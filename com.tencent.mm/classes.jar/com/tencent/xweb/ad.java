package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;

public final class ad
  implements IWebViewDatabase
{
  public static IWebViewDatabase fJM()
  {
    AppMethodBeat.i(205071);
    IWebViewDatabase localIWebViewDatabase = j.g(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(205071);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205073);
    paramString1 = fJM().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(205073);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(205072);
    fJM().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(205072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */