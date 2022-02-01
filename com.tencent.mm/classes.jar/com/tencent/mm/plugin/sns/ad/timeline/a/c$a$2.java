package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class c$a$2
  implements Runnable
{
  c$a$2(c.a parama, String paramString1, String paramString2) {}
  
  public final void run()
  {
    int j = 1;
    AppMethodBeat.i(224100);
    Object localObject2;
    Object localObject3;
    try
    {
      c.a locala = this.zrO;
      localObject2 = this.iwu;
      long l = r.azz((String)localObject2);
      localObject3 = ah.dXH().Ax(l);
      if (localObject3 == null) {
        ae.e("DynamicDataReqHelper", "adInfo can not get from DB due to adsnsinfo is null, longSnsId = " + l + ", snsId = " + (String)localObject2);
      }
      while (this.zrO.zrN == null)
      {
        ae.e("DynamicDataReqHelper", "adInfo is null, can not update AdInfo, snsId = " + this.iwu);
        AppMethodBeat.o(224100);
        return;
        locala.zrN = ((e)localObject3).dVi();
      }
      localObject2 = new g();
    }
    catch (Throwable localThrowable)
    {
      ae.e("DynamicDataReqHelper", localThrowable.toString());
      AppMethodBeat.o(224100);
      return;
    }
    Object localObject1 = new JSONObject(this.kvK);
    if (((JSONObject)localObject1).has("WordingLink")) {
      ((g)localObject2).zMc = ((JSONObject)localObject1).optString("WordingLink");
    }
    for (;;)
    {
      if (((JSONObject)localObject1).has("WordingType"))
      {
        ((g)localObject2).zMa = ((JSONObject)localObject1).optInt("WordingType");
        if (((g)localObject2).zMa == a.zLN)
        {
          if (((JSONObject)localObject1).has("UserNameList"))
          {
            localObject3 = ((JSONObject)localObject1).optJSONArray("UserNameList");
            ((g)localObject2).zMd.clear();
            i = 0;
            while (i < ((JSONArray)localObject3).length())
            {
              ((g)localObject2).zMd.add(((JSONArray)localObject3).optString(i));
              i += 1;
            }
            ((g)localObject2).zMc = null;
            continue;
          }
          ((g)localObject2).zMd.clear();
          if (((JSONObject)localObject1).has("WordingRepAndroid"))
          {
            localObject1 = ((JSONObject)localObject1).optString("WordingRepAndroid");
            if (((String)localObject1).indexOf("%s") < 0) {
              break label697;
            }
          }
        }
      }
    }
    label697:
    for (int i = j;; i = 0)
    {
      j = ((String)localObject1).indexOf("%");
      int k = ((String)localObject1).lastIndexOf("%");
      if ((!bu.isNullOrNil((String)localObject1)) && (i != 0) && (j == k)) {
        ((g)localObject2).zMb = ((String)localObject1);
      }
      if (!bu.isNullOrNil(((g)localObject2).zMb))
      {
        localObject3 = ((g)localObject2).zMd.iterator();
        localObject1 = "";
      }
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          Object localObject4 = ah.dXs().aUL(str);
          if (localObject4 != null)
          {
            localObject4 = ((c)localObject4).adG();
            if (!bu.isNullOrNil((String)localObject4)) {
              localObject1 = (String)localObject1 + (String)localObject4;
            }
          }
          while (((g)localObject2).zMd.getLast() != str)
          {
            localObject1 = (String)localObject1 + ",";
            break;
            localObject1 = (String)localObject1 + str;
            continue;
            localObject1 = (String)localObject1 + str;
          }
        }
        ((g)localObject2).zMe = ((String)localObject1);
        ((g)localObject2).zMf = String.format(((g)localObject2).zMb, new Object[] { localObject1 });
        for (;;)
        {
          localObject1 = this.zrO;
          if (((c.a)localObject1).zrN != null) {
            break;
          }
          ae.e("DynamicDataReqHelper", "adInfo or adChainData is null");
          AppMethodBeat.o(224100);
          return;
          c.a.a((g)localObject2);
          continue;
          if ((((g)localObject2).zMa == a.zLM) && (((JSONObject)localObject1).has("Wording")))
          {
            ((g)localObject2).zMb = ((JSONObject)localObject1).optString("Wording");
          }
          else
          {
            c.a.a((g)localObject2);
            continue;
            c.a.a((g)localObject2);
          }
        }
        ar.f(new c.a.1((c.a)localObject1, (g)localObject2));
        AppMethodBeat.o(224100);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.2
 * JD-Core Version:    0.7.0.1
 */