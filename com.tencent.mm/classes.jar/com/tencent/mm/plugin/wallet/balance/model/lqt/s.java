package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.dga;

public final class s
  extends c<dga>
{
  public s(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213848);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dfz();
    ((d.a)localObject).iLO = new dga();
    ((d.a)localObject).funcId = 4981;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefrombankguidestat";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dfz localdfz = (dfz)((d)localObject).iLK.iLR;
    localdfz.MKK = paramInt1;
    localdfz.MKL = paramInt2;
    localdfz.HuS = ag.fNb();
    c((d)localObject);
    AppMethodBeat.o(213848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */