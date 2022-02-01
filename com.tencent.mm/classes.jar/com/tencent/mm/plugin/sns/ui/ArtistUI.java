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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  ap gKD;
  private ListView jpT;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.p tipDialog;
  private String uZv;
  private n zOA;
  com.tencent.mm.plugin.sns.model.f zOB;
  com.tencent.mm.plugin.sns.model.b zOC;
  private Runnable zOD;
  private Runnable zOE;
  private f zOy;
  private ArtistHeader zOz;
  
  public ArtistUI()
  {
    AppMethodBeat.i(97746);
    this.uZv = "";
    this.zOA = null;
    this.tipDialog = null;
    this.gKD = ag.cVf();
    this.zOB = ag.dUb();
    this.zOC = ag.dTZ();
    this.zOD = new Runnable()
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
        ag.dUb().pause();
        AppMethodBeat.o(97738);
      }
    };
    this.zOE = new Runnable()
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
        ag.dUb().start();
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
    this.jpT = ((ListView)findViewById(2131304936));
    com.tencent.mm.plugin.sns.c.a.iRH.ci(false);
    this.zOy = new f(this, this.uZv, new f.b()new f.a
    {
      public final void QR(int paramAnonymousInt)
      {
        AppMethodBeat.i(97740);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("sns_gallery_is_artist", true);
        ((Intent)localObject).putExtra("sns_gallery_position", paramAnonymousInt);
        ((Intent)localObject).putExtra("sns_gallery_artist_lan", ArtistUI.b(ArtistUI.this));
        ((Intent)localObject).putExtra("sns_gallery_showtype", 2);
        ((Intent)localObject).setClass(ArtistUI.this, ArtistBrowseUI.class);
        ArtistUI localArtistUI = ArtistUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localArtistUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localArtistUI, "com/tencent/mm/plugin/sns/ui/ArtistUI$4", "onPhotoClick", "(Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97740);
      }
    }, new f.a()
    {
      public final void a(gr paramAnonymousgr)
      {
        AppMethodBeat.i(97741);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgr);
          paramAnonymousgr = paramAnonymousgr.Name;
          if ((paramAnonymousgr != null) && (!paramAnonymousgr.equals(""))) {
            ArtistUI.d(ArtistUI.this).edit().putString("artist_name", paramAnonymousgr).commit();
          }
          if (ArtistUI.a(ArtistUI.this) != null) {
            ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
          }
        }
        ArtistUI.e(ArtistUI.this).dismiss();
        AppMethodBeat.o(97741);
      }
      
      public final void b(gr paramAnonymousgr)
      {
        AppMethodBeat.i(97742);
        if (ArtistUI.c(ArtistUI.this) != null)
        {
          ArtistUI.c(ArtistUI.this).setVisibility(0);
          ArtistUI.c(ArtistUI.this).setUserName(paramAnonymousgr);
        }
        AppMethodBeat.o(97742);
      }
      
      public final void dZr()
      {
        AppMethodBeat.i(97743);
        if ((ArtistUI.f(ArtistUI.this) == null) && (ArtistUI.e(ArtistUI.this) != null))
        {
          ad.d("MicroMsg.ArtistUI", "onNothingBgGet");
          com.tencent.mm.plugin.sns.c.a.iRH.ci(true);
        }
        AppMethodBeat.o(97743);
      }
    });
    this.jpT.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(97744);
        if (paramAnonymousInt == 2)
        {
          if ((ArtistUI.this.zOB.zfK) || (ArtistUI.this.zOC.zfK))
          {
            ArtistUI.this.gKD.removeCallbacks(ArtistUI.g(ArtistUI.this));
            ArtistUI.this.gKD.removeCallbacks(ArtistUI.h(ArtistUI.this));
            ArtistUI.this.gKD.postDelayed(ArtistUI.g(ArtistUI.this), 0L);
            AppMethodBeat.o(97744);
          }
        }
        else
        {
          if ((ArtistUI.this.zOB.zfK) && (ArtistUI.this.zOC.zfK))
          {
            AppMethodBeat.o(97744);
            return;
          }
          ArtistUI.this.gKD.removeCallbacks(ArtistUI.g(ArtistUI.this));
          ArtistUI.this.gKD.removeCallbacks(ArtistUI.h(ArtistUI.this));
          ArtistUI.this.gKD.postDelayed(ArtistUI.h(ArtistUI.this), 0L);
        }
        AppMethodBeat.o(97744);
      }
    });
    this.zOz = new ArtistHeader(this);
    this.jpT.addHeaderView(this.zOz);
    this.jpT.setAdapter(this.zOy);
    this.zOy.notifyDataSetChanged();
    this.zOz.setVisibility(8);
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
    String str = ac.f(getSharedPreferences(aj.fkC(), 0));
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
      this.uZv = paramBundle;
      ad.d("MicroMsg.ArtistUI", "lan " + this.uZv);
      g.ajD();
      g.ajB().gAO.a(159, this);
      this.sp = getSharedPreferences(aj.fkC(), 0);
      initView();
      paramBundle = this.zOz;
      ag.dTZ().a(paramBundle);
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
    if (this.zOz != null)
    {
      ArtistHeader localArtistHeader = this.zOz;
      ag.dTZ().b(localArtistHeader);
    }
    ag.dUb().aD(this);
    g.ajD();
    g.ajB().gAO.b(159, this);
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
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).aEM() != 4))
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
      if (this.zOy != null) {
        this.zOy.Zu();
      }
      this.zOA = null;
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