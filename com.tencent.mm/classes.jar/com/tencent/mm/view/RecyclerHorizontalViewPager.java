package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ak;
import android.support.v7.widget.at;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final a HWK;
  private b HWG;
  private at HWH;
  private c HWI;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    HWK = new a((byte)0);
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
    b localb = this.HWG;
    if (localb != null)
    {
      localb.ad(paramInt, paramBoolean);
      AppMethodBeat.o(164566);
      return;
    }
    AppMethodBeat.o(164566);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164565);
    k.h(paramMotionEvent, "ev");
    if (paramMotionEvent.getActionMasked() == 3)
    {
      bool = super.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
      AppMethodBeat.o(164565);
      return bool;
    }
    c localc = this.HWI;
    if (localc != null) {
      localc.m(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.HWI;
  }
  
  public final b getPageChangeListener()
  {
    return this.HWG;
  }
  
  public final at getSnapHelper()
  {
    return this.HWH;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    k.h(paramMotionEvent, "event");
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.HWI;
    if (localc != null)
    {
      if (paramMotionEvent.getAction() == 0) {
        this.historicalX = paramMotionEvent.getX();
      }
      paramMotionEvent.getX(0);
      bool = localc.c(paramMotionEvent, bool);
      if (!bool)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
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
    if (this.HWH == null) {
      this.HWH = ((at)new ak());
    }
    at localat = this.HWH;
    if (localat != null) {
      localat.j((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.m)new d(this));
    AppMethodBeat.o(164564);
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.HWI = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.HWG = paramb;
  }
  
  public final void setSnapHelper(at paramat)
  {
    this.HWH = paramat;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void ad(int paramInt, boolean paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean c(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void m(MotionEvent paramMotionEvent);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
  public static final class d
    extends RecyclerView.m
  {
    private final Rect HWL;
    private final Rect HWM;
    private int qeb;
    
    d()
    {
      AppMethodBeat.i(164563);
      this.qeb = -1;
      this.HWL = new Rect();
      this.HWM = new Rect();
      AppMethodBeat.o(164563);
    }
    
    public final void a(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(164562);
      Object localObject1 = new b();
      ((b)localObject1).be(paramRecyclerView);
      ((b)localObject1).lT(paramInt1);
      ((b)localObject1).lT(paramInt2);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject1).ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.HWN.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)localObject1).jO();
      localObject1 = this.HWN.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt2 = ((LinearLayoutManager)localObject1).jQ();
      localObject1 = paramRecyclerView.cj(paramInt1);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.v)localObject1).arI;
        RecyclerView.v localv = paramRecyclerView.cj(paramInt2);
        paramRecyclerView = localObject2;
        if (localv != null) {
          paramRecyclerView = localv.arI;
        }
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.HWL);
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.getLocalVisibleRect(this.HWM);
        }
        if (this.HWL.width() <= this.HWM.width()) {
          break label292;
        }
      }
      for (;;)
      {
        if ((paramInt1 != this.qeb) && (paramInt1 != -1))
        {
          this.HWN.post((Runnable)new a(this, paramInt1));
          this.qeb = paramInt1;
        }
        a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(164562);
        return;
        localObject1 = null;
        break;
        label292:
        paramInt1 = paramInt2;
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(203965);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(203965);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(164561);
        this.HWO.HWN.ad(paramInt1, true);
        AppMethodBeat.o(164561);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */