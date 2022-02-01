package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j
{
  protected f AAX;
  int AAY;
  private int AAZ;
  private int ABa;
  private final OutputStream ABb;
  private int[] ABc;
  int ABd;
  private InputStream aJh;
  
  public j(InputStream paramInputStream)
  {
    AppMethodBeat.i(114864);
    this.AAX = new f();
    this.ABc = new int[8];
    this.aJh = paramInputStream;
    this.ABb = null;
    this.AAZ = paramInputStream.read();
    this.ABa = paramInputStream.read();
    AppMethodBeat.o(114864);
  }
  
  public j(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114865);
    this.AAX = new f();
    this.ABc = new int[8];
    this.aJh = paramInputStream;
    this.ABb = paramOutputStream;
    this.AAZ = paramInputStream.read();
    this.ABa = paramInputStream.read();
    AppMethodBeat.o(114865);
  }
  
  private long Sb(int paramInt)
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
      l = l << 1 | sy(true);
      i += 1;
    }
    AppMethodBeat.o(114868);
    return l;
  }
  
  private void Sg(int paramInt)
  {
    AppMethodBeat.i(114883);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      aa(0L, i);
      Sf(1);
      aa(paramInt - j, i);
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
    this.AAZ = this.ABa;
    this.ABa = this.aJh.read();
    this.AAY = 0;
    AppMethodBeat.o(114870);
  }
  
  private int ehZ()
  {
    int j = 0;
    AppMethodBeat.i(114873);
    int i = 0;
    while (sy(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = Sb(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(114873);
    return j;
  }
  
  private int eid()
  {
    AppMethodBeat.i(114877);
    int i = ehZ();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    AppMethodBeat.o(114877);
    return i;
  }
  
  private void eie()
  {
    AppMethodBeat.i(114880);
    int i = this.ABc[0];
    int j = this.ABc[1];
    int k = this.ABc[2];
    int m = this.ABc[3];
    int n = this.ABc[4];
    int i1 = this.ABc[5];
    int i2 = this.ABc[6];
    int i3 = this.ABc[7];
    this.ABb.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(114880);
  }
  
  private int sy(boolean paramBoolean)
  {
    AppMethodBeat.i(114867);
    if (this.AAY == 8)
    {
      advance();
      if (this.AAZ == -1)
      {
        AppMethodBeat.o(114867);
        return -1;
      }
    }
    int i = this.AAZ >> 7 - this.AAY & 0x1;
    this.AAY += 1;
    if ((paramBoolean) && (this.ABb != null)) {
      Sf(i);
    }
    AppMethodBeat.o(114867);
    return i;
  }
  
  public final void Sc(int paramInt)
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
      sy(true);
      i += 1;
    }
    AppMethodBeat.o(114869);
  }
  
  public final void Sd(int paramInt)
  {
    AppMethodBeat.i(114872);
    Sc(paramInt);
    AppMethodBeat.o(114872);
  }
  
  public final void Se(int paramInt)
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
        i = (eid() + j + 256) % 256;
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
  
  public final void Sf(int paramInt)
  {
    AppMethodBeat.i(114881);
    if (this.ABd == 8)
    {
      this.ABd = 0;
      eie();
    }
    int[] arrayOfInt = this.ABc;
    int i = this.ABd;
    this.ABd = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(114881);
  }
  
  public final void Sh(int paramInt)
  {
    AppMethodBeat.i(114884);
    Sg(paramInt);
    AppMethodBeat.o(114884);
  }
  
  public final void aa(long paramLong, int paramInt)
  {
    AppMethodBeat.i(114882);
    int i = 0;
    while (i < paramInt)
    {
      Sf((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(114882);
  }
  
  public final long ehY()
  {
    AppMethodBeat.i(114871);
    long l = Sb(8);
    AppMethodBeat.o(114871);
    return l;
  }
  
  final void eia()
  {
    AppMethodBeat.i(114874);
    int i = 0;
    while (sy(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      Sc(i);
    }
    AppMethodBeat.o(114874);
  }
  
  public final int eib()
  {
    AppMethodBeat.i(114875);
    int i = ehZ();
    AppMethodBeat.o(114875);
    return i;
  }
  
  public final void eic()
  {
    AppMethodBeat.i(114876);
    eia();
    AppMethodBeat.o(114876);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(114879);
    int i = this.ABd;
    while (i < 8)
    {
      this.ABc[i] = 0;
      i += 1;
    }
    this.ABd = 0;
    eie();
    AppMethodBeat.o(114879);
  }
  
  public final boolean sx(boolean paramBoolean)
  {
    AppMethodBeat.i(114866);
    if (sy(paramBoolean) == 1)
    {
      AppMethodBeat.o(114866);
      return true;
    }
    AppMethodBeat.o(114866);
    return false;
  }
  
  public final void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(114885);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Sf(i);
      AppMethodBeat.o(114885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */