package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  public dyk Imb;
  private dyj Imc;
  private i callback;
  private final d rr;
  
  public y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187306);
    Log.i("MicroMsg.NetScenePersonalPayRequestPayment", "appID = %s，out_prepay_id = %s", new Object[] { paramString1, paramString2 });
    d.a locala = new d.a();
    locala.lBU = new dyj();
    locala.lBV = new dyk();
    locala.funcId = 4912;
    locala.uri = "/cgi-bin/mmpay-bin/personalpayrequestpayment";
    this.rr = locala.bgN();
    this.Imc = ((dyj)d.b.b(this.rr.lBR));
    this.Imc.appid = paramString1;
    this.Imc.InS = paramString2;
    AppMethodBeat.o(187306);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187308);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(187308);
    return i;
  }
  
  public final int getType()
  {
    return 4912;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187311);
    Log.i("MicroMsg.NetScenePersonalPayRequestPayment", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Imb = ((dyk)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */