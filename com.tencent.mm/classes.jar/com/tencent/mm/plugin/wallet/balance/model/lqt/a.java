package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<de>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dd();
    ((b.a)localObject).hNN = new de();
    ((b.a)localObject).funcId = 2780;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    dd localdd = (dd)((b)localObject).hNK.hNQ;
    localdd.Fvy = paramString1;
    localdd.dkR = paramString2;
    localdd.wCE = paramString3;
    localdd.CwR = paramString4;
    localdd.dOa = paramLong;
    localdd.fKG = paramInt1;
    localdd.CwW = paramInt2;
    c((b)localObject);
    ad.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */