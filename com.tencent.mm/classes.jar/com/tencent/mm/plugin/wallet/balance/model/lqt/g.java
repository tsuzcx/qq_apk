package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends c<cuz>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cuy();
    ((d.a)localObject).lBV = new cuz();
    ((d.a)localObject).funcId = 2507;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    cuy localcuy = (cuy)d.b.b(((d)localObject).lBR);
    localcuy.type = paramInt1;
    localcuy.Olc = paramInt2;
    localcuy.RIU = paramString;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */