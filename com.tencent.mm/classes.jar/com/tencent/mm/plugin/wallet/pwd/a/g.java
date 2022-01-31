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
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private f callback;
  private final b rr;
  private bqo tXT;
  
  public g()
  {
    AppMethodBeat.i(46172);
    b.a locala = new b.a();
    bqn localbqn = new bqn();
    localbqn.wkd = System.currentTimeMillis();
    locala.fsX = localbqn;
    locala.fsY = new bqo();
    locala.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
    locala.funcId = 2635;
    this.rr = locala.ado();
    AppMethodBeat.o(46172);
  }
  
  public final bqo cSp()
  {
    AppMethodBeat.i(46175);
    if (this.tXT == null)
    {
      localbqo = new bqo();
      AppMethodBeat.o(46175);
      return localbqo;
    }
    bqo localbqo = this.tXT;
    AppMethodBeat.o(46175);
    return localbqo;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46173);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46173);
    return i;
  }
  
  public final int getType()
  {
    return 2635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46174);
    ab.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tXT = ((bqo)((b)paramq).fsW.fta);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(46174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */