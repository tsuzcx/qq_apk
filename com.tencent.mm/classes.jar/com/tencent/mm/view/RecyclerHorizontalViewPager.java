package com.tencent.mm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.ak;
import android.support.v7.widget.at;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final RecyclerHorizontalViewPager.a LqC;
  private at LqA;
  private c LqB;
  private b Lqz;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    LqC = new RecyclerHorizontalViewPager.a((byte)0);
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
  
  public void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164566);
    Object localObject = new b();
    ((b)localObject).mr(paramInt);
    ((b)localObject).dw(paramBoolean);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager", "com/tencent/mm/view/RecyclerHorizontalViewPager", "onPageChange", "(IZ)V", this, ((b)localObject).ahq());
    localObject = this.Lqz;
    if (localObject != null) {
      ((b)localObject).ad(paramInt, paramBoolean);
    }
    a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager", "com/tencent/mm/view/RecyclerHorizontalViewPager", "onPageChange", "(IZ)V");
    AppMethodBeat.o(164566);
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
    c localc = this.LqB;
    if (localc != null) {
      localc.k(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.LqB;
  }
  
  public final b getPageChangeListener()
  {
    return this.Lqz;
  }
  
  public final at getSnapHelper()
  {
    return this.LqA;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    p.h(paramMotionEvent, "event");
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.LqB;
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
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(164564);
    if (this.LqA == null) {
      this.LqA = ((at)new ak());
    }
    at localat = this.LqA;
    if (localat != null) {
      localat.j((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.m)new RecyclerHorizontalViewPager.d(this));
    AppMethodBeat.o(164564);
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.LqB = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.Lqz = paramb;
  }
  
  public final void setSnapHelper(at paramat)
  {
    this.LqA = paramat;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void ad(int paramInt, boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean b(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void k(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */