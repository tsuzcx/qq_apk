package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private boolean HPM;
  private bpz HPP;
  public bqa HPQ;
  private i callback;
  private d hJu;
  
  public n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69917);
    this.HPM = paramBoolean;
    d.a locala = new d.a();
    locala.iLN = new bpz();
    locala.iLO = new bqa();
    if (paramBoolean) {
      locala.funcId = 2803;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktgetlottery")
    {
      locala.iLP = 0;
      locala.respCmdId = 0;
      this.hJu = locala.aXF();
      this.HPP = ((bpz)this.hJu.iLK.iLR);
      this.HPP.LXU = paramString;
      Log.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69917);
      return;
      locala.funcId = 2508;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69918);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(69918);
    return i;
  }
  
  public final int getType()
  {
    if (this.HPM) {
      return 2803;
    }
    return 2508;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69919);
    Log.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.HPQ = ((bqa)((d)params).iLL.iLR);
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