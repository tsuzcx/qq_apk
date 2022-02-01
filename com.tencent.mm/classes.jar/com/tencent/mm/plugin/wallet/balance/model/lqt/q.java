package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.eoi;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.z;

public final class q
  extends z<eoj>
  implements j
{
  public q(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eoi();
    ((c.a)localObject).otF = new eoj();
    ((c.a)localObject).funcId = 1338;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    eoi localeoi = (eoi)c.b.b(((c)localObject).otB);
    localeoi.ablD = paramInt1;
    localeoi.ZlW = paramString1;
    localeoi.ablI = paramString2;
    localeoi.JaC = paramInt2;
    localeoi.ablH = paramString3;
    localeoi.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */