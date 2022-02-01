package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableTouch", "setEnableTouch", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getScaleDetector", "()Landroid/view/ScaleGestureDetector;", "scaleDetector$delegate", "Lkotlin/Lazy;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "event", "onTouchCancel", "libmmui_release"})
public class TouchEventLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener
{
  private boolean JeL;
  private boolean JeM;
  private boolean JeN;
  boolean JeO;
  private final f JeP;
  private final f rTf;
  
  static
  {
    AppMethodBeat.i(164469);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(TouchEventLayout.class), "scaleDetector", "getScaleDetector()Landroid/view/ScaleGestureDetector;")), (d.l.k)w.a(new u(w.bn(TouchEventLayout.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")) };
    AppMethodBeat.o(164469);
  }
  
  public TouchEventLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164481);
    this.JeL = true;
    this.JeM = true;
    this.JeN = true;
    this.JeO = true;
    this.JeP = g.K((a)new a(this));
    this.rTf = g.K((a)new b(this));
    AppMethodBeat.o(164481);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164482);
    this.JeL = true;
    this.JeM = true;
    this.JeN = true;
    this.JeO = true;
    this.JeP = g.K((a)new a(this));
    this.rTf = g.K((a)new b(this));
    AppMethodBeat.o(164482);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164483);
    this.JeL = true;
    this.JeM = true;
    this.JeN = true;
    this.JeO = true;
    this.JeP = g.K((a)new a(this));
    this.rTf = g.K((a)new b(this));
    AppMethodBeat.o(164483);
  }
  
  private final ScaleGestureDetector getScaleDetector()
  {
    AppMethodBeat.i(164470);
    ScaleGestureDetector localScaleGestureDetector = (ScaleGestureDetector)this.JeP.getValue();
    AppMethodBeat.o(164470);
    return localScaleGestureDetector;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164471);
    GestureDetector localGestureDetector = (GestureDetector)this.rTf.getValue();
    AppMethodBeat.o(164471);
    return localGestureDetector;
  }
  
  public void ai(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164480);
    d.g.b.k.h(paramMotionEvent, "e1");
    AppMethodBeat.o(164480);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164476);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    boolean bool = this.JeN;
    AppMethodBeat.o(164476);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164474);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    boolean bool = this.JeM;
    AppMethodBeat.o(164474);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164473);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    boolean bool = this.JeM;
    AppMethodBeat.o(164473);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164475);
    d.g.b.k.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164475);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164479);
    d.g.b.k.h(paramMotionEvent1, "e1");
    d.g.b.k.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(164479);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164477);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(164477);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164478);
    d.g.b.k.h(paramMotionEvent, "e");
    AppMethodBeat.o(164478);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164472);
    d.g.b.k.h(paramView, "v");
    d.g.b.k.h(paramMotionEvent, "event");
    if (!this.JeL)
    {
      AppMethodBeat.o(164472);
      return false;
    }
    if (this.JeM) {
      getScaleDetector().onTouchEvent(paramMotionEvent);
    }
    getTouchDetector().onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      ai(paramMotionEvent);
    }
    AppMethodBeat.o(164472);
    return true;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.JeN = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.JeO = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.JeM = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.JeL = paramBoolean;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<ScaleGestureDetector>
  {
    a(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<GestureDetector>
  {
    b(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.TouchEventLayout
 * JD-Core Version:    0.7.0.1
 */