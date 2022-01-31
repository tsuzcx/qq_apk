package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class g
{
  public static final char DIR_SEPARATOR;
  public static final String LINE_SEPARATOR;
  
  static
  {
    AppMethodBeat.i(86614);
    DIR_SEPARATOR = File.separatorChar;
    StringWriter localStringWriter = new StringWriter(4);
    new PrintWriter(localStringWriter).println();
    LINE_SEPARATOR = localStringWriter.toString();
    AppMethodBeat.o(86614);
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    AppMethodBeat.i(86609);
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      AppMethodBeat.o(86609);
      return;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(86609);
    }
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(86610);
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      AppMethodBeat.o(86610);
      return;
    }
    catch (IOException paramOutputStream)
    {
      AppMethodBeat.o(86610);
    }
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(86612);
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
    {
      AppMethodBeat.o(86612);
      return -1;
    }
    int i = (int)l;
    AppMethodBeat.o(86612);
    return i;
  }
  
  private static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(86613);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(86613);
    return l;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(86611);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(86611);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.util.g
 * JD-Core Version:    0.7.0.1
 */