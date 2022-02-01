package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.app.v;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.booter.x;
import com.tencent.mm.booter.x.1;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI
  implements com.tencent.mm.plugin.appbrand.widget.header.a, LauncherUI.b, LauncherUI.c, LauncherUI.d
{
  public static Boolean FKR = Boolean.FALSE;
  public static Boolean FKS = Boolean.FALSE;
  private static boolean FLh = true;
  static final int FLj = 2131302248;
  static final int FLk = 2131302237;
  private TextView FGL;
  boolean FGS;
  View FHi;
  private final long FKG;
  private final long FKH;
  public boolean FKI;
  boolean FKJ;
  public boolean FKK;
  private TextView FKL;
  private boolean FKM;
  private String FKN;
  private String FKO;
  private String FKP;
  ad FKQ;
  private final long FKT;
  private final long FKU;
  private boolean FKV;
  private int FKW;
  private int FKX;
  private int FKY;
  a FKZ;
  MMFragmentActivity FKl;
  p FLA;
  private float FLB;
  private boolean FLC;
  LauncherUI.a FLa;
  h FLb;
  MainTabUI FLc;
  int FLd;
  int FLe;
  private boolean FLf;
  boolean FLg;
  View.OnLayoutChangeListener FLi;
  b FLl;
  View FLm;
  ImageView FLn;
  private View FLo;
  ImageView FLp;
  View FLq;
  MenuItem FLr;
  MenuItem FLs;
  private MenuItem FLt;
  MenuItem FLu;
  Menu FLv;
  private boolean FLw;
  Runnable FLx;
  private int FLy;
  private LinkedList<Runnable> FLz;
  private int clickCount;
  View contentView;
  private String dta;
  private boolean imk;
  LayoutInflater imq;
  private boolean lTC;
  ActionBar mActionBar;
  MessageQueue.IdleHandler nbI;
  private long rMp;
  View uAo;
  private final HashMap<String, Object> values;
  com.tencent.mm.sdk.b.c wcH;
  private final long xFP;
  private long xFQ;
  private View xUN;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.FKG = 604800000L;
    this.FKH = 86400000L;
    this.imk = true;
    this.FKI = false;
    this.dta = null;
    this.FKK = false;
    this.FGS = false;
    this.FKM = false;
    this.FKT = 432000000L;
    this.FKU = 604800000L;
    this.FKV = true;
    this.FKW = 0;
    this.FKX = 0;
    this.FKY = 0;
    this.FKZ = a.FLI;
    this.FLc = new MainTabUI();
    this.FLd = 0;
    this.FLe = 0;
    this.FLf = false;
    this.FLg = true;
    this.FLi = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.lTC = com.tencent.mm.sdk.platformtools.ac.eFq();
    this.FLw = true;
    this.clickCount = 0;
    this.rMp = 0L;
    this.values = new HashMap();
    this.wcH = new HomeUI.14(this);
    this.nbI = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(204890);
        az.arV();
        if (bt.l((Integer)com.tencent.mm.model.c.afk().get(15, null)) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
          AppMethodBeat.o(204890);
          return false;
        }
        Object localObject = com.tencent.mm.model.ay.gNa.ao("login_user_name", "");
        if ((az.arW()) || (!((String)localObject).equals(""))) {
          az.aeS().a(new bn(new HomeUI.16.1(this), "launch normal"), 0);
        }
        com.tencent.mm.sdk.g.b.c(new x.1(new x(HomeUI.b(HomeUI.this))), "StartupReport_report");
        com.tencent.mm.booter.o.TQ();
        HomeUI.eQz();
        f.dkM();
        localObject = com.tencent.mm.aw.n.ayt().hiA;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
        ((com.tencent.mm.aw.n.c)localObject).ayx();
        Looper.myQueue().removeIdleHandler(HomeUI.this.nbI);
        AppMethodBeat.o(204890);
        return false;
      }
    };
    this.FLx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204891);
        if ((com.tencent.mm.r.a.cd(HomeUI.b(HomeUI.this))) && (!com.tencent.mm.r.a.cc(HomeUI.b(HomeUI.this))))
        {
          AppMethodBeat.o(204891);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
        localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        localIntent.putExtra("key_config_black_interval", true);
        localIntent.setFlags(65536);
        com.tencent.mm.plugin.report.service.h.vKh.f(11409, new Object[0]);
        com.tencent.mm.bs.d.b(HomeUI.b(HomeUI.this), "scanner", ".ui.BaseScanUI", localIntent);
        AppMethodBeat.o(204891);
      }
    };
    this.FLy = 0;
    this.xFP = 300L;
    this.xFQ = SystemClock.elapsedRealtime();
    this.FLz = new LinkedList();
    this.FLA = new HomeUI.38(this);
    this.FLB = 0.0F;
    this.FLC = false;
    AppMethodBeat.o(33232);
  }
  
  private void Xf(int paramInt)
  {
    AppMethodBeat.i(33248);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33248);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.XM())) {
      i = paramInt;
    }
    for (;;)
    {
      if (Math.abs(this.FLy - i) >= 50000) {}
      try
      {
        this.FKl.getWindow().setStatusBarColor(i);
        this.FLy = i;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = am.o(this.FKl.getResources().getColor(2131100954), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(i) });
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.xUN != null)
    {
      this.xUN.clearAnimation();
      this.xUN.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        az.arV();
        com.tencent.mm.model.c.afk().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(232L, 0L, 1L, false);
        FKR = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.xUN = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      az.arV();
      com.tencent.mm.model.c.afk().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(232L, 5L, 1L, false);
      FKS = Boolean.FALSE;
    }
  }
  
  private void ePb()
  {
    AppMethodBeat.i(33253);
    if (this.FKl != null) {}
    try
    {
      this.FKl.moveTaskToBack(true);
      if (az.afw()) {
        az.afE().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163262);
            if (az.afw())
            {
              az.arV();
              ab localab = com.tencent.mm.model.c.afk();
              if (localab != null) {
                localab.eKy();
              }
            }
            AppMethodBeat.o(163262);
          }
        }, 500L);
      }
      v.KT().start();
      AppMethodBeat.o(33253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean eQf()
  {
    return (this.FKW == 2) && (this.FKX == 2);
  }
  
  private static boolean eQr()
  {
    AppMethodBeat.i(33260);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(u.aqG()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean eQt()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().dGh();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean eQu()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fxw, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.uAo != null) {
      this.uAo.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.FKV)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.FLc.Zo;
    Object localObject2 = getString(2131755822);
    Object localObject1;
    if (i == 0)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.protocal.d.CpN)
      {
        if (this.lTC) {
          localObject1 = (String)localObject2 + getString(2131755263);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (this.FLc.FPE.eRr() > 0)
        {
          localObject2 = localObject1;
          if (!this.lTC) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + "(" + this.FLc.FPE.eRr() + ")";
        }
        localObject1 = new wg();
        ((wg)localObject1).dBJ.dBK = 1;
        ((wg)localObject1).dBJ.title = ((String)localObject2);
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label209:
      if (i == 3)
      {
        Xf(this.FKl.getResources().getColor(2131101053));
        if (eQr())
        {
          vt(true);
          label242:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FKl.getResources().getColor(2131101053)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.uAo != null) {
            this.uAo.setBackgroundColor(this.FKl.getResources().getColor(2131101053));
          }
          this.FLw = false;
          if ((this.FKW != 3) || (this.FKX != 3)) {
            break label636;
          }
        }
        label636:
        for (i = 1;; i = 0)
        {
          if ((i != 0) && (this.FLu != null) && (!this.FLu.isVisible())) {
            this.FLu.setVisible(true);
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.fR();
          this.FKL = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          if (this.FKL != null)
          {
            this.FKL.setText((CharSequence)localObject1);
            float f = com.tencent.mm.cd.a.ap(aj.getContext(), 2131165184) * com.tencent.mm.cd.a.hQ(aj.getContext());
            if (this.FKL.getTextSize() != f) {
              this.FKL.setTextSize(0, f);
            }
            i = this.FKl.getResources().getColor(2131099886);
            if ((this.FGS) && (this.FKL.getCurrentTextColor() != i)) {
              this.FKL.setTextColor(i);
            }
            ai.a(this.FKL.getPaint(), 0.8F);
          }
          AppMethodBeat.o(33233);
          return;
          localObject1 = (String)localObject2 + " " + getString(2131755263);
          break;
          if (i == 1)
          {
            localObject1 = getString(2131761038);
            break label209;
          }
          if (i == 2)
          {
            localObject1 = getString(2131761036);
            break label209;
          }
          if (i != 3) {
            break label873;
          }
          localObject1 = getString(2131761071);
          break label209;
          vt(false);
          break label242;
        }
      }
      Xf(this.FKl.getResources().getColor(2131100705));
      vt(this.FGS);
      localObject2 = this.mActionBar.getCustomView().getBackground();
      if ((localObject2 instanceof ColorDrawable)) {
        if (((ColorDrawable)localObject2).getColor() != this.FKl.getResources().getColor(2131100705)) {
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FKl.getResources().getColor(2131100705)));
        }
      }
      for (;;)
      {
        if (this.mActionBar.getCustomView().getVisibility() != 0) {
          this.mActionBar.getCustomView().setVisibility(0);
        }
        this.FLw = true;
        if ((eQf()) && (this.FLr != null) && (!this.FLr.isVisible())) {
          this.FLr.setVisible(true);
        }
        if ((!eQf()) || (this.FLs == null) || (this.FLs.isVisible())) {
          break;
        }
        this.FLs.setVisible(true);
        break;
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FKl.getResources().getColor(2131100705)));
      }
      label873:
      localObject1 = localObject2;
    }
  }
  
  private static void v(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33263);
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setClickable(true);
        AppMethodBeat.o(33263);
        return;
      }
      paramView.setClickable(false);
      paramView.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(33263);
  }
  
  private void vq(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.xUN != null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.xUN = View.inflate(aj.getContext(), 2131495019, null);
    Object localObject = (TextView)this.xUN.findViewById(2131302803);
    if (paramBoolean) {
      ((TextView)localObject).setText(aj.getContext().getString(2131755139));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.xUN.setBackgroundResource(2131233522);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.xUN, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(aj.getContext(), 2130772132);
        this.xUN.startAnimation((Animation)localObject);
        this.xUN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(163246);
            HomeUI.l(HomeUI.this).hM();
            if (paramBoolean)
            {
              paramAnonymousView = HomeUI.this;
              Boolean localBoolean = Boolean.TRUE;
              HomeUI.a(paramAnonymousView, localBoolean, localBoolean);
              AppMethodBeat.o(163246);
              return;
            }
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(163246);
          }
        });
      }
      AppMethodBeat.o(33235);
      return;
      ((TextView)localObject).setText(aj.getContext().getString(2131755136));
    }
  }
  
  private void vt(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.FKl.getWindow().getDecorView();
      j = localView.getSystemUiVisibility();
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int i = j & 0xFFFFDFFF;; i = j | 0x2000)
    {
      if (j != i) {
        localView.setSystemUiVisibility(i);
      }
      AppMethodBeat.o(33249);
      return;
    }
  }
  
  public final void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33257);
    MMFragment localMMFragment = getMainTabUI().eRg();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.FKl.getResources().getColor(2131101053));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.FKl.getResources().getColor(2131100705));
      }
      while (paramInt2 > 10)
      {
        v(this.FHi, false);
        v(this.FLm, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      v(this.FHi, true);
      v(this.FLm, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.FKl.getWindow().getDecorView().getBottom();
    this.FKl.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aF(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.FLz.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void b(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.FKL != null)) {
      this.FKL.setTextColor(paramInt1);
    }
    if (this.FLp != null)
    {
      if (this.FLC) {
        this.FLp.setAlpha(paramFloat);
      }
      this.FLp.setImageDrawable(am.i(this.FKl, 2131689494, paramInt2));
    }
    if (this.FLn != null)
    {
      if (this.FLC) {
        this.FLn.setAlpha(paramFloat);
      }
      this.FLn.setImageDrawable(am.i(this.FKl, 2131690510, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33252);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.Wl();
    com.tencent.mm.compatible.b.g.Wl();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.FKQ != null) && (this.FKQ.isShowing()))
    {
      this.FKQ.dismiss();
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      eQh();
      AppMethodBeat.o(33252);
      return true;
    }
    Object localObject1 = this.FLc.eRg();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((az.afw()) && (com.tencent.mm.kernel.g.afz().gcn) && (com.tencent.mm.sdk.platformtools.ay.isWap(this.FKl)))
      {
        Object localObject2 = this.FKl;
        paramKeyEvent = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33196);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(33196);
          }
        };
        if (!az.afw()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(33252);
          return true;
          az.arV();
          i = ((Integer)com.tencent.mm.model.c.afk().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!an.aFx("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2131495013, null);
            ((TextView)((View)localObject1).findViewById(2131302708)).setText(2131761551);
            localObject2 = new d.a((Context)localObject2);
            ((d.a)localObject2).aau(2131755906);
            ((d.a)localObject2).gs((View)localObject1);
            ((d.a)localObject2).aaB(2131755835).b(new MMAppMgr.1(i));
            ((d.a)localObject2).wX(false);
            ((d.a)localObject2).aaC(2131761545).c(new MMAppMgr.7());
            ((d.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((d.a)localObject2).fft().show();
            i = 1;
          }
        }
      }
      final int i = com.tencent.mm.sdk.platformtools.ay.getBackgroundLimitType(this.FKl);
      if ((az.afw()) && (com.tencent.mm.kernel.g.afz().gcn) && (com.tencent.mm.sdk.platformtools.ay.isLimited(i)))
      {
        az.arV();
        if ((bt.k((Boolean)com.tencent.mm.model.c.afk().get(16385, null))) && (MMAppMgr.a(this.FKl, i, new DialogInterface.OnClickListener()new HomeUI.21
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(163261);
            try
            {
              com.tencent.mm.sdk.platformtools.ay.startSettingItent(HomeUI.b(HomeUI.this), i);
              AppMethodBeat.o(163261);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramAnonymousDialogInterface, "", new Object[0]);
              AppMethodBeat.o(163261);
            }
          }
        }, new HomeUI.21(this))))
        {
          AppMethodBeat.o(33252);
          return true;
        }
      }
      ePb();
    }
    AppMethodBeat.o(33252);
    return false;
  }
  
  final void eQg()
  {
    AppMethodBeat.i(33234);
    if (!az.afw())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    az.arV();
    Boolean localBoolean = Boolean.valueOf(bt.l((Boolean)com.tencent.mm.model.c.afk().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.l.GVr.booleanValue()))
    {
      FKR = Boolean.TRUE;
      vq(true);
    }
    long l1 = System.currentTimeMillis();
    az.arV();
    long l2 = bt.a((Long)com.tencent.mm.model.c.afk().get(340240, null), 0L);
    az.arV();
    boolean bool1 = bt.l((Boolean)com.tencent.mm.model.c.afk().get(340230, null));
    az.arV();
    boolean bool2 = bt.l((Boolean)com.tencent.mm.model.c.afk().get(340228, null));
    az.arV();
    boolean bool3 = bt.l((Boolean)com.tencent.mm.model.c.afk().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      FKS = Boolean.TRUE;
      vq(false);
    }
    AppMethodBeat.o(33234);
  }
  
  final void eQh()
  {
    AppMethodBeat.i(33237);
    if ((this.FKQ == null) || (!az.afw()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.FKQ.isShowing())
    {
      this.FKQ.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.FKQ.hM();
    AppMethodBeat.o(33237);
  }
  
  final void eQi()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.FLu != null)
    {
      this.FLu.setShowAsAction(2);
      if (this.FLw) {
        break label224;
      }
      if (!(this.FLc.eRg() instanceof MoreTabUI)) {
        break label219;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.FLc.eRg();
      if ((localMoreTabUI.FQg != null) && (localMoreTabUI.FQg.isVisible))
      {
        i = 1;
        if (i == 0) {
          break label219;
        }
        i = 1;
        label79:
        if (i == 0) {
          break label224;
        }
        this.FLu.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.FLs != null)
      {
        if (!this.FLw) {
          break label249;
        }
        this.FLs.setShowAsAction(2);
        this.FLs.setVisible(true);
      }
      label129:
      if (this.FLr != null)
      {
        if (!this.FLw) {
          break label274;
        }
        this.FLr.setShowAsAction(2);
        this.FLr.setVisible(true);
      }
    }
    for (;;)
    {
      if (this.FLt != null)
      {
        if (!this.FLw)
        {
          this.FLt.setShowAsAction(2);
          this.FLt.setVisible(true);
          this.FGL.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label219:
          i = 0;
          break label79;
          label224:
          this.FLu.setVisible(false);
          this.FLu.setEnabled(false);
          break label94;
          label249:
          this.FLs.setVisible(false);
          this.FLs.setEnabled(false);
          break label129;
          label274:
          this.FLr.setVisible(false);
          this.FLr.setEnabled(false);
          continue;
        }
        this.FLt.setVisible(false);
        this.FLt.setEnabled(false);
        this.FGL.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void eQj()
  {
    AppMethodBeat.i(33240);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSIndexReady())
    {
      Toast.makeText(aj.getContext(), 2131762954, 0).show();
      AppMethodBeat.o(33240);
      return;
    }
    int i = this.FLc.Zo;
    if (i == 0) {
      getMainTabUI().eRg();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!ai.Eq()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.FKl, new Pair[0]).toBundle();
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.FKl, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void eQk()
  {
    AppMethodBeat.i(33242);
    if ((eQt()) && (eQu())) {
      this.FLg = false;
    }
    if (eQt()) {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxw, Boolean.FALSE);
    }
    if (this.FLq != null)
    {
      this.FLq.findViewById(2131305884).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.tP(0L);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.afC();
      int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuM, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.FKl, "", this.FKl.getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    MMFragmentActivity localMMFragmentActivity = this.FKl;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
    ((com.tencent.mm.plugin.story.api.e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.dJB(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void eQl()
  {
    AppMethodBeat.i(33243);
    if ((u.aro().booleanValue()) && ((FKR.booleanValue()) || (FKS.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    this.FLc.eQl();
    AppMethodBeat.o(33243);
  }
  
  public final void eQm()
  {
    AppMethodBeat.i(33244);
    az.afE().eFP();
    this.FLc.eRk();
    aq.f(this.FLx);
    AppMethodBeat.o(33244);
  }
  
  public final boolean eQn()
  {
    return this.FKZ == a.FLJ;
  }
  
  public final void eQo()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(33255);
    this.FLc.eQp();
    AppMethodBeat.o(33255);
  }
  
  public final void eQq()
  {
    AppMethodBeat.i(33259);
    this.FLc.Xp(170);
    AppMethodBeat.o(33259);
  }
  
  final void eQs()
  {
    AppMethodBeat.i(33261);
    if ((this.FLu != null) && (this.FLu.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.FLu.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.FKl.getResources().getDrawable(2131690361));
      if (eQr())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.FLg) {
          break label169;
        }
        if ((!eQt()) || (!eQu())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.FLg = bool;
        this.FLu.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.FKl.getResources().getColor(2131099664), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.FLu.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.FLc;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.FKl.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.FLa.eQN())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.FGS = ai.Eq();
    this.mActionBar.setLogo(new ColorDrawable(this.FKl.getResources().getColor(17170445)));
    this.mActionBar.fM();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.fL();
    this.mActionBar.fN();
    this.mActionBar.setCustomView(y.js(this.FKl).inflate(2131492927, new LinearLayout(this.FKl), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131296417);
    if (localImageView != null) {
      localImageView.getDrawable().setColorFilter(this.FKl.getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    this.mActionBar.setBackgroundDrawable(am.i(this.FKl, 2131100196, this.FKl.getResources().getColor(2131099664)));
    updateTitle();
    this.mActionBar.getCustomView().findViewById(2131296414).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204892);
        if (SystemClock.elapsedRealtime() - HomeUI.z(HomeUI.this) < 300L)
        {
          paramAnonymousView = HomeUI.A(HomeUI.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.b(HomeUI.this, SystemClock.elapsedRealtime());
        AppMethodBeat.o(204892);
      }
    });
    AppMethodBeat.o(33247);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.FLz.contains(paramRunnable)) {
      this.FLz.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  final void vr(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.FKQ == null) || (this.FLm == null) || (this.FLl == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!az.afw())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.FKQ.FRI.vG(paramBoolean);
    Object localObject = this.FLl;
    if (!com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).FLD.FKQ.FRI.eLv(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      if (!((b)localObject).FLD.FKQ.FRI.eLv()) {
        break label196;
      }
      ((b)localObject).FLD.FLo.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, k.uev, ((b)localObject).FLD.FKQ.FRI.eLv());
      localObject = new wg();
      ((wg)localObject).dBJ.dBK = 2;
      ((wg)localObject).dBJ.dBL = this.FKQ.FRI.eLv();
      ((wg)localObject).dBJ.dBM = false;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(33238);
      return;
      label196:
      ((b)localObject).FLD.FLo.setVisibility(8);
    }
  }
  
  public final void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.FKl.supportInvalidateOptionsMenu();
    if (u.aro().booleanValue()) {
      eQg();
    }
    this.FLc.eRj();
    AppMethodBeat.o(33246);
  }
  
  public final void vu(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.FLu != null) && (this.FLu.getActionView() != null) && (this.FKl != null))
    {
      if (this.FKl.getResources().getConfiguration().orientation == 2)
      {
        this.FLu.setVisible(false);
        this.FLu.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.FLu.setVisible(true);
      this.FLu.setEnabled(true);
      ImageView localImageView = (ImageView)this.FLu.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.FKl.getResources().getDrawable(2131690361));
      if ((paramBoolean) || (ai.Eq())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.FLg)
      {
        this.FLu.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.FLu.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int FLM;
    private ViewGroup FLN;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.FLN = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.FLN = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.FLM;
      int j = hashCode();
      Object localObject1;
      int k;
      label156:
      label235:
      boolean bool;
      if (paramRect.height() == 0)
      {
        localObject1 = bt.eGN();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if (paramRect.top > 0) {
          this.FLM = paramRect.top;
        }
        if ((this.FLN != null) && ((this.FLN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.FLN.getLayoutParams();
          j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          i = 0;
          if (i < getChildCount())
          {
            localObject2 = getChildAt(i);
            if (!(localObject2 instanceof TestTimeForChatting)) {
              break label490;
            }
            localObject2 = (TestTimeForChatting)localObject2;
            if ((Float.compare(j, com.tencent.mm.cd.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
              break label471;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Hul = 0;
            if ((Float.compare(k, com.tencent.mm.cd.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Hum = 0;
            label286:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          ai.N(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.lf(14)) {
          break label504;
        }
        i = 0;
        label353:
        if (i >= getChildCount()) {
          break label504;
        }
        localObject1 = getChildAt(i);
        if (!(localObject1 instanceof TestTimeForChatting)) {
          break label497;
        }
        ((View)localObject1).setFitsSystemWindows(true);
        bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
        ((View)localObject1).setFitsSystemWindows(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.mRect);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(33221);
        return bool;
        localObject1 = "pass";
        break;
        label471:
        ((TestTimeForChatting)localObject2).Hul = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).Hum = k;
        break label286;
        label490:
        i += 1;
        break label156;
        label497:
        i += 1;
        break label353;
        label504:
        bool = false;
      }
    }
    
    public int getCacheInsetsTop()
    {
      return this.FLM;
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33222);
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j)
        {
          localView = getChildAt(i);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (((localView instanceof ImageView)) && (localView.getId() == 2131303386) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
            localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
      }
    }
    
    public void setActionBarContainer(ViewGroup paramViewGroup)
    {
      this.FLN = paramViewGroup;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(33218);
      FLI = new a("ACTIVITY_CREATE", 0);
      FLJ = new a("ACTIVITY_RESUME", 1);
      FLK = new a("ACTIVITY_PAUSE", 2);
      FLL = new a[] { FLI, FLJ, FLK };
      AppMethodBeat.o(33218);
    }
    
    private a() {}
  }
  
  final class b
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33227);
      this$1 = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      HomeUI localHomeUI = HomeUI.this;
      com.tencent.mm.kiss.a.b.agA();
      HomeUI.a(localHomeUI, com.tencent.mm.kiss.a.b.c(HomeUI.b(HomeUI.this), 2131492929));
      HomeUI.a(HomeUI.this, (ImageView)HomeUI.q(HomeUI.this).findViewById(2131300874));
      HomeUI.b(HomeUI.this, HomeUI.q(HomeUI.this).findViewById(2131305884));
      HomeUI.q(HomeUI.this).setLayoutParams(HomeUI.this);
      HomeUI.q(HomeUI.this).setMinimumHeight(paramInt2);
      HomeUI.q(HomeUI.this).setMinimumWidth(paramInt1);
      HomeUI.r(HomeUI.this).setImageResource(2131690510);
      HomeUI.q(HomeUI.this).setContentDescription(HomeUI.this.getString(2131764451));
      HomeUI.q(HomeUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33224);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(3);
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10919, "0");
          HomeUI.s(HomeUI.this);
          if (HomeUI.FKR.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            Boolean localBoolean = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, localBoolean, localBoolean);
          }
          if (HomeUI.FKS.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!bu.eEO())
          {
            long l = bt.eGO();
            if (l - HomeUI.t(HomeUI.this) > 10000L)
            {
              HomeUI.a(HomeUI.this, l);
              HomeUI.u(HomeUI.this);
              AppMethodBeat.o(33224);
              return;
            }
            HomeUI.v(HomeUI.this);
            if (HomeUI.w(HomeUI.this) >= 5)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              bu.uW(true);
            }
          }
          AppMethodBeat.o(33224);
        }
      });
      HomeUI.q(HomeUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33225);
          HomeUI.b(HomeUI.this).supportInvalidateOptionsMenu();
          AppMethodBeat.o(33225);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(33226);
          String str = super.toString() + "|supportInvalidateOptionsMenu";
          AppMethodBeat.o(33226);
          return str;
        }
      });
      AppMethodBeat.o(33227);
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(204897);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(204897);
    }
    
    public final boolean a(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final boolean cND()
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dcb paramdcb)
    {
      return false;
    }
    
    public final String getPath()
    {
      return "plus";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(33228);
      View localView = HomeUI.q(HomeUI.this);
      AppMethodBeat.o(33228);
      return localView;
    }
    
    public final boolean mY(boolean paramBoolean)
    {
      AppMethodBeat.i(204898);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(204898);
      return paramBoolean;
    }
    
    public final boolean mZ(boolean paramBoolean)
    {
      AppMethodBeat.i(33231);
      if (paramBoolean) {
        HomeUI.x(HomeUI.this).setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33231);
        return true;
        HomeUI.x(HomeUI.this).setVisibility(8);
      }
    }
    
    public final boolean na(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */