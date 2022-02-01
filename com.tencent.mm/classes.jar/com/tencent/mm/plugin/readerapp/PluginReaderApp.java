package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

public class PluginReaderApp
  extends com.tencent.mm.kernel.b.f
  implements c, a
{
  private com.tencent.mm.am.h NuT;
  
  public PluginReaderApp()
  {
    AppMethodBeat.i(102648);
    this.NuT = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(289234);
        com.tencent.mm.kernel.h.baF();
        if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) != 0)
        {
          PluginReaderApp.access$000(PluginReaderApp.this);
          com.tencent.mm.kernel.h.aZW().b(138, this);
        }
        AppMethodBeat.o(289234);
      }
    };
    AppMethodBeat.o(102648);
  }
  
  static void changeNews(boolean paramBoolean)
  {
    AppMethodBeat.i(289232);
    int i = z.bAU();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.h(26, i));
      AppMethodBeat.o(289232);
      return;
      i |= 0x400;
      break;
    }
  }
  
  private boolean checkInstall()
  {
    AppMethodBeat.i(102656);
    if ((z.bBf() & 0x80000) == 0)
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
    if ((z.bAU() & 0x400) == 0)
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
      com.tencent.mm.plugin.report.service.h.OAn.b(15416, new Object[] { "newsapp", Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWx, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(102654);
      return;
      i = 0;
      break;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102651);
    if (paramg.bbA()) {
      pin(new y(com.tencent.mm.plugin.readerapp.model.d.class));
    }
    AppMethodBeat.o(102651);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(102650);
    dependsOn(v.class);
    AppMethodBeat.o(102650);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(102652);
    if (paramg.bbA()) {
      b.bsa("readerapp");
    }
    AppMethodBeat.o(102652);
  }
  
  public void installed()
  {
    AppMethodBeat.i(102649);
    alias(a.class);
    AppMethodBeat.o(102649);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(102653);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102646);
        long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWx, Long.valueOf(0L))).longValue();
        int i;
        if (System.currentTimeMillis() - l >= 604800000L)
        {
          com.tencent.mm.kernel.h.baF();
          if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) == 0) {
            break label127;
          }
          i = 1;
          if (i == 0) {
            break label132;
          }
          PluginReaderApp.access$000(PluginReaderApp.this);
        }
        for (;;)
        {
          if ((((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu() == z.bBu()) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) {
            PluginReaderApp.this.setInstall(false);
          }
          AppMethodBeat.o(102646);
          return;
          label127:
          i = 0;
          break;
          label132:
          com.tencent.mm.kernel.h.aZW().a(138, PluginReaderApp.this.NuT);
        }
      }
    }, "ReaderAppReport");
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(new com.tencent.mm.plugin.teenmode.a.g()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(289231);
        if ((((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu() == z.bBu()) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) {
          PluginReaderApp.this.setInstall(false);
        }
        AppMethodBeat.o(289231);
      }
    });
    AppMethodBeat.o(102653);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102655);
    com.tencent.mm.kernel.h.aZW().b(138, this.NuT);
    AppMethodBeat.o(102655);
  }
  
  public void setInstall(final boolean paramBoolean)
  {
    AppMethodBeat.i(289242);
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289233);
        Log.i("MicroMsg.PluginReaderApp", "set pluginReaderApp install %b", new Object[] { Boolean.valueOf(paramBoolean) });
        int i = z.bBf();
        edx localedx;
        if (paramBoolean)
        {
          i &= 0xFFF7FFFF;
          com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i));
          localedx = new edx();
          localedx.YBX = 524288;
          if (!paramBoolean) {
            break label142;
          }
        }
        label142:
        for (i = 0;; i = 1)
        {
          localedx.abiW = i;
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(39, localedx));
          if (paramBoolean) {
            break label147;
          }
          com.tencent.mm.plugin.readerapp.model.d.a(null);
          PluginReaderApp.changeNews(false);
          AppMethodBeat.o(289233);
          return;
          i |= 0x80000;
          break;
        }
        label147:
        PluginReaderApp.changeNews(true);
        AppMethodBeat.o(289233);
      }
    }, 5000L);
    AppMethodBeat.o(289242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp
 * JD-Core Version:    0.7.0.1
 */