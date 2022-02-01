package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  public ckb DHM;
  private cka DHN;
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(190241);
    b.a locala = new b.a();
    locala.hQF = new cka();
    locala.hQG = new ckb();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.aDS();
    this.DHN = ((cka)this.rr.hQD.hQJ);
    this.DHN.HwC = paramInt;
    AppMethodBeat.o(190241);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(190242);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(190242);
    return i;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190243);
    ae.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.DHM = ((ckb)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(190243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.b
 * JD-Core Version:    0.7.0.1
 */