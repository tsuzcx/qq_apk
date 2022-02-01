package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fpi;
import com.tencent.mm.protocal.protobuf.fpj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class g
  extends w
{
  public fpj Vpj;
  private h callback;
  private final c rr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182518);
    c.a locala = new c.a();
    fpi localfpi = new fpi();
    localfpi.abPl = paramInt1;
    localfpi.abPm = paramInt2;
    locala.otE = localfpi;
    locala.otF = new fpj();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
    locala.funcId = 1724;
    this.rr = locala.bEF();
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(182518);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(69539);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69539);
    return i;
  }
  
  public final int getType()
  {
    return 1724;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(315591);
    Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Vpj = ((fpj)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */