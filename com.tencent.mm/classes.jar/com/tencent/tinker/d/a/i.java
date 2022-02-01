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
  public static final byte[] MhZ = new byte[0];
  private static final byte[] Mia = { -1, -1, -1, -1 };
  public byte[] MhD = MhZ;
  private final HashSet<String> MhE = new HashSet();
  private int MhF = 8;
  private ByteArrayOutputStream MhG = new ByteArrayOutputStream();
  private byte[] MhK;
  private final boolean Mib = false;
  private g Mic;
  private byte[] Mid;
  private boolean Mie;
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
  
  private void fYD()
  {
    if (this.MhG == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.Mic != null) {
      closeEntry();
    }
    int i = paramg.MhP;
    if (i == -1) {
      i = this.MhF;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.MhO == -1L) {
          paramg.MhO = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.MhO);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.MhO) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      fYD();
      paramg.FxH = null;
      paramg.MhR = null;
      paramg.hbR = 40691;
      paramg.MhQ = 18698;
      this.MhK = paramg.name.getBytes(e.UTF_8);
      D("Name", this.MhK);
      this.Mid = MhZ;
      if (paramg.FxH != null)
      {
        this.Mid = paramg.FxH.getBytes(e.UTF_8);
        D("Comment", this.Mid);
      }
      paramg.setMethod(i);
      this.Mic = paramg;
      this.Mic.MhS = this.offset;
      this.MhE.add(this.Mic.name);
      int j;
      if (i == 0)
      {
        j = 0;
        d(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.Mic.hbR);
        e(this.out, this.Mic.MhQ);
        if (i != 0) {
          break label467;
        }
        d(this.out, this.Mic.crc);
        d(this.out, this.Mic.size);
        d(this.out, this.Mic.size);
        label386:
        e(this.out, this.MhK.length);
        if (this.Mic.MhR == null) {
          break label497;
        }
        e(this.out, this.Mic.MhR.length);
      }
      for (;;)
      {
        this.out.write(this.MhK);
        if (this.Mic.MhR != null) {
          this.out.write(this.Mic.MhR);
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
      if (this.MhG != null)
      {
        if (this.MhE.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.Mic != null) {
          closeEntry();
        }
        i = this.MhG.size();
        d(this.MhG, 101010256L);
        e(this.MhG, 0);
        e(this.MhG, 0);
        if (!this.Mie) {
          break label209;
        }
        e(this.MhG, 65535);
        e(this.MhG, 65535);
        d(this.MhG, -1L);
        d(this.MhG, -1L);
      }
    }
    for (;;)
    {
      e(this.MhG, this.MhD.length);
      if (this.MhD.length > 0) {
        this.MhG.write(this.MhD);
      }
      this.MhG.writeTo(this.out);
      this.MhG = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.MhG, this.MhE.size());
      e(this.MhG, this.MhE.size());
      d(this.MhG, i);
      d(this.MhG, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    fYD();
    if (this.Mic == null) {
      return;
    }
    long l = 30L;
    if (this.Mic.MhP != 0)
    {
      l = 46L;
      d(this.out, 134695760L);
      d(this.out, this.Mic.crc);
      d(this.out, this.Mic.MhO);
      d(this.out, this.Mic.size);
    }
    int i;
    if (this.Mic.MhP == 0)
    {
      i = 0;
      d(this.MhG, 33639248L);
      e(this.MhG, 20);
      e(this.MhG, 20);
      e(this.MhG, i | 0x800);
      e(this.MhG, this.Mic.MhP);
      e(this.MhG, this.Mic.hbR);
      e(this.MhG, this.Mic.MhQ);
      d(this.MhG, this.Mic.crc);
      if (this.Mic.MhP != 8) {
        break label442;
      }
      l += this.Mic.MhO;
      label224:
      d(this.MhG, this.Mic.MhO);
      d(this.MhG, this.Mic.size);
      l += e(this.MhG, this.MhK.length);
      if (this.Mic.MhR == null) {
        break label455;
      }
      l += e(this.MhG, this.Mic.MhR.length);
    }
    for (;;)
    {
      e(this.MhG, this.Mid.length);
      e(this.MhG, 0);
      e(this.MhG, 0);
      d(this.MhG, 0L);
      d(this.MhG, this.Mic.MhS);
      this.MhG.write(this.MhK);
      this.MhK = null;
      if (this.Mic.MhR != null) {
        this.MhG.write(this.Mic.MhR);
      }
      this.offset = (l + this.offset);
      if (this.Mid.length > 0)
      {
        this.MhG.write(this.Mid);
        this.Mid = MhZ;
      }
      this.Mic = null;
      return;
      i = 8;
      break;
      label442:
      l += this.Mic.size;
      break label224;
      label455:
      e(this.MhG, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.aV(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.Mic == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */