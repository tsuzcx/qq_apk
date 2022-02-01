package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fao;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class k
  extends w
{
  public fao Vps;
  private fap Vpt;
  private h callback;
  private final c rr;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    c.a locala = new c.a();
    fao localfao = new fao();
    localfao.YzS = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localfao.aagR = 1;; localfao.aagR = 0)
    {
      this.Vps = localfao;
      locala.otE = localfao;
      locala.otF = new fap();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.bEF();
      AppMethodBeat.o(69553);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69554);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69554);
    return i;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final fap igz()
  {
    AppMethodBeat.i(69556);
    if (this.Vpt == null)
    {
      localfap = new fap();
      AppMethodBeat.o(69556);
      return localfap;
    }
    fap localfap = this.Vpt;
    AppMethodBeat.o(69556);
    return localfap;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(315587);
    Log.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Vpt = ((fap)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */