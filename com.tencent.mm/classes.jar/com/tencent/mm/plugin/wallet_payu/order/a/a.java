package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  private f callback;
  public b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(72056);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ckm();
    ((b.a)localObject).hQG = new ckn();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((b.a)localObject).funcId = 1519;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ckm)this.rr.hQD.hQJ;
    ((ckm)localObject).utU = 10;
    ((ckm)localObject).GeT = paramInt;
    ae.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(72056);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72058);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72058);
    return i;
  }
  
  public final int eMT()
  {
    return ((ckn)this.rr.hQE.hQJ).HwY;
  }
  
  public final int getType()
  {
    return 1519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72057);
    ae.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ae.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((ckn)((b)paramq).hQE.hQJ).HwY);
    }
    AppMethodBeat.o(72057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */