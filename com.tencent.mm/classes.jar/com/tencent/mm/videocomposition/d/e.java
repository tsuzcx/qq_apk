package com.tencent.mm.videocomposition.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class e
{
  public static String stackTraceToString(Throwable paramThrowable)
  {
    AppMethodBeat.i(233675);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = localByteArrayOutputStream.toString();
      localPrintStream.close();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(233675);
      return paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      AppMethodBeat.o(233675);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(233687);
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (localObject.length < 4))
    {
      AppMethodBeat.o(233687);
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
    AppMethodBeat.o(233687);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d.e
 * JD-Core Version:    0.7.0.1
 */