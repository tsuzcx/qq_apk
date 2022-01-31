package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class aq
{
  public static aq uWt;
  public boolean hasInit;
  public e uWu = null;
  
  static
  {
    AppMethodBeat.i(6745);
    uWt = new aq();
    AppMethodBeat.o(6745);
  }
  
  public static aq dcc()
  {
    return uWt;
  }
  
  public final void setNetWorkState(int paramInt)
  {
    AppMethodBeat.i(6744);
    if (this.uWu == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (this.uWu == null) {
        break label107;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_video_proxy_net_state", paramInt);
      try
      {
        this.uWu.i(5005, localBundle);
        AppMethodBeat.o(6744);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[] { localException.getMessage() });
      }
    }
    label107:
    AppMethodBeat.o(6744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aq
 * JD-Core Version:    0.7.0.1
 */