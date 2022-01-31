package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$9
  implements am.a
{
  e$9(e parame) {}
  
  public final boolean tC()
  {
    y.d("NoteSelectManager", "onTimerExpired: ");
    RecyclerView localRecyclerView = e.a(this.rKn);
    int i;
    int j;
    if ((e.c(this.rKn) != null) && (e.c(this.rKn).rJu < e.a(this.rKn, localRecyclerView)))
    {
      i = 1;
      if ((e.c(this.rKn) == null) || (e.c(this.rKn).rJu <= e.d(this.rKn))) {
        break label195;
      }
      j = 1;
      label84:
      if ((!e.ciX()) || (localRecyclerView == null) || (e.c(this.rKn) == null) || (e.c(this.rKn).getType() != 1) || ((i == 0) && (j == 0))) {
        break label243;
      }
      if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
        break label200;
      }
      if (e.c(this.rKn).ivk == 3) {
        e.e(this.rKn);
      }
      e.f(this.rKn);
      this.rKn.ciR();
      this.rKn.ciP();
      localRecyclerView.smoothScrollBy(0, -300);
    }
    label195:
    label200:
    label243:
    while (e.g(this.rKn) == null)
    {
      do
      {
        return true;
        i = 0;
        break;
        j = 0;
        break label84;
      } while ((j == 0) || (!localRecyclerView.canScrollVertically(1)));
      e.f(this.rKn);
      this.rKn.ciR();
      this.rKn.ciP();
      localRecyclerView.smoothScrollBy(0, 300);
      return true;
    }
    e.g(this.rKn).stopTimer();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.9
 * JD-Core Version:    0.7.0.1
 */