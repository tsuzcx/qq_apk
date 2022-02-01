package com.tencent.mm.ui.n.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.plugin.emoji.e.h.b;
import com.tencent.mm.plugin.emoji.magicemoji.b.a.a;
import com.tencent.mm.plugin.emoji.magicemoji.b.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.vending.g.d.a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public enum b
  implements com.tencent.mm.api.v
{
  private a.b XJb;
  private final Map<String, a> XJc;
  private int XJd;
  
  static
  {
    AppMethodBeat.i(286052);
    XJa = new b("INSTANCE");
    XJe = new b[] { XJa };
    AppMethodBeat.o(286052);
  }
  
  private b()
  {
    AppMethodBeat.i(286026);
    this.XJb = null;
    this.XJc = new HashMap(1);
    this.XJd = 0;
    AppMethodBeat.o(286026);
  }
  
  private static void aU(Runnable paramRunnable)
  {
    AppMethodBeat.i(286035);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(286035);
      return;
    }
    com.tencent.e.h.ZvG.bc(paramRunnable);
    AppMethodBeat.o(286035);
  }
  
  private void b(a.b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(286042);
        if ((this.XJb == null) || (this.XJb != paramb)) {}
        switch (6.XJi[paramb.ordinal()])
        {
        case 1: 
          com.tencent.mm.plugin.report.service.h.IzE.el(1619, 6);
          this.XJb = paramb;
          AppMethodBeat.o(286042);
          return;
        }
      }
      finally {}
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 0);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 1);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 2);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 3);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 4);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 5);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 7);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.el(1619, 8);
    }
  }
  
  private void chi()
  {
    AppMethodBeat.i(286033);
    String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.appId;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: appid invalid");
      AppMethodBeat.o(286033);
      return;
    }
    final a locala = (a)this.XJc.get(str);
    if (locala == null)
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: item not event loaded");
      AppMethodBeat.o(286033);
      return;
    }
    this.XJc.remove(str);
    aU(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287132);
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: destroy imp in ui thread");
        synchronized (b.this)
        {
          if (locala.XJs != null)
          {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has serviceLoadTask, trigger terminate");
            locala.XJs.stop();
            locala.XJs = null;
          }
          if (locala.XJt != null)
          {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtimeLoadTask, trigger terminate");
            locala.XJt.stop();
            locala.XJt = null;
          }
          if (locala.XJr == null) {
            break label249;
          }
          Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtime, trigger destroy");
          e locale = locala.XJr;
          if (!locale.mIsRunning) {
            break label228;
          }
          Log.i("MicroMsg.MagicEmojiRuntime", "hy: destroying runtime");
          try
          {
            ConcurrentLinkedDeque localConcurrentLinkedDeque = new ConcurrentLinkedDeque(locale.XJM);
            while (!localConcurrentLinkedDeque.isEmpty())
            {
              ((e.a)Objects.requireNonNull(localConcurrentLinkedDeque.poll())).onDestroy();
              continue;
              localObject1 = finally;
            }
          }
          finally
          {
            AppMethodBeat.o(287132);
          }
        }
        localObject1.XJM.clear();
        localObject1.hXp();
        e.a(localObject1.XJJ);
        e.a(localObject1.XJI);
        localObject1.XJJ = null;
        localObject1.XJI = null;
        label228:
        localObject1.mIsRunning = false;
        locala.XJr = null;
        for (;;)
        {
          AppMethodBeat.o(287132);
          return;
          label249:
          if (locala.XJq != null)
          {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has service, trigger destroy");
            locala.XJq.notifyDestroy();
            locala.XJq = null;
          }
        }
      }
    });
    AppMethodBeat.o(286033);
  }
  
  /* Error */
  private com.tencent.mm.vending.g.c<g> hXj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 265
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 228	com/tencent/mm/plugin/emoji/magicemoji/b/a:uBq	Lcom/tencent/mm/plugin/emoji/magicemoji/b/a$a;
    //   11: getfield 234	com/tencent/mm/plugin/emoji/magicemoji/b/a$a:appId	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 269	com/tencent/mm/ui/n/a/b:bAt	(Ljava/lang/String;)Lcom/tencent/mm/ui/n/a/b$a;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 273	com/tencent/mm/ui/n/a/b$a:XJq	Lcom/tencent/mm/ui/n/a/g;
    //   25: ifnull +45 -> 70
    //   28: ldc 111
    //   30: ldc_w 275
    //   33: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_2
    //   37: getfield 273	com/tencent/mm/ui/n/a/b$a:XJq	Lcom/tencent/mm/ui/n/a/g;
    //   40: invokestatic 281	com/tencent/mm/cw/g:eE	(Ljava/lang/Object;)Lcom/tencent/mm/cw/f;
    //   43: new 35	com/tencent/mm/ui/n/a/b$7
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 283	com/tencent/mm/ui/n/a/b$7:<init>	(Lcom/tencent/mm/ui/n/a/b;)V
    //   51: invokevirtual 289	com/tencent/mm/cw/f:h	(Lcom/tencent/mm/vending/c/a;)Lcom/tencent/mm/cw/f;
    //   54: astore_1
    //   55: aload_2
    //   56: aload_1
    //   57: putfield 293	com/tencent/mm/ui/n/a/b$a:XJs	Lcom/tencent/mm/vending/g/c;
    //   60: ldc_w 265
    //   63: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: aload_2
    //   71: getfield 293	com/tencent/mm/ui/n/a/b$a:XJs	Lcom/tencent/mm/vending/g/c;
    //   74: ifnull +19 -> 93
    //   77: ldc 111
    //   79: ldc_w 295
    //   82: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: getfield 293	com/tencent/mm/ui/n/a/b$a:XJs	Lcom/tencent/mm/vending/g/c;
    //   89: astore_1
    //   90: goto -35 -> 55
    //   93: aload_1
    //   94: invokestatic 281	com/tencent/mm/cw/g:eE	(Ljava/lang/Object;)Lcom/tencent/mm/cw/f;
    //   97: new 37	com/tencent/mm/ui/n/a/b$8
    //   100: dup
    //   101: aload_0
    //   102: aload_2
    //   103: invokespecial 296	com/tencent/mm/ui/n/a/b$8:<init>	(Lcom/tencent/mm/ui/n/a/b;Lcom/tencent/mm/ui/n/a/b$a;)V
    //   106: invokevirtual 289	com/tencent/mm/cw/f:h	(Lcom/tencent/mm/vending/c/a;)Lcom/tencent/mm/cw/f;
    //   109: astore_1
    //   110: goto -55 -> 55
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	b
    //   14	96	1	localObject1	Object
    //   113	4	1	localObject2	Object
    //   20	83	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	55	113	finally
    //   55	66	113	finally
    //   70	90	113	finally
    //   93	110	113	finally
  }
  
  public static boolean hXk()
  {
    AppMethodBeat.i(286044);
    if ((MultiProcessMMKV.getSingleMMKV("__magic_emoji__").decodeBool("force_update", false)) || (com.tencent.mm.plugin.emoji.magicemoji.b.a.uBl))
    {
      AppMethodBeat.o(286044);
      return true;
    }
    AppMethodBeat.o(286044);
    return false;
  }
  
  public final void ZP()
  {
    AppMethodBeat.i(286030);
    if (((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cTU())
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: trigger preload magic emoji service");
      hXj();
    }
    AppMethodBeat.o(286030);
  }
  
  public final void ZQ()
  {
    try
    {
      AppMethodBeat.i(286032);
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: triggered destroy");
      chi();
      AppMethodBeat.o(286032);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ZR()
  {
    AppMethodBeat.i(286045);
    Object localObject = com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.appId;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: appid invalid");
      AppMethodBeat.o(286045);
      return;
    }
    localObject = (a)this.XJc.get(localObject);
    if (localObject == null)
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: item not event loaded");
      AppMethodBeat.o(286045);
      return;
    }
    if (((a)localObject).XJq == null)
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service not event loaded");
      AppMethodBeat.o(286045);
      return;
    }
    ((a)localObject).XJq.GW(false);
    AppMethodBeat.o(286045);
  }
  
  public final com.tencent.mm.vending.g.c<e> a(final FrameLayout paramFrameLayout, final WeakReference<com.tencent.mm.ui.chatting.e.a> paramWeakReference)
  {
    try
    {
      AppMethodBeat.i(286043);
      com.tencent.mm.plugin.emoji.magicemoji.b.a.cUd();
      if (com.tencent.mm.plugin.emoji.magicemoji.b.a.uBl)
      {
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: current in debug mode");
        com.tencent.mm.ui.n.b.a.bAw("Current environment is debug!");
      }
      final a.a locala1 = com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq;
      final a locala = (a)this.XJc.get(locala1.appId);
      if (locala == null)
      {
        locala = new a();
        this.XJc.put(locala1.appId, locala);
      }
      for (;;)
      {
        com.tencent.mm.vending.g.c localc = locala.XJt;
        Object localObject;
        if (locala.XJr != null)
        {
          localObject = com.tencent.mm.cw.g.eE(locala.XJr).b(new com.tencent.mm.vending.c.a() {});
          AppMethodBeat.o(286043);
        }
        for (;;)
        {
          return localObject;
          localObject = localc;
          if (localc == null)
          {
            localObject = hXj().c(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a()
            {
              private e a(com.tencent.mm.vending.j.c<bh, e> paramAnonymousc)
              {
                AppMethodBeat.i(285220);
                Log.i("MicroMsg.MagicEmojiEnvMgr", "loaded record");
                Object localObject2 = (b.a)b.b(b.this).get(locala1.appId);
                com.tencent.mm.ui.chatting.e.a locala;
                synchronized (b.this)
                {
                  ((b.a)localObject2).XJr = ((e)paramAnonymousc.get(1));
                  ((b.a)localObject2).XJt = null;
                  localObject2 = (e)paramAnonymousc.get(1);
                  ??? = (bh)paramAnonymousc.get(0);
                  locala = (com.tencent.mm.ui.chatting.e.a)paramWeakReference.get();
                  Log.i("MicroMsg.MagicEmojiRuntime", "hy: trigger startup: %s, %s, %d, is running: %b", new Object[] { ((bh)???).field_appId, ((bh)???).field_pkgPath, Integer.valueOf(((bh)???).field_version), Boolean.valueOf(((e)localObject2).mIsRunning) });
                  if (((e)localObject2).mIsRunning)
                  {
                    if (!BuildInfo.DEBUG) {
                      break label541;
                    }
                    paramAnonymousc = new RuntimeException("Runtime should be only started once!!");
                    AppMethodBeat.o(285220);
                    throw paramAnonymousc;
                  }
                }
                ((e)localObject2).XJL = ((bh)???);
                e.a(((e)localObject2).XJI, true);
                g localg = ((e)localObject2).XJI;
                Log.i("MicroMsg.MagicEmojiService", "hy: runtime ready, start inject game.js");
                localg.XJB = ((e)localObject2);
                ??? = localg.XJB.getFileSystem();
                Object localObject3;
                if (??? == null)
                {
                  Log.e("MicroMsg.MagicEmojiUtils", "hy: can not read without fs");
                  ??? = "";
                  localg.b(new g.13(localg), false);
                  long l = Util.currentTicks();
                  localObject3 = "/game.js".replace("/", "") + "_" + localg.mAppId;
                  ((com.tencent.mm.plugin.appbrand.m.i)localg.getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.i.class)).a(null, (String)localObject3, localg.XJB.hXo(), 0, (String)???, new g.14(localg, l));
                  e.a(((e)localObject2).XJJ, true);
                  ((e)localObject2).mIsRunning = true;
                  if (locala == null) {
                    break label522;
                  }
                  ((e)localObject2).XJK = new WeakReference(locala);
                  ((j)locala.bC(j.class)).a(((e)localObject2).XJN);
                }
                for (;;)
                {
                  try
                  {
                    ??? = new ConcurrentLinkedDeque(((e)localObject2).XJM);
                    while (!((ConcurrentLinkedDeque)???).isEmpty()) {
                      Objects.requireNonNull(((ConcurrentLinkedDeque)???).poll());
                    }
                    localObject3 = new com.tencent.mm.plugin.appbrand.ac.i();
                  }
                  finally
                  {
                    AppMethodBeat.o(285220);
                  }
                  if (((r)???).b("/game.js", (com.tencent.mm.plugin.appbrand.ac.i)localObject3) != m.nMR)
                  {
                    Log.e("MicroMsg.MagicEmojiUtils", "hy: no file found");
                    ??? = "";
                    break;
                  }
                  ??? = new String(d.m((ByteBuffer)((com.tencent.mm.plugin.appbrand.ac.i)localObject3).value), StandardCharsets.UTF_8);
                  break;
                  label522:
                  Log.w("MicroMsg.MagicEmojiRuntime", "hy: chatting released despite started up. should considered pause");
                  ((e)localObject2).UJ();
                }
                label541:
                paramAnonymousc = (e)paramAnonymousc.get(1);
                AppMethodBeat.o(285220);
                return paramAnonymousc;
              }
            });
            locala.XJt = ((com.tencent.mm.vending.g.c)localObject);
          }
          AppMethodBeat.o(286043);
        }
      }
    }
    finally {}
  }
  
  public final void a(final c paramc)
  {
    String str;
    try
    {
      AppMethodBeat.i(286040);
      str = com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.appId;
      locala = (a)this.XJc.get(str);
      if ((locala != null) && (locala.XJr != null))
      {
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and everything prepared");
        locala.XJr.b(paramc);
        AppMethodBeat.o(286040);
      }
      for (;;)
      {
        return;
        if ((locala == null) || (locala.XJu == null)) {
          break;
        }
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and runtime is preparing");
        locala.XJu.add(paramc);
        AppMethodBeat.o(286040);
      }
      if (locala != null) {
        break label212;
      }
    }
    finally {}
    final a locala = new a();
    this.XJc.put(str, locala);
    label212:
    for (;;)
    {
      locala.XJu = new LinkedList();
      locala.XJu.add(paramc);
      a((FrameLayout)paramc.XJx.get(), paramc.XJw).f(new com.tencent.mm.vending.c.a()
      {
        private Boolean a(e arg1)
        {
          AppMethodBeat.i(262148);
          Iterator localIterator = locala.XJu.iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            if ((localc.XJw.get() == null) || (localc.XJx.get() == null) || (localc.XJw.get() != paramc.XJw.get()) || (localc.XJx.get() != paramc.XJx.get())) {
              Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: pending msg chatting released. ignore current chatting");
            } else {
              ???.b(localc);
            }
          }
          synchronized (b.this)
          {
            locala.XJu.clear();
            ??? = Boolean.TRUE;
            AppMethodBeat.o(262148);
            return ???;
          }
        }
      }).a(new d.a() {});
      AppMethodBeat.o(286040);
      break;
    }
  }
  
  final a bAt(String paramString)
  {
    AppMethodBeat.i(286036);
    a locala2 = (a)this.XJc.get(paramString);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      this.XJc.put(paramString, locala1);
    }
    AppMethodBeat.o(286036);
    return locala1;
  }
  
  public final void jY(int paramInt)
  {
    try
    {
      AppMethodBeat.i(286028);
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: config with version: %d", new Object[] { Integer.valueOf(paramInt) });
      ((u)com.tencent.mm.kernel.h.ae(u.class)).u(com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.userName, com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.appId, 999);
      ((com.tencent.mm.plugin.appbrand.service.v)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.v.class)).bv(com.tencent.mm.plugin.emoji.magicemoji.b.a.uBq.appId, paramInt);
      AppMethodBeat.o(286028);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    g XJq;
    e XJr;
    com.tencent.mm.vending.g.c<g> XJs;
    com.tencent.mm.vending.g.c<e> XJt;
    List<c> XJu;
    boolean XJv = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b
 * JD-Core Version:    0.7.0.1
 */