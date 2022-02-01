package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class PluginReaderApp
  extends f
  implements c, a
{
  private i BBT;
  
  public PluginReaderApp()
  {
    AppMethodBeat.i(102648);
    this.BBT = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(102647);
        com.tencent.mm.kernel.g.aAi();
        if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(15, null)) != 0)
        {
          PluginReaderApp.access$000(PluginReaderApp.this);
          com.tencent.mm.kernel.g.azz().b(138, this);
        }
        AppMethodBeat.o(102647);
      }
    };
    AppMethodBeat.o(102648);
  }
  
  private boolean checkInstall()
  {
    AppMethodBeat.i(102656);
    if ((z.aUl() & 0x80000) == 0)
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
    if ((z.aUe() & 0x400) == 0)
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
      h.CyF.a(15416, new Object[] { "newsapp", Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogy, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(102654);
      return;
      i = 0;
      break;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102651);
    if (paramg.aBb()) {
      pin(new y(com.tencent.mm.plugin.readerapp.c.g.class));
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
    if (paramg.aBb()) {
      b.bfQ("readerapp");
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
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102646);
        long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogy, Long.valueOf(0L))).longValue();
        if (System.currentTimeMillis() - l >= 604800000L)
        {
          com.tencent.mm.kernel.g.aAi();
          if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(15, null)) != 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            PluginReaderApp.access$000(PluginReaderApp.this);
            AppMethodBeat.o(102646);
            return;
          }
          com.tencent.mm.kernel.g.azz().a(138, PluginReaderApp.this.BBT);
        }
        AppMethodBeat.o(102646);
      }
    }, "ReaderAppReport");
    AppMethodBeat.o(102653);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102655);
    com.tencent.mm.kernel.g.azz().b(138, this.BBT);
    AppMethodBeat.o(102655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp
 * JD-Core Version:    0.7.0.1
 */