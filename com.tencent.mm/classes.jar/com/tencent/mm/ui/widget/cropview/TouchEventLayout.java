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
import com.tencent.mm.hellhoundlib.b.b;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableTouch", "setEnableTouch", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getScaleDetector", "()Landroid/view/ScaleGestureDetector;", "scaleDetector$delegate", "Lkotlin/Lazy;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "event", "onTouchCancel", "libmmui_release"})
public class TouchEventLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener
{
  private boolean KVU;
  private boolean KVV;
  private boolean KVW;
  boolean KVX;
  private final f KVY;
  private final f sPP;
  
  public TouchEventLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164481);
    this.KVU = true;
    this.KVV = true;
    this.KVW = true;
    this.KVX = true;
    this.KVY = g.O((d.g.a.a)new a(this));
    this.sPP = g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(164481);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164482);
    this.KVU = true;
    this.KVV = true;
    this.KVW = true;
    this.KVX = true;
    this.KVY = g.O((d.g.a.a)new a(this));
    this.sPP = g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(164482);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164483);
    this.KVU = true;
    this.KVV = true;
    this.KVW = true;
    this.KVX = true;
    this.KVY = g.O((d.g.a.a)new a(this));
    this.sPP = g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(164483);
  }
  
  private final ScaleGestureDetector getScaleDetector()
  {
    AppMethodBeat.i(164470);
    ScaleGestureDetector localScaleGestureDetector = (ScaleGestureDetector)this.KVY.getValue();
    AppMethodBeat.o(164470);
    return localScaleGestureDetector;
  }
  
  public void ak(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164480);
    p.h(paramMotionEvent, "e1");
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
  
  protected final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(164471);
    GestureDetector localGestureDetector = (GestureDetector)this.sPP.getValue();
    AppMethodBeat.o(164471);
    return localGestureDetector;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186644);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186644);
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
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    boolean bool = this.KVW;
    AppMethodBeat.o(164476);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186643);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(186643);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164474);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.KVV;
    AppMethodBeat.o(164474);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164473);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.KVV;
    AppMethodBeat.o(164473);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164475);
    p.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164475);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164479);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    AppMethodBeat.o(164479);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164477);
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(164477);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164478);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    p.h(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164478);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164472);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    if (!this.KVU)
    {
      AppMethodBeat.o(164472);
      return false;
    }
    if (this.KVV) {
      getScaleDetector().onTouchEvent(paramMotionEvent);
    }
    paramView = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, locala.ahp(), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      ak(paramMotionEvent);
    }
    AppMethodBeat.o(164472);
    return true;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.KVW = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.KVX = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.KVV = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.KVU = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ScaleGestureDetector>
  {
    a(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<GestureDetector>
  {
    b(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.TouchEventLayout
 * JD-Core Version:    0.7.0.1
 */