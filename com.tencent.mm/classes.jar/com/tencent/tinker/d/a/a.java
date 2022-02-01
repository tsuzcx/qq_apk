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
  private static final byte[] ZNi = { 0 };
  private byte[] ZNj = EMPTY_BYTE_ARRAY;
  private final HashSet<String> ZNk = new HashSet();
  private int ZNl = 8;
  private ByteArrayOutputStream ZNm = new ByteArrayOutputStream();
  private ZipEntry ZNn;
  private long ZNo = 0L;
  private int ZNp;
  private byte[] ZNq;
  private final int ZNr = 4;
  private boolean closed = false;
  private int compressionLevel = -1;
  private final CRC32 crc = new CRC32();
  private boolean jHM = false;
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
  
  private static long e(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private void isM()
  {
    if (this.closed) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void a(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.ZNn != null) {
      isL();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.ZNl;
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
      isM();
      if (this.ZNk.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.ZNk.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.ZNq = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.ZNp = this.ZNq.length;
      if (this.ZNp > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.ZNp + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.ZNn = paramZipEntry;
      this.ZNk.add(this.ZNn.getName());
      int j;
      label448:
      int m;
      int n;
      if (i == 0)
      {
        j = 0;
        e(this.out, 67324752L);
        d(this.out, 20);
        d(this.out, j | 0x800);
        d(this.out, i);
        if (this.ZNn.getTime() == -1L) {
          this.ZNn.setTime(System.currentTimeMillis());
        }
        d(this.out, 0);
        d(this.out, 33);
        if (i != 0) {
          break label603;
        }
        e(this.out, this.ZNn.getCrc());
        e(this.out, this.ZNn.getSize());
        e(this.out, this.ZNn.getSize());
        d(this.out, this.ZNp);
        m = this.offset;
        n = this.ZNp;
        if (this.ZNn.getExtra() == null) {
          break label633;
        }
        i = this.ZNn.getExtra().length;
        label491:
        j = k;
        if (this.ZNn.getMethod() == 0)
        {
          if (this.ZNr != 0) {
            break label638;
          }
          j = k;
        }
        label514:
        this.padding = j;
        if (this.ZNn.getExtra() == null) {
          break label666;
        }
        d(this.out, this.ZNn.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.ZNq);
        if (this.ZNn.getExtra() != null) {
          this.out.write(this.ZNn.getExtra());
        }
        c(this.out, this.padding);
        return;
        j = 8;
        break;
        label603:
        e(this.out, 0L);
        e(this.out, 0L);
        e(this.out, 0L);
        break label448;
        label633:
        i = 0;
        break label491;
        label638:
        j = this.ZNr;
        j = (j - (i + (n + (m + 30))) % j) % this.ZNr;
        break label514;
        label666:
        d(this.out, this.padding);
      }
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
  
  public final void finish()
  {
    isM();
    if (this.jHM) {
      return;
    }
    if (this.ZNk.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.ZNn != null) {
      isL();
    }
    int i = this.ZNm.size();
    e(this.ZNm, 101010256L);
    d(this.ZNm, 0);
    d(this.ZNm, 0);
    d(this.ZNm, this.ZNk.size());
    d(this.ZNm, this.ZNk.size());
    e(this.ZNm, i);
    e(this.ZNm, this.offset + this.padding);
    d(this.ZNm, this.ZNj.length);
    if (this.ZNj.length > 0) {
      this.ZNm.write(this.ZNj);
    }
    this.ZNm.writeTo(this.out);
    this.ZNm = null;
    this.jHM = true;
  }
  
  public final void isL()
  {
    isM();
    if (this.ZNn == null) {
      return;
    }
    if (this.ZNn.getMethod() == 8) {
      super.finish();
    }
    if (this.ZNn.getMethod() == 0)
    {
      if (this.crc.getValue() != this.ZNn.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.ZNn.getSize() != this.ZNo) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.ZNn.getMethod() != 0)
    {
      i = 46;
      e(this.out, 134695760L);
      this.ZNn.setCrc(this.crc.getValue());
      e(this.out, this.ZNn.getCrc());
      this.ZNn.setCompressedSize(this.def.getTotalOut());
      e(this.out, this.ZNn.getCompressedSize());
      this.ZNn.setSize(this.def.getTotalIn());
      e(this.out, this.ZNn.getSize());
    }
    int j;
    if (this.ZNn.getMethod() == 0)
    {
      j = 0;
      e(this.ZNm, 33639248L);
      d(this.ZNm, 20);
      d(this.ZNm, 20);
      d(this.ZNm, j | 0x800);
      d(this.ZNm, this.ZNn.getMethod());
      d(this.ZNm, 0);
      d(this.ZNm, 33);
      e(this.ZNm, this.crc.getValue());
      if (this.ZNn.getMethod() != 8) {
        break label589;
      }
      i = (int)(i + e(this.ZNm, this.def.getTotalOut()));
      e(this.ZNm, this.def.getTotalIn());
      label362:
      i += d(this.ZNm, this.ZNp);
      if (this.ZNn.getExtra() == null) {
        break label620;
      }
      i += d(this.ZNm, this.ZNn.getExtra().length);
    }
    for (;;)
    {
      String str = this.ZNn.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      d(this.ZNm, arrayOfByte.length);
      d(this.ZNm, 0);
      d(this.ZNm, 0);
      e(this.ZNm, 0L);
      e(this.ZNm, this.offset);
      this.ZNm.write(this.ZNq);
      this.ZNq = null;
      if (this.ZNn.getExtra() != null) {
        this.ZNm.write(this.ZNn.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.ZNm.write(arrayOfByte);
      }
      this.ZNn = null;
      this.crc.reset();
      this.ZNo = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label589:
      i = (int)(i + e(this.ZNm, this.ZNo));
      e(this.ZNm, this.ZNo);
      break label362;
      label620:
      d(this.ZNm, 0);
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = ZNi;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.ZNn == null) {
      throw new ZipException("No active entry");
    }
    if (this.ZNn.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.ZNo += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */