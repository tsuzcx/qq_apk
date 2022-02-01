package com.tencent.mm.view.recyclerview;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkValid", "", "preItemCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
public final class h$i
  extends RecyclerView.c
{
  private final Handler die;
  
  h$i(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(222926);
    this.die = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(222926);
  }
  
  public final boolean azC(int paramInt)
  {
    AppMethodBeat.i(222875);
    if (paramInt == this.YSr.getItemCount())
    {
      AppMethodBeat.o(222875);
      return true;
    }
    AppMethodBeat.o(222875);
    return false;
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(164712);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onChanged] Cannot call this method while RecyclerView is computing a layout or scrolling");
      this.xmk.post((Runnable)new a(this));
      AppMethodBeat.o(164712);
      return;
    }
    Iterator localIterator = ((Iterable)h.a(this.YSr)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onChanged();
    }
    AppMethodBeat.o(164712);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164713);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.xmk.post((Runnable)new d(this, paramInt2, paramInt1));
      AppMethodBeat.o(164713);
      return;
    }
    if (this.YSr.YSf)
    {
      localObject = this.xmk.getItemAnimator();
      if (localObject != null)
      {
        Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        this.xmk.setItemAnimator(null);
        this.die.removeCallbacksAndMessages(null);
        this.die.postDelayed((Runnable)new b((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).lL() + 60L);
      }
    }
    Object localObject = ((Iterable)h.a(this.YSr)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).onItemRangeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164713);
  }
  
  public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
  {
    AppMethodBeat.i(164714);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + " payload=" + paramObject + ' ' + Util.getStack());
      this.xmk.post((Runnable)new e(this, paramInt2, paramInt1, paramObject));
      AppMethodBeat.o(164714);
      return;
    }
    if (this.YSr.YSf)
    {
      localObject = this.xmk.getItemAnimator();
      this.xmk.setItemAnimator(null);
      if (localObject != null)
      {
        Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
        if (((RecyclerView.f)localObject).lL() > 0L)
        {
          this.die.removeCallbacksAndMessages(null);
          this.die.postDelayed((Runnable)new c((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).lL() + 60L);
        }
      }
    }
    Object localObject = ((Iterable)h.a(this.YSr)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RecyclerView.c)((Iterator)localObject).next()).onItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(164714);
  }
  
  public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164715);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeInserted] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.xmk.post((Runnable)new f(this, paramInt2, paramInt1));
      AppMethodBeat.o(164715);
      return;
    }
    Iterator localIterator = ((Iterable)h.a(this.YSr)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeInserted(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164715);
  }
  
  public final void onItemRangeMoved(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(164716);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeMoved] Cannot call this method while RecyclerView is computing a layout or scrolling, fromPosition=" + paramInt1 + " toPosition=" + paramInt2 + " itemCount=" + paramInt3 + ' ' + Util.getStack());
      this.xmk.post((Runnable)new g(this, paramInt3, paramInt1, paramInt2));
      AppMethodBeat.o(164716);
      return;
    }
    Iterator localIterator = ((Iterable)h.a(this.YSr)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(164716);
  }
  
  public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(164717);
    if ((this.YSr.YSg) && (this.xmk.lq()))
    {
      Log.w("RecyclerViewAdapterEx", "[onItemRangeRemoved] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
      this.xmk.post((Runnable)new h(this, paramInt2, paramInt1));
      AppMethodBeat.o(164717);
      return;
    }
    Iterator localIterator = ((Iterable)h.a(this.YSr)).iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.c)localIterator.next()).onItemRangeRemoved(paramInt1, paramInt2);
    }
    AppMethodBeat.o(164717);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class a
    implements Runnable
  {
    a(h.i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(164704);
      this.YSs.YSr.notifyDataSetChanged();
      AppMethodBeat.o(164704);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
  static final class b
    implements Runnable
  {
    b(RecyclerView.f paramf1, h.i parami, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164705);
      jdField_this.xmk.setItemAnimator(this.YSt);
      AppMethodBeat.o(164705);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
  static final class c
    implements Runnable
  {
    c(RecyclerView.f paramf1, h.i parami, RecyclerView.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164706);
      jdField_this.xmk.setItemAnimator(this.YSt);
      AppMethodBeat.o(164706);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class d
    implements Runnable
  {
    d(h.i parami, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164707);
      if (!this.YSs.azC(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt2 + " but now itemCount is " + this.YSs.YSr.getItemCount());
        AppMethodBeat.o(164707);
        return;
      }
      this.YSs.YSr.d(paramInt1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(164707);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class e
    implements Runnable
  {
    e(h.i parami, int paramInt1, int paramInt2, Object paramObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(164708);
      if (!this.YSs.azC(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt2 + " but now itemCount is " + this.YSs.YSr.getItemCount());
        AppMethodBeat.o(164708);
        return;
      }
      this.YSs.YSr.e(paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(164708);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class f
    implements Runnable
  {
    f(h.i parami, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164709);
      if (!this.YSs.azC(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeInserted] preItemCount=" + paramInt2 + " but now itemCount is " + this.YSs.YSr.getItemCount());
        AppMethodBeat.o(164709);
        return;
      }
      this.YSs.YSr.aG(paramInt1, paramInt2);
      AppMethodBeat.o(164709);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class g
    implements Runnable
  {
    g(h.i parami, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(164710);
      if (!this.YSs.azC(paramInt3))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeMoved] preItemCount=" + paramInt3 + " but now itemCount is " + this.YSs.YSr.getItemCount());
        AppMethodBeat.o(164710);
        return;
      }
      this.YSs.YSr.aF(paramInt1, paramInt2);
      AppMethodBeat.o(164710);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "run"})
  static final class h
    implements Runnable
  {
    h(h.i parami, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(164711);
      if (!this.YSs.azC(paramInt2))
      {
        Log.e("RecyclerViewAdapterEx", "[notifyItemRangeRemoved] preItemCount=" + paramInt2 + " but now itemCount is " + this.YSs.YSr.getItemCount());
        AppMethodBeat.o(164711);
        return;
      }
      this.YSs.YSr.aH(paramInt1, paramInt2);
      AppMethodBeat.o(164711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h.i
 * JD-Core Version:    0.7.0.1
 */