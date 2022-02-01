package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.ip;

public final class l
  extends c<dns>
{
  public l(int paramInt1, ip paramip, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dnr();
    ((d.a)localObject).lBV = new dns();
    ((d.a)localObject).funcId = 1324;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dnr localdnr = (dnr)d.b.b(((d)localObject).lBR);
    localdnr.TUS = paramInt1;
    if (paramip != null) {
      localdnr.TUT = 1;
    }
    for (localdnr.TUU = paramip;; localdnr.TUU = null)
    {
      localdnr.DgI = paramInt2;
      localdnr.TUV = paramInt3;
      localdnr.TUW = paramString;
      localdnr.OmF = ah.gFF();
      c((d)localObject);
      AppMethodBeat.o(68448);
      return;
      localdnr.TUT = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */