package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.soter.a.f.e.b;

public final class g
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private com.tencent.mm.ak.g callback;
  private String iXf = null;
  public com.tencent.mm.ak.b rr;
  private com.tencent.soter.a.f.b<e.b> sli = null;
  
  public g(String paramString)
  {
    this.iXf = paramString;
  }
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(129692);
    ac.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(129692);
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.sli = paramb;
  }
  
  public final void cHM()
  {
    AppMethodBeat.i(129691);
    ac.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.sli != null)
    {
      ac.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(129691);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(129690);
    ac.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.sli != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sli.er(new e.b(true));
        AppMethodBeat.o(129690);
        return;
      }
      this.sli.er(new e.b(false));
    }
    AppMethodBeat.o(129690);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(129689);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(129689);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(129693);
    com.tencent.mm.kernel.g.agi().a(this, 0);
    AppMethodBeat.o(129693);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.g
 * JD-Core Version:    0.7.0.1
 */