package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$4
  implements Runnable
{
  e$4(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2178);
    String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { this.tml.toString() });
    this.tmj.tmg.evaluateJavascript(str, null);
    AppMethodBeat.o(2178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.4
 * JD-Core Version:    0.7.0.1
 */