package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.kc;
import com.tencent.mm.g.b.a.kd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.k;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
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

public final class aw
{
  public long DNA;
  public List<Long> DNB;
  public boolean DNC;
  public long DND;
  public long DNE;
  public int DNF;
  public boolean DNG;
  public boolean DNH;
  public boolean DNI;
  public k DNJ;
  public l DNK;
  public long DNL;
  public long DNM;
  public long DNN;
  public long DNO;
  public l DNP;
  public l DNQ;
  public int DNR;
  public long DNS;
  public av DNT;
  public String DNm;
  public boolean DNn;
  public long DNo;
  public long DNp;
  public int DNq;
  public int DNr;
  public int DNs;
  public int DNt;
  public int DNu;
  public long DNv;
  int DNw;
  public int DNx;
  public Map<Long, Integer> DNy;
  public View DNz;
  public String sessionId;
  
  public aw()
  {
    AppMethodBeat.i(179099);
    this.DNm = "";
    this.DNn = false;
    this.DNo = 3600L;
    this.DNp = 86400L;
    this.DNq = 5;
    this.DNr = 5;
    this.DNs = 50;
    this.DNt = 30;
    this.DNu = 5;
    this.DNv = 0L;
    this.DNw = 50;
    this.DNx = 0;
    this.DNy = new HashMap();
    this.DNz = null;
    this.DNA = 0L;
    this.DNB = new ArrayList();
    this.DNC = false;
    this.DND = 0L;
    this.DNE = 0L;
    this.DNF = ax.DOf;
    this.DNG = false;
    this.DNH = false;
    this.DNI = false;
    this.DNJ = new k();
    this.DNK = null;
    this.DNL = 0L;
    this.DNM = 0L;
    this.DNN = 0L;
    this.sessionId = "";
    this.DNO = 0L;
    this.DNP = null;
    this.DNQ = null;
    this.DNR = 0;
    this.DNS = 0L;
    this.DNT = new av();
    AppMethodBeat.o(179099);
  }
  
  private void fbI()
  {
    AppMethodBeat.i(179106);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      if (this.DNK != null) {
        Log.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.DNK.timestamp), Integer.valueOf(this.DNK.tbl.size()) });
      }
      while (!Util.isNullOrNil(this.DNJ.DRY))
      {
        Iterator localIterator = this.DNJ.DRY.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (l)localIterator.next();
          Log.i("MicroMsg.SnsUnreadTipManager", "item:%s", new Object[] { Long.valueOf(((l)localObject).timestamp) });
          localObject = ((l)localObject).tbl.iterator();
          while (((Iterator)localObject).hasNext()) {
            Log.i("MicroMsg.SnsUnreadTipManager", "id:%s", new Object[] { (Long)((Iterator)localObject).next() });
          }
        }
        Log.i("MicroMsg.SnsUnreadTipManager", "target:null");
      }
    }
    AppMethodBeat.o(179106);
  }
  
  public final void Jw(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.DNn) && (!Util.isNullOrNil(this.DNJ.DRY)) && (!this.DNH))
    {
      if (Util.isNullOrNil(this.DNB))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.DNB.get(0)).longValue();
      Iterator localIterator1 = this.DNB.iterator();
      while (localIterator1.hasNext()) {
        Log.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
      }
      if ((this.DNL != 0L) && (paramLong == this.DNL))
      {
        this.DNR += 1;
        if ((this.DNS == 0L) && (paramLong == this.DNL)) {
          this.DNS = cl.aWB();
        }
      }
      localIterator1 = this.DNJ.DRY.iterator();
      while (localIterator1.hasNext())
      {
        l locall = (l)localIterator1.next();
        if (locall == this.DNK)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = locall.tbl.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          locall.tbl.removeAll(localArrayList);
          if (Util.isNullOrNil(locall.tbl)) {
            this.DNK = null;
          }
        }
        else
        {
          locall.tbl.removeAll(this.DNB);
          Util.isNullOrNil(locall.tbl);
        }
      }
      if ((this.DNA != 0L) && (l <= this.DNA))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.DNG), Long.valueOf(l), Long.valueOf(this.DNA) });
        this.DNG = true;
        this.DNL = 0L;
        this.DNJ.DRZ = 0L;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.DNJ.DRY.size()) });
      fbI();
    }
    AppMethodBeat.o(179109);
  }
  
  public final void Jx(long paramLong)
  {
    AppMethodBeat.i(179110);
    Log.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(paramLong) });
    if (!Util.isNullOrNil(this.DNJ.DRY))
    {
      Iterator localIterator = this.DNJ.DRY.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        locall.tbl.remove(Long.valueOf(paramLong));
        if (Util.isNullOrNil(locall.tbl))
        {
          localIterator.remove();
          if (locall == this.DNK) {
            this.DNK = null;
          }
        }
      }
    }
    AppMethodBeat.o(179110);
  }
  
  final boolean a(l paraml)
  {
    AppMethodBeat.i(179101);
    if ((Util.isNullOrNil(paraml.tbl)) || (paraml.tbl.size() < this.DNq) || (Util.secondsToNow(paraml.timestamp) > this.DNp) || (Util.secondsToNow(paraml.timestamp) < this.DNo) || (paraml.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final boolean fbD()
  {
    AppMethodBeat.i(179100);
    if ((this.DNK != null) && (!Util.isNullOrNil(this.DNK.tbl)))
    {
      AppMethodBeat.o(179100);
      return true;
    }
    AppMethodBeat.o(179100);
    return false;
  }
  
  public final void fbE()
  {
    AppMethodBeat.i(179102);
    if (!Util.isNullOrNil(this.DNJ.DRY))
    {
      Iterator localIterator = this.DNJ.DRY.iterator();
      label117:
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (Util.secondsToNow(locall.timestamp) > this.DNp) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label117;
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(locall.timestamp), Integer.valueOf(locall.tbl.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void fbF()
  {
    AppMethodBeat.i(179103);
    if ((this.DNJ.DRZ == 0L) || (Util.isNullOrNil(this.DNJ.DRY)))
    {
      this.DNK = null;
      this.DNL = 0L;
      this.DNJ.DRZ = 0L;
      this.DNA = 0L;
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.h.CyF.n(1295L, 0L, 0L);
      this.DNQ = this.DNK;
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.DNA), Long.valueOf(this.DNL) });
      AppMethodBeat.o(179103);
      return;
    }
    this.DNK = null;
    int i = this.DNJ.DRY.size() - 1;
    label138:
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (l)this.DNJ.DRY.get(i);
      if ((!a((l)localObject1)) && (((Long)((l)localObject1).tbl.peek()).longValue() < this.DNJ.DRZ))
      {
        this.DNK = ((l)localObject1);
        Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.DNK.timestamp), Integer.valueOf(this.DNK.tbl.size()) });
      }
    }
    else if (this.DNK != null)
    {
      this.DNL = this.DNJ.DRZ;
      this.DNA = ((Long)this.DNK.tbl.peek()).longValue();
      if ((this.DNL == 0L) || (this.DNK == null) || (Util.isNullOrNil(this.DNK.tbl))) {
        break label761;
      }
      localObject3 = aj.faO();
      String str1 = r.Jc(this.DNM);
      String str2 = r.Jc(((Long)this.DNK.tbl.peek()).longValue());
      localObject2 = "select snsId from SnsInfo  where " + n.feO();
      localObject1 = localObject2;
      if (n.aQw(str1)) {
        localObject1 = (String)localObject2 + " AND " + ((n)localObject3).aQA(str1);
      }
      localObject2 = localObject1;
      if (n.aQw(str2)) {
        localObject2 = (String)localObject1 + " AND " + ((n)localObject3).aQz(str2);
      }
      localObject1 = (String)localObject2 + n.Emu;
      Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
      this.DNx = ((n)localObject3).iFy.rawQuery((String)localObject1, null).getCount();
      Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.DNL), this.DNK.tbl.peek() });
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.DNx) });
      if (this.DNK.state == 0)
      {
        localObject1 = this.DNT;
        localObject2 = this.DNK;
        if (localObject2 != null)
        {
          localObject3 = ((l)localObject2).tbl;
          ((av)localObject1).DNj.clear();
          ((av)localObject1).DNj.addAll((Collection)localObject3);
          ((av)localObject1).DNk = ((l)localObject2);
          if (!Util.isNullOrNil(((av)localObject1).DNj))
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s], preloadCount:%s, unreadItem:%s", new Object[] { Long.valueOf(((l)localObject2).timestamp), Integer.valueOf(((l)localObject2).tbl.size()), Integer.valueOf(((l)localObject2).DSd), localObject2 });
            ((l)localObject2).DSd += 1;
            g.aAg().hqi.a(new z(((Long)((av)localObject1).DNj.get(0)).longValue() + 1L, 0L, 2), 0);
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(1295L, 0L, this.DNJ.DRY.size());
      break;
      i -= 1;
      break label138;
      label761:
      this.DNx = 0;
    }
  }
  
  public final void fbG()
  {
    AppMethodBeat.i(179104);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179095);
        if (aw.this.DNJ != null)
        {
          SnsInfo localSnsInfo = aj.faO().JJ(aw.this.DNJ.DRZ);
          if (localSnsInfo != null) {
            aw.this.DNO = (localSnsInfo.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179095);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void fbH()
  {
    AppMethodBeat.i(179105);
    if (this.DNn)
    {
      Log.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (Util.isNullOrNil(this.DNJ.DRY))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.DNJ.DRY.size()) });
      Iterator localIterator = this.DNJ.DRY.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (l)localIterator.next();
        Log.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((l)localObject).timestamp), Integer.valueOf(((l)localObject).tbl.size()) });
        localObject = ((l)localObject).tbl.iterator();
        while (((Iterator)localObject).hasNext()) {
          Log.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long fbJ()
  {
    AppMethodBeat.i(179107);
    if (!fbD())
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.DNK.tbl.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void fbK()
  {
    AppMethodBeat.i(179108);
    if (this.DNn)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = ((c)g.af(c.class)).cMF();
      if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
        Log.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      for (;;)
      {
        this.DNB.clear();
        if (Util.isNullOrNil(localArrayList)) {
          break;
        }
        this.DNB.addAll(localArrayList);
        if ((this.DNL == 0L) || (this.DNN != 0L) || (!this.DNB.contains(Long.valueOf(this.DNL)))) {
          break label252;
        }
        this.DNN = cl.aWB();
        AppMethodBeat.o(179108);
        return;
        ((Map)localObject1).putAll((Map)localObject2);
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue()) {
            localArrayList.add(Long.valueOf(r.aOw((String)((Map.Entry)localObject2).getKey())));
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
  
  public final void fbL()
  {
    if (this.DNK != null) {
      this.DNK.state = 2;
    }
  }
  
  public final void fbM()
  {
    AppMethodBeat.i(179114);
    if (!this.DNn)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l = this.DNO;
    final l locall1 = this.DNP;
    final l locall2 = this.DNQ;
    final LinkedList localLinkedList = new LinkedList(this.DNJ.DRY);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202789);
        kd localkd;
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
          localkd = e.DUQ.DVy;
          localObject1 = new LinkedList(locall1.DSa);
          ((LinkedList)localObject1).removeAll(locall1.tbl);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (i < locall1.DSa.size())
          {
            if (i < aw.this.DNw * j)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              k = j;
              if (localObject2 != null)
              {
                ((List)localObject2).add(locall1.DSa.get(i));
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
              ((List)localObject2).add(locall1.DSa.get(i));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (i < ((LinkedList)localObject1).size())
          {
            if (i < aw.this.DNw * j)
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
                ((StringBuffer)localObject1).append(r.Jc(((Long)((Iterator)localObject3).next()).longValue())).append("|");
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
                ((StringBuffer)localObject2).append(r.Jc(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (l)((Iterator)localObject3).next();
              if (!aw.this.a((l)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (Util.isNullOrNil(((l)localObject4).tbl))) {
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
          if (locall2 != null)
          {
            if (!Util.isNullOrNil(locall2.DSa))
            {
              localkd.eTX = (locall2.DSa.size() - locall2.DSc);
              localkd.eTW = locall2.DSa.size();
            }
            if (!Util.isNullOrNil(locall2.tbl))
            {
              localkd.eTE = ((Long)locall2.DSa.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = locall2.tbl.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(r.Jc(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localkd.eTH = localkd.x("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localkd.eTV = aw.this.DNS;
          localkd.eiB = localkd.x("SessionId", aw.this.sessionId, true);
          localkd.eTM = localkd.x("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localkd.eTN = k;
          localkd.eTO = localkd.x("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localkd.eTP = m;
          localkd.eTQ = i;
          localkd.eTR = n;
          localkd.eTS = aw.this.DNR;
          localkd.eTD = l;
          localkd.eLd = l;
          localkd.eMG = j;
          localkd.eMH = i1;
          localkd.bfK();
          j += 1;
          break;
          e.DUQ.DVy = new kd();
          aw.this.DNR = 0;
          aw.this.DNS = 0L;
          AppMethodBeat.o(202789);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(179111);
    this.DNz = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.DND = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.DND = 0L;
    AppMethodBeat.o(179111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */