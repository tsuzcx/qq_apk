package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private bin HPN;
  public bio HPO;
  private i callback;
  public long crw;
  private d hJu;
  
  public m(String paramString, long paramLong)
  {
    AppMethodBeat.i(69914);
    d.a locala = new d.a();
    locala.iLN = new bin();
    locala.iLO = new bio();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.HPN = ((bin)this.hJu.iLK.iLR);
    this.HPN.LSE = paramString;
    this.crw = paramLong;
    Log.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(69914);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69915);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.HPO = ((bio)((d)params).iLL.iLR);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.HPO.pTZ), this.HPO.pUa, Integer.valueOf(this.HPO.LSF), this.HPO.LSG, this.HPO.LSH });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */