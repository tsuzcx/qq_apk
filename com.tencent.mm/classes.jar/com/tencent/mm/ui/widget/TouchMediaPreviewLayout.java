package com.tencent.mm.ui.widget;

import android.animation.ValueAnimator;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "finishCall", "Lkotlin/Function0;", "Companion", "OnScaleListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TouchMediaPreviewLayout
  extends FrameLayout
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  public static final TouchMediaPreviewLayout.a afVG;
  private static boolean afVT;
  private static boolean afVU;
  private int GQG;
  private final j Gra;
  private View Kqo;
  private final Paint Usf;
  private final j afVH;
  private MotionEvent afVI;
  public boolean afVJ;
  private boolean afVK;
  private ScaleGestureDetector afVL;
  private TouchMediaPreviewLayout.b afVM;
  private boolean afVN;
  private final DragExitCropLayout afVO;
  private ViewGroup afVP;
  private boolean afVQ;
  private boolean afVR;
  private final float afVS;
  private MotionEvent lastMotionEvent;
  
  static
  {
    AppMethodBeat.i(164342);
    afVG = new TouchMediaPreviewLayout.a((byte)0);
    afVU = true;
    AppMethodBeat.o(164342);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164361);
    this.afVH = k.cm((kotlin.g.a.a)new c(this));
    this.afVL = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.Gra = k.cm((kotlin.g.a.a)new f(this));
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramContext.setBackgroundColor(paramContext.getContext().getResources().getColor(17170445));
    paramAttributeSet = ah.aiuX;
    this.afVO = paramContext;
    this.afVS = (getContext().getResources().getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(jFi());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    paramAttributeSet = ah.aiuX;
    this.Usf = paramContext;
    if (afVT) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164361);
  }
  
  public TouchMediaPreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164362);
    this.afVH = k.cm((kotlin.g.a.a)new c(this));
    this.afVL = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)this);
    this.Gra = k.cm((kotlin.g.a.a)new f(this));
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new DragExitCropLayout(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext.setTag("TouchPhotoLayout");
    paramContext.setEnableTouch(false);
    paramContext.setHasBorder(false);
    paramContext.setEnableOverScroll(false);
    paramContext.setEnableDragExit(true);
    paramContext.setBackgroundColor(paramContext.getContext().getResources().getColor(17170445));
    paramAttributeSet = ah.aiuX;
    this.afVO = paramContext;
    this.afVS = (getContext().getResources().getDisplayMetrics().heightPixels * 0.4F);
    paramContext = new Paint(1);
    paramContext.setStrokeWidth(jFi());
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setColor(-16711936);
    paramAttributeSet = ah.aiuX;
    this.Usf = paramContext;
    if (afVT) {
      setBackgroundColor(0);
    }
    AppMethodBeat.o(164362);
  }
  
  private static final void a(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, float paramFloat, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(251771);
    s.u(paramTouchMediaPreviewLayout, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue("percent");
    if (paramValueAnimator == null)
    {
      paramTouchMediaPreviewLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(251771);
      throw paramTouchMediaPreviewLayout;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramTouchMediaPreviewLayout.getBackgroundView().setAlpha(Math.min(paramFloat, 1.0F - f));
    AppMethodBeat.o(251771);
  }
  
  private final void aV(final kotlin.g.a.b<? super View, ah> paramb)
  {
    AppMethodBeat.i(164349);
    if (!this.afVR)
    {
      float f = getBackgroundView().getAlpha();
      this.afVR = true;
      this.afVO.a((kotlin.g.a.a)new d(this, paramb), new TouchMediaPreviewLayout..ExternalSyntheticLambda0(this, f));
    }
    AppMethodBeat.o(164349);
  }
  
  private final View getBackgroundView()
  {
    AppMethodBeat.i(164343);
    View localView = (View)this.afVH.getValue();
    AppMethodBeat.o(164343);
    return localView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164344);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(164344);
    return localGestureDetector;
  }
  
  private final float jFi()
  {
    AppMethodBeat.i(164359);
    float f = TypedValue.applyDimension(1, 2.0F, getContext().getResources().getDisplayMetrics());
    AppMethodBeat.o(164359);
    return f;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164345);
    s.u(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      localObject = TouchableLayout.agKp;
      TouchableLayout.aFX((int)paramMotionEvent.getRawX());
      localObject = TouchableLayout.agKp;
      TouchableLayout.aFY((int)paramMotionEvent.getRawY());
    }
    this.afVL.onTouchEvent(paramMotionEvent);
    Object localObject = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    this.lastMotionEvent = paramMotionEvent;
    if (paramMotionEvent.getAction() == 0)
    {
      Log.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.afVK + " isInitFinish=" + this.afVQ);
      this.afVI = MotionEvent.obtain(paramMotionEvent);
    }
    if ((!this.afVK) && ((paramMotionEvent.getAction() & 0xFF) == 5) && (paramMotionEvent.getPointerCount() == 2))
    {
      localObject = this.afVM;
      if ((localObject == null) || (((TouchMediaPreviewLayout.b)localObject).onScaleBegin(this.afVL) != true)) {
        break label351;
      }
    }
    label351:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        getBackgroundView().setTag(Boolean.TRUE);
        getBackgroundView().setAlpha(0.0F);
        getBackgroundView().setVisibility(0);
      }
      this.afVK = bool;
      if (this.afVK)
      {
        localObject = MotionEvent.obtain(this.lastMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      if (this.afVK) {
        break;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164345);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      if ((afVU) || (this.afVO.getContentViewScale()[0] < 1.5F)) {
        break label508;
      }
      bool = true;
      this.afVJ = bool;
      Log.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.afVJ + " isCanScale=" + this.afVK + " isInitFinish=" + this.afVQ);
      float f = paramMotionEvent.getX();
      localObject = this.afVI;
      s.checkNotNull(localObject);
      if ((Math.abs(f - ((MotionEvent)localObject).getX()) < 5.0F) || (!this.afVJ)) {
        break label513;
      }
      this.afVO.ap(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(164345);
      return true;
      label508:
      bool = false;
      break;
      label513:
      jFh();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164358);
    s.u(paramCanvas, "canvas");
    super.draw(paramCanvas);
    if (afVT) {
      paramCanvas.drawLine(0.0F, this.afVS, getContext().getResources().getDisplayMetrics().widthPixels, this.afVS, this.Usf);
    }
    AppMethodBeat.o(164358);
  }
  
  public final TouchMediaPreviewLayout.b getScaleListener()
  {
    return this.afVM;
  }
  
  public final View getTouchView()
  {
    return this.Kqo;
  }
  
  public final void jFh()
  {
    AppMethodBeat.i(164347);
    if (!this.afVN)
    {
      this.afVN = true;
      this.afVJ = false;
      aV((kotlin.g.a.b)new e(this));
    }
    AppMethodBeat.o(164347);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164351);
    s.u(paramMotionEvent, "e");
    if (this.afVQ) {
      this.afVO.onDown(paramMotionEvent);
    }
    AppMethodBeat.o(164351);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164352);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if ((this.afVQ) && (this.afVJ)) {
      this.afVO.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164352);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251861);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(251861);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164357);
    s.u(paramScaleGestureDetector, "detector");
    if ((this.afVQ) && (this.afVK))
    {
      this.afVO.onScale(paramScaleGestureDetector);
      TouchMediaPreviewLayout.b localb = this.afVM;
      if (localb != null) {
        localb.onScale(paramScaleGestureDetector);
      }
      if (s.p(getBackgroundView().getTag(), Boolean.TRUE)) {
        getBackgroundView().animate().cancel();
      }
      getBackgroundView().setAlpha((this.afVO.getContentViewScale()[0] - 1.0F) / 0.5F);
    }
    AppMethodBeat.o(164357);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164355);
    s.u(paramScaleGestureDetector, "detector");
    boolean bool = this.afVK;
    AppMethodBeat.o(164355);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164356);
    s.u(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164356);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164353);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if ((this.afVK) && (this.afVQ)) {
      this.afVO.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(164353);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164350);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    s.u(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164350);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164346);
    if (this.afVK)
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
    this.afVJ = paramBoolean;
  }
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    this.afVM = paramb;
  }
  
  public final void setTouchView(View paramView)
  {
    this.Kqo = paramView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, kotlin.g.a.b<? super View, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    e(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<GestureDetector>
  {
    f(TouchMediaPreviewLayout paramTouchMediaPreviewLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.TouchMediaPreviewLayout
 * JD-Core Version:    0.7.0.1
 */