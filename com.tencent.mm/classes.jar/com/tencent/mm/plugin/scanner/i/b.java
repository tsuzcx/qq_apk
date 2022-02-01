package com.tencent.mm.plugin.scanner.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ge;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b
  extends MAutoStorage
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(120862);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ah.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ah.info, "ScanTranslationResult", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(ah paramah)
  {
    AppMethodBeat.i(120861);
    if (aXn(paramah.field_originMD5) != null)
    {
      bool = replace(paramah);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramah);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final ge aXn(String paramString)
  {
    AppMethodBeat.i(120860);
    ah localah = new ah();
    localah.field_originMD5 = paramString;
    if (get(localah, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localah;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i.b
 * JD-Core Version:    0.7.0.1
 */