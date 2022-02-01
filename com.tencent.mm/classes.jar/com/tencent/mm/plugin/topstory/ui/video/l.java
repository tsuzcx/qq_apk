package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tinkerboots.sdk.b.a;

public final class l
{
  public boolean BMO;
  com.tencent.mm.plugin.topstory.a.c BMP;
  private n.a oXI;
  public int yPh;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.oXI = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.yPh;
        l.this.yPh = l.efW();
        if (l.this.yPh != paramAnonymousInt)
        {
          ae.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.yPh) });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.BMP != null) {
                l.this.BMP.im(paramAnonymousInt, l.this.yPh);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.BMO = false;
    this.yPh = efW();
    g.ajQ().a(this.oXI);
    AppMethodBeat.o(126108);
  }
  
  public static int efW()
  {
    AppMethodBeat.i(126110);
    if (!a.isConnected(ak.getContext()))
    {
      AppMethodBeat.o(126110);
      return 0;
    }
    if (a.isWifi(ak.getContext()))
    {
      if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().BJn)
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
  
  public final boolean ciH()
  {
    return this.yPh == 1;
  }
  
  public final boolean eua()
  {
    return this.yPh == 2;
  }
  
  public final boolean isConnected()
  {
    return this.yPh != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    g.ajQ().b(this.oXI);
    this.BMP = null;
    this.yPh = 0;
    this.BMO = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */