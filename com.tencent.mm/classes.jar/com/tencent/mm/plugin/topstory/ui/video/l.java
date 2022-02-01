package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tinkerboots.sdk.b.a;

public final class l
{
  public boolean AdF;
  com.tencent.mm.plugin.topstory.a.c AdG;
  private n.a onL;
  public int xlf;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.onL = new n.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.xlf;
        l.this.xlf = l.dPZ();
        if (l.this.xlf != paramAnonymousInt)
        {
          ac.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.xlf) });
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.AdG != null) {
                l.this.AdG.hT(paramAnonymousInt, l.this.xlf);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.AdF = false;
    this.xlf = dPZ();
    g.agQ().a(this.onL);
    AppMethodBeat.o(126108);
  }
  
  public static int dPZ()
  {
    AppMethodBeat.i(126110);
    if (!a.isConnected(ai.getContext()))
    {
      AppMethodBeat.o(126110);
      return 0;
    }
    if (a.isWifi(ai.getContext()))
    {
      if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().Aac)
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
  
  public final boolean ccN()
  {
    return this.xlf == 1;
  }
  
  public final boolean eeb()
  {
    return this.xlf == 2;
  }
  
  public final boolean isConnected()
  {
    return this.xlf != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    g.agQ().b(this.onL);
    this.AdG = null;
    this.xlf = 0;
    this.AdF = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */