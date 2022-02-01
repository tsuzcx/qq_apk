package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends a<cbc>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cbb();
    ((b.a)localObject).hNN = new cbc();
    ((b.a)localObject).funcId = 2614;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cbb localcbb = (cbb)((b)localObject).hNK.hNQ;
    localcbb.CwW = paramInt1;
    localcbb.dkR = paramString1;
    localcbb.wCE = paramString2;
    localcbb.CwR = paramString3;
    localcbb.dOa = paramLong;
    localcbb.fKG = paramInt2;
    localcbb.Fvy = paramString4;
    c((b)localObject);
    ad.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */