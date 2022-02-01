package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.f.b;

public final class a
{
  public int LYH;
  public int LYI;
  
  public a(c paramc)
  {
    AppMethodBeat.i(191842);
    this.LYH = 2;
    this.LYI = 2;
    if (paramc != null)
    {
      f localf = paramc.agV(202);
      long l;
      if ((localf != null) && (localf.LYM == 2))
      {
        l = localf.LYO.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label193;
        }
        i = 1;
        if (i != 0) {
          this.LYI = ((int)localf.LYO.value);
        }
      }
      paramc = paramc.agV(203);
      if ((paramc != null) && (paramc.LYM == 2))
      {
        l = paramc.LYO.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label198;
        }
      }
      label193:
      label198:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          this.LYH = ((int)paramc.LYO.value);
        }
        i = this.LYI;
        j = this.LYH;
        if ((i != 3) || (j != 3)) {
          break label203;
        }
        paramc = new IllegalArgumentException("can not soft with systemplayer");
        AppMethodBeat.o(191842);
        throw paramc;
        i = 0;
        break;
      }
    }
    label203:
    AppMethodBeat.o(191842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */