package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class al$4
  extends j.a
{
  al$4(al paramal)
  {
    AppMethodBeat.i(27414);
    AppMethodBeat.o(27414);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(153693);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      a.QP();
    }
    AppMethodBeat.o(153693);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(153692);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        b.HP().o(new al.4.1(this));
      }
    }
    AppMethodBeat.o(153692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.4
 * JD-Core Version:    0.7.0.1
 */