package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.ai.a<ct>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45227);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cs();
    ((b.a)localObject).fsY = new ct();
    ((b.a)localObject).funcId = 2780;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/addplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    cs localcs = (cs)((b)localObject).fsV.fta;
    localcs.wpf = paramString1;
    localcs.poq = paramString2;
    localcs.ppo = paramString3;
    localcs.wpe = paramString4;
    localcs.cNd = paramLong;
    localcs.eel = paramInt1;
    localcs.wpg = paramInt2;
    this.rr = ((b)localObject);
    ab.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", new Object[] { paramString3, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(45227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.a
 * JD-Core Version:    0.7.0.1
 */