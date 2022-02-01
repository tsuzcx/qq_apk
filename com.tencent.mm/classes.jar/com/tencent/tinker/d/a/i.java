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
  public static final byte[] KrY = new byte[0];
  private static final byte[] KrZ = { -1, -1, -1, -1 };
  public byte[] KrC = KrY;
  private final HashSet<String> KrD = new HashSet();
  private int KrE = 8;
  private ByteArrayOutputStream KrF = new ByteArrayOutputStream();
  private byte[] KrJ;
  private final boolean Ksa = false;
  private g Ksb;
  private byte[] Ksc;
  private boolean Ksd;
  private long offset = 0L;
  
  public i(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private i(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
  }
  
  public static void C(String paramString, byte[] paramArrayOfByte)
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
  
  private void fHm()
  {
    if (this.KrF == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.Ksb != null) {
      closeEntry();
    }
    int i = paramg.KrO;
    if (i == -1) {
      i = this.KrE;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.KrN == -1L) {
          paramg.KrN = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.KrN);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.KrN) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      fHm();
      paramg.DSo = null;
      paramg.KrQ = null;
      paramg.gIh = 40691;
      paramg.KrP = 18698;
      this.KrJ = paramg.name.getBytes(e.UTF_8);
      C("Name", this.KrJ);
      this.Ksc = KrY;
      if (paramg.DSo != null)
      {
        this.Ksc = paramg.DSo.getBytes(e.UTF_8);
        C("Comment", this.Ksc);
      }
      paramg.setMethod(i);
      this.Ksb = paramg;
      this.Ksb.KrR = this.offset;
      this.KrD.add(this.Ksb.name);
      int j;
      if (i == 0)
      {
        j = 0;
        d(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.Ksb.gIh);
        e(this.out, this.Ksb.KrP);
        if (i != 0) {
          break label467;
        }
        d(this.out, this.Ksb.crc);
        d(this.out, this.Ksb.size);
        d(this.out, this.Ksb.size);
        label386:
        e(this.out, this.KrJ.length);
        if (this.Ksb.KrQ == null) {
          break label497;
        }
        e(this.out, this.Ksb.KrQ.length);
      }
      for (;;)
      {
        this.out.write(this.KrJ);
        if (this.Ksb.KrQ != null) {
          this.out.write(this.Ksb.KrQ);
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
      if (this.KrF != null)
      {
        if (this.KrD.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.Ksb != null) {
          closeEntry();
        }
        i = this.KrF.size();
        d(this.KrF, 101010256L);
        e(this.KrF, 0);
        e(this.KrF, 0);
        if (!this.Ksd) {
          break label209;
        }
        e(this.KrF, 65535);
        e(this.KrF, 65535);
        d(this.KrF, -1L);
        d(this.KrF, -1L);
      }
    }
    for (;;)
    {
      e(this.KrF, this.KrC.length);
      if (this.KrC.length > 0) {
        this.KrF.write(this.KrC);
      }
      this.KrF.writeTo(this.out);
      this.KrF = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.KrF, this.KrD.size());
      e(this.KrF, this.KrD.size());
      d(this.KrF, i);
      d(this.KrF, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    fHm();
    if (this.Ksb == null) {
      return;
    }
    long l = 30L;
    if (this.Ksb.KrO != 0)
    {
      l = 46L;
      d(this.out, 134695760L);
      d(this.out, this.Ksb.crc);
      d(this.out, this.Ksb.KrN);
      d(this.out, this.Ksb.size);
    }
    int i;
    if (this.Ksb.KrO == 0)
    {
      i = 0;
      d(this.KrF, 33639248L);
      e(this.KrF, 20);
      e(this.KrF, 20);
      e(this.KrF, i | 0x800);
      e(this.KrF, this.Ksb.KrO);
      e(this.KrF, this.Ksb.gIh);
      e(this.KrF, this.Ksb.KrP);
      d(this.KrF, this.Ksb.crc);
      if (this.Ksb.KrO != 8) {
        break label442;
      }
      l += this.Ksb.KrN;
      label224:
      d(this.KrF, this.Ksb.KrN);
      d(this.KrF, this.Ksb.size);
      l += e(this.KrF, this.KrJ.length);
      if (this.Ksb.KrQ == null) {
        break label455;
      }
      l += e(this.KrF, this.Ksb.KrQ.length);
    }
    for (;;)
    {
      e(this.KrF, this.Ksc.length);
      e(this.KrF, 0);
      e(this.KrF, 0);
      d(this.KrF, 0L);
      d(this.KrF, this.Ksb.KrR);
      this.KrF.write(this.KrJ);
      this.KrJ = null;
      if (this.Ksb.KrQ != null) {
        this.KrF.write(this.Ksb.KrQ);
      }
      this.offset = (l + this.offset);
      if (this.Ksc.length > 0)
      {
        this.KrF.write(this.Ksc);
        this.Ksc = KrY;
      }
      this.Ksb = null;
      return;
      i = 8;
      break;
      label442:
      l += this.Ksb.size;
      break label224;
      label455:
      e(this.KrF, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.aU(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.Ksb == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */