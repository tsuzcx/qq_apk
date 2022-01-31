package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a
  extends u
{
  private f callback;
  public b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(48415);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bls();
    ((b.a)localObject).fsY = new blt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((b.a)localObject).funcId = 1519;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bls)this.rr.fsV.fta;
    ((bls)localObject).nsW = 10;
    ((bls)localObject).wzS = paramInt;
    ab.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(48415);
  }
  
  public final int cXr()
  {
    return ((blt)this.rr.fsW.fta).xAr;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48417);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48417);
    return i;
  }
  
  public final int getType()
  {
    return 1519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142598);
    ab.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((blt)((b)paramq).fsW.fta).xAr);
    }
    AppMethodBeat.o(142598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */