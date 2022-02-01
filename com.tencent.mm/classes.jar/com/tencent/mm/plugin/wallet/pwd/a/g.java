package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  public djk BkA;
  private com.tencent.mm.ak.g callback;
  private final b rr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182518);
    b.a locala = new b.a();
    djj localdjj = new djj();
    localdjj.FSw = paramInt1;
    localdjj.FSx = paramInt2;
    locala.hvt = localdjj;
    locala.hvu = new djk();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
    locala.funcId = 1724;
    this.rr = locala.aAz();
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(182518);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(69539);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69539);
    return i;
  }
  
  public final int getType()
  {
    return 1724;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69540);
    ac.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.BkA = ((djk)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */