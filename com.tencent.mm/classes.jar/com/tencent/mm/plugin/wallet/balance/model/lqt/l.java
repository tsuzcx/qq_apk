package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.ja;

public final class l
  extends c<dec>
{
  public l(int paramInt1, ja paramja, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new deb();
    ((d.a)localObject).iLO = new dec();
    ((d.a)localObject).funcId = 1324;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    deb localdeb = (deb)((d)localObject).iLK.iLR;
    localdeb.MJd = paramInt1;
    if (paramja != null) {
      localdeb.MJe = 1;
    }
    for (localdeb.MJf = paramja;; localdeb.MJf = null)
    {
      localdeb.yba = paramInt2;
      localdeb.MJg = paramInt3;
      localdeb.MJh = paramString;
      localdeb.HuS = ag.fNb();
      c((d)localObject);
      AppMethodBeat.o(68448);
      return;
      localdeb.MJe = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */