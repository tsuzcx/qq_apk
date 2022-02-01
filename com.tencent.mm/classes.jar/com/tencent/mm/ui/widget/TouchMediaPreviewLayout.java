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
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.cropview.DragExitCropLayout;
import com.tencent.mm.view.TouchableLayout;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "Companion", "OnScaleListener", "libmmui_release"})
public final class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static boolean KUp;
  private static boolean KUq;
  public static final TouchMediaPreviewLayout.a KUr;
  private final f KUa;
  private MotionEvent KUb;
  private MotionEvent KUc;
  public boolean KUd;
  private boolean KUe;
  private ScaleGestureDetector KUf;
  private TouchMediaPreviewLayout.b KUg;
  private boolean KUh;
  private final DragExitCropLayout KUi;
  private ViewGroup KUj;
  private int KUk;
  private boolean KUl;
  private boolean KUm;
  private final float KUn;
  private final Paint KUo;
  private final f sPP;
  private View vno;
  
  static
  {
    AppMethodBeat.i(164342);
    KUr = new TouchMediaPreviewLayout.a((byte)0);
    KUq = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164360);
    this.KUa = g.O((d.g.a.a)new d(this));
    this.KUf = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.sPP = g.O((d.g.a.a)new h(this));
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    Context localContext = paramContext.getContext();
    p.g(localContext, "context");
    paramContext.setBackgroundColor(localContext.getResources().getColor(17170445));
    this.KUi = paramContext;
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.KUn = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fLN());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.KUo = paramContext;
    if (KUp) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164360);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.KUa = g.O((d.g.a.a)new d(this));
    this.KUf = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.sPP = g.O((d.g.a.a)new h(this));
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.KUi = paramContext;
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.KUn = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fLN());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.KUo = paramContext;
    if (KUp) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.KUa = g.O((d.g.a.a)new d(this));
    this.KUf = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.sPP = g.O((d.g.a.a)new h(this));
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.KUi = paramContext;
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.KUn = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(fLN());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.KUo = paramContext;
    if (KUp) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private final void F(final d.g.a.b<? super View, z> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.KUm)
    {
      final float f = getBackgroundView().getAlpha();
      this.KUm = true;
      this.KUi.a((d.g.a.a)new e(this, paramb), (ValueAnimator.AnimatorUpdateListener)new f(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  private final float fLN()
  {
    AppMethodBeat.i(164359);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    float f = TypedValue.applyDimension(1, 2.0F, ((Resources)localObject).getDisplayMetrics());
    AppMethodBeat.o(164359);
    return f;
  }
  
  private final View getBackgroundView()
  {
    AppMethodBeat.i(164343);
    View localView = (View)this.KUa.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.sPP.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164345);
    p.h(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.LrZ;
      TouchableLayout.aga((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.LrZ;
      TouchableLayout.agb((int)paramMotionEvent.getRawY());
    }
    this.KUf.onTouchEvent(paramMotionEvent);
    Object localObject = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    this.KUb = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      ad.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.KUe + " isInitFinish=" + this.KUl);
      this.KUc = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.KUe) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.KUg;
      if ((localObject == null) || (((TouchMediaPreviewLayout.b)localObject).onScaleBegin(this.KUf) != true)) {
        break label359;
      }
    }
    label359:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        getBackgroundView().setTag(Boolean.TRUE);
        getBackgroundView().setAlpha(0.0F);
        getBackgroundView().setVisibility(0);
      }
      this.KUe = bool;
      if (this.KUe)
      {
        localObject = MotionEvent.obtain(this.KUb);
        p.g(localObject, "cancelEvent");
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.KUe) {
        break;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if ((KUq) || (this.KUi.getContentViewScale()[0] < 1.5F)) {
        break label519;
      }
      bool = true;
      this.KUd = bool;
      ad.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.KUd + " isCanScale=" + this.KUe + " isInitFinish=" + this.KUl);
      float f = paramMotionEvent.getX();
      localObject = this.KUc;
      if (localObject == null) {
        p.gfZ();
      }
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.KUd)) {
        break label524;
      }
      this.KUi.ak(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label519:
      bool = false;
      break;
      label524:
      fLM();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    p.h(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (KUp)
    {
      float f = this.KUn;
      Object localObject = getContext();
      p.g(localObject, "context");
      localObject = ((Context)localObject).getResources();
      p.g(localObject, "context.resources");
      paramCanvas.drawLine(0.0F, f, ((Resources)localObject).getDisplayMetrics().widthPixels, this.KUn, this.KUo);
    }
    AppMethodBeat.o(164358);
  }
  
  public final void fLM()
  {
    AppMethodBeat.i(164347);
    if (!this.KUh)
    {
      this.KUh = true;
      this.KUd = false;
      F((d.g.a.b)new g(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public final void gW(View paramView)
  {
    AppMethodBeat.i(164348);
    p.h(paramView, "touchView");
    this.vno = paramView;
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
    this.KUj = ((ViewGroup)localObject1);
    localObject1 = this.KUj;
    if (localObject1 != null) {}
    for (int i = ((ViewGroup)localObject1).indexOfChild(paramView);; i = 0)
    {
      this.KUk = i;
      localObject1 = this.KUj;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView(paramView);
      }
      this.KUi.setBgView(getBackgroundView());
      localObject1 = this.KUi.getParent();
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
    ((ViewGroup)localObject1).removeView((View)this.KUi);
    label297:
    addView((View)this.KUi);
    this.KUi.setMinScaleFactor(1.0F);
    this.KUi.a(paramView, paramView.getWidth(), paramView.getHeight(), new Matrix(), CropLayout.e.KVo, (d.g.a.b)new c(this, f1, f2));
    AppMethodBeat.o(164348);
  }
  
  public final void gX(View paramView)
  {
    AppMethodBeat.i(164354);
    p.h(paramView, "view");
    paramView = (ViewGroup)paramView;
    View localView = paramView.getChildAt(0);
    paramView.removeView(localView);
    addView(localView, 0);
    paramView.addView((View)this, 0);
    AppMethodBeat.o(164354);
  }
  
  public final TouchMediaPreviewLayout.b getScaleListener()
  {
    return this.KUg;
  }
  
  public final View getTouchView()
  {
    return this.vno;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    p.h(paramMotionEvent, "e");
    if (this.KUl) {
      this.KUi.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    if ((this.KUl) && (this.KUd)) {
      this.KUi.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186631);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(186631);
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    p.h(paramScaleGestureDetector, "detector");
    if ((this.KUl) && (this.KUe))
    {
      this.KUi.onScale(paramScaleGestureDetector);
      TouchMediaPreviewLayout.b localb = this.KUg;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (p.i(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.KUi.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.KUe;
    AppMethodBeat.o(164355);
    return bool;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164356);
    p.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164356);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164353);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    if ((this.KUe) && (this.KUl)) {
      this.KUi.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164353);
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164350);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164350);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164346);
    if (this.KUe)
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
    this.KUd = paramBoolean;
  }
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    this.KUg = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.vno = paramView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Matrix, Boolean>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<View>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      TouchMediaPreviewLayout.i(this.KUs).setAlpha(Math.min(f, 1.0F - f));
      AppMethodBeat.o(164339);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<View, z>
  {
    g(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<GestureDetector>
  {
    h(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */