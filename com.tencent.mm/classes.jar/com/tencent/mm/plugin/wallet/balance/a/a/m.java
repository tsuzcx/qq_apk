package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.wallet_core.c.i;

public final class m
  extends a<bsv>
  implements i
{
  public m(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(45239);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bsu();
    ((b.a)localObject).fsY = new bsv();
    ((b.a)localObject).funcId = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bsu localbsu = (bsu)((b)localObject).fsV.fta;
    localbsu.xBA = paramInt1;
    localbsu.wMw = paramString1;
    localbsu.xBF = paramString2;
    localbsu.wMx = paramInt2;
    localbsu.xBE = paramString3;
    localbsu.tNy = ab.cQT();
    this.rr = ((b)localObject);
    AppMethodBeat.o(45239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.m
 * JD-Core Version:    0.7.0.1
 */