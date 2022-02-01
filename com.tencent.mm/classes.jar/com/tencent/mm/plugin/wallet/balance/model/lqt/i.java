package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;

public final class i
  extends a<ceo>
{
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cen();
    ((b.a)localObject).hQG = new ceo();
    ((b.a)localObject).funcId = 2585;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cen localcen = (cen)((b)localObject).hQD.hQJ;
    localcen.uIM = paramInt1;
    localcen.CPO = paramInt2;
    localcen.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */