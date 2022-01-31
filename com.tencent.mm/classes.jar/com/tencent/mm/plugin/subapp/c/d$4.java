package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class d$4
  extends j.a
{
  d$4(d paramd)
  {
    AppMethodBeat.i(25263);
    AppMethodBeat.o(25263);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(153664);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      a.QP();
    }
    AppMethodBeat.o(153664);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(153663);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!a.QP()) {
        b.HP().o(new d.4.1(this));
      }
    }
    AppMethodBeat.o(153663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.d.4
 * JD-Core Version:    0.7.0.1
 */