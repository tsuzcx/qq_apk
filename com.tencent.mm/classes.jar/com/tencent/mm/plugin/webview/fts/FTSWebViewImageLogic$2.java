package com.tencent.mm.plugin.webview.fts;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yp;
import com.tencent.mm.autogen.a.yp.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FTSWebViewImageLogic$2
  extends IListener<yp>
{
  FTSWebViewImageLogic$2(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295649);
    this.__eventId = yp.class.getName().hashCode();
    AppMethodBeat.o(295649);
  }
  
  private boolean a(yp paramyp)
  {
    AppMethodBeat.i(77878);
    if (((paramyp instanceof yp)) && (paramyp.ibS.hAf == 2))
    {
      Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramyp.ibS.mediaId });
      if (!b.c(this.WAC).containsKey(paramyp.ibS.mediaId)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (b.c(this.WAC))
      {
        i = ((Integer)b.d(this.WAC).get(paramyp.ibS.mediaId)).intValue();
        Object localObject = (HashSet)b.c(this.WAC).get(paramyp.ibS.mediaId);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/sns?path=" + y.n(paramyp.ibS.path, false);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label215:
        localJSONArray.put(localJSONObject);
        continue;
        paramyp = finally;
        AppMethodBeat.o(77878);
        throw paramyp;
        k.auP(i).dG(0, localJSONArray.toString());
        b.c(this.WAC).remove(paramyp.ibS.mediaId);
        b.d(this.WAC).remove(paramyp.ibS.mediaId);
        AppMethodBeat.o(77878);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label215;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.FTSWebViewImageLogic.2
 * JD-Core Version:    0.7.0.1
 */