package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.y;

final class g$81$1
  implements h.a
{
  g$81$1(g.81 param81) {}
  
  public final void ug()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("playResult", "onVoicePlayEnd:ok");
      localBundle.putString("localId", this.rAl.oOY);
      g.D(this.rAl.rzi).b(2002, localBundle);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.81.1
 * JD-Core Version:    0.7.0.1
 */