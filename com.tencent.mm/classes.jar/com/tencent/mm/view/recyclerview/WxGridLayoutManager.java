package com.tencent.mm.view.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WxGridLayoutManager
  extends GridLayoutManager
{
  public static final WxGridLayoutManager.a agOr;
  
  static
  {
    AppMethodBeat.i(234962);
    agOr = new WxGridLayoutManager.a((byte)0);
    AppMethodBeat.o(234962);
  }
  
  public WxGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(234971);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(234971);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.e("MicroMsg.WxGridLayoutManager", "meet a IOOBE in RecyclerView");
      AppMethodBeat.o(234971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */