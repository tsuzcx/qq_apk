package com.tencent.tinker.d.a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class h
  implements Closeable
{
  public String DSo;
  private final LinkedHashMap<String, g> KrT = new LinkedHashMap();
  private File KrU;
  private RandomAccessFile KrV;
  private final String filename;
  
  public h(File paramFile)
  {
    this(paramFile, (byte)0);
  }
  
  private h(File paramFile, byte paramByte)
  {
    this.filename = paramFile.getPath();
    this.KrU = null;
    this.KrV = new RandomAccessFile(this.filename, "r");
    fHo();
  }
  
  public h(String paramString)
  {
    this(new File(paramString), (byte)0);
  }
  
  static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, int paramInt)
  {
    String str = Integer.toHexString(paramInt);
    throw new ZipException("file name:" + paramString1 + ", file size" + paramLong1 + ", entry name:" + paramString2 + ", entry localHeaderRelOffset:" + paramLong2 + ", " + paramString3 + " signature not found; was " + str);
  }
  
  private void fHo()
  {
    long l1 = 0L;
    long l2 = this.KrV.length() - 22L;
    if (l2 < 0L) {
      throw new ZipException("File too short to be a zip file: " + this.KrV.length());
    }
    this.KrV.seek(0L);
    if (Integer.reverseBytes(this.KrV.readInt()) != 67324752L) {
      throw new ZipException("Not a zip archive");
    }
    long l3 = l2 - 65536L;
    if (l3 < 0L) {}
    for (;;)
    {
      this.KrV.seek(l2);
      if (Integer.reverseBytes(this.KrV.readInt()) != 101010256L)
      {
        l2 -= 1L;
        if (l2 < l1) {
          throw new ZipException("End Of Central Directory signature not found");
        }
      }
      else
      {
        Object localObject = new byte[18];
        this.KrV.readFully((byte[])localObject);
        localObject = d.a((byte[])localObject, 18, ByteOrder.LITTLE_ENDIAN);
        int i = ((c)localObject).readShort();
        int k = ((c)localObject).readShort();
        int j = ((c)localObject).readShort() & 0xFFFF;
        int m = ((c)localObject).readShort();
        ((c)localObject).fHn();
        l1 = ((c)localObject).readInt() & 0xFFFFFFFF;
        int n = ((c)localObject).readShort() & 0xFFFF;
        if ((j != (m & 0xFFFF)) || ((i & 0xFFFF) != 0) || ((k & 0xFFFF) != 0)) {
          throw new ZipException("Spanned archives not supported");
        }
        if (n > 0)
        {
          localObject = new byte[n];
          this.KrV.readFully((byte[])localObject);
          this.DSo = new String((byte[])localObject, 0, localObject.length, e.UTF_8);
        }
        localObject = new BufferedInputStream(new a(this.KrV, l1), 4096);
        byte[] arrayOfByte = new byte[46];
        i = 0;
        while (i < j)
        {
          g localg = new g(arrayOfByte, (InputStream)localObject, e.UTF_8);
          if (localg.KrR >= l1) {
            throw new ZipException("Local file header offset is after central directory");
          }
          String str = localg.name;
          if (this.KrT.put(str, localg) != null) {
            throw new ZipException("Duplicate entry name: ".concat(String.valueOf(str)));
          }
          i += 1;
        }
        return;
      }
      continue;
      l1 = l3;
    }
  }
  
  public final InputStream a(g arg1)
  {
    g localg = aTV(???.name);
    if (localg == null) {
      return null;
    }
    a locala;
    DataInputStream localDataInputStream;
    synchronized (this.KrV)
    {
      locala = new a(???, localg.KrR);
      localDataInputStream = new DataInputStream(locala);
      i = Integer.reverseBytes(localDataInputStream.readInt());
      if (i != 67324752L) {
        a(this.filename, ???.length(), localg.name, localg.KrR, "Local File Header", i);
      }
      localDataInputStream.skipBytes(2);
      i = Short.reverseBytes(localDataInputStream.readShort()) & 0xFFFF;
      if ((i & 0x1) != 0) {
        throw new ZipException("Invalid General Purpose Bit Flag: ".concat(String.valueOf(i)));
      }
    }
    localDataInputStream.skipBytes(18);
    int i = Short.reverseBytes(localDataInputStream.readShort());
    int j = Short.reverseBytes(localDataInputStream.readShort());
    localDataInputStream.close();
    locala.skip((i & 0xFFFF) + (j & 0xFFFF));
    if (localObject.KrO == 0) {
      a.a(locala, a.a(locala) + localObject.size);
    }
    for (;;)
    {
      return locala;
      a.a(locala, a.a(locala) + localObject.KrN);
    }
  }
  
  public final g aTV(String paramString)
  {
    nC();
    if (paramString == null) {
      throw new NullPointerException("entryName == null");
    }
    g localg2 = (g)this.KrT.get(paramString);
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = (g)this.KrT.get(paramString + "/");
    }
    return localg1;
  }
  
  public final void close()
  {
    RandomAccessFile localRandomAccessFile = this.KrV;
    if (localRandomAccessFile != null) {}
    try
    {
      this.KrV = null;
      localRandomAccessFile.close();
      if (this.KrU != null)
      {
        this.KrU.delete();
        this.KrU = null;
      }
      return;
    }
    finally {}
  }
  
  public final Enumeration<? extends g> entries()
  {
    nC();
    new Enumeration()
    {
      public final boolean hasMoreElements()
      {
        h.a(h.this);
        return this.aPp.hasNext();
      }
    };
  }
  
  public final void nC()
  {
    if (this.KrV == null) {
      throw new IllegalStateException("Zip file closed");
    }
  }
  
  public static final class a
    extends InputStream
  {
    private final RandomAccessFile KrX;
    private long bkc;
    private long offset;
    
    public a(RandomAccessFile paramRandomAccessFile, long paramLong)
    {
      this(paramRandomAccessFile, paramLong, paramRandomAccessFile.length());
    }
    
    private a(RandomAccessFile paramRandomAccessFile, long paramLong1, long paramLong2)
    {
      this.KrX = paramRandomAccessFile;
      this.offset = paramLong1;
      this.bkc = paramLong2;
    }
    
    public final int available()
    {
      if (this.offset < this.bkc) {
        return 1;
      }
      return 0;
    }
    
    public final int read()
    {
      return f.T(this);
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      synchronized (this.KrX)
      {
        long l = this.bkc - this.offset;
        int i = paramInt2;
        if (paramInt2 > l) {
          i = (int)l;
        }
        this.KrX.seek(this.offset);
        paramInt1 = this.KrX.read(paramArrayOfByte, paramInt1, i);
        if (paramInt1 > 0)
        {
          this.offset += paramInt1;
          return paramInt1;
        }
        return -1;
      }
    }
    
    public final long skip(long paramLong)
    {
      long l = paramLong;
      if (paramLong > this.bkc - this.offset) {
        l = this.bkc - this.offset;
      }
      this.offset += l;
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.h
 * JD-Core Version:    0.7.0.1
 */