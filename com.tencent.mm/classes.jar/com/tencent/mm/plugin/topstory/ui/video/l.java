package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tinkerboots.sdk.b.a;

public final class l
{
  public int PhY;
  public boolean TMQ;
  com.tencent.mm.plugin.topstory.a.c TMR;
  private p.a wOL;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.wOL = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.PhY;
        l.this.PhY = l.hoZ();
        if (l.this.PhY != paramAnonymousInt)
        {
          Log.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.PhY) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.TMR != null) {
                l.this.TMR.mm(paramAnonymousInt, l.this.PhY);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.TMQ = false;
    this.PhY = hoZ();
    h.baD().a(this.wOL);
    AppMethodBeat.o(126108);
  }
  
  public static int hoZ()
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
  
  public final boolean fvi()
  {
    return this.PhY == 1;
  }
  
  public final boolean hOx()
  {
    return this.PhY == 2;
  }
  
  public final boolean isConnected()
  {
    return this.PhY != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    h.baD().b(this.wOL);
    this.TMR = null;
    this.PhY = 0;
    this.TMQ = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */