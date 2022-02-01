package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  public String dnz;
  public String pio;
  public b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.dnz = paramString2;
    this.pio = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new apg();
    ((b.a)localObject).hvu = new aph();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((b.a)localObject).funcId = 1555;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (apg)this.rr.hvr.hvw;
    ((apg)localObject).EIj = paramString1;
    ((apg)localObject).DYn = paramString2;
    ((apg)localObject).vyA = paramString3;
    ((apg)localObject).EIk = paramString4;
    ((apg)localObject).EIl = paramString5;
    ((apg)localObject).Ewu = com.tencent.mm.plugin.wallet_core.model.mall.c.esN().azr(paramString1);
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
    ac.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */