package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.a.rr;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
  extends m
  implements k
{
  private f dmL;
  private Set<String> ncs;
  
  public b(Set<String> paramSet)
  {
    Assert.assertTrue(true);
    this.ncs = paramSet;
  }
  
  private boolean h(q paramq)
  {
    Object localObject1 = (gt)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (localObject1 == null) {
      y.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
    }
    for (;;)
    {
      return false;
      if (paramq.HF().spN == 1)
      {
        y.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
        return false;
      }
      if (paramq.HF().spN == -1)
      {
        y.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
        return true;
      }
      localObject1 = ((gt)localObject1).sAz;
      if (localObject1 != null)
      {
        int j = 0;
        if (j < ((List)localObject1).size()) {
          try
          {
            paramq = (rl)new rl().aH(aa.a((bmk)((List)localObject1).get(j)));
            if ((paramq == null) || (paramq.hPY == null))
            {
              y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
              i = 0;
              if (i == 0) {
                continue;
              }
              j += 1;
            }
          }
          catch (IOException paramq)
          {
            for (;;)
            {
              int i;
              y.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", paramq, "", new Object[0]);
              y.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
              paramq = null;
              continue;
              if (!this.ncs.contains(paramq.hPY))
              {
                y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                i = 0;
              }
              else
              {
                this.ncs.remove(paramq.hPY);
                au.Hx();
                Object localObject2 = c.Fw().abl(paramq.hPY);
                if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).dBe == 0))
                {
                  y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                  i = 0;
                }
                else
                {
                  ((ad)localObject2).setUsername(paramq.hPY);
                  ((ad)localObject2).cZ(paramq.ffm);
                  ((ad)localObject2).setType(paramq.sPr & paramq.sPs);
                  ((ad)localObject2).dk(paramq.hRf);
                  ((ad)localObject2).dl(paramq.sPp);
                  ((ad)localObject2).dm(paramq.sPq);
                  ((ad)localObject2).fm(paramq.ffh);
                  ((ad)localObject2).df(paramq.sPt);
                  ((ad)localObject2).jdMethod_do(paramq.sPw);
                  ((ad)localObject2).dp(paramq.sPv);
                  ((ad)localObject2).fp(paramq.sPx);
                  ((ad)localObject2).dg(paramq.sPA);
                  ((ad)localObject2).fq(paramq.sPB);
                  au.Hx();
                  if (c.Fw().a(((ao)localObject2).field_username, (ad)localObject2) == -1) {
                    y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                  }
                  if (ad.aaT(paramq.hPY))
                  {
                    localObject2 = g.btk().Lc(paramq.hPY);
                    if ((localObject2 == null) || (bk.pm(((d)localObject2).getUsername()).length() <= 0))
                    {
                      y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                      i = 0;
                      continue;
                    }
                    ((d)localObject2).extInfo = paramq.kWx;
                    ((d)localObject2).ncv = paramq.sPD;
                    ((d)localObject2).ncw = paramq.sPE;
                    ((d)localObject2).bcw = 52;
                    if (!g.btk().a(paramq.hPY, (d)localObject2)) {
                      y.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                    }
                  }
                  if (ad.aaR(paramq.hPY))
                  {
                    localObject2 = new rr();
                    ((rr)localObject2).cbj.opType = 0;
                    ((rr)localObject2).cbj.bVI = paramq.hPY;
                    ((rr)localObject2).cbj.bVJ = paramq.sPD;
                    ((rr)localObject2).cbj.bVK = paramq.sPu;
                    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
                  }
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  protected final int Ka()
  {
    return 50;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new LinkedList();
    Object localObject = this.ncs.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramf.add((String)((Iterator)localObject).next());
    }
    if (paramf.size() == 0)
    {
      y.e("MicroMsg.NetSceneBatchGetContactProfile", com.tencent.mm.compatible.util.g.zI() + "doScene reqSize ==0");
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).ecH = new gs();
    ((b.a)localObject).ecI = new gt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).ecG = 140;
    ((b.a)localObject).ecJ = 28;
    ((b.a)localObject).ecK = 1000000028;
    localObject = ((b.a)localObject).Kt();
    LinkedList localLinkedList = new LinkedList();
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      localLinkedList.add(aa.pj((String)paramf.next()));
    }
    ((gs)((com.tencent.mm.ah.b)localObject).ecE.ecN).svn = localLinkedList;
    ((gs)((com.tencent.mm.ah.b)localObject).ecE.ecN).sAy = 1;
    ((gs)((com.tencent.mm.ah.b)localObject).ecE.ecN).hPS = localLinkedList.size();
    return a(parame, (q)localObject, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((h(paramq)) && (this.ncs.size() > 0)) {
      a(this.edc, this.dmL);
    }
    y.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.ncs.size());
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 140;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */