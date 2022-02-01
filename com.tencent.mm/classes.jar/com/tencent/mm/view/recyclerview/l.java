package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRVListener;", "", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "Companion", "libmmui_release"})
public abstract interface l
{
  public static final a Rrr = a.Rrt;
  
  public abstract void a(RecyclerView paramRecyclerView, j paramj);
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRVListener$Companion;", "", "()V", "DataHandleThreadName", "", "getDataHandleThreadName", "()Ljava/lang/String;", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_RESUME", "SCROLL_STATE_SETTLING", "libmmui_release"})
  public static final class a
  {
    private static final String Rrs = "WxDataRecyclerView.DataHandle";
    
    static
    {
      AppMethodBeat.i(205056);
      Rrt = new a();
      Rrs = "WxDataRecyclerView.DataHandle";
      AppMethodBeat.o(205056);
    }
    
    public static String hgw()
    {
      return Rrs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.l
 * JD-Core Version:    0.7.0.1
 */