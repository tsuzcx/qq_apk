package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/IsColdBootWebView;", "", "value", "", "(Ljava/lang/String;II)V", "None", "ColdBoot", "WarmBoot", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(294714);
    WQs = new b("None", 0);
    WQt = new b("ColdBoot", 1);
    WQu = new b("WarmBoot", 2);
    WQv = new b[] { WQs, WQt, WQu };
    AppMethodBeat.o(294714);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */