package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.webview.e;
import com.tencent.mm.plugin.topstory.ui.webview.e.12;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

final class b$1
  implements b.a
{
  b$1(b paramb) {}
  
  public final void aeg(String paramString)
  {
    AppMethodBeat.i(1566);
    e locale;
    JSONObject localJSONObject;
    if (this.tgw.tgd != null)
    {
      locale = this.tgw.tgd;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("params", paramString);
      al.d(new e.12(locale, localJSONObject.toString()));
      AppMethodBeat.o(1566);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.1
 * JD-Core Version:    0.7.0.1
 */