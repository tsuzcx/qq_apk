package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRVListener;", "", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "Companion", "libmmui_release"})
public abstract interface i
{
  public static final a LDW = a.LDY;
  
  public abstract void a(RecyclerView paramRecyclerView, g paramg);
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRVListener$Companion;", "", "()V", "DataHandleThreadName", "", "getDataHandleThreadName", "()Ljava/lang/String;", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_RESUME", "SCROLL_STATE_SETTLING", "libmmui_release"})
  public static final class a
  {
    private static final String LDX = "WxDataRecyclerView.DataHandle";
    
    static
    {
      AppMethodBeat.i(203989);
      LDY = new a();
      LDX = "WxDataRecyclerView.DataHandle";
      AppMethodBeat.o(203989);
    }
    
    public static String gaz()
    {
      return LDX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */