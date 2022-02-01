package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aq
  extends MAutoStorage<ap>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(79031);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ap.info, "WebviewLocalData") };
    AppMethodBeat.o(79031);
  }
  
  public aq(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ap.info, "WebviewLocalData", null);
  }
  
  public static int bs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79030);
    int i = (paramString1 + paramString2 + paramString3).hashCode();
    AppMethodBeat.o(79030);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aq
 * JD-Core Version:    0.7.0.1
 */