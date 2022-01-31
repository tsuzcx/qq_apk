package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  private b rr;
  public String ubv;
  public boolean ubw;
  
  public i()
  {
    AppMethodBeat.i(46503);
    this.ubv = "";
    this.ubw = false;
    b.a locala = new b.a();
    locala.fsX = new anx();
    locala.fsY = new any();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(46503);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46504);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46504);
    return i;
  }
  
  public final int getType()
  {
    return 2541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46505);
    ab.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(46505);
      return;
    }
    paramq = (any)((b)paramq).fsW.fta;
    this.ubv = paramq.ubv;
    this.ubw = paramq.ubw;
    ab.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.ubv, Boolean.valueOf(this.ubw) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(46505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */