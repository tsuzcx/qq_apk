package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.widget.a.f.c;

final class h$4
  implements f.c
{
  h$4(String paramString1, String paramString2, String paramString3, String paramString4, al paramal) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151682);
    g.yxI.f(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), this.LI, this.Ffg, this.Ffh });
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(this.Ffi)) {
      g.yxI.f(15413, new Object[] { Integer.valueOf(3), "", "" });
    }
    if (this.puq != null) {
      this.puq.v(false, true);
    }
    AppMethodBeat.o(151682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h.4
 * JD-Core Version:    0.7.0.1
 */