package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;

public final class ad
  implements IWebViewDatabase
{
  public static IWebViewDatabase hta()
  {
    AppMethodBeat.i(219054);
    IWebViewDatabase localIWebViewDatabase = l.g(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(219054);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219056);
    paramString1 = hta().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(219056);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(219055);
    hta().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(219055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */