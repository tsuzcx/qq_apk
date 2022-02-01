package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  private b.b CiY;
  private f Cjc;
  FtsWebVideoView Cjj;
  public au kTk;
  public int kTl;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, f paramf)
  {
    AppMethodBeat.i(188284);
    this.Cjj = paramFtsWebVideoView;
    this.CiY = paramb;
    this.CiY.a(this);
    this.Cjc = paramf;
    AppMethodBeat.o(188284);
  }
  
  private JSONObject B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = bkx();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject ezE()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = bkx();
    localJSONObject.put("currentTime", this.Cjj.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public final void Cb() {}
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.Cjj.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  final JSONObject bkx()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.Cjj.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  public final void bky()
  {
    AppMethodBeat.i(78174);
    if (this.kTk != null) {
      this.kTk.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void bq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.Cjc.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    ac.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    bky();
    AppMethodBeat.o(78167);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      ac.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      bq(a(5, B(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void ezA() {}
  
  public final void ezB() {}
  
  public final void ezD()
  {
    AppMethodBeat.i(78170);
    try
    {
      bq(a(6, ezE()));
      AppMethodBeat.o(78170);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
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
    ac.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.Cjj.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */