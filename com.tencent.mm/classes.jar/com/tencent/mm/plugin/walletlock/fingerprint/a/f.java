package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129686);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cbi();
    ((b.a)localObject).hvu = new cbj();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
    ((b.a)localObject).funcId = 1967;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cbi)this.rr.hvr.hvw;
    ac.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", new Object[] { paramString1, paramString2, paramString3 });
    ((cbi)localObject).Fpt = paramString1;
    ((cbi)localObject).signature = paramString2;
    ((cbi)localObject).Bpa = paramString3;
    AppMethodBeat.o(129686);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(129687);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(129687);
    return i;
  }
  
  public final int getType()
  {
    return 1967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129688);
    ac.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(129688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.f
 * JD-Core Version:    0.7.0.1
 */