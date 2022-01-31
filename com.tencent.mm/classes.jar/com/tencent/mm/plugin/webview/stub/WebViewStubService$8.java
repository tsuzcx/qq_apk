package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class WebViewStubService$8
  implements g
{
  WebViewStubService$8(WebViewStubService paramWebViewStubService) {}
  
  public final void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(155695);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("game_haowan_publish_post_id", paramString);
      localBundle.putInt("game_haowan_publish_retcode", paramInt);
      paramString = WebViewStubService.f(this.uZy).iterator();
      while (paramString.hasNext()) {
        ((WebViewStubCallbackWrapper)paramString.next()).vdZ.e(254, localBundle);
      }
      AppMethodBeat.o(155695);
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(155695);
      return;
    }
  }
  
  public final void h(String paramString, float paramFloat)
  {
    AppMethodBeat.i(155696);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("game_haowan_publish_post_id", paramString);
      localBundle.putFloat("game_haowan_publish_progress", paramFloat);
      paramString = WebViewStubService.f(this.uZy).iterator();
      while (paramString.hasNext()) {
        ((WebViewStubCallbackWrapper)paramString.next()).vdZ.e(255, localBundle);
      }
      AppMethodBeat.o(155696);
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(155696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.8
 * JD-Core Version:    0.7.0.1
 */