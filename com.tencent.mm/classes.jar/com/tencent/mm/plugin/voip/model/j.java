package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  protected f BZW;
  int BZX;
  private int BZY;
  private int BZZ;
  private final OutputStream Caa;
  private int[] Cab;
  int Cac;
  private InputStream aKY;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.BZW = new f();
    this.Cab = new int[8];
    this.aKY = paramInputStream;
    this.Caa = null;
    this.BZY = paramInputStream.read();
    this.BZZ = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.BZW = new f();
    this.Cab = new int[8];
    this.aKY = paramInputStream;
    this.Caa = paramOutputStream;
    this.BZY = paramInputStream.read();
    this.BZZ = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private long TT(int paramInt)
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
      l = l << 1 | th(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void TY(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      af(0L, i);
      TX(1);
      af(paramInt - j, i);
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
    this.BZY = this.BZZ;
    this.BZZ = this.aKY.read();
    this.BZX = 0;
    AppMethodBeat.o(114870);
  }
  
  private int evK()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (th(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = TT(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int evO()
  {
    AppMethodBeat.i(114877);
    int i = evK();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void evP()
  {
    AppMethodBeat.i(114880);
    int i = this.Cab[0];
    int j = this.Cab[1];
    int k = this.Cab[2];
    int m = this.Cab[3];
    int n = this.Cab[4];
    int i1 = this.Cab[5];
    int i2 = this.Cab[6];
    int i3 = this.Cab[7];
    this.Caa.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private int th(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.BZX == 8)
    {
      advance();
      if (this.BZY == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.BZY >> 7 - this.BZX & 0x1;
    this.BZX += 1;
    if ((paramBoolean) && (this.Caa != null)) {
      TX(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  public final void TU(int paramInt)
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
      th(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void TV(int paramInt)
  {
    AppMethodBeat.i(114872);
    TU(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void TW(int paramInt)
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
        i = (evO() + j + 256) % 256;
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
  
  public final void TX(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.Cac == 8)
    {
      this.Cac = 0;
      evP();
    }
    int[] arrayOfInt = this.Cab;
    int i = this.Cac;
    this.Cac = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void TZ(int paramInt)
  {
    AppMethodBeat.i(114884);
    TY(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void af(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      TX((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final long evJ()
  {
    AppMethodBeat.i(114871);
    long l = TT(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void evL()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (th(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      TU(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int evM()
  {
    AppMethodBeat.i(114875);
    int i = evK();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void evN()
  {
    AppMethodBeat.i(114876);
    evL();
    AppMethodBeat.o(114876);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.Cac;
    while (i < 8)
    {
      this.Cab[i] = 0;
      i += 1;
    }
    this.Cac = 0;
    evP();
    AppMethodBeat.o(114879);
  }
  
  public final boolean tg(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (th(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      TX(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */