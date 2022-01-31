package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$21
  extends c<qo>
{
  WebViewUI$21(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(7843);
    this.__eventId = qo.class.getName().hashCode();
    AppMethodBeat.o(7843);
  }
  
  private boolean deN()
  {
    AppMethodBeat.i(7844);
    if (this.vgz.igU == null)
    {
      ab.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
      AppMethodBeat.o(7844);
      return false;
    }
    if ((this.vgz.vfW == null) || (this.vgz.vfW.length() == 0))
    {
      ab.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
      AppMethodBeat.o(7844);
      return false;
    }
    try
    {
      long l = System.currentTimeMillis();
      ab.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { this.vgz.vfW, Long.valueOf(this.vgz.vfX), Long.valueOf(l) });
      Bundle localBundle = new Bundle();
      localBundle.putString("service_click_tid", new String(this.vgz.vfW));
      localBundle.putLong("service_click_stime", this.vgz.vfX);
      localBundle.putLong("service_click_etime", l);
      this.vgz.igU.v(2836, localBundle);
      this.vgz.vfW = null;
      AppMethodBeat.o(7844);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.21
 * JD-Core Version:    0.7.0.1
 */