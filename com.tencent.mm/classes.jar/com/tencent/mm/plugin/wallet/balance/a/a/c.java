package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends a<bcc>
{
  public c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(45229);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bcb();
    ((b.a)localObject).fsY = new bcc();
    ((b.a)localObject).funcId = 2507;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/manageplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bcb localbcb = (bcb)((b)localObject).fsV.fta;
    localbcb.type = paramInt1;
    localbcb.wpg = paramInt2;
    localbcb.wpf = paramString;
    this.rr = ((b)localObject);
    ab.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(45229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.c
 * JD-Core Version:    0.7.0.1
 */