package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  String ByB;
  boolean Ppk;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.Ppk = false;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new etd();
    ((d.a)localObject).lBV = new ete();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((d.a)localObject).funcId = 1548;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (etd)d.b.b(this.rr.lBR);
    ((etd)localObject).scene = 1548;
    ((etd)localObject).Lwz = paramString1;
    ((etd)localObject).ktM = paramString2;
    AppMethodBeat.o(129683);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(129684);
    this.callback = parami;
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
    params = (ete)d.c.b(((d)params).lBS);
    this.ByB = params.ByB;
    Log.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.ByB });
    if (params.UnM == 1) {}
    for (this.Ppk = true;; this.Ppk = false)
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