package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.s;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements i
{
  private f Eoc;
  private ArtistHeader Eod;
  private com.tencent.mm.ak.q Eoe;
  com.tencent.mm.plugin.sns.model.g Eof;
  c Eog;
  private Runnable Eoh;
  private Runnable Eoi;
  MMHandler czp;
  private ListView krb;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.q tipDialog;
  private String yFy;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.yFy = "";
    this.Eoe = null;
    this.tipDialog = null;
    this.czp = aj.dRd();
    this.Eof = aj.faL();
    this.Eog = aj.faJ();
    this.Eoh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97738);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97738);
          return;
        }
        Log.d("MicroMsg.ArtistUI", "will pause ImageLoader");
        aj.faL().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.Eoi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97739);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97739);
          return;
        }
        Log.d("MicroMsg.ArtistUI", "will start ImageLoader");
        aj.faL().start();
        ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
        AppMethodBeat.o(97739);
      }
    };
    AppMethodBeat.o(97746);
  }
  
  public int getLayoutId()
  {
    return 2131496417;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97751);
    setMMTitle(2131765601);
    setActionbarColor(getResources().getColor(2131101120));
    setNavigationbarColor(getResources().getColor(2131101120));
    getString(2131755998);
    this.tipDialog = h.a(this, getString(2131755887), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.krb = ((ListView)findViewById(2131308075));
    com.tencent.mm.plugin.sns.c.a.jRu.cR(false);
    this.Eoc = new f(this, this.yFy, new f.b()new f.a
    {
      public final void Zt(int paramAnonymousInt)
      {
        AppMethodBeat.i(97740);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("sns_gallery_is_artist", true);
        ((Intent)localObject).putExtra("sns_gallery_position", paramAnonymousInt);
        ((Intent)localObject).putExtra("sns_gallery_artist_lan", ArtistUI.b(ArtistUI.this));
        ((Intent)localObject).putExtra("sns_gallery_showtype", 2);
        ((Intent)localObject).putExtra("key_from_scene", 6);
        ((Intent)localObject).setClass(ArtistUI.this, ArtistBrowseUI.class);
        ArtistUI localArtistUI = ArtistUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(he paramAnonymoushe)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymoushe);
          paramAnonymoushe = paramAnonymoushe.Name;
          if ((paramAnonymoushe != null) && (!paramAnonymoushe.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymoushe).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(he paramAnonymoushe)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymoushe);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void ffj()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          Log.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.c.a.jRu.cR(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.krb.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.Eof.DGJ) || (ArtistUI.this.Eog.DGJ))
          {
            ArtistUI.this.czp.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.czp.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.czp.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.Eof.DGJ) && (ArtistUI.this.Eog.DGJ))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.czp.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.czp.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.czp.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.Eod = new ArtistHeader(this);
    this.krb.addHeaderView(this.Eod);
    this.krb.setAdapter(this.Eoc);
    this.Eoc.notifyDataSetChanged();
    this.Eod.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97745);
        ArtistUI.this.finish();
        AppMethodBeat.o(97745);
        return true;
      }
    });
    AppMethodBeat.o(97751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97747);
    super.onCreate(paramBundle);
    String str = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    Log.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(str)));
    paramBundle = str;
    if (!str.equals("zh_CN"))
    {
      paramBundle = str;
      if (!str.equals("en"))
      {
        if (!str.equals("zh_TW")) {
          break label153;
        }
        paramBundle = str;
      }
    }
    for (;;)
    {
      this.yFy = paramBundle;
      Log.d("MicroMsg.ArtistUI", "lan " + this.yFy);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(159, this);
      this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      initView();
      paramBundle = this.Eod;
      aj.faJ().a(paramBundle);
      AppMethodBeat.o(97747);
      return;
      label153:
      if (str.equals("zh_HK")) {
        paramBundle = "zh_TW";
      } else {
        paramBundle = "en";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(97748);
    super.onDestroy();
    if (this.tipDialog != null) {
      this.tipDialog = null;
    }
    if (this.Eod != null)
    {
      ArtistHeader localArtistHeader = this.Eod;
      aj.faJ().b(localArtistHeader);
    }
    aj.faL().aI(this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(159, this);
    AppMethodBeat.o(97748);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97750);
    super.onPause();
    AppMethodBeat.o(97750);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97749);
    super.onResume();
    AppMethodBeat.o(97749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(97752);
    if ((!(paramq instanceof s)) || (((s)paramq).aYR() != 4))
    {
      Log.d("MicroMsg.ArtistUI", "another scene");
      AppMethodBeat.o(97752);
      return;
    }
    Log.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType() + " @" + hashCode());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramq.getType() == 159) && (this.tipDialog != null)) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(97752);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97752);
      return;
      if (this.Eoc != null) {
        this.Eoc.anp();
      }
      this.Eoe = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI
 * JD-Core Version:    0.7.0.1
 */