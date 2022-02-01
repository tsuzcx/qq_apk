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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ListView iwH;
  ap oFl;
  private String sOz;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.p tipDialog;
  private Runnable xkA;
  private f xku;
  private ArtistHeader xkv;
  private n xkw;
  com.tencent.mm.plugin.sns.model.f xkx;
  com.tencent.mm.plugin.sns.model.b xky;
  private Runnable xkz;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.sOz = "";
    this.xkw = null;
    this.tipDialog = null;
    this.oFl = af.czA();
    this.xkx = af.dtr();
    this.xky = af.dtp();
    this.xkz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97738);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97738);
          return;
        }
        ad.d("MicroMsg.ArtistUI", "will pause ImageLoader");
        af.dtr().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.xkA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97739);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97739);
          return;
        }
        ad.d("MicroMsg.ArtistUI", "will start ImageLoader");
        af.dtr().start();
        ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
        AppMethodBeat.o(97739);
      }
    };
    AppMethodBeat.o(97746);
  }
  
  public int getLayoutId()
  {
    return 2131495529;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97751);
    setMMTitle(2131763419);
    setActionbarColor(getResources().getColor(2131100903));
    setNavigationbarColor(getResources().getColor(2131100903));
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131755805), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.iwH = ((ListView)findViewById(2131304936));
    com.tencent.mm.plugin.sns.d.a.hYu.cf(false);
    this.xku = new f(this, this.sOz, new f.b()new f.a
    {
      public final void Ng(int paramAnonymousInt)
      {
        AppMethodBeat.i(97740);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("sns_gallery_is_artist", true);
        ((Intent)localObject).putExtra("sns_gallery_position", paramAnonymousInt);
        ((Intent)localObject).putExtra("sns_gallery_artist_lan", ArtistUI.b(ArtistUI.this));
        ((Intent)localObject).putExtra("sns_gallery_showtype", 2);
        ((Intent)localObject).setClass(ArtistUI.this, ArtistBrowseUI.class);
        ArtistUI localArtistUI = ArtistUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(gg paramAnonymousgg)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgg);
          paramAnonymousgg = paramAnonymousgg.Name;
          if ((paramAnonymousgg != null) && (!paramAnonymousgg.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymousgg).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(gg paramAnonymousgg)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgg);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void dyF()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          ad.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.d.a.hYu.cf(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.iwH.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.xkx.wDv) || (ArtistUI.this.xky.wDv))
          {
            ArtistUI.this.oFl.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.oFl.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.oFl.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.xkx.wDv) && (ArtistUI.this.xky.wDv))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.oFl.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.oFl.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.oFl.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.xkv = new ArtistHeader(this);
    this.iwH.addHeaderView(this.xkv);
    this.iwH.setAdapter(this.xku);
    this.xku.notifyDataSetChanged();
    this.xkv.setVisibility(8);
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
    String str = ac.f(getSharedPreferences(aj.eFD(), 0));
    ad.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(str)));
    paramBundle = str;
    if (!str.equals("zh_CN"))
    {
      paramBundle = str;
      if (!str.equals("en"))
      {
        if (!str.equals("zh_TW")) {
          break label152;
        }
        paramBundle = str;
      }
    }
    for (;;)
    {
      this.sOz = paramBundle;
      ad.d("MicroMsg.ArtistUI", "lan " + this.sOz);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(159, this);
      this.sp = getSharedPreferences(aj.eFD(), 0);
      initView();
      paramBundle = this.xkv;
      af.dtp().a(paramBundle);
      AppMethodBeat.o(97747);
      return;
      label152:
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
    if (this.xkv != null)
    {
      ArtistHeader localArtistHeader = this.xkv;
      af.dtp().b(localArtistHeader);
    }
    af.dtr().az(this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(159, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(97752);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).auQ() != 4))
    {
      ad.d("MicroMsg.ArtistUI", "another scene");
      AppMethodBeat.o(97752);
      return;
    }
    ad.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramn.getType() == 159) && (this.tipDialog != null)) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(97752);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97752);
      return;
      if (this.xku != null) {
        this.xku.Wd();
      }
      this.xkw = null;
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