package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ah.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;

final class WebViewUI$s
  implements b
{
  private WebViewUI$s(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7965);
    String str = this.vgz.getIntent().getStringExtra("geta8key_username");
    boolean bool = ah.c.a(paramString, str, this.vgz.aio(str), this.vgz.igU, WebViewUI.Q(this.vgz), this.vgz.vgv, this.vgz.hashCode());
    AppMethodBeat.o(7965);
    return bool;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7964);
    boolean bool = ah.c.a(paramString, this.vgz.igU, this.vgz.getIntent().getIntExtra("geta8key_scene", 0));
    AppMethodBeat.o(7964);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.s
 * JD-Core Version:    0.7.0.1
 */