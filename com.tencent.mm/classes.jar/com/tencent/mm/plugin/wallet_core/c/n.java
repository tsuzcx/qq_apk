package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private boolean Dgt;
  private bej Dgw;
  public bek Dgx;
  private f callback;
  private b gRX;
  
  public n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69917);
    this.Dgt = paramBoolean;
    b.a locala = new b.a();
    locala.hQF = new bej();
    locala.hQG = new bek();
    if (paramBoolean) {
      locala.funcId = 2803;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktgetlottery")
    {
      locala.hQH = 0;
      locala.respCmdId = 0;
      this.gRX = locala.aDS();
      this.Dgw = ((bej)this.gRX.hQD.hQJ);
      this.Dgw.GTG = paramString;
      ae.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69917);
      return;
      locala.funcId = 2508;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69918);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(69918);
    return i;
  }
  
  public final int getType()
  {
    if (this.Dgt) {
      return 2803;
    }
    return 2508;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69919);
    ae.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Dgx = ((bek)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */