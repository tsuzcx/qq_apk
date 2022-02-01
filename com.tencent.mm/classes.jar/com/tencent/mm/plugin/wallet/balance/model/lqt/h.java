package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends c<czp>
{
  public h(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(68405);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new czo();
    ((d.a)localObject).lBV = new czp();
    ((d.a)localObject).funcId = 2614;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    czo localczo = (czo)d.b.b(((d)localObject).lBR);
    localczo.Olc = paramInt1;
    localczo.fvP = paramString1;
    localczo.GHy = paramString2;
    localczo.OkX = paramString3;
    localczo.gbJ = paramLong;
    localczo.day = paramInt2;
    localczo.RIU = paramString4;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.h
 * JD-Core Version:    0.7.0.1
 */