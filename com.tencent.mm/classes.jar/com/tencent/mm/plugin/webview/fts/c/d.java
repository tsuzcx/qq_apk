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
  private b.b DMf;
  FtsWebVideoView DMp;
  private f DzP;
  public av lpN;
  public int lpO;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, f paramf)
  {
    AppMethodBeat.i(207823);
    this.DMp = paramFtsWebVideoView;
    this.DMf = paramb;
    this.DMf.a(this);
    this.DzP = paramf;
    AppMethodBeat.o(207823);
  }
  
  private JSONObject G(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = boi();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject eOt()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = boi();
    localJSONObject.put("currentTime", this.DMp.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public final void DA() {}
  
  public final JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.DMp.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  final JSONObject boi()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.DMp.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  public final void boj()
  {
    AppMethodBeat.i(78174);
    if (this.lpN != null) {
      this.lpN.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void bz(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.DzP.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    ad.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    boj();
    AppMethodBeat.o(78167);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      ad.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      bz(a(5, G(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void eOp() {}
  
  public final void eOq() {}
  
  public final void eOs()
  {
    AppMethodBeat.i(78170);
    try
    {
      bz(a(6, eOt()));
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
    this.DMp.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */