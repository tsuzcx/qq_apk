package com.tencent.mm.plugin.webview.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements b.a
{
  private b.b WCZ;
  private FtsWebVideoView WDj;
  private j WlX;
  public MTimerHandler sEn;
  public int sEo;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, j paramj)
  {
    AppMethodBeat.i(295581);
    this.WDj = paramFtsWebVideoView;
    this.WCZ = paramb;
    this.WCZ.a(this);
    this.WlX = paramj;
    AppMethodBeat.o(295581);
  }
  
  private JSONObject aK(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = cws();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject cws()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.WDj.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  private JSONObject itq()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = cws();
    localJSONObject.put("currentTime", this.WDj.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public static JSONObject ng(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295591);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", paramInt1);
    localJSONObject.put("errMsg", String.valueOf(paramInt2));
    AppMethodBeat.o(295591);
    return localJSONObject;
  }
  
  public final void aqb() {}
  
  public final void cF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.WlX.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    Log.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    cwt();
    AppMethodBeat.o(78167);
  }
  
  public final void cwt()
  {
    AppMethodBeat.i(78174);
    if (this.sEn != null) {
      this.sEn.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      Log.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      cF(f(5, aK(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final JSONObject f(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.WDj.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  public final void itm() {}
  
  public final void itn() {}
  
  public final void itp()
  {
    AppMethodBeat.i(78170);
    try
    {
      cF(f(6, itq()));
      AppMethodBeat.o(78170);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", localJSONException, null, new Object[0]);
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
    Log.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.WDj.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.d
 * JD-Core Version:    0.7.0.1
 */