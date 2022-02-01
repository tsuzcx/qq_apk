package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.foo;
import com.tencent.mm.protocal.protobuf.fop;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  String Hgd;
  boolean WfT;
  private h callback;
  private c rr;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.WfT = false;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new foo();
    ((c.a)localObject).otF = new fop();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((c.a)localObject).funcId = 1548;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (foo)c.b.b(this.rr.otB);
    ((foo)localObject).scene = 1548;
    ((foo)localObject).RZY = paramString1;
    ((foo)localObject).mXG = paramString2;
    AppMethodBeat.o(129683);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(129684);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(129684);
    return i;
  }
  
  public final int getType()
  {
    return 1548;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(129685);
    Log.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (fop)c.c.b(((c)params).otC);
    this.Hgd = params.Hgd;
    Log.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.Hgd });
    if (params.abGo == 1) {}
    for (this.WfT = true;; this.WfT = false)
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