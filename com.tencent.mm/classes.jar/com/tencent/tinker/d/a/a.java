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
  private static final byte[] ahSk = { 0 };
  private byte[] ahSl = EMPTY_BYTE_ARRAY;
  private final HashSet<String> ahSm = new HashSet();
  private int ahSn = 8;
  private ByteArrayOutputStream ahSo = new ByteArrayOutputStream();
  private ZipEntry ahSp;
  private long ahSq = 0L;
  private int ahSr;
  private byte[] ahSs;
  private final int ahSt = 4;
  private boolean closed = false;
  private int compressionLevel = -1;
  private final CRC32 crc = new CRC32();
  private boolean mhq = false;
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
  
  private static long f(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private static void f(OutputStream paramOutputStream, int paramInt)
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
  
  private static int g(OutputStream paramOutputStream, int paramInt)
  {
    if (paramInt > 65535) {
      throw new IllegalArgumentException("value " + paramInt + " is too large for type 'short'.");
    }
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private void kcj()
  {
    if (this.closed) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void a(ZipEntry paramZipEntry)
  {
    int k = 0;
    if (this.ahSp != null) {
      kci();
    }
    int i = paramZipEntry.getMethod();
    if (i == -1) {
      i = this.ahSn;
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
      kcj();
      if (this.ahSm.contains(paramZipEntry.getName())) {
        throw new ZipException("Entry already exists: " + paramZipEntry.getName());
      }
      if (this.ahSm.size() == 65535) {
        throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
      }
      this.ahSs = paramZipEntry.getName().getBytes(Charset.forName("UTF-8"));
      this.ahSr = this.ahSs.length;
      if (this.ahSr > 65535) {
        throw new IllegalArgumentException("Name too long: " + this.ahSr + " UTF-8 bytes");
      }
      this.def.setLevel(this.compressionLevel);
      paramZipEntry.setMethod(i);
      this.ahSp = paramZipEntry;
      this.ahSm.add(this.ahSp.getName());
      int j;
      label448:
      int m;
      int n;
      if (i == 0)
      {
        j = 0;
        f(this.out, 67324752L);
        g(this.out, 20);
        g(this.out, j | 0x800);
        g(this.out, i);
        if (this.ahSp.getTime() == -1L) {
          this.ahSp.setTime(System.currentTimeMillis());
        }
        g(this.out, 0);
        g(this.out, 33);
        if (i != 0) {
          break label603;
        }
        f(this.out, this.ahSp.getCrc());
        f(this.out, this.ahSp.getSize());
        f(this.out, this.ahSp.getSize());
        g(this.out, this.ahSr);
        m = this.offset;
        n = this.ahSr;
        if (this.ahSp.getExtra() == null) {
          break label633;
        }
        i = this.ahSp.getExtra().length;
        label491:
        j = k;
        if (this.ahSp.getMethod() == 0)
        {
          if (this.ahSt != 0) {
            break label638;
          }
          j = k;
        }
        label514:
        this.padding = j;
        if (this.ahSp.getExtra() == null) {
          break label666;
        }
        g(this.out, this.ahSp.getExtra().length + this.padding);
      }
      for (;;)
      {
        this.out.write(this.ahSs);
        if (this.ahSp.getExtra() != null) {
          this.out.write(this.ahSp.getExtra());
        }
        f(this.out, this.padding);
        return;
        j = 8;
        break;
        label603:
        f(this.out, 0L);
        f(this.out, 0L);
        f(this.out, 0L);
        break label448;
        label633:
        i = 0;
        break label491;
        label638:
        j = this.ahSt;
        j = (j - (i + (n + (m + 30))) % j) % this.ahSt;
        break label514;
        label666:
        g(this.out, this.padding);
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
    kcj();
    if (this.mhq) {
      return;
    }
    if (this.ahSm.isEmpty()) {
      throw new ZipException("No entries");
    }
    if (this.ahSp != null) {
      kci();
    }
    int i = this.ahSo.size();
    f(this.ahSo, 101010256L);
    g(this.ahSo, 0);
    g(this.ahSo, 0);
    g(this.ahSo, this.ahSm.size());
    g(this.ahSo, this.ahSm.size());
    f(this.ahSo, i);
    f(this.ahSo, this.offset + this.padding);
    g(this.ahSo, this.ahSl.length);
    if (this.ahSl.length > 0) {
      this.ahSo.write(this.ahSl);
    }
    this.ahSo.writeTo(this.out);
    this.ahSo = null;
    this.mhq = true;
  }
  
  public final void kci()
  {
    kcj();
    if (this.ahSp == null) {
      return;
    }
    if (this.ahSp.getMethod() == 8) {
      super.finish();
    }
    if (this.ahSp.getMethod() == 0)
    {
      if (this.crc.getValue() != this.ahSp.getCrc()) {
        throw new ZipException("CRC mismatch");
      }
      if (this.ahSp.getSize() != this.ahSq) {
        throw new ZipException("Size mismatch");
      }
    }
    int i = 30;
    if (this.ahSp.getMethod() != 0)
    {
      i = 46;
      f(this.out, 134695760L);
      this.ahSp.setCrc(this.crc.getValue());
      f(this.out, this.ahSp.getCrc());
      this.ahSp.setCompressedSize(this.def.getTotalOut());
      f(this.out, this.ahSp.getCompressedSize());
      this.ahSp.setSize(this.def.getTotalIn());
      f(this.out, this.ahSp.getSize());
    }
    int j;
    if (this.ahSp.getMethod() == 0)
    {
      j = 0;
      f(this.ahSo, 33639248L);
      g(this.ahSo, 20);
      g(this.ahSo, 20);
      g(this.ahSo, j | 0x800);
      g(this.ahSo, this.ahSp.getMethod());
      g(this.ahSo, 0);
      g(this.ahSo, 33);
      f(this.ahSo, this.crc.getValue());
      if (this.ahSp.getMethod() != 8) {
        break label589;
      }
      i = (int)(i + f(this.ahSo, this.def.getTotalOut()));
      f(this.ahSo, this.def.getTotalIn());
      label362:
      i += g(this.ahSo, this.ahSr);
      if (this.ahSp.getExtra() == null) {
        break label620;
      }
      i += g(this.ahSo, this.ahSp.getExtra().length);
    }
    for (;;)
    {
      String str = this.ahSp.getComment();
      byte[] arrayOfByte = EMPTY_BYTE_ARRAY;
      if (str != null) {
        arrayOfByte = str.getBytes(Charset.forName("UTF-8"));
      }
      g(this.ahSo, arrayOfByte.length);
      g(this.ahSo, 0);
      g(this.ahSo, 0);
      f(this.ahSo, 0L);
      f(this.ahSo, this.offset);
      this.ahSo.write(this.ahSs);
      this.ahSs = null;
      if (this.ahSp.getExtra() != null) {
        this.ahSo.write(this.ahSp.getExtra());
      }
      j = this.offset;
      this.offset = (i + this.padding + j);
      this.padding = 0;
      if (arrayOfByte.length > 0) {
        this.ahSo.write(arrayOfByte);
      }
      this.ahSp = null;
      this.crc.reset();
      this.ahSq = 0L;
      this.def.reset();
      return;
      j = 8;
      break;
      label589:
      i = (int)(i + f(this.ahSo, this.ahSq));
      f(this.ahSo, this.ahSq);
      break label362;
      label620:
      g(this.ahSo, 0);
    }
  }
  
  public final void write(int paramInt)
  {
    byte[] arrayOfByte = ahSk;
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    write(arrayOfByte, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2)) {
      throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    if (this.ahSp == null) {
      throw new ZipException("No active entry");
    }
    if (this.ahSp.getMethod() == 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
      this.ahSq += paramInt2;
      return;
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.d.a.a
 * JD-Core Version:    0.7.0.1
 */