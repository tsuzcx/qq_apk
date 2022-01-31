package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  implements f
{
  c$3(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(2150);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("retCode", paramInt2);
        localJSONObject.put("errMsg", paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          continue;
        }
        ab.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramm).ohe);
      }
      catch (JSONException paramString)
      {
        continue;
      }
      if (this.tmb.tlT != null) {
        this.tmb.tlT.aek(localJSONObject.toString());
      }
      AppMethodBeat.o(2150);
      return;
      if (this.tmb.tlT != null)
      {
        localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramm).cIC().yfl);
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramm).cIC().ohe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.3
 * JD-Core Version:    0.7.0.1
 */