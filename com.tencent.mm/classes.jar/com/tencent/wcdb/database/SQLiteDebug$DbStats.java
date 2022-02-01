package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SQLiteDebug$DbStats
{
  public String cache;
  public String dbName;
  public long dbSize;
  public int lookaside;
  public long pageSize;
  
  public SQLiteDebug$DbStats(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(3230);
    this.dbName = paramString;
    this.pageSize = (paramLong2 / 1024L);
    this.dbSize = (paramLong1 * paramLong2 / 1024L);
    this.lookaside = paramInt1;
    this.cache = (paramInt2 + "/" + paramInt3 + "/" + paramInt4);
    AppMethodBeat.o(3230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug.DbStats
 * JD-Core Version:    0.7.0.1
 */