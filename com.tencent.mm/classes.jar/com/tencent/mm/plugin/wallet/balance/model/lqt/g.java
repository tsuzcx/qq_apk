package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends c<bon>
{
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(68404);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bom();
    ((b.a)localObject).gUV = new bon();
    ((b.a)localObject).funcId = 2507;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    bom localbom = (bom)((b)localObject).gUS.gUX;
    localbom.type = paramInt1;
    localbom.zEA = paramInt2;
    localbom.CxN = paramString;
    this.rr = ((b)localObject);
    ad.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */