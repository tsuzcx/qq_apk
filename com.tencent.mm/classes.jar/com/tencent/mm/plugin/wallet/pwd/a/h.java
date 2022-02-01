package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fps;
import com.tencent.mm.protocal.protobuf.fpt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class h
  extends w
{
  public fpt Vpk;
  public h.a Vpl;
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(182519);
    c.a locala = new c.a();
    fps localfps = new fps();
    localfps.abPm = paramInt;
    locala.otE = localfps;
    locala.otF = new fpt();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
    locala.funcId = 1813;
    this.rr = locala.bEF();
    AppMethodBeat.o(182519);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69545);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69545);
    return i;
  }
  
  public final int getType()
  {
    return 1813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(315597);
    Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Vpk = ((fpt)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */