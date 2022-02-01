package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;

public final class j
  extends c<deh>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new deg();
    ((d.a)localObject).lBV = new deh();
    ((d.a)localObject).funcId = 1830;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    deg localdeg = (deg)d.b.b(((d)localObject).lBR);
    localdeg.DgI = paramInt;
    localdeg.OmF = ah.gFF();
    c((d)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */