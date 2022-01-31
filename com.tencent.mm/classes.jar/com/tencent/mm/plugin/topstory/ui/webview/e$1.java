package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.d;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2175);
    String str = this.tmi.toString();
    a.a(this.tmj, "onSearchDataReady", str);
    d.c(this.tmj.cKi, "dataReady", System.currentTimeMillis());
    AppMethodBeat.o(2175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.1
 * JD-Core Version:    0.7.0.1
 */