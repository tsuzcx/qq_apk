package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private boolean COO;
  private bdt COS;
  public bdu COT;
  private f callback;
  private b gPp;
  
  public n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69917);
    this.COO = paramBoolean;
    b.a locala = new b.a();
    locala.hNM = new bdt();
    locala.hNN = new bdu();
    if (paramBoolean) {
      locala.funcId = 2803;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktgetlottery")
    {
      locala.hNO = 0;
      locala.respCmdId = 0;
      this.gPp = locala.aDC();
      this.COS = ((bdt)this.gPp.hNK.hNQ);
      this.COS.GAg = paramString;
      ad.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69917);
      return;
      locala.funcId = 2508;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69918);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(69918);
    return i;
  }
  
  public final int getType()
  {
    if (this.COO) {
      return 2803;
    }
    return 2508;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69919);
    ad.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.COT = ((bdu)((b)paramq).hNL.hNQ);
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