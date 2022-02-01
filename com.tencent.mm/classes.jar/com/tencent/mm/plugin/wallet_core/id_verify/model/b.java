package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<crc>
{
  public b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(174502);
    cri localcri = new cri();
    b.a locala = new b.a();
    localcri.CPf = paramString1;
    localcri.CUe = paramString2;
    localcri.HjI = paramInt;
    localcri.dve = paramString3;
    locala.hNM = localcri;
    locala.hNN = new crc();
    locala.funcId = 1923;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(174502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */