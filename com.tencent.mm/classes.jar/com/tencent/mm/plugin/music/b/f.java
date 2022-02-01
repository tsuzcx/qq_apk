package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.a.w.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static f vcO;
  com.tencent.mm.ai.a cZk;
  Object pwZ;
  HashMap<String, com.tencent.mm.ai.b> vcA;
  private HashMap<String, com.tencent.mm.ai.d> vcB;
  private LinkedList<String> vcC;
  HashMap<String, Integer> vcD;
  private LinkedList<String> vcE;
  boolean vcF;
  private boolean vcG;
  long vcH;
  private long vcI;
  com.tencent.mm.plugin.music.b.a.d vcJ;
  private com.tencent.mm.plugin.music.b.b.a vcK;
  private HashMap<String, String> vcL;
  HashMap<String, Integer> vcM;
  com.tencent.mm.audio.mix.f.c vcN;
  private c vcP;
  private Runnable vcQ;
  Runnable vcR;
  private com.tencent.mm.audio.mix.f.b vcS;
  private com.tencent.mm.audio.mix.f.g vcT;
  private LinkedList<String> vcs;
  HashMap<String, h> vct;
  LinkedList<String> vcu;
  HashMap<String, h> vcv;
  LinkedList<String> vcw;
  public LinkedList<String> vcx;
  private HashMap<String, String> vcy;
  HashMap<String, LinkedList<String>> vcz;
  
  private f()
  {
    AppMethodBeat.i(137037);
    this.vcs = new LinkedList();
    this.vct = new HashMap();
    this.vcu = new LinkedList();
    this.vcv = new HashMap();
    this.vcw = new LinkedList();
    this.vcx = new LinkedList();
    this.vcy = new HashMap();
    this.vcz = new HashMap();
    this.vcA = new HashMap();
    this.vcB = new HashMap();
    this.vcC = new LinkedList();
    this.vcD = new HashMap();
    this.vcE = new LinkedList();
    this.pwZ = new Object();
    this.vcF = false;
    this.vcG = false;
    this.vcH = 0L;
    this.vcI = 0L;
    this.cZk = new com.tencent.mm.ai.a();
    this.vcK = new com.tencent.mm.plugin.music.b.b.a();
    this.vcL = new HashMap();
    this.vcM = new HashMap();
    this.vcP = new c()
    {
      public final void acj(String paramAnonymousString)
      {
        AppMethodBeat.i(137018);
        h localh = f.this.amT(paramAnonymousString);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
          AppMethodBeat.o(137018);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.dho();
        f.a(f.this, paramAnonymousString);
        f.this.ane(paramAnonymousString);
        AppMethodBeat.o(137018);
      }
      
      public final void amK(String paramAnonymousString)
      {
        AppMethodBeat.i(137017);
        h localh = f.this.amT(paramAnonymousString);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
          AppMethodBeat.o(137017);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.dho();
        AppMethodBeat.o(137017);
      }
      
      public final void fh(String paramAnonymousString)
      {
        AppMethodBeat.i(137019);
        h localh = f.this.amT(paramAnonymousString);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
          AppMethodBeat.o(137019);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f.this.f(paramAnonymousString, localh);
        f.a(f.this);
        f.this.dho();
        f.a(f.this, paramAnonymousString);
        f.this.ane(paramAnonymousString);
        AppMethodBeat.o(137019);
      }
      
      public final void onError(String paramAnonymousString)
      {
        AppMethodBeat.i(137020);
        h localh = f.this.amT(paramAnonymousString);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
          AppMethodBeat.o(137020);
          return;
        }
        f.this.b(paramAnonymousString, localh);
        f localf = f.this;
        int j = localh.pwp;
        if (localf.vcD.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localf.vcD.get(paramAnonymousString)).intValue();; i = 0)
        {
          if (i > 0)
          {
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            localf.vcD.remove(paramAnonymousString);
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label189;
            }
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            f.this.dhs();
            f.this.b(paramAnonymousString, null);
            AppMethodBeat.o(137020);
            return;
            if (66 != j)
            {
              localf.vcD.remove(paramAnonymousString);
              break;
            }
            if (!localf.and(paramAnonymousString)) {
              break;
            }
            localf.vcD.put(paramAnonymousString, Integer.valueOf(i + 1));
          }
          label189:
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
          f.this.f(paramAnonymousString, localh);
          f.a(f.this);
          f.this.dho();
          AppMethodBeat.o(137020);
          return;
        }
      }
      
      public final void onStart(String arg1)
      {
        AppMethodBeat.i(137016);
        h localh = f.this.amT(???);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
          AppMethodBeat.o(137016);
          return;
        }
        f.this.e(???, localh);
        synchronized (f.this.pwZ)
        {
          f.this.vcF = false;
          ap.aB(f.this.vcR);
          AppMethodBeat.o(137016);
          return;
        }
      }
    };
    this.vcQ = new f.2(this);
    this.vcR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137022);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
        Iterator localIterator = f.this.vcx.iterator();
        int i = 0;
        f localf;
        Object localObject5;
        if (localIterator.hasNext())
        {
          ??? = (String)localIterator.next();
          if (f.this.amS((String)???) != 0) {
            break label450;
          }
          localf = f.this;
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
          localObject5 = (LinkedList)localf.vcz.get(???);
          if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
          {
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
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
            synchronized (localf.pwZ)
            {
              localObject6 = ((LinkedList)localObject5).iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (String)((Iterator)localObject6).next();
              if (localf.vcN.fk((String)localObject7)) {
                localf.vcN.fo((String)localObject7);
              }
              localh = (h)localf.vct.remove(localObject7);
              localf.vcu.remove(localObject7);
              if (localh == null) {
                continue;
              }
              localf.b((String)localObject7, localh);
              ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
              if (localh.htD) {
                f.d((String)localObject7, localh);
              }
            }
            f.c((String)localObject7, localh);
          }
          localObject5 = ((LinkedList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localf.vcN.fk((String)localObject6)) {
              localf.vcN.fo((String)localObject6);
            }
            localObject7 = (h)localf.vcv.remove(localObject6);
            localf.vcw.remove(localObject6);
            if (localObject7 != null)
            {
              localf.b((String)localObject6, (h)localObject7);
              ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
              if (((h)localObject7).htD) {
                f.d((String)localObject6, (h)localObject7);
              } else {
                f.c((String)localObject6, (h)localObject7);
              }
            }
          }
          break label112;
          if (i == 0) {}
          synchronized (f.this.pwZ)
          {
            f.this.vcF = true;
            f.this.vcH = System.currentTimeMillis();
            ap.n(f.this.vcR, 1800000L);
            AppMethodBeat.o(137022);
            return;
          }
        }
      }
    };
    this.vcS = new com.tencent.mm.audio.mix.f.b()
    {
      public final void b(w paramAnonymousw)
      {
        AppMethodBeat.i(137024);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137024);
      }
      
      public final void c(w paramAnonymousw)
      {
        AppMethodBeat.i(137025);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137025);
      }
      
      public final void d(w paramAnonymousw)
      {
        AppMethodBeat.i(137026);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137026);
      }
      
      public final void e(w paramAnonymousw)
      {
        AppMethodBeat.i(137027);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137027);
      }
      
      public final void f(w paramAnonymousw)
      {
        AppMethodBeat.i(137028);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137028);
      }
      
      public final void g(w paramAnonymousw)
      {
        AppMethodBeat.i(137029);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137029);
      }
      
      public final void h(w paramAnonymousw)
      {
        AppMethodBeat.i(137030);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137030);
      }
      
      public final void i(w paramAnonymousw)
      {
        AppMethodBeat.i(137031);
        com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
        AppMethodBeat.o(137031);
      }
      
      public final void j(w paramAnonymousw)
      {
        AppMethodBeat.i(137032);
        int i = paramAnonymousw.cZm.errCode;
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
        if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
        }
        while (f.this.vcJ != null)
        {
          com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.vcA.get(paramAnonymousw.cZm.cQO);
          if (localb == null)
          {
            AppMethodBeat.o(137032);
            return;
            com.tencent.mm.sdk.b.a.GpY.a(paramAnonymousw, Looper.getMainLooper());
          }
          else
          {
            f.this.vcJ.Ju(paramAnonymousw.cZm.errCode);
            if (!f.this.vcN.fx(localb.filePath))
            {
              if (f.this.vcM.containsKey(localb.filePath))
              {
                i = ((Integer)f.this.vcM.get(localb.filePath)).intValue();
                f.this.vcM.put(localb.filePath, Integer.valueOf(i + 1));
                AppMethodBeat.o(137032);
                return;
              }
              f.this.vcM.put(localb.filePath, Integer.valueOf(1));
            }
          }
        }
        AppMethodBeat.o(137032);
      }
      
      public final void k(w paramAnonymousw)
      {
        AppMethodBeat.i(137033);
        if (f.this.vcJ != null)
        {
          com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.vcA.get(paramAnonymousw.cZm.cQO);
          if (localb == null)
          {
            AppMethodBeat.o(137033);
            return;
          }
          if (localb.htt > 1000000L) {
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.cQO, Long.valueOf(localb.htt) });
          }
          Object localObject = paramAnonymousw.cZm.cRZ;
          paramAnonymousw = (w)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramAnonymousw = localb.cRZ;
          }
          localObject = f.this.vcJ;
          String str1 = localb.cQO;
          long l1 = System.currentTimeMillis();
          long l2 = localb.htr;
          long l3 = localb.hts;
          long l4 = localb.htt;
          String str2 = localb.filePath;
          long l5 = f.this.vcN.ft(localb.cQO);
          long l6 = localb.fileSize;
          String str3 = localb.filePath;
          ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramAnonymousw, l1 - l2, l3, l4, false, str2, l5, l6, com.tencent.mm.audio.mix.b.e.ML().eR(str3));
          if (f.this.vcM.containsKey(localb.filePath)) {
            f.this.vcM.remove(localb.filePath);
          }
        }
        AppMethodBeat.o(137033);
      }
    };
    this.vcT = new com.tencent.mm.audio.mix.f.g()
    {
      public final void hG(int paramAnonymousInt)
      {
        AppMethodBeat.i(137034);
        if (f.this.vcJ != null) {
          f.this.vcJ.Jt(paramAnonymousInt);
        }
        AppMethodBeat.o(137034);
      }
    };
    _release();
    this.vcN = new com.tencent.mm.audio.mix.f.c();
    this.vcN.a(this.vcS);
    this.vcN.a(this.vcT);
    AppMethodBeat.o(137037);
  }
  
  private void a(com.tencent.mm.ai.b paramb1, com.tencent.mm.ai.b paramb2)
  {
    AppMethodBeat.i(137045);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    amY(paramb1.cQO);
    k(paramb1);
    if ((TextUtils.isEmpty(paramb1.filePath)) && (paramb2 != null) && (paramb2.e(paramb1))) {
      paramb1.filePath = paramb2.filePath;
    }
    if (paramb1.htn)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        a(paramb1, true, false);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.vcN.eX(paramb1.cQO)) || (this.vcN.fp(paramb1.cQO)) || (this.vcN.fq(paramb1.cQO)) || (this.vcN.fr(paramb1.cQO)) || (this.vcN.isPaused(paramb1.cQO))) {
          this.vcN.fo(paramb1.cQO);
        }
        this.vcN.a(paramb1);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.vcN.eX(paramb1.cQO))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      if ((this.vcN.fp(paramb1.cQO)) && (this.vcN.isPaused(paramb1.cQO)))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.vcN.fm(paramb1.cQO);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.vcN.fr(paramb1.cQO))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.vcN.fm(paramb1.cQO);
        AppMethodBeat.o(137045);
        return;
      }
      if (this.vcN.fq(paramb1.cQO))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        AppMethodBeat.o(137045);
        return;
      }
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.vcN.a(paramb1);
      AppMethodBeat.o(137045);
      return;
    }
    if (this.vcN.fk(paramb1.cQO)) {
      this.vcN.c(paramb1);
    }
    for (;;)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.vcN.eX(paramb1.cQO)) || (this.vcN.fp(paramb1.cQO)) || (this.vcN.fq(paramb1.cQO)) || (this.vcN.fr(paramb1.cQO)) || (this.vcN.isPaused(paramb1.cQO))) {
          this.vcN.fo(paramb1.cQO);
        }
      }
      this.vcN.o(7, paramb1.cQO);
      AppMethodBeat.o(137045);
      return;
      this.vcN.b(paramb1);
    }
  }
  
  private void a(com.tencent.mm.ai.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137091);
    this.vcJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.vcJ != null) {
      this.vcJ.r(paramb.cQO, paramb.cRZ, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.htr = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.htv;
    }
    for (paramb.hts = paramb.htu; (l1 > 0L) && (l2 > l1); paramb.hts = paramb.htw)
    {
      paramb.htt = (l2 - l1);
      AppMethodBeat.o(137091);
      return;
      l1 = paramb.htx;
    }
    paramb.htt = 0L;
    AppMethodBeat.o(137091);
  }
  
  private void a(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137039);
    if (paramb == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137039);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.vcy.put(paramb.appId, paramb.processName);
    this.vcA.put(paramb.cQO, paramb);
    hR(paramb.appId, paramString);
    this.vcD.remove(paramString);
    AppMethodBeat.o(137039);
  }
  
  private void a(String paramString, h paramh)
  {
    AppMethodBeat.i(137068);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    if ((localb != null) && (paramh.aGv()) && (paramh.aGx()))
    {
      localb.htn = true;
      localb.cSh = paramh.dhO();
    }
    for (;;)
    {
      b(paramString, paramh);
      paramString = amR(paramString);
      if ((paramString != null) && (paramh.aGv())) {
        paramString.rM = true;
      }
      if ((!paramh.aGv()) && (!paramh.aGx()) && (!paramh.cDT()) && (!paramh.blh()) && (!paramh.isPaused())) {
        break;
      }
      paramh.dhL();
      AppMethodBeat.o(137068);
      return;
      if ((localb != null) && (paramh.aGx()))
      {
        localb.htn = true;
        localb.cSh = paramh.dhO();
      }
      else if (localb != null)
      {
        localb.htn = true;
        localb.cSh = 0;
      }
    }
    paramh.dhK();
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
    if ((paramh.aGv()) || (paramh.isPaused()) || (paramh.cDT()) || (paramh.blh()) || (paramh.aGx())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    AppMethodBeat.o(137075);
    return false;
  }
  
  private void amW(String arg1)
  {
    AppMethodBeat.i(137064);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.vcz.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137064);
      return;
    }
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.pwZ)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.vcN.fk(str)) {
          this.vcN.fo(str);
        }
        localh = (h)this.vcv.remove(str);
        this.vcw.remove(str);
        if (localh == null) {
          continue;
        }
        b(str, localh);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localh.htD) {
          d(str, localh);
        }
      }
      c(str, localh);
    }
    AppMethodBeat.o(137064);
  }
  
  private String amX(String paramString)
  {
    AppMethodBeat.i(137067);
    Iterator localIterator = this.vcx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.vcz.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137067);
        return str;
      }
    }
    AppMethodBeat.o(137067);
    return "";
  }
  
  private boolean amY(String paramString)
  {
    AppMethodBeat.i(137074);
    ??? = amT(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137074);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.pwZ)
    {
      this.vct.remove(paramString);
      this.vcu.remove(paramString);
      this.vcv.remove(paramString);
      this.vcw.remove(paramString);
      AppMethodBeat.o(137074);
      return true;
    }
  }
  
  private void amZ(String paramString)
  {
    AppMethodBeat.i(137078);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.vct.size();
    int j = this.vcv.size();
    int k = dhp();
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      dhq();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = amX(paramString);
      i = this.vct.size();
      j = this.vcv.size();
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.vcx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          ana(str);
        }
      }
      if (k >= 6) {
        dhq();
      } else if (i + k >= 8) {
        dhq();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.vcx.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          ana(str);
        }
      }
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.vcv.size();
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      dhr();
      AppMethodBeat.o(137078);
      return;
    }
    if (j + i >= 50)
    {
      dhr();
      AppMethodBeat.o(137078);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137078);
  }
  
  private void ana(String paramString)
  {
    AppMethodBeat.i(137081);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    amW(paramString);
    AppMethodBeat.o(137081);
  }
  
  private boolean anb(String paramString)
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
      synchronized (this.pwZ)
      {
        m = this.vct.size();
        if (m < 10)
        {
          this.vcC.clear();
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137082);
          return false;
        }
        localObject3 = this.vcu.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.vcA.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).cRZ == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.ai.b)localObject4).cRZ))
        {
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).cRZ, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).cQO);
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).cRZ, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.ai.b)localObject4).cRZ)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.ai.b)localObject4).cRZ);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).cRZ)).intValue();
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).cRZ, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).cRZ);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).cQO)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).cQO);
      }
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).cRZ, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.dij();
    ac.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      ac.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
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
        paramString = (com.tencent.mm.ai.b)this.vcA.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.cRZ)))
        {
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.ai.b)this.vcA.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new f.a(this));
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.ai.b)paramString.next()).cQO);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label826;
            }
            i += 1;
            ac.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.vcC.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            ac.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.vcC.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137082);
          return bool1;
          label826:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.vcC.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.vcC.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.vcC.clear();
        }
      }
      label905:
      break label469;
      label908:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void b(com.tencent.mm.ai.b paramb1, com.tencent.mm.ai.b paramb2)
  {
    int i = 1;
    AppMethodBeat.i(137046);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    h localh = amT(paramb1.cQO);
    if (localh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.cQO });
      paramb2 = dhn();
      paramb2.a(this.vcP);
      paramb2.anf(paramb1.cQO);
      paramb2.b(paramb1);
      if (paramb1.htn)
      {
        a(paramb1, true, true);
        e(paramb1.cQO, paramb2);
        paramb1.hto = System.currentTimeMillis();
        paramb2.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      f(paramb1.cQO, paramb2);
      paramb2.dhz();
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      AppMethodBeat.o(137046);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.cQO });
    if (paramb1.htn)
    {
      e(paramb1.cQO, localh);
      paramb1.hto = System.currentTimeMillis();
      localh.b(paramb1);
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localh.aGv()) || (localh.aGx()) || (localh.cDT()) || (localh.blh()) || (localh.isPaused())) {
          localh.stopPlay();
        }
        a(paramb1, true, true);
        localh.l(paramb1);
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.aGv())
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      if ((localh.aGx()) && (localh.isPaused()))
      {
        a(paramb1, true, true);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.blh())
      {
        a(paramb1, true, true);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localh.resume();
        AppMethodBeat.o(137046);
        return;
      }
      if (localh.cDT())
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
        AppMethodBeat.o(137046);
        return;
      }
      a(paramb1, true, true);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
      localh.l(paramb1);
      AppMethodBeat.o(137046);
      return;
    }
    for (;;)
    {
      synchronized (this.pwZ)
      {
        if (!this.vcu.contains(paramb1.cQO)) {
          break label594;
        }
        if (i == 0)
        {
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb1.cQO, localh);
          localh.b(paramb1);
          if ((paramb2 != null) && (!paramb2.e(paramb1)))
          {
            ac.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localh.aGv()) || (localh.aGx()) || (localh.cDT()) || (localh.blh()) || (localh.isPaused())) {
              localh.stopPlay();
            }
          }
          localh.dhz();
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
          AppMethodBeat.o(137046);
          return;
        }
      }
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      continue;
      label594:
      i = 0;
    }
  }
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(137065);
    ac.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = e.dhk();
    }
    paramString = new w();
    paramString.cZm.action = 4;
    paramString.cZm.state = "error";
    paramString.cZm.errCode = com.tencent.mm.plugin.music.f.a.e.JY(paramInt);
    paramString.cZm.errMsg = com.tencent.mm.plugin.music.f.a.e.tV(paramInt);
    paramString.cZm.cQO = str;
    paramString.cZm.appId = amX(str);
    com.tencent.mm.sdk.b.a.GpY.a(paramString, Looper.getMainLooper());
    AppMethodBeat.o(137065);
  }
  
  static void c(String paramString, h paramh)
  {
    AppMethodBeat.i(137070);
    if (paramh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137070);
      return;
    }
    if ((paramh.aGv()) || (paramh.aGx()) || (paramh.cDT()) || (paramh.blh()) || (paramh.isPaused())) {
      paramh.stopPlay();
    }
    paramh.release();
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137070);
  }
  
  static void d(String paramString, h paramh)
  {
    AppMethodBeat.i(137071);
    ac.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramh);
    AppMethodBeat.o(137071);
  }
  
  /* Error */
  public static void dhl()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 743
    //   6: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 745	com/tencent/mm/plugin/music/b/f:vcO	Lcom/tencent/mm/plugin/music/b/f;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 743
    //   18: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/f
    //   28: dup
    //   29: invokespecial 746	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   32: putstatic 745	com/tencent/mm/plugin/music/b/f:vcO	Lcom/tencent/mm/plugin/music/b/f;
    //   35: ldc_w 743
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
  
  public static f dhm()
  {
    AppMethodBeat.i(137036);
    if (vcO == null) {
      vcO = new f();
    }
    f localf = vcO;
    AppMethodBeat.o(137036);
    return localf;
  }
  
  private h dhn()
  {
    AppMethodBeat.i(137066);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.pwZ)
    {
      if (this.vcv.size() == 0)
      {
        localObject1 = new h();
        AppMethodBeat.o(137066);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.vcw.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (h)this.vcv.get(str);
        if (??? != null)
        {
          if ((!((h)???).htD) && (!((h)???).isCompleted()) && (!((h)???).isStopped()))
          {
            if (((h)???).vda == null) {
              break label422;
            }
            if (((h)???).vda.getPlayerState() != 9) {
              break label417;
            }
            i = 1;
            break label395;
          }
          label169:
          if ((l1 != 0L) && (((h)???).gcd >= l1)) {
            break label380;
          }
          l1 = ((h)???).gcd;
          localObject1 = str;
          localObject5 = ???;
          break label402;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.pwZ)
        {
          if (this.vcw.contains(localObject5))
          {
            this.vcv.remove(localObject5);
            this.vcw.remove(localObject5);
          }
          if (this.vcu.contains(localObject5))
          {
            this.vcu.remove(localObject5);
            this.vct.remove(localObject5);
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
  
  private int dhp()
  {
    AppMethodBeat.i(137077);
    int i;
    boolean bool;
    synchronized (this.pwZ)
    {
      Iterator localIterator = this.vcw.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        h localh = amT((String)localObject3);
        if (localh == null)
        {
          ac.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = amR((String)localObject3);
          if (localObject3 == null) {
            break label135;
          }
          bool = ((com.tencent.mm.ai.d)localObject3).rM;
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
  
  private void dhq()
  {
    AppMethodBeat.i(137079);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.pwZ)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.vcw);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        h localh = (h)this.vcv.get(str);
        if ((localh != null) && (localh.isPaused())) {
          a(str, localh);
        }
      }
    }
    AppMethodBeat.o(137079);
  }
  
  private void dhr()
  {
    AppMethodBeat.i(137080);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.pwZ)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.vcw);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localh = (h)this.vcv.remove(str);
        this.vcw.remove(str);
        if (localh == null) {
          continue;
        }
        if (localh.htD)
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
  
  private void dht()
  {
    AppMethodBeat.i(137086);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.cZk.htl), Boolean.valueOf(this.vcK.vdQ) });
    if ((!this.cZk.htl) && (!this.vcK.vdQ))
    {
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      requestFocus();
      AppMethodBeat.o(137086);
      return;
    }
    if ((this.cZk.htl) && (this.vcK.vdQ))
    {
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bjF();
    }
    AppMethodBeat.o(137086);
  }
  
  private void dhu()
  {
    AppMethodBeat.i(137089);
    this.vcJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.vcJ != null) {
      this.vcJ.dhS();
    }
    AppMethodBeat.o(137089);
  }
  
  private boolean ec(String paramString, int paramInt)
  {
    AppMethodBeat.i(137053);
    paramString = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    if (paramString != null)
    {
      paramString.cSh = paramInt;
      AppMethodBeat.o(137053);
      return true;
    }
    AppMethodBeat.o(137053);
    return false;
  }
  
  private void hR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137040);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137040);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.vcx.contains(paramString1)) {
      this.vcx.add(paramString1);
    }
    if (!this.vcs.contains(paramString2)) {
      this.vcs.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.vcz.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.vcz.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137040);
  }
  
  private void i(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137044);
    if (this.vcN.fk(paramb.cQO)) {
      this.vcN.c(paramb);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramb.filePath)) {
        ane(paramb.cQO);
      }
      AppMethodBeat.o(137044);
      return;
      this.vcN.b(paramb);
    }
  }
  
  private void j(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137090);
    this.vcJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.vcJ != null) {
      this.vcJ.hT(paramb.cQO, paramb.cRZ);
    }
    AppMethodBeat.o(137090);
  }
  
  private static void k(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137093);
    if (paramb.htA != null) {
      try
      {
        paramb.htA.close();
        paramb.htA = null;
        AppMethodBeat.o(137093);
        return;
      }
      catch (Exception paramb)
      {
        ac.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
    AppMethodBeat.o(137093);
  }
  
  private void requestFocus()
  {
    AppMethodBeat.i(137087);
    if (this.vcK.vdQ)
    {
      AppMethodBeat.o(137087);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.vcK.requestFocus()) });
    AppMethodBeat.o(137087);
  }
  
  public final void _release()
  {
    AppMethodBeat.i(137038);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.vcs.clear();
    String str;
    synchronized (this.pwZ)
    {
      Iterator localIterator = this.vcu.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (h)this.vct.remove(str));
      }
    }
    this.vcu.clear();
    this.vct.clear();
    Object localObject3 = this.vcw.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (h)this.vcv.remove(str));
    }
    this.vcw.clear();
    this.vcv.clear();
    ??? = this.vcx.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.vcz.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.vcx.clear();
    this.vcy.clear();
    this.vcz.clear();
    this.vcA.clear();
    this.vcB.clear();
    this.vcD.clear();
    this.vcE.clear();
    ap.aB(this.vcQ);
    ap.aB(this.vcR);
    this.vcF = false;
    this.vcG = false;
    AppMethodBeat.o(137038);
  }
  
  public final boolean amL(String paramString)
  {
    AppMethodBeat.i(137048);
    h localh = amT(paramString);
    if (localh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.vcN.fk(paramString))
      {
        this.vcN.fn(paramString);
        AppMethodBeat.o(137048);
        return true;
      }
      AppMethodBeat.o(137048);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localh.pause();
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137048);
    return true;
  }
  
  public final boolean amM(String paramString)
  {
    AppMethodBeat.i(137049);
    h localh = amT(paramString);
    if (localh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.vcN.fk(paramString))
      {
        this.vcN.fo(paramString);
        AppMethodBeat.o(137049);
        return true;
      }
      AppMethodBeat.o(137049);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localh.stopPlay();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    if (localb != null)
    {
      localb.cSh = 0;
      localb.htn = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137049);
    return true;
  }
  
  public final boolean amN(String paramString)
  {
    AppMethodBeat.i(137050);
    if (this.vcN.fk(paramString)) {
      this.vcN.fo(paramString);
    }
    h localh = amT(paramString);
    if (localh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137050);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localh.dhM();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    if (localb != null)
    {
      localb.cSh = 0;
      localb.htn = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137050);
    return true;
  }
  
  public final boolean amO(String paramString)
  {
    AppMethodBeat.i(137051);
    this.vcN.fo(paramString);
    this.vcN.remove(paramString);
    ??? = amT(paramString);
    if (??? == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      AppMethodBeat.o(137051);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.pwZ)
    {
      this.vct.remove(paramString);
      this.vcu.remove(paramString);
      this.vcv.remove(paramString);
      this.vcw.remove(paramString);
      this.vcs.remove(paramString);
      ??? = this.vcx.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.vcz.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.vcz.remove(str);
            this.vcx.remove(str);
            this.vcy.remove(str);
          }
        }
      }
      this.vcA.remove(paramString);
      this.vcB.remove(paramString);
      AppMethodBeat.o(137051);
      return true;
    }
  }
  
  public final boolean amP(String paramString)
  {
    AppMethodBeat.i(137054);
    h localh = amT(paramString);
    if (localh == null)
    {
      if (this.vcN.fk(paramString))
      {
        bool = this.vcN.fp(paramString);
        AppMethodBeat.o(137054);
        return bool;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137054);
      return false;
    }
    boolean bool = localh.aGx();
    AppMethodBeat.o(137054);
    return bool;
  }
  
  public final boolean amQ(String paramString)
  {
    AppMethodBeat.i(137057);
    h localh = amT(paramString);
    if (localh == null)
    {
      if (this.vcN.fk(paramString))
      {
        bool = this.vcN.NH();
        AppMethodBeat.o(137057);
        return bool;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = amR(paramString);
      if (paramString != null)
      {
        bool = paramString.htD;
        AppMethodBeat.o(137057);
        return bool;
      }
      AppMethodBeat.o(137057);
      return false;
    }
    boolean bool = localh.htD;
    AppMethodBeat.o(137057);
    return bool;
  }
  
  public final com.tencent.mm.ai.d amR(String paramString)
  {
    AppMethodBeat.i(137058);
    Object localObject = amT(paramString);
    if (localObject != null)
    {
      paramString = ((h)localObject).dhP();
      AppMethodBeat.o(137058);
      return paramString;
    }
    if (this.vcN.fk(paramString))
    {
      localObject = this.vcN.fu(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137058);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.ai.d)this.vcB.get(paramString);
    AppMethodBeat.o(137058);
    return paramString;
  }
  
  public final int amS(String paramString)
  {
    AppMethodBeat.i(137059);
    int j = dhp();
    synchronized (this.pwZ)
    {
      int k = this.vcs.size();
      int m = this.vct.size();
      int n = this.vcv.size();
      paramString = (LinkedList)this.vcz.get(paramString);
      if (paramString == null)
      {
        i = 0;
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(137059);
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final h amT(String paramString)
  {
    AppMethodBeat.i(137061);
    if (this.vct.containsKey(paramString))
    {
      paramString = (h)this.vct.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    if (this.vcv.containsKey(paramString))
    {
      paramString = (h)this.vcv.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    AppMethodBeat.o(137061);
    return null;
  }
  
  public final void amU(String paramString)
  {
    AppMethodBeat.i(137062);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.vcN.NG();
    bjF();
    Object localObject3 = (LinkedList)this.vcz.get(paramString);
    long l1 = this.vcN.NJ();
    long l2 = com.tencent.mm.audio.mix.b.e.ML().MM();
    long l3 = com.tencent.mm.audio.mix.b.d.MJ().MK();
    long l4 = l2 + l3;
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.vcJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137062);
      return;
    }
    if ((this.vct.isEmpty()) && (this.vcv.isEmpty()))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.vcJ != null) {
        this.vcJ.c(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137062);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.pwZ)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        h localh = (h)this.vcv.get(localObject3);
        if (localh != null) {
          a((String)localObject3, localh);
        }
      }
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.vct.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (h)this.vct.get(???);
      if (localObject3 != null)
      {
        a((String)???, (h)localObject3);
        f((String)???, (h)localObject3);
      }
    }
    if (this.vcJ != null) {
      this.vcJ.c(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137062);
  }
  
  public final void amV(String paramString)
  {
    AppMethodBeat.i(137063);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bjF();
    LinkedList localLinkedList = (LinkedList)this.vcz.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137063);
      return;
    }
    String str;
    h localh;
    synchronized (this.pwZ)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localh = (h)this.vct.remove(str);
        this.vcu.remove(str);
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localh);
        this.vcA.remove(str);
        this.vcB.remove(str);
        if (this.vcN.fk(str))
        {
          this.vcN.fo(str);
          this.vcN.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localh = (h)this.vcv.remove(str);
      this.vcw.remove(str);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localh);
      this.vcA.remove(str);
      this.vcB.remove(str);
      if (this.vcN.fk(str))
      {
        this.vcN.fo(str);
        this.vcN.remove(str);
      }
    }
    this.vcs.removeAll(localLinkedList);
    this.vcx.remove(paramString);
    this.vcy.remove(paramString);
    this.vcN.clearCache();
    this.vcN.NI();
    this.vcL.clear();
    this.vcM.clear();
    AppMethodBeat.o(137063);
  }
  
  public final void anc(String paramString)
  {
    AppMethodBeat.i(137084);
    if (this.vcx.size() == 0)
    {
      AppMethodBeat.o(137084);
      return;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.vcx);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.vcy.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        amV(str1);
      }
    }
    AppMethodBeat.o(137084);
  }
  
  final boolean and(String paramString)
  {
    AppMethodBeat.i(137085);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.pwZ)
      {
        i = this.vct.size();
        if (i <= 5)
        {
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137085);
          return false;
        }
        localObject3 = this.vcu.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.vcA.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).cRZ == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.ai.b)localObject4).cRZ))
        {
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).cRZ, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).cQO);
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).cRZ, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.ai.b)localObject4).cRZ)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.ai.b)localObject4).cRZ);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).cRZ)).intValue();
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).cRZ, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).cRZ);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).cQO)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).cQO);
      }
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).cRZ, localArrayList);
    }
    paramString = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.cRZ)))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        AppMethodBeat.o(137085);
        return false;
      }
    }
    paramString = "";
    ac.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      ac.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
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
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.mm.ai.b)this.vcA.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new f.a(this));
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.ai.b)paramString.next()).cQO);
          }
          this.vcE.add(((LinkedList)localObject1).getLast());
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.vcE.size()) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137085);
        return bool1;
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      label785:
      break label534;
      label788:
      j = i;
      localObject1 = paramString;
    }
  }
  
  public final void ane(final String paramString)
  {
    AppMethodBeat.i(137092);
    if (!b.dhj())
    {
      AppMethodBeat.o(137092);
      return;
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(137023);
        com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)f.this.vcA.get(paramString);
        if (localb == null) {
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
        }
        long l1;
        long l2;
        com.tencent.mm.audio.mix.f.c localc;
        int i;
        int j;
        if ((!TextUtils.isEmpty(localb.filePath)) && (!f.this.vcN.fx(localb.filePath)))
        {
          l1 = com.tencent.mm.audio.mix.h.a.fD(localb.filePath);
          ac.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", new Object[] { localb.filePath, Long.valueOf(l1) });
          l2 = com.tencent.mm.audio.mix.b.e.ML().MM();
          localc = f.this.vcN;
          long l3 = com.tencent.mm.audio.mix.b.e.ML().MM();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
          if (l3 >= 50000000L)
          {
            i = 1;
            if (i != 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
            }
            j = 0;
            if (f.this.vcM.containsKey(localb.filePath)) {
              j = ((Integer)f.this.vcM.get(localb.filePath)).intValue();
            }
            if (i == 0) {
              break label288;
            }
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
            if (f.this.vcJ != null) {
              f.this.vcJ.Jv(713);
            }
            f.this.vcN.fv("");
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
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
            if (f.this.vcJ != null) {
              f.this.vcJ.Jv(714);
            }
            f.this.vcN.fv("");
          }
          else if (j >= 30)
          {
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
          }
          else if (!com.tencent.mm.audio.mix.h.a.fC(localb.filePath))
          {
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
          }
          else
          {
            localc = f.this.vcN;
            String str = localb.filePath;
            if (!localc.cTz.eT(str))
            {
              localb.htC = true;
              localb.fileSize = l1;
              f.this.vcN.a(localb);
            }
            else
            {
              ac.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
              continue;
              if (!TextUtils.isEmpty(localb.filePath))
              {
                localb.htC = false;
                if (!f.this.vcN.fk(paramString)) {
                  f.this.vcN.b(localb);
                }
                localb.fileSize = com.tencent.mm.audio.mix.h.a.fD(localb.filePath);
              }
              else
              {
                localb.htC = false;
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
    this.vcB.put(paramString, paramh.dhP());
    AppMethodBeat.o(137069);
  }
  
  public final boolean b(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137047);
    com.tencent.mm.ai.b localb2 = (com.tencent.mm.ai.b)this.vcA.get(paramString);
    com.tencent.mm.ai.b localb1;
    boolean bool1;
    if (((!this.vcs.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      j(localb1);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      int i = amS(amX(paramString));
      if (i >= 10)
      {
        ac.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!anb(paramString)) {
          break label368;
        }
        dhs();
      }
      dht();
      this.vcA.put(paramString, localb1);
      paramb = amT(paramString);
      if (!b.dhj()) {
        break label451;
      }
      boolean bool2 = a(paramb);
      if ((!this.vcN.fk(paramString)) || (!this.vcN.fw(paramString))) {
        break label388;
      }
      bool1 = true;
      label200:
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.cQO });
      if ((!bool2) || (!bool1)) {
        break label459;
      }
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      amY(localb1.cQO);
      k(localb1);
      if (!this.vcN.eX(localb1.cQO)) {
        break label394;
      }
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (!this.vcs.contains(paramString))
      {
        ac.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        bt(601, paramString);
        AppMethodBeat.o(137047);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      bt(602, paramString);
      AppMethodBeat.o(137047);
      return false;
      label368:
      dhu();
      bt(600, paramString);
      AppMethodBeat.o(137047);
      return false;
      label388:
      bool1 = false;
      break label200;
      label394:
      if (this.vcN.fq(localb1.cQO))
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.htn = true;
        paramb.b(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.vcN.fl(paramString);
      }
    }
    label451:
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label459:
    if (paramb == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      amZ(paramString);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = dhn();
      paramb.a(this.vcP);
      paramb.anf(paramString);
      e(paramString, paramb);
      localb1.htn = true;
      localb1.cSh = 0;
      localb1.hto = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.l(localb1);
      AppMethodBeat.o(137047);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.aGx()) && (!paramb.aGv()))
    {
      a(localb1, false, true);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (paramb.blh())
      {
        a(localb1, false, true);
        localb1.htn = true;
        localb1.hto = System.currentTimeMillis();
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.cSh = 0;
        paramb.b(localb1);
      }
      else if (paramb.cDT())
      {
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.htn = true;
        localb1.hto = System.currentTimeMillis();
        paramb.b(localb1);
      }
      else if (paramb.htD)
      {
        a(localb1, false, true);
        localb1.htn = true;
        localb1.hto = System.currentTimeMillis();
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
        paramb.l(localb1);
      }
      else
      {
        if (paramb.aGx()) {
          break;
        }
        a(localb1, false, true);
        localb1.htn = true;
        localb1.hto = System.currentTimeMillis();
        ac.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.l(localb1);
        localb1.cSh = 0;
      }
    }
    ac.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137047);
    return false;
  }
  
  final void bjF()
  {
    AppMethodBeat.i(137088);
    if (this.vcK.vdQ) {
      this.vcK.bjF();
    }
    AppMethodBeat.o(137088);
  }
  
  public final void dho()
  {
    AppMethodBeat.i(137076);
    long l = System.currentTimeMillis();
    if ((this.vcF) && (l - this.vcH < 10000L))
    {
      AppMethodBeat.o(137076);
      return;
    }
    this.vcH = l;
    synchronized (this.pwZ)
    {
      this.vcF = true;
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      ap.aB(this.vcR);
      ap.n(this.vcR, 1800000L);
      AppMethodBeat.o(137076);
      return;
    }
  }
  
  final void dhs()
  {
    AppMethodBeat.i(137083);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.vcC.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      amM(str);
      dhu();
    }
    localIterator = this.vcE.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      amM(str);
      dhu();
    }
    this.vcC.clear();
    this.vcE.clear();
    AppMethodBeat.o(137083);
  }
  
  final void e(String paramString, h paramh)
  {
    AppMethodBeat.i(137072);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.pwZ)
    {
      if (this.vcw.contains(paramString))
      {
        this.vcv.remove(paramString);
        this.vcw.remove(paramString);
      }
      if (!this.vcu.contains(paramString))
      {
        this.vcu.add(paramString);
        this.vct.put(paramString, paramh);
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  public final boolean eb(String paramString, int paramInt)
  {
    AppMethodBeat.i(137052);
    h localh = amT(paramString);
    if (localh == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.vcN.fk(paramString)) {
        this.vcN.w(paramString, paramInt);
      }
      bool = ec(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if (paramInt < 0)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    if (localh.getDuration() <= 0)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      localh.dhE();
      bool = ec(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if ((paramInt > 0) && (paramInt > localh.getDuration()))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((localh.aGv()) || (localh.aGx()) || (localh.isPaused()))
    {
      bool = localh.pl(paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    localh.dhE();
    boolean bool = ec(paramString, paramInt);
    AppMethodBeat.o(137052);
    return bool;
  }
  
  final void f(String paramString, h paramh)
  {
    AppMethodBeat.i(137073);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.pwZ)
    {
      if (this.vcu.contains(paramString))
      {
        this.vct.remove(paramString);
        this.vcu.remove(paramString);
      }
      if (!this.vcw.contains(paramString))
      {
        this.vcw.add(paramString);
        this.vcv.put(paramString, paramh);
      }
      AppMethodBeat.o(137073);
      return;
    }
  }
  
  public final boolean fs(String paramString)
  {
    AppMethodBeat.i(137056);
    h localh = amT(paramString);
    if (localh == null)
    {
      if (this.vcN.fk(paramString))
      {
        bool = this.vcN.fs(paramString);
        AppMethodBeat.o(137056);
        return bool;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      AppMethodBeat.o(137056);
      return true;
    }
    boolean bool = localh.isStopped();
    AppMethodBeat.o(137056);
    return bool;
  }
  
  public final boolean g(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137042);
    if (paramb == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137042);
      return false;
    }
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.vcA.get(paramb.cQO);
    if (localb != null)
    {
      localb.f(paramb);
      h localh = amT(paramb.cQO);
      if (localh == null) {
        break label130;
      }
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localh.b(localb);
      label76:
      if (b.dhj())
      {
        if (!this.vcN.fk(paramb.cQO)) {
          break label141;
        }
        this.vcN.c(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137042);
      return true;
      this.vcA.put(paramb.cQO, paramb);
      localb = paramb;
      break;
      label130:
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label76;
      label141:
      this.vcN.b(paramb);
    }
  }
  
  public final boolean h(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137043);
    if (paramb == null)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      bt(605, "");
      AppMethodBeat.o(137043);
      return false;
    }
    if (TextUtils.isEmpty(paramb.cQO))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      bt(604, paramb.cQO);
      AppMethodBeat.o(137043);
      return false;
    }
    if (!this.vcs.contains(paramb.cQO))
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      bt(601, paramb.cQO);
      AppMethodBeat.o(137043);
      return false;
    }
    if (paramb.htn) {
      j(paramb);
    }
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject2 = amX(paramb.cQO);
    Object localObject1 = zJ(paramb.cQO);
    int i = amS((String)localObject2);
    boolean bool2;
    boolean bool3;
    if (i >= 10)
    {
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i) });
      this.vcA.put(paramb.cQO, paramb);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.htn) });
      if ((paramb.htn) && (anb(paramb.cQO))) {
        dhs();
      }
    }
    else
    {
      amZ(paramb.cQO);
      dht();
      this.vcy.put(localObject2, paramb.processName);
      this.vcA.put(paramb.cQO, paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (this.vcL.containsKey(paramb.cRZ))) {
        paramb.filePath = ((String)this.vcL.get(paramb.cRZ));
      }
      localObject2 = amT(paramb.cQO);
      bool2 = b.dhj();
      if (!bool2) {
        break label552;
      }
      bool3 = a((h)localObject2);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.vcN.fx(paramb.filePath))) && ((localObject1 == null) || (!paramb.e((com.tencent.mm.ai.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.ai.b)localObject1).filePath)) || (!this.vcN.fx(((com.tencent.mm.ai.b)localObject1).filePath)))) {
        break label547;
      }
    }
    label547:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.cQO });
      if ((!bool3) || (!bool1)) {
        break;
      }
      a(paramb, (com.tencent.mm.ai.b)localObject1);
      AppMethodBeat.o(137043);
      return true;
      if (paramb.htn)
      {
        bt(600, paramb.cQO);
        dhu();
        AppMethodBeat.o(137043);
        return false;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = amT(paramb.cQO);
      if (localObject1 != null)
      {
        ((h)localObject1).b(paramb);
        ((h)localObject1).dhz();
      }
      AppMethodBeat.o(137043);
      return true;
    }
    label552:
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    b(paramb, (com.tencent.mm.ai.b)localObject1);
    if (bool2) {
      i(paramb);
    }
    AppMethodBeat.o(137043);
    return true;
  }
  
  public final String hS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137041);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.vcz.get(paramString1);
    Object localObject = this.pwZ;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.vcu.contains(paramString2)) {
            break label241;
          }
          if (this.vcw.contains(paramString2))
          {
            break label241;
            j = amS(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label133;
            }
            ac.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            bt(604, paramString2);
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
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      hR(paramString1, paramString2);
      AppMethodBeat.o(137041);
      return null;
      label174:
      if (i != 0)
      {
        ac.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        bt(603, paramString2);
        AppMethodBeat.o(137041);
        return null;
      }
      hR(paramString1, paramString2);
      amZ(paramString2);
      ac.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137041);
      return paramString2;
      label241:
      int i = 1;
    }
  }
  
  public final boolean zI(String paramString)
  {
    AppMethodBeat.i(137055);
    h localh = amT(paramString);
    if (localh == null)
    {
      if (this.vcN.fk(paramString))
      {
        bool = this.vcN.eX(paramString);
        AppMethodBeat.o(137055);
        return bool;
      }
      ac.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137055);
      return false;
    }
    boolean bool = localh.aGv();
    AppMethodBeat.o(137055);
    return bool;
  }
  
  public final com.tencent.mm.ai.b zJ(String paramString)
  {
    AppMethodBeat.i(137060);
    if (this.vcA.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.vcA.get(paramString);
      AppMethodBeat.o(137060);
      return paramString;
    }
    AppMethodBeat.o(137060);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */