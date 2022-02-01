package com.tencent.tinker.d.a;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class j
{
  public static void a(g paramg, File paramFile, long paramLong, i parami)
  {
    paramg = new g(paramg);
    paramg.aIX(0);
    paramg.setSize(paramFile.length());
    paramg.ahSw = paramFile.length();
    if ((paramLong >= 0L) && (paramLong <= 4294967295L)) {
      paramg.crc = paramLong;
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
        parami.b(new g(paramg));
        paramg = new byte[16384];
        i = paramFile.read(paramg);
        if (i != -1)
        {
          parami.write(paramg, 0, i);
          i = paramFile.read(paramg);
          throw new IllegalArgumentException("Bad CRC32: ".concat(String.valueOf(paramLong)));
        }
        parami.kci();
        paramFile.close();
        return;
      }
      finally
      {
        break label146;
      }
      paramg = finally;
      paramFile = null;
    }
    label146:
    paramFile.close();
    label154:
    throw paramg;
  }
  
  public static void a(h paramh, g paramg, i parami)
  {
    h localh = null;
    try
    {
      paramh = paramh.a(paramg);
      localh = paramh;
      parami.b(new g(paramg));
      localh = paramh;
      paramg = new byte[16384];
      localh = paramh;
      for (int i = paramh.read(paramg); i != -1; i = paramh.read(paramg))
      {
        localh = paramh;
        parami.write(paramg, 0, i);
        localh = paramh;
      }
      localh = paramh;
      parami.kci();
      return;
    }
    finally
    {
      if (localh != null) {
        localh.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.d.a.j
 * JD-Core Version:    0.7.0.1
 */