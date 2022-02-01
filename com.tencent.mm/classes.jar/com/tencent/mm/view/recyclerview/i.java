package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxRVListener;", "", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "Companion", "libmmui_release"})
public abstract interface i
{
  public static final a LvM = a.LvO;
  
  public abstract void a(RecyclerView paramRecyclerView, g paramg);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxRVListener$Companion;", "", "()V", "DataHandleThreadName", "", "getDataHandleThreadName", "()Ljava/lang/String;", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_RESUME", "SCROLL_STATE_SETTLING", "libmmui_release"})
  public static final class a
  {
    private static final String LvN = "WxDataRecyclerView.DataHandle";
    
    static
    {
      AppMethodBeat.i(186678);
      LvO = new a();
      LvN = "WxDataRecyclerView.DataHandle";
      AppMethodBeat.o(186678);
    }
    
    public static String fQD()
    {
      return LvN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */