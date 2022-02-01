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
  private static final byte[] MhC = { 0 };
  private byte[] MhD = EMPTY_BYTE_ARRAY;
  private final HashSet<String> MhE = new HashSet();
  private int MhF = 8;
  private ByteArrayOutputStream MhG = new ByteArrayOutputStream();
  private ZipEntry MhH;
  private long MhI = 0L;
  private int MhJ;
  private byte[] MhK;
  private final int MhL = 4;
  private boolean bWS = false;
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
  
  private void fYD()
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
    fYD();
    if (this.MhH == null) {
      return;
    }
    if (this.MhH.getMethod() == 8) {
      super.finish();
    }
    if (this.MhH.getMethod() == 0)
    {
      if (this.crc.getValue() != this.MhH.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.MhH.getSize() != this.MhI) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.MhH.getMethod() != 0)
    {
      i = 46;
      c(this.out, 134695760L);
      this.MhH.setCrc(this.crc.getValue());
      c(this.out, this.MhH.getCrc());
      this.MhH.setCompressedSize(this.def.getTotalOut());
      c(this.out, this.MhH.getCompressedSize());
      this.MhH.setSize(this.def.getTotalIn());
      c(this.out, this.MhH.getSize());
    }
    int j;
    if (this.MhH.getMethod() == 0)
    {
      j = 0;
      c(this.MhG, 33639248L);
      d(this.MhG, 20);
      d(this.MhG, 20);
      d(this.MhG, j | 0x800);
      d(this.MhG, this.MhH.getMethod());
      d(this.MhG, 0);
      d(this.MhG, 33);
      c(this.MhG, this.crc.getValue());
      if (this.MhH.getMethod() != 8) {
        break label587;
      }
      i = (int)(i + c(this.MhG, this.def.getTotalOut()));
      c(this.MhG, this.def.getTotalIn());
      label360:
      i += d(this.MhG, this.MhJ);
      if (this.MhH.getExtra() == null) {
        break label618;
      }
      i += d(this.MhG, this.MhH.getExtra().length);
    }
    for (;;)
    {
      String str = this.MhH.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.MhG, arrayOfByte.length);
      d(this.MhG, 0);
      d(this.MhG, 0);
      c(this.MhG, 0L);
      c(this.MhG, this.offset);
      this.MhG.write(this.MhK);
      this.MhK = null;
      if (this.MhH.getExtra() != null) {
        this.MhG.write(this.MhH.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.MhG.write(arrayOfByte);
      }
      this.MhH = null;
      this.crc.reset();
      this.MhI = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label587:
      i = (int)(i + c(this.MhG, this.MhI));
      c(this.MhG, this.MhI);
      break label360;
      label618:
      d(this.MhG, 0);
    }
  }
  
  public final void finish()
  {
    fYD();
    if (this.bWS) {
      return;
    }
    if (this.MhE.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.MhH != null) {
      closeEntry();
    }
    int i = this.MhG.size();
    c(this.MhG, 101010256L);
    d(this.MhG, 0);
    d(this.MhG, 0);
    d(this.MhG, this.MhE.size());
    d(this.MhG, this.MhE.size());
    c(this.MhG, i);
    c(this.MhG, this.offset + this.padding);
    d(this.MhG, this.MhD.length);
    if (this.MhD.length > 0) {
      this.MhG.write(this.MhD);
    }
    this.MhG.writeTo(this.out);
    this.MhG = null;
    this.bWS = true;
  }
  
  public final void putNextEntry(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.MhH != null) {
      closeEntry();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.MhF;
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
      fYD();
      if (this.MhE.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.MhE.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.MhK = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.MhJ = this.MhK.length;
      if (this.MhJ > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.MhJ + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.MhH = paramZipEntry;
      this.MhE.add(this.MhH.getName());
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
        if (this.MhH.getTime() == -1L) {
          this.MhH.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label609;
        }
        c(this.out, this.MhH.getCrc());
        c(this.out, this.MhH.getSize());
        c(this.out, this.MhH.getSize());
        d(this.out, this.MhJ);
        m = this.offset;
        n = this.MhJ;
        if (this.MhH.getExtra() == null) {
          break label639;
        }
        i = this.MhH.getExtra().length;
        label497:
        j = k;
        if (this.MhH.getMethod() == 0)
        {
          if (this.MhL != 0) {
            break label644;
          }
          j = k;
        }
        label520:
        this.padding = j;
        if (this.MhH.getExtra() == null) {
          break label672;
        }
        d(this.out, this.MhH.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.MhK);
        if (this.MhH.getExtra() != null) {
          this.out.write(this.MhH.getExtra());
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
        j = this.MhL;
        j = (j - (i + (n + (m + 30))) % j) % this.MhL;
        break label520;
        label672:
        d(this.out, this.padding);
      }
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = MhC;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.MhH == null) {
      throw new ZipException("No active entry");
    }
    if (this.MhH.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.MhI += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */