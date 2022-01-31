package com.tencent.wcdb;

public class SQLException
  extends RuntimeException
{
  public SQLException() {}
  
  public SQLException(String paramString)
  {
    super(paramString);
  }
  
  public SQLException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.SQLException
 * JD-Core Version:    0.7.0.1
 */