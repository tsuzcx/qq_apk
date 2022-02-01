package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements b.a
{
  private h IBw;
  private b.b IQD;
  FtsWebVideoView IQN;
  public MTimerHandler mAM;
  public int mAN;
  
  public d(FtsWebVideoView paramFtsWebVideoView, b.b paramb, h paramh)
  {
    AppMethodBeat.i(210856);
    this.IQN = paramFtsWebVideoView;
    this.IQD = paramb;
    this.IQD.a(this);
    this.IBw = paramh;
    AppMethodBeat.o(210856);
  }
  
  private JSONObject J(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78171);
    JSONObject localJSONObject = bKv();
    localJSONObject.put("fullScreen", paramBoolean);
    localJSONObject.put("direction", paramString);
    AppMethodBeat.o(78171);
    return localJSONObject;
  }
  
  private JSONObject gaQ()
  {
    AppMethodBeat.i(78173);
    JSONObject localJSONObject = bKv();
    localJSONObject.put("currentTime", this.IQN.getCurrPosSec());
    AppMethodBeat.o(78173);
    return localJSONObject;
  }
  
  public final void Na() {}
  
  public final JSONObject b(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78176);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("playerId", this.IQN.getmVideoPlayerId());
    localJSONObject.put("event", paramInt);
    if (paramJSONObject != null) {
      localJSONObject.put("detail", paramJSONObject);
    }
    AppMethodBeat.o(78176);
    return localJSONObject;
  }
  
  final JSONObject bKv()
  {
    AppMethodBeat.i(78172);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.IQN.getCookieData());
    AppMethodBeat.o(78172);
    return localJSONObject;
  }
  
  public final void bKw()
  {
    AppMethodBeat.i(78174);
    if (this.mAM != null) {
      this.mAM.stopTimer();
    }
    AppMethodBeat.o(78174);
  }
  
  public final void bY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78168);
    this.IBw.b("onVideoPlayerCallback", null, paramJSONObject);
    AppMethodBeat.o(78168);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(78167);
    Log.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[] { toString() });
    bKw();
    AppMethodBeat.o(78167);
  }
  
  public final void d(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(78169);
    try
    {
      Log.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString });
      bY(b(5, J(paramBoolean, paramString)));
      AppMethodBeat.o(78169);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { paramString });
      AppMethodBeat.o(78169);
    }
  }
  
  public final void gaM() {}
  
  public final void gaN() {}
  
  public final void gaP()
  {
    AppMethodBeat.i(78170);
    try
    {
      bY(b(6, gaQ()));
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
    this.IQN.setCallback(null);
    AppMethodBeat.o(78175);
  }
  
  public final void onForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.d
 * JD-Core Version:    0.7.0.1
 */