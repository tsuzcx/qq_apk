package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private ddl DcA;
  public ddk Dcz;
  private f callback;
  private final b rr;
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(69553);
    b.a locala = new b.a();
    ddk localddk = new ddk();
    localddk.FIl = System.currentTimeMillis();
    if (paramBoolean) {}
    for (localddk.HLd = 1;; localddk.HLd = 0)
    {
      this.Dcz = localddk;
      locala.hQF = localddk;
      locala.hQG = new ddl();
      locala.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
      locala.funcId = 2554;
      this.rr = locala.aDS();
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
  
  public final ddl eHF()
  {
    AppMethodBeat.i(69556);
    if (this.DcA == null)
    {
      localddl = new ddl();
      AppMethodBeat.o(69556);
      return localddl;
    }
    ddl localddl = this.DcA;
    AppMethodBeat.o(69556);
    return localddl;
  }
  
  public final int getType()
  {
    return 2554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69555);
    ae.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.DcA = ((ddl)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.k
 * JD-Core Version:    0.7.0.1
 */