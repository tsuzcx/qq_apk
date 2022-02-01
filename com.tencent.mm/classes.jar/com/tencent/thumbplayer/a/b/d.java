package com.tencent.thumbplayer.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.a.a;
import com.tencent.thumbplayer.utils.g;

public final class d
  extends b
{
  private int ahGf;
  private int[] ahGg;
  
  public d(a parama)
  {
    super(parama);
    AppMethodBeat.i(228500);
    this.ahGf = 0;
    this.ahGg = parama.ahGg;
    if ((this.ahGg == null) || (this.ahGg.length == 0)) {
      this.ahGg = new int[1];
    }
    AppMethodBeat.o(228500);
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(228507);
    if (this.ahGg.length > this.ahGf) {}
    for (int i = this.ahGg[this.ahGf];; i = 0)
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
      AppMethodBeat.o(228507);
      return j;
    }
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb, com.tencent.thumbplayer.a.b.a.b paramb1)
  {
    AppMethodBeat.i(228514);
    if (paramb1.ahGk == 0)
    {
      i = a(paramb);
      AppMethodBeat.o(228514);
      return i;
    }
    if (this.ahGg.length - 1 > this.ahGf)
    {
      paramb1 = this.ahGg;
      i = this.ahGf + 1;
      this.ahGf = i;
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
      AppMethodBeat.o(228514);
      return j;
    }
  }
  
  public final int[] jZZ()
  {
    AppMethodBeat.i(228523);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    if (this.ahGf >= this.ahGg.length)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec error, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(228523);
      return arrayOfInt;
    }
    if ((this.ahGg[this.ahGf] == 1) || (this.ahGg[this.ahGf] == 2)) {
      arrayOfInt[0] = 102;
    }
    for (;;)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(228523);
      return arrayOfInt;
      if (this.ahGg[this.ahGf] == 3) {
        arrayOfInt[0] = 101;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.d
 * JD-Core Version:    0.7.0.1
 */