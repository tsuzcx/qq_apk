package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(27074);
    c.a(this.GZh, 4);
    if (c.f(this.GZh).getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      com.tencent.mm.by.c.b(c.f(this.GZh), "shake", ".ui.ShakeReportUI", localIntent);
    }
    AppMethodBeat.o(27074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.3
 * JD-Core Version:    0.7.0.1
 */