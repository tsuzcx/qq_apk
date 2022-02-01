package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;

public final class n
  extends a<coq>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68450);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cop();
    ((b.a)localObject).hNN = new coq();
    ((b.a)localObject).funcId = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cop localcop = (cop)((b)localObject).hNK.hNQ;
    localcop.Hhu = paramString1;
    localcop.xZh = paramString2;
    localcop.HgC = paramInt1;
    localcop.uxm = paramInt2;
    localcop.Hfb = paramString3;
    localcop.Cyj = paramInt3;
    localcop.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */