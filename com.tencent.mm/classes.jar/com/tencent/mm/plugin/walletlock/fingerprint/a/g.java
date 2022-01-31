package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e.b;

public final class g
  extends d
  implements k, com.tencent.soter.a.f.e
{
  private f callback;
  private String gJv = null;
  private com.tencent.soter.a.f.b<e.b> mGF = null;
  public com.tencent.mm.ai.b rr;
  
  public g(String paramString)
  {
    this.gJv = paramString;
  }
  
  public final void a(com.tencent.soter.a.f.b<e.b> paramb)
  {
    this.mGF = paramb;
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(51486);
    ab.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.mGF != null)
    {
      ab.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(51486);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(51485);
    ab.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    if (this.mGF != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mGF.cW(new e.b(true));
        AppMethodBeat.o(51485);
        return;
      }
      this.mGF.cW(new e.b(false));
    }
    AppMethodBeat.o(51485);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(51484);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51484);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(51488);
    com.tencent.mm.kernel.g.Rc().a(this, 0);
    AppMethodBeat.o(51488);
  }
  
  public final int getType()
  {
    return 1665;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(51487);
    ab.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(51487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.g
 * JD-Core Version:    0.7.0.1
 */