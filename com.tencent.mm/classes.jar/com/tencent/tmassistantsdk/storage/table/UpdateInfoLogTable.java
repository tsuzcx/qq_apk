package com.tencent.tmassistantsdk.storage.table;

public class UpdateInfoLogTable
  extends BaseLogTable
{
  private static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  private static final String INSERT_SQL = "INSERT INTO SelfUpdateInfoLogData logData = ?";
  private static final String TABLE_NAME = "SelfUpdateInfoLogData";
  private static UpdateInfoLogTable mInstance = null;
  
  public static UpdateInfoLogTable getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new UpdateInfoLogTable();
      }
      UpdateInfoLogTable localUpdateInfoLogTable = mInstance;
      return localUpdateInfoLogTable;
    }
    finally {}
  }
  
  protected String[] getAlterSQL(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { getCreateTableSQL() };
    }
    return null;
  }
  
  protected String getCreateTableSQL()
  {
    return "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  protected String getInsertSQL()
  {
    return "INSERT INTO SelfUpdateInfoLogData logData = ?";
  }
  
  protected String getTableName()
  {
    return "SelfUpdateInfoLogData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable
 * JD-Core Version:    0.7.0.1
 */