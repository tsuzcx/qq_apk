package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class b
  extends n
  implements k
{
  private g callback;
  byte[] dzW;
  int ret;
  private final com.tencent.mm.ak.b rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxp();
    ((b.a)localObject).hvu = new cxq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).funcId = 161;
    ((b.a)localObject).reqCmdId = 56;
    ((b.a)localObject).respCmdId = 1000000056;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxp)this.rr.hvr.hvw;
    ac.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((cxp)localObject).OpCode = 0;
    ((cxp)localObject).Eht = paramFloat1;
    ((cxp)localObject).Ehu = paramFloat2;
    ((cxp)localObject).EyK = paramInt1;
    ((cxp)localObject).EyL = paramString1;
    ((cxp)localObject).EyM = paramString2;
    ((cxp)localObject).EyN = paramInt2;
    az.ayM();
    ((cxp)localObject).FHn = bs.a((Integer)c.agA().get(4107, null), 0);
    az.ayM();
    paramInt2 = bs.m((Integer)c.agA().get(4106, null));
    ((cxp)localObject).FHo = paramInt2;
    az.ayM();
    c.agA().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new dun();
      paramString1.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
      ((cxp)localObject).DUr = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
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
  
  public final int dCN()
  {
    return ((cxp)this.rr.hvr.hvw).EyN;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28090);
    ac.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cxq)this.rr.hvs.hvw;
    this.ret = paramq.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.dzW = z.a(paramArrayOfByte.DVs);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */