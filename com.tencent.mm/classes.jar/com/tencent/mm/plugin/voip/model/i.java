package com.tencent.mm.plugin.voip.model;

import java.io.InputStream;
import java.io.OutputStream;

final class i
{
  protected e pPs = new e();
  int pPt;
  private InputStream pPu;
  private int pPv;
  private int pPw;
  private final OutputStream pPx;
  private int[] pPy = new int[8];
  int pPz;
  
  public i(InputStream paramInputStream)
  {
    this.pPu = paramInputStream;
    this.pPx = null;
    this.pPv = paramInputStream.read();
    this.pPw = paramInputStream.read();
  }
  
  public i(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.pPu = paramInputStream;
    this.pPx = paramOutputStream;
    this.pPv = paramInputStream.read();
    this.pPw = paramInputStream.read();
  }
  
  private int bPN()
  {
    int j = 0;
    int i = 0;
    while (jT(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = zQ(i);
      j = (int)((1 << i) - 1 + l);
    }
    return j;
  }
  
  private void bPQ()
  {
    int i = this.pPy[0];
    int j = this.pPy[1];
    int k = this.pPy[2];
    int m = this.pPy[3];
    int n = this.pPy[4];
    int i1 = this.pPy[5];
    int i2 = this.pPy[6];
    int i3 = this.pPy[7];
    this.pPx.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
  }
  
  private int jT(boolean paramBoolean)
  {
    int i = -1;
    if (this.pPt == 8)
    {
      this.pPv = this.pPw;
      this.pPw = this.pPu.read();
      this.pPt = 0;
      if (this.pPv != -1) {}
    }
    int j;
    do
    {
      do
      {
        return i;
        j = this.pPv >> 7 - this.pPt & 0x1;
        this.pPt += 1;
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (this.pPx == null);
    zU(j);
    return j;
  }
  
  private long zQ(int paramInt)
  {
    if (paramInt > 64) {
      throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | jT(true);
      i += 1;
    }
    return l;
  }
  
  public final long bPM()
  {
    long l = zQ(8);
    return l;
  }
  
  public final int bPO()
  {
    int i = bPN();
    return i;
  }
  
  public final void bPP()
  {
    int i = 0;
    while (jT(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      zR(i);
    }
  }
  
  public final void flush()
  {
    int i = this.pPz;
    while (i < 8)
    {
      this.pPy[i] = 0;
      i += 1;
    }
    this.pPz = 0;
    bPQ();
  }
  
  public final boolean jS(boolean paramBoolean)
  {
    return jT(paramBoolean) == 1;
  }
  
  public final void jU(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zU(i);
      return;
    }
  }
  
  public final void y(long paramLong, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      zU((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
  }
  
  public final void zR(int paramInt)
  {
    if (paramInt > 64) {
      throw new IllegalArgumentException("Can not skip more then 64 bit");
    }
    int i = 0;
    while (i < paramInt)
    {
      jT(true);
      i += 1;
    }
  }
  
  public final void zS(int paramInt)
  {
    zR(paramInt);
  }
  
  public final void zT(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int k = 0;
    int m = 8;
    int i = 8;
    if (k < paramInt)
    {
      int j = m;
      if (m != 0)
      {
        j = bPN();
        j = ((j & 0x1) + (j >> 1)) * (((j & 0x1) << 1) - 1);
        j = (j + i + 256) % 256;
      }
      if (j == 0) {}
      for (;;)
      {
        arrayOfInt[k] = i;
        i = arrayOfInt[k];
        k += 1;
        m = j;
        break;
        i = j;
      }
    }
  }
  
  public final void zU(int paramInt)
  {
    if (this.pPz == 8)
    {
      this.pPz = 0;
      bPQ();
    }
    int[] arrayOfInt = this.pPy;
    int i = this.pPz;
    this.pPz = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public final void zV(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      y(0L, i);
      zU(1);
      y(paramInt - j, i);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.i
 * JD-Core Version:    0.7.0.1
 */