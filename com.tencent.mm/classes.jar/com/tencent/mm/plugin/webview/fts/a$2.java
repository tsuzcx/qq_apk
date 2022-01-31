package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.h.a.qj;
import com.tencent.mm.h.a.qj.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a$2
  extends c<qj>
{
  a$2(a parama)
  {
    this.udX = qj.class.getName().hashCode();
  }
  
  private boolean a(qj paramqj)
  {
    if (((paramqj instanceof qj)) && (paramqj.bZJ.bHz == 2))
    {
      y.i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramqj.bZJ.bUi });
      if (!this.qYQ.qYK.containsKey(paramqj.bZJ.bUi)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.qYQ.qYK)
      {
        i = ((Integer)this.qYQ.qYN.get(paramqj.bZJ.bUi)).intValue();
        Object localObject = (HashSet)this.qYQ.qYK.get(paramqj.bZJ.bUi);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/sns?path=" + paramqj.bZJ.path;
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label206:
        localJSONArray.put(localJSONObject);
        continue;
        paramqj = finally;
        throw paramqj;
        h.Db(i).aZ(0, localJSONArray.toString());
        this.qYQ.qYK.remove(paramqj.bZJ.bUi);
        this.qYQ.qYN.remove(paramqj.bZJ.bUi);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label206;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.2
 * JD-Core Version:    0.7.0.1
 */