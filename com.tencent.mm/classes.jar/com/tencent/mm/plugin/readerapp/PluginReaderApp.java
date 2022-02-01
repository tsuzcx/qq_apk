package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public class PluginReaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private com.tencent.mm.ak.f xBT;
  
  public PluginReaderApp()
  {
    AppMethodBeat.i(102648);
    this.xBT = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(102647);
        com.tencent.mm.kernel.g.ajS();
        if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(15, null)) != 0)
        {
          PluginReaderApp.access$000(PluginReaderApp.this);
          com.tencent.mm.kernel.g.ajj().b(138, this);
        }
        AppMethodBeat.o(102647);
      }
    };
    AppMethodBeat.o(102648);
  }
  
  private boolean checkInstall()
  {
    AppMethodBeat.i(102656);
    if ((v.aAO() & 0x80000) == 0)
    {
      AppMethodBeat.o(102656);
      return true;
    }
    AppMethodBeat.o(102656);
    return false;
  }
  
  private boolean checkRecvNews()
  {
    AppMethodBeat.i(102657);
    if ((v.aAI() & 0x400) == 0)
    {
      AppMethodBeat.o(102657);
      return true;
    }
    AppMethodBeat.o(102657);
    return false;
  }
  
  private void reportPluginStatus()
  {
    AppMethodBeat.i(102654);
    int i;
    if (checkInstall())
    {
      i = 1;
      if (!checkRecvNews()) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(15416, new Object[] { "newsapp", Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYb, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(102654);
      return;
      i = 0;
      break;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102651);
    if (paramg.akL()) {
      pin(new u(com.tencent.mm.plugin.readerapp.c.g.class));
    }
    AppMethodBeat.o(102651);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(102650);
    dependsOn(s.class);
    AppMethodBeat.o(102650);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102652);
    if (paramg.akL()) {
      com.tencent.mm.br.c.aPn("readerapp");
    }
    AppMethodBeat.o(102652);
  }
  
  public void installed()
  {
    AppMethodBeat.i(102649);
    alias(a.class);
    AppMethodBeat.o(102649);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(102653);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102646);
        long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYb, Long.valueOf(0L))).longValue();
        if (System.currentTimeMillis() - l >= 604800000L)
        {
          com.tencent.mm.kernel.g.ajS();
          if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(15, null)) != 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            PluginReaderApp.access$000(PluginReaderApp.this);
            AppMethodBeat.o(102646);
            return;
          }
          com.tencent.mm.kernel.g.ajj().a(138, PluginReaderApp.this.xBT);
        }
        AppMethodBeat.o(102646);
      }
    }, "ReaderAppReport");
    AppMethodBeat.o(102653);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102655);
    com.tencent.mm.kernel.g.ajj().b(138, this.xBT);
    AppMethodBeat.o(102655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp
 * JD-Core Version:    0.7.0.1
 */