package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a<m>
{
  private List<String> DVg;
  public boolean dmj;
  private List<m> tGc;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString);
    this.DVg = paramList;
  }
  
  public final void hb(List<m> paramList)
  {
    AppMethodBeat.i(116560);
    this.tGc = paramList;
    if (this.tGc != null)
    {
      paramList = new ArrayList(this.DVg.size());
      Iterator localIterator = this.tGc.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        an localan = ((l)g.ab(l.class)).azF().BH(localm.tEY);
        i = this.DVg.indexOf(localan.field_username);
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
        this.tGc.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.dmj = true;
    AppMethodBeat.o(116560);
  }
  
  public final JSONObject iX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116561);
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.dmj)
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
    if (paramInt2 > this.tGc.size() - 1) {
      paramInt2 = this.tGc.size() - 1;
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
        if (paramInt2 != this.tGc.size() - 1) {
          break label578;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.query);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", x.aBE());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (m)this.tGc.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((l)g.ab(l.class)).azF().BH(((m)localObject1).tEY);
          localJSONObject3.put("userName", ((aw)localObject2).field_username);
          localJSONObject3.put("nickName", ((aw)localObject2).field_nickname);
          String str = ((m)localObject1).content;
          Context localContext = ak.getContext();
          str = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
          i = ((m)localObject1).tEX;
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
            localObject2 = p.aEN().DL(((aw)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((i)localObject2).aEH();
              localObject1 = str;
              if (bu.isNullOrNil(str)) {
                localObject1 = ((i)localObject2).aEG();
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
            ae.printErrStackTrace("JsapiFtsMatchContact", localJSONException1, "", new Object[0]);
            continue;
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (JSONException localJSONException2)
      {
        ae.printErrStackTrace("JsapiFtsMatchContact", localJSONException2, "", new Object[0]);
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