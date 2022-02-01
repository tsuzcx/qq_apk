package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends c<cil>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68449);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cik();
    ((b.a)localObject).hvu = new cil();
    ((b.a)localObject).funcId = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cik localcik = (cik)((b)localObject).hvr.hvw;
    localcik.Fwv = paramString1;
    localcik.Fww = paramInt1;
    localcik.ErG = paramInt2;
    localcik.Fwx = paramString2;
    localcik.FuW = paramString3;
    localcik.AYa = paramInt3;
    localcik.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */