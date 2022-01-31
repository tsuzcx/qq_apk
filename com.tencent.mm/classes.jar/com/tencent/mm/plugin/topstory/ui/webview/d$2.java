package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import org.json.JSONObject;

final class d$2
  implements Runnable
{
  d$2(d paramd, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { this.pIt.toString() });
    this.pIs.pIp.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d.2
 * JD-Core Version:    0.7.0.1
 */