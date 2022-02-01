package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends p
  implements m
{
  public String VxC;
  public String VxD;
  public boolean VxE;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public k()
  {
    AppMethodBeat.i(69908);
    this.VxC = "";
    this.VxD = "";
    this.VxE = false;
    c.a locala = new c.a();
    locala.otE = new cpp();
    locala.otF = new cpq();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.funcId = 2541;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    c.b.b(this.rr.otB);
    AppMethodBeat.o(69908);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69909);
    this.callback = paramh;
    com.tencent.mm.plugin.ae.a.c.gxP().An(false);
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
    params = (cpq)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.VxC = params.VxC;
    this.VxD = params.aawk;
    this.VxE = params.VxE;
    Log.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s ,duty_info_darkmode %s need_agree_duty %s", new Object[] { this.VxC, this.VxD, Boolean.valueOf(this.VxE) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */