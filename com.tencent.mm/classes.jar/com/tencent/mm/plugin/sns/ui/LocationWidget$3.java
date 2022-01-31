package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LocationWidget$3
  implements c.a
{
  LocationWidget$3(LocationWidget paramLocationWidget) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(38287);
    ab.i("MicroMsg.LocationWidget", "get info %s", new Object[] { paramAddr.toString() });
    if (!LocationWidget.e(this.rIm))
    {
      AppMethodBeat.o(38287);
      return;
    }
    LocationWidget.f(this.rIm);
    if (!bo.isNullOrNil(LocationWidget.g(this.rIm)))
    {
      AppMethodBeat.o(38287);
      return;
    }
    LocationWidget.a(this.rIm, paramAddr.fBs);
    LocationWidget.f(this.rIm);
    AppMethodBeat.o(38287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.3
 * JD-Core Version:    0.7.0.1
 */