package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$6
  implements Runnable
{
  e$6(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2180);
    String str = this.tmm.toString();
    a.a(this.tmj, "notifyReddot", str);
    AppMethodBeat.o(2180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.6
 * JD-Core Version:    0.7.0.1
 */