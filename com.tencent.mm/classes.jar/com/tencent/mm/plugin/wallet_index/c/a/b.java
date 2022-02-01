package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  public cjh Dqg;
  private cjg Dqh;
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(199357);
    b.a locala = new b.a();
    locala.hNM = new cjg();
    locala.hNN = new cjh();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.aDC();
    this.Dqh = ((cjg)this.rr.hNK.hNQ);
    this.Dqh.Hdc = paramInt;
    AppMethodBeat.o(199357);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(199358);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(199358);
    return i;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199359);
    ad.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dqg = ((cjh)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(199359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.b
 * JD-Core Version:    0.7.0.1
 */