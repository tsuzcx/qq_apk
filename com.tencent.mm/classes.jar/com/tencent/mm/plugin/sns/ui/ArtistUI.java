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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;

public class ArtistUI
  extends MMActivity
  implements i
{
  private String Ejr;
  private f KBl;
  private ArtistHeader KBm;
  private q KBn;
  g KBo;
  com.tencent.mm.plugin.sns.model.c KBp;
  private Runnable KBq;
  private Runnable KBr;
  MMHandler cyl;
  private ListView niO;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.s tipDialog;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.Ejr = "";
    this.KBn = null;
    this.tipDialog = null;
    this.cyl = aj.etE();
    this.KBo = aj.fOF();
    this.KBp = aj.fOD();
    this.KBq = new Runnable()
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
        aj.fOF().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.KBr = new Runnable()
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
        aj.fOF().start();
        ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
        AppMethodBeat.o(97739);
      }
    };
    AppMethodBeat.o(97746);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_artist_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97751);
    setMMTitle(i.j.settings_sns_bg_title);
    setActionbarColor(getResources().getColor(i.c.sns_artist_background));
    setNavigationbarColor(getResources().getColor(i.c.sns_artist_background));
    getString(i.j.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(i.j.app_loading_data), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.niO = ((ListView)findViewById(i.f.sns_artist_list));
    com.tencent.mm.plugin.sns.c.a.mIH.jdMethod_do(false);
    this.KBl = new f(this, this.Ejr, new f.b()new f.a
    {
      public final void agK(int paramAnonymousInt)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(gs paramAnonymousgs)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgs);
          paramAnonymousgs = paramAnonymousgs.CMP;
          if ((paramAnonymousgs != null) && (!paramAnonymousgs.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymousgs).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(gs paramAnonymousgs)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgs);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void fTe()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          Log.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.c.a.mIH.jdMethod_do(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.niO.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.KBo.JTH) || (ArtistUI.this.KBp.JTH))
          {
            ArtistUI.this.cyl.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.cyl.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.cyl.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.KBo.JTH) && (ArtistUI.this.KBp.JTH))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.cyl.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.cyl.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.cyl.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.KBm = new ArtistHeader(this);
    this.niO.addHeaderView(this.KBm);
    this.niO.setAdapter(this.KBl);
    this.KBl.notifyDataSetChanged();
    this.KBm.setVisibility(8);
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
          break label155;
        }
        paramBundle = str;
      }
    }
    for (;;)
    {
      this.Ejr = paramBundle;
      Log.d("MicroMsg.ArtistUI", "lan " + this.Ejr);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(159, this);
      this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      initView();
      paramBundle = this.KBm;
      aj.fOD().a(paramBundle);
      AppMethodBeat.o(97747);
      return;
      label155:
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
    if (this.KBm != null)
    {
      ArtistHeader localArtistHeader = this.KBm;
      aj.fOD().b(localArtistHeader);
    }
    aj.fOF().aO(this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(159, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(97752);
    if ((!(paramq instanceof com.tencent.mm.an.s)) || (((com.tencent.mm.an.s)paramq).big() != 4))
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
      if (this.KBl != null) {
        this.KBl.atr();
      }
      this.KBn = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI
 * JD-Core Version:    0.7.0.1
 */