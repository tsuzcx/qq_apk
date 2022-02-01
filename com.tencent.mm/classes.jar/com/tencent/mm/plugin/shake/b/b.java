package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class b
  extends n
  implements k
{
  private f callback;
  byte[] dMj;
  int ret;
  private final com.tencent.mm.al.b rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ddc();
    ((b.a)localObject).hNN = new ddd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).funcId = 161;
    ((b.a)localObject).hNO = 56;
    ((b.a)localObject).respCmdId = 1000000056;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ddc)this.rr.hNK.hNQ;
    ad.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((ddc)localObject).OpCode = 0;
    ((ddc)localObject).FOA = paramFloat1;
    ((ddc)localObject).FOB = paramFloat2;
    ((ddc)localObject).Ggw = paramInt1;
    ((ddc)localObject).Ggx = paramString1;
    ((ddc)localObject).Ggy = paramString2;
    ((ddc)localObject).Ggz = paramInt2;
    ba.aBQ();
    ((ddc)localObject).HrV = bt.a((Integer)c.ajl().get(4107, null), 0);
    ba.aBQ();
    paramInt2 = bt.n((Integer)c.ajl().get(4106, null));
    ((ddc)localObject).HrW = paramInt2;
    ba.aBQ();
    c.ajl().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new eah();
      paramString1.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
      ((ddc)localObject).FzL = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
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
  
  public final int dOq()
  {
    return ((ddc)this.rr.hNK.hNQ).Ggz;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28090);
    ad.d("MicroMsg.NetSceneShakeReport", "doScene");
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
    ad.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ddd)this.rr.hNL.hNQ;
    this.ret = paramq.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.dMj = z.a(paramArrayOfByte.FAN);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */