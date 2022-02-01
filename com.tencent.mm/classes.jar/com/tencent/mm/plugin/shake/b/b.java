package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class b
  extends n
  implements k
{
  private g callback;
  byte[] dCi;
  int ret;
  private final com.tencent.mm.al.b rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new csg();
    ((b.a)localObject).gUV = new csh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).funcId = 161;
    ((b.a)localObject).reqCmdId = 56;
    ((b.a)localObject).respCmdId = 1000000056;
    this.rr = ((b.a)localObject).atI();
    localObject = (csg)this.rr.gUS.gUX;
    ad.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((csg)localObject).OpCode = 0;
    ((csg)localObject).COI = paramFloat1;
    ((csg)localObject).COJ = paramFloat2;
    ((csg)localObject).DfE = paramInt1;
    ((csg)localObject).DfF = paramString1;
    ((csg)localObject).DfG = paramString2;
    ((csg)localObject).DfH = paramInt2;
    az.arV();
    ((csg)localObject).Ekp = bt.a((Integer)c.afk().get(4107, null), 0);
    az.arV();
    paramInt2 = bt.l((Integer)c.afk().get(4106, null));
    ((csg)localObject).Ekq = paramInt2;
    az.arV();
    c.afk().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new dow();
      paramString1.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
      ((csg)localObject).CBU = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
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
  
  public final int doD()
  {
    return ((csg)this.rr.gUS.gUX).DfH;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28090);
    ad.d("MicroMsg.NetSceneShakeReport", "doScene");
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
    ad.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (csh)this.rr.gUT.gUX;
    this.ret = paramq.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.dCi = z.a(paramArrayOfByte.CCV);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */