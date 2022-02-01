package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends c<db>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new da();
    ((b.a)localObject).gUV = new db();
    ((b.a)localObject).funcId = 2780;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    da localda = (da)((b)localObject).gUS.gUX;
    localda.CxN = paramString1;
    localda.dca = paramString2;
    localda.uoo = paramString3;
    localda.zEv = paramString4;
    localda.dEb = paramLong;
    localda.foG = paramInt1;
    localda.zEA = paramInt2;
    this.rr = ((b)localObject);
    ad.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */