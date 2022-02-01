package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onInterceptTouchEventCallback", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "getOnInterceptTouchEventCallback", "()Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "setOnInterceptTouchEventCallback", "(Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;)V", "onLongClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;)V", "onScaleListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "getOnScaleListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "setOnScaleListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;)V", "onScrollListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "getOnScrollListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "setOnScrollListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "canScrollHorizontally", "", "direction", "canScrollVertically", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onDoubleTap", "e", "onInterceptTouchEvent", "ev", "onLongPress", "", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapConfirmed", "onTouch", "v", "Landroid/view/View;", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Companion", "OnDoubleClickListener", "OnInterceptTouchEventCallback", "OnLongClickListener", "OnScaleListener", "OnScrollListener", "OnSingleClickListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class HardTouchableLayout
  extends TouchEventLayout
{
  public static final a agGK;
  private static int qjs;
  private static int qjt;
  private g GBr;
  private b GBs;
  private d GBt;
  private f agGL;
  private e agGM;
  private c agGN;
  
  static
  {
    AppMethodBeat.i(164513);
    agGK = new a((byte)0);
    AppMethodBeat.o(164513);
  }
  
  public HardTouchableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164511);
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(164511);
  }
  
  public HardTouchableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164512);
    setEnableFling(false);
    setEnableOverScroll(false);
    setEnableScale(false);
    AppMethodBeat.o(164512);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(235176);
    boolean bool = jHy();
    AppMethodBeat.o(235176);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(235173);
    boolean bool = jHy();
    AppMethodBeat.o(235173);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164501);
    s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      qjs = (int)paramMotionEvent.getRawX();
      qjt = (int)paramMotionEvent.getRawY();
    }
    super.onTouch((View)this, paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      ap(paramMotionEvent);
      if (this.agGL == null) {}
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164501);
      return bool;
      paramMotionEvent.getAction();
    }
  }
  
  public final b getOnDoubleClickListener()
  {
    return this.GBs;
  }
  
  public final c getOnInterceptTouchEventCallback()
  {
    return this.agGN;
  }
  
  public final d getOnLongClickListener()
  {
    return this.GBt;
  }
  
  public final e getOnScaleListener()
  {
    return this.agGM;
  }
  
  public final f getOnScrollListener()
  {
    return this.agGL;
  }
  
  public final g getOnSingleClickListener()
  {
    return this.GBr;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164507);
    if (paramMotionEvent != null)
    {
      b localb = getOnDoubleClickListener();
      if (localb != null) {
        localb.c((View)this, paramMotionEvent);
      }
    }
    boolean bool = super.onDoubleTap(paramMotionEvent);
    AppMethodBeat.o(164507);
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164500);
    s.u(paramMotionEvent, "ev");
    c localc = this.agGN;
    if (localc == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164500);
      return bool;
    }
    boolean bool = localc.flG();
    AppMethodBeat.o(164500);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164506);
    super.onLongPress(paramMotionEvent);
    paramMotionEvent = this.GBt;
    if (paramMotionEvent != null) {
      paramMotionEvent.ft((View)this);
    }
    AppMethodBeat.o(164506);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164504);
    s.u(paramScaleGestureDetector, "detector");
    boolean bool = super.onScale(paramScaleGestureDetector);
    AppMethodBeat.o(164504);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164503);
    s.u(paramScaleGestureDetector, "detector");
    boolean bool = super.onScaleBegin(paramScaleGestureDetector);
    AppMethodBeat.o(164503);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164505);
    s.u(paramScaleGestureDetector, "detector");
    super.onScaleEnd(paramScaleGestureDetector);
    AppMethodBeat.o(164505);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164502);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    if (this.agGL != null) {
      jHA();
    }
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(164502);
    return bool;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164508);
    g localg = this.GBr;
    if (localg != null) {
      localg.fu((View)this);
    }
    boolean bool = super.onSingleTapConfirmed(paramMotionEvent);
    AppMethodBeat.o(164508);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164499);
    s.u(paramView, "v");
    s.u(paramMotionEvent, "event");
    AppMethodBeat.o(164499);
    return true;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164510);
    this.GBr = ((g)new h(paramOnClickListener));
    AppMethodBeat.o(164510);
  }
  
  public final void setOnDoubleClickListener(b paramb)
  {
    this.GBs = paramb;
  }
  
  public final void setOnInterceptTouchEventCallback(c paramc)
  {
    this.agGN = paramc;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(164509);
    this.GBt = ((d)new i(paramOnLongClickListener));
    AppMethodBeat.o(164509);
  }
  
  public final void setOnLongClickListener(d paramd)
  {
    this.GBt = paramd;
  }
  
  public final void setOnScaleListener(e parame)
  {
    this.agGM = parame;
  }
  
  public final void setOnScrollListener(f paramf)
  {
    this.agGL = paramf;
  }
  
  public final void setOnSingleClickListener(g paramg)
  {
    this.GBr = paramg;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$Companion;", "", "()V", "TAG", "", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(View paramView, MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract boolean flG();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void ft(View paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleEnd", "onScaling", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "", "onDown", "", "event", "Landroid/view/MotionEvent;", "onScroll", "distanceX", "", "distanceY", "isEnableOverScroll", "", "onUp", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface g
  {
    public abstract void fu(View paramView);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/HardTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements HardTouchableLayout.g
  {
    h(View.OnClickListener paramOnClickListener) {}
    
    public final void fu(View paramView)
    {
      AppMethodBeat.i(234601);
      s.u(paramView, "view");
      View.OnClickListener localOnClickListener = this.GFw;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
      AppMethodBeat.o(234601);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/HardTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements HardTouchableLayout.d
  {
    i(View.OnLongClickListener paramOnLongClickListener) {}
    
    public final void ft(View paramView)
    {
      AppMethodBeat.i(164498);
      s.u(paramView, "view");
      View.OnLongClickListener localOnLongClickListener = this.GFx;
      if (localOnLongClickListener != null) {
        localOnLongClickListener.onLongClick(paramView);
      }
      AppMethodBeat.o(164498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.HardTouchableLayout
 * JD-Core Version:    0.7.0.1
 */