package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;

public final class n
  extends c<cen>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68450);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cem();
    ((b.a)localObject).gUV = new cen();
    ((b.a)localObject).funcId = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cem localcem = (cem)((b)localObject).gUS.gUX;
    localcem.Eau = paramString1;
    localcem.vBv = paramString2;
    localcem.DZB = paramInt1;
    localcem.CYU = paramInt2;
    localcem.DYc = paramString3;
    localcem.zFN = paramInt3;
    localcem.zFY = ae.dYR();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */