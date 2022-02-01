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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableScrollRightClose", "enableScrollVertical", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedWebViewHeight", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getBoxWebView", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initMoveOffsetXFactor", "initWebViewHeight", "onBackPressed", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setFixWebViewHeight", "fixedHeight", "setIsFixWebViewHeight", "fixed", "setWebViewEnableScroll", "enableScroll", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"})
public final class BoxDialogView
  extends RelativeLayout
{
  public static final BoxDialogView.b yAH;
  final ValueAnimator animator;
  boolean isAnimating;
  private int lya;
  private int mKJ;
  private float ncP;
  private BoxWebView oaU;
  boolean vuQ;
  private boolean yAA;
  private boolean yAB;
  private boolean yAC;
  a yAD;
  private a yAE;
  final DecelerateInterpolator yAF;
  int yAG;
  private View yAa;
  View yAb;
  private BoxWebViewContainer yAc;
  private View yAd;
  private d yAe;
  private a yAf;
  private float yAg;
  private float yAh;
  private int yAi;
  private float yAj;
  private float yAk;
  float yAl;
  private int yAm;
  private int yAn;
  private int yAo;
  private int yAp;
  public boolean yAq;
  private int yAr;
  private int yAs;
  private int yAt;
  private boolean yAu;
  private int yAv;
  private float yAw;
  private float yAx;
  private boolean yAy;
  private boolean yAz;
  private float yzV;
  private float yzW;
  private float yzX;
  private VelocityTracker yzY;
  c yzZ;
  
  static
  {
    AppMethodBeat.i(52114);
    yAH = new BoxDialogView.b((byte)0);
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
    this.yAq = true;
    this.yAx = 1.0F;
    this.yAy = true;
    this.yAB = true;
    this.animator = new ValueAnimator();
    this.yAD = new a();
    this.yAE = new a();
    this.yAF = new DecelerateInterpolator();
    setFitsSystemWindows(true);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494563, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131299120);
    p.g(localObject, "view.findViewById(R.id.dialog_container)");
    this.yAb = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131299116);
    p.g(localObject, "view.findViewById(R.id.dialog_bg)");
    this.yAa = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131298372);
    p.g(localObject, "view.findViewById(R.id.close_img)");
    this.yAd = ((View)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131306912);
    p.g(paramAttributeSet, "view.findViewById(R.id.webview_container)");
    this.yAc = ((BoxWebViewContainer)paramAttributeSet);
    this.oaU = new BoxWebView(paramContext);
    paramAttributeSet = this.oaU;
    if (paramAttributeSet == null) {
      p.bdF("boxWebView");
    }
    paramAttributeSet.a((MMWebView.e)new BoxDialogView.i(this));
    this.yAp = com.tencent.mm.ui.ar.en(paramContext);
    paramAttributeSet = this.yAc;
    if (paramAttributeSet == null) {
      p.bdF("webViewContainer");
    }
    localObject = this.oaU;
    if (localObject == null) {
      p.bdF("boxWebView");
    }
    paramAttributeSet.addView((View)localObject);
    paramAttributeSet = this.yAa;
    if (paramAttributeSet == null) {
      p.bdF("dialogBg");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new BoxDialogView.j(this));
    paramAttributeSet = this.yAd;
    if (paramAttributeSet == null) {
      p.bdF("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new BoxDialogView.k(this));
    this.mKJ = com.tencent.mm.ui.ar.jN(paramContext);
    this.lya = (com.tencent.mm.cb.a.iv(paramContext) + this.mKJ);
    this.yAm = paramContext.getResources().getDimensionPixelSize(2131166757);
    this.yAo = com.tencent.mm.cb.a.fromDPToPix(paramContext, 50);
    ae.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lya), Integer.valueOf(this.mKJ), Integer.valueOf(this.yAo) });
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
      this.yAn = paramAttributeSet.height();
      paramContext = this.yAb;
      if (paramContext == null) {
        p.bdF("dialogContainer");
      }
      paramContext.setTranslationY(this.yAn);
      ae.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView windowVisibleDisplayFrame: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { paramAttributeSet, Integer.valueOf(paramAttributeSet.height()), Integer.valueOf(this.yAn), Integer.valueOf(this.yAp) });
    }
    AppMethodBeat.o(52113);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void bw(float paramFloat)
  {
    AppMethodBeat.i(52105);
    View localView = this.yAb;
    if (localView == null) {
      p.bdF("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bx(paramFloat);
    AppMethodBeat.o(52105);
  }
  
  private final void bx(float paramFloat)
  {
    AppMethodBeat.i(52106);
    float f = 1.0F * paramFloat / this.yAi;
    d locald = this.yAe;
    if (locald != null) {
      locald.c(this.yAG, paramFloat, f);
    }
    ae.v("MicroMsg.BoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(52106);
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52103);
    Object localObject = this.oaU;
    if (localObject == null) {
      p.bdF("boxWebView");
    }
    this.yAr = ((BoxWebView)localObject).getScrollHeight();
    int i;
    if ((dNT()) && (this.yAs > this.yAv))
    {
      i = Math.max(this.yAv, this.yAt);
      ae.d("MicroMsg.BoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.yAv), Integer.valueOf(i) });
      this.yAk = Math.max(this.yAk, this.yAs - i);
      if (!paramBoolean) {
        break label365;
      }
    }
    label365:
    for (float f1 = 0.68F * paramFloat;; f1 = this.yAx * paramFloat)
    {
      float f2 = this.yAj;
      f2 = Math.max(this.yAk, f2 + f1);
      f2 = Math.min(this.yAi, f2);
      ae.d("MicroMsg.BoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.yAj), Float.valueOf(f2), Float.valueOf(this.yAk) });
      this.yAw = f1;
      bw(f2);
      if (f1 < 0.0F) {
        break label375;
      }
      paramFloat = this.yAj;
      f1 = this.yAi;
      localObject = this.yAb;
      if (localObject == null) {
        p.bdF("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.yAg, 0.0F));
      AppMethodBeat.o(52103);
      return;
      if (this.yAs <= this.yAr) {
        break;
      }
      i = Math.max(this.yAr, this.yAt);
      ae.d("MicroMsg.BoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.yAr), Integer.valueOf(i) });
      this.yAk = Math.max(this.yAk, this.yAs - i);
      break;
    }
    label375:
    if (this.yAj > 0.0F)
    {
      paramFloat = this.yAj;
      localObject = this.yAb;
      if (localObject == null) {
        p.bdF("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.yAE.yAI, this.yAE.yAJ));
    }
    AppMethodBeat.o(52103);
  }
  
  private final boolean dNT()
  {
    return (this.yAu) && (this.yAv > 0);
  }
  
  private final boolean dNU()
  {
    AppMethodBeat.i(52107);
    if ((this.yAw > 0.0F) && (Math.abs(this.yAw) >= this.yAs * 0.15F))
    {
      AppMethodBeat.o(52107);
      return true;
    }
    AppMethodBeat.o(52107);
    return false;
  }
  
  private final boolean dNV()
  {
    AppMethodBeat.i(52108);
    if ((this.yAw < 0.0F) && (Math.abs(this.yAw) >= this.yAs * 0.05F))
    {
      AppMethodBeat.o(52108);
      return true;
    }
    AppMethodBeat.o(52108);
    return false;
  }
  
  private final boolean dNW()
  {
    AppMethodBeat.i(52109);
    if ((this.yAw > 0.0F) && (Math.abs(this.yAw) >= this.yAs * 0.15F))
    {
      AppMethodBeat.o(52109);
      return true;
    }
    AppMethodBeat.o(52109);
    return false;
  }
  
  private final void e(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(52110);
    ae.v("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      ae.w("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      AppMethodBeat.o(52110);
      return;
    }
    Object localObject = this.yAf;
    if (localObject != null) {}
    for (final float f = ((a)localObject).getBackgroundTransY();; f = 0.0F)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      p.g(localObject, "animator");
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
    ae.v("MicroMsg.BoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    a locala = this.yAf;
    if (locala != null) {
      locala.setBackgroundTransY(paramFloat);
    }
    locala = this.yAf;
    if (locala != null)
    {
      locala.setMarkViewTransY(this.yAh + paramFloat);
      AppMethodBeat.o(52104);
      return;
    }
    AppMethodBeat.o(52104);
  }
  
  public final void OV(final int paramInt)
  {
    AppMethodBeat.i(52100);
    float f2 = getMaxTranslationY();
    Object localObject = this.yAf;
    if (localObject != null) {}
    for (float f1 = ((a)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      localObject = this.yAb;
      if (localObject == null) {
        p.bdF("dialogContainer");
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
      localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BoxDialogView.h(this, f1));
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
    BoxWebView localBoxWebView = this.oaU;
    if (localBoxWebView == null) {
      p.bdF("boxWebView");
    }
    AppMethodBeat.o(52099);
    return localBoxWebView;
  }
  
  final int getMaxTranslationY()
  {
    return this.yAi;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52101);
    if (paramMotionEvent != null) {}
    boolean bool1;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ae.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
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
    if (this.yzY == null) {
      this.yzY = VelocityTracker.obtain();
    }
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      ae.v("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.yAz), Boolean.valueOf(this.yAA) });
      AppMethodBeat.o(52101);
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.yAb;
      if (localObject == null) {
        p.bdF("dialogContainer");
      }
      ae.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.yzW = paramMotionEvent.getRawX();
      this.yzX = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.yzW;
      f2 = paramMotionEvent.getRawY() - this.yzX;
      ae.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.yAb;
      if (localObject == null) {
        p.bdF("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.yAB) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          ae.i("MicroMsg.BoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.yAj) });
          if (this.yAj <= this.yAk) {
            if (this.yAy) {
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
            this.yAz = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.yAC) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.yzW <= 20.0F)) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.yzW), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.yAA = true;
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
    Object localObject1 = this.yAb;
    if (localObject1 == null) {
      p.bdF("dialogContainer");
    }
    float f1;
    label626:
    float f2;
    if ((((View)localObject1).getMeasuredHeight() != this.yAi) && (this.yAq))
    {
      localObject1 = this.yAb;
      if (localObject1 == null) {
        p.bdF("dialogContainer");
      }
      this.yAi = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.yAn - this.yAi);
      paramInt2 = Math.max(0, this.yAo - paramInt1);
      this.yAs = (this.yAi - this.yAm - paramInt2);
      ae.v("MicroMsg.BoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d", new Object[] { Integer.valueOf(this.yAi), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.yAt = (this.yAn / 2 - this.yAm);
      localObject1 = this.yAa;
      if (localObject1 == null) {
        p.bdF("dialogBg");
      }
      Object localObject2 = this.yAa;
      if (localObject2 == null) {
        p.bdF("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.yAn / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      boolean bool = dNT();
      if (bool)
      {
        this.yAv = Math.min(this.yAs, this.yAv);
        this.yAt = this.yAv;
      }
      localObject1 = this.yAc;
      if (localObject1 == null) {
        p.bdF("webViewContainer");
      }
      if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.yAs)
      {
        localObject1 = this.oaU;
        if (localObject1 == null) {
          p.bdF("boxWebView");
        }
        localObject2 = (View)localObject1;
        paramInt1 = this.yAs;
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
          post((Runnable)new BoxDialogView.n((View)localObject2));
        }
      }
      else
      {
        localObject1 = this.yAb;
        if (localObject1 == null) {
          p.bdF("dialogContainer");
        }
        if (((View)localObject1).getTranslationY() != this.yAs - this.yAt)
        {
          this.yAj = (this.yAs - this.yAt);
          this.yAl = this.yAj;
        }
        paramInt1 = this.yAs;
        paramInt2 = this.yAt;
        localObject1 = this.yAb;
        if (localObject1 == null) {
          p.bdF("dialogContainer");
        }
        ae.i("MicroMsg.BoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedWebView: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.yAj), Boolean.valueOf(bool) });
        paramInt1 = com.tencent.mm.cb.a.iu(getContext());
        localObject1 = this.yAb;
        if (localObject1 == null) {
          p.bdF("dialogContainer");
        }
        this.yAx = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
        ae.d("MicroMsg.BoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.yAx) });
        this.yAD.yAI = 0.0F;
        this.yAD.yAK = true;
        paramInt1 = this.yAn - this.yAt - this.yAm;
        localObject1 = this.yAf;
        if (localObject1 == null) {
          break label802;
        }
        f1 = ((a)localObject1).getMarkViewHeight();
        localObject1 = this.yAf;
        if (localObject1 == null) {
          break label807;
        }
      }
      label802:
      label807:
      for (f2 = ((a)localObject1).getMarkViewTransY();; f2 = 0.0F)
      {
        ae.i("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.yAn / 4.0F), Float.valueOf(f2) });
        if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
          break label813;
        }
        ae.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
        this.yAD.yAK = false;
        this.yAE.yAK = true;
        this.yAE.yAI = this.yAD.yAJ;
        f2 = this.yAD.yAJ + this.yAh;
        if (f2 > this.yAo / 2.0F) {
          break label910;
        }
        ae.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
        this.yAE.yAK = false;
        AppMethodBeat.o(52096);
        return;
        localObject1 = null;
        break;
        f1 = 0.0F;
        break label626;
      }
      label813:
      if (f2 >= this.yAn - paramInt1 / 2.0F - f1 / 2.0F) {}
      for (this.yAD.yAJ = (-this.yAl);; this.yAD.yAJ = (paramInt1 / 2.0F - f1 / 2.0F - this.yAh))
      {
        ae.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.yAD.yAI), Float.valueOf(this.yAD.yAJ) });
        break;
      }
      label910:
      if (f2 < this.yAi / 2.0F - this.yAo / 2.0F) {
        break label990;
      }
    }
    for (this.yAE.yAJ = (-this.yAi);; this.yAE.yAJ = (this.yAD.yAJ - f2 - (f1 - this.yAo) / 2.0F))
    {
      ae.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.yAE.yAI), Float.valueOf(this.yAE.yAJ) });
      AppMethodBeat.o(52096);
      return;
      label990:
      localObject1 = this.yAf;
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
    ae.d("MicroMsg.BoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
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
        this.yzV = paramMotionEvent.getRawX();
        this.ncP = paramMotionEvent.getRawY();
        AppMethodBeat.o(52102);
        return true;
        if ((this.yzV == 0.0F) && (this.ncP == 0.0F))
        {
          this.yzV = paramMotionEvent.getRawX();
          this.ncP = paramMotionEvent.getRawY();
        }
        else
        {
          float f1 = paramMotionEvent.getRawX() - this.yzV;
          float f2 = paramMotionEvent.getRawY() - this.ncP;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.yAz = true;
          }
          if (this.yAz) {
            c(f2, true);
          } else if (this.yAA) {
            c(f1, false);
          } else {
            ae.v("MicroMsg.BoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.yzV = 0.0F;
    this.ncP = 0.0F;
    ae.i("MicroMsg.BoxDialogView", "alvinluo onTouchUp isExpand: %b", new Object[] { Boolean.valueOf(this.vuQ) });
    if (!this.vuQ)
    {
      ae.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(dNU()), Boolean.valueOf(dNV()) });
      if (dNU()) {
        if (this.yAz) {
          label333:
          OV(i);
        }
      }
    }
    for (;;)
    {
      this.yAz = false;
      this.yAA = false;
      break;
      i = 2;
      break label333;
      if (!dNV())
      {
        localView = this.yAb;
        if (localView == null) {
          p.bdF("dialogContainer");
        }
        e(localView.getTranslationY(), this.yAl, false);
        continue;
        ae.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(dNW()) });
        if (dNW())
        {
          if (this.yAz) {}
          for (i = j;; i = 2)
          {
            OV(i);
            break;
          }
        }
      }
      View localView = this.yAb;
      if (localView == null) {
        p.bdF("dialogContainer");
      }
      e(localView.getTranslationY(), this.yAk, true);
    }
  }
  
  public final void setBackgroundListener(d paramd)
  {
    AppMethodBeat.i(52097);
    p.h(paramd, "listener");
    this.yAe = paramd;
    AppMethodBeat.o(52097);
  }
  
  public final void setBackgroundViewModel(a parama)
  {
    AppMethodBeat.i(52098);
    p.h(parama, "model");
    this.yAf = parama;
    parama = this.yAf;
    float f;
    if (parama != null)
    {
      f = parama.getMarkViewTransY();
      this.yAh = f;
      if (this.yAf != null)
      {
        parama = this.yAf;
        if (parama == null) {
          p.gkB();
        }
        if (parama.getMarkViewHeight() > this.yAo)
        {
          parama = this.yAf;
          if (parama == null) {
            p.gkB();
          }
          this.yAo = ((int)parama.getMarkViewHeight());
        }
      }
      parama = this.yAf;
      if (parama == null) {
        break label144;
      }
    }
    label144:
    for (parama = Float.valueOf(parama.getMarkViewTransY());; parama = null)
    {
      ae.v("MicroMsg.BoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { parama });
      AppMethodBeat.o(52098);
      return;
      f = 0.0F;
      break;
    }
  }
  
  public final void setFixWebViewHeight(int paramInt)
  {
    AppMethodBeat.i(189523);
    ae.v("MicroMsg.BoxDialogView", "alvinluo setFixWebViewHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.yAv = paramInt;
    AppMethodBeat.o(189523);
  }
  
  public final void setIsFixWebViewHeight(boolean paramBoolean)
  {
    this.yAu = paramBoolean;
  }
  
  public final void setWebViewEnableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(189524);
    BoxWebViewContainer localBoxWebViewContainer = this.yAc;
    if (localBoxWebViewContainer == null) {
      p.bdF("webViewContainer");
    }
    localBoxWebViewContainer.setEnableScroll(paramBoolean);
    AppMethodBeat.o(189524);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
  final class a
  {
    float yAI;
    float yAJ;
    boolean yAK;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BoxDialogView paramBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52084);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52084);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      BoxDialogView.e(this.yAL, f2);
      if (paramBoolean) {}
      for (float f1 = BoxDialogView.f(this.yAL).yAJ;; f1 = BoxDialogView.g(this.yAL).yAJ)
      {
        f1 = BoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BoxDialogView.b(this.yAL, f1);
        AppMethodBeat.o(52084);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52085);
      BoxDialogView.b(this.yAL, paramBoolean);
      BoxDialogView.c(this.yAL, BoxDialogView.d(this.yAL).getTranslationY());
      paramAnimator = this.yAL;
      a locala = BoxDialogView.e(this.yAL);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = this.yAL;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(52087);
      BoxDialogView.a(this.yAL, 1);
      paramAnimator = this.yAL;
      a locala = BoxDialogView.e(this.yAL);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = BoxDialogView.e(this.yAL);
        if (paramAnimator == null) {
          break label124;
        }
      }
      label124:
      for (paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());; paramAnimator = null)
      {
        locala = BoxDialogView.e(this.yAL);
        if (locala != null) {
          localFloat = Float.valueOf(locala.getMarkViewTransY());
        }
        ae.d("MicroMsg.BoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", new Object[] { paramAnimator, localFloat });
        AppMethodBeat.o(52087);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161052);
      BoxDialogView.a(this.yAL);
      AppMethodBeat.o(161052);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52089);
      BoxDialogView.a(this.yAL);
      BoxDialogView.a(this.yAL, 0);
      BoxDialogView.b(this.yAL);
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new a(this));
      AppMethodBeat.o(52089);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BoxDialogView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(52088);
        c localc = BoxDialogView.c(this.yAR.yAL);
        if (localc != null)
        {
          localc.dismissDialog(this.yAR.yAQ);
          AppMethodBeat.o(52088);
          return;
        }
        AppMethodBeat.o(52088);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView
 * JD-Core Version:    0.7.0.1
 */