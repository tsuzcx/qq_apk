package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class g
  extends com.tencent.mm.plugin.soter.b.d
  implements m, e
{
  private i callback;
  private String krw = null;
  public com.tencent.mm.ak.d rr;
  private b<e.b> wGj = null;
  
  public g(String paramString)
  {
    this.krw = paramString;
  }
  
  public final void MO(int paramInt)
  {
    AppMethodBeat.i(129692);
    Log.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(129692);
  }
  
  public final void a(b<e.b> paramb)
  {
    this.wGj = paramb;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(129690);
    Log.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.wGj != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wGj.eB(new e.b(true));
        AppMethodBeat.o(129690);
        return;
      }
      this.wGj.eB(new e.b(false));
    }
    AppMethodBeat.o(129690);
  }
  
  public final void dKB()
  {
    AppMethodBeat.i(129691);
    Log.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.wGj != null)
    {
      Log.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
      this.wGj.eB(new e.b(false));
    }
    AppMethodBeat.o(129691);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(129689);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(129689);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(129693);
    com.tencent.mm.kernel.g.azz().a(this, 0);
    AppMethodBeat.o(129693);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.g
 * JD-Core Version:    0.7.0.1
 */