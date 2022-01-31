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
  public static final byte[] wZY = new byte[0];
  private static final byte[] wZZ = { -1, -1, -1, -1 };
  private long pj = 0L;
  private final HashSet<String> xaa = new HashSet();
  private final boolean xab = false;
  public byte[] xac = wZY;
  private int xad = 8;
  private ByteArrayOutputStream xae = new ByteArrayOutputStream();
  private f xaf;
  private byte[] xag;
  private byte[] xah;
  private boolean xai;
  
  public h(OutputStream paramOutputStream)
  {
    this(paramOutputStream, (byte)0);
  }
  
  private h(OutputStream paramOutputStream, byte paramByte)
  {
    super(paramOutputStream);
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
  
  private void cQX()
  {
    if (this.xae == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public static void y(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 65535) {
      throw new IllegalArgumentException(paramString + " too long in UTF-8:" + paramArrayOfByte.length + " bytes");
    }
  }
  
  public final void b(f paramf)
  {
    if (this.xaf != null) {
      closeEntry();
    }
    int i = paramf.wZO;
    if (i == -1) {
      i = this.xad;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramf.wZN == -1L) {
          paramf.wZN = paramf.size;
        }
        while (paramf.wZD == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramf.size == -1L) {
            paramf.setSize(paramf.wZN);
          }
        }
        if (paramf.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramf.size != paramf.wZN) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      cQX();
      paramf.tIg = null;
      paramf.wZQ = null;
      paramf.time = 40691;
      paramf.wZP = 18698;
      this.xag = paramf.name.getBytes(d.UTF_8);
      y("Name", this.xag);
      this.xah = wZY;
      if (paramf.tIg != null)
      {
        this.xah = paramf.tIg.getBytes(d.UTF_8);
        y("Comment", this.xah);
      }
      paramf.setMethod(i);
      this.xaf = paramf;
      this.xaf.wZR = this.pj;
      this.xaa.add(this.xaf.name);
      int j;
      if (i == 0)
      {
        j = 0;
        c(this.out, 67324752L);
        c(this.out, 20);
        c(this.out, j | 0x800);
        c(this.out, i);
        c(this.out, this.xaf.time);
        c(this.out, this.xaf.wZP);
        if (i != 0) {
          break label467;
        }
        c(this.out, this.xaf.wZD);
        c(this.out, this.xaf.size);
        c(this.out, this.xaf.size);
        label386:
        c(this.out, this.xag.length);
        if (this.xaf.wZQ == null) {
          break label497;
        }
        c(this.out, this.xaf.wZQ.length);
      }
      for (;;)
      {
        this.out.write(this.xag);
        if (this.xaf.wZQ != null) {
          this.out.write(this.xaf.wZQ);
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
      if (this.xae != null)
      {
        if (this.xaa.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.xaf != null) {
          closeEntry();
        }
        i = this.xae.size();
        c(this.xae, 101010256L);
        c(this.xae, 0);
        c(this.xae, 0);
        if (!this.xai) {
          break label209;
        }
        c(this.xae, 65535);
        c(this.xae, 65535);
        c(this.xae, -1L);
        c(this.xae, -1L);
      }
    }
    for (;;)
    {
      c(this.xae, this.xac.length);
      if (this.xac.length > 0) {
        this.xae.write(this.xac);
      }
      this.xae.writeTo(this.out);
      this.xae = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      c(this.xae, this.xaa.size());
      c(this.xae, this.xaa.size());
      c(this.xae, i);
      c(this.xae, this.pj);
    }
  }
  
  public final void closeEntry()
  {
    cQX();
    if (this.xaf == null) {
      return;
    }
    long l = 30L;
    if (this.xaf.wZO != 0)
    {
      l = 46L;
      c(this.out, 134695760L);
      c(this.out, this.xaf.wZD);
      c(this.out, this.xaf.wZN);
      c(this.out, this.xaf.size);
    }
    int i;
    if (this.xaf.wZO == 0)
    {
      i = 0;
      c(this.xae, 33639248L);
      c(this.xae, 20);
      c(this.xae, 20);
      c(this.xae, i | 0x800);
      c(this.xae, this.xaf.wZO);
      c(this.xae, this.xaf.time);
      c(this.xae, this.xaf.wZP);
      c(this.xae, this.xaf.wZD);
      if (this.xaf.wZO != 8) {
        break label442;
      }
      l += this.xaf.wZN;
      label224:
      c(this.xae, this.xaf.wZN);
      c(this.xae, this.xaf.size);
      l += c(this.xae, this.xag.length);
      if (this.xaf.wZQ == null) {
        break label455;
      }
      l += c(this.xae, this.xaf.wZQ.length);
    }
    for (;;)
    {
      c(this.xae, this.xah.length);
      c(this.xae, 0);
      c(this.xae, 0);
      c(this.xae, 0L);
      c(this.xae, this.xaf.wZR);
      this.xae.write(this.xag);
      this.xag = null;
      if (this.xaf.wZQ != null) {
        this.xae.write(this.xaf.wZQ);
      }
      this.pj = (l + this.pj);
      if (this.xah.length > 0)
      {
        this.xae.write(this.xah);
        this.xah = wZY;
      }
      this.xaf = null;
      return;
      i = 8;
      break;
      label442:
      l += this.xaf.size;
      break label224;
      label455:
      c(this.xae, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.au(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.xaf == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.h
 * JD-Core Version:    0.7.0.1
 */