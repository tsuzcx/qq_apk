package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$5
  implements Runnable
{
  e$5(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2179);
    String str = this.tmm.toString();
    a.a(this.tmj, "notifyNumReddotChange", str);
    AppMethodBeat.o(2179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.5
 * JD-Core Version:    0.7.0.1
 */