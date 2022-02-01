package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "", "value", "", "(Ljava/lang/String;II)V", "None", "NothingComplete", "CompleteA8keyAsyncOnly", "CompletePrefetch", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  static
  {
    AppMethodBeat.i(294691);
    WQw = new c("None", 0);
    WQx = new c("NothingComplete", 1);
    WQy = new c("CompleteA8keyAsyncOnly", 2);
    WQz = new c("CompletePrefetch", 3);
    WQA = new c[] { WQw, WQx, WQy, WQz };
    AppMethodBeat.o(294691);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.c
 * JD-Core Version:    0.7.0.1
 */