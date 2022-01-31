package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a<bfc>
{
  public d(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(45230);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bfb();
    ((b.a)localObject).fsY = new bfc();
    ((b.a)localObject).funcId = 2614;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bfb localbfb = (bfb)((b)localObject).fsV.fta;
    localbfb.wpg = paramInt1;
    localbfb.poq = paramString1;
    localbfb.ppo = paramString2;
    localbfb.wpe = paramString3;
    localbfb.cNd = paramLong;
    localbfb.eel = paramInt2;
    localbfb.wpf = paramString4;
    this.rr = ((b)localObject);
    ab.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", new Object[] { Integer.valueOf(paramInt1), paramString2, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(45230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.d
 * JD-Core Version:    0.7.0.1
 */