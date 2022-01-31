package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
final class e$i
  implements b.a
{
  e$i(e parame) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(102920);
    if (e.a(this.pQV))
    {
      ab.d(e.access$getTAG$cp(), "cancel location");
      AppMethodBeat.o(102920);
      return false;
    }
    if (e.c(this.pQV) != null)
    {
      AppMethodBeat.o(102920);
      return false;
    }
    e locale;
    if (paramBoolean)
    {
      locale = this.pQV;
      e.c(this.pQV);
      e.a(locale, true);
      o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
      ab.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
      e.a(this.pQV, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
      e.e(this.pQV).nP(0L);
    }
    for (;;)
    {
      AppMethodBeat.o(102920);
      return false;
      locale = this.pQV;
      e.c(this.pQV);
      e.a(locale, false);
      e.f(this.pQV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.i
 * JD-Core Version:    0.7.0.1
 */