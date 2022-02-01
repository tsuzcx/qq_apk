package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
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
  private static f tUg;
  com.tencent.mm.aj.a dbL;
  Object oTO;
  private LinkedList<String> tTK;
  HashMap<String, h> tTL;
  LinkedList<String> tTM;
  HashMap<String, h> tTN;
  LinkedList<String> tTO;
  public LinkedList<String> tTP;
  private HashMap<String, String> tTQ;
  HashMap<String, LinkedList<String>> tTR;
  HashMap<String, com.tencent.mm.aj.b> tTS;
  private HashMap<String, com.tencent.mm.aj.d> tTT;
  private LinkedList<String> tTU;
  HashMap<String, Integer> tTV;
  private LinkedList<String> tTW;
  boolean tTX;
  private boolean tTY;
  long tTZ;
  private long tUa;
  com.tencent.mm.plugin.music.b.a.d tUb;
  private com.tencent.mm.plugin.music.b.b.a tUc;
  private HashMap<String, String> tUd;
  HashMap<String, Integer> tUe;
  com.tencent.mm.audio.mix.f.c tUf;
  private c tUh;
  private Runnable tUi;
  Runnable tUj;
  private com.tencent.mm.audio.mix.f.b tUk;
  private com.tencent.mm.audio.mix.f.g tUl;
  
  private f()
  {
    AppMethodBeat.i(137037);
    this.tTK = new LinkedList();
    this.tTL = new HashMap();
    this.tTM = new LinkedList();
    this.tTN = new HashMap();
    this.tTO = new LinkedList();
    this.tTP = new LinkedList();
    this.tTQ = new HashMap();
    this.tTR = new HashMap();
    this.tTS = new HashMap();
    this.tTT = new HashMap();
    this.tTU = new LinkedList();
    this.tTV = new HashMap();
    this.tTW = new LinkedList();
    this.oTO = new Object();
    this.tTX = false;
    this.tTY = false;
    this.tTZ = 0L;
    this.tUa = 0L;
    this.dbL = new com.tencent.mm.aj.a();
    this.tUc = new com.tencent.mm.plugin.music.b.b.a();
    this.tUd = new HashMap();
    this.tUe = new HashMap();
    this.tUh = new c()
    {
      public final void XM(String paramAnonymousString)
      {
        AppMethodBeat.i(137018);
        h localh = f.this.ahY(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
          AppMethodBeat.o(137018);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.cTF();
        f.a(f.this, paramAnonymousString);
        f.this.aij(paramAnonymousString);
        AppMethodBeat.o(137018);
      }
      
      public final void ahP(String paramAnonymousString)
      {
        AppMethodBeat.i(137017);
        h localh = f.this.ahY(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
          AppMethodBeat.o(137017);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.cTF();
        AppMethodBeat.o(137017);
      }
      
      public final void fr(String paramAnonymousString)
      {
        AppMethodBeat.i(137019);
        h localh = f.this.ahY(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
          AppMethodBeat.o(137019);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.cTF();
        f.a(f.this, paramAnonymousString);
        f.this.aij(paramAnonymousString);
        AppMethodBeat.o(137019);
      }
      
      public final void onError(String paramAnonymousString)
      {
        AppMethodBeat.i(137020);
        h localh = f.this.ahY(paramAnonymousString);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
          AppMethodBeat.o(137020);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f localf = f.this;
        int j = localh.oTe;
        if (localf.tTV.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localf.tTV.get(paramAnonymousString)).intValue();; i = 0)
        {
          if (i > 0)
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            localf.tTV.remove(paramAnonymousString);
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label189;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            f.this.cTJ();
            f.this.b(paramAnonymousString, null);
            AppMethodBeat.o(137020);
            return;
            if (66 != j)
            {
              localf.tTV.remove(paramAnonymousString);
              break;
            }
            if (!localf.aii(paramAnonymousString)) {
              break;
            }
            localf.tTV.put(paramAnonymousString, Integer.valueOf(i + 1));
          }
          label189:
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
          f.this.f(paramAnonymousString, localh);
          f.a(f.this);
          f.this.cTF();
          AppMethodBeat.o(137020);
          return;
        }
      }
      
      public final void onStart(String arg1)
      {
        AppMethodBeat.i(137016);
        h localh = f.this.ahY(???);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
          AppMethodBeat.o(137016);
          return;
        }
        f.this.e(???, localh);
        synchronized (f.this.oTO)
        {
          f.this.tTX = false;
          aq.az(f.this.tUj);
          AppMethodBeat.o(137016);
          return;
        }
      }
    };
    this.tUi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137021);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
        Iterator localIterator = f.this.tTP.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (f.this.ahX(str) == 0) {
            f.this.ahZ(str);
          }
        }
        AppMethodBeat.o(137021);
      }
    };
    this.tUj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137022);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
        Iterator localIterator = f.this.tTP.iterator();
        int i = 0;
        f localf;
        Object localObject5;
        if (localIterator.hasNext())
        {
          ??? = (String)localIterator.next();
          if (f.this.ahX((String)???) != 0) {
            break label450;
          }
          localf = f.this;
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
          localObject5 = (LinkedList)localf.tTR.get(???);
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
            synchronized (localf.oTO)
            {
              localObject6 = ((LinkedList)localObject5).iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (String)((Iterator)localObject6).next();
              if (localf.tUf.fu((String)localObject7)) {
                localf.tUf.fy((String)localObject7);
              }
              localh = (h)localf.tTL.remove(localObject7);
              localf.tTM.remove(localObject7);
              if (localh == null) {
                continue;
              }
              localf.b((String)localObject7, localh);
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
              if (localh.gTe) {
                f.d((String)localObject7, localh);
              }
            }
            f.c((String)localObject7, localh);
          }
          localObject5 = ((LinkedList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localf.tUf.fu((String)localObject6)) {
              localf.tUf.fy((String)localObject6);
            }
            localObject7 = (h)localf.tTN.remove(localObject6);
            localf.tTO.remove(localObject6);
            if (localObject7 != null)
            {
              localf.b((String)localObject6, (h)localObject7);
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
              if (((h)localObject7).gTe) {
                f.d((String)localObject6, (h)localObject7);
              } else {
                f.c((String)localObject6, (h)localObject7);
              }
            }
          }
          break label112;
          if (i == 0) {}
          synchronized (f.this.oTO)
          {
            f.this.tTX = true;
            f.this.tTZ = System.currentTimeMillis();
            aq.n(f.this.tUj, 1800000L);
            AppMethodBeat.o(137022);
            return;
          }
        }
      }
    };
    this.tUk = new com.tencent.mm.audio.mix.f.b()
    {
      public final void b(v paramAnonymousv)
      {
        AppMethodBeat.i(137024);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137024);
      }
      
      public final void c(v paramAnonymousv)
      {
        AppMethodBeat.i(137025);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137025);
      }
      
      public final void d(v paramAnonymousv)
      {
        AppMethodBeat.i(137026);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137026);
      }
      
      public final void e(v paramAnonymousv)
      {
        AppMethodBeat.i(137027);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137027);
      }
      
      public final void f(v paramAnonymousv)
      {
        AppMethodBeat.i(137028);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137028);
      }
      
      public final void g(v paramAnonymousv)
      {
        AppMethodBeat.i(137029);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137029);
      }
      
      public final void h(v paramAnonymousv)
      {
        AppMethodBeat.i(137030);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137030);
      }
      
      public final void i(v paramAnonymousv)
      {
        AppMethodBeat.i(137031);
        com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
        AppMethodBeat.o(137031);
      }
      
      public final void j(v paramAnonymousv)
      {
        AppMethodBeat.i(137032);
        int i = paramAnonymousv.dbN.errCode;
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
        if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
        }
        while (f.this.tUb != null)
        {
          com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.tTS.get(paramAnonymousv.dbN.cTr);
          if (localb == null)
          {
            AppMethodBeat.o(137032);
            return;
            com.tencent.mm.sdk.b.a.ESL.a(paramAnonymousv, Looper.getMainLooper());
          }
          else
          {
            f.this.tUb.Hv(paramAnonymousv.dbN.errCode);
            if (!f.this.tUf.fH(localb.filePath))
            {
              if (f.this.tUe.containsKey(localb.filePath))
              {
                i = ((Integer)f.this.tUe.get(localb.filePath)).intValue();
                f.this.tUe.put(localb.filePath, Integer.valueOf(i + 1));
                AppMethodBeat.o(137032);
                return;
              }
              f.this.tUe.put(localb.filePath, Integer.valueOf(1));
            }
          }
        }
        AppMethodBeat.o(137032);
      }
      
      public final void k(v paramAnonymousv)
      {
        AppMethodBeat.i(137033);
        if (f.this.tUb != null)
        {
          com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.tTS.get(paramAnonymousv.dbN.cTr);
          if (localb == null)
          {
            AppMethodBeat.o(137033);
            return;
          }
          if (localb.gSU > 1000000L) {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.cTr, Long.valueOf(localb.gSU) });
          }
          Object localObject = paramAnonymousv.dbN.cUD;
          paramAnonymousv = (v)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramAnonymousv = localb.cUD;
          }
          localObject = f.this.tUb;
          String str1 = localb.cTr;
          long l1 = System.currentTimeMillis();
          long l2 = localb.gSS;
          long l3 = localb.gST;
          long l4 = localb.gSU;
          String str2 = localb.filePath;
          long l5 = f.this.tUf.fD(localb.cTr);
          long l6 = localb.fileSize;
          String str3 = localb.filePath;
          ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramAnonymousv, l1 - l2, l3, l4, false, str2, l5, l6, com.tencent.mm.audio.mix.b.e.MN().fb(str3));
          if (f.this.tUe.containsKey(localb.filePath)) {
            f.this.tUe.remove(localb.filePath);
          }
        }
        AppMethodBeat.o(137033);
      }
    };
    this.tUl = new com.tencent.mm.audio.mix.f.g()
    {
      public final void hW(int paramAnonymousInt)
      {
        AppMethodBeat.i(137034);
        if (f.this.tUb != null) {
          f.this.tUb.Hu(paramAnonymousInt);
        }
        AppMethodBeat.o(137034);
      }
    };
    cTD();
    this.tUf = new com.tencent.mm.audio.mix.f.c();
    this.tUf.a(this.tUk);
    this.tUf.a(this.tUl);
    AppMethodBeat.o(137037);
  }
  
  private void a(com.tencent.mm.aj.b paramb1, com.tencent.mm.aj.b paramb2)
  {
    AppMethodBeat.i(137045);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    aid(paramb1.cTr);
    k(paramb1);
    if ((TextUtils.isEmpty(paramb1.filePath)) && (paramb2 != null) && (paramb2.e(paramb1))) {
      paramb1.filePath = paramb2.filePath;
    }
    if (paramb1.gSN)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        a(paramb1, true, false);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.tUf.fh(paramb1.cTr)) || (this.tUf.fz(paramb1.cTr)) || (this.tUf.fA(paramb1.cTr)) || (this.tUf.fB(paramb1.cTr)) || (this.tUf.isPaused(paramb1.cTr))) {
          this.tUf.fy(paramb1.cTr);
        }
        this.tUf.a(paramb1);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.tUf.fh(paramb1.cTr))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      if ((this.tUf.fz(paramb1.cTr)) && (this.tUf.isPaused(paramb1.cTr)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.tUf.fw(paramb1.cTr);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.tUf.fB(paramb1.cTr))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.tUf.fw(paramb1.cTr);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.tUf.fA(paramb1.cTr))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.tUf.a(paramb1);
      AppMethodBeat.o(137045);
      return;
    }
    if (this.tUf.fu(paramb1.cTr)) {
      this.tUf.c(paramb1);
    }
    for (;;)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.tUf.fh(paramb1.cTr)) || (this.tUf.fz(paramb1.cTr)) || (this.tUf.fA(paramb1.cTr)) || (this.tUf.fB(paramb1.cTr)) || (this.tUf.isPaused(paramb1.cTr))) {
          this.tUf.fy(paramb1.cTr);
        }
      }
      this.tUf.o(7, paramb1.cTr);
      AppMethodBeat.o(137045);
      return;
      this.tUf.b(paramb1);
    }
  }
  
  private void a(com.tencent.mm.aj.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137091);
    this.tUb = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.tUb != null) {
      this.tUb.r(paramb.cTr, paramb.cUD, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.gSS = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.gSW;
    }
    for (paramb.gST = paramb.gSV; (l1 > 0L) && (l2 > l1); paramb.gST = paramb.gSX)
    {
      paramb.gSU = (l2 - l1);
      AppMethodBeat.o(137091);
      return;
      l1 = paramb.gSY;
    }
    paramb.gSU = 0L;
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
    this.tTQ.put(paramb.appId, paramb.processName);
    this.tTS.put(paramb.cTr, paramb);
    hy(paramb.appId, paramString);
    this.tTV.remove(paramString);
    AppMethodBeat.o(137039);
  }
  
  private void a(String paramString, h paramh)
  {
    AppMethodBeat.i(137068);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    if ((localb != null) && (paramh.azF()) && (paramh.azH()))
    {
      localb.gSN = true;
      localb.cUL = paramh.cUi();
    }
    for (;;)
    {
      b(paramString, paramh);
      paramString = ahW(paramString);
      if ((paramString != null) && (paramh.azF())) {
        paramString.qM = true;
      }
      if ((!paramh.azF()) && (!paramh.azH()) && (!paramh.cUd()) && (!paramh.ben()) && (!paramh.isPaused())) {
        break;
      }
      paramh.cUf();
      AppMethodBeat.o(137068);
      return;
      if ((localb != null) && (paramh.azH()))
      {
        localb.gSN = true;
        localb.cUL = paramh.cUi();
      }
      else if (localb != null)
      {
        localb.gSN = true;
        localb.cUL = 0;
      }
    }
    paramh.cUe();
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
    if ((paramh.azF()) || (paramh.isPaused()) || (paramh.cUd()) || (paramh.ben()) || (paramh.azH())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    AppMethodBeat.o(137075);
    return false;
  }
  
  private void aib(String arg1)
  {
    AppMethodBeat.i(137064);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.tTR.get(???);
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
      synchronized (this.oTO)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.tUf.fu(str)) {
          this.tUf.fy(str);
        }
        localh = (h)this.tTN.remove(str);
        this.tTO.remove(str);
        if (localh == null) {
          continue;
        }
        b(str, localh);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localh.gTe) {
          d(str, localh);
        }
      }
      c(str, localh);
    }
    AppMethodBeat.o(137064);
  }
  
  private String aic(String paramString)
  {
    AppMethodBeat.i(137067);
    Iterator localIterator = this.tTP.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.tTR.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137067);
        return str;
      }
    }
    AppMethodBeat.o(137067);
    return "";
  }
  
  private boolean aid(String paramString)
  {
    AppMethodBeat.i(137074);
    ??? = ahY(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137074);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.oTO)
    {
      this.tTL.remove(paramString);
      this.tTM.remove(paramString);
      this.tTN.remove(paramString);
      this.tTO.remove(paramString);
      AppMethodBeat.o(137074);
      return true;
    }
  }
  
  private void aie(String paramString)
  {
    AppMethodBeat.i(137078);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.tTL.size();
    int j = this.tTN.size();
    int k = cTG();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      cTH();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = aic(paramString);
      i = this.tTL.size();
      j = this.tTN.size();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.tTP.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          aif(str);
        }
      }
      if (k >= 6) {
        cTH();
      } else if (i + k >= 8) {
        cTH();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.tTP.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          aif(str);
        }
      }
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.tTN.size();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      cTI();
      AppMethodBeat.o(137078);
      return;
    }
    if (j + i >= 50)
    {
      cTI();
      AppMethodBeat.o(137078);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137078);
  }
  
  private void aif(String paramString)
  {
    AppMethodBeat.i(137081);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    aib(paramString);
    AppMethodBeat.o(137081);
  }
  
  private boolean aig(String paramString)
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
      synchronized (this.oTO)
      {
        m = this.tTL.size();
        if (m < 10)
        {
          this.tTU.clear();
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137082);
          return false;
        }
        localObject3 = this.tTM.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.aj.b)this.tTS.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.aj.b)localObject4).cUD == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.aj.b)localObject4).cUD))
        {
          localHashMap2.put(((com.tencent.mm.aj.b)localObject4).cUD, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.aj.b)localObject4).cTr);
          localHashMap1.put(((com.tencent.mm.aj.b)localObject4).cUD, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.aj.b)localObject4).cUD)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.aj.b)localObject4).cUD);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.aj.b)localObject4).cUD)).intValue();
      localHashMap2.put(((com.tencent.mm.aj.b)localObject4).cUD, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.aj.b)localObject4).cUD);
      if (!localArrayList.contains(((com.tencent.mm.aj.b)localObject4).cTr)) {
        localArrayList.add(((com.tencent.mm.aj.b)localObject4).cTr);
      }
      localHashMap1.put(((com.tencent.mm.aj.b)localObject4).cUD, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.cUD();
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
        paramString = (com.tencent.mm.aj.b)this.tTS.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.cUD)))
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
              localObject2 = (com.tencent.mm.aj.b)this.tTS.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new a());
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.aj.b)paramString.next()).cTr);
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
            this.tTU.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.tTU.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137082);
          return bool1;
          label826:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.tTU.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.tTU.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.tTU.clear();
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
    h localh = ahY(paramb1.cTr);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.cTr });
      paramb2 = cTE();
      paramb2.a(this.tUh);
      paramb2.aik(paramb1.cTr);
      paramb2.b(paramb1);
      if (paramb1.gSN)
      {
        a(paramb1, true, true);
        e(paramb1.cTr, paramb2);
        paramb1.gSP = System.currentTimeMillis();
        paramb2.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      f(paramb1.cTr, paramb2);
      paramb2.cTS();
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      AppMethodBeat.o(137046);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.cTr });
    if (paramb1.gSN)
    {
      e(paramb1.cTr, localh);
      paramb1.gSP = System.currentTimeMillis();
      localh.b(paramb1);
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localh.azF()) || (localh.azH()) || (localh.cUd()) || (localh.ben()) || (localh.isPaused())) {
          localh.stopPlay();
        }
        a(paramb1, true, true);
        localh.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.azF())
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      if ((localh.azH()) && (localh.isPaused()))
      {
        a(paramb1, true, true);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.ben())
      {
        a(paramb1, true, true);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.cUd())
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
      synchronized (this.oTO)
      {
        if (!this.tTM.contains(paramb1.cTr)) {
          break label594;
        }
        if (i == 0)
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb1.cTr, localh);
          localh.b(paramb1);
          if ((paramb2 != null) && (!paramb2.e(paramb1)))
          {
            ad.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localh.azF()) || (localh.azH()) || (localh.cUd()) || (localh.ben()) || (localh.isPaused())) {
              localh.stopPlay();
            }
          }
          localh.cTS();
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
  
  private void bo(int paramInt, String paramString)
  {
    AppMethodBeat.i(137065);
    ad.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = e.cTA();
    }
    paramString = new v();
    paramString.dbN.action = 4;
    paramString.dbN.state = "error";
    paramString.dbN.errCode = com.tencent.mm.plugin.music.f.a.e.HZ(paramInt);
    paramString.dbN.errMsg = com.tencent.mm.plugin.music.f.a.e.te(paramInt);
    paramString.dbN.cTr = str;
    paramString.dbN.appId = aic(str);
    com.tencent.mm.sdk.b.a.ESL.a(paramString, Looper.getMainLooper());
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
    if ((paramh.azF()) || (paramh.azH()) || (paramh.cUd()) || (paramh.ben()) || (paramh.isPaused())) {
      paramh.stopPlay();
    }
    paramh.release();
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137070);
  }
  
  /* Error */
  public static void cTB()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 737
    //   6: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 739	com/tencent/mm/plugin/music/b/f:tUg	Lcom/tencent/mm/plugin/music/b/f;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 737
    //   18: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/f
    //   28: dup
    //   29: invokespecial 740	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   32: putstatic 739	com/tencent/mm/plugin/music/b/f:tUg	Lcom/tencent/mm/plugin/music/b/f;
    //   35: ldc_w 737
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
  
  public static f cTC()
  {
    AppMethodBeat.i(137036);
    if (tUg == null) {
      tUg = new f();
    }
    f localf = tUg;
    AppMethodBeat.o(137036);
    return localf;
  }
  
  private h cTE()
  {
    AppMethodBeat.i(137066);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.oTO)
    {
      if (this.tTN.size() == 0)
      {
        localObject1 = new h();
        AppMethodBeat.o(137066);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.tTO.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (h)this.tTN.get(str);
        if (??? != null)
        {
          if ((!((h)???).gTe) && (!((h)???).isCompleted()) && (!((h)???).isStopped()))
          {
            if (((h)???).tUs == null) {
              break label422;
            }
            if (((h)???).tUs.getPlayerState() != 9) {
              break label417;
            }
            i = 1;
            break label395;
          }
          label169:
          if ((l1 != 0L) && (((h)???).fXw >= l1)) {
            break label380;
          }
          l1 = ((h)???).fXw;
          localObject1 = str;
          localObject5 = ???;
          break label402;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.oTO)
        {
          if (this.tTO.contains(localObject5))
          {
            this.tTN.remove(localObject5);
            this.tTO.remove(localObject5);
          }
          if (this.tTM.contains(localObject5))
          {
            this.tTM.remove(localObject5);
            this.tTL.remove(localObject5);
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
  
  private int cTG()
  {
    AppMethodBeat.i(137077);
    int i;
    boolean bool;
    synchronized (this.oTO)
    {
      Iterator localIterator = this.tTO.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        h localh = ahY((String)localObject3);
        if (localh == null)
        {
          ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = ahW((String)localObject3);
          if (localObject3 == null) {
            break label135;
          }
          bool = ((com.tencent.mm.aj.d)localObject3).qM;
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
  
  private void cTH()
  {
    AppMethodBeat.i(137079);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.oTO)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.tTO);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        h localh = (h)this.tTN.get(str);
        if ((localh != null) && (localh.isPaused())) {
          a(str, localh);
        }
      }
    }
    AppMethodBeat.o(137079);
  }
  
  private void cTI()
  {
    AppMethodBeat.i(137080);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.oTO)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.tTO);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localh = (h)this.tTN.remove(str);
        this.tTO.remove(str);
        if (localh == null) {
          continue;
        }
        if (localh.gTe)
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
  
  private void cTK()
  {
    AppMethodBeat.i(137086);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.dbL.gSL), Boolean.valueOf(this.tUc.tVi) });
    if ((!this.dbL.gSL) && (!this.tUc.tVi))
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      requestFocus();
      AppMethodBeat.o(137086);
      return;
    }
    if ((this.dbL.gSL) && (this.tUc.tVi))
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bfc();
    }
    AppMethodBeat.o(137086);
  }
  
  private void cTM()
  {
    AppMethodBeat.i(137089);
    this.tUb = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.tUb != null) {
      this.tUb.cUm();
    }
    AppMethodBeat.o(137089);
  }
  
  static void d(String paramString, h paramh)
  {
    AppMethodBeat.i(137071);
    ad.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramh);
    AppMethodBeat.o(137071);
  }
  
  private boolean dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(137053);
    paramString = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    if (paramString != null)
    {
      paramString.cUL = paramInt;
      AppMethodBeat.o(137053);
      return true;
    }
    AppMethodBeat.o(137053);
    return false;
  }
  
  private void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137040);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137040);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.tTP.contains(paramString1)) {
      this.tTP.add(paramString1);
    }
    if (!this.tTK.contains(paramString2)) {
      this.tTK.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.tTR.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.tTR.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137040);
  }
  
  private void i(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137044);
    if (this.tUf.fu(paramb.cTr)) {
      this.tUf.c(paramb);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramb.filePath)) {
        aij(paramb.cTr);
      }
      AppMethodBeat.o(137044);
      return;
      this.tUf.b(paramb);
    }
  }
  
  private void j(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137090);
    this.tUb = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.tUb != null) {
      this.tUb.hA(paramb.cTr, paramb.cUD);
    }
    AppMethodBeat.o(137090);
  }
  
  private static void k(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137093);
    if (paramb.gTb != null) {
      try
      {
        paramb.gTb.close();
        paramb.gTb = null;
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
    if (this.tUc.tVi)
    {
      AppMethodBeat.o(137087);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.tUc.requestFocus()) });
    AppMethodBeat.o(137087);
  }
  
  public final boolean ahQ(String paramString)
  {
    AppMethodBeat.i(137048);
    h localh = ahY(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.tUf.fu(paramString))
      {
        this.tUf.fx(paramString);
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
  
  public final boolean ahR(String paramString)
  {
    AppMethodBeat.i(137049);
    h localh = ahY(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.tUf.fu(paramString))
      {
        this.tUf.fy(paramString);
        AppMethodBeat.o(137049);
        return true;
      }
      AppMethodBeat.o(137049);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localh.stopPlay();
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    if (localb != null)
    {
      localb.cUL = 0;
      localb.gSN = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137049);
    return true;
  }
  
  public final boolean ahS(String paramString)
  {
    AppMethodBeat.i(137050);
    if (this.tUf.fu(paramString)) {
      this.tUf.fy(paramString);
    }
    h localh = ahY(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137050);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localh.cUg();
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    if (localb != null)
    {
      localb.cUL = 0;
      localb.gSN = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137050);
    return true;
  }
  
  public final boolean ahT(String paramString)
  {
    AppMethodBeat.i(137051);
    this.tUf.fy(paramString);
    this.tUf.remove(paramString);
    ??? = ahY(paramString);
    if (??? == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      AppMethodBeat.o(137051);
      return false;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.oTO)
    {
      this.tTL.remove(paramString);
      this.tTM.remove(paramString);
      this.tTN.remove(paramString);
      this.tTO.remove(paramString);
      this.tTK.remove(paramString);
      ??? = this.tTP.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.tTR.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.tTR.remove(str);
            this.tTP.remove(str);
            this.tTQ.remove(str);
          }
        }
      }
      this.tTS.remove(paramString);
      this.tTT.remove(paramString);
      AppMethodBeat.o(137051);
      return true;
    }
  }
  
  public final boolean ahU(String paramString)
  {
    AppMethodBeat.i(137054);
    h localh = ahY(paramString);
    if (localh == null)
    {
      if (this.tUf.fu(paramString))
      {
        bool = this.tUf.fz(paramString);
        AppMethodBeat.o(137054);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137054);
      return false;
    }
    boolean bool = localh.azH();
    AppMethodBeat.o(137054);
    return bool;
  }
  
  public final boolean ahV(String paramString)
  {
    AppMethodBeat.i(137057);
    h localh = ahY(paramString);
    if (localh == null)
    {
      if (this.tUf.fu(paramString))
      {
        bool = this.tUf.NJ();
        AppMethodBeat.o(137057);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = ahW(paramString);
      if (paramString != null)
      {
        bool = paramString.gTe;
        AppMethodBeat.o(137057);
        return bool;
      }
      AppMethodBeat.o(137057);
      return false;
    }
    boolean bool = localh.gTe;
    AppMethodBeat.o(137057);
    return bool;
  }
  
  public final com.tencent.mm.aj.d ahW(String paramString)
  {
    AppMethodBeat.i(137058);
    Object localObject = ahY(paramString);
    if (localObject != null)
    {
      paramString = ((h)localObject).cUj();
      AppMethodBeat.o(137058);
      return paramString;
    }
    if (this.tUf.fu(paramString))
    {
      localObject = this.tUf.fE(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137058);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.aj.d)this.tTT.get(paramString);
    AppMethodBeat.o(137058);
    return paramString;
  }
  
  public final int ahX(String paramString)
  {
    AppMethodBeat.i(137059);
    int j = cTG();
    synchronized (this.oTO)
    {
      int k = this.tTK.size();
      int m = this.tTL.size();
      int n = this.tTN.size();
      paramString = (LinkedList)this.tTR.get(paramString);
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
  
  final h ahY(String paramString)
  {
    AppMethodBeat.i(137061);
    if (this.tTL.containsKey(paramString))
    {
      paramString = (h)this.tTL.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    if (this.tTN.containsKey(paramString))
    {
      paramString = (h)this.tTN.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    AppMethodBeat.o(137061);
    return null;
  }
  
  public final void ahZ(String paramString)
  {
    AppMethodBeat.i(137062);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.tUf.NI();
    bfc();
    Object localObject3 = (LinkedList)this.tTR.get(paramString);
    long l1 = this.tUf.NL();
    long l2 = com.tencent.mm.audio.mix.b.e.MN().MO();
    long l3 = com.tencent.mm.audio.mix.b.d.ML().MM();
    long l4 = l2 + l3;
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.tUb = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137062);
      return;
    }
    if ((this.tTL.isEmpty()) && (this.tTN.isEmpty()))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.tUb != null) {
        this.tUb.c(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137062);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.oTO)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        h localh = (h)this.tTN.get(localObject3);
        if (localh != null) {
          a((String)localObject3, localh);
        }
      }
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.tTL.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (h)this.tTL.get(???);
      if (localObject3 != null)
      {
        a((String)???, (h)localObject3);
        f((String)???, (h)localObject3);
      }
    }
    if (this.tUb != null) {
      this.tUb.c(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137062);
  }
  
  public final void aia(String paramString)
  {
    AppMethodBeat.i(137063);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bfc();
    LinkedList localLinkedList = (LinkedList)this.tTR.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137063);
      return;
    }
    String str;
    h localh;
    synchronized (this.oTO)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localh = (h)this.tTL.remove(str);
        this.tTM.remove(str);
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localh);
        this.tTS.remove(str);
        this.tTT.remove(str);
        if (this.tUf.fu(str))
        {
          this.tUf.fy(str);
          this.tUf.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localh = (h)this.tTN.remove(str);
      this.tTO.remove(str);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localh);
      this.tTS.remove(str);
      this.tTT.remove(str);
      if (this.tUf.fu(str))
      {
        this.tUf.fy(str);
        this.tUf.remove(str);
      }
    }
    this.tTK.removeAll(localLinkedList);
    this.tTP.remove(paramString);
    this.tTQ.remove(paramString);
    this.tUf.clearCache();
    this.tUf.NK();
    this.tUd.clear();
    this.tUe.clear();
    AppMethodBeat.o(137063);
  }
  
  public final void aih(String paramString)
  {
    AppMethodBeat.i(137084);
    if (this.tTP.size() == 0)
    {
      AppMethodBeat.o(137084);
      return;
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.tTP);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.tTQ.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        aia(str1);
      }
    }
    AppMethodBeat.o(137084);
  }
  
  final boolean aii(String paramString)
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
      synchronized (this.oTO)
      {
        i = this.tTL.size();
        if (i <= 5)
        {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137085);
          return false;
        }
        localObject3 = this.tTM.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.aj.b)this.tTS.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.aj.b)localObject4).cUD == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.aj.b)localObject4).cUD))
        {
          localHashMap1.put(((com.tencent.mm.aj.b)localObject4).cUD, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.aj.b)localObject4).cTr);
          localHashMap2.put(((com.tencent.mm.aj.b)localObject4).cUD, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.aj.b)localObject4).cUD)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.aj.b)localObject4).cUD);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.aj.b)localObject4).cUD)).intValue();
      localHashMap1.put(((com.tencent.mm.aj.b)localObject4).cUD, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.aj.b)localObject4).cUD);
      if (!localArrayList.contains(((com.tencent.mm.aj.b)localObject4).cTr)) {
        localArrayList.add(((com.tencent.mm.aj.b)localObject4).cTr);
      }
      localHashMap2.put(((com.tencent.mm.aj.b)localObject4).cUD, localArrayList);
    }
    paramString = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.cUD)))
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
            ??? = (com.tencent.mm.aj.b)this.tTS.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new a());
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.aj.b)paramString.next()).cTr);
          }
          this.tTW.add(((LinkedList)localObject1).getLast());
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.tTW.size()) });
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
  
  public final void aij(final String paramString)
  {
    AppMethodBeat.i(137092);
    if (!b.cTz())
    {
      AppMethodBeat.o(137092);
      return;
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(137023);
        com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)f.this.tTS.get(paramString);
        if (localb == null) {
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
        }
        long l1;
        long l2;
        com.tencent.mm.audio.mix.f.c localc;
        int i;
        int j;
        if ((!TextUtils.isEmpty(localb.filePath)) && (!f.this.tUf.fH(localb.filePath)))
        {
          l1 = com.tencent.mm.audio.mix.h.a.fN(localb.filePath);
          ad.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", new Object[] { localb.filePath, Long.valueOf(l1) });
          l2 = com.tencent.mm.audio.mix.b.e.MN().MO();
          localc = f.this.tUf;
          long l3 = com.tencent.mm.audio.mix.b.e.MN().MO();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
          if (l3 >= 50000000L)
          {
            i = 1;
            if (i != 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
            }
            j = 0;
            if (f.this.tUe.containsKey(localb.filePath)) {
              j = ((Integer)f.this.tUe.get(localb.filePath)).intValue();
            }
            if (i == 0) {
              break label288;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
            if (f.this.tUb != null) {
              f.this.tUb.Hw(713);
            }
            f.this.tUf.fF("");
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
            if (f.this.tUb != null) {
              f.this.tUb.Hw(714);
            }
            f.this.tUf.fF("");
          }
          else if (j >= 30)
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
          }
          else if (!com.tencent.mm.audio.mix.h.a.fM(localb.filePath))
          {
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
          }
          else
          {
            localc = f.this.tUf;
            String str = localb.filePath;
            if (!localc.cWd.fd(str))
            {
              localb.gTd = true;
              localb.fileSize = l1;
              f.this.tUf.a(localb);
            }
            else
            {
              ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
              continue;
              if (!TextUtils.isEmpty(localb.filePath))
              {
                localb.gTd = false;
                if (!f.this.tUf.fu(paramString)) {
                  f.this.tUf.b(localb);
                }
                localb.fileSize = com.tencent.mm.audio.mix.h.a.fN(localb.filePath);
              }
              else
              {
                localb.gTd = false;
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
    this.tTT.put(paramString, paramh.cUj());
    AppMethodBeat.o(137069);
  }
  
  public final boolean b(String paramString, com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137047);
    com.tencent.mm.aj.b localb2 = (com.tencent.mm.aj.b)this.tTS.get(paramString);
    com.tencent.mm.aj.b localb1;
    boolean bool1;
    if (((!this.tTK.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      j(localb1);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      int i = ahX(aic(paramString));
      if (i >= 10)
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!aig(paramString)) {
          break label368;
        }
        cTJ();
      }
      cTK();
      this.tTS.put(paramString, localb1);
      paramb = ahY(paramString);
      if (!b.cTz()) {
        break label451;
      }
      boolean bool2 = a(paramb);
      if ((!this.tUf.fu(paramString)) || (!this.tUf.fG(paramString))) {
        break label388;
      }
      bool1 = true;
      label200:
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.cTr });
      if ((!bool2) || (!bool1)) {
        break label459;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      aid(localb1.cTr);
      k(localb1);
      if (!this.tUf.fh(localb1.cTr)) {
        break label394;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (!this.tTK.contains(paramString))
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        bo(601, paramString);
        AppMethodBeat.o(137047);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      bo(602, paramString);
      AppMethodBeat.o(137047);
      return false;
      label368:
      cTM();
      bo(600, paramString);
      AppMethodBeat.o(137047);
      return false;
      label388:
      bool1 = false;
      break label200;
      label394:
      if (this.tUf.fA(localb1.cTr))
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.gSN = true;
        paramb.b(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.tUf.fv(paramString);
      }
    }
    label451:
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label459:
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      aie(paramString);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = cTE();
      paramb.a(this.tUh);
      paramb.aik(paramString);
      e(paramString, paramb);
      localb1.gSN = true;
      localb1.cUL = 0;
      localb1.gSP = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.l(localb1);
      AppMethodBeat.o(137047);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.azH()) && (!paramb.azF()))
    {
      a(localb1, false, true);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (paramb.ben())
      {
        a(localb1, false, true);
        localb1.gSN = true;
        localb1.gSP = System.currentTimeMillis();
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.cUL = 0;
        paramb.b(localb1);
      }
      else if (paramb.cUd())
      {
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.gSN = true;
        localb1.gSP = System.currentTimeMillis();
        paramb.b(localb1);
      }
      else
      {
        if (paramb.azH()) {
          break;
        }
        a(localb1, false, true);
        localb1.gSN = true;
        localb1.gSP = System.currentTimeMillis();
        ad.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.l(localb1);
        localb1.cUL = 0;
      }
    }
    ad.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137047);
    return false;
  }
  
  final void bfc()
  {
    AppMethodBeat.i(137088);
    if (this.tUc.tVi) {
      this.tUc.bfc();
    }
    AppMethodBeat.o(137088);
  }
  
  public final void cTD()
  {
    AppMethodBeat.i(137038);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.tTK.clear();
    String str;
    synchronized (this.oTO)
    {
      Iterator localIterator = this.tTM.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (h)this.tTL.remove(str));
      }
    }
    this.tTM.clear();
    this.tTL.clear();
    Object localObject3 = this.tTO.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (h)this.tTN.remove(str));
    }
    this.tTO.clear();
    this.tTN.clear();
    ??? = this.tTP.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.tTR.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.tTP.clear();
    this.tTQ.clear();
    this.tTR.clear();
    this.tTS.clear();
    this.tTT.clear();
    this.tTV.clear();
    this.tTW.clear();
    aq.az(this.tUi);
    aq.az(this.tUj);
    this.tTX = false;
    this.tTY = false;
    AppMethodBeat.o(137038);
  }
  
  public final void cTF()
  {
    AppMethodBeat.i(137076);
    long l = System.currentTimeMillis();
    if ((this.tTX) && (l - this.tTZ < 10000L))
    {
      AppMethodBeat.o(137076);
      return;
    }
    this.tTZ = l;
    synchronized (this.oTO)
    {
      this.tTX = true;
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      aq.az(this.tUj);
      aq.n(this.tUj, 1800000L);
      AppMethodBeat.o(137076);
      return;
    }
  }
  
  final void cTJ()
  {
    AppMethodBeat.i(137083);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.tTU.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      ahR(str);
      cTM();
    }
    localIterator = this.tTW.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      ahR(str);
      cTM();
    }
    this.tTU.clear();
    this.tTW.clear();
    AppMethodBeat.o(137083);
  }
  
  public final boolean dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(137052);
    h localh = ahY(paramString);
    if (localh == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.tUf.fu(paramString)) {
        this.tUf.w(paramString, paramInt);
      }
      bool = dV(paramString, paramInt);
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
      localh.cTX();
      bool = dV(paramString, paramInt);
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
    if ((localh.azF()) || (localh.azH()) || (localh.isPaused()))
    {
      bool = localh.ox(paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    localh.cTX();
    boolean bool = dV(paramString, paramInt);
    AppMethodBeat.o(137052);
    return bool;
  }
  
  final void e(String paramString, h paramh)
  {
    AppMethodBeat.i(137072);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.oTO)
    {
      if (this.tTO.contains(paramString))
      {
        this.tTN.remove(paramString);
        this.tTO.remove(paramString);
      }
      if (!this.tTM.contains(paramString))
      {
        this.tTM.add(paramString);
        this.tTL.put(paramString, paramh);
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  final void f(String paramString, h paramh)
  {
    AppMethodBeat.i(137073);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.oTO)
    {
      if (this.tTM.contains(paramString))
      {
        this.tTL.remove(paramString);
        this.tTM.remove(paramString);
      }
      if (!this.tTO.contains(paramString))
      {
        this.tTO.add(paramString);
        this.tTN.put(paramString, paramh);
      }
      AppMethodBeat.o(137073);
      return;
    }
  }
  
  public final boolean fC(String paramString)
  {
    AppMethodBeat.i(137056);
    h localh = ahY(paramString);
    if (localh == null)
    {
      if (this.tUf.fu(paramString))
      {
        bool = this.tUf.fC(paramString);
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
  
  public final boolean g(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137042);
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137042);
      return false;
    }
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.tTS.get(paramb.cTr);
    if (localb != null)
    {
      localb.f(paramb);
      h localh = ahY(paramb.cTr);
      if (localh == null) {
        break label130;
      }
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localh.b(localb);
      label76:
      if (b.cTz())
      {
        if (!this.tUf.fu(paramb.cTr)) {
          break label141;
        }
        this.tUf.c(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137042);
      return true;
      this.tTS.put(paramb.cTr, paramb);
      localb = paramb;
      break;
      label130:
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label76;
      label141:
      this.tUf.b(paramb);
    }
  }
  
  public final boolean h(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137043);
    if (paramb == null)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      bo(605, "");
      AppMethodBeat.o(137043);
      return false;
    }
    if (TextUtils.isEmpty(paramb.cTr))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      bo(604, paramb.cTr);
      AppMethodBeat.o(137043);
      return false;
    }
    if (!this.tTK.contains(paramb.cTr))
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      bo(601, paramb.cTr);
      AppMethodBeat.o(137043);
      return false;
    }
    if (paramb.gSN) {
      j(paramb);
    }
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject2 = aic(paramb.cTr);
    Object localObject1 = vD(paramb.cTr);
    int i = ahX((String)localObject2);
    boolean bool2;
    boolean bool3;
    if (i >= 10)
    {
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i) });
      this.tTS.put(paramb.cTr, paramb);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.gSN) });
      if ((paramb.gSN) && (aig(paramb.cTr))) {
        cTJ();
      }
    }
    else
    {
      aie(paramb.cTr);
      cTK();
      this.tTQ.put(localObject2, paramb.processName);
      this.tTS.put(paramb.cTr, paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (this.tUd.containsKey(paramb.cUD))) {
        paramb.filePath = ((String)this.tUd.get(paramb.cUD));
      }
      localObject2 = ahY(paramb.cTr);
      bool2 = b.cTz();
      if (!bool2) {
        break label552;
      }
      bool3 = a((h)localObject2);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.tUf.fH(paramb.filePath))) && ((localObject1 == null) || (!paramb.e((com.tencent.mm.aj.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.aj.b)localObject1).filePath)) || (!this.tUf.fH(((com.tencent.mm.aj.b)localObject1).filePath)))) {
        break label547;
      }
    }
    label547:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.cTr });
      if ((!bool3) || (!bool1)) {
        break;
      }
      a(paramb, (com.tencent.mm.aj.b)localObject1);
      AppMethodBeat.o(137043);
      return true;
      if (paramb.gSN)
      {
        bo(600, paramb.cTr);
        cTM();
        AppMethodBeat.o(137043);
        return false;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = ahY(paramb.cTr);
      if (localObject1 != null)
      {
        ((h)localObject1).b(paramb);
        ((h)localObject1).cTS();
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
  
  public final String hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137041);
    ad.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.tTR.get(paramString1);
    Object localObject = this.oTO;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.tTM.contains(paramString2)) {
            break label241;
          }
          if (this.tTO.contains(paramString2))
          {
            break label241;
            j = ahX(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label133;
            }
            ad.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            bo(604, paramString2);
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
      hy(paramString1, paramString2);
      AppMethodBeat.o(137041);
      return null;
      label174:
      if (i != 0)
      {
        ad.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        bo(603, paramString2);
        AppMethodBeat.o(137041);
        return null;
      }
      hy(paramString1, paramString2);
      aie(paramString2);
      ad.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137041);
      return paramString2;
      label241:
      int i = 1;
    }
  }
  
  public final boolean vC(String paramString)
  {
    AppMethodBeat.i(137055);
    h localh = ahY(paramString);
    if (localh == null)
    {
      if (this.tUf.fu(paramString))
      {
        bool = this.tUf.fh(paramString);
        AppMethodBeat.o(137055);
        return bool;
      }
      ad.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137055);
      return false;
    }
    boolean bool = localh.azF();
    AppMethodBeat.o(137055);
    return bool;
  }
  
  public final com.tencent.mm.aj.b vD(String paramString)
  {
    AppMethodBeat.i(137060);
    if (this.tTS.containsKey(paramString))
    {
      paramString = (com.tencent.mm.aj.b)this.tTS.get(paramString);
      AppMethodBeat.o(137060);
      return paramString;
    }
    AppMethodBeat.o(137060);
    return null;
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