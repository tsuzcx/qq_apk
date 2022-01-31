package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;

final class WebViewSmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  WebViewSmileyGrid$1(WebViewSmileyGrid paramWebViewSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(10104);
    if (paramInt == WebViewSmileyGrid.a(this.vtE).getCount() - 1)
    {
      if (WebViewSmileyGrid.b(this.vtE).vtJ != null) {
        WebViewSmileyGrid.b(this.vtE).vtJ.aRo();
      }
      AppMethodBeat.o(10104);
      return;
    }
    if (WebViewSmileyGrid.c(this.vtE) * (WebViewSmileyGrid.d(this.vtE) - 1) + paramInt >= WebViewSmileyGrid.e(this.vtE))
    {
      AppMethodBeat.o(10104);
      return;
    }
    int i = WebViewSmileyGrid.c(this.vtE);
    int j = WebViewSmileyGrid.d(this.vtE);
    if (WebViewSmileyGrid.b(this.vtE).vtJ != null)
    {
      paramAdapterView = WebViewSmileyGrid.b(this.vtE).vtJ;
      WebViewSmileyGrid.b(this.vtE);
      paramAdapterView.append(e.dve().qC(i * (j - 1) + paramInt));
    }
    AppMethodBeat.o(10104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */