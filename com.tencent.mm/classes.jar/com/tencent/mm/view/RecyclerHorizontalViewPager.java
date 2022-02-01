package com.tencent.mm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.ak;
import android.support.v7.widget.at;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frozeTouch", "", "getFrozeTouch", "()Z", "setFrozeTouch", "(Z)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "isAuto", "onTouchEvent", "e", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final RecyclerHorizontalViewPager.a RlD;
  private at RlA;
  private boolean RlB;
  private c RlC;
  private b Rlz;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    RlD = new RecyclerHorizontalViewPager.a((byte)0);
    AppMethodBeat.o(164570);
  }
  
  public RecyclerHorizontalViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164568);
    AppMethodBeat.o(164568);
  }
  
  public RecyclerHorizontalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164569);
    AppMethodBeat.o(164569);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164565);
    p.h(paramMotionEvent, "ev");
    if (paramMotionEvent.getActionMasked() == 3)
    {
      bool = super.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
      AppMethodBeat.o(164565);
      return bool;
    }
    c localc = this.RlC;
    if (localc != null) {
      localc.n(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(204982);
    b localb = this.Rlz;
    if (localb != null)
    {
      localb.aC(paramInt, paramBoolean1);
      AppMethodBeat.o(204982);
      return;
    }
    AppMethodBeat.o(204982);
  }
  
  public final boolean getFrozeTouch()
  {
    return this.RlB;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.RlC;
  }
  
  public final b getPageChangeListener()
  {
    return this.Rlz;
  }
  
  public final at getSnapHelper()
  {
    return this.RlA;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    p.h(paramMotionEvent, "event");
    if (this.RlB)
    {
      AppMethodBeat.o(164567);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.RlC;
    if (localc != null)
    {
      if (paramMotionEvent.getAction() == 0) {
        this.historicalX = paramMotionEvent.getX();
      }
      paramMotionEvent.getX(0);
      bool = localc.b(paramMotionEvent, bool);
      if (!bool)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(164567);
      return bool;
    }
    AppMethodBeat.o(164567);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204983);
    if (this.RlB)
    {
      AppMethodBeat.o(204983);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(204983);
    return bool;
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(164564);
    if (this.RlA == null) {
      this.RlA = ((at)new ak());
    }
    at localat = this.RlA;
    if (localat != null) {
      localat.f((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.l)new RecyclerHorizontalViewPager.d(this));
    AppMethodBeat.o(164564);
  }
  
  public final void setFrozeTouch(boolean paramBoolean)
  {
    this.RlB = paramBoolean;
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.RlC = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.Rlz = paramb;
  }
  
  public final void setSnapHelper(at paramat)
  {
    this.RlA = paramat;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void aC(int paramInt, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean b(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */