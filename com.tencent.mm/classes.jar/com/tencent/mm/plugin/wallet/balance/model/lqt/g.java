package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends c<cmd>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cmc();
    ((d.a)localObject).iLO = new cmd();
    ((d.a)localObject).funcId = 2507;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    cmc localcmc = (cmc)((d)localObject).iLK.iLR;
    localcmc.type = paramInt1;
    localcmc.Htr = paramInt2;
    localcmc.KHB = paramString;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */