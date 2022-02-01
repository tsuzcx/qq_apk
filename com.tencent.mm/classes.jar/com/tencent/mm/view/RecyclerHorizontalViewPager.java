package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.v;
import androidx.recyclerview.widget.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frozeTouch", "", "getFrozeTouch", "()Z", "setFrozeTouch", "(Z)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "getSnapHelper", "()Landroidx/recyclerview/widget/SnapHelper;", "setSnapHelper", "(Landroidx/recyclerview/widget/SnapHelper;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "isAuto", "onTouchEvent", "e", "selectViewAt", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final a YMY;
  private b YMU;
  private z YMV;
  private boolean YMW;
  private c YMX;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    YMY = new a((byte)0);
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
    p.k(paramMotionEvent, "ev");
    if (paramMotionEvent.getActionMasked() == 3)
    {
      bool = super.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
      AppMethodBeat.o(164565);
      return bool;
    }
    c localc = this.YMX;
    if (localc != null) {
      localc.n(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190648);
    b localb = this.YMU;
    if (localb != null)
    {
      localb.al(paramInt, paramBoolean1);
      AppMethodBeat.o(190648);
      return;
    }
    AppMethodBeat.o(190648);
  }
  
  public final boolean getFrozeTouch()
  {
    return this.YMW;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.YMX;
  }
  
  public final b getPageChangeListener()
  {
    return this.YMU;
  }
  
  public final z getSnapHelper()
  {
    return this.YMV;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    p.k(paramMotionEvent, "event");
    if (this.YMW)
    {
      AppMethodBeat.o(164567);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.YMX;
    if (localc != null)
    {
      if (paramMotionEvent.getAction() == 0) {
        this.historicalX = paramMotionEvent.getX();
      }
      paramMotionEvent.getX(0);
      bool = localc.a(paramMotionEvent, bool);
      if (!bool)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(paramMotionEvent, "cancelEvent");
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
    AppMethodBeat.i(190660);
    if (this.YMW)
    {
      AppMethodBeat.o(190660);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(190660);
    return bool;
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(190638);
    if (this.YMV == null) {
      this.YMV = ((z)new v());
    }
    z localz = this.YMV;
    if (localz != null) {
      localz.a((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.l)new d(this));
    AppMethodBeat.o(190638);
  }
  
  public final void setFrozeTouch(boolean paramBoolean)
  {
    this.YMW = paramBoolean;
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.YMX = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.YMU = paramb;
  }
  
  public final void setSnapHelper(z paramz)
  {
    this.YMV = paramz;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void al(int paramInt, boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
  public static final class d
    extends RecyclerView.l
  {
    private final Rect YMZ;
    private final Rect YNa;
    private int wKJ;
    
    d()
    {
      AppMethodBeat.i(164563);
      this.wKJ = -1;
      this.YMZ = new Rect();
      this.YNa = new Rect();
      AppMethodBeat.o(164563);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(207640);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(207640);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(207636);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramRecyclerView);
      ((b)localObject1).sg(paramInt1);
      ((b)localObject1).sg(paramInt2);
      a.c("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject1).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.YNb.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(207636);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)localObject1).kJ();
      localObject1 = this.YNb.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(207636);
        throw paramRecyclerView;
      }
      paramInt2 = ((LinearLayoutManager)localObject1).kL();
      localObject1 = paramRecyclerView.cK(paramInt1);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.v)localObject1).amk;
        RecyclerView.v localv = paramRecyclerView.cK(paramInt2);
        paramRecyclerView = localObject2;
        if (localv != null) {
          paramRecyclerView = localv.amk;
        }
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.YMZ);
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.getLocalVisibleRect(this.YNa);
        }
        if (this.YMZ.width() <= this.YNa.width()) {
          break label292;
        }
      }
      for (;;)
      {
        if ((paramInt1 != this.wKJ) && (paramInt1 != -1))
        {
          this.YNb.post((Runnable)new a(this, paramInt1));
          this.wKJ = paramInt1;
        }
        a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(207636);
        return;
        localObject1 = null;
        break;
        label292:
        paramInt1 = paramInt2;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(164561);
        this.YNc.YNb.g(paramInt1, true, true);
        AppMethodBeat.o(164561);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */