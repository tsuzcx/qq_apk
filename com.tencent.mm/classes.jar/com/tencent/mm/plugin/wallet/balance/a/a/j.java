package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.wallet_core.c.i;

public final class j
  extends a<bot>
  implements i
{
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(45236);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bos();
    ((b.a)localObject).fsY = new bot();
    ((b.a)localObject).funcId = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bos localbos = (bos)((b)localObject).fsV.fta;
    localbos.xCP = paramString1;
    localbos.xCQ = paramInt1;
    localbos.wMx = paramInt2;
    localbos.xCR = paramString2;
    localbos.xBE = paramString3;
    localbos.tNy = ab.cQT();
    this.rr = ((b)localObject);
    AppMethodBeat.o(45236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.j
 * JD-Core Version:    0.7.0.1
 */