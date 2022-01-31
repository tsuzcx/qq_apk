package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class i$b
  implements i<IPCBoolean, IPCBoolean>
{
  private static IPCBoolean cbk()
  {
    boolean bool = true;
    IPCBoolean localIPCBoolean = new IPCBoolean();
    try
    {
      i = bk.getInt(g.AA().getValue("EnableWebviewScanQRCode"), 1);
      if (i == 1)
      {
        localIPCBoolean.value = bool;
        return localIPCBoolean;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.GameWebViewMenuListHelper", "isAllowScanQRCode parseInt failed");
        int i = 0;
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.b
 * JD-Core Version:    0.7.0.1
 */