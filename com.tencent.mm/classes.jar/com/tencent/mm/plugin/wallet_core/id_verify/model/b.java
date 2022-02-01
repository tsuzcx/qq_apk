package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<cmc>
{
  public b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(174502);
    cmh localcmh = new cmh();
    b.a locala = new b.a();
    localcmh.BoQ = paramString1;
    localcmh.BtP = paramString2;
    localcmh.FzA = paramInt;
    localcmh.djr = paramString3;
    locala.hvt = localcmh;
    locala.hvu = new cmc();
    locala.funcId = 1923;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(174502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */