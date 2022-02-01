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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onInterceptTouchEventCallback", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "getOnInterceptTouchEventCallback", "()Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "setOnInterceptTouchEventCallback", "(Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;)V", "onLongClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;)V", "onScaleListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "getOnScaleListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "setOnScaleListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;)V", "onScrollListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "getOnScrollListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "setOnScrollListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "canScrollHorizontally", "", "direction", "canScrollVertically", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onDoubleTap", "e", "onInterceptTouchEvent", "ev", "onLongPress", "", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Companion", "OnDoubleClickListener", "OnInterceptTouchEventCallback", "OnLongClickListener", "OnScaleListener", "OnScrollListener", "OnSingleClickListener", "libmmui_release"})
public class HardTouchableLayout
  extends TouchEventLayout
{
  public static final a Rjl;
  private static int kuv;
  private static int kuw;
  private d Rjf;
  private g Rjg;
  private b Rjh;
  private f Rji;
  private e Rjj;
  private c Rjk;
  
  static
  {
    AppMethodBeat.i(164513);
    Rjl = new a((byte)0);
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
    return this.AwT;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.AwT;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164501);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      kuv = (int)paramMotionEvent.getRawX();
      kuw = (int)paramMotionEvent.getRawY();
    }
    super.onTouch((View)this, paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      ad(paramMotionEvent);
      if (this.Rji != null) {}
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
    return this.Rjh;
  }
  
  public final c getOnInterceptTouchEventCallback()
  {
    return this.Rjk;
  }
  
  public final d getOnLongClickListener()
  {
    return this.Rjf;
  }
  
  public final e getOnScaleListener()
  {
    return this.Rjj;
  }
  
  public final f getOnScrollListener()
  {
    return this.Rji;
  }
  
  public final g getOnSingleClickListener()
  {
    return this.Rjg;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164507);
    if (paramMotionEvent != null)
    {
      b localb = this.Rjh;
      if (localb != null) {
        localb.a((View)this, paramMotionEvent);
      }
    }
    boolean bool = super.onDoubleTap(paramMotionEvent);
    AppMethodBeat.o(164507);
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164500);
    p.h(paramMotionEvent, "ev");
    c localc = this.Rjk;
    if (localc != null)
    {
      bool = localc.S(paramMotionEvent);
      AppMethodBeat.o(164500);
      return bool;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164500);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164506);
    super.onLongPress(paramMotionEvent);
    paramMotionEvent = this.Rjf;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.ea((View)this);
      AppMethodBeat.o(164506);
      return;
    }
    AppMethodBeat.o(164506);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164504);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = super.onScale(paramScaleGestureDetector);
    AppMethodBeat.o(164504);
    return bool;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164503);
    p.h(paramScaleGestureDetector, "detector");
    boolean bool = super.onScaleBegin(paramScaleGestureDetector);
    AppMethodBeat.o(164503);
    return bool;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164505);
    p.h(paramScaleGestureDetector, "detector");
    super.onScaleEnd(paramScaleGestureDetector);
    AppMethodBeat.o(164505);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(164502);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(164502);
    return bool;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204950);
    p.h(paramMotionEvent, "e");
    g localg = this.Rjg;
    if (localg != null) {
      localg.b((View)this, paramMotionEvent);
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(204950);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164499);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    AppMethodBeat.o(164499);
    return true;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164510);
    this.Rjg = ((g)new h(paramOnClickListener));
    AppMethodBeat.o(164510);
  }
  
  public final void setOnDoubleClickListener(b paramb)
  {
    this.Rjh = paramb;
  }
  
  public final void setOnInterceptTouchEventCallback(c paramc)
  {
    this.Rjk = paramc;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(164509);
    this.Rjf = ((d)new i(paramOnLongClickListener));
    AppMethodBeat.o(164509);
  }
  
  public final void setOnLongClickListener(d paramd)
  {
    this.Rjf = paramd;
  }
  
  public final void setOnScaleListener(e parame)
  {
    this.Rjj = parame;
  }
  
  public final void setOnScrollListener(f paramf)
  {
    this.Rji = paramf;
  }
  
  public final void setOnSingleClickListener(g paramg)
  {
    this.Rjg = paramg;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$Companion;", "", "()V", "TAG", "", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean S(MotionEvent paramMotionEvent);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"})
  public static abstract interface d
  {
    public abstract void ea(View paramView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleEnd", "onScaling", "libmmui_release"})
  public static abstract interface e {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "", "onDown", "", "event", "Landroid/view/MotionEvent;", "onScroll", "distanceX", "", "distanceY", "isEnableOverScroll", "", "onUp", "libmmui_release"})
  public static abstract interface f {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
  public static abstract interface g
  {
    public abstract void b(View paramView, MotionEvent paramMotionEvent);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/HardTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
  public static final class h
    implements HardTouchableLayout.g
  {
    h(View.OnClickListener paramOnClickListener) {}
    
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204949);
      p.h(paramView, "view");
      paramMotionEvent = this.Rjm;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.onClick(paramView);
        AppMethodBeat.o(204949);
        return;
      }
      AppMethodBeat.o(204949);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/HardTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"})
  public static final class i
    implements HardTouchableLayout.d
  {
    i(View.OnLongClickListener paramOnLongClickListener) {}
    
    public final void ea(View paramView)
    {
      AppMethodBeat.i(164498);
      p.h(paramView, "view");
      View.OnLongClickListener localOnLongClickListener = this.Rjn;
      if (localOnLongClickListener != null)
      {
        localOnLongClickListener.onLongClick(paramView);
        AppMethodBeat.o(164498);
        return;
      }
      AppMethodBeat.o(164498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.HardTouchableLayout
 * JD-Core Version:    0.7.0.1
 */