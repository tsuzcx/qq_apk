package com.tencent.mm.plugin.webview.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "", "value", "", "(Ljava/lang/String;II)V", "None", "NothingComplete", "CompleteA8keyAsyncOnly", "CompletePrefetch", "webview-sdk_release"})
public enum c
{
  static
  {
    AppMethodBeat.i(205832);
    c localc1 = new c("None", 0);
    PZE = localc1;
    c localc2 = new c("NothingComplete", 1);
    PZF = localc2;
    c localc3 = new c("CompleteA8keyAsyncOnly", 2);
    PZG = localc3;
    c localc4 = new c("CompletePrefetch", 3);
    PZH = localc4;
    PZI = new c[] { localc1, localc2, localc3, localc4 };
    AppMethodBeat.o(205832);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i.c
 * JD-Core Version:    0.7.0.1
 */