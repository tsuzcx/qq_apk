package com.tencent.mm.plugin.websearch.c.a;

import android.content.Context;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a<l>
{
  public boolean bGq;
  private List<l> kxh;
  private List<String> qWe;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString);
    this.qWe = paramList;
  }
  
  public final void da(List<l> paramList)
  {
    this.kxh = paramList;
    if (this.kxh != null)
    {
      paramList = new ArrayList(this.qWe.size());
      Iterator localIterator = this.kxh.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        ad localad = ((j)g.r(j.class)).Fw().abl(locall.kwg);
        i = this.qWe.indexOf(localad.field_username);
        if (i >= 0)
        {
          if (i < paramList.size()) {
            paramList.add(i, locall);
          }
          for (;;)
          {
            localIterator.remove();
            break;
            paramList.add(locall);
          }
        }
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        this.kxh.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.bGq = true;
  }
  
  public final JSONObject eC(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.bGq) {
      return localJSONObject1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0)) {
      return localJSONObject1;
    }
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (paramInt2 > this.kxh.size() - 1) {
      paramInt2 = this.kxh.size() - 1;
    }
    while (paramInt2 < paramInt1) {
      return localJSONObject1;
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        if (paramInt2 != this.kxh.size() - 1) {
          break label554;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.bVk);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", s.Hb());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (l)this.kxh.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((j)g.r(j.class)).Fw().abl(((l)localObject1).kwg);
          localJSONObject3.put("userName", ((ao)localObject2).field_username);
          localJSONObject3.put("nickName", ((ao)localObject2).field_nickname);
          String str = ((l)localObject1).content;
          Context localContext = ae.getContext();
          str = str.replaceFirst(this.bVk, "<em class=\\\"highlight\\\">" + this.bVk + "</em>");
          i = ((l)localObject1).kwf;
          localObject1 = str;
          switch (i)
          {
          default: 
            localObject1 = "";
          }
          try
          {
            localJSONObject3.put("displayText", localObject1);
            localObject1 = "";
            localObject2 = o.Kh().kp(((ao)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((h)localObject2).JY();
              localObject1 = str;
              if (bk.bl(str)) {
                localObject1 = ((h)localObject2).JX();
              }
            }
            localJSONObject3.put("thumbUrl", localObject1);
            localJSONArray2.put(localJSONObject3);
            paramInt1 += 1;
            continue;
            localObject1 = localContext.getString(a.c.search_contact_tag_wxid);
            localObject1 = (String)localObject1 + str;
            continue;
          }
          catch (JSONException localJSONException1)
          {
            y.printErrStackTrace("JsapiFtsMatchContact", localJSONException1, "", new Object[0]);
            continue;
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (JSONException localJSONException2)
      {
        y.printErrStackTrace("JsapiFtsMatchContact", localJSONException2, "", new Object[0]);
        return localJSONObject1;
      }
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      continue;
      label554:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.d
 * JD-Core Version:    0.7.0.1
 */