package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class aw
{
  public static aw IZA;
  public f ISw = null;
  public boolean hasInit;
  
  static
  {
    AppMethodBeat.i(79045);
    IZA = new aw();
    AppMethodBeat.o(79045);
  }
  
  public static aw gcU()
  {
    return IZA;
  }
  
  public final void setNetWorkState(int paramInt)
  {
    AppMethodBeat.i(79044);
    if (this.ISw == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (this.ISw == null) {
        break label105;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_video_proxy_net_state", paramInt);
      try
      {
        this.ISw.j(5005, localBundle);
        AppMethodBeat.o(79044);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[] { localException.getMessage() });
      }
    }
    label105:
    AppMethodBeat.o(79044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aw
 * JD-Core Version:    0.7.0.1
 */