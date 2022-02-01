package com.tencent.mm.plugin.websearch.webview;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hj;
import com.tencent.mm.autogen.a.hj.a;
import com.tencent.mm.autogen.a.hj.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FTSEmojiDownloadedEvent;", "callback", "", "event", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSearchImageData$ftsEmojiDownloadedListener$1
  extends IListener<hj>
{
  WebSearchImageData$ftsEmojiDownloadedListener$1(k<T> paramk, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(315188);
    AppMethodBeat.o(315188);
  }
  
  private boolean a(hj paramhj)
  {
    AppMethodBeat.i(315200);
    s.u(paramhj, "event");
    k localk = this.WrW;
    if (paramhj.hIm.hAf == 2)
    {
      Log.i(k.b(localk), "emoji download callback %s", new Object[] { paramhj.hIm.md5 });
      if (!k.a(localk).containsKey(paramhj.hIm.md5)) {}
    }
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (k.a(localk))
      {
        localObject2 = (HashSet)k.a(localk).get(paramhj.hIm.md5);
        localObject1 = new JSONArray();
        s.checkNotNull(localObject2);
        localObject2 = ((HashSet)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          str2 = s.X("weixin://fts/emoji?path=", paramhj.hIn.path);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label179:
        ((JSONArray)localObject1).put(localJSONObject);
        continue;
        paramhj = finally;
        AppMethodBeat.o(315200);
        throw paramhj;
        localObject2 = localk.iqS();
        if (localObject2 != null)
        {
          localObject2 = ((d)localObject2).fyT();
          if (localObject2 != null)
          {
            localObject1 = ((JSONArray)localObject1).toString();
            s.s(localObject1, "returnArray.toString()");
            ((l)localObject2).dG(0, (String)localObject1);
          }
        }
        k.a(localk).remove(paramhj.hIm.md5);
        AppMethodBeat.o(315200);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label179;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.WebSearchImageData.ftsEmojiDownloadedListener.1
 * JD-Core Version:    0.7.0.1
 */