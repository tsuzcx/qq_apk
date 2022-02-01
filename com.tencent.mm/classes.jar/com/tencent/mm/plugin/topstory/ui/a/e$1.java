package com.tencent.mm.plugin.topstory.ui.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(126577);
    String str = this.plY.toString();
    a.a(this.GqA, "onSearchDataReady", str);
    c.c(e.a(this.GqA), "dataReady", System.currentTimeMillis());
    AppMethodBeat.o(126577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e.1
 * JD-Core Version:    0.7.0.1
 */