package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<crw>
{
  public b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(174502);
    csc localcsc = new csc();
    b.a locala = new b.a();
    localcsc.DgJ = paramString1;
    localcsc.DlK = paramString2;
    localcsc.HDi = paramInt;
    localcsc.dwj = paramString3;
    locala.hQF = localcsc;
    locala.hQG = new crw();
    locala.funcId = 1923;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(174502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */