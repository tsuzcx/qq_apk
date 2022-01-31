package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class PluginReaderApp$1
  implements Runnable
{
  PluginReaderApp$1(PluginReaderApp paramPluginReaderApp) {}
  
  public final void run()
  {
    AppMethodBeat.i(76739);
    long l = ((Long)g.RL().Ru().get(ac.a.yJZ, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l >= 604800000L)
    {
      g.RM();
      if (bo.g((Integer)g.RL().Ru().get(15, null)) != 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        PluginReaderApp.access$000(this.pTF);
        AppMethodBeat.o(76739);
        return;
      }
      g.Rc().a(138, PluginReaderApp.access$100(this.pTF));
    }
    AppMethodBeat.o(76739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp.1
 * JD-Core Version:    0.7.0.1
 */