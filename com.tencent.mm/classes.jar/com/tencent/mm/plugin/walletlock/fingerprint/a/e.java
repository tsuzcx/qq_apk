package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  boolean DLQ;
  private f callback;
  private b rr;
  String trY;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.DLQ = false;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dpf();
    ((b.a)localObject).hQG = new dpg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((b.a)localObject).funcId = 1548;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dpf)this.rr.hQD.hQJ;
    ((dpf)localObject).scene = 1548;
    ((dpf)localObject).AXb = paramString1;
    ((dpf)localObject).AXc = paramString2;
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
    ae.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (dpg)((b)paramq).hQE.hQJ;
    this.trY = paramq.trY;
    ae.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.trY });
    if (paramq.HPB == 1) {}
    for (this.DLQ = true;; this.DLQ = false)
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