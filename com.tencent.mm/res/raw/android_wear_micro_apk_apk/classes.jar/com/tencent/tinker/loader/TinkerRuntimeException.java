package com.tencent.tinker.loader;

public class TinkerRuntimeException
  extends RuntimeException
{
  public TinkerRuntimeException(String paramString)
  {
    super("Tinker Exception:" + paramString);
  }
  
  public TinkerRuntimeException(String paramString, Throwable paramThrowable)
  {
    super("Tinker Exception:" + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerRuntimeException
 * JD-Core Version:    0.7.0.1
 */