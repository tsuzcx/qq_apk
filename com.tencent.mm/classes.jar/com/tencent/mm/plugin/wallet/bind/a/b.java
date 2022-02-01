package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  private i callback;
  private String dQm;
  private d rr;
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69064);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69064);
    return i;
  }
  
  public final int getType()
  {
    return 621;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69063);
    Log.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.wallet.a.s.fOg();
      com.tencent.mm.plugin.wallet.a.s.fOh();
      an.aVo(this.dQm);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.b
 * JD-Core Version:    0.7.0.1
 */