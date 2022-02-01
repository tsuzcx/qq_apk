package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class c
{
  public static String o(Throwable paramThrowable)
  {
    AppMethodBeat.i(194927);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = localByteArrayOutputStream.toString();
      localPrintStream.close();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(194927);
      return paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      AppMethodBeat.o(194927);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194926);
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (localObject.length < 4))
    {
      AppMethodBeat.o(194926);
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
    AppMethodBeat.o(194926);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.c
 * JD-Core Version:    0.7.0.1
 */