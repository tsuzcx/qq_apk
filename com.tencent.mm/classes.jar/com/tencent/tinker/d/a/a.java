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
  private static final byte[] IFq = { 0 };
  private byte[] IFr = EMPTY_BYTE_ARRAY;
  private final HashSet<String> IFs = new HashSet();
  private int IFt = 8;
  private ByteArrayOutputStream IFu = new ByteArrayOutputStream();
  private ZipEntry IFv;
  private long IFw = 0L;
  private int IFx;
  private byte[] IFy;
  private final int IFz = 4;
  private boolean bOX = false;
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
  
  private void fpe()
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
    fpe();
    if (this.IFv == null) {
      return;
    }
    if (this.IFv.getMethod() == 8) {
      super.finish();
    }
    if (this.IFv.getMethod() == 0)
    {
      if (this.crc.getValue() != this.IFv.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.IFv.getSize() != this.IFw) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.IFv.getMethod() != 0)
    {
      i = 46;
      c(this.out, 134695760L);
      this.IFv.setCrc(this.crc.getValue());
      c(this.out, this.IFv.getCrc());
      this.IFv.setCompressedSize(this.def.getTotalOut());
      c(this.out, this.IFv.getCompressedSize());
      this.IFv.setSize(this.def.getTotalIn());
      c(this.out, this.IFv.getSize());
    }
    int j;
    if (this.IFv.getMethod() == 0)
    {
      j = 0;
      c(this.IFu, 33639248L);
      d(this.IFu, 20);
      d(this.IFu, 20);
      d(this.IFu, j | 0x800);
      d(this.IFu, this.IFv.getMethod());
      d(this.IFu, 0);
      d(this.IFu, 33);
      c(this.IFu, this.crc.getValue());
      if (this.IFv.getMethod() != 8) {
        break label587;
      }
      i = (int)(i + c(this.IFu, this.def.getTotalOut()));
      c(this.IFu, this.def.getTotalIn());
      label360:
      i += d(this.IFu, this.IFx);
      if (this.IFv.getExtra() == null) {
        break label618;
      }
      i += d(this.IFu, this.IFv.getExtra().length);
    }
    for (;;)
    {
      String str = this.IFv.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.IFu, arrayOfByte.length);
      d(this.IFu, 0);
      d(this.IFu, 0);
      c(this.IFu, 0L);
      c(this.IFu, this.offset);
      this.IFu.write(this.IFy);
      this.IFy = null;
      if (this.IFv.getExtra() != null) {
        this.IFu.write(this.IFv.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.IFu.write(arrayOfByte);
      }
      this.IFv = null;
      this.crc.reset();
      this.IFw = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label587:
      i = (int)(i + c(this.IFu, this.IFw));
      c(this.IFu, this.IFw);
      break label360;
      label618:
      d(this.IFu, 0);
    }
  }
  
  public final void finish()
  {
    fpe();
    if (this.bOX) {
      return;
    }
    if (this.IFs.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.IFv != null) {
      closeEntry();
    }
    int i = this.IFu.size();
    c(this.IFu, 101010256L);
    d(this.IFu, 0);
    d(this.IFu, 0);
    d(this.IFu, this.IFs.size());
    d(this.IFu, this.IFs.size());
    c(this.IFu, i);
    c(this.IFu, this.offset + this.padding);
    d(this.IFu, this.IFr.length);
    if (this.IFr.length > 0) {
      this.IFu.write(this.IFr);
    }
    this.IFu.writeTo(this.out);
    this.IFu = null;
    this.bOX = true;
  }
  
  public final void putNextEntry(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.IFv != null) {
      closeEntry();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.IFt;
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
      fpe();
      if (this.IFs.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.IFs.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.IFy = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.IFx = this.IFy.length;
      if (this.IFx > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.IFx + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.IFv = paramZipEntry;
      this.IFs.add(this.IFv.getName());
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
        if (this.IFv.getTime() == -1L) {
          this.IFv.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label609;
        }
        c(this.out, this.IFv.getCrc());
        c(this.out, this.IFv.getSize());
        c(this.out, this.IFv.getSize());
        d(this.out, this.IFx);
        m = this.offset;
        n = this.IFx;
        if (this.IFv.getExtra() == null) {
          break label639;
        }
        i = this.IFv.getExtra().length;
        label497:
        j = k;
        if (this.IFv.getMethod() == 0)
        {
          if (this.IFz != 0) {
            break label644;
          }
          j = k;
        }
        label520:
        this.padding = j;
        if (this.IFv.getExtra() == null) {
          break label672;
        }
        d(this.out, this.IFv.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.IFy);
        if (this.IFv.getExtra() != null) {
          this.out.write(this.IFv.getExtra());
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
        j = this.IFz;
        j = (j - (i + (n + (m + 30))) % j) % this.IFz;
        break label520;
        label672:
        d(this.out, this.padding);
      }
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = IFq;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.IFv == null) {
      throw new ZipException("No active entry");
    }
    if (this.IFv.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.IFw += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */