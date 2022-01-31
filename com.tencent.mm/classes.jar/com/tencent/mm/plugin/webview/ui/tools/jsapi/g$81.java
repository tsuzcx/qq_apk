package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.sdk.platformtools.ab;

final class g$81
  implements w.a
{
  g$81(g paramg, long paramLong) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(9145);
    ab.i("MicroMsg.MsgHandler", "doUxSearchOpLog rsp errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (cvs)paramb.fsW.fta;
    paramb = new Bundle();
    paramb.putLong("reqId", this.vjL);
    paramb.putInt("ret", paramInt2);
    if (paramString.yec != null)
    {
      paramString.yec.dqj();
      paramb.putString("json", paramString.yec.dqj());
    }
    try
    {
      if (g.l(this.vqm) != null) {
        g.l(this.vqm).e(147, paramb);
      }
      AppMethodBeat.o(9145);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MsgHandler", paramString, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.81
 * JD-Core Version:    0.7.0.1
 */