package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.h;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.jy.a;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopViewContainer;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopViewContainer.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer;
import com.tencent.mm.plugin.appbrand.widget.recent.j;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class TaskBarContainer
  extends HeaderContainer
  implements View.OnTouchListener, AppBrandDesktopViewContainer.a
{
  private MMFragmentActivity Dpx;
  private com.tencent.mm.plugin.taskbar.api.b FTE;
  private TaskBarView FTF;
  private DynamicBgContainer FTG;
  private GradientColorBackgroundView FTH;
  private BlurView FTI;
  private Rect FTJ;
  private boolean FTK;
  private LinearLayout FTL;
  private View FTM;
  private View FTN;
  private TextView FTO;
  private WeImageView FTP;
  private WeImageView FTQ;
  private WeImageView FTR;
  private WeImageView FTS;
  private View FTT;
  private View FTU;
  private TaskBarBottomView FTV;
  private AppBrandDesktopViewContainer FTW;
  private View FTX;
  private boolean FTY;
  private int FTZ;
  private GyroView FTo;
  private int FUa;
  private boolean FUb;
  private com.tencent.mm.plugin.multitask.ui.bg.a FUc;
  private Runnable FUd;
  private IListener FUe;
  private FrameLayout UrI;
  private GradientColorBackgroundView UrJ;
  private int aYN;
  private int aYO;
  private int aqL;
  private View nZg;
  private boolean whs;
  
  public TaskBarContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238163);
    this.FTJ = new Rect();
    this.FTK = false;
    this.FTY = true;
    this.aYN = 0;
    this.aYO = 0;
    this.FTZ = 0;
    this.FUa = 0;
    this.aqL = 0;
    this.whs = true;
    this.FUb = LocaleUtil.isChineseAppLang();
    this.FUc = null;
    this.FUd = null;
    this.FUe = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(238163);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238164);
    this.FTJ = new Rect();
    this.FTK = false;
    this.FTY = true;
    this.aYN = 0;
    this.aYO = 0;
    this.FTZ = 0;
    this.FUa = 0;
    this.aqL = 0;
    this.whs = true;
    this.FUb = LocaleUtil.isChineseAppLang();
    this.FUc = null;
    this.FUd = null;
    this.FUe = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(238164);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238165);
    this.FTJ = new Rect();
    this.FTK = false;
    this.FTY = true;
    this.aYN = 0;
    this.aYO = 0;
    this.FTZ = 0;
    this.FUa = 0;
    this.aqL = 0;
    this.whs = true;
    this.FUb = LocaleUtil.isChineseAppLang();
    this.FUc = null;
    this.FUd = null;
    this.FUe = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(238165);
  }
  
  private void a(DynamicBgContainer paramDynamicBgContainer, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(238189);
    this.FTG = paramDynamicBgContainer;
    this.FTH = paramGradientColorBackgroundView;
    if (this.FTE != null) {
      this.FTE.o(paramDynamicBgContainer, this.FTH);
    }
    AppMethodBeat.o(238189);
  }
  
  private void fuK()
  {
    AppMethodBeat.i(238169);
    int i = getResources().getConfiguration().orientation;
    this.FTZ = 0;
    AppMethodBeat.o(238169);
  }
  
  private void fuL()
  {
    AppMethodBeat.i(238174);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.whs)
    {
      AppMethodBeat.o(238174);
      return;
    }
    if (this.FTL != null)
    {
      this.FTL.setScaleX(0.6F);
      this.FTL.setScaleY(0.6F);
    }
    AppMethodBeat.o(238174);
  }
  
  private void fuM()
  {
    AppMethodBeat.i(238176);
    Object localObject;
    if ((this.FTO != null) && (this.nZg != null))
    {
      localObject = new int[2];
      this.nZg.getLocationOnScreen((int[])localObject);
      Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label164;
      }
    }
    label164:
    for (boolean bool = this.Dpx.isInMultiWindowMode();; bool = false)
    {
      if (bool)
      {
        localObject = (LinearLayout.LayoutParams)this.FTO.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = getResources().getDimensionPixelSize(2131165201);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).leftMargin) });
        if (this.FTO.getParent() != null) {
          this.FTO.getParent().requestLayout();
        }
        this.FTM.setVisibility(0);
      }
      AppMethodBeat.o(238176);
      return;
    }
  }
  
  private void fuN()
  {
    AppMethodBeat.i(238187);
    if ((this.FTI == null) || (this.Dpx == null))
    {
      AppMethodBeat.o(238187);
      return;
    }
    this.FTI.L((ViewGroup)this.Dpx.getWindow().getDecorView()).alW(ar.fj(Color.parseColor("#181818"), 76)).F(this.Dpx.getWindow().getDecorView().getBackground()).b(new f(this.Dpx.getBaseContext())).cw(20.0F);
    AppMethodBeat.o(238187);
  }
  
  private void gIj()
  {
    AppMethodBeat.i(258560);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.RbR, 0) == 1) {
      i = 1;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.AppBrandDesktopContainer", "initDesktopBg disable blur");
      this.UrJ = new GradientColorBackgroundView(getContext());
      this.UrI.addView(this.UrJ, new RelativeLayout.LayoutParams(-1, -1));
      Object localObject = com.tencent.mm.plugin.multitask.ui.bg.a.erA();
      this.UrJ.setColor(((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).gRT, ((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).gRU);
      this.UrJ.setUpdateMode(1);
      localObject = new FrameLayout(getContext());
      ((FrameLayout)localObject).setBackgroundColor(com.tencent.mm.cb.a.n(getContext(), 2131099834));
      this.UrI.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(258560);
      return;
      localObject = Build.BRAND.toLowerCase();
      if ((((String)localObject).contains("oppo")) || (((String)localObject).contains("vivo"))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    Log.i("MicroMsg.AppBrandDesktopContainer", "initDesktopBg enable blur");
    this.FTI = new BlurView(getContext());
    this.UrI.addView(this.FTI, new RelativeLayout.LayoutParams(-1, -1));
    fuN();
    AppMethodBeat.o(258560);
  }
  
  private void hp(Context paramContext)
  {
    AppMethodBeat.i(238173);
    View localView = LayoutInflater.from(paramContext).inflate(2131496652, null);
    this.FTL = ((LinearLayout)localView.findViewById(2131296790));
    ((FrameLayout.LayoutParams)this.FTL.getLayoutParams()).topMargin = ao.getStatusBarHeight(paramContext);
    this.FTo = ((GyroView)localView.findViewById(2131302234));
    this.UrI = ((FrameLayout)localView.findViewById(2131310690));
    gIj();
    this.FTW = ((AppBrandDesktopViewContainer)localView.findViewById(2131299537));
    this.FTW.setCallback(this);
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(2131296787);
    this.FTM = LayoutInflater.from(paramContext).inflate(2131496654, null);
    this.FTN = this.FTM.findViewById(2131299174);
    localFrameLayout.addView(this.FTM, -1, -1);
    this.FTO = ((TextView)this.FTM.findViewById(2131296784));
    this.FTP = ((WeImageView)this.FTM.findViewById(2131307390));
    this.FTQ = ((WeImageView)this.FTM.findViewById(2131305996));
    this.FTS = ((WeImageView)this.FTM.findViewById(2131302348));
    this.FTT = this.FTM.findViewById(2131307391);
    this.FTU = this.FTM.findViewById(2131305997);
    this.FTV = ((TaskBarBottomView)this.FTM.findViewById(2131296785));
    this.FTR = ((WeImageView)this.FTM.findViewById(2131296449));
    this.FTP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(238160);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).esy())) {
          TaskBarContainer.a(TaskBarContainer.this).abu(16);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238160);
      }
    });
    this.FTQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(238161);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).esy())) {
          TaskBarContainer.a(TaskBarContainer.this).abu(14);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238161);
      }
    });
    fuL();
    this.FTF = ((TaskBarView)localView.findViewById(2131296793));
    this.FTF.setHeaderContainer(this);
    this.FTF.setId(2131296793);
    this.FTW.getDesktopView().setTaskBarCallback(this.FTF);
    addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(238173);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(238170);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.aqL = com.tencent.mm.cb.a.fromDPToPix(paramContext, 16);
    fuK();
    setBackgroundColor(getResources().getColor(2131101287));
    com.tencent.mm.plugin.taskbar.ui.a.a locala = com.tencent.mm.plugin.taskbar.ui.a.a.FUZ;
    com.tencent.mm.plugin.taskbar.ui.a.a.fva();
    hp(paramContext);
    AppMethodBeat.o(238170);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(238177);
    if (this.FTO != null)
    {
      paramString = l.e(getContext(), paramString, com.tencent.mm.cb.a.aG(getContext(), 2131165195));
      this.FTO.setText(paramString);
      float f = com.tencent.mm.cb.a.aH(getContext(), 2131165186) * com.tencent.mm.cb.a.ji(getContext());
      if (this.FTO.getTextSize() != f) {
        this.FTO.setTextSize(0, f);
      }
      ao.a(this.FTO.getPaint(), 0.8F);
      ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(this.FTO, com.tencent.mm.plugin.auth.a.a.ceA(), a.b.FXm, a.c.FXp);
    }
    AppMethodBeat.o(238177);
  }
  
  public final boolean abw(int paramInt)
  {
    AppMethodBeat.i(238194);
    if ((paramInt == 11) && (this.FTF.getDesktopViewContainer().caF()) && (!this.FTK))
    {
      this.FTF.abD(paramInt);
      AppMethodBeat.o(238194);
      return true;
    }
    AppMethodBeat.o(238194);
    return false;
  }
  
  public final void abx(int paramInt)
  {
    AppMethodBeat.i(238195);
    super.abx(paramInt);
    if (this.FTV != null) {
      this.FTV.setDrawColor(paramInt);
    }
    AppMethodBeat.o(238195);
  }
  
  public final void ac(long paramLong, int paramInt)
  {
    AppMethodBeat.i(238183);
    super.ac(paramLong, paramInt);
    if (this.FTE != null) {
      this.FTE.i(paramLong, paramInt, false);
    }
    AppMethodBeat.o(238183);
  }
  
  public final void ad(long paramLong, int paramInt)
  {
    AppMethodBeat.i(238184);
    super.ad(paramLong, paramInt);
    if (this.FTE != null) {
      this.FTE.i(paramLong, paramInt, true);
    }
    AppMethodBeat.o(238184);
  }
  
  public final void caG()
  {
    AppMethodBeat.i(238199);
    this.FTF.abD(3);
    AppMethodBeat.o(238199);
  }
  
  public final void f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(238180);
    super.f(paramConfiguration);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.FUd != null) {
      removeCallbacks(this.FUd);
    }
    this.FTM.setVisibility(4);
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238162);
        TaskBarContainer.b(TaskBarContainer.this);
        if (ao.isDarkMode())
        {
          TaskBarContainer.this.abx(TaskBarContainer.this.getResources().getColor(2131100229));
          AppMethodBeat.o(238162);
          return;
        }
        TaskBarContainer.this.abx(TaskBarContainer.this.getResources().getColor(2131100898));
        AppMethodBeat.o(238162);
      }
    };
    this.FUd = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    if (this.FTF != null)
    {
      localObject = this.FTF;
      Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).hIX), Integer.valueOf(paramConfiguration.orientation) });
      if (((TaskBarView)localObject).onh != null)
      {
        ((TaskBarView)localObject).onp = ((TaskBarView)localObject).onh.getViewHeight();
        Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).onp) });
      }
      if (((TaskBarView)localObject).hIX != paramConfiguration.orientation)
      {
        ((TaskBarView)localObject).hIX = paramConfiguration.orientation;
        if ((((TaskBarView)localObject).onh != null) && (((TaskBarView)localObject).onh.fuw()))
        {
          Log.i("MicroMsg.TaskBarView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((TaskBarView)localObject).onh.ad(0L, 0);
          AppMethodBeat.o(238180);
          return;
        }
        ((TaskBarView)localObject).reloadData();
      }
    }
    AppMethodBeat.o(238180);
  }
  
  public final void fuA()
  {
    AppMethodBeat.i(238181);
    if (this.Dpx == null)
    {
      AppMethodBeat.o(238181);
      return;
    }
    Pair localPair = com.tencent.mm.plugin.taskbar.ui.c.b.aO(this.Dpx);
    ((FrameLayout.LayoutParams)this.FTN.getLayoutParams()).setMargins(((Integer)localPair.first).intValue(), 0, ((Integer)localPair.second).intValue(), 0);
    this.FTM.requestLayout();
    this.FTM.setVisibility(0);
    AppMethodBeat.o(238181);
  }
  
  public final boolean fuw()
  {
    AppMethodBeat.i(238182);
    if (this.FTE != null)
    {
      boolean bool = this.FTE.fuw();
      AppMethodBeat.o(238182);
      return bool;
    }
    AppMethodBeat.o(238182);
    return false;
  }
  
  public int getAnimationScrollOffset()
  {
    AppMethodBeat.i(238197);
    int i = this.FTE.getAnimationScrollOffset();
    AppMethodBeat.o(238197);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.FTJ;
  }
  
  public View getBackgroundGLSurfaceContainer()
  {
    return this.FTG;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    AppMethodBeat.i(238193);
    DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = this.FTG.getDynamicBgSurfaceView();
    AppMethodBeat.o(238193);
    return localDynamicBackgroundGLSurfaceView;
  }
  
  public View getBackgroundGradientView()
  {
    return this.FTH;
  }
  
  public View getDesktopBgView()
  {
    return this.UrI;
  }
  
  public View getDesktopContainerView()
  {
    return this.FTW;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.FUa;
  }
  
  public GyroView getGyroView()
  {
    return this.FTo;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.c.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.FTX;
  }
  
  public LinearLayout getRootLayout()
  {
    return this.FTL;
  }
  
  public int getViewHeight()
  {
    return this.aYO;
  }
  
  public final boolean isFullScreen()
  {
    return true;
  }
  
  public final void jh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238178);
    if (!this.whs)
    {
      if (paramInt1 <= 10) {
        this.whs = true;
      }
      AppMethodBeat.o(238178);
      return;
    }
    if (this.FTL != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(238178);
        return;
      }
      this.FTL.setTranslationY(getMeasuredHeight() - getBottom());
      float f = Math.max(Math.min(paramInt1 * 1.0F / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.FTL.setScaleX(f);
      this.FTL.setScaleY(f);
      Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 >= paramInt2) {
        this.whs = false;
      }
    }
    AppMethodBeat.o(238178);
  }
  
  public final void ji(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238196);
    super.ji(paramInt1, paramInt2);
    if (this.FTO != null) {
      this.FTO.setTextColor(paramInt1);
    }
    if (this.FTP != null)
    {
      this.FTP.setImageResource(2131689496);
      this.FTP.setIconColor(paramInt2);
    }
    if (this.FTQ != null)
    {
      this.FTQ.setImageResource(2131690728);
      this.FTQ.setIconColor(paramInt2);
    }
    Object localObject;
    if (this.FTS != null)
    {
      localObject = this.FTS;
      if (!this.FTF.FUi.iCn) {
        break label168;
      }
    }
    label168:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      ((WeImageView)localObject).setVisibility(paramInt1);
      if (this.FTR == null) {
        break label182;
      }
      this.FTR.setIconColor(paramInt2);
      if (this.nZg == null) {
        break label182;
      }
      localObject = this.nZg.findViewById(2131296449);
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        break;
      }
      this.FTR.setVisibility(4);
      AppMethodBeat.o(238196);
      return;
    }
    this.FTR.setVisibility(0);
    label182:
    AppMethodBeat.o(238196);
  }
  
  public final void o(View paramView1, View paramView2)
  {
    AppMethodBeat.i(238185);
    a((DynamicBgContainer)paramView1, (GradientColorBackgroundView)paramView2);
    AppMethodBeat.o(238185);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(238171);
    super.onAttachedToWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.FUe != null) {
      this.FUe.alive();
    }
    jy localjy = new jy();
    EventCenter.instance.publish(localjy);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localjy.dOR.dOS) });
    Object localObject2 = getContext().getResources().getString(2131755908);
    if (!com.tencent.mm.protocal.d.KyR)
    {
      localObject1 = localObject2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      if (!this.FUb) {
        break label225;
      }
    }
    label225:
    for (Object localObject1 = (String)localObject2 + h.jr(getContext());; localObject1 = (String)localObject2 + " " + h.jr(getContext()))
    {
      localObject2 = localObject1;
      if (localjy.dOR.dOS > 0)
      {
        localObject2 = localObject1;
        if (!this.FUb) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localjy.dOR.dOS + ")";
      }
      setActionBarTitle((String)localObject2);
      AppMethodBeat.o(238171);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238192);
    super.onDestroy();
    TaskBarView localTaskBarView;
    if (this.FTF != null)
    {
      localTaskBarView = this.FTF;
      Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onDestroy %d", new Object[] { Integer.valueOf(localTaskBarView.hashCode()) });
      localObject1 = localTaskBarView.getDesktopViewContainer().getDesktopView();
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    try
    {
      if (((AppBrandDesktopView)localObject1).onm != null)
      {
        localObject2 = ((AppBrandDesktopView)localObject1).onm;
        if (((RecentAppBrandViewContainer)localObject2).aco != null) {
          ((RecentAppBrandViewContainer)localObject2).removeCallbacks(((RecentAppBrandViewContainer)localObject2).aco);
        }
      }
      if (((AppBrandDesktopView)localObject1).ont != null)
      {
        ((AppBrandDesktopView)localObject1).removeCallbacks(((AppBrandDesktopView)localObject1).ont);
        ((AppBrandDesktopView)localObject1).ont = null;
      }
      if (((AppBrandDesktopView)localObject1).onu != null)
      {
        ((AppBrandDesktopView)localObject1).removeCallbacks(((AppBrandDesktopView)localObject1).onu);
        ((AppBrandDesktopView)localObject1).onu = null;
      }
      localObject2 = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject2).remove(((AppBrandDesktopView)localObject1).onQ);
      }
      localObject2 = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP();
      if (localObject2 != null) {
        ((j)localObject2).remove(((AppBrandDesktopView)localObject1).onR);
      }
      ((AppBrandDesktopView)localObject1).onS = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException2, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    Object localObject1 = localTaskBarView.FUi;
    ((d)localObject1).FUK.dead();
    ((d)localObject1).FUL = null;
    localObject2 = ((d)localObject1).fuW();
    if (localObject2 != null) {
      ((ah)localObject2).remove(((d)localObject1).FUI);
    }
    ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(((d)localObject1).kIM);
    try
    {
      if (localTaskBarView.ont != null)
      {
        localTaskBarView.removeCallbacks(localTaskBarView.ont);
        localTaskBarView.ont = null;
      }
      if (localTaskBarView.onu != null)
      {
        localTaskBarView.removeCallbacks(localTaskBarView.onu);
        localTaskBarView.onu = null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TaskBarView", localException1, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.FUe != null) {
      this.FUe.dead();
    }
    if (this.FUd != null)
    {
      removeCallbacks(this.FUd);
      this.FUd = null;
    }
    AppMethodBeat.o(238192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(238172);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.FUe != null) {
      this.FUe.dead();
    }
    AppMethodBeat.o(238172);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238168);
    fuK();
    Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.FTZ), Integer.valueOf(this.FUa) });
    if (this.FTY)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.FTZ - this.FUa - this.aqL;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aYO = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aYN)
      {
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYN) });
        this.aYN = getMeasuredWidth();
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.FTL.setPivotX(getMeasuredWidth() / 2.0F);
        this.FTL.setPivotY(au.eu(getContext()));
        fuL();
      }
      AppMethodBeat.o(238168);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(238191);
    super.onPause();
    if (this.FTF != null)
    {
      Object localObject = this.FTF;
      ((TaskBarView)localObject).isPaused = true;
      Log.i("MicroMsg.TaskBarView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject).onK), Boolean.valueOf(((TaskBarView)localObject).onN) });
      if ((((TaskBarView)localObject).onK) && (((TaskBarView)localObject).onN))
      {
        ((TaskBarView)localObject).onO = true;
        ((TaskBarView)localObject).fuS();
      }
      if (((TaskBarView)localObject).FUo)
      {
        ((TaskBarView)localObject).FUo = false;
        if (((TaskBarView)localObject).onh != null)
        {
          ((TaskBarView)localObject).onh.ac(1000L, ((TaskBarView)localObject).onP);
          ((TaskBarView)localObject).onP = 0;
        }
      }
      localObject = ((TaskBarView)localObject).FUi;
      d.b localb = ((d)localObject).FUL;
      if (localb == null) {
        break label222;
      }
      if (localb.esy() == true)
      {
        if (cl.aWA() >= ((d)localObject).mZq) {
          ((d)localObject).FUG += cl.aWA() - ((d)localObject).mZq;
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "onPause lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((d)localObject).mZq), Long.valueOf(((d)localObject).FUG), Long.valueOf(cl.aWA()) });
      }
    }
    AppMethodBeat.o(238191);
    return;
    label222:
    AppMethodBeat.o(238191);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(238190);
    super.onResume();
    fuA();
    if (this.FTF != null)
    {
      Object localObject = this.FTF;
      Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume");
      ((TaskBarView)localObject).isPaused = false;
      if (((RecyclerView)localObject).asn)
      {
        Log.v("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume setLayoutFrozen false");
        ((TaskBarView)localObject).setLayoutFrozen(false);
      }
      Log.i("MicroMsg.TaskBarView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject).onK), Boolean.valueOf(((TaskBarView)localObject).onO), Boolean.valueOf(((TaskBarView)localObject).FUn) });
      if ((((TaskBarView)localObject).onK) && (((TaskBarView)localObject).onO))
      {
        ((TaskBarView)localObject).fuT();
        ((TaskBarView)localObject).onN = true;
        ((TaskBarView)localObject).onO = true;
      }
      if ((((TaskBarView)localObject).FUn) && (((TaskBarView)localObject).onh != null))
      {
        ((TaskBarView)localObject).onh.ad(0L, ((TaskBarView)localObject).onP);
        ((TaskBarView)localObject).onP = 0;
        ((TaskBarView)localObject).FUn = false;
      }
      ((TaskBarView)localObject).FUi.cau();
      ((TaskBarView)localObject).fuQ();
      localObject = ((TaskBarView)localObject).FUi;
      d.b localb = ((d)localObject).FUL;
      if (localb == null) {
        break label270;
      }
      if (localb.esy() == true)
      {
        if (cl.aWA() >= ((d)localObject).mZq) {
          ((d)localObject).mZq = cl.aWA();
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "onResume lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((d)localObject).mZq), Long.valueOf(((d)localObject).FUG), Long.valueOf(cl.aWA()) });
      }
    }
    AppMethodBeat.o(238190);
    return;
    label270:
    AppMethodBeat.o(238190);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(238179);
    if ((this.FTE != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.FTE.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(238179);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(238175);
    super.setActionBar(paramView);
    this.nZg = paramView;
    fuM();
    AppMethodBeat.o(238175);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(238166);
    this.Dpx = paramMMFragmentActivity;
    fuN();
    AppMethodBeat.o(238166);
  }
  
  public void setAnimController(com.tencent.mm.plugin.taskbar.api.b paramb)
  {
    AppMethodBeat.i(238167);
    this.FTE = paramb;
    if ((this.FTF != null) && (this.FTE != null)) {
      this.FTE.a(this.FTF);
    }
    AppMethodBeat.o(238167);
  }
  
  public void setBlurAlpha(float paramFloat)
  {
    AppMethodBeat.i(238188);
    if (this.FTK)
    {
      AppMethodBeat.o(238188);
      return;
    }
    this.UrI.setAlpha(paramFloat);
    AppMethodBeat.o(238188);
  }
  
  public void setBlurAnimateStatue(boolean paramBoolean)
  {
    this.FTK = paramBoolean;
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(238186);
    a((DynamicBgContainer)paramView, this.FTH);
    AppMethodBeat.o(238186);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.FUa = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.FTY = paramBoolean;
  }
  
  public final void wn(boolean paramBoolean)
  {
    AppMethodBeat.i(238198);
    super.wn(paramBoolean);
    if (this.FTF != null)
    {
      TaskBarView localTaskBarView = this.FTF;
      Log.i("MicroMsg.TaskBarView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localTaskBarView.dSv) });
      if (localTaskBarView.dSv != paramBoolean) {
        localTaskBarView.dSv = paramBoolean;
      }
    }
    AppMethodBeat.o(238198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarContainer
 * JD-Core Version:    0.7.0.1
 */