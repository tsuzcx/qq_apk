package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  boolean Dul;
  private f callback;
  private b rr;
  String thf;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.Dul = false;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new doi();
    ((b.a)localObject).hNN = new doj();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((b.a)localObject).funcId = 1548;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (doi)this.rr.hNK.hNQ;
    ((doi)localObject).scene = 1548;
    ((doi)localObject).AFy = paramString1;
    ((doi)localObject).AFz = paramString2;
    AppMethodBeat.o(129683);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(129684);
    this.callback = paramf;
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
    paramq = (doj)((b)paramq).hNL.hNQ;
    this.thf = paramq.thf;
    ad.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.thf });
    if (paramq.HvY == 1) {}
    for (this.Dul = true;; this.Dul = false)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(129685);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.e
 * JD-Core Version:    0.7.0.1
 */