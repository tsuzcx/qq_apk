package com.tencent.mm.plugin.websearch.widget;

import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.aug;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.protocal.c.ckt;
import com.tencent.mm.protocal.c.cmx;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements p
{
  private static List<WidgetData> RC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = Collections.emptyList();
    }
    for (;;)
    {
      return paramString;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optJSONArray("data");
        localObject1 = ((JSONObject)localObject1).optString("searchID");
        if ((paramString == null) || (paramString.length() == 0)) {
          return Collections.EMPTY_LIST;
        }
        Object localObject2 = paramString.optJSONObject(0);
        paramString = localArrayList;
        if (localObject2 == null) {
          continue;
        }
        paramString = localArrayList;
        if (!((JSONObject)localObject2).has("items")) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).optJSONArray("items");
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= ((JSONArray)localObject2).length()) {
            break;
          }
          paramString = WidgetData.m(((JSONArray)localObject2).optJSONObject(i), (String)localObject1);
          if (paramString != null) {
            localArrayList.add(paramString);
          }
          i += 1;
        }
        return Collections.emptyList();
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("WidgetLocalSearchService", paramString, "", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, o paramo)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = com.tencent.mm.model.c.c.IX().fJ("100440");
      if (!((com.tencent.mm.storage.c)localObject1).isValid()) {
        break label104;
      }
      localObject2 = ((com.tencent.mm.storage.c)localObject1).ctr();
      if (localObject2 != null) {
        break label94;
      }
      localObject1 = "";
      y.i("WidgetLocalSearchService", "switch conf is %s", new Object[] { localObject1 });
    }
    label94:
    label104:
    for (boolean bool = "1".equals(((Map)localObject2).get("isOpen"));; bool = false)
    {
      if (bool) {
        break label110;
      }
      if (paramo != null) {
        paramo.m(paramString1, null);
      }
      return;
      localObject1 = localObject2.toString();
      break;
    }
    label110:
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecG = 2782;
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_weappsearch_localdata";
    ((b.a)localObject1).ecH = new aug();
    ((b.a)localObject1).ecI = new auh();
    localObject1 = ((b.a)localObject1).Kt();
    Object localObject2 = (aug)((com.tencent.mm.ah.b)localObject1).ecE.ecN;
    ((aug)localObject2).tpM = paramString2;
    ((aug)localObject2).tcJ = paramString1;
    ((aug)localObject2).tpJ = 0;
    ((aug)localObject2).tpI = aa.Bs(0);
    paramString2 = new cmx();
    paramString2.tZB = true;
    paramString2.tZx = ((aug)localObject2).tpI;
    ckt localckt = new ckt();
    localckt.tYb = new jr();
    atp localatp = aa.Jx();
    if (localatp != null)
    {
      jr localjr = localckt.tYb;
      if (com.tencent.mm.modelgeo.c.Ob().Oe()) {
        i = 0;
      }
      localjr.sEx = i;
      ((aug)localObject2).tpK = localatp.sGK;
      ((aug)localObject2).tpL = localatp.sGJ;
    }
    for (;;)
    {
      localckt.tYc = ((a)g.r(a.class)).aaM();
      try
      {
        ((aug)localObject2).tpN = new com.tencent.mm.bv.b(localckt.toByteArray());
        ((aug)localObject2).tpO = new com.tencent.mm.bv.b(paramString2.toByteArray());
        w.a((com.tencent.mm.ah.b)localObject1, new c.1(this, paramo, paramString1));
        return;
        localckt.tYb.sEx = 1;
        ((aug)localObject2).tpK = 0.0D;
        ((aug)localObject2).tpL = 0.0D;
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          y.printErrStackTrace("WidgetLocalSearchService", paramString2, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c
 * JD-Core Version:    0.7.0.1
 */