package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.f.a.ko;
import com.tencent.mm.f.a.ko.a;
import com.tencent.mm.f.a.zw;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.b;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.e;
import com.tencent.mm.plugin.taskbar.d.f;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.t;

public class TaskBarContainer
  extends RelativeLayout
  implements View.OnTouchListener
{
  public boolean ARi;
  private int INC;
  private MMFragmentActivity Jvc;
  private a MoF;
  public TaskBarView MoG;
  public DynamicBgContainer MoH;
  private GradientColorBackgroundView MoI;
  private Rect MoJ;
  public LinearLayout MoK;
  public View MoL;
  private View MoM;
  private TextView MoN;
  private WeImageView MoO;
  private WeImageView MoP;
  private WeImageView MoQ;
  private WeImageView MoR;
  private View MoS;
  private View MoT;
  private TaskBarBottomView MoU;
  AppBrandDesktopContainerView MoV;
  private boolean MoW;
  private int MoX;
  private int MoY;
  private boolean MoZ;
  private GyroView Mor;
  public Runnable Mpa;
  public IListener Mpb;
  private int aIj;
  private int aIk;
  private int ajm;
  private View raR;
  
  public TaskBarContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(215157);
    this.MoJ = new Rect();
    this.INC = ax.getStatusBarHeight(getContext());
    this.MoW = true;
    this.aIj = 0;
    this.aIk = 0;
    this.MoX = 0;
    this.MoY = 0;
    this.ajm = 0;
    this.ARi = true;
    this.MoZ = LocaleUtil.isChineseAppLang();
    this.Mpa = null;
    this.Mpb = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(215157);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(215158);
    this.MoJ = new Rect();
    this.INC = ax.getStatusBarHeight(getContext());
    this.MoW = true;
    this.aIj = 0;
    this.aIk = 0;
    this.MoX = 0;
    this.MoY = 0;
    this.ajm = 0;
    this.ARi = true;
    this.MoZ = LocaleUtil.isChineseAppLang();
    this.Mpa = null;
    this.Mpb = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(215158);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215159);
    this.MoJ = new Rect();
    this.INC = ax.getStatusBarHeight(getContext());
    this.MoW = true;
    this.aIj = 0;
    this.aIk = 0;
    this.MoX = 0;
    this.MoY = 0;
    this.ajm = 0;
    this.ARi = true;
    this.MoZ = LocaleUtil.isChineseAppLang();
    this.Mpa = null;
    this.Mpb = new IListener() {};
    init(paramContext);
    AppMethodBeat.o(215159);
  }
  
  private void gjp()
  {
    AppMethodBeat.i(215164);
    int i = getResources().getConfiguration().orientation;
    this.MoX = 0;
    AppMethodBeat.o(215164);
  }
  
  private void gjq()
  {
    AppMethodBeat.i(215174);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.ARi)
    {
      AppMethodBeat.o(215174);
      return;
    }
    if (this.MoK != null)
    {
      this.MoK.setScaleX(0.6F);
      this.MoK.setScaleY(0.6F);
    }
    AppMethodBeat.o(215174);
  }
  
  private void gjr()
  {
    AppMethodBeat.i(215177);
    Object localObject;
    if ((this.MoN != null) && (this.raR != null))
    {
      localObject = new int[2];
      this.raR.getLocationOnScreen((int[])localObject);
      Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label163;
      }
    }
    label163:
    for (boolean bool = this.Jvc.isInMultiWindowMode();; bool = false)
    {
      if (bool)
      {
        localObject = (LinearLayout.LayoutParams)this.MoN.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = getResources().getDimensionPixelSize(d.b.BiggerPadding);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).leftMargin) });
        if (this.MoN.getParent() != null) {
          this.MoN.getParent().requestLayout();
        }
        this.MoL.setVisibility(0);
      }
      AppMethodBeat.o(215177);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(215166);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.ajm = com.tencent.mm.ci.a.aZ(paramContext, d.b.app_brand_desktop_close_area_extra);
    gjp();
    setBackgroundColor(getResources().getColor(d.a.transparent));
    com.tencent.mm.plugin.taskbar.ui.a.a locala = com.tencent.mm.plugin.taskbar.ui.a.a.Mqu;
    com.tencent.mm.plugin.taskbar.ui.a.a.gjY();
    ip(paramContext);
    AppMethodBeat.o(215166);
  }
  
  private void ip(Context paramContext)
  {
    AppMethodBeat.i(215172);
    View localView = LayoutInflater.from(paramContext).inflate(d.e.MmB, null);
    this.MoK = ((LinearLayout)localView.findViewById(d.d.app_brand_desktop_root_layout));
    ((FrameLayout.LayoutParams)this.MoK.getLayoutParams()).topMargin = this.INC;
    this.Mor = ((GyroView)localView.findViewById(d.d.gyro_view));
    this.MoV = ((AppBrandDesktopContainerView)localView.findViewById(d.d.Mms));
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(d.d.Mmr);
    this.MoL = LayoutInflater.from(paramContext).inflate(d.e.MmC, null);
    this.MoM = this.MoL.findViewById(d.d.container);
    localFrameLayout.addView(this.MoL, -1, -1);
    this.MoN = ((TextView)this.MoL.findViewById(d.d.Mmp));
    this.MoO = ((WeImageView)this.MoL.findViewById(d.d.search_icon));
    this.MoP = ((WeImageView)this.MoL.findViewById(d.d.Mmu));
    this.MoR = ((WeImageView)this.MoL.findViewById(d.d.home_title_icon));
    this.MoS = this.MoL.findViewById(d.d.Mmw);
    this.MoT = this.MoL.findViewById(d.d.Mmv);
    this.MoU = ((TaskBarBottomView)this.MoL.findViewById(d.d.Mmq));
    this.MoQ = ((WeImageView)this.MoL.findViewById(d.d.actionbar_up_indicator_btn));
    this.MoO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214930);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).fcH())) {
          TaskBarContainer.a(TaskBarContainer.this).DC(16);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214930);
      }
    });
    this.MoP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214811);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).fcH())) {
          TaskBarContainer.a(TaskBarContainer.this).DC(14);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214811);
      }
    });
    gjq();
    this.MoG = ((TaskBarView)localView.findViewById(d.d.app_brand_desktop_view));
    this.MoG.setHeaderContainer(this);
    this.MoG.setId(d.d.app_brand_desktop_view);
    addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(215172);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(215181);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(215181);
      return;
    }
    if (this.MoN != null)
    {
      paramString = l.d(getContext(), paramString, com.tencent.mm.ci.a.aY(getContext(), d.b.BigTextSize));
      this.MoN.setText(paramString);
      float f = com.tencent.mm.ci.a.aZ(getContext(), d.b.ActionBarTextSize) * com.tencent.mm.ci.a.km(getContext());
      if (this.MoN.getTextSize() != f) {
        this.MoN.setTextSize(0, f);
      }
      ar.a(this.MoN.getPaint(), 0.8F);
      ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(this.MoN, com.tencent.mm.plugin.auth.a.a.crN(), a.b.MzF, a.c.MzI);
    }
    AppMethodBeat.o(215181);
  }
  
  public final void a(DynamicBgContainer paramDynamicBgContainer, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(215189);
    this.MoH = paramDynamicBgContainer;
    this.MoI = paramGradientColorBackgroundView;
    if (this.MoF != null) {
      this.MoF.o(paramDynamicBgContainer, this.MoI);
    }
    AppMethodBeat.o(215189);
  }
  
  public final void aiU(int paramInt)
  {
    AppMethodBeat.i(215171);
    if (this.INC != paramInt)
    {
      this.INC = paramInt;
      ((FrameLayout.LayoutParams)this.MoK.getLayoutParams()).topMargin = paramInt;
      Object localObject = this.MoV.rpp.getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(215171);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
    }
    AppMethodBeat.o(215171);
  }
  
  public final void aiV(int paramInt)
  {
    AppMethodBeat.i(215195);
    if (this.MoU != null) {
      this.MoU.setDrawColor(paramInt);
    }
    AppMethodBeat.o(215195);
  }
  
  public final void al(long paramLong, int paramInt)
  {
    AppMethodBeat.i(215186);
    if (this.MoF != null) {
      this.MoF.i(paramLong, paramInt, false);
    }
    AppMethodBeat.o(215186);
  }
  
  public final void am(long paramLong, int paramInt)
  {
    AppMethodBeat.i(215187);
    if (this.MoF != null) {
      this.MoF.i(paramLong, paramInt, true);
    }
    AppMethodBeat.o(215187);
  }
  
  public int getAnimationScrollOffset()
  {
    return this.MoF.Moa;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.MoJ;
  }
  
  public DynamicBgContainer getBackgroundGLSurfaceContainer()
  {
    return this.MoH;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    AppMethodBeat.i(215190);
    DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = this.MoH.getDynamicBgSurfaceView();
    AppMethodBeat.o(215190);
    return localDynamicBackgroundGLSurfaceView;
  }
  
  public View getBackgroundGradientView()
  {
    return this.MoI;
  }
  
  public AppBrandDesktopContainerView getDesktopContainerView()
  {
    return this.MoV;
  }
  
  public int getExtraBottomHeight()
  {
    return this.MoY;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.d.a.a getHeaderView()
  {
    return null;
  }
  
  public LinearLayout getRootLayout()
  {
    return this.MoK;
  }
  
  public TaskBarView getTaskBarView()
  {
    return this.MoG;
  }
  
  public int getViewHeight()
  {
    return this.aIk;
  }
  
  public final void gjs()
  {
    AppMethodBeat.i(215184);
    if (this.Jvc == null)
    {
      AppMethodBeat.o(215184);
      return;
    }
    Pair localPair = com.tencent.mm.plugin.taskbar.ui.c.b.aU(this.Jvc);
    ((FrameLayout.LayoutParams)this.MoM.getLayoutParams()).setMargins(((Integer)localPair.first).intValue(), 0, ((Integer)localPair.second).intValue(), 0);
    this.MoL.requestLayout();
    this.MoL.setVisibility(0);
    AppMethodBeat.o(215184);
  }
  
  public final boolean gjt()
  {
    AppMethodBeat.i(215185);
    if (this.MoF != null)
    {
      boolean bool = this.MoF.gjg();
      AppMethodBeat.o(215185);
      return bool;
    }
    AppMethodBeat.o(215185);
    return false;
  }
  
  public final void ks(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215197);
    if (this.MoN != null) {
      this.MoN.setTextColor(paramInt1);
    }
    if (this.MoO != null)
    {
      this.MoO.setImageResource(d.f.actionbar_icon_dark_search);
      this.MoO.setIconColor(paramInt2);
    }
    if (this.MoP != null)
    {
      this.MoP.setImageResource(d.f.icons_outlined_add2);
      this.MoP.setIconColor(paramInt2);
    }
    Object localObject;
    if (this.MoR != null)
    {
      localObject = this.MoR;
      if (!this.MoG.Mph.lsi) {
        break label162;
      }
    }
    label162:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      ((WeImageView)localObject).setVisibility(paramInt1);
      if (this.MoQ == null) {
        break label176;
      }
      this.MoQ.setIconColor(paramInt2);
      if (this.raR == null) {
        break label176;
      }
      localObject = this.raR.findViewById(d.d.actionbar_up_indicator_btn);
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        break;
      }
      this.MoQ.setVisibility(4);
      AppMethodBeat.o(215197);
      return;
    }
    this.MoQ.setVisibility(0);
    label176:
    AppMethodBeat.o(215197);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(215167);
    super.onAttachedToWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.Mpb != null) {
      this.Mpb.alive();
    }
    ko localko = new ko();
    EventCenter.instance.publish(localko);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localko.fIc.fId) });
    Object localObject2 = getContext().getResources().getString(d.g.app_name);
    if (!com.tencent.mm.protocal.d.RAG)
    {
      localObject1 = localObject2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      if (!this.MoZ) {
        break label225;
      }
    }
    label225:
    for (Object localObject1 = (String)localObject2 + com.tencent.mm.cj.h.kv(getContext());; localObject1 = (String)localObject2 + " " + com.tencent.mm.cj.h.kv(getContext()))
    {
      localObject2 = localObject1;
      if (localko.fIc.fId > 0)
      {
        localObject2 = localObject1;
        if (!this.MoZ) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localko.fIc.fId + ")";
      }
      setActionBarTitle((String)localObject2);
      AppMethodBeat.o(215167);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(215169);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.Mpb != null) {
      this.Mpb.dead();
    }
    AppMethodBeat.o(215169);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215162);
    gjp();
    Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.MoX), Integer.valueOf(this.MoY) });
    if (this.MoW)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.MoX - this.MoY - this.ajm;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aIk = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aIj)
      {
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aIj) });
        this.aIj = getMeasuredWidth();
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.MoK.setPivotX(getMeasuredWidth() / 2.0F);
        this.MoK.setPivotY(ax.ew(getContext()));
        gjq();
      }
      AppMethodBeat.o(215162);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215182);
    if ((this.MoF != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.MoF.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(215182);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(215176);
    this.raR = paramView;
    gjr();
    AppMethodBeat.o(215176);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.Jvc = paramMMFragmentActivity;
  }
  
  public void setAnimController(a parama)
  {
    AppMethodBeat.i(215161);
    this.MoF = parama;
    if ((this.MoG != null) && (this.MoF != null)) {
      this.MoF.a(this.MoG);
    }
    AppMethodBeat.o(215161);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(215188);
    a((DynamicBgContainer)paramView, this.MoI);
    AppMethodBeat.o(215188);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.MoY = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.MoW = paramBoolean;
  }
  
  public final void zS(boolean paramBoolean)
  {
    AppMethodBeat.i(215192);
    this.MoG.zU(paramBoolean);
    AppMethodBeat.o(215192);
  }
  
  public final void zT(boolean paramBoolean)
  {
    AppMethodBeat.i(215203);
    if (this.MoG != null)
    {
      TaskBarView localTaskBarView = this.MoG;
      Log.i("MicroMsg.TaskBarView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localTaskBarView.fLS) });
      if (localTaskBarView.fLS != paramBoolean) {
        localTaskBarView.fLS = paramBoolean;
      }
    }
    DynamicBgContainer.setIsInMultiWindowMode(paramBoolean);
    AppMethodBeat.o(215203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarContainer
 * JD-Core Version:    0.7.0.1
 */