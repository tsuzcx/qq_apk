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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableScroll", "setEnableScroll", "isEnableTouch", "setEnableTouch", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getScaleDetector", "()Landroid/view/ScaleGestureDetector;", "scaleDetector$delegate", "Lkotlin/Lazy;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "canScrollHorizontally", "direction", "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "event", "onTouchCancel", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TouchEventLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener
{
  private boolean GFm;
  private boolean GFn;
  private boolean GFo;
  private boolean GFp;
  private boolean GFq;
  private final j Gra;
  private final j agdO;
  
  public TouchEventLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164481);
    this.GFm = true;
    this.GFn = true;
    this.GFo = true;
    this.GFp = true;
    this.GFq = true;
    this.agdO = k.cm((kotlin.g.a.a)new a(this));
    this.Gra = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164481);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164482);
    this.GFm = true;
    this.GFn = true;
    this.GFo = true;
    this.GFp = true;
    this.GFq = true;
    this.agdO = k.cm((kotlin.g.a.a)new a(this));
    this.Gra = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164482);
  }
  
  public TouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164483);
    this.GFm = true;
    this.GFn = true;
    this.GFo = true;
    this.GFp = true;
    this.GFq = true;
    this.agdO = k.cm((kotlin.g.a.a)new a(this));
    this.Gra = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(164483);
  }
  
  private final ScaleGestureDetector getScaleDetector()
  {
    AppMethodBeat.i(164470);
    ScaleGestureDetector localScaleGestureDetector = (ScaleGestureDetector)this.agdO.getValue();
    AppMethodBeat.o(164470);
    return localScaleGestureDetector;
  }
  
  public void ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164480);
    s.u(paramMotionEvent, "e1");
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
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(164471);
    return localGestureDetector;
  }
  
  public final boolean jHA()
  {
    return this.GFp;
  }
  
  public final boolean jHB()
  {
    return this.GFq;
  }
  
  public final boolean jHy()
  {
    return this.GFm;
  }
  
  public final boolean jHz()
  {
    return this.GFo;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252632);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(252632);
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
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    boolean bool = this.GFo;
    AppMethodBeat.o(164476);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252616);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(252616);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164474);
    s.u(paramScaleGestureDetector, "detector");
    boolean bool = this.GFn;
    AppMethodBeat.o(164474);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164473);
    s.u(paramScaleGestureDetector, "detector");
    boolean bool = this.GFn;
    AppMethodBeat.o(164473);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164475);
    s.u(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(164475);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164479);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    AppMethodBeat.o(164479);
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164477);
    s.u(paramMotionEvent, "e");
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
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    s.u(paramMotionEvent, "e");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(164478);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164472);
    s.u(paramView, "v");
    s.u(paramMotionEvent, "event");
    if (!this.GFm)
    {
      AppMethodBeat.o(164472);
      return false;
    }
    if (this.GFn) {
      getScaleDetector().onTouchEvent(paramMotionEvent);
    }
    paramView = getTouchDetector();
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      ap(paramMotionEvent);
    }
    AppMethodBeat.o(164472);
    return true;
  }
  
  public void setEnableFling(boolean paramBoolean)
  {
    this.GFo = paramBoolean;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.GFp = paramBoolean;
  }
  
  public void setEnableScale(boolean paramBoolean)
  {
    this.GFn = paramBoolean;
  }
  
  public void setEnableScroll(boolean paramBoolean)
  {
    this.GFq = paramBoolean;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    this.GFm = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ScaleGestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ScaleGestureDetector>
  {
    a(TouchEventLayout paramTouchEventLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
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