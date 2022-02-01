package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129686);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dyr();
    ((c.a)localObject).otF = new dys();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
    ((c.a)localObject).funcId = 1967;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dyr)c.b.b(this.rr.otB);
    Log.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", new Object[] { paramString1, paramString2, paramString3 });
    ((dyr)localObject).abdA = paramString1;
    ((dyr)localObject).signature = paramString2;
    ((dyr)localObject).Vyh = paramString3;
    AppMethodBeat.o(129686);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(129687);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(129687);
    return i;
  }
  
  public final int getType()
  {
    return 1967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129688);
    Log.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(129688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.f
 * JD-Core Version:    0.7.0.1
 */