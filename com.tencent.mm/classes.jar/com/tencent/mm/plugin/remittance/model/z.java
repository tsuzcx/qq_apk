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
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends q
  implements m
{
  private sy Imd;
  public sz Ime;
  private i callback;
  private final d rr;
  
  public z(sq paramsq)
  {
    AppMethodBeat.i(271096);
    Log.i("MicroMsg.NetScenePersonalPaySuccPage", "personalpay_order_id = %s ,trans_id = %s ,total_amount = %s，placeorder_ext = %s", new Object[] { paramsq.InU, paramsq.InV, Long.valueOf(paramsq.InT), paramsq.InW });
    d.a locala = new d.a();
    locala.lBU = new sy();
    locala.lBV = new sz();
    locala.funcId = 4587;
    locala.uri = "/cgi-bin/mmpay-bin/personalpaysuccpage";
    this.rr = locala.bgN();
    this.Imd = ((sy)d.b.b(this.rr.lBR));
    this.Imd.Scb = paramsq;
    AppMethodBeat.o(271096);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(271098);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(271098);
    return i;
  }
  
  public final int getType()
  {
    return 4587;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271099);
    Log.i("MicroMsg.NetScenePersonalPaySuccPage", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ime = ((sz)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(271099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.z
 * JD-Core Version:    0.7.0.1
 */