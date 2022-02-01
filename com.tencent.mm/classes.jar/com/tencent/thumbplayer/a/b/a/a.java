package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.f.b;

public final class a
{
  public int MvC;
  public int MvD;
  
  public a(c paramc)
  {
    AppMethodBeat.i(194520);
    this.MvC = 2;
    this.MvD = 2;
    if (paramc != null)
    {
      f localf = paramc.ahE(202);
      long l;
      if ((localf != null) && (localf.MvH == 2))
      {
        l = localf.MvJ.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label193;
        }
        i = 1;
        if (i != 0) {
          this.MvD = ((int)localf.MvJ.value);
        }
      }
      paramc = paramc.ahE(203);
      if ((paramc != null) && (paramc.MvH == 2))
      {
        l = paramc.MvJ.value;
        if ((l <= 0L) || (l >= 5L)) {
          break label198;
        }
      }
      label193:
      label198:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          this.MvC = ((int)paramc.MvJ.value);
        }
        i = this.MvD;
        j = this.MvC;
        if ((i != 3) || (j != 3)) {
          break label203;
        }
        paramc = new IllegalArgumentException("can not soft with systemplayer");
        AppMethodBeat.o(194520);
        throw paramc;
        i = 0;
        break;
      }
    }
    label203:
    AppMethodBeat.o(194520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */