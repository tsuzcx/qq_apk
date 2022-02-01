package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.evm;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.an.c<evn>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    d.a locala = new d.a();
    evm localevm = new evm();
    localevm.Sld = paramString;
    localevm.timestamp = System.currentTimeMillis();
    locala.lBU = localevm;
    locala.lBV = new evn();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    Log.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */