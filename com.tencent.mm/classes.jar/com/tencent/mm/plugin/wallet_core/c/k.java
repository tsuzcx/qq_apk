package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private b goo;
  private age ubA;
  public agf ubB;
  public long ubC;
  
  public k(String paramString, long paramLong)
  {
    AppMethodBeat.i(46509);
    b.a locala = new b.a();
    locala.fsX = new age();
    locala.fsY = new agf();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.funcId = 2948;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.ubA = ((age)this.goo.fsV.fta);
    this.ubA.wZg = paramString;
    this.ubC = paramLong;
    ab.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(46509);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46510);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(46510);
    return i;
  }
  
  public final int getType()
  {
    return 2948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46511);
    ab.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ubB = ((agf)((b)paramq).fsW.fta);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      ab.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.ubB.koj), this.ubB.kok, Integer.valueOf(this.ubB.wZh), this.ubB.wZi, this.ubB.wZj });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(46511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */