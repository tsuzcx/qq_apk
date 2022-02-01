package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cpk;

public final class n
  extends a<cpk>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68450);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cpj();
    ((b.a)localObject).hQG = new cpk();
    ((b.a)localObject).funcId = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cpj localcpj = (cpj)((b)localObject).hQD.hQJ;
    localcpj.HAU = paramString1;
    localcpj.yoZ = paramString2;
    localcpj.HAc = paramInt1;
    localcpj.uIM = paramInt2;
    localcpj.HyB = paramString3;
    localcpj.CPO = paramInt3;
    localcpj.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */