package com.tencent.mm.plugin.websearch.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static List<WidgetData> agD(String paramString)
  {
    AppMethodBeat.i(91433);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(91433);
      return paramString;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optJSONArray("data");
      paramString = paramString.optString("searchID");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        paramString = Collections.EMPTY_LIST;
        AppMethodBeat.o(91433);
        return paramString;
      }
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if ((localObject != null) && (((JSONObject)localObject).has("items")))
      {
        localObject = ((JSONObject)localObject).optJSONArray("items");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          WidgetData localWidgetData = WidgetData.l(((JSONArray)localObject).optJSONObject(i), paramString);
          if (localWidgetData != null) {
            localArrayList.add(localWidgetData);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(91433);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("WidgetLocalSearchService", paramString, "", new Object[0]);
      paramString = Collections.emptyList();
      AppMethodBeat.o(91433);
    }
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, o paramo)
  {
    int i = 1;
    AppMethodBeat.i(91432);
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = com.tencent.mm.model.c.c.abU().me("100440");
      if (!((com.tencent.mm.storage.c)localObject1).isValid()) {
        break label114;
      }
      localObject2 = ((com.tencent.mm.storage.c)localObject1).dvN();
      if (localObject2 != null) {
        break label104;
      }
      localObject1 = "";
      ab.i("WidgetLocalSearchService", "switch conf is %s", new Object[] { localObject1 });
    }
    label104:
    label114:
    for (boolean bool = "1".equals(((Map)localObject2).get("isOpen"));; bool = false)
    {
      if (bool) {
        break label120;
      }
      if (paramo != null) {
        paramo.n(paramString1, null);
      }
      AppMethodBeat.o(91432);
      return;
      localObject1 = localObject2.toString();
      break;
    }
    label120:
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = 2782;
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_weappsearch_localdata";
    ((b.a)localObject1).fsX = new ban();
    ((b.a)localObject1).fsY = new bao();
    localObject1 = ((b.a)localObject1).ado();
    Object localObject2 = (ban)((com.tencent.mm.ai.b)localObject1).fsV.fta;
    ((ban)localObject2).xpJ = paramString2;
    ((ban)localObject2).xba = paramString1;
    ((ban)localObject2).xpG = 0;
    ((ban)localObject2).xpF = aa.Jf(0);
    paramString2 = new dbf();
    paramString2.yhu = true;
    paramString2.yhq = ((ban)localObject2).xpF;
    cyi localcyi = new cyi();
    localcyi.yft = new mc();
    azu localazu = aa.acv();
    if (localazu != null)
    {
      mc localmc = localcyi.yft;
      if (com.tencent.mm.modelgeo.d.agQ().agT()) {
        i = 0;
      }
      localmc.wAD = i;
      ((ban)localObject2).xpH = localazu.wDi;
      ((ban)localObject2).xpI = localazu.wDh;
    }
    for (;;)
    {
      localcyi.yfu = ((e)g.E(e.class)).auy();
      try
      {
        ((ban)localObject2).xpK = new com.tencent.mm.bv.b(localcyi.toByteArray());
        ((ban)localObject2).xpL = new com.tencent.mm.bv.b(paramString2.toByteArray());
        w.a((com.tencent.mm.ai.b)localObject1, new c.1(this, paramo, paramString1));
        AppMethodBeat.o(91432);
        return;
        localcyi.yft.wAD = 1;
        ((ban)localObject2).xpH = 0.0D;
        ((ban)localObject2).xpI = 0.0D;
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          ab.printErrStackTrace("WidgetLocalSearchService", paramString2, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c
 * JD-Core Version:    0.7.0.1
 */