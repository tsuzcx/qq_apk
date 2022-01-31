package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MMWebViewWithJsApi$a
{
  public static MMWebViewWithJsApi fC(Context paramContext)
  {
    AppMethodBeat.i(156888);
    paramContext = fD(paramContext);
    AppMethodBeat.o(156888);
    return paramContext;
  }
  
  public static MMWebViewWithJsApi fD(Context paramContext)
  {
    AppMethodBeat.i(10029);
    MMWebViewWithJsApi.fB(paramContext);
    paramContext = new MMWebViewWithJsApi(paramContext);
    MMWebViewWithJsApi.a(paramContext);
    AppMethodBeat.o(10029);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a
 * JD-Core Version:    0.7.0.1
 */