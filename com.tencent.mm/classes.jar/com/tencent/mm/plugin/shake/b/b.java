package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class b
  extends n
  implements k
{
  private f callback;
  byte[] dNz;
  int ret;
  private final com.tencent.mm.ak.b rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ddw();
    ((b.a)localObject).hQG = new ddx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).funcId = 161;
    ((b.a)localObject).hQH = 56;
    ((b.a)localObject).respCmdId = 1000000056;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ddw)this.rr.hQD.hQJ;
    ae.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((ddw)localObject).OpCode = 0;
    ((ddw)localObject).GgZ = paramFloat1;
    ((ddw)localObject).Gha = paramFloat2;
    ((ddw)localObject).Gzf = paramInt1;
    ((ddw)localObject).Gzg = paramString1;
    ((ddw)localObject).Gzh = paramString2;
    ((ddw)localObject).Gzi = paramInt2;
    bc.aCg();
    ((ddw)localObject).HLx = bu.a((Integer)c.ajA().get(4107, null), 0);
    bc.aCg();
    paramInt2 = bu.o((Integer)c.ajA().get(4106, null));
    ((ddw)localObject).HLy = paramInt2;
    bc.aCg();
    c.ajA().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new eby();
      paramString1.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
      ((ddw)localObject).FSj = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
      label291:
      o.a(2002, paramFloat1, paramFloat2, paramInt1);
      AppMethodBeat.o(28089);
      return;
    }
    catch (Throwable paramString1)
    {
      break label291;
    }
  }
  
  public final int dRN()
  {
    return ((ddw)this.rr.hQD.hQJ).Gzi;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28090);
    ae.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28090);
    return i;
  }
  
  public final int getType()
  {
    return 161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28091);
    ae.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ddx)this.rr.hQE.hQJ;
    this.ret = paramq.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.dNz = z.a(paramArrayOfByte.FTj);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */