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
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final RecyclerHorizontalViewPager.a LNn;
  private b LNk;
  private at LNl;
  private c LNm;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    LNn = new RecyclerHorizontalViewPager.a((byte)0);
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
  
  public void af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164566);
    Object localObject = new b();
    ((b)localObject).mu(paramInt);
    ((b)localObject).dx(paramBoolean);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager", "com/tencent/mm/view/RecyclerHorizontalViewPager", "onPageChange", "(IZ)V", this, ((b)localObject).ahF());
    localObject = this.LNk;
    if (localObject != null) {
      ((b)localObject).af(paramInt, paramBoolean);
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
    c localc = this.LNm;
    if (localc != null) {
      localc.k(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.LNm;
  }
  
  public final b getPageChangeListener()
  {
    return this.LNk;
  }
  
  public final at getSnapHelper()
  {
    return this.LNl;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    p.h(paramMotionEvent, "event");
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.LNm;
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
    if (this.LNl == null) {
      this.LNl = ((at)new ak());
    }
    at localat = this.LNl;
    if (localat != null) {
      localat.j((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.m)new d(this));
    AppMethodBeat.o(164564);
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.LNm = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.LNk = paramb;
  }
  
  public final void setSnapHelper(at paramat)
  {
    this.LNl = paramat;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void af(int paramInt, boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
  public static abstract interface c
  {
    public abstract boolean b(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void k(MotionEvent paramMotionEvent);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
  public static final class d
    extends RecyclerView.m
  {
    private final Rect LNo;
    private final Rect LNp;
    private int rES;
    
    d()
    {
      AppMethodBeat.i(164563);
      this.rES = -1;
      this.LNo = new Rect();
      this.LNp = new Rect();
      AppMethodBeat.o(164563);
    }
    
    public final void a(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(164562);
      Object localObject1 = new b();
      ((b)localObject1).bd(paramRecyclerView);
      ((b)localObject1).mu(paramInt1);
      ((b)localObject1).mu(paramInt2);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject1).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.LNq.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)localObject1).km();
      localObject1 = this.LNq.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164562);
        throw paramRecyclerView;
      }
      paramInt2 = ((LinearLayoutManager)localObject1).ko();
      localObject1 = paramRecyclerView.ci(paramInt1);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView.w)localObject1).auu;
        RecyclerView.w localw = paramRecyclerView.ci(paramInt2);
        paramRecyclerView = localObject2;
        if (localw != null) {
          paramRecyclerView = localw.auu;
        }
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.LNo);
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.getLocalVisibleRect(this.LNp);
        }
        if (this.LNo.width() <= this.LNp.width()) {
          break label292;
        }
      }
      for (;;)
      {
        if ((paramInt1 != this.rES) && (paramInt1 != -1))
        {
          this.LNq.post((Runnable)new a(this, paramInt1));
          this.rES = paramInt1;
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
      AppMethodBeat.i(193905);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(193905);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(164561);
        this.LNr.LNq.af(paramInt1, true);
        AppMethodBeat.o(164561);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */