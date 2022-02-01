package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ac
  extends MAutoStorage<ab>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(97653);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ab.info, "UxCanvasInfo") };
    AppMethodBeat.o(97653);
  }
  
  public ac(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, ab.info, "UxCanvasInfo");
  }
  
  private ac(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(97652);
    if ((paramab == null) || (Util.isNullOrNil(paramab.field_canvasXml)))
    {
      AppMethodBeat.o(97652);
      return;
    }
    paramab.field_createTime = System.currentTimeMillis();
    if (!insert(paramab)) {
      update(paramab, new String[0]);
    }
    AppMethodBeat.o(97652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ac
 * JD-Core Version:    0.7.0.1
 */