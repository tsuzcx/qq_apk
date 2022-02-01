package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.cf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public bhj COL;
  private f callback;
  private final b rr;
  
  public k()
  {
    AppMethodBeat.i(199295);
    b.a locala = new b.a();
    bhi localbhi = new bhi();
    localbhi.timestamp = cf.aCL();
    locala.hNM = localbhi;
    locala.hNN = new bhj();
    locala.funcId = 2860;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassisplugin";
    this.rr = locala.aDC();
    AppMethodBeat.o(199295);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(199296);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(199296);
    return i;
  }
  
  public final int getType()
  {
    return 2860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199297);
    ad.w("MicroMsg.NetSceneGetReceipAssistPlugin", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.COL = ((bhj)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(199297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */