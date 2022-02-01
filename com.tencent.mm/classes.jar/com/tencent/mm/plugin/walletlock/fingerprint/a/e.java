package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  boolean ABw;
  private g callback;
  String rcj;
  private b rr;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.ABw = false;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ddf();
    ((b.a)localObject).gUV = new ddg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((b.a)localObject).funcId = 1548;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ddf)this.rr.gUS.gUX;
    ((ddf)localObject).scene = 1548;
    ((ddf)localObject).yaF = paramString1;
    ((ddf)localObject).yaG = paramString2;
    AppMethodBeat.o(129683);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(129684);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(129684);
    return i;
  }
  
  public final int getType()
  {
    return 1548;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129685);
    ad.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ddg)((b)paramq).gUT.gUX;
    this.rcj = paramq.rcj;
    ad.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.rcj });
    if (paramq.Eor == 1) {}
    for (this.ABw = true;; this.ABw = false)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(129685);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.e
 * JD-Core Version:    0.7.0.1
 */