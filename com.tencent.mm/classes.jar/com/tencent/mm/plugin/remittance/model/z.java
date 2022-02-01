package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ern;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class z
  extends w
{
  public ero Ojs;
  private ern Ojt;
  private h callback;
  private final c rr;
  
  public z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(288851);
    Log.i("MicroMsg.NetScenePersonalPayRequestPayment", "appID = %s，out_prepay_id = %s", new Object[] { paramString1, paramString2 });
    c.a locala = new c.a();
    locala.otE = new ern();
    locala.otF = new ero();
    locala.funcId = 4912;
    locala.uri = "/cgi-bin/mmpay-bin/personalpayrequestpayment";
    this.rr = locala.bEF();
    this.Ojt = ((ern)c.b.b(this.rr.otB));
    this.Ojt.appid = paramString1;
    this.Ojt.Olk = paramString2;
    AppMethodBeat.o(288851);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288858);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288858);
    return i;
  }
  
  public final int getType()
  {
    return 4912;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288861);
    Log.i("MicroMsg.NetScenePersonalPayRequestPayment", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ojs = ((ero)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.z
 * JD-Core Version:    0.7.0.1
 */