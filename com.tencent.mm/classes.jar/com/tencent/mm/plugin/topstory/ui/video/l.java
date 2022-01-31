package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tinkerboots.sdk.b.a;

public final class l
{
  private n.a kDL;
  public int qCf;
  public boolean tjk;
  com.tencent.mm.plugin.topstory.a.c tjl;
  
  public l()
  {
    AppMethodBeat.i(1743);
    this.kDL = new l.1(this);
    this.tjk = false;
    this.qCf = cvE();
    g.RK().a(this.kDL);
    AppMethodBeat.o(1743);
  }
  
  public static int cvE()
  {
    AppMethodBeat.i(1745);
    if (!a.isConnected(ah.getContext()))
    {
      AppMethodBeat.o(1745);
      return 0;
    }
    if (a.isWifi(ah.getContext()))
    {
      if (((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getTopStoryCommand().tfB)
      {
        AppMethodBeat.o(1745);
        return 2;
      }
      AppMethodBeat.o(1745);
      return 1;
    }
    AppMethodBeat.o(1745);
    return 2;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1744);
    g.RK().b(this.kDL);
    this.tjl = null;
    this.qCf = 0;
    this.tjk = false;
    AppMethodBeat.o(1744);
  }
  
  public final boolean blP()
  {
    return this.qCf == 1;
  }
  
  public final boolean cJZ()
  {
    return this.qCf == 2;
  }
  
  public final boolean isConnected()
  {
    return this.qCf != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */