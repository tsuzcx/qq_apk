package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<de>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dd();
    ((b.a)localObject).hQG = new de();
    ((b.a)localObject).funcId = 2780;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    dd localdd = (dd)((b)localObject).hQD.hQJ;
    localdd.FNW = paramString1;
    localdd.dlT = paramString2;
    localdd.wSp = paramString3;
    localdd.COw = paramString4;
    localdd.dPq = paramLong;
    localdd.fMJ = paramInt1;
    localdd.COB = paramInt2;
    c((b)localObject);
    ae.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */