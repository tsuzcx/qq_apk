package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
public final class WxRecyclerAdapter$c
  extends RecyclerView.c
{
  WxRecyclerAdapter$c(RecyclerView paramRecyclerView) {}
  
  private void gaA()
  {
    AppMethodBeat.i(203997);
    this.qrn.post((Runnable)new a(this));
    AppMethodBeat.o(203997);
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204000);
    super.at(paramInt1, paramInt2);
    gaA();
    AppMethodBeat.o(204000);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204002);
    super.au(paramInt1, paramInt2);
    gaA();
    AppMethodBeat.o(204002);
  }
  
  public final void f(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(203999);
    super.f(paramInt1, paramInt2, paramObject);
    gaA();
    AppMethodBeat.o(203999);
  }
  
  public final void l(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(204001);
    super.l(paramInt1, paramInt2, paramInt3);
    gaA();
    AppMethodBeat.o(204001);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(203998);
    super.onChanged();
    gaA();
    AppMethodBeat.o(203998);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class a
    implements Runnable
  {
    a(WxRecyclerAdapter.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(203996);
      RecyclerView.m localm = WxRecyclerAdapter.b(this.LEn.LEi);
      if (localm != null)
      {
        localm.b(this.LEn.qrn, 8);
        AppMethodBeat.o(203996);
        return;
      }
      AppMethodBeat.o(203996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.c
 * JD-Core Version:    0.7.0.1
 */