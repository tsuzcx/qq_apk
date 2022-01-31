package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
 enum e$f
{
  static
  {
    AppMethodBeat.i(102914);
    f localf1 = new f("Stopped", 0);
    pQQ = localf1;
    f localf2 = new f("Locating", 1);
    pQR = localf2;
    f localf3 = new f("RadarSearching", 2);
    pQS = localf3;
    f localf4 = new f("Waiting", 3);
    pQT = localf4;
    pQU = new f[] { localf1, localf2, localf3, localf4 };
    AppMethodBeat.o(102914);
  }
  
  private e$f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.f
 * JD-Core Version:    0.7.0.1
 */