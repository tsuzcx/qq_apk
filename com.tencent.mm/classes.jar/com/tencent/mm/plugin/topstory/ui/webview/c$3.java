package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  implements g
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
        ad.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).dnB);
      }
      catch (JSONException paramString)
      {
        continue;
      }
      if (this.ySN.ySH != null) {
        this.ySN.ySH.asE(localJSONObject.toString());
      }
      AppMethodBeat.o(126555);
      return;
      if (this.ySN.ySH != null)
      {
        localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).dOc().EGU);
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramn).dOc().dnB);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.3
 * JD-Core Version:    0.7.0.1
 */