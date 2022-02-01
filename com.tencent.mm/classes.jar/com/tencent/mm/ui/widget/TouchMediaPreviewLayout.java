package com.tencent.mm.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.DragExitCropLayout;
import com.tencent.mm.view.TouchableLayout;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "Companion", "OnScaleListener", "libmmui_release"})
public final class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static boolean HCL;
  public static final a HCM;
  private static boolean LDg;
  private boolean HCA;
  private ScaleGestureDetector HCB;
  private b HCC;
  private boolean HCD;
  private final DragExitCropLayout HCE;
  private ViewGroup HCF;
  private int HCG;
  private boolean HCH;
  private boolean HCI;
  private final float HCJ;
  private final Paint HCK;
  private final f HCw;
  private MotionEvent HCx;
  private MotionEvent HCy;
  public boolean HCz;
  private final f rFB;
  private View tct;
  
  static
  {
    AppMethodBeat.i(164342);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(TouchMediaPreviewLayout.class), "backgroundView", "getBackgroundView()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(TouchMediaPreviewLayout.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")) };
    HCM = new a((byte)0);
    LDg = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164360);
    this.HCw = g.E((a)new d(this));
    this.HCB = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rFB = g.E((a)new h(this));
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    Context localContext = paramContext.getContext();
    d.g.b.k.g(localContext, "context");
    paramContext.setBackgroundColor(localContext.getResources().getColor(17170445));
    this.HCE = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.HCJ = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fff());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.HCK = paramContext;
    if (HCL) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164360);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.HCw = g.E((a)new d(this));
    this.HCB = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rFB = g.E((a)new h(this));
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.HCE = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.HCJ = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fff());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.HCK = paramContext;
    if (HCL) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.HCw = g.E((a)new d(this));
    this.HCB = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rFB = g.E((a)new h(this));
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.HCE = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.HCJ = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fff());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.HCK = paramContext;
    if (HCL) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private final float fff()
  {
    AppMethodBeat.i(164359);
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f = TypedValue.applyDimension(1, 2.0F, ((Resources)localObject).getDisplayMetrics());
    AppMethodBeat.o(164359);
    return f;
  }
  
  private final View getBackgroundView()
  {
    AppMethodBeat.i(164343);
    View localView = (View)this.HCw.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.rFB.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  private final void x(final b<? super View, y> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.HCI)
    {
      final float f = getBackgroundView().getAlpha();
      this.HCI = true;
      this.HCE.a((a)new e(this, paramb), (ValueAnimator.AnimatorUpdateListener)new f(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(164345);
    d.g.b.k.h(paramMotionEvent, "ev");
    Object localObject;
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.HYe;
      TouchableLayout.abi((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.HYe;
      TouchableLayout.abj((int)paramMotionEvent.getRawY());
    }
    this.HCB.onTouchEvent(paramMotionEvent);
    getTouchDetector().onTouchEvent(paramMotionEvent);
    this.HCx = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      ad.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.HCA + " isInitFinish=" + this.HCH);
      this.HCy = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.HCA) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.HCC;
      if ((localObject == null) || (((b)localObject).onScaleBegin(this.HCB) != true)) {
        break label287;
      }
    }
    label287:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        getBackgroundView().setTag(Boolean.TRUE);
        getBackgroundView().setAlpha(0.0F);
        getBackgroundView().setVisibility(0);
      }
      this.HCA = bool1;
      if (this.HCA)
      {
        localObject = MotionEvent.obtain(this.HCx);
        d.g.b.k.g(localObject, "cancelEvent");
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.HCA) {
        break;
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool1;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      bool1 = bool2;
      if (!LDg)
      {
        bool1 = bool2;
        if (this.HCE.getContentViewScale()[0] >= 1.5F) {
          bool1 = true;
        }
      }
      this.HCz = bool1;
      ad.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.HCz + " isCanScale=" + this.HCA + " isInitFinish=" + this.HCH);
      float f = paramMotionEvent.getX();
      localObject = this.HCy;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.HCz)) {
        break label454;
      }
      this.HCE.ai(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label454:
      ffe();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    d.g.b.k.h(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (HCL)
    {
      float f = this.HCJ;
      Object localObject = getContext();
      d.g.b.k.g(localObject, "context");
      localObject = ((Context)localObject).getResources();
      d.g.b.k.g(localObject, "context.resources");
      paramCanvas.drawLine(0.0F, f, ((Resources)localObject).getDisplayMetrics().widthPixels, this.HCJ, this.HCK);
    }
    AppMethodBeat.o(164358);
  }
  
  public final void ffe()
  {
    AppMethodBeat.i(164347);
    if (!this.HCD)
    {
      this.HCD = true;
      this.HCz = false;
      x((b)new g(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public final b getScaleListener()
  {
    return this.HCC;
  }
  
  public final View getTouchView()
  {
    return this.tct;
  }
  
  public final void gq(View paramView)
  {
    AppMethodBeat.i(164348);
    d.g.b.k.h(paramView, "touchView");
    this.tct = paramView;
    Object localObject1 = new Rect();
    Object localObject2 = new int[2];
    paramView.getLocationOnScreen((int[])localObject2);
    ((Rect)localObject1).set(localObject2[0], localObject2[1], localObject2[0] + paramView.getWidth(), localObject2[1] + paramView.getHeight());
    localObject2 = new Rect();
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    ((Rect)localObject2).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + getWidth(), arrayOfInt[1] + getHeight());
    final float f1 = ((Rect)localObject1).centerX() - ((Rect)localObject2).centerX();
    final float f2 = ((Rect)localObject1).centerY() - ((Rect)localObject2).centerY();
    localObject1 = paramView.getParent();
    if (localObject1 == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(164348);
      throw paramView;
    }
    this.HCF = ((ViewGroup)localObject1);
    localObject1 = this.HCF;
    if (localObject1 != null) {}
    for (int i = ((ViewGroup)localObject1).indexOfChild(paramView);; i = 0)
    {
      this.HCG = i;
      localObject1 = this.HCF;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView(paramView);
      }
      this.HCE.setBgView(getBackgroundView());
      localObject1 = this.HCE.getParent();
      if (localObject1 == null) {
        break label297;
      }
      if (localObject1 != null) {
        break;
      }
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(164348);
      throw paramView;
    }
    ((ViewGroup)localObject1).removeView((View)this.HCE);
    label297:
    addView((View)this.HCE);
    this.HCE.setMinScaleFactor(1.0F);
    this.HCE.a(paramView, paramView.getWidth(), paramView.getHeight(), new Matrix(), CropLayout.c.HDJ, (b)new c(this, f1, f2));
    AppMethodBeat.o(164348);
  }
  
  public final void gr(View paramView)
  {
    AppMethodBeat.i(164354);
    d.g.b.k.h(paramView, "view");
    paramView = (ViewGroup)paramView;
    View localView = paramView.getChildAt(0);
    paramView.removeView(localView);
    addView(localView, 0);
    paramView.addView((View)this, 0);
    AppMethodBeat.o(164354);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    d.g.b.k.h(paramMotionEvent, "e");
    if (this.HCH) {
      this.HCE.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    if ((this.HCH) && (this.HCz)) {
      this.HCE.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    if ((this.HCH) && (this.HCA))
    {
      this.HCE.onScale(paramScaleGestureDetector);
      b localb = this.HCC;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (d.g.b.k.g(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.HCE.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    boolean bool = this.HCA;
    AppMethodBeat.o(164355);
    return bool;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164356);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164356);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164353);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    if ((this.HCA) && (this.HCH)) {
      this.HCE.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164353);
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164350);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(164350);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164346);
    if (this.HCA)
    {
      AppMethodBeat.o(164346);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164346);
    return bool;
  }
  
  public final void setPreViewMode(boolean paramBoolean)
  {
    this.HCz = paramBoolean;
  }
  
  public final void setScaleListener(b paramb)
  {
    this.HCC = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.tct = paramView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "INIT_BG_ALPHA", "", "TAG", "", "isRevertImmediately", "", "()Z", "setRevertImmediately", "(Z)V", "isShowVideoBaseLine", "setShowVideoBaseLine", "libmmui_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "libmmui_release"})
  public static abstract interface b
    extends ScaleGestureDetector.OnScaleGestureListener
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<View>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164339);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("percent");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164339);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      TouchMediaPreviewLayout.i(this.HCN).setAlpha(Math.min(f, 1.0F - f));
      AppMethodBeat.o(164339);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<View, y>
  {
    g(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<GestureDetector>
  {
    h(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */