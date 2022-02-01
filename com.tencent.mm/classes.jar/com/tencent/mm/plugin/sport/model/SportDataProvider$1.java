package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.PluginSport;

final class SportDataProvider$1
  implements Runnable
{
  SportDataProvider$1(SportDataProvider paramSportDataProvider, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(224441);
    ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().b(this.JhN, this.JhO, "MM");
    AppMethodBeat.o(224441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportDataProvider.1
 * JD-Core Version:    0.7.0.1
 */