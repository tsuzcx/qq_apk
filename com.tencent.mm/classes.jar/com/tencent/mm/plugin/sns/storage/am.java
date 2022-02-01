package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class am
  extends MAutoStorage<al>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(97653);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(al.info, "UxCanvasInfo") };
    AppMethodBeat.o(97653);
  }
  
  public am(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, al.info, "UxCanvasInfo");
  }
  
  private am(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
  }
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(97652);
    if ((paramal == null) || (Util.isNullOrNil(paramal.field_canvasXml)))
    {
      AppMethodBeat.o(97652);
      return;
    }
    paramal.field_createTime = System.currentTimeMillis();
    if (!insert(paramal)) {
      update(paramal, new String[0]);
    }
    AppMethodBeat.o(97652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.am
 * JD-Core Version:    0.7.0.1
 */