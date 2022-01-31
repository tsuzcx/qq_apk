package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a
  extends u
{
  private f callback;
  private b rr;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48438);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48438);
    return i;
  }
  
  public final int getType()
  {
    return 1554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142601);
    ab.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (blu)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + paramString.lGK);
    }
    paramString = paramString.lGL;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.a
 * JD-Core Version:    0.7.0.1
 */