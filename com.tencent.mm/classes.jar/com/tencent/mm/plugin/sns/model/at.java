package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
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

public final class at
{
  public String sessionId;
  public String zlT;
  public boolean zlU;
  public long zlV;
  public long zlW;
  public int zlX;
  public int zlY;
  public int zlZ;
  public as zmA;
  public int zma;
  public int zmb;
  public long zmc;
  int zmd;
  public int zme;
  public Map<Long, Integer> zmf;
  public View zmg;
  public long zmh;
  public List<Long> zmi;
  public boolean zmj;
  public long zmk;
  public long zml;
  public int zmm;
  public boolean zmn;
  public boolean zmo;
  public boolean zmp;
  public j zmq;
  public k zmr;
  public long zms;
  public long zmt;
  public long zmu;
  public long zmv;
  public k zmw;
  public k zmx;
  public int zmy;
  public long zmz;
  
  public at()
  {
    AppMethodBeat.i(179099);
    this.zlT = "";
    this.zlU = false;
    this.zlV = 3600L;
    this.zlW = 86400L;
    this.zlX = 5;
    this.zlY = 5;
    this.zlZ = 50;
    this.zma = 30;
    this.zmb = 5;
    this.zmc = 0L;
    this.zmd = 50;
    this.zme = 0;
    this.zmf = new HashMap();
    this.zmg = null;
    this.zmh = 0L;
    this.zmi = new ArrayList();
    this.zmj = false;
    this.zmk = 0L;
    this.zml = 0L;
    this.zmm = au.zmN;
    this.zmn = false;
    this.zmo = false;
    this.zmp = false;
    this.zmq = new j();
    this.zmr = null;
    this.zms = 0L;
    this.zmt = 0L;
    this.zmu = 0L;
    this.sessionId = "";
    this.zmv = 0L;
    this.zmw = null;
    this.zmx = null;
    this.zmy = 0;
    this.zmz = 0L;
    this.zmA = new as();
    AppMethodBeat.o(179099);
  }
  
  private void dUU()
  {
    AppMethodBeat.i(179106);
    if ((i.DEBUG) || (i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED))
    {
      if (this.zmr != null) {
        ad.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.zmr.timestamp), Integer.valueOf(this.zmr.rtu.size()) });
      }
      while (!bt.hj(this.zmq.zqI))
      {
        Iterator localIterator = this.zmq.zqI.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (k)localIterator.next();
          ad.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((k)localObject).timestamp) });
          localObject = ((k)localObject).rtu.iterator();
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
    if ((bt.hj(paramk.rtu)) || (paramk.rtu.size() < this.zlX) || (bt.rM(paramk.timestamp) > this.zlW) || (bt.rM(paramk.timestamp) < this.zlV) || (paramk.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final boolean dUP()
  {
    AppMethodBeat.i(179100);
    if ((this.zmr != null) && (!bt.hj(this.zmr.rtu)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void dUQ()
  {
    AppMethodBeat.i(179102);
    if (!bt.hj(this.zmq.zqI))
    {
      Iterator localIterator = this.zmq.zqI.iterator();
      label117:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (bt.rM(localk.timestamp) > this.zlW) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          ad.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(localk.timestamp), Integer.valueOf(localk.rtu.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void dUR()
  {
    AppMethodBeat.i(179103);
    if ((this.zmq.zqJ == 0L) || (bt.hj(this.zmq.zqI)))
    {
      this.zmr = null;
      this.zms = 0L;
      this.zmq.zqJ = 0L;
      this.zmh = 0L;
      ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.g.yhR.n(1295L, 0L, 0L);
      this.zmx = this.zmr;
      ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.zmh), Long.valueOf(this.zms) });
      AppMethodBeat.o(179103);
      return;
    }
    this.zmr = null;
    int i = this.zmq.zqI.size() - 1;
    label138:
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (k)this.zmq.zqI.get(i);
      if ((!a((k)localObject1)) && (((Long)((k)localObject1).rtu.peek()).longValue() < this.zmq.zqJ))
      {
        this.zmr = ((k)localObject1);
        ad.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.zmr.timestamp), Integer.valueOf(this.zmr.rtu.size()) });
      }
    }
    else if (this.zmr != null)
    {
      this.zms = this.zmq.zqJ;
      this.zmh = ((Long)this.zmr.rtu.peek()).longValue();
      if ((this.zms == 0L) || (this.zmr == null) || (bt.hj(this.zmr.rtu))) {
        break label739;
      }
      localObject3 = ag.dUe();
      String str1 = com.tencent.mm.plugin.sns.data.q.zx(this.zmt);
      String str2 = com.tencent.mm.plugin.sns.data.q.zx(((Long)this.zmr.rtu.peek()).longValue());
      localObject2 = "select snsId from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.dYZ();
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.storage.q.aAk(str1)) {
        localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).aAo(str1);
      }
      localObject2 = localObject1;
      if (com.tencent.mm.plugin.sns.storage.q.aAk(str2)) {
        localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).aAn(str2);
      }
      localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.zMV;
      ad.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
      this.zme = ((com.tencent.mm.plugin.sns.storage.q)localObject3).db.rawQuery((String)localObject1, null).getCount();
      ad.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.zms), this.zmr.rtu.peek() });
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.zme) });
      if (this.zmr.state == 0)
      {
        localObject1 = this.zmA;
        localObject2 = this.zmr;
        if (localObject2 != null)
        {
          localObject3 = ((k)localObject2).rtu;
          ((as)localObject1).zlR.clear();
          ((as)localObject1).zlR.addAll((Collection)localObject3);
          ((as)localObject1).zlS = ((k)localObject2);
          if (!bt.hj(((as)localObject1).zlR))
          {
            ad.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s]", new Object[] { Long.valueOf(((k)localObject2).timestamp), Integer.valueOf(((k)localObject2).rtu.size()) });
            com.tencent.mm.kernel.g.ajB().gAO.a(new x(((Long)((as)localObject1).zlR.get(0)).longValue() + 1L, 0L, 2), 0);
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1295L, 0L, this.zmq.zqI.size());
      break;
      i -= 1;
      break label138;
      label739:
      this.zme = 0;
    }
  }
  
  public final void dUS()
  {
    AppMethodBeat.i(179104);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179095);
        if (at.this.zmq != null)
        {
          p localp = ag.dUe().Ai(at.this.zmq.zqJ);
          if (localp != null) {
            at.this.zmv = (localp.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179095);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void dUT()
  {
    AppMethodBeat.i(179105);
    if (this.zlU)
    {
      ad.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (bt.hj(this.zmq.zqI))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.zmq.zqI.size()) });
      Iterator localIterator = this.zmq.zqI.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (k)localIterator.next();
        ad.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((k)localObject).timestamp), Integer.valueOf(((k)localObject).rtu.size()) });
        localObject = ((k)localObject).rtu.iterator();
        while (((Iterator)localObject).hasNext()) {
          ad.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long dUV()
  {
    AppMethodBeat.i(179107);
    if (!dUP())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.zmr.rtu.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void dUW()
  {
    AppMethodBeat.i(179108);
    if (this.zlU)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((c)com.tencent.mm.kernel.g.ab(c.class)).cne();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        ad.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.zmi.clear();
        if (bt.hj(localArrayList)) {
          break;
        }
        this.zmi.addAll(localArrayList);
        if ((this.zms == 0L) || (this.zmu != 0L) || (!this.zmi.contains(Long.valueOf(this.zms)))) {
          break label252;
        }
        this.zmu = cf.aCN();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(com.tencent.mm.plugin.sns.data.q.ayi((String)((Map.Entry)localObject2).getKey())));
          }
        }
        Collections.sort(localArrayList);
        if (bt.hj(localArrayList)) {
          ad.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
        }
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
    }
    label252:
    AppMethodBeat.o(179108);
  }
  
  public final void dUX()
  {
    if (this.zmr != null) {
      this.zmr.state = 2;
    }
  }
  
  public final void dUY()
  {
    AppMethodBeat.i(179114);
    if (!this.zlU)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l = this.zmv;
    final k localk1 = this.zmw;
    final k localk2 = this.zmx;
    final LinkedList localLinkedList = new LinkedList(this.zmq.zqI);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197863);
        gn localgn;
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
          localgn = com.tencent.mm.plugin.sns.j.e.ztz.zuf;
          localObject1 = new LinkedList(localk1.zqK);
          ((LinkedList)localObject1).removeAll(localk1.rtu);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (i < localk1.zqK.size())
          {
            if (i < at.this.zmd * j)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(localk1.zqK.get(i));
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
              ((List)localObject2).add(localk1.zqK.get(i));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (i < ((LinkedList)localObject1).size())
          {
            if (i < at.this.zmd * j)
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
                ((StringBuffer)localObject1).append(com.tencent.mm.plugin.sns.data.q.zx(((Long)((Iterator)localObject3).next()).longValue())).append("|");
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
                ((StringBuffer)localObject2).append(com.tencent.mm.plugin.sns.data.q.zx(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (k)((Iterator)localObject3).next();
              if (!at.this.a((k)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (bt.hj(((k)localObject4).rtu))) {
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
            if (!bt.hj(localk2.zqK))
            {
              localgn.eoN = (localk2.zqK.size() - localk2.zqM);
              localgn.eoM = localk2.zqK.size();
            }
            if (!bt.hj(localk2.rtu))
            {
              localgn.eou = ((Long)localk2.zqK.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = localk2.rtu.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(com.tencent.mm.plugin.sns.data.q.zx(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localgn.eox = localgn.t("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localgn.eoL = at.this.zmz;
          localgn.dSb = localgn.t("SessionId", at.this.sessionId, true);
          localgn.eoC = localgn.t("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localgn.eoD = k;
          localgn.eoE = localgn.t("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localgn.eoF = m;
          localgn.eoG = i;
          localgn.eoH = n;
          localgn.eoI = at.this.zmy;
          localgn.eot = l;
          localgn.egV = l;
          localgn.eik = j;
          localgn.eil = i1;
          localgn.aLk();
          j += 1;
          break;
          com.tencent.mm.plugin.sns.j.e.ztz.zuf = new gn();
          at.this.zmy = 0;
          at.this.zmz = 0L;
          AppMethodBeat.o(197863);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final void eV(View paramView)
  {
    AppMethodBeat.i(179111);
    this.zmg = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.zmk = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.zmk = 0L;
    AppMethodBeat.o(179111);
  }
  
  public final void zS(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.zlU) && (!bt.hj(this.zmq.zqI)) && (!this.zmo))
    {
      if (bt.hj(this.zmi))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.zmi.get(0)).longValue();
      Iterator localIterator1 = this.zmi.iterator();
      while (localIterator1.hasNext()) {
        ad.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
      }
      if ((this.zms != 0L) && (paramLong == this.zms))
      {
        this.zmy += 1;
        if ((this.zmz == 0L) && (paramLong == this.zms)) {
          this.zmz = cf.aCN();
        }
      }
      localIterator1 = this.zmq.zqI.iterator();
      while (localIterator1.hasNext())
      {
        k localk = (k)localIterator1.next();
        if (localk == this.zmr)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = localk.rtu.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          localk.rtu.removeAll(localArrayList);
          if (bt.hj(localk.rtu)) {
            this.zmr = null;
          }
        }
        else
        {
          localk.rtu.removeAll(this.zmi);
          bt.hj(localk.rtu);
        }
      }
      if ((this.zmh != 0L) && (l <= this.zmh))
      {
        ad.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.zmn), Long.valueOf(l), Long.valueOf(this.zmh) });
        this.zmn = true;
        this.zms = 0L;
        this.zmq.zqJ = 0L;
      }
      ad.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.zmq.zqI.size()) });
      dUU();
    }
    AppMethodBeat.o(179109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */