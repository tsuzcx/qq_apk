package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.a.a;
import org.json.JSONException;
import org.json.JSONObject;

final class g$1
  implements com.tencent.mm.plugin.game.api.g
{
  g$1(g paramg)
  {
    AppMethodBeat.i(6959);
    AppMethodBeat.o(6959);
  }
  
  public final void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(153142);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("postId", paramString);
      localJSONObject.put("result", paramInt);
      paramString = new Bundle();
      paramString.putString("name", "onPublishHaowanEnd");
      paramString.putString("data", localJSONObject.toString());
      ToolsProcessIPCService.a(paramString, a.class);
      AppMethodBeat.o(153142);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(153142);
    }
  }
  
  public final void h(String paramString, float paramFloat)
  {
    AppMethodBeat.i(153143);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("postId", paramString);
      localJSONObject.put("percent", paramFloat);
      paramString = new Bundle();
      paramString.putString("name", "onPublishHaowanProgress");
      paramString.putString("data", localJSONObject.toString());
      ToolsProcessIPCService.a(paramString, a.class);
      AppMethodBeat.o(153143);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(153143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.1
 * JD-Core Version:    0.7.0.1
 */