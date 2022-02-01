package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      ac.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bpb();
    ((b.a)localObject).hvu = new bpc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).funcId = 148;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bpb)this.rr.hvr.hvw;
    ((bpb)localObject).OpCode = paramInt1;
    ((bpb)localObject).Eht = paramFloat1;
    ((bpb)localObject).Ehu = paramFloat2;
    ((bpb)localObject).EyK = paramInt2;
    ((bpb)localObject).EyL = paramString1;
    ((bpb)localObject).EyM = paramString2;
    ((bpb)localObject).EyN = paramInt3;
    try
    {
      dun localdun = new dun();
      localdun.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
      ((bpb)localObject).DUr = new SKBuiltinBuffer_t().setBuffer(localdun.toByteArray());
      label223:
      ac.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      o.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public final int Js()
  {
    return ((bpb)this.rr.hvr.hvw).OpCode;
  }
  
  public final boolean djH()
  {
    return ((bpc)this.rr.hvs.hvw).FeE == 1;
  }
  
  public final int djI()
  {
    return ((bpc)this.rr.hvs.hvw).FeF;
  }
  
  public final List<box> djJ()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((bpc)this.rr.hvs.hvw).ENR;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.agP().afT();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        box localbox = (box)localIterator.next();
        com.tencent.mm.plugin.c.a.aRW().axc().lv(localbox.ncR, localbox.ELg);
      }
    }
    AppMethodBeat.o(89768);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(89766);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89767);
    ac.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bpc)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.ENR.size())
    {
      i locali = new i();
      locali.username = ((box)paramq.ENR.get(paramInt1)).ncR;
      locali.exK = ((box)paramq.ENR.get(paramInt1)).DPW;
      locali.huF = ((box)paramq.ENR.get(paramInt1)).Eof;
      locali.huE = ((box)paramq.ENR.get(paramInt1)).Eog;
      locali.ez(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aBw().al(paramArrayOfByte);
    if ((Js() == 1) || (Js() == 3) || (Js() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.agR().agA().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.g.agR().agA().set(8210, Long.valueOf(System.currentTimeMillis() + paramq.FeD * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (Js() == 2) {
        com.tencent.mm.kernel.g.agR().agA().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */