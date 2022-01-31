package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  private final b rr;
  public cbe tXU;
  private cbf tXV;
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(46178);
    b.a locala = new b.a();
    cbe localcbe = new cbe();
    localcbe.wkd = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localcbe.xLX = 1;; localcbe.xLX = 0)
    {
      this.tXU = localcbe;
      locala.fsX = localcbe;
      locala.fsY = new cbf();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.ado();
      AppMethodBeat.o(46178);
      return;
    }
  }
  
  public final cbf cSq()
  {
    AppMethodBeat.i(46181);
    if (this.tXV == null)
    {
      localcbf = new cbf();
      AppMethodBeat.o(46181);
      return localcbf;
    }
    cbf localcbf = this.tXV;
    AppMethodBeat.o(46181);
    return localcbf;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46179);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46179);
    return i;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46180);
    ab.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tXV = ((cbf)((b)paramq).fsW.fta);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(46180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.i
 * JD-Core Version:    0.7.0.1
 */