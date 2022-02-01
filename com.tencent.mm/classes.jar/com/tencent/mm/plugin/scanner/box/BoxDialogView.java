package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
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
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableScrollRightClose", "enableScrollVertical", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedWebViewHeight", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getBoxWebView", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initMoveOffsetXFactor", "initWebViewHeight", "onBackPressed", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setFixWebViewHeight", "fixedHeight", "setIsFixWebViewHeight", "fixed", "setWebViewEnableScroll", "enableScroll", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"})
public final class BoxDialogView
  extends RelativeLayout
{
  public static final BoxDialogView.b wWW;
  private int ByR;
  boolean isAnimating;
  private int kWC;
  private int mfe;
  private float mxe;
  private BoxWebView ntX;
  final ValueAnimator rT;
  boolean ugb;
  private float wWA;
  float wWB;
  private int wWC;
  private int wWD;
  private int wWE;
  public boolean wWF;
  private int wWG;
  private int wWH;
  private int wWI;
  private boolean wWJ;
  private int wWK;
  private float wWL;
  private float wWM;
  private boolean wWN;
  private boolean wWO;
  private boolean wWP;
  private boolean wWQ;
  private boolean wWR;
  a wWS;
  private a wWT;
  final DecelerateInterpolator wWU;
  int wWV;
  private float wWl;
  private float wWm;
  private float wWn;
  private VelocityTracker wWo;
  c wWp;
  private View wWq;
  View wWr;
  private BoxWebViewContainer wWs;
  private View wWt;
  private d wWu;
  private a wWv;
  private float wWw;
  private float wWx;
  private int wWy;
  private float wWz;
  
  static
  {
    AppMethodBeat.i(52114);
    wWW = new BoxDialogView.b((byte)0);
    AppMethodBeat.o(52114);
  }
  
  public BoxDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(52111);
    AppMethodBeat.o(52111);
  }
  
  public BoxDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52112);
    AppMethodBeat.o(52112);
  }
  
  public BoxDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52113);
    this.wWF = true;
    this.wWM = 1.0F;
    this.wWN = true;
    this.wWQ = true;
    this.rT = new ValueAnimator();
    this.wWS = new a();
    this.wWT = new a();
    this.wWU = new DecelerateInterpolator();
    setFitsSystemWindows(true);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494563, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131299120);
    k.g(localObject, "view.findViewById(R.id.dialog_container)");
    this.wWr = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131299116);
    k.g(localObject, "view.findViewById(R.id.dialog_bg)");
    this.wWq = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131298372);
    k.g(localObject, "view.findViewById(R.id.close_img)");
    this.wWt = ((View)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131306912);
    k.g(paramAttributeSet, "view.findViewById(R.id.webview_container)");
    this.wWs = ((BoxWebViewContainer)paramAttributeSet);
    this.ntX = new BoxWebView(paramContext);
    paramAttributeSet = this.ntX;
    if (paramAttributeSet == null) {
      k.aVY("boxWebView");
    }
    paramAttributeSet.a((MMWebView.e)new i(this));
    this.ByR = com.tencent.mm.ui.ap.ej(paramContext);
    paramAttributeSet = this.wWs;
    if (paramAttributeSet == null) {
      k.aVY("webViewContainer");
    }
    localObject = this.ntX;
    if (localObject == null) {
      k.aVY("boxWebView");
    }
    paramAttributeSet.addView((View)localObject);
    paramAttributeSet = this.wWq;
    if (paramAttributeSet == null) {
      k.aVY("dialogBg");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new j(this));
    paramAttributeSet = this.wWt;
    if (paramAttributeSet == null) {
      k.aVY("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new k(this));
    this.mfe = com.tencent.mm.ui.ap.ji(paramContext);
    this.kWC = (com.tencent.mm.cc.a.ih(paramContext) + this.mfe);
    this.wWC = paramContext.getResources().getDimensionPixelSize(2131166757);
    this.wWE = com.tencent.mm.cc.a.fromDPToPix(paramContext, 50);
    ac.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.kWC), Integer.valueOf(this.mfe), Integer.valueOf(this.wWE) });
    if ((paramContext instanceof Activity))
    {
      paramAttributeSet = new Rect();
      paramContext = ((Activity)paramContext).getWindow();
      if (paramContext != null)
      {
        paramContext = paramContext.getDecorView();
        if (paramContext != null) {
          paramContext.getWindowVisibleDisplayFrame(paramAttributeSet);
        }
      }
      this.wWD = paramAttributeSet.height();
      paramContext = this.wWr;
      if (paramContext == null) {
        k.aVY("dialogContainer");
      }
      paramContext.setTranslationY(this.wWD);
      ac.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView windowVisibleDisplayFrame: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { paramAttributeSet, Integer.valueOf(paramAttributeSet.height()), Integer.valueOf(this.wWD), Integer.valueOf(this.ByR) });
    }
    AppMethodBeat.o(52113);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void bt(float paramFloat)
  {
    AppMethodBeat.i(52105);
    View localView = this.wWr;
    if (localView == null) {
      k.aVY("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bu(paramFloat);
    AppMethodBeat.o(52105);
  }
  
  private final void bu(float paramFloat)
  {
    AppMethodBeat.i(52106);
    float f = 1.0F * paramFloat / this.wWy;
    d locald = this.wWu;
    if (locald != null) {
      locald.c(this.wWV, paramFloat, f);
    }
    ac.v("MicroMsg.BoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(52106);
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52103);
    Object localObject = this.ntX;
    if (localObject == null) {
      k.aVY("boxWebView");
    }
    this.wWG = ((BoxWebView)localObject).getScrollHeight();
    int i;
    if ((dzd()) && (this.wWH > this.wWK))
    {
      i = Math.max(this.wWK, this.wWI);
      ac.d("MicroMsg.BoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.wWK), Integer.valueOf(i) });
      this.wWA = Math.max(this.wWA, this.wWH - i);
      if (!paramBoolean) {
        break label365;
      }
    }
    label365:
    for (float f1 = 0.68F * paramFloat;; f1 = this.wWM * paramFloat)
    {
      float f2 = this.wWz;
      f2 = Math.max(this.wWA, f2 + f1);
      f2 = Math.min(this.wWy, f2);
      ac.d("MicroMsg.BoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.wWz), Float.valueOf(f2), Float.valueOf(this.wWA) });
      this.wWL = f1;
      bt(f2);
      if (f1 < 0.0F) {
        break label375;
      }
      paramFloat = this.wWz;
      f1 = this.wWy;
      localObject = this.wWr;
      if (localObject == null) {
        k.aVY("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.wWw, 0.0F));
      AppMethodBeat.o(52103);
      return;
      if (this.wWH <= this.wWG) {
        break;
      }
      i = Math.max(this.wWG, this.wWI);
      ac.d("MicroMsg.BoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.wWG), Integer.valueOf(i) });
      this.wWA = Math.max(this.wWA, this.wWH - i);
      break;
    }
    label375:
    if (this.wWz > 0.0F)
    {
      paramFloat = this.wWz;
      localObject = this.wWr;
      if (localObject == null) {
        k.aVY("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.wWT.wWX, this.wWT.wWY));
    }
    AppMethodBeat.o(52103);
  }
  
  private final boolean dzd()
  {
    return (this.wWJ) && (this.wWK > 0);
  }
  
  private final boolean dze()
  {
    AppMethodBeat.i(52107);
    if ((this.wWL > 0.0F) && (Math.abs(this.wWL) >= this.wWH * 0.15F))
    {
      AppMethodBeat.o(52107);
      return true;
    }
    AppMethodBeat.o(52107);
    return false;
  }
  
  private final boolean dzf()
  {
    AppMethodBeat.i(52108);
    if ((this.wWL < 0.0F) && (Math.abs(this.wWL) >= this.wWH * 0.05F))
    {
      AppMethodBeat.o(52108);
      return true;
    }
    AppMethodBeat.o(52108);
    return false;
  }
  
  private final boolean dzg()
  {
    AppMethodBeat.i(52109);
    if ((this.wWL > 0.0F) && (Math.abs(this.wWL) >= this.wWH * 0.15F))
    {
      AppMethodBeat.o(52109);
      return true;
    }
    AppMethodBeat.o(52109);
    return false;
  }
  
  private final void f(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(52110);
    ac.v("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      ac.w("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      AppMethodBeat.o(52110);
      return;
    }
    Object localObject = this.wWv;
    if (localObject != null) {}
    for (final float f = ((a)localObject).getBackgroundTransY();; f = 0.0F)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      k.g(localObject, "animator");
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new d(this, paramBoolean));
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(52110);
      return;
    }
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    AppMethodBeat.i(52104);
    ac.v("MicroMsg.BoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    a locala = this.wWv;
    if (locala != null) {
      locala.setBackgroundTransY(paramFloat);
    }
    locala = this.wWv;
    if (locala != null)
    {
      locala.setMarkViewTransY(this.wWx + paramFloat);
      AppMethodBeat.o(52104);
      return;
    }
    AppMethodBeat.o(52104);
  }
  
  public final void MN(final int paramInt)
  {
    AppMethodBeat.i(52100);
    float f2 = getMaxTranslationY();
    Object localObject = this.wWv;
    if (localObject != null) {}
    for (final float f1 = ((a)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      localObject = this.wWr;
      if (localObject == null) {
        k.aVY("dialogContainer");
      }
      localObject = ((View)localObject).animate();
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).translationY(f2);
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new g(this, paramInt));
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(this, f1));
      if (localObject == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(52100);
      return;
    }
    AppMethodBeat.o(52100);
  }
  
  public final BoxWebView getBoxWebView()
  {
    AppMethodBeat.i(52099);
    BoxWebView localBoxWebView = this.ntX;
    if (localBoxWebView == null) {
      k.aVY("boxWebView");
    }
    AppMethodBeat.o(52099);
    return localBoxWebView;
  }
  
  final int getMaxTranslationY()
  {
    return this.wWy;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52101);
    if (paramMotionEvent != null) {}
    boolean bool1;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ac.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool1) {
        break;
      }
      AppMethodBeat.o(52101);
      return bool1;
    }
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(52101);
      return false;
    }
    if (this.wWo == null) {
      this.wWo = VelocityTracker.obtain();
    }
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      ac.v("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.wWO), Boolean.valueOf(this.wWP) });
      AppMethodBeat.o(52101);
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.wWr;
      if (localObject == null) {
        k.aVY("dialogContainer");
      }
      ac.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.wWm = paramMotionEvent.getRawX();
      this.wWn = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.wWm;
      f2 = paramMotionEvent.getRawY() - this.wWn;
      ac.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.wWr;
      if (localObject == null) {
        k.aVY("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.wWQ) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          ac.i("MicroMsg.BoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.wWz) });
          if (this.wWz <= this.wWA) {
            if (this.wWN) {
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
            this.wWO = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.wWR) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.wWm <= 20.0F)) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ac.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.wWm), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.wWP = true;
          bool1 = bool2;
          break;
        }
      }
      bool1 = false;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f3 = 0.0F;
    AppMethodBeat.i(52096);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject1 = this.wWr;
    if (localObject1 == null) {
      k.aVY("dialogContainer");
    }
    float f1;
    label626:
    float f2;
    if ((((View)localObject1).getMeasuredHeight() != this.wWy) && (this.wWF))
    {
      localObject1 = this.wWr;
      if (localObject1 == null) {
        k.aVY("dialogContainer");
      }
      this.wWy = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.wWD - this.wWy);
      paramInt2 = Math.max(0, this.wWE - paramInt1);
      this.wWH = (this.wWy - this.wWC - paramInt2);
      ac.v("MicroMsg.BoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d", new Object[] { Integer.valueOf(this.wWy), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.wWI = (this.wWD / 2 - this.wWC);
      localObject1 = this.wWq;
      if (localObject1 == null) {
        k.aVY("dialogBg");
      }
      Object localObject2 = this.wWq;
      if (localObject2 == null) {
        k.aVY("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.wWD / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      boolean bool = dzd();
      if (bool)
      {
        this.wWK = Math.min(this.wWH, this.wWK);
        this.wWI = this.wWK;
      }
      localObject1 = this.wWs;
      if (localObject1 == null) {
        k.aVY("webViewContainer");
      }
      if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.wWH)
      {
        localObject1 = this.ntX;
        if (localObject1 == null) {
          k.aVY("boxWebView");
        }
        localObject2 = (View)localObject1;
        paramInt1 = this.wWH;
        if (localObject2 != null)
        {
          localObject1 = ((View)localObject2).getLayoutParams();
          if (localObject1 != null)
          {
            ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
        else
        {
          post((Runnable)new n((View)localObject2));
        }
      }
      else
      {
        localObject1 = this.wWr;
        if (localObject1 == null) {
          k.aVY("dialogContainer");
        }
        if (((View)localObject1).getTranslationY() != this.wWH - this.wWI)
        {
          this.wWz = (this.wWH - this.wWI);
          this.wWB = this.wWz;
        }
        paramInt1 = this.wWH;
        paramInt2 = this.wWI;
        localObject1 = this.wWr;
        if (localObject1 == null) {
          k.aVY("dialogContainer");
        }
        ac.i("MicroMsg.BoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedWebView: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.wWz), Boolean.valueOf(bool) });
        paramInt1 = com.tencent.mm.cc.a.ig(getContext());
        localObject1 = this.wWr;
        if (localObject1 == null) {
          k.aVY("dialogContainer");
        }
        this.wWM = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
        ac.d("MicroMsg.BoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.wWM) });
        this.wWS.wWX = 0.0F;
        this.wWS.wWZ = true;
        paramInt1 = this.wWD - this.wWI - this.wWC;
        localObject1 = this.wWv;
        if (localObject1 == null) {
          break label802;
        }
        f1 = ((a)localObject1).getMarkViewHeight();
        localObject1 = this.wWv;
        if (localObject1 == null) {
          break label807;
        }
      }
      label802:
      label807:
      for (f2 = ((a)localObject1).getMarkViewTransY();; f2 = 0.0F)
      {
        ac.i("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.wWD / 4.0F), Float.valueOf(f2) });
        if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
          break label813;
        }
        ac.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
        this.wWS.wWZ = false;
        this.wWT.wWZ = true;
        this.wWT.wWX = this.wWS.wWY;
        f2 = this.wWS.wWY + this.wWx;
        if (f2 > this.wWE / 2.0F) {
          break label910;
        }
        ac.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
        this.wWT.wWZ = false;
        AppMethodBeat.o(52096);
        return;
        localObject1 = null;
        break;
        f1 = 0.0F;
        break label626;
      }
      label813:
      if (f2 >= this.wWD - paramInt1 / 2.0F - f1 / 2.0F) {}
      for (this.wWS.wWY = (-this.wWB);; this.wWS.wWY = (paramInt1 / 2.0F - f1 / 2.0F - this.wWx))
      {
        ac.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.wWS.wWX), Float.valueOf(this.wWS.wWY) });
        break;
      }
      label910:
      if (f2 < this.wWy / 2.0F - this.wWE / 2.0F) {
        break label990;
      }
    }
    for (this.wWT.wWY = (-this.wWy);; this.wWT.wWY = (this.wWS.wWY - f2 - (f1 - this.wWE) / 2.0F))
    {
      ac.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.wWT.wWX), Float.valueOf(this.wWT.wWY) });
      AppMethodBeat.o(52096);
      return;
      label990:
      localObject1 = this.wWv;
      f1 = f3;
      if (localObject1 != null) {
        f1 = ((a)localObject1).getMarkViewHeight();
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(52102);
    boolean bool;
    if (paramMotionEvent == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52102);
      return bool;
    }
    ac.d("MicroMsg.BoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(52102);
        return bool;
        this.wWl = paramMotionEvent.getRawX();
        this.mxe = paramMotionEvent.getRawY();
        AppMethodBeat.o(52102);
        return true;
        if ((this.wWl == 0.0F) && (this.mxe == 0.0F))
        {
          this.wWl = paramMotionEvent.getRawX();
          this.mxe = paramMotionEvent.getRawY();
        }
        else
        {
          float f1 = paramMotionEvent.getRawX() - this.wWl;
          float f2 = paramMotionEvent.getRawY() - this.mxe;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.wWO = true;
          }
          if (this.wWO) {
            c(f2, true);
          } else if (this.wWP) {
            c(f1, false);
          } else {
            ac.v("MicroMsg.BoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.wWl = 0.0F;
    this.mxe = 0.0F;
    ac.i("MicroMsg.BoxDialogView", "alvinluo onTouchUp isExpand: %b", new Object[] { Boolean.valueOf(this.ugb) });
    if (!this.ugb)
    {
      ac.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(dze()), Boolean.valueOf(dzf()) });
      if (dze()) {
        if (this.wWO) {
          label333:
          MN(i);
        }
      }
    }
    for (;;)
    {
      this.wWO = false;
      this.wWP = false;
      break;
      i = 2;
      break label333;
      if (!dzf())
      {
        localView = this.wWr;
        if (localView == null) {
          k.aVY("dialogContainer");
        }
        f(localView.getTranslationY(), this.wWB, false);
        continue;
        ac.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(dzg()) });
        if (dzg())
        {
          if (this.wWO) {}
          for (i = j;; i = 2)
          {
            MN(i);
            break;
          }
        }
      }
      View localView = this.wWr;
      if (localView == null) {
        k.aVY("dialogContainer");
      }
      f(localView.getTranslationY(), this.wWA, true);
    }
  }
  
  public final void setBackgroundListener(d paramd)
  {
    AppMethodBeat.i(52097);
    k.h(paramd, "listener");
    this.wWu = paramd;
    AppMethodBeat.o(52097);
  }
  
  public final void setBackgroundViewModel(a parama)
  {
    AppMethodBeat.i(52098);
    k.h(parama, "model");
    this.wWv = parama;
    parama = this.wWv;
    float f;
    if (parama != null)
    {
      f = parama.getMarkViewTransY();
      this.wWx = f;
      if (this.wWv != null)
      {
        parama = this.wWv;
        if (parama == null) {
          k.fOy();
        }
        if (parama.getMarkViewHeight() > this.wWE)
        {
          parama = this.wWv;
          if (parama == null) {
            k.fOy();
          }
          this.wWE = ((int)parama.getMarkViewHeight());
        }
      }
      parama = this.wWv;
      if (parama == null) {
        break label144;
      }
    }
    label144:
    for (parama = Float.valueOf(parama.getMarkViewTransY());; parama = null)
    {
      ac.v("MicroMsg.BoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { parama });
      AppMethodBeat.o(52098);
      return;
      f = 0.0F;
      break;
    }
  }
  
  public final void setFixWebViewHeight(int paramInt)
  {
    AppMethodBeat.i(199564);
    ac.v("MicroMsg.BoxDialogView", "alvinluo setFixWebViewHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.wWK = paramInt;
    AppMethodBeat.o(199564);
  }
  
  public final void setIsFixWebViewHeight(boolean paramBoolean)
  {
    this.wWJ = paramBoolean;
  }
  
  public final void setWebViewEnableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(199565);
    BoxWebViewContainer localBoxWebViewContainer = this.wWs;
    if (localBoxWebViewContainer == null) {
      k.aVY("webViewContainer");
    }
    localBoxWebViewContainer.setEnableScroll(paramBoolean);
    AppMethodBeat.o(199565);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
  final class a
  {
    float wWX;
    float wWY;
    boolean wWZ;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BoxDialogView paramBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52084);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52084);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      BoxDialogView.e(this.wXa, f2);
      if (paramBoolean) {}
      for (float f1 = BoxDialogView.f(this.wXa).wWY;; f1 = BoxDialogView.g(this.wXa).wWY)
      {
        f1 = BoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BoxDialogView.b(this.wXa, f1);
        AppMethodBeat.o(52084);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52085);
      BoxDialogView.b(this.wXa, paramBoolean);
      BoxDialogView.c(this.wXa, BoxDialogView.d(this.wXa).getTranslationY());
      paramAnimator = this.wXa;
      a locala = BoxDialogView.e(this.wXa);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = this.wXa;
        if (!paramBoolean) {
          break label95;
        }
      }
      label95:
      for (int i = 2;; i = 1)
      {
        BoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(52085);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52086);
      BoxDialogView localBoxDialogView = this.wXa;
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52086);
        throw paramValueAnimator;
      }
      BoxDialogView.b(localBoxDialogView, ((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(52086);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(52087);
      BoxDialogView.a(this.wXa, 1);
      paramAnimator = this.wXa;
      a locala = BoxDialogView.e(this.wXa);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = BoxDialogView.e(this.wXa);
        if (paramAnimator == null) {
          break label124;
        }
      }
      label124:
      for (paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());; paramAnimator = null)
      {
        locala = BoxDialogView.e(this.wXa);
        if (locala != null) {
          localFloat = Float.valueOf(locala.getMarkViewTransY());
        }
        ac.d("MicroMsg.BoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", new Object[] { paramAnimator, localFloat });
        AppMethodBeat.o(52087);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161052);
      BoxDialogView.a(this.wXa);
      AppMethodBeat.o(161052);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52089);
      BoxDialogView.a(this.wXa);
      BoxDialogView.a(this.wXa, 0);
      BoxDialogView.b(this.wXa);
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new a(this));
      AppMethodBeat.o(52089);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BoxDialogView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(52088);
        c localc = BoxDialogView.c(this.wXg.wXa);
        if (localc != null)
        {
          localc.dismissDialog(this.wXg.wXf);
          AppMethodBeat.o(52088);
          return;
        }
        AppMethodBeat.o(52088);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
  public static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52090);
      BoxDialogView.a(this.wXa, BoxDialogView.d(this.wXa).getTranslationY());
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(52090);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52090);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f1;
      float f3 = this.wXi;
      float f4 = f1;
      BoxDialogView.b(this.wXa, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(52090);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
  static final class i
    implements MMWebView.e
  {
    i(BoxDialogView paramBoxDialogView) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = true;
      AppMethodBeat.i(52091);
      ac.v("MicroMsg.BoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      BoxDialogView localBoxDialogView = this.wXa;
      if (paramInt2 == 0) {}
      for (;;)
      {
        BoxDialogView.a(localBoxDialogView, bool);
        AppMethodBeat.o(52091);
        return;
        bool = false;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52092);
      this.wXa.MN(3);
      AppMethodBeat.o(52092);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52093);
      this.wXa.MN(4);
      AppMethodBeat.o(52093);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52094);
      BoxDialogView.c(this.wXa, BoxDialogView.d(this.wXa).getTranslationY());
      BoxDialogView.a(this.wXa, BoxDialogView.d(this.wXa).getTranslationY());
      AppMethodBeat.o(52094);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/box/BoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161053);
      BoxDialogView.a(this.wXa);
      AppMethodBeat.o(161053);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52095);
      BoxDialogView.b(this.wXa);
      BoxDialogView.a(this.wXa);
      ac.v("MicroMsg.BoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(BoxDialogView.d(this.wXa).getTranslationY()) });
      AppMethodBeat.o(52095);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(210218);
      View localView = this.rWO;
      if (localView != null)
      {
        localView.requestLayout();
        AppMethodBeat.o(210218);
        return;
      }
      AppMethodBeat.o(210218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView
 * JD-Core Version:    0.7.0.1
 */