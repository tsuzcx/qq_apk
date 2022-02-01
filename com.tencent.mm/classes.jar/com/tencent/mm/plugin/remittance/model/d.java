package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class d
  extends z<yx>
{
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(288802);
    yw localyw = new yw();
    localyw.nQU = paramString1;
    localyw.Zho = paramString2;
    localyw.Okt = paramString3;
    c.a locala = new c.a();
    locala.otE = localyw;
    locala.otF = new yx();
    locala.funcId = 4969;
    locala.uri = "/cgi-bin/mmpay-bin/recalltransfer";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiTransferRecall", "recall: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(288802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.d
 * JD-Core Version:    0.7.0.1
 */