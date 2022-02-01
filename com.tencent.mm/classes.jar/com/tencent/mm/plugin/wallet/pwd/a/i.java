package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private g callback;
  private final b rr;
  private cfn zSk;
  
  public i()
  {
    AppMethodBeat.i(69547);
    b.a locala = new b.a();
    cfm localcfm = new cfm();
    localcfm.Csp = System.currentTimeMillis();
    locala.gUU = localcfm;
    locala.gUV = new cfn();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.atI();
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
  
  public final cfn eaB()
  {
    AppMethodBeat.i(69550);
    if (this.zSk == null)
    {
      localcfn = new cfn();
      AppMethodBeat.o(69550);
      return localcfn;
    }
    cfn localcfn = this.zSk;
    AppMethodBeat.o(69550);
    return localcfn;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69549);
    ad.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.zSk = ((cfn)((b)paramq).gUT.gUX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */