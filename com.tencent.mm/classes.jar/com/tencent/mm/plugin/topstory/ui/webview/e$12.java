package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$12
  implements Runnable
{
  public e$12(e parame, String paramString) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2186);
    a.a(this.tmj, "onWebRecommendInfoUpdate", this.tmk);
    AppMethodBeat.o(2186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.12
 * JD-Core Version:    0.7.0.1
 */