package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  private f callback;
  private String dyN;
  private com.tencent.mm.ak.b rr;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69064);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69064);
    return i;
  }
  
  public final int getType()
  {
    return 621;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69063);
    ae.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      s.eGW();
      s.eGX();
      an.aFP(this.dyN);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.b
 * JD-Core Version:    0.7.0.1
 */