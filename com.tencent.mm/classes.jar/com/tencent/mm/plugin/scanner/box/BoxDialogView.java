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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableScrollRightClose", "enableScrollVertical", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedWebViewHeight", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getBoxWebView", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initMoveOffsetXFactor", "initWebViewHeight", "onBackPressed", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setFixWebViewHeight", "fixedHeight", "setIsFixWebViewHeight", "fixed", "setWebViewEnableScroll", "enableScroll", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"})
public final class BoxDialogView
  extends RelativeLayout
{
  public static final BoxDialogView.b ykI;
  final ValueAnimator animator;
  boolean isAnimating;
  private int ltB;
  private int mFF;
  private float mXI;
  private BoxWebView nVn;
  boolean viL;
  private float yjW;
  private float yjX;
  private float yjY;
  private VelocityTracker yjZ;
  private boolean ykA;
  private boolean ykB;
  private boolean ykC;
  private boolean ykD;
  a ykE;
  private a ykF;
  final DecelerateInterpolator ykG;
  int ykH;
  c yka;
  private View ykb;
  View ykc;
  private BoxWebViewContainer ykd;
  private View yke;
  private d ykf;
  private a ykg;
  private float ykh;
  private float yki;
  private int ykj;
  private float ykk;
  private float ykl;
  float ykm;
  private int ykn;
  private int yko;
  private int ykp;
  private int ykq;
  public boolean ykr;
  private int yks;
  private int ykt;
  private int yku;
  private boolean ykv;
  private int ykw;
  private float ykx;
  private float yky;
  private boolean ykz;
  
  static
  {
    AppMethodBeat.i(52114);
    ykI = new BoxDialogView.b((byte)0);
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
    this.ykr = true;
    this.yky = 1.0F;
    this.ykz = true;
    this.ykC = true;
    this.animator = new ValueAnimator();
    this.ykE = new a();
    this.ykF = new a();
    this.ykG = new DecelerateInterpolator();
    setFitsSystemWindows(true);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494563, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131299120);
    p.g(localObject, "view.findViewById(R.id.dialog_container)");
    this.ykc = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131299116);
    p.g(localObject, "view.findViewById(R.id.dialog_bg)");
    this.ykb = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131298372);
    p.g(localObject, "view.findViewById(R.id.close_img)");
    this.yke = ((View)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131306912);
    p.g(paramAttributeSet, "view.findViewById(R.id.webview_container)");
    this.ykd = ((BoxWebViewContainer)paramAttributeSet);
    this.nVn = new BoxWebView(paramContext);
    paramAttributeSet = this.nVn;
    if (paramAttributeSet == null) {
      p.bcb("boxWebView");
    }
    paramAttributeSet.a((MMWebView.e)new i(this));
    this.ykq = ar.ej(paramContext);
    paramAttributeSet = this.ykd;
    if (paramAttributeSet == null) {
      p.bcb("webViewContainer");
    }
    localObject = this.nVn;
    if (localObject == null) {
      p.bcb("boxWebView");
    }
    paramAttributeSet.addView((View)localObject);
    paramAttributeSet = this.ykb;
    if (paramAttributeSet == null) {
      p.bcb("dialogBg");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new j(this));
    paramAttributeSet = this.yke;
    if (paramAttributeSet == null) {
      p.bcb("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new k(this));
    this.mFF = ar.jG(paramContext);
    this.ltB = (com.tencent.mm.cc.a.iq(paramContext) + this.mFF);
    this.ykn = paramContext.getResources().getDimensionPixelSize(2131166757);
    this.ykp = com.tencent.mm.cc.a.fromDPToPix(paramContext, 50);
    ad.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.ltB), Integer.valueOf(this.mFF), Integer.valueOf(this.ykp) });
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
      this.yko = paramAttributeSet.height();
      paramContext = this.ykc;
      if (paramContext == null) {
        p.bcb("dialogContainer");
      }
      paramContext.setTranslationY(this.yko);
      ad.i("MicroMsg.BoxDialogView", "alvinluo initBoxDialogView windowVisibleDisplayFrame: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { paramAttributeSet, Integer.valueOf(paramAttributeSet.height()), Integer.valueOf(this.yko), Integer.valueOf(this.ykq) });
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
    View localView = this.ykc;
    if (localView == null) {
      p.bcb("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bx(paramFloat);
    AppMethodBeat.o(52105);
  }
  
  private final void bx(float paramFloat)
  {
    AppMethodBeat.i(52106);
    float f = 1.0F * paramFloat / this.ykj;
    d locald = this.ykf;
    if (locald != null) {
      locald.c(this.ykH, paramFloat, f);
    }
    ad.v("MicroMsg.BoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(52106);
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52103);
    Object localObject = this.nVn;
    if (localObject == null) {
      p.bcb("boxWebView");
    }
    this.yks = ((BoxWebView)localObject).getScrollHeight();
    int i;
    if ((dKB()) && (this.ykt > this.ykw))
    {
      i = Math.max(this.ykw, this.yku);
      ad.d("MicroMsg.BoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.ykw), Integer.valueOf(i) });
      this.ykl = Math.max(this.ykl, this.ykt - i);
      if (!paramBoolean) {
        break label365;
      }
    }
    label365:
    for (float f1 = 0.68F * paramFloat;; f1 = this.yky * paramFloat)
    {
      float f2 = this.ykk;
      f2 = Math.max(this.ykl, f2 + f1);
      f2 = Math.min(this.ykj, f2);
      ad.d("MicroMsg.BoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.ykk), Float.valueOf(f2), Float.valueOf(this.ykl) });
      this.ykx = f1;
      bw(f2);
      if (f1 < 0.0F) {
        break label375;
      }
      paramFloat = this.ykk;
      f1 = this.ykj;
      localObject = this.ykc;
      if (localObject == null) {
        p.bcb("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.ykh, 0.0F));
      AppMethodBeat.o(52103);
      return;
      if (this.ykt <= this.yks) {
        break;
      }
      i = Math.max(this.yks, this.yku);
      ad.d("MicroMsg.BoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.yks), Integer.valueOf(i) });
      this.ykl = Math.max(this.ykl, this.ykt - i);
      break;
    }
    label375:
    if (this.ykk > 0.0F)
    {
      paramFloat = this.ykk;
      localObject = this.ykc;
      if (localObject == null) {
        p.bcb("dialogContainer");
      }
      setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.ykF.ykJ, this.ykF.ykK));
    }
    AppMethodBeat.o(52103);
  }
  
  private final boolean dKB()
  {
    return (this.ykv) && (this.ykw > 0);
  }
  
  private final boolean dKC()
  {
    AppMethodBeat.i(52107);
    if ((this.ykx > 0.0F) && (Math.abs(this.ykx) >= this.ykt * 0.15F))
    {
      AppMethodBeat.o(52107);
      return true;
    }
    AppMethodBeat.o(52107);
    return false;
  }
  
  private final boolean dKD()
  {
    AppMethodBeat.i(52108);
    if ((this.ykx < 0.0F) && (Math.abs(this.ykx) >= this.ykt * 0.05F))
    {
      AppMethodBeat.o(52108);
      return true;
    }
    AppMethodBeat.o(52108);
    return false;
  }
  
  private final boolean dKE()
  {
    AppMethodBeat.i(52109);
    if ((this.ykx > 0.0F) && (Math.abs(this.ykx) >= this.ykt * 0.15F))
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
    ad.v("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      ad.w("MicroMsg.BoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      AppMethodBeat.o(52110);
      return;
    }
    Object localObject = this.ykg;
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
    ad.v("MicroMsg.BoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    a locala = this.ykg;
    if (locala != null) {
      locala.setBackgroundTransY(paramFloat);
    }
    locala = this.ykg;
    if (locala != null)
    {
      locala.setMarkViewTransY(this.yki + paramFloat);
      AppMethodBeat.o(52104);
      return;
    }
    AppMethodBeat.o(52104);
  }
  
  public final void Op(final int paramInt)
  {
    AppMethodBeat.i(52100);
    float f2 = getMaxTranslationY();
    Object localObject = this.ykg;
    if (localObject != null) {}
    for (final float f1 = ((a)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      localObject = this.ykc;
      if (localObject == null) {
        p.bcb("dialogContainer");
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
    BoxWebView localBoxWebView = this.nVn;
    if (localBoxWebView == null) {
      p.bcb("boxWebView");
    }
    AppMethodBeat.o(52099);
    return localBoxWebView;
  }
  
  final int getMaxTranslationY()
  {
    return this.ykj;
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
    if (this.yjZ == null) {
      this.yjZ = VelocityTracker.obtain();
    }
    localObject = this.yjZ;
    if (localObject == null) {
      p.gfZ();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.yjZ;
    if (localObject == null) {
      p.gfZ();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.yjZ;
    if (localObject == null) {
      p.gfZ();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.yjZ;
    if (localObject == null) {
      p.gfZ();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      ad.v("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.ykA), Boolean.valueOf(this.ykB) });
      AppMethodBeat.o(52101);
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.ykc;
      if (localObject == null) {
        p.bcb("dialogContainer");
      }
      ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.yjX = paramMotionEvent.getRawX();
      this.yjY = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.yjX;
      f2 = paramMotionEvent.getRawY() - this.yjY;
      ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.ykc;
      if (localObject == null) {
        p.bcb("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.ykC) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          ad.i("MicroMsg.BoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.ykk) });
          if (this.ykk <= this.ykl) {
            if (this.ykz) {
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
            this.ykA = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.ykD) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.yjX <= 20.0F)) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ad.d("MicroMsg.BoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.yjX), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.ykB = true;
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
    Object localObject1 = this.ykc;
    if (localObject1 == null) {
      p.bcb("dialogContainer");
    }
    float f1;
    label626:
    float f2;
    if ((((View)localObject1).getMeasuredHeight() != this.ykj) && (this.ykr))
    {
      localObject1 = this.ykc;
      if (localObject1 == null) {
        p.bcb("dialogContainer");
      }
      this.ykj = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.yko - this.ykj);
      paramInt2 = Math.max(0, this.ykp - paramInt1);
      this.ykt = (this.ykj - this.ykn - paramInt2);
      ad.v("MicroMsg.BoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d", new Object[] { Integer.valueOf(this.ykj), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.yku = (this.yko / 2 - this.ykn);
      localObject1 = this.ykb;
      if (localObject1 == null) {
        p.bcb("dialogBg");
      }
      Object localObject2 = this.ykb;
      if (localObject2 == null) {
        p.bcb("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.yko / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      boolean bool = dKB();
      if (bool)
      {
        this.ykw = Math.min(this.ykt, this.ykw);
        this.yku = this.ykw;
      }
      localObject1 = this.ykd;
      if (localObject1 == null) {
        p.bcb("webViewContainer");
      }
      if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.ykt)
      {
        localObject1 = this.nVn;
        if (localObject1 == null) {
          p.bcb("boxWebView");
        }
        localObject2 = (View)localObject1;
        paramInt1 = this.ykt;
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
        localObject1 = this.ykc;
        if (localObject1 == null) {
          p.bcb("dialogContainer");
        }
        if (((View)localObject1).getTranslationY() != this.ykt - this.yku)
        {
          this.ykk = (this.ykt - this.yku);
          this.ykm = this.ykk;
        }
        paramInt1 = this.ykt;
        paramInt2 = this.yku;
        localObject1 = this.ykc;
        if (localObject1 == null) {
          p.bcb("dialogContainer");
        }
        ad.i("MicroMsg.BoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedWebView: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.ykk), Boolean.valueOf(bool) });
        paramInt1 = com.tencent.mm.cc.a.ip(getContext());
        localObject1 = this.ykc;
        if (localObject1 == null) {
          p.bcb("dialogContainer");
        }
        this.yky = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
        ad.d("MicroMsg.BoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.yky) });
        this.ykE.ykJ = 0.0F;
        this.ykE.ykL = true;
        paramInt1 = this.yko - this.yku - this.ykn;
        localObject1 = this.ykg;
        if (localObject1 == null) {
          break label802;
        }
        f1 = ((a)localObject1).getMarkViewHeight();
        localObject1 = this.ykg;
        if (localObject1 == null) {
          break label807;
        }
      }
      label802:
      label807:
      for (f2 = ((a)localObject1).getMarkViewTransY();; f2 = 0.0F)
      {
        ad.i("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.yko / 4.0F), Float.valueOf(f2) });
        if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
          break label813;
        }
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
        this.ykE.ykL = false;
        this.ykF.ykL = true;
        this.ykF.ykJ = this.ykE.ykK;
        f2 = this.ykE.ykK + this.yki;
        if (f2 > this.ykp / 2.0F) {
          break label910;
        }
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
        this.ykF.ykL = false;
        AppMethodBeat.o(52096);
        return;
        localObject1 = null;
        break;
        f1 = 0.0F;
        break label626;
      }
      label813:
      if (f2 >= this.yko - paramInt1 / 2.0F - f1 / 2.0F) {}
      for (this.ykE.ykK = (-this.ykm);; this.ykE.ykK = (paramInt1 / 2.0F - f1 / 2.0F - this.yki))
      {
        ad.d("MicroMsg.BoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.ykE.ykJ), Float.valueOf(this.ykE.ykK) });
        break;
      }
      label910:
      if (f2 < this.ykj / 2.0F - this.ykp / 2.0F) {
        break label990;
      }
    }
    for (this.ykF.ykK = (-this.ykj);; this.ykF.ykK = (this.ykE.ykK - f2 - (f1 - this.ykp) / 2.0F))
    {
      ad.d("MicroMsg.BoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.ykF.ykJ), Float.valueOf(this.ykF.ykK) });
      AppMethodBeat.o(52096);
      return;
      label990:
      localObject1 = this.ykg;
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
        this.yjW = paramMotionEvent.getRawX();
        this.mXI = paramMotionEvent.getRawY();
        AppMethodBeat.o(52102);
        return true;
        if ((this.yjW == 0.0F) && (this.mXI == 0.0F))
        {
          this.yjW = paramMotionEvent.getRawX();
          this.mXI = paramMotionEvent.getRawY();
        }
        else
        {
          float f1 = paramMotionEvent.getRawX() - this.yjW;
          float f2 = paramMotionEvent.getRawY() - this.mXI;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.ykA = true;
          }
          if (this.ykA) {
            c(f2, true);
          } else if (this.ykB) {
            c(f1, false);
          } else {
            ad.v("MicroMsg.BoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.yjW = 0.0F;
    this.mXI = 0.0F;
    ad.i("MicroMsg.BoxDialogView", "alvinluo onTouchUp isExpand: %b", new Object[] { Boolean.valueOf(this.viL) });
    if (!this.viL)
    {
      ad.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(dKC()), Boolean.valueOf(dKD()) });
      if (dKC()) {
        if (this.ykA) {
          label333:
          Op(i);
        }
      }
    }
    for (;;)
    {
      this.ykA = false;
      this.ykB = false;
      break;
      i = 2;
      break label333;
      if (!dKD())
      {
        localView = this.ykc;
        if (localView == null) {
          p.bcb("dialogContainer");
        }
        e(localView.getTranslationY(), this.ykm, false);
        continue;
        ad.d("MicroMsg.BoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(dKE()) });
        if (dKE())
        {
          if (this.ykA) {}
          for (i = j;; i = 2)
          {
            Op(i);
            break;
          }
        }
      }
      View localView = this.ykc;
      if (localView == null) {
        p.bcb("dialogContainer");
      }
      e(localView.getTranslationY(), this.ykl, true);
    }
  }
  
  public final void setBackgroundListener(d paramd)
  {
    AppMethodBeat.i(52097);
    p.h(paramd, "listener");
    this.ykf = paramd;
    AppMethodBeat.o(52097);
  }
  
  public final void setBackgroundViewModel(a parama)
  {
    AppMethodBeat.i(52098);
    p.h(parama, "model");
    this.ykg = parama;
    parama = this.ykg;
    float f;
    if (parama != null)
    {
      f = parama.getMarkViewTransY();
      this.yki = f;
      if (this.ykg != null)
      {
        parama = this.ykg;
        if (parama == null) {
          p.gfZ();
        }
        if (parama.getMarkViewHeight() > this.ykp)
        {
          parama = this.ykg;
          if (parama == null) {
            p.gfZ();
          }
          this.ykp = ((int)parama.getMarkViewHeight());
        }
      }
      parama = this.ykg;
      if (parama == null) {
        break label144;
      }
    }
    label144:
    for (parama = Float.valueOf(parama.getMarkViewTransY());; parama = null)
    {
      ad.v("MicroMsg.BoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { parama });
      AppMethodBeat.o(52098);
      return;
      f = 0.0F;
      break;
    }
  }
  
  public final void setFixWebViewHeight(int paramInt)
  {
    AppMethodBeat.i(186241);
    ad.v("MicroMsg.BoxDialogView", "alvinluo setFixWebViewHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.ykw = paramInt;
    AppMethodBeat.o(186241);
  }
  
  public final void setIsFixWebViewHeight(boolean paramBoolean)
  {
    this.ykv = paramBoolean;
  }
  
  public final void setWebViewEnableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(186242);
    BoxWebViewContainer localBoxWebViewContainer = this.ykd;
    if (localBoxWebViewContainer == null) {
      p.bcb("webViewContainer");
    }
    localBoxWebViewContainer.setEnableScroll(paramBoolean);
    AppMethodBeat.o(186242);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
  final class a
  {
    float ykJ;
    float ykK;
    boolean ykL;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      BoxDialogView.e(this.ykM, f2);
      if (paramBoolean) {}
      for (float f1 = BoxDialogView.f(this.ykM).ykK;; f1 = BoxDialogView.g(this.ykM).ykK)
      {
        f1 = BoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BoxDialogView.b(this.ykM, f1);
        AppMethodBeat.o(52084);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52085);
      BoxDialogView.b(this.ykM, paramBoolean);
      BoxDialogView.c(this.ykM, BoxDialogView.d(this.ykM).getTranslationY());
      paramAnimator = this.ykM;
      a locala = BoxDialogView.e(this.ykM);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = this.ykM;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52086);
      BoxDialogView localBoxDialogView = this.ykM;
      p.g(paramValueAnimator, "animation");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/BoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(52087);
      BoxDialogView.a(this.ykM, 1);
      paramAnimator = this.ykM;
      a locala = BoxDialogView.e(this.ykM);
      float f;
      if (locala != null)
      {
        f = locala.getBackgroundTransY();
        BoxDialogView.d(paramAnimator, f);
        paramAnimator = BoxDialogView.e(this.ykM);
        if (paramAnimator == null) {
          break label124;
        }
      }
      label124:
      for (paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());; paramAnimator = null)
      {
        locala = BoxDialogView.e(this.ykM);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161052);
      BoxDialogView.a(this.ykM);
      AppMethodBeat.o(161052);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52089);
      BoxDialogView.a(this.ykM);
      BoxDialogView.a(this.ykM, 0);
      BoxDialogView.b(this.ykM);
      aq.f((Runnable)new a(this));
      AppMethodBeat.o(52089);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BoxDialogView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(52088);
        c localc = BoxDialogView.c(this.ykS.ykM);
        if (localc != null)
        {
          localc.dismissDialog(this.ykS.ykR);
          AppMethodBeat.o(52088);
          return;
        }
        AppMethodBeat.o(52088);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/BoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
  public static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52090);
      BoxDialogView.a(this.ykM, BoxDialogView.d(this.ykM).getTranslationY());
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
      float f3 = this.ykU;
      float f4 = f1;
      BoxDialogView.b(this.ykM, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(52090);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
  static final class i
    implements MMWebView.e
  {
    i(BoxDialogView paramBoxDialogView) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = true;
      AppMethodBeat.i(52091);
      ad.v("MicroMsg.BoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      BoxDialogView localBoxDialogView = this.ykM;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52092);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/BoxDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.ykM.Op(3);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/BoxDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(52092);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(BoxDialogView paramBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52093);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/BoxDialogView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.ykM.Op(4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/BoxDialogView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(52093);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(BoxDialogView paramBoxDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52094);
      BoxDialogView.c(this.ykM, BoxDialogView.d(this.ykM).getTranslationY());
      BoxDialogView.a(this.ykM, BoxDialogView.d(this.ykM).getTranslationY());
      AppMethodBeat.o(52094);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/box/BoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(161053);
      BoxDialogView.a(this.ykM);
      AppMethodBeat.o(161053);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52095);
      BoxDialogView.b(this.ykM);
      BoxDialogView.a(this.ykM);
      ad.v("MicroMsg.BoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(BoxDialogView.d(this.ykM).getTranslationY()) });
      AppMethodBeat.o(52095);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView
 * JD-Core Version:    0.7.0.1
 */