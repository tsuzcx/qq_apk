package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  private ckq BkE;
  private g callback;
  private final b rr;
  
  public i()
  {
    AppMethodBeat.i(69547);
    b.a locala = new b.a();
    ckp localckp = new ckp();
    localckp.DKH = System.currentTimeMillis();
    locala.hvt = localckp;
    locala.hvu = new ckq();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.aAz();
    AppMethodBeat.o(69547);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69548);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69548);
    return i;
  }
  
  public final ckq epX()
  {
    AppMethodBeat.i(69550);
    if (this.BkE == null)
    {
      localckq = new ckq();
      AppMethodBeat.o(69550);
      return localckq;
    }
    ckq localckq = this.BkE;
    AppMethodBeat.o(69550);
    return localckq;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69549);
    ac.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.BkE = ((ckq)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */