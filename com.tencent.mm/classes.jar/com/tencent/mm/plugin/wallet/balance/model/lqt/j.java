package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.ceq;

public final class j
  extends a<ceq>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cep();
    ((b.a)localObject).hQG = new ceq();
    ((b.a)localObject).funcId = 1830;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cep localcep = (cep)((b)localObject).hQD.hQJ;
    localcep.uIM = paramInt;
    localcep.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */