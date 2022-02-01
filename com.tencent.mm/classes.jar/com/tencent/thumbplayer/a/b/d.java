package com.tencent.thumbplayer.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.a.a;
import com.tencent.thumbplayer.utils.g;

public final class d
  extends b
{
  private int RYs;
  private int[] RYt;
  
  public d(a parama)
  {
    super(parama);
    AppMethodBeat.i(188990);
    this.RYs = 0;
    this.RYt = parama.RYt;
    if ((this.RYt == null) || (this.RYt.length == 0)) {
      this.RYt = new int[1];
    }
    AppMethodBeat.o(188990);
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(188991);
    if (this.RYt.length > this.RYs) {}
    for (int i = this.RYt[this.RYs];; i = 0)
    {
      int j;
      if (i != 2)
      {
        j = i;
        if (i != 3) {}
      }
      else
      {
        j = i;
        if (!b(paramb)) {
          j = 0;
        }
      }
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForOpen, playerType:".concat(String.valueOf(j)));
      AppMethodBeat.o(188991);
      return j;
    }
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb, com.tencent.thumbplayer.a.b.a.b paramb1)
  {
    AppMethodBeat.i(188992);
    if (paramb1.RYx == 0)
    {
      i = a(paramb);
      AppMethodBeat.o(188992);
      return i;
    }
    if (this.RYt.length - 1 > this.RYs)
    {
      paramb1 = this.RYt;
      i = this.RYs + 1;
      this.RYs = i;
    }
    for (int i = paramb1[i];; i = 0)
    {
      int j;
      if (i != 2)
      {
        j = i;
        if (i != 3) {}
      }
      else
      {
        j = i;
        if (!b(paramb)) {
          j = 0;
        }
      }
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForRetry, playerType:".concat(String.valueOf(j)));
      AppMethodBeat.o(188992);
      return j;
    }
  }
  
  public final int[] hnd()
  {
    AppMethodBeat.i(188993);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    if (this.RYs >= this.RYt.length)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec error, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(188993);
      return arrayOfInt;
    }
    if ((this.RYt[this.RYs] == 1) || (this.RYt[this.RYs] == 2)) {
      arrayOfInt[0] = 102;
    }
    for (;;)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(188993);
      return arrayOfInt;
      if (this.RYt[this.RYs] == 3) {
        arrayOfInt[0] = 101;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.d
 * JD-Core Version:    0.7.0.1
 */