package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejb;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  boolean Ivf;
  private i callback;
  private d rr;
  String wFE;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129683);
    this.Ivf = false;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejb();
    ((d.a)localObject).iLO = new ejc();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((d.a)localObject).funcId = 1548;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejb)this.rr.iLK.iLR;
    ((ejb)localObject).scene = 1548;
    ((ejb)localObject).FhU = paramString1;
    ((ejb)localObject).hFF = paramString2;
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
    params = (ejc)((d)params).iLL.iLR;
    this.wFE = params.wFE;
    Log.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.wFE });
    if (params.Nbt == 1) {}
    for (this.Ivf = true;; this.Ivf = false)
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