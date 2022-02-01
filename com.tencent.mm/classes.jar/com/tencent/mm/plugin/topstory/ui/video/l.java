package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tinkerboots.sdk.b.a;

public final class l
{
  private n.a nKL;
  public int vZZ;
  public boolean yPO;
  com.tencent.mm.plugin.topstory.a.c yPP;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.nKL = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.vZZ;
        l.this.vZZ = l.dBC();
        if (l.this.vZZ != paramAnonymousInt)
        {
          ad.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.vZZ) });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.yPP != null) {
                l.this.yPP.hJ(paramAnonymousInt, l.this.vZZ);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.yPO = false;
    this.vZZ = dBC();
    g.afA().a(this.nKL);
    AppMethodBeat.o(126108);
  }
  
  public static int dBC()
  {
    AppMethodBeat.i(126110);
    if (!a.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(126110);
      return 0;
    }
    if (a.isWifi(aj.getContext()))
    {
      if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().yMk)
      {
        AppMethodBeat.o(126110);
        return 2;
      }
      AppMethodBeat.o(126110);
      return 1;
    }
    AppMethodBeat.o(126110);
    return 2;
  }
  
  public final boolean bVA()
  {
    return this.vZZ == 1;
  }
  
  public final boolean dPC()
  {
    return this.vZZ == 2;
  }
  
  public final boolean isConnected()
  {
    return this.vZZ != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    g.afA().b(this.nKL);
    this.yPP = null;
    this.vZZ = 0;
    this.yPO = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */