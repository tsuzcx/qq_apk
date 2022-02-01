package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchReportNewAction;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "isBindConnected", "", "isMainAction", "isMainActionForStart", "None", "OnCreateUI", "StartLoad", "PageStart", "PageCommit", "PageFinish", "OnConnect", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(294704);
    WQB = new d("None", 0, 0);
    WQC = new d("OnCreateUI", 1, 11);
    WQD = new d("StartLoad", 2, 12);
    WQE = new d("PageStart", 3, 13);
    WQF = new d("PageCommit", 4, 14);
    WQG = new d("PageFinish", 5, 15);
    WQH = new d("OnConnect", 6, 21);
    WQI = new d[] { WQB, WQC, WQD, WQE, WQF, WQG, WQH };
    AppMethodBeat.o(294704);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.d
 * JD-Core Version:    0.7.0.1
 */