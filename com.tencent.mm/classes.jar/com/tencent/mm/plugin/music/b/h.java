package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.e.f.a;
import com.tencent.mm.audio.mix.g.c;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static h Ahv;
  private LinkedList<String> AgR;
  HashMap<String, k> AgS;
  LinkedList<String> AgT;
  HashMap<String, k> AgU;
  LinkedList<String> AgV;
  public LinkedList<String> AgW;
  private HashMap<String, String> AgX;
  HashMap<String, LinkedList<String>> AgY;
  HashMap<String, com.tencent.mm.ai.b> AgZ;
  private com.tencent.mm.audio.mix.g.g AhA;
  private f.a AhB;
  volatile int AhC;
  private HashMap<String, com.tencent.mm.ai.d> Aha;
  private LinkedList<String> Ahb;
  HashMap<String, Integer> Ahc;
  private LinkedList<String> Ahd;
  boolean Ahe;
  private boolean Ahf;
  long Ahg;
  private long Ahh;
  com.tencent.mm.plugin.music.b.a.d Ahi;
  private com.tencent.mm.plugin.music.b.b.a Ahj;
  private PhoneStatusWatcher Ahk;
  private volatile boolean Ahl;
  ArrayList<j> Ahm;
  private HashMap<String, String> Ahn;
  HashMap<String, Integer> Aho;
  c Ahp;
  private volatile boolean Ahq;
  long Ahr;
  private LinkedList<String> Ahs;
  LinkedList<String> Aht;
  com.tencent.mm.audio.mix.e.a Ahu;
  private e Ahw;
  private Runnable Ahx;
  Runnable Ahy;
  private com.tencent.mm.audio.mix.g.b Ahz;
  private Looper Jap;
  com.tencent.mm.ai.a dCU;
  private AudioManager mAudioManager;
  Handler mHandler;
  volatile boolean qUm;
  Object ryf;
  
  private h()
  {
    AppMethodBeat.i(137037);
    this.AgR = new LinkedList();
    this.AgS = new HashMap();
    this.AgT = new LinkedList();
    this.AgU = new HashMap();
    this.AgV = new LinkedList();
    this.AgW = new LinkedList();
    this.AgX = new HashMap();
    this.AgY = new HashMap();
    this.AgZ = new HashMap();
    this.Aha = new HashMap();
    this.Ahb = new LinkedList();
    this.Ahc = new HashMap();
    this.Ahd = new LinkedList();
    this.ryf = new Object();
    this.Ahe = false;
    this.Ahf = false;
    this.Ahg = 0L;
    this.Ahh = 0L;
    this.dCU = new com.tencent.mm.ai.a();
    this.Ahj = new com.tencent.mm.plugin.music.b.b.a();
    this.Ahl = false;
    this.Ahm = new ArrayList();
    this.Ahn = new HashMap();
    this.Aho = new HashMap();
    this.qUm = true;
    this.Ahq = true;
    this.mAudioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    this.Ahr = 0L;
    this.Ahs = new LinkedList();
    this.Aht = new LinkedList();
    this.Ahw = new e()
    {
      public final void aGS(String paramAnonymousString)
      {
        AppMethodBeat.i(198142);
        k localk = h.this.aHb(paramAnonymousString);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
          AppMethodBeat.o(198142);
          return;
        }
        h.this.b(paramAnonymousString, localk);
        h.this.f(paramAnonymousString, localk);
        h.a(h.this);
        h.this.esK();
        AppMethodBeat.o(198142);
      }
      
      public final void arD(String paramAnonymousString)
      {
        AppMethodBeat.i(198143);
        k localk = h.this.aHb(paramAnonymousString);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
          AppMethodBeat.o(198143);
          return;
        }
        h.this.b(paramAnonymousString, localk);
        h.this.f(paramAnonymousString, localk);
        h.a(h.this);
        h.this.esK();
        h.this.aHm(paramAnonymousString);
        h.this.aHn(paramAnonymousString);
        AppMethodBeat.o(198143);
      }
      
      public final void gY(String paramAnonymousString)
      {
        AppMethodBeat.i(198144);
        k localk = h.this.aHb(paramAnonymousString);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
          AppMethodBeat.o(198144);
          return;
        }
        h.this.b(paramAnonymousString, localk);
        h.this.f(paramAnonymousString, localk);
        h.a(h.this);
        h.this.esK();
        h.this.aHm(paramAnonymousString);
        h.this.aHn(paramAnonymousString);
        AppMethodBeat.o(198144);
      }
      
      public final void onError(String paramAnonymousString)
      {
        AppMethodBeat.i(198145);
        k localk = h.this.aHb(paramAnonymousString);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
          AppMethodBeat.o(198145);
          return;
        }
        h.this.b(paramAnonymousString, localk);
        h localh = h.this;
        int j = localk.rxv;
        if (localh.Ahc.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localh.Ahc.get(paramAnonymousString)).intValue();; i = 0)
        {
          if (i > 0)
          {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            localh.Ahc.remove(paramAnonymousString);
          }
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label189;
            }
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            h.this.esO();
            h.this.b(paramAnonymousString, null);
            AppMethodBeat.o(198145);
            return;
            if (66 != j)
            {
              localh.Ahc.remove(paramAnonymousString);
              break;
            }
            if (!localh.aHl(paramAnonymousString)) {
              break;
            }
            localh.Ahc.put(paramAnonymousString, Integer.valueOf(i + 1));
          }
          label189:
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
          h.this.f(paramAnonymousString, localk);
          h.a(h.this);
          h.this.esK();
          AppMethodBeat.o(198145);
          return;
        }
      }
      
      public final void onStart(String arg1)
      {
        AppMethodBeat.i(198141);
        k localk = h.this.aHb(???);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
          AppMethodBeat.o(198141);
          return;
        }
        h.this.e(???, localk);
        synchronized (h.this.ryf)
        {
          h.this.Ahe = false;
          MMHandlerThread.removeRunnable(h.this.Ahy);
          AppMethodBeat.o(198141);
          return;
        }
      }
    };
    this.Ahx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137022);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
        Iterator localIterator = h.this.AgW.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (h.this.aHa(str) == 0) {
            h.this.aHc(str);
          }
        }
        AppMethodBeat.o(137022);
      }
    };
    this.Ahy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198146);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
        Iterator localIterator = h.this.AgW.iterator();
        int i = 0;
        h localh;
        Object localObject5;
        if (localIterator.hasNext())
        {
          ??? = (String)localIterator.next();
          if (h.this.aHa((String)???) != 0) {
            break label450;
          }
          localh = h.this;
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
          localObject5 = (LinkedList)localh.AgY.get(???);
          if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
          {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
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
            k localk;
            synchronized (localh.ryf)
            {
              localObject6 = ((LinkedList)localObject5).iterator();
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject7 = (String)((Iterator)localObject6).next();
              if (localh.Ahp.gD((String)localObject7)) {
                localh.Ahp.he((String)localObject7);
              }
              localk = (k)localh.AgS.remove(localObject7);
              localh.AgT.remove(localObject7);
              if (localk == null) {
                continue;
              }
              localh.b((String)localObject7, localk);
              Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
              if (localk.iJV) {
                h.d((String)localObject7, localk);
              }
            }
            h.c((String)localObject7, localk);
          }
          localObject5 = ((LinkedList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            if (localh.Ahp.gD((String)localObject6)) {
              localh.Ahp.he((String)localObject6);
            }
            localObject7 = (k)localh.AgU.remove(localObject6);
            localh.AgV.remove(localObject6);
            if (localObject7 != null)
            {
              localh.b((String)localObject6, (k)localObject7);
              Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
              if (((k)localObject7).iJV) {
                h.d((String)localObject6, (k)localObject7);
              } else {
                h.c((String)localObject6, (k)localObject7);
              }
            }
          }
          break label112;
          if (i == 0) {}
          synchronized (h.this.ryf)
          {
            h.this.Ahe = true;
            h.this.Ahg = System.currentTimeMillis();
            MMHandlerThread.postToMainThreadDelayed(h.this.Ahy, 1800000L);
            AppMethodBeat.o(198146);
            return;
          }
        }
      }
    };
    this.Ahz = new com.tencent.mm.audio.mix.g.b()
    {
      public final void b(y paramAnonymousy)
      {
        AppMethodBeat.i(198148);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198148);
      }
      
      public final void c(y paramAnonymousy)
      {
        AppMethodBeat.i(198149);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198149);
      }
      
      public final void d(y paramAnonymousy)
      {
        AppMethodBeat.i(198150);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198150);
      }
      
      public final void e(y paramAnonymousy)
      {
        AppMethodBeat.i(198151);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198151);
      }
      
      public final void f(y paramAnonymousy)
      {
        AppMethodBeat.i(198152);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        h.a(h.this, paramAnonymousy.dCW.dtX);
        AppMethodBeat.o(198152);
      }
      
      public final void g(y paramAnonymousy)
      {
        AppMethodBeat.i(198153);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198153);
      }
      
      public final void h(y paramAnonymousy)
      {
        AppMethodBeat.i(198154);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198154);
      }
      
      public final void i(y paramAnonymousy)
      {
        AppMethodBeat.i(198155);
        EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
        AppMethodBeat.o(198155);
      }
      
      public final void j(y paramAnonymousy)
      {
        AppMethodBeat.i(198156);
        int i = paramAnonymousy.dCW.errCode;
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
        if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
        }
        com.tencent.mm.ai.b localb;
        while (h.this.Ahi != null)
        {
          localb = (com.tencent.mm.ai.b)h.this.AgZ.get(paramAnonymousy.dCW.dtX);
          if (localb == null)
          {
            AppMethodBeat.o(198156);
            return;
            EventCenter.instance.asyncPublish(paramAnonymousy, Looper.getMainLooper());
          }
          else
          {
            h.this.Ahi.Sz(paramAnonymousy.dCW.errCode);
            if (!h.this.Ahp.hn(localb.filePath))
            {
              if (!h.this.Aho.containsKey(localb.filePath)) {
                break label242;
              }
              i = ((Integer)h.this.Aho.get(localb.filePath)).intValue();
              h.this.Aho.put(localb.filePath, Integer.valueOf(i + 1));
            }
          }
        }
        for (;;)
        {
          h.a(h.this, paramAnonymousy.dCW.dtX);
          AppMethodBeat.o(198156);
          return;
          label242:
          h.this.Aho.put(localb.filePath, Integer.valueOf(1));
        }
      }
      
      public final void k(y paramAnonymousy)
      {
        AppMethodBeat.i(198157);
        if (h.this.Ahi != null)
        {
          com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)h.this.AgZ.get(paramAnonymousy.dCW.dtX);
          if (localb == null)
          {
            AppMethodBeat.o(198157);
            return;
          }
          if (localb.iJK > 1000000L) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.dtX, Long.valueOf(localb.iJK) });
          }
          Object localObject = paramAnonymousy.dCW.dvn;
          paramAnonymousy = (y)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramAnonymousy = localb.dvn;
          }
          localObject = h.this.Ahi;
          String str1 = localb.dtX;
          long l1 = System.currentTimeMillis();
          long l2 = localb.iJI;
          long l3 = localb.iJJ;
          long l4 = localb.iJK;
          String str2 = localb.filePath;
          long l5 = h.this.Ahp.hj(localb.dtX);
          long l6 = localb.fileSize;
          String str3 = localb.filePath;
          ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramAnonymousy, l1 - l2, l3, l4, false, str2, l5, l6, f.YL().gH(str3));
          if (h.this.Aho.containsKey(localb.filePath)) {
            h.this.Aho.remove(localb.filePath);
          }
        }
        AppMethodBeat.o(198157);
      }
      
      public final void l(y paramAnonymousy)
      {
        AppMethodBeat.i(198158);
        h.a(h.this, paramAnonymousy.dCW.dtX);
        AppMethodBeat.o(198158);
      }
    };
    this.AhA = new com.tencent.mm.audio.mix.g.g()
    {
      public final void jj(int paramAnonymousInt)
      {
        AppMethodBeat.i(198159);
        if (h.this.Ahi != null) {
          h.this.Ahi.Sy(paramAnonymousInt);
        }
        AppMethodBeat.o(198159);
      }
    };
    this.AhB = new f.a()
    {
      public final void e(final com.tencent.mm.ai.b paramAnonymousb)
      {
        AppMethodBeat.i(198161);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "loadCache audio:%s", new Object[] { paramAnonymousb.dtX });
        if (paramAnonymousb != null)
        {
          com.tencent.mm.ai.b localb = h.this.LU(paramAnonymousb.dtX);
          if ((localb == null) || (TextUtils.isEmpty(localb.filePath)) || (!h.this.Ahp.hn(localb.filePath))) {
            break label130;
          }
        }
        label130:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "cached:%b", new Object[] { Boolean.valueOf(bool) });
          if ((!bool) && (h.this.mHandler != null)) {
            h.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198160);
                h.this.aHm(paramAnonymousb.dtX);
                h.this.q(paramAnonymousb);
                h.this.aHn(paramAnonymousb.dtX);
                AppMethodBeat.o(198160);
              }
            });
          }
          AppMethodBeat.o(198161);
          return;
        }
      }
    };
    this.AhC = 0;
    _release();
    this.Ahp = new c();
    this.Ahp.a(this.Ahz);
    this.Ahp.a(this.AhA);
    this.Ahu = new b();
    this.Ahu.dvT = this.AhB;
    AppMethodBeat.o(137037);
  }
  
  private void a(com.tencent.mm.ai.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137091);
    this.Ahi = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.Ahi != null) {
      this.Ahi.t(paramb.dtX, paramb.dvn, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.iJI = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.iJM;
    }
    for (paramb.iJJ = paramb.iJL; (l1 > 0L) && (l2 > l1); paramb.iJJ = paramb.iJN)
    {
      paramb.iJK = (l2 - l1);
      AppMethodBeat.o(137091);
      return;
      l1 = paramb.iJO;
    }
    paramb.iJK = 0L;
    AppMethodBeat.o(137091);
  }
  
  private void a(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137039);
    if (paramb == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137039);
      return;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.AgX.put(paramb.appId, paramb.processName);
    this.AgZ.put(paramb.dtX, paramb);
    iR(paramb.appId, paramString);
    this.Ahc.remove(paramString);
    AppMethodBeat.o(137039);
  }
  
  private void a(String paramString, k paramk)
  {
    AppMethodBeat.i(137068);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if ((localb != null) && (paramk.bec()) && (paramk.bee()))
    {
      localb.iJE = true;
      localb.dvv = paramk.etn();
    }
    for (;;)
    {
      b(paramString, paramk);
      paramString = aGZ(paramString);
      if ((paramString != null) && (paramk.bec())) {
        paramString.tN = true;
      }
      if ((!paramk.bec()) && (!paramk.bee()) && (!paramk.dFr()) && (!paramk.asa()) && (!paramk.isPaused())) {
        break;
      }
      paramk.etk();
      AppMethodBeat.o(137068);
      return;
      if ((localb != null) && (paramk.bee()))
      {
        localb.iJE = true;
        localb.dvv = paramk.etn();
      }
      else if (localb != null)
      {
        localb.iJE = true;
        localb.dvv = 0;
      }
    }
    paramk.etj();
    AppMethodBeat.o(137068);
  }
  
  private static boolean a(k paramk)
  {
    AppMethodBeat.i(137075);
    if (paramk == null)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    if ((paramk.bec()) || (paramk.isPaused()) || (paramk.dFr()) || (paramk.asa()) || (paramk.bee())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137075);
      return true;
    }
    AppMethodBeat.o(137075);
    return false;
  }
  
  private void aHe(String arg1)
  {
    AppMethodBeat.i(137064);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    aHo(???);
    cdV();
    Object localObject1 = (LinkedList)this.AgY.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137064);
      return;
    }
    for (;;)
    {
      String str;
      k localk;
      synchronized (this.ryf)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.Ahp.gD(str)) {
          this.Ahp.he(str);
        }
        localk = (k)this.AgU.remove(str);
        this.AgV.remove(str);
        if (localk == null) {
          continue;
        }
        b(str, localk);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localk.iJV) {
          d(str, localk);
        }
      }
      c(str, localk);
    }
    AppMethodBeat.o(137064);
  }
  
  private String aHf(String paramString)
  {
    AppMethodBeat.i(137067);
    Iterator localIterator = this.AgW.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.AgY.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137067);
        return str;
      }
    }
    AppMethodBeat.o(137067);
    return "";
  }
  
  private boolean aHg(String paramString)
  {
    AppMethodBeat.i(137074);
    ??? = aHb(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137074);
      return false;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (k)???);
    synchronized (this.ryf)
    {
      this.AgS.remove(paramString);
      this.AgT.remove(paramString);
      this.AgU.remove(paramString);
      this.AgV.remove(paramString);
      AppMethodBeat.o(137074);
      return true;
    }
  }
  
  private void aHh(String paramString)
  {
    AppMethodBeat.i(137078);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.AgS.size();
    int j = this.AgU.size();
    int k = esL();
    if ((i > 0) || (j > 0) || (k > 0)) {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    if (i >= 10) {
      esM();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = aHf(paramString);
      i = this.AgS.size();
      j = this.AgU.size();
      if ((i > 0) || (j > 0)) {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      if (j < 50) {
        break;
      }
      localIterator = this.AgW.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          aHi(str);
        }
      }
      if (k >= 6) {
        esM();
      } else if (i + k >= 8) {
        esM();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.AgW.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          aHi(str);
        }
      }
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.AgU.size();
    if ((i > 0) || (j > 0)) {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    if (j >= 50)
    {
      esN();
      AppMethodBeat.o(137078);
      return;
    }
    if (j + i >= 50)
    {
      esN();
      AppMethodBeat.o(137078);
      return;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137078);
  }
  
  private void aHi(String paramString)
  {
    AppMethodBeat.i(137081);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    aHe(paramString);
    AppMethodBeat.o(137081);
  }
  
  private boolean aHj(String paramString)
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
      synchronized (this.ryf)
      {
        m = this.AgS.size();
        if (m < 10)
        {
          this.Ahb.clear();
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137082);
          return false;
        }
        localObject3 = this.AgT.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.AgZ.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).dvn == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.ai.b)localObject4).dvn))
        {
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).dvn, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).dtX);
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).dvn, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.ai.b)localObject4).dvn)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.ai.b)localObject4).dvn);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).dvn)).intValue();
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).dvn, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).dvn);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).dtX)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).dtX);
      }
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).dvn, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.etE();
    Log.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      Log.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
      if (j < k) {
        break label916;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label913;
      }
      ??? = localObject3;
      i = j;
      label472:
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
        paramString = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.dvn)))
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.ai.b)this.AgZ.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new a());
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.ai.b)paramString.next()).dtX);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label833;
            }
            i += 1;
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.Ahb.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.Ahb.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137082);
          return bool1;
          label833:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.Ahb.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.Ahb.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.Ahb.clear();
        }
      }
      label913:
      break label472;
      label916:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void aHo(String paramString)
  {
    AppMethodBeat.i(198165);
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.dCU.appId)) && (!paramString.equalsIgnoreCase(this.dCU.appId)))
    {
      this.dCU.reset();
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "reset AudioContextParam, appId:%s", new Object[] { paramString });
    }
    this.dCU.appId = paramString;
    this.qUm = this.dCU.dtE;
    AppMethodBeat.o(198165);
  }
  
  private void bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(137065);
    Log.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = g.esG();
    }
    paramString = new y();
    paramString.dCW.action = 4;
    paramString.dCW.state = "error";
    paramString.dCW.errCode = com.tencent.mm.plugin.music.f.a.e.Tc(paramInt);
    paramString.dCW.errMsg = com.tencent.mm.plugin.music.f.a.e.yw(paramInt);
    paramString.dCW.dtX = str;
    paramString.dCW.appId = aHf(str);
    EventCenter.instance.asyncPublish(paramString, Looper.getMainLooper());
    AppMethodBeat.o(137065);
  }
  
  static void c(String paramString, k paramk)
  {
    AppMethodBeat.i(137070);
    if (paramk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137070);
      return;
    }
    if ((paramk.bec()) || (paramk.bee()) || (paramk.dFr()) || (paramk.asa()) || (paramk.isPaused())) {
      paramk.stopPlay();
    }
    paramk.release();
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137070);
  }
  
  static void d(String paramString, k paramk)
  {
    AppMethodBeat.i(137071);
    Log.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramk);
    AppMethodBeat.o(137071);
  }
  
  private boolean eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(137053);
    paramString = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if (paramString != null)
    {
      paramString.dvv = paramInt;
      AppMethodBeat.o(137053);
      return true;
    }
    AppMethodBeat.o(137053);
    return false;
  }
  
  private boolean esF()
  {
    AppMethodBeat.i(198164);
    if ((d.esF()) && (esR()))
    {
      AppMethodBeat.o(198164);
      return true;
    }
    AppMethodBeat.o(198164);
    return false;
  }
  
  /* Error */
  public static void esH()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 696
    //   6: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 698	com/tencent/mm/plugin/music/b/h:Ahv	Lcom/tencent/mm/plugin/music/b/h;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 696
    //   18: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/h
    //   28: dup
    //   29: invokespecial 699	com/tencent/mm/plugin/music/b/h:<init>	()V
    //   32: putstatic 698	com/tencent/mm/plugin/music/b/h:Ahv	Lcom/tencent/mm/plugin/music/b/h;
    //   35: ldc_w 696
    //   38: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static h esI()
  {
    AppMethodBeat.i(137036);
    if (Ahv == null) {
      Ahv = new h();
    }
    h localh = Ahv;
    AppMethodBeat.o(137036);
    return localh;
  }
  
  private k esJ()
  {
    AppMethodBeat.i(137066);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.ryf)
    {
      if (this.AgU.size() == 0)
      {
        localObject1 = new k();
        AppMethodBeat.o(137066);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.AgV.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (k)this.AgU.get(str);
        if (??? != null)
        {
          if ((!((k)???).iJV) && (!((k)???).isCompleted()) && (!((k)???).isStopped()))
          {
            if (((k)???).AhJ == null) {
              break label425;
            }
            if (((k)???).AhJ.getPlayerState() != 9) {
              break label420;
            }
            i = 1;
            break label398;
          }
          label170:
          if ((l1 != 0L) && (((k)???).hlh >= l1)) {
            break label383;
          }
          l1 = ((k)???).hlh;
          localObject1 = str;
          localObject5 = ???;
          break label405;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.ryf)
        {
          if (this.AgV.contains(localObject5))
          {
            this.AgU.remove(localObject5);
            this.AgV.remove(localObject5);
          }
          if (this.AgT.contains(localObject5))
          {
            this.AgT.remove(localObject5);
            this.AgS.remove(localObject5);
          }
          AppMethodBeat.o(137066);
          return localObject1;
        }
      }
    }
    Object localObject4 = new k();
    AppMethodBeat.o(137066);
    return localObject4;
    label398:
    label405:
    label420:
    label425:
    label428:
    for (;;)
    {
      label383:
      ??? = localObject4;
      localObject4 = localObject5;
      localObject5 = ???;
      for (;;)
      {
        if (i == 0) {
          break label428;
        }
        break label170;
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
  
  private int esL()
  {
    AppMethodBeat.i(137077);
    int i;
    boolean bool;
    synchronized (this.ryf)
    {
      Iterator localIterator = this.AgV.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        k localk = aHb((String)localObject3);
        if (localk == null)
        {
          Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = aGZ((String)localObject3);
          if (localObject3 == null) {
            break label136;
          }
          bool = ((com.tencent.mm.ai.d)localObject3).tN;
        }
        else
        {
          bool = localk.isPaused();
        }
      }
      else
      {
        AppMethodBeat.o(137077);
        return i;
      }
    }
    label136:
    label139:
    for (;;)
    {
      for (;;)
      {
        if (!bool) {
          break label139;
        }
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  private void esM()
  {
    AppMethodBeat.i(137079);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.ryf)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.AgV);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        k localk = (k)this.AgU.get(str);
        if ((localk != null) && (localk.isPaused())) {
          a(str, localk);
        }
      }
    }
    AppMethodBeat.o(137079);
  }
  
  private void esN()
  {
    AppMethodBeat.i(137080);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      k localk;
      synchronized (this.ryf)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.AgV);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localk = (k)this.AgU.remove(str);
        this.AgV.remove(str);
        if (localk == null) {
          continue;
        }
        if (localk.iJV)
        {
          b(str, localk);
          d(str, localk);
        }
      }
      if (!localk.isPaused())
      {
        b(str, localk);
        c(str, localk);
      }
    }
    AppMethodBeat.o(137080);
  }
  
  private void esP()
  {
    AppMethodBeat.i(137086);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.dCU.iJC), Boolean.valueOf(this.Ahj.Aiz) });
    if ((!this.dCU.iJC) && (!this.Ahj.Aiz))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      requestFocus();
      AppMethodBeat.o(137086);
      return;
    }
    if ((this.dCU.iJC) && (this.Ahj.Aiz))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bLZ();
    }
    AppMethodBeat.o(137086);
  }
  
  private void esQ()
  {
    AppMethodBeat.i(137089);
    this.Ahi = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.Ahi != null) {
      this.Ahi.etr();
    }
    AppMethodBeat.o(137089);
  }
  
  private boolean esR()
  {
    return (this.dCU.dtE) || (this.dCU.iJC);
  }
  
  private void esS()
  {
    AppMethodBeat.i(198166);
    if ((this.dCU.iJC) && (!this.Ahq))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, useSpeakerOn is false, return");
      cdV();
      AppMethodBeat.o(198166);
      return;
    }
    if (this.dCU.iJC)
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, return");
      AppMethodBeat.o(198166);
      return;
    }
    if ((this.qUm) && (this.mAudioManager.getMode() != 0))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on and reset speaker");
      cdV();
      AppMethodBeat.o(198166);
      return;
    }
    if (this.qUm)
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on, do nothing");
      AppMethodBeat.o(198166);
      return;
    }
    if (PhoneStatusWatcher.isCalling())
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when phone calling");
      AppMethodBeat.o(198166);
      return;
    }
    if ((this.mAudioManager.isBluetoothScoOn()) || (this.mAudioManager.isBluetoothA2dpOn()))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when isBluetoothScoOn:%b , isBluetoothA2dpOn:%b", new Object[] { Boolean.valueOf(this.mAudioManager.isBluetoothScoOn()), Boolean.valueOf(this.mAudioManager.isBluetoothA2dpOn()) });
      AppMethodBeat.o(198166);
      return;
    }
    if (this.mAudioManager.isWiredHeadsetOn())
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
      AppMethodBeat.o(198166);
      return;
    }
    if ((!this.Ahq) && (this.mAudioManager.getMode() == 3) && (!this.mAudioManager.isSpeakerphoneOn()))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
      AppMethodBeat.o(198166);
      return;
    }
    this.Ahq = false;
    this.mAudioManager.setSpeakerphoneOn(false);
    this.mAudioManager.setMode(3);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker off and change mode to MODE_IN_COMMUNICATION");
    AppMethodBeat.o(198166);
  }
  
  private void esT()
  {
    try
    {
      AppMethodBeat.i(198171);
      if (this.Ahk != null)
      {
        this.Ahk.end();
        this.Ahk.clearPhoneCallListener();
        this.Ahk = null;
      }
      this.Ahl = false;
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "removePhoneStatusWatcher");
      AppMethodBeat.o(198171);
      return;
    }
    finally {}
  }
  
  private void iR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137040);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137040);
      return;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.AgW.contains(paramString1)) {
      this.AgW.add(paramString1);
    }
    if (!this.AgR.contains(paramString2)) {
      this.AgR.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.AgY.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.AgY.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137040);
  }
  
  private void n(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137090);
    this.Ahi = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.Ahi != null) {
      this.Ahi.iT(paramb.dtX, paramb.dvn);
    }
    AppMethodBeat.o(137090);
  }
  
  private static void o(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137093);
    if (paramb.iJR != null) {
      try
      {
        paramb.iJR.close();
        paramb.iJR = null;
        AppMethodBeat.o(137093);
        return;
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
    AppMethodBeat.o(137093);
  }
  
  private void p(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198168);
    if (paramb == null)
    {
      AppMethodBeat.o(198168);
      return;
    }
    if (TextUtils.isEmpty(paramb.dvn))
    {
      AppMethodBeat.o(198168);
      return;
    }
    if (!paramb.dvn.startsWith("http"))
    {
      AppMethodBeat.o(198168);
      return;
    }
    if ((!TextUtils.isEmpty(paramb.filePath)) && (this.Ahp.hn(paramb.filePath))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(198168);
      return;
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.myLooper());
    }
    com.tencent.mm.plugin.music.cache.g.aHx(paramb.dvn);
    boolean bool = com.tencent.mm.plugin.music.cache.i.aHI(paramb.dvn);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "checkNeedDownloadSrc audioId:%s, cacheValid:%b, checkCount:%d", new Object[] { paramb.dtX, Boolean.valueOf(bool), Integer.valueOf(this.AhC) });
    this.AhC += 1;
    if (!bool)
    {
      this.Ahu.a(paramb);
      AppMethodBeat.o(198168);
      return;
    }
    aHm(paramb.dtX);
    q(paramb);
    aHn(paramb.dtX);
    AppMethodBeat.o(198168);
  }
  
  static boolean r(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198170);
    if ((paramb != null) && (paramb.dvn.startsWith("wxblob://")) && (paramb.iJU != null))
    {
      AppMethodBeat.o(198170);
      return true;
    }
    AppMethodBeat.o(198170);
    return false;
  }
  
  private void requestFocus()
  {
    AppMethodBeat.i(137087);
    if (this.Ahj.Aiz)
    {
      AppMethodBeat.o(137087);
      return;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.Ahj.requestFocus()) });
    AppMethodBeat.o(137087);
  }
  
  public final boolean LT(String paramString)
  {
    AppMethodBeat.i(137055);
    k localk = aHb(paramString);
    if (localk == null)
    {
      if (this.Ahp.gD(paramString))
      {
        bool = this.Ahp.gO(paramString);
        AppMethodBeat.o(137055);
        return bool;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137055);
      return false;
    }
    boolean bool = localk.bec();
    AppMethodBeat.o(137055);
    return bool;
  }
  
  public final com.tencent.mm.ai.b LU(String paramString)
  {
    AppMethodBeat.i(137060);
    if (this.AgZ.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
      AppMethodBeat.o(137060);
      return paramString;
    }
    AppMethodBeat.o(137060);
    return null;
  }
  
  public final void _release()
  {
    AppMethodBeat.i(137038);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.AgR.clear();
    String str;
    synchronized (this.ryf)
    {
      Iterator localIterator = this.AgT.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (k)this.AgS.remove(str));
      }
    }
    this.AgT.clear();
    this.AgS.clear();
    Object localObject3 = this.AgV.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (k)this.AgU.remove(str));
    }
    this.AgV.clear();
    this.AgU.clear();
    ??? = this.AgW.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.AgY.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.AgW.clear();
    this.AgX.clear();
    this.AgY.clear();
    this.AgZ.clear();
    this.Aha.clear();
    this.Ahc.clear();
    this.Ahd.clear();
    MMHandlerThread.removeRunnable(this.Ahx);
    MMHandlerThread.removeRunnable(this.Ahy);
    this.Ahe = false;
    this.Ahf = false;
    esT();
    AppMethodBeat.o(137038);
  }
  
  public final boolean a(com.tencent.mm.ai.a parama)
  {
    this.dCU = parama;
    this.qUm = parama.dtE;
    return true;
  }
  
  public final boolean aGT(String paramString)
  {
    AppMethodBeat.i(137048);
    k localk = aHb(paramString);
    if (localk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.Ahp.gD(paramString))
      {
        this.Ahp.hd(paramString);
        AppMethodBeat.o(137048);
        return true;
      }
      AppMethodBeat.o(137048);
      return false;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localk.pause();
    b(paramString, localk);
    f(paramString, localk);
    AppMethodBeat.o(137048);
    return true;
  }
  
  public final boolean aGU(String paramString)
  {
    AppMethodBeat.i(137049);
    k localk = aHb(paramString);
    if (localk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.Ahp.gD(paramString))
      {
        this.Ahp.he(paramString);
        AppMethodBeat.o(137049);
        return true;
      }
      AppMethodBeat.o(137049);
      return false;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localk.stopPlay();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if (localb != null)
    {
      localb.dvv = 0;
      localb.iJE = true;
    }
    b(paramString, localk);
    f(paramString, localk);
    AppMethodBeat.o(137049);
    return true;
  }
  
  public final boolean aGV(String paramString)
  {
    AppMethodBeat.i(137050);
    if (this.Ahp.gD(paramString)) {
      this.Ahp.he(paramString);
    }
    k localk = aHb(paramString);
    if (localk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137050);
      return false;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localk.etl();
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if (localb != null)
    {
      localb.dvv = 0;
      localb.iJE = true;
    }
    b(paramString, localk);
    f(paramString, localk);
    AppMethodBeat.o(137050);
    return true;
  }
  
  public final boolean aGW(String paramString)
  {
    AppMethodBeat.i(137051);
    label390:
    label402:
    label425:
    for (;;)
    {
      boolean bool;
      synchronized (this.Aht)
      {
        bool = this.Aht.contains(paramString);
        if (bool) {
          break label425;
        }
        ??? = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
        if ((??? != null) && (this.Ahp.ho(((com.tencent.mm.ai.b)???).filePath)))
        {
          bool = true;
          if (!bool)
          {
            if ((this.Ahp.gD(paramString)) && ((this.Ahp.isPaused(paramString)) || (this.Ahp.gO(paramString)) || (this.Ahp.hh(paramString)) || (this.Ahp.hg(paramString)) || (this.Ahp.hf(paramString)))) {
              this.Ahp.he(paramString);
            }
            this.Ahp.remove(paramString);
          }
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
          ??? = aHb(paramString);
          if (??? == null) {
            break label390;
          }
          c(paramString, (k)???);
        }
      }
      for (;;)
      {
        synchronized (this.ryf)
        {
          this.AgS.remove(paramString);
          this.AgT.remove(paramString);
          this.AgU.remove(paramString);
          this.AgV.remove(paramString);
          this.AgR.remove(paramString);
          ??? = this.AgW.iterator();
          if (((Iterator)???).hasNext())
          {
            String str = (String)((Iterator)???).next();
            LinkedList localLinkedList = (LinkedList)this.AgY.get(str);
            if ((localLinkedList == null) || (!localLinkedList.contains(paramString))) {
              continue;
            }
            localLinkedList.remove(paramString);
            if (localLinkedList.size() == 0)
            {
              this.AgY.remove(str);
              this.AgW.remove(str);
              this.AgX.remove(str);
            }
          }
          this.Aha.remove(paramString);
          if (bool) {
            break label402;
          }
          this.AgZ.remove(paramString);
          AppMethodBeat.o(137051);
          return true;
          paramString = finally;
          AppMethodBeat.o(137051);
          throw paramString;
          bool = false;
        }
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
        continue;
        if (!this.Ahs.contains(paramString)) {
          this.Ahs.add(paramString);
        }
      }
    }
  }
  
  public final boolean aGX(String paramString)
  {
    AppMethodBeat.i(137054);
    k localk = aHb(paramString);
    if (localk == null)
    {
      if (this.Ahp.gD(paramString))
      {
        bool = this.Ahp.hf(paramString);
        AppMethodBeat.o(137054);
        return bool;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137054);
      return false;
    }
    boolean bool = localk.bee();
    AppMethodBeat.o(137054);
    return bool;
  }
  
  public final boolean aGY(String paramString)
  {
    AppMethodBeat.i(137057);
    k localk = aHb(paramString);
    if (localk == null)
    {
      if (this.Ahp.gD(paramString))
      {
        bool = this.Ahp.ZI();
        AppMethodBeat.o(137057);
        return bool;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = aGZ(paramString);
      if (paramString != null)
      {
        bool = paramString.iJV;
        AppMethodBeat.o(137057);
        return bool;
      }
      AppMethodBeat.o(137057);
      return false;
    }
    boolean bool = localk.iJV;
    AppMethodBeat.o(137057);
    return bool;
  }
  
  public final com.tencent.mm.ai.d aGZ(String paramString)
  {
    AppMethodBeat.i(137058);
    Object localObject = aHb(paramString);
    if (localObject != null)
    {
      paramString = ((k)localObject).eto();
      AppMethodBeat.o(137058);
      return paramString;
    }
    if (this.Ahp.gD(paramString))
    {
      localObject = this.Ahp.hk(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137058);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.ai.d)this.Aha.get(paramString);
    AppMethodBeat.o(137058);
    return paramString;
  }
  
  public final int aHa(String paramString)
  {
    AppMethodBeat.i(137059);
    int j = esL();
    synchronized (this.ryf)
    {
      int k = this.AgR.size();
      int m = this.AgS.size();
      int n = this.AgU.size();
      paramString = (LinkedList)this.AgY.get(paramString);
      if (paramString == null)
      {
        i = 0;
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(137059);
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final k aHb(String paramString)
  {
    AppMethodBeat.i(137061);
    if (this.AgS.containsKey(paramString))
    {
      paramString = (k)this.AgS.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    if (this.AgU.containsKey(paramString))
    {
      paramString = (k)this.AgU.get(paramString);
      AppMethodBeat.o(137061);
      return paramString;
    }
    AppMethodBeat.o(137061);
    return null;
  }
  
  public final void aHc(String paramString)
  {
    AppMethodBeat.i(137062);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.Ahp.ZH();
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198140);
        h.this.cdV();
        AppMethodBeat.o(198140);
      }
    });
    bLZ();
    Object localObject3 = (LinkedList)this.AgY.get(paramString);
    long l1 = this.Ahp.ZK();
    long l2 = f.YL().YM();
    long l3 = com.tencent.mm.audio.mix.b.e.YJ().YK();
    long l4 = l2 + l3;
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.Ahi = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137062);
      return;
    }
    if ((this.AgS.isEmpty()) && (this.AgU.isEmpty()))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.Ahi != null) {
        this.Ahi.c(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137062);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.ryf)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        k localk = (k)this.AgU.get(localObject3);
        if (localk != null) {
          a((String)localObject3, localk);
        }
      }
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.AgS.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (k)this.AgS.get(???);
      if (localObject3 != null)
      {
        a((String)???, (k)localObject3);
        f((String)???, (k)localObject3);
      }
    }
    if (this.Ahi != null) {
      this.Ahi.c(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137062);
  }
  
  public final void aHd(String paramString)
  {
    AppMethodBeat.i(137063);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bLZ();
    aHo(paramString);
    cdV();
    LinkedList localLinkedList = (LinkedList)this.AgY.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137063);
      return;
    }
    String str;
    k localk;
    synchronized (this.ryf)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localk = (k)this.AgS.remove(str);
        this.AgT.remove(str);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localk);
        this.AgZ.remove(str);
        this.Aha.remove(str);
        if (this.Ahp.gD(str))
        {
          this.Ahp.he(str);
          this.Ahp.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localk = (k)this.AgU.remove(str);
      this.AgV.remove(str);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localk);
      this.AgZ.remove(str);
      this.Aha.remove(str);
      if (this.Ahp.gD(str))
      {
        this.Ahp.he(str);
        this.Ahp.remove(str);
      }
    }
    this.AgR.removeAll(localLinkedList);
    this.AgW.remove(paramString);
    this.AgX.remove(paramString);
    this.Ahp.clearCache();
    this.Ahp.ZJ();
    this.Ahn.clear();
    this.Aho.clear();
    AppMethodBeat.o(137063);
  }
  
  public final void aHk(String paramString)
  {
    AppMethodBeat.i(137084);
    if (this.AgW.size() == 0)
    {
      AppMethodBeat.o(137084);
      return;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.AgW);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.AgX.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        aHd(str1);
      }
    }
    AppMethodBeat.o(137084);
  }
  
  final boolean aHl(String paramString)
  {
    AppMethodBeat.i(137085);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.ryf)
      {
        i = this.AgS.size();
        if (i <= 5)
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137085);
          return false;
        }
        localObject3 = this.AgT.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ai.b)this.AgZ.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ai.b)localObject4).dvn == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.ai.b)localObject4).dvn))
        {
          localHashMap1.put(((com.tencent.mm.ai.b)localObject4).dvn, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ai.b)localObject4).dtX);
          localHashMap2.put(((com.tencent.mm.ai.b)localObject4).dvn, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.ai.b)localObject4).dvn)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.ai.b)localObject4).dvn);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.ai.b)localObject4).dvn)).intValue();
      localHashMap1.put(((com.tencent.mm.ai.b)localObject4).dvn, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.ai.b)localObject4).dvn);
      if (!localArrayList.contains(((com.tencent.mm.ai.b)localObject4).dtX)) {
        localArrayList.add(((com.tencent.mm.ai.b)localObject4).dtX);
      }
      localHashMap2.put(((com.tencent.mm.ai.b)localObject4).dvn, localArrayList);
    }
    paramString = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.dvn)))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        AppMethodBeat.o(137085);
        return false;
      }
    }
    paramString = "";
    Log.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      Log.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
      if (j < 2) {
        break label796;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label793;
      }
      paramString = (String)???;
      i = j;
      label539:
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
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.mm.ai.b)this.AgZ.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new a());
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.ai.b)paramString.next()).dtX);
          }
          this.Ahd.add(((LinkedList)localObject1).getLast());
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.Ahd.size()) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137085);
        return bool1;
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      label793:
      break label539;
      label796:
      j = i;
      localObject1 = paramString;
    }
  }
  
  final void aHm(String paramString)
  {
    AppMethodBeat.i(198163);
    paramString = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if ((paramString == null) || (TextUtils.isEmpty(paramString.dvn)))
    {
      AppMethodBeat.o(198163);
      return;
    }
    if ((!paramString.dvn.startsWith("http://")) && (!paramString.dvn.startsWith("https://")))
    {
      AppMethodBeat.o(198163);
      return;
    }
    if (!com.tencent.mm.plugin.music.cache.i.aHI(paramString.dvn))
    {
      AppMethodBeat.o(198163);
      return;
    }
    paramString.filePath = com.tencent.mm.plugin.music.h.b.aIe(paramString.dvn);
    if (!this.Ahn.containsKey(paramString.dvn)) {
      this.Ahn.put(paramString.dvn, paramString.filePath);
    }
    AppMethodBeat.o(198163);
  }
  
  public final void aHn(final String paramString)
  {
    AppMethodBeat.i(137092);
    if (!esF())
    {
      AppMethodBeat.o(137092);
      return;
    }
    ??? = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    if ((??? != null) && (!TextUtils.isEmpty(((com.tencent.mm.ai.b)???).filePath)) && (this.Ahp.hn(((com.tencent.mm.ai.b)???).filePath)))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache cache done!");
      AppMethodBeat.o(137092);
      return;
    }
    synchronized (this.Aht)
    {
      if (!this.Aht.contains(paramString)) {
        this.Aht.add(paramString);
      }
      if ((this.Jap == null) || (Looper.myQueue() == null))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "Looper.myQueue() is null!");
        AppMethodBeat.o(137092);
        return;
      }
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(198147);
        ??? = (com.tencent.mm.ai.b)h.this.AgZ.get(paramString);
        if (??? == null)
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null, audioId:%s", new Object[] { paramString });
          synchronized (h.this.Aht)
          {
            h.this.Aht.remove(paramString);
            h.a(h.this, paramString);
            AppMethodBeat.o(198147);
            return false;
          }
        }
        long l1;
        long l2;
        c localc;
        int i;
        if ((!TextUtils.isEmpty(((com.tencent.mm.ai.b)???).filePath)) && (!h.this.Ahp.hn(((com.tencent.mm.ai.b)???).filePath)))
        {
          l1 = com.tencent.mm.audio.mix.i.a.hv(((com.tencent.mm.ai.b)???).filePath);
          if (h.r((com.tencent.mm.ai.b)???)) {
            l1 = ((com.tencent.mm.ai.b)???).iJU.limit();
          }
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d, preloadMixCacheCount:%d", new Object[] { ((com.tencent.mm.ai.b)???).filePath, Long.valueOf(l1), Long.valueOf(h.this.Ahr) });
          l2 = f.YL().YM();
          localc = h.this.Ahp;
          long l3 = f.YL().YM();
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
          if (l3 >= 50000000L) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i != 0) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
          }
          int j = 0;
          if (h.this.Aho.containsKey(((com.tencent.mm.ai.b)???).filePath)) {
            j = ((Integer)h.this.Aho.get(((com.tencent.mm.ai.b)???).filePath)).intValue();
          }
          if (i != 0)
          {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
            if (h.this.Ahi != null) {
              h.this.Ahi.SA(713);
            }
            h.this.Ahp.hl("");
            i = 0;
          }
          synchronized (h.this.Aht)
          {
            for (;;)
            {
              h.this.Aht.remove(paramString);
              if (i == 0) {
                h.a(h.this, paramString);
              }
              AppMethodBeat.o(198147);
              return false;
              i = 0;
              break;
              if (l2 + l1 > 50000000L)
              {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
                if (h.this.Ahi != null) {
                  h.this.Ahi.SA(714);
                }
                h.this.Ahp.hl("");
                i = 0;
              }
              else if (j >= 30)
              {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
                i = 0;
              }
              else if ((!com.tencent.mm.audio.mix.i.a.hu(((com.tencent.mm.ai.b)???).filePath)) && (!h.r((com.tencent.mm.ai.b)???)))
              {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
                i = 0;
              }
              else if ((h.r((com.tencent.mm.ai.b)???)) && (com.tencent.mm.audio.mix.i.a.bu(((com.tencent.mm.ai.b)???).iJU.limit())))
              {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load pByteBuff large file");
                i = 0;
              }
              else if (!h.this.Ahp.ho(((com.tencent.mm.ai.b)???).filePath))
              {
                ((com.tencent.mm.ai.b)???).iJT = true;
                ((com.tencent.mm.ai.b)???).fileSize = l1;
                h.this.Ahp.f((com.tencent.mm.ai.b)???);
                ??? = h.this;
                ((h)???).Ahr += 1L;
                i = 1;
              }
              else
              {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
                i = 0;
                continue;
                if (TextUtils.isEmpty(((com.tencent.mm.ai.b)???).filePath)) {
                  break label769;
                }
                ((com.tencent.mm.ai.b)???).iJT = false;
                if (!h.this.Ahp.gD(paramString)) {
                  h.this.Ahp.g((com.tencent.mm.ai.b)???);
                }
                if (h.r((com.tencent.mm.ai.b)???))
                {
                  ((com.tencent.mm.ai.b)???).fileSize = ((com.tencent.mm.ai.b)???).iJU.limit();
                  i = 0;
                }
                else
                {
                  ((com.tencent.mm.ai.b)???).fileSize = com.tencent.mm.audio.mix.i.a.hv(((com.tencent.mm.ai.b)???).filePath);
                  i = 0;
                }
              }
            }
            label769:
            ((com.tencent.mm.ai.b)???).iJT = false;
            i = 0;
          }
        }
      }
    });
    AppMethodBeat.o(137092);
  }
  
  final void b(String paramString, k paramk)
  {
    AppMethodBeat.i(137069);
    this.Aha.put(paramString, paramk.eto());
    AppMethodBeat.o(137069);
  }
  
  public final boolean b(String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137047);
    com.tencent.mm.ai.b localb2 = (com.tencent.mm.ai.b)this.AgZ.get(paramString);
    com.tencent.mm.ai.b localb1;
    boolean bool1;
    if (((!this.AgR.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      n(localb1);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      paramb = aHf(paramString);
      int i = aHa(paramb);
      if (i >= 10)
      {
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!aHj(paramString)) {
          break label388;
        }
        esO();
      }
      esP();
      this.AgZ.put(paramString, localb1);
      aHo(paramb);
      esS();
      paramb = aHb(paramString);
      if (!esF()) {
        break label472;
      }
      boolean bool2 = a(paramb);
      if ((!this.Ahp.gD(paramString)) || (!this.Ahp.hm(paramString))) {
        break label408;
      }
      bool1 = true;
      label215:
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.dtX });
      if ((!bool2) || (!bool1)) {
        break label481;
      }
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      aHg(localb1.dtX);
      o(localb1);
      if (!this.Ahp.gO(localb1.dtX)) {
        break label414;
      }
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (!this.AgR.contains(paramString))
      {
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        bL(601, paramString);
        AppMethodBeat.o(137047);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      bL(602, paramString);
      AppMethodBeat.o(137047);
      return false;
      label388:
      esQ();
      bL(600, paramString);
      AppMethodBeat.o(137047);
      return false;
      label408:
      bool1 = false;
      break label215;
      label414:
      if (this.Ahp.hg(localb1.dtX))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.iJE = true;
        paramb.g(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.Ahp.hb(paramString);
      }
    }
    label472:
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label481:
    if (paramb == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      aHh(paramString);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = esJ();
      paramb.a(this.Ahw);
      paramb.aHp(paramString);
      e(paramString, paramb);
      localb1.iJE = true;
      localb1.dvv = 0;
      localb1.iJF = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.s(localb1);
      AppMethodBeat.o(137047);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.bee()) && (!paramb.bec()))
    {
      a(localb1, false, true);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137047);
      return true;
      if (paramb.asa())
      {
        a(localb1, false, true);
        localb1.iJE = true;
        localb1.iJF = System.currentTimeMillis();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.dvv = 0;
        paramb.g(localb1);
      }
      else if (paramb.dFr())
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.iJE = true;
        localb1.iJF = System.currentTimeMillis();
        paramb.g(localb1);
      }
      else if (paramb.iJV)
      {
        a(localb1, false, true);
        localb1.iJE = true;
        localb1.iJF = System.currentTimeMillis();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
        paramb.s(localb1);
      }
      else
      {
        if (paramb.bee()) {
          break;
        }
        a(localb1, false, true);
        localb1.iJE = true;
        localb1.iJF = System.currentTimeMillis();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.s(localb1);
        localb1.dvv = 0;
      }
    }
    Log.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137047);
    return false;
  }
  
  final void bLZ()
  {
    AppMethodBeat.i(137088);
    if (this.Ahj.Aiz) {
      this.Ahj.bLZ();
    }
    AppMethodBeat.o(137088);
  }
  
  public final void cdV()
  {
    AppMethodBeat.i(198167);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "resetSpeaker");
    if ((!this.Ahq) && (this.mAudioManager.getMode() == 3))
    {
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on and reset mode to MODE_NORMAL");
      this.mAudioManager.setSpeakerphoneOn(true);
      this.mAudioManager.setMode(0);
    }
    for (;;)
    {
      this.Ahq = true;
      AppMethodBeat.o(198167);
      return;
      if (!this.Ahq)
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on");
        this.mAudioManager.setSpeakerphoneOn(true);
      }
    }
  }
  
  final void e(String paramString, k paramk)
  {
    AppMethodBeat.i(137072);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.ryf)
    {
      if (this.AgV.contains(paramString))
      {
        this.AgU.remove(paramString);
        this.AgV.remove(paramString);
      }
      if (!this.AgT.contains(paramString))
      {
        this.AgT.add(paramString);
        this.AgS.put(paramString, paramk);
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  public final boolean eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(137052);
    k localk = aHb(paramString);
    if (localk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.Ahp.gD(paramString)) {
        this.Ahp.A(paramString, paramInt);
      }
      bool = eR(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if (paramInt < 0)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localk.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    if (localk.getDuration() <= 0)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localk.getDuration()) });
      localk.etd();
      bool = eR(paramString, paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    if ((paramInt > 0) && (paramInt > localk.getDuration()))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localk.getDuration()) });
      AppMethodBeat.o(137052);
      return false;
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((localk.bec()) || (localk.bee()) || (localk.isPaused()))
    {
      bool = localk.tG(paramInt);
      AppMethodBeat.o(137052);
      return bool;
    }
    localk.etd();
    boolean bool = eR(paramString, paramInt);
    AppMethodBeat.o(137052);
    return bool;
  }
  
  public final void esK()
  {
    AppMethodBeat.i(137076);
    long l = System.currentTimeMillis();
    if ((this.Ahe) && (l - this.Ahg < 10000L))
    {
      AppMethodBeat.o(137076);
      return;
    }
    this.Ahg = l;
    synchronized (this.ryf)
    {
      this.Ahe = true;
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      MMHandlerThread.removeRunnable(this.Ahy);
      MMHandlerThread.postToMainThreadDelayed(this.Ahy, 1800000L);
      AppMethodBeat.o(137076);
      return;
    }
  }
  
  final void esO()
  {
    AppMethodBeat.i(137083);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.Ahb.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      aGU(str);
      esQ();
    }
    localIterator = this.Ahd.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      aGU(str);
      esQ();
    }
    this.Ahb.clear();
    this.Ahd.clear();
    AppMethodBeat.o(137083);
  }
  
  final void f(String paramString, k paramk)
  {
    AppMethodBeat.i(137073);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.ryf)
    {
      if (this.AgT.contains(paramString))
      {
        this.AgS.remove(paramString);
        this.AgT.remove(paramString);
      }
      if (!this.AgV.contains(paramString))
      {
        this.AgV.add(paramString);
        this.AgU.put(paramString, paramk);
      }
      AppMethodBeat.o(137073);
      return;
    }
  }
  
  public final int getStreamType()
  {
    if ((this.qUm) || (this.dCU.iJC)) {}
    while (this.Ahq) {
      return 3;
    }
    return 0;
  }
  
  public final boolean hi(String paramString)
  {
    AppMethodBeat.i(137056);
    k localk = aHb(paramString);
    if (localk == null)
    {
      if (this.Ahp.gD(paramString))
      {
        bool = this.Ahp.hi(paramString);
        AppMethodBeat.o(137056);
        return bool;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      AppMethodBeat.o(137056);
      return true;
    }
    boolean bool = localk.isStopped();
    AppMethodBeat.o(137056);
    return bool;
  }
  
  public final String iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137041);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.AgY.get(paramString1);
    Object localObject = this.ryf;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.AgT.contains(paramString2)) {
            break label246;
          }
          if (this.AgV.contains(paramString2))
          {
            break label246;
            j = aHa(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label135;
            }
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            bL(604, paramString2);
            AppMethodBeat.o(137041);
            return null;
          }
        }
        i = 0;
        continue;
        if (j < 10) {
          break label177;
        }
      }
      finally
      {
        AppMethodBeat.o(137041);
      }
      label135:
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      iR(paramString1, paramString2);
      AppMethodBeat.o(137041);
      return null;
      label177:
      if (i != 0)
      {
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        bL(603, paramString2);
        AppMethodBeat.o(137041);
        return null;
      }
      iR(paramString1, paramString2);
      aHh(paramString2);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137041);
      return paramString2;
      label246:
      int i = 1;
    }
  }
  
  public final boolean l(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137042);
    if (paramb == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137042);
      return false;
    }
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.AgZ.get(paramb.dtX);
    if (localb != null)
    {
      localb.k(paramb);
      k localk = aHb(paramb.dtX);
      if (localk == null) {
        break label133;
      }
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localk.g(localb);
      label78:
      if (esF())
      {
        if (!this.Ahp.gD(paramb.dtX)) {
          break label145;
        }
        this.Ahp.h(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137042);
      return true;
      this.AgZ.put(paramb.dtX, paramb);
      localb = paramb;
      break;
      label133:
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label78;
      label145:
      this.Ahp.g(paramb);
    }
  }
  
  public final boolean m(com.tencent.mm.ai.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(137043);
    if (paramb == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      bL(605, "");
      AppMethodBeat.o(137043);
      return false;
    }
    if (TextUtils.isEmpty(paramb.dtX))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      bL(604, paramb.dtX);
      AppMethodBeat.o(137043);
      return false;
    }
    if (!this.AgR.contains(paramb.dtX))
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      bL(601, paramb.dtX);
      AppMethodBeat.o(137043);
      return false;
    }
    if (paramb.iJE) {
      n(paramb);
    }
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject1;
    boolean bool2;
    boolean bool1;
    if (!this.Ahl)
    {
      if (android.support.v4.content.b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher() not have read_phone_state perm");
      }
    }
    else
    {
      ??? = aHf(paramb.dtX);
      localObject1 = LU(paramb.dtX);
      int j = aHa((String)???);
      if (j >= 10)
      {
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(j) });
        this.AgZ.put(paramb.dtX, paramb);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.iJE) });
        p(paramb);
        if ((!paramb.iJE) || (!aHj(paramb.dtX))) {
          break label721;
        }
        esO();
      }
      aHh(paramb.dtX);
      esP();
      aHo((String)???);
      esS();
      this.AgX.put(???, paramb.processName);
      this.AgZ.put(paramb.dtX, paramb);
      q(paramb);
      ??? = aHb(paramb.dtX);
      bool2 = esF();
      if (!bool2) {
        break label1134;
      }
      boolean bool3 = a((k)???);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.Ahp.hn(paramb.filePath))) && ((localObject1 == null) || (!paramb.j((com.tencent.mm.ai.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.ai.b)localObject1).filePath)) || (!this.Ahp.hn(((com.tencent.mm.ai.b)localObject1).filePath)))) {
        break label794;
      }
      bool1 = true;
      label433:
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.dtX });
      if ((!bool3) || (!bool1)) {
        break label1143;
      }
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
      aHg(paramb.dtX);
      o(paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (localObject1 != null) && (((com.tencent.mm.ai.b)localObject1).j(paramb))) {
        paramb.filePath = ((com.tencent.mm.ai.b)localObject1).filePath;
      }
      if (!paramb.iJE) {
        break label981;
      }
      if ((localObject1 == null) || (((com.tencent.mm.ai.b)localObject1).j(paramb))) {
        break label800;
      }
      a(paramb, true, false);
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
      if ((this.Ahp.gO(paramb.dtX)) || (this.Ahp.hf(paramb.dtX)) || (this.Ahp.hg(paramb.dtX)) || (this.Ahp.hh(paramb.dtX)) || (this.Ahp.isPaused(paramb.dtX))) {
        this.Ahp.he(paramb.dtX);
      }
      this.Ahp.f(paramb);
    }
    for (;;)
    {
      AppMethodBeat.o(137043);
      return true;
      this.Ahk = new PhoneStatusWatcher();
      this.Ahk.begin(MMApplicationContext.getContext());
      this.Ahk.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener()
      {
        public final void onPhoneCall(int paramAnonymousInt)
        {
          AppMethodBeat.i(198162);
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "onPhoneCall state:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          synchronized (h.this.Ahm)
          {
            Iterator localIterator = h.this.Ahm.iterator();
            if (localIterator.hasNext()) {
              ((j)localIterator.next()).onPhoneCall(paramAnonymousInt);
            }
          }
          AppMethodBeat.o(198162);
        }
      });
      this.Ahl = true;
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher");
      break;
      label721:
      if (paramb.iJE)
      {
        bL(600, paramb.dtX);
        esQ();
        AppMethodBeat.o(137043);
        return false;
      }
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = aHb(paramb.dtX);
      if (localObject1 != null)
      {
        ((k)localObject1).g(paramb);
        ((k)localObject1).esY();
      }
      AppMethodBeat.o(137043);
      return true;
      label794:
      bool1 = false;
      break label433;
      label800:
      if (this.Ahp.gO(paramb.dtX))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
      }
      else if ((this.Ahp.hf(paramb.dtX)) && (this.Ahp.isPaused(paramb.dtX)))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb, true, false);
        this.Ahp.hc(paramb.dtX);
      }
      else if (this.Ahp.hh(paramb.dtX))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb, true, false);
        this.Ahp.hc(paramb.dtX);
      }
      else if (this.Ahp.hg(paramb.dtX))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
      }
      else
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
        a(paramb, true, false);
        this.Ahp.f(paramb);
      }
    }
    label981:
    if (this.Ahp.gD(paramb.dtX)) {
      this.Ahp.h(paramb);
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((com.tencent.mm.ai.b)localObject1).j(paramb)))
      {
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.Ahp.gO(paramb.dtX)) || (this.Ahp.hf(paramb.dtX)) || (this.Ahp.hg(paramb.dtX)) || (this.Ahp.hh(paramb.dtX)) || (this.Ahp.isPaused(paramb.dtX))) {
          this.Ahp.he(paramb.dtX);
        }
      }
      this.Ahp.q(7, paramb.dtX);
      break;
      this.Ahp.g(paramb);
    }
    label1134:
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    label1143:
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    k localk = aHb(paramb.dtX);
    if (localk == null)
    {
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb.dtX });
      localObject1 = esJ();
      ((k)localObject1).a(this.Ahw);
      ((k)localObject1).aHp(paramb.dtX);
      ((k)localObject1).g(paramb);
      if (paramb.iJE)
      {
        a(paramb, true, true);
        e(paramb.dtX, (k)localObject1);
        paramb.iJF = System.currentTimeMillis();
        ((k)localObject1).s(paramb);
        if (bool2)
        {
          this.Jap = Looper.myLooper();
          if (!this.Ahp.gD(paramb.dtX)) {
            break label1790;
          }
          this.Ahp.h(paramb);
        }
      }
    }
    for (;;)
    {
      if ((r(paramb)) || (!TextUtils.isEmpty(paramb.filePath))) {
        aHn(paramb.dtX);
      }
      p(paramb);
      AppMethodBeat.o(137043);
      return true;
      f(paramb.dtX, (k)localObject1);
      ((k)localObject1).esY();
      Log.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      break;
      Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb.dtX });
      if (paramb.iJE)
      {
        e(paramb.dtX, localk);
        paramb.iJF = System.currentTimeMillis();
        localk.g(paramb);
        if ((localObject1 != null) && (!((com.tencent.mm.ai.b)localObject1).j(paramb)))
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
          if ((localk.bec()) || (localk.bee()) || (localk.dFr()) || (localk.asa()) || (localk.isPaused())) {
            localk.stopPlay();
          }
          a(paramb, true, true);
          localk.s(paramb);
          break;
        }
        if (localk.bec())
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
          break;
        }
        if ((localk.bee()) && (localk.isPaused()))
        {
          a(paramb, true, true);
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
          localk.resume();
          break;
        }
        if (localk.asa())
        {
          a(paramb, true, true);
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
          localk.resume();
          break;
        }
        if (localk.dFr())
        {
          Log.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
          break;
        }
        a(paramb, true, true);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
        localk.s(paramb);
        break;
      }
      for (;;)
      {
        synchronized (this.ryf)
        {
          if (this.AgT.contains(paramb.dtX)) {
            i = 1;
          }
          if (i == 0)
          {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
            f(paramb.dtX, localk);
            localk.g(paramb);
            if ((localObject1 != null) && (!((com.tencent.mm.ai.b)localObject1).j(paramb)))
            {
              Log.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
              if ((localk.bec()) || (localk.bee()) || (localk.dFr()) || (localk.asa()) || (localk.isPaused())) {
                localk.stopPlay();
              }
            }
            localk.esY();
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
          }
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      }
      label1790:
      this.Ahp.g(paramb);
    }
  }
  
  final void q(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198169);
    if ((TextUtils.isEmpty(paramb.filePath)) && (this.Ahn.containsKey(paramb.dvn))) {
      paramb.filePath = ((String)this.Ahn.get(paramb.dvn));
    }
    AppMethodBeat.o(198169);
  }
  
  public final class a
    implements Comparator<com.tencent.mm.ai.b>
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h
 * JD-Core Version:    0.7.0.1
 */