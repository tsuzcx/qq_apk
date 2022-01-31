package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.cd.e;

final class WebViewSmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  WebViewSmileyGrid$1(WebViewSmileyGrid paramWebViewSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == WebViewSmileyGrid.a(this.rDs).getCount() - 1) {
      if (WebViewSmileyGrid.b(this.rDs).rDx != null) {
        WebViewSmileyGrid.b(this.rDs).rDx.asj();
      }
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (WebViewSmileyGrid.c(this.rDs) * (WebViewSmileyGrid.d(this.rDs) - 1) + paramInt >= WebViewSmileyGrid.e(this.rDs));
      i = WebViewSmileyGrid.c(this.rDs);
      j = WebViewSmileyGrid.d(this.rDs);
    } while (WebViewSmileyGrid.b(this.rDs).rDx == null);
    WebViewSmileyGrid.b(this.rDs).rDx.append(e.csH().mY(i * (j - 1) + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */