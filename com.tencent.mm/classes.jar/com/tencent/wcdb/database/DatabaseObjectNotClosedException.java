package com.tencent.wcdb.database;

public class DatabaseObjectNotClosedException
  extends RuntimeException
{
  private static final String s = "Application did not close the cursor or database object that was opened here";
  
  public DatabaseObjectNotClosedException()
  {
    super("Application did not close the cursor or database object that was opened here");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.DatabaseObjectNotClosedException
 * JD-Core Version:    0.7.0.1
 */