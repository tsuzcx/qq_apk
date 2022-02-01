package com.tencent.mm.plugin.websearch.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a<m>
{
  private List<m> BIW;
  private List<String> PAS;
  public boolean fwi;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString, 2147483647);
    this.PAS = paramList;
  }
  
  public final void iX(List<m> paramList)
  {
    AppMethodBeat.i(116560);
    this.BIW = paramList;
    if (this.BIW != null)
    {
      paramList = new ArrayList(this.PAS.size());
      Iterator localIterator = this.BIW.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        as localas = ((n)h.ae(n.class)).bbL().RG(localm.BHS);
        i = this.PAS.indexOf(localas.field_username);
        if (i >= 0)
        {
          if (i < paramList.size()) {
            paramList.add(i, localm);
          }
          for (;;)
          {
            localIterator.remove();
            break;
            paramList.add(localm);
          }
        }
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        this.BIW.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.fwi = true;
    AppMethodBeat.o(116560);
  }
  
  public final JSONObject lt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116561);
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.fwi)
    {
      AppMethodBeat.o(116561);
      return localJSONObject1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(116561);
      return localJSONObject1;
    }
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (paramInt2 > this.BIW.size() - 1) {
      paramInt2 = this.BIW.size() - 1;
    }
    while (paramInt2 < paramInt1)
    {
      AppMethodBeat.o(116561);
      return localJSONObject1;
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        if (paramInt2 != this.BIW.size() - 1) {
          break label579;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.query);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", ab.bee());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (m)this.BIW.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((n)h.ae(n.class)).bbL().RG(((m)localObject1).BHS);
          localJSONObject3.put("userName", ((ax)localObject2).field_username);
          localJSONObject3.put("nickName", ((ax)localObject2).field_nickname);
          String str = ((m)localObject1).content;
          Context localContext = MMApplicationContext.getContext();
          str = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
          i = ((m)localObject1).BHR;
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
            localObject2 = q.bhP().TS(((ax)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((j)localObject2).bhI();
              localObject1 = str;
              if (Util.isNullOrNil(str)) {
                localObject1 = ((j)localObject2).bhH();
              }
            }
            localJSONObject3.put("thumbUrl", localObject1);
            localJSONArray2.put(localJSONObject3);
            paramInt1 += 1;
            continue;
            localObject1 = localContext.getString(a.g.web_search_contact_tag_wxid);
            localObject1 = (String)localObject1 + str;
            continue;
          }
          catch (JSONException localJSONException1)
          {
            Log.printErrStackTrace("JsapiFtsMatchContact", localJSONException1, "", new Object[0]);
            continue;
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (JSONException localJSONException2)
      {
        Log.printErrStackTrace("JsapiFtsMatchContact", localJSONException2, "", new Object[0]);
        AppMethodBeat.o(116561);
        return localJSONObject1;
      }
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      continue;
      label579:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.d
 * JD-Core Version:    0.7.0.1
 */