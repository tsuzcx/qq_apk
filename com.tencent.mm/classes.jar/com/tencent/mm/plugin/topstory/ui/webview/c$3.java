package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  implements f
{
  c$3(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126555);
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
        ae.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).dyb);
      }
      catch (JSONException paramString)
      {
        continue;
      }
      if (this.BPM.BPG != null) {
        this.BPM.BPG.aEl(localJSONObject.toString());
      }
      AppMethodBeat.o(126555);
      return;
      if (this.BPM.BPG != null)
      {
        localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).esA().Ijt);
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).esA().dyb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.3
 * JD-Core Version:    0.7.0.1
 */