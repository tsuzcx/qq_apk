package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends c<cqy>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cqx();
    ((d.a)localObject).iLO = new cqy();
    ((d.a)localObject).funcId = 2614;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    cqx localcqx = (cqx)((d)localObject).iLK.iLR;
    localcqx.Htr = paramInt1;
    localcqx.dDj = paramString1;
    localcqx.AOk = paramString2;
    localcqx.Htm = paramString3;
    localcqx.eht = paramLong;
    localcqx.grV = paramInt2;
    localcqx.KHB = paramString4;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */