package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(96282);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "CanvasInfo") };
    AppMethodBeat.o(96282);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, a.info, "CanvasInfo");
  }
  
  private b(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(96281);
    if (parama == null)
    {
      AppMethodBeat.o(96281);
      return;
    }
    parama.field_createTime = System.currentTimeMillis();
    if (!insert(parama)) {
      update(parama, new String[0]);
    }
    AppMethodBeat.o(96281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */