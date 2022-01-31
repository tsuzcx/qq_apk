package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  public am gEO;
  public int gEP;
  private b.b rbg;
  private com.tencent.mm.plugin.webview.ui.tools.jsapi.d rbk;
  FtsWebVideoView rbr;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
  {
    this.rbr = paramFtsWebVideoView;
    this.rbg = paramb;
    this.rbg.a(this);
    this.rbk = paramd;
  }
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.rbr.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    return localJSONObject;
  }
  
  public final void ajc() {}
  
  public final JSONObject akU()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.rbr.getCookieData());
    return localJSONObject;
  }
  
  public final void akV()
  {
    if (this.gEO != null) {
      this.gEO.stopTimer();
    }
  }
  
  public final void ay(JSONObject paramJSONObject)
  {
    this.rbk.a("onVideoPlayerCallback", null, paramJSONObject);
  }
  
  public final void caM() {}
  
  public final void caN() {}
  
  public final void caP()
  {
    try
    {
      JSONObject localJSONObject = akU();
      localJSONObject.put("currentTime", this.rbr.getCurrPosSec());
      ay(a(6, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
    }
  }
  
  public final void clean()
  {
    y.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    akV();
  }
  
  public final void onDestroy()
  {
    y.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.rbr.setCallback(null);
  }
  
  public final void pY() {}
  
  public final void qa() {}
  
  public final boolean qc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */