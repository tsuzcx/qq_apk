package com.tencent.mm.view.recyclerview;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkValid", "", "preItemCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
public final class g$h
  extends RecyclerView.c
{
  private final Handler aDv;
  
  g$h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164718);
    this.aDv = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(164718);
  }
  
  public final boolean aqd(int paramInt)
  {
    AppMethodBeat.i(205047);
    if (paramInt == this.RqS.getItemCount())
    {
      AppMethodBeat.o(205047);
      return true;
    }
    AppMethodBeat.o(205047);
    return false;
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(164712);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onChanged] Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.tDJ.post((Runnable)new a(this));
      AppMethodBeat.o(164712);
      return;
    }
    Iterator localIterator = ((Iterable)g.a(this.RqS)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onChanged();
    }
    AppMethodBeat.o(164712);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164713);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.tDJ.post((Runnable)new d(this, paramInt2, paramInt1));
      AppMethodBeat.o(164713);
      return;
    }
    if (this.RqS.RqH)
    {
      localObject = this.tDJ.getItemAnimator();
      if (localObject != null)
      {
        Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        this.tDJ.setItemAnimator(null);
        this.aDv.removeCallbacksAndMessages(null);
        this.aDv.postDelayed((Runnable)new b((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).lA() + 60L);
      }
    }
    Object localObject = ((Iterable)g.a(this.RqS)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).onItemRangeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164713);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(164714);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + " payload=" + paramObject + ' ' + Util.getStack());
      this.tDJ.post((Runnable)new e(this, paramInt2, paramInt1, paramObject));
      AppMethodBeat.o(164714);
      return;
    }
    if (this.RqS.RqH)
    {
      localObject = this.tDJ.getItemAnimator();
      this.tDJ.setItemAnimator(null);
      if (localObject != null)
      {
        Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        if (((RecyclerView.f)localObject).lA() > 0L)
        {
          this.aDv.removeCallbacksAndMessages(null);
          this.aDv.postDelayed((Runnable)new c((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).lA() + 60L);
        }
      }
    }
    Object localObject = ((Iterable)g.a(this.RqS)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).onItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(164714);
  }
  
  public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164715);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeInserted] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.tDJ.post((Runnable)new f(this, paramInt2, paramInt1));
      AppMethodBeat.o(164715);
      return;
    }
    Iterator localIterator = ((Iterable)g.a(this.RqS)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeInserted(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164715);
  }
  
  public final void onItemRangeMoved(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(164716);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeMoved] Cannot call this method while RecyclerView is computing a layout or scrolling, fromPosition=" + paramInt1 + " toPosition=" + paramInt2 + " itemCount=" + paramInt3 + ' ' + Util.getStack());
      this.tDJ.post((Runnable)new g(this, paramInt3, paramInt1, paramInt2));
      AppMethodBeat.o(164716);
      return;
    }
    Iterator localIterator = ((Iterable)g.a(this.RqS)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(164716);
  }
  
  public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164717);
    if ((this.RqS.RqI) && (this.tDJ.ld()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeRemoved] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.tDJ.post((Runnable)new h(this, paramInt2, paramInt1));
      AppMethodBeat.o(164717);
      return;
    }
    Iterator localIterator = ((Iterable)g.a(this.RqS)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeRemoved(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164717);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class a
    implements Runnable
  {
    a(g.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(164704);
      this.RqT.RqS.notifyDataSetChanged();
      AppMethodBeat.o(164704);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
  static final class b
    implements Runnable
  {
    b(RecyclerView.f paramf1, g.h paramh, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164705);
      jdField_this.tDJ.setItemAnimator(this.RqU);
      AppMethodBeat.o(164705);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
  static final class c
    implements Runnable
  {
    c(RecyclerView.f paramf1, g.h paramh, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164706);
      jdField_this.tDJ.setItemAnimator(this.RqU);
      AppMethodBeat.o(164706);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class d
    implements Runnable
  {
    d(g.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164707);
      if (!this.RqT.aqd(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt2 + " but now itemCount is " + this.RqT.RqS.getItemCount());
        AppMethodBeat.o(164707);
        return;
      }
      this.RqT.RqS.b(paramInt1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(164707);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class e
    implements Runnable
  {
    e(g.h paramh, int paramInt1, int paramInt2, Object paramObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(164708);
      if (!this.RqT.aqd(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt2 + " but now itemCount is " + this.RqT.RqS.getItemCount());
        AppMethodBeat.o(164708);
        return;
      }
      this.RqT.RqS.e(paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(164708);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class f
    implements Runnable
  {
    f(g.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164709);
      if (!this.RqT.aqd(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeInserted] preItemCount=" + paramInt2 + " but now itemCount is " + this.RqT.RqS.getItemCount());
        AppMethodBeat.o(164709);
        return;
      }
      this.RqT.RqS.as(paramInt1, paramInt2);
      AppMethodBeat.o(164709);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class g
    implements Runnable
  {
    g(g.h paramh, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(164710);
      if (!this.RqT.aqd(paramInt3))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeMoved] preItemCount=" + paramInt3 + " but now itemCount is " + this.RqT.RqS.getItemCount());
        AppMethodBeat.o(164710);
        return;
      }
      this.RqT.RqS.ar(paramInt1, paramInt2);
      AppMethodBeat.o(164710);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
  static final class h
    implements Runnable
  {
    h(g.h paramh, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164711);
      if (!this.RqT.aqd(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[notifyItemRangeRemoved] preItemCount=" + paramInt2 + " but now itemCount is " + this.RqT.RqS.getItemCount());
        AppMethodBeat.o(164711);
        return;
      }
      this.RqT.RqS.at(paramInt1, paramInt2);
      AppMethodBeat.o(164711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g.h
 * JD-Core Version:    0.7.0.1
 */