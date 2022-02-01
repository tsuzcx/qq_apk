package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public final class a
  extends DeflaterOutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final byte[] KrB = { 0 };
  private byte[] KrC = EMPTY_BYTE_ARRAY;
  private final HashSet<String> KrD = new HashSet();
  private int KrE = 8;
  private ByteArrayOutputStream KrF = new ByteArrayOutputStream();
  private ZipEntry KrG;
  private long KrH = 0L;
  private int KrI;
  private byte[] KrJ;
  private final int KrK = 4;
  private boolean bMF = false;
  private boolean closed = false;
  private int compressionLevel = -1;
  private final CRC32 crc = new CRC32();
  private int offset = 0;
  private int padding = 0;
  
  public a(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private a(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream, new Deflater(-1, true));
  }
  
  private static long c(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private static void c(OutputStream paramOutputStream, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      while (i > 0)
      {
        paramOutputStream.write(0);
        i -= 1;
      }
    }
  }
  
  private static int d(OutputStream paramOutputStream, int paramInt)
  {
    if (paramInt > 65535) {
      throw new IllegalArgumentException("value " + paramInt + " is too large for type 'short'.");
    }
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private void fHm()
  {
    if (this.closed) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void close()
  {
    if (!this.closed)
    {
      finish();
      this.def.end();
      this.out.close();
      this.out = null;
      this.closed = true;
    }
  }
  
  public final void closeEntry()
  {
    fHm();
    if (this.KrG == null) {
      return;
    }
    if (this.KrG.getMethod() == 8) {
      super.finish();
    }
    if (this.KrG.getMethod() == 0)
    {
      if (this.crc.getValue() != this.KrG.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.KrG.getSize() != this.KrH) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.KrG.getMethod() != 0)
    {
      i = 46;
      c(this.out, 134695760L);
      this.KrG.setCrc(this.crc.getValue());
      c(this.out, this.KrG.getCrc());
      this.KrG.setCompressedSize(this.def.getTotalOut());
      c(this.out, this.KrG.getCompressedSize());
      this.KrG.setSize(this.def.getTotalIn());
      c(this.out, this.KrG.getSize());
    }
    int j;
    if (this.KrG.getMethod() == 0)
    {
      j = 0;
      c(this.KrF, 33639248L);
      d(this.KrF, 20);
      d(this.KrF, 20);
      d(this.KrF, j | 0x800);
      d(this.KrF, this.KrG.getMethod());
      d(this.KrF, 0);
      d(this.KrF, 33);
      c(this.KrF, this.crc.getValue());
      if (this.KrG.getMethod() != 8) {
        break label587;
      }
      i = (int)(i + c(this.KrF, this.def.getTotalOut()));
      c(this.KrF, this.def.getTotalIn());
      label360:
      i += d(this.KrF, this.KrI);
      if (this.KrG.getExtra() == null) {
        break label618;
      }
      i += d(this.KrF, this.KrG.getExtra().length);
    }
    for (;;)
    {
      String str = this.KrG.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.KrF, arrayOfByte.length);
      d(this.KrF, 0);
      d(this.KrF, 0);
      c(this.KrF, 0L);
      c(this.KrF, this.offset);
      this.KrF.write(this.KrJ);
      this.KrJ = null;
      if (this.KrG.getExtra() != null) {
        this.KrF.write(this.KrG.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.KrF.write(arrayOfByte);
      }
      this.KrG = null;
      this.crc.reset();
      this.KrH = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label587:
      i = (int)(i + c(this.KrF, this.KrH));
      c(this.KrF, this.KrH);
      break label360;
      label618:
      d(this.KrF, 0);
    }
  }
  
  public final void finish()
  {
    fHm();
    if (this.bMF) {
      return;
    }
    if (this.KrD.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.KrG != null) {
      closeEntry();
    }
    int i = this.KrF.size();
    c(this.KrF, 101010256L);
    d(this.KrF, 0);
    d(this.KrF, 0);
    d(this.KrF, this.KrD.size());
    d(this.KrF, this.KrD.size());
    c(this.KrF, i);
    c(this.KrF, this.offset + this.padding);
    d(this.KrF, this.KrC.length);
    if (this.KrC.length > 0) {
      this.KrF.write(this.KrC);
    }
    this.KrF.writeTo(this.out);
    this.KrF = null;
    this.bMF = true;
  }
  
  public final void putNextEntry(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.KrG != null) {
      closeEntry();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.KrE;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramZipEntry.getCompressedSize() == -1L) {
          paramZipEntry.setCompressedSize(paramZipEntry.getSize());
        }
        while (paramZipEntry.getCrc() == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramZipEntry.getSize() == -1L) {
            paramZipEntry.setSize(paramZipEntry.getCompressedSize());
          }
        }
        if (paramZipEntry.getSize() == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramZipEntry.getSize() != paramZipEntry.getCompressedSize()) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      fHm();
      if (this.KrD.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.KrD.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.KrJ = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.KrI = this.KrJ.length;
      if (this.KrI > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.KrI + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.KrG = paramZipEntry;
      this.KrD.add(this.KrG.getName());
      int j;
      label454:
      int m;
      int n;
      if (i == 0)
      {
        j = 0;
        c(this.out, 67324752L);
        d(this.out, 20);
        d(this.out, j | 0x800);
        d(this.out, i);
        if (this.KrG.getTime() == -1L) {
          this.KrG.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label609;
        }
        c(this.out, this.KrG.getCrc());
        c(this.out, this.KrG.getSize());
        c(this.out, this.KrG.getSize());
        d(this.out, this.KrI);
        m = this.offset;
        n = this.KrI;
        if (this.KrG.getExtra() == null) {
          break label639;
        }
        i = this.KrG.getExtra().length;
        label497:
        j = k;
        if (this.KrG.getMethod() == 0)
        {
          if (this.KrK != 0) {
            break label644;
          }
          j = k;
        }
        label520:
        this.padding = j;
        if (this.KrG.getExtra() == null) {
          break label672;
        }
        d(this.out, this.KrG.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.KrJ);
        if (this.KrG.getExtra() != null) {
          this.out.write(this.KrG.getExtra());
        }
        c(this.out, this.padding);
        return;
        j = 8;
        break;
        label609:
        c(this.out, 0L);
        c(this.out, 0L);
        c(this.out, 0L);
        break label454;
        label639:
        i = 0;
        break label497;
        label644:
        j = this.KrK;
        j = (j - (i + (n + (m + 30))) % j) % this.KrK;
        break label520;
        label672:
        d(this.out, this.padding);
      }
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = KrB;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.KrG == null) {
      throw new ZipException("No active entry");
    }
    if (this.KrG.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.KrH += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */