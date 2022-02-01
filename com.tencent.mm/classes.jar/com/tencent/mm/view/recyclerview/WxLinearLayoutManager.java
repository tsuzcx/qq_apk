package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "libmmui_release"})
public final class WxLinearLayoutManager
  extends LinearLayoutManager
{
  public static final a YSJ;
  private Context context;
  
  static
  {
    AppMethodBeat.i(222058);
    YSJ = new a((byte)0);
    AppMethodBeat.o(222058);
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
    AppMethodBeat.i(222055);
    StringBuilder localStringBuilder;
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(222055);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.e("MicroMsg.WxLinearLayoutManager", "meet a IOOBE in RecyclerView");
      AppMethodBeat.o(222055);
      return;
    }
    catch (IllegalArgumentException paramn)
    {
      params = (Throwable)paramn;
      localStringBuilder = new StringBuilder("onLayoutChildren ");
      paramn = this.context;
      if (paramn == null) {}
    }
    for (paramn = paramn.getClass().getName();; paramn = null)
    {
      Log.printErrStackTrace("MicroMsg.WxLinearLayoutManager", params, paramn, new Object[0]);
      AppMethodBeat.o(222055);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */