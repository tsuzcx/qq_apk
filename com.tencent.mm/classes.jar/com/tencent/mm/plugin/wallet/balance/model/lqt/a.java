package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<dl>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68398);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dk();
    ((d.a)localObject).lBV = new dl();
    ((d.a)localObject).funcId = 2780;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dk localdk = (dk)d.b.b(((d)localObject).lBR);
    localdk.RIU = paramString1;
    localdk.fvP = paramString2;
    localdk.GHy = paramString3;
    localdk.OkX = paramString4;
    localdk.gbJ = paramLong;
    localdk.day = paramInt1;
    localdk.Olc = paramInt2;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.a
 * JD-Core Version:    0.7.0.1
 */