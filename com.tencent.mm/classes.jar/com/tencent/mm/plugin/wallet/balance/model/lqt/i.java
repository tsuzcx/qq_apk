package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class i
  extends z<dqw>
{
  public i(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dqv();
    ((c.a)localObject).otF = new dqw();
    ((c.a)localObject).funcId = 2614;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dqv localdqv = (dqv)c.b.b(((c)localObject).otB);
    localdqv.UZF = paramInt1;
    localdqv.hAk = paramString1;
    localdqv.MEp = paramString2;
    localdqv.UZA = paramString3;
    localdqv.ihV = paramLong;
    localdqv.day = paramInt2;
    localdqv.YGa = paramString4;
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */