package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a<m>
{
  private List<String> DDi;
  public boolean dlh;
  private List<m> tvl;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString);
    this.DDi = paramList;
  }
  
  public final void gR(List<m> paramList)
  {
    AppMethodBeat.i(116560);
    this.tvl = paramList;
    if (this.tvl != null)
    {
      paramList = new ArrayList(this.DDi.size());
      Iterator localIterator = this.tvl.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        am localam = ((l)g.ab(l.class)).azp().Bf(localm.tuh);
        i = this.DDi.indexOf(localam.field_username);
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
        this.tvl.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.dlh = true;
    AppMethodBeat.o(116560);
  }
  
  public final JSONObject iT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116561);
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.dlh)
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
    if (paramInt2 > this.tvl.size() - 1) {
      paramInt2 = this.tvl.size() - 1;
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
        if (paramInt2 != this.tvl.size() - 1) {
          break label578;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.query);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", w.aBo());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (m)this.tvl.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((l)g.ab(l.class)).azp().Bf(((m)localObject1).tuh);
          localJSONObject3.put("userName", ((aw)localObject2).field_username);
          localJSONObject3.put("nickName", ((aw)localObject2).field_nickname);
          String str = ((m)localObject1).content;
          Context localContext = aj.getContext();
          str = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
          i = ((m)localObject1).tug;
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
            localObject2 = p.aEx().Dj(((aw)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((i)localObject2).aEr();
              localObject1 = str;
              if (bt.isNullOrNil(str)) {
                localObject1 = ((i)localObject2).aEq();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.d
 * JD-Core Version:    0.7.0.1
 */