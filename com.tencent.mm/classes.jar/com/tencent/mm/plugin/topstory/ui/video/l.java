package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tinkerboots.sdk.b.a;

public final class l
{
  private n.a iAF = new l.1(this);
  public boolean pFL = false;
  com.tencent.mm.plugin.topstory.a.c pFM;
  public int pFN = bOn();
  
  public l()
  {
    g.DO().a(this.iAF);
  }
  
  public static int bOn()
  {
    if (!a.isConnected(ae.getContext())) {
      return 0;
    }
    if (a.isWifi(ae.getContext()))
    {
      if (((PluginTopStoryUI)g.t(PluginTopStoryUI.class)).getTopStoryCommand().pDH) {
        return 2;
      }
      return 1;
    }
    return 2;
  }
  
  public final boolean aIq()
  {
    return this.pFN == 1;
  }
  
  public final void akT()
  {
    g.DO().b(this.iAF);
    this.pFM = null;
    this.pFN = 0;
    this.pFL = false;
  }
  
  public final boolean bOm()
  {
    return this.pFN == 2;
  }
  
  public final boolean isConnected()
  {
    return this.pFN != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */