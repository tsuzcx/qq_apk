package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final RecyclerHorizontalViewPager.a Jxu;
  private b Jxr;
  private at Jxs;
  private c Jxt;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    Jxu = new RecyclerHorizontalViewPager.a((byte)0);
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
    b localb = this.Jxr;
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
    c localc = this.Jxt;
    if (localc != null) {
      localc.k(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.Jxt;
  }
  
  public final b getPageChangeListener()
  {
    return this.Jxr;
  }
  
  public final at getSnapHelper()
  {
    return this.Jxs;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    k.h(paramMotionEvent, "event");
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.Jxt;
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
    if (this.Jxs == null) {
      this.Jxs = ((at)new ak());
    }
    at localat = this.Jxs;
    if (localat != null) {
      localat.j((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.m)new d(this));
    AppMethodBeat.o(164564);
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.Jxt = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.Jxr = paramb;
  }
  
  public final void setSnapHelper(at paramat)
  {
    this.Jxs = paramat;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void ad(int paramInt, boolean paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean b(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void k(MotionEvent paramMotionEvent);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
  public static final class d
    extends RecyclerView.m
  {
    private final Rect Jxv;
    private final Rect Jxw;
    private int qME;
    
    d()
    {
      AppMethodBeat.i(164563);
      this.qME = -1;
      this.Jxv = new Rect();
      this.Jxw = new Rect();
      AppMethodBeat.o(164563);
    }
    
    public final void a(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(164562);
      Object localObject1 = new b();
      ((b)localObject1).bb(paramRecyclerView);
      ((b)localObject1).lS(paramInt1);
      ((b)localObject1).lS(paramInt2);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject1).aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.Jxx.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)localObject1).jW();
      localObject1 = this.Jxx.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt2 = ((LinearLayoutManager)localObject1).jY();
      localObject1 = paramRecyclerView.ci(paramInt1);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.w)localObject1).asD;
        RecyclerView.w localw = paramRecyclerView.ci(paramInt2);
        paramRecyclerView = localObject2;
        if (localw != null) {
          paramRecyclerView = localw.asD;
        }
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.Jxv);
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.getLocalVisibleRect(this.Jxw);
        }
        if (this.Jxv.width() <= this.Jxw.width()) {
          break label292;
        }
      }
      for (;;)
      {
        if ((paramInt1 != this.qME) && (paramInt1 != -1))
        {
          this.Jxx.post((Runnable)new a(this, paramInt1));
          this.qME = paramInt1;
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
      AppMethodBeat.i(197318);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(197318);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(164561);
        this.Jxy.Jxx.ad(paramInt1, true);
        AppMethodBeat.o(164561);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */