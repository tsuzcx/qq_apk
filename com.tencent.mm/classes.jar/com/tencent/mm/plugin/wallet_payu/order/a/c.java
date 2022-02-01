package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.w;

public final class c
  extends w
{
  public cki DKl;
  private f callback;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72062);
    this.DKl = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cks();
    ((b.a)localObject).hQG = new ckt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).funcId = 1520;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cks)this.rr.hQD.hQJ;
    if (!bu.isNullOrNil(paramString)) {
      ((cks)localObject).wSZ = paramString;
    }
    AppMethodBeat.o(72062);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72063);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72063);
    return i;
  }
  
  public final int getType()
  {
    return 1520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72064);
    ae.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (ckt)((b)paramq).hQE.hQJ;
      this.DKl = paramString.Hxb;
      if (paramString.Hxb != null)
      {
        ae.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.Hxb.wSZ);
        AppMethodBeat.o(72064);
        return;
      }
      ae.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
    }
    AppMethodBeat.o(72064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */