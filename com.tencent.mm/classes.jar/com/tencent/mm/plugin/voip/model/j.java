package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  private final OutputStream NLA;
  private int[] NLB;
  int NLC;
  protected f NLv;
  int NLw;
  private InputStream NLx;
  private int NLy;
  private int NLz;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.NLv = new f();
    this.NLB = new int[8];
    this.NLx = paramInputStream;
    this.NLA = null;
    this.NLy = paramInputStream.read();
    this.NLz = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.NLv = new f();
    this.NLB = new int[8];
    this.NLx = paramInputStream;
    this.NLA = paramOutputStream;
    this.NLy = paramInputStream.read();
    this.NLz = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private int AR(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.NLw == 8)
    {
      gyt();
      if (this.NLy == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.NLy >> 7 - this.NLw & 0x1;
    this.NLw += 1;
    if ((paramBoolean) && (this.NLA != null)) {
      akI(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  private long akE(int paramInt)
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
      l = l << 1 | AR(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void akJ(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      ar(0L, i);
      akI(1);
      ar(paramInt - j, i);
      AppMethodBeat.o(114883);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  private void gyA()
  {
    AppMethodBeat.i(114880);
    int i = this.NLB[0];
    int j = this.NLB[1];
    int k = this.NLB[2];
    int m = this.NLB[3];
    int n = this.NLB[4];
    int i1 = this.NLB[5];
    int i2 = this.NLB[6];
    int i3 = this.NLB[7];
    this.NLA.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private void gyt()
  {
    AppMethodBeat.i(114870);
    this.NLy = this.NLz;
    this.NLz = this.NLx.read();
    this.NLw = 0;
    AppMethodBeat.o(114870);
  }
  
  private int gyv()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (AR(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = akE(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int gyz()
  {
    AppMethodBeat.i(114877);
    int i = gyv();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  public final boolean AQ(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (AR(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void AS(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      akI(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
  
  public final void akF(int paramInt)
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
      AR(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void akG(int paramInt)
  {
    AppMethodBeat.i(114872);
    akF(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void akH(int paramInt)
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
        i = (gyz() + j + 256) % 256;
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
  
  public final void akI(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.NLC == 8)
    {
      this.NLC = 0;
      gyA();
    }
    int[] arrayOfInt = this.NLB;
    int i = this.NLC;
    this.NLC = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void akK(int paramInt)
  {
    AppMethodBeat.i(114884);
    akJ(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void ar(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      akI((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.NLC;
    while (i < 8)
    {
      this.NLB[i] = 0;
      i += 1;
    }
    this.NLC = 0;
    gyA();
    AppMethodBeat.o(114879);
  }
  
  public final long gyu()
  {
    AppMethodBeat.i(114871);
    long l = akE(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void gyw()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (AR(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      akF(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int gyx()
  {
    AppMethodBeat.i(114875);
    int i = gyv();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void gyy()
  {
    AppMethodBeat.i(114876);
    gyw();
    AppMethodBeat.o(114876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */