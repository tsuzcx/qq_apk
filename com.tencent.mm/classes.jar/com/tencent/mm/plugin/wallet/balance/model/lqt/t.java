package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.dpu;

public final class t
  extends c<dpu>
{
  public t(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264064);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dpt();
    ((d.a)localObject).lBV = new dpu();
    ((d.a)localObject).funcId = 4981;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefrombankguidestat";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dpt localdpt = (dpt)d.b.b(((d)localObject).lBR);
    localdpt.TWF = paramInt1;
    localdpt.TWG = paramInt2;
    localdpt.OmF = ah.gFF();
    c((d)localObject);
    AppMethodBeat.o(264064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t
 * JD-Core Version:    0.7.0.1
 */