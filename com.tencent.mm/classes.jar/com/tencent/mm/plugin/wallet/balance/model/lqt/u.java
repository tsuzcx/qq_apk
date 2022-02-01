package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.wallet_core.model.z;

public final class u
  extends z<eio>
{
  public u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(316097);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ein();
    ((c.a)localObject).otF = new eio();
    ((c.a)localObject).funcId = 4981;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefrombankguidestat";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    ein localein = (ein)c.b.b(((c)localObject).otB);
    localein.abnu = paramInt1;
    localein.abnv = paramInt2;
    localein.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(316097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */