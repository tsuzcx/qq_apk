package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.ci.a;
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
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "backgroundDrawableCenter", "Landroid/graphics/drawable/Drawable;", "backgroundDrawableCenterPressed", "backgroundDrawableLeft", "backgroundDrawableLeftPressed", "backgroundDrawableRight", "backgroundDrawableRightPressed", "ballRootView", "canResetExtraSize", "", "currentBallRootViewVerticalGravity", "currentLayoutState", "currentPassiveCount", "currentStateHeight", "getCurrentStateHeight", "()I", "currentStateWidth", "getCurrentStateWidth", "customView", "Landroid/view/View;", "customViewMargin", "customViewSize", "Landroid/graphics/Point;", "enableClick", "extendWidth", "getExtendWidth", "extraSize", "fingerPosOnDown", "Landroid/graphics/PointF;", "innerView", "<set-?>", "isFloatBallViewDockLeft", "()Z", "isTouchEnabled", "lastBackgroundDockLeft", "lastBackgroundManual", "lastBackgroundSettled", "lastBackgroundState", "lastClickTime", "", "lastLayoutDockLeft", "lastLayoutManual", "lastLayoutSettled", "lastLayoutState", "lastOrientation", "listeners", "", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "mLayoutTransition", "Landroid/animation/LayoutTransition;", "needTranslateAnimation", "otherContentView", "", "posYPercentOfScreen", "getPosYPercentOfScreen", "()F", "positionY", "getPositionY", "previousLayoutState", "scaleTouchSlop", "screenResolution", "stickyAnimator", "Landroid/animation/ValueAnimator;", "targetPositionXWhenOrientationChanged", "getTargetPositionXWhenOrientationChanged", "uiHandler", "Landroid/os/Handler;", "viewPosOnDown", "widthNeedExtend", "addFloatBallViewListener", "", "listener", "checkDoTranslateAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "checkOrientationIfNeed", "doUpdateFloatBallViewLayout", "isSettled", "isDockLeft", "getStateHeight", "getStateWidth", "getTargetPositionX", "startPositionX", "getTargetPositionY", "startPositionY", "getViewHeightWithoutVoip", "state", "getViewWidthWithoutVoip", "hasActiveState", "hasAppBrandVOIPState", "hasAudioState", "hasCustomViewState", "hasFourPassiveState", "hasOnePassiveState", "hasPassiveState", "hasThreePassiveState", "hasTwoPassiveState", "hasVOIPMultiTalkAudioState", "hasVOIPMultiTalkVideoState", "hasVideoState", "hide", "withTransAnimation", "withAlphaAnimation", "hideByTranslation", "inActiveFourPassiveState", "inActiveOnePassiveState", "inActiveState", "inActiveThreePassiveState", "inActiveTwoPassiveState", "inAudioState", "inCustomViewActiveState", "inFourPassiveState", "inOnePassiveState", "inThreePassiveState", "inTwoPassiveState", "inVideoState", "init", "isAnimating", "isPositionLeft", "positionX", "isWechatInForeground", "markWechatInForeground", "inForeground", "notifyBallPositionChanged", "x", "y", "isManual", "notifyOrientationChange", "orientation", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "processOrientationChanged", "newOrientation", "quickHide", "quickShow", "removeFloatBallViewListener", "resetExtraSize", "resetFloatBallViewSizeAndPosition", "setAlpha", "alpha", "setFloatBallAlphaInternal", "setNeedTranslateAnimation", "setVisibility", "visibility", "show", "withAnimation", "checkVisible", "showByTranslation", "startStickyAnimation", "stickToLeft", "targetPositionX", "targetPositionY", "updateBallPosition", "needNotify", "updateBallRootViewLayout", "gravity", "updateFloatBallBackground", "updateFloatBallViewLayout", "forceUpdate", "updateFloatBallViewLayoutState", "updateFloatBallViewSize", "viewWidth", "viewHeight", "notify", "updatePosYPercentOfScreen", "Companion", "plugin-multitask_release"})
public final class MultiTaskFloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final MultiTaskFloatBallView.a FIi;
  private static final int scf;
  private static final int scg;
  public com.tencent.mm.plugin.multitask.animation.b.b FIe;
  private FrameLayout FIf;
  private LayoutTransition FIg;
  private boolean FIh;
  private final Handler cQo;
  private int lastOrientation;
  private final Set<d> listeners;
  boolean sak;
  private int scS;
  private ValueAnimator scU;
  private FrameLayout scZ;
  private int sca;
  private int scb;
  private boolean sdB;
  private Point sdD;
  private final PointF sdE;
  private final Point sdF;
  private float sdG;
  private int sdH;
  private boolean sdI;
  private final boolean sdK;
  private final Point sdN;
  private final boolean sdP;
  private int sdQ;
  private boolean sdR;
  private boolean sdS;
  private boolean sdT;
  private int sdU;
  private boolean sdX;
  private boolean sdY;
  private boolean sdZ;
  private Drawable sdg;
  private final Drawable sdh;
  private final Drawable sdi;
  private int sea;
  
  static
  {
    AppMethodBeat.i(248849);
    FIi = new MultiTaskFloatBallView.a((byte)0);
    scf = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_active_passive_width);
    scg = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_active_passive_height);
    AppMethodBeat.o(248849);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248846);
    this.listeners = ((Set)new CopyOnWriteArraySet());
    this.sdD = new Point();
    this.sdE = new PointF();
    this.sdF = new Point();
    this.sdG = -1.0F;
    this.sdK = true;
    this.sdN = new Point();
    this.sdQ = 16;
    this.cQo = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, j.f.layout_multitask_float_ball_view, (ViewGroup)this);
    this.sdg = a.m(paramContext, j.d.float_window_background_left);
    this.FIf = ((FrameLayout)findViewById(j.e.ballRootView));
    this.scZ = ((FrameLayout)findViewById(j.e.otherContentView));
    this.FIe = new com.tencent.mm.plugin.multitask.animation.b.b((View)this);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    p.j(paramAttributeSet, "ViewConfiguration.get(context)");
    this.scS = paramAttributeSet.getScaledTouchSlop();
    paramAttributeSet = ar.au(paramContext);
    p.j(paramAttributeSet, "UIUtils.getDisplayRealSize(context)");
    this.sdD = paramAttributeSet;
    if ((ar.hIO()) && (ar.kL(paramContext))) {
      this.sdD.x = ar.getDeviceWidth();
    }
    if (ar.hIH()) {
      this.sdD.x = ar.getDeviceHeight();
    }
    this.FIg = new LayoutTransition();
    paramContext = this.FIf;
    if (paramContext != null) {
      paramContext.setLayoutTransition(this.FIg);
    }
    paramContext = getResources();
    p.j(paramContext, "resources");
    this.lastOrientation = paramContext.getConfiguration().orientation;
    AppMethodBeat.o(248846);
  }
  
  private final void Fs(int paramInt)
  {
    AppMethodBeat.i(248810);
    Point localPoint1 = this.sdD;
    Object localObject = ar.au(getContext());
    p.j(localObject, "UIUtils.getDisplayRealSize(context)");
    this.sdD = ((Point)localObject);
    if ((ar.hIO()) && (ar.kL(getContext()))) {
      this.sdD.x = ar.getDeviceWidth();
    }
    if (ar.hIH()) {
      this.sdD.x = ar.getDeviceHeight();
    }
    Point localPoint2 = this.sdD;
    if (localPoint1 == null) {}
    for (localObject = "null";; localObject = localPoint1)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      int i;
      int j;
      int k;
      if ((this.lastOrientation != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.sdD.x) || (localPoint1.y != this.sdD.y))))
      {
        this.lastOrientation = paramInt;
        this.sdI = true;
        localObject = getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(248810);
          throw ((Throwable)localObject);
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        paramInt = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        i = (int)(this.sdD.y * this.sdG);
        paramInt = Math.max(Math.min(paramInt, this.sdD.x), 0);
        i = Math.max(Math.min(i, this.sdD.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = Fv(i);
        if (j != 0) {
          break label371;
        }
      }
      label371:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).leftMargin), Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).topMargin), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        d(bool, paramInt, i, j, k);
        AppMethodBeat.o(248810);
        return;
      }
    }
  }
  
  private static int Fv(int paramInt)
  {
    int i;
    if (paramInt < f.saT) {
      i = f.saT;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= f.saU);
    return f.saU;
  }
  
  private final void Y(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.sdG = (paramInt / this.sdD.y);
    }
    this.sdH = paramInt;
  }
  
  private final void Yg(int paramInt)
  {
    AppMethodBeat.i(248814);
    Object localObject = this.FIf;
    if (localObject != null) {}
    for (localObject = ((FrameLayout)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(248814);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    FrameLayout localFrameLayout = this.FIf;
    if (localFrameLayout != null) {
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.scZ;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() != 0) {
        break label156;
      }
      localObject = this.scZ;
      if (localObject == null) {
        break label151;
      }
    }
    label151:
    for (localObject = ((FrameLayout)localObject).getLayoutParams();; localObject = null)
    {
      localObject = (FrameLayout.LayoutParams)localObject;
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
      }
      localFrameLayout = this.scZ;
      if (localFrameLayout == null) {
        break;
      }
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(248814);
      return;
      AppMethodBeat.o(248814);
      return;
    }
    label156:
    AppMethodBeat.o(248814);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(248817);
    if ((this.sdY == paramBoolean1) && (this.sdZ == paramBoolean2) && (!this.sdX) && (this.sea == paramInt))
    {
      AppMethodBeat.o(248817);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Integer.valueOf(paramInt) });
    this.sea = paramInt;
    this.sdX = false;
    this.sdY = paramBoolean1;
    this.sdZ = paramBoolean2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localFrameLayout = this.FIf;
        if (localFrameLayout != null)
        {
          localFrameLayout.setBackground(this.sdg);
          AppMethodBeat.o(248817);
          return;
        }
        AppMethodBeat.o(248817);
        return;
      }
      localFrameLayout = this.FIf;
      if (localFrameLayout != null)
      {
        localFrameLayout.setBackground(this.sdh);
        AppMethodBeat.o(248817);
        return;
      }
      AppMethodBeat.o(248817);
      return;
    }
    FrameLayout localFrameLayout = this.FIf;
    if (localFrameLayout != null)
    {
      localFrameLayout.setBackground(this.sdi);
      AppMethodBeat.o(248817);
      return;
    }
    AppMethodBeat.o(248817);
  }
  
  private final void cwQ()
  {
    AppMethodBeat.i(248830);
    fx(scf, scf);
    AppMethodBeat.o(248830);
  }
  
  private final void cwR()
  {
    AppMethodBeat.i(248837);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      Resources localResources = getResources();
      p.j(localResources, "resources");
      int i = localResources.getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        Fs(i);
      }
    }
    AppMethodBeat.o(248837);
  }
  
  private final void cwS()
  {
    AppMethodBeat.i(248840);
    if (!this.sdP)
    {
      AppMethodBeat.o(248840);
      return;
    }
    try
    {
      if ((this.sdN.x != 0) || (this.sdN.y != 0))
      {
        Object localObject = getLayoutParams();
        if (localObject != null) {
          break label99;
        }
        localObject = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(248840);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", (Throwable)localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(248840);
      return;
    }
    label99:
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localException;
    int i;
    if (this.FIh) {
      i = 0;
    }
    for (;;)
    {
      int j = localLayoutParams.y;
      int k = this.sdN.y;
      cwT();
      this.sdQ = 16;
      cwQ();
      a(this, i, j + k, true);
      AppMethodBeat.o(248840);
      return;
      i = localLayoutParams.x;
      j = this.sdN.x;
      i += j;
    }
  }
  
  private final void cwT()
  {
    AppMethodBeat.i(248842);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.sdN.x = 0;
    this.sdN.y = 0;
    AppMethodBeat.o(248842);
  }
  
  private void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(248823);
    Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(248823);
        return;
      }
      AppMethodBeat.o(248823);
      return;
    }
    if (this.FIe != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        paramAnimatorListenerAdapter = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(248823);
        throw paramAnimatorListenerAdapter;
      }
      boolean bool = Fu(((FrameLayout.LayoutParams)localObject).leftMargin);
      localObject = this.FIe;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.animation.b.b)localObject).a(getCurrentStateWidth(), bool, paramAnimatorListenerAdapter);
        AppMethodBeat.o(248823);
        return;
      }
      AppMethodBeat.o(248823);
      return;
    }
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(248823);
      return;
    }
    AppMethodBeat.o(248823);
  }
  
  private final void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(248825);
    Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if (this.scU != null)
    {
      localValueAnimator = this.scU;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
      {
        Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
        localValueAnimator = this.scU;
        if (localValueAnimator != null) {
          localValueAnimator.cancel();
        }
      }
    }
    this.scU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator = this.scU;
    if (localValueAnimator != null) {
      localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    }
    localValueAnimator = this.scU;
    if (localValueAnimator != null) {
      localValueAnimator.setDuration(100L);
    }
    localValueAnimator = this.scU;
    if (localValueAnimator != null) {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramInt1, paramInt3, paramInt2, paramInt4));
    }
    localValueAnimator = this.scU;
    if (localValueAnimator != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new c(this));
    }
    localValueAnimator = this.scU;
    if (localValueAnimator != null)
    {
      localValueAnimator.start();
      AppMethodBeat.o(248825);
      return;
    }
    AppMethodBeat.o(248825);
  }
  
  private final void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(248813);
    if ((this.sdS == paramBoolean1) && (this.sdT == paramBoolean2) && (this.sdR == paramBoolean3) && (this.sdU != 0) && (this.sdU == this.sca))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.sdY), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.sdT), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.sdR), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.sdU), Integer.valueOf(this.sca) });
      AppMethodBeat.o(248813);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.sdU), Integer.valueOf(this.sca) });
    this.sdR = paramBoolean3;
    this.sdS = paramBoolean1;
    this.sdT = paramBoolean2;
    this.sdU = this.sca;
    cwQ();
    FrameLayout localFrameLayout = this.FIf;
    if (localFrameLayout != null)
    {
      localFrameLayout.getPaddingLeft();
      int j = localFrameLayout.getPaddingRight();
      int k = localFrameLayout.getPaddingTop();
      int m = localFrameLayout.getPaddingBottom();
      if ((this.sca & 0x20) != 0)
      {
        if (i == 0) {
          break label409;
        }
        if (!paramBoolean2) {
          break label391;
        }
      }
      label391:
      for (i = this.sdQ | 0x3;; i = this.sdQ | 0x5)
      {
        Yg(i);
        if ((!paramBoolean1) || (!paramBoolean2)) {
          break label497;
        }
        localFrameLayout = this.FIf;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.FIf;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.FIg);
        }
        Yg(this.sdQ | 0x3);
        localFrameLayout = this.scZ;
        if (localFrameLayout == null) {
          break label402;
        }
        localFrameLayout.setVisibility(0);
        AppMethodBeat.o(248813);
        return;
        i = 0;
        break;
      }
      label402:
      AppMethodBeat.o(248813);
      return;
      label409:
      if ((paramBoolean1) && (paramBoolean2))
      {
        localFrameLayout = this.FIf;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.FIf;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.FIg);
        }
        Yg(this.sdQ | 0x3);
        localFrameLayout = this.scZ;
        if (localFrameLayout != null)
        {
          localFrameLayout.setVisibility(0);
          AppMethodBeat.o(248813);
          return;
        }
      }
      label497:
      AppMethodBeat.o(248813);
      return;
    }
    AppMethodBeat.o(248813);
  }
  
  private final void fbo()
  {
    AppMethodBeat.i(248812);
    this.scb = this.sca;
    this.sca = 0;
    if (AppForegroundDelegate.fby.aax()) {
      this.sca |= 0x20;
    }
    AppMethodBeat.o(248812);
  }
  
  private final void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248831);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(248831);
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
        AppMethodBeat.o(248831);
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
  
  private final void g(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(248819);
    if (this.sak)
    {
      d(paramAnimatorListenerAdapter);
      AppMethodBeat.o(248819);
      return;
    }
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(248819);
      return;
    }
    AppMethodBeat.o(248819);
  }
  
  private final int getCurrentStateHeight()
  {
    AppMethodBeat.i(248828);
    Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(this.sca) });
    int i = scg;
    int j = f.saM;
    int k = f.saN;
    AppMethodBeat.o(248828);
    return i + j + k;
  }
  
  private final int getExtendWidth()
  {
    AppMethodBeat.i(248832);
    if (!this.sdI)
    {
      AppMethodBeat.o(248832);
      return 0;
    }
    if (!c.eI(getContext()))
    {
      AppMethodBeat.o(248832);
      return 0;
    }
    Object localObject;
    if ((getContext() instanceof Activity))
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(248832);
        throw ((Throwable)localObject);
      }
      localObject = ((Activity)localObject).getWindow();
      p.j(localObject, "(context as Activity).window");
      localObject = ((Window)localObject).getWindowManager();
      p.j(localObject, "(context as Activity).window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.j(localObject, "(context as Activity).wi…dowManager.defaultDisplay");
    }
    for (int i = ((Display)localObject).getRotation();; i = 0)
    {
      if (((this.FIh) && (i == 1)) || ((!this.FIh) && (i == 3)))
      {
        i = c.aM(getContext());
        AppMethodBeat.o(248832);
        return i;
      }
      AppMethodBeat.o(248832);
      return 0;
    }
  }
  
  private final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(248826);
    int i = 0;
    if (!this.FIh) {
      i = this.sdD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(248826);
    return i;
  }
  
  private final void setFloatBallAlphaInternal(float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(248820);
    setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      i = 8;
    }
    for (;;)
    {
      setVisibility(i);
      AppMethodBeat.o(248820);
      return;
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    }
  }
  
  public final void C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(248816);
    this.FIh = Fu(paramInt1);
    a(paramBoolean, this.FIh, false, this.sca);
    e(paramBoolean, this.FIh, false);
    Y(paramInt2, paramBoolean);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(this.FIh) });
    AppMethodBeat.o(248816);
  }
  
  final boolean Fu(int paramInt)
  {
    AppMethodBeat.i(248818);
    if (getCurrentStateWidth() / 2 + paramInt <= this.sdD.x / 2)
    {
      AppMethodBeat.o(248818);
      return true;
    }
    AppMethodBeat.o(248818);
    return false;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(248843);
    p.k(paramd, "listener");
    this.listeners.add(paramd);
    AppMethodBeat.o(248843);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(248811);
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, multiTaskInfo:%s", new Object[] { paramMultiTaskInfo });
    fbo();
    paramMultiTaskInfo = getLayoutParams();
    if (paramMultiTaskInfo == null)
    {
      paramMultiTaskInfo = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(248811);
      throw paramMultiTaskInfo;
    }
    boolean bool = Fu(((ViewGroup.MarginLayoutParams)paramMultiTaskInfo).leftMargin);
    e(true, bool, false);
    a(true, bool, false, this.sca);
    g(paramAnimatorListenerAdapter);
    AppMethodBeat.o(248811);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(248824);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(248824);
        return;
      }
      AppMethodBeat.o(248824);
      return;
    }
    com.tencent.mm.plugin.multitask.animation.b.b localb;
    if ((paramBoolean1) && (this.FIe != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with trans animation");
      localb = this.FIe;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(248824);
        return;
      }
      AppMethodBeat.o(248824);
      return;
    }
    if ((paramBoolean2) && (this.FIe != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with alpha animation");
      localb = this.FIe;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(248824);
        return;
      }
      AppMethodBeat.o(248824);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "hide without animation");
    setVisibility(8);
    cwS();
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(248824);
      return;
    }
    AppMethodBeat.o(248824);
  }
  
  final int getCurrentStateWidth()
  {
    AppMethodBeat.i(248827);
    Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(this.sca) });
    int i = scf;
    int j = f.saO;
    AppMethodBeat.o(248827);
    return i + j;
  }
  
  public final float getPosYPercentOfScreen()
  {
    return this.sdG;
  }
  
  public final int getPositionY()
  {
    return this.sdH;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(248807);
    super.onAttachedToWindow();
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(248807);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    C(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, true);
    AppMethodBeat.o(248807);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(248809);
    p.k(paramConfiguration, "newConfig");
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    Fs(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.listeners.iterator();
    while (paramConfiguration.hasNext()) {
      ((d)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(248809);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(248808);
    super.onDetachedFromWindow();
    if (this.scU != null)
    {
      ValueAnimator localValueAnimator = this.scU;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.scU = null;
    }
    AppMethodBeat.o(248808);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(248834);
    super.setAlpha(paramFloat);
    Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    cwR();
    AppMethodBeat.o(248834);
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.sak = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(248833);
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.sdB = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(248833);
      return;
    }
    if (i == 1)
    {
      this.sdB = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cwR();
    }
    AppMethodBeat.o(248833);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(MultiTaskFloatBallView paramMultiTaskFloatBallView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(248952);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(248952);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = paramInt1;
      int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
      int k = paramInt2;
      int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
      MultiTaskFloatBallView.a(this.FIj, i + j, m + k, false);
      AppMethodBeat.o(248952);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView$startStickyAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(249151);
      p.k(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.FIj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(249151);
        throw paramAnimator;
      }
      paramAnimator = (ViewGroup.MarginLayoutParams)paramAnimator;
      this.FIj.C(paramAnimator.leftMargin, paramAnimator.topMargin, true);
      AppMethodBeat.o(249151);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView
 * JD-Core Version:    0.7.0.1
 */