package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  private cqk Dcy;
  private f callback;
  private final b rr;
  
  public i()
  {
    AppMethodBeat.i(69547);
    b.a locala = new b.a();
    cqj localcqj = new cqj();
    localcqj.FIl = System.currentTimeMillis();
    locala.hQF = localcqj;
    locala.hQG = new cqk();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.aDS();
    AppMethodBeat.o(69547);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69548);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69548);
    return i;
  }
  
  public final cqk eHE()
  {
    AppMethodBeat.i(69550);
    if (this.Dcy == null)
    {
      localcqk = new cqk();
      AppMethodBeat.o(69550);
      return localcqk;
    }
    cqk localcqk = this.Dcy;
    AppMethodBeat.o(69550);
    return localcqk;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69549);
    ae.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dcy = ((cqk)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */