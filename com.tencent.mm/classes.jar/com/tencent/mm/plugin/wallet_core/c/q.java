package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private eke VxP;
  public ekf VxQ;
  private h callback;
  private c nao;
  public String rBJ;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69923);
    c.a locala = new c.a();
    locala.otE = new eke();
    locala.otF = new ekf();
    locala.funcId = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.VxP = ((eke)c.b.b(this.nao.otB));
    this.VxP.VQZ = paramString1;
    this.rBJ = paramString2;
    Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(69923);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69924);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
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
    this.VxQ = ((ekf)c.c.b(((c)params).otC));
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.VxQ.wuz), this.VxQ.wuA });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */