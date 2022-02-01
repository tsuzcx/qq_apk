package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  private b.b AQL;
  private f AQP;
  FtsWebVideoView AQW;
  public av krS;
  public int krT;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, f paramf)
  {
    AppMethodBeat.i(187858);
    this.AQW = paramFtsWebVideoView;
    this.AQL = paramb;
    this.AQL.a(this);
    this.AQP = paramf;
    AppMethodBeat.o(187858);
  }
  
  private JSONObject A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = bdC();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject ekj()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = bdC();
    localJSONObject.put("currentTime", this.AQW.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public final void Cx() {}
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.AQW.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  final JSONObject bdC()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.AQW.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  public final void bdD()
  {
    AppMethodBeat.i(78174);
    if (this.krS != null) {
      this.krS.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.AQP.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    ad.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    bdD();
    AppMethodBeat.o(78167);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      ad.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      bp(a(5, A(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void ekf() {}
  
  public final void ekg() {}
  
  public final void eki()
  {
    AppMethodBeat.i(78170);
    try
    {
      bp(a(6, ekj()));
      AppMethodBeat.o(78170);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
      AppMethodBeat.o(78170);
    }
  }
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBackground() {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78175);
    ad.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.AQW.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */