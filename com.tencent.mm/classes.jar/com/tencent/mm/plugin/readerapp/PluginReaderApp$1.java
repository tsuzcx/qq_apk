package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class PluginReaderApp$1
  implements Runnable
{
  PluginReaderApp$1(PluginReaderApp paramPluginReaderApp) {}
  
  public final void run()
  {
    long l = ((Long)g.DP().Dz().get(ac.a.uzl, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l >= 604800000L)
    {
      g.DQ();
      if (bk.g((Integer)g.DP().Dz().get(15, null)) == 0) {
        break label74;
      }
    }
    label74:
    for (int i = 1; i != 0; i = 0)
    {
      PluginReaderApp.access$000(this.nor);
      return;
    }
    g.Dk().a(138, PluginReaderApp.access$100(this.nor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp.1
 * JD-Core Version:    0.7.0.1
 */