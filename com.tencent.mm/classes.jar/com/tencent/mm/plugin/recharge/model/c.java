package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  public String dAs;
  public String pSt;
  public b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.dAs = paramString2;
    this.pSt = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new atq();
    ((b.a)localObject).hQG = new atr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((b.a)localObject).funcId = 1555;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (atq)this.rr.hQD.hQJ;
    ((atq)localObject).GKy = paramString1;
    ((atq)localObject).FWe = paramString2;
    ((atq)localObject).wTF = paramString3;
    ((atq)localObject).GKz = paramString4;
    ((atq)localObject).GKA = paramString5;
    ((atq)localObject).xrf = com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().aFV(paramString1);
    AppMethodBeat.o(67101);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67103);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */