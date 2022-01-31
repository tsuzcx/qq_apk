package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  public String czF;
  public String loz;
  public b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(44193);
    this.czF = paramString2;
    this.loz = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ads();
    ((b.a)localObject).fsY = new adt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((b.a)localObject).funcId = 1555;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ads)this.rr.fsV.fta;
    ((ads)localObject).wWF = paramString1;
    ((ads)localObject).wvG = paramString2;
    ((ads)localObject).pqE = paramString3;
    ((ads)localObject).wWG = paramString4;
    ((ads)localObject).wWH = paramString5;
    ((ads)localObject).wQf = com.tencent.mm.plugin.wallet_core.model.mall.c.cUX().afq(paramString1);
    AppMethodBeat.o(44193);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44195);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44195);
    return i;
  }
  
  public final int getType()
  {
    return 1555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44194);
    ab.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(44194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */