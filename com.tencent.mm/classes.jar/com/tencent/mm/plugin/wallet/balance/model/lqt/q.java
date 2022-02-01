package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;

public final class q
  extends c<def>
{
  public q(String paramString)
  {
    AppMethodBeat.i(277862);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dee();
    ((d.a)localObject).lBV = new def();
    ((d.a)localObject).funcId = 4574;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickreddot";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dee localdee = (dee)d.b.b(((d)localObject).lBR);
    localdee.TLO = paramString;
    localdee.OmF = ah.gFF();
    c((d)localObject);
    AppMethodBeat.o(277862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.q
 * JD-Core Version:    0.7.0.1
 */