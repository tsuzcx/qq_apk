package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class n
  implements IWebViewDatabase
{
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207550);
    paramString1 = new WebView(XWalkEnvironment.getApplicationContext()).getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(207550);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207549);
    new WebView(XWalkEnvironment.getApplicationContext()).setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(207549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.n
 * JD-Core Version:    0.7.0.1
 */