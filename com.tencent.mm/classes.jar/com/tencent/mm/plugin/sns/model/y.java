package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class y
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> zxZ;
  public int ajO;
  public f callback;
  private boolean inI;
  public int pullType;
  com.tencent.mm.ak.b rr;
  final int sourceType;
  public boolean zxW;
  long zxX;
  long zxY;
  private long zyA;
  private String zyB;
  private long zyT;
  private final long zyU;
  private boolean zyV;
  private boolean zyW;
  private boolean zyX;
  public int zya;
  public int zyb;
  
  static
  {
    AppMethodBeat.i(95670);
    zxZ = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public y(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.inI = false;
    this.zyT = 0L;
    this.zxX = 0L;
    this.zxY = 0L;
    this.zyA = 0L;
    this.zyU = 102400L;
    this.zyB = "";
    this.zyV = false;
    this.zyW = false;
    this.zya = 0;
    this.zyb = 0;
    this.ajO = 0;
    this.pullType = 0;
    this.zyX = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).hQF = new dhu();
    ((com.tencent.mm.ak.b.a)localObject1).hQG = new dhv();
    ((com.tencent.mm.ak.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((com.tencent.mm.ak.b.a)localObject1).funcId = 211;
    ((com.tencent.mm.ak.b.a)localObject1).hQH = 98;
    ((com.tencent.mm.ak.b.a)localObject1).respCmdId = 1000000098;
    this.rr = ((com.tencent.mm.ak.b.a)localObject1).aDS();
    int i;
    if (az.isWifi(ak.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.zxX = paramLong1;
      boolean bool;
      label190:
      dhu localdhu;
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
        this.zxW = bool;
        this.sourceType = 2;
        localdhu = (dhu)this.rr.hQD.hQJ;
        localdhu.HNc = i;
        localdhu.HNy = paramLong1;
        k = ah.dXu().dYi();
        localObject1 = ah.dXE();
        if (!this.zxW) {
          break label861;
        }
        l1 = 0L;
        this.zxY = ((com.tencent.mm.plugin.sns.storage.q)localObject1).f(l1, k, true);
        localdhu.HOJ = this.zxY;
        m = d.a(this.zxY, paramLong1, "@__weixintimtline");
        localdhu.HOK = m;
        localdhu.HOQ = paramLong2;
        if (!this.zxW) {
          break label867;
        }
        localObject1 = ah.dXN();
        long l2 = ((au)localObject1).zDI;
        l1 = l2;
        if (((au)localObject1).zDF != null)
        {
          l1 = l2;
          if (!bu.ht(((au)localObject1).zDF.zHX))
          {
            localObject1 = ((au)localObject1).zDF.zHX.iterator();
            do
            {
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.i.k)((Iterator)localObject1).next();
            } while (bu.ht(((com.tencent.mm.plugin.sns.i.k)localObject2).rBG));
            l1 = ((Long)((com.tencent.mm.plugin.sns.i.k)localObject2).rBG.peekLast()).longValue() - 1L;
          }
        }
        localdhu.HOR = l1;
        if (paramInt != 1) {
          break label873;
        }
        j = 1;
        label433:
        localdhu.HOP = j;
        this.pullType = paramInt;
        localObject2 = ah.dXI().aBw("@__weixintimtline");
        if (this.zxW)
        {
          this.zyA = ah.dXE().f(0L, 1, true);
          ae.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.zyA);
          localdhu.HOL = this.zyA;
          if (localObject2 != null) {
            break label879;
          }
          localObject1 = "";
          label520:
          this.zyB = ((String)localObject1);
          if (this.zyB == null) {
            this.zyB = "";
          }
          localdhu.HNx = this.zyB;
        }
        l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIA, 102400L);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession.length <= l1)) {
          break label889;
        }
      }
      for (localdhu.HNa = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdhu.HNa = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession))
      {
        this.zyT = paramLong1;
        ae.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.zxY + " ReqTime:" + localdhu.HOK + " nettype: " + i + " MinIdForCheckUnread:" + localdhu.HOR + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2);
        ae.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { r.zV(paramLong1), r.zV(this.zxY), Integer.valueOf(m) });
        ae.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
        AppMethodBeat.o(179086);
        return;
        if (az.is3G(ak.getContext()))
        {
          i = 3;
          break;
        }
        if (az.is4G(ak.getContext()))
        {
          i = 4;
          break;
        }
        if (az.is2G(ak.getContext()))
        {
          i = 2;
          break;
        }
        if (!az.is5G(ak.getContext())) {
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
        ae.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_adsession });
      }
      label933:
      i = 0;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, dhv paramdhv)
  {
    AppMethodBeat.i(219336);
    if (paramdhv.FUY.size() == 0)
    {
      aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(219336);
      return;
    }
    Iterator localIterator = paramdhv.FUY.iterator();
    while (localIterator.hasNext()) {
      ae.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramdhv, r.zW(this.zxX));
    aAf("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(219336);
  }
  
  private void a(dhv paramdhv, String paramString)
  {
    AppMethodBeat.i(95666);
    al.b("@__weixintimtline", this.sourceType, paramdhv.FUY, paramString);
    this.zxY = ((SnsObject)paramdhv.FUY.getLast()).Id;
    if (this.zxX == 0L) {
      this.zxX = ((SnsObject)paramdhv.FUY.getFirst()).Id;
    }
    for (;;)
    {
      d.f("@__weixintimtline", this.zxX, this.zxY, paramdhv.HOS);
      try
      {
        paramdhv = paramdhv.FUY.iterator();
        for (;;)
        {
          if (paramdhv.hasNext())
          {
            paramString = (SnsObject)paramdhv.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = ah.dXE().AG(paramString.Id);
              if ((localObject != null) && (((p)localObject).ebP() != null))
              {
                int i = ((p)localObject).field_type;
                if (i == 15)
                {
                  try
                  {
                    localObject = ((bzh)((p)localObject).ebP().HUG.Gtx.get(0)).Url;
                    com.tencent.mm.plugin.report.service.g.yxI.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.zxX = d.zZ(this.zxX);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramdhv)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean aAe(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 508
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 51	com/tencent/mm/plugin/sns/model/y:zxZ	Ljava/util/Vector;
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
    //   32: getstatic 51	com/tencent/mm/plugin/sns/model/y:zxZ	Ljava/util/Vector;
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
  
  public static boolean aAf(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      zxZ.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, dhv paramdhv)
  {
    AppMethodBeat.i(179087);
    if (paramdhv.HND != null)
    {
      ae.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramdhv.HND.HOF + " " + paramdhv.HND.HOE);
      i = paramdhv.HND.HOF;
      com.tencent.mm.plugin.sns.c.a.zsC = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.c.a.zsC = 2147483647;
      }
      com.tencent.mm.storage.al.IKg = paramdhv.HND.HOE;
    }
    this.zya = paramdhv.HNB;
    this.zyb = paramdhv.HNC;
    ae.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramdhv.HNB + " , objCount:  " + paramdhv.Hor + " cflag : " + paramdhv.HNC);
    this.ajO = paramdhv.Hor;
    String str1 = r.zW(this.zxX);
    Object localObject1;
    if (!paramdhv.FUY.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramdhv.FUY.size()).append(" Max ").append(((SnsObject)paramdhv.FUY.getFirst()).Id).append(" ").append(r.zV(((SnsObject)paramdhv.FUY.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramdhv.FUY.getLast()).Id).append(" ").append(r.zV(((SnsObject)paramdhv.FUY.getLast()).Id)).append(" adCount=");
      if (paramdhv.HOU == null)
      {
        i = 0;
        ae.i("MicroMsg.NetSceneSnsTimeLine", i);
        com.tencent.mm.plugin.sns.ad.c.b.c(paramdhv.HOY, paramdhv.HOX, 0);
        if (!this.zyB.equals(paramdhv.HNx)) {
          break label544;
        }
        paramdhv = ah.dXE();
        if (!this.zxW) {
          break label535;
        }
      }
    }
    label535:
    for (long l1 = 0L;; l1 = this.zyT)
    {
      this.zxY = paramdhv.f(l1, this.zya, true);
      ae.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.zxY) });
      dXa();
      aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      i = paramdhv.HOU.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramdhv.HOU == null) {}
      for (i = 0;; i = paramdhv.HOU.size())
      {
        ae.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
    }
    label544:
    ah.dXI().g("@__weixintimtline", paramdhv.HNx, z.a(paramdhv.HNa));
    ae.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramdhv.FUY.size() + " adsize : " + paramdhv.HOT);
    int i = 0;
    String str4;
    long l2;
    for (;;)
    {
      if (i < paramdhv.HOU.size())
      {
        localObject1 = (dj)paramdhv.HOU.get(i);
        String str2;
        if (this.inI) {
          str2 = ah.getAccPath() + "ad.proto";
        }
        try
        {
          Object localObject3 = ((dj)localObject1).toByteArray();
          com.tencent.mm.vfs.o.f(str2, (byte[])localObject3, localObject3.length);
          localObject3 = z.a(((dj)localObject1).FOc);
          str2 = z.a(((dj)localObject1).FOb.HMZ);
          str4 = z.b(((dj)localObject1).FOb.HMY.ObjectDesc);
          ae.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
          ae.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
          ae.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
          long l3 = 0L;
          l1 = l3;
          l2 = l3;
          try
          {
            if (!bu.V(new String[] { localObject3, str2 }))
            {
              l1 = l3;
              l2 = l3;
              if (((dj)localObject1).FOb != null)
              {
                l1 = l3;
                l2 = l3;
                if (((dj)localObject1).FOb.HMY != null)
                {
                  l2 = l3;
                  l1 = bu.i(Long.valueOf(((dj)localObject1).FOb.HMY.Id));
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
              ae.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localThrowable.toString());
              l1 = l2;
            }
          }
          localObject3 = ((dj)localObject1).FOb.HMY.Username;
          if (!bu.isNullOrNil((String)localObject3))
          {
            bool = com.tencent.mm.plugin.sns.data.k.azh(str2);
            ae.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + (String)localObject3 + ", isUsePreferedInfo=" + bool + ", snsId=" + r.zW(l1));
            if (!bool)
            {
              au.a.hIG.aJ((String)localObject3, "");
              com.tencent.e.h.MqF.r(new y.1(this, (String)localObject3), 10000L);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.a.d.a((dj)localObject1);
          i += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.inI) && (paramdhv.HOU.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.o.bb(ah.getAccPath() + "ad.proto", 0, -1);
      localObject2 = new dj();
      ((dj)localObject2).parseFrom((byte[])localObject1);
      paramdhv.HOU.add(localObject2);
      paramdhv.HOT = paramdhv.HOU.size();
      ae.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramdhv.HOT);
      if (paramdhv.HOU.size() > 0)
      {
        localObject1 = (dj)paramdhv.HOU.get(0);
        localObject2 = z.a(((dj)localObject1).FOc);
        String str3 = z.a(((dj)localObject1).FOb.HMZ);
        str4 = z.b(((dj)localObject1).FOb.HMY.ObjectDesc);
        ae.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
        ae.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str3)));
        ae.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
        d((dj)localObject1);
      }
      a.a(paramdhv.HOU, paramdhv.FUY, this.zxW, this.pullType);
      a.aS(paramdhv.HOU);
      if (paramdhv.HOT == 0)
      {
        ae.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramdhv.HOV) });
        a.e(paramdhv.HOW, paramdhv.FUY);
        a.aR(paramdhv.HOW);
      }
      if (!this.zxW)
      {
        ae.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramdhv.FUY.size());
        if (paramdhv.FUY.isEmpty())
        {
          ah.dXE().aBy(str1);
          this.zyV = true;
          this.zxY = this.zxX;
          aAf("@__weixintimtline");
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
        ae.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
        continue;
        a(paramdhv, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = paramdhv.FUY.iterator();
      while (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
      }
      localObject2 = new vh();
      ((vh)localObject2).dKC.dKD = localLinkedList;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      if (this.rr.hQE.getRetCode() == 207)
      {
        if (paramdhv.FUY.isEmpty())
        {
          ah.dXE().ecF();
          this.zxY = this.zxX;
        }
        for (;;)
        {
          this.zyV = true;
          aAf("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          ah.dXE().aBz(r.zW(((SnsObject)paramdhv.FUY.getFirst()).Id));
          ah.dXE().aBy(r.zW(((SnsObject)paramdhv.FUY.getLast()).Id));
          a(paramdhv, str1);
          a.aT(paramdhv.FUY);
        }
      }
      if (!paramdhv.FUY.isEmpty()) {
        break label1838;
      }
    }
    ah.dXE().ecF();
    this.zxY = this.zxX;
    this.zyV = true;
    for (;;)
    {
      aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      label1838:
      a(paramdhv, str1);
      a.aT(paramdhv.FUY);
    }
  }
  
  private static boolean d(dj paramdj)
  {
    AppMethodBeat.i(95668);
    if (!az.isWifi(ak.getContext()))
    {
      AppMethodBeat.o(95668);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.h.GZ(z.b(paramdj.FOb.HMY.ObjectDesc));
      ah.dXz();
      AppMethodBeat.o(95668);
      return true;
    }
    catch (Exception paramdj)
    {
      AppMethodBeat.o(95668);
    }
    return false;
  }
  
  private void dXa()
  {
    AppMethodBeat.i(95665);
    Object localObject = ah.dXE();
    String str = com.tencent.mm.plugin.sns.storage.q.ecK();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.zyW = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.zyV = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final boolean dVL()
  {
    return this.zxW;
  }
  
  public final boolean dVM()
  {
    return this.pullType == 1;
  }
  
  public final int dVN()
  {
    return -1;
  }
  
  public final boolean dVO()
  {
    return false;
  }
  
  public final boolean dVP()
  {
    return this.zyV;
  }
  
  public final boolean dVQ()
  {
    return this.zyW;
  }
  
  public final boolean dVR()
  {
    return false;
  }
  
  public final long dVS()
  {
    return this.zxY;
  }
  
  public final boolean dVT()
  {
    return false;
  }
  
  public final long dVU()
  {
    return 0L;
  }
  
  public final String dVV()
  {
    return "";
  }
  
  public final boolean dVW()
  {
    return this.zyX;
  }
  
  public final boolean dXb()
  {
    return this.pullType == 2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(95669);
    this.callback = paramf;
    paramf = (dhu)this.rr.hQD.hQJ;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.j.e.zKO.dZh();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramf.HON = localLinkedList;
      paramf.HOM = paramf.HON.size();
      ae.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramf.HOO = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IZC, 0);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZC, Integer.valueOf(0));
      ae.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramf.HOM), Integer.valueOf(paramf.HOO) });
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      paramf.HOM = 0;
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
    ae.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (dhv)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if (this.zxW)
    {
      if (paramArrayOfByte != null)
      {
        ae.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.HPa.size()), Integer.valueOf(paramArrayOfByte.FUY.size()) });
        paramq = ah.dXN();
        LinkedList localLinkedList1 = paramArrayOfByte.HPa;
        LinkedList localLinkedList2 = paramArrayOfByte.FUY;
        LinkedList localLinkedList3 = paramArrayOfByte.HPb;
        ah.cXK().post(new au.2(paramq, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      paramq = ah.dXO();
      if (ar.zCQ)
      {
        com.tencent.mm.sdk.platformtools.ar.ay(paramq.zCW);
        paramq.dYm();
        paramq.reset();
      }
    }
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.FUY.size() == 0)
      {
        this.zyX = true;
        aAf("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.zyX = false;
      a(paramArrayOfByte, r.zW(((SnsObject)paramArrayOfByte.FUY.getFirst()).Id));
      aAf("@__weixintimtline");
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */