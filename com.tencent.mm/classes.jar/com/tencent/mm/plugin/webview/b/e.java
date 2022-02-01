package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(77859);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "WebViewHistory") };
    AppMethodBeat.o(77859);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.info, "WebViewHistory", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.e
 * JD-Core Version:    0.7.0.1
 */