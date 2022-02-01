package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TipsInfoLogTable
  extends BaseLogTable
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  protected static final String SQL_INSERT = "INSERT INTO TipsInfoLogData logData = ?";
  public static final String TABLE_NAME = "TipsInfoLogData";
  protected static TipsInfoLogTable mInstance = null;
  
  public static TipsInfoLogTable getInstance()
  {
    try
    {
      AppMethodBeat.i(102455);
      if (mInstance == null) {
        mInstance = new TipsInfoLogTable();
      }
      TipsInfoLogTable localTipsInfoLogTable = mInstance;
      AppMethodBeat.o(102455);
      return localTipsInfoLogTable;
    }
    finally {}
  }
  
  protected String[] getAlterSQL(int paramInt)
  {
    AppMethodBeat.i(102456);
    if (paramInt > 1)
    {
      String str = getCreateTableSQL();
      AppMethodBeat.o(102456);
      return new String[] { str };
    }
    AppMethodBeat.o(102456);
    return null;
  }
  
  protected String getCreateTableSQL()
  {
    return "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  protected String getInsertSQL()
  {
    return "INSERT INTO TipsInfoLogData logData = ?";
  }
  
  protected String getTableName()
  {
    return "TipsInfoLogData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable
 * JD-Core Version:    0.7.0.1
 */