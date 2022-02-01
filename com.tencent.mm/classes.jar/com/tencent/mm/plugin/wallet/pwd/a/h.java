package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public def zSh;
  public h.a zSi;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(182519);
    b.a locala = new b.a();
    dee localdee = new dee();
    localdee.Evu = paramInt;
    locala.gUU = localdee;
    locala.gUV = new def();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
    locala.funcId = 1813;
    this.rr = locala.atI();
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
    ad.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.zSh = ((def)((b)paramq).gUT.gUX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */