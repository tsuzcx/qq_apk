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
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private asp BoA;
  public asq BoB;
  public long BoC;
  private g callback;
  private b gvE;
  
  public m(String paramString, long paramLong)
  {
    AppMethodBeat.i(69914);
    b.a locala = new b.a();
    locala.hvt = new asp();
    locala.hvu = new asq();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.BoA = ((asp)this.gvE.hvr.hvw);
    this.BoA.ELX = paramString;
    this.BoC = paramLong;
    ac.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(69914);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69915);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(69915);
    return i;
  }
  
  public final int getType()
  {
    return 2948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69916);
    ac.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.BoB = ((asq)((b)paramq).hvs.hvw);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ac.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.BoB.nWx), this.BoB.nWy, Integer.valueOf(this.BoB.ELY), this.BoB.ELZ, this.BoB.EMa });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */