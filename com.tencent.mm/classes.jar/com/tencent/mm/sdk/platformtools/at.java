package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class at
{
  public static String fkV()
  {
    AppMethodBeat.i(157711);
    try
    {
      Object localObject = new Throwable().getStackTrace();
      if ((localObject == null) || (localObject.length < 3))
      {
        AppMethodBeat.o(157711);
        return "";
      }
      String str = localObject[2].getClassName().substring(15);
      str = str + ":" + localObject[2].getMethodName();
      localObject = str + "(" + localObject[2].getLineNumber() + ")";
      AppMethodBeat.o(157711);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Util.MMStack", "getCaller e:%s", new Object[] { n(localThrowable) });
      AppMethodBeat.o(157711);
    }
    return "";
  }
  
  public static String fkW()
  {
    AppMethodBeat.i(157712);
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (localObject.length < 4))
    {
      AppMethodBeat.o(157712);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 3;
    while (i < localObject.length)
    {
      if ((localObject[i].getClassName().contains("com.tencent.mm")) && (!localObject[i].getClassName().contains("sdk.platformtools.Log")))
      {
        localStringBuilder.append("[");
        localStringBuilder.append(localObject[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(localObject[i].getMethodName());
        localStringBuilder.append("(" + localObject[i].getLineNumber() + ")]");
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(157712);
    return localObject;
  }
  
  public static String n(Throwable paramThrowable)
  {
    AppMethodBeat.i(157713);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(157713);
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
      AppMethodBeat.o(157713);
      return paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      AppMethodBeat.o(157713);
    }
    return "";
  }
  
  public static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(157714);
    if ((paramArrayOfStackTraceElement == null) || (paramArrayOfStackTraceElement.length < 4))
    {
      AppMethodBeat.o(157714);
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
    paramArrayOfStackTraceElement = localStringBuilder.toString();
    AppMethodBeat.o(157714);
    return paramArrayOfStackTraceElement;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(157710);
    String str = fkW();
    AppMethodBeat.o(157710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.at
 * JD-Core Version:    0.7.0.1
 */