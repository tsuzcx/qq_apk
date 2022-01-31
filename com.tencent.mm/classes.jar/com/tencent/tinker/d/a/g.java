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

public final class g
  implements Closeable
{
  private File BwA;
  private RandomAccessFile BwB;
  private final LinkedHashMap<String, f> Bwz = new LinkedHashMap();
  private final String filename;
  public String wqH;
  
  public g(File paramFile)
  {
    this(paramFile, (byte)0);
  }
  
  private g(File paramFile, byte paramByte)
  {
    this.filename = paramFile.getPath();
    this.BwA = null;
    this.BwB = new RandomAccessFile(this.filename, "r");
    dWL();
  }
  
  public g(String paramString)
  {
    this(new File(paramString), (byte)0);
  }
  
  static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, int paramInt)
  {
    String str = Integer.toHexString(paramInt);
    throw new ZipException("file name:" + paramString1 + ", file size" + paramLong1 + ", entry name:" + paramString2 + ", entry localHeaderRelOffset:" + paramLong2 + ", " + paramString3 + " signature not found; was " + str);
  }
  
  private void dWL()
  {
    long l1 = 0L;
    long l2 = this.BwB.length() - 22L;
    if (l2 < 0L) {
      throw new ZipException("File too short to be a zip file: " + this.BwB.length());
    }
    this.BwB.seek(0L);
    if (Integer.reverseBytes(this.BwB.readInt()) != 67324752L) {
      throw new ZipException("Not a zip archive");
    }
    long l3 = l2 - 65536L;
    if (l3 < 0L) {}
    for (;;)
    {
      this.BwB.seek(l2);
      if (Integer.reverseBytes(this.BwB.readInt()) != 101010256L)
      {
        l2 -= 1L;
        if (l2 < l1) {
          throw new ZipException("End Of Central Directory signature not found");
        }
      }
      else
      {
        Object localObject = new byte[18];
        this.BwB.readFully((byte[])localObject);
        localObject = c.a((byte[])localObject, 18, ByteOrder.LITTLE_ENDIAN);
        int i = ((b)localObject).readShort();
        int k = ((b)localObject).readShort();
        int j = ((b)localObject).readShort() & 0xFFFF;
        int m = ((b)localObject).readShort();
        ((b)localObject).dWJ();
        l1 = ((b)localObject).readInt() & 0xFFFFFFFF;
        int n = ((b)localObject).readShort() & 0xFFFF;
        if ((j != (m & 0xFFFF)) || ((i & 0xFFFF) != 0) || ((k & 0xFFFF) != 0)) {
          throw new ZipException("Spanned archives not supported");
        }
        if (n > 0)
        {
          localObject = new byte[n];
          this.BwB.readFully((byte[])localObject);
          this.wqH = new String((byte[])localObject, 0, localObject.length, d.UTF_8);
        }
        localObject = new BufferedInputStream(new a(this.BwB, l1), 4096);
        byte[] arrayOfByte = new byte[46];
        i = 0;
        while (i < j)
        {
          f localf = new f(arrayOfByte, (InputStream)localObject, d.UTF_8);
          if (localf.Bwx >= l1) {
            throw new ZipException("Local file header offset is after central directory");
          }
          String str = localf.name;
          if (this.Bwz.put(str, localf) != null) {
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
  
  public final InputStream a(f arg1)
  {
    f localf = axh(???.name);
    if (localf == null) {
      return null;
    }
    a locala;
    DataInputStream localDataInputStream;
    synchronized (this.BwB)
    {
      locala = new a(???, localf.Bwx);
      localDataInputStream = new DataInputStream(locala);
      i = Integer.reverseBytes(localDataInputStream.readInt());
      if (i != 67324752L) {
        a(this.filename, ???.length(), localf.name, localf.Bwx, "Local File Header", i);
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
    if (localObject.Bwu == 0) {
      a.a(locala, a.a(locala) + localObject.size);
    }
    for (;;)
    {
      return locala;
      a.a(locala, a.a(locala) + localObject.Bwt);
    }
  }
  
  public final f axh(String paramString)
  {
    dWK();
    if (paramString == null) {
      throw new NullPointerException("entryName == null");
    }
    f localf2 = (f)this.Bwz.get(paramString);
    f localf1 = localf2;
    if (localf2 == null) {
      localf1 = (f)this.Bwz.get(paramString + "/");
    }
    return localf1;
  }
  
  public final void close()
  {
    RandomAccessFile localRandomAccessFile = this.BwB;
    if (localRandomAccessFile != null) {}
    try
    {
      this.BwB = null;
      localRandomAccessFile.close();
      if (this.BwA != null)
      {
        this.BwA.delete();
        this.BwA = null;
      }
      return;
    }
    finally {}
  }
  
  public final void dWK()
  {
    if (this.BwB == null) {
      throw new IllegalStateException("Zip file closed");
    }
  }
  
  public final Enumeration<? extends f> entries()
  {
    dWK();
    new Enumeration()
    {
      public final boolean hasMoreElements()
      {
        g.a(g.this);
        return this.atQ.hasNext();
      }
    };
  }
  
  public static final class a
    extends InputStream
  {
    private final RandomAccessFile BwD;
    private long aNX;
    private long offset;
    
    public a(RandomAccessFile paramRandomAccessFile, long paramLong)
    {
      this(paramRandomAccessFile, paramLong, paramRandomAccessFile.length());
    }
    
    private a(RandomAccessFile paramRandomAccessFile, long paramLong1, long paramLong2)
    {
      this.BwD = paramRandomAccessFile;
      this.offset = paramLong1;
      this.aNX = paramLong2;
    }
    
    public final int available()
    {
      if (this.offset < this.aNX) {
        return 1;
      }
      return 0;
    }
    
    public final int read()
    {
      return e.K(this);
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      synchronized (this.BwD)
      {
        long l = this.aNX - this.offset;
        int i = paramInt2;
        if (paramInt2 > l) {
          i = (int)l;
        }
        this.BwD.seek(this.offset);
        paramInt1 = this.BwD.read(paramArrayOfByte, paramInt1, i);
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
      if (paramLong > this.aNX - this.offset) {
        l = this.aNX - this.offset;
      }
      this.offset += l;
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.g
 * JD-Core Version:    0.7.0.1
 */