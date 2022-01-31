package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ao
  extends j<an>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(6738);
    SQL_CREATE = new String[] { j.getCreateSQLs(an.info, "WebviewLocalData") };
    AppMethodBeat.o(6738);
  }
  
  public ao(e parame)
  {
    super(parame, an.info, "WebviewLocalData", null);
  }
  
  public static int aw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6737);
    int i = (paramString1 + paramString2 + paramString3).hashCode();
    AppMethodBeat.o(6737);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ao
 * JD-Core Version:    0.7.0.1
 */