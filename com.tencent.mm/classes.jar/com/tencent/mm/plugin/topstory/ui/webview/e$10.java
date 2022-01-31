package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$10
  implements Runnable
{
  public e$10(e parame, String paramString) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2184);
    a.a(this.tmj, "onWebRecommendPostComments", this.tmo);
    AppMethodBeat.o(2184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.10
 * JD-Core Version:    0.7.0.1
 */