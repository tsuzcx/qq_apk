package com.tencent.mm.view.recyclerview;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
public final class d$h
  extends RecyclerView.c
{
  private final Handler aCF;
  
  d$h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164718);
    this.aCF = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(164718);
  }
  
  public final void at(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164713);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new d(this, paramInt1, paramInt2));
      AppMethodBeat.o(164713);
      return;
    }
    if (this.Lvo.Lvd)
    {
      localObject = this.rOk.getItemAnimator();
      if (localObject != null)
      {
        ad.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        this.rOk.setItemAnimator(null);
        this.aCF.removeCallbacksAndMessages(null);
        this.aCF.postDelayed((Runnable)new b((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).ls() + 60L);
      }
    }
    Object localObject = ((Iterable)d.a(this.Lvo)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).at(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164713);
  }
  
  public final void au(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164715);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new f(this, paramInt1, paramInt2));
      AppMethodBeat.o(164715);
      return;
    }
    Iterator localIterator = ((Iterable)d.a(this.Lvo)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).au(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164715);
  }
  
  public final void av(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164717);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new h(this, paramInt1, paramInt2));
      AppMethodBeat.o(164717);
      return;
    }
    Iterator localIterator = ((Iterable)d.a(this.Lvo)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).av(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164717);
  }
  
  public final void f(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(164714);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new e(this, paramInt1, paramInt2, paramObject));
      AppMethodBeat.o(164714);
      return;
    }
    if (this.Lvo.Lvd)
    {
      localObject = this.rOk.getItemAnimator();
      this.rOk.setItemAnimator(null);
      if (localObject != null)
      {
        ad.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        if (((RecyclerView.f)localObject).ls() > 0L)
        {
          this.aCF.removeCallbacksAndMessages(null);
          this.aCF.postDelayed((Runnable)new c((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).ls() + 60L);
        }
      }
    }
    Object localObject = ((Iterable)d.a(this.Lvo)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).f(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(164714);
  }
  
  public final void l(final int paramInt1, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(164716);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new g(this, paramInt1, paramInt2));
      AppMethodBeat.o(164716);
      return;
    }
    Iterator localIterator = ((Iterable)d.a(this.Lvo)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).l(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(164716);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(164712);
    if ((this.Lvo.Lve) && (this.rOk.kW()))
    {
      ad.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.rOk.post((Runnable)new a(this));
      AppMethodBeat.o(164712);
      return;
    }
    Iterator localIterator = ((Iterable)d.a(this.Lvo)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onChanged();
    }
    AppMethodBeat.o(164712);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class a
    implements Runnable
  {
    a(d.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(164704);
      this.Lvp.Lvo.notifyDataSetChanged();
      AppMethodBeat.o(164704);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
  static final class b
    implements Runnable
  {
    b(RecyclerView.f paramf1, d.h paramh, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164705);
      jdField_this.rOk.setItemAnimator(this.Lvq);
      AppMethodBeat.o(164705);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
  static final class c
    implements Runnable
  {
    c(RecyclerView.f paramf1, d.h paramh, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164706);
      jdField_this.rOk.setItemAnimator(this.Lvq);
      AppMethodBeat.o(164706);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class d
    implements Runnable
  {
    d(d.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164707);
      this.Lvp.Lvo.b(paramInt1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(164707);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class e
    implements Runnable
  {
    e(d.h paramh, int paramInt1, int paramInt2, Object paramObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(164708);
      this.Lvp.Lvo.e(paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(164708);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class f
    implements Runnable
  {
    f(d.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164709);
      this.Lvp.Lvo.ar(paramInt1, paramInt2);
      AppMethodBeat.o(164709);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class g
    implements Runnable
  {
    g(d.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164710);
      this.Lvp.Lvo.aq(paramInt1, paramInt2);
      AppMethodBeat.o(164710);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class h
    implements Runnable
  {
    h(d.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164711);
      this.Lvp.Lvo.as(paramInt1, paramInt2);
      AppMethodBeat.o(164711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d.h
 * JD-Core Version:    0.7.0.1
 */