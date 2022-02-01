package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxRVListener;", "", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "Companion", "libmmui_release"})
public abstract interface i
{
  public static final a LSz = a.LSB;
  
  public abstract void a(RecyclerView paramRecyclerView, g paramg);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxRVListener$Companion;", "", "()V", "DataHandleThreadName", "", "getDataHandleThreadName", "()Ljava/lang/String;", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_RESUME", "SCROLL_STATE_SETTLING", "libmmui_release"})
  public static final class a
  {
    private static final String LSA = "WxDataRecyclerView.DataHandle";
    
    static
    {
      AppMethodBeat.i(193935);
      LSB = new a();
      LSA = "WxDataRecyclerView.DataHandle";
      AppMethodBeat.o(193935);
    }
    
    public static String fUZ()
    {
      return LSA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */