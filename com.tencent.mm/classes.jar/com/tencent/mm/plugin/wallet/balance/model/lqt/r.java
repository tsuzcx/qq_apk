package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.wallet_core.model.z;

public final class r
  extends z<dwe>
{
  public r(String paramString)
  {
    AppMethodBeat.i(316109);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwd();
    ((c.a)localObject).otF = new dwe();
    ((c.a)localObject).funcId = 4574;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickreddot";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    dwd localdwd = (dwd)c.b.b(((c)localObject).otB);
    localdwd.ZQJ = paramString;
    localdwd.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(316109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.r
 * JD-Core Version:    0.7.0.1
 */