package com.tencent.mm.plugin.scanner.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(120862);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aj.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aj.info, "ScanTranslationResult", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(aj paramaj)
  {
    AppMethodBeat.i(120861);
    if (aMG(paramaj.field_originMD5) != null)
    {
      bool = replace(paramaj);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramaj);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final fx aMG(String paramString)
  {
    AppMethodBeat.i(120860);
    aj localaj = new aj();
    localaj.field_originMD5 = paramString;
    if (get(localaj, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localaj;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h.b
 * JD-Core Version:    0.7.0.1
 */