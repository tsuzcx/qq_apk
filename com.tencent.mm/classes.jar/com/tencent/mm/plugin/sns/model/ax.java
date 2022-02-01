package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.pw;
import com.tencent.mm.autogen.mmdata.rpt.px;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.k.l;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.lf;
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

public final class ax
{
  public static a Qyi;
  public long QxA;
  public int QxB;
  public int QxC;
  public int QxD;
  public int QxE;
  public int QxF;
  public long QxG;
  int QxH;
  public int QxI;
  public Map<Long, Integer> QxJ;
  public View QxK;
  public long QxL;
  public List<Long> QxM;
  public boolean QxN;
  public long QxO;
  public long QxP;
  public int QxQ;
  public boolean QxR;
  public boolean QxS;
  public boolean QxT;
  public k QxU;
  public l QxV;
  public l QxW;
  public long QxX;
  public long QxY;
  public long QxZ;
  public String Qxx;
  public boolean Qxy;
  public long Qxz;
  public long Qya;
  public l Qyb;
  public l Qyc;
  public int Qyd;
  public long Qye;
  public aw Qyf;
  public LinkedList<String> Qyg;
  private final com.tencent.mm.am.h Qyh;
  public String sessionId;
  
  public ax()
  {
    AppMethodBeat.i(179099);
    this.Qxx = "";
    this.Qxy = false;
    this.Qxz = 3600L;
    this.QxA = 86400L;
    this.QxB = 5;
    this.QxC = 5;
    this.QxD = 50;
    this.QxE = 30;
    this.QxF = 5;
    this.QxG = 0L;
    this.QxH = 50;
    this.QxI = 0;
    this.QxJ = new HashMap();
    this.QxK = null;
    this.QxL = 0L;
    this.QxM = new ArrayList();
    this.QxN = false;
    this.QxO = 0L;
    this.QxP = 0L;
    this.QxQ = ay.QyB;
    this.QxR = false;
    this.QxS = false;
    this.QxT = false;
    this.QxU = new k();
    this.QxV = null;
    this.QxW = null;
    this.QxX = 0L;
    this.QxY = 0L;
    this.QxZ = 0L;
    this.sessionId = "";
    this.Qya = 0L;
    this.Qyb = null;
    this.Qyc = null;
    this.Qyd = 0;
    this.Qye = 0L;
    this.Qyf = new aw();
    this.Qyg = new LinkedList();
    this.Qyh = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(309525);
        if (paramAnonymousp.getType() == 5987)
        {
          com.tencent.mm.kernel.h.baD().mCm.b(5987, this);
          Object localObject = ((n)paramAnonymousp).Qsf;
          paramAnonymousString = new StringBuilder();
          ax.this.Qyg = new LinkedList();
          if ((localObject != null) && (!Util.isNullOrNil(((lf)localObject).YMW)))
          {
            paramAnonymousp = new LinkedList();
            localObject = ((lf)localObject).YMW.iterator();
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
              } while (ax.this.Qyg.contains(localSnsObject.Username));
              paramAnonymousString.append("**,");
              ax.this.Qyg.add(localSnsObject.Username);
              paramAnonymousp.add(Long.valueOf(localSnsObject.Id));
            } while (ax.this.Qyg.size() < 3);
            if (ax.this.Qyc != null)
            {
              ax.this.Qyc.QCS = paramAnonymousp;
              ax.this.Qyc.osR = ax.this.Qyg;
            }
          }
          if ((!Util.isNullOrNil(ax.this.Qyg)) && (ax.Qyi != null)) {
            ax.Qyi.bT(ax.this.Qyg);
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "onBatchObjectDetailSceneEnd getAvatar, avatar:%s, size:%s", new Object[] { paramAnonymousString.toString(), Integer.valueOf(ax.this.Qyg.size()) });
        }
        AppMethodBeat.o(309525);
      }
    };
    AppMethodBeat.o(179099);
  }
  
  public static boolean a(l paraml)
  {
    AppMethodBeat.i(309462);
    if ((paraml != null) && (!Util.isNullOrNil(paraml.Adz)))
    {
      AppMethodBeat.o(309462);
      return true;
    }
    AppMethodBeat.o(309462);
    return false;
  }
  
  private void hht()
  {
    AppMethodBeat.i(179106);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      Iterator localIterator1;
      if (this.QxV != null)
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", new Object[] { Long.valueOf(this.QxV.timestamp), Integer.valueOf(this.QxV.Adz.size()) });
        if (!Util.isNullOrNil(this.QxU.QCM)) {
          localIterator1 = this.QxU.QCM.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label211;
          }
          l locall = (l)localIterator1.next();
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator2 = locall.Adz.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localStringBuilder.append((Long)localIterator2.next()).append(",");
              continue;
              Log.i("MicroMsg.SnsUnreadTipManager", "target:null");
              break;
            }
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "item:%s, idList:%s", new Object[] { Long.valueOf(locall.timestamp), localStringBuilder.toString() });
        }
      }
    }
    label211:
    AppMethodBeat.o(179106);
  }
  
  final boolean b(l paraml)
  {
    AppMethodBeat.i(179101);
    if ((Util.isNullOrNil(paraml.Adz)) || (paraml.Adz.size() < this.QxB) || (Util.secondsToNow(paraml.timestamp) > this.QxA) || (Util.secondsToNow(paraml.timestamp) < this.Qxz) || (paraml.state == 2))
    {
      AppMethodBeat.o(179101);
      return true;
    }
    AppMethodBeat.o(179101);
    return false;
  }
  
  public final void hhp()
  {
    AppMethodBeat.i(179102);
    if (!Util.isNullOrNil(this.QxU.QCM))
    {
      Iterator localIterator = this.QxU.QCM.iterator();
      label118:
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (Util.secondsToNow(locall.timestamp) > this.QxA) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label118;
          }
          Log.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", new Object[] { Long.valueOf(locall.timestamp), Integer.valueOf(locall.Adz.size()) });
          localIterator.remove();
          break;
        }
      }
    }
    AppMethodBeat.o(179102);
  }
  
  public final void hhq()
  {
    AppMethodBeat.i(179103);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.QxU.QCN == 0L) || (Util.isNullOrNil(this.QxU.QCM)))
    {
      this.QxV = null;
      this.QxX = 0L;
      this.QxU.QCN = 0L;
      this.QxL = 0L;
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
      com.tencent.mm.plugin.report.service.h.OAn.p(1295L, 0L, 0L);
      localObject1 = this.QxW;
      localObject2 = this.QxV;
      if (localObject1 == localObject2) {
        break label1176;
      }
      if (((localObject1 == null) || (localObject2 != null)) && ((localObject1 != null) || (localObject2 == null))) {
        break label1012;
      }
      i = 0;
    }
    label1176:
    for (;;)
    {
      if ((this.QxV != null) && (!Util.isNullOrNil(this.QxV.Adz)) && ((Util.isNullOrNil(this.Qyg)) || (i == 0)))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem getAvatar, targetsize:%s", new Object[] { Integer.valueOf(this.QxV.Adz.size()) });
        this.Qyg = new LinkedList();
        com.tencent.mm.kernel.h.baD().mCm.a(5987, this.Qyh);
        com.tencent.mm.kernel.h.baD().mCm.a(new n(this.QxV.Adz), 0);
      }
      if (i == 0)
      {
        this.QxW = this.QxV;
        this.Qyc = this.QxV;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", new Object[] { Long.valueOf(this.QxL), Long.valueOf(this.QxX) });
      AppMethodBeat.o(179103);
      return;
      this.QxV = null;
      i = this.QxU.QCM.size() - 1;
      label304:
      boolean bool;
      label333:
      Object localObject3;
      if (i >= 0)
      {
        localObject1 = (l)this.QxU.QCM.get(i);
        if (!b((l)localObject1))
        {
          bool = true;
          Log.d("MicroMsg.SnsUnreadTipManager", "findTargetItem isValid:%s, item.idList.peek():%s, unreadSnsIdList.lastSnsId:%s", new Object[] { Boolean.valueOf(bool), ((l)localObject1).Adz.peek(), Long.valueOf(this.QxU.QCN) });
          if ((b((l)localObject1)) || (((Long)((l)localObject1).Adz.peek()).longValue() >= this.QxU.QCN)) {
            break label997;
          }
          this.QxV = ((l)localObject1);
          Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", new Object[] { Long.valueOf(this.QxV.timestamp), Integer.valueOf(this.QxV.Adz.size()) });
        }
      }
      else if (this.QxV != null)
      {
        this.QxX = this.QxU.QCN;
        this.QxL = ((Long)this.QxV.Adz.peek()).longValue();
        if ((this.QxX == 0L) || (this.QxV == null) || (Util.isNullOrNil(this.QxV.Adz))) {
          break label1004;
        }
        localObject3 = al.hgB();
        String str1 = t.uB(this.QxY);
        String str2 = t.uB(((Long)this.QxV.Adz.peek()).longValue());
        localObject2 = "select snsId from SnsInfo  where " + w.hkV();
        localObject1 = localObject2;
        if (w.bad(str1)) {
          localObject1 = (String)localObject2 + " AND " + ((w)localObject3).bah(str1);
        }
        localObject2 = localObject1;
        if (w.bad(str2)) {
          localObject2 = (String)localObject1 + " AND " + ((w)localObject3).bag(str2);
        }
        localObject1 = (String)localObject2 + w.QYW;
        Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", new Object[] { localObject1, str1, str2 });
        this.QxI = ((w)localObject3).QYR.rawQuery((String)localObject1, null).getCount();
        Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", new Object[] { Long.valueOf(this.QxX), this.QxV.Adz.peek() });
      }
      for (;;)
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", new Object[] { Integer.valueOf(this.QxI) });
        if (this.QxV.state == 0)
        {
          localObject1 = this.Qyf;
          localObject2 = this.QxV;
          if (localObject2 != null)
          {
            localObject3 = ((l)localObject2).Adz;
            ((aw)localObject1).Qxu.clear();
            ((aw)localObject1).Qxu.addAll((Collection)localObject3);
            ((aw)localObject1).Qxv = ((l)localObject2);
            if (!Util.isNullOrNil(((aw)localObject1).Qxu))
            {
              Log.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s], preloadCount:%s, unreadItem:%s", new Object[] { Long.valueOf(((l)localObject2).timestamp), Integer.valueOf(((l)localObject2).Adz.size()), Integer.valueOf(((l)localObject2).QCR), localObject2 });
              ((l)localObject2).QCR += 1;
              com.tencent.mm.kernel.h.baD().mCm.a(new z(((Long)((aw)localObject1).Qxu.get(0)).longValue() + 1L, 0L, 2), 0);
            }
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1295L, 0L, this.QxU.QCM.size());
        break;
        bool = false;
        break label333;
        label997:
        i -= 1;
        break label304;
        label1004:
        this.QxI = 0;
      }
      label1012:
      if ((((l)localObject1).timestamp != ((l)localObject2).timestamp) || (((l)localObject1).state != ((l)localObject2).state) || (((l)localObject1).QCQ != ((l)localObject2).QCQ) || (((l)localObject1).QCP != ((l)localObject2).QCP) || (((l)localObject1).QCR != ((l)localObject2).QCR))
      {
        i = 0;
      }
      else
      {
        if ((((l)localObject1).QCO != null) || (((l)localObject2).QCO != null))
        {
          if ((((l)localObject1).QCO != null) && (((l)localObject2).QCO != null) && (((l)localObject1).QCO.size() == ((l)localObject2).QCO.size())) {
            i = 0;
          }
          for (;;)
          {
            if (i < ((l)localObject1).QCO.size())
            {
              if (((l)localObject1).QCO.get(i) != ((l)localObject2).QCO.get(i))
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
  
  public final void hhr()
  {
    AppMethodBeat.i(179104);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179096);
        if (ax.this.QxU != null)
        {
          SnsInfo localSnsInfo = al.hgB().vj(ax.this.QxU.QCN);
          if (localSnsInfo != null) {
            ax.this.Qya = (localSnsInfo.field_createTime + 1);
          }
        }
        AppMethodBeat.o(179096);
      }
    });
    AppMethodBeat.o(179104);
  }
  
  public final void hhs()
  {
    AppMethodBeat.i(179105);
    if (this.Qxy)
    {
      Log.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
      if (Util.isNullOrNil(this.QxU.QCM))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
        AppMethodBeat.o(179105);
        return;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", new Object[] { Integer.valueOf(this.QxU.QCM.size()) });
      Iterator localIterator = this.QxU.QCM.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (l)localIterator.next();
        Log.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", new Object[] { Long.valueOf(((l)localObject).timestamp), Integer.valueOf(((l)localObject).Adz.size()) });
        localObject = ((l)localObject).Adz.iterator();
        while (((Iterator)localObject).hasNext()) {
          Log.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", new Object[] { (Long)((Iterator)localObject).next() });
        }
      }
    }
    AppMethodBeat.o(179105);
  }
  
  public final long hhu()
  {
    AppMethodBeat.i(179107);
    if (!a(this.QxV))
    {
      AppMethodBeat.o(179107);
      return -1L;
    }
    long l = ((Long)this.QxV.Adz.peek()).longValue();
    AppMethodBeat.o(179107);
    return l;
  }
  
  public final void hhv()
  {
    AppMethodBeat.i(179108);
    if (this.Qxy)
    {
      ArrayList localArrayList = new ArrayList();
      ??? = new HashMap();
      Object localObject3 = ((d)com.tencent.mm.kernel.h.ax(d.class)).dHP();
      if ((localObject3 == null) || (((Map)localObject3).size() == 0)) {
        Log.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
      }
      synchronized (this.QxM)
      {
        for (;;)
        {
          this.QxM.clear();
          if (Util.isNullOrNil(localArrayList)) {
            break;
          }
          this.QxM.addAll(localArrayList);
          if ((this.QxX != 0L) && (this.QxZ == 0L) && (this.QxM.contains(Long.valueOf(this.QxX)))) {
            this.QxZ = cn.getSyncServerTimeSecond();
          }
          AppMethodBeat.o(179108);
          return;
          ((Map)???).putAll((Map)localObject3);
          ??? = ((Map)???).entrySet().iterator();
          while (((Iterator)???).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)???).next();
            if (!((Boolean)((Map.Entry)localObject3).getValue()).booleanValue()) {
              localArrayList.add(Long.valueOf(t.aXD((String)((Map.Entry)localObject3).getKey())));
            }
          }
          Collections.sort(localArrayList);
          if (Util.isNullOrNil(localArrayList)) {
            Log.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
          }
        }
        Log.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
      }
    }
    AppMethodBeat.o(179108);
  }
  
  public final void hhw()
  {
    if (this.QxV != null) {
      this.QxV.state = 2;
    }
  }
  
  public final void hhx()
  {
    AppMethodBeat.i(179114);
    if (!this.Qxy)
    {
      AppMethodBeat.o(179114);
      return;
    }
    final long l1 = this.Qya;
    final l locall1 = this.Qyb;
    final l locall2 = this.Qyc;
    final LinkedList localLinkedList = new LinkedList(this.QxU.QCM);
    final int i = this.Qyd;
    final long l2 = this.Qye;
    String str = this.sessionId;
    this.Qyd = 0;
    this.Qye = 0L;
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309529);
        px localpx;
        Object localObject1;
        int j;
        int i;
        Object localObject2;
        int i1;
        long l;
        int m;
        Object localObject3;
        int k;
        int n;
        label520:
        Object localObject4;
        if (locall1 != null)
        {
          localpx = j.QFS.QGC;
          localObject1 = new LinkedList(locall1.QCO);
          ((LinkedList)localObject1).removeAll(locall1.Adz);
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          j = 0;
          i = 0;
          if (j < locall1.QCO.size())
          {
            if (j < ax.this.QxH * i)
            {
              localObject2 = (List)localLinkedList1.peekLast();
              if (localObject2 != null) {
                ((List)localObject2).add((Long)locall1.QCO.get(j));
              }
            }
            for (;;)
            {
              j += 1;
              break;
              i += 1;
              localObject2 = new ArrayList();
              ((List)localObject2).add((Long)locall1.QCO.get(j));
              localLinkedList1.add(localObject2);
            }
          }
          j = 0;
          i = 0;
          if (j < ((LinkedList)localObject1).size())
          {
            if (j < ax.this.QxH * i)
            {
              localObject2 = (List)localLinkedList2.peekLast();
              if (localObject2 != null) {
                ((List)localObject2).add((Long)((LinkedList)localObject1).get(j));
              }
            }
            for (;;)
            {
              j += 1;
              break;
              i += 1;
              localObject2 = new ArrayList();
              ((List)localObject2).add((Long)((LinkedList)localObject1).get(j));
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
                ((StringBuffer)localObject1).append(t.uB(((Long)((Iterator)localObject3).next()).longValue())).append("|");
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
                ((StringBuffer)localObject2).append(t.uB(((Long)((Iterator)localObject3).next()).longValue())).append("|");
              }
            }
            i = 0;
            localObject3 = localLinkedList.iterator();
            n = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (l)((Iterator)localObject3).next();
              if (!ax.this.b((l)localObject4))
              {
                n += 1;
              }
              else
              {
                if ((localObject4 == null) || (Util.isNullOrNil(((l)localObject4).Adz))) {
                  break label1102;
                }
                i += 1;
              }
            }
          }
        }
        label1102:
        for (;;)
        {
          break label520;
          if (locall2 != null)
          {
            if (!Util.isNullOrNil(locall2.QCO))
            {
              localpx.jpH = (locall2.QCO.size() - locall2.QCQ);
              localpx.jpG = locall2.QCO.size();
            }
            if (!Util.isNullOrNil(locall2.Adz))
            {
              localpx.jpo = ((Long)locall2.QCO.peek()).longValue();
              localObject3 = new StringBuffer();
              localObject4 = locall2.Adz.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(t.uB(((Long)((Iterator)localObject4).next()).longValue())).append("|");
              }
              localpx.jpr = localpx.F("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
            }
            if ((!Util.isNullOrNil(locall2.osR)) && (!Util.isNullOrNil(locall2.QCS)))
            {
              localObject3 = new StringBuffer();
              localObject4 = locall2.osR.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append((String)((Iterator)localObject4).next()).append("#");
              }
              localpx.jpM = localpx.F("AvatarList", ((StringBuffer)localObject3).toString(), true);
              localObject3 = new StringBuffer();
              localObject4 = locall2.QCS.iterator();
              while (((Iterator)localObject4).hasNext()) {
                ((StringBuffer)localObject3).append(t.uB(((Long)((Iterator)localObject4).next()).longValue())).append("#");
              }
              localpx.jpN = localpx.F("IdList", ((StringBuffer)localObject3).toString(), true);
            }
          }
          localpx.jpF = l2;
          localpx.ijk = localpx.F("SessionId", i, true);
          localpx.jpw = localpx.F("NewFeeds", ((StringBuffer)localObject1).toString(), true);
          localpx.jpx = k;
          localpx.jpy = localpx.F("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
          localpx.jpz = m;
          localpx.jpA = i;
          localpx.jpB = n;
          localpx.jpC = l1;
          localpx.jpn = this.Qyx;
          localpx.iZX = l;
          localpx.jcC = j;
          localpx.jcD = i1;
          localpx.bMH();
          j += 1;
          break;
          j.QFS.QGC = new px();
          AppMethodBeat.o(309529);
          return;
        }
      }
    });
    AppMethodBeat.o(179114);
  }
  
  public final void ju(View paramView)
  {
    AppMethodBeat.i(179111);
    this.QxK = paramView;
    if ((paramView != null) && ((paramView.getTag() instanceof Long)))
    {
      this.QxO = ((Long)paramView.getTag()).longValue();
      AppMethodBeat.o(179111);
      return;
    }
    this.QxO = 0L;
    AppMethodBeat.o(179111);
  }
  
  public final void uV(long paramLong)
  {
    AppMethodBeat.i(179109);
    if ((this.Qxy) && (!Util.isNullOrNil(this.QxU.QCM)) && (!this.QxS))
    {
      if (Util.isNullOrNil(this.QxM))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
        AppMethodBeat.o(179109);
        return;
      }
      long l = ((Long)this.QxM.get(0)).longValue();
      if (Log.getLogLevel() <= 1)
      {
        localIterator1 = this.QxM.iterator();
        while (localIterator1.hasNext()) {
          Log.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", new Object[] { (Long)localIterator1.next() });
        }
      }
      if ((this.QxX != 0L) && (paramLong == this.QxX))
      {
        this.Qyd += 1;
        if ((this.Qye == 0L) && (paramLong == this.QxX)) {
          this.Qye = cn.getSyncServerTimeSecond();
        }
      }
      Iterator localIterator1 = this.QxU.QCM.iterator();
      while (localIterator1.hasNext())
      {
        l locall = (l)localIterator1.next();
        if (locall == this.QxV)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = locall.Adz.iterator();
          while (localIterator2.hasNext())
          {
            Long localLong = (Long)localIterator2.next();
            if (localLong.longValue() >= l) {
              localArrayList.add(localLong);
            }
          }
          locall.Adz.removeAll(localArrayList);
          if (Util.isNullOrNil(locall.Adz)) {
            this.QxV = null;
          }
        }
        else
        {
          locall.Adz.removeAll(this.QxM);
        }
      }
      if ((this.QxL != 0L) && (l <= this.QxL))
      {
        Log.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", new Object[] { Boolean.valueOf(this.QxR), Long.valueOf(l), Long.valueOf(this.QxL) });
        this.QxR = true;
        this.QxX = 0L;
        this.QxU.QCN = 0L;
      }
      Log.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", new Object[] { Long.valueOf(l), Integer.valueOf(this.QxU.QCM.size()) });
      hht();
    }
    AppMethodBeat.o(179109);
  }
  
  public final void uW(long paramLong)
  {
    AppMethodBeat.i(179110);
    Log.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(paramLong) });
    if (!Util.isNullOrNil(this.QxU.QCM))
    {
      Iterator localIterator = this.QxU.QCM.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        locall.Adz.remove(Long.valueOf(paramLong));
        if (Util.isNullOrNil(locall.Adz))
        {
          localIterator.remove();
          if (locall == this.QxV) {
            this.QxV = null;
          }
        }
      }
    }
    AppMethodBeat.o(179110);
  }
  
  public static abstract interface a
  {
    public abstract void bT(LinkedList<String> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */