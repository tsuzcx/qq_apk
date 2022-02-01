package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a<m>
{
  private List<String> AHW;
  public boolean dcq;
  private List<m> rpQ;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString);
    this.AHW = paramList;
  }
  
  public final void gu(List<m> paramList)
  {
    AppMethodBeat.i(116560);
    this.rpQ = paramList;
    if (this.rpQ != null)
    {
      paramList = new ArrayList(this.AHW.size());
      Iterator localIterator = this.rpQ.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        af localaf = ((k)g.ab(k.class)).apM().aHY(localm.roN);
        i = this.AHW.indexOf(localaf.field_username);
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
        this.rpQ.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.dcq = true;
    AppMethodBeat.o(116560);
  }
  
  public final JSONObject ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116561);
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.dcq)
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
    if (paramInt2 > this.rpQ.size() - 1) {
      paramInt2 = this.rpQ.size() - 1;
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
        if (paramInt2 != this.rpQ.size() - 1) {
          break label578;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.query);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", w.ary());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (m)this.rpQ.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((k)g.ab(k.class)).apM().aHY(((m)localObject1).roN);
          localJSONObject3.put("userName", ((au)localObject2).field_username);
          localJSONObject3.put("nickName", ((au)localObject2).field_nickname);
          String str = ((m)localObject1).content;
          Context localContext = aj.getContext();
          str = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
          i = ((m)localObject1).roM;
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
            localObject2 = p.auF().we(((au)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((i)localObject2).auy();
              localObject1 = str;
              if (bt.isNullOrNil(str)) {
                localObject1 = ((i)localObject2).aux();
              }
            }
            localJSONObject3.put("thumbUrl", localObject1);
            localJSONArray2.put(localJSONObject3);
            paramInt1 += 1;
            continue;
            localObject1 = localContext.getString(2131762935);
            localObject1 = (String)localObject1 + str;
            continue;
          }
          catch (JSONException localJSONException1)
          {
            ad.printErrStackTrace("JsapiFtsMatchContact", localJSONException1, "", new Object[0]);
            continue;
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (JSONException localJSONException2)
      {
        ad.printErrStackTrace("JsapiFtsMatchContact", localJSONException2, "", new Object[0]);
        AppMethodBeat.o(116561);
        return localJSONObject1;
      }
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      continue;
      label578:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.d
 * JD-Core Version:    0.7.0.1
 */