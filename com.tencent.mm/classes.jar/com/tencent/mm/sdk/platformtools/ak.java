package com.tencent.mm.sdk.platformtools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class ak
{
  public static String b(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if ((paramArrayOfStackTraceElement == null) || (paramArrayOfStackTraceElement.length < 4)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 3;
    while (i < paramArrayOfStackTraceElement.length)
    {
      if ((paramArrayOfStackTraceElement[i].getClassName().contains("com.tencent.mm")) && (!paramArrayOfStackTraceElement[i].getClassName().contains("sdk.platformtools.Log")))
      {
        localStringBuilder.append("[");
        localStringBuilder.append(paramArrayOfStackTraceElement[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(paramArrayOfStackTraceElement[i].getMethodName());
        localStringBuilder.append("(" + paramArrayOfStackTraceElement[i].getLineNumber() + ")]");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String cri()
  {
    try
    {
      Object localObject = new Throwable().getStackTrace();
      if ((localObject != null) && (localObject.length >= 3))
      {
        String str = localObject[2].getClassName().substring(15);
        str = str + ":" + localObject[2].getMethodName();
        localObject = str + "(" + localObject[2].getLineNumber() + ")";
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      y.e("MicroMsg.Util.MMStack", "getCaller e:%s", new Object[] { j(localThrowable) });
      return "";
    }
    return "";
  }
  
  public static String crj()
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
  
  public static String j(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = localByteArrayOutputStream.toString();
      localPrintStream.close();
      localByteArrayOutputStream.close();
      return paramThrowable;
    }
    catch (Exception paramThrowable) {}
    return "";
  }
  
  public final String toString()
  {
    return crj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ak
 * JD-Core Version:    0.7.0.1
 */