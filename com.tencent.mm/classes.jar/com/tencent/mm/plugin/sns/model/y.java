package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.qu;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.buf;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class y
  extends com.tencent.mm.ah.m
  implements k, d
{
  private static Vector<String> opS = new Vector();
  public int Zn = 0;
  final int bIl;
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  private boolean eyq = false;
  public boolean opP;
  private long opQ = 0L;
  long opR = 0L;
  public int opT = 0;
  public int opU = 0;
  private long oqI = 0L;
  private boolean oqJ = false;
  private boolean oqK = false;
  private long oqq = 0L;
  private String oqr = "";
  
  public y(long paramLong)
  {
    long l2 = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bup();
    ((b.a)localObject).ecI = new buq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((b.a)localObject).ecG = 211;
    ((b.a)localObject).ecJ = 98;
    ((b.a)localObject).ecK = 1000000098;
    this.dmK = ((b.a)localObject).Kt();
    int i;
    if (aq.isWifi(ae.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.opQ = paramLong;
      boolean bool;
      label161:
      bup localbup;
      int j;
      long l1;
      label222:
      int k;
      l locall;
      if (paramLong == 0L)
      {
        bool = true;
        this.opP = bool;
        this.bIl = 2;
        localbup = (bup)this.dmK.ecE.ecN;
        localbup.tJm = i;
        localbup.tJI = paramLong;
        j = af.bDv().bEe();
        localObject = af.bDF();
        if (!this.opP) {
          break label574;
        }
        l1 = 0L;
        this.opR = ((o)localObject).e(l1, j, true);
        localbup.tLe = this.opR;
        k = c.a(this.opR, paramLong, "@__weixintimtline");
        localbup.tLf = k;
        if (this.opP)
        {
          this.oqq = af.bDF().e(0L, 1, true);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.oqq);
          localbup.tLg = this.oqq;
          locall = af.bDJ().OF("@__weixintimtline");
          if (locall != null) {
            break label580;
          }
          localObject = "";
          label336:
          this.oqr = ((String)localObject);
          if (this.oqr == null) {
            this.oqr = "";
          }
          localbup.tJH = this.oqr;
          if ((locall != null) && (locall.field_adsession != null)) {
            break label590;
          }
        }
      }
      for (localbup.tJk = new bmk().bs(new byte[0]);; localbup.tJk = new bmk().bs(locall.field_adsession))
      {
        this.oqI = paramLong;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + j + " max:" + paramLong + " min:" + this.opR + " ReqTime:" + localbup.tLf + " nettype: " + i);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { i.fN(paramLong), i.fN(this.opR), Integer.valueOf(k) });
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        return;
        if (aq.is3G(ae.getContext()))
        {
          i = 3;
          break;
        }
        if (aq.is4G(ae.getContext()))
        {
          i = 4;
          break;
        }
        if (!aq.is2G(ae.getContext())) {
          break label633;
        }
        i = 2;
        break;
        bool = false;
        break label161;
        label574:
        l1 = paramLong;
        break label222;
        label580:
        localObject = locall.field_md5;
        break label336;
        label590:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
      }
      label633:
      i = 0;
    }
  }
  
  /* Error */
  public static boolean Nu(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 41	com/tencent/mm/plugin/sns/model/y:opS	Ljava/util/Vector;
    //   6: aload_0
    //   7: invokevirtual 299	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc 2
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: getstatic 41	com/tencent/mm/plugin/sns/model/y:opS	Ljava/util/Vector;
    //   25: aload_0
    //   26: invokevirtual 302	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   29: pop
    //   30: iconst_1
    //   31: istore_1
    //   32: goto -15 -> 17
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramString	String
    //   10	22	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	11	35	finally
    //   22	30	35	finally
  }
  
  public static boolean Nv(String paramString)
  {
    try
    {
      opS.remove(paramString);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(buq parambuq, String paramString)
  {
    aj.a("@__weixintimtline", this.bIl, parambuq.sAA, paramString);
    this.opR = ((bto)parambuq.sAA.getLast()).sGd;
    if (this.opQ == 0L) {
      this.opQ = ((bto)parambuq.sAA.getFirst()).sGd;
    }
    for (;;)
    {
      c.f("@__weixintimtline", this.opQ, this.opR, parambuq.tLh);
      try
      {
        parambuq = parambuq.sAA.iterator();
        while (parambuq.hasNext())
        {
          paramString = (bto)parambuq.next();
          if (paramString.tKf == 0)
          {
            Object localObject = af.bDF().gt(paramString.sGd);
            if ((localObject != null) && (((n)localObject).bGe() != null))
            {
              int i = ((n)localObject).field_type;
              if (i == 15)
              {
                try
                {
                  localObject = ((awd)((n)localObject).bGe().tNr.sPJ.get(0)).kSC;
                  h.nFQ.f(14388, new Object[] { Long.valueOf(paramString.sGd), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                }
                catch (Exception paramString) {}
                continue;
                this.opQ = c.fR(this.opQ);
              }
            }
          }
        }
      }
      catch (Exception parambuq) {}
    }
  }
  
  private void bDd()
  {
    Object localObject = af.bDF();
    String str = o.bGX();
    localObject = ((o)localObject).dXw.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0)) {
      this.oqK = true;
    }
    while (i != 0) {
      return;
    }
    this.oqJ = true;
  }
  
  private static boolean c(cn paramcn)
  {
    if (!aq.isWifi(ae.getContext())) {
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.e.nn(aa.b(paramcn.svY.tJi.tJU));
      af.bDA();
      b.bCJ();
      return true;
    }
    catch (Exception paramcn) {}
    return false;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (buq)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramq.HF().spN != 207) && (paramq.HF().spN != 0))
    {
      Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.tJN != null)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramArrayOfByte.tJN.tLa + " " + paramArrayOfByte.tJN.tKZ);
      paramInt1 = paramArrayOfByte.tJN.tLa;
      com.tencent.mm.plugin.sns.c.a.omJ = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.omJ = 2147483647;
      }
      com.tencent.mm.storage.ab.unw = paramArrayOfByte.tJN.tKZ;
    }
    this.opT = paramArrayOfByte.tJL;
    this.opU = paramArrayOfByte.tJM;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramArrayOfByte.tJL + " , objCount:  " + paramArrayOfByte.ttP + " cflag : " + paramArrayOfByte.tJM);
    this.Zn = paramArrayOfByte.ttP;
    String str1 = i.fO(this.opQ);
    if (!paramArrayOfByte.sAA.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + paramArrayOfByte.sAA.size() + " Max " + ((bto)paramArrayOfByte.sAA.getFirst()).sGd + " " + i.fN(((bto)paramArrayOfByte.sAA.getFirst()).sGd) + "  respone min  " + ((bto)paramArrayOfByte.sAA.getLast()).sGd + " " + i.fN(((bto)paramArrayOfByte.sAA.getLast()).sGd));
      if (this.opP) {
        break label546;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramArrayOfByte.sAA.size());
      if (!paramArrayOfByte.sAA.isEmpty()) {
        break label535;
      }
      af.bDF().OG(str1);
      this.oqJ = true;
      this.opR = this.opQ;
    }
    for (;;)
    {
      Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
      break;
      label535:
      a(paramArrayOfByte, str1);
    }
    label546:
    this.Zn = paramArrayOfByte.ttP;
    if (this.oqr.equals(paramArrayOfByte.tJH))
    {
      paramq = af.bDF();
      if (this.opP) {}
      for (long l = 0L;; l = this.oqI)
      {
        this.opR = paramq.e(l, this.opT, true);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.opR) });
        bDd();
        Nv("@__weixintimtline");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + paramArrayOfByte.sAA.size() + " adsize : " + paramArrayOfByte.tLi);
    af.bDJ().h("@__weixintimtline", paramArrayOfByte.tJH, aa.a(paramArrayOfByte.tJk));
    paramInt1 = 0;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      if (paramInt1 < paramArrayOfByte.tLj.size())
      {
        localObject1 = (cn)paramArrayOfByte.tLj.get(paramInt1);
        String str2;
        if (this.eyq) {
          str2 = af.FU() + "ad.proto";
        }
        try
        {
          localObject3 = ((cn)localObject1).toByteArray();
          com.tencent.mm.vfs.e.b(str2, (byte[])localObject3, localObject3.length);
          str2 = aa.a(((cn)localObject1).svZ);
          localObject3 = aa.a(((cn)localObject1).svY.tJj);
          localObject1 = aa.b(((cn)localObject1).svY.tJi.tJU);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + (String)localObject3);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + (String)localObject1 + "\r\n");
          paramInt1 += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.eyq) && (paramArrayOfByte.tLj.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.e.c(af.FU() + "ad.proto", 0, -1);
      localObject2 = new cn();
      ((cn)localObject2).aH((byte[])localObject1);
      paramArrayOfByte.tLj.add(localObject2);
      paramArrayOfByte.tLi = paramArrayOfByte.tLj.size();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramArrayOfByte.tLi);
      if (paramArrayOfByte.tLj.size() > 0)
      {
        localObject1 = (cn)paramArrayOfByte.tLj.get(0);
        localObject2 = aa.a(((cn)localObject1).svZ);
        localObject3 = aa.a(((cn)localObject1).svY.tJj);
        String str3 = aa.b(((cn)localObject1).svY.tJi.tJU);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + (String)localObject2);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + (String)localObject3);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str3 + "\r\n");
        c((cn)localObject1);
      }
      a.j(paramArrayOfByte.tLj, paramArrayOfByte.sAA);
      a.aj(paramArrayOfByte.tLj);
      if (paramArrayOfByte.tLi == 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.tLk) });
        a.d(paramArrayOfByte.tLl, paramArrayOfByte.sAA);
        a.ai(paramArrayOfByte.tLl);
      }
      localObject1 = new LinkedList();
      localObject2 = paramArrayOfByte.sAA.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(Long.valueOf(((bto)((Iterator)localObject2).next()).sGd));
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
      }
      Object localObject2 = new qu();
      ((qu)localObject2).caa.cab = localException1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if (paramq.HF().spN == 207)
      {
        if (paramArrayOfByte.sAA.isEmpty())
        {
          af.bDF().bGT();
          this.opR = this.opQ;
        }
        for (;;)
        {
          this.oqJ = true;
          Nv("@__weixintimtline");
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          af.bDF().OH(i.fO(((bto)paramArrayOfByte.sAA.getFirst()).sGd));
          af.bDF().OG(i.fO(((bto)paramArrayOfByte.sAA.getLast()).sGd));
          a(paramArrayOfByte, str1);
          a.ak(paramArrayOfByte.sAA);
        }
      }
      if (!paramArrayOfByte.sAA.isEmpty()) {
        break label1579;
      }
    }
    af.bDF().bGT();
    this.opR = this.opQ;
    this.oqJ = true;
    for (;;)
    {
      Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label1579:
      a(paramArrayOfByte, str1);
      a.ak(paramArrayOfByte.sAA);
    }
  }
  
  public final boolean bCM()
  {
    return this.opP;
  }
  
  public final boolean bCN()
  {
    return this.oqJ;
  }
  
  public final boolean bCO()
  {
    return this.oqK;
  }
  
  public final boolean bCP()
  {
    return false;
  }
  
  public final long bCQ()
  {
    return this.opR;
  }
  
  public final boolean bCR()
  {
    return false;
  }
  
  public final long bCS()
  {
    return 0L;
  }
  
  public final int getType()
  {
    return 211;
  }
  
  public final String getUserName()
  {
    return "@__weixintimtline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */