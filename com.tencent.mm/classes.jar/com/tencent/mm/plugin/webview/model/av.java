package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class av
{
  public static av DUy;
  public f DNO = null;
  public boolean hasInit;
  
  static
  {
    AppMethodBeat.i(79045);
    DUy = new av();
    AppMethodBeat.o(79045);
  }
  
  public static av eQu()
  {
    return DUy;
  }
  
  public final void setNetWorkState(int paramInt)
  {
    AppMethodBeat.i(79044);
    if (this.DNO == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (this.DNO == null) {
        break label105;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("webview_video_proxy_net_state", paramInt);
      try
      {
        this.DNO.k(5005, localBundle);
        AppMethodBeat.o(79044);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[] { localException.getMessage() });
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