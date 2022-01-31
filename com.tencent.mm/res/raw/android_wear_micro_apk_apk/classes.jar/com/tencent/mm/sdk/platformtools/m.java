package com.tencent.mm.sdk.platformtools;

public final class m
{
  public final String toString()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length < 4)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 3;
    while (i < arrayOfStackTraceElement.length)
    {
      if ((arrayOfStackTraceElement[i].getClassName().contains("com.tencent.mm")) && (!arrayOfStackTraceElement[i].getClassName().contains("sdk.platformtools.Log")))
      {
        localStringBuilder.append("[");
        localStringBuilder.append(arrayOfStackTraceElement[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(arrayOfStackTraceElement[i].getMethodName());
        localStringBuilder.append("(" + arrayOfStackTraceElement[i].getLineNumber() + ")]");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.m
 * JD-Core Version:    0.7.0.1
 */