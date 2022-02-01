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
  public static final byte[] SkU = new byte[0];
  private static final byte[] SkV = { -1, -1, -1, -1 };
  private int SkA = 8;
  private ByteArrayOutputStream SkB = new ByteArrayOutputStream();
  private byte[] SkF;
  private final boolean SkW = false;
  private g SkX;
  private byte[] SkY;
  private boolean SkZ;
  public byte[] Sky = SkU;
  private final HashSet<String> Skz = new HashSet();
  private long offset = 0L;
  
  public i(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private i(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
  }
  
  public static void D(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 65535) {
      throw new IllegalArgumentException(paramString + " too long in UTF-8:" + paramArrayOfByte.length + " bytes");
    }
  }
  
  private static long d(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private static int e(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private void hpk()
  {
    if (this.SkB == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.SkX != null) {
      closeEntry();
    }
    int i = paramg.SkK;
    if (i == -1) {
      i = this.SkA;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.SkJ == -1L) {
          paramg.SkJ = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.SkJ);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.SkJ) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      hpk();
      paramg.KJM = null;
      paramg.SkM = null;
      paramg.hXs = 40691;
      paramg.SkL = 18698;
      this.SkF = paramg.name.getBytes(e.UTF_8);
      D("Name", this.SkF);
      this.SkY = SkU;
      if (paramg.KJM != null)
      {
        this.SkY = paramg.KJM.getBytes(e.UTF_8);
        D("Comment", this.SkY);
      }
      paramg.setMethod(i);
      this.SkX = paramg;
      this.SkX.SkN = this.offset;
      this.Skz.add(this.SkX.name);
      int j;
      if (i == 0)
      {
        j = 0;
        d(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.SkX.hXs);
        e(this.out, this.SkX.SkL);
        if (i != 0) {
          break label467;
        }
        d(this.out, this.SkX.crc);
        d(this.out, this.SkX.size);
        d(this.out, this.SkX.size);
        label386:
        e(this.out, this.SkF.length);
        if (this.SkX.SkM == null) {
          break label497;
        }
        e(this.out, this.SkX.SkM.length);
      }
      for (;;)
      {
        this.out.write(this.SkF);
        if (this.SkX.SkM != null) {
          this.out.write(this.SkX.SkM);
        }
        return;
        j = 8;
        break;
        label467:
        d(this.out, 0L);
        d(this.out, 0L);
        d(this.out, 0L);
        break label386;
        label497:
        e(this.out, 0);
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
      if (this.SkB != null)
      {
        if (this.Skz.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.SkX != null) {
          closeEntry();
        }
        i = this.SkB.size();
        d(this.SkB, 101010256L);
        e(this.SkB, 0);
        e(this.SkB, 0);
        if (!this.SkZ) {
          break label209;
        }
        e(this.SkB, 65535);
        e(this.SkB, 65535);
        d(this.SkB, -1L);
        d(this.SkB, -1L);
      }
    }
    for (;;)
    {
      e(this.SkB, this.Sky.length);
      if (this.Sky.length > 0) {
        this.SkB.write(this.Sky);
      }
      this.SkB.writeTo(this.out);
      this.SkB = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.SkB, this.Skz.size());
      e(this.SkB, this.Skz.size());
      d(this.SkB, i);
      d(this.SkB, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    hpk();
    if (this.SkX == null) {
      return;
    }
    long l = 30L;
    if (this.SkX.SkK != 0)
    {
      l = 46L;
      d(this.out, 134695760L);
      d(this.out, this.SkX.crc);
      d(this.out, this.SkX.SkJ);
      d(this.out, this.SkX.size);
    }
    int i;
    if (this.SkX.SkK == 0)
    {
      i = 0;
      d(this.SkB, 33639248L);
      e(this.SkB, 20);
      e(this.SkB, 20);
      e(this.SkB, i | 0x800);
      e(this.SkB, this.SkX.SkK);
      e(this.SkB, this.SkX.hXs);
      e(this.SkB, this.SkX.SkL);
      d(this.SkB, this.SkX.crc);
      if (this.SkX.SkK != 8) {
        break label442;
      }
      l += this.SkX.SkJ;
      label224:
      d(this.SkB, this.SkX.SkJ);
      d(this.SkB, this.SkX.size);
      l += e(this.SkB, this.SkF.length);
      if (this.SkX.SkM == null) {
        break label455;
      }
      l += e(this.SkB, this.SkX.SkM.length);
    }
    for (;;)
    {
      e(this.SkB, this.SkY.length);
      e(this.SkB, 0);
      e(this.SkB, 0);
      d(this.SkB, 0L);
      d(this.SkB, this.SkX.SkN);
      this.SkB.write(this.SkF);
      this.SkF = null;
      if (this.SkX.SkM != null) {
        this.SkB.write(this.SkX.SkM);
      }
      this.offset = (l + this.offset);
      if (this.SkY.length > 0)
      {
        this.SkB.write(this.SkY);
        this.SkY = SkU;
      }
      this.SkX = null;
      return;
      i = 8;
      break;
      label442:
      l += this.SkX.size;
      break label224;
      label455:
      e(this.SkB, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.SkX == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */