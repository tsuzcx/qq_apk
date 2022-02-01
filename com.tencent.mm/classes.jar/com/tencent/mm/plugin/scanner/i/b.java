package com.tencent.mm.plugin.scanner.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.plugin.scanner.model.aq;
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
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aq.info, "ScanTranslationResult") };
    AppMethodBeat.o(120862);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aq.info, "ScanTranslationResult", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(aq paramaq)
  {
    AppMethodBeat.i(120861);
    if (aUV(paramaq.field_originMD5) != null)
    {
      bool = replace(paramaq);
      AppMethodBeat.o(120861);
      return bool;
    }
    boolean bool = super.insert(paramaq);
    AppMethodBeat.o(120861);
    return bool;
  }
  
  public final gy aUV(String paramString)
  {
    AppMethodBeat.i(120860);
    aq localaq = new aq();
    localaq.field_originMD5 = paramString;
    if (get(localaq, new String[0]))
    {
      AppMethodBeat.o(120860);
      return localaq;
    }
    AppMethodBeat.o(120860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.i.b
 * JD-Core Version:    0.7.0.1
 */