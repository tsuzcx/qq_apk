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
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  public String FJm;
  private dhp HPT;
  public dhq HPU;
  private i callback;
  private d hJu;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69923);
    d.a locala = new d.a();
    locala.iLN = new dhp();
    locala.iLO = new dhq();
    locala.funcId = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.HPT = ((dhp)this.hJu.iLK.iLR);
    this.HPT.Iie = paramString1;
    this.FJm = paramString2;
    Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(69923);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69924);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(69924);
    return i;
  }
  
  public final int getType()
  {
    return 2710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69925);
    Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.HPU = ((dhq)((d)params).iLL.iLR);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.HPU.pTZ), this.HPU.pUa });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */