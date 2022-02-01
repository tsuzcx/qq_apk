package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  public dwo HIn;
  private dwp HIo;
  private i callback;
  private final d rr;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    d.a locala = new d.a();
    dwo localdwo = new dwo();
    localdwo.KBz = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localdwo.MWM = 1;; localdwo.MWM = 0)
    {
      this.HIn = localdwo;
      locala.iLN = localdwo;
      locala.iLO = new dwp();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.aXF();
      AppMethodBeat.o(69553);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69554);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69554);
    return i;
  }
  
  public final dwp fOP()
  {
    AppMethodBeat.i(69556);
    if (this.HIo == null)
    {
      localdwp = new dwp();
      AppMethodBeat.o(69556);
      return localdwp;
    }
    dwp localdwp = this.HIo;
    AppMethodBeat.o(69556);
    return localdwp;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69555);
    Log.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HIo = ((dwp)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */