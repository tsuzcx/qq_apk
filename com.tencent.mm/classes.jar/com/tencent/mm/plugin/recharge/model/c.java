package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  public String dpO;
  public String oEN;
  public b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.dpO = paramString2;
    this.oEN = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new amd();
    ((b.a)localObject).gUV = new ame();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((b.a)localObject).funcId = 1555;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (amd)this.rr.gUS.gUX;
    ((amd)localObject).Dnj = paramString1;
    ((amd)localObject).CFN = paramString2;
    ((amd)localObject).upE = paramString3;
    ((amd)localObject).Dnk = paramString4;
    ((amd)localObject).Dnl = paramString5;
    ((amd)localObject).Ddo = com.tencent.mm.plugin.wallet_core.model.mall.c.eds().atZ(paramString1);
    AppMethodBeat.o(67101);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67103);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67103);
    return i;
  }
  
  public final int getType()
  {
    return 1555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67102);
    ad.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */