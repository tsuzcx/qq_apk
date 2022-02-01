package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends com.tencent.mm.wallet_core.model.w
{
  private uh Ojm;
  private ui Ojn;
  private h callback;
  private final c rr;
  
  public w(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(288831);
    Log.i("MicroMsg.NetScenePersonalPayCancelPay", "personalpay_order_id = %s ,trans_id = %s ,total_amount = %s，placeorder_ext = %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3 });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new uh();
    ((c.a)localObject).otF = new ui();
    ((c.a)localObject).funcId = 5003;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/personalpaycancelpay";
    this.rr = ((c.a)localObject).bEF();
    this.Ojm = ((uh)c.b.b(this.rr.otB));
    localObject = new ug();
    ((ug)localObject).Olm = paramString1;
    ((ug)localObject).Oln = paramString2;
    ((ug)localObject).Oll = paramLong;
    ((ug)localObject).Olo = paramString3;
    this.Ojm.YZT = ((ug)localObject);
    AppMethodBeat.o(288831);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288836);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288836);
    return i;
  }
  
  public final int getType()
  {
    return 5003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288838);
    Log.i("MicroMsg.NetScenePersonalPayCancelPay", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ojn = ((ui)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */