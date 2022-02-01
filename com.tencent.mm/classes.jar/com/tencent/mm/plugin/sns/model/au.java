package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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

public final class au
{
  public String sessionId;
  public long zDA;
  public int zDB;
  public boolean zDC;
  public boolean zDD;
  public boolean zDE;
  public com.tencent.mm.plugin.sns.i.j zDF;
  public k zDG;
  public long zDH;
  public long zDI;
  public long zDJ;
  public long zDK;
  public k zDL;
  public k zDM;
  public int zDN;
  public long zDO;
  public at zDP;
  public String zDi;
  public boolean zDj;
  public long zDk;
  public long zDl;
  public int zDm;
  public int zDn;
  public int zDo;
  public int zDp;
  public int zDq;
  public long zDr;
  int zDs;
  public int zDt;
  public Map<Long, Integer> zDu;
  public View zDv;
  public long zDw;
  public List<Long> zDx;
  public boolean zDy;
  public long zDz;
  
  public au()
  {
    AppMethodBeat.i(179099);
    this.zDi = "";
    this.zDj = false;
    this.zDk = 3600L;
    this.zDl = 86400L;
    this.zDm = 5;
    this.zDn = 5;
    this.zDo = 50;
    this.zDp = 30;
    this.zDq = 5;
    this.zDr = 0L;
    this.zDs = 50;
    this.zDt = 0;
    this.zDu = new HashMap();
    this.zDv = null;
    this.zDw = 0L;
    this.zDx = new ArrayList();
    this.zDy = false;
    this.zDz = 0L;
    this.zDA = 0L;
    this.zDB = av.zEc;
    this.zDC = false;
    this.zDD = false;
    this.zDE = false;
    this.zDF = new com.tencent.mm.plugin.sns.i.j();
    this.zDG = null;
    this.zDH = 0L;
    this.zDI = 0L;
    this.zDJ = 0L;
    this.sessionId = "";
    this.zDK = 0L;
    this.zDL = null;
    this.zDM = null;
    this.zDN = 0;
    this.zDO = 0L;
    this.zDP = new at();
    AppMethodBeat.o(179099);
  }
  
  private void dYu()
  {
    AppMethodBeat.i(179106);
    if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED))
    {
      if (this.zDG != null) {
        ae.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.zDG.timestamp), Integer.valueOf(this.zDG.rBG.size()) });
      }
      while (!bu.ht(this.zDF.zHX))
      {
        Iterator localIterator = this.zDF.zHX.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (k)localIterator.next();
          ae.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((k)localObject).timestamp) });
          localObject = ((k)localObject).rBG.iterator();
          while (((Iterator)localObject).hasNext()) {
            ae.i("MicroMsg.SnsUnreadTipManager", "id:%s", new Object[] { (Long)((Iterator)localObject).next() });
          }
        }
        ae.i("MicroMsg.SnsUnreadTipManager", "target:null");
      }
    }
    AppMethodBeat.o(179106);
  }
  
  public final void Aq(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.zDj) && (!bu.ht(this.zDF.zHX)) && (!this.zDD))
    {
      if (bu.ht(this.zDx))
      {
        ae.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.zDx.get(0)).longValue();
      Iterator localIterator1 = this.zDx.iterator();
      while (localIterator1.hasNext()) {
        ae.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
      }
      if ((this.zDH != 0L) && (paramLong == this.zDH))
      {
        this.zDN += 1;
        if ((this.zDO == 0L) && (paramLong == this.zDH)) {
          this.zDO = ch.aDd();
        }
      }
      localIterator1 = this.zDF.zHX.iterator();
      while (localIterator1.hasNext())
      {
        k localk = (k)localIterator1.next();
        if (localk == this.zDG)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = localk.rBG.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          localk.rBG.removeAll(localArrayList);
          if (bu.ht(localk.rBG)) {
            this.zDG = null;
          }
        }
        else
        {
          localk.rBG.removeAll(this.zDx);
          bu.ht(localk.rBG);
        }
      }
      if ((this.zDw != 0L) && (l <= this.zDw))
      {
        ae.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.zDC), Long.valueOf(l), Long.valueOf(this.zDw) });
        this.zDC = true;
        this.zDH = 0L;
        this.zDF.zHY = 0L;
      }
      ae.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.zDF.zHX.size()) });
      dYu();
    }
    AppMethodBeat.o(179109);
  }
  
  final boolean a(k paramk)
  {
    AppMethodBeat.i(179101);
    if ((bu.ht(paramk.rBG)) || (paramk.rBG.size() < this.zDm) || (bu.rZ(paramk.timestamp) > this.zDl) || (bu.rZ(paramk.timestamp) < this.zDk) || (paramk.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final boolean dYp()
  {
    AppMethodBeat.i(179100);
    if ((this.zDG != null) && (!bu.ht(this.zDG.rBG)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void dYq()
  {
    AppMethodBeat.i(179102);
    if (!bu.ht(this.zDF.zHX))
    {
      Iterator localIterator = this.zDF.zHX.iterator();
      label117:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (bu.rZ(localk.timestamp) > this.zDl) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          ae.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(localk.timestamp), Integer.valueOf(localk.rBG.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void dYr()
  {
    AppMethodBeat.i(179103);
    if ((this.zDF.zHY == 0L) || (bu.ht(this.zDF.zHX)))
    {
      this.zDG = null;
      this.zDH = 0L;
      this.zDF.zHY = 0L;
      this.zDw = 0L;
      ae.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.g.yxI.n(1295L, 0L, 0L);
      this.zDM = this.zDG;
      ae.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.zDw), Long.valueOf(this.zDH) });
      AppMethodBeat.o(179103);
      return;
    }
    this.zDG = null;
    int i = this.zDF.zHX.size() - 1;
    label138:
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (k)this.zDF.zHX.get(i);
      if ((!a((k)localObject1)) && (((Long)((k)localObject1).rBG.peek()).longValue() < this.zDF.zHY))
      {
        this.zDG = ((k)localObject1);
        ae.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.zDG.timestamp), Integer.valueOf(this.zDG.rBG.size()) });
      }
    }
    else if (this.zDG != null)
    {
      this.zDH = this.zDF.zHY;
      this.zDw = ((Long)this.zDG.rBG.peek()).longValue();
      if ((this.zDH == 0L) || (this.zDG == null) || (bu.ht(this.zDG.rBG))) {
        break label739;
      }
      localObject3 = ah.dXE();
      String str1 = r.zW(this.zDI);
      String str2 = r.zW(((Long)this.zDG.rBG.peek()).longValue());
      localObject2 = "select snsId from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.ecE();
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.storage.q.aBB(str1)) {
        localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).aBF(str1);
      }
      localObject2 = localObject1;
      if (com.tencent.mm.plugin.sns.storage.q.aBB(str2)) {
        localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).aBE(str2);
      }
      localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.Aec;
      ae.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
      this.zDt = ((com.tencent.mm.plugin.sns.storage.q)localObject3).db.rawQuery((String)localObject1, null).getCount();
      ae.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.zDH), this.zDG.rBG.peek() });
    }
    for (;;)
    {
      ae.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.zDt) });
      if (this.zDG.state == 0)
      {
        localObject1 = this.zDP;
        localObject2 = this.zDG;
        if (localObject2 != null)
        {
          localObject3 = ((k)localObject2).rBG;
          ((at)localObject1).zDg.clear();
          ((at)localObject1).zDg.addAll((Collection)localObject3);
          ((at)localObject1).zDh = ((k)localObject2);
          if (!bu.ht(((at)localObject1).zDg))
          {
            ae.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s]", new Object[] { Long.valueOf(((k)localObject2).timestamp), Integer.valueOf(((k)localObject2).rBG.size()) });
            com.tencent.mm.kernel.g.ajQ().gDv.a(new y(((Long)((at)localObject1).zDg.get(0)).longValue() + 1L, 0L, 2), 0);
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1295L, 0L, this.zDF.zHX.size());
      break;
      i -= 1;
      break label138;
      label739:
      this.zDt = 0;
    }
  }
  
  public final void dYs()
  {
    AppMethodBeat.i(179104);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179095);
        if (au.this.zDF != null)
        {
          p localp = ah.dXE().AG(au.this.zDF.zHY);
          if (localp != null) {
            au.this.zDK = (localp.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179095);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void dYt()
  {
    AppMethodBeat.i(179105);
    if (this.zDj)
    {
      ae.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (bu.ht(this.zDF.zHX))
      {
        ae.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      ae.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.zDF.zHX.size()) });
      Iterator localIterator = this.zDF.zHX.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (k)localIterator.next();
        ae.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((k)localObject).timestamp), Integer.valueOf(((k)localObject).rBG.size()) });
        localObject = ((k)localObject).rBG.iterator();
        while (((Iterator)localObject).hasNext()) {
          ae.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long dYv()
  {
    AppMethodBeat.i(179107);
    if (!dYp())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.zDG.rBG.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void dYw()
  {
    AppMethodBeat.i(179108);
    if (this.zDj)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((c)com.tencent.mm.kernel.g.ab(c.class)).cou();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        ae.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.zDx.clear();
        if (bu.ht(localArrayList)) {
          break;
        }
        this.zDx.addAll(localArrayList);
        if ((this.zDH == 0L) || (this.zDJ != 0L) || (!this.zDx.contains(Long.valueOf(this.zDH)))) {
          break label252;
        }
        this.zDJ = ch.aDd();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(r.azz((String)((Map.Entry)localObject2).getKey())));
          }
        }
        Collections.sort(localArrayList);
        if (bu.ht(localArrayList)) {
          ae.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
        }
      }
      ae.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
    }
    label252:
    AppMethodBeat.o(179108);
  }
  
  public final void dYx()
  {
    if (this.zDG != null) {
      this.zDG.state = 2;
    }
  }
  
  public final void dYy()
  {
    AppMethodBeat.i(179114);
    if (!this.zDj)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l = this.zDK;
    final k localk1 = this.zDL;
    final k localk2 = this.zDM;
    final LinkedList localLinkedList = new LinkedList(this.zDF.zHX);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219356);
        gp localgp;
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
          localgp = com.tencent.mm.plugin.sns.j.e.zKO.zLw;
          localObject1 = new LinkedList(localk1.zHZ);
          ((LinkedList)localObject1).removeAll(localk1.rBG);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (i < localk1.zHZ.size())
          {
            if (i < au.this.zDs * j)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(localk1.zHZ.get(i));
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
              ((List)localObject2).add(localk1.zHZ.get(i));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (i < ((LinkedList)localObject1).size())
          {
            if (i < au.this.zDs * j)
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
                ((StringBuffer)localObject1).append(r.zW(((Long)((Iterator)localObject3).next()).longValue())).append("|");
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
                ((StringBuffer)localObject2).append(r.zW(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (k)((Iterator)localObject3).next();
              if (!au.this.a((k)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (bu.ht(((k)localObject4).rBG))) {
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
            if (!bu.ht(localk2.zHZ))
            {
              localgp.equ = (localk2.zHZ.size() - localk2.zIb);
              localgp.eqt = localk2.zHZ.size();
            }
            if (!bu.ht(localk2.rBG))
            {
              localgp.eqb = ((Long)localk2.zHZ.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = localk2.rBG.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(r.zW(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localgp.eqe = localgp.t("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localgp.eqs = au.this.zDO;
          localgp.dTr = localgp.t("SessionId", au.this.sessionId, true);
          localgp.eqj = localgp.t("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localgp.eqk = k;
          localgp.eql = localgp.t("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localgp.eqm = m;
          localgp.eqn = i;
          localgp.eqo = n;
          localgp.eqp = au.this.zDN;
          localgp.eqa = l;
          localgp.eiF = l;
          localgp.ejU = j;
          localgp.ejV = i1;
          localgp.aLH();
          j += 1;
          break;
          com.tencent.mm.plugin.sns.j.e.zKO.zLw = new gp();
          au.this.zDN = 0;
          au.this.zDO = 0L;
          AppMethodBeat.o(219356);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final void eU(View paramView)
  {
    AppMethodBeat.i(179111);
    this.zDv = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.zDz = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.zDz = 0L;
    AppMethodBeat.o(179111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */