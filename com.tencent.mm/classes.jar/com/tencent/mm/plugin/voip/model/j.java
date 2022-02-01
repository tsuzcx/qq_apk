package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  private InputStream aIr;
  protected f zin;
  int zio;
  private int zip;
  private int ziq;
  private final OutputStream zir;
  private int[] zis;
  int zit;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.zin = new f();
    this.zis = new int[8];
    this.aIr = paramInputStream;
    this.zir = null;
    this.zip = paramInputStream.read();
    this.ziq = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.zin = new f();
    this.zis = new int[8];
    this.aIr = paramInputStream;
    this.zir = paramOutputStream;
    this.zip = paramInputStream.read();
    this.ziq = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private long PS(int paramInt)
  {
    AppMethodBeat.i(114868);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
      AppMethodBeat.o(114868);
      throw localIllegalArgumentException;
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | rx(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void PX(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      X(0L, i);
      PW(1);
      X(paramInt - j, i);
      AppMethodBeat.o(114883);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  private void advance()
  {
    AppMethodBeat.i(114870);
    this.zip = this.ziq;
    this.ziq = this.aIr.read();
    this.zio = 0;
    AppMethodBeat.o(114870);
  }
  
  private int dSN()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (rx(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = PS(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int dSR()
  {
    AppMethodBeat.i(114877);
    int i = dSN();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void dSS()
  {
    AppMethodBeat.i(114880);
    int i = this.zis[0];
    int j = this.zis[1];
    int k = this.zis[2];
    int m = this.zis[3];
    int n = this.zis[4];
    int i1 = this.zis[5];
    int i2 = this.zis[6];
    int i3 = this.zis[7];
    this.zir.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private int rx(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.zio == 8)
    {
      advance();
      if (this.zip == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.zip >> 7 - this.zio & 0x1;
    this.zio += 1;
    if ((paramBoolean) && (this.zir != null)) {
      PW(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  public final void PT(int paramInt)
  {
    AppMethodBeat.i(114869);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
      AppMethodBeat.o(114869);
      throw localIllegalArgumentException;
    }
    int i = 0;
    while (i < paramInt)
    {
      rx(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void PU(int paramInt)
  {
    AppMethodBeat.i(114872);
    PT(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void PV(int paramInt)
  {
    AppMethodBeat.i(114878);
    int[] arrayOfInt = new int[paramInt];
    int k = 0;
    int m = 8;
    int j = 8;
    if (k < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (dSR() + j + 256) % 256;
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
    AppMethodBeat.o(114878);
  }
  
  public final void PW(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.zit == 8)
    {
      this.zit = 0;
      dSS();
    }
    int[] arrayOfInt = this.zis;
    int i = this.zit;
    this.zit = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(114884);
    PX(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void X(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      PW((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final long dSM()
  {
    AppMethodBeat.i(114871);
    long l = PS(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void dSO()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (rx(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      PT(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int dSP()
  {
    AppMethodBeat.i(114875);
    int i = dSN();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void dSQ()
  {
    AppMethodBeat.i(114876);
    dSO();
    AppMethodBeat.o(114876);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.zit;
    while (i < 8)
    {
      this.zis[i] = 0;
      i += 1;
    }
    this.zit = 0;
    dSS();
    AppMethodBeat.o(114879);
  }
  
  public final boolean rw(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (rx(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      PW(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */