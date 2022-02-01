package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends c<bwm>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bwl();
    ((b.a)localObject).hvu = new bwm();
    ((b.a)localObject).funcId = 2614;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    bwl localbwl = (bwl)((b)localObject).hvr.hvw;
    localbwl.AWN = paramInt1;
    localbwl.cZz = paramString1;
    localbwl.vxk = paramString2;
    localbwl.AWI = paramString3;
    localbwl.dBN = paramLong;
    localbwl.fsg = paramInt2;
    localbwl.DQj = paramString4;
    this.rr = ((b)localObject);
    ac.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */