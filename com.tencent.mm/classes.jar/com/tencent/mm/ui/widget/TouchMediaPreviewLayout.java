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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "finishCall", "Lkotlin/Function0;", "Companion", "OnScaleListener", "libmmui_release"})
public class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static boolean YdY;
  private static boolean YdZ;
  public static final a Yea;
  private final f AOG;
  private int BlP;
  private View ExE;
  private final Paint NFZ;
  private final f YdM;
  private MotionEvent YdN;
  public boolean YdO;
  private boolean YdP;
  private ScaleGestureDetector YdQ;
  private b YdR;
  private boolean YdS;
  private final DragExitCropLayout YdT;
  private ViewGroup YdU;
  private boolean YdV;
  private boolean YdW;
  private final float YdX;
  private MotionEvent aHh;
  
  static
  {
    AppMethodBeat.i(164342);
    Yea = new a((byte)0);
    YdZ = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.YdM = g.ar((kotlin.g.a.a)new c(this));
    this.YdQ = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.AOG = g.ar((kotlin.g.a.a)new g(this));
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    p.j(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.YdT = paramContext;
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = paramContext.getResources();
    p.j(paramContext, "context.resources");
    this.YdX = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(iab());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.NFZ = paramContext;
    if (YdY) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.YdM = g.ar((kotlin.g.a.a)new c(this));
    this.YdQ = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.AOG = g.ar((kotlin.g.a.a)new g(this));
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramAttributeSet = paramContext.getContext();
    p.j(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(17170445));
    this.YdT = paramContext;
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = paramContext.getResources();
    p.j(paramContext, "context.resources");
    this.YdX = (paramContext.getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(iab());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    this.NFZ = paramContext;
    if (YdY) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private final void ae(final kotlin.g.a.b<? super View, x> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.YdW)
    {
      final float f = getBackgroundView().getAlpha();
      this.YdW = true;
      this.YdT.a((kotlin.g.a.a)new d(this, paramb), (ValueAnimator.AnimatorUpdateListener)new e(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  private final View getBackgroundView()
  {
    AppMethodBeat.i(164343);
    View localView = (View)this.YdM.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  private final float iab()
  {
    AppMethodBeat.i(164359);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "context.resources");
    float f = TypedValue.applyDimension(1, 2.0F, ((Resources)localObject).getDisplayMetrics());
    AppMethodBeat.o(164359);
    return f;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164345);
    p.k(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.YOD;
      TouchableLayout.azt((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.YOD;
      TouchableLayout.azu((int)paramMotionEvent.getRawY());
    }
    this.YdQ.onTouchEvent(paramMotionEvent);
    Object localObject = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    this.aHh = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      Log.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.YdP + " isInitFinish=" + this.YdV);
      this.YdN = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.YdP) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.YdR;
      if ((localObject == null) || (((b)localObject).onScaleBegin(this.YdQ) != true)) {
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
      this.YdP = bool;
      if (this.YdP)
      {
        localObject = MotionEvent.obtain(this.aHh);
        p.j(localObject, "cancelEvent");
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.YdP) {
        break;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if ((YdZ) || (this.YdT.getContentViewScale()[0] < 1.5F)) {
        break label519;
      }
      bool = true;
      this.YdO = bool;
      Log.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.YdO + " isCanScale=" + this.YdP + " isInitFinish=" + this.YdV);
      float f = paramMotionEvent.getX();
      localObject = this.YdN;
      if (localObject == null) {
        p.iCn();
      }
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.YdO)) {
        break label524;
      }
      this.YdT.am(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label519:
      bool = false;
      break;
      label524:
      iaa();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    p.k(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (YdY)
    {
      float f = this.YdX;
      Object localObject = getContext();
      p.j(localObject, "context");
      localObject = ((Context)localObject).getResources();
      p.j(localObject, "context.resources");
      paramCanvas.drawLine(0.0F, f, ((Resources)localObject).getDisplayMetrics().widthPixels, this.YdX, this.NFZ);
    }
    AppMethodBeat.o(164358);
  }
  
  public final b getScaleListener()
  {
    return this.YdR;
  }
  
  public final View getTouchView()
  {
    return this.ExE;
  }
  
  public final void iaa()
  {
    AppMethodBeat.i(164347);
    if (!this.YdS)
    {
      this.YdS = true;
      this.YdO = false;
      ae((kotlin.g.a.b)new f(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    p.k(paramMotionEvent, "e");
    if (this.YdV) {
      this.YdT.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    if ((this.YdV) && (this.YdO)) {
      this.YdT.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193550);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(193550);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    p.k(paramScaleGestureDetector, "detector");
    if ((this.YdV) && (this.YdP))
    {
      this.YdT.onScale(paramScaleGestureDetector);
      b localb = this.YdR;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (p.h(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.YdT.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    p.k(paramScaleGestureDetector, "detector");
    boolean bool = this.YdP;
    AppMethodBeat.o(164355);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164356);
    p.k(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164356);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164353);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    if ((this.YdP) && (this.YdV)) {
      this.YdT.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164353);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164350);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    p.k(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164350);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164346);
    if (this.YdP)
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
    this.YdO = paramBoolean;
  }
  
  public final void setScaleListener(b paramb)
  {
    this.YdR = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.ExE = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "INIT_BG_ALPHA", "", "TAG", "", "isRevertImmediately", "", "()Z", "setRevertImmediately", "(Z)V", "isShowVideoBaseLine", "setShowVideoBaseLine", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "libmmui_release"})
  public static abstract interface b
    extends ScaleGestureDetector.OnScaleGestureListener
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      TouchMediaPreviewLayout.j(this.Yeb).setAlpha(Math.min(f, 1.0F - f));
      AppMethodBeat.o(164339);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<View, x>
  {
    f(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */