package com.tencent.tinker.d.a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class i
{
  public static void a(f paramf, File paramFile, long paramLong, h paramh)
  {
    paramf = new f(paramf);
    paramf.setMethod(0);
    paramf.setSize(paramFile.length());
    paramf.Bwt = paramFile.length();
    if ((paramLong >= 0L) && (paramLong <= 4294967295L)) {
      paramf.Bwi = paramLong;
    }
    try
    {
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      int i;
      if (paramFile == null) {
        break label154;
      }
    }
    finally
    {
      try
      {
        paramh.b(new f(paramf));
        paramf = new byte[16384];
        i = paramFile.read(paramf);
        if (i != -1)
        {
          paramh.write(paramf, 0, i);
          i = paramFile.read(paramf);
          throw new IllegalArgumentException("Bad CRC32: ".concat(String.valueOf(paramLong)));
        }
        paramh.closeEntry();
        paramFile.close();
        return;
      }
      finally
      {
        break label146;
      }
      paramf = finally;
      paramFile = null;
    }
    label146:
    paramFile.close();
    label154:
    throw paramf;
  }
  
  public static void a(f paramf, InputStream paramInputStream, h paramh)
  {
    paramh.b(paramf);
    paramf = new byte[16384];
    for (int i = paramInputStream.read(paramf); i != -1; i = paramInputStream.read(paramf)) {
      paramh.write(paramf, 0, i);
    }
    paramh.closeEntry();
  }
  
  public static void a(g paramg, f paramf, h paramh)
  {
    g localg = null;
    try
    {
      paramg = paramg.a(paramf);
      localg = paramg;
      paramh.b(new f(paramf));
      localg = paramg;
      paramf = new byte[16384];
      localg = paramg;
      for (int i = paramg.read(paramf); i != -1; i = paramg.read(paramf))
      {
        localg = paramg;
        paramh.write(paramf, 0, i);
        localg = paramg;
      }
      localg = paramg;
      paramh.closeEntry();
      return;
    }
    finally
    {
      if (localg != null) {
        localg.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */