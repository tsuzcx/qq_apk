package com.tencent.mm.plugin.shake.c.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class r
  extends MAutoStorage<q>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(28349);
    INDEX_CREATE = new String[0];
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(q.info, "shaketvhistory") };
    AppMethodBeat.o(28349);
  }
  
  public r(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, q.info, "shaketvhistory", SQL_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor gXH()
  {
    AppMethodBeat.i(28348);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(28348);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.r
 * JD-Core Version:    0.7.0.1
 */