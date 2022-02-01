package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends a<bxr>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bxq();
    ((b.a)localObject).hNN = new bxr();
    ((b.a)localObject).funcId = 2507;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    bxq localbxq = (bxq)((b)localObject).hNK.hNQ;
    localbxq.type = paramInt1;
    localbxq.CwW = paramInt2;
    localbxq.Fvy = paramString;
    c((b)localObject);
    ad.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */