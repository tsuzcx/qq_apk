package com.tencent.mm.plugin.radar;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/RadarApplication;", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "()V", "regitMMModelCallback", "", "callback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "regitMMUICallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "Companion", "plugin-radar_release"})
public final class a
  implements o
{
  private static n gmO;
  private static m gmP;
  public static final a.a pPE;
  
  static
  {
    AppMethodBeat.i(102851);
    pPE = new a.a((byte)0);
    AppMethodBeat.o(102851);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(102850);
    j.q(paramm, "callback");
    gmP = paramm;
    AppMethodBeat.o(102850);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(102849);
    j.q(paramn, "callback");
    gmO = paramn;
    AppMethodBeat.o(102849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.a
 * JD-Core Version:    0.7.0.1
 */