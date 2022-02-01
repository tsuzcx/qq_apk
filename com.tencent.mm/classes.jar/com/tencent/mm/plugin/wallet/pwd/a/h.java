package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends n
  implements k
{
  public dju BkB;
  public h.a BkC;
  private g callback;
  private final b rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(182519);
    b.a locala = new b.a();
    djt localdjt = new djt();
    localdjt.FSx = paramInt;
    locala.hvt = localdjt;
    locala.hvu = new dju();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
    locala.funcId = 1813;
    this.rr = locala.aAz();
    AppMethodBeat.o(182519);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69545);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69545);
    return i;
  }
  
  public final int getType()
  {
    return 1813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69546);
    ac.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.BkB = ((dju)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */