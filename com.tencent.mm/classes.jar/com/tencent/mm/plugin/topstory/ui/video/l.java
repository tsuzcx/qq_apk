package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tinkerboots.sdk.b.a;

public final class l
{
  public int CTg;
  public boolean Gnu;
  c Gnv;
  private p.a qmF;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.qmF = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.CTg;
        l.this.CTg = l.fiw();
        if (l.this.CTg != paramAnonymousInt)
        {
          Log.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.CTg) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.Gnv != null) {
                l.this.Gnv.jm(paramAnonymousInt, l.this.CTg);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.Gnu = false;
    this.CTg = fiw();
    g.aAg().a(this.qmF);
    AppMethodBeat.o(126108);
  }
  
  public static int fiw()
  {
    AppMethodBeat.i(126110);
    if (!a.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(126110);
      return 0;
    }
    if (a.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(126110);
      return 1;
    }
    AppMethodBeat.o(126110);
    return 2;
  }
  
  public final boolean cGF()
  {
    return this.CTg == 1;
  }
  
  public final boolean fzw()
  {
    return this.CTg == 2;
  }
  
  public final boolean isConnected()
  {
    return this.CTg != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    g.aAg().b(this.qmF);
    this.Gnv = null;
    this.CTg = 0;
    this.Gnu = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */