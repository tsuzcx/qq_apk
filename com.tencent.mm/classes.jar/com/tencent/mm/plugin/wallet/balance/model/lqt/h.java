package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends c<brv>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bru();
    ((b.a)localObject).gUV = new brv();
    ((b.a)localObject).funcId = 2614;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    bru localbru = (bru)((b)localObject).gUS.gUX;
    localbru.zEA = paramInt1;
    localbru.dca = paramString1;
    localbru.uoo = paramString2;
    localbru.zEv = paramString3;
    localbru.dEb = paramLong;
    localbru.foG = paramInt2;
    localbru.CxN = paramString4;
    this.rr = ((b)localObject);
    ad.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */