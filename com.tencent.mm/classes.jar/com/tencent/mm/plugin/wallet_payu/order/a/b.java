package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class b
  extends u
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(48418);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new blv();
    ((b.a)localObject).fsY = new blw();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payudeluserroll";
    ((b.a)localObject).funcId = 1544;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (blv)this.rr.fsV.fta;
    if (!bo.isNullOrNil(paramString)) {
      ((blv)localObject).ppY = paramString;
    }
    AppMethodBeat.o(48418);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48420);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48420);
    return i;
  }
  
  public final int getType()
  {
    return 1544;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142599);
    ab.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.b
 * JD-Core Version:    0.7.0.1
 */