package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.f.c;

final class h$5
  implements f.c
{
  h$5(String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(184259);
    h.CyF.a(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.LS, this.JVX, this.JVY });
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(this.JVZ)) {
      h.CyF.a(15413, new Object[] { Integer.valueOf(2), "", "" });
    }
    this.val$run.run();
    AppMethodBeat.o(184259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h.5
 * JD-Core Version:    0.7.0.1
 */