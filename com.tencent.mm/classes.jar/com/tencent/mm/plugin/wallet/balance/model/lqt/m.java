package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends c<cdi>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68449);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cdh();
    ((b.a)localObject).gUV = new cdi();
    ((b.a)localObject).funcId = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cdh localcdh = (cdh)((b)localObject).gUS.gUX;
    localcdh.DZA = paramString1;
    localcdh.DZB = paramInt1;
    localcdh.CYU = paramInt2;
    localcdh.DZC = paramString2;
    localcdh.DYc = paramString3;
    localcdh.zFN = paramInt3;
    localcdh.zFY = ae.dYR();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */