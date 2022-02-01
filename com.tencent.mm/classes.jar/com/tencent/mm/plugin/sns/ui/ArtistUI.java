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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  ao gqT;
  private ListView iWK;
  private SharedPreferences sp;
  private String tWM;
  private com.tencent.mm.ui.base.p tipDialog;
  private f yxm;
  private ArtistHeader yxn;
  private n yxo;
  com.tencent.mm.plugin.sns.model.f yxp;
  com.tencent.mm.plugin.sns.model.b yxq;
  private Runnable yxr;
  private Runnable yxs;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.tWM = "";
    this.yxo = null;
    this.tipDialog = null;
    this.gqT = af.cMM();
    this.yxp = af.dHO();
    this.yxq = af.dHM();
    this.yxr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97738);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97738);
          return;
        }
        ac.d("MicroMsg.ArtistUI", "will pause ImageLoader");
        af.dHO().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.yxs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97739);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(97739);
          return;
        }
        ac.d("MicroMsg.ArtistUI", "will start ImageLoader");
        af.dHO().start();
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
    this.iWK = ((ListView)findViewById(2131304936));
    com.tencent.mm.plugin.sns.c.a.iyy.ch(false);
    this.yxm = new f(this, this.tWM, new f.b()new f.a
    {
      public final void Pj(int paramAnonymousInt)
      {
        AppMethodBeat.i(97740);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("sns_gallery_is_artist", true);
        ((Intent)localObject).putExtra("sns_gallery_position", paramAnonymousInt);
        ((Intent)localObject).putExtra("sns_gallery_artist_lan", ArtistUI.b(ArtistUI.this));
        ((Intent)localObject).putExtra("sns_gallery_showtype", 2);
        ((Intent)localObject).setClass(ArtistUI.this, ArtistBrowseUI.class);
        ArtistUI localArtistUI = ArtistUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(gk paramAnonymousgk)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgk);
          paramAnonymousgk = paramAnonymousgk.Name;
          if ((paramAnonymousgk != null) && (!paramAnonymousgk.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymousgk).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(gk paramAnonymousgk)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgk);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void dNc()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          ac.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.c.a.iyy.ch(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.iWK.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.yxp.xPQ) || (ArtistUI.this.yxq.xPQ))
          {
            ArtistUI.this.gqT.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.gqT.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.gqT.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.yxp.xPQ) && (ArtistUI.this.yxq.xPQ))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.gqT.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.gqT.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.gqT.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.yxn = new ArtistHeader(this);
    this.iWK.addHeaderView(this.yxn);
    this.iWK.setAdapter(this.yxm);
    this.yxm.notifyDataSetChanged();
    this.yxn.setVisibility(8);
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
    String str = ab.f(getSharedPreferences(ai.eUX(), 0));
    ac.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(str)));
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
      this.tWM = paramBundle;
      ac.d("MicroMsg.ArtistUI", "lan " + this.tWM);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(159, this);
      this.sp = getSharedPreferences(ai.eUX(), 0);
      initView();
      paramBundle = this.yxn;
      af.dHM().a(paramBundle);
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
    if (this.yxn != null)
    {
      ArtistHeader localArtistHeader = this.yxn;
      af.dHM().b(localArtistHeader);
    }
    af.dHO().aD(this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(159, this);
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
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aBJ() != 4))
    {
      ac.d("MicroMsg.ArtistUI", "another scene");
      AppMethodBeat.o(97752);
      return;
    }
    ac.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
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
      if (this.yxm != null) {
        this.yxm.Xb();
      }
      this.yxo = null;
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