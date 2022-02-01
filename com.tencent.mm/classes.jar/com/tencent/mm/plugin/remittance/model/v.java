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
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m
{
  private sr IlV;
  private ss IlW;
  private i callback;
  private final d rr;
  
  public v(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(271411);
    Log.i("MicroMsg.NetScenePersonalPayCancelPay", "personalpay_order_id = %s ,trans_id = %s ,total_amount = %s，placeorder_ext = %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3 });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new sr();
    ((d.a)localObject).lBV = new ss();
    ((d.a)localObject).funcId = 5003;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/personalpaycancelpay";
    this.rr = ((d.a)localObject).bgN();
    this.IlV = ((sr)d.b.b(this.rr.lBR));
    localObject = new sq();
    ((sq)localObject).InU = paramString1;
    ((sq)localObject).InV = paramString2;
    ((sq)localObject).InT = paramLong;
    ((sq)localObject).InW = paramString3;
    this.IlV.Scb = ((sq)localObject);
    AppMethodBeat.o(271411);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(271415);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(271415);
    return i;
  }
  
  public final int getType()
  {
    return 5003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271417);
    Log.i("MicroMsg.NetScenePersonalPayCancelPay", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.IlW = ((ss)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(271417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */