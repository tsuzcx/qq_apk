package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import org.xwalk.core.Log;

public final class ae
{
  private static ae aifp = null;
  private IWebStorage aifo;
  
  private ae()
  {
    AppMethodBeat.i(156798);
    this.aifo = null;
    IWebStorage localIWebStorage = WebViewWrapperFactory.e(WebView.getCurWebType()).createWebviewStorage();
    if (localIWebStorage == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur webview type is " + WebView.getCurWebType());
      AppMethodBeat.o(156798);
      return;
    }
    this.aifo = localIWebStorage;
    AppMethodBeat.o(156798);
  }
  
  public static ae kfW()
  {
    try
    {
      AppMethodBeat.i(156797);
      if (aifp == null) {
        aifp = new ae();
      }
      ae localae = aifp;
      AppMethodBeat.o(156797);
      return localae;
    }
    finally {}
  }
  
  @Deprecated
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(212424);
    if (this.aifo == null)
    {
      Log.e("WebStorage", "deleteOrigin, failed webStg is null, cur webview type is " + WebView.getCurWebType());
      AppMethodBeat.o(212424);
      return;
    }
    this.aifo.deleteOrigin(paramString);
    AppMethodBeat.o(212424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.ae
 * JD-Core Version:    0.7.0.1
 */