package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private final b rr;
  public cru zSl;
  private crv zSm;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    b.a locala = new b.a();
    cru localcru = new cru();
    localcru.Csp = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localcru.EjV = 1;; localcru.EjV = 0)
    {
      this.zSl = localcru;
      locala.gUU = localcru;
      locala.gUV = new crv();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.atI();
      AppMethodBeat.o(69553);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69554);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69554);
    return i;
  }
  
  public final crv eaC()
  {
    AppMethodBeat.i(69556);
    if (this.zSm == null)
    {
      localcrv = new crv();
      AppMethodBeat.o(69556);
      return localcrv;
    }
    crv localcrv = this.zSm;
    AppMethodBeat.o(69556);
    return localcrv;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69555);
    ad.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.zSm = ((crv)((b)paramq).gUT.gUX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */