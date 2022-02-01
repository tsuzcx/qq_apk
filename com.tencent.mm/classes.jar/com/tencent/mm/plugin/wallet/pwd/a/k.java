package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public dcq CKT;
  private dcr CKU;
  private f callback;
  private final b rr;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    b.a locala = new b.a();
    dcq localdcq = new dcq();
    localdcq.FpN = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localdcq.HrB = 1;; localdcq.HrB = 0)
    {
      this.CKT = localdcq;
      locala.hNM = localdcq;
      locala.hNN = new dcr();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.aDC();
      AppMethodBeat.o(69553);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69554);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69554);
    return i;
  }
  
  public final dcr eDY()
  {
    AppMethodBeat.i(69556);
    if (this.CKU == null)
    {
      localdcr = new dcr();
      AppMethodBeat.o(69556);
      return localdcr;
    }
    dcr localdcr = this.CKU;
    AppMethodBeat.o(69556);
    return localdcr;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69555);
    ad.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.CKU = ((dcr)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */