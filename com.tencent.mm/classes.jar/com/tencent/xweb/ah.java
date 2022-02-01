package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;

public final class ah
  implements IWebViewDatabase
{
  public static IWebViewDatabase kfZ()
  {
    AppMethodBeat.i(212431);
    IWebViewDatabase localIWebViewDatabase = WebViewWrapperFactory.e(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(212431);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212439);
    paramString1 = kfZ().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(212439);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212435);
    kfZ().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(212435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.ah
 * JD-Core Version:    0.7.0.1
 */