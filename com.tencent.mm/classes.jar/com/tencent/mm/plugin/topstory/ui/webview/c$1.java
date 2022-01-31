package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements com.tencent.mm.ai.f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(2148);
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
        ab.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      }
      catch (JSONException paramString)
      {
        continue;
      }
      if (this.tmb.tlT != null) {
        this.tmb.tlT.ael(localJSONObject.toString());
      }
      AppMethodBeat.o(2148);
      return;
      if (this.tmb.tlT != null)
      {
        paramString = ((com.tencent.mm.plugin.topstory.a.c.f)paramm).cIE().xUF;
        paramm = ((com.tencent.mm.plugin.topstory.a.c.f)paramm).cIE().xHX;
        localJSONObject.put("commentId", paramString);
        localJSONObject.put("requestId", paramm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.1
 * JD-Core Version:    0.7.0.1
 */