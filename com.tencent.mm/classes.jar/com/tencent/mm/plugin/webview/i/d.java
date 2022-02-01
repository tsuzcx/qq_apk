package com.tencent.mm.plugin.webview.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchReportNewAction;", "", "value", "", "(Ljava/lang/String;II)V", "None", "Click", "Start", "PageCommit", "PageFinish", "webview-sdk_release"})
public enum d
{
  static
  {
    AppMethodBeat.i(216380);
    d locald1 = new d("None", 0);
    PZJ = locald1;
    d locald2 = new d("Click", 1);
    PZK = locald2;
    d locald3 = new d("Start", 2);
    PZL = locald3;
    d locald4 = new d("PageCommit", 3);
    PZM = locald4;
    d locald5 = new d("PageFinish", 4);
    PZN = locald5;
    PZO = new d[] { locald1, locald2, locald3, locald4, locald5 };
    AppMethodBeat.o(216380);
  }
  
  private d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i.d
 * JD-Core Version:    0.7.0.1
 */