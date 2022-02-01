package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.mu;
import com.tencent.mm.f.b.a.mv;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.j.k;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class av
{
  public static a KaZ;
  public Map<Long, Integer> KaA;
  public View KaB;
  public long KaC;
  public List<Long> KaD;
  public boolean KaE;
  public long KaF;
  public long KaG;
  public int KaH;
  public boolean KaI;
  public boolean KaJ;
  public boolean KaK;
  public k KaL;
  public l KaM;
  public l KaN;
  public long KaO;
  public long KaP;
  public long KaQ;
  public long KaR;
  public l KaS;
  public l KaT;
  public int KaU;
  public long KaV;
  public au KaW;
  public LinkedList<String> KaX;
  private final i KaY;
  public String Kao;
  public boolean Kap;
  public long Kaq;
  public long Kar;
  public int Kas;
  public int Kat;
  public int Kau;
  public int Kav;
  public int Kaw;
  public long Kax;
  int Kay;
  public int Kaz;
  public String sessionId;
  
  public av()
  {
    AppMethodBeat.i(179099);
    this.Kao = "";
    this.Kap = false;
    this.Kaq = 3600L;
    this.Kar = 86400L;
    this.Kas = 5;
    this.Kat = 5;
    this.Kau = 50;
    this.Kav = 30;
    this.Kaw = 5;
    this.Kax = 0L;
    this.Kay = 50;
    this.Kaz = 0;
    this.KaA = new HashMap();
    this.KaB = null;
    this.KaC = 0L;
    this.KaD = new ArrayList();
    this.KaE = false;
    this.KaF = 0L;
    this.KaG = 0L;
    this.KaH = aw.Kbl;
    this.KaI = false;
    this.KaJ = false;
    this.KaK = false;
    this.KaL = new k();
    this.KaM = null;
    this.KaN = null;
    this.KaO = 0L;
    this.KaP = 0L;
    this.KaQ = 0L;
    this.sessionId = "";
    this.KaR = 0L;
    this.KaS = null;
    this.KaT = null;
    this.KaU = 0;
    this.KaV = 0L;
    this.KaW = new au();
    this.KaX = new LinkedList();
    this.KaY = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(268660);
        if (paramAnonymousq.getType() == 5987)
        {
          com.tencent.mm.kernel.h.aHF().kcd.b(5987, this);
          Object localObject = ((n)paramAnonymousq).JVd;
          paramAnonymousString = new StringBuilder();
          av.this.KaX = new LinkedList();
          if ((localObject != null) && (!Util.isNullOrNil(((kj)localObject).RPI)))
          {
            paramAnonymousq = new LinkedList();
            localObject = ((kj)localObject).RPI.iterator();
            do
            {
              SnsObject localSnsObject;
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localSnsObject = (SnsObject)((Iterator)localObject).next();
                paramAnonymousString.append(localSnsObject.Username).append(",");
              } while (av.this.KaX.contains(localSnsObject.Username));
              paramAnonymousString.append("**,");
              av.this.KaX.add(localSnsObject.Username);
              paramAnonymousq.add(Long.valueOf(localSnsObject.Id));
            } while (av.this.KaX.size() < 3);
            if (av.this.KaT != null)
            {
              av.this.KaT.Kfl = paramAnonymousq;
              av.this.KaT.lBi = av.this.KaX;
            }
          }
          if ((!Util.isNullOrNil(av.this.KaX)) && (av.KaZ != null)) {
            av.KaZ.bK(av.this.KaX);
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "onBatchObjectDetailSceneEnd getAvatar, avatar:%s, size:%s", new Object[] { paramAnonymousString.toString(), Integer.valueOf(av.this.KaX.size()) });
        }
        AppMethodBeat.o(268660);
      }
    };
    AppMethodBeat.o(179099);
  }
  
  private void fPB()
  {
    AppMethodBeat.i(179106);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      if (this.KaM != null) {
        Log.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.KaM.timestamp), Integer.valueOf(this.KaM.wHq.size()) });
      }
      while (!Util.isNullOrNil(this.KaL.Kff))
      {
        Iterator localIterator = this.KaL.Kff.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (l)localIterator.next();
          Log.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((l)localObject).timestamp) });
          localObject = ((l)localObject).wHq.iterator();
          while (((Iterator)localObject).hasNext()) {
            Log.i("MicroMsg.SnsUnreadTipManager", "id:%s", new Object[] { (Long)((Iterator)localObject).next() });
          }
        }
        Log.i("MicroMsg.SnsUnreadTipManager", "target:null");
      }
    }
    AppMethodBeat.o(179106);
  }
  
  public final void QP(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.Kap) && (!Util.isNullOrNil(this.KaL.Kff)) && (!this.KaJ))
    {
      if (Util.isNullOrNil(this.KaD))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.KaD.get(0)).longValue();
      if (Log.getLogLevel() <= 1)
      {
        localIterator1 = this.KaD.iterator();
        while (localIterator1.hasNext()) {
          Log.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
        }
      }
      if ((this.KaO != 0L) && (paramLong == this.KaO))
      {
        this.KaU += 1;
        if ((this.KaV == 0L) && (paramLong == this.KaO)) {
          this.KaV = cm.bfF();
        }
      }
      Iterator localIterator1 = this.KaL.Kff.iterator();
      while (localIterator1.hasNext())
      {
        l locall = (l)localIterator1.next();
        if (locall == this.KaM)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = locall.wHq.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          locall.wHq.removeAll(localArrayList);
          if (Util.isNullOrNil(locall.wHq)) {
            this.KaM = null;
          }
        }
        else
        {
          locall.wHq.removeAll(this.KaD);
          Util.isNullOrNil(locall.wHq);
        }
      }
      if ((this.KaC != 0L) && (l <= this.KaC))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.KaI), Long.valueOf(l), Long.valueOf(this.KaC) });
        this.KaI = true;
        this.KaO = 0L;
        this.KaL.Kfg = 0L;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.KaL.Kff.size()) });
      fPB();
    }
    AppMethodBeat.o(179109);
  }
  
  public final void QQ(long paramLong)
  {
    AppMethodBeat.i(179110);
    Log.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(paramLong) });
    if (!Util.isNullOrNil(this.KaL.Kff))
    {
      Iterator localIterator = this.KaL.Kff.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        locall.wHq.remove(Long.valueOf(paramLong));
        if (Util.isNullOrNil(locall.wHq))
        {
          localIterator.remove();
          if (locall == this.KaM) {
            this.KaM = null;
          }
        }
      }
    }
    AppMethodBeat.o(179110);
  }
  
  final boolean a(l paraml)
  {
    AppMethodBeat.i(179101);
    if ((Util.isNullOrNil(paraml.wHq)) || (paraml.wHq.size() < this.Kas) || (Util.secondsToNow(paraml.timestamp) > this.Kar) || (Util.secondsToNow(paraml.timestamp) < this.Kaq) || (paraml.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final void fPA()
  {
    AppMethodBeat.i(179105);
    if (this.Kap)
    {
      Log.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (Util.isNullOrNil(this.KaL.Kff))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.KaL.Kff.size()) });
      Iterator localIterator = this.KaL.Kff.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (l)localIterator.next();
        Log.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((l)localObject).timestamp), Integer.valueOf(((l)localObject).wHq.size()) });
        localObject = ((l)localObject).wHq.iterator();
        while (((Iterator)localObject).hasNext()) {
          Log.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long fPC()
  {
    AppMethodBeat.i(179107);
    if (!fPw())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.KaM.wHq.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void fPD()
  {
    AppMethodBeat.i(179108);
    if (this.Kap)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbt();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        Log.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.KaD.clear();
        if (Util.isNullOrNil(localArrayList)) {
          break;
        }
        this.KaD.addAll(localArrayList);
        if ((this.KaO == 0L) || (this.KaQ != 0L) || (!this.KaD.contains(Long.valueOf(this.KaO)))) {
          break label252;
        }
        this.KaQ = cm.bfF();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(com.tencent.mm.plugin.sns.data.t.aZs((String)((Map.Entry)localObject2).getKey())));
          }
        }
        Collections.sort(localArrayList);
        if (Util.isNullOrNil(localArrayList)) {
          Log.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
        }
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
    }
    label252:
    AppMethodBeat.o(179108);
  }
  
  public final void fPE()
  {
    if (this.KaM != null) {
      this.KaM.state = 2;
    }
  }
  
  public final void fPF()
  {
    AppMethodBeat.i(179114);
    if (!this.Kap)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l = this.KaR;
    final l locall1 = this.KaS;
    final l locall2 = this.KaT;
    final LinkedList localLinkedList = new LinkedList(this.KaL.Kff);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220353);
        mv localmv;
        Object localObject1;
        int j;
        int i;
        Object localObject2;
        int k;
        int i1;
        long l;
        int m;
        Object localObject3;
        int n;
        label520:
        Object localObject4;
        if (locall1 != null)
        {
          localmv = g.Kia.KiI;
          localObject1 = new LinkedList(locall1.Kfh);
          ((LinkedList)localObject1).removeAll(locall1.wHq);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (i < locall1.Kfh.size())
          {
            if (i < av.this.Kay * j)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(locall1.Kfh.get(i));
                k = j;
              }
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              k = j + 1;
              localObject2 = new ArrayList();
              ((List)localObject2).add(locall1.Kfh.get(i));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (i < ((LinkedList)localObject1).size())
          {
            if (i < av.this.Kay * j)
            {
              localObject2 = (List)localLinkedList2.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(((LinkedList)localObject1).get(i));
                k = j;
              }
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              k = j + 1;
              localObject2 = new ArrayList();
              ((List)localObject2).add(((LinkedList)localObject1).get(i));
              localLinkedList2.add(localObject2);
            }
          }
          i1 = Math.max(localLinkedList2.size(), localLinkedList1.size());
          l = System.currentTimeMillis();
          j = 0;
          if (j < i1)
          {
            localObject1 = new StringBuffer();
            localObject2 = new StringBuffer();
            m = 0;
            if (j < localLinkedList1.size())
            {
              localObject3 = (List)localLinkedList1.get(j);
              i = ((List)localObject3).size();
              localObject3 = ((List)localObject3).iterator();
              for (;;)
              {
                k = i;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                ((StringBuffer)localObject1).append(com.tencent.mm.plugin.sns.data.t.Qv(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            k = 0;
            if (j < localLinkedList2.size())
            {
              localObject3 = (List)localLinkedList2.get(j);
              i = ((List)localObject3).size();
              localObject3 = ((List)localObject3).iterator();
              for (;;)
              {
                m = i;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                ((StringBuffer)localObject2).append(com.tencent.mm.plugin.sns.data.t.Qv(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (l)((Iterator)localObject3).next();
              if (!av.this.a((l)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (Util.isNullOrNil(((l)localObject4).wHq))) {
                  break label1127;
                }
                i += 1;
              }
            }
          }
        }
        label1127:
        for (;;)
        {
          break label520;
          if (locall2 != null)
          {
            if (!Util.isNullOrNil(locall2.Kfh))
            {
              localmv.gWl = (locall2.Kfh.size() - locall2.Kfj);
              localmv.gWk = locall2.Kfh.size();
            }
            if (!Util.isNullOrNil(locall2.wHq))
            {
              localmv.gVS = ((Long)locall2.Kfh.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = locall2.wHq.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(com.tencent.mm.plugin.sns.data.t.Qv(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localmv.gVV = localmv.z("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
            if ((!Util.isNullOrNil(locall2.lBi)) && (!Util.isNullOrNil(locall2.Kfl)))
            {
              localObject3 = new StringBuffer();
              localObject4 = locall2.lBi.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append((String)((Iterator)localObject4).next()).append("#");
              }
              localmv.gWq = localmv.z("AvatarList", ((StringBuffer)localObject3).toString(), true);
              localObject3 = new StringBuffer();
              localObject4 = locall2.Kfl.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(com.tencent.mm.plugin.sns.data.t.Qv(((Long)((Iterator)localObject4).next()).longValue())).append("#");
              }
              localmv.gWr = localmv.z("IdList", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localmv.gWj = av.this.KaV;
          localmv.gcU = localmv.z("SessionId", av.this.sessionId, true);
          localmv.gWa = localmv.z("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localmv.gWb = k;
          localmv.gWc = localmv.z("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localmv.gWd = m;
          localmv.gWe = i;
          localmv.gWf = n;
          localmv.gWg = av.this.KaU;
          localmv.gVR = l;
          localmv.gKH = l;
          localmv.gMK = j;
          localmv.gML = i1;
          localmv.bpa();
          j += 1;
          break;
          g.Kia.KiI = new mv();
          av.this.KaU = 0;
          av.this.KaV = 0L;
          AppMethodBeat.o(220353);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final boolean fPw()
  {
    AppMethodBeat.i(179100);
    if ((this.KaM != null) && (!Util.isNullOrNil(this.KaM.wHq)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void fPx()
  {
    AppMethodBeat.i(179102);
    if (!Util.isNullOrNil(this.KaL.Kff))
    {
      Iterator localIterator = this.KaL.Kff.iterator();
      label117:
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (Util.secondsToNow(locall.timestamp) > this.Kar) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(locall.timestamp), Integer.valueOf(locall.wHq.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void fPy()
  {
    AppMethodBeat.i(179103);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.KaL.Kfg == 0L) || (Util.isNullOrNil(this.KaL.Kff)))
    {
      this.KaM = null;
      this.KaO = 0L;
      this.KaL.Kfg = 0L;
      this.KaC = 0L;
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.h.IzE.p(1295L, 0L, 0L);
      localObject1 = this.KaN;
      localObject2 = this.KaM;
      if (localObject1 == localObject2) {
        break label1169;
      }
      if (((localObject1 == null) || (localObject2 != null)) && ((localObject1 != null) || (localObject2 == null))) {
        break label1005;
      }
      i = 0;
    }
    label1169:
    for (;;)
    {
      if ((this.KaM != null) && (!Util.isNullOrNil(this.KaM.wHq)) && ((Util.isNullOrNil(this.KaX)) || (i == 0)))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem getAvatar, targetsize:%s", new Object[] { Integer.valueOf(this.KaM.wHq.size()) });
        this.KaX = new LinkedList();
        com.tencent.mm.kernel.h.aHF().kcd.a(5987, this.KaY);
        com.tencent.mm.kernel.h.aHF().kcd.a(new n(this.KaM.wHq), 0);
      }
      if (i == 0)
      {
        this.KaN = this.KaM;
        this.KaT = this.KaM;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.KaC), Long.valueOf(this.KaO) });
      AppMethodBeat.o(179103);
      return;
      this.KaM = null;
      i = this.KaL.Kff.size() - 1;
      label301:
      boolean bool;
      label330:
      Object localObject3;
      if (i >= 0)
      {
        localObject1 = (l)this.KaL.Kff.get(i);
        if (!a((l)localObject1))
        {
          bool = true;
          Log.d("MicroMsg.SnsUnreadTipManager", "findTargetItem isValid:%s, item.idList.peek():%s, unreadSnsIdList.lastSnsId:%s", new Object[] { Boolean.valueOf(bool), ((l)localObject1).wHq.peek(), Long.valueOf(this.KaL.Kfg) });
          if ((a((l)localObject1)) || (((Long)((l)localObject1).wHq.peek()).longValue() >= this.KaL.Kfg)) {
            break label990;
          }
          this.KaM = ((l)localObject1);
          Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.KaM.timestamp), Integer.valueOf(this.KaM.wHq.size()) });
        }
      }
      else if (this.KaM != null)
      {
        this.KaO = this.KaL.Kfg;
        this.KaC = ((Long)this.KaM.wHq.peek()).longValue();
        if ((this.KaO == 0L) || (this.KaM == null) || (Util.isNullOrNil(this.KaM.wHq))) {
          break label997;
        }
        localObject3 = aj.fOI();
        String str1 = com.tencent.mm.plugin.sns.data.t.Qv(this.KaP);
        String str2 = com.tencent.mm.plugin.sns.data.t.Qv(((Long)this.KaM.wHq.peek()).longValue());
        localObject2 = "select snsId from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.n.fSJ();
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.storage.n.bbw(str1)) {
          localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).bbA(str1);
        }
        localObject2 = localObject1;
        if (com.tencent.mm.plugin.sns.storage.n.bbw(str2)) {
          localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).bbz(str2);
        }
        localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.n.KzD;
        Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
        this.Kaz = ((com.tencent.mm.plugin.sns.storage.n)localObject3).lvy.rawQuery((String)localObject1, null).getCount();
        Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.KaO), this.KaM.wHq.peek() });
      }
      for (;;)
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.Kaz) });
        if (this.KaM.state == 0)
        {
          localObject1 = this.KaW;
          localObject2 = this.KaM;
          if (localObject2 != null)
          {
            localObject3 = ((l)localObject2).wHq;
            ((au)localObject1).Kal.clear();
            ((au)localObject1).Kal.addAll((Collection)localObject3);
            ((au)localObject1).Kam = ((l)localObject2);
            if (!Util.isNullOrNil(((au)localObject1).Kal))
            {
              Log.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s], preloadCount:%s, unreadItem:%s", new Object[] { Long.valueOf(((l)localObject2).timestamp), Integer.valueOf(((l)localObject2).wHq.size()), Integer.valueOf(((l)localObject2).Kfk), localObject2 });
              ((l)localObject2).Kfk += 1;
              com.tencent.mm.kernel.h.aHF().kcd.a(new z(((Long)((au)localObject1).Kal.get(0)).longValue() + 1L, 0L, 2), 0);
            }
          }
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(1295L, 0L, this.KaL.Kff.size());
        break;
        bool = false;
        break label330;
        label990:
        i -= 1;
        break label301;
        label997:
        this.Kaz = 0;
      }
      label1005:
      if ((((l)localObject1).timestamp != ((l)localObject2).timestamp) || (((l)localObject1).state != ((l)localObject2).state) || (((l)localObject1).Kfj != ((l)localObject2).Kfj) || (((l)localObject1).Kfi != ((l)localObject2).Kfi) || (((l)localObject1).Kfk != ((l)localObject2).Kfk))
      {
        i = 0;
      }
      else
      {
        if ((((l)localObject1).Kfh != null) || (((l)localObject2).Kfh != null))
        {
          if ((((l)localObject1).Kfh != null) && (((l)localObject2).Kfh != null) && (((l)localObject1).Kfh.size() == ((l)localObject2).Kfh.size())) {
            i = 0;
          }
          for (;;)
          {
            if (i < ((l)localObject1).Kfh.size())
            {
              if (((l)localObject1).Kfh.get(i) != ((l)localObject2).Kfh.get(i))
              {
                i = 0;
                break;
              }
              i += 1;
              continue;
              i = 0;
              break;
            }
          }
        }
        i = 1;
      }
    }
  }
  
  public final void fPz()
  {
    AppMethodBeat.i(179104);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179096);
        if (av.this.KaL != null)
        {
          SnsInfo localSnsInfo = aj.fOI().Rd(av.this.KaL.Kfg);
          if (localSnsInfo != null) {
            av.this.KaR = (localSnsInfo.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179096);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void gq(View paramView)
  {
    AppMethodBeat.i(179111);
    this.KaB = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.KaF = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.KaF = 0L;
    AppMethodBeat.o(179111);
  }
  
  public static abstract interface a
  {
    public abstract void bK(LinkedList<String> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */