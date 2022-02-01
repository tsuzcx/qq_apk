package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.r;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String Kca;
  private f RaS;
  private ArtistHeader RaT;
  private p RaU;
  g RaV;
  com.tencent.mm.plugin.sns.model.c RaW;
  private Runnable RaX;
  private Runnable RaY;
  MMHandler eqE;
  private ListView qgc;
  private SharedPreferences sp;
  private w tipDialog;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.Kca = "";
    this.RaU = null;
    this.tipDialog = null;
    this.eqE = al.fAG();
    this.RaV = al.hgy();
    this.RaW = al.hgw();
    this.RaX = new Runnable()
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
        al.hgy().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.RaY = new Runnable()
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
        al.hgy().start();
        ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
        AppMethodBeat.o(97739);
      }
    };
    AppMethodBeat.o(97746);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_artist_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97751);
    setMMTitle(b.j.settings_sns_bg_title);
    setActionbarColor(getResources().getColor(b.c.sns_artist_background));
    setNavigationbarColor(getResources().getColor(b.c.sns_artist_background));
    getString(b.j.app_tip);
    this.tipDialog = k.a(this, getString(b.j.app_loading_data), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.qgc = ((ListView)findViewById(b.f.sns_artist_list));
    com.tencent.mm.plugin.sns.d.a.pFo.ea(false);
    this.RaS = new f(this, this.Kca, new f.b()new f.a
    {
      public final void alD(int paramAnonymousInt)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(hl paramAnonymoushl)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymoushl);
          paramAnonymoushl = paramAnonymoushl.IGU;
          if ((paramAnonymoushl != null) && (!paramAnonymoushl.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymoushl).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(hl paramAnonymoushl)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymoushl);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void hlu()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          Log.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.d.a.pFo.ea(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.qgc.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.RaV.QqK) || (ArtistUI.this.RaW.QqK))
          {
            ArtistUI.this.eqE.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.eqE.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.eqE.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.RaV.QqK) && (ArtistUI.this.RaW.QqK))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.eqE.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.eqE.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.eqE.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.RaT = new ArtistHeader(this);
    this.qgc.addHeaderView(this.RaT);
    this.qgc.setAdapter(this.RaS);
    this.RaS.notifyDataSetChanged();
    this.RaT.setVisibility(8);
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
      this.Kca = paramBundle;
      Log.d("MicroMsg.ArtistUI", "lan " + this.Kca);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(159, this);
      this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      initView();
      paramBundle = this.RaT;
      al.hgw().a(paramBundle);
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
    if (this.RaT != null)
    {
      ArtistHeader localArtistHeader = this.RaT;
      al.hgw().b(localArtistHeader);
    }
    al.hgy().bq(this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(159, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(97752);
    if ((!(paramp instanceof r)) || (((r)paramp).bFO() != 4))
    {
      Log.d("MicroMsg.ArtistUI", "another scene");
      AppMethodBeat.o(97752);
      return;
    }
    Log.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType() + " @" + hashCode());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramp.getType() == 159) && (this.tipDialog != null)) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(97752);
      return;
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97752);
      return;
      if (this.RaS != null) {
        this.RaS.aNy();
      }
      this.RaU = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI
 * JD-Core Version:    0.7.0.1
 */