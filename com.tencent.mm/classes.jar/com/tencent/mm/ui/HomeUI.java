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
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.p;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.contact.k;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.vending.g.f;
import java.util.HashMap;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI
  implements com.tencent.mm.plugin.appbrand.widget.header.a, LauncherUI.b, LauncherUI.c, LauncherUI.d
{
  public static Boolean yXL = Boolean.FALSE;
  public static Boolean yXM = Boolean.FALSE;
  static final int yYd = 2131820646;
  static final int yYe = 2131820645;
  private String cCC;
  private int clickCount;
  View contentView;
  LayoutInflater exe;
  private boolean gzb;
  MessageQueue.IdleHandler jZm;
  ActionBar mActionBar;
  private long nhs;
  View pyE;
  com.tencent.mm.sdk.b.c qEr;
  boolean qGO;
  private final long rXi;
  private long rXj;
  private View skI;
  private final HashMap<String, Object> values;
  private TextView yTX;
  View yUs;
  private final long yXB;
  public boolean yXC;
  boolean yXD;
  public boolean yXE;
  private TextView yXF;
  private boolean yXG;
  private String yXH;
  private String yXI;
  private String yXJ;
  ab yXK;
  private final long yXN;
  private final long yXO;
  private boolean yXP;
  private int yXQ;
  private int yXR;
  private int yXS;
  HomeUI.a yXT;
  LauncherUI.a yXU;
  h yXV;
  MainTabUI yXW;
  int yXX;
  int yXY;
  private boolean yXZ;
  MMFragmentActivity yXg;
  private boolean yYa;
  View.OnLayoutChangeListener yYb;
  private boolean yYc;
  View yYf;
  ImageView yYg;
  View yYh;
  ImageView yYi;
  View yYj;
  MenuItem yYk;
  MenuItem yYl;
  private MenuItem yYm;
  MenuItem yYn;
  Menu yYo;
  private boolean yYp;
  Runnable yYq;
  private int yYr;
  private LinkedList<Runnable> yYs;
  o yYt;
  private float yYu;
  private boolean yYv;
  
  public HomeUI()
  {
    AppMethodBeat.i(29392);
    this.yXB = 604800000L;
    this.gzb = true;
    this.yXC = false;
    this.cCC = null;
    this.yXE = false;
    this.qGO = false;
    this.yXG = false;
    this.yXN = 432000000L;
    this.yXO = 604800000L;
    this.yXP = true;
    this.yXQ = 0;
    this.yXR = 0;
    this.yXS = 0;
    this.yXT = HomeUI.a.yYB;
    this.yXW = new MainTabUI();
    this.yXX = 0;
    this.yXY = 0;
    this.yXZ = false;
    this.yYa = true;
    this.yYb = new HomeUI.36(this);
    this.yYc = com.tencent.mm.sdk.platformtools.aa.dsC();
    this.yYp = true;
    this.clickCount = 0;
    this.nhs = 0L;
    this.values = new HashMap();
    this.qEr = new HomeUI.14(this);
    this.jZm = new HomeUI.16(this);
    this.yYq = new HomeUI.17(this);
    this.yYr = 0;
    this.rXi = 300L;
    this.rXj = SystemClock.elapsedRealtime();
    this.yYs = new LinkedList();
    this.yYt = new HomeUI.32(this);
    this.yYu = 0.0F;
    this.yYv = false;
    AppMethodBeat.o(29392);
  }
  
  private void Oa(int paramInt)
  {
    AppMethodBeat.i(29408);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(29408);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.h.Mo())) {
      i = paramInt;
    }
    for (;;)
    {
      if (Math.abs(this.yYr - i) >= 50000)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "updateStatusBar %s stack: %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.ah.aoA().toString() });
        this.yXg.getWindow().setStatusBarColor(i);
      }
      this.yYr = i;
      AppMethodBeat.o(29408);
      return;
      i = paramInt;
      if (Build.VERSION.SDK_INT >= 21) {
        i = aj.n(this.yXg.getResources().getColor(2131690523), paramInt);
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(29396);
    if (this.skI != null)
    {
      this.skI.clearAnimation();
      this.skI.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(232L, 0L, 1L, false);
        yXL = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.skI = null;
      AppMethodBeat.o(29396);
      return;
      label89:
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(232L, 5L, 1L, false);
      yXM = Boolean.FALSE;
    }
  }
  
  private void dAF()
  {
    AppMethodBeat.i(29412);
    if (this.yXg != null) {}
    try
    {
      this.yXg.moveTaskToBack(true);
      if (aw.RG()) {
        aw.RO().o(new HomeUI.22(this), 500L);
      }
      p.Bv().start();
      AppMethodBeat.o(29412);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean dBH()
  {
    return (this.yXQ == 2) && (this.yXR == 2);
  }
  
  private static boolean dBT()
  {
    AppMethodBeat.i(29418);
    if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())
    {
      AppMethodBeat.o(29418);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(r.Zn()))
    {
      AppMethodBeat.o(29418);
      return true;
    }
    AppMethodBeat.o(29418);
    return false;
  }
  
  private void qi(boolean paramBoolean)
  {
    AppMethodBeat.i(29395);
    if (this.skI != null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(29395);
      return;
    }
    this.skI = View.inflate(com.tencent.mm.sdk.platformtools.ah.getContext(), 2130970361, null);
    Object localObject = (TextView)this.skI.findViewById(2131826549);
    if (paramBoolean) {
      ((TextView)localObject).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131296411));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.skI.setBackgroundResource(2130839862);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.skI, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(com.tencent.mm.sdk.platformtools.ah.getContext(), 2131034254);
        this.skI.startAnimation((Animation)localObject);
        this.skI.setOnClickListener(new HomeUI.3(this, paramBoolean));
      }
      AppMethodBeat.o(29395);
      return;
      ((TextView)localObject).setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131296409));
    }
  }
  
  private void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(29409);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.yXg.getWindow().getDecorView();
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
      AppMethodBeat.o(29409);
      return;
    }
  }
  
  private void setActionBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(29415);
    if (this.pyE == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "alvinluo setActionBarColor color: %d, actionBarContainer == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.pyE != null) {
      this.pyE.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(29415);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(29393);
    if (!this.yXP)
    {
      AppMethodBeat.o(29393);
      return;
    }
    int i = this.yXW.Sl;
    Object localObject2 = getString(2131297005);
    Object localObject1;
    if (i == 0)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.protocal.d.whK)
      {
        if (this.yYc) {
          localObject1 = (String)localObject2 + getString(2131296529);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (this.yXW.zcx.dCN() > 0)
        {
          localObject2 = localObject1;
          if (!this.yYc) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + "(" + this.yXW.zcx.dCN() + ")";
        }
        localObject1 = new uh();
        ((uh)localObject1).cKM.cKN = 1;
        ((uh)localObject1).cKM.title = ((String)localObject2);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label209:
      if (i == 3)
      {
        Oa(this.yXg.getResources().getColor(2131690605));
        if (dBT())
        {
          ql(true);
          label242:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yXg.getResources().getColor(2131690605)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.pyE != null) {
            this.pyE.setBackgroundColor(this.yXg.getResources().getColor(2131690605));
          }
          this.yYp = false;
          if ((this.yXQ != 3) || (this.yXR != 3)) {
            break label636;
          }
        }
        label636:
        for (i = 1;; i = 0)
        {
          if ((i != 0) && (this.yYn != null) && (!this.yYn.isVisible())) {
            this.yYn.setVisible(true);
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.ez();
          this.yXF = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          if (this.yXF != null)
          {
            this.yXF.setText((CharSequence)localObject1);
            float f = com.tencent.mm.cb.a.ap(com.tencent.mm.sdk.platformtools.ah.getContext(), 2131427493) * com.tencent.mm.cb.a.gr(com.tencent.mm.sdk.platformtools.ah.getContext());
            if (this.yXF.getTextSize() != f) {
              this.yXF.setTextSize(0, f);
            }
            i = this.yXg.getResources().getColor(2131690711);
            if ((this.qGO) && (this.yXF.getCurrentTextColor() != i)) {
              this.yXF.setTextColor(i);
            }
            af.a(this.yXF.getPaint(), 0.8F);
          }
          AppMethodBeat.o(29393);
          return;
          localObject1 = (String)localObject2 + " " + getString(2131296529);
          break;
          if (i == 1)
          {
            localObject1 = getString(2131301392);
            break label209;
          }
          if (i == 2)
          {
            localObject1 = getString(2131301390);
            break label209;
          }
          if (i != 3) {
            break label873;
          }
          localObject1 = getString(2131301424);
          break label209;
          ql(false);
          break label242;
        }
      }
      Oa(this.yXg.getResources().getColor(2131690316));
      ql(this.qGO);
      localObject2 = this.mActionBar.getCustomView().getBackground();
      if ((localObject2 instanceof ColorDrawable)) {
        if (((ColorDrawable)localObject2).getColor() != this.yXg.getResources().getColor(2131690316)) {
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yXg.getResources().getColor(2131690316)));
        }
      }
      for (;;)
      {
        if (this.mActionBar.getCustomView().getVisibility() != 0) {
          this.mActionBar.getCustomView().setVisibility(0);
        }
        this.yYp = true;
        if ((dBH()) && (this.yYk != null) && (!this.yYk.isVisible())) {
          this.yYk.setVisible(true);
        }
        if ((!dBH()) || (this.yYl == null) || (this.yYl.isVisible())) {
          break;
        }
        this.yYl.setVisible(true);
        break;
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yXg.getResources().getColor(2131690316)));
      }
      label873:
      localObject1 = localObject2;
    }
  }
  
  private static void w(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(29421);
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setClickable(true);
        paramView.setBackgroundResource(2130837631);
        AppMethodBeat.o(29421);
        return;
      }
      paramView.setClickable(false);
      paramView.setBackgroundResource(2131690605);
    }
    AppMethodBeat.o(29421);
  }
  
  public final void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153791);
    MMFragment localMMFragment = getMainTabUI().dCB();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.yXg.getResources().getColor(2131690605));
        AppMethodBeat.o(153791);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.yXg.getResources().getColor(2131690316));
      }
      while (paramInt2 > 10)
      {
        w(this.yUs, false);
        w(this.yYf, false);
        AppMethodBeat.o(153791);
        return;
        setActionBarColor(paramInt1);
      }
      w(this.yUs, true);
      w(this.yYf, true);
    }
    AppMethodBeat.o(153791);
  }
  
  public final void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29405);
    this.yXg.getWindow().getDecorView().getBottom();
    this.yXg.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(29405);
  }
  
  public final void av(Runnable paramRunnable)
  {
    AppMethodBeat.i(29411);
    this.yYs.remove(paramRunnable);
    AppMethodBeat.o(29411);
  }
  
  public final void b(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153792);
    int i = paramInt2;
    if (!(getMainTabUI().dCB() instanceof MainUI))
    {
      paramInt2 = this.yXg.getResources().getColor(2131689652);
      paramInt1 = paramInt2;
      i = paramInt1;
      paramInt1 = paramInt2;
    }
    if ((paramInt1 != 0) && (this.yXF != null)) {
      this.yXF.setTextColor(paramInt1);
    }
    if (this.yYi != null)
    {
      if (this.yYv) {
        this.yYi.setAlpha(paramFloat);
      }
      this.yYi.setImageDrawable(aj.g(this.yXg, 2131230741, i));
    }
    if (this.yYg != null)
    {
      if (this.yYv) {
        this.yYg.setAlpha(paramFloat);
      }
      this.yYg.setImageDrawable(aj.g(this.yXg, 2131231480, i));
    }
    AppMethodBeat.o(153792);
  }
  
  final void dBI()
  {
    AppMethodBeat.i(29394);
    if (!aw.RG())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(29394);
      return;
    }
    aw.aaz();
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.platformtools.ah.e((Boolean)com.tencent.mm.model.c.Ru().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!k.AcM.booleanValue()))
    {
      yXL = Boolean.TRUE;
      qi(true);
    }
    long l1 = System.currentTimeMillis();
    aw.aaz();
    long l2 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Ru().get(340240, null));
    aw.aaz();
    boolean bool1 = com.tencent.mm.platformtools.ah.e((Boolean)com.tencent.mm.model.c.Ru().get(340230, null));
    aw.aaz();
    boolean bool2 = com.tencent.mm.platformtools.ah.e((Boolean)com.tencent.mm.model.c.Ru().get(340228, null));
    aw.aaz();
    boolean bool3 = com.tencent.mm.platformtools.ah.e((Boolean)com.tencent.mm.model.c.Ru().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      yXM = Boolean.TRUE;
      qi(false);
    }
    AppMethodBeat.o(29394);
  }
  
  final void dBJ()
  {
    AppMethodBeat.i(29397);
    if ((this.yXK == null) || (!aw.RG()))
    {
      AppMethodBeat.o(29397);
      return;
    }
    if (this.yXK.isShowing())
    {
      this.yXK.dismiss();
      AppMethodBeat.o(29397);
      return;
    }
    this.yXK.gr();
    AppMethodBeat.o(29397);
  }
  
  final void dBK()
  {
    AppMethodBeat.i(29399);
    int i;
    if (this.yYn != null)
    {
      this.yYn.setShowAsAction(2);
      if (this.yYp) {
        break label224;
      }
      if (!(this.yXW.dCB() instanceof MoreTabUI)) {
        break label219;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.yXW.dCB();
      if ((localMoreTabUI.zcZ != null) && (localMoreTabUI.zcZ.isVisible))
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
        this.yYn.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.yYl != null)
      {
        if (!this.yYp) {
          break label249;
        }
        this.yYl.setShowAsAction(2);
        this.yYl.setVisible(true);
      }
      label129:
      if (this.yYk != null)
      {
        if (!this.yYp) {
          break label274;
        }
        this.yYk.setShowAsAction(2);
        this.yYk.setVisible(true);
      }
    }
    for (;;)
    {
      if (this.yYm != null)
      {
        if (!this.yYp)
        {
          this.yYm.setShowAsAction(2);
          this.yYm.setVisible(true);
          this.yTX.setVisibility(0);
          AppMethodBeat.o(29399);
          return;
          i = 0;
          break;
          label219:
          i = 0;
          break label79;
          label224:
          this.yYn.setVisible(false);
          this.yYn.setEnabled(false);
          break label94;
          label249:
          this.yYl.setVisible(false);
          this.yYl.setEnabled(false);
          break label129;
          label274:
          this.yYk.setVisible(false);
          this.yYk.setEnabled(false);
          continue;
        }
        this.yYm.setVisible(false);
        this.yYm.setEnabled(false);
        this.yTX.setVisibility(8);
      }
    }
    AppMethodBeat.o(29399);
  }
  
  final void dBL()
  {
    AppMethodBeat.i(29400);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).isFTSIndexReady())
    {
      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), 2131303013, 0).show();
      AppMethodBeat.o(29400);
      return;
    }
    int i = this.yXW.Sl;
    if (i == 0) {
      getMainTabUI().dCB();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Bundle localBundle = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localBundle = ActivityOptions.makeSceneTransitionAnimation(this.yXg, new Pair[0]).toBundle();
    }
    com.tencent.mm.plugin.fts.a.d.b(this.yXg, ".ui.FTSMainUI", localIntent, localBundle);
    AppMethodBeat.o(29400);
  }
  
  final void dBM()
  {
    AppMethodBeat.i(29402);
    ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLE, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLE, Boolean.FALSE);
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.RM();
      int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLr, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.b(this.yXg, "", this.yXg.getResources().getString(2131304180, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(29402);
      return;
    }
    MMFragmentActivity localMMFragmentActivity = this.yXg;
    i locali = i.sFa;
    com.tencent.mm.plugin.story.api.n.a(localMMFragmentActivity, 0, i.cDI(), 10);
    AppMethodBeat.o(29402);
  }
  
  public final void dBN()
  {
    AppMethodBeat.i(29403);
    if ((r.ZU().booleanValue()) && ((yXL.booleanValue()) || (yXM.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    this.yXW.dBN();
    AppMethodBeat.o(29403);
  }
  
  public final void dBO()
  {
    AppMethodBeat.i(29404);
    aw.RO().dtb();
    this.yXW.dCG();
    al.d(this.yYq);
    AppMethodBeat.o(29404);
  }
  
  public final boolean dBP()
  {
    return this.yXT == HomeUI.a.yYC;
  }
  
  public final void dBQ()
  {
    AppMethodBeat.i(29413);
    updateTitle();
    AppMethodBeat.o(29413);
  }
  
  public final void dBR()
  {
    AppMethodBeat.i(29414);
    this.yXW.dBR();
    AppMethodBeat.o(29414);
  }
  
  public final void dBS()
  {
    AppMethodBeat.i(29417);
    this.yXW.Oj(180);
    AppMethodBeat.o(29417);
  }
  
  final void dBU()
  {
    AppMethodBeat.i(29419);
    if ((this.yYn != null) && (this.yYn.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.yYn.getActionView().findViewById(2131820929);
      localImageView.setImageDrawable(this.yXg.getResources().getDrawable(2131231442));
      if (dBT())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(29419);
        return;
      }
      localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
    }
    AppMethodBeat.o(29419);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(153790);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.KG();
    com.tencent.mm.compatible.b.g.KG();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.yXK != null) && (this.yXK.isShowing()))
    {
      this.yXK.dismiss();
      AppMethodBeat.o(153790);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      dBJ();
      AppMethodBeat.o(153790);
      return true;
    }
    Object localObject1 = this.yXW.dCB();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(153790);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((aw.RG()) && (com.tencent.mm.kernel.g.RJ().eHg) && (at.isWap(this.yXg)))
      {
        Object localObject2 = this.yXg;
        paramKeyEvent = new HomeUI.19(this);
        if (!aw.RG()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(153790);
          return true;
          aw.aaz();
          i = ((Integer)com.tencent.mm.model.c.Ru().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!com.tencent.mm.sdk.platformtools.aj.apk("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2130970356, null);
            ((TextView)((View)localObject1).findViewById(2131826532)).setText(2131301801);
            localObject2 = new c.a((Context)localObject2);
            ((c.a)localObject2).Rb(2131297087);
            ((c.a)localObject2).fu((View)localObject1);
            ((c.a)localObject2).Ri(2131297018).a(new MMAppMgr.1(i));
            ((c.a)localObject2).rG(false);
            ((c.a)localObject2).Rj(2131301798).b(new MMAppMgr.7());
            ((c.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((c.a)localObject2).aLZ().show();
            i = 1;
          }
        }
      }
      int i = at.getBackgroundLimitType(this.yXg);
      if ((aw.RG()) && (com.tencent.mm.kernel.g.RJ().eHg) && (at.isLimited(i)))
      {
        aw.aaz();
        if ((com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Ru().get(16385, null))) && (MMAppMgr.a(this.yXg, i, new HomeUI.20(this, i), new HomeUI.21(this))))
        {
          AppMethodBeat.o(153790);
          return true;
        }
      }
      dAF();
    }
    AppMethodBeat.o(153790);
    return false;
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.yXW;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(29401);
    String str = this.yXg.getString(paramInt);
    AppMethodBeat.o(29401);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(29407);
    if (this.yXU.dCm())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(29407);
      return;
    }
    this.mActionBar.setLogo(new ColorDrawable(this.yXg.getResources().getColor(17170445)));
    this.mActionBar.eu();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.et();
    this.mActionBar.ev();
    this.mActionBar.setCustomView(w.hM(this.yXg).inflate(2130968619, new LinearLayout(this.yXg), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131820989);
    if ((localImageView != null) && (this.qGO)) {
      localImageView.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    if (this.qGO) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yXg.getResources().getColor(2131689915)));
    }
    for (;;)
    {
      updateTitle();
      this.mActionBar.getCustomView().findViewById(2131820998).setOnClickListener(new HomeUI.18(this));
      AppMethodBeat.o(29407);
      return;
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yXg.getResources().getColor(2131690316)));
    }
  }
  
  final void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(29398);
    if ((this.yXK == null) || (this.yYf == null))
    {
      AppMethodBeat.o(29398);
      return;
    }
    if (!aw.RG())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(29398);
      return;
    }
    this.yXK.zeA.qz(paramBoolean);
    if (this.yXK.zeA.dDe()) {
      this.yYh.setVisibility(0);
    }
    for (;;)
    {
      uh localuh = new uh();
      localuh.cKM.cKN = 2;
      localuh.cKM.cKO = this.yXK.zeA.dDe();
      localuh.cKM.cKP = false;
      com.tencent.mm.sdk.b.a.ymk.l(localuh);
      AppMethodBeat.o(29398);
      return;
      this.yYh.setVisibility(8);
    }
  }
  
  public final void qk(boolean paramBoolean)
  {
    AppMethodBeat.i(29406);
    if (!paramBoolean) {
      initActionBar();
    }
    this.yXg.supportInvalidateOptionsMenu();
    if (r.ZU().booleanValue()) {
      dBI();
    }
    this.yXW.dCF();
    AppMethodBeat.o(29406);
  }
  
  public final void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(29420);
    if ((this.yYn != null) && (this.yYn.getActionView() != null) && (this.yXg != null))
    {
      if (this.yXg.getResources().getConfiguration().orientation == 2)
      {
        this.yYn.setVisible(false);
        this.yYn.setEnabled(false);
        AppMethodBeat.o(29420);
        return;
      }
      this.yYn.setVisible(true);
      this.yYn.setEnabled(true);
      ImageView localImageView = (ImageView)this.yYn.getActionView().findViewById(2131820929);
      localImageView.setImageDrawable(this.yXg.getResources().getDrawable(2131231442));
      if (paramBoolean)
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(29420);
        return;
      }
      localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
    }
    AppMethodBeat.o(29420);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(29410);
    if (!this.yYs.contains(paramRunnable)) {
      this.yYs.add(paramRunnable);
    }
    AppMethodBeat.o(29410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */