package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;

public final class j
  extends a<cdw>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cdv();
    ((b.a)localObject).hNN = new cdw();
    ((b.a)localObject).funcId = 1830;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cdv localcdv = (cdv)((b)localObject).hNK.hNQ;
    localcdv.uxm = paramInt;
    localcdv.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */