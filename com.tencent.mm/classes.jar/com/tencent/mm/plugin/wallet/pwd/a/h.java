package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  public ekc HIj;
  public h.a HIk;
  private i callback;
  private final d rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(182519);
    d.a locala = new d.a();
    ekb localekb = new ekb();
    localekb.NiZ = paramInt;
    locala.iLN = localekb;
    locala.iLO = new ekc();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
    locala.funcId = 1813;
    this.rr = locala.aXF();
    AppMethodBeat.o(182519);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69545);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69545);
    return i;
  }
  
  public final int getType()
  {
    return 1813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69546);
    Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HIj = ((ekc)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */