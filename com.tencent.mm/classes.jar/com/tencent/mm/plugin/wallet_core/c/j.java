package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  public String HPH;
  public boolean HPI;
  private i callback;
  private d rr;
  
  public j()
  {
    AppMethodBeat.i(69908);
    this.HPH = "";
    this.HPI = false;
    d.a locala = new d.a();
    locala.iLN = new bsk();
    locala.iLO = new bsl();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69909);
    this.callback = parami;
    c.eBv().sC(false);
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
    params = (bsl)((d)params).iLL.iLR;
    this.HPH = params.HPH;
    this.HPI = params.HPI;
    Log.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.HPH, Boolean.valueOf(this.HPI) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */