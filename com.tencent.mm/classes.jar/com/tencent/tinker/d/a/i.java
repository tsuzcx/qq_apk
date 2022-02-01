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
  public static final byte[] MEW = new byte[0];
  private static final byte[] MEX = { -1, -1, -1, -1 };
  public byte[] MEA = MEW;
  private final HashSet<String> MEB = new HashSet();
  private int MEC = 8;
  private ByteArrayOutputStream MED = new ByteArrayOutputStream();
  private byte[] MEH;
  private final boolean MEY = false;
  private g MEZ;
  private byte[] MFa;
  private boolean MFb;
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
  
  private void gdc()
  {
    if (this.MED == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final void b(g paramg)
  {
    if (this.MEZ != null) {
      closeEntry();
    }
    int i = paramg.MEM;
    if (i == -1) {
      i = this.MEC;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (paramg.MEL == -1L) {
          paramg.MEL = paramg.size;
        }
        while (paramg.crc == -1L)
        {
          throw new ZipException("STORED entry missing CRC");
          if (paramg.size == -1L) {
            paramg.setSize(paramg.MEL);
          }
        }
        if (paramg.size == -1L) {
          throw new ZipException("STORED entry missing size");
        }
        if (paramg.size != paramg.MEL) {
          throw new ZipException("STORED entry size/compressed size mismatch");
        }
      }
      gdc();
      paramg.FQf = null;
      paramg.MEO = null;
      paramg.heF = 40691;
      paramg.MEN = 18698;
      this.MEH = paramg.name.getBytes(e.UTF_8);
      D("Name", this.MEH);
      this.MFa = MEW;
      if (paramg.FQf != null)
      {
        this.MFa = paramg.FQf.getBytes(e.UTF_8);
        D("Comment", this.MFa);
      }
      paramg.setMethod(i);
      this.MEZ = paramg;
      this.MEZ.MEP = this.offset;
      this.MEB.add(this.MEZ.name);
      int j;
      if (i == 0)
      {
        j = 0;
        d(this.out, 67324752L);
        e(this.out, 20);
        e(this.out, j | 0x800);
        e(this.out, i);
        e(this.out, this.MEZ.heF);
        e(this.out, this.MEZ.MEN);
        if (i != 0) {
          break label467;
        }
        d(this.out, this.MEZ.crc);
        d(this.out, this.MEZ.size);
        d(this.out, this.MEZ.size);
        label386:
        e(this.out, this.MEH.length);
        if (this.MEZ.MEO == null) {
          break label497;
        }
        e(this.out, this.MEZ.MEO.length);
      }
      for (;;)
      {
        this.out.write(this.MEH);
        if (this.MEZ.MEO != null) {
          this.out.write(this.MEZ.MEO);
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
      if (this.MED != null)
      {
        if (this.MEB.isEmpty()) {
          throw new ZipException("No entries");
        }
        if (this.MEZ != null) {
          closeEntry();
        }
        i = this.MED.size();
        d(this.MED, 101010256L);
        e(this.MED, 0);
        e(this.MED, 0);
        if (!this.MFb) {
          break label209;
        }
        e(this.MED, 65535);
        e(this.MED, 65535);
        d(this.MED, -1L);
        d(this.MED, -1L);
      }
    }
    for (;;)
    {
      e(this.MED, this.MEA.length);
      if (this.MEA.length > 0) {
        this.MED.write(this.MEA);
      }
      this.MED.writeTo(this.out);
      this.MED = null;
      this.out.close();
      this.out = null;
      return;
      label209:
      e(this.MED, this.MEB.size());
      e(this.MED, this.MEB.size());
      d(this.MED, i);
      d(this.MED, this.offset);
    }
  }
  
  public final void closeEntry()
  {
    gdc();
    if (this.MEZ == null) {
      return;
    }
    long l = 30L;
    if (this.MEZ.MEM != 0)
    {
      l = 46L;
      d(this.out, 134695760L);
      d(this.out, this.MEZ.crc);
      d(this.out, this.MEZ.MEL);
      d(this.out, this.MEZ.size);
    }
    int i;
    if (this.MEZ.MEM == 0)
    {
      i = 0;
      d(this.MED, 33639248L);
      e(this.MED, 20);
      e(this.MED, 20);
      e(this.MED, i | 0x800);
      e(this.MED, this.MEZ.MEM);
      e(this.MED, this.MEZ.heF);
      e(this.MED, this.MEZ.MEN);
      d(this.MED, this.MEZ.crc);
      if (this.MEZ.MEM != 8) {
        break label442;
      }
      l += this.MEZ.MEL;
      label224:
      d(this.MED, this.MEZ.MEL);
      d(this.MED, this.MEZ.size);
      l += e(this.MED, this.MEH.length);
      if (this.MEZ.MEO == null) {
        break label455;
      }
      l += e(this.MED, this.MEZ.MEO.length);
    }
    for (;;)
    {
      e(this.MED, this.MFa.length);
      e(this.MED, 0);
      e(this.MED, 0);
      d(this.MED, 0L);
      d(this.MED, this.MEZ.MEP);
      this.MED.write(this.MEH);
      this.MEH = null;
      if (this.MEZ.MEO != null) {
        this.MED.write(this.MEZ.MEO);
      }
      this.offset = (l + this.offset);
      if (this.MFa.length > 0)
      {
        this.MED.write(this.MFa);
        this.MFa = MEW;
      }
      this.MEZ = null;
      return;
      i = 8;
      break;
      label442:
      l += this.MEZ.size;
      break label224;
      label455:
      e(this.MED, 0);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.aW(paramArrayOfByte.length, paramInt1, paramInt2);
    if (this.MEZ == null) {
      throw new ZipException("No active entry");
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.d.a.i
 * JD-Core Version:    0.7.0.1
 */