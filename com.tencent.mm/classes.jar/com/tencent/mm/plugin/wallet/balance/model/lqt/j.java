package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.wallet_core.model.z;

public final class j
  extends z<dwc>
{
  public j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwb();
    ((c.a)localObject).otF = new dwc();
    ((c.a)localObject).funcId = 2585;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dwb localdwb = (dwb)c.b.b(((c)localObject).otB);
    localdwb.JaC = paramInt1;
    localdwb.VaY = paramInt2;
    localdwb.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */