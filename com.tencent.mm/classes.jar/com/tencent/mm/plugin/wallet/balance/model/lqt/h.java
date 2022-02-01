package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class h
  extends z<dmf>
{
  public h(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dme();
    ((c.a)localObject).otF = new dmf();
    ((c.a)localObject).funcId = 2507;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dme localdme = (dme)c.b.b(((c)localObject).otB);
    localdme.type = paramInt1;
    localdme.UZF = paramInt2;
    localdme.YGa = paramString;
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */