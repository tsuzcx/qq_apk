package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.kernel.g;

final class f$7
  extends j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(153553);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new ge();
        paramString.cuI.isActive = false;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(153553);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(153552);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new ge();
        paramString.cuI.isActive = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(153552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f.7
 * JD-Core Version:    0.7.0.1
 */