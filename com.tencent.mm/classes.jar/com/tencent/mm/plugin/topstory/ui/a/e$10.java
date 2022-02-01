package com.tencent.mm.plugin.topstory.ui.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class e$10
  implements Runnable
{
  public e$10(e parame, JSONObject paramJSONObject) {}
  
  @TargetApi(7)
  public final void run()
  {
    AppMethodBeat.i(236412);
    String str = this.plY.toString();
    a.a(this.GqA, "onVideoPlayInfo", str);
    AppMethodBeat.o(236412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e.10
 * JD-Core Version:    0.7.0.1
 */