package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements b.a
{
  private b.b PMS;
  private FtsWebVideoView PNc;
  private h PvJ;
  public MTimerHandler pzi;
  public int pzj;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, h paramh)
  {
    AppMethodBeat.i(267230);
    this.PNc = paramFtsWebVideoView;
    this.PMS = paramb;
    this.PMS.a(this);
    this.PvJ = paramh;
    AppMethodBeat.o(267230);
  }
  
  private JSONObject P(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = bWg();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject bWg()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.PNc.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  private JSONObject gTI()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = bWg();
    localJSONObject.put("currentTime", this.PNc.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public static JSONObject lw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(267231);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", paramInt1);
    localJSONObject.put("errMsg", String.valueOf(paramInt2));
    AppMethodBeat.o(267231);
    return localJSONObject;
  }
  
  public final void PS() {}
  
  public final void bWh()
  {
    AppMethodBeat.i(78174);
    if (this.pzi != null) {
      this.pzi.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void cj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.PvJ.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    Log.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    bWh();
    AppMethodBeat.o(78167);
  }
  
  public final JSONObject d(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.PNc.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      Log.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      cj(d(5, P(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void gTE() {}
  
  public final void gTF() {}
  
  public final void gTH()
  {
    AppMethodBeat.i(78170);
    try
    {
      cj(d(6, gTI()));
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
    this.PNc.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */