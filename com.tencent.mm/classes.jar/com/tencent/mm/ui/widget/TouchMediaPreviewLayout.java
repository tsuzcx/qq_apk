package com.tencent.mm.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.DragExitCropLayout;
import com.tencent.mm.view.TouchableLayout;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "finishCall", "Lkotlin/Function0;", "Companion", "OnScaleListener", "libmmui_release"})
public class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static boolean QFC;
  private static boolean QFD;
  public static final TouchMediaPreviewLayout.a QFE;
  private final Paint GQi;
  private boolean QFA;
  private final float QFB;
  private final f QFq;
  private MotionEvent QFr;
  public boolean QFs;
  private boolean QFt;
  private ScaleGestureDetector QFu;
  private TouchMediaPreviewLayout.b QFv;
  private boolean QFw;
  private final DragExitCropLayout QFx;
  private ViewGroup QFy;
  private boolean QFz;
  private MotionEvent aXM;
  private final f wbH;
  private int wxy;
  private View yTH;
  
  static
  {
    AppMethodBeat.i(164342);
    QFE = new TouchMediaPreviewLayout.a((byte)0);
    QFD = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.QFq = g.ah((kotlin.g.a.a)new c(this));
    this.QFu = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.wbH = g.ah((kotlin.g.a.a)new g(this));
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
    this.QFx = paramContext;
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.QFB = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(gZl());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.GQi = paramContext;
    if (QFC) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.QFq = g.ah((kotlin.g.a.a)new c(this));
    this.QFu = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.wbH = g.ah((kotlin.g.a.a)new g(this));
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
    this.QFx = paramContext;
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.QFB = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(gZl());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.GQi = paramContext;
    if (QFC) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private final void Q(final kotlin.g.a.b<? super View, x> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.QFA)
    {
      final float f = getBackgroundView().getAlpha();
      this.QFA = true;
      this.QFx.a((kotlin.g.a.a)new d(this, paramb), (ValueAnimator.AnimatorUpdateListener)new e(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  private final float gZl()
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
    View localView = (View)this.QFq.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164345);
    p.h(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.Rni;
      TouchableLayout.apU((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.Rni;
      TouchableLayout.apV((int)paramMotionEvent.getRawY());
    }
    this.QFu.onTouchEvent(paramMotionEvent);
    Object localObject = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    this.aXM = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      Log.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.QFt + " isInitFinish=" + this.QFz);
      this.QFr = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.QFt) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.QFv;
      if ((localObject == null) || (((TouchMediaPreviewLayout.b)localObject).onScaleBegin(this.QFu) != true)) {
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
      this.QFt = bool;
      if (this.QFt)
      {
        localObject = MotionEvent.obtain(this.aXM);
        p.g(localObject, "cancelEvent");
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.QFt) {
        break;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if ((QFD) || (this.QFx.getContentViewScale()[0] < 1.5F)) {
        break label519;
      }
      bool = true;
      this.QFs = bool;
      Log.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.QFs + " isCanScale=" + this.QFt + " isInitFinish=" + this.QFz);
      float f = paramMotionEvent.getX();
      localObject = this.QFr;
      if (localObject == null) {
        p.hyc();
      }
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.QFs)) {
        break label524;
      }
      this.QFx.ad(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label519:
      bool = false;
      break;
      label524:
      gZk();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    p.h(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (QFC)
    {
      float f = this.QFB;
      Object localObject = getContext();
      p.g(localObject, "context");
      localObject = ((Context)localObject).getResources();
      p.g(localObject, "context.resources");
      paramCanvas.drawLine(0.0F, f, ((Resources)localObject).getDisplayMetrics().widthPixels, this.QFB, this.GQi);
    }
    AppMethodBeat.o(164358);
  }
  
  public final void gZk()
  {
    AppMethodBeat.i(164347);
    if (!this.QFw)
    {
      this.QFw = true;
      this.QFs = false;
      Q((kotlin.g.a.b)new f(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public final TouchMediaPreviewLayout.b getScaleListener()
  {
    return this.QFv;
  }
  
  public final View getTouchView()
  {
    return this.yTH;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    p.h(paramMotionEvent, "e");
    if (this.QFz) {
      this.QFx.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    if ((this.QFz) && (this.QFs)) {
      this.QFx.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204893);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(204893);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    p.h(paramScaleGestureDetector, "detector");
    if ((this.QFz) && (this.QFt))
    {
      this.QFx.onScale(paramScaleGestureDetector);
      TouchMediaPreviewLayout.b localb = this.QFv;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (p.j(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.QFx.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.QFt;
    AppMethodBeat.o(164355);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164356);
    p.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164356);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164353);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    if ((this.QFt) && (this.QFz)) {
      this.QFx.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164353);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164350);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164350);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164346);
    if (this.QFt)
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
    this.QFs = paramBoolean;
  }
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    this.QFv = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.yTH = paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(164339);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("percent");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(164339);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      TouchMediaPreviewLayout.j(this.QFF).setAlpha(Math.min(f, 1.0F - f));
      AppMethodBeat.o(164339);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<View, x>
  {
    f(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    g(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */