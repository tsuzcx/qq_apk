package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;

public final class ad
  implements IWebViewDatabase
{
  public static IWebViewDatabase gfI()
  {
    AppMethodBeat.i(217400);
    IWebViewDatabase localIWebViewDatabase = j.g(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(217400);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217402);
    paramString1 = gfI().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(217402);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217401);
    gfI().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(217401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */