package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  public dpw Dcu;
  private f callback;
  private final b rr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182518);
    b.a locala = new b.a();
    dpv localdpv = new dpv();
    localdpv.HWS = paramInt1;
    localdpv.HWT = paramInt2;
    locala.hQF = localdpv;
    locala.hQG = new dpw();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
    locala.funcId = 1724;
    this.rr = locala.aDS();
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(182518);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69539);
    this.callback = paramf;
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
    ae.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dcu = ((dpw)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */