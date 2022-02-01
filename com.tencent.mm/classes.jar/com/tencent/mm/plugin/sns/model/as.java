package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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

public final class as
{
  public String sessionId;
  public String xVV;
  public boolean xVW;
  public long xVX;
  public long xVY;
  public int xVZ;
  public int xWA;
  public long xWB;
  public ar xWC;
  public int xWa;
  public int xWb;
  public int xWc;
  public int xWd;
  public long xWe;
  int xWf;
  public int xWg;
  public Map<Long, Integer> xWh;
  public View xWi;
  public long xWj;
  public List<Long> xWk;
  public boolean xWl;
  public long xWm;
  public long xWn;
  public int xWo;
  public boolean xWp;
  public boolean xWq;
  public boolean xWr;
  public j xWs;
  public k xWt;
  public long xWu;
  public long xWv;
  public long xWw;
  public long xWx;
  public k xWy;
  public k xWz;
  
  public as()
  {
    AppMethodBeat.i(179099);
    this.xVV = "";
    this.xVW = false;
    this.xVX = 3600L;
    this.xVY = 86400L;
    this.xVZ = 5;
    this.xWa = 5;
    this.xWb = 50;
    this.xWc = 30;
    this.xWd = 5;
    this.xWe = 0L;
    this.xWf = 50;
    this.xWg = 0;
    this.xWh = new HashMap();
    this.xWi = null;
    this.xWj = 0L;
    this.xWk = new ArrayList();
    this.xWl = false;
    this.xWm = 0L;
    this.xWn = 0L;
    this.xWo = at.xWO;
    this.xWp = false;
    this.xWq = false;
    this.xWr = false;
    this.xWs = new j();
    this.xWt = null;
    this.xWu = 0L;
    this.xWv = 0L;
    this.xWw = 0L;
    this.sessionId = "";
    this.xWx = 0L;
    this.xWy = null;
    this.xWz = null;
    this.xWA = 0;
    this.xWB = 0L;
    this.xWC = new ar();
    AppMethodBeat.o(179099);
  }
  
  private void dIH()
  {
    AppMethodBeat.i(179106);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
    {
      if (this.xWt != null) {
        ac.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.xWt.timestamp), Integer.valueOf(this.xWt.qJs.size()) });
      }
      while (!bs.gY(this.xWs.yaM))
      {
        Iterator localIterator = this.xWs.yaM.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (k)localIterator.next();
          ac.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((k)localObject).timestamp) });
          localObject = ((k)localObject).qJs.iterator();
          while (((Iterator)localObject).hasNext()) {
            ac.i("MicroMsg.SnsUnreadTipManager", "id:%s", new Object[] { (Long)((Iterator)localObject).next() });
          }
        }
        ac.i("MicroMsg.SnsUnreadTipManager", "target:null");
      }
    }
    AppMethodBeat.o(179106);
  }
  
  final boolean a(k paramk)
  {
    AppMethodBeat.i(179101);
    if ((bs.gY(paramk.qJs)) || (paramk.qJs.size() < this.xVZ) || (bs.pN(paramk.timestamp) > this.xVY) || (bs.pN(paramk.timestamp) < this.xVX) || (paramk.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final boolean dIC()
  {
    AppMethodBeat.i(179100);
    if ((this.xWt != null) && (!bs.gY(this.xWt.qJs)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void dID()
  {
    AppMethodBeat.i(179102);
    if (!bs.gY(this.xWs.yaM))
    {
      Iterator localIterator = this.xWs.yaM.iterator();
      label117:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (bs.pN(localk.timestamp) > this.xVY) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          ac.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(localk.timestamp), Integer.valueOf(localk.qJs.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void dIE()
  {
    AppMethodBeat.i(179103);
    if ((this.xWs.yaN == 0L) || (bs.gY(this.xWs.yaM)))
    {
      this.xWt = null;
      this.xWu = 0L;
      this.xWs.yaN = 0L;
      this.xWj = 0L;
      ac.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.h.wUl.n(1295L, 0L, 0L);
      this.xWz = this.xWt;
      ac.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.xWj), Long.valueOf(this.xWu) });
      AppMethodBeat.o(179103);
      return;
    }
    this.xWt = null;
    int i = this.xWs.yaM.size() - 1;
    label138:
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (k)this.xWs.yaM.get(i);
      if ((!a((k)localObject1)) && (((Long)((k)localObject1).qJs.peek()).longValue() < this.xWs.yaN))
      {
        this.xWt = ((k)localObject1);
        ac.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.xWt.timestamp), Integer.valueOf(this.xWt.qJs.size()) });
      }
    }
    else if (this.xWt != null)
    {
      this.xWu = this.xWs.yaN;
      this.xWj = ((Long)this.xWt.qJs.peek()).longValue();
      if ((this.xWu == 0L) || (this.xWt == null) || (bs.gY(this.xWt.qJs))) {
        break label739;
      }
      localObject3 = af.dHR();
      String str1 = com.tencent.mm.plugin.sns.data.q.wX(this.xWv);
      String str2 = com.tencent.mm.plugin.sns.data.q.wX(((Long)this.xWt.qJs.peek()).longValue());
      localObject2 = "select snsId from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.dMK();
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.storage.q.avd(str1)) {
        localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).avh(str1);
      }
      localObject2 = localObject1;
      if (com.tencent.mm.plugin.sns.storage.q.avd(str2)) {
        localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject3).avg(str2);
      }
      localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.yvI;
      ac.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
      this.xWg = ((com.tencent.mm.plugin.sns.storage.q)localObject3).db.rawQuery((String)localObject1, null).getCount();
      ac.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.xWu), this.xWt.qJs.peek() });
    }
    for (;;)
    {
      ac.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.xWg) });
      if (this.xWt.state == 0)
      {
        localObject1 = this.xWC;
        localObject2 = this.xWt;
        if (localObject2 != null)
        {
          localObject3 = ((k)localObject2).qJs;
          ((ar)localObject1).xVT.clear();
          ((ar)localObject1).xVT.addAll((Collection)localObject3);
          ((ar)localObject1).xVU = ((k)localObject2);
          if (!bs.gY(((ar)localObject1).xVT))
          {
            ac.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s]", new Object[] { Long.valueOf(((k)localObject2).timestamp), Integer.valueOf(((k)localObject2).qJs.size()) });
            g.agQ().ghe.a(new x(((Long)((ar)localObject1).xVT.get(0)).longValue() + 1L, 0L, 2), 0);
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.n(1295L, 0L, this.xWs.yaM.size());
      break;
      i -= 1;
      break label138;
      label739:
      this.xWg = 0;
    }
  }
  
  public final void dIF()
  {
    AppMethodBeat.i(179104);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179095);
        if (as.this.xWs != null)
        {
          p localp = af.dHR().xK(as.this.xWs.yaN);
          if (localp != null) {
            as.this.xWx = (localp.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179095);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void dIG()
  {
    AppMethodBeat.i(179105);
    if (this.xVW)
    {
      ac.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (bs.gY(this.xWs.yaM))
      {
        ac.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      ac.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.xWs.yaM.size()) });
      Iterator localIterator = this.xWs.yaM.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (k)localIterator.next();
        ac.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((k)localObject).timestamp), Integer.valueOf(((k)localObject).qJs.size()) });
        localObject = ((k)localObject).qJs.iterator();
        while (((Iterator)localObject).hasNext()) {
          ac.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long dII()
  {
    AppMethodBeat.i(179107);
    if (!dIC())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.xWt.qJs.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void dIJ()
  {
    AppMethodBeat.i(179108);
    if (this.xVW)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((c)g.ab(c.class)).civ();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        ac.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.xWk.clear();
        if (bs.gY(localArrayList)) {
          break;
        }
        this.xWk.addAll(localArrayList);
        if ((this.xWu == 0L) || (this.xWw != 0L) || (!this.xWk.contains(Long.valueOf(this.xWu)))) {
          break label252;
        }
        this.xWw = ce.azK();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(com.tencent.mm.plugin.sns.data.q.atd((String)((Map.Entry)localObject2).getKey())));
          }
        }
        Collections.sort(localArrayList);
        if (bs.gY(localArrayList)) {
          ac.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
        }
      }
      ac.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
    }
    label252:
    AppMethodBeat.o(179108);
  }
  
  public final void dIK()
  {
    if (this.xWt != null) {
      this.xWt.state = 2;
    }
  }
  
  public final void dIL()
  {
    AppMethodBeat.i(179114);
    if (!this.xVW)
    {
      AppMethodBeat.o(179114);
      return;
    }
    long l = this.xWx;
    k localk1 = this.xWy;
    k localk2 = this.xWz;
    LinkedList localLinkedList = new LinkedList(this.xWs.yaM);
    af.dvq().post(new as.5(this, localk1, localLinkedList, localk2, l));
    AppMethodBeat.o(179114);
  }
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(179111);
    this.xWi = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.xWm = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.xWm = 0L;
    AppMethodBeat.o(179111);
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(179112);
    try
    {
      i.deleteFile(this.xVV);
      AppMethodBeat.o(179112);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(179112);
    }
  }
  
  public final void xt(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.xVW) && (!bs.gY(this.xWs.yaM)) && (!this.xWq))
    {
      if (bs.gY(this.xWk))
      {
        ac.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.xWk.get(0)).longValue();
      Iterator localIterator1 = this.xWk.iterator();
      while (localIterator1.hasNext()) {
        ac.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
      }
      if ((this.xWu != 0L) && (paramLong == this.xWu))
      {
        this.xWA += 1;
        if ((this.xWB == 0L) && (paramLong == this.xWu)) {
          this.xWB = ce.azK();
        }
      }
      localIterator1 = this.xWs.yaM.iterator();
      while (localIterator1.hasNext())
      {
        k localk = (k)localIterator1.next();
        if (localk == this.xWt)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = localk.qJs.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          localk.qJs.removeAll(localArrayList);
          if (bs.gY(localk.qJs)) {
            this.xWt = null;
          }
        }
        else
        {
          localk.qJs.removeAll(this.xWk);
          bs.gY(localk.qJs);
        }
      }
      if ((this.xWj != 0L) && (l <= this.xWj))
      {
        ac.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.xWp), Long.valueOf(l), Long.valueOf(this.xWj) });
        this.xWp = true;
        this.xWu = 0L;
        this.xWs.yaN = 0L;
      }
      ac.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.xWs.yaM.size()) });
      dIH();
    }
    AppMethodBeat.o(179109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */