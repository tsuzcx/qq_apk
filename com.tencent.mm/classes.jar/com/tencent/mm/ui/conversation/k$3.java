package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$3
  implements Runnable
{
  k$3(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(34575);
    if (this.AlJ.AlF)
    {
      AppMethodBeat.o(34575);
      return;
    }
    int m = this.AlJ.AgN.getLastVisiblePosition();
    int j = this.AlJ.AgN.getFirstVisiblePosition();
    int k = m - j;
    if (j == this.AlJ.AlI)
    {
      AppMethodBeat.o(34575);
      return;
    }
    this.AlJ.AlI = j;
    ab.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    for (int i = m + 1;; i = j - 1) {
      try
      {
        while ((i < this.AlJ.Ahr.getCount()) && (i < k * 1 + m))
        {
          this.AlJ.Ahr.QC(i);
          i += 1;
          continue;
          while ((i >= 0) && (i > j - k * 1))
          {
            this.AlJ.Ahr.QC(i);
            i -= 1;
          }
          AppMethodBeat.o(34575);
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        ab.printErrStackTrace("MicroMsg.PreLoadHelper", localRuntimeException, "Failed to preload MainUI avatars", new Object[0]);
        AppMethodBeat.o(34575);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.3
 * JD-Core Version:    0.7.0.1
 */