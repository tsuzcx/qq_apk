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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "backgroundDrawableCenter", "Landroid/graphics/drawable/Drawable;", "backgroundDrawableCenterPressed", "backgroundDrawableLeft", "backgroundDrawableLeftPressed", "backgroundDrawableRight", "backgroundDrawableRightPressed", "ballRootView", "canResetExtraSize", "", "currentBallRootViewVerticalGravity", "currentLayoutState", "currentPassiveCount", "currentStateHeight", "getCurrentStateHeight", "()I", "currentStateWidth", "getCurrentStateWidth", "customView", "Landroid/view/View;", "customViewMargin", "customViewSize", "Landroid/graphics/Point;", "enableClick", "extendWidth", "getExtendWidth", "extraSize", "fingerPosOnDown", "Landroid/graphics/PointF;", "innerView", "<set-?>", "isFloatBallViewDockLeft", "()Z", "isTouchEnabled", "lastBackgroundDockLeft", "lastBackgroundManual", "lastBackgroundSettled", "lastBackgroundState", "lastClickTime", "", "lastLayoutDockLeft", "lastLayoutManual", "lastLayoutSettled", "lastLayoutState", "lastOrientation", "listeners", "", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "mLayoutTransition", "Landroid/animation/LayoutTransition;", "needTranslateAnimation", "otherContentView", "", "posYPercentOfScreen", "getPosYPercentOfScreen", "()F", "positionY", "getPositionY", "previousLayoutState", "scaleTouchSlop", "screenResolution", "stickyAnimator", "Landroid/animation/ValueAnimator;", "targetPositionXWhenOrientationChanged", "getTargetPositionXWhenOrientationChanged", "uiHandler", "Landroid/os/Handler;", "viewPosOnDown", "widthNeedExtend", "addFloatBallViewListener", "", "listener", "checkDoTranslateAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "checkOrientationIfNeed", "doUpdateFloatBallViewLayout", "isSettled", "isDockLeft", "getStateHeight", "getStateWidth", "getTargetPositionX", "startPositionX", "getTargetPositionY", "startPositionY", "getViewHeightWithoutVoip", "state", "getViewWidthWithoutVoip", "hasActiveState", "hasAppBrandVOIPState", "hasAudioState", "hasCustomViewState", "hasFourPassiveState", "hasOnePassiveState", "hasPassiveState", "hasThreePassiveState", "hasTwoPassiveState", "hasVOIPMultiTalkAudioState", "hasVOIPMultiTalkVideoState", "hasVideoState", "hide", "withTransAnimation", "withAlphaAnimation", "hideByTranslation", "inActiveFourPassiveState", "inActiveOnePassiveState", "inActiveState", "inActiveThreePassiveState", "inActiveTwoPassiveState", "inAudioState", "inCustomViewActiveState", "inFourPassiveState", "inOnePassiveState", "inThreePassiveState", "inTwoPassiveState", "inVideoState", "init", "isAnimating", "isPositionLeft", "positionX", "isWechatInForeground", "markWechatInForeground", "inForeground", "notifyBallPositionChanged", "x", "y", "isManual", "notifyOrientationChange", "orientation", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "processOrientationChanged", "newOrientation", "quickHide", "quickShow", "removeFloatBallViewListener", "resetExtraSize", "resetFloatBallViewSizeAndPosition", "setAlpha", "alpha", "setFloatBallAlphaInternal", "setNeedTranslateAnimation", "setVisibility", "visibility", "show", "withAnimation", "checkVisible", "showByTranslation", "startStickyAnimation", "stickToLeft", "targetPositionX", "targetPositionY", "updateBallPosition", "needNotify", "updateBallRootViewLayout", "gravity", "updateFloatBallBackground", "updateFloatBallViewLayout", "forceUpdate", "updateFloatBallViewLayoutState", "updateFloatBallViewSize", "viewWidth", "viewHeight", "notify", "updatePosYPercentOfScreen", "Companion", "plugin-multitask_release"})
public final class MultiTaskFloatBallView
  extends FrameLayout
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final MultiTaskFloatBallView.a Acs;
  private static final int pae;
  private static final int paf;
  public com.tencent.mm.plugin.multitask.animation.b.b Aco;
  private FrameLayout Acp;
  private LayoutTransition Acq;
  private boolean Acr;
  private final Handler cPw;
  private int lastOrientation;
  private final Set<d> listeners;
  boolean oYj;
  private int oZZ;
  private int paR;
  private ValueAnimator paU;
  private FrameLayout paZ;
  private int paa;
  private boolean pbB;
  private Point pbD;
  private final PointF pbE;
  private final Point pbF;
  private float pbG;
  private int pbH;
  private boolean pbI;
  private final boolean pbK;
  private final Point pbN;
  private final boolean pbP;
  private int pbQ;
  private boolean pbR;
  private boolean pbS;
  private boolean pbT;
  private int pbU;
  private boolean pbX;
  private boolean pbY;
  private boolean pbZ;
  private Drawable pbg;
  private final Drawable pbh;
  private final Drawable pbi;
  private int pca;
  
  static
  {
    AppMethodBeat.i(200691);
    Acs = new MultiTaskFloatBallView.a((byte)0);
    pae = a.aH(MMApplicationContext.getContext(), 2131166388);
    paf = a.aH(MMApplicationContext.getContext(), 2131166387);
    AppMethodBeat.o(200691);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public MultiTaskFloatBallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200689);
    this.listeners = ((Set)new CopyOnWriteArraySet());
    this.pbD = new Point();
    this.pbE = new PointF();
    this.pbF = new Point();
    this.pbG = -1.0F;
    this.pbK = true;
    this.pbN = new Point();
    this.pbQ = 16;
    this.cPw = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131495179, (ViewGroup)this);
    this.pbg = a.l(paramContext, 2131232782);
    this.Acp = ((FrameLayout)findViewById(2131297255));
    this.paZ = ((FrameLayout)findViewById(2131305726));
    this.Aco = new com.tencent.mm.plugin.multitask.animation.b.b((View)this);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    p.g(paramAttributeSet, "ViewConfiguration.get(context)");
    this.paR = paramAttributeSet.getScaledTouchSlop();
    paramAttributeSet = ao.az(paramContext);
    p.g(paramAttributeSet, "UIUtils.getDisplayRealSize(context)");
    this.pbD = paramAttributeSet;
    if ((ao.gJN()) && (aw.kB(paramContext))) {
      this.pbD.x = ao.getDeviceWidth();
    }
    if (ao.gJK()) {
      this.pbD.x = ao.getDeviceHeight();
    }
    this.Acq = new LayoutTransition();
    paramContext = this.Acp;
    if (paramContext != null) {
      paramContext.setLayoutTransition(this.Acq);
    }
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.lastOrientation = paramContext.getConfiguration().orientation;
    AppMethodBeat.o(200689);
  }
  
  private final void BR(int paramInt)
  {
    AppMethodBeat.i(200663);
    Point localPoint1 = this.pbD;
    Object localObject = ao.az(getContext());
    p.g(localObject, "UIUtils.getDisplayRealSize(context)");
    this.pbD = ((Point)localObject);
    if ((ao.gJN()) && (aw.kB(getContext()))) {
      this.pbD.x = ao.getDeviceWidth();
    }
    if (ao.gJK()) {
      this.pbD.x = ao.getDeviceHeight();
    }
    Point localPoint2 = this.pbD;
    if (localPoint1 == null) {}
    for (localObject = "null";; localObject = localPoint1)
    {
      Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", new Object[] { localPoint2, localObject });
      int i;
      int j;
      int k;
      if ((this.lastOrientation != paramInt) || ((localPoint1 != null) && ((localPoint1.x != this.pbD.x) || (localPoint1.y != this.pbD.y))))
      {
        this.lastOrientation = paramInt;
        this.pbI = true;
        localObject = getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(200663);
          throw ((Throwable)localObject);
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        paramInt = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        i = (int)(this.pbD.y * this.pbG);
        paramInt = Math.max(Math.min(paramInt, this.pbD.x), 0);
        i = Math.max(Math.min(i, this.pbD.y), 0);
        j = getTargetPositionXWhenOrientationChanged();
        k = BU(i);
        if (j != 0) {
          break label371;
        }
      }
      label371:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).leftMargin), Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).topMargin), Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        d(bool, paramInt, i, j, k);
        AppMethodBeat.o(200663);
        return;
      }
    }
  }
  
  private static int BU(int paramInt)
  {
    int i;
    if (paramInt < f.oYS) {
      i = f.oYS;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= f.oYT);
    return f.oYT;
  }
  
  private final void RO(int paramInt)
  {
    AppMethodBeat.i(200667);
    Object localObject = this.Acp;
    if (localObject != null) {}
    for (localObject = ((FrameLayout)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(200667);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
    FrameLayout localFrameLayout = this.Acp;
    if (localFrameLayout != null) {
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.paZ;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() != 0) {
        break label156;
      }
      localObject = this.paZ;
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
      localFrameLayout = this.paZ;
      if (localFrameLayout == null) {
        break;
      }
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(200667);
      return;
      AppMethodBeat.o(200667);
      return;
    }
    label156:
    AppMethodBeat.o(200667);
  }
  
  private final void Y(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.pbG = (paramInt / this.pbD.y);
    }
    this.pbH = paramInt;
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(200670);
    if ((this.pbY == paramBoolean1) && (this.pbZ == paramBoolean2) && (!this.pbX) && (this.pca == paramInt))
    {
      AppMethodBeat.o(200670);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Integer.valueOf(paramInt) });
    this.pca = paramInt;
    this.pbX = false;
    this.pbY = paramBoolean1;
    this.pbZ = paramBoolean2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localFrameLayout = this.Acp;
        if (localFrameLayout != null)
        {
          localFrameLayout.setBackground(this.pbg);
          AppMethodBeat.o(200670);
          return;
        }
        AppMethodBeat.o(200670);
        return;
      }
      localFrameLayout = this.Acp;
      if (localFrameLayout != null)
      {
        localFrameLayout.setBackground(this.pbh);
        AppMethodBeat.o(200670);
        return;
      }
      AppMethodBeat.o(200670);
      return;
    }
    FrameLayout localFrameLayout = this.Acp;
    if (localFrameLayout != null)
    {
      localFrameLayout.setBackground(this.pbi);
      AppMethodBeat.o(200670);
      return;
    }
    AppMethodBeat.o(200670);
  }
  
  private final void cjA()
  {
    AppMethodBeat.i(200685);
    if (((int)getAlpha() == 1) && (getVisibility() == 0))
    {
      Resources localResources = getResources();
      p.g(localResources, "resources");
      int i = localResources.getConfiguration().orientation;
      if (i != this.lastOrientation)
      {
        Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lastOrientation) });
        BR(i);
      }
    }
    AppMethodBeat.o(200685);
  }
  
  private final void cjB()
  {
    AppMethodBeat.i(200686);
    if (!this.pbP)
    {
      AppMethodBeat.o(200686);
      return;
    }
    try
    {
      if ((this.pbN.x != 0) || (this.pbN.y != 0))
      {
        Object localObject = getLayoutParams();
        if (localObject != null) {
          break label99;
        }
        localObject = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        AppMethodBeat.o(200686);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallView", (Throwable)localException, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
      AppMethodBeat.o(200686);
      return;
    }
    label99:
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localException;
    int i;
    if (this.Acr) {
      i = 0;
    }
    for (;;)
    {
      int j = localLayoutParams.y;
      int k = this.pbN.y;
      cjC();
      this.pbQ = 16;
      cjz();
      a(this, i, j + k, true);
      AppMethodBeat.o(200686);
      return;
      i = localLayoutParams.x;
      j = this.pbN.x;
      i += j;
    }
  }
  
  private final void cjC()
  {
    AppMethodBeat.i(200687);
    Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
    this.pbN.x = 0;
    this.pbN.y = 0;
    AppMethodBeat.o(200687);
  }
  
  private final void cjz()
  {
    AppMethodBeat.i(200680);
    eY(pae, pae);
    AppMethodBeat.o(200680);
  }
  
  private void d(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200674);
    Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
    setNeedTranslateAnimation(false);
    if (getVisibility() == 0)
    {
      Log.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200674);
        return;
      }
      AppMethodBeat.o(200674);
      return;
    }
    if (this.Aco != null)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        paramAnimatorListenerAdapter = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(200674);
        throw paramAnimatorListenerAdapter;
      }
      boolean bool = BT(((FrameLayout.LayoutParams)localObject).leftMargin);
      localObject = this.Aco;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.animation.b.b)localObject).a(getCurrentStateWidth(), bool, paramAnimatorListenerAdapter);
        AppMethodBeat.o(200674);
        return;
      }
      AppMethodBeat.o(200674);
      return;
    }
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(200674);
      return;
    }
    AppMethodBeat.o(200674);
  }
  
  private final void d(boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(200676);
    Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
    if (this.paU != null)
    {
      localValueAnimator = this.paU;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
      {
        Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
        localValueAnimator = this.paU;
        if (localValueAnimator != null) {
          localValueAnimator.cancel();
        }
      }
    }
    this.paU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator = this.paU;
    if (localValueAnimator != null) {
      localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    }
    localValueAnimator = this.paU;
    if (localValueAnimator != null) {
      localValueAnimator.setDuration(100L);
    }
    localValueAnimator = this.paU;
    if (localValueAnimator != null) {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramInt1, paramInt3, paramInt2, paramInt4));
    }
    localValueAnimator = this.paU;
    if (localValueAnimator != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new c(this));
    }
    localValueAnimator = this.paU;
    if (localValueAnimator != null)
    {
      localValueAnimator.start();
      AppMethodBeat.o(200676);
      return;
    }
    AppMethodBeat.o(200676);
  }
  
  private final void eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200681);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(200681);
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
        AppMethodBeat.o(200681);
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
  
  private final void erl()
  {
    AppMethodBeat.i(200665);
    this.paa = this.oZZ;
    this.oZZ = 0;
    if (AppForegroundDelegate.djR.Wc()) {
      this.oZZ |= 0x20;
    }
    AppMethodBeat.o(200665);
  }
  
  private final void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(200666);
    if ((this.pbS == paramBoolean1) && (this.pbT == paramBoolean2) && (this.pbR == paramBoolean3) && (this.pbU != 0) && (this.pbU == this.oZZ))
    {
      Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", new Object[] { Boolean.valueOf(this.pbY), Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.pbT), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.pbR), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ) });
      AppMethodBeat.o(200666);
      return;
    }
    Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ) });
    this.pbR = paramBoolean3;
    this.pbS = paramBoolean1;
    this.pbT = paramBoolean2;
    this.pbU = this.oZZ;
    cjz();
    FrameLayout localFrameLayout = this.Acp;
    if (localFrameLayout != null)
    {
      localFrameLayout.getPaddingLeft();
      int j = localFrameLayout.getPaddingRight();
      int k = localFrameLayout.getPaddingTop();
      int m = localFrameLayout.getPaddingBottom();
      if ((this.oZZ & 0x20) != 0)
      {
        if (i == 0) {
          break label409;
        }
        if (!paramBoolean2) {
          break label391;
        }
      }
      label391:
      for (i = this.pbQ | 0x3;; i = this.pbQ | 0x5)
      {
        RO(i);
        if ((!paramBoolean1) || (!paramBoolean2)) {
          break label497;
        }
        localFrameLayout = this.Acp;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.Acp;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.Acq);
        }
        RO(this.pbQ | 0x3);
        localFrameLayout = this.paZ;
        if (localFrameLayout == null) {
          break label402;
        }
        localFrameLayout.setVisibility(0);
        AppMethodBeat.o(200666);
        return;
        i = 0;
        break;
      }
      label402:
      AppMethodBeat.o(200666);
      return;
      label409:
      if ((paramBoolean1) && (paramBoolean2))
      {
        localFrameLayout = this.Acp;
        if (localFrameLayout != null) {
          localFrameLayout.setPadding(getExtendWidth(), k, j, m);
        }
        localFrameLayout = this.Acp;
        if (localFrameLayout != null) {
          localFrameLayout.setLayoutTransition(this.Acq);
        }
        RO(this.pbQ | 0x3);
        localFrameLayout = this.paZ;
        if (localFrameLayout != null)
        {
          localFrameLayout.setVisibility(0);
          AppMethodBeat.o(200666);
          return;
        }
      }
      label497:
      AppMethodBeat.o(200666);
      return;
    }
    AppMethodBeat.o(200666);
  }
  
  private final void g(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200672);
    if (this.oYj)
    {
      d(paramAnimatorListenerAdapter);
      AppMethodBeat.o(200672);
      return;
    }
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(200672);
      return;
    }
    AppMethodBeat.o(200672);
  }
  
  private final int getCurrentStateHeight()
  {
    AppMethodBeat.i(200679);
    Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", new Object[] { Integer.valueOf(this.oZZ) });
    int i = paf;
    int j = f.oYL;
    int k = f.oYM;
    AppMethodBeat.o(200679);
    return i + j + k;
  }
  
  private final int getExtendWidth()
  {
    AppMethodBeat.i(200682);
    if (!this.pbI)
    {
      AppMethodBeat.o(200682);
      return 0;
    }
    if (!c.eF(getContext()))
    {
      AppMethodBeat.o(200682);
      return 0;
    }
    Object localObject;
    if ((getContext() instanceof Activity))
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(200682);
        throw ((Throwable)localObject);
      }
      localObject = ((Activity)localObject).getWindow();
      p.g(localObject, "(context as Activity).window");
      localObject = ((Window)localObject).getWindowManager();
      p.g(localObject, "(context as Activity).window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "(context as Activity).wi…dowManager.defaultDisplay");
    }
    for (int i = ((Display)localObject).getRotation();; i = 0)
    {
      if (((this.Acr) && (i == 1)) || ((!this.Acr) && (i == 3)))
      {
        i = c.aP(getContext());
        AppMethodBeat.o(200682);
        return i;
      }
      AppMethodBeat.o(200682);
      return 0;
    }
  }
  
  private final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(200677);
    int i = 0;
    if (!this.Acr) {
      i = this.pbD.x - getCurrentStateWidth();
    }
    AppMethodBeat.o(200677);
    return i;
  }
  
  private static int getViewHeightWithoutVoip$134621()
  {
    return paf;
  }
  
  private static int getViewWidthWithoutVoip$134621()
  {
    return pae;
  }
  
  private final void setFloatBallAlphaInternal(float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(200673);
    setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
      i = 8;
    }
    for (;;)
    {
      setVisibility(i);
      AppMethodBeat.o(200673);
      return;
      Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", new Object[] { Float.valueOf(paramFloat) });
    }
  }
  
  final boolean BT(int paramInt)
  {
    AppMethodBeat.i(200671);
    if (getCurrentStateWidth() / 2 + paramInt <= this.pbD.x / 2)
    {
      AppMethodBeat.o(200671);
      return true;
    }
    AppMethodBeat.o(200671);
    return false;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(200688);
    p.h(paramd, "listener");
    this.listeners.add(paramd);
    AppMethodBeat.o(200688);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200664);
    Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, multiTaskInfo:%s", new Object[] { paramMultiTaskInfo });
    erl();
    paramMultiTaskInfo = getLayoutParams();
    if (paramMultiTaskInfo == null)
    {
      paramMultiTaskInfo = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(200664);
      throw paramMultiTaskInfo;
    }
    boolean bool = BT(((ViewGroup.MarginLayoutParams)paramMultiTaskInfo).leftMargin);
    f(true, bool, false);
    a(true, bool, false, this.oZZ);
    g(paramAnimatorListenerAdapter);
    AppMethodBeat.o(200664);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200675);
    if (getVisibility() == 8)
    {
      Log.i("MicroMsg.FloatBallView", "float ball already hide");
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200675);
        return;
      }
      AppMethodBeat.o(200675);
      return;
    }
    com.tencent.mm.plugin.multitask.animation.b.b localb;
    if ((paramBoolean1) && (this.Aco != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with trans animation");
      localb = this.Aco;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(200675);
        return;
      }
      AppMethodBeat.o(200675);
      return;
    }
    if ((paramBoolean2) && (this.Aco != null))
    {
      Log.i("MicroMsg.FloatBallView", "hide with alpha animation");
      localb = this.Aco;
      if (localb != null)
      {
        localb.a(getCurrentStateWidth(), paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(200675);
        return;
      }
      AppMethodBeat.o(200675);
      return;
    }
    Log.i("MicroMsg.FloatBallView", "hide without animation");
    setVisibility(8);
    cjB();
    if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
      AppMethodBeat.o(200675);
      return;
    }
    AppMethodBeat.o(200675);
  }
  
  final int getCurrentStateWidth()
  {
    AppMethodBeat.i(200678);
    Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", new Object[] { Integer.valueOf(this.oZZ) });
    int i = pae;
    int j = f.oYN;
    AppMethodBeat.o(200678);
    return i + j;
  }
  
  public final float getPosYPercentOfScreen()
  {
    return this.pbG;
  }
  
  public final int getPositionY()
  {
    return this.pbH;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(200660);
    super.onAttachedToWindow();
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(200660);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    y(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, true);
    AppMethodBeat.o(200660);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200662);
    p.h(paramConfiguration, "newConfig");
    Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lastOrientation) });
    BR(paramConfiguration.orientation);
    int i = paramConfiguration.orientation;
    paramConfiguration = this.listeners.iterator();
    while (paramConfiguration.hasNext()) {
      ((d)paramConfiguration.next()).onOrientationChange(i);
    }
    AppMethodBeat.o(200662);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(200661);
    super.onDetachedFromWindow();
    if (this.paU != null)
    {
      ValueAnimator localValueAnimator = this.paU;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.paU = null;
    }
    AppMethodBeat.o(200661);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(200684);
    super.setAlpha(paramFloat);
    Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", new Object[] { Float.valueOf(paramFloat) });
    cjA();
    AppMethodBeat.o(200684);
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    this.oYj = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200683);
    super.setVisibility(paramInt);
    int i = (int)getAlpha();
    if (i == 0)
    {
      this.pbB = false;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(200683);
      return;
    }
    if (i == 1)
    {
      this.pbB = true;
      Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      cjA();
    }
    AppMethodBeat.o(200683);
  }
  
  public final void y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(200669);
    this.Acr = BT(paramInt1);
    a(paramBoolean, this.Acr, false, this.oZZ);
    f(paramBoolean, this.Acr, false);
    Y(paramInt2, paramBoolean);
    Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.FALSE, Boolean.valueOf(this.Acr) });
    AppMethodBeat.o(200669);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(MultiTaskFloatBallView paramMultiTaskFloatBallView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200658);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(200658);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = paramInt1;
      int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
      int k = paramInt2;
      int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
      MultiTaskFloatBallView.a(this.Act, i + j, m + k, false);
      AppMethodBeat.o(200658);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView$startStickyAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200659);
      p.h(paramAnimator, "animation");
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.Act.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(200659);
        throw paramAnimator;
      }
      paramAnimator = (ViewGroup.MarginLayoutParams)paramAnimator;
      this.Act.y(paramAnimator.leftMargin, paramAnimator.topMargin, true);
      AppMethodBeat.o(200659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView
 * JD-Core Version:    0.7.0.1
 */