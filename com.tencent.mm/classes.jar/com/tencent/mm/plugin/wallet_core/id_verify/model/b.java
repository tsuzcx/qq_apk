package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<djw>
{
  public b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(174502);
    dkc localdkc = new dkc();
    d.a locala = new d.a();
    localdkc.HQc = paramString1;
    localdkc.HVd = paramString2;
    localdkc.MNZ = paramInt;
    localdkc.dNQ = paramString3;
    locala.iLN = localdkc;
    locala.iLO = new djw();
    locala.funcId = 1923;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(174502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */