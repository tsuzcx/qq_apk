package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$4$1
  implements c.a
{
  WebViewInputFooter$4$1(WebViewInputFooter.4 param4) {}
  
  public final void JU() {}
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(10079);
    if (WebViewInputFooter.k(this.vtB.vtA) != null) {
      WebViewInputFooter.k(this.vtB.vtA).agO(WebViewInputFooter.d(this.vtB.vtA).getText().toString());
    }
    paramString = this.vtB.vtA;
    paramString.vtw.clearComposingText();
    paramString.vtw.setText("");
    AppMethodBeat.o(10079);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(10080);
    if (WebViewInputFooter.b(this.vtB.vtA) != null) {
      Toast.makeText(WebViewInputFooter.b(this.vtB.vtA), "exceed max-length", 0).show();
    }
    AppMethodBeat.o(10080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.4.1
 * JD-Core Version:    0.7.0.1
 */