package com.tencent.tmassistantsdk.downloadservice;

public class StopRequestException
  extends Exception
{
  protected static final long serialVersionUID = 1L;
  public final int mFinalErrCode;
  
  public StopRequestException(int paramInt, String paramString)
  {
    super(paramString);
    this.mFinalErrCode = paramInt;
  }
  
  public StopRequestException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.mFinalErrCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.StopRequestException
 * JD-Core Version:    0.7.0.1
 */