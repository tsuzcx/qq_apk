package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.a.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static f wik;
  com.tencent.mm.aj.a dkC;
  Object qaE;
  private LinkedList<String> whO;
  HashMap<String, h> whP;
  LinkedList<String> whQ;
  HashMap<String, h> whR;
  LinkedList<String> whS;
  public LinkedList<String> whT;
  private HashMap<String, String> whU;
  HashMap<String, LinkedList<String>> whV;
  HashMap<String, com.tencent.mm.aj.b> whW;
  private HashMap<String, com.tencent.mm.aj.d> whX;
  private LinkedList<String> whY;
  HashMap<String, Integer> whZ;
  private LinkedList<String> wia;
  boolean wib;
  private boolean wic;
  long wid;
  private long wie;
  com.tencent.mm.plugin.music.b.a.d wif;
  private com.tencent.mm.plugin.music.b.b.a wig;
  private HashMap<String, String> wih;
  HashMap<String, Integer> wii;
  com.tencent.mm.audio.mix.f.c wij;
  private c wil;
  private Runnable wim;
  Runnable win;
  private com.tencent.mm.audio.mix.f.b wio;
  private com.tencent.mm.audio.mix.f.g wip;
  
  private f()
  {
    AppMethodBeat.i(137037);
    this.whO = new LinkedList();
    this.whP = new HashMap();
    this.whQ = new LinkedList();
    this.whR = new HashMap();
    this.whS = new LinkedList();
    this.whT = new LinkedList();
    this.whU = new HashMap();
    this.whV = new HashMap();
    this.whW = new HashMap();
    this.whX = new HashMap();
    this.whY = new LinkedList();
    this.whZ = new HashMap();
    this.wia = new LinkedList();
    this.qaE = new Object();
    this.wib = false;
    this.wic = false;
    this.wid = 0L;
    this.wie = 0L;
    this.dkC = new com.tencent.mm.aj.a();
    this.wig = new com.tencent.mm.plugin.music.b.b.a();
    this.wih = new HashMap();
    this.wii = new HashMap();
    this.wil = new c()
    {
      public final void afY(String paramAnonymousString)
      {
        AppMethodBeat.i(137018);
        h localh = f.this.arS(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
          AppMethodBeat.o(137018);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.drB();
        f.a(f.this, paramAnonymousString);
        f.this.asd(paramAnonymousString);
        AppMethodBeat.o(137018);
      }
      
      public final void arJ(String paramAnonymousString)
      {
        AppMethodBeat.i(137017);
        h localh = f.this.arS(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
          AppMethodBeat.o(137017);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.drB();
        AppMethodBeat.o(137017);
      }
      
      public final void gc(String paramAnonymousString)
      {
        AppMethodBeat.i(137019);
        h localh = f.this.arS(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
          AppMethodBeat.o(137019);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.drB();
        f.a(f.this, paramAnonymousString);
        f.this.asd(paramAnonymousString);
        AppMethodBeat.o(137019);
      }
      
      public final void onError(String paramAnonymousString)
      {
        AppMethodBeat.i(137020);
        h localh = f.this.arS(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
          AppMethodBeat.o(137020);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f localf = f.this;
        int j = localh.pZU;
        if (localf.whZ.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localf.whZ.get(paramAnonymousString)).intValue();; i = 0)
        {
          if (i > 0)
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            localf.whZ.remove(paramAnonymousString);
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label189;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            f.this.drF();
            f.this.b(paramAnonymousString, null);
            AppMethodBeat.o(137020);
            return;
            if (66 != j)
            {
              localf.whZ.remove(paramAnonymousString);
              break;
            }
            if (!localf.asc(paramAnonymousString)) {
              break;
            }
            localf.whZ.put(paramAnonymousString, Integer.valueOf(i + 1));
          }
          label189:
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
          f.this.f(paramAnonymousString, localh);
          f.a(f.this);
          f.this.drB();
          AppMethodBeat.o(137020);
          return;
        }
      }
      
      public final void onStart(String arg1)
      {
        AppMethodBeat.i(137016);
        h localh = f.this.arS(???);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
          AppMethodBeat.o(137016);
          return;
        }
        f.this.e(???, localh);
        synchronized (f.this.qaE)
        {
          f.this.wib = false;
          aq.aA(f.this.win);
          AppMethodBeat.o(137016);
          return;
        }
      }
    };
    this.wim = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137021);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
        Iterator localIterator = f.this.whT.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (f.this.arR(str) == 0) {
            f.this.arT(str);
          }
        }
        AppMethodBeat.o(137021);
      }
    };
    this.win = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137022);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
        Iterator localIterator = f.this.whT.iterator();
        int i = 0;
        f localf;
        Object localObject5;
        if (localIterator.hasNext())
        {
          ??? = (String)localIterator.next();
          if (f.this.arR((String)???) != 0) {
            break label450;
          }
          localf = f.this;
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
          localObject5 = (LinkedList)localf.whV.get(???);
          if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            label112:
            i = 1;
          }
        }
        label450:
        for (;;)
        {
          break;
          Object localObject6;
          Object localObject7;
          for (;;)
          {
            h localh;
            synchronized (localf.qaE)
            {
              localObject6 = ((LinkedList)localObject5).iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (String)((Iterator)localObject6).next();
              if (localf.wij.gf((String)localObject7)) {
                localf.wij.gj((String)localObject7);
              }
              localh = (h)localf.whP.remove(localObject7);
              localf.whQ.remove(localObject7);
              if (localh == null) {
                continue;
              }
              localf.b((String)localObject7, localh);
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
              if (localh.hLV) {
                f.d((String)localObject7, localh);
              }
            }
            f.c((String)localObject7, localh);
          }
          localObject5 = ((LinkedList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localf.wij.gf((String)localObject6)) {
              localf.wij.gj((String)localObject6);
            }
            localObject7 = (h)localf.whR.remove(localObject6);
            localf.whS.remove(localObject6);
            if (localObject7 != null)
            {
              localf.b((String)localObject6, (h)localObject7);
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
              if (((h)localObject7).hLV) {
                f.d((String)localObject6, (h)localObject7);
              } else {
                f.c((String)localObject6, (h)localObject7);
              }
            }
          }
          break label112;
          if (i == 0) {}
          synchronized (f.this.qaE)
          {
            f.this.wib = true;
            f.this.wid = System.currentTimeMillis();
            aq.o(f.this.win, 1800000L);
            AppMethodBeat.o(137022);
            return;
          }
        }
      }
    };
    this.wio = new com.tencent.mm.audio.mix.f.b()
    {
      public final void b(w paramAnonymousw)
      {
        AppMethodBeat.i(137024);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137024);
      }
      
      public final void c(w paramAnonymousw)
      {
        AppMethodBeat.i(137025);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137025);
      }
      
      public final void d(w paramAnonymousw)
      {
        AppMethodBeat.i(137026);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137026);
      }
      
      public final void e(w paramAnonymousw)
      {
        AppMethodBeat.i(137027);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137027);
      }
      
      public final void f(w paramAnonymousw)
      {
        AppMethodBeat.i(137028);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137028);
      }
      
      public final void g(w paramAnonymousw)
      {
        AppMethodBeat.i(137029);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137029);
      }
      
      public final void h(w paramAnonymousw)
      {
        AppMethodBeat.i(137030);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137030);
      }
      
      public final void i(w paramAnonymousw)
      {
        AppMethodBeat.i(137031);
        com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137031);
      }
      
      public final void j(w paramAnonymousw)
      {
        AppMethodBeat.i(137032);
        int i = paramAnonymousw.dkE.errCode;
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
        if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
        }
        while (f.this.wif != null)
        {
          com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.whW.get(paramAnonymousw.dkE.dce);
          if (localb == null)
          {
            AppMethodBeat.o(137032);
            return;
            com.tencent.mm.sdk.b.a.IbL.a(paramAnonymousw, Looper.getMainLooper());
          }
          else
          {
            f.this.wif.KW(paramAnonymousw.dkE.errCode);
            if (!f.this.wij.gs(localb.filePath))
            {
              if (f.this.wii.containsKey(localb.filePath))
              {
                i = ((Integer)f.this.wii.get(localb.filePath)).intValue();
                f.this.wii.put(localb.filePath, Integer.valueOf(i + 1));
                AppMethodBeat.o(137032);
                return;
              }
              f.this.wii.put(localb.filePath, Integer.valueOf(1));
            }
          }
        }
        AppMethodBeat.o(137032);
      }
      
      public final void k(w paramAnonymousw)
      {
        AppMethodBeat.i(137033);
        if (f.this.wif != null)
        {
          com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.whW.get(paramAnonymousw.dkE.dce);
          if (localb == null)
          {
            AppMethodBeat.o(137033);
            return;
          }
          if (localb.hLL > 1000000L) {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.dce, Long.valueOf(localb.hLL) });
          }
          Object localObject = paramAnonymousw.dkE.ddp;
          paramAnonymousw = (w)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramAnonymousw = localb.ddp;
          }
          localObject = f.this.wif;
          String str1 = localb.dce;
          long l1 = System.currentTimeMillis();
          long l2 = localb.hLJ;
          long l3 = localb.hLK;
          long l4 = localb.hLL;
          String str2 = localb.filePath;
          long l5 = f.this.wij.go(localb.dce);
          long l6 = localb.fileSize;
          String str3 = localb.filePath;
          ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramAnonymousw, l1 - l2, l3, l4, false, str2, l5, l6, com.tencent.mm.audio.mix.b.e.Ou().fM(str3));
          if (f.this.wii.containsKey(localb.filePath)) {
            f.this.wii.remove(localb.filePath);
          }
        }
        AppMethodBeat.o(137033);
      }
    };
    this.wip = new com.tencent.mm.audio.mix.f.g()
    {
      public final void hN(int paramAnonymousInt)
      {
        AppMethodBeat.i(137034);
        if (f.this.wif != null) {
          f.this.wif.KV(paramAnonymousInt);
        }
        AppMethodBeat.o(137034);
      }
    };
    _release();
    this.wij = new com.tencent.mm.audio.mix.f.c();
    this.wij.a(this.wio);
    this.wij.a(this.wip);
    AppMethodBeat.o(137037);
  }
  
  private void a(com.tencent.mm.aj.b paramb1, com.tencent.mm.aj.b paramb2)
  {
    AppMethodBeat.i(137045);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    arX(paramb1.dce);
    k(paramb1);
    if ((TextUtils.isEmpty(paramb1.filePath)) && (paramb2 != null) && (paramb2.e(paramb1))) {
      paramb1.filePath = paramb2.filePath;
    }
    if (paramb1.hLF)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        a(paramb1, true, false);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.wij.fS(paramb1.dce)) || (this.wij.gk(paramb1.dce)) || (this.wij.gl(paramb1.dce)) || (this.wij.gm(paramb1.dce)) || (this.wij.isPaused(paramb1.dce))) {
          this.wij.gj(paramb1.dce);
        }
        this.wij.a(paramb1);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wij.fS(paramb1.dce))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      if ((this.wij.gk(paramb1.dce)) && (this.wij.isPaused(paramb1.dce)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.wij.gh(paramb1.dce);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wij.gm(paramb1.dce))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.wij.gh(paramb1.dce);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wij.gl(paramb1.dce))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.wij.a(paramb1);
      AppMethodBeat.o(137045);
      return;
    }
    if (this.wij.gf(paramb1.dce)) {
      this.wij.c(paramb1);
    }
    for (;;)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.wij.fS(paramb1.dce)) || (this.wij.gk(paramb1.dce)) || (this.wij.gl(paramb1.dce)) || (this.wij.gm(paramb1.dce)) || (this.wij.isPaused(paramb1.dce))) {
          this.wij.gj(paramb1.dce);
        }
      }
      this.wij.o(7, paramb1.dce);
      AppMethodBeat.o(137045);
      return;
      this.wij.b(paramb1);
    }
  }
  
  private void a(com.tencent.mm.aj.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137091);
    this.wif = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wif != null) {
      this.wif.r(paramb.dce, paramb.ddp, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.hLJ = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.hLN;
    }
    for (paramb.hLK = paramb.hLM; (l1 > 0L) && (l2 > l1); paramb.hLK = paramb.hLO)
    {
      paramb.hLL = (l2 - l1);
      AppMethodBeat.o(137091);
      return;
      l1 = paramb.hLP;
    }
    paramb.hLL = 0L;
    AppMethodBeat.o(137091);
  }
  
  private void a(String paramString, com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137039);
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137039);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.whU.put(paramb.appId, paramb.processName);
    this.whW.put(paramb.dce, paramb);
    ic(paramb.appId, paramString);
    this.whZ.remove(paramString);
    AppMethodBeat.o(137039);
  }
  
  private void a(String paramString, h paramh)
  {
    AppMethodBeat.i(137068);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.whW.get(paramString);
    if ((localb != null) && (paramh.aJG()) && (paramh.aJI()))
    {
      localb.hLF = true;
      localb.ddx = paramh.dsc();
    }
    for (;;)
    {
      b(paramString, paramh);
      paramString = arQ(paramString);
      if ((paramString != null) && (paramh.aJG())) {
        paramString.tG = true;
      }
      if ((!paramh.aJG()) && (!paramh.aJI()) && (!paramh.cMm()) && (!paramh.boS()) && (!paramh.isPaused())) {
        break;
      }
      paramh.drZ();
      AppMethodBeat.o(137068);
      return;
      if ((localb != null) && (paramh.aJI()))
      {
        localb.hLF = true;
        localb.ddx = paramh.dsc();
      }
      else if (localb != null)
      {
        localb.hLF = true;
        localb.ddx = 0;
      }
    }
    paramh.drY();
    AppMethodBeat.o(137068);
  }
  
  private static boolean a(h paramh)
  {
    AppMethodBeat.i(137075);
    if (paramh == null)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    if ((paramh.aJG()) || (paramh.isPaused()) || (paramh.cMm()) || (paramh.boS()) || (paramh.aJI())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    AppMethodBeat.o(137075);
    return false;
  }
  
  private void arV(String arg1)
  {
    AppMethodBeat.i(137064);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.whV.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137064);
      return;
    }
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.qaE)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.wij.gf(str)) {
          this.wij.gj(str);
        }
        localh = (h)this.whR.remove(str);
        this.whS.remove(str);
        if (localh == null) {
          continue;
        }
        b(str, localh);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localh.hLV) {
          d(str, localh);
        }
      }
      c(str, localh);
    }
    AppMethodBeat.o(137064);
  }
  
  private String arW(String paramString)
  {
    AppMethodBeat.i(137067);
    Iterator localIterator = this.whT.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.whV.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137067);
        return str;
      }
    }
    AppMethodBeat.o(137067);
    return "";
  }
  
  private boolean arX(String paramString)
  {
    AppMethodBeat.i(137074);
    ??? = arS(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137074);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.qaE)
    {
      this.whP.remove(paramString);
      this.whQ.remove(paramString);
      this.whR.remove(paramString);
      this.whS.remove(paramString);
      AppMethodBeat.o(137074);
      return true;
    }
  }
  
  private void arY(String paramString)
  {
    AppMethodBeat.i(137078);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.whP.size();
    int j = this.whR.size();
    int k = drC();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      drD();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = arW(paramString);
      i = this.whP.size();
      j = this.whR.size();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.whT.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          arZ(str);
        }
      }
      if (k >= 6) {
        drD();
      } else if (i + k >= 8) {
        drD();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.whT.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          arZ(str);
        }
      }
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.whR.size();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      drE();
      AppMethodBeat.o(137078);
      return;
    }
    if (j + i >= 50)
    {
      drE();
      AppMethodBeat.o(137078);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137078);
  }
  
  private void arZ(String paramString)
  {
    AppMethodBeat.i(137081);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    arV(paramString);
    AppMethodBeat.o(137081);
  }
  
  private boolean asa(String paramString)
  {
    AppMethodBeat.i(137082);
    boolean bool1 = false;
    Object localObject2 = new ArrayList();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    int m;
    Object localObject3;
    for (;;)
    {
      synchronized (this.qaE)
      {
        m = this.whP.size();
        if (m < 10)
        {
          this.whY.clear();
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137082);
          return false;
        }
        localObject3 = this.whQ.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.aj.b)this.whW.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.aj.b)localObject4).ddp == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.aj.b)localObject4).ddp))
        {
          localHashMap2.put(((com.tencent.mm.aj.b)localObject4).ddp, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.aj.b)localObject4).dce);
          localHashMap1.put(((com.tencent.mm.aj.b)localObject4).ddp, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.aj.b)localObject4).ddp)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.aj.b)localObject4).ddp);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.aj.b)localObject4).ddp)).intValue();
      localHashMap2.put(((com.tencent.mm.aj.b)localObject4).ddp, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.aj.b)localObject4).ddp);
      if (!localArrayList.contains(((com.tencent.mm.aj.b)localObject4).dce)) {
        localArrayList.add(((com.tencent.mm.aj.b)localObject4).dce);
      }
      localHashMap1.put(((com.tencent.mm.aj.b)localObject4).ddp, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.dsv();
    ad.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      ad.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
      if (j < k) {
        break label908;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label905;
      }
      ??? = localObject3;
      i = j;
      label469:
      j = i;
      localObject2 = ???;
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)???))
      {
        localObject2 = localObject3;
        bool1 = bool2;
        j = i;
      }
    }
    for (;;)
    {
      i = j;
      ??? = localObject2;
      break;
      if (bool1)
      {
        paramString = (com.tencent.mm.aj.b)this.whW.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.ddp)))
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.aj.b)this.whW.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new a());
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.aj.b)paramString.next()).dce);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label826;
            }
            i += 1;
            ad.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.whY.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.whY.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137082);
          return bool1;
          label826:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.whY.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.whY.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.whY.clear();
        }
      }
      label905:
      break label469;
      label908:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void b(com.tencent.mm.aj.b paramb1, com.tencent.mm.aj.b paramb2)
  {
    int i = 1;
    AppMethodBeat.i(137046);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    h localh = arS(paramb1.dce);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.dce });
      paramb2 = drA();
      paramb2.a(this.wil);
      paramb2.ase(paramb1.dce);
      paramb2.b(paramb1);
      if (paramb1.hLF)
      {
        a(paramb1, true, true);
        e(paramb1.dce, paramb2);
        paramb1.hLG = System.currentTimeMillis();
        paramb2.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      f(paramb1.dce, paramb2);
      paramb2.drN();
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      AppMethodBeat.o(137046);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.dce });
    if (paramb1.hLF)
    {
      e(paramb1.dce, localh);
      paramb1.hLG = System.currentTimeMillis();
      localh.b(paramb1);
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localh.aJG()) || (localh.aJI()) || (localh.cMm()) || (localh.boS()) || (localh.isPaused())) {
          localh.stopPlay();
        }
        a(paramb1, true, true);
        localh.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.aJG())
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      if ((localh.aJI()) && (localh.isPaused()))
      {
        a(paramb1, true, true);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.boS())
      {
        a(paramb1, true, true);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.cMm())
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      a(paramb1, true, true);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
      localh.l(paramb1);
      AppMethodBeat.o(137046);
      return;
    }
    for (;;)
    {
      synchronized (this.qaE)
      {
        if (!this.whQ.contains(paramb1.dce)) {
          break label594;
        }
        if (i == 0)
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb1.dce, localh);
          localh.b(paramb1);
          if ((paramb2 != null) && (!paramb2.e(paramb1)))
          {
            ad.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localh.aJG()) || (localh.aJI()) || (localh.cMm()) || (localh.boS()) || (localh.isPaused())) {
              localh.stopPlay();
            }
          }
          localh.drN();
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
          AppMethodBeat.o(137046);
          return;
        }
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      continue;
      label594:
      i = 0;
    }
  }
  
  private void by(int paramInt, String paramString)
  {
    AppMethodBeat.i(137065);
    ad.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = e.drx();
    }
    paramString = new w();
    paramString.dkE.action = 4;
    paramString.dkE.state = "error";
    paramString.dkE.errCode = com.tencent.mm.plugin.music.f.a.e.LA(paramInt);
    paramString.dkE.errMsg = com.tencent.mm.plugin.music.f.a.e.uz(paramInt);
    paramString.dkE.dce = str;
    paramString.dkE.appId = arW(str);
    com.tencent.mm.sdk.b.a.IbL.a(paramString, Looper.getMainLooper());
    AppMethodBeat.o(137065);
  }
  
  static void c(String paramString, h paramh)
  {
    AppMethodBeat.i(137070);
    if (paramh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137070);
      return;
    }
    if ((paramh.aJG()) || (paramh.aJI()) || (paramh.cMm()) || (paramh.boS()) || (paramh.isPaused())) {
      paramh.stopPlay();
    }
    paramh.release();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137070);
  }
  
  static void d(String paramString, h paramh)
  {
    AppMethodBeat.i(137071);
    ad.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramh);
    AppMethodBeat.o(137071);
  }
  
  private h drA()
  {
    AppMethodBeat.i(137066);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.qaE)
    {
      if (this.whR.size() == 0)
      {
        localObject1 = new h();
        AppMethodBeat.o(137066);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.whS.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (h)this.whR.get(str);
        if (??? != null)
        {
          if ((!((h)???).hLV) && (!((h)???).isCompleted()) && (!((h)???).isStopped()))
          {
            if (((h)???).wiw == null) {
              break label422;
            }
            if (((h)???).wiw.getPlayerState() != 9) {
              break label417;
            }
            i = 1;
            break label395;
          }
          label169:
          if ((l1 != 0L) && (((h)???).gvN >= l1)) {
            break label380;
          }
          l1 = ((h)???).gvN;
          localObject1 = str;
          localObject5 = ???;
          break label402;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.qaE)
        {
          if (this.whS.contains(localObject5))
          {
            this.whR.remove(localObject5);
            this.whS.remove(localObject5);
          }
          if (this.whQ.contains(localObject5))
          {
            this.whQ.remove(localObject5);
            this.whP.remove(localObject5);
          }
          AppMethodBeat.o(137066);
          return localObject1;
        }
      }
    }
    Object localObject4 = new h();
    AppMethodBeat.o(137066);
    return localObject4;
    label395:
    label402:
    label417:
    label422:
    label425:
    for (;;)
    {
      label380:
      ??? = localObject4;
      localObject4 = localObject5;
      localObject5 = ???;
      for (;;)
      {
        if (i == 0) {
          break label425;
        }
        break label169;
        ??? = localObject5;
        localObject5 = localObject4;
        localObject4 = ???;
        break;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  private int drC()
  {
    AppMethodBeat.i(137077);
    int i;
    boolean bool;
    synchronized (this.qaE)
    {
      Iterator localIterator = this.whS.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        h localh = arS((String)localObject3);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = arQ((String)localObject3);
          if (localObject3 == null) {
            break label135;
          }
          bool = ((com.tencent.mm.aj.d)localObject3).tG;
        }
        else
        {
          bool = localh.isPaused();
        }
      }
      else
      {
        AppMethodBeat.o(137077);
        return i;
      }
    }
    label135:
    label138:
    for (;;)
    {
      for (;;)
      {
        if (!bool) {
          break label138;
        }
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  private void drD()
  {
    AppMethodBeat.i(137079);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.qaE)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.whS);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        h localh = (h)this.whR.get(str);
        if ((localh != null) && (localh.isPaused())) {
          a(str, localh);
        }
      }
    }
    AppMethodBeat.o(137079);
  }
  
  private void drE()
  {
    AppMethodBeat.i(137080);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.qaE)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.whS);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localh = (h)this.whR.remove(str);
        this.whS.remove(str);
        if (localh == null) {
          continue;
        }
        if (localh.hLV)
        {
          b(str, localh);
          d(str, localh);
        }
      }
      if (!localh.isPaused())
      {
        b(str, localh);
        c(str, localh);
      }
    }
    AppMethodBeat.o(137080);
  }
  
  private void drG()
  {
    AppMethodBeat.i(137086);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.dkC.hLD), Boolean.valueOf(this.wig.wjm) });
    if ((!this.dkC.hLD) && (!this.wig.wjm))
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      requestFocus();
      AppMethodBeat.o(137086);
      return;
    }
    if ((this.dkC.hLD) && (this.wig.wjm))
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bpH();
    }
    AppMethodBeat.o(137086);
  }
  
  private void drH()
  {
    AppMethodBeat.i(137089);
    this.wif = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wif != null) {
      this.wif.dsg();
    }
    AppMethodBeat.o(137089);
  }
  
  /* Error */
  public static void dry()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 811
    //   6: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 813	com/tencent/mm/plugin/music/b/f:wik	Lcom/tencent/mm/plugin/music/b/f;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 811
    //   18: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/f
    //   28: dup
    //   29: invokespecial 814	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   32: putstatic 813	com/tencent/mm/plugin/music/b/f:wik	Lcom/tencent/mm/plugin/music/b/f;
    //   35: ldc_w 811
    //   38: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	44	finally
    //   25	41	44	finally
  }
  
  public static f drz()
  {
    AppMethodBeat.i(137036);
    if (wik == null) {
      wik = new f();
    }
    f localf = wik;
    AppMethodBeat.o(137036);
    return localf;
  }
  
  private boolean eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(137053);
    paramString = (com.tencent.mm.aj.b)this.whW.get(paramString);
    if (paramString != null)
    {
      paramString.ddx = paramInt;
      AppMethodBeat.o(137053);
      return true;
    }
    AppMethodBeat.o(137053);
    return false;
  }
  
  private void i(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137044);
    if (this.wij.gf(paramb.dce)) {
      this.wij.c(paramb);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramb.filePath)) {
        asd(paramb.dce);
      }
      AppMethodBeat.o(137044);
      return;
      this.wij.b(paramb);
    }
  }
  
  private void ic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137040);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137040);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.whT.contains(paramString1)) {
      this.whT.add(paramString1);
    }
    if (!this.whO.contains(paramString2)) {
      this.whO.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.whV.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.whV.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137040);
  }
  
  private void j(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137090);
    this.wif = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wif != null) {
      this.wif.ie(paramb.dce, paramb.ddp);
    }
    AppMethodBeat.o(137090);
  }
  
  private static void k(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137093);
    if (paramb.hLS != null) {
      try
      {
        paramb.hLS.close();
        paramb.hLS = null;
        AppMethodBeat.o(137093);
        return;
      }
      catch (Exception paramb)
      {
        ad.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
    AppMethodBeat.o(137093);
  }
  
  private void requestFocus()
  {
    AppMethodBeat.i(137087);
    if (this.wig.wjm)
    {
      AppMethodBeat.o(137087);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.wig.requestFocus()) });
    AppMethodBeat.o(137087);
  }
  
  public final boolean CH(String paramString)
  {
    AppMethodBeat.i(137055);
    h localh = arS(paramString);
    if (localh == null)
    {
      if (this.wij.gf(paramString))
      {
        bool = this.wij.fS(paramString);
        AppMethodBeat.o(137055);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137055);
      return false;
    }
    boolean bool = localh.aJG();
    AppMethodBeat.o(137055);
    return bool;
  }
  
  public final com.tencent.mm.aj.b CI(String paramString)
  {
    AppMethodBeat.i(137060);
    if (this.whW.containsKey(paramString))
    {
      paramString = (com.tencent.mm.aj.b)this.whW.get(paramString);
      AppMethodBeat.o(137060);
      return paramString;
    }
    AppMethodBeat.o(137060);
    return null;
  }
  
  public final void _release()
  {
    AppMethodBeat.i(137038);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.whO.clear();
    String str;
    synchronized (this.qaE)
    {
      Iterator localIterator = this.whQ.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (h)this.whP.remove(str));
      }
    }
    this.whQ.clear();
    this.whP.clear();
    Object localObject3 = this.whS.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (h)this.whR.remove(str));
    }
    this.whS.clear();
    this.whR.clear();
    ??? = this.whT.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.whV.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.whT.clear();
    this.whU.clear();
    this.whV.clear();
    this.whW.clear();
    this.whX.clear();
    this.whZ.clear();
    this.wia.clear();
    aq.aA(this.wim);
    aq.aA(this.win);
    this.wib = false;
    this.wic = false;
    AppMethodBeat.o(137038);
  }
  
  public final boolean arK(String paramString)
  {
    AppMethodBeat.i(137048);
    h localh = arS(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.wij.gf(paramString))
      {
        this.wij.gi(paramString);
        AppMethodBeat.o(137048);
        return true;
      }
      AppMethodBeat.o(137048);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localh.pause();
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137048);
    return true;
  }
  
  public final boolean arL(String paramString)
  {
    AppMethodBeat.i(137049);
    h localh = arS(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.wij.gf(paramString))
      {
        this.wij.gj(paramString);
        AppMethodBeat.o(137049);
        return true;
      }
      AppMethodBeat.o(137049);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localh.stopPlay();
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.whW.get(paramString);
    if (localb != null)
    {
      localb.ddx = 0;
      localb.hLF = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137049);
    return true;
  }
  
  public final boolean arM(String paramString)
  {
    AppMethodBeat.i(137050);
    if (this.wij.gf(paramString)) {
      this.wij.gj(paramString);
    }
    h localh = arS(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137050);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localh.dsa();
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.whW.get(paramString);
    if (localb != null)
    {
      localb.ddx = 0;
      localb.hLF = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137050);
    return true;
  }
  
  public final boolean arN(String paramString)
  {
    AppMethodBeat.i(137051);
    this.wij.gj(paramString);
    this.wij.remove(paramString);
    ??? = arS(paramString);
    if (??? == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      AppMethodBeat.o(137051);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.qaE)
    {
      this.whP.remove(paramString);
      this.whQ.remove(paramString);
      this.whR.remove(paramString);
      this.whS.remove(paramString);
      this.whO.remove(paramString);
      ??? = this.whT.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.whV.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.whV.remove(str);
            this.whT.remove(str);
            this.whU.remove(str);
          }
        }
      }
      this.whW.remove(paramString);
      this.whX.remove(paramString);
      AppMethodBeat.o(137051);
      return true;
    }
  }
  
  public final boolean arO(String paramString)
  {
    AppMethodBeat.i(137054);
    h localh = arS(paramString);
    if (localh == null)
    {
      if (this.wij.gf(paramString))
      {
        bool = this.wij.gk(paramString);
        AppMethodBeat.o(137054);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137054);
      return false;
    }
    boolean bool = localh.aJI();
    AppMethodBeat.o(137054);
    return bool;
  }
  
  public final boolean arP(String paramString)
  {
    AppMethodBeat.i(137057);
    h localh = arS(paramString);
    if (localh == null)
    {
      if (this.wij.gf(paramString))
      {
        bool = this.wij.Pq();
        AppMethodBeat.o(137057);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = arQ(paramString);
      if (paramString != null)
      {
        bool = paramString.hLV;
        AppMethodBeat.o(137057);
        return bool;
      }
      AppMethodBeat.o(137057);
      return false;
    }
    boolean bool = localh.hLV;
    AppMethodBeat.o(137057);
    return bool;
  }
  
  public final com.tencent.mm.aj.d arQ(String paramString)
  {
    AppMethodBeat.i(137058);
    Object localObject = arS(paramString);
    if (localObject != null)
    {
      paramString = ((h)localObject).dsd();
      AppMethodBeat.o(137058);
      return paramString;
    }
    if (this.wij.gf(paramString))
    {
      localObject = this.wij.gp(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137058);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.aj.d)this.whX.get(paramString);
    AppMethodBeat.o(137058);
    return paramString;
  }
  
  public final int arR(String paramString)
  {
    AppMethodBeat.i(137059);
    int j = drC();
    synchronized (this.qaE)
    {
      int k = this.whO.size();
      int m = this.whP.size();
      int n = this.whR.size();
      paramString = (LinkedList)this.whV.get(paramString);
      if (paramString == null)
      {
        i = 0;
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(137059);
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final h arS(String paramString)
  {
    AppMethodBeat.i(137061);
    if (this.whP.containsKey(paramString))
    {
      paramString = (h)this.whP.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    if (this.whR.containsKey(paramString))
    {
      paramString = (h)this.whR.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    AppMethodBeat.o(137061);
    return null;
  }
  
  public final void arT(String paramString)
  {
    AppMethodBeat.i(137062);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.wij.Pp();
    bpH();
    Object localObject3 = (LinkedList)this.whV.get(paramString);
    long l1 = this.wij.Ps();
    long l2 = com.tencent.mm.audio.mix.b.e.Ou().Ov();
    long l3 = com.tencent.mm.audio.mix.b.d.Os().Ot();
    long l4 = l2 + l3;
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.wif = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137062);
      return;
    }
    if ((this.whP.isEmpty()) && (this.whR.isEmpty()))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.wif != null) {
        this.wif.c(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137062);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.qaE)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        h localh = (h)this.whR.get(localObject3);
        if (localh != null) {
          a((String)localObject3, localh);
        }
      }
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.whP.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (h)this.whP.get(???);
      if (localObject3 != null)
      {
        a((String)???, (h)localObject3);
        f((String)???, (h)localObject3);
      }
    }
    if (this.wif != null) {
      this.wif.c(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137062);
  }
  
  public final void arU(String paramString)
  {
    AppMethodBeat.i(137063);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bpH();
    LinkedList localLinkedList = (LinkedList)this.whV.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137063);
      return;
    }
    String str;
    h localh;
    synchronized (this.qaE)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localh = (h)this.whP.remove(str);
        this.whQ.remove(str);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localh);
        this.whW.remove(str);
        this.whX.remove(str);
        if (this.wij.gf(str))
        {
          this.wij.gj(str);
          this.wij.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localh = (h)this.whR.remove(str);
      this.whS.remove(str);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localh);
      this.whW.remove(str);
      this.whX.remove(str);
      if (this.wij.gf(str))
      {
        this.wij.gj(str);
        this.wij.remove(str);
      }
    }
    this.whO.removeAll(localLinkedList);
    this.whT.remove(paramString);
    this.whU.remove(paramString);
    this.wij.clearCache();
    this.wij.Pr();
    this.wih.clear();
    this.wii.clear();
    AppMethodBeat.o(137063);
  }
  
  public final void asb(String paramString)
  {
    AppMethodBeat.i(137084);
    if (this.whT.size() == 0)
    {
      AppMethodBeat.o(137084);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.whT);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.whU.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        arU(str1);
      }
    }
    AppMethodBeat.o(137084);
  }
  
  final boolean asc(String paramString)
  {
    AppMethodBeat.i(137085);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.qaE)
      {
        i = this.whP.size();
        if (i <= 5)
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137085);
          return false;
        }
        localObject3 = this.whQ.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.aj.b)this.whW.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.aj.b)localObject4).ddp == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.aj.b)localObject4).ddp))
        {
          localHashMap1.put(((com.tencent.mm.aj.b)localObject4).ddp, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.aj.b)localObject4).dce);
          localHashMap2.put(((com.tencent.mm.aj.b)localObject4).ddp, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.aj.b)localObject4).ddp)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.aj.b)localObject4).ddp);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.aj.b)localObject4).ddp)).intValue();
      localHashMap1.put(((com.tencent.mm.aj.b)localObject4).ddp, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.aj.b)localObject4).ddp);
      if (!localArrayList.contains(((com.tencent.mm.aj.b)localObject4).dce)) {
        localArrayList.add(((com.tencent.mm.aj.b)localObject4).dce);
      }
      localHashMap2.put(((com.tencent.mm.aj.b)localObject4).ddp, localArrayList);
    }
    paramString = (com.tencent.mm.aj.b)this.whW.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.ddp)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        AppMethodBeat.o(137085);
        return false;
      }
    }
    paramString = "";
    ad.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      ad.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
      if (j < 2) {
        break label788;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label785;
      }
      paramString = (String)???;
      i = j;
      label534:
      j = i;
      localObject1 = paramString;
      bool1 = bool2;
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = ???;
        bool1 = bool2;
        j = i;
      }
    }
    for (;;)
    {
      i = j;
      paramString = (String)localObject1;
      break;
      if (bool1)
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.mm.aj.b)this.whW.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new a());
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.aj.b)paramString.next()).dce);
          }
          this.wia.add(((LinkedList)localObject1).getLast());
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.wia.size()) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137085);
        return bool1;
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      label785:
      break label534;
      label788:
      j = i;
      localObject1 = paramString;
    }
  }
  
  public final void asd(final String paramString)
  {
    AppMethodBeat.i(137092);
    if (!b.drw())
    {
      AppMethodBeat.o(137092);
      return;
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(137023);
        com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.whW.get(paramString);
        if (localb == null) {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
        }
        long l1;
        long l2;
        com.tencent.mm.audio.mix.f.c localc;
        int i;
        int j;
        if ((!TextUtils.isEmpty(localb.filePath)) && (!f.this.wij.gs(localb.filePath)))
        {
          l1 = com.tencent.mm.audio.mix.h.a.gy(localb.filePath);
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", new Object[] { localb.filePath, Long.valueOf(l1) });
          l2 = com.tencent.mm.audio.mix.b.e.Ou().Ov();
          localc = f.this.wij;
          long l3 = com.tencent.mm.audio.mix.b.e.Ou().Ov();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
          if (l3 >= 50000000L)
          {
            i = 1;
            if (i != 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
            }
            j = 0;
            if (f.this.wii.containsKey(localb.filePath)) {
              j = ((Integer)f.this.wii.get(localb.filePath)).intValue();
            }
            if (i == 0) {
              break label288;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
            if (f.this.wif != null) {
              f.this.wif.KX(713);
            }
            f.this.wij.gq("");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137023);
          return false;
          i = 0;
          break;
          label288:
          if (l2 + l1 > 50000000L)
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
            if (f.this.wif != null) {
              f.this.wif.KX(714);
            }
            f.this.wij.gq("");
          }
          else if (j >= 30)
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
          }
          else if (!com.tencent.mm.audio.mix.h.a.gx(localb.filePath))
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
          }
          else
          {
            localc = f.this.wij;
            String str = localb.filePath;
            if (!localc.deP.fO(str))
            {
              localb.hLU = true;
              localb.fileSize = l1;
              f.this.wij.a(localb);
            }
            else
            {
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
              continue;
              if (!TextUtils.isEmpty(localb.filePath))
              {
                localb.hLU = false;
                if (!f.this.wij.gf(paramString)) {
                  f.this.wij.b(localb);
                }
                localb.fileSize = com.tencent.mm.audio.mix.h.a.gy(localb.filePath);
              }
              else
              {
                localb.hLU = false;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(137092);
  }
  
  final void b(String paramString, h paramh)
  {
    AppMethodBeat.i(137069);
    this.whX.put(paramString, paramh.dsd());
    AppMethodBeat.o(137069);
  }
  
  public final boolean b(String paramString, com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137047);
    com.tencent.mm.aj.b localb2 = (com.tencent.mm.aj.b)this.whW.get(paramString);
    com.tencent.mm.aj.b localb1;
    boolean bool1;
    if (((!this.whO.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      j(localb1);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      int i = arR(arW(paramString));
      if (i >= 10)
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!asa(paramString)) {
          break label368;
        }
        drF();
      }
      drG();
      this.whW.put(paramString, localb1);
      paramb = arS(paramString);
      if (!b.drw()) {
        break label451;
      }
      boolean bool2 = a(paramb);
      if ((!this.wij.gf(paramString)) || (!this.wij.gr(paramString))) {
        break label388;
      }
      bool1 = true;
      label200:
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.dce });
      if ((!bool2) || (!bool1)) {
        break label459;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      arX(localb1.dce);
      k(localb1);
      if (!this.wij.fS(localb1.dce)) {
        break label394;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (!this.whO.contains(paramString))
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        by(601, paramString);
        AppMethodBeat.o(137047);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      by(602, paramString);
      AppMethodBeat.o(137047);
      return false;
      label368:
      drH();
      by(600, paramString);
      AppMethodBeat.o(137047);
      return false;
      label388:
      bool1 = false;
      break label200;
      label394:
      if (this.wij.gl(localb1.dce))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.hLF = true;
        paramb.b(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.wij.gg(paramString);
      }
    }
    label451:
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label459:
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      arY(paramString);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = drA();
      paramb.a(this.wil);
      paramb.ase(paramString);
      e(paramString, paramb);
      localb1.hLF = true;
      localb1.ddx = 0;
      localb1.hLG = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.l(localb1);
      AppMethodBeat.o(137047);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.aJI()) && (!paramb.aJG()))
    {
      a(localb1, false, true);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (paramb.boS())
      {
        a(localb1, false, true);
        localb1.hLF = true;
        localb1.hLG = System.currentTimeMillis();
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.ddx = 0;
        paramb.b(localb1);
      }
      else if (paramb.cMm())
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.hLF = true;
        localb1.hLG = System.currentTimeMillis();
        paramb.b(localb1);
      }
      else if (paramb.hLV)
      {
        a(localb1, false, true);
        localb1.hLF = true;
        localb1.hLG = System.currentTimeMillis();
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
        paramb.l(localb1);
      }
      else
      {
        if (paramb.aJI()) {
          break;
        }
        a(localb1, false, true);
        localb1.hLF = true;
        localb1.hLG = System.currentTimeMillis();
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.l(localb1);
        localb1.ddx = 0;
      }
    }
    ad.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137047);
    return false;
  }
  
  final void bpH()
  {
    AppMethodBeat.i(137088);
    if (this.wig.wjm) {
      this.wig.bpH();
    }
    AppMethodBeat.o(137088);
  }
  
  public final void drB()
  {
    AppMethodBeat.i(137076);
    long l = System.currentTimeMillis();
    if ((this.wib) && (l - this.wid < 10000L))
    {
      AppMethodBeat.o(137076);
      return;
    }
    this.wid = l;
    synchronized (this.qaE)
    {
      this.wib = true;
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      aq.aA(this.win);
      aq.o(this.win, 1800000L);
      AppMethodBeat.o(137076);
      return;
    }
  }
  
  final void drF()
  {
    AppMethodBeat.i(137083);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.whY.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      arL(str);
      drH();
    }
    localIterator = this.wia.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      arL(str);
      drH();
    }
    this.whY.clear();
    this.wia.clear();
    AppMethodBeat.o(137083);
  }
  
  final void e(String paramString, h paramh)
  {
    AppMethodBeat.i(137072);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.qaE)
    {
      if (this.whS.contains(paramString))
      {
        this.whR.remove(paramString);
        this.whS.remove(paramString);
      }
      if (!this.whQ.contains(paramString))
      {
        this.whQ.add(paramString);
        this.whP.put(paramString, paramh);
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  public final boolean et(String paramString, int paramInt)
  {
    AppMethodBeat.i(137052);
    h localh = arS(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.wij.gf(paramString)) {
        this.wij.y(paramString, paramInt);
      }
      bool = eu(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if (paramInt < 0)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    if (localh.getDuration() <= 0)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      localh.drS();
      bool = eu(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if ((paramInt > 0) && (paramInt > localh.getDuration()))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((localh.aJG()) || (localh.aJI()) || (localh.isPaused()))
    {
      bool = localh.pO(paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    localh.drS();
    boolean bool = eu(paramString, paramInt);
    AppMethodBeat.o(137052);
    return bool;
  }
  
  final void f(String paramString, h paramh)
  {
    AppMethodBeat.i(137073);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.qaE)
    {
      if (this.whQ.contains(paramString))
      {
        this.whP.remove(paramString);
        this.whQ.remove(paramString);
      }
      if (!this.whS.contains(paramString))
      {
        this.whS.add(paramString);
        this.whR.put(paramString, paramh);
      }
      AppMethodBeat.o(137073);
      return;
    }
  }
  
  public final boolean g(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137042);
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137042);
      return false;
    }
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.whW.get(paramb.dce);
    if (localb != null)
    {
      localb.f(paramb);
      h localh = arS(paramb.dce);
      if (localh == null) {
        break label130;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localh.b(localb);
      label76:
      if (b.drw())
      {
        if (!this.wij.gf(paramb.dce)) {
          break label141;
        }
        this.wij.c(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137042);
      return true;
      this.whW.put(paramb.dce, paramb);
      localb = paramb;
      break;
      label130:
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label76;
      label141:
      this.wij.b(paramb);
    }
  }
  
  public final boolean gn(String paramString)
  {
    AppMethodBeat.i(137056);
    h localh = arS(paramString);
    if (localh == null)
    {
      if (this.wij.gf(paramString))
      {
        bool = this.wij.gn(paramString);
        AppMethodBeat.o(137056);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      AppMethodBeat.o(137056);
      return true;
    }
    boolean bool = localh.isStopped();
    AppMethodBeat.o(137056);
    return bool;
  }
  
  public final boolean h(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137043);
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      by(605, "");
      AppMethodBeat.o(137043);
      return false;
    }
    if (TextUtils.isEmpty(paramb.dce))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      by(604, paramb.dce);
      AppMethodBeat.o(137043);
      return false;
    }
    if (!this.whO.contains(paramb.dce))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      by(601, paramb.dce);
      AppMethodBeat.o(137043);
      return false;
    }
    if (paramb.hLF) {
      j(paramb);
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject2 = arW(paramb.dce);
    Object localObject1 = CI(paramb.dce);
    int i = arR((String)localObject2);
    boolean bool2;
    boolean bool3;
    if (i >= 10)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i) });
      this.whW.put(paramb.dce, paramb);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.hLF) });
      if ((paramb.hLF) && (asa(paramb.dce))) {
        drF();
      }
    }
    else
    {
      arY(paramb.dce);
      drG();
      this.whU.put(localObject2, paramb.processName);
      this.whW.put(paramb.dce, paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (this.wih.containsKey(paramb.ddp))) {
        paramb.filePath = ((String)this.wih.get(paramb.ddp));
      }
      localObject2 = arS(paramb.dce);
      bool2 = b.drw();
      if (!bool2) {
        break label552;
      }
      bool3 = a((h)localObject2);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.wij.gs(paramb.filePath))) && ((localObject1 == null) || (!paramb.e((com.tencent.mm.aj.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.aj.b)localObject1).filePath)) || (!this.wij.gs(((com.tencent.mm.aj.b)localObject1).filePath)))) {
        break label547;
      }
    }
    label547:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.dce });
      if ((!bool3) || (!bool1)) {
        break;
      }
      a(paramb, (com.tencent.mm.aj.b)localObject1);
      AppMethodBeat.o(137043);
      return true;
      if (paramb.hLF)
      {
        by(600, paramb.dce);
        drH();
        AppMethodBeat.o(137043);
        return false;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = arS(paramb.dce);
      if (localObject1 != null)
      {
        ((h)localObject1).b(paramb);
        ((h)localObject1).drN();
      }
      AppMethodBeat.o(137043);
      return true;
    }
    label552:
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    b(paramb, (com.tencent.mm.aj.b)localObject1);
    if (bool2) {
      i(paramb);
    }
    AppMethodBeat.o(137043);
    return true;
  }
  
  public final String id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137041);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.whV.get(paramString1);
    Object localObject = this.qaE;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.whQ.contains(paramString2)) {
            break label241;
          }
          if (this.whS.contains(paramString2))
          {
            break label241;
            j = arR(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label133;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            by(604, paramString2);
            AppMethodBeat.o(137041);
            return null;
          }
        }
        i = 0;
        continue;
        if (j < 10) {
          break label174;
        }
      }
      finally
      {
        AppMethodBeat.o(137041);
      }
      label133:
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      ic(paramString1, paramString2);
      AppMethodBeat.o(137041);
      return null;
      label174:
      if (i != 0)
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        by(603, paramString2);
        AppMethodBeat.o(137041);
        return null;
      }
      ic(paramString1, paramString2);
      arY(paramString2);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137041);
      return paramString2;
      label241:
      int i = 1;
    }
  }
  
  public final class a
    implements Comparator<com.tencent.mm.aj.b>
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */