package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundOpContainer", "Landroid/widget/LinearLayout;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "backgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedDialogHeight", "fixedDialogHeightRate", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "attachWebView", "webView", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFixedWebViewHeight", "dialogHeight", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initBackgroundOpView", "initDialogBg", "initMoveOffsetXFactor", "initWebViewHeight", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "view", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundOpView", "opView", "setBackgroundTouchListener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setCanceledOnTouchOutside", "cancel", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"})
public abstract class BaseBoxDialogView
  extends RelativeLayout
{
  public static final BaseBoxDialogView.b CBX = new BaseBoxDialogView.b((byte)0);
  private boolean CAL;
  private int CBA;
  private int CBB;
  public boolean CBC = true;
  private int CBD;
  private int CBE;
  private int CBF;
  private boolean CBG;
  private int CBH;
  private int CBI;
  private float CBJ;
  private float CBK;
  private float CBL = 1.0F;
  private boolean CBM = true;
  private boolean CBN;
  private boolean CBO;
  private boolean CBP;
  private boolean CBQ = true;
  private boolean CBS = true;
  a CBT = new a();
  private a CBU = new a();
  final DecelerateInterpolator CBV = new DecelerateInterpolator();
  int CBW;
  private float CBd;
  private float CBe;
  private float CBf;
  private VelocityTracker CBg;
  e CBh;
  private View CBi;
  View CBj;
  BoxWebViewContainer CBk;
  private View CBl;
  private LinearLayout CBm;
  MMWebView CBn;
  private f CBo;
  private c CBp;
  private d CBq;
  private b CBr;
  private float CBs;
  private float CBt;
  private int CBu;
  private float CBv;
  private float CBw;
  float CBx;
  private int CBy;
  private int CBz;
  final ValueAnimator animator = new ValueAnimator();
  private boolean ddZ;
  boolean isAnimating;
  private int lastOrientation;
  private int mEY;
  private int mStatusBarHeight;
  private int nmS;
  private float onW;
  boolean yPa;
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFitsSystemWindows(true);
    paramAttributeSet = getResources();
    p.g(paramAttributeSet, "resources");
    this.lastOrientation = paramAttributeSet.getConfiguration().orientation;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    p.g(paramAttributeSet, "view");
    eP(paramAttributeSet);
    View localView = paramAttributeSet.findViewById(2131299644);
    p.g(localView, "view.findViewById(R.id.dialog_container)");
    this.CBj = localView;
    localView = paramAttributeSet.findViewById(2131299641);
    p.g(localView, "view.findViewById(R.id.dialog_bg)");
    this.CBi = localView;
    localView = paramAttributeSet.findViewById(2131310385);
    p.g(localView, "view.findViewById(R.id.webview_container)");
    this.CBk = ((BoxWebViewContainer)localView);
    this.CBl = eQ(paramAttributeSet);
    this.CBm = ((LinearLayout)paramAttributeSet.findViewById(2131297174));
    paramAttributeSet = this.CBm;
    if (paramAttributeSet != null) {
      paramAttributeSet.setVisibility(8);
    }
    this.nmS = au.aD(paramContext);
    ePa();
    paramAttributeSet = this.CBl;
    if (paramAttributeSet == null) {
      p.btv("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new BaseBoxDialogView.j(this));
    this.mStatusBarHeight = au.getStatusBarHeight(paramContext);
    this.mEY = (a.jo(paramContext) + this.mStatusBarHeight);
    this.CBy = getCloseLayoutHeight();
    this.CBA = a.fromDPToPix(paramContext, 50);
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lastOrientation), Integer.valueOf(this.mEY), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.CBA) });
    paramContext = this.CBj;
    if (paramContext == null) {
      p.btv("dialogContainer");
    }
    paramContext.setTranslationY(this.mEY);
    ePb();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void bP(float paramFloat)
  {
    View localView = this.CBj;
    if (localView == null) {
      p.btv("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bQ(paramFloat);
  }
  
  private final void bQ(float paramFloat)
  {
    float f = 1.0F * paramFloat / this.CBu;
    Object localObject = this.CBo;
    if (localObject != null) {
      ((f)localObject).c(this.CBW, paramFloat, f);
    }
    localObject = this.CBm;
    int i;
    if (localObject != null)
    {
      b localb = this.CBr;
      if (localb != null)
      {
        i = localb.getVieHeight();
        ((LinearLayout)localObject).setTranslationY(paramFloat - i);
      }
    }
    else
    {
      i = this.CBu;
      localObject = this.CBr;
      if (localObject == null) {
        break label139;
      }
    }
    label139:
    for (localObject = Integer.valueOf(((b)localObject).getVieHeight());; localObject = null)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f, dialogHeight: %s, backgroundOpViewHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), localObject });
      return;
      i = 0;
      break;
    }
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    if (!this.CBP)
    {
      this.CBP = true;
      localObject = this.CBo;
      if (localObject != null) {
        ((f)localObject).ePg();
      }
    }
    Object localObject = this.CBn;
    int i;
    label135:
    float f1;
    if (localObject != null)
    {
      i = ((MMWebView)localObject).getScrollHeight();
      this.CBD = i;
      if ((!ePc()) || (this.CBE <= this.CBI)) {
        break label310;
      }
      i = Math.max(this.CBI, this.CBF);
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.CBI), Integer.valueOf(i) });
      this.CBw = Math.max(this.CBw, this.CBE - i);
      if (!paramBoolean) {
        break label387;
      }
      f1 = 0.68F * paramFloat;
      label145:
      float f2 = this.CBv;
      f2 = Math.max(this.CBw, f2 + f1);
      f2 = Math.min(this.CBu, f2);
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.CBv), Float.valueOf(f2), Float.valueOf(this.CBw) });
      this.CBK = f1;
      bP(f2);
      if (f1 < 0.0F) {
        break label396;
      }
      paramFloat = this.CBv;
      f1 = this.CBu;
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.CBs, 0.0F));
    }
    label310:
    while (this.CBv <= 0.0F)
    {
      return;
      i = 0;
      break;
      if (this.CBE <= this.CBD) {
        break label135;
      }
      i = Math.max(this.CBD, this.CBF);
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.CBD), Integer.valueOf(i) });
      this.CBw = Math.max(this.CBw, this.CBE - i);
      break label135;
      f1 = 0.85F * paramFloat;
      break label145;
    }
    label387:
    label396:
    paramFloat = this.CBv;
    localObject = this.CBj;
    if (localObject == null) {
      p.btv("dialogContainer");
    }
    setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.CBU.CBY, this.CBU.CBZ));
  }
  
  private final void d(View paramView, int paramInt, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView != null)
    {
      localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label48;
      }
      localLayoutParams.height = paramInt;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      if (paramBoolean) {
        post((Runnable)new BaseBoxDialogView.n(paramView));
      }
      return;
      label48:
      localLayoutParams = null;
    }
  }
  
  private final void ePa()
  {
    View localView = this.CBi;
    if (localView == null) {
      p.btv("dialogBg");
    }
    localView.setOnClickListener((View.OnClickListener)new BaseBoxDialogView.k(this));
  }
  
  private final void ePb()
  {
    if ((getContext() instanceof Activity))
    {
      Rect localRect = new Rect();
      Object localObject = getContext();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.app.Activity");
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).getWindowVisibleDisplayFrame(localRect);
        }
      }
      this.CBz = localRect.height();
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { localRect, Integer.valueOf(localRect.height()), Integer.valueOf(this.CBz), Integer.valueOf(this.nmS) });
    }
  }
  
  private final boolean ePc()
  {
    return (this.CBG) && ((this.CBH > 0) || (this.CBJ > 0.0F));
  }
  
  private final boolean ePd()
  {
    return (this.CBK > 0.0F) && (Math.abs(this.CBK) >= this.CBE * 0.15F);
  }
  
  private final boolean ePe()
  {
    return (this.CBK < 0.0F) && (Math.abs(this.CBK) >= this.CBE * 0.05F);
  }
  
  private final boolean ePf()
  {
    return (this.CBK > 0.0F) && (Math.abs(this.CBK) >= this.CBE * 0.15F);
  }
  
  private final void f(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      Log.w("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      return;
    }
    Object localObject = this.CBq;
    if (localObject != null) {}
    for (final float f = ((d)localObject).getBackgroundTransY();; f = 0.0F)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      p.g(localObject, "animator");
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new d(this, paramBoolean));
      ((ValueAnimator)localObject).start();
      return;
    }
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    d locald = this.CBq;
    if (locald != null) {
      locald.setBackgroundTransY(paramFloat);
    }
    locald = this.CBq;
    if (locald != null) {
      locald.setMarkViewTransY(this.CBt + paramFloat);
    }
  }
  
  public final void Wr(final int paramInt)
  {
    float f2 = getMaxTranslationY();
    Object localObject = this.CBq;
    if (localObject != null) {}
    for (final float f1 = ((d)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      this.ddZ = false;
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(f2);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new h(this, paramInt));
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new i(this, f1));
                if (localObject != null) {
                  ((ViewPropertyAnimator)localObject).start();
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public void eP(View paramView)
  {
    p.h(paramView, "view");
  }
  
  public abstract View eQ(View paramView);
  
  public abstract int getCloseLayoutHeight();
  
  public abstract int getLayoutId();
  
  final int getMaxTranslationY()
  {
    return this.CBu;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null) {}
    for (Integer localInteger = Integer.valueOf(paramConfiguration.orientation);; localInteger = null)
    {
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", new Object[] { localInteger, Integer.valueOf(this.lastOrientation) });
      int i = this.lastOrientation;
      if ((paramConfiguration == null) || (i != paramConfiguration.orientation)) {
        ePb();
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool2) {
        break label59;
      }
      bool1 = bool2;
    }
    label59:
    while (paramMotionEvent == null)
    {
      return bool1;
      localObject = null;
      break;
    }
    if (this.CBg == null) {
      this.CBg = VelocityTracker.obtain();
    }
    Object localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Boolean.valueOf(this.CBQ), Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.CBN), Boolean.valueOf(this.CBO) });
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.CBe = paramMotionEvent.getRawX();
      this.CBf = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.CBe;
      f2 = paramMotionEvent.getRawY() - this.CBf;
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.CBQ) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.CBv) });
          if (this.CBv <= this.CBw) {
            if (this.CBM) {
              if (f2 >= 0.0F) {
                bool2 = true;
              }
            }
          }
          for (;;)
          {
            bool1 = bool2;
            if (!bool2) {
              break;
            }
            this.CBN = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.CAL) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.CBe <= 20.0F)) {}
        for (bool2 = true;; bool2 = false)
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.CBe), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.CBO = true;
          bool1 = bool2;
          break;
        }
      }
      bool1 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f3 = 0.0F;
    super.onMeasure(paramInt1, paramInt2);
    if (this.CBz == 0) {
      ePb();
    }
    Object localObject1 = this.CBj;
    if (localObject1 == null) {
      p.btv("dialogContainer");
    }
    boolean bool2;
    boolean bool1;
    if ((((View)localObject1).getMeasuredHeight() != this.CBu) && (this.CBC))
    {
      localObject1 = this.CBj;
      if (localObject1 == null) {
        p.btv("dialogContainer");
      }
      this.CBu = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.CBz - this.CBu);
      this.CBB = Math.max(0, this.CBA - paramInt1);
      if (ePc())
      {
        localObject1 = getContext();
        p.g(localObject1, "context");
        this.CBB = ((Context)localObject1).getResources().getDimensionPixelSize(2131165314);
      }
      this.CBE = (this.CBu - this.CBy - this.CBB);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d, fixedDialogHeight: %b", new Object[] { Integer.valueOf(this.CBu), Integer.valueOf(this.CBB), Integer.valueOf(paramInt1), Boolean.valueOf(ePc()) });
      this.CBF = (this.CBz / 2 - this.CBy);
      localObject1 = this.CBi;
      if (localObject1 == null) {
        p.btv("dialogBg");
      }
      Object localObject2 = this.CBi;
      if (localObject2 == null) {
        p.btv("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.CBz / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      bool2 = ePc();
      bool1 = bool2;
      if (bool2)
      {
        paramInt2 = this.CBu;
        if (this.CBH <= 0) {
          break label1046;
        }
        paramInt1 = this.CBH - this.CBy;
      }
    }
    for (;;)
    {
      paramInt1 = Math.min(this.CBE, paramInt1);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo computeFixedWebViewHeight dialogHeight: %s, fixedDialogHeight: %s, fixedDiaogHeightRate: %s, fixedWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.CBH), Float.valueOf(this.CBJ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
      this.CBI = paramInt1;
      if (this.CBI > 0)
      {
        this.CBF = this.CBI;
        bool1 = bool2;
        label412:
        localObject1 = this.CBn;
        if (localObject1 == null) {
          break label1079;
        }
        localObject1 = ((MMWebView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label1079;
        }
        paramInt1 = ((ViewGroup.LayoutParams)localObject1).height;
        label441:
        if (!bool1) {
          break label1084;
        }
        if (this.CBn == null) {
          break label1473;
        }
        localObject1 = this.CBn;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((MMWebView)localObject1).getLayoutParams().height == this.CBI) {
          break label1473;
        }
        paramInt1 = this.CBI;
        d((View)this.CBn, this.CBI, false);
      }
      label663:
      label1079:
      label1084:
      label1473:
      for (;;)
      {
        localObject1 = this.CBk;
        if (localObject1 == null) {
          p.btv("webViewContainer");
        }
        if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.CBE)
        {
          localObject1 = this.CBk;
          if (localObject1 == null) {
            p.btv("webViewContainer");
          }
          d((View)localObject1, this.CBE, true);
        }
        localObject1 = this.CBj;
        if (localObject1 == null) {
          p.btv("dialogContainer");
        }
        paramInt2 = paramInt1;
        if (((View)localObject1).getTranslationY() != this.CBE - this.CBI)
        {
          this.CBv = (this.CBE - this.CBI);
          this.CBx = this.CBv;
          paramInt2 = paramInt1;
          if (this.ddZ)
          {
            localObject1 = this.CBj;
            if (localObject1 == null) {
              p.btv("dialogContainer");
            }
            ((View)localObject1).setTranslationY(this.CBv);
            paramInt2 = paramInt1;
          }
        }
        paramInt1 = this.CBE;
        int i = this.CBF;
        localObject1 = this.CBj;
        if (localObject1 == null) {
          p.btv("dialogContainer");
        }
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedDialog: %b, fixedWebViewHeight: %s, currentWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.CBv), Boolean.valueOf(bool1), Integer.valueOf(this.CBI), Integer.valueOf(paramInt2) });
        paramInt1 = a.jn(getContext());
        localObject1 = this.CBj;
        if (localObject1 == null) {
          p.btv("dialogContainer");
        }
        this.CBL = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.CBL) });
        this.CBT.CBY = 0.0F;
        this.CBT.CCa = true;
        paramInt1 = this.CBz - this.CBF - this.CBy;
        localObject1 = this.CBq;
        float f1;
        if (localObject1 != null)
        {
          f1 = ((d)localObject1).getMarkViewHeight();
          label882:
          localObject1 = this.CBq;
          if (localObject1 == null) {
            break label1244;
          }
        }
        label1244:
        for (float f2 = ((d)localObject1).getMarkViewTransY();; f2 = 0.0F)
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.CBz / 4.0F), Float.valueOf(f2) });
          if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
            break label1250;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
          this.CBT.CCa = false;
          this.CBU.CCa = true;
          this.CBU.CBY = this.CBT.CBZ;
          f2 = this.CBT.CBZ + this.CBt;
          if (f2 > this.CBA / 2.0F) {
            break label1347;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
          this.CBU.CCa = false;
          return;
          if (this.CBJ <= 0.0F) {
            break label1476;
          }
          paramInt1 = (int)(this.CBJ * paramInt2 - this.CBy);
          break;
          bool1 = false;
          break label412;
          paramInt1 = 0;
          break label441;
          paramInt2 = paramInt1;
          if (this.CBn != null)
          {
            localObject1 = this.CBn;
            if (localObject1 == null) {
              p.hyc();
            }
            paramInt2 = paramInt1;
            if (((MMWebView)localObject1).getLayoutParams().height != this.CBE)
            {
              paramInt2 = this.CBE;
              d((View)this.CBn, this.CBE, true);
            }
          }
          localObject1 = this.CBj;
          if (localObject1 == null) {
            p.btv("dialogContainer");
          }
          if (((View)localObject1).getTranslationY() != this.CBE - this.CBF)
          {
            this.CBv = (this.CBE - this.CBF);
            this.CBx = this.CBv;
            if (this.ddZ)
            {
              localObject1 = this.CBj;
              if (localObject1 == null) {
                p.btv("dialogContainer");
              }
              ((View)localObject1).setTranslationY(this.CBv);
            }
          }
          break label663;
          f1 = 0.0F;
          break label882;
        }
        label1250:
        if (f2 >= this.CBz - paramInt1 / 2.0F - f1 / 2.0F) {}
        for (this.CBT.CBZ = (-this.CBx);; this.CBT.CBZ = (paramInt1 / 2.0F - f1 / 2.0F - this.CBt))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.CBT.CBY), Float.valueOf(this.CBT.CBZ) });
          break;
        }
        label1347:
        if (f2 >= this.CBu / 2.0F - this.CBA / 2.0F) {}
        for (this.CBU.CBZ = (-this.CBu);; this.CBU.CBZ = (this.CBT.CBZ - f2 - (f1 - this.CBA) / 2.0F))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.CBU.CBY), Float.valueOf(this.CBU.CBZ) });
          return;
          localObject1 = this.CBq;
          f1 = f3;
          if (localObject1 != null) {
            f1 = ((d)localObject1).getMarkViewHeight();
          }
        }
      }
      label1046:
      label1476:
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 1;
    boolean bool2 = true;
    if (paramMotionEvent == null) {
      bool2 = super.onTouchEvent(paramMotionEvent);
    }
    Object localObject;
    float f1;
    boolean bool1;
    do
    {
      return bool2;
      if ((this.CBO) || (this.CBp == null)) {
        break;
      }
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      f1 = ((View)localObject).getTranslationY() + this.CBB;
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent handle by backgroundListener offsetY: %s, event.y: %s", new Object[] { Float.valueOf(f1), Float.valueOf(paramMotionEvent.getRawY()) });
      localObject = this.CBp;
      if (localObject == null) {
        break label186;
      }
      bool1 = ((c)localObject).i(paramMotionEvent, (int)f1);
    } while (bool1);
    Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        label186:
        bool1 = false;
        break;
        this.CBd = paramMotionEvent.getRawX();
        this.onW = paramMotionEvent.getRawY();
        return true;
        if ((this.CBd == 0.0F) && (this.onW == 0.0F))
        {
          this.CBd = paramMotionEvent.getRawX();
          this.onW = paramMotionEvent.getRawY();
        }
        else
        {
          f1 = paramMotionEvent.getRawX() - this.CBd;
          float f2 = paramMotionEvent.getRawY() - this.onW;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.CBN = true;
          }
          if ((this.CBN) && (this.CBQ)) {
            c(f2, true);
          } else if (this.CBO) {
            c(f1, false);
          } else {
            Log.v("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.CBd = 0.0F;
    this.onW = 0.0F;
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp isExpand: %b, isTouchScrolling: %s", new Object[] { Boolean.valueOf(this.yPa), Boolean.valueOf(this.CBP) });
    if (this.CBP)
    {
      this.CBP = false;
      localObject = this.CBo;
      if (localObject != null) {
        ((f)localObject).ePh();
      }
    }
    if (!this.yPa)
    {
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(ePd()), Boolean.valueOf(ePe()) });
      if (ePd()) {
        if (this.CBN) {
          label462:
          Wr(i);
        }
      }
    }
    for (;;)
    {
      this.CBN = false;
      this.CBO = false;
      break;
      i = 2;
      break label462;
      if (!ePe())
      {
        localObject = this.CBj;
        if (localObject == null) {
          p.btv("dialogContainer");
        }
        f(((View)localObject).getTranslationY(), this.CBx, false);
        continue;
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(ePf()) });
        if (ePf())
        {
          if (this.CBN) {}
          for (i = j;; i = 2)
          {
            Wr(i);
            break;
          }
        }
      }
      localObject = this.CBj;
      if (localObject == null) {
        p.btv("dialogContainer");
      }
      f(((View)localObject).getTranslationY(), this.CBw, true);
    }
  }
  
  public final void setBackgroundListener(f paramf)
  {
    p.h(paramf, "listener");
    this.CBo = paramf;
  }
  
  public final void setBackgroundOpView(b paramb)
  {
    p.h(paramb, "opView");
    this.CBr = paramb;
    if ((this.CBr instanceof View))
    {
      paramb = this.CBm;
      if (paramb != null) {
        paramb.removeAllViews();
      }
      paramb = this.CBm;
      if (paramb != null)
      {
        b localb = this.CBr;
        if (localb == null) {
          throw new t("null cannot be cast to non-null type android.view.View");
        }
        paramb.addView((View)localb);
      }
      paramb = this.CBm;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      requestLayout();
    }
    do
    {
      return;
      paramb = this.CBm;
    } while (paramb == null);
    paramb.setVisibility(8);
  }
  
  public final void setBackgroundTouchListener(c paramc)
  {
    p.h(paramc, "listener");
    this.CBp = paramc;
  }
  
  public final void setBackgroundViewModel(d paramd)
  {
    p.h(paramd, "model");
    this.CBq = paramd;
    paramd = this.CBq;
    float f;
    if (paramd != null)
    {
      f = paramd.getMarkViewTransY();
      this.CBt = f;
      if (this.CBq != null)
      {
        paramd = this.CBq;
        if (paramd == null) {
          p.hyc();
        }
        if (paramd.getMarkViewHeight() > this.CBA)
        {
          paramd = this.CBq;
          if (paramd == null) {
            p.hyc();
          }
          this.CBA = ((int)paramd.getMarkViewHeight());
        }
      }
      paramd = this.CBq;
      if (paramd == null) {
        break label132;
      }
    }
    label132:
    for (paramd = Float.valueOf(paramd.getMarkViewTransY());; paramd = null)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { paramd });
      return;
      f = 0.0F;
      break;
    }
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    this.CBS = paramBoolean;
    if (!this.CBS)
    {
      localView = this.CBi;
      if (localView == null) {
        p.btv("dialogBg");
      }
      localView.setVisibility(8);
      localView = this.CBi;
      if (localView == null) {
        p.btv("dialogBg");
      }
      localView.setOnClickListener(null);
      return;
    }
    View localView = this.CBi;
    if (localView == null) {
      p.btv("dialogBg");
    }
    localView.setVisibility(0);
    ePa();
  }
  
  public final void setEnableDialogScroll(boolean paramBoolean)
  {
    this.CBQ = paramBoolean;
  }
  
  public final void setEnableScrollRightClose(boolean paramBoolean)
  {
    this.CAL = paramBoolean;
  }
  
  public final void setEnableWebViewScroll(boolean paramBoolean)
  {
    BoxWebViewContainer localBoxWebViewContainer = this.CBk;
    if (localBoxWebViewContainer == null) {
      p.btv("webViewContainer");
    }
    localBoxWebViewContainer.setEnableScroll(paramBoolean);
  }
  
  public final void setFixDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.CBH = paramInt;
  }
  
  public final void setFixDialogHeightRate(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeightRate: %s", new Object[] { Float.valueOf(paramFloat) });
    this.CBJ = paramFloat;
  }
  
  public final void setIsFixDialogHeight(boolean paramBoolean)
  {
    this.CBG = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
  final class a
  {
    float CBY;
    float CBZ;
    boolean CCa;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240222);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240222);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      BaseBoxDialogView.e(this.CCb, f2);
      if (paramBoolean) {}
      for (float f1 = BaseBoxDialogView.i(this.CCb).CBZ;; f1 = BaseBoxDialogView.j(this.CCb).CBZ)
      {
        f1 = BaseBoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BaseBoxDialogView.b(this.CCb, f1);
        AppMethodBeat.o(240222);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240223);
      BaseBoxDialogView.b(this.CCb, paramBoolean);
      BaseBoxDialogView.c(this.CCb, BaseBoxDialogView.e(this.CCb).getTranslationY());
      paramAnimator = this.CCb;
      d locald = BaseBoxDialogView.h(this.CCb);
      float f;
      if (locald != null)
      {
        f = locald.getBackgroundTransY();
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = this.CCb;
        if (!paramBoolean) {
          break label95;
        }
      }
      label95:
      for (int i = 2;; i = 1)
      {
        BaseBoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(240223);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateShowBackground$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240224);
      BaseBoxDialogView localBaseBoxDialogView = this.CCb;
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240224);
        throw paramValueAnimator;
      }
      BaseBoxDialogView.b(localBaseBoxDialogView, ((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(240224);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(240225);
      BaseBoxDialogView.a(this.CCb, 1);
      paramAnimator = this.CCb;
      d locald = BaseBoxDialogView.h(this.CCb);
      float f;
      if (locald != null)
      {
        f = locald.getBackgroundTransY();
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = BaseBoxDialogView.h(this.CCb);
        if (paramAnimator == null) {
          break label124;
        }
      }
      label124:
      for (paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());; paramAnimator = null)
      {
        locald = BaseBoxDialogView.h(this.CCb);
        if (locald != null) {
          localFloat = Float.valueOf(locald.getMarkViewTransY());
        }
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", new Object[] { paramAnimator, localFloat });
        AppMethodBeat.o(240225);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(240229);
      BaseBoxDialogView.b(this.CCb);
      AppMethodBeat.o(240229);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240228);
      BaseBoxDialogView.b(this.CCb);
      BaseBoxDialogView.a(this.CCb, 0);
      paramAnimator = BaseBoxDialogView.c(this.CCb);
      if (paramAnimator != null) {
        paramAnimator.ePj();
      }
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      AppMethodBeat.o(240228);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(240230);
      paramAnimator = BaseBoxDialogView.c(this.CCb);
      if (paramAnimator != null)
      {
        paramAnimator.ePi();
        AppMethodBeat.o(240230);
        return;
      }
      AppMethodBeat.o(240230);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BaseBoxDialogView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(240227);
        e locale = BaseBoxDialogView.d(this.CCh.CCb);
        if (locale != null)
        {
          locale.dismissDialog(this.CCh.CCg);
          AppMethodBeat.o(240227);
          return;
        }
        AppMethodBeat.o(240227);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
  public static final class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i(float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240231);
      BaseBoxDialogView.a(this.CCb, BaseBoxDialogView.e(this.CCb).getTranslationY());
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(240231);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240231);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f1;
      float f3 = this.CCj;
      float f4 = f1;
      BaseBoxDialogView.b(this.CCb, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(240231);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240234);
      BaseBoxDialogView.c(this.CCb, BaseBoxDialogView.e(this.CCb).getTranslationY());
      BaseBoxDialogView.a(this.CCb, BaseBoxDialogView.e(this.CCb).getTranslationY());
      AppMethodBeat.o(240234);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    m(float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(240236);
      BaseBoxDialogView.b(this.CCb);
      AppMethodBeat.o(240236);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240235);
      paramAnimator = BaseBoxDialogView.c(this.CCb);
      if (paramAnimator != null) {
        paramAnimator.ePk();
      }
      BaseBoxDialogView.f(this.CCb);
      BaseBoxDialogView.b(this.CCb);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(BaseBoxDialogView.e(this.CCb).getTranslationY()) });
      AppMethodBeat.o(240235);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(240237);
      paramAnimator = BaseBoxDialogView.c(this.CCb);
      if (paramAnimator != null)
      {
        paramAnimator.d(BaseBoxDialogView.g(this.CCb), this.CCk, this.CCl);
        AppMethodBeat.o(240237);
        return;
      }
      AppMethodBeat.o(240237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
 * JD-Core Version:    0.7.0.1
 */