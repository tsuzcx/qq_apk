package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  protected f Uyh;
  int Uyi;
  private InputStream Uyj;
  private int Uyk;
  private int Uyl;
  private final OutputStream Uym;
  private int[] Uyn;
  int Uyo;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.Uyh = new f();
    this.Uyn = new int[8];
    this.Uyj = paramInputStream;
    this.Uym = null;
    this.Uyk = paramInputStream.read();
    this.Uyl = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.Uyh = new f();
    this.Uyn = new int[8];
    this.Uyj = paramInputStream;
    this.Uym = paramOutputStream;
    this.Uyk = paramInputStream.read();
    this.Uyl = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private int Gp(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.Uyi == 8)
    {
      rR();
      if (this.Uyk == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.Uyk >> 7 - this.Uyi & 0x1;
    this.Uyi += 1;
    if ((paramBoolean) && (this.Uym != null)) {
      aqa(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  private long apW(int paramInt)
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
      l = l << 1 | Gp(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void aqb(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      aI(0L, i);
      aqa(1);
      aI(paramInt - j, i);
      AppMethodBeat.o(114883);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  private int hWp()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (Gp(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = apW(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int hWt()
  {
    AppMethodBeat.i(114877);
    int i = hWp();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void hWu()
  {
    AppMethodBeat.i(114880);
    int i = this.Uyn[0];
    int j = this.Uyn[1];
    int k = this.Uyn[2];
    int m = this.Uyn[3];
    int n = this.Uyn[4];
    int i1 = this.Uyn[5];
    int i2 = this.Uyn[6];
    int i3 = this.Uyn[7];
    this.Uym.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private void rR()
  {
    AppMethodBeat.i(114870);
    this.Uyk = this.Uyl;
    this.Uyl = this.Uyj.read();
    this.Uyi = 0;
    AppMethodBeat.o(114870);
  }
  
  public final boolean Go(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (Gp(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void Gq(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      aqa(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
  
  public final void aI(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      aqa((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final void apX(int paramInt)
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
      Gp(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void apY(int paramInt)
  {
    AppMethodBeat.i(114872);
    apX(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void apZ(int paramInt)
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
        i = (hWt() + j + 256) % 256;
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
  
  public final void aqa(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.Uyo == 8)
    {
      this.Uyo = 0;
      hWu();
    }
    int[] arrayOfInt = this.Uyn;
    int i = this.Uyo;
    this.Uyo = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void aqc(int paramInt)
  {
    AppMethodBeat.i(114884);
    aqb(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.Uyo;
    while (i < 8)
    {
      this.Uyn[i] = 0;
      i += 1;
    }
    this.Uyo = 0;
    hWu();
    AppMethodBeat.o(114879);
  }
  
  public final long hWo()
  {
    AppMethodBeat.i(114871);
    long l = apW(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void hWq()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (Gp(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      apX(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int hWr()
  {
    AppMethodBeat.i(114875);
    int i = hWp();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void hWs()
  {
    AppMethodBeat.i(114876);
    hWq();
    AppMethodBeat.o(114876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */