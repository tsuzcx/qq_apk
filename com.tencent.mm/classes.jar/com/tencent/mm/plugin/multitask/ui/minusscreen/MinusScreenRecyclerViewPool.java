package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "gridViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getGridViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setGridViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "timelinePool", "getTimelinePool", "Companion", "ui-multitask_release"})
public final class MinusScreenRecyclerViewPool
  extends ViewModel
{
  public static final a AdP;
  private final RecyclerView.m wuu;
  private RecyclerView.m wux;
  
  static
  {
    AppMethodBeat.i(236455);
    AdP = new a((byte)0);
    AppMethodBeat.o(236455);
  }
  
  public MinusScreenRecyclerViewPool()
  {
    AppMethodBeat.i(236454);
    this.wuu = ((RecyclerView.m)new b());
    this.wux = new RecyclerView.m();
    AppMethodBeat.o(236454);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "ui-multitask_release"})
  public static final class b
    extends RecyclerView.m
  {
    public final RecyclerView.v cm(int paramInt)
    {
      AppMethodBeat.i(236453);
      RecyclerView.v localv = super.cm(paramInt);
      StringBuilder localStringBuilder;
      View localView;
      if (Log.getLogLevel() <= 1)
      {
        localStringBuilder = new StringBuilder("getRecycledView hash=");
        if (localv == null) {
          break label94;
        }
        localView = localv.aus;
        if (localView == null) {
          break label99;
        }
      }
      label94:
      label99:
      for (int i = localView.hashCode();; i = 0)
      {
        Log.d("Finder.RecyclerViewPoolVM", i + " viewType=" + paramInt + " size=" + cl(paramInt));
        AppMethodBeat.o(236453);
        return localv;
        localView = null;
        break;
      }
    }
    
    public final void q(RecyclerView.v paramv)
    {
      AppMethodBeat.i(236452);
      p.h(paramv, "scrap");
      super.q(paramv);
      if (Log.getLogLevel() <= 1) {
        Log.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + paramv.aus.hashCode() + " viewType=" + paramv.lU() + " size=" + cl(paramv.lU()));
      }
      AppMethodBeat.o(236452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */