package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class g
  extends d
  implements e
{
  private b<e.b> HgL = null;
  private com.tencent.mm.am.h callback;
  private String qgt = null;
  public c rr;
  
  public g(String paramString)
  {
    this.qgt = paramString;
  }
  
  public final void VE(int paramInt)
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
    this.HgL = paramb;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(129690);
    Log.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    com.tencent.mm.plugin.soter.model.j.Sah = paramString;
    if (this.HgL != null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.HgL.hf(new e.b(true));
        AppMethodBeat.o(129690);
        return;
      }
      this.HgL.hf(new e.b(false));
    }
    AppMethodBeat.o(129690);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(129689);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(129689);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(129693);
    com.tencent.mm.kernel.h.aZW().a(this, 0);
    AppMethodBeat.o(129693);
  }
  
  public final void fuc()
  {
    AppMethodBeat.i(129691);
    Log.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    if (this.HgL != null)
    {
      Log.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
      this.HgL.hf(new e.b(false));
    }
    AppMethodBeat.o(129691);
  }
  
  public final int getType()
  {
    return 1665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.g
 * JD-Core Version:    0.7.0.1
 */