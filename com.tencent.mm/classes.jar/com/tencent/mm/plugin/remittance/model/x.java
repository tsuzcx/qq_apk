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
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements m
{
  private sw IlZ;
  public sx Ima;
  private i callback;
  private final d rr;
  
  public x(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(220711);
    Log.i("MicroMsg.NetScenePersonalPayPlaceOrder", "appID = %s ，outPrepayId = %s ,,totalAmount = %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    d.a locala = new d.a();
    locala.lBU = new sw();
    locala.lBV = new sx();
    locala.funcId = 4304;
    locala.uri = "/cgi-bin/mmpay-bin/personalpayplaceorder";
    this.rr = locala.bgN();
    this.IlZ = ((sw)d.b.b(this.rr.lBR));
    this.IlZ.appid = paramString1;
    this.IlZ.InS = paramString2;
    this.IlZ.InT = paramLong;
    AppMethodBeat.o(220711);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(220714);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(220714);
    return i;
  }
  
  public final int getType()
  {
    return 4304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220721);
    Log.i("MicroMsg.NetScenePersonalPayPlaceOrder", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ima = ((sx)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(220721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */