package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  private i callback;
  private d rr;
  
  public f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(66683);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aju();
    ((d.a)localObject).iLO = new ajv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/evaluateorder";
    ((d.a)localObject).funcId = 583;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aju)this.rr.iLK.iLR;
    ((aju)localObject).Lti = paramString1;
    ((aju)localObject).jfi = paramString2;
    ((aju)localObject).Cyb = paramInt;
    ((aju)localObject).Lcc = k.fQy();
    AppMethodBeat.o(66683);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66685);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66685);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66684);
    Log.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.f
 * JD-Core Version:    0.7.0.1
 */