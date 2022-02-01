package com.tencent.mm.plugin.topstory.ui.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import org.json.JSONObject;

final class e$9
  implements Runnable
{
  e$9(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(236411);
    String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { this.GqD.toString() });
    this.GqA.Gqy.evaluateJavascript(str, null);
    AppMethodBeat.o(236411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e.9
 * JD-Core Version:    0.7.0.1
 */