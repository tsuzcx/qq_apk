package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      ad.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bto();
    ((b.a)localObject).hNN = new btp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).funcId = 148;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bto)this.rr.hNK.hNQ;
    ((bto)localObject).OpCode = paramInt1;
    ((bto)localObject).FOA = paramFloat1;
    ((bto)localObject).FOB = paramFloat2;
    ((bto)localObject).Ggw = paramInt2;
    ((bto)localObject).Ggx = paramString1;
    ((bto)localObject).Ggy = paramString2;
    ((bto)localObject).Ggz = paramInt3;
    try
    {
      eah localeah = new eah();
      localeah.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
      ((bto)localObject).FzL = new SKBuiltinBuffer_t().setBuffer(localeah.toByteArray());
      label223:
      ad.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      o.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public final int KR()
  {
    return ((bto)this.rr.hNK.hNQ).OpCode;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(89766);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final boolean dtT()
  {
    return ((btp)this.rr.hNL.hNQ).GOi == 1;
  }
  
  public final int dtU()
  {
    return ((btp)this.rr.hNL.hNQ).GOj;
  }
  
  public final List<btk> dtV()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((btp)this.rr.hNL.hNQ).GwV;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.ajA().aiF();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        btk localbtk = (btk)localIterator.next();
        com.tencent.mm.plugin.c.a.aVi().azR().lU(localbtk.nDo, localbtk.Guj);
      }
    }
    AppMethodBeat.o(89768);
    return localLinkedList;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89767);
    ad.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (btp)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.GwV.size())
    {
      i locali = new i();
      locali.username = ((btk)paramq.GwV.get(paramInt1)).nDo;
      locali.ePj = ((btk)paramq.GwV.get(paramInt1)).Fvl;
      locali.hMX = ((btk)paramq.GwV.get(paramInt1)).FVo;
      locali.hMW = ((btk)paramq.GwV.get(paramInt1)).FVp;
      locali.eB(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aEx().am(paramArrayOfByte);
    if ((KR() == 1) || (KR() == 3) || (KR() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(8210, Long.valueOf(System.currentTimeMillis() + paramq.GOh * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (KR() == 2) {
        com.tencent.mm.kernel.g.ajC().ajl().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */