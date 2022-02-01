package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;

public final class i
  extends a<cdu>
{
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cdt();
    ((b.a)localObject).hNN = new cdu();
    ((b.a)localObject).funcId = 2585;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cdt localcdt = (cdt)((b)localObject).hNK.hNQ;
    localcdt.uxm = paramInt1;
    localcdt.Cyj = paramInt2;
    localcdt.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */