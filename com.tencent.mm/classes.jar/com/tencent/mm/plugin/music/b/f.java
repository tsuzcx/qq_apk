package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static f oXa;
  com.tencent.mm.ag.a cmW;
  Object lDc;
  private LinkedList<String> oWE;
  HashMap<String, h> oWF;
  LinkedList<String> oWG;
  HashMap<String, h> oWH;
  LinkedList<String> oWI;
  LinkedList<String> oWJ;
  private HashMap<String, String> oWK;
  HashMap<String, LinkedList<String>> oWL;
  HashMap<String, com.tencent.mm.ag.b> oWM;
  private HashMap<String, com.tencent.mm.ag.d> oWN;
  private LinkedList<String> oWO;
  HashMap<String, Integer> oWP;
  private LinkedList<String> oWQ;
  boolean oWR;
  private boolean oWS;
  long oWT;
  private long oWU;
  com.tencent.mm.plugin.music.b.a.d oWV;
  private com.tencent.mm.plugin.music.b.b.a oWW;
  private HashMap<String, String> oWX;
  HashMap<String, Integer> oWY;
  com.tencent.mm.audio.mix.f.c oWZ;
  private c oXb;
  private Runnable oXc;
  Runnable oXd;
  private com.tencent.mm.audio.mix.f.b oXe;
  private com.tencent.mm.audio.mix.f.g oXf;
  
  private f()
  {
    AppMethodBeat.i(137287);
    this.oWE = new LinkedList();
    this.oWF = new HashMap();
    this.oWG = new LinkedList();
    this.oWH = new HashMap();
    this.oWI = new LinkedList();
    this.oWJ = new LinkedList();
    this.oWK = new HashMap();
    this.oWL = new HashMap();
    this.oWM = new HashMap();
    this.oWN = new HashMap();
    this.oWO = new LinkedList();
    this.oWP = new HashMap();
    this.oWQ = new LinkedList();
    this.lDc = new Object();
    this.oWR = false;
    this.oWS = false;
    this.oWT = 0L;
    this.oWU = 0L;
    this.cmW = new com.tencent.mm.ag.a();
    this.oWW = new com.tencent.mm.plugin.music.b.b.a();
    this.oWX = new HashMap();
    this.oWY = new HashMap();
    this.oXb = new f.1(this);
    this.oXc = new f.2(this);
    this.oXd = new f.3(this);
    this.oXe = new f.5(this);
    this.oXf = new f.6(this);
    bUa();
    this.oWZ = new com.tencent.mm.audio.mix.f.c();
    this.oWZ.a(this.oXe);
    this.oWZ.a(this.oXf);
    AppMethodBeat.o(137287);
  }
  
  private void UR(String arg1)
  {
    AppMethodBeat.i(137314);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.oWL.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137314);
      return;
    }
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.lDc)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        if (this.oWZ.en(str)) {
          this.oWZ.er(str);
        }
        localh = (h)this.oWH.remove(str);
        this.oWI.remove(str);
        if (localh == null) {
          continue;
        }
        b(str, localh);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localh.frl) {
          d(str, localh);
        }
      }
      c(str, localh);
    }
    AppMethodBeat.o(137314);
  }
  
  private String US(String paramString)
  {
    AppMethodBeat.i(137317);
    Iterator localIterator = this.oWJ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.oWL.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
      {
        AppMethodBeat.o(137317);
        return str;
      }
    }
    AppMethodBeat.o(137317);
    return "";
  }
  
  private boolean UT(String paramString)
  {
    AppMethodBeat.i(137324);
    ??? = UO(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(137324);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.lDc)
    {
      this.oWF.remove(paramString);
      this.oWG.remove(paramString);
      this.oWH.remove(paramString);
      this.oWI.remove(paramString);
      AppMethodBeat.o(137324);
      return true;
    }
  }
  
  private void UU(String paramString)
  {
    AppMethodBeat.i(137328);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.oWF.size();
    int j = this.oWH.size();
    int k = bUd();
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      bUe();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = US(paramString);
      i = this.oWF.size();
      j = this.oWH.size();
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.oWJ.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          UV(str);
        }
      }
      if (k >= 6) {
        bUe();
      } else if (i + k >= 8) {
        bUe();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.oWJ.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          UV(str);
        }
      }
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.oWH.size();
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      bUf();
      AppMethodBeat.o(137328);
      return;
    }
    if (j + i >= 50)
    {
      bUf();
      AppMethodBeat.o(137328);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
    AppMethodBeat.o(137328);
  }
  
  private void UV(String paramString)
  {
    AppMethodBeat.i(137331);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    UR(paramString);
    AppMethodBeat.o(137331);
  }
  
  private boolean UW(String paramString)
  {
    AppMethodBeat.i(137332);
    boolean bool1 = false;
    Object localObject2 = new ArrayList();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    int m;
    Object localObject3;
    for (;;)
    {
      synchronized (this.lDc)
      {
        m = this.oWF.size();
        if (m < 10)
        {
          this.oWO.clear();
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          AppMethodBeat.o(137332);
          return false;
        }
        localObject3 = this.oWG.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ag.b)this.oWM.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ag.b)localObject4).cfG == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.ag.b)localObject4).cfG))
        {
          localHashMap2.put(((com.tencent.mm.ag.b)localObject4).cfG, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ag.b)localObject4).ceu);
          localHashMap1.put(((com.tencent.mm.ag.b)localObject4).cfG, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.ag.b)localObject4).cfG)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.ag.b)localObject4).cfG);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.ag.b)localObject4).cfG)).intValue();
      localHashMap2.put(((com.tencent.mm.ag.b)localObject4).cfG, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.ag.b)localObject4).cfG);
      if (!localArrayList.contains(((com.tencent.mm.ag.b)localObject4).ceu)) {
        localArrayList.add(((com.tencent.mm.ag.b)localObject4).ceu);
      }
      localHashMap1.put(((com.tencent.mm.ag.b)localObject4).cfG, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.bVc();
    ab.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      ab.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
      if (j < k) {
        break label907;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label904;
      }
      ??? = localObject3;
      i = j;
      label468:
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
        paramString = (com.tencent.mm.ag.b)this.oWM.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.cfG)))
        {
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.ag.b)this.oWM.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new f.a(this));
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.ag.b)paramString.next()).ceu);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label825;
            }
            i += 1;
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.oWO.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.oWO.size()) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(137332);
          return bool1;
          label825:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.oWO.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.oWO.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.oWO.clear();
        }
      }
      label904:
      break label468;
      label907:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void a(com.tencent.mm.ag.b paramb1, com.tencent.mm.ag.b paramb2)
  {
    AppMethodBeat.i(137295);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
    UT(paramb1.ceu);
    k(paramb1);
    if ((TextUtils.isEmpty(paramb1.filePath)) && (paramb2 != null) && (paramb2.e(paramb1))) {
      paramb1.filePath = paramb2.filePath;
    }
    if (paramb1.fqX)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        a(paramb1, true, false);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
        if ((this.oWZ.eb(paramb1.ceu)) || (this.oWZ.es(paramb1.ceu)) || (this.oWZ.et(paramb1.ceu)) || (this.oWZ.eu(paramb1.ceu)) || (this.oWZ.isPaused(paramb1.ceu))) {
          this.oWZ.er(paramb1.ceu);
        }
        this.oWZ.a(paramb1);
        AppMethodBeat.o(137295);
        return;
      }
      if (this.oWZ.eb(paramb1.ceu))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
        AppMethodBeat.o(137295);
        return;
      }
      if ((this.oWZ.es(paramb1.ceu)) && (this.oWZ.isPaused(paramb1.ceu)))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
        a(paramb1, true, false);
        this.oWZ.ep(paramb1.ceu);
        AppMethodBeat.o(137295);
        return;
      }
      if (this.oWZ.eu(paramb1.ceu))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
        a(paramb1, true, false);
        this.oWZ.ep(paramb1.ceu);
        AppMethodBeat.o(137295);
        return;
      }
      if (this.oWZ.et(paramb1.ceu))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
        AppMethodBeat.o(137295);
        return;
      }
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
      a(paramb1, true, false);
      this.oWZ.a(paramb1);
      AppMethodBeat.o(137295);
      return;
    }
    if (this.oWZ.en(paramb1.ceu)) {
      this.oWZ.c(paramb1);
    }
    for (;;)
    {
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
        if ((this.oWZ.eb(paramb1.ceu)) || (this.oWZ.es(paramb1.ceu)) || (this.oWZ.et(paramb1.ceu)) || (this.oWZ.eu(paramb1.ceu)) || (this.oWZ.isPaused(paramb1.ceu))) {
          this.oWZ.er(paramb1.ceu);
        }
      }
      this.oWZ.m(7, paramb1.ceu);
      AppMethodBeat.o(137295);
      return;
      this.oWZ.b(paramb1);
    }
  }
  
  private void a(com.tencent.mm.ag.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137341);
    this.oWV = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.oWV != null) {
      this.oWV.r(paramb.ceu, paramb.cfG, paramBoolean2);
    }
    long l2 = System.currentTimeMillis();
    paramb.frb = l2;
    long l1;
    if (paramBoolean1) {
      l1 = paramb.frf;
    }
    for (paramb.frc = paramb.fre; (l1 > 0L) && (l2 > l1); paramb.frc = paramb.frg)
    {
      paramb.frd = (l2 - l1);
      AppMethodBeat.o(137341);
      return;
      l1 = paramb.frh;
    }
    paramb.frd = 0L;
    AppMethodBeat.o(137341);
  }
  
  private void a(String paramString, com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137289);
    if (paramb == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137289);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
    this.oWK.put(paramb.appId, paramb.processName);
    this.oWM.put(paramb.ceu, paramb);
    fs(paramb.appId, paramString);
    this.oWP.remove(paramString);
    AppMethodBeat.o(137289);
  }
  
  private void a(String paramString, h paramh)
  {
    AppMethodBeat.i(137318);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    if ((localb != null) && (paramh.aiw()) && (paramh.aiy()))
    {
      localb.fqX = true;
      localb.startTime = paramh.bUH();
    }
    for (;;)
    {
      b(paramString, paramh);
      paramString = UM(paramString);
      if ((paramString != null) && (paramh.aiw())) {
        paramString.kH = true;
      }
      if ((!paramh.aiw()) && (!paramh.aiy()) && (!paramh.bUB()) && (!paramh.bUC()) && (!paramh.isPaused())) {
        break;
      }
      paramh.bUE();
      AppMethodBeat.o(137318);
      return;
      if ((localb != null) && (paramh.aiy()))
      {
        localb.fqX = true;
        localb.startTime = paramh.bUH();
      }
      else if (localb != null)
      {
        localb.fqX = true;
        localb.startTime = 0;
      }
    }
    paramh.bUD();
    AppMethodBeat.o(137318);
  }
  
  private static boolean a(h paramh)
  {
    AppMethodBeat.i(137325);
    if (paramh == null)
    {
      AppMethodBeat.o(137325);
      return true;
    }
    if ((paramh.aiw()) || (paramh.isPaused()) || (paramh.bUB()) || (paramh.bUC()) || (paramh.aiy())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(137325);
      return true;
    }
    AppMethodBeat.o(137325);
    return false;
  }
  
  private void aS(int paramInt, String paramString)
  {
    AppMethodBeat.i(137315);
    ab.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = e.bTX();
    }
    paramString = new t();
    paramString.cmZ.action = 4;
    paramString.cmZ.state = "error";
    paramString.cmZ.errCode = com.tencent.mm.plugin.music.f.a.e.Aw(paramInt);
    paramString.cmZ.errMsg = com.tencent.mm.plugin.music.f.a.e.oP(paramInt);
    paramString.cmZ.ceu = str;
    paramString.cmZ.appId = US(str);
    com.tencent.mm.sdk.b.a.ymk.a(paramString, Looper.getMainLooper());
    AppMethodBeat.o(137315);
  }
  
  private void b(com.tencent.mm.ag.b paramb1, com.tencent.mm.ag.b paramb2)
  {
    int i = 1;
    AppMethodBeat.i(137296);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
    h localh = UO(paramb1.ceu);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb1.ceu });
      paramb2 = bUb();
      paramb2.a(this.oXb);
      paramb2.Va(paramb1.ceu);
      paramb2.b(paramb1);
      if (paramb1.fqX)
      {
        a(paramb1, true, true);
        e(paramb1.ceu, paramb2);
        paramb1.fqZ = System.currentTimeMillis();
        paramb2.l(paramb1);
        AppMethodBeat.o(137296);
        return;
      }
      f(paramb1.ceu, paramb2);
      paramb2.bUq();
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      AppMethodBeat.o(137296);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb1.ceu });
    if (paramb1.fqX)
    {
      e(paramb1.ceu, localh);
      paramb1.fqZ = System.currentTimeMillis();
      localh.b(paramb1);
      if ((paramb2 != null) && (!paramb2.e(paramb1)))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localh.aiw()) || (localh.aiy()) || (localh.bUB()) || (localh.bUC()) || (localh.isPaused())) {
          localh.stopPlay();
        }
        a(paramb1, true, true);
        localh.l(paramb1);
        AppMethodBeat.o(137296);
        return;
      }
      if (localh.aiw())
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
        AppMethodBeat.o(137296);
        return;
      }
      if ((localh.aiy()) && (localh.isPaused()))
      {
        a(paramb1, true, true);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localh.resume();
        AppMethodBeat.o(137296);
        return;
      }
      if (localh.bUC())
      {
        a(paramb1, true, true);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localh.resume();
        AppMethodBeat.o(137296);
        return;
      }
      if (localh.bUB())
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
        AppMethodBeat.o(137296);
        return;
      }
      a(paramb1, true, true);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
      localh.l(paramb1);
      AppMethodBeat.o(137296);
      return;
    }
    for (;;)
    {
      synchronized (this.lDc)
      {
        if (!this.oWG.contains(paramb1.ceu)) {
          break label594;
        }
        if (i == 0)
        {
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb1.ceu, localh);
          localh.b(paramb1);
          if ((paramb2 != null) && (!paramb2.e(paramb1)))
          {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localh.aiw()) || (localh.aiy()) || (localh.bUB()) || (localh.bUC()) || (localh.isPaused())) {
              localh.stopPlay();
            }
          }
          localh.bUq();
          ab.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
          AppMethodBeat.o(137296);
          return;
        }
      }
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
      continue;
      label594:
      i = 0;
    }
  }
  
  /* Error */
  public static void bTY()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 729
    //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 731	com/tencent/mm/plugin/music/b/f:oXa	Lcom/tencent/mm/plugin/music/b/f;
    //   12: ifnull +13 -> 25
    //   15: ldc_w 729
    //   18: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 2	com/tencent/mm/plugin/music/b/f
    //   28: dup
    //   29: invokespecial 732	com/tencent/mm/plugin/music/b/f:<init>	()V
    //   32: putstatic 731	com/tencent/mm/plugin/music/b/f:oXa	Lcom/tencent/mm/plugin/music/b/f;
    //   35: ldc_w 729
    //   38: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static f bTZ()
  {
    AppMethodBeat.i(137286);
    if (oXa == null) {
      oXa = new f();
    }
    f localf = oXa;
    AppMethodBeat.o(137286);
    return localf;
  }
  
  private h bUb()
  {
    AppMethodBeat.i(137316);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject5;
    int i;
    synchronized (this.lDc)
    {
      if (this.oWH.size() == 0)
      {
        localObject1 = new h();
        AppMethodBeat.o(137316);
        return localObject1;
      }
      Object localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.oWI.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (h)this.oWH.get(str);
        if (??? != null)
        {
          if ((!((h)???).frl) && (!((h)???).isCompleted()) && (!((h)???).isStopped()))
          {
            if (((h)???).oXm == null) {
              break label421;
            }
            if (((h)???).oXm.getPlayerState() != 9) {
              break label416;
            }
            i = 1;
            break label394;
          }
          label168:
          if ((l1 != 0L) && (((h)???).eBT >= l1)) {
            break label379;
          }
          l1 = ((h)???).eBT;
          localObject1 = str;
          localObject5 = ???;
          break label401;
        }
      }
      if ((localObject1 != null) && (l2 - l1 > 500L))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
        synchronized (this.lDc)
        {
          if (this.oWI.contains(localObject5))
          {
            this.oWH.remove(localObject5);
            this.oWI.remove(localObject5);
          }
          if (this.oWG.contains(localObject5))
          {
            this.oWG.remove(localObject5);
            this.oWF.remove(localObject5);
          }
          AppMethodBeat.o(137316);
          return localObject1;
        }
      }
    }
    Object localObject4 = new h();
    AppMethodBeat.o(137316);
    return localObject4;
    label394:
    label401:
    label416:
    label421:
    label424:
    for (;;)
    {
      label379:
      ??? = localObject4;
      localObject4 = localObject5;
      localObject5 = ???;
      for (;;)
      {
        if (i == 0) {
          break label424;
        }
        break label168;
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
  
  private int bUd()
  {
    AppMethodBeat.i(137327);
    int i;
    boolean bool;
    synchronized (this.lDc)
    {
      Iterator localIterator = this.oWI.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        h localh = UO((String)localObject3);
        if (localh == null)
        {
          ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = UM((String)localObject3);
          if (localObject3 == null) {
            break label135;
          }
          bool = ((com.tencent.mm.ag.d)localObject3).kH;
        }
        else
        {
          bool = localh.isPaused();
        }
      }
      else
      {
        AppMethodBeat.o(137327);
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
  
  private void bUe()
  {
    AppMethodBeat.i(137329);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.lDc)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.oWI);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        h localh = (h)this.oWH.get(str);
        if ((localh != null) && (localh.isPaused())) {
          a(str, localh);
        }
      }
    }
    AppMethodBeat.o(137329);
  }
  
  private void bUf()
  {
    AppMethodBeat.i(137330);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      h localh;
      synchronized (this.lDc)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.oWI);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localh = (h)this.oWH.remove(str);
        this.oWI.remove(str);
        if (localh == null) {
          continue;
        }
        if (localh.frl)
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
    AppMethodBeat.o(137330);
  }
  
  private void bUh()
  {
    AppMethodBeat.i(137336);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.cmW.fqV), Boolean.valueOf(this.oWW.oYb) });
    if ((!this.cmW.fqV) && (!this.oWW.oYb))
    {
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      bUi();
      AppMethodBeat.o(137336);
      return;
    }
    if ((this.cmW.fqV) && (this.oWW.oYb))
    {
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bUj();
    }
    AppMethodBeat.o(137336);
  }
  
  private void bUi()
  {
    AppMethodBeat.i(137337);
    if (this.oWW.oYb)
    {
      AppMethodBeat.o(137337);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(this.oWW.requestFocus()) });
    AppMethodBeat.o(137337);
  }
  
  private void bUk()
  {
    AppMethodBeat.i(137339);
    this.oWV = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.oWV != null) {
      this.oWV.bUL();
    }
    AppMethodBeat.o(137339);
  }
  
  static void c(String paramString, h paramh)
  {
    AppMethodBeat.i(137320);
    if (paramh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      AppMethodBeat.o(137320);
      return;
    }
    if ((paramh.aiw()) || (paramh.aiy()) || (paramh.bUB()) || (paramh.bUC()) || (paramh.isPaused())) {
      paramh.stopPlay();
    }
    paramh.release();
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
    AppMethodBeat.o(137320);
  }
  
  private boolean cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(137303);
    paramString = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    if (paramString != null)
    {
      paramString.startTime = paramInt;
      AppMethodBeat.o(137303);
      return true;
    }
    AppMethodBeat.o(137303);
    return false;
  }
  
  static void d(String paramString, h paramh)
  {
    AppMethodBeat.i(137321);
    ab.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramh);
    AppMethodBeat.o(137321);
  }
  
  private void fs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137290);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(137290);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.oWJ.contains(paramString1)) {
      this.oWJ.add(paramString1);
    }
    if (!this.oWE.contains(paramString2)) {
      this.oWE.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.oWL.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.oWL.put(paramString1, localLinkedList1);
    AppMethodBeat.o(137290);
  }
  
  private void i(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137294);
    if (this.oWZ.en(paramb.ceu)) {
      this.oWZ.c(paramb);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramb.filePath)) {
        UZ(paramb.ceu);
      }
      AppMethodBeat.o(137294);
      return;
      this.oWZ.b(paramb);
    }
  }
  
  private void j(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137340);
    this.oWV = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.oWV != null) {
      this.oWV.fu(paramb.ceu, paramb.cfG);
    }
    AppMethodBeat.o(137340);
  }
  
  private static void k(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137343);
    if (paramb.fri != null) {
      try
      {
        paramb.fri.close();
        paramb.fri = null;
        AppMethodBeat.o(137343);
        return;
      }
      catch (Exception paramb)
      {
        ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", paramb, "closeAudioDataSource", new Object[0]);
      }
    }
    AppMethodBeat.o(137343);
  }
  
  public final boolean UG(String paramString)
  {
    AppMethodBeat.i(137298);
    h localh = UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
      if (this.oWZ.en(paramString))
      {
        this.oWZ.eq(paramString);
        AppMethodBeat.o(137298);
        return true;
      }
      AppMethodBeat.o(137298);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[] { paramString });
    localh.pause();
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137298);
    return true;
  }
  
  public final boolean UH(String paramString)
  {
    AppMethodBeat.i(137299);
    h localh = UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      if (this.oWZ.en(paramString))
      {
        this.oWZ.er(paramString);
        AppMethodBeat.o(137299);
        return true;
      }
      AppMethodBeat.o(137299);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localh.stopPlay();
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    if (localb != null)
    {
      localb.startTime = 0;
      localb.fqX = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137299);
    return true;
  }
  
  public final boolean UI(String paramString)
  {
    AppMethodBeat.i(137300);
    if (this.oWZ.en(paramString)) {
      this.oWZ.er(paramString);
    }
    h localh = UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
      AppMethodBeat.o(137300);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[] { paramString });
    localh.bUF();
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    if (localb != null)
    {
      localb.startTime = 0;
      localb.fqX = true;
    }
    b(paramString, localh);
    f(paramString, localh);
    AppMethodBeat.o(137300);
    return true;
  }
  
  public final boolean UJ(String paramString)
  {
    AppMethodBeat.i(137301);
    this.oWZ.er(paramString);
    this.oWZ.remove(paramString);
    ??? = UO(paramString);
    if (??? == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      AppMethodBeat.o(137301);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (h)???);
    synchronized (this.lDc)
    {
      this.oWF.remove(paramString);
      this.oWG.remove(paramString);
      this.oWH.remove(paramString);
      this.oWI.remove(paramString);
      this.oWE.remove(paramString);
      ??? = this.oWJ.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.oWL.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.oWL.remove(str);
            this.oWJ.remove(str);
            this.oWK.remove(str);
          }
        }
      }
      this.oWM.remove(paramString);
      this.oWN.remove(paramString);
      AppMethodBeat.o(137301);
      return true;
    }
  }
  
  public final boolean UK(String paramString)
  {
    AppMethodBeat.i(137304);
    h localh = UO(paramString);
    if (localh == null)
    {
      if (this.oWZ.en(paramString))
      {
        bool = this.oWZ.es(paramString);
        AppMethodBeat.o(137304);
        return bool;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
      AppMethodBeat.o(137304);
      return false;
    }
    boolean bool = localh.aiy();
    AppMethodBeat.o(137304);
    return bool;
  }
  
  public final boolean UL(String paramString)
  {
    AppMethodBeat.i(137307);
    h localh = UO(paramString);
    if (localh == null)
    {
      if (this.oWZ.en(paramString))
      {
        bool = this.oWZ.Ea();
        AppMethodBeat.o(137307);
        return bool;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
      paramString = UM(paramString);
      if (paramString != null)
      {
        bool = paramString.frl;
        AppMethodBeat.o(137307);
        return bool;
      }
      AppMethodBeat.o(137307);
      return false;
    }
    boolean bool = localh.frl;
    AppMethodBeat.o(137307);
    return bool;
  }
  
  public final com.tencent.mm.ag.d UM(String paramString)
  {
    AppMethodBeat.i(137308);
    Object localObject = UO(paramString);
    if (localObject != null)
    {
      paramString = ((h)localObject).bUI();
      AppMethodBeat.o(137308);
      return paramString;
    }
    if (this.oWZ.en(paramString))
    {
      localObject = this.oWZ.ex(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(137308);
        return localObject;
      }
    }
    paramString = (com.tencent.mm.ag.d)this.oWN.get(paramString);
    AppMethodBeat.o(137308);
    return paramString;
  }
  
  public final int UN(String paramString)
  {
    AppMethodBeat.i(137309);
    int j = bUd();
    synchronized (this.lDc)
    {
      int k = this.oWE.size();
      int m = this.oWF.size();
      int n = this.oWH.size();
      paramString = (LinkedList)this.oWL.get(paramString);
      if (paramString == null)
      {
        i = 0;
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(137309);
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final h UO(String paramString)
  {
    AppMethodBeat.i(137311);
    if (this.oWF.containsKey(paramString))
    {
      paramString = (h)this.oWF.get(paramString);
      AppMethodBeat.o(137311);
      return paramString;
    }
    if (this.oWH.containsKey(paramString))
    {
      paramString = (h)this.oWH.get(paramString);
      AppMethodBeat.o(137311);
      return paramString;
    }
    AppMethodBeat.o(137311);
    return null;
  }
  
  public final void UP(String paramString)
  {
    AppMethodBeat.i(137312);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    this.oWZ.DZ();
    bUj();
    Object localObject3 = (LinkedList)this.oWL.get(paramString);
    long l1 = this.oWZ.Ec();
    long l2 = com.tencent.mm.audio.mix.b.d.De().Df();
    long l3 = com.tencent.mm.audio.mix.b.c.Dc().Dd();
    long l4 = l2 + l3;
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    this.oWV = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.b.a.d.class));
    if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      AppMethodBeat.o(137312);
      return;
    }
    if ((this.oWF.isEmpty()) && (this.oWH.isEmpty()))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
      if (this.oWV != null) {
        this.oWV.b(paramString, l1, l4, l2);
      }
      AppMethodBeat.o(137312);
      return;
    }
    Object localObject1 = new LinkedList();
    synchronized (this.lDc)
    {
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (String)((Iterator)???).next();
        h localh = (h)this.oWH.get(localObject3);
        if (localh != null) {
          a((String)localObject3, localh);
        }
      }
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.oWF.size()) });
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (String)((Iterator)localObject1).next();
      localObject3 = (h)this.oWF.get(???);
      if (localObject3 != null)
      {
        a((String)???, (h)localObject3);
        f((String)???, (h)localObject3);
      }
    }
    if (this.oWV != null) {
      this.oWV.b(paramString, l1, l4, l2);
    }
    AppMethodBeat.o(137312);
  }
  
  public final void UQ(String paramString)
  {
    AppMethodBeat.i(137313);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bUj();
    LinkedList localLinkedList = (LinkedList)this.oWL.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      AppMethodBeat.o(137313);
      return;
    }
    String str;
    h localh;
    synchronized (this.lDc)
    {
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localh = (h)this.oWF.remove(str);
        this.oWG.remove(str);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localh);
        this.oWM.remove(str);
        this.oWN.remove(str);
        if (this.oWZ.en(str))
        {
          this.oWZ.er(str);
          this.oWZ.remove(str);
        }
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localh = (h)this.oWH.remove(str);
      this.oWI.remove(str);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localh);
      this.oWM.remove(str);
      this.oWN.remove(str);
      if (this.oWZ.en(str))
      {
        this.oWZ.er(str);
        this.oWZ.remove(str);
      }
    }
    this.oWE.removeAll(localLinkedList);
    this.oWJ.remove(paramString);
    this.oWK.remove(paramString);
    this.oWZ.clearCache();
    this.oWZ.Eb();
    this.oWX.clear();
    this.oWY.clear();
    AppMethodBeat.o(137313);
  }
  
  public final void UX(String paramString)
  {
    AppMethodBeat.i(137334);
    if (this.oWJ.size() == 0)
    {
      AppMethodBeat.o(137334);
      return;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[] { paramString });
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.oWJ);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)this.oWK.get(str1);
      if ((paramString != null) && (paramString.equalsIgnoreCase(str2)))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
        UQ(str1);
      }
    }
    AppMethodBeat.o(137334);
  }
  
  final boolean UY(String paramString)
  {
    AppMethodBeat.i(137335);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.lDc)
      {
        i = this.oWF.size();
        if (i <= 5)
        {
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(137335);
          return false;
        }
        localObject3 = this.oWG.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.ag.b)this.oWM.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.ag.b)localObject4).cfG == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.ag.b)localObject4).cfG))
        {
          localHashMap1.put(((com.tencent.mm.ag.b)localObject4).cfG, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.ag.b)localObject4).ceu);
          localHashMap2.put(((com.tencent.mm.ag.b)localObject4).cfG, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.ag.b)localObject4).cfG)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.ag.b)localObject4).cfG);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.ag.b)localObject4).cfG)).intValue();
      localHashMap1.put(((com.tencent.mm.ag.b)localObject4).cfG, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.ag.b)localObject4).cfG);
      if (!localArrayList.contains(((com.tencent.mm.ag.b)localObject4).ceu)) {
        localArrayList.add(((com.tencent.mm.ag.b)localObject4).ceu);
      }
      localHashMap2.put(((com.tencent.mm.ag.b)localObject4).cfG, localArrayList);
    }
    paramString = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.cfG)))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        AppMethodBeat.o(137335);
        return false;
      }
    }
    paramString = "";
    ab.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      ab.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
      if (j < 2) {
        break label787;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label784;
      }
      paramString = (String)???;
      i = j;
      label533:
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
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramString = new LinkedList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (String)((Iterator)localObject1).next();
            ??? = (com.tencent.mm.ag.b)this.oWM.get(???);
            if (??? != null) {
              paramString.add(???);
            }
          }
          Collections.sort(paramString, new f.a(this));
          localObject1 = new LinkedList();
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((LinkedList)localObject1).add(((com.tencent.mm.ag.b)paramString.next()).ceu);
          }
          this.oWQ.add(((LinkedList)localObject1).getLast());
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.oWQ.size()) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137335);
        return bool1;
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      }
      label784:
      break label533;
      label787:
      j = i;
      localObject1 = paramString;
    }
  }
  
  public final void UZ(String paramString)
  {
    AppMethodBeat.i(137342);
    if (!b.bTW())
    {
      AppMethodBeat.o(137342);
      return;
    }
    Looper.myQueue().addIdleHandler(new f.4(this, paramString));
    AppMethodBeat.o(137342);
  }
  
  final void b(String paramString, h paramh)
  {
    AppMethodBeat.i(137319);
    this.oWN.put(paramString, paramh.bUI());
    AppMethodBeat.o(137319);
  }
  
  public final boolean b(String paramString, com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137297);
    com.tencent.mm.ag.b localb2 = (com.tencent.mm.ag.b)this.oWM.get(paramString);
    com.tencent.mm.ag.b localb1;
    boolean bool1;
    if (((!this.oWE.contains(paramString)) || (localb2 == null)) && (paramb != null))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      a(paramString, paramb);
      localb1 = localb2;
      if (localb2 == null) {
        localb1 = paramb;
      }
      j(localb1);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
      int i = UN(US(paramString));
      if (i >= 10)
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
        if (!UW(paramString)) {
          break label368;
        }
        bUg();
      }
      bUh();
      this.oWM.put(paramString, localb1);
      paramb = UO(paramString);
      if (!b.bTW()) {
        break label451;
      }
      boolean bool2 = a(paramb);
      if ((!this.oWZ.en(paramString)) || (!this.oWZ.ez(paramString))) {
        break label388;
      }
      bool1 = true;
      label200:
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localb1.ceu });
      if ((!bool2) || (!bool1)) {
        break label459;
      }
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
      UT(localb1.ceu);
      k(localb1);
      if (!this.oWZ.eb(localb1.ceu)) {
        break label394;
      }
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
    }
    for (;;)
    {
      AppMethodBeat.o(137297);
      return true;
      if (!this.oWE.contains(paramString))
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
        aS(601, paramString);
        AppMethodBeat.o(137297);
        return false;
      }
      localb1 = localb2;
      if (localb2 != null) {
        break;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
      aS(602, paramString);
      AppMethodBeat.o(137297);
      return false;
      label368:
      bUk();
      aS(600, paramString);
      AppMethodBeat.o(137297);
      return false;
      label388:
      bool1 = false;
      break label200;
      label394:
      if (this.oWZ.et(localb1.ceu))
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
        localb1.fqX = true;
        paramb.b(localb1);
      }
      else
      {
        a(localb1, false, false);
        this.oWZ.eo(paramString);
      }
    }
    label451:
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
    label459:
    if (paramb == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
      UU(paramString);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
      paramb = bUb();
      paramb.a(this.oXb);
      paramb.Va(paramString);
      e(paramString, paramb);
      localb1.fqX = true;
      localb1.startTime = 0;
      localb1.fqZ = System.currentTimeMillis();
      a(localb1, false, true);
      paramb.l(localb1);
      AppMethodBeat.o(137297);
      return true;
    }
    e(paramString, paramb);
    if ((paramb.aiy()) && (!paramb.aiw()))
    {
      a(localb1, false, true);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
      paramb.resume();
    }
    for (;;)
    {
      AppMethodBeat.o(137297);
      return true;
      if (paramb.bUC())
      {
        a(localb1, false, true);
        localb1.fqX = true;
        localb1.fqZ = System.currentTimeMillis();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
        paramb.resume();
        localb1.startTime = 0;
        paramb.b(localb1);
      }
      else if (paramb.bUB())
      {
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
        localb1.fqX = true;
        localb1.fqZ = System.currentTimeMillis();
        paramb.b(localb1);
      }
      else
      {
        if (paramb.aiy()) {
          break;
        }
        a(localb1, false, true);
        localb1.fqX = true;
        localb1.fqZ = System.currentTimeMillis();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
        paramb.l(localb1);
        localb1.startTime = 0;
      }
    }
    ab.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
    AppMethodBeat.o(137297);
    return false;
  }
  
  public final void bUa()
  {
    AppMethodBeat.i(137288);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.oWE.clear();
    String str;
    synchronized (this.lDc)
    {
      Iterator localIterator = this.oWG.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (h)this.oWF.remove(str));
      }
    }
    this.oWG.clear();
    this.oWF.clear();
    Object localObject3 = this.oWI.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (h)this.oWH.remove(str));
    }
    this.oWI.clear();
    this.oWH.clear();
    ??? = this.oWJ.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.oWL.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.oWJ.clear();
    this.oWK.clear();
    this.oWL.clear();
    this.oWM.clear();
    this.oWN.clear();
    this.oWP.clear();
    this.oWQ.clear();
    al.ae(this.oXc);
    al.ae(this.oXd);
    this.oWR = false;
    this.oWS = false;
    AppMethodBeat.o(137288);
  }
  
  public final void bUc()
  {
    AppMethodBeat.i(137326);
    long l = System.currentTimeMillis();
    if ((this.oWR) && (l - this.oWT < 10000L))
    {
      AppMethodBeat.o(137326);
      return;
    }
    this.oWT = l;
    synchronized (this.lDc)
    {
      this.oWR = true;
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      al.ae(this.oXd);
      al.p(this.oXd, 1800000L);
      AppMethodBeat.o(137326);
      return;
    }
  }
  
  final void bUg()
  {
    AppMethodBeat.i(137333);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.oWO.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      UH(str);
      bUk();
    }
    localIterator = this.oWQ.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      UH(str);
      bUk();
    }
    this.oWO.clear();
    this.oWQ.clear();
    AppMethodBeat.o(137333);
  }
  
  final void bUj()
  {
    AppMethodBeat.i(137338);
    if (this.oWW.oYb) {
      this.oWW.bUj();
    }
    AppMethodBeat.o(137338);
  }
  
  public final boolean cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(137302);
    h localh = UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
      if (this.oWZ.en(paramString)) {
        this.oWZ.w(paramString, paramInt);
      }
      bool = cQ(paramString, paramInt);
      AppMethodBeat.o(137302);
      return bool;
    }
    if (paramInt < 0)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137302);
      return false;
    }
    if (localh.getDuration() <= 0)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      localh.bUv();
      bool = cQ(paramString, paramInt);
      AppMethodBeat.o(137302);
      return bool;
    }
    if ((paramInt > 0) && (paramInt > localh.getDuration()))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localh.getDuration()) });
      AppMethodBeat.o(137302);
      return false;
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((localh.aiw()) || (localh.aiy()) || (localh.isPaused()))
    {
      bool = localh.lN(paramInt);
      AppMethodBeat.o(137302);
      return bool;
    }
    localh.bUv();
    boolean bool = cQ(paramString, paramInt);
    AppMethodBeat.o(137302);
    return bool;
  }
  
  final void e(String paramString, h paramh)
  {
    AppMethodBeat.i(137322);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.lDc)
    {
      if (this.oWI.contains(paramString))
      {
        this.oWH.remove(paramString);
        this.oWI.remove(paramString);
      }
      if (!this.oWG.contains(paramString))
      {
        this.oWG.add(paramString);
        this.oWF.put(paramString, paramh);
      }
      AppMethodBeat.o(137322);
      return;
    }
  }
  
  public final boolean ev(String paramString)
  {
    AppMethodBeat.i(137306);
    h localh = UO(paramString);
    if (localh == null)
    {
      if (this.oWZ.en(paramString))
      {
        bool = this.oWZ.ev(paramString);
        AppMethodBeat.o(137306);
        return bool;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
      AppMethodBeat.o(137306);
      return true;
    }
    boolean bool = localh.isStopped();
    AppMethodBeat.o(137306);
    return bool;
  }
  
  final void f(String paramString, h paramh)
  {
    AppMethodBeat.i(137323);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.lDc)
    {
      if (this.oWG.contains(paramString))
      {
        this.oWF.remove(paramString);
        this.oWG.remove(paramString);
      }
      if (!this.oWI.contains(paramString))
      {
        this.oWI.add(paramString);
        this.oWH.put(paramString, paramh);
      }
      AppMethodBeat.o(137323);
      return;
    }
  }
  
  public final String ft(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137291);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.oWL.get(paramString1);
    Object localObject = this.lDc;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.oWG.contains(paramString2)) {
            break label241;
          }
          if (this.oWI.contains(paramString2))
          {
            break label241;
            j = UN(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label133;
            }
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            aS(604, paramString2);
            AppMethodBeat.o(137291);
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
        AppMethodBeat.o(137291);
      }
      label133:
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      fs(paramString1, paramString2);
      AppMethodBeat.o(137291);
      return null;
      label174:
      if (i != 0)
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        aS(603, paramString2);
        AppMethodBeat.o(137291);
        return null;
      }
      fs(paramString1, paramString2);
      UU(paramString2);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(137291);
      return paramString2;
      label241:
      int i = 1;
    }
  }
  
  public final boolean g(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137292);
    if (paramb == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
      AppMethodBeat.o(137292);
      return false;
    }
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oWM.get(paramb.ceu);
    if (localb != null)
    {
      localb.f(paramb);
      h localh = UO(paramb.ceu);
      if (localh == null) {
        break label130;
      }
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
      localh.b(localb);
      label76:
      if (b.bTW())
      {
        if (!this.oWZ.en(paramb.ceu)) {
          break label141;
        }
        this.oWZ.c(paramb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137292);
      return true;
      this.oWM.put(paramb.ceu, paramb);
      localb = paramb;
      break;
      label130:
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
      break label76;
      label141:
      this.oWZ.b(paramb);
    }
  }
  
  public final boolean h(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137293);
    if (paramb == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      aS(605, "");
      AppMethodBeat.o(137293);
      return false;
    }
    if (TextUtils.isEmpty(paramb.ceu))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      aS(604, paramb.ceu);
      AppMethodBeat.o(137293);
      return false;
    }
    if (!this.oWE.contains(paramb.ceu))
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      aS(601, paramb.ceu);
      AppMethodBeat.o(137293);
      return false;
    }
    if (paramb.fqX) {
      j(paramb);
    }
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
    Object localObject2 = US(paramb.ceu);
    Object localObject1 = qJ(paramb.ceu);
    int i = UN((String)localObject2);
    boolean bool2;
    boolean bool3;
    if (i >= 10)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(i) });
      this.oWM.put(paramb.ceu, paramb);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.fqX) });
      if ((paramb.fqX) && (UW(paramb.ceu))) {
        bUg();
      }
    }
    else
    {
      UU(paramb.ceu);
      bUh();
      this.oWK.put(localObject2, paramb.processName);
      this.oWM.put(paramb.ceu, paramb);
      if ((TextUtils.isEmpty(paramb.filePath)) && (this.oWX.containsKey(paramb.cfG))) {
        paramb.filePath = ((String)this.oWX.get(paramb.cfG));
      }
      localObject2 = UO(paramb.ceu);
      bool2 = b.bTW();
      if (!bool2) {
        break label551;
      }
      bool3 = a((h)localObject2);
      if (((TextUtils.isEmpty(paramb.filePath)) || (!this.oWZ.eA(paramb.filePath))) && ((localObject1 == null) || (!paramb.e((com.tencent.mm.ag.b)localObject1)) || (TextUtils.isEmpty(((com.tencent.mm.ag.b)localObject1).filePath)) || (!this.oWZ.eA(((com.tencent.mm.ag.b)localObject1).filePath)))) {
        break label546;
      }
    }
    label546:
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), paramb.ceu });
      if ((!bool3) || (!bool1)) {
        break;
      }
      a(paramb, (com.tencent.mm.ag.b)localObject1);
      AppMethodBeat.o(137293);
      return true;
      if (paramb.fqX)
      {
        aS(600, paramb.ceu);
        bUk();
        AppMethodBeat.o(137293);
        return false;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = UO(paramb.ceu);
      if (localObject1 != null)
      {
        ((h)localObject1).b(paramb);
        ((h)localObject1).bUq();
      }
      AppMethodBeat.o(137293);
      return true;
    }
    label551:
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
    b(paramb, (com.tencent.mm.ag.b)localObject1);
    if (bool2) {
      i(paramb);
    }
    AppMethodBeat.o(137293);
    return true;
  }
  
  public final boolean qI(String paramString)
  {
    AppMethodBeat.i(137305);
    h localh = UO(paramString);
    if (localh == null)
    {
      if (this.oWZ.en(paramString))
      {
        bool = this.oWZ.eb(paramString);
        AppMethodBeat.o(137305);
        return bool;
      }
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
      AppMethodBeat.o(137305);
      return false;
    }
    boolean bool = localh.aiw();
    AppMethodBeat.o(137305);
    return bool;
  }
  
  public final com.tencent.mm.ag.b qJ(String paramString)
  {
    AppMethodBeat.i(137310);
    if (this.oWM.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ag.b)this.oWM.get(paramString);
      AppMethodBeat.o(137310);
      return paramString;
    }
    AppMethodBeat.o(137310);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */