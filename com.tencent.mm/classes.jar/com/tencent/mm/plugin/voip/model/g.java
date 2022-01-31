package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class g
  extends m
  implements k
{
  private static final List<Object> esN = new ArrayList();
  private static final Set<Long> pPr = new HashSet();
  private long bIt;
  private b dmK;
  private f dmL;
  private final List<bi> esO = new LinkedList();
  
  public g()
  {
    y.d("MicroMsg.NetSceneSendMsg", "dktext :" + bk.csb());
    y.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    y.d("MicroMsg.NetSceneSendMsg", "dktext :" + bk.csb());
    if (!bk.bl(paramString1))
    {
      bi localbi = new bi();
      localbi.setStatus(1);
      localbi.ec(paramString1);
      localbi.bg(bd.iK(paramString1));
      localbi.fA(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt);
      this.bIt = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
      if (this.bIt == -1L) {
        break label161;
      }
    }
    label161:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bIt);
      return;
    }
  }
  
  private void Pg()
  {
    int i = 0;
    while (i < this.esO.size())
    {
      iS(i);
      i += 1;
    }
  }
  
  private void iS(int paramInt)
  {
    bi localbi = (bi)this.esO.get(paramInt);
    localbi.setStatus(5);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(localbi.field_msgId, localbi);
    Iterator localIterator = esN.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      String str = localbi.field_talker;
      str = localbi.field_content;
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new bpc();
    paramf.ecI = new bpd();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.ecG = 522;
    paramf.ecJ = 237;
    paramf.ecK = 1000000237;
    this.dmK = paramf.Kt();
    paramf = (bpc)this.dmK.ecE.ecN;
    List localList = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bia();
    int i;
    if (localList.size() == 0)
    {
      y.i("MicroMsg.NetSceneSendMsg", "no sending message");
      i = -2;
    }
    int j;
    do
    {
      return i;
      this.esO.clear();
      i = 0;
      while (i < localList.size())
      {
        bi localbi = (bi)localList.get(i);
        if (localbi.field_isSend == 1)
        {
          awn localawn = new awn();
          localawn.svG = new bml().YI(localbi.field_talker);
          localawn.mPL = ((int)(localbi.field_createTime / 1000L));
          localawn.hQR = localbi.getType();
          localawn.kVs = localbi.field_content;
          localawn.ttf = o.l(com.tencent.mm.model.q.Gj(), localbi.field_createTime).hashCode();
          localawn.svK = bf.HS();
          paramf.hPT.add(localawn);
          paramf.hPS = paramf.hPT.size();
          this.esO.add(localbi);
        }
        i += 1;
      }
      j = a(parame, this.dmK, this);
      i = j;
    } while (j >= 0);
    Pg();
    return j;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Pg();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      paramq = ((bpd)this.dmK.ecF.ecN).hPT;
      if (this.esO.size() == paramq.size())
      {
        paramInt1 = 0;
        while (paramInt1 < paramq.size())
        {
          paramArrayOfByte = (awo)paramq.get(paramInt1);
          if (paramArrayOfByte.sze != 0)
          {
            y.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.sze);
            iS(paramInt1);
            this.dmL.onSceneEnd(4, paramArrayOfByte.sze, paramString, this);
            return;
          }
          long l = ((bi)this.esO.get(paramInt1)).field_msgId;
          y.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.ndp + " sent successfully!");
          bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
          localbi.bf(paramArrayOfByte.ndp);
          localbi.setStatus(2);
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l, localbi);
          paramInt1 += 1;
        }
        y.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
      }
      paramInt1 = a(this.edc, this.dmL);
      if (paramInt1 == -2)
      {
        this.dmL.onSceneEnd(0, 0, paramString, this);
        return;
      }
    } while (paramInt1 >= 0);
    this.dmL.onSceneEnd(3, -1, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    if (this.esO.size() > 0) {
      return m.b.edr;
    }
    return m.b.eds;
  }
  
  public final int getType()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */