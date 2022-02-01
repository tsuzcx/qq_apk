package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<dd>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dc();
    ((b.a)localObject).hvu = new dd();
    ((b.a)localObject).funcId = 2780;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    dc localdc = (dc)((b)localObject).hvr.hvw;
    localdc.DQj = paramString1;
    localdc.cZz = paramString2;
    localdc.vxk = paramString3;
    localdc.AWI = paramString4;
    localdc.dBN = paramLong;
    localdc.fsg = paramInt1;
    localdc.AWN = paramInt2;
    this.rr = ((b)localObject);
    ac.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */