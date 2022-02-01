package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<dn>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dm();
    ((d.a)localObject).iLO = new dn();
    ((d.a)localObject).funcId = 2780;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dm localdm = (dm)((d)localObject).iLK.iLR;
    localdm.KHB = paramString1;
    localdm.dDj = paramString2;
    localdm.AOk = paramString3;
    localdm.Htm = paramString4;
    localdm.eht = paramLong;
    localdm.grV = paramInt1;
    localdm.Htr = paramInt2;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */