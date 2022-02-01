package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public cxd BkF;
  private cxe BkG;
  private g callback;
  private final b rr;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    b.a locala = new b.a();
    cxd localcxd = new cxd();
    localcxd.DKH = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localcxd.FGT = 1;; localcxd.FGT = 0)
    {
      this.BkF = localcxd;
      locala.hvt = localcxd;
      locala.hvu = new cxe();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.aAz();
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
  
  public final cxe epY()
  {
    AppMethodBeat.i(69556);
    if (this.BkG == null)
    {
      localcxe = new cxe();
      AppMethodBeat.o(69556);
      return localcxe;
    }
    cxe localcxe = this.BkG;
    AppMethodBeat.o(69556);
    return localcxe;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69555);
    ac.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.BkG = ((cxe)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */