package com.tencent.mm.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRVListener;", "", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface o
{
  public static final a agOH = a.agOI;
  
  public abstract void a(RecyclerView paramRecyclerView, m paramm);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRVListener$Companion;", "", "()V", "DataHandleThreadName", "", "getDataHandleThreadName", "()Ljava/lang/String;", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_RESUME", "SCROLL_STATE_SETTLING", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final String agOJ;
    
    static
    {
      AppMethodBeat.i(234956);
      agOI = new a();
      agOJ = "WxDataRecyclerView.DataHandle";
      AppMethodBeat.o(234956);
    }
    
    public static String jNo()
    {
      return agOJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.o
 * JD-Core Version:    0.7.0.1
 */