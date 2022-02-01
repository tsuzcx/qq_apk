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
  public int IYy;
  public boolean Nah;
  com.tencent.mm.plugin.topstory.a.c Nai;
  private p.a tLw;
  
  public l()
  {
    AppMethodBeat.i(126108);
    this.tLw = new p.a()
    {
      public final void onNetworkChange(final int paramAnonymousInt)
      {
        AppMethodBeat.i(126107);
        paramAnonymousInt = l.this.IYy;
        l.this.IYy = l.fWI();
        if (l.this.IYy != paramAnonymousInt)
        {
          Log.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(l.this.IYy) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126106);
              if (l.this.Nai != null) {
                l.this.Nai.ky(paramAnonymousInt, l.this.IYy);
              }
              AppMethodBeat.o(126106);
            }
          });
        }
        AppMethodBeat.o(126107);
      }
    };
    this.Nah = false;
    this.IYy = fWI();
    h.aHF().a(this.tLw);
    AppMethodBeat.o(126108);
  }
  
  public static int fWI()
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
  
  public final boolean eqb()
  {
    return this.IYy == 1;
  }
  
  public final boolean grx()
  {
    return this.IYy == 2;
  }
  
  public final boolean isConnected()
  {
    return this.IYy != 0;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126109);
    h.aHF().b(this.tLw);
    this.Nai = null;
    this.IYy = 0;
    this.Nah = false;
    AppMethodBeat.o(126109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l
 * JD-Core Version:    0.7.0.1
 */