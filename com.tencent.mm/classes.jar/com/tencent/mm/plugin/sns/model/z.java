package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ehq;
import com.tencent.mm.protocal.protobuf.ewq;
import com.tencent.mm.protocal.protobuf.fbc;
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
  extends q
  implements com.tencent.mm.network.m, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> DIh;
  private long DIK;
  private String DIL;
  public boolean DIe;
  long DIf;
  long DIg;
  public int DIi;
  public int DIj;
  private long DJd;
  private final long DJe;
  private boolean DJf;
  private boolean DJg;
  private boolean DJh;
  private w DJi;
  public int akb;
  public com.tencent.mm.ak.i callback;
  private boolean jiQ;
  public int pullType;
  com.tencent.mm.ak.d rr;
  final int sourceType;
  
  static
  {
    AppMethodBeat.i(95670);
    DIh = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public z(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.jiQ = false;
    this.DJd = 0L;
    this.DIf = 0L;
    this.DIg = 0L;
    this.DIK = 0L;
    this.DJe = 102400L;
    this.DIL = "";
    this.DJf = false;
    this.DJg = false;
    this.DIi = 0;
    this.DIj = 0;
    this.akb = 0;
    this.pullType = 0;
    this.DJh = false;
    this.DJi = null;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ebd();
    ((d.a)localObject1).iLO = new ebe();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((d.a)localObject1).funcId = 211;
    ((d.a)localObject1).iLP = 98;
    ((d.a)localObject1).respCmdId = 1000000098;
    this.rr = ((d.a)localObject1).aXF();
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.DIf = paramLong1;
      boolean bool;
      label195:
      ebd localebd;
      int k;
      long l1;
      label257:
      int m;
      Object localObject2;
      label422:
      int j;
      if ((paramLong1 == 0L) && (paramLong2 == 0L))
      {
        bool = true;
        this.DIe = bool;
        this.sourceType = 2;
        localebd = (ebd)this.rr.iLK.iLR;
        localebd.MYL = i;
        localebd.MZh = paramLong1;
        k = aj.faE().fbw();
        localObject1 = aj.faO();
        if (!this.DIe) {
          break label1019;
        }
        l1 = 0L;
        this.DIg = ((com.tencent.mm.plugin.sns.storage.n)localObject1).g(l1, k, true);
        localebd.Nau = this.DIg;
        m = d.a(this.DIg, paramLong1, "@__weixintimtline");
        localebd.Nav = m;
        localebd.NaB = paramLong2;
        if (!this.DIe) {
          break label1025;
        }
        localObject1 = aj.faZ();
        long l2 = ((aw)localObject1).DNM;
        l1 = l2;
        if (((aw)localObject1).DNJ != null)
        {
          l1 = l2;
          if (!Util.isNullOrNil(((aw)localObject1).DNJ.DRY))
          {
            localObject1 = ((aw)localObject1).DNJ.DRY.iterator();
            do
            {
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.j.l)((Iterator)localObject1).next();
            } while (Util.isNullOrNil(((com.tencent.mm.plugin.sns.j.l)localObject2).tbl));
            l1 = ((Long)((com.tencent.mm.plugin.sns.j.l)localObject2).tbl.peekLast()).longValue() - 1L;
          }
        }
        localebd.NaC = l1;
        if (paramInt != 1) {
          break label1031;
        }
        j = 1;
        label438:
        localebd.NaA = j;
        Object localObject3 = aj.faW();
        localObject1 = null;
        localObject2 = null;
        String str = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + x.EmU + " order by SnsWsFoldGroup.top desc limit 1";
        localObject3 = ((x)localObject3).iFy.rawQuery(str, null, 2);
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
        this.DJi = ((w)localObject1);
        if (this.DJi != null) {
          break label1037;
        }
        localebd.NaD = 0L;
        localebd.NaF = 0L;
        label564:
        localebd.NaE = ah.DKg;
        this.pullType = paramInt;
        localObject2 = aj.faS().aQr("@__weixintimtline");
        if (this.DIe)
        {
          this.DIK = aj.faO().g(0L, 1, true);
          Log.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.DIK);
          localebd.Naw = this.DIK;
          if (localObject2 != null) {
            break label1116;
          }
          localObject1 = "";
          label652:
          this.DIL = ((String)localObject1);
          if (this.DIL == null) {
            this.DIL = "";
          }
          localebd.MZg = this.DIL;
        }
        l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdH, 102400L);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession.length <= l1)) {
          break label1126;
        }
      }
      for (localebd.MYJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localebd.MYJ = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession))
      {
        this.DJd = paramLong1;
        Log.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.DIg + " ReqTime:" + localebd.Nav + " nettype: " + i + " MinIdForCheckUnread:" + localebd.NaC + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2 + " NearbyFoldId:" + localebd.NaD + " FoldSectionSize：" + ah.DKg);
        Log.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { r.Jb(paramLong1), r.Jb(this.DIg), Integer.valueOf(m) });
        Log.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
        AppMethodBeat.o(179086);
        return;
        if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
        {
          i = 3;
          break;
        }
        if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
        {
          i = 4;
          break;
        }
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          i = 2;
          break;
        }
        if (!NetStatusUtil.is5G(MMApplicationContext.getContext())) {
          break label1170;
        }
        i = 5;
        break;
        bool = false;
        break label195;
        label1019:
        l1 = paramLong1;
        break label257;
        label1025:
        l1 = 0L;
        break label422;
        label1031:
        j = 0;
        break label438;
        label1037:
        Log.i("MicroMsg.NetSceneSnsTimeLine", "firstFinishWsGroup.size:%s, firstFinishWsGroup.top:%s, firstFinishWsGroup.bottom:%s", new Object[] { Integer.valueOf(this.DJi.field_size), r.Jc(this.DJi.field_top), r.Jc(this.DJi.field_bottom) });
        localebd.NaD = this.DJi.field_top;
        localebd.NaF = this.DJi.field_top;
        break label564;
        label1116:
        localObject1 = ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_md5;
        break label652;
        label1126:
        Log.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_adsession });
      }
      label1170:
      i = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ebe paramebe)
  {
    AppMethodBeat.i(202729);
    if (paramebe.KOH.size() == 0)
    {
      aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(202729);
      return;
    }
    Iterator localIterator = paramebe.KOH.iterator();
    while (localIterator.hasNext()) {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramebe, r.Jc(this.DIf));
    aPb("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(202729);
  }
  
  private static void a(ebe paramebe)
  {
    AppMethodBeat.i(202728);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramebe != null) {
      if (!Util.isNullOrNil(paramebe.KOH))
      {
        localObject1 = new ArrayList();
        localObject2 = paramebe.KOH.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SnsObject)((Iterator)localObject2).next();
          if ((localObject3 != null) && (an.YA(((SnsObject)localObject3).ExtFlag))) {
            ((List)localObject1).add(Long.valueOf(((SnsObject)localObject3).Id));
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          aj.faX().JO(((Long)localObject2).longValue());
        }
      }
    }
    label605:
    label874:
    for (;;)
    {
      int k;
      int i;
      try
      {
        localObject1 = new fbc();
        ((fbc)localObject1).parseFrom(com.tencent.mm.platformtools.z.a(paramebe.NaR));
        if (!Util.isNullOrNil(((fbc)localObject1).Nxs))
        {
          k = ((fbc)localObject1).Nxs.size() / ah.DKg;
          Log.i("MicroMsg.NetSceneSnsTimeLine", "wsInfo.timeline_idx.size:%s, SnsConfig.wsFoldGroupSize:%s, tmp:%s", new Object[] { Integer.valueOf(((fbc)localObject1).Nxs.size()), Integer.valueOf(ah.DKg), Integer.valueOf(k) });
          if (k != 0) {
            break label860;
          }
          paramebe = new w();
          paramebe.field_top = ((ehq)((fbc)localObject1).Nxs.getFirst()).MuD;
          paramebe.field_bottom = ((ehq)((fbc)localObject1).Nxs.getLast()).MuD;
          paramebe.field_size = ((fbc)localObject1).Nxs.size();
          if (paramebe.field_size != ah.DKg) {
            break label605;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert topId:%s, bottomId:%s", new Object[] { r.Jc(paramebe.field_top), r.Jc(paramebe.field_bottom) });
          aj.faW().a(paramebe);
        }
        if (Util.isNullOrNil(((fbc)localObject1).Ltx)) {
          break label850;
        }
        paramebe = ((fbc)localObject1).Ltx.iterator();
        if (!paramebe.hasNext()) {
          break label850;
        }
        localObject1 = (ewq)paramebe.next();
        if ((localObject1 == null) || (Util.isNullOrNil(((ewq)localObject1).KOJ)) || (((ewq)localObject1).Nul == null)) {
          continue;
        }
        long l = ((ewq)localObject1).Nuj;
        i = ((ewq)localObject1).Nuk;
        new SnsObject().parseFrom(((ewq)localObject1).Nul.toByteArray());
        localObject2 = new ebn();
        ((ebn)localObject2).Nbk.addAll(((ewq)localObject1).KOJ);
        ((ebn)localObject2).Nbl = com.tencent.mm.modelsns.n.PM(new String(((ewq)localObject1).Nul.ObjectDesc.getBuffer().toByteArray())).ContentDesc;
        localObject3 = new u();
        ((u)localObject3).field_groupId = l;
        ((u)localObject3).field_groupTime = i;
        ((u)localObject3).field_groupStrcut = ((ebn)localObject2).toByteArray();
        aj.faX().a((u)localObject3);
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(((ewq)localObject1).Nul);
        an.a("@__weixintimtline", 128, (LinkedList)localObject2, r.Jc(((ewq)localObject1).Nul.Id));
        continue;
        AppMethodBeat.o(202728);
      }
      catch (Exception paramebe)
      {
        Log.w("MicroMsg.NetSceneSnsTimeLine", "parse WSInfo err: %s", new Object[] { paramebe.getMessage() });
      }
      return;
      Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, field_size:%s", new Object[] { Integer.valueOf(paramebe.field_size) });
      continue;
      for (;;)
      {
        if (i >= k) {
          break label874;
        }
        int m = ((fbc)localObject1).Nxs.size() - 1 - ah.DKg * i;
        int j = m - ah.DKg + 1;
        if (j < 0) {
          j = 0;
        }
        for (;;)
        {
          paramebe = new w();
          paramebe.field_top = ((ehq)((fbc)localObject1).Nxs.get(j)).MuD;
          paramebe.field_bottom = ((ehq)((fbc)localObject1).Nxs.get(m)).MuD;
          paramebe.field_size = (m - j + 1);
          if (paramebe.field_size == ah.DKg)
          {
            Log.i("MicroMsg.NetSceneSnsTimeLine", "insert index:%s, topIndex:%s, bottomIndex:%s, topId:%s, bottomId:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), r.Jc(paramebe.field_top), r.Jc(paramebe.field_bottom) });
            aj.faW().a(paramebe);
            break;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, index:%s, topIndex:%s, bottomIndex:%s, field_size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramebe.field_size) });
          break;
          AppMethodBeat.o(202728);
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
  
  private void a(ebe paramebe, String paramString)
  {
    AppMethodBeat.i(95666);
    an.a("@__weixintimtline", this.sourceType, paramebe.KOH, paramString);
    this.DIg = ((SnsObject)paramebe.KOH.getLast()).Id;
    if (this.DIf == 0L) {
      this.DIf = ((SnsObject)paramebe.KOH.getFirst()).Id;
    }
    for (;;)
    {
      d.f("@__weixintimtline", this.DIf, this.DIg, paramebe.NaG);
      try
      {
        paramebe = paramebe.KOH.iterator();
        for (;;)
        {
          if (paramebe.hasNext())
          {
            paramString = (SnsObject)paramebe.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = aj.faO().JJ(paramString.Id);
              if ((localObject != null) && (((SnsInfo)localObject).getTimeLine() != null))
              {
                int i = ((SnsInfo)localObject).getTypeFlag();
                if (i == 15)
                {
                  try
                  {
                    localObject = ((cnb)((SnsInfo)localObject).getTimeLine().ContentObj.LoV.get(0)).Url;
                    com.tencent.mm.plugin.report.service.h.CyF.a(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.DIf = d.Jf(this.DIf);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramebe)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean aPa(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 733
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/z:DIh	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 736	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 733
    //   24: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/z:DIh	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 737	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 733
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
  
  public static boolean aPb(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      DIh.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, ebe paramebe)
  {
    AppMethodBeat.i(179087);
    if (paramebe.MZl != null)
    {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramebe.MZl.Naq + " " + paramebe.MZl.Nap);
      i = paramebe.MZl.Naq;
      com.tencent.mm.plugin.sns.c.a.DCT = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.c.a.DCT = 2147483647;
      }
      com.tencent.mm.storage.aq.NSd = paramebe.MZl.Nap;
    }
    this.DIi = paramebe.MZk;
    this.DIj = paramebe.xuw;
    Log.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramebe.MZk + " , objCount:  " + paramebe.MvM + " cflag : " + paramebe.xuw);
    this.akb = paramebe.MvM;
    String str1 = r.Jc(this.DIf);
    Object localObject1;
    if (!paramebe.KOH.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramebe.KOH.size()).append(" Max ").append(((SnsObject)paramebe.KOH.getFirst()).Id).append(" ").append(r.Jb(((SnsObject)paramebe.KOH.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramebe.KOH.getLast()).Id).append(" ").append(r.Jb(((SnsObject)paramebe.KOH.getLast()).Id)).append(" adCount=");
      if (paramebe.NaI == null)
      {
        i = 0;
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        com.tencent.mm.plugin.sns.ad.e.c.c(paramebe.NaM, paramebe.NaL, 0);
        if (!this.DIL.equals(paramebe.MZg)) {
          break label544;
        }
        paramebe = aj.faO();
        if (!this.DIe) {
          break label535;
        }
      }
    }
    label535:
    for (long l1 = 0L;; l1 = this.DJd)
    {
      this.DIg = paramebe.g(l1, this.DIi, true);
      Log.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.DIg) });
      faj();
      aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      i = paramebe.NaI.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramebe.NaI == null) {}
      for (i = 0;; i = paramebe.NaI.size())
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
    }
    label544:
    aj.faS().g("@__weixintimtline", paramebe.MZg, com.tencent.mm.platformtools.z.a(paramebe.MYJ));
    Log.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramebe.KOH.size() + " adsize : " + paramebe.NaH);
    int i = 0;
    String str4;
    long l2;
    for (;;)
    {
      if (i < paramebe.NaI.size())
      {
        localObject1 = (ds)paramebe.NaI.get(i);
        String str2;
        if (this.jiQ) {
          str2 = aj.getAccPath() + "ad.proto";
        }
        try
        {
          Object localObject3 = ((ds)localObject1).toByteArray();
          com.tencent.mm.vfs.s.f(str2, (byte[])localObject3, localObject3.length);
          localObject3 = com.tencent.mm.platformtools.z.a(((ds)localObject1).KHH);
          str2 = com.tencent.mm.platformtools.z.a(((ds)localObject1).KHG.MYI);
          str4 = com.tencent.mm.platformtools.z.b(((ds)localObject1).KHG.MYH.ObjectDesc);
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
              if (((ds)localObject1).KHG != null)
              {
                l1 = l3;
                l2 = l3;
                if (((ds)localObject1).KHG.MYH != null)
                {
                  l2 = l3;
                  l1 = Util.nullAsNil(Long.valueOf(((ds)localObject1).KHG.MYH.Id));
                }
              }
              l2 = l1;
              com.tencent.mm.plugin.sns.data.i.d(l1, (String)localObject3, str2);
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
          localObject3 = ((ds)localObject1).KHG.MYH.Username;
          if (!Util.isNullOrNil((String)localObject3))
          {
            bool = com.tencent.mm.plugin.sns.data.k.aOd(str2);
            Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + (String)localObject3 + ", isUsePreferedInfo=" + bool + ", snsId=" + r.Jc(l1));
            if (!bool)
            {
              ay.a.iDq.aL((String)localObject3, "");
              com.tencent.f.h.RTc.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(95661);
                  Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.gtu);
                  com.tencent.mm.aj.c.Mf(this.gtu);
                  p.aYD().Mh(this.gtu);
                  AppMethodBeat.o(95661);
                }
              }, 10000L);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.b.e.a((ds)localObject1);
          i += 1;
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
    if ((this.jiQ) && (paramebe.NaI.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.s.aW(aj.getAccPath() + "ad.proto", 0, -1);
      localObject2 = new ds();
      ((ds)localObject2).parseFrom((byte[])localObject1);
      paramebe.NaI.add(localObject2);
      paramebe.NaH = paramebe.NaI.size();
      Log.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramebe.NaH);
      if (paramebe.NaI.size() > 0)
      {
        localObject1 = (ds)paramebe.NaI.get(0);
        localObject2 = com.tencent.mm.platformtools.z.a(((ds)localObject1).KHH);
        String str3 = com.tencent.mm.platformtools.z.a(((ds)localObject1).KHG.MYI);
        str4 = com.tencent.mm.platformtools.z.b(((ds)localObject1).KHG.MYH.ObjectDesc);
        Log.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
        Log.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str3)));
        Log.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
        c((ds)localObject1);
      }
      a.a(paramebe.NaI, paramebe.KOH, this.DIe, this.pullType);
      j.d(paramebe.NaI, false);
      if (paramebe.NaH == 0)
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramebe.NaJ) });
        a.e(paramebe.NaK, paramebe.KOH);
        a.bo(paramebe.NaK);
      }
      if (!this.DIe)
      {
        Log.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramebe.KOH.size());
        if (paramebe.KOH.isEmpty())
        {
          aj.faO().aQt(str1);
          this.DJf = true;
          this.DIg = this.DIf;
          aPb("@__weixintimtline");
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
        a(paramebe, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = paramebe.KOH.iterator();
      while (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
      }
      localObject2 = new wh();
      ((wh)localObject2).ecr.ecs = localLinkedList;
      EventCenter.instance.publish((IEvent)localObject2);
      if (this.rr.iLL.getRetCode() == 207)
      {
        if (paramebe.KOH.isEmpty())
        {
          aj.faO().feP();
          this.DIg = this.DIf;
        }
        for (;;)
        {
          this.DJf = true;
          aPb("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          aj.faO().aQu(r.Jc(((SnsObject)paramebe.KOH.getFirst()).Id));
          aj.faO().aQt(r.Jc(((SnsObject)paramebe.KOH.getLast()).Id));
          a(paramebe, str1);
          j.br(paramebe.KOH);
        }
      }
      if (!paramebe.KOH.isEmpty()) {
        break label1839;
      }
    }
    aj.faO().feP();
    this.DIg = this.DIf;
    this.DJf = true;
    for (;;)
    {
      aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label1839:
      a(paramebe, str1);
      j.br(paramebe.KOH);
    }
  }
  
  private static boolean c(ds paramds)
  {
    AppMethodBeat.i(95668);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.n.PM(com.tencent.mm.platformtools.z.b(paramds.KHG.MYH.ObjectDesc));
      aj.faJ();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramds)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  private void faj()
  {
    AppMethodBeat.i(95665);
    Object localObject = aj.faO();
    String str = com.tencent.mm.plugin.sns.storage.n.feW();
    localObject = ((com.tencent.mm.plugin.sns.storage.n)localObject).iFy.rawQuery(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.DJg = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.DJf = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95669);
    this.callback = parami;
    parami = (ebd)this.rr.iLK.iLR;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.k.e.DUQ.fcv();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      parami.Nay = localLinkedList;
      parami.Nax = parami.Nay.size();
      Log.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      parami.Naz = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Oih, 0);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oih, Integer.valueOf(0));
      Log.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(parami.Nax), Integer.valueOf(parami.Naz) });
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      parami.Nax = 0;
    }
  }
  
  public final boolean eYW()
  {
    return this.DIe;
  }
  
  public final boolean eYX()
  {
    return this.pullType == 1;
  }
  
  public final int eYY()
  {
    return -1;
  }
  
  public final boolean eYZ()
  {
    return false;
  }
  
  public final boolean eZa()
  {
    return this.DJf;
  }
  
  public final boolean eZb()
  {
    return this.DJg;
  }
  
  public final boolean eZc()
  {
    return false;
  }
  
  public final long eZd()
  {
    return this.DIg;
  }
  
  public final boolean eZe()
  {
    return false;
  }
  
  public final long eZf()
  {
    return 0L;
  }
  
  public final String eZg()
  {
    return "";
  }
  
  public final boolean eZh()
  {
    return this.DJh;
  }
  
  public final boolean fak()
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95667);
    Log.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (ebe)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", false);
    if (this.DIe)
    {
      if (paramArrayOfByte != null)
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.NaP.size()), Integer.valueOf(paramArrayOfByte.KOH.size()) });
        params = aj.faZ();
        LinkedList localLinkedList1 = paramArrayOfByte.NaP;
        LinkedList localLinkedList2 = paramArrayOfByte.KOH;
        LinkedList localLinkedList3 = paramArrayOfByte.NaQ;
        aj.dRd().post(new aw.2(params, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      params = aj.fba();
      if (at.DMT)
      {
        MMHandlerThread.removeRunnable(params.DMZ);
        params.fbA();
        params.reset();
      }
    }
    a(paramArrayOfByte);
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.KOH.size() == 0)
      {
        this.DJh = true;
        aPb("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.DJh = false;
      a(paramArrayOfByte, r.Jc(((SnsObject)paramArrayOfByte.KOH.getFirst()).Id));
      aPb("@__weixintimtline");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */