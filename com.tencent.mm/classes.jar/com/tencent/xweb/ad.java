package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;

public final class ad
  implements IWebViewDatabase
{
  public static IWebViewDatabase gbg()
  {
    AppMethodBeat.i(197082);
    IWebViewDatabase localIWebViewDatabase = j.g(WebView.getCurWebType()).getWebViewDatabase();
    AppMethodBeat.o(197082);
    return localIWebViewDatabase;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197084);
    paramString1 = gbg().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(197084);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197083);
    gbg().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(197083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */