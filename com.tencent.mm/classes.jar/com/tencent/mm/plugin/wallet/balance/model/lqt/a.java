package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<dy>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dx();
    ((c.a)localObject).otF = new dy();
    ((c.a)localObject).funcId = 2780;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dx localdx = (dx)c.b.b(((c)localObject).otB);
    localdx.YGa = paramString1;
    localdx.hAk = paramString2;
    localdx.MEp = paramString3;
    localdx.UZA = paramString4;
    localdx.ihV = paramLong;
    localdx.day = paramInt1;
    localdx.UZF = paramInt2;
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */