package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abj;

public final class f
  extends c<abj>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new abi();
    ((d.a)localObject).lBV = new abj();
    ((d.a)localObject).funcId = 1386;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    abi localabi = (abi)d.b.b(((d)localObject).lBR);
    localabi.SnA = paramString;
    localabi.DgI = paramInt;
    localabi.OmF = ah.gFF();
    c((d)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */