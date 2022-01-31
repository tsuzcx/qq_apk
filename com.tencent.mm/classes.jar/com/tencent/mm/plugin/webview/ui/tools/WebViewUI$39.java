package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewUI$39
  implements MessageQueue.IdleHandler
{
  WebViewUI$39(WebViewUI paramWebViewUI, String paramString, long paramLong, int paramInt) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(153247);
    Looper.myQueue().removeIdleHandler(this);
    this.vgz.n(this.vgD, this.fET, this.vgE);
    AppMethodBeat.o(153247);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.39
 * JD-Core Version:    0.7.0.1
 */