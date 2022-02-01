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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableScrollRightClose", "", "enableScrollVertical", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "webViewContainer", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getBoxWebView", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initMoveOffsetXFactor", "initWebViewHeight", "onBackPressed", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "AnimationInfo", "Companion", "plugin-scan_release"})
public final class BoxDialogView
  extends RelativeLayout
{
  public static final b vMF;
  boolean isAnimating;
  private int kvo;
  private int lDk;
  private float lVc;
  private BoxWebView mRH;
  final ValueAnimator qT;
  boolean sXO;
  private float vLY;
  private float vLZ;
  private boolean vMA;
  a vMB;
  private a vMC;
  final DecelerateInterpolator vMD;
  int vME;
  private float vMa;
  private VelocityTracker vMb;
  c vMc;
  private View vMd;
  View vMe;
  private RelativeLayout vMf;
  private View vMg;
  private d vMh;
  private a vMi;
  private float vMj;
  private float vMk;
  private int vMl;
  float vMm;
  private float vMn;
  private int vMo;
  private int vMp;
  private int vMq;
  private int vMr;
  private int vMs;
  private int vMt;
  private float vMu;
  private float vMv;
  private boolean vMw;
  private boolean vMx;
  private boolean vMy;
  private boolean vMz;
  
  static
  {
    AppMethodBeat.i(52114);
    vMF = new b((byte)0);
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
    this.vMv = 1.0F;
    this.vMw = true;
    this.vMz = true;
    this.qT = new ValueAnimator();
    this.vMB = new a();
    this.vMC = new a();
    this.vMD = new DecelerateInterpolator();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494563, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131299120);
    k.g(localObject, "view.findViewById(R.id.dialog_container)");
    this.vMe = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131299116);
    k.g(localObject, "view.findViewById(R.id.dialog_bg)");
    this.vMd = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131298372);
    k.g(localObject, "view.findViewById(R.id.close_img)");
    this.vMg = ((View)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131306912);
    k.g(paramAttributeSet, "view.findViewById(R.id.webview_container)");
    this.vMf = ((RelativeLayout)paramAttributeSet);
    this.mRH = new BoxWebView(paramContext);
    paramAttributeSet = this.mRH;
    if (paramAttributeSet == null) {
      k.aPZ("boxWebView");
    }
    paramAttributeSet.a((MMWebView.e)new i(this));
    paramAttributeSet = this.vMf;
    if (paramAttributeSet == null) {
      k.aPZ("webViewContainer");
    }
    localObject = this.mRH;
    if (localObject == null) {
      k.aPZ("boxWebView");
    }
    paramAttributeSet.addView((View)localObject);
    paramAttributeSet = this.vMd;
    if (paramAttributeSet == null) {
      k.aPZ("dialogBg");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new j(this));
    paramAttributeSet = this.vMg;
    if (paramAttributeSet == null) {
      k.aPZ("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new k(this));
    this.lDk = ap.iX(paramContext);
    this.kvo = (com.tencent.mm.cd.a.hW(paramContext) + this.lDk);
    this.vMo = paramContext.getResources().getDimensionPixelSize(2131166757);
    this.vMq = com.tencent.mm.cd.a.fromDPToPix(paramContext, 50);
    ad.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.kvo), Integer.valueOf(this.lDk), Integer.valueOf(this.vMq) });
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
      this.vMp = paramAttributeSet.height();
      if (this.vMp > this.kvo) {
        this.vMp = this.kvo;
      }
      ad.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView windowVisibleDisplayFrame: %s, height: %d, windowVisibleHeight: %d", new Object[] { paramAttributeSet, Integer.valueOf(paramAttributeSet.height()), Integer.valueOf(this.vMp) });
    }
    AppMethodBeat.o(52113);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void bl(float paramFloat)
  {
    AppMethodBeat.i(52105);
    View localView = this.vMe;
    if (localView == null) {
      k.aPZ("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bm(paramFloat);
    AppMethodBeat.o(52105);
  }
  
  private final void bm(float paramFloat)
  {
    AppMethodBeat.i(52106);
    float f = 1.0F * paramFloat / this.vMl;
    d locald = this.vMh;
    if (locald != null) {
      locald.c(this.vME, paramFloat, f);
    }
    ad.v("MicroMsg.BoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(52106);
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52103);
    Object localObject = this.mRH;
    if (localObject == null) {
      k.aPZ("boxWebView");
    }
    this.vMr = ((BoxWebView)localObject).getScrollHeight();
    if (this.vMs > this.vMr)
    {
      int i = Math.max(this.vMr, this.vMt);
      ad.d("MicroMsg.BoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.vMr), Integer.valueOf(i) });
      this.vMn = Math.max(this.vMn, this.vMs - i);
    }
    if (paramBoolean) {}
    for (float f1 = 0.68F * paramFloat;; f1 = this.vMv * paramFloat)
    {
      float f2 = this.vMm;
      f2 = Math.max(this.vMn, f2 + f1);
      f2 = Math.min(this.vMl, f2);
      ad.d("MicroMsg.BoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.vMm), Float.valueOf(f2), Float.valueOf(this.vMn) });
      this.vMu = f1;
      bl(f2);
      if (f1 < 0.0F) {
        break;
      }
      paramFloat = this.vMm;
      f1 = this.vMl;
      localObject = this.vMe;
      if (localObject == null) {
        k.aPZ("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.vMj, 0.0F));
      AppMethodBeat.o(52103);
      return;
    }
    if (this.vMm > 0.0F)
    {
      paramFloat = this.vMm;
      localObject = this.vMe;
      if (localObject == null) {
        k.aPZ("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.vMC.vMG, this.vMC.vMH));
    }
    AppMethodBeat.o(52103);
  }
  
  private final boolean dlc()
  {
    AppMethodBeat.i(52107);
    if ((this.vMu > 0.0F) && (Math.abs(this.vMu) >= this.vMs * 0.15F))
    {
      AppMethodBeat.o(52107);
      return true;
    }
    AppMethodBeat.o(52107);
    return false;
  }
  
  private final boolean dld()
  {
    AppMethodBeat.i(52108);
    if ((this.vMu < 0.0F) && (Math.abs(this.vMu) >= this.vMs * 0.05F))
    {
      AppMethodBeat.o(52108);
      return true;
    }
    AppMethodBeat.o(52108);
    return false;
  }
  
  private final boolean dle()
  {
    AppMethodBeat.i(52109);
    if ((this.vMu > 0.0F) && (Math.abs(this.vMu) >= this.vMs * 0.15F))
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
    ad.v("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      ad.w("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      AppMethodBeat.o(52110);
      return;
    }
    Object localObject = this.vMi;
    if (localObject != null) {}
    for (final float f = ((a)localObject).getBackgroundTransY();; f = 0.0F)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      k.g(localObject, "animator");
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new d(this, paramFloat2, paramBoolean));
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(52110);
      return;
    }
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    AppMethodBeat.i(52104);
    ad.v("MicroMsg.BoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    a locala = this.vMi;
    if (locala != null) {
      locala.setBackgroundTransY(paramFloat);
    }
    locala = this.vMi;
    if (locala != null)
    {
      locala.setMarkViewTransY(this.vMk + paramFloat);
      AppMethodBeat.o(52104);
      return;
    }
    AppMethodBeat.o(52104);
  }
  
  public final void KM(final int paramInt)
  {
    AppMethodBeat.i(52100);
    float f2 = getMaxTranslationY();
    Object localObject = this.vMi;
    if (localObject != null) {}
    for (final float f1 = ((a)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      localObject = this.vMe;
      if (localObject == null) {
        k.aPZ("dialogContainer");
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
    BoxWebView localBoxWebView = this.mRH;
    if (localBoxWebView == null) {
      k.aPZ("boxWebView");
    }
    AppMethodBeat.o(52099);
    return localBoxWebView;
  }
  
  final int getMaxTranslationY()
  {
    return this.vMl;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52101);
    if (paramMotionEvent != null) {}
    boolean bool1;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
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
    if (this.vMb == null) {
      this.vMb = VelocityTracker.obtain();
    }
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      ad.v("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.vMx), Boolean.valueOf(this.vMy) });
      AppMethodBeat.o(52101);
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.vMe;
      if (localObject == null) {
        k.aPZ("dialogContainer");
      }
      ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.vLZ = paramMotionEvent.getRawX();
      this.vMa = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.vLZ;
      f2 = paramMotionEvent.getRawY() - this.vMa;
      ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.vMe;
      if (localObject == null) {
        k.aPZ("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.vMz) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          ad.i("MicroMsg.BoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.vMm) });
          if (this.vMm <= this.vMn) {
            if (this.vMw) {
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
            this.vMx = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.vMA) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.vLZ <= 20.0F)) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.vLZ), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.vMy = true;
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
    Object localObject1 = this.vMe;
    if (localObject1 == null) {
      k.aPZ("dialogContainer");
    }
    float f1;
    label564:
    float f2;
    if (((View)localObject1).getMeasuredHeight() != this.vMl)
    {
      localObject1 = this.vMe;
      if (localObject1 == null) {
        k.aPZ("dialogContainer");
      }
      this.vMl = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.vMp - this.vMl);
      paramInt1 = Math.max(0, this.vMq - paramInt1);
      this.vMs = (this.vMl - this.vMo - paramInt1);
      ad.v("MicroMsg.BoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d", new Object[] { Integer.valueOf(this.vMl), Integer.valueOf(paramInt1) });
      this.vMt = (this.vMp / 2 - this.vMo);
      localObject1 = this.vMd;
      if (localObject1 == null) {
        k.aPZ("dialogBg");
      }
      Object localObject2 = this.vMd;
      if (localObject2 == null) {
        k.aPZ("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.vMp / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.vMf;
      if (localObject1 == null) {
        k.aPZ("webViewContainer");
      }
      if (((RelativeLayout)localObject1).getLayoutParams().height != this.vMs)
      {
        localObject1 = this.vMf;
        if (localObject1 == null) {
          k.aPZ("webViewContainer");
        }
        localObject2 = (View)localObject1;
        paramInt1 = this.vMs;
        if (localObject2 != null)
        {
          localObject1 = ((View)localObject2).getLayoutParams();
          if (localObject1 == null) {
            break label701;
          }
          ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      localObject1 = this.vMe;
      if (localObject1 == null) {
        k.aPZ("dialogContainer");
      }
      if (((View)localObject1).getTranslationY() != this.vMs - this.vMt)
      {
        localObject1 = this.vMe;
        if (localObject1 == null) {
          k.aPZ("dialogContainer");
        }
        ((View)localObject1).setTranslationY(this.vMs - this.vMt);
        localObject1 = this.vMe;
        if (localObject1 == null) {
          k.aPZ("dialogContainer");
        }
        this.vMm = ((View)localObject1).getTranslationY();
      }
      paramInt1 = this.vMs;
      paramInt2 = this.vMt;
      localObject1 = this.vMe;
      if (localObject1 == null) {
        k.aPZ("dialogContainer");
      }
      ad.i("MicroMsg.BoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(((View)localObject1).getTranslationY()) });
      paramInt1 = com.tencent.mm.cd.a.hV(getContext());
      localObject1 = this.vMe;
      if (localObject1 == null) {
        k.aPZ("dialogContainer");
      }
      this.vMv = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
      ad.d("MicroMsg.BoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.vMv) });
      this.vMB.vMG = 0.0F;
      this.vMB.vMI = true;
      localObject1 = this.vMi;
      float f4;
      float f5;
      if (localObject1 != null)
      {
        f1 = ((a)localObject1).getMarkViewHeight();
        f4 = this.vMp / 4.0F;
        f5 = f1 / 2.0F;
        localObject1 = this.vMi;
        if (localObject1 == null) {
          break label712;
        }
      }
      label701:
      label712:
      for (f2 = ((a)localObject1).getMarkViewTransY();; f2 = 0.0F)
      {
        if (f2 > f4 - f5) {
          break label718;
        }
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
        this.vMB.vMI = false;
        this.vMC.vMI = true;
        this.vMC.vMG = this.vMB.vMH;
        f2 = this.vMB.vMH + this.vMk;
        if (f2 > this.vMq / 2.0F) {
          break label823;
        }
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
        this.vMC.vMI = false;
        AppMethodBeat.o(52096);
        return;
        localObject1 = null;
        break;
        f1 = 0.0F;
        break label564;
      }
      label718:
      if (f2 >= this.vMp * 3.0F / 4.0F - f1 / 2.0F) {}
      for (this.vMB.vMH = (-this.vMm);; this.vMB.vMH = (this.vMp / 4.0F - f1 / 2.0F - this.vMk))
      {
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.vMB.vMG), Float.valueOf(this.vMB.vMH) });
        break;
      }
      label823:
      if (f2 < this.vMl / 2.0F - this.vMq / 2.0F) {
        break label903;
      }
    }
    for (this.vMC.vMH = (-this.vMl);; this.vMC.vMH = (this.vMB.vMH - f2 - (f1 - this.vMq) / 2.0F))
    {
      ad.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.vMC.vMG), Float.valueOf(this.vMC.vMH) });
      AppMethodBeat.o(52096);
      return;
      label903:
      localObject1 = this.vMi;
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
    ad.d("MicroMsg.BoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
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
        this.vLY = paramMotionEvent.getRawX();
        this.lVc = paramMotionEvent.getRawY();
        AppMethodBeat.o(52102);
        return true;
        if ((this.vLY == 0.0F) && (this.lVc == 0.0F))
        {
          this.vLY = paramMotionEvent.getRawX();
          this.lVc = paramMotionEvent.getRawY();
        }
        else
        {
          float f1 = paramMotionEvent.getRawX() - this.vLY;
          float f2 = paramMotionEvent.getRawY() - this.lVc;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.vMx = true;
          }
          if (this.vMx) {
            c(f2, true);
          } else if (this.vMy) {
            c(f1, false);
          } else {
            ad.v("MicroMsg.BoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.vLY = 0.0F;
    this.lVc = 0.0F;
    ad.i("MicroMsg.BoxDialogView", "alvinluo onTouchUp isExpand: %b", new Object[] { Boolean.valueOf(this.sXO) });
    if (!this.sXO)
    {
      ad.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(dlc()), Boolean.valueOf(dld()) });
      if (dlc()) {
        if (this.vMx) {
          label333:
          KM(i);
        }
      }
    }
    for (;;)
    {
      this.vMx = false;
      this.vMy = false;
      break;
      i = 2;
      break label333;
      if (!dld())
      {
        localView = this.vMe;
        if (localView == null) {
          k.aPZ("dialogContainer");
        }
        f(localView.getTranslationY(), this.vMp / 2.0F - this.vMq, false);
        continue;
        ad.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(dle()) });
        if (dle())
        {
          if (this.vMx) {}
          for (i = j;; i = 2)
          {
            KM(i);
            break;
          }
        }
      }
      View localView = this.vMe;
      if (localView == null) {
        k.aPZ("dialogContainer");
      }
      f(localView.getTranslationY(), this.vMn, true);
    }
  }
  
  public final void setBackgroundListener(d paramd)
  {
    AppMethodBeat.i(52097);
    k.h(paramd, "listener");
    this.vMh = paramd;
    AppMethodBeat.o(52097);
  }
  
  public final void setBackgroundViewModel(a parama)
  {
    AppMethodBeat.i(52098);
    k.h(parama, "model");
    this.vMi = parama;
    parama = this.vMi;
    float f;
    if (parama != null)
    {
      f = parama.getMarkViewTransY();
      this.vMk = f;
      parama = this.vMi;
      if (parama == null) {
        break label87;
      }
    }
    label87:
    for (parama = Float.valueOf(parama.getMarkViewTransY());; parama = null)
    {
      ad.v("MicroMsg.BoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { parama });
      AppMethodBeat.o(52098);
      return;
      f = 0.0F;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
  final class a
  {
    float vMG;
    float vMH;
    boolean vMI;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$Companion;", "", "()V", "DIALOG_SHOW_ANIMATION_DURATION", "", "DIALOG_SWITCH_ANIMATION_DURATION", "FULL_SCREEN_DRAG_CLOSE_FACTOR", "", "FULL_SCREEN_MOVE_OFFSET_Y_FACTOR", "HALF_SCREEN_DRAG_CLOSE_FACTOR", "HALF_SCREEN_DRAG_OPEN_FACTOR", "TAG", "", "plugin-scan_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      BoxDialogView.d(this.vMJ, f2);
      if (paramBoolean) {}
      for (float f1 = BoxDialogView.f(this.vMJ).vMH;; f1 = BoxDialogView.g(this.vMJ).vMH)
      {
        f1 = BoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BoxDialogView.b(this.vMJ, f1);
        AppMethodBeat.o(52084);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(float paramFloat, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int i = 1;
      AppMethodBeat.i(52085);
      paramAnimator = this.vMJ;
      boolean bool;
      a locala;
      if (paramFloat2 == BoxDialogView.h(this.vMJ))
      {
        bool = true;
        BoxDialogView.b(paramAnimator, bool);
        BoxDialogView.e(this.vMJ, BoxDialogView.d(this.vMJ).getTranslationY());
        paramAnimator = this.vMJ;
        locala = BoxDialogView.e(this.vMJ);
        if (locala == null) {
          break label116;
        }
      }
      label116:
      for (float f = locala.getBackgroundTransY();; f = 0.0F)
      {
        BoxDialogView.c(paramAnimator, f);
        paramAnimator = this.vMJ;
        if (paramBoolean) {
          i = 2;
        }
        BoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(52085);
        return;
        bool = false;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52086);
      BoxDialogView localBoxDialogView = this.vMJ;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(52087);
      BoxDialogView.a(this.vMJ, 1);
      paramAnimator = this.vMJ;
      a locala = BoxDialogView.e(this.vMJ);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.c(paramAnimator, f);
        paramAnimator = BoxDialogView.e(this.vMJ);
        if (paramAnimator == null) {
          break label124;
        }
      }
      label124:
      for (paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());; paramAnimator = null)
      {
        locala = BoxDialogView.e(this.vMJ);
        if (locala != null) {
          localFloat = Float.valueOf(locala.getMarkViewTransY());
        }
        ad.d("MicroMsg.BoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", new Object[] { paramAnimator, localFloat });
        AppMethodBeat.o(52087);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161052);
      BoxDialogView.a(this.vMJ);
      AppMethodBeat.o(161052);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52089);
      BoxDialogView.a(this.vMJ);
      BoxDialogView.a(this.vMJ, 0);
      BoxDialogView.b(this.vMJ);
      aq.f((Runnable)new a(this));
      AppMethodBeat.o(52089);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BoxDialogView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(52088);
        c localc = BoxDialogView.c(this.vMP.vMJ);
        if (localc != null)
        {
          localc.dismissDialog(this.vMP.vMO);
          AppMethodBeat.o(52088);
          return;
        }
        AppMethodBeat.o(52088);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
  public static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52090);
      BoxDialogView.a(this.vMJ, BoxDialogView.d(this.vMJ).getTranslationY());
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
      float f3 = this.vMR;
      float f4 = f1;
      BoxDialogView.b(this.vMJ, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(52090);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
  static final class i
    implements MMWebView.e
  {
    i(BoxDialogView paramBoxDialogView) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = true;
      AppMethodBeat.i(52091);
      ad.v("MicroMsg.BoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      BoxDialogView localBoxDialogView = this.vMJ;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52092);
      this.vMJ.KM(3);
      AppMethodBeat.o(52092);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52093);
      this.vMJ.KM(4);
      AppMethodBeat.o(52093);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52094);
      BoxDialogView.a(this.vMJ, BoxDialogView.d(this.vMJ).getTranslationY());
      AppMethodBeat.o(52094);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/box/BoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161053);
      BoxDialogView.a(this.vMJ);
      AppMethodBeat.o(161053);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52095);
      BoxDialogView.b(this.vMJ);
      BoxDialogView.a(this.vMJ);
      ad.v("MicroMsg.BoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(BoxDialogView.d(this.vMJ).getTranslationY()) });
      AppMethodBeat.o(52095);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView
 * JD-Core Version:    0.7.0.1
 */