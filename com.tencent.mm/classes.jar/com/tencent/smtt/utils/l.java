package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.zip.ZipEntry;

final class l
  implements k.b
{
  l(String paramString) {}
  
  public final boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
  {
    AppMethodBeat.i(65219);
    try
    {
      boolean bool = k.a(paramInputStream, paramZipEntry, this.a, paramString);
      AppMethodBeat.o(65219);
      return bool;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream = new Exception("copyFileIfChanged Exception", paramInputStream);
      AppMethodBeat.o(65219);
      throw paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */