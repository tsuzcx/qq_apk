package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.wallet_core.model.z;

public final class k
  extends z<dwg>
{
  public k(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwf();
    ((c.a)localObject).otF = new dwg();
    ((c.a)localObject).funcId = 1830;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dwf localdwf = (dwf)c.b.b(((c)localObject).otB);
    localdwf.JaC = paramInt;
    localdwf.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */