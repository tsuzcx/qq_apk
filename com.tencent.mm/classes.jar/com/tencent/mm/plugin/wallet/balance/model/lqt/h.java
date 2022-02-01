package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends a<cbw>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cbv();
    ((b.a)localObject).hQG = new cbw();
    ((b.a)localObject).funcId = 2614;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cbv localcbv = (cbv)((b)localObject).hQD.hQJ;
    localcbv.COB = paramInt1;
    localcbv.dlT = paramString1;
    localcbv.wSp = paramString2;
    localcbv.COw = paramString3;
    localcbv.dPq = paramLong;
    localcbv.fMJ = paramInt2;
    localcbv.FNW = paramString4;
    c((b)localObject);
    ae.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */