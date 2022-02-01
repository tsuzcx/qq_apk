package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> xRq;
  public int ahX;
  public com.tencent.mm.ak.g callback;
  private boolean hRB;
  public int pullType;
  com.tencent.mm.ak.b rr;
  final int sourceType;
  private long xRR;
  private String xRS;
  public boolean xRn;
  long xRo;
  long xRp;
  public int xRr;
  public int xRs;
  private long xSk;
  private final long xSl;
  private boolean xSm;
  private boolean xSn;
  private boolean xSo;
  
  static
  {
    AppMethodBeat.i(95670);
    xRq = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public x(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.hRB = false;
    this.xSk = 0L;
    this.xRo = 0L;
    this.xRp = 0L;
    this.xRR = 0L;
    this.xSl = 102400L;
    this.xRS = "";
    this.xSm = false;
    this.xSn = false;
    this.xRr = 0;
    this.xRs = 0;
    this.ahX = 0;
    this.pullType = 0;
    this.xSo = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).hvt = new dbn();
    ((com.tencent.mm.ak.b.a)localObject1).hvu = new dbo();
    ((com.tencent.mm.ak.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((com.tencent.mm.ak.b.a)localObject1).funcId = 211;
    ((com.tencent.mm.ak.b.a)localObject1).reqCmdId = 98;
    ((com.tencent.mm.ak.b.a)localObject1).respCmdId = 1000000098;
    this.rr = ((com.tencent.mm.ak.b.a)localObject1).aAz();
    int i;
    if (ax.isWifi(ai.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.xRo = paramLong1;
      boolean bool;
      label190:
      dbn localdbn;
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
        this.xRn = bool;
        this.sourceType = 2;
        localdbn = (dbn)this.rr.hvr.hvw;
        localdbn.FIR = i;
        localdbn.FJn = paramLong1;
        k = af.dHH().dIv();
        localObject1 = af.dHR();
        if (!this.xRn) {
          break label861;
        }
        l1 = 0L;
        this.xRp = ((com.tencent.mm.plugin.sns.storage.q)localObject1).f(l1, k, true);
        localdbn.FKy = this.xRp;
        m = c.a(this.xRp, paramLong1, "@__weixintimtline");
        localdbn.FKz = m;
        localdbn.FKF = paramLong2;
        if (!this.xRn) {
          break label867;
        }
        localObject1 = af.dIa();
        long l2 = ((as)localObject1).xWv;
        l1 = l2;
        if (((as)localObject1).xWs != null)
        {
          l1 = l2;
          if (!bs.gY(((as)localObject1).xWs.yaM))
          {
            localObject1 = ((as)localObject1).xWs.yaM.iterator();
            do
            {
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.i.k)((Iterator)localObject1).next();
            } while (bs.gY(((com.tencent.mm.plugin.sns.i.k)localObject2).qJs));
            l1 = ((Long)((com.tencent.mm.plugin.sns.i.k)localObject2).qJs.peekLast()).longValue() - 1L;
          }
        }
        localdbn.FKG = l1;
        if (paramInt != 1) {
          break label873;
        }
        j = 1;
        label433:
        localdbn.FKE = j;
        this.pullType = paramInt;
        localObject2 = af.dHV().auY("@__weixintimtline");
        if (this.xRn)
        {
          this.xRR = af.dHR().f(0L, 1, true);
          ac.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.xRR);
          localdbn.FKA = this.xRR;
          if (localObject2 != null) {
            break label879;
          }
          localObject1 = "";
          label520:
          this.xRS = ((String)localObject1);
          if (this.xRS == null) {
            this.xRS = "";
          }
          localdbn.FJm = this.xRS;
        }
        l1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWn, 102400L);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession.length <= l1)) {
          break label889;
        }
      }
      for (localdbn.FIP = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdbn.FIP = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession))
      {
        this.xSk = paramLong1;
        ac.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.xRp + " ReqTime:" + localdbn.FKz + " nettype: " + i + " MinIdForCheckUnread:" + localdbn.FKG + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2);
        ac.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramLong1), com.tencent.mm.plugin.sns.data.q.wW(this.xRp), Integer.valueOf(m) });
        ac.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
        AppMethodBeat.o(179086);
        return;
        if (ax.is3G(ai.getContext()))
        {
          i = 3;
          break;
        }
        if (ax.is4G(ai.getContext()))
        {
          i = 4;
          break;
        }
        if (ax.is2G(ai.getContext()))
        {
          i = 2;
          break;
        }
        if (!ax.is5G(ai.getContext())) {
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
        ac.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession });
      }
      label933:
      i = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, dbo paramdbo)
  {
    AppMethodBeat.i(200112);
    if (paramdbo.DXh.size() == 0)
    {
      atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(200112);
      return;
    }
    Iterator localIterator = paramdbo.DXh.iterator();
    while (localIterator.hasNext()) {
      ac.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramdbo, com.tencent.mm.plugin.sns.data.q.wX(this.xRo));
    atJ("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(200112);
  }
  
  private void a(dbo paramdbo, String paramString)
  {
    AppMethodBeat.i(95666);
    aj.b("@__weixintimtline", this.sourceType, paramdbo.DXh, paramString);
    this.xRp = ((SnsObject)paramdbo.DXh.getLast()).Id;
    if (this.xRo == 0L) {
      this.xRo = ((SnsObject)paramdbo.DXh.getFirst()).Id;
    }
    for (;;)
    {
      c.f("@__weixintimtline", this.xRo, this.xRp, paramdbo.FKH);
      try
      {
        paramdbo = paramdbo.DXh.iterator();
        for (;;)
        {
          if (paramdbo.hasNext())
          {
            paramString = (SnsObject)paramdbo.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = af.dHR().xK(paramString.Id);
              if ((localObject != null) && (((p)localObject).dLV() != null))
              {
                int i = ((p)localObject).field_type;
                if (i == 15)
                {
                  try
                  {
                    localObject = ((btz)((p)localObject).dLV().FQo.Etz.get(0)).Url;
                    com.tencent.mm.plugin.report.service.h.wUl.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.xRo = c.xc(this.xRo);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramdbo)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean atI(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 508
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 51	com/tencent/mm/plugin/sns/model/x:xRq	Ljava/util/Vector;
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
    //   32: getstatic 51	com/tencent/mm/plugin/sns/model/x:xRq	Ljava/util/Vector;
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
  
  public static boolean atJ(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      xRq.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, dbo paramdbo)
  {
    AppMethodBeat.i(179087);
    if (paramdbo.FJs != null)
    {
      ac.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramdbo.FJs.FKu + " " + paramdbo.FJs.FKt);
      i = paramdbo.FJs.FKu;
      com.tencent.mm.plugin.sns.c.a.xMh = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.c.a.xMh = 2147483647;
      }
      com.tencent.mm.storage.ag.GDt = paramdbo.FJs.FKt;
    }
    this.xRr = paramdbo.FJq;
    this.xRs = paramdbo.FJr;
    ac.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramdbo.FJq + " , objCount:  " + paramdbo.Fli + " cflag : " + paramdbo.FJr);
    this.ahX = paramdbo.Fli;
    String str1 = com.tencent.mm.plugin.sns.data.q.wX(this.xRo);
    Object localObject1;
    label422:
    long l1;
    Object localObject2;
    if (!paramdbo.DXh.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramdbo.DXh.size()).append(" Max ").append(((SnsObject)paramdbo.DXh.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.wW(((SnsObject)paramdbo.DXh.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramdbo.DXh.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.wW(((SnsObject)paramdbo.DXh.getLast()).Id)).append(" adCount=");
      if (paramdbo.FKJ == null)
      {
        i = 0;
        ac.i("MicroMsg.NetSceneSnsTimeLine", i);
        if (paramdbo.FKM <= 0) {
          break label679;
        }
        ac.i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramdbo.FKM) });
        if ((paramdbo.FKN == null) || (paramdbo.FKN.size() != paramdbo.FKM)) {
          break label679;
        }
        localObject1 = new LinkedList();
        i = 0;
        if (i >= paramdbo.FKM) {
          break label647;
        }
        l1 = ((aan)paramdbo.FKN.get(i)).Id;
        ac.i("MicroMsg.NetSceneSnsTimeLine", "delete ad %s", new Object[] { Long.valueOf(l1) });
        if (l1 != 0L)
        {
          localObject2 = af.dHU().xB(l1);
          if (localObject2 != null) {
            break label579;
          }
          ac.i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label579:
    Object localObject4;
    for (;;)
    {
      i += 1;
      break label422;
      i = paramdbo.FKJ.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramdbo.FKJ == null) {}
      for (i = 0;; i = paramdbo.FKJ.size())
      {
        ac.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
      localObject4 = new bx();
      ((bx)localObject4).DPl = 13298;
      ((bx)localObject4).DPm = new com.tencent.mm.bw.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).dFQ().dtx.getBytes());
      ((bx)localObject4).sVY = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.wY(l1);
    }
    label647:
    if (((LinkedList)localObject1).size() > 0)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new k((LinkedList)localObject1), 0);
    }
    label679:
    if (this.xRS.equals(paramdbo.FJm))
    {
      paramdbo = af.dHR();
      if (this.xRn) {}
      for (l1 = 0L;; l1 = this.xSk)
      {
        this.xRp = paramdbo.f(l1, this.xRr, true);
        ac.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.xRp) });
        dHo();
        atJ("@__weixintimtline");
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
        AppMethodBeat.o(179087);
        return;
      }
    }
    af.dHV().g("@__weixintimtline", paramdbo.FJm, z.a(paramdbo.FIP));
    ac.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramdbo.DXh.size() + " adsize : " + paramdbo.FKI);
    int i = 0;
    String str2;
    for (;;)
    {
      if (i < paramdbo.FKJ.size())
      {
        localObject1 = (di)paramdbo.FKJ.get(i);
        if (this.hRB) {
          localObject2 = af.getAccPath() + "ad.proto";
        }
        try
        {
          localObject4 = ((di)localObject1).toByteArray();
          com.tencent.mm.vfs.i.f((String)localObject2, (byte[])localObject4, localObject4.length);
          localObject2 = z.a(((di)localObject1).DQp);
          localObject4 = z.a(((di)localObject1).DQo.FIO);
          str2 = z.b(((di)localObject1).DQo.FIN.ObjectDesc);
          ac.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
          ac.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
          ac.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
          com.tencent.mm.plugin.sns.waid.g.awf((String)localObject2);
          try
          {
            if (!bs.T(new String[] { localObject2, localObject4 }))
            {
              long l2 = 0L;
              l1 = l2;
              if (((di)localObject1).DQo != null)
              {
                l1 = l2;
                if (((di)localObject1).DQo.FIN != null) {
                  l1 = bs.g(Long.valueOf(((di)localObject1).DQo.FIN.Id));
                }
              }
              com.tencent.mm.plugin.sns.data.h.d(l1, (String)localObject2, (String)localObject4);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ac.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localThrowable.toString());
            }
          }
          localObject2 = ((di)localObject1).DQo.FIN.Username;
          if (!bs.isNullOrNil((String)localObject2))
          {
            ac.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject2)));
            ar.a.hnw.aJ((String)localObject2, "");
            com.tencent.e.h.JZN.q(new x.1(this, (String)localObject2), 10000L);
          }
          com.tencent.mm.plugin.sns.ad.timeline.a.a.a((di)localObject1);
          i += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.hRB) && (paramdbo.FKJ.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.i.aU(af.getAccPath() + "ad.proto", 0, -1);
      localObject3 = new di();
      ((di)localObject3).parseFrom((byte[])localObject1);
      paramdbo.FKJ.add(localObject3);
      paramdbo.FKI = paramdbo.FKJ.size();
      ac.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramdbo.FKI);
      if (paramdbo.FKJ.size() > 0)
      {
        localObject1 = (di)paramdbo.FKJ.get(0);
        localObject3 = z.a(((di)localObject1).DQp);
        localObject4 = z.a(((di)localObject1).DQo.FIO);
        str2 = z.b(((di)localObject1).DQo.FIN.ObjectDesc);
        ac.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
        ac.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
        ac.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
        d((di)localObject1);
      }
      a.x(paramdbo.FKJ, paramdbo.DXh);
      a.aQ(paramdbo.FKJ);
      if (paramdbo.FKI == 0)
      {
        ac.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramdbo.FKK) });
        a.e(paramdbo.FKL, paramdbo.DXh);
        a.aP(paramdbo.FKL);
      }
      if (!this.xRn)
      {
        ac.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramdbo.DXh.size());
        if (paramdbo.DXh.isEmpty())
        {
          af.dHR().ava(str1);
          this.xSm = true;
          this.xRp = this.xRo;
          atJ("@__weixintimtline");
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
        ac.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
        continue;
        a(paramdbo, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = paramdbo.DXh.iterator();
      while (((Iterator)localObject3).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
      }
      localObject3 = new uk();
      ((uk)localObject3).dxc.dxd = localLinkedList;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
      if (this.rr.hvs.getRetCode() == 207)
      {
        if (paramdbo.DXh.isEmpty())
        {
          af.dHR().dML();
          this.xRp = this.xRo;
        }
        for (;;)
        {
          this.xSm = true;
          atJ("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          af.dHR().avb(com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)paramdbo.DXh.getFirst()).Id));
          af.dHR().ava(com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)paramdbo.DXh.getLast()).Id));
          a(paramdbo, str1);
          a.aR(paramdbo.DXh);
        }
      }
      if (!paramdbo.DXh.isEmpty()) {
        break label2006;
      }
    }
    af.dHR().dML();
    this.xRp = this.xRo;
    this.xSm = true;
    for (;;)
    {
      atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label2006:
      a(paramdbo, str1);
      a.aR(paramdbo.DXh);
    }
  }
  
  private static boolean d(di paramdi)
  {
    AppMethodBeat.i(95668);
    if (!ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.g.Ds(z.b(paramdi.DQo.FIN.ObjectDesc));
      af.dHM();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramdi)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  private void dHo()
  {
    AppMethodBeat.i(95665);
    Object localObject = af.dHR();
    String str = com.tencent.mm.plugin.sns.storage.q.dMQ();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.xSn = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.xSm = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final boolean dGa()
  {
    return this.xRn;
  }
  
  public final boolean dGb()
  {
    return this.pullType == 1;
  }
  
  public final int dGc()
  {
    return -1;
  }
  
  public final boolean dGd()
  {
    return false;
  }
  
  public final boolean dGe()
  {
    return this.xSm;
  }
  
  public final boolean dGf()
  {
    return this.xSn;
  }
  
  public final boolean dGg()
  {
    return false;
  }
  
  public final long dGh()
  {
    return this.xRp;
  }
  
  public final boolean dGi()
  {
    return false;
  }
  
  public final long dGj()
  {
    return 0L;
  }
  
  public final String dGk()
  {
    return "";
  }
  
  public final boolean dGl()
  {
    return this.xSo;
  }
  
  public final boolean dHp()
  {
    return this.pullType == 2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(95669);
    this.callback = paramg;
    paramg = (dbn)this.rr.hvr.hvw;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.j.f.ydE.dJt();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramg.FKC = localLinkedList;
      paramg.FKB = paramg.FKC.size();
      ac.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramg.FKD = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GSx, 0);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSx, Integer.valueOf(0));
      ac.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramg.FKB), Integer.valueOf(paramg.FKD) });
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      paramg.FKB = 0;
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
    ac.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (dbo)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if (this.xRn)
    {
      if (paramArrayOfByte != null)
      {
        ac.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.FKP.size()), Integer.valueOf(paramArrayOfByte.DXh.size()) });
        paramq = af.dIa();
        LinkedList localLinkedList1 = paramArrayOfByte.FKP;
        LinkedList localLinkedList2 = paramArrayOfByte.DXh;
        LinkedList localLinkedList3 = paramArrayOfByte.FKQ;
        af.cMM().post(new as.2(paramq, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      paramq = af.dIb();
      if (ap.xVF)
      {
        com.tencent.mm.sdk.platformtools.ap.aB(paramq.xVJ);
        paramq.dIz();
        paramq.reset();
      }
    }
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.DXh.size() == 0)
      {
        this.xSo = true;
        atJ("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.xSo = false;
      a(paramArrayOfByte, "");
      atJ("@__weixintimtline");
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