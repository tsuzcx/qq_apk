package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  private f DRx;
  private b.b Eed;
  FtsWebVideoView Een;
  public aw luk;
  public int lul;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, f paramf)
  {
    AppMethodBeat.i(197999);
    this.Een = paramFtsWebVideoView;
    this.Eed = paramb;
    this.Eed.a(this);
    this.DRx = paramf;
    AppMethodBeat.o(197999);
  }
  
  private JSONObject I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = boS();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject eSe()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = boS();
    localJSONObject.put("currentTime", this.Een.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public final void DD() {}
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.Een.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  final JSONObject boS()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.Een.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  public final void boT()
  {
    AppMethodBeat.i(78174);
    if (this.luk != null) {
      this.luk.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void bz(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.DRx.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    ae.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    boT();
    AppMethodBeat.o(78167);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      ae.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      bz(a(5, I(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void eSa() {}
  
  public final void eSb() {}
  
  public final void eSd()
  {
    AppMethodBeat.i(78170);
    try
    {
      bz(a(6, eSe()));
      AppMethodBeat.o(78170);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
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
    ae.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.Een.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */