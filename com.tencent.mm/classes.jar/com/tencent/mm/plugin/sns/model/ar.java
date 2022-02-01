package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.sns.j.j;
import com.tencent.mm.plugin.sns.j.k;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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

public final class ar
{
  public String sessionId;
  int wJA;
  public int wJB;
  public Map<Long, Integer> wJC;
  public View wJD;
  public long wJE;
  public List<Long> wJF;
  public boolean wJG;
  public long wJH;
  public long wJI;
  public int wJJ;
  public boolean wJK;
  public boolean wJL;
  public boolean wJM;
  public j wJN;
  public k wJO;
  public long wJP;
  public long wJQ;
  public long wJR;
  public long wJS;
  public k wJT;
  public k wJU;
  public int wJV;
  public long wJW;
  public aq wJX;
  public String wJq;
  public boolean wJr;
  public long wJs;
  public long wJt;
  public int wJu;
  public int wJv;
  public int wJw;
  public int wJx;
  public int wJy;
  public long wJz;
  
  public ar()
  {
    AppMethodBeat.i(179099);
    this.wJq = "";
    this.wJr = false;
    this.wJs = 3600L;
    this.wJt = 86400L;
    this.wJu = 5;
    this.wJv = 5;
    this.wJw = 50;
    this.wJx = 30;
    this.wJy = 5;
    this.wJz = 0L;
    this.wJA = 50;
    this.wJB = 0;
    this.wJC = new HashMap();
    this.wJD = null;
    this.wJE = 0L;
    this.wJF = new ArrayList();
    this.wJG = false;
    this.wJH = 0L;
    this.wJI = 0L;
    this.wJJ = as.wKj;
    this.wJK = false;
    this.wJL = false;
    this.wJM = false;
    this.wJN = new j();
    this.wJO = null;
    this.wJP = 0L;
    this.wJQ = 0L;
    this.wJR = 0L;
    this.sessionId = "";
    this.wJS = 0L;
    this.wJT = null;
    this.wJU = null;
    this.wJV = 0;
    this.wJW = 0L;
    this.wJX = new aq();
    AppMethodBeat.o(179099);
  }
  
  private void duh()
  {
    AppMethodBeat.i(179106);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
    {
      if (this.wJO != null) {
        ad.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.wJO.timestamp), Integer.valueOf(this.wJO.qaM.size()) });
      }
      while (!bt.gL(this.wJN.wOf))
      {
        Iterator localIterator = this.wJN.wOf.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (k)localIterator.next();
          ad.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((k)localObject).timestamp) });
          localObject = ((k)localObject).qaM.iterator();
          while (((Iterator)localObject).hasNext()) {
            ad.i("MicroMsg.SnsUnreadTipManager", "id:%s", new Object[] { (Long)((Iterator)localObject).next() });
          }
        }
        ad.i("MicroMsg.SnsUnreadTipManager", "target:null");
      }
    }
    AppMethodBeat.o(179106);
  }
  
  final boolean a(k paramk)
  {
    AppMethodBeat.i(179101);
    if ((bt.gL(paramk.qaM)) || (paramk.qaM.size() < this.wJu) || (bt.lZ(paramk.timestamp) > this.wJt) || (bt.lZ(paramk.timestamp) < this.wJs) || (paramk.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final boolean duc()
  {
    AppMethodBeat.i(179100);
    if ((this.wJO != null) && (!bt.gL(this.wJO.qaM)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void dud()
  {
    AppMethodBeat.i(179102);
    if (!bt.gL(this.wJN.wOf))
    {
      Iterator localIterator = this.wJN.wOf.iterator();
      label117:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (bt.lZ(localk.timestamp) > this.wJt) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          ad.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(localk.timestamp), Integer.valueOf(localk.qaM.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void due()
  {
    AppMethodBeat.i(179103);
    if ((this.wJN.wOg == 0L) || (bt.gL(this.wJN.wOf)))
    {
      this.wJO = null;
      this.wJP = 0L;
      this.wJN.wOg = 0L;
      this.wJE = 0L;
      ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.h.vKh.m(1295L, 0L, 0L);
      this.wJU = this.wJO;
      ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.wJE), Long.valueOf(this.wJP) });
      AppMethodBeat.o(179103);
      return;
    }
    this.wJO = null;
    int i = this.wJN.wOf.size() - 1;
    label138:
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (k)this.wJN.wOf.get(i);
      if ((!a((k)localObject1)) && (((Long)((k)localObject1).qaM.peek()).longValue() < this.wJN.wOg))
      {
        this.wJO = ((k)localObject1);
        ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.wJO.timestamp), Integer.valueOf(this.wJO.qaM.size()) });
      }
    }
    else if (this.wJO != null)
    {
      this.wJP = this.wJN.wOg;
      this.wJE = ((Long)this.wJO.qaM.peek()).longValue();
      if ((this.wJP == 0L) || (this.wJO == null) || (bt.gL(this.wJO.qaM))) {
        break label739;
      }
      localObject3 = af.dtu();
      String str1 = com.tencent.mm.plugin.sns.data.q.su(this.wJQ);
      String str2 = com.tencent.mm.plugin.sns.data.q.su(((Long)this.wJO.qaM.peek()).longValue());
      localObject2 = "select snsId from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.dyn();
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.storage.q.apU(str1)) {
        localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).apY(str1);
      }
      localObject2 = localObject1;
      if (com.tencent.mm.plugin.sns.storage.q.apU(str2)) {
        localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).apX(str2);
      }
      localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.xiR;
      ad.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
      this.wJB = ((com.tencent.mm.plugin.sns.storage.q)localObject3).db.rawQuery((String)localObject1, null).getCount();
      ad.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.wJP), this.wJO.qaM.peek() });
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.wJB) });
      if (this.wJO.state == 0)
      {
        localObject1 = this.wJX;
        localObject2 = this.wJO;
        if (localObject2 != null)
        {
          localObject3 = ((k)localObject2).qaM;
          ((aq)localObject1).wJn.clear();
          ((aq)localObject1).wJn.addAll((Collection)localObject3);
          ((aq)localObject1).wJo = ((k)localObject2);
          if (!bt.gL(((aq)localObject1).wJn))
          {
            ad.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s]", new Object[] { Long.valueOf(((k)localObject2).timestamp), Integer.valueOf(((k)localObject2).qaM.size()) });
            g.afA().gcy.a(new x(((Long)((aq)localObject1).wJn.get(0)).longValue() + 1L, 0L, 2), 0);
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.m(1295L, 0L, this.wJN.wOf.size());
      break;
      i -= 1;
      break label138;
      label739:
      this.wJB = 0;
    }
  }
  
  public final void duf()
  {
    AppMethodBeat.i(179104);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179095);
        if (ar.this.wJN != null)
        {
          p localp = af.dtu().th(ar.this.wJN.wOg);
          if (localp != null) {
            ar.this.wJS = (localp.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179095);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void dug()
  {
    AppMethodBeat.i(179105);
    if (this.wJr)
    {
      ad.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (bt.gL(this.wJN.wOf))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.wJN.wOf.size()) });
      Iterator localIterator = this.wJN.wOf.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (k)localIterator.next();
        ad.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((k)localObject).timestamp), Integer.valueOf(((k)localObject).qaM.size()) });
        localObject = ((k)localObject).qaM.iterator();
        while (((Iterator)localObject).hasNext()) {
          ad.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long dui()
  {
    AppMethodBeat.i(179107);
    if (!duc())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.wJO.qaM.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void duj()
  {
    AppMethodBeat.i(179108);
    if (this.wJr)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((c)g.ab(c.class)).cbm();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        ad.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.wJF.clear();
        if (bt.gL(localArrayList)) {
          break;
        }
        this.wJF.addAll(localArrayList);
        if ((this.wJP == 0L) || (this.wJR != 0L) || (!this.wJF.contains(Long.valueOf(this.wJP)))) {
          break label252;
        }
        this.wJR = ce.asT();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(com.tencent.mm.plugin.sns.data.q.anR((String)((Map.Entry)localObject2).getKey())));
          }
        }
        Collections.sort(localArrayList);
        if (bt.gL(localArrayList)) {
          ad.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
        }
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
    }
    label252:
    AppMethodBeat.o(179108);
  }
  
  public final void duk()
  {
    if (this.wJO != null) {
      this.wJO.state = 2;
    }
  }
  
  public final void dul()
  {
    AppMethodBeat.i(179114);
    if (!this.wJr)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l = this.wJS;
    final k localk1 = this.wJT;
    final k localk2 = this.wJU;
    final LinkedList localLinkedList = new LinkedList(this.wJN.wOf);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179098);
        dy localdy;
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
        if (localk1 != null)
        {
          localdy = f.wQY.wRE;
          localObject1 = new LinkedList(localk1.wOh);
          ((LinkedList)localObject1).removeAll(localk1.qaM);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (i < localk1.wOh.size())
          {
            if (i < ar.this.wJA * j)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(localk1.wOh.get(i));
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
              ((List)localObject2).add(localk1.wOh.get(i));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (i < ((LinkedList)localObject1).size())
          {
            if (i < ar.this.wJA * j)
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
                ((StringBuffer)localObject1).append(com.tencent.mm.plugin.sns.data.q.su(((Long)((Iterator)localObject3).next()).longValue())).append("|");
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
                ((StringBuffer)localObject2).append(com.tencent.mm.plugin.sns.data.q.su(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (k)((Iterator)localObject3).next();
              if (!ar.this.a((k)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (bt.gL(((k)localObject4).qaM))) {
                  break label949;
                }
                i += 1;
              }
            }
          }
        }
        label949:
        for (;;)
        {
          break label520;
          if (localk2 != null)
          {
            if (!bt.gL(localk2.wOh))
            {
              localdy.dWB = (localk2.wOh.size() - localk2.wOj);
              localdy.dWA = localk2.wOh.size();
            }
            if (!bt.gL(localk2.qaM))
            {
              localdy.dWi = ((Long)localk2.wOh.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = localk2.qaM.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(com.tencent.mm.plugin.sns.data.q.su(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localdy.dWl = localdy.t("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localdy.dWz = ar.this.wJW;
          localdy.dHr = localdy.t("SessionId", ar.this.sessionId, true);
          localdy.dWq = localdy.t("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localdy.dWr = k;
          localdy.dWs = localdy.t("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localdy.dWt = m;
          localdy.dWu = i;
          localdy.dWv = n;
          localdy.dWw = ar.this.wJV;
          localdy.dWh = l;
          localdy.dPH = l;
          localdy.dQP = j;
          localdy.dQQ = i1;
          localdy.aBj();
          j += 1;
          break;
          f.wQY.wRE = new dy();
          ar.this.wJV = 0;
          ar.this.wJW = 0L;
          AppMethodBeat.o(179098);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final void es(View paramView)
  {
    AppMethodBeat.i(179111);
    this.wJD = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.wJH = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.wJH = 0L;
    AppMethodBeat.o(179111);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(179112);
    try
    {
      i.deleteFile(this.wJq);
      AppMethodBeat.o(179112);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(179112);
    }
  }
  
  public final void sQ(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.wJr) && (!bt.gL(this.wJN.wOf)) && (!this.wJL))
    {
      if (bt.gL(this.wJF))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.wJF.get(0)).longValue();
      Iterator localIterator1 = this.wJF.iterator();
      while (localIterator1.hasNext()) {
        ad.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
      }
      if ((this.wJP != 0L) && (paramLong == this.wJP))
      {
        this.wJV += 1;
        if ((this.wJW == 0L) && (paramLong == this.wJP)) {
          this.wJW = ce.asT();
        }
      }
      localIterator1 = this.wJN.wOf.iterator();
      while (localIterator1.hasNext())
      {
        k localk = (k)localIterator1.next();
        if (localk == this.wJO)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = localk.qaM.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          localk.qaM.removeAll(localArrayList);
          if (bt.gL(localk.qaM)) {
            this.wJO = null;
          }
        }
        else
        {
          localk.qaM.removeAll(this.wJF);
          bt.gL(localk.qaM);
        }
      }
      if ((this.wJE != 0L) && (l <= this.wJE))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.wJK), Long.valueOf(l), Long.valueOf(this.wJE) });
        this.wJK = true;
        this.wJP = 0L;
        this.wJN.wOg = 0L;
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.wJN.wOf.size()) });
      duh();
    }
    AppMethodBeat.o(179109);
  }
  
  public final void sR(long paramLong)
  {
    AppMethodBeat.i(179110);
    ad.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(paramLong) });
    if (!bt.gL(this.wJN.wOf))
    {
      Iterator localIterator = this.wJN.wOf.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        localk.qaM.remove(Long.valueOf(paramLong));
        if (bt.gL(localk.qaM))
        {
          localIterator.remove();
          if (localk == this.wJO) {
            this.wJO = null;
          }
        }
      }
    }
    AppMethodBeat.o(179110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */