package com.tencent.mm.sdk.platformtools;

final class d
  extends RuntimeException
{
  d(String paramString, Throwable paramThrowable)
  {
    super(paramString + "\n See stacktrace to find where is the holder(listener) being added.");
    setStackTrace(paramThrowable.getStackTrace());
  }
  
  public final Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */