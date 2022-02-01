package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  public ejs HIi;
  private i callback;
  private final d rr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182518);
    d.a locala = new d.a();
    ejr localejr = new ejr();
    localejr.NiY = paramInt1;
    localejr.NiZ = paramInt2;
    locala.iLN = localejr;
    locala.iLO = new ejs();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
    locala.funcId = 1724;
    this.rr = locala.aXF();
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(182518);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69539);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69539);
    return i;
  }
  
  public final int getType()
  {
    return 1724;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69540);
    Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HIi = ((ejs)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */