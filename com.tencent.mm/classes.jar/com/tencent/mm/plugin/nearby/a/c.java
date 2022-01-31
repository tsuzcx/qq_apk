package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55363);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      ab.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new azv();
    ((b.a)localObject).fsY = new azw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).funcId = 148;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (azv)this.rr.fsV.fta;
    ((azv)localObject).OpCode = paramInt1;
    ((azv)localObject).wDh = paramFloat1;
    ((azv)localObject).wDi = paramFloat2;
    ((azv)localObject).wSk = paramInt2;
    ((azv)localObject).wSl = paramString1;
    ((azv)localObject).wSm = paramString2;
    ((azv)localObject).wSn = paramInt3;
    try
    {
      cuv localcuv = new cuv();
      localcuv.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.bXq());
      ((azv)localObject).wss = new SKBuiltinBuffer_t().setBuffer(localcuv.toByteArray());
      label223:
      ab.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      com.tencent.mm.modelstat.o.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(55363);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public final int Ac()
  {
    return ((azv)this.rr.fsV.fta).OpCode;
  }
  
  public final List<azr> bWA()
  {
    AppMethodBeat.i(55366);
    LinkedList localLinkedList = ((azw)this.rr.fsW.fta).xaT;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.RJ().QQ();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        azr localazr = (azr)localIterator.next();
        com.tencent.mm.plugin.c.a.asD().Zb().in(localazr.jJA, localazr.wYu);
      }
    }
    AppMethodBeat.o(55366);
    return localLinkedList;
  }
  
  public final boolean bWy()
  {
    return ((azw)this.rr.fsW.fta).xps == 1;
  }
  
  public final int bWz()
  {
    return ((azw)this.rr.fsW.fta).xpt;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(55364);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55364);
    return i;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55365);
    ab.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (azw)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.xaT.size())
    {
      h localh = new h();
      localh.username = ((azr)paramq.xaT.get(paramInt1)).jJA;
      localh.dqB = ((azr)paramq.xaT.get(paramInt1)).woS;
      localh.fsl = ((azr)paramq.xaT.get(paramInt1)).wJq;
      localh.fsk = ((azr)paramq.xaT.get(paramInt1)).wJr;
      localh.cM(true);
      paramArrayOfByte.add(localh);
      paramInt1 += 1;
    }
    com.tencent.mm.ah.o.adg().X(paramArrayOfByte);
    if ((Ac() == 1) || (Ac() == 3) || (Ac() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(55365);
        return;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(8210, Long.valueOf(System.currentTimeMillis() + paramq.xpr * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55365);
      return;
      if (Ac() == 2) {
        com.tencent.mm.kernel.g.RL().Ru().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */