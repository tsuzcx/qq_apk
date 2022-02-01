package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.wallet_core.model.z;

public final class o
  extends z<ejz>
{
  public o(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(316113);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ejy();
    ((c.a)localObject).otF = new ejz();
    ((c.a)localObject).funcId = 1283;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    ejy localejy = (ejy)c.b.b(((c)localObject).otB);
    localejy.abos = paramString1;
    localejy.Oks = paramString2;
    localejy.abnw = paramInt1;
    localejy.JaC = paramInt2;
    localejy.ablH = paramString3;
    localejy.VaY = paramInt3;
    localejy.Vbl = ai.ieD();
    localejy.abot = paramInt4;
    c((c)localObject);
    AppMethodBeat.o(316113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */