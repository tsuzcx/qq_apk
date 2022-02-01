package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  implements i
{
  c$3(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
        Log.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramq).dPI);
      }
      catch (JSONException paramString)
      {
        continue;
      }
      if ((com.tencent.mm.plugin.topstory.ui.home.a)this.Gqs.IHe != null) {
        ((com.tencent.mm.plugin.topstory.ui.home.a)this.Gqs.IHe).aTB(localJSONObject.toString());
      }
      AppMethodBeat.o(126555);
      return;
      if ((com.tencent.mm.plugin.topstory.ui.home.a)this.Gqs.IHe != null)
      {
        localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramq).fxY().NvZ);
        localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramq).fxY().dPI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.c.3
 * JD-Core Version:    0.7.0.1
 */