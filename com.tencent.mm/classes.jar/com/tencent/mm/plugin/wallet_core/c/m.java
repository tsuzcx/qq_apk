package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private g callback;
  private b iaa;
  private apl zWg;
  public apm zWh;
  public long zWi;
  
  public m(String paramString, long paramLong)
  {
    AppMethodBeat.i(69914);
    b.a locala = new b.a();
    locala.gUU = new apl();
    locala.gUV = new apm();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.zWg = ((apl)this.iaa.gUS.gUX);
    this.zWg.DqV = paramString;
    this.zWi = paramLong;
    ad.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(69914);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69915);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zWh = ((apm)((b)paramq).gUT.gUX);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ad.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.zWh.ntx), this.zWh.nty, Integer.valueOf(this.zWh.DqW), this.zWh.DqX, this.zWh.DqY });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */