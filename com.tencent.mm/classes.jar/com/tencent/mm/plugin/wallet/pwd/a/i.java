package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.protocal.protobuf.ekw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class i
  extends w
{
  private ekw Vpr;
  private h callback;
  private final c rr;
  
  public i()
  {
    AppMethodBeat.i(69547);
    c.a locala = new c.a();
    ekv localekv = new ekv();
    localekv.YzS = System.currentTimeMillis();
    locala.otE = localekv;
    locala.otF = new ekw();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.bEF();
    AppMethodBeat.o(69547);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69548);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69548);
    return i;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final ekw igy()
  {
    AppMethodBeat.i(69550);
    if (this.Vpr == null)
    {
      localekw = new ekw();
      AppMethodBeat.o(69550);
      return localekw;
    }
    ekw localekw = this.Vpr;
    AppMethodBeat.o(69550);
    return localekw;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(315594);
    Log.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Vpr = ((ekw)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */