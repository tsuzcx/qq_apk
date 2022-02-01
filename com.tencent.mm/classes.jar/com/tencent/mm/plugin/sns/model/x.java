package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> zhk;
  public int ajO;
  public com.tencent.mm.al.f callback;
  private boolean ikP;
  public int pullType;
  com.tencent.mm.al.b rr;
  final int sourceType;
  private long zhL;
  private String zhM;
  public boolean zhh;
  long zhi;
  long zhj;
  public int zhl;
  public int zhm;
  private long zie;
  private final long zif;
  private boolean zig;
  private boolean zih;
  private boolean zii;
  
  static
  {
    AppMethodBeat.i(95670);
    zhk = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public x(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.ikP = false;
    this.zie = 0L;
    this.zhi = 0L;
    this.zhj = 0L;
    this.zhL = 0L;
    this.zif = 102400L;
    this.zhM = "";
    this.zig = false;
    this.zih = false;
    this.zhl = 0;
    this.zhm = 0;
    this.ajO = 0;
    this.pullType = 0;
    this.zii = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).hNM = new dha();
    ((com.tencent.mm.al.b.a)localObject1).hNN = new dhb();
    ((com.tencent.mm.al.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((com.tencent.mm.al.b.a)localObject1).funcId = 211;
    ((com.tencent.mm.al.b.a)localObject1).hNO = 98;
    ((com.tencent.mm.al.b.a)localObject1).respCmdId = 1000000098;
    this.rr = ((com.tencent.mm.al.b.a)localObject1).aDC();
    int i;
    if (ay.isWifi(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.zhi = paramLong1;
      boolean bool;
      label190:
      dha localdha;
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
        this.zhh = bool;
        this.sourceType = 2;
        localdha = (dha)this.rr.hNK.hNQ;
        localdha.Htz = i;
        localdha.HtV = paramLong1;
        k = ag.dTU().dUI();
        localObject1 = ag.dUe();
        if (!this.zhh) {
          break label861;
        }
        l1 = 0L;
        this.zhj = ((com.tencent.mm.plugin.sns.storage.q)localObject1).f(l1, k, true);
        localdha.Hvg = this.zhj;
        m = c.a(this.zhj, paramLong1, "@__weixintimtline");
        localdha.Hvh = m;
        localdha.Hvn = paramLong2;
        if (!this.zhh) {
          break label867;
        }
        localObject1 = ag.dUn();
        long l2 = ((at)localObject1).zmt;
        l1 = l2;
        if (((at)localObject1).zmq != null)
        {
          l1 = l2;
          if (!bt.hj(((at)localObject1).zmq.zqI))
          {
            localObject1 = ((at)localObject1).zmq.zqI.iterator();
            do
            {
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.i.k)((Iterator)localObject1).next();
            } while (bt.hj(((com.tencent.mm.plugin.sns.i.k)localObject2).rtu));
            l1 = ((Long)((com.tencent.mm.plugin.sns.i.k)localObject2).rtu.peekLast()).longValue() - 1L;
          }
        }
        localdha.Hvo = l1;
        if (paramInt != 1) {
          break label873;
        }
        j = 1;
        label433:
        localdha.Hvm = j;
        this.pullType = paramInt;
        localObject2 = ag.dUi().aAf("@__weixintimtline");
        if (this.zhh)
        {
          this.zhL = ag.dUe().f(0L, 1, true);
          ad.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.zhL);
          localdha.Hvi = this.zhL;
          if (localObject2 != null) {
            break label879;
          }
          localObject1 = "";
          label520:
          this.zhM = ((String)localObject1);
          if (this.zhM == null) {
            this.zhM = "";
          }
          localdha.HtU = this.zhM;
        }
        l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBh, 102400L);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession.length <= l1)) {
          break label889;
        }
      }
      for (localdha.Htx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdha.Htx = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession))
      {
        this.zie = paramLong1;
        ad.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.zhj + " ReqTime:" + localdha.Hvh + " nettype: " + i + " MinIdForCheckUnread:" + localdha.Hvo + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2);
        ad.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramLong1), com.tencent.mm.plugin.sns.data.q.zw(this.zhj), Integer.valueOf(m) });
        ad.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
        AppMethodBeat.o(179086);
        return;
        if (ay.is3G(aj.getContext()))
        {
          i = 3;
          break;
        }
        if (ay.is4G(aj.getContext()))
        {
          i = 4;
          break;
        }
        if (ay.is2G(aj.getContext()))
        {
          i = 2;
          break;
        }
        if (!ay.is5G(aj.getContext())) {
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
  
  private void a(int paramInt1, int paramInt2, String paramString, dhb paramdhb)
  {
    AppMethodBeat.i(197843);
    if (paramdhb.FCD.size() == 0)
    {
      ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(197843);
      return;
    }
    Iterator localIterator = paramdhb.FCD.iterator();
    while (localIterator.hasNext()) {
      ad.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramdhb, com.tencent.mm.plugin.sns.data.q.zx(this.zhi));
    ayO("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(197843);
  }
  
  private void a(dhb paramdhb, String paramString)
  {
    AppMethodBeat.i(95666);
    ak.b("@__weixintimtline", this.sourceType, paramdhb.FCD, paramString);
    this.zhj = ((SnsObject)paramdhb.FCD.getLast()).Id;
    if (this.zhi == 0L) {
      this.zhi = ((SnsObject)paramdhb.FCD.getFirst()).Id;
    }
    for (;;)
    {
      c.f("@__weixintimtline", this.zhi, this.zhj, paramdhb.Hvp);
      try
      {
        paramdhb = paramdhb.FCD.iterator();
        for (;;)
        {
          if (paramdhb.hasNext())
          {
            paramString = (SnsObject)paramdhb.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = ag.dUe().Ai(paramString.Id);
              if ((localObject != null) && (((p)localObject).dYl() != null))
              {
                int i = ((p)localObject).field_type;
                if (i == 15)
                {
                  try
                  {
                    localObject = ((byn)((p)localObject).dYl().HAT.GaQ.get(0)).Url;
                    com.tencent.mm.plugin.report.service.g.yhR.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.zhi = c.zB(this.zhi);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramdhb)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean ayN(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 508
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 51	com/tencent/mm/plugin/sns/model/x:zhk	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 512	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 508
    //   24: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 51	com/tencent/mm/plugin/sns/model/x:zhk	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 515	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 508
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
  
  public static boolean ayO(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      zhk.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, dhb paramdhb)
  {
    AppMethodBeat.i(179087);
    if (paramdhb.Hua != null)
    {
      ad.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramdhb.Hua.Hvc + " " + paramdhb.Hua.Hvb);
      i = paramdhb.Hua.Hvc;
      com.tencent.mm.plugin.sns.c.a.zbZ = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.c.a.zbZ = 2147483647;
      }
      com.tencent.mm.storage.ak.IpM = paramdhb.Hua.Hvb;
    }
    this.zhl = paramdhb.HtY;
    this.zhm = paramdhb.HtZ;
    ad.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramdhb.HtY + " , objCount:  " + paramdhb.GUQ + " cflag : " + paramdhb.HtZ);
    this.ajO = paramdhb.GUQ;
    String str1 = com.tencent.mm.plugin.sns.data.q.zx(this.zhi);
    Object localObject1;
    label422:
    long l1;
    Object localObject2;
    if (!paramdhb.FCD.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramdhb.FCD.size()).append(" Max ").append(((SnsObject)paramdhb.FCD.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.zw(((SnsObject)paramdhb.FCD.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramdhb.FCD.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.zw(((SnsObject)paramdhb.FCD.getLast()).Id)).append(" adCount=");
      if (paramdhb.Hvr == null)
      {
        i = 0;
        ad.i("MicroMsg.NetSceneSnsTimeLine", i);
        if (paramdhb.Hvu <= 0) {
          break label685;
        }
        ad.i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramdhb.Hvu) });
        if ((paramdhb.Hvv == null) || (paramdhb.Hvv.size() != paramdhb.Hvu)) {
          break label685;
        }
        localObject1 = new LinkedList();
        i = 0;
        if (i >= paramdhb.Hvu) {
          break label653;
        }
        l1 = ((acn)paramdhb.Hvv.get(i)).Id;
        ad.i("MicroMsg.NetSceneSnsTimeLine", "server delete ad, snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l1));
        if (l1 != 0L)
        {
          localObject2 = ag.dUh().zZ(l1);
          if (localObject2 != null) {
            break label585;
          }
          ad.i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label585:
    Object localObject4;
    for (;;)
    {
      i += 1;
      break label422;
      i = paramdhb.Hvr.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramdhb.Hvr == null) {}
      for (i = 0;; i = paramdhb.Hvr.size())
      {
        ad.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
      localObject4 = new bx();
      ((bx)localObject4).Fuv = 13298;
      ((bx)localObject4).Fuw = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).dRK().dFy.getBytes());
      ((bx)localObject4).tSD = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.zy(l1);
    }
    label653:
    if (((LinkedList)localObject1).size() > 0)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new k((LinkedList)localObject1), 0);
    }
    label685:
    if (this.zhM.equals(paramdhb.HtU))
    {
      paramdhb = ag.dUe();
      if (this.zhh) {}
      for (l1 = 0L;; l1 = this.zie)
      {
        this.zhj = paramdhb.f(l1, this.zhl, true);
        ad.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.zhj) });
        dTA();
        ayO("@__weixintimtline");
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
        AppMethodBeat.o(179087);
        return;
      }
    }
    ag.dUi().g("@__weixintimtline", paramdhb.HtU, z.a(paramdhb.Htx));
    ad.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramdhb.FCD.size() + " adsize : " + paramdhb.Hvq);
    int i = 0;
    String str3;
    long l2;
    for (;;)
    {
      if (i < paramdhb.Hvr.size())
      {
        localObject1 = (dj)paramdhb.Hvr.get(i);
        if (this.ikP) {
          localObject2 = ag.getAccPath() + "ad.proto";
        }
        try
        {
          localObject4 = ((dj)localObject1).toByteArray();
          com.tencent.mm.vfs.i.f((String)localObject2, (byte[])localObject4, localObject4.length);
          localObject4 = z.a(((dj)localObject1).FvE);
          localObject2 = z.a(((dj)localObject1).FvD.Htw);
          str3 = z.b(((dj)localObject1).FvD.Htv.ObjectDesc);
          ad.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject4)));
          ad.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject2)));
          ad.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str3 + "\r\n");
          long l3 = 0L;
          l1 = l3;
          l2 = l3;
          try
          {
            if (!bt.V(new String[] { localObject4, localObject2 }))
            {
              l1 = l3;
              l2 = l3;
              if (((dj)localObject1).FvD != null)
              {
                l1 = l3;
                l2 = l3;
                if (((dj)localObject1).FvD.Htv != null)
                {
                  l2 = l3;
                  l1 = bt.g(Long.valueOf(((dj)localObject1).FvD.Htv.Id));
                }
              }
              l2 = l1;
              com.tencent.mm.plugin.sns.data.h.d(l1, (String)localObject4, (String)localObject2);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              boolean bool;
              ad.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localThrowable.toString());
              l1 = l2;
            }
          }
          localObject4 = ((dj)localObject1).FvD.Htv.Username;
          if (!bt.isNullOrNil((String)localObject4))
          {
            bool = com.tencent.mm.plugin.sns.data.j.axQ((String)localObject2);
            ad.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + (String)localObject4 + ", isUsePreferedInfo=" + bool + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zx(l1));
            if (!bool)
            {
              as.a.hFO.aI((String)localObject4, "");
              com.tencent.e.h.LTJ.r(new x.1(this, (String)localObject4), 10000L);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.a.b.a((dj)localObject1);
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
    if ((this.ikP) && (paramdhb.Hvr.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.i.aY(ag.getAccPath() + "ad.proto", 0, -1);
      localObject3 = new dj();
      ((dj)localObject3).parseFrom((byte[])localObject1);
      paramdhb.Hvr.add(localObject3);
      paramdhb.Hvq = paramdhb.Hvr.size();
      ad.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramdhb.Hvq);
      if (paramdhb.Hvr.size() > 0)
      {
        localObject1 = (dj)paramdhb.Hvr.get(0);
        localObject3 = z.a(((dj)localObject1).FvE);
        String str2 = z.a(((dj)localObject1).FvD.Htw);
        str3 = z.b(((dj)localObject1).FvD.Htv.ObjectDesc);
        ad.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
        ad.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
        ad.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str3 + "\r\n");
        d((dj)localObject1);
      }
      a.y(paramdhb.Hvr, paramdhb.FCD);
      a.aR(paramdhb.Hvr);
      if (paramdhb.Hvq == 0)
      {
        ad.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramdhb.Hvs) });
        a.e(paramdhb.Hvt, paramdhb.FCD);
        a.aQ(paramdhb.Hvt);
      }
      if (!this.zhh)
      {
        ad.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramdhb.FCD.size());
        if (paramdhb.FCD.isEmpty())
        {
          ag.dUe().aAh(str1);
          this.zig = true;
          this.zhj = this.zhi;
          ayO("@__weixintimtline");
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
        a(paramdhb, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = paramdhb.FCD.iterator();
      while (((Iterator)localObject3).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
      }
      localObject3 = new vd();
      ((vd)localObject3).dJo.dJp = localLinkedList;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
      if (this.rr.hNL.getRetCode() == 207)
      {
        if (paramdhb.FCD.isEmpty())
        {
          ag.dUe().dZa();
          this.zhj = this.zhi;
        }
        for (;;)
        {
          this.zig = true;
          ayO("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          ag.dUe().aAi(com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)paramdhb.FCD.getFirst()).Id));
          ag.dUe().aAh(com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)paramdhb.FCD.getLast()).Id));
          a(paramdhb, str1);
          a.aS(paramdhb.FCD);
        }
      }
      if (!paramdhb.FCD.isEmpty()) {
        break label2079;
      }
    }
    ag.dUe().dZa();
    this.zhj = this.zhi;
    this.zig = true;
    for (;;)
    {
      ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label2079:
      a(paramdhb, str1);
      a.aS(paramdhb.FCD);
    }
  }
  
  private static boolean d(dj paramdj)
  {
    AppMethodBeat.i(95668);
    if (!ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.h.Gx(z.b(paramdj.FvD.Htv.ObjectDesc));
      ag.dTZ();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramdj)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  private void dTA()
  {
    AppMethodBeat.i(95665);
    Object localObject = ag.dUe();
    String str = com.tencent.mm.plugin.sns.storage.q.dZf();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.zih = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.zig = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final boolean dSn()
  {
    return this.zhh;
  }
  
  public final boolean dSo()
  {
    return this.pullType == 1;
  }
  
  public final int dSp()
  {
    return -1;
  }
  
  public final boolean dSq()
  {
    return false;
  }
  
  public final boolean dSr()
  {
    return this.zig;
  }
  
  public final boolean dSs()
  {
    return this.zih;
  }
  
  public final boolean dSt()
  {
    return false;
  }
  
  public final long dSu()
  {
    return this.zhj;
  }
  
  public final boolean dSv()
  {
    return false;
  }
  
  public final long dSw()
  {
    return 0L;
  }
  
  public final String dSx()
  {
    return "";
  }
  
  public final boolean dSy()
  {
    return this.zii;
  }
  
  public final boolean dTB()
  {
    return this.pullType == 2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(95669);
    this.callback = paramf;
    paramf = (dha)this.rr.hNK.hNQ;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.j.e.ztz.dVG();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramf.Hvk = localLinkedList;
      paramf.Hvj = paramf.Hvk.size();
      ad.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramf.Hvl = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFc, 0);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFc, Integer.valueOf(0));
      ad.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramf.Hvj), Integer.valueOf(paramf.Hvl) });
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      paramf.Hvj = 0;
    }
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
    paramArrayOfByte = (dhb)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if (this.zhh)
    {
      if (paramArrayOfByte != null)
      {
        ad.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.Hvx.size()), Integer.valueOf(paramArrayOfByte.FCD.size()) });
        paramq = ag.dUn();
        LinkedList localLinkedList1 = paramArrayOfByte.Hvx;
        LinkedList localLinkedList2 = paramArrayOfByte.FCD;
        LinkedList localLinkedList3 = paramArrayOfByte.Hvy;
        ag.cVf().post(new at.2(paramq, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      paramq = ag.dUo();
      if (aq.zlB)
      {
        com.tencent.mm.sdk.platformtools.aq.aA(paramq.zlH);
        paramq.dUM();
        paramq.reset();
      }
    }
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.FCD.size() == 0)
      {
        this.zii = true;
        ayO("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.zii = false;
      a(paramArrayOfByte, "");
      ayO("@__weixintimtline");
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