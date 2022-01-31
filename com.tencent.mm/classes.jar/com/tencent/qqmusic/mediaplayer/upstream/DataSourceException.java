package com.tencent.qqmusic.mediaplayer.upstream;

public class DataSourceException
  extends Exception
{
  private final int errorCode;
  
  public DataSourceException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String toString()
  {
    return "DataSourceException{errorCode=" + this.errorCode + "\nmessage=" + getMessage() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DataSourceException
 * JD-Core Version:    0.7.0.1
 */