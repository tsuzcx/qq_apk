package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    String str = this.pIr.toString();
    y.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onSearchDataReady %d", new Object[] { Integer.valueOf(str.length()) });
    str = String.format("javascript:onSearchDataReady(%s)", new Object[] { str });
    com.tencent.mm.plugin.topstory.ui.d.c(this.pIs.cbF, "dataReady", System.currentTimeMillis());
    this.pIs.pIp.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d.1
 * JD-Core Version:    0.7.0.1
 */