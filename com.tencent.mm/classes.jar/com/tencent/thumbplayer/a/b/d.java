package com.tencent.thumbplayer.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.a.a;
import com.tencent.thumbplayer.utils.g;

public final class d
  extends b
{
  private int ZBc;
  private int[] ZBd;
  
  public d(a parama)
  {
    super(parama);
    AppMethodBeat.i(219673);
    this.ZBc = 0;
    this.ZBd = parama.ZBd;
    if ((this.ZBd == null) || (this.ZBd.length == 0)) {
      this.ZBd = new int[1];
    }
    AppMethodBeat.o(219673);
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(219676);
    if (this.ZBd.length > this.ZBc) {}
    for (int i = this.ZBd[this.ZBc];; i = 0)
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
      AppMethodBeat.o(219676);
      return j;
    }
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb, com.tencent.thumbplayer.a.b.a.b paramb1)
  {
    AppMethodBeat.i(219677);
    if (paramb1.ZBh == 0)
    {
      i = a(paramb);
      AppMethodBeat.o(219677);
      return i;
    }
    if (this.ZBd.length - 1 > this.ZBc)
    {
      paramb1 = this.ZBd;
      i = this.ZBc + 1;
      this.ZBc = i;
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
      AppMethodBeat.o(219677);
      return j;
    }
  }
  
  public final int[] iqE()
  {
    AppMethodBeat.i(219678);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    if (this.ZBc >= this.ZBd.length)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec error, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(219678);
      return arrayOfInt;
    }
    if ((this.ZBd[this.ZBc] == 1) || (this.ZBd[this.ZBc] == 2)) {
      arrayOfInt[0] = 102;
    }
    for (;;)
    {
      g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec, decType:" + arrayOfInt[0]);
      AppMethodBeat.o(219678);
      return arrayOfInt;
      if (this.ZBd[this.ZBc] == 3) {
        arrayOfInt[0] = 101;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.d
 * JD-Core Version:    0.7.0.1
 */