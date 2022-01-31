package com.tencent.mm.plugin.music.b;

import android.media.AudioManager;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.h.a.t;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static e mxg;
  com.tencent.mm.af.a bFP = new com.tencent.mm.af.a();
  Object jtD = new Object();
  private LinkedList<String> mwN = new LinkedList();
  HashMap<String, g> mwO = new HashMap();
  LinkedList<String> mwP = new LinkedList();
  HashMap<String, g> mwQ = new HashMap();
  LinkedList<String> mwR = new LinkedList();
  LinkedList<String> mwS = new LinkedList();
  HashMap<String, String> mwT = new HashMap();
  HashMap<String, LinkedList<String>> mwU = new HashMap();
  HashMap<String, com.tencent.mm.af.b> mwV = new HashMap();
  private HashMap<String, com.tencent.mm.af.d> mwW = new HashMap();
  private LinkedList<String> mwX = new LinkedList();
  HashMap<String, Integer> mwY = new HashMap();
  private LinkedList<String> mwZ = new LinkedList();
  boolean mxa = false;
  private boolean mxb = false;
  long mxc = 0L;
  private long mxd = 0L;
  private com.tencent.mm.plugin.music.b.a.b mxe;
  private com.tencent.mm.plugin.music.b.b.a mxf = new com.tencent.mm.plugin.music.b.b.a();
  private b mxh = new e.1(this);
  private Runnable mxi = new e.2(this);
  Runnable mxj = new e.3(this);
  
  private e()
  {
    blZ();
  }
  
  private String IY(String paramString)
  {
    Iterator localIterator = this.mwS.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LinkedList localLinkedList = (LinkedList)this.mwU.get(str);
      if ((localLinkedList != null) && (localLinkedList.contains(paramString))) {
        return str;
      }
    }
    return "";
  }
  
  private void IZ(String paramString)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
    int i = this.mwO.size();
    int j = this.mwQ.size();
    int k = bmc();
    y.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (i >= 10) {
      bmd();
    }
    Iterator localIterator;
    String str;
    for (;;)
    {
      paramString = IY(paramString);
      i = this.mwO.size();
      j = this.mwQ.size();
      y.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j < 50) {
        break;
      }
      localIterator = this.mwS.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          Ja(str);
        }
      }
      if (k >= 6) {
        bmd();
      } else if (i + k >= 8) {
        bmd();
      }
    }
    if (j + i >= 50)
    {
      localIterator = this.mwS.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((str != null) && (!str.equalsIgnoreCase(paramString))) {
          Ja(str);
        }
      }
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
    j = this.mwQ.size();
    y.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j >= 50)
    {
      bme();
      return;
    }
    if (j + i >= 50)
    {
      bme();
      return;
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
  }
  
  private void Ja(String arg1)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
    y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[] { ??? });
    Object localObject1 = (LinkedList)this.mwU.get(???);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      return;
    }
    for (;;)
    {
      String str;
      g localg;
      synchronized (this.jtD)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject1).next();
        localg = (g)this.mwQ.remove(str);
        this.mwR.remove(str);
        if (localg == null) {
          continue;
        }
        b(str, localg);
        y.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
        if (localg.eaW) {
          d(str, localg);
        }
      }
      c(str, localg);
    }
  }
  
  private boolean Jb(String paramString)
  {
    boolean bool1 = false;
    Object localObject2 = new ArrayList();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    int m;
    Object localObject3;
    for (;;)
    {
      synchronized (this.jtD)
      {
        m = this.mwO.size();
        if (m < 10)
        {
          this.mwX.clear();
          y.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[] { Integer.valueOf(m) });
          return false;
        }
        localObject3 = this.mwP.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.af.b)this.mwV.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.af.b)localObject4).ceM == null)) {
          continue;
        }
        if (!localHashMap2.containsKey(((com.tencent.mm.af.b)localObject4).ceM))
        {
          localHashMap2.put(((com.tencent.mm.af.b)localObject4).ceM, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.af.b)localObject4).bFM);
          localHashMap1.put(((com.tencent.mm.af.b)localObject4).ceM, localArrayList);
          if (((ArrayList)localObject2).contains(((com.tencent.mm.af.b)localObject4).ceM)) {
            continue;
          }
          ((ArrayList)localObject2).add(((com.tencent.mm.af.b)localObject4).ceM);
        }
      }
      i = ((Integer)localHashMap2.get(((com.tencent.mm.af.b)localObject4).ceM)).intValue();
      localHashMap2.put(((com.tencent.mm.af.b)localObject4).ceM, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap1.get(((com.tencent.mm.af.b)localObject4).ceM);
      if (!localArrayList.contains(((com.tencent.mm.af.b)localObject4).bFM)) {
        localArrayList.add(((com.tencent.mm.af.b)localObject4).bFM);
      }
      localHashMap1.put(((com.tencent.mm.af.b)localObject4).ceM, localArrayList);
    }
    ??? = "";
    int k = com.tencent.mm.plugin.music.cache.g.bmJ();
    y.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", new Object[] { Integer.valueOf(k) });
    Object localObject4 = ((ArrayList)localObject2).iterator();
    int i = k;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (String)((Iterator)localObject4).next();
      j = ((Integer)localHashMap2.get(localObject3)).intValue();
      y.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), localObject3 });
      if (j < k) {
        break label882;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label879;
      }
      ??? = localObject3;
      i = j;
      label449:
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
        paramString = (com.tencent.mm.af.b)this.mwV.get(paramString);
        if ((paramString != null) && (??? != null) && (((String)???).equalsIgnoreCase(paramString.ceM)))
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
          ??? = (ArrayList)localHashMap1.get(???);
          if ((??? != null) && (((ArrayList)???).size() > 0))
          {
            paramString = new LinkedList();
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              localObject2 = (com.tencent.mm.af.b)this.mwV.get(localObject2);
              if (localObject2 != null) {
                paramString.add(localObject2);
              }
            }
            Collections.sort(paramString, new e.a(this));
            ??? = new LinkedList();
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              ((LinkedList)???).add(((com.tencent.mm.af.b)paramString.next()).bFM);
            }
            i = m - 10;
            if ((i <= 0) || (((LinkedList)???).size() <= i)) {
              break label800;
            }
            i += 1;
            y.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", new Object[] { Integer.valueOf(i) });
            j = ((LinkedList)???).size() - i;
            i = j;
            if (j < 0) {
              i = 1;
            }
            this.mwX.addAll(((LinkedList)???).subList(i, ((LinkedList)???).size()));
            y.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", new Object[] { Integer.valueOf(this.mwX.size()) });
          }
        }
        for (;;)
        {
          return bool1;
          label800:
          if ((i > 0) && (((LinkedList)???).size() < i))
          {
            this.mwX.addAll(((LinkedList)???).subList(1, ((LinkedList)???).size()));
            break;
          }
          this.mwX.add(((LinkedList)???).get(((LinkedList)???).size() - 1));
          break;
          y.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
          this.mwX.clear();
        }
      }
      label879:
      break label449;
      label882:
      j = i;
      localObject2 = ???;
    }
  }
  
  private void a(String paramString, g paramg)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[] { paramString });
    com.tencent.mm.af.b localb = (com.tencent.mm.af.b)this.mwV.get(paramString);
    if ((localb != null) && (paramg.Pu()) && (paramg.Pv()))
    {
      localb.eaO = true;
      localb.startTime = paramg.bmA();
    }
    for (;;)
    {
      b(paramString, paramg);
      paramString = IT(paramString);
      if ((paramString != null) && (paramg.Pu())) {
        paramString.jJ = true;
      }
      if ((!paramg.Pu()) && (!paramg.Pv()) && (!paramg.bmy()) && (!paramg.isPrepared()) && (!paramg.isPaused())) {
        break;
      }
      y.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
      paramg.eaW = true;
      paramg.bmz();
      return;
      if ((localb != null) && (paramg.Pv()))
      {
        localb.eaO = true;
        localb.startTime = paramg.bmA();
      }
      else if (localb != null)
      {
        localb.eaO = true;
        localb.startTime = 0;
      }
    }
    y.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    paramg.eaW = true;
    paramg.mxs = true;
  }
  
  private void aw(int paramInt, String paramString)
  {
    y.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
      str = d.blW();
    }
    paramString = new t();
    paramString.bFS.action = 4;
    paramString.bFS.state = "error";
    paramString.bFS.errCode = com.tencent.mm.plugin.music.f.a.e.uV(paramInt);
    paramString.bFS.aox = com.tencent.mm.plugin.music.f.a.e.uW(paramInt);
    paramString.bFS.bFM = str;
    paramString.bFS.appId = IY(str);
    com.tencent.mm.sdk.b.a.udP.a(paramString, Looper.getMainLooper());
  }
  
  /* Error */
  public static void blX()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 458	com/tencent/mm/plugin/music/b/e:mxg	Lcom/tencent/mm/plugin/music/b/e;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 2	com/tencent/mm/plugin/music/b/e
    //   18: dup
    //   19: invokespecial 459	com/tencent/mm/plugin/music/b/e:<init>	()V
    //   22: putstatic 458	com/tencent/mm/plugin/music/b/e:mxg	Lcom/tencent/mm/plugin/music/b/e;
    //   25: goto -14 -> 11
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	locale	e
    //   28	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	28	finally
    //   15	25	28	finally
  }
  
  public static e blY()
  {
    if (mxg == null) {
      mxg = new e();
    }
    return mxg;
  }
  
  private g bma()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
    Object localObject1;
    Object localObject5;
    int i;
    synchronized (this.jtD)
    {
      if (this.mwQ.size() == 0)
      {
        localObject1 = new g();
        return localObject1;
      }
      localObject1 = null;
      localObject5 = "";
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.mwR.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ??? = (g)this.mwQ.get(str);
        if (??? != null)
        {
          if ((!((g)???).eaW) && (!((g)???).isCompleted()) && (!((g)???).isStopped()))
          {
            if (((g)???).mxp == null) {
              break label381;
            }
            if (((g)???).mxp.getPlayerState() != 9) {
              break label376;
            }
            i = 1;
            break label354;
          }
          label156:
          if ((l1 != 0L) && (((g)???).dEq >= l1)) {
            break label339;
          }
          l1 = ((g)???).dEq;
          localObject1 = str;
          localObject5 = ???;
          break label361;
        }
      }
      if ((localObject1 == null) || (l2 - l1 <= 500L)) {
        break label328;
      }
      y.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
      y.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[] { localObject5 });
    }
    synchronized (this.jtD)
    {
      if (this.mwR.contains(localObject5))
      {
        this.mwQ.remove(localObject5);
        this.mwR.remove(localObject5);
      }
      if (this.mwP.contains(localObject5))
      {
        this.mwP.remove(localObject5);
        this.mwO.remove(localObject5);
      }
      return localObject1;
      localObject2 = finally;
      throw localObject2;
    }
    label328:
    return new g();
    label384:
    for (;;)
    {
      label339:
      ??? = localObject3;
      Object localObject4 = localObject5;
      localObject5 = ???;
      for (;;)
      {
        label354:
        if (i == 0) {
          break label384;
        }
        break label156;
        label361:
        ??? = localObject5;
        localObject5 = localObject4;
        localObject4 = ???;
        break;
        label376:
        i = 0;
        continue;
        label381:
        i = 0;
      }
    }
  }
  
  private int bmc()
  {
    int i;
    boolean bool;
    synchronized (this.jtD)
    {
      Iterator localIterator = this.mwR.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        g localg = IV((String)localObject3);
        if (localg == null)
        {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
          localObject3 = IT((String)localObject3);
          if (localObject3 == null) {
            break label117;
          }
          bool = ((com.tencent.mm.af.d)localObject3).jJ;
        }
        else
        {
          bool = localg.isPaused();
        }
      }
      else
      {
        return i;
      }
    }
    label117:
    label120:
    for (;;)
    {
      for (;;)
      {
        if (!bool) {
          break label120;
        }
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  private void bmd()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
    synchronized (this.jtD)
    {
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(this.mwR);
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        g localg = (g)this.mwQ.get(str);
        if ((localg != null) && (localg.isPaused())) {
          a(str, localg);
        }
      }
    }
  }
  
  private void bme()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
    for (;;)
    {
      String str;
      g localg;
      synchronized (this.jtD)
      {
        Object localObject2 = new LinkedList();
        ((LinkedList)localObject2).addAll(this.mwR);
        localObject2 = ((LinkedList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject2).next();
        localg = (g)this.mwQ.remove(str);
        this.mwR.remove(str);
        if (localg == null) {
          continue;
        }
        if (localg.eaW)
        {
          b(str, localg);
          d(str, localg);
        }
      }
      if (!localg.isPaused())
      {
        b(str, localg);
        c(str, localg);
      }
    }
  }
  
  private void bmg()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "mix play with music mixWithOther:%b, focus:%b", new Object[] { Boolean.valueOf(this.bFP.eaM), Boolean.valueOf(this.mxf.mxR) });
    if ((!this.bFP.eaM) && (!this.mxf.mxR))
    {
      y.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
      if (!this.mxf.mxR)
      {
        com.tencent.mm.plugin.music.b.b.a locala = this.mxf;
        if (locala.dui == null) {
          break label171;
        }
        int i = locala.dui.requestAudioFocus(locala.mxS, 3, 2);
        if (i != 1) {
          break label166;
        }
        bool = true;
        y.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
        if (i == 1) {
          locala.mxR = true;
        }
        if (i != 1) {
          break label171;
        }
      }
      label166:
      label171:
      for (boolean bool = true;; bool = false)
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", new Object[] { Boolean.valueOf(bool) });
        return;
        bool = false;
        break;
      }
    }
    if ((this.bFP.eaM) && (this.mxf.mxR))
    {
      y.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
      bmh();
      return;
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
  }
  
  static void c(String paramString, g paramg)
  {
    if (paramg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[] { paramString });
      return;
    }
    if ((paramg.Pu()) || (paramg.Pv()) || (paramg.bmy()) || (paramg.isPrepared()) || (paramg.isPaused())) {
      paramg.stopPlay();
    }
    paramg.release();
    y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[] { paramString });
  }
  
  static void d(String paramString, g paramg)
  {
    y.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
    c(paramString, paramg);
  }
  
  private void dY(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    if (!this.mwS.contains(paramString1)) {
      this.mwS.add(paramString1);
    }
    if (!this.mwN.contains(paramString2)) {
      this.mwN.add(paramString2);
    }
    LinkedList localLinkedList2 = (LinkedList)this.mwU.get(paramString1);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null) {
      localLinkedList1 = new LinkedList();
    }
    if (!localLinkedList1.contains(paramString2)) {
      localLinkedList1.add(paramString2);
    }
    this.mwU.put(paramString1, localLinkedList1);
  }
  
  public final boolean IR(String paramString)
  {
    g localg = IV(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
      return false;
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[] { paramString });
    localg.stopPlay();
    com.tencent.mm.af.b localb = (com.tencent.mm.af.b)this.mwV.get(paramString);
    if (localb != null)
    {
      localb.startTime = 0;
      localb.eaO = true;
    }
    b(paramString, localg);
    f(paramString, localg);
    return true;
  }
  
  public final boolean IS(String paramString)
  {
    ??? = IV(paramString);
    if (??? == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
      return false;
    }
    y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[] { paramString });
    c(paramString, (g)???);
    synchronized (this.jtD)
    {
      this.mwO.remove(paramString);
      this.mwP.remove(paramString);
      this.mwQ.remove(paramString);
      this.mwR.remove(paramString);
      this.mwN.remove(paramString);
      ??? = this.mwS.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        LinkedList localLinkedList = (LinkedList)this.mwU.get(str);
        if ((localLinkedList != null) && (localLinkedList.contains(paramString)))
        {
          localLinkedList.remove(paramString);
          if (localLinkedList.size() == 0)
          {
            this.mwU.remove(str);
            this.mwS.remove(str);
            this.mwT.remove(str);
          }
        }
      }
      this.mwV.remove(paramString);
      this.mwW.remove(paramString);
      return true;
    }
  }
  
  public final com.tencent.mm.af.d IT(String paramString)
  {
    g localg = IV(paramString);
    if (localg != null) {
      return localg.bmB();
    }
    return (com.tencent.mm.af.d)this.mwW.get(paramString);
  }
  
  public final int IU(String paramString)
  {
    int j = bmc();
    synchronized (this.jtD)
    {
      int k = this.mwN.size();
      int m = this.mwO.size();
      int n = this.mwQ.size();
      paramString = (LinkedList)this.mwU.get(paramString);
      if (paramString == null)
      {
        i = 0;
        y.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
        return m;
      }
      int i = paramString.size();
    }
  }
  
  final g IV(String paramString)
  {
    if (this.mwO.containsKey(paramString)) {
      return (g)this.mwO.get(paramString);
    }
    if (this.mwQ.containsKey(paramString)) {
      return (g)this.mwQ.get(paramString);
    }
    return null;
  }
  
  public final void IW(String paramString)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[] { paramString });
    bmh();
    Object localObject1 = (LinkedList)this.mwU.get(paramString);
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0)) {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
    }
    do
    {
      return;
      if ((this.mwO.isEmpty()) && (this.mwQ.isEmpty()))
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        return;
      }
      Object localObject2 = ((LinkedList)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        g localg = (g)this.mwQ.get(localObject3);
        if (localg != null) {
          a((String)localObject3, localg);
        }
      }
      y.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[] { Integer.valueOf(this.mwO.size()) });
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (g)this.mwO.get(localObject2);
        if (localObject3 != null)
        {
          a((String)localObject2, (g)localObject3);
          f((String)localObject2, (g)localObject3);
        }
      }
      this.mxe = ((com.tencent.mm.plugin.music.b.a.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.b.a.b.class));
    } while (this.mxe == null);
    this.mxe.Je(paramString);
  }
  
  public final void IX(String paramString)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[] { paramString });
    bmh();
    LinkedList localLinkedList = (LinkedList)this.mwU.remove(paramString);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
      return;
    }
    String str;
    g localg;
    synchronized (this.jtD)
    {
      localIterator = localLinkedList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localg = (g)this.mwO.remove(str);
        this.mwP.remove(str);
        y.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
        c(str, localg);
        this.mwV.remove(str);
        this.mwW.remove(str);
      }
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localg = (g)this.mwQ.remove(str);
      this.mwR.remove(str);
      y.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
      c(str, localg);
      this.mwV.remove(str);
      this.mwW.remove(str);
    }
    this.mwN.removeAll(localLinkedList);
    this.mwS.remove(paramString);
    this.mwT.remove(paramString);
  }
  
  final boolean Jc(String paramString)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
    boolean bool1 = false;
    Object localObject1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      Object localObject4;
      synchronized (this.jtD)
      {
        i = this.mwO.size();
        if (i <= 5)
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[] { Integer.valueOf(i) });
          return false;
        }
        localObject3 = this.mwP.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.tencent.mm.af.b)this.mwV.get(localObject4);
        if ((localObject4 == null) || (((com.tencent.mm.af.b)localObject4).ceM == null)) {
          continue;
        }
        if (!localHashMap1.containsKey(((com.tencent.mm.af.b)localObject4).ceM))
        {
          localHashMap1.put(((com.tencent.mm.af.b)localObject4).ceM, Integer.valueOf(1));
          localArrayList = new ArrayList();
          localArrayList.add(((com.tencent.mm.af.b)localObject4).bFM);
          localHashMap2.put(((com.tencent.mm.af.b)localObject4).ceM, localArrayList);
          if (((ArrayList)localObject1).contains(((com.tencent.mm.af.b)localObject4).ceM)) {
            continue;
          }
          ((ArrayList)localObject1).add(((com.tencent.mm.af.b)localObject4).ceM);
        }
      }
      i = ((Integer)localHashMap1.get(((com.tencent.mm.af.b)localObject4).ceM)).intValue();
      localHashMap1.put(((com.tencent.mm.af.b)localObject4).ceM, Integer.valueOf(i + 1));
      ArrayList localArrayList = (ArrayList)localHashMap2.get(((com.tencent.mm.af.b)localObject4).ceM);
      if (!localArrayList.contains(((com.tencent.mm.af.b)localObject4).bFM)) {
        localArrayList.add(((com.tencent.mm.af.b)localObject4).bFM);
      }
      localHashMap2.put(((com.tencent.mm.af.b)localObject4).ceM, localArrayList);
    }
    paramString = (com.tencent.mm.af.b)this.mwV.get(paramString);
    ??? = ((ArrayList)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      if ((paramString != null) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase(paramString.ceM)))
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        return false;
      }
    }
    paramString = "";
    y.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", new Object[] { Integer.valueOf(2) });
    int i = 2;
    Object localObject3 = ((ArrayList)localObject1).iterator();
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      ??? = (String)((Iterator)localObject3).next();
      j = ((Integer)localHashMap1.get(???)).intValue();
      y.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", new Object[] { Integer.valueOf(j), ??? });
      if (j < 2) {
        break label757;
      }
      boolean bool2 = true;
      if (i >= j) {
        break label754;
      }
      paramString = (String)???;
      i = j;
      label509:
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
        y.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        localObject1 = (ArrayList)localHashMap2.get(paramString);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break label765;
        }
        paramString = new LinkedList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (String)((Iterator)localObject1).next();
          ??? = (com.tencent.mm.af.b)this.mwV.get(???);
          if (??? != null) {
            paramString.add(???);
          }
        }
        Collections.sort(paramString, new e.a(this));
        localObject1 = new LinkedList();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((LinkedList)localObject1).add(((com.tencent.mm.af.b)paramString.next()).bFM);
        }
        this.mwZ.add(((LinkedList)localObject1).getLast());
        y.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", new Object[] { Integer.valueOf(this.mwZ.size()) });
        return bool1;
      }
      y.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
      return bool1;
      label754:
      break label509;
      label757:
      j = i;
      localObject1 = paramString;
    }
    label765:
    return bool1;
  }
  
  public final boolean a(String paramString, com.tencent.mm.af.b paramb)
  {
    Object localObject = (com.tencent.mm.af.b)this.mwV.get(paramString);
    if (((!this.mwN.contains(paramString)) || (localObject == null)) && (paramb != null))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[] { paramString });
      if (paramb == null)
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[] { paramString });
        if (localObject != null) {
          break label636;
        }
      }
    }
    for (;;)
    {
      this.mxe = ((com.tencent.mm.plugin.music.b.a.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.b.a.b.class));
      if (this.mxe != null) {
        this.mxe.ea(paramb.bFM, paramb.ceM);
      }
      paramb.eaS = System.currentTimeMillis();
      if ((paramb.eaU > 0L) && (System.currentTimeMillis() > paramb.eaU)) {}
      for (paramb.eaU = (System.currentTimeMillis() - paramb.eaU);; paramb.eaU = 0L)
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[] { paramString });
        int i = IU(IY(paramString));
        if (i >= 10)
        {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[] { Integer.valueOf(i) });
          if (!Jb(paramString)) {
            break label437;
          }
          bmf();
        }
        bmg();
        localObject = IV(paramString);
        if (localObject != null) {
          break label447;
        }
        y.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
        IZ(paramString);
        y.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[] { paramString });
        localObject = bma();
        ((g)localObject).a(this.mxh);
        ((g)localObject).Jd(paramString);
        e(paramString, (g)localObject);
        paramb.eaO = true;
        paramb.startTime = 0;
        paramb.eaQ = System.currentTimeMillis();
        ((g)localObject).d(paramb);
        return true;
        y.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[] { paramString });
        this.mwT.put(paramb.appId, paramb.processName);
        this.mwV.put(paramb.bFM, paramb);
        dY(paramb.appId, paramString);
        this.mwY.remove(paramString);
        break;
        if (!this.mwN.contains(paramString))
        {
          y.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
          aw(601, paramString);
          return false;
        }
        if (localObject != null) {
          break label636;
        }
        y.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
        aw(602, paramString);
        return false;
      }
      label437:
      aw(600, paramString);
      return false;
      label447:
      e(paramString, (g)localObject);
      this.mwV.put(paramString, paramb);
      if ((((g)localObject).Pv()) && (!((g)localObject).Pu()))
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
        ((g)localObject).resume();
      }
      for (;;)
      {
        return true;
        if (((g)localObject).isPrepared())
        {
          paramb.eaO = true;
          paramb.eaQ = System.currentTimeMillis();
          y.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
          ((g)localObject).resume();
          paramb.startTime = 0;
          ((g)localObject).c(paramb);
        }
        else if (((g)localObject).bmy())
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
          paramb.eaO = true;
          paramb.eaQ = System.currentTimeMillis();
          ((g)localObject).c(paramb);
          ((g)localObject).resume();
        }
        else
        {
          if (((g)localObject).Pv()) {
            break;
          }
          paramb.eaO = true;
          paramb.eaQ = System.currentTimeMillis();
          y.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
          ((g)localObject).d(paramb);
          paramb.startTime = 0;
        }
      }
      y.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
      return false;
      label636:
      paramb = (com.tencent.mm.af.b)localObject;
    }
  }
  
  final void b(String paramString, g paramg)
  {
    this.mwW.put(paramString, paramg.bmB());
  }
  
  public final boolean b(com.tencent.mm.af.b paramb)
  {
    int i = 0;
    if (paramb == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
      aw(605, "");
      return false;
    }
    if (TextUtils.isEmpty(paramb.bFM))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
      aw(604, paramb.bFM);
      return false;
    }
    if (!this.mwN.contains(paramb.bFM))
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
      aw(601, paramb.bFM);
      return false;
    }
    Object localObject1;
    com.tencent.mm.af.b localb;
    g localg;
    if (paramb.eaO)
    {
      this.mxe = ((com.tencent.mm.plugin.music.b.a.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.b.a.b.class));
      if (this.mxe != null) {
        this.mxe.ea(paramb.bFM, paramb.ceM);
      }
      paramb.eaS = System.currentTimeMillis();
      if ((paramb.eaU > 0L) && (System.currentTimeMillis() > paramb.eaU)) {
        paramb.eaU = (System.currentTimeMillis() - paramb.eaU);
      }
    }
    else
    {
      y.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
      localObject1 = IY(paramb.bFM);
      localb = jQ(paramb.bFM);
      int j = IU((String)localObject1);
      if (j >= 10)
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[] { Integer.valueOf(j) });
        this.mwV.put(paramb.bFM, paramb);
        y.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[] { Boolean.valueOf(paramb.eaO) });
        if ((!paramb.eaO) || (!Jb(paramb.bFM))) {
          break label434;
        }
        bmf();
      }
      IZ(paramb.bFM);
      bmg();
      localg = IV(paramb.bFM);
      if (localg != null) {
        break label516;
      }
      y.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[] { paramb.bFM });
      ??? = bma();
      ((g)???).a(this.mxh);
      ((g)???).Jd(paramb.bFM);
      ((g)???).c(paramb);
      if (!paramb.eaO) {
        break label490;
      }
      e(paramb.bFM, (g)???);
      paramb.eaQ = System.currentTimeMillis();
      ((g)???).d(paramb);
    }
    for (;;)
    {
      this.mwT.put(localObject1, paramb.processName);
      this.mwV.put(paramb.bFM, paramb);
      return true;
      paramb.eaU = 0L;
      break;
      label434:
      if (paramb.eaO)
      {
        aw(600, paramb.bFM);
        return false;
      }
      y.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
      localObject1 = IV(paramb.bFM);
      if (localObject1 != null)
      {
        ((g)localObject1).c(paramb);
        ((g)localObject1).bmn();
      }
      return true;
      label490:
      f(paramb.bFM, (g)???);
      ((g)???).bmn();
      y.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
      continue;
      label516:
      y.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[] { paramb.bFM });
      if (!paramb.eaO) {
        break label752;
      }
      e(paramb.bFM, localg);
      paramb.eaQ = System.currentTimeMillis();
      localg.c(paramb);
      if ((localb != null) && (!localb.a(paramb)))
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
        if ((localg.Pu()) || (localg.Pv()) || (localg.bmy()) || (localg.isPrepared()) || (localg.isPaused())) {
          localg.stopPlay();
        }
        localg.d(paramb);
      }
      else if (localg.Pu())
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
      }
      else if ((localg.Pv()) && (localg.isPaused()))
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
        localg.resume();
      }
      else if (localg.isPrepared())
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
        localg.resume();
      }
      else if (localg.bmy())
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
      }
      else
      {
        y.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
        localg.d(paramb);
      }
    }
    for (;;)
    {
      label752:
      synchronized (this.jtD)
      {
        if (this.mwP.contains(paramb.bFM)) {
          i = 1;
        }
        if (i == 0)
        {
          y.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
          f(paramb.bFM, localg);
          localg.c(paramb);
          if ((localb != null) && (!localb.a(paramb)))
          {
            y.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if ((localg.Pu()) || (localg.Pv()) || (localg.bmy()) || (localg.isPrepared()) || (localg.isPaused())) {
              localg.stopPlay();
            }
          }
          localg.bmn();
          y.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
        }
      }
      y.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
    }
  }
  
  final boolean bY(String paramString, int paramInt)
  {
    paramString = (com.tencent.mm.af.b)this.mwV.get(paramString);
    if (paramString != null)
    {
      paramString.startTime = paramInt;
      return true;
    }
    return false;
  }
  
  public final void blZ()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
    this.mwN.clear();
    String str;
    synchronized (this.jtD)
    {
      Iterator localIterator = this.mwP.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        c(str, (g)this.mwO.remove(str));
      }
    }
    this.mwP.clear();
    this.mwO.clear();
    Object localObject3 = this.mwR.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      c(str, (g)this.mwQ.remove(str));
    }
    this.mwR.clear();
    this.mwQ.clear();
    ??? = this.mwS.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (String)((Iterator)???).next();
      localObject3 = (LinkedList)this.mwU.remove(localObject3);
      if (localObject3 != null) {
        ((LinkedList)localObject3).clear();
      }
    }
    this.mwS.clear();
    this.mwT.clear();
    this.mwU.clear();
    this.mwV.clear();
    this.mwW.clear();
    this.mwY.clear();
    this.mwZ.clear();
    ai.S(this.mxi);
    ai.S(this.mxj);
    this.mxa = false;
    this.mxb = false;
  }
  
  public final void bmb()
  {
    long l = System.currentTimeMillis();
    if ((this.mxa) && (l - this.mxc < 10000L)) {
      return;
    }
    this.mxc = l;
    synchronized (this.jtD)
    {
      this.mxa = true;
      y.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(1800000) });
      ai.S(this.mxj);
      ai.l(this.mxj, 1800000L);
      return;
    }
  }
  
  final void bmf()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
    Iterator localIterator = this.mwX.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      y.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[] { str });
      IR(str);
    }
    localIterator = this.mwZ.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      y.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[] { str });
      IR(str);
    }
    this.mwX.clear();
    this.mwZ.clear();
  }
  
  final void bmh()
  {
    if (this.mxf.mxR)
    {
      com.tencent.mm.plugin.music.b.b.a locala = this.mxf;
      y.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
      if (locala.dui != null)
      {
        locala.dui.abandonAudioFocus(locala.mxS);
        locala.mxR = false;
      }
    }
  }
  
  public final String dZ(String paramString1, String paramString2)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
    LinkedList localLinkedList = (LinkedList)this.mwU.get(paramString1);
    Object localObject = this.jtD;
    if (localLinkedList != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (localLinkedList.contains(paramString2))
        {
          if (this.mwP.contains(paramString2)) {
            break label233;
          }
          if (this.mwR.contains(paramString2))
          {
            break label233;
            j = IU(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              break label115;
            }
            y.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            aw(604, paramString2);
            return null;
          }
        }
        i = 0;
        continue;
        if (j < 10) {
          break label150;
        }
      }
      finally {}
      label115:
      y.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[] { Integer.valueOf(j) });
      dY(paramString1, paramString2);
      return null;
      label150:
      if (i != 0)
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
        aw(603, paramString2);
        return null;
      }
      dY(paramString1, paramString2);
      IZ(paramString2);
      localObject = bma();
      ((g)localObject).a(this.mxh);
      ((g)localObject).Jd(paramString2);
      f(paramString2, (g)localObject);
      y.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
      return paramString2;
      label233:
      int i = 1;
    }
  }
  
  final void e(String paramString, g paramg)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[] { paramString });
    synchronized (this.jtD)
    {
      if (this.mwR.contains(paramString))
      {
        this.mwQ.remove(paramString);
        this.mwR.remove(paramString);
      }
      if (!this.mwP.contains(paramString))
      {
        this.mwP.add(paramString);
        this.mwO.put(paramString, paramg);
      }
      return;
    }
  }
  
  final void f(String paramString, g paramg)
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[] { paramString });
    synchronized (this.jtD)
    {
      if (this.mwP.contains(paramString))
      {
        this.mwO.remove(paramString);
        this.mwP.remove(paramString);
      }
      if (!this.mwR.contains(paramString))
      {
        this.mwR.add(paramString);
        this.mwQ.put(paramString, paramg);
      }
      return;
    }
  }
  
  public final com.tencent.mm.af.b jQ(String paramString)
  {
    if (this.mwV.containsKey(paramString)) {
      return (com.tencent.mm.af.b)this.mwV.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e
 * JD-Core Version:    0.7.0.1
 */