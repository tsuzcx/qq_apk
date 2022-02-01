package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.f.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"forEachLine", "", "Lcom/tencent/mm/vfs/VFSFile;", "charset", "Ljava/nio/charset/Charset;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "readText", "reader", "Ljava/io/InputStreamReader;", "writeBytes", "array", "", "writeText", "text", "mmkernel_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  private static String a(u paramu, Charset paramCharset)
  {
    AppMethodBeat.i(176827);
    s.u(paramu, "<this>");
    s.u(paramCharset, "charset");
    s.u(paramu, "<this>");
    s.u(paramCharset, "charset");
    paramu = y.ao(paramu);
    s.s(paramu, "openRead(this)");
    paramu = (Closeable)new InputStreamReader(paramu, paramCharset);
    try
    {
      paramCharset = d.a((Reader)paramu);
      b.a(paramu, null);
      AppMethodBeat.o(176827);
      return paramCharset;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(176827);
        throw paramCharset;
      }
      finally
      {
        b.a(paramu, paramCharset);
        AppMethodBeat.o(176827);
      }
    }
  }
  
  private static void a(u paramu, String paramString, Charset paramCharset)
  {
    AppMethodBeat.i(176829);
    s.u(paramu, "<this>");
    s.u(paramString, "text");
    s.u(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    b(paramu, paramString);
    AppMethodBeat.o(176829);
  }
  
  public static final void b(u paramu, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(176826);
    s.u(paramu, "<this>");
    s.u(paramArrayOfByte, "array");
    paramu = (Closeable)y.ap(paramu);
    try
    {
      ((OutputStream)paramu).write(paramArrayOfByte);
      paramArrayOfByte = ah.aiuX;
      b.a(paramu, null);
      AppMethodBeat.o(176826);
      return;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(176826);
        throw paramArrayOfByte;
      }
      finally
      {
        b.a(paramu, paramArrayOfByte);
        AppMethodBeat.o(176826);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.v
 * JD-Core Version:    0.7.0.1
 */