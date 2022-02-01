package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public String dSf;
  public String rjt;
  public d rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.dSf = paramString2;
    this.rjt = paramString3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new beq();
    ((d.a)localObject).iLO = new ber();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((d.a)localObject).funcId = 1555;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (beq)this.rr.iLK.iLR;
    ((beq)localObject).LOs = paramString1;
    ((beq)localObject).KPP = paramString2;
    ((beq)localObject).APy = paramString3;
    ((beq)localObject).LOt = paramString4;
    ((beq)localObject).LOu = paramString5;
    ((beq)localObject).Bri = com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVu(paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */