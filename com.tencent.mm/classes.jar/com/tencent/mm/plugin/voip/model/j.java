package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  private int tuA;
  private int tuB;
  private final OutputStream tuC;
  private int[] tuD;
  int tuE;
  protected f tux;
  int tuy;
  private InputStream tuz;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(4369);
    this.tux = new f();
    this.tuD = new int[8];
    this.tuz = paramInputStream;
    this.tuC = null;
    this.tuA = paramInputStream.read();
    this.tuB = paramInputStream.read();
    AppMethodBeat.o(4369);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(4370);
    this.tux = new f();
    this.tuD = new int[8];
    this.tuz = paramInputStream;
    this.tuC = paramOutputStream;
    this.tuA = paramInputStream.read();
    this.tuB = paramInputStream.read();
    AppMethodBeat.o(4370);
  }
  
  private long GZ(int paramInt)
  {
    AppMethodBeat.i(4373);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
      AppMethodBeat.o(4373);
      throw localIllegalArgumentException;
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | mM(true);
      i += 1;
    }
    AppMethodBeat.o(4373);
    return l;
  }
  
  private void He(int paramInt)
  {
    AppMethodBeat.i(4388);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      I(0L, i);
      Hd(1);
      I(paramInt - j, i);
      AppMethodBeat.o(4388);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  private void advance()
  {
    AppMethodBeat.i(4375);
    this.tuA = this.tuB;
    this.tuB = this.tuz.read();
    this.tuy = 0;
    AppMethodBeat.o(4375);
  }
  
  private int cLP()
  {
    int j = 0;
    AppMethodBeat.i(4378);
    int i = 0;
    while (mM(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = GZ(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(4378);
    return j;
  }
  
  private int cLT()
  {
    AppMethodBeat.i(4382);
    int i = cLP();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(4382);
    return i;
  }
  
  private void cLU()
  {
    AppMethodBeat.i(4385);
    int i = this.tuD[0];
    int j = this.tuD[1];
    int k = this.tuD[2];
    int m = this.tuD[3];
    int n = this.tuD[4];
    int i1 = this.tuD[5];
    int i2 = this.tuD[6];
    int i3 = this.tuD[7];
    this.tuC.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(4385);
  }
  
  private int mM(boolean paramBoolean)
  {
    AppMethodBeat.i(4372);
    if (this.tuy == 8)
    {
      advance();
      if (this.tuA == -1)
      {
        AppMethodBeat.o(4372);
        return -1;
      }
    }
    int i = this.tuA >> 7 - this.tuy & 0x1;
    this.tuy += 1;
    if ((paramBoolean) && (this.tuC != null)) {
      Hd(i);
    }
    AppMethodBeat.o(4372);
    return i;
  }
  
  public final void Ha(int paramInt)
  {
    AppMethodBeat.i(4374);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
      AppMethodBeat.o(4374);
      throw localIllegalArgumentException;
    }
    int i = 0;
    while (i < paramInt)
    {
      mM(true);
      i += 1;
    }
    AppMethodBeat.o(4374);
  }
  
  public final void Hb(int paramInt)
  {
    AppMethodBeat.i(4377);
    Ha(paramInt);
    AppMethodBeat.o(4377);
  }
  
  public final void Hc(int paramInt)
  {
    AppMethodBeat.i(4383);
    int[] arrayOfInt = new int[paramInt];
    int k = 0;
    int m = 8;
    int j = 8;
    if (k < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (cLT() + j + 256) % 256;
      }
      if (i == 0) {}
      for (;;)
      {
        arrayOfInt[k] = j;
        j = arrayOfInt[k];
        k += 1;
        m = i;
        break;
        j = i;
      }
    }
    AppMethodBeat.o(4383);
  }
  
  public final void Hd(int paramInt)
  {
    AppMethodBeat.i(4386);
    if (this.tuE == 8)
    {
      this.tuE = 0;
      cLU();
    }
    int[] arrayOfInt = this.tuD;
    int i = this.tuE;
    this.tuE = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(4386);
  }
  
  public final void Hf(int paramInt)
  {
    AppMethodBeat.i(4389);
    He(paramInt);
    AppMethodBeat.o(4389);
  }
  
  public final void I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(4387);
    int i = 0;
    while (i < paramInt)
    {
      Hd((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(4387);
  }
  
  public final long cLO()
  {
    AppMethodBeat.i(4376);
    long l = GZ(8);
    AppMethodBeat.o(4376);
    return l;
  }
  
  final void cLQ()
  {
    AppMethodBeat.i(4379);
    int i = 0;
    while (mM(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      Ha(i);
    }
    AppMethodBeat.o(4379);
  }
  
  public final int cLR()
  {
    AppMethodBeat.i(4380);
    int i = cLP();
    AppMethodBeat.o(4380);
    return i;
  }
  
  public final void cLS()
  {
    AppMethodBeat.i(4381);
    cLQ();
    AppMethodBeat.o(4381);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(4384);
    int i = this.tuE;
    while (i < 8)
    {
      this.tuD[i] = 0;
      i += 1;
    }
    this.tuE = 0;
    cLU();
    AppMethodBeat.o(4384);
  }
  
  public final boolean mL(boolean paramBoolean)
  {
    AppMethodBeat.i(4371);
    if (mM(paramBoolean) == 1)
    {
      AppMethodBeat.o(4371);
      return true;
    }
    AppMethodBeat.o(4371);
    return false;
  }
  
  public final void mN(boolean paramBoolean)
  {
    AppMethodBeat.i(4390);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Hd(i);
      AppMethodBeat.o(4390);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */