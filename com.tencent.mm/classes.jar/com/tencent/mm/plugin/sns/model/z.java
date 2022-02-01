package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.xm;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.protocal.protobuf.eld;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.protocal.protobuf.flv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class z
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> JVh;
  private long JVK;
  private String JVL;
  public boolean JVe;
  long JVf;
  long JVg;
  public int JVi;
  public int JVj;
  private long JWd;
  private final long JWe;
  private boolean JWf;
  private boolean JWg;
  private boolean JWh;
  private w JWi;
  public int afI;
  public com.tencent.mm.an.i callback;
  private boolean lYN;
  public int pullType;
  com.tencent.mm.an.d rr;
  final int sourceType;
  
  static
  {
    AppMethodBeat.i(95670);
    JVh = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public z(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.lYN = false;
    this.JWd = 0L;
    this.JVf = 0L;
    this.JVg = 0L;
    this.JVK = 0L;
    this.JWe = 102400L;
    this.JVL = "";
    this.JWf = false;
    this.JWg = false;
    this.JVi = 0;
    this.JVj = 0;
    this.afI = 0;
    this.pullType = 0;
    this.JWh = false;
    this.JWi = null;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new eld();
    ((d.a)localObject1).lBV = new ele();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((d.a)localObject1).funcId = 211;
    ((d.a)localObject1).lBW = 98;
    ((d.a)localObject1).respCmdId = 1000000098;
    this.rr = ((d.a)localObject1).bgN();
    int j = t.avq();
    this.JVf = paramLong1;
    boolean bool;
    eld localeld;
    int k;
    long l1;
    label250:
    int m;
    Object localObject2;
    label415:
    int i;
    if ((paramLong1 == 0L) && (paramLong2 == 0L))
    {
      bool = true;
      this.JVe = bool;
      this.sourceType = 2;
      localeld = (eld)d.b.b(this.rr.lBR);
      localeld.Ulf = j;
      localeld.UlB = paramLong1;
      k = aj.fOy().fPp();
      localObject1 = aj.fOI();
      if (!this.JVe) {
        break label970;
      }
      l1 = 0L;
      this.JVg = ((n)localObject1).g(l1, k, true);
      localeld.UmO = this.JVg;
      m = d.a(this.JVg, paramLong1, "@__weixintimtline");
      localeld.UmP = m;
      localeld.UmV = paramLong2;
      if (!this.JVe) {
        break label976;
      }
      localObject1 = aj.fOT();
      long l2 = ((av)localObject1).KaP;
      l1 = l2;
      if (((av)localObject1).KaL != null)
      {
        l1 = l2;
        if (!Util.isNullOrNil(((av)localObject1).KaL.Kff))
        {
          localObject1 = ((av)localObject1).KaL.Kff.iterator();
          do
          {
            l1 = l2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (com.tencent.mm.plugin.sns.j.l)((Iterator)localObject1).next();
          } while (Util.isNullOrNil(((com.tencent.mm.plugin.sns.j.l)localObject2).wHq));
          l1 = ((Long)((com.tencent.mm.plugin.sns.j.l)localObject2).wHq.peekLast()).longValue() - 1L;
        }
      }
      localeld.UmW = l1;
      if (paramInt != 1) {
        break label982;
      }
      i = 1;
      label431:
      localeld.UmU = i;
      this.pullType = paramInt;
      Object localObject3 = aj.fOQ();
      localObject1 = null;
      localObject2 = null;
      String str = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + x.KAd + " order by SnsWsFoldGroup.top desc limit 1";
      localObject3 = ((x)localObject3).lvy.rawQuery(str, null, 2);
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = new w();
          ((w)localObject1).convertFrom((Cursor)localObject3);
        }
        ((Cursor)localObject3).close();
      }
      this.JWi = ((w)localObject1);
      if (this.JWi != null) {
        break label988;
      }
      localeld.UmX = 0L;
      localeld.UmZ = 0L;
      label563:
      localeld.UmY = ah.JXi;
      localObject2 = aj.fOM().bbr("@__weixintimtline");
      if (this.JVe)
      {
        this.JVK = aj.fOI().g(0L, 1, true);
        Log.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.JVK);
        localeld.UmQ = this.JVK;
        if (localObject2 != null) {
          break label1067;
        }
        localObject1 = "";
        label645:
        this.JVL = ((String)localObject1);
        if (this.JVL == null) {
          this.JVL = "";
        }
        localeld.UlA = this.JVL;
      }
      l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNb, 102400L);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession.length <= l1)) {
        break label1077;
      }
    }
    for (localeld.Uld = new eae().dc(new byte[0]);; localeld.Uld = new eae().dc(((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession))
    {
      this.JWd = paramLong1;
      localeld.Una = new eae().dc(com.tencent.mm.plugin.sns.ad.d.e.fJS());
      Log.i("MicroMsg.NetSceneSnsTimeLine", "This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.JVg + " ReqTime:" + localeld.UmP + " nettype: " + j + " MinIdForCheckUnread:" + localeld.UmW + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2 + " NearbyFoldId:" + localeld.UmX + " FoldSectionSize：" + ah.JXi);
      Log.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { t.Qu(paramLong1), t.Qu(this.JVg), Integer.valueOf(m) });
      Log.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine cost：%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
      AppMethodBeat.o(179086);
      return;
      bool = false;
      break;
      label970:
      l1 = paramLong1;
      break label250;
      label976:
      l1 = 0L;
      break label415;
      label982:
      i = 0;
      break label431;
      label988:
      Log.i("MicroMsg.NetSceneSnsTimeLine", "firstFinishWsGroup.size:%s, firstFinishWsGroup.top:%s, firstFinishWsGroup.bottom:%s", new Object[] { Integer.valueOf(this.JWi.field_size), t.Qv(this.JWi.field_top), t.Qv(this.JWi.field_bottom) });
      localeld.UmX = this.JWi.field_top;
      localeld.UmZ = this.JWi.field_top;
      break label563;
      label1067:
      localObject1 = ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_md5;
      break label645;
      label1077:
      Log.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession });
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ele paramele)
  {
    AppMethodBeat.i(213473);
    if (paramele.RPF.size() == 0)
    {
      aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(213473);
      return;
    }
    Iterator localIterator = paramele.RPF.iterator();
    while (localIterator.hasNext()) {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramele, t.Qv(this.JVf));
    aZW("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(213473);
  }
  
  private static void a(ele paramele)
  {
    AppMethodBeat.i(213472);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramele != null) {
      if (!Util.isNullOrNil(paramele.RPF))
      {
        localObject1 = new ArrayList();
        localObject2 = paramele.RPF.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SnsObject)((Iterator)localObject2).next();
          if ((localObject3 != null) && (an.afS(((SnsObject)localObject3).ExtFlag))) {
            ((List)localObject1).add(Long.valueOf(((SnsObject)localObject3).Id));
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          aj.fOR().Ri(((Long)localObject2).longValue());
        }
      }
    }
    label694:
    label962:
    label975:
    label985:
    label994:
    label999:
    for (;;)
    {
      int k;
      int i;
      int j;
      try
      {
        localObject1 = new flv();
        ((flv)localObject1).parseFrom(com.tencent.mm.platformtools.z.a(paramele.Unl));
        if (!Util.isNullOrNil(((flv)localObject1).UKJ))
        {
          k = ((flv)localObject1).UKJ.size() / ah.JXi;
          Log.i("MicroMsg.NetSceneSnsTimeLine", "wsInfo.timeline_idx.size:%s, SnsConfig.wsFoldGroupSize:%s, tmp:%s", new Object[] { Integer.valueOf(((flv)localObject1).UKJ.size()), Integer.valueOf(ah.JXi), Integer.valueOf(k) });
          if (k != 0) {
            break label985;
          }
          paramele = new w();
          paramele.field_top = ((ers)((flv)localObject1).UKJ.getFirst()).UtM;
          paramele.field_bottom = ((ers)((flv)localObject1).UKJ.getLast()).UtM;
          paramele.field_size = ((flv)localObject1).UKJ.size();
          if (paramele.field_size != ah.JXi) {
            break label694;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert topId:%s, bottomId:%s", new Object[] { t.Qv(paramele.field_top), t.Qv(paramele.field_bottom) });
          aj.fOQ().a(paramele);
        }
        if (Util.isNullOrNil(((flv)localObject1).UKI)) {
          break label975;
        }
        paramele = ((flv)localObject1).UKI.iterator();
        if (!paramele.hasNext()) {
          break label975;
        }
        localObject1 = (fhc)paramele.next();
        if ((localObject1 == null) || (Util.isNullOrNil(((fhc)localObject1).RPH)) || (((fhc)localObject1).UHl == null)) {
          continue;
        }
        long l = ((fhc)localObject1).UHj;
        i = ((fhc)localObject1).UHk;
        new SnsObject().parseFrom(((fhc)localObject1).UHl.toByteArray());
        localObject2 = new eln();
        ((eln)localObject2).UnE.addAll(((fhc)localObject1).RPH);
        localObject3 = o.Xk(new String(((fhc)localObject1).UHl.ObjectDesc.Tkb.toByteArray()));
        if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentDesc)) {
          break label962;
        }
        if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Sqr != null) && (((TimeLineObject)localObject3).ContentObj.Sqr.size() > 0) && (((TimeLineObject)localObject3).ContentObj.Sqr.getFirst() != null))
        {
          j = ((cvt)((TimeLineObject)localObject3).ContentObj.Sqr.getFirst()).rWu;
          if (j != 2) {
            break label939;
          }
          ((eln)localObject2).UnF = MMApplicationContext.getContext().getString(i.j.sns_item_ws_fold_pic);
        }
        localObject3 = new com.tencent.mm.plugin.sns.storage.u();
        ((com.tencent.mm.plugin.sns.storage.u)localObject3).field_groupId = l;
        ((com.tencent.mm.plugin.sns.storage.u)localObject3).field_groupTime = i;
        ((com.tencent.mm.plugin.sns.storage.u)localObject3).field_groupStrcut = ((eln)localObject2).toByteArray();
        aj.fOR().a((com.tencent.mm.plugin.sns.storage.u)localObject3);
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(((fhc)localObject1).UHl);
        an.a("@__weixintimtline", 128, (LinkedList)localObject2, t.Qv(((fhc)localObject1).UHl.Id));
        continue;
        AppMethodBeat.o(213472);
      }
      catch (Exception paramele)
      {
        Log.w("MicroMsg.NetSceneSnsTimeLine", "parse WSInfo err: %s", new Object[] { paramele.getMessage() });
      }
      return;
      Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, field_size:%s", new Object[] { Integer.valueOf(paramele.field_size) });
      continue;
      for (;;)
      {
        if (i >= k) {
          break label999;
        }
        int m = ((flv)localObject1).UKJ.size() - 1 - ah.JXi * i;
        j = m - ah.JXi + 1;
        if (j < 0) {
          j = 0;
        }
        for (;;)
        {
          paramele = new w();
          paramele.field_top = ((ers)((flv)localObject1).UKJ.get(j)).UtM;
          paramele.field_bottom = ((ers)((flv)localObject1).UKJ.get(m)).UtM;
          paramele.field_size = (m - j + 1);
          if (paramele.field_size == ah.JXi)
          {
            Log.i("MicroMsg.NetSceneSnsTimeLine", "insert index:%s, topIndex:%s, bottomIndex:%s, topId:%s, bottomId:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), t.Qv(paramele.field_top), t.Qv(paramele.field_bottom) });
            aj.fOQ().a(paramele);
            break label994;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, index:%s, topIndex:%s, bottomIndex:%s, field_size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramele.field_size) });
          break label994;
          if (j != 6) {
            break;
          }
          ((eln)localObject2).UnF = MMApplicationContext.getContext().getString(i.j.sns_item_ws_fold_video);
          break;
          ((eln)localObject2).UnF = ((TimeLineObject)localObject3).ContentDesc;
          break;
          AppMethodBeat.o(213472);
          return;
        }
        if (k <= 0) {
          break;
        }
        i = 0;
        continue;
        i += 1;
      }
    }
  }
  
  private void a(ele paramele, String paramString)
  {
    AppMethodBeat.i(95666);
    an.a("@__weixintimtline", this.sourceType, paramele.RPF, paramString);
    this.JVg = ((SnsObject)paramele.RPF.getLast()).Id;
    if (this.JVf == 0L) {
      this.JVf = ((SnsObject)paramele.RPF.getFirst()).Id;
    }
    for (;;)
    {
      d.f("@__weixintimtline", this.JVf, this.JVg, paramele.Unb);
      try
      {
        paramele = paramele.RPF.iterator();
        for (;;)
        {
          if (paramele.hasNext())
          {
            paramString = (SnsObject)paramele.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = aj.fOI().Rd(paramString.Id);
              if ((localObject != null) && (((SnsInfo)localObject).getTimeLine() != null))
              {
                int i = ((SnsInfo)localObject).getTypeFlag();
                if (i == 15)
                {
                  try
                  {
                    localObject = ((cvt)((SnsInfo)localObject).getTimeLine().ContentObj.Sqr.get(0)).Url;
                    com.tencent.mm.plugin.report.service.h.IzE.a(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.JVf = d.Qy(this.JVf);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramele)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean aZV(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 746
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/z:JVh	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 749	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 746
    //   24: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/z:JVh	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 750	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 746
    //   45: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -21 -> 27
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   20	22	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	19	51	finally
    //   21	27	51	finally
    //   32	40	51	finally
    //   42	48	51	finally
  }
  
  public static boolean aZW(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      JVh.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, ele paramele)
  {
    AppMethodBeat.i(179087);
    int i;
    if (paramele.UlF != null)
    {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramele.UlF.UmK + " " + paramele.UlF.UmJ);
      i = paramele.UlF.UmK;
      com.tencent.mm.plugin.sns.c.a.JPj = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.c.a.JPj = 2147483647;
      }
      com.tencent.mm.storage.aq.Vga = paramele.UlF.UmJ;
    }
    this.JVi = paramele.UlE;
    this.JVj = paramele.CqN;
    Log.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramele.UlE + " , objCount: " + paramele.TGK + ", controlFlag: " + paramele.CqN);
    this.afI = paramele.TGK;
    String str1 = t.Qv(this.JVf);
    Object localObject1;
    if (!paramele.RPF.isEmpty())
    {
      localObject1 = new StringBuilder("resp size:").append(paramele.RPF.size()).append(", resp Max:").append(((SnsObject)paramele.RPF.getFirst()).Id).append(" ").append(t.Qu(((SnsObject)paramele.RPF.getFirst()).Id)).append(", resp Min:").append(((SnsObject)paramele.RPF.getLast()).Id).append(" ").append(t.Qu(((SnsObject)paramele.RPF.getLast()).Id)).append(", adListSize:");
      if (paramele.Und == null)
      {
        i = 0;
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        com.tencent.mm.plugin.sns.ad.d.f.c(paramele.Unh, paramele.Ung, 0);
        if (!this.JVL.equals(paramele.UlA)) {
          break label544;
        }
        paramele = aj.fOI();
        if (!this.JVe) {
          break label535;
        }
      }
    }
    label535:
    for (long l1 = 0L;; l1 = this.JWd)
    {
      this.JVg = paramele.g(l1, this.JVi, true);
      Log.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid:%s", new Object[] { Long.valueOf(this.JVg) });
      fOc();
      aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      i = paramele.Und.size();
      break;
      localObject1 = new StringBuilder("resp is Empty, adListSize:");
      if (paramele.Und == null) {}
      for (i = 0;; i = paramele.Und.size())
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
    }
    label544:
    aj.fOM().g("@__weixintimtline", paramele.UlA, com.tencent.mm.platformtools.z.a(paramele.Uld));
    Log.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramele.RPF.size() + " adsize : " + paramele.Unc);
    if ((paramele != null) && (paramele.Und != null) && (paramele.Und.size() > 0)) {
      com.tencent.mm.plugin.sns.ad.d.e.fJT();
    }
    label640:
    String str4;
    long l2;
    for (;;)
    {
      i = 0;
      if (i < paramele.Und.size())
      {
        localObject1 = (dq)paramele.Und.get(i);
        String str2;
        if (this.lYN) {
          str2 = aj.getAccPath() + "ad.proto";
        }
        try
        {
          Object localObject3 = ((dq)localObject1).toByteArray();
          com.tencent.mm.vfs.u.f(str2, (byte[])localObject3, localObject3.length);
          localObject3 = com.tencent.mm.platformtools.z.a(((dq)localObject1).RJa);
          str2 = com.tencent.mm.platformtools.z.a(((dq)localObject1).RIZ.Ulc);
          str4 = com.tencent.mm.platformtools.z.b(((dq)localObject1).RIZ.Ulb.ObjectDesc);
          Log.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
          Log.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
          Log.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
          long l3 = 0L;
          l1 = l3;
          l2 = l3;
          try
          {
            if (!Util.isNullOrNil(new String[] { localObject3, str2 }))
            {
              l1 = l3;
              l2 = l3;
              if (((dq)localObject1).RIZ != null)
              {
                l1 = l3;
                l2 = l3;
                if (((dq)localObject1).RIZ.Ulb != null)
                {
                  l2 = l3;
                  l1 = Util.nullAsNil(Long.valueOf(((dq)localObject1).RIZ.Ulb.Id));
                }
              }
              l2 = l1;
              com.tencent.mm.plugin.sns.data.k.f(l1, (String)localObject3, str2);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              boolean bool;
              Log.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localThrowable.toString());
              l1 = l2;
            }
          }
          localObject3 = ((dq)localObject1).RIZ.Ulb.Username;
          if (!Util.isNullOrNil((String)localObject3))
          {
            bool = com.tencent.mm.plugin.sns.data.m.aYV(str2);
            Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + (String)localObject3 + ", isUsePreferedInfo=" + bool + ", snsId=" + t.Qv(l1));
            if (!bool)
            {
              az.a.ltq.aP((String)localObject3, "");
              com.tencent.e.h.ZvG.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(95661);
                  Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.iXG);
                  com.tencent.mm.am.d.TA(this.iXG);
                  com.tencent.mm.am.q.bhR().Rv(this.iXG);
                  AppMethodBeat.o(95661);
                }
              }, 10000L);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.b.f.a((dq)localObject1, 1);
          i += 1;
          break label640;
          Log.d("AdPassThroughInfoHelper", "NetSceneSnsTimeLine, resp AdvertiseList size is 0");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.lYN) && (paramele.Und.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.u.aY(aj.getAccPath() + "ad.proto", 0, -1);
      localObject2 = new dq();
      ((dq)localObject2).parseFrom((byte[])localObject1);
      paramele.Und.add(localObject2);
      paramele.Unc = paramele.Und.size();
      Log.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramele.Unc);
      if (paramele.Und.size() > 0)
      {
        localObject1 = (dq)paramele.Und.get(0);
        localObject2 = com.tencent.mm.platformtools.z.a(((dq)localObject1).RJa);
        String str3 = com.tencent.mm.platformtools.z.a(((dq)localObject1).RIZ.Ulc);
        str4 = com.tencent.mm.platformtools.z.b(((dq)localObject1).RIZ.Ulb.ObjectDesc);
        Log.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
        Log.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str3)));
        Log.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
        b((dq)localObject1);
      }
      a.a(paramele.Und, paramele.RPF, this.JVe, this.pullType);
      j.f(paramele.Und, false);
      if (paramele.Unc == 0)
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramele.Une) });
        a.f(paramele.Unf, paramele.RPF);
        a.bI(paramele.Unf);
      }
      if (!this.JVe)
      {
        Log.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramele.RPF.size());
        if (paramele.RPF.isEmpty())
        {
          aj.fOI().bbt(str1);
          this.JWf = true;
          this.JVg = this.JVf;
          aZW("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
        continue;
        a(paramele, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = paramele.RPF.iterator();
      while (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
      }
      localObject2 = new xm();
      ((xm)localObject2).fWt.fWu = localLinkedList;
      EventCenter.instance.publish((IEvent)localObject2);
      if (this.rr.lBS.getRetCode() == 207)
      {
        if (paramele.RPF.isEmpty())
        {
          aj.fOI().fSK();
          this.JVg = this.JVf;
        }
        for (;;)
        {
          this.JWf = true;
          aZW("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          aj.fOI().bbu(t.Qv(((SnsObject)paramele.RPF.getFirst()).Id));
          aj.fOI().bbt(t.Qv(((SnsObject)paramele.RPF.getLast()).Id));
          a(paramele, str1);
          j.bM(paramele.RPF);
        }
      }
      if (!paramele.RPF.isEmpty()) {
        break label1879;
      }
    }
    aj.fOI().fSK();
    this.JVg = this.JVf;
    this.JWf = true;
    for (;;)
    {
      aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label1879:
      a(paramele, str1);
      j.bM(paramele.RPF);
    }
  }
  
  private static boolean b(dq paramdq)
  {
    AppMethodBeat.i(95668);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      o.Xk(com.tencent.mm.platformtools.z.b(paramdq.RIZ.Ulb.ObjectDesc));
      aj.fOD();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramdq)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  private void fOc()
  {
    AppMethodBeat.i(95665);
    Object localObject = aj.fOI();
    String str = n.fSQ();
    localObject = ((n)localObject).lvy.rawQuery(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.JWg = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.JWf = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(95669);
    this.callback = parami;
    parami = (eld)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.k.g.Kia.fQo();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      parami.UmS = localLinkedList;
      parami.UmR = parami.UmS.size();
      Log.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      parami.UmT = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vwx, 0);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vwx, Integer.valueOf(0));
      Log.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(parami.UmR), Integer.valueOf(parami.UmT) });
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      parami.UmR = 0;
    }
  }
  
  public final boolean fML()
  {
    return this.JVe;
  }
  
  public final boolean fMM()
  {
    return this.pullType == 1;
  }
  
  public final int fMN()
  {
    return -1;
  }
  
  public final boolean fMO()
  {
    return false;
  }
  
  public final boolean fMP()
  {
    return this.JWf;
  }
  
  public final boolean fMQ()
  {
    return this.JWg;
  }
  
  public final boolean fMR()
  {
    return false;
  }
  
  public final long fMS()
  {
    return this.JVg;
  }
  
  public final boolean fMT()
  {
    return false;
  }
  
  public final long fMU()
  {
    return 0L;
  }
  
  public final String fMV()
  {
    return "";
  }
  
  public final boolean fMW()
  {
    return this.JWh;
  }
  
  public final boolean fOd()
  {
    return this.pullType == 2;
  }
  
  public final int getType()
  {
    return 211;
  }
  
  public final String getUserName()
  {
    return "@__weixintimtline";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95667);
    Log.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (ele)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", false);
    if (this.JVe)
    {
      if (paramArrayOfByte != null)
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.Unj.size()), Integer.valueOf(paramArrayOfByte.RPF.size()) });
        params = aj.fOT();
        LinkedList localLinkedList1 = paramArrayOfByte.Unj;
        LinkedList localLinkedList2 = paramArrayOfByte.RPF;
        LinkedList localLinkedList3 = paramArrayOfByte.Unk;
        aj.etE().post(new av.3(params, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      params = aj.fOU();
      if (as.JZV)
      {
        MMHandlerThread.removeRunnable(params.Kab);
        params.fPt();
        params.reset();
      }
    }
    a(paramArrayOfByte);
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.RPF.size() == 0)
      {
        this.JWh = true;
        aZW("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.JWh = false;
      a(paramArrayOfByte, t.Qv(((SnsObject)paramArrayOfByte.RPF.getFirst()).Id));
      aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if (this.pullType == 2)
    {
      a(paramInt2, paramInt3, paramString, paramArrayOfByte);
      AppMethodBeat.o(95667);
      return;
    }
    b(paramInt2, paramInt3, paramString, paramArrayOfByte);
    AppMethodBeat.o(95667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */