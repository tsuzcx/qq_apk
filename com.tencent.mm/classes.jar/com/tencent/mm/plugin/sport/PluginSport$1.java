package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.c;
import com.tencent.mm.plugin.sport.model.h.a;

final class PluginSport$1
  implements h.a
{
  PluginSport$1(PluginSport paramPluginSport) {}
  
  public final void ye()
  {
    AppMethodBeat.i(93605);
    a locala = this.spg.getDeviceStepManager();
    if (locala.spl != null) {
      locala.spl.cyF();
    }
    AppMethodBeat.o(93605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport.1
 * JD-Core Version:    0.7.0.1
 */