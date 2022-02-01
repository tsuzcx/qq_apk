package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.ae;

public final class av
{
  public static av Emx;
  public f EfN = null;
  public boolean hasInit;
  
  static
  {
    AppMethodBeat.i(79045);
    Emx = new av();
    AppMethodBeat.o(79045);
  }
  
  public static av eUg()
  {
    return Emx;
  }
  
  public final void setNetWorkState(int paramInt)
  {
    AppMethodBeat.i(79044);
    if (this.EfN == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (this.EfN == null) {
        break label105;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_video_proxy_net_state", paramInt);
      try
      {
        this.EfN.k(5005, localBundle);
        AppMethodBeat.o(79044);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[] { localException.getMessage() });
      }
    }
    label105:
    AppMethodBeat.o(79044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av
 * JD-Core Version:    0.7.0.1
 */