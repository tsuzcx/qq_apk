package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;

public final class e
  extends j<d>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(77859);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "WebViewHistory") };
    AppMethodBeat.o(77859);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "WebViewHistory", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.e
 * JD-Core Version:    0.7.0.1
 */