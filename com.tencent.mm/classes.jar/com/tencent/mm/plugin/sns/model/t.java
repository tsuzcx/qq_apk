package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.ah.m
  implements k
{
  public int Zn = 0;
  final int bIl;
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  private long opR = 0L;
  public int opT = 0;
  public int opU = 0;
  private long oqq = 0L;
  private String oqr = "";
  
  public t()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bup();
    ((b.a)localObject).ecI = new buq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).ecG = 718;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    int i;
    if (aq.isWifi(ae.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.bIl = 2;
      bup localbup = (bup)this.dmK.ecE.ecN;
      localbup.tJm = i;
      localbup.tJI = 0L;
      int j = af.bDv().bEe();
      this.opR = af.bDF().e(0L, j, true);
      localbup.tLe = this.opR;
      int k = c.a(this.opR, 0L, "@__weixintimtline");
      localbup.tLf = k;
      this.oqq = af.bDF().e(0L, 1, true);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.oqq);
      localbup.tLg = this.oqq;
      l locall = af.bDJ().OF("@__weixintimtline");
      if (locall == null)
      {
        localObject = "";
        label258:
        this.oqr = ((String)localObject);
        if (this.oqr == null) {
          this.oqr = "";
        }
        localbup.tJH = this.oqr;
        if ((locall != null) && (locall.field_adsession != null)) {
          break label453;
        }
      }
      for (localbup.tJk = new bmk().bs(new byte[0]);; localbup.tJk = new bmk().bs(locall.field_adsession))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.opR + " ReqTime:" + localbup.tLf + " nettype: " + i);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { i.fN(this.opR), Integer.valueOf(k) });
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
          break label495;
        }
        i = 2;
        break;
        localObject = locall.field_md5;
        break label258;
        label453:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
      }
      label495:
      i = 0;
    }
  }
  
  private void a(buq parambuq, String paramString)
  {
    aj.a("@__weixintimtline", this.bIl, parambuq.sAA, paramString);
    this.opR = ((bto)parambuq.sAA.getLast()).sGd;
    c.f("@__weixintimtline", ((bto)parambuq.sAA.getFirst()).sGd, this.opR, parambuq.tLh);
    parambuq = parambuq.sAA.iterator();
    while (parambuq.hasNext())
    {
      paramString = (bto)parambuq.next();
      if (paramString.tKf == 0)
      {
        Object localObject1 = af.bDF().gt(paramString.sGd);
        if ((localObject1 != null) && (((n)localObject1).bGe() != null))
        {
          ??? = ((n)localObject1).bGe().tNr.sPJ;
          Object localObject2 = ???.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            awd localawd = (awd)((Iterator)localObject2).next();
            if (???.size() <= 1)
            {
              i = 1;
              label173:
              if (localawd == null) {
                break label314;
              }
              localObject3 = i.e(localawd);
              if (i == 0) {
                break label316;
              }
            }
            label314:
            label316:
            for (int i = 1;; i = 0)
            {
              localObject4 = an.eJ(af.getAccSnsPath(), localawd.lsK);
              if ((!com.tencent.mm.vfs.e.bK((String)localObject4 + (String)localObject3)) && (!com.tencent.mm.vfs.e.bK((String)localObject4 + i.l(localawd))) && (!com.tencent.mm.vfs.e.bK((String)localObject4 + i.m(localawd)))) {
                break label321;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { localawd.lsK });
              break;
              i = 0;
              break label173;
              break;
            }
            label321:
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { localawd.lsK });
            Object localObject3 = new com.tencent.mm.plugin.sns.data.e(localawd);
            ((com.tencent.mm.plugin.sns.data.e)localObject3).omU = i;
            ((com.tencent.mm.plugin.sns.data.e)localObject3).lJQ = localawd.lsK;
            Object localObject4 = af.bDA();
            if (localawd.hQR == 6) {}
            for (i = 5;; i = 1)
            {
              ((b)localObject4).a(localawd, i, (com.tencent.mm.plugin.sns.data.e)localObject3, az.uBC);
              break;
            }
          }
          if (((n)localObject1).field_type == 15)
          {
            localObject2 = af.bDD();
            if (localObject1 != null) {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", new Object[] { Integer.valueOf(localObject2.hashCode()), ((n)localObject1).bGE() });
            }
            synchronized (((ar)localObject2).otM)
            {
              ((ar)localObject2).otM.addFirst(localObject1);
              try
              {
                localObject1 = ((awd)((n)localObject1).bGe().tNr.sPJ.get(0)).kSC;
                h.nFQ.f(14388, new Object[] { Long.valueOf(paramString.sGd), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
          }
        }
      }
    }
    af.bDD().bEj();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (buq)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramq.HF().spN != 207) && (paramq.HF().spN != 0))
    {
      y.Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.tJN != null)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + paramArrayOfByte.tJN.tLa + " " + paramArrayOfByte.tJN.tKZ);
      paramInt1 = paramArrayOfByte.tJN.tLa;
      com.tencent.mm.plugin.sns.c.a.omJ = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.omJ = 2147483647;
      }
      com.tencent.mm.storage.ab.unw = paramArrayOfByte.tJN.tKZ;
    }
    this.opT = paramArrayOfByte.tJL;
    this.opU = paramArrayOfByte.tJM;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + paramArrayOfByte.tJL + " , objCount:  " + paramArrayOfByte.ttP + " cflag : " + paramArrayOfByte.tJM);
    this.Zn = paramArrayOfByte.ttP;
    String str = i.fO(0L);
    if (!paramArrayOfByte.sAA.isEmpty()) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + paramArrayOfByte.sAA.size() + " Max " + ((bto)paramArrayOfByte.sAA.getFirst()).sGd + " " + i.fN(((bto)paramArrayOfByte.sAA.getFirst()).sGd) + "  respone min  " + ((bto)paramArrayOfByte.sAA.getLast()).sGd + " " + i.fN(((bto)paramArrayOfByte.sAA.getLast()).sGd));
    }
    for (;;)
    {
      this.Zn = paramArrayOfByte.ttP;
      if (!this.oqr.equals(paramArrayOfByte.tJH)) {
        break;
      }
      this.opR = af.bDF().e(0L, this.opT, true);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.opR) });
      y.Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + paramArrayOfByte.sAA.size() + " adsize : " + paramArrayOfByte.tLi);
    af.bDJ().h("@__weixintimtline", paramArrayOfByte.tJH, aa.a(paramArrayOfByte.tJk));
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfByte.tLj.size())
    {
      Object localObject3 = (cn)paramArrayOfByte.tLj.get(paramInt1);
      localObject1 = aa.a(((cn)localObject3).svZ);
      localObject2 = aa.a(((cn)localObject3).svY.tJj);
      localObject3 = aa.b(((cn)localObject3).svY.tJi.tJU);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + (String)localObject1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + (String)localObject2);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + (String)localObject3 + "\r\n");
      paramInt1 += 1;
    }
    a.j(paramArrayOfByte.tLj, paramArrayOfByte.sAA);
    a.aj(paramArrayOfByte.tLj);
    if (paramArrayOfByte.tLi == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.tLk) });
      a.d(paramArrayOfByte.tLl, paramArrayOfByte.sAA);
      a.ai(paramArrayOfByte.tLl);
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = paramArrayOfByte.sAA.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(Long.valueOf(((bto)((Iterator)localObject2).next()).sGd));
    }
    localObject2 = new qu();
    ((qu)localObject2).caa.cab = ((LinkedList)localObject1);
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    if (paramq.HF().spN == 207)
    {
      if (paramArrayOfByte.sAA.isEmpty()) {
        af.bDF().bGT();
      }
      for (;;)
      {
        y.Nv("@__weixintimtline");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        af.bDF().OH(i.fO(((bto)paramArrayOfByte.sAA.getFirst()).sGd));
        af.bDF().OG(i.fO(((bto)paramArrayOfByte.sAA.getLast()).sGd));
        a(paramArrayOfByte, str);
        a.ak(paramArrayOfByte.sAA);
      }
    }
    if (paramArrayOfByte.sAA.isEmpty()) {
      af.bDF().bGT();
    }
    for (;;)
    {
      y.Nv("@__weixintimtline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      a(paramArrayOfByte, str);
      a.ak(paramArrayOfByte.sAA);
    }
  }
  
  public final int getType()
  {
    return 718;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */