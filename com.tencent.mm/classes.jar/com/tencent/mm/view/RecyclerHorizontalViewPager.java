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
import androidx.recyclerview.widget.t;
import androidx.recyclerview.widget.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frozeTouch", "", "getFrozeTouch", "()Z", "setFrozeTouch", "(Z)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "getSnapHelper", "()Landroidx/recyclerview/widget/SnapHelper;", "setSnapHelper", "(Landroidx/recyclerview/widget/SnapHelper;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "isAuto", "onTouchEvent", "e", "selectViewAt", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RecyclerHorizontalViewPager
  extends RecyclerView
{
  public static final RecyclerHorizontalViewPager.a agII;
  private b agIJ;
  private x agIK;
  private boolean agIL;
  private c agIM;
  private float historicalX;
  
  static
  {
    AppMethodBeat.i(164570);
    agII = new RecyclerHorizontalViewPager.a((byte)0);
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
    s.u(paramMotionEvent, "ev");
    if (paramMotionEvent.getActionMasked() == 3)
    {
      bool = super.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
      AppMethodBeat.o(164565);
      return bool;
    }
    c localc = this.agIM;
    if (localc != null) {
      localc.n(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164565);
    return bool;
  }
  
  public void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(234771);
    b localb = this.agIJ;
    if (localb != null) {
      localb.aE(paramInt, paramBoolean1);
    }
    AppMethodBeat.o(234771);
  }
  
  public final boolean getFrozeTouch()
  {
    return this.agIL;
  }
  
  public final c getOnInterceptTouchEvent()
  {
    return this.agIM;
  }
  
  public final b getPageChangeListener()
  {
    return this.agIJ;
  }
  
  public final x getSnapHelper()
  {
    return this.agIK;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164567);
    s.u(paramMotionEvent, "event");
    if (this.agIL)
    {
      AppMethodBeat.o(164567);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    c localc = this.agIM;
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
    AppMethodBeat.i(234779);
    if (this.agIL)
    {
      AppMethodBeat.o(234779);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(234779);
    return bool;
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(234764);
    if (this.agIK == null) {
      this.agIK = ((x)new t());
    }
    x localx = this.agIK;
    if (localx != null) {
      localx.a((RecyclerView)this);
    }
    super.setAdapter(parama);
    a((RecyclerView.l)new d(this));
    AppMethodBeat.o(234764);
  }
  
  public final void setFrozeTouch(boolean paramBoolean)
  {
    this.agIL = paramBoolean;
  }
  
  public final void setOnInterceptTouchEvent(c paramc)
  {
    this.agIM = paramc;
  }
  
  public final void setPageChangeListener(b paramb)
  {
    this.agIJ = paramb;
  }
  
  public final void setSnapHelper(x paramx)
  {
    this.agIK = paramx;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void aE(int paramInt, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", "direction", "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    private int Ahg;
    private final Rect agIN;
    private final Rect agIO;
    
    d(RecyclerHorizontalViewPager paramRecyclerHorizontalViewPager)
    {
      AppMethodBeat.i(164563);
      this.Ahg = -1;
      this.agIN = new Rect();
      this.agIO = new Rect();
      AppMethodBeat.o(164563);
    }
    
    private static final void a(RecyclerHorizontalViewPager paramRecyclerHorizontalViewPager, int paramInt)
    {
      AppMethodBeat.i(235016);
      s.u(paramRecyclerHorizontalViewPager, "this$0");
      paramRecyclerHorizontalViewPager.g(paramInt, true, true);
      AppMethodBeat.o(235016);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(235034);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(235034);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235027);
      Object localObject1 = new b();
      ((b)localObject1).cH(paramRecyclerView);
      ((b)localObject1).sc(paramInt1);
      ((b)localObject1).sc(paramInt2);
      a.c("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject1).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.agIP.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(235027);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)localObject1).Ju();
      localObject1 = this.agIP.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(235027);
        throw paramRecyclerView;
      }
      paramInt2 = ((LinearLayoutManager)localObject1).Jw();
      localObject1 = paramRecyclerView.fU(paramInt1);
      if (localObject1 == null)
      {
        localObject1 = null;
        paramRecyclerView = paramRecyclerView.fU(paramInt2);
        if (paramRecyclerView != null) {
          break label284;
        }
        paramRecyclerView = localObject2;
        label173:
        if (localObject1 != null) {
          ((View)localObject1).getLocalVisibleRect(this.agIN);
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.getLocalVisibleRect(this.agIO);
        }
        if (this.agIN.width() <= this.agIO.width()) {
          break label292;
        }
      }
      for (;;)
      {
        if ((paramInt1 != this.Ahg) && (paramInt1 != -1))
        {
          this.agIP.post(new RecyclerHorizontalViewPager.d..ExternalSyntheticLambda0(this.agIP, paramInt1));
          this.Ahg = paramInt1;
        }
        a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(235027);
        return;
        localObject1 = ((RecyclerView.v)localObject1).caK;
        break;
        label284:
        paramRecyclerView = paramRecyclerView.caK;
        break label173;
        label292:
        paramInt1 = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager
 * JD-Core Version:    0.7.0.1
 */