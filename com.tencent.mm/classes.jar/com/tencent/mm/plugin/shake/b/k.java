package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class k
  extends MAutoStorage<j>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(28146);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "ShakeNewYearFriendInfo") };
    AppMethodBeat.o(28146);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.info, "ShakeNewYearFriendInfo", SQL_CREATE);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.k
 * JD-Core Version:    0.7.0.1
 */