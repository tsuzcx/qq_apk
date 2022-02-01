package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  public doz CKO;
  private f callback;
  private final b rr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182518);
    b.a locala = new b.a();
    doy localdoy = new doy();
    localdoy.HDf = paramInt1;
    localdoy.HDg = paramInt2;
    locala.hNM = localdoy;
    locala.hNN = new doz();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
    locala.funcId = 1724;
    this.rr = locala.aDC();
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", new Object[] { Integer.valueOf(paramInt1) });
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
    ad.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.CKO = ((doz)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */