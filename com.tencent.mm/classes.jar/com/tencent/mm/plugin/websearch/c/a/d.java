package com.tencent.mm.plugin.websearch.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
  public boolean cnz;
  private List<l> mSW;
  private List<String> uLq;
  
  public d(String paramString, List<String> paramList)
  {
    super(paramString);
    this.uLq = paramList;
  }
  
  public final void ee(List<l> paramList)
  {
    AppMethodBeat.i(91374);
    this.mSW = paramList;
    if (this.mSW != null)
    {
      paramList = new ArrayList(this.uLq.size());
      Iterator localIterator = this.mSW.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        ad localad = ((j)g.E(j.class)).YA().arw(locall.mRV);
        i = this.uLq.indexOf(localad.field_username);
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
        this.mSW.add(0, paramList.get(i));
        i -= 1;
      }
    }
    this.cnz = true;
    AppMethodBeat.o(91374);
  }
  
  public final JSONObject gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91375);
    JSONObject localJSONObject1 = new JSONObject();
    if (!this.cnz)
    {
      AppMethodBeat.o(91375);
      return localJSONObject1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(91375);
      return localJSONObject1;
    }
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (paramInt2 > this.mSW.size() - 1) {
      paramInt2 = this.mSW.size() - 1;
    }
    while (paramInt2 < paramInt1)
    {
      AppMethodBeat.o(91375);
      return localJSONObject1;
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        if (paramInt2 != this.mSW.size() - 1) {
          break label578;
        }
        i = 0;
        localJSONObject1.put("continueFlag", i);
        localJSONObject1.put("offset", paramInt2 + 1);
        localJSONObject1.put("query", this.query);
        localJSONObject1.put("ret", 0);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("count", paramInt2 - paramInt1 + 1);
        localJSONObject2.put("totalCount", t.aad());
        JSONArray localJSONArray2 = new JSONArray();
        if (paramInt1 <= paramInt2)
        {
          Object localObject1 = (l)this.mSW.get(paramInt1);
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject2 = ((j)g.E(j.class)).YA().arw(((l)localObject1).mRV);
          localJSONObject3.put("userName", ((aq)localObject2).field_username);
          localJSONObject3.put("nickName", ((aq)localObject2).field_nickname);
          String str = ((l)localObject1).content;
          Context localContext = ah.getContext();
          str = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
          i = ((l)localObject1).mRU;
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
            localObject2 = o.adg().rj(((aq)localObject2).field_username);
            if (localObject2 != null)
            {
              str = ((h)localObject2).acY();
              localObject1 = str;
              if (bo.isNullOrNil(str)) {
                localObject1 = ((h)localObject2).acX();
              }
            }
            localJSONObject3.put("thumbUrl", localObject1);
            localJSONArray2.put(localJSONObject3);
            paramInt1 += 1;
            continue;
            localObject1 = localContext.getString(2131302996);
            localObject1 = (String)localObject1 + str;
            continue;
          }
          catch (JSONException localJSONException1)
          {
            ab.printErrStackTrace("JsapiFtsMatchContact", localJSONException1, "", new Object[0]);
            continue;
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (JSONException localJSONException2)
      {
        ab.printErrStackTrace("JsapiFtsMatchContact", localJSONException2, "", new Object[0]);
        AppMethodBeat.o(91375);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.d
 * JD-Core Version:    0.7.0.1
 */