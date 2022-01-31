package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$9
  implements ap.a
{
  e$9(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26866);
    ab.d("NoteSelectManager", "onTimerExpired: ");
    RecyclerView localRecyclerView = e.a(this.vAR);
    int i;
    int j;
    if ((e.c(this.vAR) != null) && (e.c(this.vAR).vzY < e.a(this.vAR, localRecyclerView)))
    {
      i = 1;
      if ((e.c(this.vAR) == null) || (e.c(this.vAR).vzY <= e.d(this.vAR))) {
        break label208;
      }
      j = 1;
      label90:
      if ((!e.djy()) || (localRecyclerView == null) || (e.c(this.vAR) == null) || (e.c(this.vAR).getType() != 1) || ((i == 0) && (j == 0))) {
        break label258;
      }
      if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
        break label213;
      }
      if (e.c(this.vAR).kwo == 3) {
        e.e(this.vAR);
      }
      e.f(this.vAR);
      this.vAR.djk();
      this.vAR.dji();
      localRecyclerView.a(0, -300, null);
    }
    label258:
    for (;;)
    {
      AppMethodBeat.o(26866);
      return true;
      i = 0;
      break;
      label208:
      j = 0;
      break label90;
      label213:
      if ((j != 0) && (localRecyclerView.canScrollVertically(1)))
      {
        e.f(this.vAR);
        this.vAR.djk();
        this.vAR.dji();
        localRecyclerView.a(0, 300, null);
        continue;
        if (e.g(this.vAR) != null) {
          e.g(this.vAR).stopTimer();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.9
 * JD-Core Version:    0.7.0.1
 */