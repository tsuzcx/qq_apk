package com.tencent.smtt.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;

final class k
  implements j.b
{
  k(String paramString) {}
  
  public final boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
  {
    try
    {
      boolean bool = j.a(paramInputStream, paramZipEntry, this.a, paramString);
      return bool;
    }
    catch (Exception paramInputStream)
    {
      throw new Exception("copyFileIfChanged Exception", paramInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.k
 * JD-Core Version:    0.7.0.1
 */