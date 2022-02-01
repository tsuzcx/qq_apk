package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.multitask.animation.b.b.c;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.plugin.multitask.j.c;
import com.tencent.mm.plugin.multitask.j.d;
import com.tencent.mm.plugin.multitask.j.e;
import com.tencent.mm.plugin.multitask.j.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "backgroundDrawableCenter", "Landroid/graphics/drawable/Drawable;", "backgroundDrawableCenterPressed", "backgroundDrawableLeft", "backgroundDrawableLeftPressed", "backgroundDrawableRight", "backgroundDrawableRightPressed", "ballRootView", "canResetExtraSize", "", "currentBallRootViewVerticalGravity", "currentLayoutState", "currentPassiveCount", "currentStateHeight", "getCurrentStateHeight", "()I", "currentStateWidth", "getCurrentStateWidth", "customView", "Landroid/view/View;", "customViewMargin", "customViewSize", "Landroid/graphics/Point;", "enableClick", "extendWidth", "getExtendWidth", "extraSize", "fingerPosOnDown", "Landroid/graphics/PointF;", "innerView", "<set-?>", "isFloatBallViewDockLeft", "()Z", "isTouchEnabled", "lastBackgroundDockLeft", "lastBackgroundManual", "lastBackgroundSettled", "lastBackgroundState", "lastClickTime", "", "lastLayoutDockLeft", "lastLayoutManual", "lastLayoutSettled", "lastLayoutState", "lastOrientation", "listeners", "", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "mLayoutTransition", "Landroid/animation/LayoutTransition;", "needTranslateAnimation", "otherContentView", "", "posYPercentOfScreen", "getPosYPercentOfScreen", "()F", "positionY", "getPositionY", "previousLayoutState", "scaleTouchSlop", "screenResolution", "stickyAnimator", "Landroid/animation/ValueAnimator;", "targetPositionXWhenOrientationChanged", "getTargetPositionXWhenOrientationChanged", "uiHandler", "Landroid/os/Handler;", "viewPosOnDown", "widthNeedExtend", "addFloatBallViewListener", "", "listener", "checkDoTranslateAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "checkOrientationIfNeed", "doUpdateFloatBallViewLayout", "isSettled", "isDockLeft", "getStateHeight", "getStateWidth", "getTargetPositionX", "startPositionX", "getTargetPositionY", "startPositionY", "getViewHeightWithoutVoip", "state", "getViewWidthWithoutVoip", "hasActiveState", "hasAppBrandVOIPState", "hasAudioState", "hasCustomViewState", "hasFourPassiveState", "hasOnePassiveState", "hasPassiveState", "hasThreePassiveState", "hasTwoPassiveState", "hasVOIPMultiTalkAudioState", "hasVOIPMultiTalkVideoState", "hasVideoState", "hide", "withTransAnimation", "withAlphaAnimation", "hideByTranslation", "inActiveFourPassiveState", "inActiveOnePassiveState", "inActiveState", "inActiveThreePassiveState", "inActiveTwoPassiveState", "inAudioState", "inCustomViewActiveState", "inFourPassiveState", "inOnePassiveState", "inThreePassiveState", "inTwoPassiveState", "inVideoState", "init", "isAnimating", "isPositionLeft", "positionX", "isWechatInForeground", "markWechatInForeground", "inForeground", "notifyBallPositionChanged", "x", "y", "isManual", "notifyOrientationChange", "orientation", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "processOrientationChanged", "newOrientation", "quickHide", "quickShow", "removeFloatBallViewListener", "resetExtraSize", "resetFloatBallViewSizeAndPosition", "setAlpha", "alpha", "setFloatBallAlphaInternal", "setNeedTranslateAnimation", "setVisibility", "visibility", "show", "withAnimation", "checkVisible", "showByTranslation", "startStickyAnimation", "stickToLeft", "targetPositionX", "targetPositionY", "updateBallPosition", "needNotify", "updateBallRootViewLayout", "gravity", "updateFloatBallBackground", "updateFloatBallViewLayout", "forceUpdate", "updateFloatBallViewLayoutState", "updateFloatBallViewSize", "viewWidth", "viewHeight", "notify", "updatePosYPercentOfScreen", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTaskFloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final MultiTaskFloatBallView.a LDx;
  private static final int vnA;
  private static final int vnz;
  private boolean LDA;
  public com.tencent.mm.plugin.multitask.animation.b.b LDy;
  private LayoutTransition LDz;
  private final Handler eLs;
  private int lastOrientation;
  private final Set<d> listeners;
  boolean vlB;
  private int vnu;
  private int vnv;
  private Drawable voF;
  private final Drawable voG;
  private final Drawable voH;
  private int von;
  private ValueAnimator vop;
  private FrameLayout vos;
  private FrameLayout vow;
  private int vpA;
  private boolean vpD;
  private boolean vpE;
  private boolean vpF;
  private int vpG;
  private boolean vpd;
  private Point vpf;
  private final PointF vpg;
  private final Point vph;
  private float vpi;
  private int vpj;
  private boolean vpk;
  private final boolean vpm;
  private final Point vpq;
  private final boolean vps;
  private int vpt;
  private boolean vpx;
  private boolean vpy;
  private boolean vpz;
  
  static
  {
    AppMethodBeat.i(304321);
    LDx = new MultiTaskFloatBallView.a((byte)0);
    vnz = a.bs(MMApplicationContext.getContext(), j.c.float_ball_active_passive_width);
    vnA = a.bs(MMApplicationContext.getContext(), j.c.float_ball_active_passive_height);
    AppMethodBeat.o(304321);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(304310);
    AppMethodBeat.o(304310);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304169);
    this.listeners = ((Set)new CopyOnWriteArraySet());
    this.vpf = new Point();
    this.vpg = new PointF();
    this.vph = new Point();
    this.vpi = -1.0F;
    this.vpm = true;
    this.vpq = new Point();
    this.vpt = 16;
    this.eLs = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, j.f.layout_multitask_float_ball_view, (ViewGroup)this);
    this.voF = a.m(paramContext, j.d.float_window_background_left);
    this.vos = ((FrameLayout)findViewById(j.e.ballRootView));
    this.vow = ((FrameLayout)findViewById(j.e.otherContentView));
    this.LDy = new com.tencent.mm.plugin.multitask.animation.b.b((View)this);
    this.von = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramAttributeSet = aw.bf(paramContext);
    s.s(paramAttributeSet, "getDisplayRealSize(context)");
    this.vpf = paramAttributeSet;
    if ((aw.jlc()) && (aw.mO(paramContext))) {
      this.vpf.x = aw.getDeviceWidth();
    }
    if (aw.jkS()) {
      this.vpf.x = aw.getDeviceHeight();
    }
    this.LDz = new LayoutTransition();
    paramContext = this.vos;
    if (paramContext != null) {
      paramContext.setLayoutTransition(this.LDz);
    }
    this.lastOrientation = getResources().getConfiguration().orientation;
    AppMethodBeat.o(304169);
  }
  
  private final void FR(int paramInt)
  {
    AppMethodBeat.i(304190);
    Point localPoint1 = this.vpf;
    Object localObject = aw.bf(getContext());
    s.s(localObject, "getDisplayRealSize(context)");
    this.vpf = ((Point)localObject);
    if ((aw.jlc()) && (aw.mO(getContext()))) {
      this.vpf.x = aw.getDeviceWidth();
    }
    if (aw.jkS()) {
      this.vpf.x = aw.getDeviceHeight();
    }
    Point localPoint2 = this.vpf;
    if (localPoint1 == null) {}
    for (localObject = "null";; localObject = localPoint1)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      if ((this.lastOrientation == paramInt) && ((localPoint1 == null) || ((localPoint1.x == this.vpf.x) && (localPoint1.y == this.vpf.y)))) {
        break label371;
      }
      this.lastOrientation = paramInt;
      this.vpk = true;
      localObject = getLayoutParams();
      if (localObject != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(304190);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    paramInt = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    int i = (int)(this.vpf.y * this.vpi);
    paramInt = Math.max(Math.min(paramInt, this.vpf.x), 0);
    i = Math.max(Math.min(i, this.vpf.y), 0);
    int j = getTargetPositionXWhenOrientationChanged();
    int k = FU(i);
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).leftMargin), Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).topMargin), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      d(bool, paramInt, i, j, k);
      label371:
      AppMethodBeat.o(304190);
      return;
    }
  }
  
  private static int FU(int paramInt)
  {
    int i;
    if (paramInt < f.vml) {
      i = f.vml;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= f.vmm);
    return f.vmm;
  }
  
  private static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, MultiTaskFloatBallView paramMultiTaskFloatBallView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(304316);
    s.u(paramMultiTaskFloatBallView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramMultiTaskFloatBallView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(304316);
      throw paramMultiTaskFloatBallView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    a(paramMultiTaskFloatBallView, (int)((paramInt2 * 1.0F - paramInt1) * f) + paramInt1, (int)(f * (paramInt4 * 1.0F - paramInt3)) + paramInt3, false);
    AppMethodBeat.o(304316);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(304237);
    if ((this.vpE == paramBoolean1) && (this.vpF == paramBoolean2) && (!this.vpD) && (this.vpG == paramInt))
    {
      AppMethodBeat.o(304237);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Integer.valueOf(paramInt) });
    this.vpG = paramInt;
    this.vpD = false;
    this.vpE = paramBoolean1;
    this.vpF = paramBoolean2;
    FrameLayout localFrameLayout;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localFrameLayout = this.vos;
        if (localFrameLayout != null)
        {
          localFrameLayout.setBackground(this.voF);
          AppMethodBeat.o(304237);
        }
      }
      else
      {
        localFrameLayout = this.vos;
        if (localFrameLayout != null)
        {
          localFrameLayout.setBackground(this.voG);
          AppMethodBeat.o(304237);
        }
      }
    }
    else
    {
      localFrameLayout = this.vos;
      if (localFrameLayout != null) {
        localFrameLayout.setBackground(this.voH);
      }
    }
    AppMethodBeat.o(304237);
  }
  
  private final void acs(int paramInt)
  {
    AppMethodBeat.i(304217);
    Object localObject = this.vos;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((FrameLayout)localObject).getLayoutParams())
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(304217);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    FrameLayout localFrameLayout = this.vos;
    if (localFrameLayout != null) {
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.vow;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localObject = this.vow;
        if (localObject != null) {
          break label152;
        }
      }
    }
    label152:
    for (localObject = null;; localObject = ((FrameLayout)localObject).getLayoutParams())
    {
      localObject = (FrameLayout.LayoutParams)localObject;
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
      }
      localFrameLayout = this.vow;
      if (localFrameLayout != null) {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(304217);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private final void ao(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.vpi = (paramInt / this.vpf.y);
    }
    this.vpj = paramInt;
  }
  
  private final void cZB()
  {
    AppMethodBeat.i(304274);
    gp(vnz, vnz);
    AppMethodBeat.o(304274);
  }
  
  private final void cZC()
  {
    AppMethodBeat.i(304296);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      int i = getResources().getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        FR(i);
      }
    }
    AppMethodBeat.o(304296);
  }
  
  private final void cZD()
  {
    AppMethodBeat.i(304300);
    if (!this.vps)
    {
      AppMethodBeat.o(304300);
      return;
    }
    try
    {
      if ((this.vpq.x != 0) || (this.vpq.y != 0))
      {
        Object localObject = getLayoutParams();
        if (localObject != null) {
          break label99;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(304300);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", (Throwable)localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(304300);
      return;
    }
    label99:
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localException;
    int i;
    if (this.LDA) {
      i = 0;
    }
    for (;;)
    {
      int j = localLayoutParams.y;
      int k = this.vpq.y;
      cZE();
      this.vpt = 16;
      cZB();
      a(this, i, j + k, true);
      AppMethodBeat.o(304300);
      return;
      i = localLayoutParams.x;
      j = this.vpq.x;
      i += j;
    }
  }
  
  private final void cZE()
  {
    AppMethodBeat.i(304304);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.vpq.x = 0;
    this.vpq.y = 0;
    AppMethodBeat.o(304304);
  }
  
  private final void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304255);
    Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    ValueAnimator localValueAnimator;
    if (this.vop != null)
    {
      localValueAnimator = this.vop;
      if ((localValueAnimator == null) || (localValueAnimator.isRunning() != true)) {
        break label245;
      }
    }
    label245:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
        localValueAnimator = this.vop;
        if (localValueAnimator != null) {
          localValueAnimator.cancel();
        }
      }
      this.vop = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.setDuration(100L);
      }
      localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener(new MultiTaskFloatBallView..ExternalSyntheticLambda0(paramInt1, paramInt3, paramInt2, paramInt4, this));
      }
      localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.addListener((Animator.AnimatorListener)new b(this));
      }
      localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.start();
      }
      AppMethodBeat.o(304255);
      return;
    }
  }
  
  private final int getCurrentStateHeight()
  {
    AppMethodBeat.i(304269);
    Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(this.vnu) });
    int i = vnA;
    int j = f.vme;
    int k = f.vmf;
    AppMethodBeat.o(304269);
    return i + j + k;
  }
  
  private final int getExtendWidth()
  {
    AppMethodBeat.i(304287);
    if (!this.vpk)
    {
      AppMethodBeat.o(304287);
      return 0;
    }
    if (!c.fD(getContext()))
    {
      AppMethodBeat.o(304287);
      return 0;
    }
    Object localObject;
    if ((getContext() instanceof Activity))
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(304287);
        throw ((Throwable)localObject);
      }
    }
    for (int i = ((Activity)localObject).getWindow().getWindowManager().getDefaultDisplay().getRotation();; i = 0)
    {
      if (((this.LDA) && (i == 1)) || ((!this.LDA) && (i == 3)))
      {
        i = c.bw(getContext());
        AppMethodBeat.o(304287);
        return i;
      }
      AppMethodBeat.o(304287);
      return 0;
    }
  }
  
  private final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(304264);
    int i = 0;
    if (!this.LDA) {
      i = this.vpf.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(304264);
    return i;
  }
  
  private final void gp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304281);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(304281);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
    }
    try
    {
      for (;;)
      {
        setLayoutParams((ViewGroup.LayoutParams)localObject);
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).width), Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).height) });
        AppMethodBeat.o(304281);
        return;
        ((ViewGroup.MarginLayoutParams)localObject).width = 0;
        ((ViewGroup.MarginLayoutParams)localObject).height = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallView", (Throwable)localException, "updateFloatBallViewSize exception", new Object[0]);
      }
    }
  }
  
  private final void l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(304200);
    if ((this.vpy == paramBoolean1) && (this.vpz == paramBoolean2) && (this.vpx == paramBoolean3) && (this.vpA != 0) && (this.vpA == this.vnu))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.vpE), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.vpz), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.vpx), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.vpA), Integer.valueOf(this.vnu) });
      AppMethodBeat.o(304200);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.vpA), Integer.valueOf(this.vnu) });
    this.vpx = paramBoolean3;
    this.vpy = paramBoolean1;
    this.vpz = paramBoolean2;
    this.vpA = this.vnu;
    cZB();
    FrameLayout localFrameLayout = this.vos;
    if (localFrameLayout != null)
    {
      localFrameLayout.getPaddingLeft();
      int j = localFrameLayout.getPaddingRight();
      int k = localFrameLayout.getPaddingTop();
      int m = localFrameLayout.getPaddingBottom();
      if ((this.vnu & 0x20) != 0)
      {
        if (i == 0) {
          break label402;
        }
        if (!paramBoolean2) {
          break label391;
        }
      }
      label391:
      for (i = this.vpt | 0x3;; i = this.vpt | 0x5)
      {
        acs(i);
        if ((!paramBoolean1) || (!paramBoolean2)) {
          break label483;
        }
        localFrameLayout = this.vos;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.vos;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.LDz);
        }
        acs(this.vpt | 0x3);
        localFrameLayout = this.vow;
        if (localFrameLayout == null) {
          break label483;
        }
        localFrameLayout.setVisibility(0);
        AppMethodBeat.o(304200);
        return;
        i = 0;
        break;
      }
      label402:
      if ((paramBoolean1) && (paramBoolean2))
      {
        localFrameLayout = this.vos;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.vos;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.LDz);
        }
        acs(this.vpt | 0x3);
        localFrameLayout = this.vow;
        if (localFrameLayout != null) {
          localFrameLayout.setVisibility(0);
        }
      }
    }
    label483:
    AppMethodBeat.o(304200);
  }
  
  private final void setFloatBallAlphaInternal(float paramFloat)
  {
    int j = 0;
    AppMethodBeat.i(304244);
    setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      i = 1;
      if (i == 0) {
        break label54;
      }
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
    }
    for (int i = 8;; i = j)
    {
      setVisibility(i);
      AppMethodBeat.o(304244);
      return;
      i = 0;
      break;
      label54:
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    }
  }
  
  final boolean FT(int paramInt)
  {
    AppMethodBeat.i(304378);
    if (getCurrentStateWidth() / 2 + paramInt <= this.vpf.x / 2)
    {
      AppMethodBeat.o(304378);
      return true;
    }
    AppMethodBeat.o(304378);
    return false;
  }
  
  public final void G(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(304375);
    this.LDA = FT(paramInt1);
    a(paramBoolean, this.LDA, false, this.vnu);
    l(paramBoolean, this.LDA, false);
    ao(paramInt2, paramBoolean);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(this.LDA) });
    AppMethodBeat.o(304375);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(304423);
    s.u(paramd, "listener");
    this.listeners.add(paramd);
    AppMethodBeat.o(304423);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304365);
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, multiTaskInfo:%s", new Object[] { paramMultiTaskInfo });
    this.vnv = this.vnu;
    this.vnu = 0;
    if (AppForegroundDelegate.heY.eLx) {
      this.vnu |= 0x20;
    }
    paramMultiTaskInfo = getLayoutParams();
    if (paramMultiTaskInfo == null)
    {
      paramMultiTaskInfo = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(304365);
      throw paramMultiTaskInfo;
    }
    boolean bool = FT(((ViewGroup.MarginLayoutParams)paramMultiTaskInfo).leftMargin);
    l(true, bool, false);
    a(true, bool, false, this.vnu);
    if (this.vlB)
    {
      Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
      setNeedTranslateAnimation(false);
      if (getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
        if (paramAnimatorListenerAdapter != null) {
          paramAnimatorListenerAdapter.onAnimationCancel(null);
        }
        AppMethodBeat.o(304365);
        return;
      }
      if (this.LDy != null)
      {
        paramMultiTaskInfo = getLayoutParams();
        if (paramMultiTaskInfo == null)
        {
          paramMultiTaskInfo = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(304365);
          throw paramMultiTaskInfo;
        }
        bool = FT(((FrameLayout.LayoutParams)paramMultiTaskInfo).leftMargin);
        paramMultiTaskInfo = this.LDy;
        if (paramMultiTaskInfo != null)
        {
          int i = getCurrentStateWidth();
          if (paramMultiTaskInfo.nmf == null)
          {
            if (paramAnimatorListenerAdapter != null) {
              paramAnimatorListenerAdapter.onAnimationCancel(null);
            }
            AppMethodBeat.o(304365);
            return;
          }
          if (paramMultiTaskInfo.cXD())
          {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
            if (paramAnimatorListenerAdapter != null) {
              paramAnimatorListenerAdapter.onAnimationCancel(null);
            }
            AppMethodBeat.o(304365);
            return;
          }
          if (paramMultiTaskInfo.cXE())
          {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
            Animator localAnimator = paramMultiTaskInfo.vjx;
            if (localAnimator != null) {
              localAnimator.cancel();
            }
          }
          Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { paramMultiTaskInfo.nmf, Integer.valueOf(i), Boolean.valueOf(bool) });
          paramMultiTaskInfo.vjw = paramMultiTaskInfo.a(true, i, bool, (AnimatorListenerAdapter)new b.c(paramMultiTaskInfo.nmf, paramAnimatorListenerAdapter));
          paramAnimatorListenerAdapter = paramMultiTaskInfo.vjw;
          if (paramAnimatorListenerAdapter != null) {
            paramAnimatorListenerAdapter.start();
          }
          paramAnimatorListenerAdapter = paramMultiTaskInfo.nmf;
          if (paramAnimatorListenerAdapter != null) {
            paramAnimatorListenerAdapter.setAlpha(1.0F);
          }
          paramMultiTaskInfo = paramMultiTaskInfo.nmf;
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.setVisibility(0);
          }
          AppMethodBeat.o(304365);
        }
      }
      else if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      AppMethodBeat.o(304365);
      return;
    }
    if (paramAnimatorListenerAdapter != null) {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
    }
    AppMethodBeat.o(304365);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304396);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
      AppMethodBeat.o(304396);
      return;
    }
    com.tencent.mm.plugin.multitask.animation.b.b localb;
    if ((paramBoolean1) && (this.LDy != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with trans animation");
      localb = this.LDy;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(304396);
      }
    }
    else if ((paramBoolean2) && (this.LDy != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with alpha animation");
      localb = this.LDy;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(304396);
      }
    }
    else
    {
      Log.i("MicroMsg.FloatBallView", "hide without animation");
      setVisibility(8);
      cZD();
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
      }
    }
    AppMethodBeat.o(304396);
  }
  
  final int getCurrentStateWidth()
  {
    AppMethodBeat.i(304403);
    Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(this.vnu) });
    int i = vnz;
    int j = f.vmg;
    AppMethodBeat.o(304403);
    return i + j;
  }
  
  public final float getPosYPercentOfScreen()
  {
    return this.vpi;
  }
  
  public final int getPositionY()
  {
    return this.vpj;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(304342);
    super.onAttachedToWindow();
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(304342);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    G(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, true);
    AppMethodBeat.o(304342);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(304353);
    s.u(paramConfiguration, "newConfig");
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    FR(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.listeners.iterator();
    while (paramConfiguration.hasNext()) {
      ((d)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(304353);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(304346);
    super.onDetachedFromWindow();
    if (this.vop != null)
    {
      ValueAnimator localValueAnimator = this.vop;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.vop = null;
    }
    AppMethodBeat.o(304346);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(304419);
    super.setAlpha(paramFloat);
    Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    cZC();
    AppMethodBeat.o(304419);
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.vlB = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(304413);
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304413);
      return;
      this.vpd = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(304413);
      return;
      this.vpd = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cZC();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView$startStickyAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(MultiTaskFloatBallView paramMultiTaskFloatBallView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304141);
      s.u(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.LDB.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(304141);
        throw paramAnimator;
      }
      paramAnimator = (ViewGroup.MarginLayoutParams)paramAnimator;
      this.LDB.G(paramAnimator.leftMargin, paramAnimator.topMargin, true);
      AppMethodBeat.o(304141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView
 * JD-Core Version:    0.7.0.1
 */