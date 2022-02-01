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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundOpContainer", "Landroid/widget/LinearLayout;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "backgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "currentEnableTouchScroll", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedDialogHeight", "fixedDialogHeightRate", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "attachWebView", "webView", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFixedWebViewHeight", "dialogHeight", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initBackgroundOpView", "initDialogBg", "initMoveOffsetXFactor", "initWebViewHeight", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "view", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundOpView", "opView", "setBackgroundTouchListener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setCanceledOnTouchOutside", "cancel", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseBoxDialogView
  extends RelativeLayout
{
  public static final BaseBoxDialogView.b OMR = new BaseBoxDialogView.b((byte)0);
  private LinearLayout GWY;
  private MMWebView GWZ;
  private float GXe;
  private float GXf;
  private int GXg;
  private int GXh;
  private int GXi;
  private int GXj;
  e OMS;
  private BoxWebViewContainer OMT;
  private f OMU;
  private c OMV;
  private d OMW;
  private b OMX;
  private a OMY = new a();
  private a OMZ = new a();
  private final ValueAnimator animator = new ValueAnimator();
  private boolean fhR;
  private boolean isAnimating;
  private int lastOrientation;
  private int mStatusBarHeight;
  private float puO;
  private float puP;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  private View puU;
  private View puV;
  private View puX;
  private boolean pvA = true;
  private boolean pvB = true;
  private boolean pvC;
  private boolean pvD = true;
  private final DecelerateInterpolator pvE = new DecelerateInterpolator();
  private int pvF;
  private int pvb;
  private float pvc;
  private float pvd;
  private float pve;
  private int pvf;
  private int pvg;
  private int pvh;
  private int pvi;
  private int pvj;
  private int pvk;
  public boolean pvl = true;
  private boolean pvo;
  private int pvp;
  private float pvr;
  private float pvt;
  private float pvu = 1.0F;
  private boolean pvv;
  private boolean pvw = true;
  private boolean pvx;
  private boolean pvy;
  private boolean pvz;
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFitsSystemWindows(true);
    this.lastOrientation = getResources().getConfiguration().orientation;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    s.s(paramAttributeSet, "view");
    iV(paramAttributeSet);
    View localView = paramAttributeSet.findViewById(l.f.dialog_container);
    s.s(localView, "view.findViewById(R.id.dialog_container)");
    this.puV = localView;
    localView = paramAttributeSet.findViewById(l.f.dialog_bg);
    s.s(localView, "view.findViewById(R.id.dialog_bg)");
    this.puU = localView;
    localView = paramAttributeSet.findViewById(l.f.webview_container);
    s.s(localView, "view.findViewById(R.id.webview_container)");
    this.OMT = ((BoxWebViewContainer)localView);
    this.puX = jdMethod_do(paramAttributeSet);
    this.GWY = ((LinearLayout)paramAttributeSet.findViewById(l.f.background_op_container));
    paramAttributeSet = this.GWY;
    if (paramAttributeSet != null) {
      paramAttributeSet.setVisibility(8);
    }
    this.pvk = bf.bk(paramContext);
    bSx();
    localView = this.puX;
    paramAttributeSet = localView;
    if (localView == null)
    {
      s.bIx("closeButton");
      paramAttributeSet = null;
    }
    paramAttributeSet.setOnClickListener(new BaseBoxDialogView..ExternalSyntheticLambda4(this));
    this.mStatusBarHeight = bf.getStatusBarHeight(paramContext);
    this.pvg = (com.tencent.mm.cd.a.mt(paramContext) + this.mStatusBarHeight);
    this.pvf = getCloseLayoutHeight();
    this.pvi = com.tencent.mm.cd.a.fromDPToPix(paramContext, 50);
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lastOrientation), Integer.valueOf(this.pvg), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.pvi) });
    paramContext = this.puV;
    if (paramContext == null)
    {
      s.bIx("dialogContainer");
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.setTranslationY(this.pvg);
      bSy();
      return;
    }
  }
  
  private void Vx(final int paramInt)
  {
    float f2 = getMaxTranslationY();
    Object localObject = this.OMW;
    if (localObject == null) {}
    for (final float f1 = 0.0F;; f1 = ((d)localObject).getBackgroundTransY())
    {
      this.isAnimating = true;
      this.fhR = false;
      View localView = this.puV;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        localObject = null;
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
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new e(this, paramInt));
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, f1));
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
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    s.u(paramBaseBoxDialogView, "this$0");
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramInt2 == 0) {}
    for (;;)
    {
      paramBaseBoxDialogView.pvw = bool;
      return;
      bool = false;
    }
  }
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    s.u(paramBaseBoxDialogView, "this$0");
    View localView = paramBaseBoxDialogView.puV;
    paramValueAnimator = localView;
    if (localView == null)
    {
      s.bIx("dialogContainer");
      paramValueAnimator = null;
    }
    paramBaseBoxDialogView.pvc = paramValueAnimator.getTranslationY();
    paramValueAnimator = paramBaseBoxDialogView.puV;
    if (paramValueAnimator == null)
    {
      s.bIx("dialogContainer");
      paramValueAnimator = localObject;
    }
    for (;;)
    {
      paramBaseBoxDialogView.cs(paramValueAnimator.getTranslationY());
      return;
    }
  }
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseBoxDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/box/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseBoxDialogView, "this$0");
    paramBaseBoxDialogView.Vx(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, ValueAnimator paramValueAnimator)
  {
    s.u(paramBaseBoxDialogView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    paramBaseBoxDialogView.bu(f2);
    if (paramBoolean) {}
    for (float f1 = paramBaseBoxDialogView.OMZ.GXn;; f1 = paramBaseBoxDialogView.OMY.GXn)
    {
      paramBaseBoxDialogView.setBackgroundTranslationY(c(paramFloat1, paramFloat2, f2, paramFloat3, f1));
      return;
    }
  }
  
  private static final void b(BaseBoxDialogView paramBaseBoxDialogView, ValueAnimator paramValueAnimator)
  {
    s.u(paramBaseBoxDialogView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    paramBaseBoxDialogView.setBackgroundTranslationY(((Float)paramValueAnimator).floatValue());
  }
  
  private static final void b(BaseBoxDialogView paramBaseBoxDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseBoxDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/box/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseBoxDialogView, "this$0");
    if (!paramBaseBoxDialogView.pvD)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    paramBaseBoxDialogView.Vx(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final boolean bSA()
  {
    return (this.pvt < 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.05F);
  }
  
  private final boolean bSB()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.15F);
  }
  
  private final void bSx()
  {
    View localView2 = this.puU;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("dialogBg");
      localView1 = null;
    }
    localView1.setOnClickListener(new BaseBoxDialogView..ExternalSyntheticLambda3(this));
  }
  
  private final void bSy()
  {
    if ((getContext() instanceof Activity))
    {
      Rect localRect = new Rect();
      Object localObject = getContext();
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).getWindowVisibleDisplayFrame(localRect);
        }
      }
      this.pvh = localRect.height();
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { localRect, Integer.valueOf(localRect.height()), Integer.valueOf(this.pvh), Integer.valueOf(this.pvk) });
    }
  }
  
  private final boolean bSz()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.15F);
  }
  
  private final void bu(float paramFloat)
  {
    View localView2 = this.puV;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("dialogContainer");
      localView1 = null;
    }
    localView1.setTranslationY(paramFloat);
    cs(paramFloat);
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (!this.pvA) {}
    label142:
    label328:
    do
    {
      return;
      if (!this.pvz)
      {
        this.pvz = true;
        localObject2 = this.OMU;
        if (localObject2 != null) {
          ((f)localObject2).gPJ();
        }
      }
      localObject2 = this.GWZ;
      int i;
      if (localObject2 == null)
      {
        i = 0;
        this.GXg = i;
        if ((!fpJ()) || (this.GXh <= this.GXj)) {
          break label328;
        }
        i = Math.max(this.GXj, this.GXi);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.GXj), Integer.valueOf(i) });
        this.pvd = Math.max(this.pvd, this.GXh - i);
        if (!paramBoolean) {
          break label405;
        }
      }
      for (float f1 = 0.68F * paramFloat;; f1 = 0.85F * paramFloat)
      {
        float f2 = this.pvc;
        f2 = Math.max(this.pvd, f2 + f1);
        f2 = Math.min(this.pvb, f2);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.pvc), Float.valueOf(f2), Float.valueOf(this.pvd) });
        this.pvt = f1;
        bu(f2);
        if (f1 < 0.0F) {
          break label414;
        }
        paramFloat = this.pvc;
        f1 = this.pvb;
        localObject2 = this.puV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("dialogContainer");
          localObject1 = null;
        }
        setBackgroundTranslationY(c(paramFloat, f1, localObject1.getTranslationY(), this.GXe, 0.0F));
        return;
        i = ((MMWebView)localObject2).getScrollHeight();
        break;
        if (this.GXh <= this.GXg) {
          break label142;
        }
        i = Math.max(this.GXg, this.GXi);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.GXg), Integer.valueOf(i) });
        this.pvd = Math.max(this.pvd, this.GXh - i);
        break label142;
      }
    } while (this.pvc <= 0.0F);
    label405:
    label414:
    paramFloat = this.pvc;
    Object localObject2 = this.puV;
    if (localObject2 == null) {
      s.bIx("dialogContainer");
    }
    for (;;)
    {
      setBackgroundTranslationY(c(paramFloat, 0.0F, localObject1.getTranslationY(), this.OMZ.GXm, this.OMZ.GXn));
      return;
      localObject1 = localObject2;
    }
  }
  
  private final void cs(float paramFloat)
  {
    float f = 1.0F * paramFloat / this.pvb;
    Object localObject = this.OMU;
    if (localObject != null) {
      ((f)localObject).d(this.pvF, paramFloat, f);
    }
    localObject = this.GWY;
    b localb;
    int i;
    if (localObject != null)
    {
      localb = this.OMX;
      if (localb == null)
      {
        i = 0;
        ((LinearLayout)localObject).setTranslationY(paramFloat - i);
      }
    }
    else
    {
      i = this.pvb;
      localObject = this.OMX;
      if (localObject != null) {
        break label130;
      }
    }
    label130:
    for (localObject = null;; localObject = Integer.valueOf(((b)localObject).getVieHeight()))
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f, dialogHeight: %s, backgroundOpViewHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), localObject });
      return;
      i = localb.getVieHeight();
      break;
    }
  }
  
  private final void f(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      return;
    }
    Object localObject = this.OMW;
    if (localObject == null) {}
    for (float f = 0.0F;; f = ((d)localObject).getBackgroundTransY())
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener(new BaseBoxDialogView..ExternalSyntheticLambda2(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new c(this, paramBoolean));
      ((ValueAnimator)localObject).start();
      return;
    }
  }
  
  private final void f(View paramView, int paramInt, boolean paramBoolean)
  {
    ah localah = null;
    Object localObject;
    if (paramView != null)
    {
      if (paramView != null) {
        break label39;
      }
      localObject = localah;
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramBoolean) {
        post(new BaseBoxDialogView..ExternalSyntheticLambda6(paramView));
      }
      return;
      label39:
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        localObject = localah;
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
        localah = ah.aiuX;
      }
    }
  }
  
  private final boolean fpJ()
  {
    return (this.pvo) && ((this.pvp > 0) || (this.pvr > 0.0F));
  }
  
  private final int getMaxTranslationY()
  {
    return this.pvb;
  }
  
  private static final void hn(View paramView)
  {
    if (paramView != null) {
      paramView.requestLayout();
    }
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
    d locald = this.OMW;
    if (locald != null) {
      locald.setBackgroundTransY(paramFloat);
    }
    locald = this.OMW;
    if (locald != null) {
      locald.setMarkViewTransY(this.GXf + paramFloat);
    }
  }
  
  public abstract View jdMethod_do(View paramView);
  
  public final void e(MMWebView paramMMWebView)
  {
    s.u(paramMMWebView, "webView");
    this.GWZ = paramMMWebView;
    paramMMWebView = this.GWZ;
    s.checkNotNull(paramMMWebView);
    paramMMWebView.a(new BaseBoxDialogView..ExternalSyntheticLambda5(this));
    paramMMWebView = this.OMT;
    if (paramMMWebView == null)
    {
      s.bIx("webViewContainer");
      paramMMWebView = null;
    }
    for (;;)
    {
      paramMMWebView.addView((View)this.GWZ, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      return;
    }
  }
  
  public abstract int getCloseLayoutHeight();
  
  public abstract int getLayoutId();
  
  public void iV(View paramView)
  {
    s.u(paramView, "view");
  }
  
  public final boolean onBackPressed()
  {
    if (this.isAnimating) {
      return true;
    }
    Vx(5);
    return true;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Integer localInteger;
    if (paramConfiguration == null)
    {
      localInteger = null;
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", new Object[] { localInteger, Integer.valueOf(this.lastOrientation) });
      i = this.lastOrientation;
      if ((paramConfiguration == null) || (i != paramConfiguration.orientation)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bSy();
      }
      return;
      localInteger = Integer.valueOf(paramConfiguration.orientation);
      break;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject1 });
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool2) {
        break label65;
      }
      bool1 = bool2;
    }
    label65:
    while (paramMotionEvent == null)
    {
      return bool1;
      localObject1 = Integer.valueOf(paramMotionEvent.getAction());
      break;
    }
    if (this.puS == null) {
      this.puS = VelocityTracker.obtain();
    }
    Object localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).computeCurrentVelocity(1000);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int i = (int)((VelocityTracker)localObject1).getXVelocity();
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int j = (int)((VelocityTracker)localObject1).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Boolean.valueOf(this.pvB), Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.pvx), Boolean.valueOf(this.pvy) });
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject1).getTranslationY()) });
        this.puQ = paramMotionEvent.getRawX();
        this.puR = paramMotionEvent.getRawY();
        bool1 = false;
        break;
      }
      f1 = paramMotionEvent.getRawX() - this.puQ;
      f2 = paramMotionEvent.getRawY() - this.puR;
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject3;
        label443:
        if (f3 < ((View)localObject1).getTranslationY()) {
          break label729;
        }
        if ((Math.abs(f2) < 5.0F) || (!this.pvB) || (Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (Math.abs(j) <= 0) || (Math.abs(f2) <= Math.abs(f1))) {
          break label619;
        }
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.pvc) });
        if (this.pvc > this.pvd) {
          break label613;
        }
        if (!this.pvw) {
          break label607;
        }
        if (f2 < 0.0F) {
          break label601;
        }
        bool2 = true;
      }
      for (;;)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.pvx = true;
        bool1 = bool2;
        break;
        break label443;
        label601:
        bool2 = false;
        continue;
        label607:
        bool2 = false;
        continue;
        label613:
        bool2 = true;
      }
      label619:
      if (!this.pvC) {
        break;
      }
      if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.puQ <= 20.0F)) {}
      for (bool2 = true;; bool2 = false)
      {
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.puQ), Boolean.valueOf(bool2) });
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.pvy = true;
        bool1 = bool2;
        break;
      }
      label729:
      bool1 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    super.onMeasure(paramInt1, paramInt2);
    if (this.pvh == 0) {
      bSy();
    }
    Object localObject2 = this.puV;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = null;
    }
    boolean bool2;
    boolean bool1;
    if ((((View)localObject1).getMeasuredHeight() != this.pvb) && (this.pvl))
    {
      localObject2 = this.puV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      this.pvb = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.pvh - this.pvb);
      this.pvj = Math.max(0, this.pvi - paramInt1);
      if (fpJ()) {
        this.pvj = getContext().getResources().getDimensionPixelSize(l.d.Edge_A);
      }
      this.GXh = (this.pvb - this.pvf - this.pvj);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d, fixedDialogHeight: %b", new Object[] { Integer.valueOf(this.pvb), Integer.valueOf(this.pvj), Integer.valueOf(paramInt1), Boolean.valueOf(fpJ()) });
      this.GXi = (this.pvh / 2 - this.pvf);
      localObject2 = this.puU;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogBg");
        localObject1 = null;
      }
      Object localObject4 = this.puU;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("dialogBg");
        localObject2 = null;
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.pvh / 2);
      localObject4 = ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      bool2 = fpJ();
      bool1 = bool2;
      if (bool2)
      {
        paramInt2 = this.pvb;
        if (this.pvp <= 0) {
          break label1166;
        }
        paramInt1 = this.pvp - this.pvf;
      }
    }
    label922:
    label1434:
    for (;;)
    {
      paramInt1 = Math.min(this.GXh, paramInt1);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo computeFixedWebViewHeight dialogHeight: %s, fixedDialogHeight: %s, fixedDiaogHeightRate: %s, fixedWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.pvp), Float.valueOf(this.pvr), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
      this.GXj = paramInt1;
      if (this.GXj > 0)
      {
        this.GXi = this.GXj;
        bool1 = bool2;
        label433:
        localObject1 = this.GWZ;
        if (localObject1 != null) {
          break label1199;
        }
        paramInt1 = 0;
        label446:
        if (!bool1) {
          break label1231;
        }
        if (this.GXh > this.GXj)
        {
          paramInt2 = Math.max(this.GXj, this.GXi);
          this.pvd = Math.max(this.pvd, this.GXh - paramInt2);
          Log.d("MicroMsg.BaseBoxDialogView", "initWebViewHeight fixedWebViewHeight: %d, target: %d, dialogContainerMinTranslationY: %f", new Object[] { Integer.valueOf(this.GXj), Integer.valueOf(paramInt2), Float.valueOf(this.pvd) });
        }
        if (this.GWZ == null) {
          break label1659;
        }
        localObject1 = this.GWZ;
        s.checkNotNull(localObject1);
        if (((MMWebView)localObject1).getLayoutParams().height == this.GXj) {
          break label1659;
        }
        paramInt1 = this.GXj;
        f((View)this.GWZ, this.GXj, false);
      }
      label709:
      label1006:
      label1659:
      for (;;)
      {
        localObject2 = this.OMT;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("webViewContainer");
          localObject1 = null;
        }
        if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.GXh)
        {
          localObject2 = this.OMT;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("webViewContainer");
            localObject1 = null;
          }
          f((View)localObject1, this.GXh, true);
        }
        localObject2 = this.puV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("dialogContainer");
          localObject1 = null;
        }
        int i;
        if (((View)localObject1).getTranslationY() == this.GXh - this.GXj)
        {
          i = 1;
          paramInt2 = paramInt1;
          if (i == 0)
          {
            this.pvc = (this.GXh - this.GXj);
            this.pve = this.pvc;
            paramInt2 = paramInt1;
            if (this.fhR)
            {
              localObject2 = this.puV;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("dialogContainer");
                localObject1 = null;
              }
              ((View)localObject1).setTranslationY(this.pvc);
              paramInt2 = paramInt1;
            }
          }
          paramInt1 = this.GXh;
          i = this.GXi;
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedDialog: %b, fixedWebViewHeight: %s, currentWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.pvc), Boolean.valueOf(bool1), Integer.valueOf(this.GXj), Integer.valueOf(paramInt2) });
          paramInt1 = com.tencent.mm.cd.a.ms(getContext());
          localObject1 = this.puV;
          if (localObject1 != null) {
            break label1408;
          }
          s.bIx("dialogContainer");
          localObject1 = localObject3;
          this.pvu = (((View)localObject1).getMeasuredHeight() / (0.5F * paramInt1));
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.pvu) });
          this.OMY.GXm = 0.0F;
          this.OMY.GXo = true;
          paramInt1 = this.pvh - this.GXi - this.pvf;
          localObject1 = this.OMW;
          if (localObject1 != null) {
            break label1411;
          }
          f1 = 0.0F;
          localObject1 = this.OMW;
          if (localObject1 != null) {
            break label1422;
          }
        }
        for (float f2 = 0.0F;; f2 = ((d)localObject1).getMarkViewTransY())
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.pvh / 4.0F), Float.valueOf(f2) });
          if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
            break label1434;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
          this.OMY.GXo = false;
          this.OMZ.GXo = true;
          this.OMZ.GXm = this.OMY.GXn;
          f1 = this.OMY.GXn;
          f2 = this.GXf + f1;
          if (f2 > this.pvi / 2.0F) {
            break label1531;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
          this.OMZ.GXo = false;
          return;
          if (this.pvr <= 0.0F) {
            break label1662;
          }
          paramInt1 = (int)(this.pvr * paramInt2 - this.pvf);
          break;
          bool1 = false;
          break label433;
          localObject1 = ((MMWebView)localObject1).getLayoutParams();
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label446;
          }
          paramInt1 = ((ViewGroup.LayoutParams)localObject1).height;
          break label446;
          i = 0;
          break label709;
          paramInt2 = paramInt1;
          if (this.GWZ != null)
          {
            localObject1 = this.GWZ;
            s.checkNotNull(localObject1);
            paramInt2 = paramInt1;
            if (((MMWebView)localObject1).getLayoutParams().height != this.GXh)
            {
              paramInt2 = this.GXh;
              f((View)this.GWZ, this.GXh, true);
            }
          }
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          if (((View)localObject1).getTranslationY() == this.GXh - this.GXi) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0)
            {
              this.pvc = (this.GXh - this.GXi);
              this.pve = this.pvc;
              if (this.fhR)
              {
                localObject2 = this.puV;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("dialogContainer");
                  localObject1 = null;
                }
                ((View)localObject1).setTranslationY(this.pvc);
              }
            }
            break;
          }
          break label922;
          f1 = ((d)localObject1).getMarkViewHeight();
          break label1006;
        }
        if (f2 >= this.pvh - paramInt1 / 2.0F - f1 / 2.0F) {}
        for (this.OMY.GXn = (-this.pve);; this.OMY.GXn = (paramInt1 / 2.0F - f1 / 2.0F - this.GXf))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.OMY.GXm), Float.valueOf(this.OMY.GXn) });
          break;
        }
        label1531:
        if (f2 >= this.pvb / 2.0F - this.pvi / 2.0F)
        {
          this.OMZ.GXn = (-this.pvb);
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.OMZ.GXm), Float.valueOf(this.OMZ.GXn) });
          return;
        }
        localObject1 = this.OMW;
        if (localObject1 == null) {}
        for (float f1 = 0.0F;; f1 = ((d)localObject1).getMarkViewHeight())
        {
          this.OMZ.GXn = (this.OMY.GXn - f2 - (f1 - this.pvi) / 2.0F);
          break;
        }
      }
      label1199:
      label1231:
      label1662:
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    int i = 2;
    boolean bool3 = true;
    boolean bool1;
    if (paramMotionEvent == null) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    boolean bool2;
    label99:
    do
    {
      return bool1;
      if ((this.isAnimating) || (this.pvy) || (this.OMV == null)) {
        break;
      }
      View localView = this.puV;
      localObject1 = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      f1 = ((View)localObject1).getTranslationY();
      f1 = this.pvj + f1;
      localObject1 = this.OMV;
      if (localObject1 != null) {
        break label210;
      }
      bool2 = false;
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent handle by backgroundListener offsetY: %s, event.y: %s, handled: %s", new Object[] { Float.valueOf(f1), Float.valueOf(paramMotionEvent.getRawY()), Boolean.valueOf(bool2) });
      bool1 = bool3;
    } while (bool2);
    Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        label210:
        bool2 = ((c)localObject1).j(paramMotionEvent, (int)f1);
        break label99;
        this.puO = paramMotionEvent.getRawX();
        this.puP = paramMotionEvent.getRawY();
        bool1 = bool3;
        if (!this.isAnimating) {
          break;
        }
        this.pvA = false;
        return true;
        if (this.isAnimating) {
          this.pvA = false;
        }
        if (this.puO == 0.0F)
        {
          i = 1;
          label283:
          if (i == 0) {
            break label336;
          }
          if (this.puP != 0.0F) {
            break label330;
          }
        }
        label330:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label336;
          }
          this.puO = paramMotionEvent.getRawX();
          this.puP = paramMotionEvent.getRawY();
          break;
          i = 0;
          break label283;
        }
        label336:
        f1 = paramMotionEvent.getRawX() - this.puO;
        float f2 = paramMotionEvent.getRawY() - this.puP;
        if (Math.abs(f2) > Math.abs(f1)) {
          this.pvx = true;
        }
        if ((this.pvx) && (this.pvB)) {
          c(f2, true);
        } else if (this.pvy) {
          c(f1, false);
        } else {
          Log.v("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll ignore");
        }
      }
    }
    this.puO = 0.0F;
    this.puP = 0.0F;
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp isExpand: %b, isTouchScrolling: %s, currentEnableTouchScroll: %s", new Object[] { Boolean.valueOf(this.pvv), Boolean.valueOf(this.pvz), Boolean.valueOf(this.pvA) });
    if (this.pvA)
    {
      if (this.pvz)
      {
        this.pvz = false;
        localObject1 = this.OMU;
        if (localObject1 != null) {
          ((f)localObject1).gPK();
        }
      }
      if (this.pvv) {
        break label649;
      }
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(bSz()), Boolean.valueOf(bSA()) });
      if (!bSz()) {
        break label601;
      }
      if (!this.pvx) {
        break label595;
      }
      i = 1;
      label571:
      Vx(i);
    }
    for (;;)
    {
      this.pvx = false;
      this.pvy = false;
      this.pvA = true;
      break;
      label595:
      i = 2;
      break label571;
      label601:
      if (bSA()) {
        break label698;
      }
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        f(((View)localObject1).getTranslationY(), this.pve, false);
        break;
      }
      label649:
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(bSB()) });
      if (!bSB()) {
        break label698;
      }
      if (this.pvx) {
        i = 1;
      }
      Vx(i);
    }
    label698:
    Object localObject1 = this.puV;
    if (localObject1 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = localObject3;
    }
    for (;;)
    {
      f(((View)localObject1).getTranslationY(), this.pvd, true);
      break;
    }
  }
  
  public final void setBackgroundListener(f paramf)
  {
    s.u(paramf, "listener");
    this.OMU = paramf;
  }
  
  public final void setBackgroundOpView(b paramb)
  {
    s.u(paramb, "opView");
    this.OMX = paramb;
    if ((this.OMX instanceof View))
    {
      paramb = this.GWY;
      if (paramb != null) {
        paramb.removeAllViews();
      }
      paramb = this.GWY;
      if (paramb != null)
      {
        b localb = this.OMX;
        if (localb == null) {
          throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        paramb.addView((View)localb);
      }
      paramb = this.GWY;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      requestLayout();
    }
    do
    {
      return;
      paramb = this.GWY;
    } while (paramb == null);
    paramb.setVisibility(8);
  }
  
  public final void setBackgroundTouchListener(c paramc)
  {
    s.u(paramc, "listener");
    this.OMV = paramc;
  }
  
  public final void setBackgroundViewModel(d paramd)
  {
    s.u(paramd, "model");
    this.OMW = paramd;
    paramd = this.OMW;
    float f;
    if (paramd == null)
    {
      f = 0.0F;
      this.GXf = f;
      if (this.OMW != null)
      {
        paramd = this.OMW;
        s.checkNotNull(paramd);
        if (paramd.getMarkViewHeight() > this.pvi)
        {
          paramd = this.OMW;
          s.checkNotNull(paramd);
          this.pvi = ((int)paramd.getMarkViewHeight());
        }
      }
      paramd = this.OMW;
      if (paramd != null) {
        break label118;
      }
    }
    label118:
    for (paramd = null;; paramd = Float.valueOf(paramd.getMarkViewTransY()))
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { paramd });
      return;
      f = paramd.getMarkViewTransY();
      break;
    }
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    Object localObject = null;
    this.pvD = paramBoolean;
    if (!this.pvD)
    {
      localView = this.puU;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogBg");
        localObject = null;
      }
      localObject.setVisibility(8);
      localView = this.puU;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogBg");
        localObject = null;
      }
      localObject.setOnClickListener(null);
      return;
    }
    View localView = this.puU;
    if (localView == null) {
      s.bIx("dialogBg");
    }
    for (;;)
    {
      localObject.setVisibility(0);
      bSx();
      return;
      localObject = localView;
    }
  }
  
  public final void setEnableDialogScroll(boolean paramBoolean)
  {
    this.pvB = paramBoolean;
  }
  
  public final void setEnableScrollRightClose(boolean paramBoolean)
  {
    this.pvC = paramBoolean;
  }
  
  public final void setEnableWebViewScroll(boolean paramBoolean)
  {
    BoxWebViewContainer localBoxWebViewContainer2 = this.OMT;
    BoxWebViewContainer localBoxWebViewContainer1 = localBoxWebViewContainer2;
    if (localBoxWebViewContainer2 == null)
    {
      s.bIx("webViewContainer");
      localBoxWebViewContainer1 = null;
    }
    localBoxWebViewContainer1.setEnableScroll(paramBoolean);
  }
  
  public final void setFixDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.pvp = paramInt;
  }
  
  public final void setFixDialogHeightRate(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeightRate: %s", new Object[] { Float.valueOf(paramFloat) });
    this.pvr = paramFloat;
  }
  
  public final void setIsFixDialogHeight(boolean paramBoolean)
  {
    this.pvo = paramBoolean;
  }
  
  public final void show()
  {
    Object localObject2 = null;
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo showDialog");
    this.pvv = false;
    this.isAnimating = true;
    this.pvF = 0;
    final float f1 = getMaxTranslationY();
    final float f2 = this.pve;
    View localView = this.puV;
    Object localObject1 = localView;
    if (localView == null)
    {
      s.bIx("dialogContainer");
      localObject1 = null;
    }
    ((View)localObject1).setTranslationY(f1);
    localObject1 = this.puV;
    if (localObject1 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((View)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).translationY(f2);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setInterpolator((TimeInterpolator)this.pvE);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener(new BaseBoxDialogView..ExternalSyntheticLambda0(this));
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new g(this, f1, f2));
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
      }
      localObject1 = this.animator;
      ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject1).setDuration(300L);
      ((ValueAnimator)localObject1).setFloatValues(new float[] { this.OMY.GXm, this.OMY.GXn });
      ((ValueAnimator)localObject1).addUpdateListener(new BaseBoxDialogView..ExternalSyntheticLambda1(this));
      ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new d(this));
      ((ValueAnimator)localObject1).setStartDelay(50L);
      ((ValueAnimator)localObject1).start();
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    float GXm;
    float GXn;
    boolean GXo;
    
    public a()
    {
      AppMethodBeat.i(313767);
      AppMethodBeat.o(313767);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313759);
      BaseBoxDialogView.a(this.ONa, paramBoolean);
      BaseBoxDialogView localBaseBoxDialogView = this.ONa;
      Object localObject = BaseBoxDialogView.d(this.ONa);
      paramAnimator = (Animator)localObject;
      if (localObject == null)
      {
        s.bIx("dialogContainer");
        paramAnimator = null;
      }
      BaseBoxDialogView.c(localBaseBoxDialogView, paramAnimator.getTranslationY());
      paramAnimator = this.ONa;
      localObject = BaseBoxDialogView.g(this.ONa);
      float f;
      if (localObject == null)
      {
        f = 0.0F;
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = this.ONa;
        if (!paramBoolean) {
          break label117;
        }
      }
      label117:
      for (int i = 2;; i = 1)
      {
        BaseBoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(313759);
        return;
        f = ((d)localObject).getBackgroundTransY();
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Float localFloat = null;
      AppMethodBeat.i(313769);
      BaseBoxDialogView.a(this.ONa, 1);
      paramAnimator = this.ONa;
      d locald = BaseBoxDialogView.g(this.ONa);
      float f;
      if (locald == null)
      {
        f = 0.0F;
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = BaseBoxDialogView.g(this.ONa);
        if (paramAnimator != null) {
          break label105;
        }
        paramAnimator = null;
        label55:
        locald = BaseBoxDialogView.g(this.ONa);
        if (locald != null) {
          break label118;
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", new Object[] { paramAnimator, localFloat });
        AppMethodBeat.o(313769);
        return;
        f = locald.getBackgroundTransY();
        break;
        label105:
        paramAnimator = Float.valueOf(paramAnimator.getBackgroundTransY());
        break label55;
        label118:
        localFloat = Float.valueOf(locald.getMarkViewTransY());
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(BaseBoxDialogView paramBaseBoxDialogView, int paramInt) {}
    
    private static final void b(BaseBoxDialogView paramBaseBoxDialogView, int paramInt)
    {
      AppMethodBeat.i(313758);
      s.u(paramBaseBoxDialogView, "this$0");
      paramBaseBoxDialogView = BaseBoxDialogView.c(paramBaseBoxDialogView);
      if (paramBaseBoxDialogView != null) {
        paramBaseBoxDialogView.xM(paramInt);
      }
      AppMethodBeat.o(313758);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(313778);
      BaseBoxDialogView.a(this.ONa);
      AppMethodBeat.o(313778);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313774);
      BaseBoxDialogView.a(this.ONa);
      BaseBoxDialogView.a(this.ONa, 0);
      paramAnimator = BaseBoxDialogView.b(this.ONa);
      if (paramAnimator != null) {
        paramAnimator.gPM();
      }
      MMHandlerThread.postToMainThread(new BaseBoxDialogView.e..ExternalSyntheticLambda0(this.ONa, paramInt));
      AppMethodBeat.o(313774);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(313783);
      paramAnimator = BaseBoxDialogView.b(this.ONa);
      if (paramAnimator != null) {
        paramAnimator.gPL();
      }
      AppMethodBeat.o(313783);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(BaseBoxDialogView paramBaseBoxDialogView, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(313746);
      BaseBoxDialogView localBaseBoxDialogView = this.ONa;
      View localView2 = BaseBoxDialogView.d(this.ONa);
      View localView1 = localView2;
      if (localView2 == null)
      {
        s.bIx("dialogContainer");
        localView1 = null;
      }
      BaseBoxDialogView.a(localBaseBoxDialogView, localView1.getTranslationY());
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(313746);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(313746);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f1;
      float f3 = this.GXr;
      float f4 = f1;
      BaseBoxDialogView.b(this.ONa, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(313746);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(BaseBoxDialogView paramBaseBoxDialogView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(313772);
      BaseBoxDialogView.a(this.ONa);
      AppMethodBeat.o(313772);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313765);
      paramAnimator = BaseBoxDialogView.b(this.ONa);
      if (paramAnimator != null) {
        paramAnimator.gPN();
      }
      BaseBoxDialogView.e(this.ONa);
      BaseBoxDialogView.a(this.ONa);
      View localView = BaseBoxDialogView.d(this.ONa);
      paramAnimator = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        paramAnimator = null;
      }
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(paramAnimator.getTranslationY()) });
      AppMethodBeat.o(313765);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(313785);
      paramAnimator = BaseBoxDialogView.b(this.ONa);
      if (paramAnimator != null) {
        paramAnimator.e(BaseBoxDialogView.f(this.ONa), f1, f2);
      }
      AppMethodBeat.o(313785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
 * JD-Core Version:    0.7.0.1
 */