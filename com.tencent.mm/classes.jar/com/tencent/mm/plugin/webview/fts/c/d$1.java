package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$1
  implements ap.a
{
  public d$1(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5951);
    try
    {
      int i = this.uRa.uQZ.getCurrPosMs();
      int j = Math.abs(i - this.uRa.idT);
      if (j < 250)
      {
        AppMethodBeat.o(5951);
        return true;
      }
      this.uRa.idT = i;
      d locald1 = this.uRa;
      d locald2 = this.uRa;
      d locald3 = this.uRa;
      JSONObject localJSONObject = locald3.aFD();
      localJSONObject.put("currentTime", locald3.uQZ.getCurrPosSec());
      locald1.aR(locald2.a(4, localJSONObject));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(5951);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d.1
 * JD-Core Version:    0.7.0.1
 */