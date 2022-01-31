package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI$a
  extends WebViewUI.h
{
  protected GameBaseWebViewUI$a(GameBaseWebViewUI paramGameBaseWebViewUI)
  {
    super(paramGameBaseWebViewUI);
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8636);
    super.b(paramWebView, paramString);
    GameBaseWebViewUI.a(this.vmh).vmB.uG();
    AppMethodBeat.o(8636);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8635);
    GameBaseWebViewUI.a(this.vmh).vmB.dgb();
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(8635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */