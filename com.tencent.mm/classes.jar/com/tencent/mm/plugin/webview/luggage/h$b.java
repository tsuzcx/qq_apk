package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class h$b
  implements i<IPCBoolean, IPCBoolean>
{
  private static IPCBoolean dbo()
  {
    boolean bool = true;
    AppMethodBeat.i(6134);
    IPCBoolean localIPCBoolean = new IPCBoolean();
    try
    {
      i = bo.getInt(g.Nq().getValue("EnableWebviewScanQRCode"), 1);
      if (i == 1)
      {
        localIPCBoolean.value = bool;
        AppMethodBeat.o(6134);
        return localIPCBoolean;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameWebViewMenuListHelper", "isAllowScanQRCode parseInt failed");
        int i = 0;
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.b
 * JD-Core Version:    0.7.0.1
 */