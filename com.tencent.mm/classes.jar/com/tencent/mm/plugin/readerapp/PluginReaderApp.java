package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class PluginReaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private com.tencent.mm.al.f xlW;
  
  public PluginReaderApp()
  {
    AppMethodBeat.i(102648);
    this.xlW = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(102647);
        com.tencent.mm.kernel.g.ajD();
        if (bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(15, null)) != 0)
        {
          PluginReaderApp.access$000(PluginReaderApp.this);
          com.tencent.mm.kernel.g.aiU().b(138, this);
        }
        AppMethodBeat.o(102647);
      }
    };
    AppMethodBeat.o(102648);
  }
  
  private boolean checkInstall()
  {
    AppMethodBeat.i(102656);
    if ((u.aAy() & 0x80000) == 0)
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
    if ((u.aAs() & 0x400) == 0)
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
      com.tencent.mm.plugin.report.service.g.yhR.f(15416, new Object[] { "newsapp", Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDB, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(102654);
      return;
      i = 0;
      break;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102651);
    if (paramg.akw()) {
      pin(new t(com.tencent.mm.plugin.readerapp.c.g.class));
    }
    AppMethodBeat.o(102651);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(102650);
    dependsOn(r.class);
    AppMethodBeat.o(102650);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102652);
    if (paramg.akw()) {
      com.tencent.mm.bs.c.aNQ("readerapp");
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
        long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDB, Long.valueOf(0L))).longValue();
        if (System.currentTimeMillis() - l >= 604800000L)
        {
          com.tencent.mm.kernel.g.ajD();
          if (bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(15, null)) != 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            PluginReaderApp.access$000(PluginReaderApp.this);
            AppMethodBeat.o(102646);
            return;
          }
          com.tencent.mm.kernel.g.aiU().a(138, PluginReaderApp.this.xlW);
        }
        AppMethodBeat.o(102646);
      }
    }, "ReaderAppReport");
    AppMethodBeat.o(102653);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102655);
    com.tencent.mm.kernel.g.aiU().b(138, this.xlW);
    AppMethodBeat.o(102655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp
 * JD-Core Version:    0.7.0.1
 */