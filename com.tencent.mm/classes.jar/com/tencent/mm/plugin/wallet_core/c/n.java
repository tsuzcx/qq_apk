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
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  private cep VxJ;
  public ceq VxK;
  private h callback;
  public long ehe;
  private c nao;
  
  public n(String paramString, long paramLong)
  {
    AppMethodBeat.i(69914);
    c.a locala = new c.a();
    locala.otE = new cep();
    locala.otF = new ceq();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.VxJ = ((cep)c.b.b(this.nao.otB));
    this.VxJ.aaoC = paramString;
    this.ehe = paramLong;
    Log.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(69914);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69915);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(69915);
    return i;
  }
  
  public final int getType()
  {
    return 2948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69916);
    Log.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.VxK = ((ceq)c.c.b(((c)params).otC));
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.VxK.wuz), this.VxK.wuA, Integer.valueOf(this.VxK.aaoD), this.VxK.aaoE, this.VxK.aaoF });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */