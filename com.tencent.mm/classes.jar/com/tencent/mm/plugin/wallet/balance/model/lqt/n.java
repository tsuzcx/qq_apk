package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.z;

public final class n
  extends z<eiq>
  implements j
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(316156);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eip();
    ((c.a)localObject).otF = new eiq();
    ((c.a)localObject).funcId = 1276;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    eip localeip = (eip)c.b.b(((c)localObject).otB);
    localeip.aaMN = paramString1;
    localeip.abnw = paramInt1;
    localeip.JaC = paramInt2;
    localeip.aaMM = paramString2;
    localeip.ablH = paramString3;
    localeip.VaY = paramInt3;
    localeip.hAk = paramString4;
    localeip.VEr = paramString5;
    localeip.abnx = 1;
    localeip.abny = 1;
    localeip.Vbl = ai.ieD();
    localeip.abny = 1;
    localeip.abnx = 1;
    c((c)localObject);
    AppMethodBeat.o(316156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */