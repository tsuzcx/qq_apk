package com.tencent.mm.plugin.webview.fts;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hj;
import com.tencent.mm.autogen.a.hj.a;
import com.tencent.mm.autogen.a.hj.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FTSWebViewImageLogic$1
  extends IListener<hj>
{
  FTSWebViewImageLogic$1(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295646);
    this.__eventId = hj.class.getName().hashCode();
    AppMethodBeat.o(295646);
  }
  
  private boolean a(hj paramhj)
  {
    AppMethodBeat.i(77876);
    if (paramhj.hIm.hAf == 2)
    {
      Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramhj.hIm.md5 });
      if (!b.a(this.WAC).containsKey(paramhj.hIm.md5)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (b.a(this.WAC))
      {
        i = ((Integer)b.b(this.WAC).get(paramhj.hIm.md5)).intValue();
        Object localObject = (HashSet)b.a(this.WAC).get(paramhj.hIm.md5);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/emoji?path=" + paramhj.hIn.path;
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label204:
        localJSONArray.put(localJSONObject);
        continue;
        paramhj = finally;
        AppMethodBeat.o(77876);
        throw paramhj;
        k.auP(i).dG(0, localJSONArray.toString());
        b.a(this.WAC).remove(paramhj.hIm.md5);
        b.b(this.WAC).remove(paramhj.hIm.md5);
        AppMethodBeat.o(77876);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label204;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.FTSWebViewImageLogic.1
 * JD-Core Version:    0.7.0.1
 */