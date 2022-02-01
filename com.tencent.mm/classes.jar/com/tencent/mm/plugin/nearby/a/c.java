package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      ad.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new blf();
    ((b.a)localObject).gUV = new blg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).funcId = 148;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (blf)this.rr.gUS.gUX;
    ((blf)localObject).OpCode = paramInt1;
    ((blf)localObject).COI = paramFloat1;
    ((blf)localObject).COJ = paramFloat2;
    ((blf)localObject).DfE = paramInt2;
    ((blf)localObject).DfF = paramString1;
    ((blf)localObject).DfG = paramString2;
    ((blf)localObject).DfH = paramInt3;
    try
    {
      dow localdow = new dow();
      localdow.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
      ((blf)localObject).CBU = new SKBuiltinBuffer_t().setBuffer(localdow.toByteArray());
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
  
  public final int JJ()
  {
    return ((blf)this.rr.gUS.gUX).OpCode;
  }
  
  public final boolean cVZ()
  {
    return ((blg)this.rr.gUT.gUX).DJj == 1;
  }
  
  public final int cWa()
  {
    return ((blg)this.rr.gUT.gUX).DJk;
  }
  
  public final List<blb> cWb()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((blg)this.rr.gUT.gUX).DsN;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.afz().aeD();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        blb localblb = (blb)localIterator.next();
        com.tencent.mm.plugin.c.a.aLf().aqn().kY(localblb.mAQ, localblb.Dqd);
      }
    }
    AppMethodBeat.o(89768);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (blg)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.DsN.size())
    {
      i locali = new i();
      locali.username = ((blb)paramq.DsN.get(paramInt1)).mAQ;
      locali.evo = ((blb)paramq.DsN.get(paramInt1)).CxA;
      locali.gUg = ((blb)paramq.DsN.get(paramInt1)).CVv;
      locali.gUf = ((blb)paramq.DsN.get(paramInt1)).CVw;
      locali.ee(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.auF().ao(paramArrayOfByte);
    if ((JJ() == 1) || (JJ() == 3) || (JJ() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.afB().afk().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.g.afB().afk().set(8210, Long.valueOf(System.currentTimeMillis() + paramq.DJi * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (JJ() == 2) {
        com.tencent.mm.kernel.g.afB().afk().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */