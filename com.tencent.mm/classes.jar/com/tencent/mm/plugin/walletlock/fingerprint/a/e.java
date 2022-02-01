package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  boolean BTR;
  private g callback;
  private b rr;
  String skD;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.BTR = false;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dit();
    ((b.a)localObject).hvu = new diu();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((b.a)localObject).funcId = 1548;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dit)this.rr.hvr.hvw;
    ((dit)localObject).scene = 1548;
    ((dit)localObject).znE = paramString1;
    ((dit)localObject).znF = paramString2;
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
    ac.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (diu)((b)paramq).hvs.hvw;
    this.skD = paramq.skD;
    ac.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.skD });
    if (paramq.FLq == 1) {}
    for (this.BTR = true;; this.BTR = false)
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