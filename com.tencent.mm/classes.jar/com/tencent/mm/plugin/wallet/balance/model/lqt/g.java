package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends a<byl>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new byk();
    ((b.a)localObject).hQG = new byl();
    ((b.a)localObject).funcId = 2507;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    byk localbyk = (byk)((b)localObject).hQD.hQJ;
    localbyk.type = paramInt1;
    localbyk.COB = paramInt2;
    localbyk.FNW = paramString;
    c((b)localObject);
    ae.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */