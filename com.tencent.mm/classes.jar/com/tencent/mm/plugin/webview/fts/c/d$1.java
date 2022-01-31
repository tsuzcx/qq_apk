package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$1
  implements am.a
{
  public d$1(d paramd) {}
  
  public final boolean tC()
  {
    try
    {
      int i = this.rbs.rbr.getCurrPosMs();
      if (Math.abs(i - this.rbs.gEP) < 250) {
        return true;
      }
      this.rbs.gEP = i;
      d locald1 = this.rbs;
      d locald2 = this.rbs;
      d locald3 = this.rbs;
      JSONObject localJSONObject = locald3.akU();
      localJSONObject.put("currentTime", locald3.rbr.getCurrPosSec());
      locald1.ay(locald2.a(4, localJSONObject));
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[] { localJSONException });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d.1
 * JD-Core Version:    0.7.0.1
 */