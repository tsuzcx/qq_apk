package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.h.a.fz;
import com.tencent.mm.h.a.fz.a;
import com.tencent.mm.h.a.fz.b;
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

final class a$1
  extends c<fz>
{
  a$1(a parama)
  {
    this.udX = fz.class.getName().hashCode();
  }
  
  private boolean a(fz paramfz)
  {
    if (paramfz.bNk.bHz == 2)
    {
      y.i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramfz.bNk.bIW });
      if (!this.qYQ.qYL.containsKey(paramfz.bNk.bIW)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.qYQ.qYL)
      {
        i = ((Integer)this.qYQ.qYO.get(paramfz.bNk.bIW)).intValue();
        Object localObject = (HashSet)this.qYQ.qYL.get(paramfz.bNk.bIW);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/emoji?path=" + paramfz.bNl.path;
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label199:
        localJSONArray.put(localJSONObject);
        continue;
        paramfz = finally;
        throw paramfz;
        h.Db(i).aZ(0, localJSONArray.toString());
        this.qYQ.qYL.remove(paramfz.bNk.bIW);
        this.qYQ.qYO.remove(paramfz.bNk.bIW);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label199;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.1
 * JD-Core Version:    0.7.0.1
 */