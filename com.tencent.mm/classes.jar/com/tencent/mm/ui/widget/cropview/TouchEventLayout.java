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
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableScroll", "setEnableScroll", "isEnableTouch", "setEnableTouch", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getScaleDetector", "()Landroid/view/ScaleGestureDetector;", "scaleDetector$delegate", "Lkotlin/Lazy;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "event", "onTouchCancel", "libmmui_release"})
public class TouchEventLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener
{
  protected boolean AwT;
  private boolean QNi;
  boolean QNj;
  boolean QNk;
  boolean QNl;
  private final f QNm;
  private final f wbH;
  
  public TouchEventLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164481);
    this.AwT = true;
    this.QNi = true;
    this.QNj = true;
    this.QNk = true;
    this.QNl = true;
    this.QNm = g.ah((kotlin.g.a.a)new a(this));
    this.wbH = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164481);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164482);
    this.AwT = true;
    this.QNi = true;
    this.QNj = true;
    this.QNk = true;
    this.QNl = true;
    this.QNm = g.ah((kotlin.g.a.a)new a(this));
    this.wbH = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164482);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164483);
    this.AwT = true;
    this.QNi = true;
    this.QNj = true;
    this.QNk = true;
    this.QNl = true;
    this.QNm = g.ah((kotlin.g.a.a)new a(this));
    this.wbH = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164483);
  }
  
  private final ScaleGestureDetector getScaleDetector()
  {
    AppMethodBeat.i(164470);
    ScaleGestureDetector localScaleGestureDetector = (ScaleGestureDetector)this.QNm.getValue();
    AppMethodBeat.o(164470);
    return localScaleGestureDetector;
  }
  
  public void ad(MotionEvent paramMotionEvent)
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
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(164471);
    return localGestureDetector;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204910);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(204910);
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
    boolean bool = this.QNj;
    AppMethodBeat.o(164476);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204909);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(204909);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164474);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.QNi;
    AppMethodBeat.o(164474);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164473);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = this.QNi;
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
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
    if (!this.AwT)
    {
      AppMethodBeat.o(164472);
      return false;
    }
    if (this.QNi) {
      getScaleDetector().onTouchEvent(paramMotionEvent);
    }
    paramView = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, locala.axQ(), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      ad(paramMotionEvent);
    }
    AppMethodBeat.o(164472);
    return true;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.QNj = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.QNk = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.QNi = paramBoolean;
  }
  
  public void setEnableScroll(boolean paramBoolean)
  {
    this.QNl = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.AwT = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ScaleGestureDetector>
  {
    a(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<GestureDetector>
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