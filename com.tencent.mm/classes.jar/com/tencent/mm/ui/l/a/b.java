package com.tencent.mm.ui.l.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.plugin.emoji.magicemoji.b.a.a;
import com.tencent.mm.plugin.emoji.magicemoji.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mmkv.MMKV;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum b
  implements com.tencent.mm.api.v
{
  private boolean Qlt;
  private final Map<String, a> Qlv;
  private a.a UuZ;
  
  static
  {
    AppMethodBeat.i(234363);
    Qlr = new b("INSTANCE");
    Qlw = new b[] { Qlr };
    AppMethodBeat.o(234363);
  }
  
  private b()
  {
    AppMethodBeat.i(234348);
    this.Qlt = false;
    this.UuZ = null;
    this.Qlv = new HashMap(1);
    AppMethodBeat.o(234348);
  }
  
  private static void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(234353);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(234353);
      return;
    }
    com.tencent.f.h.RTc.aV(paramRunnable);
    AppMethodBeat.o(234353);
  }
  
  private void b(a.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(258301);
        if ((this.UuZ == null) || (this.UuZ != parama)) {}
        switch (4.Qlz[parama.ordinal()])
        {
        case 1: 
          com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 6);
          this.UuZ = parama;
          AppMethodBeat.o(258301);
          return;
        }
      }
      finally {}
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 0);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 1);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 2);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 3);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 4);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 5);
      continue;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1619, 7);
    }
  }
  
  private void bUc()
  {
    AppMethodBeat.i(257972);
    String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: appid invalid");
      AppMethodBeat.o(257972);
      return;
    }
    final a locala = (a)this.Qlv.get(str);
    if (locala == null)
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: item not event loaded");
      AppMethodBeat.o(257972);
      return;
    }
    this.Qlv.remove(str);
    aN(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234331);
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: destroy imp in ui thread");
        for (;;)
        {
          synchronized (b.this)
          {
            if (locala.QlH != null)
            {
              Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has serviceLoadTask, trigger terminate");
              locala.QlH.stop();
              locala.QlH = null;
            }
            if (locala.QlI != null)
            {
              Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtimeLoadTask, trigger terminate");
              locala.QlI.stop();
              locala.QlI = null;
            }
            if (locala.QlG != null)
            {
              Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtime, trigger destroy");
              e locale = locala.QlG;
              if (locale.mIsRunning) {
                Log.i("MicroMsg.MagicEmojiRuntime", "hy: destroying runtime");
              }
              try
              {
                if (locale.kAz == null) {
                  locale.kAz.release();
                }
                e.a(locale.QlV);
                e.a(locale.QlU);
                locale.QlV = null;
                locale.QlU = null;
                locale.mIsRunning = false;
                locala.QlG = null;
                return;
              }
              finally
              {
                AppMethodBeat.o(234331);
              }
            }
          }
          if (locala.QlF != null)
          {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has service, trigger destroy");
            locala.QlF.notifyDestroy();
            locala.QlF = null;
          }
        }
      }
    });
    AppMethodBeat.o(257972);
  }
  
  public static boolean gWz()
  {
    AppMethodBeat.i(234357);
    if (MMKV.mmkvWithID("__magic_emoji__").decodeBool("force_update", false))
    {
      AppMethodBeat.o(234357);
      return true;
    }
    AppMethodBeat.o(234357);
    return false;
  }
  
  private com.tencent.mm.vending.g.c<g> hed()
  {
    try
    {
      AppMethodBeat.i(257973);
      Object localObject1 = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
      String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.userName;
      final a locala = (a)this.Qlv.get(localObject1);
      if (locala == null)
      {
        locala = new a();
        this.Qlv.put(localObject1, locala);
      }
      for (;;)
      {
        if (locala.QlF != null)
        {
          Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service already loaded");
          localObject1 = com.tencent.mm.co.g.ey(locala.QlF).h(new com.tencent.mm.vending.c.a() {});
        }
        for (;;)
        {
          locala.QlH = ((com.tencent.mm.vending.g.c)localObject1);
          AppMethodBeat.o(257973);
          return localObject1;
          if (locala.QlH != null)
          {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service already loading");
            localObject1 = locala.QlH;
          }
          else
          {
            localObject1 = com.tencent.mm.co.g.ey(com.tencent.mm.vending.j.c.Q(localObject1, str)).h(new com.tencent.mm.vending.c.a()
            {
              private g a(com.tencent.mm.vending.j.c<String, String> arg1)
              {
                AppMethodBeat.i(234335);
                Object localObject1 = ((com.tencent.mm.plugin.appbrand.service.v)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H(this.val$appId, com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.iOo, 0);
                if (localObject1 != null)
                {
                  Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: reset config version to %d", new Object[] { Integer.valueOf(((bd)localObject1).field_version) });
                  b.this.zX(((bd)localObject1).field_version);
                }
                localObject1 = ((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFt();
                if (com.tencent.mm.plugin.emoji.magicemoji.b.a.a((a.a)localObject1))
                {
                  com.tencent.mm.vending.g.g.hdx().ej(localObject1);
                  AppMethodBeat.o(234335);
                  return null;
                }
                ((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFu();
                localObject1 = b.nn((String)???.get(0), (String)???.get(1));
                synchronized (b.this)
                {
                  locala.QlF = ((g)localObject1);
                  locala.QlH = null;
                  AppMethodBeat.o(234335);
                  return localObject1;
                }
              }
            });
          }
        }
      }
    }
    finally {}
  }
  
  public final void Vw()
  {
    AppMethodBeat.i(257970);
    if (((com.tencent.mm.plugin.emoji.magicemoji.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFs())
    {
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: trigger preload magic emoji service");
      hed();
    }
    AppMethodBeat.o(257970);
  }
  
  public final void c(final c paramc)
  {
    String str;
    try
    {
      AppMethodBeat.i(257974);
      str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
      locala = (a)this.Qlv.get(str);
      if ((locala != null) && (locala.QlG != null))
      {
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and everything prepared");
        locala.QlG.a(paramc);
        AppMethodBeat.o(257974);
      }
      for (;;)
      {
        return;
        if ((locala == null) || (locala.QlJ == null)) {
          break;
        }
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and runtime is preparing");
        locala.QlJ.add(paramc);
        AppMethodBeat.o(257974);
      }
      if (locala != null) {
        break label208;
      }
    }
    finally {}
    final a locala = new a();
    this.Qlv.put(str, locala);
    label208:
    for (;;)
    {
      locala.QlJ = new LinkedList();
      locala.QlJ.add(paramc);
      f((FrameLayout)paramc.QlL.get()).f(new com.tencent.mm.vending.c.a()
      {
        private Boolean a(e arg1)
        {
          AppMethodBeat.i(234338);
          Iterator localIterator = locala.QlJ.iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            if ((localc.QlK.get() == null) || (localc.QlL.get() == null) || (localc.QlK.get() != paramc.QlK.get()) || (localc.QlL.get() != paramc.QlL.get())) {
              Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: pending msg chatting released. ignore current chatting");
            } else {
              ???.a(localc);
            }
          }
          synchronized (b.this)
          {
            locala.QlJ.clear();
            ??? = Boolean.TRUE;
            AppMethodBeat.o(234338);
            return ???;
          }
        }
      }).a(new d.a() {});
      AppMethodBeat.o(257974);
      break;
    }
  }
  
  public final void cFB()
  {
    try
    {
      AppMethodBeat.i(257971);
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: triggered destroy");
      bUc();
      AppMethodBeat.o(257971);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.vending.g.c<e> f(final FrameLayout paramFrameLayout)
  {
    try
    {
      AppMethodBeat.i(257975);
      final a.b localb = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT;
      a locala = (a)this.Qlv.get(localb.appId);
      if (locala == null)
      {
        locala = new a();
        this.Qlv.put(localb.appId, locala);
      }
      for (;;)
      {
        com.tencent.mm.vending.g.c localc = locala.QlI;
        Object localObject;
        if (locala.QlG != null)
        {
          localObject = com.tencent.mm.co.g.ey(locala.QlG).b(new com.tencent.mm.vending.c.a() {});
          AppMethodBeat.o(257975);
        }
        for (;;)
        {
          return localObject;
          localObject = localc;
          if (localc == null)
          {
            localObject = hed().c(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {}).c(new com.tencent.mm.vending.c.a()
            {
              private e b(com.tencent.mm.vending.j.c<bd, e> paramAnonymousc)
              {
                AppMethodBeat.i(234340);
                Log.i("MicroMsg.MagicEmojiEnvMgr", "loaded record");
                Object localObject2 = (b.a)b.a(b.this).get(localb.appId);
                for (;;)
                {
                  synchronized (b.this)
                  {
                    ((b.a)localObject2).QlG = ((e)paramAnonymousc.get(1));
                    ((b.a)localObject2).QlI = null;
                    localObject2 = (e)paramAnonymousc.get(1);
                    ??? = (bd)paramAnonymousc.get(0);
                    Log.i("MicroMsg.MagicEmojiRuntime", "hy: trigger startup: %s, %s, %d", new Object[] { ((bd)???).field_appId, ((bd)???).field_pkgPath, Integer.valueOf(((bd)???).field_version) });
                    ((e)localObject2).QlX = ((bd)???);
                    e.a(((e)localObject2).QlU, true);
                    g localg = ((e)localObject2).QlU;
                    Log.i("MicroMsg.MagicEmojiService", "hy: runtime ready, start inject game.js");
                    localg.QlN = ((e)localObject2);
                    ??? = localg.QlN.getFileSystem();
                    if (??? == null)
                    {
                      Log.e("MicroMsg.MagicEmojiUtils", "hy: can not read without fs");
                      ??? = "";
                      localg.b(new g.13(localg), false);
                      long l = Util.currentTicks();
                      localObject3 = "/game.js".replace("/", "") + "_" + localg.mAppId;
                      ((com.tencent.mm.plugin.appbrand.m.i)localg.getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.i.class)).a(null, (String)localObject3, localg.QlN.gWF(), 0, (String)???, new g.14(localg, l));
                      e.a(((e)localObject2).QlV, true);
                      ((e)localObject2).mIsRunning = true;
                      paramAnonymousc = (e)paramAnonymousc.get(1);
                      AppMethodBeat.o(234340);
                      return paramAnonymousc;
                    }
                  }
                  Object localObject3 = new com.tencent.mm.plugin.appbrand.ac.i();
                  if (((q)???).b("/game.js", (com.tencent.mm.plugin.appbrand.ac.i)localObject3) != m.kSu)
                  {
                    Log.e("MicroMsg.MagicEmojiUtils", "hy: no file found");
                    ??? = "";
                  }
                  else
                  {
                    ??? = new String(d.p((ByteBuffer)((com.tencent.mm.plugin.appbrand.ac.i)localObject3).value), StandardCharsets.UTF_8);
                  }
                }
              }
            });
            locala.QlI = ((com.tencent.mm.vending.g.c)localObject);
          }
          AppMethodBeat.o(257975);
        }
      }
    }
    finally {}
  }
  
  public final void zX(int paramInt)
  {
    try
    {
      AppMethodBeat.i(257969);
      Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: config with version: %d", new Object[] { Integer.valueOf(paramInt) });
      ((u)com.tencent.mm.kernel.g.af(u.class)).r(com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.userName, com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId, 999);
      ((com.tencent.mm.plugin.appbrand.service.v)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.v.class)).bc(com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId, paramInt);
      AppMethodBeat.o(257969);
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
    g QlF;
    e QlG;
    com.tencent.mm.vending.g.c<g> QlH;
    com.tencent.mm.vending.g.c<e> QlI;
    List<c> QlJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b
 * JD-Core Version:    0.7.0.1
 */