package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$7
  implements Runnable
{
  public e$7(e parame, String paramString) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(2181);
    a.a(this.tmj, "onWebRecommendCommCgiResult", this.tmn);
    AppMethodBeat.o(2181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e.7
 * JD-Core Version:    0.7.0.1
 */