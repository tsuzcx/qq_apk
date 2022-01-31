package com.tencent.tmassistantsdk.storage.table;

public class DownloadLogTable
  extends BaseLogTable
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  protected static final String SQL_INSERT = "INSERT INTO downloadLogData logData = ?";
  public static final String TABLE_NAME = "downloadLogData";
  protected static DownloadLogTable mInstance = null;
  
  public static DownloadLogTable getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DownloadLogTable();
      }
      DownloadLogTable localDownloadLogTable = mInstance;
      return localDownloadLogTable;
    }
    finally {}
  }
  
  protected String[] getAlterSQL(int paramInt)
  {
    return new String[] { getCreateTableSQL() };
  }
  
  protected String getCreateTableSQL()
  {
    return "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  protected String getInsertSQL()
  {
    return "INSERT INTO downloadLogData logData = ?";
  }
  
  protected String getTableName()
  {
    return "downloadLogData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.DownloadLogTable
 * JD-Core Version:    0.7.0.1
 */