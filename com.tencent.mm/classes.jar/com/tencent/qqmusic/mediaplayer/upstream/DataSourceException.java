package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(105508);
    String str = "DataSourceException{errorCode=" + this.errorCode + "\nmessage=" + getMessage() + '}';
    AppMethodBeat.o(105508);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DataSourceException
 * JD-Core Version:    0.7.0.1
 */