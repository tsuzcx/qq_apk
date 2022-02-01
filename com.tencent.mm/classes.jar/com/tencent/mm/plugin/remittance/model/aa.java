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
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class aa
  extends w
{
  private uo Oju;
  public up Ojv;
  private h callback;
  private final c rr;
  
  public aa(ug paramug)
  {
    AppMethodBeat.i(288789);
    Log.i("MicroMsg.NetScenePersonalPaySuccPage", "personalpay_order_id = %s ,trans_id = %s ,total_amount = %s，placeorder_ext = %s", new Object[] { paramug.Olm, paramug.Oln, Long.valueOf(paramug.Oll), paramug.Olo });
    c.a locala = new c.a();
    locala.otE = new uo();
    locala.otF = new up();
    locala.funcId = 4587;
    locala.uri = "/cgi-bin/mmpay-bin/personalpaysuccpage";
    this.rr = locala.bEF();
    this.Oju = ((uo)c.b.b(this.rr.otB));
    this.Oju.YZT = paramug;
    AppMethodBeat.o(288789);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288794);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288794);
    return i;
  }
  
  public final int getType()
  {
    return 4587;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288797);
    Log.i("MicroMsg.NetScenePersonalPaySuccPage", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ojv = ((up)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */