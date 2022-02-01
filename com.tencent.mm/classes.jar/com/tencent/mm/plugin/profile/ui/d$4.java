package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.MMActivity;

final class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(305649);
    d.a(this.MXk, 4);
    if (d.g(this.MXk).getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      c.b(d.g(this.MXk), "shake", ".ui.ShakeReportUI", localIntent);
    }
    AppMethodBeat.o(305649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d.4
 * JD-Core Version:    0.7.0.1
 */