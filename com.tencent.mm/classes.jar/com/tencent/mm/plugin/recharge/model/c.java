package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public String fLC;
  public d rr;
  public String uMF;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.fLC = paramString2;
    this.uMF = paramString3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new blu();
    ((d.a)localObject).lBV = new blv();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((d.a)localObject).funcId = 1555;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (blu)d.b.b(this.rr.lBR);
    ((blu)localObject).SWQ = paramString1;
    ((blu)localObject).RQN = paramString2;
    ((blu)localObject).GIM = paramString3;
    ((blu)localObject).SWR = paramString4;
    ((blu)localObject).SWS = paramString5;
    ((blu)localObject).HlB = com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhd(paramString1);
    AppMethodBeat.o(67101);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67103);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67103);
    return i;
  }
  
  public final int getType()
  {
    return 1555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67102);
    Log.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */