package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  private g callback;
  private b rr;
  
  public f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(66683);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aep();
    ((b.a)localObject).hvu = new aeq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/evaluateorder";
    ((b.a)localObject).funcId = 583;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aep)this.rr.hvr.hvw;
    ((aep)localObject).Exo = paramString1;
    ((aep)localObject).hOf = paramString2;
    ((aep)localObject).wTE = paramInt;
    ((aep)localObject).EhT = k.ero();
    AppMethodBeat.o(66683);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66685);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66685);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66684);
    ac.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.f
 * JD-Core Version:    0.7.0.1
 */