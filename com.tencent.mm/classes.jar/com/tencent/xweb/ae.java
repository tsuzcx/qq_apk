package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;

public final class ae
  implements IWebViewDatabase
{
  public static IWebViewDatabase iwI()
  {
    AppMethodBeat.i(197428);
    IWebViewDatabase localIWebViewDatabase = l.h(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(197428);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197432);
    paramString1 = iwI().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(197432);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197429);
    iwI().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(197429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ae
 * JD-Core Version:    0.7.0.1
 */