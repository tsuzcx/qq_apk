package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ap
  extends j<ao>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(79031);
    SQL_CREATE = new String[] { j.getCreateSQLs(ao.info, "WebviewLocalData") };
    AppMethodBeat.o(79031);
  }
  
  public ap(e parame)
  {
    super(parame, ao.info, "WebviewLocalData", null);
  }
  
  public static int aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79030);
    int i = (paramString1 + paramString2 + paramString3).hashCode();
    AppMethodBeat.o(79030);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ap
 * JD-Core Version:    0.7.0.1
 */