package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  public ap idS;
  public int idT;
  private b.b uQO;
  private com.tencent.mm.plugin.webview.ui.tools.jsapi.d uQS;
  FtsWebVideoView uQZ;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
  {
    AppMethodBeat.i(5952);
    this.uQZ = paramFtsWebVideoView;
    this.uQO = paramb;
    this.uQO.a(this);
    this.uQS = paramd;
    AppMethodBeat.o(5952);
  }
  
  private JSONObject daQ()
  {
    AppMethodBeat.i(5959);
    JSONObject localJSONObject = aFD();
    localJSONObject.put("currentTime", this.uQZ.getCurrPosSec());
    AppMethodBeat.o(5959);
    return localJSONObject;
  }
  
  private JSONObject w(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(5957);
    JSONObject localJSONObject = aFD();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(5957);
    return localJSONObject;
  }
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(5962);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.uQZ.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(5962);
    return localJSONObject;
  }
  
  public final void aDk() {}
  
  final JSONObject aFD()
  {
    AppMethodBeat.i(5958);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.uQZ.getCookieData());
    AppMethodBeat.o(5958);
    return localJSONObject;
  }
  
  public final void aFE()
  {
    AppMethodBeat.i(5960);
    if (this.idS != null) {
      this.idS.stopTimer();
    }
    AppMethodBeat.o(5960);
  }
  
  public final void aR(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(5954);
    this.uQS.a("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(5954);
  }
  
  public final void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(5955);
    try
    {
      ab.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      aR(a(5, w(paramBoolean, paramString)));
      AppMethodBeat.o(5955);
      return;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(5955);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(5953);
    ab.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    aFE();
    AppMethodBeat.o(5953);
  }
  
  public final void daM() {}
  
  public final void daN() {}
  
  public final void daP()
  {
    AppMethodBeat.i(5956);
    try
    {
      aR(a(6, daQ()));
      AppMethodBeat.o(5956);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
      AppMethodBeat.o(5956);
    }
  }
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBackground() {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(5961);
    ab.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.uQZ.setCallback(null);
    AppMethodBeat.o(5961);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */