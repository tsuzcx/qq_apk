package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h
  extends FilterOutputStream
{
  public static final byte[] BwE = new byte[0];
  private static final byte[] BwF = { -1, -1, -1, -1 };
  private final HashSet<String> BwG = new HashSet();
  private final boolean BwH = false;
  public byte[] BwI = BwE;
  private int BwJ = 8;
  private ByteArrayOutputStream BwK = new ByteArrayOutputStream();
  private f BwL;
  private byte[] BwM;
  private byte[] BwN;
  private boolean BwO;
  private long offset = 0L;
  
  public h(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private h(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
  }
  
  public static void G(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 65535) {
      throw new IllegalArgumentException(paramString + " too long in UTF-8:" + paramArrayOfByte.length + " bytes");
    }
  }
  
  private static int c(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private static long c(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private void dWM()
  {
    if (this.BwK == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(f paramf)
  {
    if (this.BwL != null) {
      closeEntry();
    }
    int i = paramf.Bwu;
    if (i == -1) {
      i = this.BwJ;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramf.Bwt == -1L) {
          paramf.Bwt = paramf.size;
        }
        while (paramf.Bwi == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramf.size == -1L) {
            paramf.setSize(paramf.Bwt);
          }
        }
        if (paramf.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramf.size != paramf.Bwt) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      dWM();
      paramf.wqH = null;
      paramf.Bww = null;
      paramf.oLs = 40691;
      paramf.Bwv = 18698;
      this.BwM = paramf.name.getBytes(d.UTF_8);
      G("Name", this.BwM);
      this.BwN = BwE;
      if (paramf.wqH != null)
      {
        this.BwN = paramf.wqH.getBytes(d.UTF_8);
        G("Comment", this.BwN);
      }
      paramf.setMethod(i);
      this.BwL = paramf;
      this.BwL.Bwx = this.offset;
      this.BwG.add(this.BwL.name);
      int j;
      if (i == 0)
      {
        j = 0;
        c(this.out, 67324752L);
        c(this.out, 20);
        c(this.out, j | 0x800);
        c(this.out, i);
        c(this.out, this.BwL.oLs);
        c(this.out, this.BwL.Bwv);
        if (i != 0) {
          break label467;
        }
        c(this.out, this.BwL.Bwi);
        c(this.out, this.BwL.size);
        c(this.out, this.BwL.size);
        label386:
        c(this.out, this.BwM.length);
        if (this.BwL.Bww == null) {
          break label497;
        }
        c(this.out, this.BwL.Bww.length);
      }
      for (;;)
      {
        this.out.write(this.BwM);
        if (this.BwL.Bww != null) {
          this.out.write(this.BwL.Bww);
        }
        return;
        j = 8;
        break;
        label467:
        c(this.out, 0L);
        c(this.out, 0L);
        c(this.out, 0L);
        break label386;
        label497:
        c(this.out, 0);
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
      if (this.BwK != null)
      {
        if (this.BwG.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.BwL != null) {
          closeEntry();
        }
        i = this.BwK.size();
        c(this.BwK, 101010256L);
        c(this.BwK, 0);
        c(this.BwK, 0);
        if (!this.BwO) {
          break label209;
        }
        c(this.BwK, 65535);
        c(this.BwK, 65535);
        c(this.BwK, -1L);
        c(this.BwK, -1L);
      }
    }
    for (;;)
    {
      c(this.BwK, this.BwI.length);
      if (this.BwI.length > 0) {
        this.BwK.write(this.BwI);
      }
      this.BwK.writeTo(this.out);
      this.BwK = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      c(this.BwK, this.BwG.size());
      c(this.BwK, this.BwG.size());
      c(this.BwK, i);
      c(this.BwK, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    dWM();
    if (this.BwL == null) {
      return;
    }
    long l = 30L;
    if (this.BwL.Bwu != 0)
    {
      l = 46L;
      c(this.out, 134695760L);
      c(this.out, this.BwL.Bwi);
      c(this.out, this.BwL.Bwt);
      c(this.out, this.BwL.size);
    }
    int i;
    if (this.BwL.Bwu == 0)
    {
      i = 0;
      c(this.BwK, 33639248L);
      c(this.BwK, 20);
      c(this.BwK, 20);
      c(this.BwK, i | 0x800);
      c(this.BwK, this.BwL.Bwu);
      c(this.BwK, this.BwL.oLs);
      c(this.BwK, this.BwL.Bwv);
      c(this.BwK, this.BwL.Bwi);
      if (this.BwL.Bwu != 8) {
        break label442;
      }
      l += this.BwL.Bwt;
      label224:
      c(this.BwK, this.BwL.Bwt);
      c(this.BwK, this.BwL.size);
      l += c(this.BwK, this.BwM.length);
      if (this.BwL.Bww == null) {
        break label455;
      }
      l += c(this.BwK, this.BwL.Bww.length);
    }
    for (;;)
    {
      c(this.BwK, this.BwN.length);
      c(this.BwK, 0);
      c(this.BwK, 0);
      c(this.BwK, 0L);
      c(this.BwK, this.BwL.Bwx);
      this.BwK.write(this.BwM);
      this.BwM = null;
      if (this.BwL.Bww != null) {
        this.BwK.write(this.BwL.Bww);
      }
      this.offset = (l + this.offset);
      if (this.BwN.length > 0)
      {
        this.BwK.write(this.BwN);
        this.BwN = BwE;
      }
      this.BwL = null;
      return;
      i = 8;
      break;
      label442:
      l += this.BwL.size;
      break label224;
      label455:
      c(this.BwK, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.aG(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.BwL == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.h
 * JD-Core Version:    0.7.0.1
 */