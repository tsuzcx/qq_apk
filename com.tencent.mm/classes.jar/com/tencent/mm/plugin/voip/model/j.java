package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  protected f GVj;
  int GVk;
  private int GVl;
  private int GVm;
  private final OutputStream GVn;
  private int[] GVo;
  int GVp;
  private InputStream aKQ;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.GVj = new f();
    this.GVo = new int[8];
    this.aKQ = paramInputStream;
    this.GVn = null;
    this.GVl = paramInputStream.read();
    this.GVm = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.GVj = new f();
    this.GVo = new int[8];
    this.aKQ = paramInputStream;
    this.GVn = paramOutputStream;
    this.GVl = paramInputStream.read();
    this.GVm = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private long acT(int paramInt)
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
      l = l << 1 | wZ(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void acY(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      ai(0L, i);
      acX(1);
      ai(paramInt - j, i);
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
    this.GVl = this.GVm;
    this.GVm = this.aKQ.read();
    this.GVk = 0;
    AppMethodBeat.o(114870);
  }
  
  private int fGh()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (wZ(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = acT(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int fGl()
  {
    AppMethodBeat.i(114877);
    int i = fGh();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void fGm()
  {
    AppMethodBeat.i(114880);
    int i = this.GVo[0];
    int j = this.GVo[1];
    int k = this.GVo[2];
    int m = this.GVo[3];
    int n = this.GVo[4];
    int i1 = this.GVo[5];
    int i2 = this.GVo[6];
    int i3 = this.GVo[7];
    this.GVn.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private int wZ(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.GVk == 8)
    {
      advance();
      if (this.GVl == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.GVl >> 7 - this.GVk & 0x1;
    this.GVk += 1;
    if ((paramBoolean) && (this.GVn != null)) {
      acX(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  public final void acU(int paramInt)
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
      wZ(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void acV(int paramInt)
  {
    AppMethodBeat.i(114872);
    acU(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void acW(int paramInt)
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
        i = (fGl() + j + 256) % 256;
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
  
  public final void acX(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.GVp == 8)
    {
      this.GVp = 0;
      fGm();
    }
    int[] arrayOfInt = this.GVo;
    int i = this.GVp;
    this.GVp = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void acZ(int paramInt)
  {
    AppMethodBeat.i(114884);
    acY(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void ai(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      acX((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final long fGg()
  {
    AppMethodBeat.i(114871);
    long l = acT(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void fGi()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (wZ(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      acU(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int fGj()
  {
    AppMethodBeat.i(114875);
    int i = fGh();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void fGk()
  {
    AppMethodBeat.i(114876);
    fGi();
    AppMethodBeat.o(114876);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.GVp;
    while (i < 8)
    {
      this.GVo[i] = 0;
      i += 1;
    }
    this.GVp = 0;
    fGm();
    AppMethodBeat.o(114879);
  }
  
  public final boolean wY(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (wZ(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      acX(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */