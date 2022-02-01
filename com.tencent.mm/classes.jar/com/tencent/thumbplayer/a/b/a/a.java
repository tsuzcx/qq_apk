package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.f.b;

public final class a
{
  public int KeL;
  public int KeM;
  
  public a(c paramc)
  {
    AppMethodBeat.i(187821);
    this.KeL = 2;
    this.KeM = 2;
    if (paramc != null)
    {
      f localf = paramc.aev(202);
      long l;
      if ((localf != null) && (localf.KeQ == 2))
      {
        l = localf.KeS.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label193;
        }
        i = 1;
        if (i != 0) {
          this.KeM = ((int)localf.KeS.value);
        }
      }
      paramc = paramc.aev(203);
      if ((paramc != null) && (paramc.KeQ == 2))
      {
        l = paramc.KeS.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label198;
        }
      }
      label193:
      label198:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          this.KeL = ((int)paramc.KeS.value);
        }
        i = this.KeM;
        j = this.KeL;
        if ((i != 3) || (j != 3)) {
          break label203;
        }
        paramc = new IllegalArgumentException("can not soft with systemplayer");
        AppMethodBeat.o(187821);
        throw paramc;
        i = 0;
        break;
      }
    }
    label203:
    AppMethodBeat.o(187821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */