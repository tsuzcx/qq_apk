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
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class x
  extends w
{
  private ul Ojo;
  private uk Ojp;
  private h callback;
  private final c rr;
  
  public x(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(288844);
    Log.i("MicroMsg.NetScenePersonalPayCheck", "personalpay_order_id = %s ,trans_id = %s ,total_amount = %s，placeorder_ext = %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3 });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new uk();
    ((c.a)localObject).otF = new ul();
    ((c.a)localObject).funcId = 5047;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/personalpaypaycheck";
    this.rr = ((c.a)localObject).bEF();
    this.Ojp = ((uk)c.b.b(this.rr.otB));
    localObject = new ug();
    ((ug)localObject).Olm = paramString1;
    ((ug)localObject).Oln = paramString2;
    ((ug)localObject).Oll = paramLong;
    ((ug)localObject).Olo = paramString3;
    this.Ojp.YZT = ((ug)localObject);
    AppMethodBeat.o(288844);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288856);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288856);
    return i;
  }
  
  public final int getType()
  {
    return 5047;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288862);
    Log.i("MicroMsg.NetScenePersonalPayCheck", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ojo = ((ul)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */