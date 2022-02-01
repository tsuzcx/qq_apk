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
  public boolean Bvq;
  com.tencent.mm.plugin.topstory.a.c Bvr;
  private n.a oRg;
  public int yzh;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.oRg = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.yzh;
        l.this.yzh = l.ecp();
        if (l.this.yzh != paramAnonymousInt)
        {
          ad.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.yzh) });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.Bvr != null) {
                l.this.Bvr.ij(paramAnonymousInt, l.this.yzh);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.Bvq = false;
    this.yzh = ecp();
    g.ajB().a(this.oRg);
    AppMethodBeat.o(126108);
  }
  
  public static int ecp()
  {
    AppMethodBeat.i(126110);
    if (!a.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(126110);
      return 0;
    }
    if (a.isWifi(aj.getContext()))
    {
      if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().BrO)
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
  
  public final boolean chr()
  {
    return this.yzh == 1;
  }
  
  public final boolean eqt()
  {
    return this.yzh == 2;
  }
  
  public final boolean isConnected()
  {
    return this.yzh != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    g.ajB().b(this.oRg);
    this.Bvr = null;
    this.yzh = 0;
    this.Bvq = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */