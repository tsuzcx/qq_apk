package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class PluginReaderApp$2
  implements f
{
  PluginReaderApp$2(PluginReaderApp paramPluginReaderApp) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    if (bk.g((Integer)g.DP().Dz().get(15, null)) != 0)
    {
      PluginReaderApp.access$000(this.nor);
      g.Dk().b(138, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp.2
 * JD-Core Version:    0.7.0.1
 */