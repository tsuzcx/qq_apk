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
  public static final byte[] ZNF = new byte[0];
  private static final byte[] ZNG = { -1, -1, -1, -1 };
  private final boolean ZNH = false;
  private g ZNI;
  private byte[] ZNJ;
  private boolean ZNK;
  private byte[] ZNj = ZNF;
  private final HashSet<String> ZNk = new HashSet();
  private int ZNl = 8;
  private ByteArrayOutputStream ZNm = new ByteArrayOutputStream();
  private byte[] ZNq;
  private long offset = 0L;
  
  public i(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private i(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
  }
  
  private static void I(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 65535) {
      throw new IllegalArgumentException(paramString + " too long in UTF-8:" + paramArrayOfByte.length + " bytes");
    }
  }
  
  private static int e(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private static long f(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private void isM()
  {
    if (this.ZNm == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.ZNI != null) {
      isL();
    }
    int i = paramg.ZNv;
    if (i == -1) {
      i = this.ZNl;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.ZNu == -1L) {
          paramg.ZNu = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.ZNu);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.ZNu) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      isM();
      paramg.comment = null;
      paramg.ZNx = null;
      paramg.time = 40691;
      paramg.ZNw = 18698;
      this.ZNq = paramg.name.getBytes(e.UTF_8);
      I("Name", this.ZNq);
      this.ZNJ = ZNF;
      if (paramg.comment != null)
      {
        this.ZNJ = paramg.comment.getBytes(e.UTF_8);
        I("Comment", this.ZNJ);
      }
      paramg.aCi(i);
      this.ZNI = paramg;
      this.ZNI.ZNy = this.offset;
      this.ZNk.add(this.ZNI.name);
      int j;
      if (i == 0)
      {
        j = 0;
        f(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.ZNI.time);
        e(this.out, this.ZNI.ZNw);
        if (i != 0) {
          break label467;
        }
        f(this.out, this.ZNI.crc);
        f(this.out, this.ZNI.size);
        f(this.out, this.ZNI.size);
        label386:
        e(this.out, this.ZNq.length);
        if (this.ZNI.ZNx == null) {
          break label497;
        }
        e(this.out, this.ZNI.ZNx.length);
      }
      for (;;)
      {
        this.out.write(this.ZNq);
        if (this.ZNI.ZNx != null) {
          this.out.write(this.ZNI.ZNx);
        }
        return;
        j = 8;
        break;
        label467:
        f(this.out, 0L);
        f(this.out, 0L);
        f(this.out, 0L);
        break label386;
        label497:
        e(this.out, 0);
      }
    }
  }
  
  public final void bDK(String paramString)
  {
    if (paramString == null)
    {
      this.ZNj = ZNF;
      return;
    }
    paramString = paramString.getBytes(e.UTF_8);
    I("Comment", paramString);
    this.ZNj = paramString;
  }
  
  public final void close()
  {
    int i;
    if (this.out != null)
    {
      if (this.out == null) {
        throw new IOException("Stream is closed");
      }
      if (this.ZNm != null)
      {
        if (this.ZNk.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.ZNI != null) {
          isL();
        }
        i = this.ZNm.size();
        f(this.ZNm, 101010256L);
        e(this.ZNm, 0);
        e(this.ZNm, 0);
        if (!this.ZNK) {
          break label209;
        }
        e(this.ZNm, 65535);
        e(this.ZNm, 65535);
        f(this.ZNm, -1L);
        f(this.ZNm, -1L);
      }
    }
    for (;;)
    {
      e(this.ZNm, this.ZNj.length);
      if (this.ZNj.length > 0) {
        this.ZNm.write(this.ZNj);
      }
      this.ZNm.writeTo(this.out);
      this.ZNm = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.ZNm, this.ZNk.size());
      e(this.ZNm, this.ZNk.size());
      f(this.ZNm, i);
      f(this.ZNm, this.offset);
    }
  }
  
  public final void isL()
  {
    isM();
    if (this.ZNI == null) {
      return;
    }
    long l = 30L;
    if (this.ZNI.ZNv != 0)
    {
      l = 46L;
      f(this.out, 134695760L);
      f(this.out, this.ZNI.crc);
      f(this.out, this.ZNI.ZNu);
      f(this.out, this.ZNI.size);
    }
    int i;
    if (this.ZNI.ZNv == 0)
    {
      i = 0;
      f(this.ZNm, 33639248L);
      e(this.ZNm, 20);
      e(this.ZNm, 20);
      e(this.ZNm, i | 0x800);
      e(this.ZNm, this.ZNI.ZNv);
      e(this.ZNm, this.ZNI.time);
      e(this.ZNm, this.ZNI.ZNw);
      f(this.ZNm, this.ZNI.crc);
      if (this.ZNI.ZNv != 8) {
        break label442;
      }
      l += this.ZNI.ZNu;
      label224:
      f(this.ZNm, this.ZNI.ZNu);
      f(this.ZNm, this.ZNI.size);
      l += e(this.ZNm, this.ZNq.length);
      if (this.ZNI.ZNx == null) {
        break label455;
      }
      l += e(this.ZNm, this.ZNI.ZNx.length);
    }
    for (;;)
    {
      e(this.ZNm, this.ZNJ.length);
      e(this.ZNm, 0);
      e(this.ZNm, 0);
      f(this.ZNm, 0L);
      f(this.ZNm, this.ZNI.ZNy);
      this.ZNm.write(this.ZNq);
      this.ZNq = null;
      if (this.ZNI.ZNx != null) {
        this.ZNm.write(this.ZNI.ZNx);
      }
      this.offset = (l + this.offset);
      if (this.ZNJ.length > 0)
      {
        this.ZNm.write(this.ZNJ);
        this.ZNJ = ZNF;
      }
      this.ZNI = null;
      return;
      i = 8;
      break;
      label442:
      l += this.ZNI.size;
      break label224;
      label455:
      e(this.ZNm, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.ZNI == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */