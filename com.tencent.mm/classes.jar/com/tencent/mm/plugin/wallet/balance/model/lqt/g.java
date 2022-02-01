package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends c<btd>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new btc();
    ((b.a)localObject).hvu = new btd();
    ((b.a)localObject).funcId = 2507;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    btc localbtc = (btc)((b)localObject).hvr.hvw;
    localbtc.type = paramInt1;
    localbtc.AWN = paramInt2;
    localbtc.DQj = paramString;
    this.rr = ((b)localObject);
    ac.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */