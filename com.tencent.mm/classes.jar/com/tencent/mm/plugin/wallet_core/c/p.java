package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
  extends n
  implements k
{
  private cjw BoH;
  public cjx BoI;
  private g callback;
  private b gvE;
  public String zPC;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69923);
    b.a locala = new b.a();
    locala.hvt = new cjw();
    locala.hvu = new cjx();
    locala.funcId = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.BoH = ((cjw)this.gvE.hvr.hvw);
    this.BoH.BGX = paramString1;
    this.zPC = paramString2;
    ac.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(69923);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69924);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(69924);
    return i;
  }
  
  public final int getType()
  {
    return 2710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69925);
    ac.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.BoI = ((cjx)((b)paramq).hvs.hvw);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ac.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.BoI.nWx), this.BoI.nWy });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */