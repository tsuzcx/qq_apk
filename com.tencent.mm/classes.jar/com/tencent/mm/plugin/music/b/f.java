package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.a.w.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bd;
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
  private static f wxP;
  com.tencent.mm.ai.a dlE;
  private AudioManager mAudioManager;
  volatile boolean pEV;
  Object qhj;
  HashMap<String, com.tencent.mm.ai.b> wxA;
  private HashMap<String, com.tencent.mm.ai.d> wxB;
  private LinkedList<String> wxC;
  HashMap<String, Integer> wxD;
  private LinkedList<String> wxE;
  boolean wxF;
  private boolean wxG;
  long wxH;
  private long wxI;
  com.tencent.mm.plugin.music.b.a.d wxJ;
  private com.tencent.mm.plugin.music.b.b.a wxK;
  private HashMap<String, String> wxL;
  HashMap<String, Integer> wxM;
  com.tencent.mm.audio.mix.f.c wxN;
  private volatile boolean wxO;
  private c wxQ;
  private Runnable wxR;
  Runnable wxS;
  private com.tencent.mm.audio.mix.f.b wxT;
  private com.tencent.mm.audio.mix.f.g wxU;
  private LinkedList<String> wxs;
  HashMap<String, h> wxt;
  LinkedList<String> wxu;
  HashMap<String, h> wxv;
  LinkedList<String> wxw;
  public LinkedList<String> wxx;
  private HashMap<String, String> wxy;
  HashMap<String, LinkedList<String>> wxz;
  
  private f()
  {
    AppMethodBeat.i(137037);
    this.wxs = new LinkedList();
    this.wxt = new HashMap();
    this.wxu = new LinkedList();
    this.wxv = new HashMap();
    this.wxw = new LinkedList();
    this.wxx = new LinkedList();
    this.wxy = new HashMap();
    this.wxz = new HashMap();
    this.wxA = new HashMap();
    this.wxB = new HashMap();
    this.wxC = new LinkedList();
    this.wxD = new HashMap();
    this.wxE = new LinkedList();
    this.qhj = new Object();
    this.wxF = false;
    this.wxG = false;
    this.wxH = 0L;
    this.wxI = 0L;
    this.dlE = new com.tencent.mm.ai.a();
    this.wxK = new com.tencent.mm.plugin.music.b.b.a();
    this.wxL = new HashMap();
    this.wxM = new HashMap();
    this.pEV = true;
    this.wxO = true;
    this.mAudioManager = ((AudioManager)ak.getContext().getSystemService("audio"));
    this.wxQ = new c()
    {
      public final void agU(String paramAnonymousString)
      {
        AppMethodBeat.i(195437);
        h localh = f.this.atf(paramAnonymousString);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
          AppMethodBeat.o(195437);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.duN();
        f.a(f.this, paramAnonymousString);
        f.this.atq(paramAnonymousString);
        AppMethodBeat.o(195437);
      }
      
      public final void asW(String paramAnonymousString)
      {
        AppMethodBeat.i(195436);
        h localh = f.this.atf(paramAnonymousString);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
          AppMethodBeat.o(195436);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.duN();
        AppMethodBeat.o(195436);
      }
      
      public final void gi(String paramAnonymousString)
      {
        AppMethodBeat.i(195438);
        h localh = f.this.atf(paramAnonymousString);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
          AppMethodBeat.o(195438);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.duN();
        f.a(f.this, paramAnonymousString);
        f.this.atq(paramAnonymousString);
        AppMethodBeat.o(195438);
      }
      
      public final void onError(String paramAnonymousString)
      {
        AppMethodBeat.i(195439);
        h localh = f.this.atf(paramAnonymousString);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
          AppMethodBeat.o(195439);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f localf = f.this;
        int j = localh.qgz;
        if (localf.wxD.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localf.wxD.get(paramAnonymousString)).intValue();; i = 0)
        {
          if (i > 0)
          {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            localf.wxD.remove(paramAnonymousString);
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label189;
            }
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            f.this.duR();
            f.this.b(paramAnonymousString, null);
            AppMethodBeat.o(195439);
            return;
            if (66 != j)
            {
              localf.wxD.remove(paramAnonymousString);
              break;
            }
            if (!localf.atp(paramAnonymousString)) {
              break;
            }
            localf.wxD.put(paramAnonymousString, Integer.valueOf(i + 1));
          }
          label189:
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
          f.this.f(paramAnonymousString, localh);
          f.a(f.this);
          f.this.duN();
          AppMethodBeat.o(195439);
          return;
        }
      }
      
      public final void onStart(String arg1)
      {
        AppMethodBeat.i(195435);
        h localh = f.this.atf(???);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
          AppMethodBeat.o(195435);
          return;
        }
        f.this.e(???, localh);
        synchronized (f.this.qhj)
        {
          f.this.wxF = false;
          ar.ay(f.this.wxS);
          AppMethodBeat.o(195435);
          return;
        }
      }
    };
    this.wxR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137022);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
        Iterator localIterator = f.this.wxx.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (f.this.ate(str) == 0) {
            f.this.atg(str);
          }
        }
        AppMethodBeat.o(137022);
      }
    };
    this.wxS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195440);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
        Iterator localIterator = f.this.wxx.iterator();
        int i = 0;
        f localf;
        Object localObject5;
        if (localIterator.hasNext())
        {
          ??? = (String)localIterator.next();
          if (f.this.ate((String)???) != 0) {
            break label450;
          }
          localf = f.this;
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
          localObject5 = (LinkedList)localf.wxz.get(???);
          if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
          {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
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
            synchronized (localf.qhj)
            {
              localObject6 = ((LinkedList)localObject5).iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (String)((Iterator)localObject6).next();
              if (localf.wxN.gl((String)localObject7)) {
                localf.wxN.gp((String)localObject7);
              }
              localh = (h)localf.wxt.remove(localObject7);
              localf.wxu.remove(localObject7);
              if (localh == null) {
                continue;
              }
              localf.b((String)localObject7, localh);
              ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
              if (localh.hOO) {
                f.d((String)localObject7, localh);
              }
            }
            f.c((String)localObject7, localh);
          }
          localObject5 = ((LinkedList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localf.wxN.gl((String)localObject6)) {
              localf.wxN.gp((String)localObject6);
            }
            localObject7 = (h)localf.wxv.remove(localObject6);
            localf.wxw.remove(localObject6);
            if (localObject7 != null)
            {
              localf.b((String)localObject6, (h)localObject7);
              ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
              if (((h)localObject7).hOO) {
                f.d((String)localObject6, (h)localObject7);
              } else {
                f.c((String)localObject6, (h)localObject7);
              }
            }
          }
          break label112;
          if (i == 0) {}
          synchronized (f.this.qhj)
          {
            f.this.wxF = true;
            f.this.wxH = System.currentTimeMillis();
            ar.o(f.this.wxS, 1800000L);
            AppMethodBeat.o(195440);
            return;
          }
        }
      }
    };
    this.wxT = new com.tencent.mm.audio.mix.f.b()
    {
      public final void b(w paramAnonymousw)
      {
        AppMethodBeat.i(195442);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195442);
      }
      
      public final void c(w paramAnonymousw)
      {
        AppMethodBeat.i(195443);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195443);
      }
      
      public final void d(w paramAnonymousw)
      {
        AppMethodBeat.i(195444);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195444);
      }
      
      public final void e(w paramAnonymousw)
      {
        AppMethodBeat.i(195445);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195445);
      }
      
      public final void f(w paramAnonymousw)
      {
        AppMethodBeat.i(195446);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195446);
      }
      
      public final void g(w paramAnonymousw)
      {
        AppMethodBeat.i(195447);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195447);
      }
      
      public final void h(w paramAnonymousw)
      {
        AppMethodBeat.i(195448);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195448);
      }
      
      public final void i(w paramAnonymousw)
      {
        AppMethodBeat.i(195449);
        com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(195449);
      }
      
      public final void j(w paramAnonymousw)
      {
        AppMethodBeat.i(195450);
        int i = paramAnonymousw.dlG.errCode;
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
        if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
        }
        while (f.this.wxJ != null)
        {
          com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.wxA.get(paramAnonymousw.dlG.ddg);
          if (localb == null)
          {
            AppMethodBeat.o(195450);
            return;
            com.tencent.mm.sdk.b.a.IvT.a(paramAnonymousw, Looper.getMainLooper());
          }
          else
          {
            f.this.wxJ.LB(paramAnonymousw.dlG.errCode);
            if (!f.this.wxN.gy(localb.filePath))
            {
              if (f.this.wxM.containsKey(localb.filePath))
              {
                i = ((Integer)f.this.wxM.get(localb.filePath)).intValue();
                f.this.wxM.put(localb.filePath, Integer.valueOf(i + 1));
                AppMethodBeat.o(195450);
                return;
              }
              f.this.wxM.put(localb.filePath, Integer.valueOf(1));
            }
          }
        }
        AppMethodBeat.o(195450);
      }
      
      public final void k(w paramAnonymousw)
      {
        AppMethodBeat.i(195451);
        if (f.this.wxJ != null)
        {
          com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.wxA.get(paramAnonymousw.dlG.ddg);
          if (localb == null)
          {
            AppMethodBeat.o(195451);
            return;
          }
          if (localb.hOE > 1000000L) {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.ddg, Long.valueOf(localb.hOE) });
          }
          Object localObject = paramAnonymousw.dlG.der;
          paramAnonymousw = (w)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramAnonymousw = localb.der;
          }
          localObject = f.this.wxJ;
          String str1 = localb.ddg;
          long l1 = System.currentTimeMillis();
          long l2 = localb.hOC;
          long l3 = localb.hOD;
          long l4 = localb.hOE;
          String str2 = localb.filePath;
          long l5 = f.this.wxN.gu(localb.ddg);
          long l6 = localb.fileSize;
          String str3 = localb.filePath;
          ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramAnonymousw, l1 - l2, l3, l4, false, str2, l5, l6, com.tencent.mm.audio.mix.b.e.Os().fS(str3));
          if (f.this.wxM.containsKey(localb.filePath)) {
            f.this.wxM.remove(localb.filePath);
          }
        }
        AppMethodBeat.o(195451);
      }
    };
    this.wxU = new com.tencent.mm.audio.mix.f.g()
    {
      public final void hP(int paramAnonymousInt)
      {
        AppMethodBeat.i(195452);
        if (f.this.wxJ != null) {
          f.this.wxJ.LA(paramAnonymousInt);
        }
        AppMethodBeat.o(195452);
      }
    };
    _release();
    this.wxN = new com.tencent.mm.audio.mix.f.c();
    this.wxN.a(this.wxT);
    this.wxN.a(this.wxU);
    AppMethodBeat.o(137037);
  }
  
  private void a(com.tencent.mm.ai.b paramb1, com.tencent.mm.ai.b paramb2)
  {
    AppMethodBeat.i(137045);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    atk(paramb1.ddg);
    k(paramb1);
    if ((TextUtils.isEmpty(paramb1.filePath)) && (paramb2 != null) && (paramb2.e(paramb1))) {
      paramb1.filePath = paramb2.filePath;
    }
    if (paramb1.hOy)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        a(paramb1, true, false);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.wxN.fY(paramb1.ddg)) || (this.wxN.gq(paramb1.ddg)) || (this.wxN.gr(paramb1.ddg)) || (this.wxN.gs(paramb1.ddg)) || (this.wxN.isPaused(paramb1.ddg))) {
          this.wxN.gp(paramb1.ddg);
        }
        this.wxN.a(paramb1);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wxN.fY(paramb1.ddg))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      if ((this.wxN.gq(paramb1.ddg)) && (this.wxN.isPaused(paramb1.ddg)))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.wxN.gn(paramb1.ddg);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wxN.gs(paramb1.ddg))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.wxN.gn(paramb1.ddg);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.wxN.gr(paramb1.ddg))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.wxN.a(paramb1);
      AppMethodBeat.o(137045);
      return;
    }
    if (this.wxN.gl(paramb1.ddg)) {
      this.wxN.c(paramb1);
    }
    for (;;)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.wxN.fY(paramb1.ddg)) || (this.wxN.gq(paramb1.ddg)) || (this.wxN.gr(paramb1.ddg)) || (this.wxN.gs(paramb1.ddg)) || (this.wxN.isPaused(paramb1.ddg))) {
          this.wxN.gp(paramb1.ddg);
        }
      }
      this.wxN.o(7, paramb1.ddg);
      AppMethodBeat.o(137045);
      return;
      this.wxN.b(paramb1);
    }
  }
  
  private void a(com.tencent.mm.ai.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137091);
    this.wxJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wxJ != null) {
      this.wxJ.r(paramb.ddg, paramb.der, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.hOC = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.hOG;
    }
    for (paramb.hOD = paramb.hOF; (l1 > 0L) && (l2 > l1); paramb.hOD = paramb.hOH)
    {
      paramb.hOE = (l2 - l1);
      AppMethodBeat.o(137091);
      return;
      l1 = paramb.hOI;
    }
    paramb.hOE = 0L;
    AppMethodBeat.o(137091);
  }
  
  private void a(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137039);
    if (paramb == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137039);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.wxy.put(paramb.appId, paramb.processName);
    this.wxA.put(paramb.ddg, paramb);
    ii(paramb.appId, paramString);
    this.wxD.remove(paramString);
    AppMethodBeat.o(137039);
  }
  
  private void a(String paramString, h paramh)
  {
    AppMethodBeat.i(137068);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    if ((localb != null) && (paramh.aJZ()) && (paramh.aKb()))
    {
      localb.hOy = true;
      localb.dez = paramh.dvr();
    }
    for (;;)
    {
      b(paramString, paramh);
      paramString = atd(paramString);
      if ((paramString != null) && (paramh.aJZ())) {
        paramString.tG = true;
      }
      if ((!paramh.aJZ()) && (!paramh.aKb()) && (!paramh.cOU()) && (!paramh.bpC()) && (!paramh.isPaused())) {
        break;
      }
      paramh.dvo();
      AppMethodBeat.o(137068);
      return;
      if ((localb != null) && (paramh.aKb()))
      {
        localb.hOy = true;
        localb.dez = paramh.dvr();
      }
      else if (localb != null)
      {
        localb.hOy = true;
        localb.dez = 0;
      }
    }
    paramh.dvn();
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
    if ((paramh.aJZ()) || (paramh.isPaused()) || (paramh.cOU()) || (paramh.bpC()) || (paramh.aKb())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    AppMethodBeat.o(137075);
    return false;
  }
  
  private void ati(String arg1)
  {
    AppMethodBeat.i(137064);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    atr(???);
    bHs();
    Object localObject1 = (LinkedList)this.wxz.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137064);
      return;
    }
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.qhj)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.wxN.gl(str)) {
          this.wxN.gp(str);
        }
        localh = (h)this.wxv.remove(str);
        this.wxw.remove(str);
        if (localh == null) {
          continue;
        }
        b(str, localh);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localh.hOO) {
          d(str, localh);
        }
      }
      c(str, localh);
    }
    AppMethodBeat.o(137064);
  }
  
  private String atj(String paramString)
  {
    AppMethodBeat.i(137067);
    Iterator localIterator = this.wxx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.wxz.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137067);
        return str;
      }
    }
    AppMethodBeat.o(137067);
    return "";
  }
  
  private boolean atk(String paramString)
  {
    AppMethodBeat.i(137074);
    ??? = atf(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137074);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.qhj)
    {
      this.wxt.remove(paramString);
      this.wxu.remove(paramString);
      this.wxv.remove(paramString);
      this.wxw.remove(paramString);
      AppMethodBeat.o(137074);
      return true;
    }
  }
  
  private void atl(String paramString)
  {
    AppMethodBeat.i(137078);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.wxt.size();
    int j = this.wxv.size();
    int k = duO();
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      duP();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = atj(paramString);
      i = this.wxt.size();
      j = this.wxv.size();
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.wxx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          atm(str);
        }
      }
      if (k >= 6) {
        duP();
      } else if (i + k >= 8) {
        duP();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.wxx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          atm(str);
        }
      }
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.wxv.size();
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      duQ();
      AppMethodBeat.o(137078);
      return;
    }
    if (j + i >= 50)
    {
      duQ();
      AppMethodBeat.o(137078);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137078);
  }
  
  private void atm(String paramString)
  {
    AppMethodBeat.i(137081);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    ati(paramString);
    AppMethodBeat.o(137081);
  }
  
  private boolean atn(String paramString)
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
      synchronized (this.qhj)
      {
        m = this.wxt.size();
        if (m < 10)
        {
          this.wxC.clear();
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137082);
          return false;
        }
        localObject3 = this.wxu.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.wxA.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).der == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.ai.b)localObject4).der))
        {
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).der, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).ddg);
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).der, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.ai.b)localObject4).der)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.ai.b)localObject4).der);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).der)).intValue();
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).der, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).der);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).ddg)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).ddg);
      }
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).der, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.dvK();
    ae.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      ae.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
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
        paramString = (com.tencent.mm.ai.b)this.wxA.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.der)))
        {
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.ai.b)this.wxA.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new a());
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.ai.b)paramString.next()).ddg);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label826;
            }
            i += 1;
            ae.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.wxC.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            ae.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.wxC.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137082);
          return bool1;
          label826:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.wxC.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.wxC.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.wxC.clear();
        }
      }
      label905:
      break label469;
      label908:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void atr(String paramString)
  {
    AppMethodBeat.i(195454);
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.dlE.appId)) && (!paramString.equalsIgnoreCase(this.dlE.appId)))
    {
      this.dlE.reset();
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "reset AudioContextParam, appId:%s", new Object[] { paramString });
    }
    this.dlE.appId = paramString;
    this.pEV = this.dlE.dcN;
    AppMethodBeat.o(195454);
  }
  
  private void b(com.tencent.mm.ai.b paramb1, com.tencent.mm.ai.b paramb2)
  {
    int i = 1;
    AppMethodBeat.i(137046);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    h localh = atf(paramb1.ddg);
    if (localh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.ddg });
      paramb2 = duM();
      paramb2.a(this.wxQ);
      paramb2.ats(paramb1.ddg);
      paramb2.b(paramb1);
      if (paramb1.hOy)
      {
        a(paramb1, true, true);
        e(paramb1.ddg, paramb2);
        paramb1.hOz = System.currentTimeMillis();
        paramb2.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      f(paramb1.ddg, paramb2);
      paramb2.dvb();
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      AppMethodBeat.o(137046);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.ddg });
    if (paramb1.hOy)
    {
      e(paramb1.ddg, localh);
      paramb1.hOz = System.currentTimeMillis();
      localh.b(paramb1);
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localh.aJZ()) || (localh.aKb()) || (localh.cOU()) || (localh.bpC()) || (localh.isPaused())) {
          localh.stopPlay();
        }
        a(paramb1, true, true);
        localh.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.aJZ())
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      if ((localh.aKb()) && (localh.isPaused()))
      {
        a(paramb1, true, true);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.bpC())
      {
        a(paramb1, true, true);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.cOU())
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      a(paramb1, true, true);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
      localh.l(paramb1);
      AppMethodBeat.o(137046);
      return;
    }
    for (;;)
    {
      synchronized (this.qhj)
      {
        if (!this.wxu.contains(paramb1.ddg)) {
          break label594;
        }
        if (i == 0)
        {
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb1.ddg, localh);
          localh.b(paramb1);
          if ((paramb2 != null) && (!paramb2.e(paramb1)))
          {
            ae.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localh.aJZ()) || (localh.aKb()) || (localh.cOU()) || (localh.bpC()) || (localh.isPaused())) {
              localh.stopPlay();
            }
          }
          localh.dvb();
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
          AppMethodBeat.o(137046);
          return;
        }
      }
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      continue;
      label594:
      i = 0;
    }
  }
  
  private void by(int paramInt, String paramString)
  {
    AppMethodBeat.i(137065);
    ae.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = e.duJ();
    }
    paramString = new w();
    paramString.dlG.action = 4;
    paramString.dlG.state = "error";
    paramString.dlG.errCode = com.tencent.mm.plugin.music.f.a.e.Mf(paramInt);
    paramString.dlG.errMsg = com.tencent.mm.plugin.music.f.a.e.uF(paramInt);
    paramString.dlG.ddg = str;
    paramString.dlG.appId = atj(str);
    com.tencent.mm.sdk.b.a.IvT.a(paramString, Looper.getMainLooper());
    AppMethodBeat.o(137065);
  }
  
  static void c(String paramString, h paramh)
  {
    AppMethodBeat.i(137070);
    if (paramh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137070);
      return;
    }
    if ((paramh.aJZ()) || (paramh.aKb()) || (paramh.cOU()) || (paramh.bpC()) || (paramh.isPaused())) {
      paramh.stopPlay();
    }
    paramh.release();
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137070);
  }
  
  static void d(String paramString, h paramh)
  {
    AppMethodBeat.i(137071);
    ae.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramh);
    AppMethodBeat.o(137071);
  }
  
  private boolean duI()
  {
    AppMethodBeat.i(195453);
    if ((b.duI()) && (duU()))
    {
      AppMethodBeat.o(195453);
      return true;
    }
    AppMethodBeat.o(195453);
    return false;
  }
  
  /* Error */
  public static void duK()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 795
    //   6: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 797	com/tencent/mm/plugin/music/b/f:wxP	Lcom/tencent/mm/plugin/music/b/f;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 795
    //   18: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/f
    //   28: dup
    //   29: invokespecial 798	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   32: putstatic 797	com/tencent/mm/plugin/music/b/f:wxP	Lcom/tencent/mm/plugin/music/b/f;
    //   35: ldc_w 795
    //   38: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static f duL()
  {
    AppMethodBeat.i(137036);
    if (wxP == null) {
      wxP = new f();
    }
    f localf = wxP;
    AppMethodBeat.o(137036);
    return localf;
  }
  
  private h duM()
  {
    AppMethodBeat.i(137066);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.qhj)
    {
      if (this.wxv.size() == 0)
      {
        localObject1 = new h();
        AppMethodBeat.o(137066);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.wxw.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (h)this.wxv.get(str);
        if (??? != null)
        {
          if ((!((h)???).hOO) && (!((h)???).isCompleted()) && (!((h)???).isStopped()))
          {
            if (((h)???).wyb == null) {
              break label422;
            }
            if (((h)???).wyb.getPlayerState() != 9) {
              break label417;
            }
            i = 1;
            break label395;
          }
          label169:
          if ((l1 != 0L) && (((h)???).gyu >= l1)) {
            break label380;
          }
          l1 = ((h)???).gyu;
          localObject1 = str;
          localObject5 = ???;
          break label402;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.qhj)
        {
          if (this.wxw.contains(localObject5))
          {
            this.wxv.remove(localObject5);
            this.wxw.remove(localObject5);
          }
          if (this.wxu.contains(localObject5))
          {
            this.wxu.remove(localObject5);
            this.wxt.remove(localObject5);
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
  
  private int duO()
  {
    AppMethodBeat.i(137077);
    int i;
    boolean bool;
    synchronized (this.qhj)
    {
      Iterator localIterator = this.wxw.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        h localh = atf((String)localObject3);
        if (localh == null)
        {
          ae.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = atd((String)localObject3);
          if (localObject3 == null) {
            break label135;
          }
          bool = ((com.tencent.mm.ai.d)localObject3).tG;
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
  
  private void duP()
  {
    AppMethodBeat.i(137079);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.qhj)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.wxw);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        h localh = (h)this.wxv.get(str);
        if ((localh != null) && (localh.isPaused())) {
          a(str, localh);
        }
      }
    }
    AppMethodBeat.o(137079);
  }
  
  private void duQ()
  {
    AppMethodBeat.i(137080);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.qhj)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.wxw);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localh = (h)this.wxv.remove(str);
        this.wxw.remove(str);
        if (localh == null) {
          continue;
        }
        if (localh.hOO)
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
  
  private void duS()
  {
    AppMethodBeat.i(137086);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.dlE.hOw), Boolean.valueOf(this.wxK.wyR) });
    if ((!this.dlE.hOw) && (!this.wxK.wyR))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      requestFocus();
      AppMethodBeat.o(137086);
      return;
    }
    if ((this.dlE.hOw) && (this.wxK.wyR))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bqr();
    }
    AppMethodBeat.o(137086);
  }
  
  private void duT()
  {
    AppMethodBeat.i(137089);
    this.wxJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wxJ != null) {
      this.wxJ.dvv();
    }
    AppMethodBeat.o(137089);
  }
  
  private boolean duU()
  {
    return (this.dlE.dcN) || (this.dlE.hOw);
  }
  
  private void duV()
  {
    AppMethodBeat.i(195455);
    if ((this.dlE.hOw) && (!this.wxO))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, useSpeakerOn is false, return");
      bHs();
      AppMethodBeat.o(195455);
      return;
    }
    if (this.dlE.hOw)
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, return");
      AppMethodBeat.o(195455);
      return;
    }
    if ((this.pEV) && (this.mAudioManager.getMode() != 0))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on and reset speaker");
      bHs();
      AppMethodBeat.o(195455);
      return;
    }
    if (this.pEV)
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on, do nothing");
      AppMethodBeat.o(195455);
      return;
    }
    if (bd.PC())
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when phone calling");
      AppMethodBeat.o(195455);
      return;
    }
    if ((this.mAudioManager.isBluetoothScoOn()) || (this.mAudioManager.isBluetoothA2dpOn()))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when isBluetoothScoOn:%b , isBluetoothA2dpOn:%b", new Object[] { Boolean.valueOf(this.mAudioManager.isBluetoothScoOn()), Boolean.valueOf(this.mAudioManager.isBluetoothA2dpOn()) });
      AppMethodBeat.o(195455);
      return;
    }
    if (this.mAudioManager.isWiredHeadsetOn())
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
      AppMethodBeat.o(195455);
      return;
    }
    if ((!this.wxO) && (this.mAudioManager.getMode() == 3) && (!this.mAudioManager.isSpeakerphoneOn()))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
      AppMethodBeat.o(195455);
      return;
    }
    this.wxO = false;
    this.mAudioManager.setSpeakerphoneOn(false);
    this.mAudioManager.setMode(3);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker off and change mode to MODE_IN_COMMUNICATION");
    AppMethodBeat.o(195455);
  }
  
  private boolean eC(String paramString, int paramInt)
  {
    AppMethodBeat.i(137053);
    paramString = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    if (paramString != null)
    {
      paramString.dez = paramInt;
      AppMethodBeat.o(137053);
      return true;
    }
    AppMethodBeat.o(137053);
    return false;
  }
  
  private void i(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137044);
    if (this.wxN.gl(paramb.ddg)) {
      this.wxN.c(paramb);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramb.filePath)) {
        atq(paramb.ddg);
      }
      AppMethodBeat.o(137044);
      return;
      this.wxN.b(paramb);
    }
  }
  
  private void ii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137040);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137040);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.wxx.contains(paramString1)) {
      this.wxx.add(paramString1);
    }
    if (!this.wxs.contains(paramString2)) {
      this.wxs.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.wxz.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.wxz.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137040);
  }
  
  private void j(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137090);
    this.wxJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wxJ != null) {
      this.wxJ.ik(paramb.ddg, paramb.der);
    }
    AppMethodBeat.o(137090);
  }
  
  private static void k(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137093);
    if (paramb.hOL != null) {
      try
      {
        paramb.hOL.close();
        paramb.hOL = null;
        AppMethodBeat.o(137093);
        return;
      }
      catch (Exception paramb)
      {
        ae.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
    AppMethodBeat.o(137093);
  }
  
  private void requestFocus()
  {
    AppMethodBeat.i(137087);
    if (this.wxK.wyR)
    {
      AppMethodBeat.o(137087);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.wxK.requestFocus()) });
    AppMethodBeat.o(137087);
  }
  
  public final boolean Dj(String paramString)
  {
    AppMethodBeat.i(137055);
    h localh = atf(paramString);
    if (localh == null)
    {
      if (this.wxN.gl(paramString))
      {
        bool = this.wxN.fY(paramString);
        AppMethodBeat.o(137055);
        return bool;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137055);
      return false;
    }
    boolean bool = localh.aJZ();
    AppMethodBeat.o(137055);
    return bool;
  }
  
  public final com.tencent.mm.ai.b Dk(String paramString)
  {
    AppMethodBeat.i(137060);
    if (this.wxA.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.wxA.get(paramString);
      AppMethodBeat.o(137060);
      return paramString;
    }
    AppMethodBeat.o(137060);
    return null;
  }
  
  public final void _release()
  {
    AppMethodBeat.i(137038);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.wxs.clear();
    String str;
    synchronized (this.qhj)
    {
      Iterator localIterator = this.wxu.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (h)this.wxt.remove(str));
      }
    }
    this.wxu.clear();
    this.wxt.clear();
    Object localObject3 = this.wxw.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (h)this.wxv.remove(str));
    }
    this.wxw.clear();
    this.wxv.clear();
    ??? = this.wxx.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.wxz.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.wxx.clear();
    this.wxy.clear();
    this.wxz.clear();
    this.wxA.clear();
    this.wxB.clear();
    this.wxD.clear();
    this.wxE.clear();
    ar.ay(this.wxR);
    ar.ay(this.wxS);
    this.wxF = false;
    this.wxG = false;
    AppMethodBeat.o(137038);
  }
  
  public final boolean a(com.tencent.mm.ai.a parama)
  {
    this.dlE = parama;
    this.pEV = parama.dcN;
    return true;
  }
  
  public final boolean asX(String paramString)
  {
    AppMethodBeat.i(137048);
    h localh = atf(paramString);
    if (localh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.wxN.gl(paramString))
      {
        this.wxN.go(paramString);
        AppMethodBeat.o(137048);
        return true;
      }
      AppMethodBeat.o(137048);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localh.pause();
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137048);
    return true;
  }
  
  public final boolean asY(String paramString)
  {
    AppMethodBeat.i(137049);
    h localh = atf(paramString);
    if (localh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.wxN.gl(paramString))
      {
        this.wxN.gp(paramString);
        AppMethodBeat.o(137049);
        return true;
      }
      AppMethodBeat.o(137049);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localh.stopPlay();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    if (localb != null)
    {
      localb.dez = 0;
      localb.hOy = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137049);
    return true;
  }
  
  public final boolean asZ(String paramString)
  {
    AppMethodBeat.i(137050);
    if (this.wxN.gl(paramString)) {
      this.wxN.gp(paramString);
    }
    h localh = atf(paramString);
    if (localh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137050);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localh.dvp();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    if (localb != null)
    {
      localb.dez = 0;
      localb.hOy = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137050);
    return true;
  }
  
  public final boolean ata(String paramString)
  {
    AppMethodBeat.i(137051);
    this.wxN.gp(paramString);
    this.wxN.remove(paramString);
    ??? = atf(paramString);
    if (??? == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      AppMethodBeat.o(137051);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.qhj)
    {
      this.wxt.remove(paramString);
      this.wxu.remove(paramString);
      this.wxv.remove(paramString);
      this.wxw.remove(paramString);
      this.wxs.remove(paramString);
      ??? = this.wxx.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.wxz.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.wxz.remove(str);
            this.wxx.remove(str);
            this.wxy.remove(str);
          }
        }
      }
      this.wxA.remove(paramString);
      this.wxB.remove(paramString);
      AppMethodBeat.o(137051);
      return true;
    }
  }
  
  public final boolean atb(String paramString)
  {
    AppMethodBeat.i(137054);
    h localh = atf(paramString);
    if (localh == null)
    {
      if (this.wxN.gl(paramString))
      {
        bool = this.wxN.gq(paramString);
        AppMethodBeat.o(137054);
        return bool;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137054);
      return false;
    }
    boolean bool = localh.aKb();
    AppMethodBeat.o(137054);
    return bool;
  }
  
  public final boolean atc(String paramString)
  {
    AppMethodBeat.i(137057);
    h localh = atf(paramString);
    if (localh == null)
    {
      if (this.wxN.gl(paramString))
      {
        bool = this.wxN.Po();
        AppMethodBeat.o(137057);
        return bool;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = atd(paramString);
      if (paramString != null)
      {
        bool = paramString.hOO;
        AppMethodBeat.o(137057);
        return bool;
      }
      AppMethodBeat.o(137057);
      return false;
    }
    boolean bool = localh.hOO;
    AppMethodBeat.o(137057);
    return bool;
  }
  
  public final com.tencent.mm.ai.d atd(String paramString)
  {
    AppMethodBeat.i(137058);
    Object localObject = atf(paramString);
    if (localObject != null)
    {
      paramString = ((h)localObject).dvs();
      AppMethodBeat.o(137058);
      return paramString;
    }
    if (this.wxN.gl(paramString))
    {
      localObject = this.wxN.gv(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137058);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.ai.d)this.wxB.get(paramString);
    AppMethodBeat.o(137058);
    return paramString;
  }
  
  public final int ate(String paramString)
  {
    AppMethodBeat.i(137059);
    int j = duO();
    synchronized (this.qhj)
    {
      int k = this.wxs.size();
      int m = this.wxt.size();
      int n = this.wxv.size();
      paramString = (LinkedList)this.wxz.get(paramString);
      if (paramString == null)
      {
        i = 0;
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(137059);
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final h atf(String paramString)
  {
    AppMethodBeat.i(137061);
    if (this.wxt.containsKey(paramString))
    {
      paramString = (h)this.wxt.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    if (this.wxv.containsKey(paramString))
    {
      paramString = (h)this.wxv.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    AppMethodBeat.o(137061);
    return null;
  }
  
  public final void atg(String paramString)
  {
    AppMethodBeat.i(137062);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.wxN.Pn();
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195434);
        f.this.bHs();
        AppMethodBeat.o(195434);
      }
    });
    bqr();
    Object localObject3 = (LinkedList)this.wxz.get(paramString);
    long l1 = this.wxN.Pq();
    long l2 = com.tencent.mm.audio.mix.b.e.Os().Ot();
    long l3 = com.tencent.mm.audio.mix.b.d.Oq().Or();
    long l4 = l2 + l3;
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.wxJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137062);
      return;
    }
    if ((this.wxt.isEmpty()) && (this.wxv.isEmpty()))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.wxJ != null) {
        this.wxJ.c(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137062);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.qhj)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        h localh = (h)this.wxv.get(localObject3);
        if (localh != null) {
          a((String)localObject3, localh);
        }
      }
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.wxt.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (h)this.wxt.get(???);
      if (localObject3 != null)
      {
        a((String)???, (h)localObject3);
        f((String)???, (h)localObject3);
      }
    }
    if (this.wxJ != null) {
      this.wxJ.c(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137062);
  }
  
  public final void ath(String paramString)
  {
    AppMethodBeat.i(137063);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bqr();
    atr(paramString);
    bHs();
    LinkedList localLinkedList = (LinkedList)this.wxz.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137063);
      return;
    }
    String str;
    h localh;
    synchronized (this.qhj)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localh = (h)this.wxt.remove(str);
        this.wxu.remove(str);
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localh);
        this.wxA.remove(str);
        this.wxB.remove(str);
        if (this.wxN.gl(str))
        {
          this.wxN.gp(str);
          this.wxN.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localh = (h)this.wxv.remove(str);
      this.wxw.remove(str);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localh);
      this.wxA.remove(str);
      this.wxB.remove(str);
      if (this.wxN.gl(str))
      {
        this.wxN.gp(str);
        this.wxN.remove(str);
      }
    }
    this.wxs.removeAll(localLinkedList);
    this.wxx.remove(paramString);
    this.wxy.remove(paramString);
    this.wxN.clearCache();
    this.wxN.Pp();
    this.wxL.clear();
    this.wxM.clear();
    AppMethodBeat.o(137063);
  }
  
  public final void ato(String paramString)
  {
    AppMethodBeat.i(137084);
    if (this.wxx.size() == 0)
    {
      AppMethodBeat.o(137084);
      return;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.wxx);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.wxy.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        ath(str1);
      }
    }
    AppMethodBeat.o(137084);
  }
  
  final boolean atp(String paramString)
  {
    AppMethodBeat.i(137085);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.qhj)
      {
        i = this.wxt.size();
        if (i <= 5)
        {
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137085);
          return false;
        }
        localObject3 = this.wxu.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.wxA.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).der == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.ai.b)localObject4).der))
        {
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).der, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).ddg);
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).der, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.ai.b)localObject4).der)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.ai.b)localObject4).der);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).der)).intValue();
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).der, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).der);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).ddg)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).ddg);
      }
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).der, localArrayList);
    }
    paramString = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.der)))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        AppMethodBeat.o(137085);
        return false;
      }
    }
    paramString = "";
    ae.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      ae.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
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
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.mm.ai.b)this.wxA.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new a());
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.ai.b)paramString.next()).ddg);
          }
          this.wxE.add(((LinkedList)localObject1).getLast());
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.wxE.size()) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137085);
        return bool1;
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      label785:
      break label534;
      label788:
      j = i;
      localObject1 = paramString;
    }
  }
  
  public final void atq(final String paramString)
  {
    AppMethodBeat.i(137092);
    if (!duI())
    {
      AppMethodBeat.o(137092);
      return;
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(195441);
        com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.wxA.get(paramString);
        if (localb == null) {
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
        }
        long l1;
        long l2;
        com.tencent.mm.audio.mix.f.c localc;
        int i;
        int j;
        if ((!TextUtils.isEmpty(localb.filePath)) && (!f.this.wxN.gy(localb.filePath)))
        {
          l1 = com.tencent.mm.audio.mix.h.a.gE(localb.filePath);
          ae.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", new Object[] { localb.filePath, Long.valueOf(l1) });
          l2 = com.tencent.mm.audio.mix.b.e.Os().Ot();
          localc = f.this.wxN;
          long l3 = com.tencent.mm.audio.mix.b.e.Os().Ot();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
          if (l3 >= 50000000L)
          {
            i = 1;
            if (i != 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
            }
            j = 0;
            if (f.this.wxM.containsKey(localb.filePath)) {
              j = ((Integer)f.this.wxM.get(localb.filePath)).intValue();
            }
            if (i == 0) {
              break label288;
            }
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
            if (f.this.wxJ != null) {
              f.this.wxJ.LC(713);
            }
            f.this.wxN.gw("");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(195441);
          return false;
          i = 0;
          break;
          label288:
          if (l2 + l1 > 50000000L)
          {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
            if (f.this.wxJ != null) {
              f.this.wxJ.LC(714);
            }
            f.this.wxN.gw("");
          }
          else if (j >= 30)
          {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
          }
          else if (!com.tencent.mm.audio.mix.h.a.gD(localb.filePath))
          {
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
          }
          else
          {
            localc = f.this.wxN;
            String str = localb.filePath;
            if (!localc.dfR.fU(str))
            {
              localb.hON = true;
              localb.fileSize = l1;
              f.this.wxN.a(localb);
            }
            else
            {
              ae.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
              continue;
              if (!TextUtils.isEmpty(localb.filePath))
              {
                localb.hON = false;
                if (!f.this.wxN.gl(paramString)) {
                  f.this.wxN.b(localb);
                }
                localb.fileSize = com.tencent.mm.audio.mix.h.a.gE(localb.filePath);
              }
              else
              {
                localb.hON = false;
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
    this.wxB.put(paramString, paramh.dvs());
    AppMethodBeat.o(137069);
  }
  
  public final boolean b(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137047);
    com.tencent.mm.ai.b localb2 = (com.tencent.mm.ai.b)this.wxA.get(paramString);
    com.tencent.mm.ai.b localb1;
    boolean bool1;
    if (((!this.wxs.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      j(localb1);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      paramb = atj(paramString);
      int i = ate(paramb);
      if (i >= 10)
      {
        ae.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!atn(paramString)) {
          break label380;
        }
        duR();
      }
      duS();
      this.wxA.put(paramString, localb1);
      atr(paramb);
      duV();
      paramb = atf(paramString);
      if (!duI()) {
        break label463;
      }
      boolean bool2 = a(paramb);
      if ((!this.wxN.gl(paramString)) || (!this.wxN.gx(paramString))) {
        break label400;
      }
      bool1 = true;
      label212:
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.ddg });
      if ((!bool2) || (!bool1)) {
        break label471;
      }
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      atk(localb1.ddg);
      k(localb1);
      if (!this.wxN.fY(localb1.ddg)) {
        break label406;
      }
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (!this.wxs.contains(paramString))
      {
        ae.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        by(601, paramString);
        AppMethodBeat.o(137047);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      by(602, paramString);
      AppMethodBeat.o(137047);
      return false;
      label380:
      duT();
      by(600, paramString);
      AppMethodBeat.o(137047);
      return false;
      label400:
      bool1 = false;
      break label212;
      label406:
      if (this.wxN.gr(localb1.ddg))
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.hOy = true;
        paramb.b(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.wxN.gm(paramString);
      }
    }
    label463:
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label471:
    if (paramb == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      atl(paramString);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = duM();
      paramb.a(this.wxQ);
      paramb.ats(paramString);
      e(paramString, paramb);
      localb1.hOy = true;
      localb1.dez = 0;
      localb1.hOz = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.l(localb1);
      AppMethodBeat.o(137047);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.aKb()) && (!paramb.aJZ()))
    {
      a(localb1, false, true);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (paramb.bpC())
      {
        a(localb1, false, true);
        localb1.hOy = true;
        localb1.hOz = System.currentTimeMillis();
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.dez = 0;
        paramb.b(localb1);
      }
      else if (paramb.cOU())
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.hOy = true;
        localb1.hOz = System.currentTimeMillis();
        paramb.b(localb1);
      }
      else if (paramb.hOO)
      {
        a(localb1, false, true);
        localb1.hOy = true;
        localb1.hOz = System.currentTimeMillis();
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
        paramb.l(localb1);
      }
      else
      {
        if (paramb.aKb()) {
          break;
        }
        a(localb1, false, true);
        localb1.hOy = true;
        localb1.hOz = System.currentTimeMillis();
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.l(localb1);
        localb1.dez = 0;
      }
    }
    ae.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137047);
    return false;
  }
  
  public final void bHs()
  {
    AppMethodBeat.i(195456);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "resetSpeaker");
    if ((!this.wxO) && (this.mAudioManager.getMode() == 3))
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on and reset mode to MODE_NORMAL");
      this.mAudioManager.setSpeakerphoneOn(true);
      this.mAudioManager.setMode(0);
    }
    for (;;)
    {
      this.wxO = true;
      AppMethodBeat.o(195456);
      return;
      if (!this.wxO)
      {
        ae.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on");
        this.mAudioManager.setSpeakerphoneOn(true);
      }
    }
  }
  
  final void bqr()
  {
    AppMethodBeat.i(137088);
    if (this.wxK.wyR) {
      this.wxK.bqr();
    }
    AppMethodBeat.o(137088);
  }
  
  public final void duN()
  {
    AppMethodBeat.i(137076);
    long l = System.currentTimeMillis();
    if ((this.wxF) && (l - this.wxH < 10000L))
    {
      AppMethodBeat.o(137076);
      return;
    }
    this.wxH = l;
    synchronized (this.qhj)
    {
      this.wxF = true;
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      ar.ay(this.wxS);
      ar.o(this.wxS, 1800000L);
      AppMethodBeat.o(137076);
      return;
    }
  }
  
  final void duR()
  {
    AppMethodBeat.i(137083);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.wxC.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      asY(str);
      duT();
    }
    localIterator = this.wxE.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      asY(str);
      duT();
    }
    this.wxC.clear();
    this.wxE.clear();
    AppMethodBeat.o(137083);
  }
  
  final void e(String paramString, h paramh)
  {
    AppMethodBeat.i(137072);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.qhj)
    {
      if (this.wxw.contains(paramString))
      {
        this.wxv.remove(paramString);
        this.wxw.remove(paramString);
      }
      if (!this.wxu.contains(paramString))
      {
        this.wxu.add(paramString);
        this.wxt.put(paramString, paramh);
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  public final boolean eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(137052);
    h localh = atf(paramString);
    if (localh == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.wxN.gl(paramString)) {
        this.wxN.z(paramString, paramInt);
      }
      bool = eC(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if (paramInt < 0)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    if (localh.getDuration() <= 0)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      localh.dvg();
      bool = eC(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if ((paramInt > 0) && (paramInt > localh.getDuration()))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((localh.aJZ()) || (localh.aKb()) || (localh.isPaused()))
    {
      bool = localh.pR(paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    localh.dvg();
    boolean bool = eC(paramString, paramInt);
    AppMethodBeat.o(137052);
    return bool;
  }
  
  final void f(String paramString, h paramh)
  {
    AppMethodBeat.i(137073);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.qhj)
    {
      if (this.wxu.contains(paramString))
      {
        this.wxt.remove(paramString);
        this.wxu.remove(paramString);
      }
      if (!this.wxw.contains(paramString))
      {
        this.wxw.add(paramString);
        this.wxv.put(paramString, paramh);
      }
      AppMethodBeat.o(137073);
      return;
    }
  }
  
  public final boolean g(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137042);
    if (paramb == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137042);
      return false;
    }
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.wxA.get(paramb.ddg);
    if (localb != null)
    {
      localb.f(paramb);
      h localh = atf(paramb.ddg);
      if (localh == null) {
        break label131;
      }
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localh.b(localb);
      label76:
      if (duI())
      {
        if (!this.wxN.gl(paramb.ddg)) {
          break label142;
        }
        this.wxN.c(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137042);
      return true;
      this.wxA.put(paramb.ddg, paramb);
      localb = paramb;
      break;
      label131:
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label76;
      label142:
      this.wxN.b(paramb);
    }
  }
  
  public final int getStreamType()
  {
    if ((this.pEV) || (this.dlE.hOw)) {}
    while (this.wxO) {
      return 3;
    }
    return 0;
  }
  
  public final boolean gt(String paramString)
  {
    AppMethodBeat.i(137056);
    h localh = atf(paramString);
    if (localh == null)
    {
      if (this.wxN.gl(paramString))
      {
        bool = this.wxN.gt(paramString);
        AppMethodBeat.o(137056);
        return bool;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      AppMethodBeat.o(137056);
      return true;
    }
    boolean bool = localh.isStopped();
    AppMethodBeat.o(137056);
    return bool;
  }
  
  public final boolean h(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137043);
    if (paramb == null)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      by(605, "");
      AppMethodBeat.o(137043);
      return false;
    }
    if (TextUtils.isEmpty(paramb.ddg))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      by(604, paramb.ddg);
      AppMethodBeat.o(137043);
      return false;
    }
    if (!this.wxs.contains(paramb.ddg))
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      by(601, paramb.ddg);
      AppMethodBeat.o(137043);
      return false;
    }
    if (paramb.hOy) {
      j(paramb);
    }
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject2 = atj(paramb.ddg);
    Object localObject1 = Dk(paramb.ddg);
    int i = ate((String)localObject2);
    boolean bool2;
    boolean bool3;
    if (i >= 10)
    {
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i) });
      this.wxA.put(paramb.ddg, paramb);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.hOy) });
      if ((paramb.hOy) && (atn(paramb.ddg))) {
        duR();
      }
    }
    else
    {
      atl(paramb.ddg);
      duS();
      atr((String)localObject2);
      duV();
      this.wxy.put(localObject2, paramb.processName);
      this.wxA.put(paramb.ddg, paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (this.wxL.containsKey(paramb.der))) {
        paramb.filePath = ((String)this.wxL.get(paramb.der));
      }
      localObject2 = atf(paramb.ddg);
      bool2 = duI();
      if (!bool2) {
        break label563;
      }
      bool3 = a((h)localObject2);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.wxN.gy(paramb.filePath))) && ((localObject1 == null) || (!paramb.e((com.tencent.mm.ai.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.ai.b)localObject1).filePath)) || (!this.wxN.gy(((com.tencent.mm.ai.b)localObject1).filePath)))) {
        break label558;
      }
    }
    label558:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.ddg });
      if ((!bool3) || (!bool1)) {
        break;
      }
      a(paramb, (com.tencent.mm.ai.b)localObject1);
      AppMethodBeat.o(137043);
      return true;
      if (paramb.hOy)
      {
        by(600, paramb.ddg);
        duT();
        AppMethodBeat.o(137043);
        return false;
      }
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = atf(paramb.ddg);
      if (localObject1 != null)
      {
        ((h)localObject1).b(paramb);
        ((h)localObject1).dvb();
      }
      AppMethodBeat.o(137043);
      return true;
    }
    label563:
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    b(paramb, (com.tencent.mm.ai.b)localObject1);
    if (bool2) {
      i(paramb);
    }
    AppMethodBeat.o(137043);
    return true;
  }
  
  public final String ij(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137041);
    ae.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.wxz.get(paramString1);
    Object localObject = this.qhj;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.wxu.contains(paramString2)) {
            break label241;
          }
          if (this.wxw.contains(paramString2))
          {
            break label241;
            j = ate(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label133;
            }
            ae.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
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
      ae.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      ii(paramString1, paramString2);
      AppMethodBeat.o(137041);
      return null;
      label174:
      if (i != 0)
      {
        ae.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        by(603, paramString2);
        AppMethodBeat.o(137041);
        return null;
      }
      ii(paramString1, paramString2);
      atl(paramString2);
      ae.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137041);
      return paramString2;
      label241:
      int i = 1;
    }
  }
  
  public final class a
    implements Comparator<com.tencent.mm.ai.b>
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */