package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  private int CrA;
  private final OutputStream CrB;
  private int[] CrC;
  int CrD;
  protected f Crx;
  int Cry;
  private int Crz;
  private InputStream aKY;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.Crx = new f();
    this.CrC = new int[8];
    this.aKY = paramInputStream;
    this.CrB = null;
    this.Crz = paramInputStream.read();
    this.CrA = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.Crx = new f();
    this.CrC = new int[8];
    this.aKY = paramInputStream;
    this.CrB = paramOutputStream;
    this.Crz = paramInputStream.read();
    this.CrA = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private long UA(int paramInt)
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
      l = l << 1 | to(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void UF(int paramInt)
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
      UE(1);
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
    this.Crz = this.CrA;
    this.CrA = this.aKY.read();
    this.Cry = 0;
    AppMethodBeat.o(114870);
  }
  
  private int ezr()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (to(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = UA(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int ezv()
  {
    AppMethodBeat.i(114877);
    int i = ezr();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void ezw()
  {
    AppMethodBeat.i(114880);
    int i = this.CrC[0];
    int j = this.CrC[1];
    int k = this.CrC[2];
    int m = this.CrC[3];
    int n = this.CrC[4];
    int i1 = this.CrC[5];
    int i2 = this.CrC[6];
    int i3 = this.CrC[7];
    this.CrB.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private int to(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.Cry == 8)
    {
      advance();
      if (this.Crz == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.Crz >> 7 - this.Cry & 0x1;
    this.Cry += 1;
    if ((paramBoolean) && (this.CrB != null)) {
      UE(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  public final void UB(int paramInt)
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
      to(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void UC(int paramInt)
  {
    AppMethodBeat.i(114872);
    UB(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void UD(int paramInt)
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
        i = (ezv() + j + 256) % 256;
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
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.CrD == 8)
    {
      this.CrD = 0;
      ezw();
    }
    int[] arrayOfInt = this.CrC;
    int i = this.CrD;
    this.CrD = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void UG(int paramInt)
  {
    AppMethodBeat.i(114884);
    UF(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void af(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      UE((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final long ezq()
  {
    AppMethodBeat.i(114871);
    long l = UA(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void ezs()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (to(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      UB(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int ezt()
  {
    AppMethodBeat.i(114875);
    int i = ezr();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void ezu()
  {
    AppMethodBeat.i(114876);
    ezs();
    AppMethodBeat.o(114876);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.CrD;
    while (i < 8)
    {
      this.CrC[i] = 0;
      i += 1;
    }
    this.CrD = 0;
    ezw();
    AppMethodBeat.o(114879);
  }
  
  public final boolean tn(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (to(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void tp(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      UE(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */