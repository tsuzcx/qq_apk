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
  public static final byte[] IFN = new byte[0];
  private static final byte[] IFO = { -1, -1, -1, -1 };
  private final boolean IFP = false;
  private g IFQ;
  private byte[] IFR;
  private boolean IFS;
  public byte[] IFr = IFN;
  private final HashSet<String> IFs = new HashSet();
  private int IFt = 8;
  private ByteArrayOutputStream IFu = new ByteArrayOutputStream();
  private byte[] IFy;
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
  
  private void fpe()
  {
    if (this.IFu == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.IFQ != null) {
      closeEntry();
    }
    int i = paramg.IFD;
    if (i == -1) {
      i = this.IFt;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.IFC == -1L) {
          paramg.IFC = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.IFC);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.IFC) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      fpe();
      paramg.CzS = null;
      paramg.IFF = null;
      paramg.tGD = 40691;
      paramg.IFE = 18698;
      this.IFy = paramg.name.getBytes(e.UTF_8);
      C("Name", this.IFy);
      this.IFR = IFN;
      if (paramg.CzS != null)
      {
        this.IFR = paramg.CzS.getBytes(e.UTF_8);
        C("Comment", this.IFR);
      }
      paramg.setMethod(i);
      this.IFQ = paramg;
      this.IFQ.IFG = this.offset;
      this.IFs.add(this.IFQ.name);
      int j;
      if (i == 0)
      {
        j = 0;
        d(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.IFQ.tGD);
        e(this.out, this.IFQ.IFE);
        if (i != 0) {
          break label467;
        }
        d(this.out, this.IFQ.crc);
        d(this.out, this.IFQ.size);
        d(this.out, this.IFQ.size);
        label386:
        e(this.out, this.IFy.length);
        if (this.IFQ.IFF == null) {
          break label497;
        }
        e(this.out, this.IFQ.IFF.length);
      }
      for (;;)
      {
        this.out.write(this.IFy);
        if (this.IFQ.IFF != null) {
          this.out.write(this.IFQ.IFF);
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
      if (this.IFu != null)
      {
        if (this.IFs.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.IFQ != null) {
          closeEntry();
        }
        i = this.IFu.size();
        d(this.IFu, 101010256L);
        e(this.IFu, 0);
        e(this.IFu, 0);
        if (!this.IFS) {
          break label209;
        }
        e(this.IFu, 65535);
        e(this.IFu, 65535);
        d(this.IFu, -1L);
        d(this.IFu, -1L);
      }
    }
    for (;;)
    {
      e(this.IFu, this.IFr.length);
      if (this.IFr.length > 0) {
        this.IFu.write(this.IFr);
      }
      this.IFu.writeTo(this.out);
      this.IFu = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.IFu, this.IFs.size());
      e(this.IFu, this.IFs.size());
      d(this.IFu, i);
      d(this.IFu, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    fpe();
    if (this.IFQ == null) {
      return;
    }
    long l = 30L;
    if (this.IFQ.IFD != 0)
    {
      l = 46L;
      d(this.out, 134695760L);
      d(this.out, this.IFQ.crc);
      d(this.out, this.IFQ.IFC);
      d(this.out, this.IFQ.size);
    }
    int i;
    if (this.IFQ.IFD == 0)
    {
      i = 0;
      d(this.IFu, 33639248L);
      e(this.IFu, 20);
      e(this.IFu, 20);
      e(this.IFu, i | 0x800);
      e(this.IFu, this.IFQ.IFD);
      e(this.IFu, this.IFQ.tGD);
      e(this.IFu, this.IFQ.IFE);
      d(this.IFu, this.IFQ.crc);
      if (this.IFQ.IFD != 8) {
        break label442;
      }
      l += this.IFQ.IFC;
      label224:
      d(this.IFu, this.IFQ.IFC);
      d(this.IFu, this.IFQ.size);
      l += e(this.IFu, this.IFy.length);
      if (this.IFQ.IFF == null) {
        break label455;
      }
      l += e(this.IFu, this.IFQ.IFF.length);
    }
    for (;;)
    {
      e(this.IFu, this.IFR.length);
      e(this.IFu, 0);
      e(this.IFu, 0);
      d(this.IFu, 0L);
      d(this.IFu, this.IFQ.IFG);
      this.IFu.write(this.IFy);
      this.IFy = null;
      if (this.IFQ.IFF != null) {
        this.IFu.write(this.IFQ.IFF);
      }
      this.offset = (l + this.offset);
      if (this.IFR.length > 0)
      {
        this.IFu.write(this.IFR);
        this.IFR = IFN;
      }
      this.IFQ = null;
      return;
      i = 8;
      break;
      label442:
      l += this.IFQ.size;
      break label224;
      label455:
      e(this.IFu, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.aS(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.IFQ == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */