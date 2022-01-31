package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.y;

public final class al
{
  public static al rgg = new al();
  public boolean hasInit;
  public e rgh = null;
  
  public static al cbY()
  {
    return rgg;
  }
  
  public final void setNetWorkState(int paramInt)
  {
    if (this.rgh == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WebViewVideoProxy", "set networkd state = %d, callbacker == null ? %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      Bundle localBundle;
      if (this.rgh != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("webview_video_proxy_net_state", paramInt);
      }
      try
      {
        this.rgh.f(5005, localBundle);
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.al
 * JD-Core Version:    0.7.0.1
 */