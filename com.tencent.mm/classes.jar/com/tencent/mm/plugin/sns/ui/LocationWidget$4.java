package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.ab;

final class LocationWidget$4
  implements b.a
{
  LocationWidget$4(LocationWidget paramLocationWidget) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(38288);
    if (!paramBoolean)
    {
      AppMethodBeat.o(38288);
      return true;
    }
    ab.d("MicroMsg.LocationWidget", "get location %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    e locale = e.akz();
    if (paramInt == 0)
    {
      paramBoolean = false;
      if (LocationWidget.h(this.rIm) != null) {
        break label113;
      }
    }
    label113:
    for (boolean bool = false;; bool = LocationWidget.h(this.rIm).fBM)
    {
      locale.a(2003, paramBoolean, bool, paramFloat1, paramFloat2, (int)paramDouble2);
      o.a(2003, paramFloat1, paramFloat2, 0);
      if (LocationWidget.e(this.rIm)) {
        break label128;
      }
      AppMethodBeat.o(38288);
      return false;
      paramBoolean = true;
      break;
    }
    label128:
    if ((LocationWidget.i(this.rIm) == -1000.0F) || (LocationWidget.j(this.rIm) == -1000.0F))
    {
      LocationWidget.a(this.rIm, paramFloat2);
      LocationWidget.b(this.rIm, paramFloat1);
    }
    AppMethodBeat.o(38288);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.4
 * JD-Core Version:    0.7.0.1
 */