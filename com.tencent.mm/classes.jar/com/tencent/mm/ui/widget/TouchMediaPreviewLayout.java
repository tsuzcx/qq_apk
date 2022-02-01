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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "Companion", "OnScaleListener", "libmmui_release"})
public final class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static boolean Jdh;
  private static boolean Jdi;
  public static final TouchMediaPreviewLayout.a Jdj;
  private final f JcS;
  private MotionEvent JcT;
  private MotionEvent JcU;
  public boolean JcV;
  private boolean JcW;
  private ScaleGestureDetector JcX;
  private b JcY;
  private boolean JcZ;
  private final DragExitCropLayout Jda;
  private ViewGroup Jdb;
  private int Jdc;
  private boolean Jdd;
  private boolean Jde;
  private final float Jdf;
  private final Paint Jdg;
  private final f rTf;
  private View ukI;
  
  static
  {
    AppMethodBeat.i(164342);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(TouchMediaPreviewLayout.class), "backgroundView", "getBackgroundView()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(TouchMediaPreviewLayout.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")) };
    Jdj = new TouchMediaPreviewLayout.a((byte)0);
    Jdi = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164360);
    this.JcS = g.K((a)new d(this));
    this.JcX = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rTf = g.K((a)new h(this));
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
    this.Jda = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.Jdf = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fva());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.Jdg = paramContext;
    if (Jdh) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164360);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.JcS = g.K((a)new d(this));
    this.JcX = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rTf = g.K((a)new h(this));
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
    this.Jda = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.Jdf = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fva());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.Jdg = paramContext;
    if (Jdh) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.JcS = g.K((a)new d(this));
    this.JcX = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.rTf = g.K((a)new h(this));
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
    this.Jda = paramContext;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    this.Jdf = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fva());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.Jdg = paramContext;
    if (Jdh) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private final void F(final b<? super View, y> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.Jde)
    {
      final float f = getBackgroundView().getAlpha();
      this.Jde = true;
      this.Jda.a((a)new e(this, paramb), (ValueAnimator.AnimatorUpdateListener)new f(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  private final float fva()
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
    View localView = (View)this.JcS.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.rTf.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(164345);
    d.g.b.k.h(paramMotionEvent, "ev");
    Object localObject;
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.JyS;
      TouchableLayout.adA((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.JyS;
      TouchableLayout.adB((int)paramMotionEvent.getRawY());
    }
    this.JcX.onTouchEvent(paramMotionEvent);
    getTouchDetector().onTouchEvent(paramMotionEvent);
    this.JcT = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      ac.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.JcW + " isInitFinish=" + this.Jdd);
      this.JcU = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.JcW) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.JcY;
      if ((localObject == null) || (((b)localObject).onScaleBegin(this.JcX) != true)) {
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
      this.JcW = bool1;
      if (this.JcW)
      {
        localObject = MotionEvent.obtain(this.JcT);
        d.g.b.k.g(localObject, "cancelEvent");
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.JcW) {
        break;
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool1;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      bool1 = bool2;
      if (!Jdi)
      {
        bool1 = bool2;
        if (this.Jda.getContentViewScale()[0] >= 1.5F) {
          bool1 = true;
        }
      }
      this.JcV = bool1;
      ac.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.JcV + " isCanScale=" + this.JcW + " isInitFinish=" + this.Jdd);
      float f = paramMotionEvent.getX();
      localObject = this.JcU;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.JcV)) {
        break label454;
      }
      this.Jda.ai(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label454:
      fuZ();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    d.g.b.k.h(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (Jdh)
    {
      float f = this.Jdf;
      Object localObject = getContext();
      d.g.b.k.g(localObject, "context");
      localObject = ((Context)localObject).getResources();
      d.g.b.k.g(localObject, "context.resources");
      paramCanvas.drawLine(0.0F, f, ((Resources)localObject).getDisplayMetrics().widthPixels, this.Jdf, this.Jdg);
    }
    AppMethodBeat.o(164358);
  }
  
  public final void fuZ()
  {
    AppMethodBeat.i(164347);
    if (!this.JcZ)
    {
      this.JcZ = true;
      this.JcV = false;
      F((b)new g(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public final void gF(View paramView)
  {
    AppMethodBeat.i(164348);
    d.g.b.k.h(paramView, "touchView");
    this.ukI = paramView;
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
    this.Jdb = ((ViewGroup)localObject1);
    localObject1 = this.Jdb;
    if (localObject1 != null) {}
    for (int i = ((ViewGroup)localObject1).indexOfChild(paramView);; i = 0)
    {
      this.Jdc = i;
      localObject1 = this.Jdb;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView(paramView);
      }
      this.Jda.setBgView(getBackgroundView());
      localObject1 = this.Jda.getParent();
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
    ((ViewGroup)localObject1).removeView((View)this.Jda);
    label297:
    addView((View)this.Jda);
    this.Jda.setMinScaleFactor(1.0F);
    this.Jda.a(paramView, paramView.getWidth(), paramView.getHeight(), new Matrix(), CropLayout.e.Jeg, (b)new c(this, f1, f2));
    AppMethodBeat.o(164348);
  }
  
  public final void gG(View paramView)
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
  
  public final b getScaleListener()
  {
    return this.JcY;
  }
  
  public final View getTouchView()
  {
    return this.ukI;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    d.g.b.k.h(paramMotionEvent, "e");
    if (this.Jdd) {
      this.Jda.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    if ((this.Jdd) && (this.JcV)) {
      this.Jda.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    if ((this.Jdd) && (this.JcW))
    {
      this.Jda.onScale(paramScaleGestureDetector);
      b localb = this.JcY;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (d.g.b.k.g(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.Jda.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    boolean bool = this.JcW;
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
    if ((this.JcW) && (this.Jdd)) {
      this.Jda.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
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
    if (this.JcW)
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
    this.JcV = paramBoolean;
  }
  
  public final void setScaleListener(b paramb)
  {
    this.JcY = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.ukI = paramView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "libmmui_release"})
  public static abstract interface b
    extends ScaleGestureDetector.OnScaleGestureListener
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<View>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      TouchMediaPreviewLayout.i(this.Jdk).setAlpha(Math.min(f, 1.0F - f));
      AppMethodBeat.o(164339);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<View, y>
  {
    g(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */