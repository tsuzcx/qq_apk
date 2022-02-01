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
  private static final byte[] Skx = { 0 };
  private int SkA = 8;
  private ByteArrayOutputStream SkB = new ByteArrayOutputStream();
  private ZipEntry SkC;
  private long SkD = 0L;
  private int SkE;
  private byte[] SkF;
  private final int SkG = 4;
  private byte[] Sky = EMPTY_BYTE_ARRAY;
  private final HashSet<String> Skz = new HashSet();
  private boolean chA = false;
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
  
  private void hpk()
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
    hpk();
    if (this.SkC == null) {
      return;
    }
    if (this.SkC.getMethod() == 8) {
      super.finish();
    }
    if (this.SkC.getMethod() == 0)
    {
      if (this.crc.getValue() != this.SkC.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.SkC.getSize() != this.SkD) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.SkC.getMethod() != 0)
    {
      i = 46;
      c(this.out, 134695760L);
      this.SkC.setCrc(this.crc.getValue());
      c(this.out, this.SkC.getCrc());
      this.SkC.setCompressedSize(this.def.getTotalOut());
      c(this.out, this.SkC.getCompressedSize());
      this.SkC.setSize(this.def.getTotalIn());
      c(this.out, this.SkC.getSize());
    }
    int j;
    if (this.SkC.getMethod() == 0)
    {
      j = 0;
      c(this.SkB, 33639248L);
      d(this.SkB, 20);
      d(this.SkB, 20);
      d(this.SkB, j | 0x800);
      d(this.SkB, this.SkC.getMethod());
      d(this.SkB, 0);
      d(this.SkB, 33);
      c(this.SkB, this.crc.getValue());
      if (this.SkC.getMethod() != 8) {
        break label587;
      }
      i = (int)(i + c(this.SkB, this.def.getTotalOut()));
      c(this.SkB, this.def.getTotalIn());
      label360:
      i += d(this.SkB, this.SkE);
      if (this.SkC.getExtra() == null) {
        break label618;
      }
      i += d(this.SkB, this.SkC.getExtra().length);
    }
    for (;;)
    {
      String str = this.SkC.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.SkB, arrayOfByte.length);
      d(this.SkB, 0);
      d(this.SkB, 0);
      c(this.SkB, 0L);
      c(this.SkB, this.offset);
      this.SkB.write(this.SkF);
      this.SkF = null;
      if (this.SkC.getExtra() != null) {
        this.SkB.write(this.SkC.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.SkB.write(arrayOfByte);
      }
      this.SkC = null;
      this.crc.reset();
      this.SkD = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label587:
      i = (int)(i + c(this.SkB, this.SkD));
      c(this.SkB, this.SkD);
      break label360;
      label618:
      d(this.SkB, 0);
    }
  }
  
  public final void finish()
  {
    hpk();
    if (this.chA) {
      return;
    }
    if (this.Skz.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.SkC != null) {
      closeEntry();
    }
    int i = this.SkB.size();
    c(this.SkB, 101010256L);
    d(this.SkB, 0);
    d(this.SkB, 0);
    d(this.SkB, this.Skz.size());
    d(this.SkB, this.Skz.size());
    c(this.SkB, i);
    c(this.SkB, this.offset + this.padding);
    d(this.SkB, this.Sky.length);
    if (this.Sky.length > 0) {
      this.SkB.write(this.Sky);
    }
    this.SkB.writeTo(this.out);
    this.SkB = null;
    this.chA = true;
  }
  
  public final void putNextEntry(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.SkC != null) {
      closeEntry();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.SkA;
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
      hpk();
      if (this.Skz.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.Skz.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.SkF = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.SkE = this.SkF.length;
      if (this.SkE > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.SkE + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.SkC = paramZipEntry;
      this.Skz.add(this.SkC.getName());
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
        if (this.SkC.getTime() == -1L) {
          this.SkC.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label609;
        }
        c(this.out, this.SkC.getCrc());
        c(this.out, this.SkC.getSize());
        c(this.out, this.SkC.getSize());
        d(this.out, this.SkE);
        m = this.offset;
        n = this.SkE;
        if (this.SkC.getExtra() == null) {
          break label639;
        }
        i = this.SkC.getExtra().length;
        label497:
        j = k;
        if (this.SkC.getMethod() == 0)
        {
          if (this.SkG != 0) {
            break label644;
          }
          j = k;
        }
        label520:
        this.padding = j;
        if (this.SkC.getExtra() == null) {
          break label672;
        }
        d(this.out, this.SkC.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.SkF);
        if (this.SkC.getExtra() != null) {
          this.out.write(this.SkC.getExtra());
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
        j = this.SkG;
        j = (j - (i + (n + (m + 30))) % j) % this.SkG;
        break label520;
        label672:
        d(this.out, this.padding);
      }
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = Skx;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.SkC == null) {
      throw new ZipException("No active entry");
    }
    if (this.SkC.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.SkD += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */