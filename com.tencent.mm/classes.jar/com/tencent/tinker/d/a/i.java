package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class i
  extends FilterOutputStream
{
  public static final byte[] ahSG = new byte[0];
  private static final byte[] ahSH = { -1, -1, -1, -1 };
  private final boolean ahSI = false;
  private g ahSJ;
  private byte[] ahSK;
  private boolean ahSL;
  public byte[] ahSl = ahSG;
  private final HashSet<String> ahSm = new HashSet();
  private int ahSn = 8;
  private ByteArrayOutputStream ahSo = new ByteArrayOutputStream();
  private byte[] ahSs;
  private long offset = 0L;
  
  public i(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private i(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
  }
  
  public static void L(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 65535) {
      throw new IllegalArgumentException(paramString + " too long in UTF-8:" + paramArrayOfByte.length + " bytes");
    }
  }
  
  private static long g(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private static int h(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private void kcj()
  {
    if (this.ahSo == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.ahSJ != null) {
      kci();
    }
    int i = paramg.ahSx;
    if (i == -1) {
      i = this.ahSn;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.ahSw == -1L) {
          paramg.ahSw = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.ahSw);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.ahSw) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      kcj();
      paramg.comment = null;
      paramg.egP = null;
      paramg.time = 40691;
      paramg.ahSy = 18698;
      this.ahSs = paramg.name.getBytes(e.UTF_8);
      L("Name", this.ahSs);
      this.ahSK = ahSG;
      if (paramg.comment != null)
      {
        this.ahSK = paramg.comment.getBytes(e.UTF_8);
        L("Comment", this.ahSK);
      }
      paramg.aIX(i);
      this.ahSJ = paramg;
      this.ahSJ.ahSz = this.offset;
      this.ahSm.add(this.ahSJ.name);
      int j;
      if (i == 0)
      {
        j = 0;
        g(this.out, 67324752L);
        h(this.out, 20);
        h(this.out, j | 0x800);
        h(this.out, i);
        h(this.out, this.ahSJ.time);
        h(this.out, this.ahSJ.ahSy);
        if (i != 0) {
          break label467;
        }
        g(this.out, this.ahSJ.crc);
        g(this.out, this.ahSJ.size);
        g(this.out, this.ahSJ.size);
        label386:
        h(this.out, this.ahSs.length);
        if (this.ahSJ.egP == null) {
          break label497;
        }
        h(this.out, this.ahSJ.egP.length);
      }
      for (;;)
      {
        this.out.write(this.ahSs);
        if (this.ahSJ.egP != null) {
          this.out.write(this.ahSJ.egP);
        }
        return;
        j = 8;
        break;
        label467:
        g(this.out, 0L);
        g(this.out, 0L);
        g(this.out, 0L);
        break label386;
        label497:
        h(this.out, 0);
      }
    }
  }
  
  public final void close()
  {
    int i;
    if (this.out != null)
    {
      if (this.out == null) {
        throw new IOException("Stream is closed");
      }
      if (this.ahSo != null)
      {
        if (this.ahSm.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.ahSJ != null) {
          kci();
        }
        i = this.ahSo.size();
        g(this.ahSo, 101010256L);
        h(this.ahSo, 0);
        h(this.ahSo, 0);
        if (!this.ahSL) {
          break label209;
        }
        h(this.ahSo, 65535);
        h(this.ahSo, 65535);
        g(this.ahSo, -1L);
        g(this.ahSo, -1L);
      }
    }
    for (;;)
    {
      h(this.ahSo, this.ahSl.length);
      if (this.ahSl.length > 0) {
        this.ahSo.write(this.ahSl);
      }
      this.ahSo.writeTo(this.out);
      this.ahSo = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      h(this.ahSo, this.ahSm.size());
      h(this.ahSo, this.ahSm.size());
      g(this.ahSo, i);
      g(this.ahSo, this.offset);
    }
  }
  
  public final void kci()
  {
    kcj();
    if (this.ahSJ == null) {
      return;
    }
    long l = 30L;
    if (this.ahSJ.ahSx != 0)
    {
      l = 46L;
      g(this.out, 134695760L);
      g(this.out, this.ahSJ.crc);
      g(this.out, this.ahSJ.ahSw);
      g(this.out, this.ahSJ.size);
    }
    int i;
    if (this.ahSJ.ahSx == 0)
    {
      i = 0;
      g(this.ahSo, 33639248L);
      h(this.ahSo, 20);
      h(this.ahSo, 20);
      h(this.ahSo, i | 0x800);
      h(this.ahSo, this.ahSJ.ahSx);
      h(this.ahSo, this.ahSJ.time);
      h(this.ahSo, this.ahSJ.ahSy);
      g(this.ahSo, this.ahSJ.crc);
      if (this.ahSJ.ahSx != 8) {
        break label442;
      }
      l += this.ahSJ.ahSw;
      label224:
      g(this.ahSo, this.ahSJ.ahSw);
      g(this.ahSo, this.ahSJ.size);
      l += h(this.ahSo, this.ahSs.length);
      if (this.ahSJ.egP == null) {
        break label455;
      }
      l += h(this.ahSo, this.ahSJ.egP.length);
    }
    for (;;)
    {
      h(this.ahSo, this.ahSK.length);
      h(this.ahSo, 0);
      h(this.ahSo, 0);
      g(this.ahSo, 0L);
      g(this.ahSo, this.ahSJ.ahSz);
      this.ahSo.write(this.ahSs);
      this.ahSs = null;
      if (this.ahSJ.egP != null) {
        this.ahSo.write(this.ahSJ.egP);
      }
      this.offset = (l + this.offset);
      if (this.ahSK.length > 0)
      {
        this.ahSo.write(this.ahSK);
        this.ahSK = ahSG;
      }
      this.ahSJ = null;
      return;
      i = 8;
      break;
      label442:
      l += this.ahSJ.size;
      break label224;
      label455:
      h(this.ahSo, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.ahSJ == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */