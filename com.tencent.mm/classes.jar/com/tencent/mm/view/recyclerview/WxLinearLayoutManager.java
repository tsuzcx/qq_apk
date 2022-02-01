package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxLinearLayoutManager
  extends LinearLayoutManager
{
  public static final WxLinearLayoutManager.a agOA;
  private Context context;
  
  static
  {
    AppMethodBeat.i(234904);
    agOA = new WxLinearLayoutManager.a((byte)0);
    AppMethodBeat.o(234904);
  }
  
  public WxLinearLayoutManager(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public WxLinearLayoutManager(Context paramContext, byte paramByte)
  {
    super(0, false);
    this.context = paramContext;
  }
  
  public WxLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.context = paramContext;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(234909);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(234909);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.e("MicroMsg.WxLinearLayoutManager", "meet a IOOBE in RecyclerView");
      AppMethodBeat.o(234909);
      return;
    }
    catch (IllegalArgumentException paramn)
    {
      params = (Throwable)paramn;
      paramn = this.context;
      if (paramn == null) {}
      for (paramn = localObject1;; paramn = paramn.getClass().getName())
      {
        Log.printErrStackTrace("MicroMsg.WxLinearLayoutManager", params, s.X("onLayoutChildren ", paramn), new Object[0]);
        AppMethodBeat.o(234909);
        return;
      }
    }
    catch (Exception paramn)
    {
      params = (Throwable)paramn;
      paramn = this.context;
      if (paramn != null) {}
    }
    for (paramn = localObject2;; paramn = paramn.getClass().getName())
    {
      Log.printErrStackTrace("MicroMsg.WxLinearLayoutManager", params, s.X("onLayoutChildren ", paramn), new Object[0]);
      AppMethodBeat.o(234909);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */