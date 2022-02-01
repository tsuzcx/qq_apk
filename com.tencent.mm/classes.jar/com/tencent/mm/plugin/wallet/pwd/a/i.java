package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private dij HIm;
  private com.tencent.mm.ak.i callback;
  private final d rr;
  
  public i()
  {
    AppMethodBeat.i(69547);
    d.a locala = new d.a();
    dii localdii = new dii();
    localdii.KBz = System.currentTimeMillis();
    locala.iLN = localdii;
    locala.iLO = new dij();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.aXF();
    AppMethodBeat.o(69547);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(69548);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69548);
    return i;
  }
  
  public final dij fOO()
  {
    AppMethodBeat.i(69550);
    if (this.HIm == null)
    {
      localdij = new dij();
      AppMethodBeat.o(69550);
      return localdij;
    }
    dij localdij = this.HIm;
    AppMethodBeat.o(69550);
    return localdij;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69549);
    Log.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HIm = ((dij)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */