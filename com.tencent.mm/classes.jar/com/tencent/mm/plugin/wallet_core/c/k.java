package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ad.a.a;
import com.tencent.mm.plugin.ad.a.c;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  public String OHQ;
  public boolean OHR;
  private i callback;
  private d rr;
  
  public k()
  {
    AppMethodBeat.i(69908);
    this.OHQ = "";
    this.OHR = false;
    d.a locala = new d.a();
    locala.lBU = new cag();
    locala.lBV = new cah();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    d.b.b(this.rr.lBR);
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69909);
    this.callback = parami;
    c.fnc().vR(false);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69909);
    return i;
  }
  
  public final int getType()
  {
    return 2541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69910);
    Log.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69910);
      return;
    }
    params = (cah)d.c.b(((d)params).lBS);
    this.OHQ = params.OHQ;
    this.OHR = params.OHR;
    Log.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.OHQ, Boolean.valueOf(this.OHR) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */