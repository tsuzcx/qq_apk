package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      ae.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bui();
    ((b.a)localObject).hQG = new buj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((b.a)localObject).funcId = 148;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bui)this.rr.hQD.hQJ;
    ((bui)localObject).OpCode = paramInt1;
    ((bui)localObject).GgZ = paramFloat1;
    ((bui)localObject).Gha = paramFloat2;
    ((bui)localObject).Gzf = paramInt2;
    ((bui)localObject).Gzg = paramString1;
    ((bui)localObject).Gzh = paramString2;
    ((bui)localObject).Gzi = paramInt3;
    try
    {
      eby localeby = new eby();
      localeby.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
      ((bui)localObject).FSj = new SKBuiltinBuffer_t().setBuffer(localeby.toByteArray());
      label223:
      ae.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      o.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public final int KZ()
  {
    return ((bui)this.rr.hQD.hQJ).OpCode;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(89766);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final boolean dxi()
  {
    return ((buj)this.rr.hQE.hQJ).HhI == 1;
  }
  
  public final int dxj()
  {
    return ((buj)this.rr.hQE.hQJ).HhJ;
  }
  
  public final List<bue> dxk()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((buj)this.rr.hQE.hQJ).GQv;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.ajP().aiU();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        bue localbue = (bue)localIterator.next();
        com.tencent.mm.plugin.c.a.aVH().aAh().mb(localbue.nIJ, localbue.GNI);
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
    ae.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (buj)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.GQv.size())
    {
      i locali = new i();
      locali.username = ((bue)paramq.GQv.get(paramInt1)).nIJ;
      locali.eQU = ((bue)paramq.GQv.get(paramInt1)).FNJ;
      locali.hPQ = ((bue)paramq.GQv.get(paramInt1)).GnN;
      locali.hPP = ((bue)paramq.GQv.get(paramInt1)).GnO;
      locali.eD(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aEN().am(paramArrayOfByte);
    if ((KZ() == 1) || (KZ() == 3) || (KZ() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(8210, Long.valueOf(System.currentTimeMillis() + paramq.HhH * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (KZ() == 2) {
        com.tencent.mm.kernel.g.ajR().ajA().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */