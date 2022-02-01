package com.tencent.xweb.sys;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.IWebViewDatabase;

public final class f
  implements IWebViewDatabase
{
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207530);
    paramString1 = ad.gfI().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(207530);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207529);
    ad.gfI().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(207529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.f
 * JD-Core Version:    0.7.0.1
 */