package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      y.e("MicroMsg.NetSceneLbsP", "OpCode Error :" + paramInt1);
    }
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new atq();
    ((b.a)localObject).ecI = new atr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).ecG = 148;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (atq)this.dmK.ecE.ecN;
    ((atq)localObject).ssq = paramInt1;
    ((atq)localObject).sGJ = paramFloat1;
    ((atq)localObject).sGK = paramFloat2;
    ((atq)localObject).sUn = paramInt2;
    ((atq)localObject).sUo = paramString1;
    ((atq)localObject).sUp = paramString2;
    ((atq)localObject).sUq = paramInt3;
    ((atq)localObject).tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
    y.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2 + " ccdLen:" + ((atq)localObject).tpt.tFK);
    com.tencent.mm.modelstat.o.a(2001, paramFloat1, paramFloat2, paramInt2);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (atr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.tcB.size())
    {
      h localh = new h();
      localh.username = ((atm)paramq.tcB.get(paramInt1)).hPY;
      localh.cCq = ((atm)paramq.tcB.get(paramInt1)).svI;
      localh.ebT = ((atm)paramq.tcB.get(paramInt1)).sLD;
      localh.ebS = ((atm)paramq.tcB.get(paramInt1)).sLE;
      localh.bK(true);
      paramArrayOfByte.add(localh);
      paramInt1 += 1;
    }
    com.tencent.mm.ag.o.Kh().Q(paramArrayOfByte);
    if ((rN() == 1) || (rN() == 3) || (rN() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.DP().Dz().o(8210, Long.valueOf(0L));
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      com.tencent.mm.kernel.g.DP().Dz().o(8210, Long.valueOf(System.currentTimeMillis() + paramq.tpu * 1000));
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (rN() == 2) {
        com.tencent.mm.kernel.g.DP().Dz().o(8210, Long.valueOf(0L));
      }
    }
  }
  
  public final boolean boc()
  {
    return ((atr)this.dmK.ecF.ecN).tpv == 1;
  }
  
  public final int bod()
  {
    return ((atr)this.dmK.ecF.ecN).tpw;
  }
  
  public final List<atm> boe()
  {
    LinkedList localLinkedList = ((atr)this.dmK.ecF.ecN).tcB;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.DN().CX();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        atm localatm = (atm)localIterator.next();
        com.tencent.mm.plugin.c.a.YT().Ga().gm(localatm.hPY, localatm.tac);
      }
    }
    return localLinkedList;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final int rN()
  {
    return ((atq)this.dmK.ecE.ecN).ssq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */