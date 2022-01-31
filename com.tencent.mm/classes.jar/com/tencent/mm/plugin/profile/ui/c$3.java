package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(23459);
    this.pzT.aV(4, null);
    if (this.pzT.cmc.getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this.pzT.cmc, "shake", ".ui.ShakeReportUI", localIntent);
    }
    AppMethodBeat.o(23459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.3
 * JD-Core Version:    0.7.0.1
 */