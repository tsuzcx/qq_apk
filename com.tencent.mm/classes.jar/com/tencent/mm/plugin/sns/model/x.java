package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k, com.tencent.mm.plugin.sns.c.b
{
  private static Vector<String> wEV;
  public int ahd;
  public com.tencent.mm.al.g callback;
  private boolean hqZ;
  public int pullType;
  com.tencent.mm.al.b rr;
  final int sourceType;
  public boolean wES;
  long wET;
  long wEU;
  public int wEW;
  public int wEX;
  private long wFQ;
  private final long wFR;
  private boolean wFS;
  private boolean wFT;
  private boolean wFU;
  private long wFx;
  private String wFy;
  
  static
  {
    AppMethodBeat.i(95670);
    wEV = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public x(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.hqZ = false;
    this.wFQ = 0L;
    this.wET = 0L;
    this.wEU = 0L;
    this.wFx = 0L;
    this.wFR = 102400L;
    this.wFy = "";
    this.wFS = false;
    this.wFT = false;
    this.wEW = 0;
    this.wEX = 0;
    this.ahd = 0;
    this.pullType = 0;
    this.wFU = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).gUU = new cwb();
    ((com.tencent.mm.al.b.a)localObject1).gUV = new cwc();
    ((com.tencent.mm.al.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((com.tencent.mm.al.b.a)localObject1).funcId = 211;
    ((com.tencent.mm.al.b.a)localObject1).reqCmdId = 98;
    ((com.tencent.mm.al.b.a)localObject1).respCmdId = 1000000098;
    this.rr = ((com.tencent.mm.al.b.a)localObject1).atI();
    int i;
    if (ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.wET = paramLong1;
      boolean bool;
      label190:
      cwb localcwb;
      int k;
      long l1;
      label252:
      int m;
      Object localObject2;
      label417:
      int j;
      if ((paramLong1 == 0L) && (paramLong2 == 0L))
      {
        bool = true;
        this.wES = bool;
        this.sourceType = 2;
        localcwb = (cwb)this.rr.gUS.gUX;
        localcwb.ElS = i;
        localcwb.Emo = paramLong1;
        k = af.dtk().dtX();
        localObject1 = af.dtu();
        if (!this.wES) {
          break label861;
        }
        l1 = 0L;
        this.wEU = ((com.tencent.mm.plugin.sns.storage.q)localObject1).f(l1, k, true);
        localcwb.Enz = this.wEU;
        m = c.a(this.wEU, paramLong1, "@__weixintimtline");
        localcwb.EnA = m;
        localcwb.EnG = paramLong2;
        if (!this.wES) {
          break label867;
        }
        localObject1 = af.dtD();
        long l2 = ((ar)localObject1).wJQ;
        l1 = l2;
        if (((ar)localObject1).wJN != null)
        {
          l1 = l2;
          if (!bt.gL(((ar)localObject1).wJN.wOf))
          {
            localObject1 = ((ar)localObject1).wJN.wOf.iterator();
            do
            {
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.j.k)((Iterator)localObject1).next();
            } while (bt.gL(((com.tencent.mm.plugin.sns.j.k)localObject2).qaM));
            l1 = ((Long)((com.tencent.mm.plugin.sns.j.k)localObject2).qaM.peekLast()).longValue() - 1L;
          }
        }
        localcwb.EnH = l1;
        if (paramInt != 1) {
          break label873;
        }
        j = 1;
        label433:
        localcwb.EnF = j;
        this.pullType = paramInt;
        localObject2 = af.dty().apP("@__weixintimtline");
        if (this.wES)
        {
          this.wFx = af.dtu().f(0L, 1, true);
          ad.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.wFx);
          localcwb.EnB = this.wFx;
          if (localObject2 != null) {
            break label879;
          }
          localObject1 = "";
          label520:
          this.wFy = ((String)localObject1);
          if (this.wFy == null) {
            this.wFy = "";
          }
          localcwb.Emn = this.wFy;
        }
        l1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psi, 102400L);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession.length <= l1)) {
          break label889;
        }
      }
      for (localcwb.ElQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localcwb.ElQ = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession))
      {
        this.wFQ = paramLong1;
        ad.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.wEU + " ReqTime:" + localcwb.EnA + " nettype: " + i + " MinIdForCheckUnread:" + localcwb.EnH + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2);
        ad.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramLong1), com.tencent.mm.plugin.sns.data.q.st(this.wEU), Integer.valueOf(m) });
        ad.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
        AppMethodBeat.o(179086);
        return;
        if (ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = 3;
          break;
        }
        if (ay.is4G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = 4;
          break;
        }
        if (ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = 2;
          break;
        }
        if (!ay.is5G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
          break label933;
        }
        i = 5;
        break;
        bool = false;
        break label190;
        label861:
        l1 = paramLong1;
        break label252;
        label867:
        l1 = 0L;
        break label417;
        label873:
        j = 0;
        break label433;
        label879:
        localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_md5;
        break label520;
        label889:
        ad.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession });
      }
      label933:
      i = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, cwc paramcwc)
  {
    AppMethodBeat.i(187326);
    if (paramcwc.CEH.size() == 0)
    {
      aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(187326);
      return;
    }
    Iterator localIterator = paramcwc.CEH.iterator();
    while (localIterator.hasNext()) {
      ad.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramcwc, com.tencent.mm.plugin.sns.data.q.su(this.wET));
    aox("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(187326);
  }
  
  private void a(cwc paramcwc, String paramString)
  {
    AppMethodBeat.i(95666);
    aj.b("@__weixintimtline", this.sourceType, paramcwc.CEH, paramString);
    this.wEU = ((SnsObject)paramcwc.CEH.getLast()).Id;
    if (this.wET == 0L) {
      this.wET = ((SnsObject)paramcwc.CEH.getFirst()).Id;
    }
    for (;;)
    {
      c.e("@__weixintimtline", this.wET, this.wEU, paramcwc.EnI);
      try
      {
        paramcwc = paramcwc.CEH.iterator();
        for (;;)
        {
          if (paramcwc.hasNext())
          {
            paramString = (SnsObject)paramcwc.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = af.dtu().th(paramString.Id);
              if ((localObject != null) && (((p)localObject).dxy() != null))
              {
                int i = ((p)localObject).field_type;
                if (i == 15)
                {
                  try
                  {
                    localObject = ((bpi)((p)localObject).dxy().Etm.DaC.get(0)).Url;
                    com.tencent.mm.plugin.report.service.h.vKh.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.wET = c.sz(this.wET);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramcwc)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  private static boolean a(dg paramdg)
  {
    AppMethodBeat.i(95668);
    if (!ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.g.zn(z.b(paramdg.CxS.ElO.ObjectDesc));
      af.dtp();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramdg)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  /* Error */
  public static boolean aow(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 541
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 51	com/tencent/mm/plugin/sns/model/x:wEV	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 545	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 541
    //   24: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 51	com/tencent/mm/plugin/sns/model/x:wEV	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 548	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 541
    //   45: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aox(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      wEV.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, cwc paramcwc)
  {
    AppMethodBeat.i(179087);
    if (paramcwc.Emt != null)
    {
      ad.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramcwc.Emt.Env + " " + paramcwc.Emt.Enu);
      i = paramcwc.Emt.Env;
      com.tencent.mm.plugin.sns.d.a.wzN = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.d.a.wzN = 2147483647;
      }
      com.tencent.mm.storage.ad.FfG = paramcwc.Emt.Enu;
    }
    this.wEW = paramcwc.Emr;
    this.wEX = paramcwc.Ems;
    ad.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramcwc.Emr + " , objCount:  " + paramcwc.DOR + " cflag : " + paramcwc.Ems);
    this.ahd = paramcwc.DOR;
    String str1 = com.tencent.mm.plugin.sns.data.q.su(this.wET);
    Object localObject1;
    label422:
    long l1;
    Object localObject2;
    if (!paramcwc.CEH.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramcwc.CEH.size()).append(" Max ").append(((SnsObject)paramcwc.CEH.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.st(((SnsObject)paramcwc.CEH.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramcwc.CEH.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.st(((SnsObject)paramcwc.CEH.getLast()).Id)).append(" adCount=");
      if (paramcwc.EnK == null)
      {
        i = 0;
        ad.i("MicroMsg.NetSceneSnsTimeLine", i);
        if (paramcwc.EnN <= 0) {
          break label679;
        }
        ad.i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramcwc.EnN) });
        if ((paramcwc.EnO == null) || (paramcwc.EnO.size() != paramcwc.EnN)) {
          break label679;
        }
        localObject1 = new LinkedList();
        i = 0;
        if (i >= paramcwc.EnN) {
          break label647;
        }
        l1 = ((zo)paramcwc.EnO.get(i)).Id;
        ad.i("MicroMsg.NetSceneSnsTimeLine", "delete ad %s", new Object[] { Long.valueOf(l1) });
        if (l1 != 0L)
        {
          localObject2 = af.dtx().sY(l1);
          if (localObject2 != null) {
            break label579;
          }
          ad.i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label579:
    Object localObject4;
    for (;;)
    {
      i += 1;
      break label422;
      i = paramcwc.EnK.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramcwc.EnK == null) {}
      for (i = 0;; i = paramcwc.EnK.size())
      {
        ad.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
      localObject4 = new bv();
      ((bv)localObject4).CwP = 13298;
      ((bv)localObject4).CwQ = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).dxu().dvK.getBytes());
      ((bv)localObject4).rOh = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.sv(l1);
    }
    label647:
    if (((LinkedList)localObject1).size() > 0)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new k((LinkedList)localObject1), 0);
    }
    label679:
    if (this.wFy.equals(paramcwc.Emn))
    {
      paramcwc = af.dtu();
      if (this.wES) {}
      for (l1 = 0L;; l1 = this.wFQ)
      {
        this.wEU = paramcwc.f(l1, this.wEW, true);
        ad.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.wEU) });
        dsR();
        aox("@__weixintimtline");
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
        AppMethodBeat.o(179087);
        return;
      }
    }
    af.dty().g("@__weixintimtline", paramcwc.Emn, z.a(paramcwc.ElQ));
    ad.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramcwc.CEH.size() + " adsize : " + paramcwc.EnJ);
    int i = 0;
    String str2;
    for (;;)
    {
      if (i < paramcwc.EnK.size())
      {
        localObject1 = (dg)paramcwc.EnK.get(i);
        if (this.hqZ) {
          localObject2 = af.getAccPath() + "ad.proto";
        }
        try
        {
          localObject4 = ((dg)localObject1).toByteArray();
          com.tencent.mm.vfs.i.f((String)localObject2, (byte[])localObject4, localObject4.length);
          localObject2 = z.a(((dg)localObject1).CxT);
          localObject4 = z.a(((dg)localObject1).CxS.ElP);
          str2 = z.b(((dg)localObject1).CxS.ElO.ObjectDesc);
          ad.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
          ad.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
          ad.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
          com.tencent.mm.plugin.sns.waid.g.aqW((String)localObject2);
          try
          {
            if (!bt.T(new String[] { localObject2, localObject4 }))
            {
              long l2 = 0L;
              l1 = l2;
              if (((dg)localObject1).CxS != null)
              {
                l1 = l2;
                if (((dg)localObject1).CxS.ElO != null) {
                  l1 = bt.f(Long.valueOf(((dg)localObject1).CxS.ElO.Id));
                }
              }
              com.tencent.mm.plugin.sns.data.h.c(l1, (String)localObject2, (String)localObject4);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ad.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localThrowable.toString());
            }
          }
          localObject2 = ((dg)localObject1).CxS.ElO.Username;
          if (!bt.isNullOrNil((String)localObject2))
          {
            ad.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject2)));
            ar.a.gMW.aB((String)localObject2, "");
            com.tencent.e.h.Iye.q(new x.1(this, (String)localObject2), 10000L);
          }
          com.tencent.mm.plugin.sns.data.j.a((dg)localObject1);
          i += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.hqZ) && (paramcwc.EnK.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.i.aR(af.getAccPath() + "ad.proto", 0, -1);
      localObject3 = new dg();
      ((dg)localObject3).parseFrom((byte[])localObject1);
      paramcwc.EnK.add(localObject3);
      paramcwc.EnJ = paramcwc.EnK.size();
      ad.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramcwc.EnJ);
      if (paramcwc.EnK.size() > 0)
      {
        localObject1 = (dg)paramcwc.EnK.get(0);
        localObject3 = z.a(((dg)localObject1).CxT);
        localObject4 = z.a(((dg)localObject1).CxS.ElP);
        str2 = z.b(((dg)localObject1).CxS.ElO.ObjectDesc);
        ad.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
        ad.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
        ad.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
        a((dg)localObject1);
      }
      a.y(paramcwc.EnK, paramcwc.CEH);
      a.aJ(paramcwc.EnK);
      if (paramcwc.EnJ == 0)
      {
        ad.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramcwc.EnL) });
        a.e(paramcwc.EnM, paramcwc.CEH);
        a.aI(paramcwc.EnM);
      }
      if (!this.wES)
      {
        ad.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramcwc.CEH.size());
        if (paramcwc.CEH.isEmpty())
        {
          af.dtu().apR(str1);
          this.wFS = true;
          this.wEU = this.wET;
          aox("@__weixintimtline");
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
        ad.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
        continue;
        a(paramcwc, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = paramcwc.CEH.iterator();
      while (((Iterator)localObject3).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
      }
      localObject3 = new ua();
      ((ua)localObject3).dzq.dzr = localLinkedList;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
      if (this.rr.gUT.getRetCode() == 207)
      {
        if (paramcwc.CEH.isEmpty())
        {
          af.dtu().dyo();
          this.wEU = this.wET;
        }
        for (;;)
        {
          this.wFS = true;
          aox("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          af.dtu().apS(com.tencent.mm.plugin.sns.data.q.su(((SnsObject)paramcwc.CEH.getFirst()).Id));
          af.dtu().apR(com.tencent.mm.plugin.sns.data.q.su(((SnsObject)paramcwc.CEH.getLast()).Id));
          a(paramcwc, str1);
          a.aK(paramcwc.CEH);
        }
      }
      if (!paramcwc.CEH.isEmpty()) {
        break label2006;
      }
    }
    af.dtu().dyo();
    this.wEU = this.wET;
    this.wFS = true;
    for (;;)
    {
      aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label2006:
      a(paramcwc, str1);
      a.aK(paramcwc.CEH);
    }
  }
  
  private void dsR()
  {
    AppMethodBeat.i(95665);
    Object localObject = af.dtu();
    String str = com.tencent.mm.plugin.sns.storage.q.dyt();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.wFT = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.wFS = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(95669);
    this.callback = paramg;
    paramg = (cwb)this.rr.gUS.gUX;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.k.f.wQY.duU();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramg.EnD = localLinkedList;
      paramg.EnC = paramg.EnD.size();
      ad.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramg.EnE = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.FuD, 0);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuD, Integer.valueOf(0));
      ad.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramg.EnC), Integer.valueOf(paramg.EnE) });
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      paramg.EnC = 0;
    }
  }
  
  public final boolean drB()
  {
    return this.wES;
  }
  
  public final boolean drC()
  {
    return this.pullType == 1;
  }
  
  public final int drD()
  {
    return -1;
  }
  
  public final boolean drE()
  {
    return false;
  }
  
  public final boolean drF()
  {
    return this.wFS;
  }
  
  public final boolean drG()
  {
    return this.wFT;
  }
  
  public final boolean drH()
  {
    return false;
  }
  
  public final long drI()
  {
    return this.wEU;
  }
  
  public final boolean drJ()
  {
    return false;
  }
  
  public final long drK()
  {
    return 0L;
  }
  
  public final String drL()
  {
    return "";
  }
  
  public final boolean drM()
  {
    return this.wFU;
  }
  
  public final boolean dsS()
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95667);
    ad.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (cwc)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if ((this.wES) && (paramArrayOfByte != null))
    {
      ad.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.EnQ.size()), Integer.valueOf(paramArrayOfByte.CEH.size()) });
      paramq = af.dtD();
      LinkedList localLinkedList1 = paramArrayOfByte.EnQ;
      LinkedList localLinkedList2 = paramArrayOfByte.CEH;
      LinkedList localLinkedList3 = paramArrayOfByte.EnR;
      af.czA().post(new ar.2(paramq, localLinkedList1, localLinkedList2, localLinkedList3));
    }
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.CEH.size() == 0)
      {
        this.wFU = true;
        aox("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.wFU = false;
      a(paramArrayOfByte, "");
      aox("@__weixintimtline");
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */