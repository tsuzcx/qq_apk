package com.tencent.mm.ui.n.b;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.u;
import com.tencent.mm.ui.n.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEGetVisibleMsgMetas;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "invoke", "", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "data", "Lorg/json/JSONObject;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.p
  implements a
{
  private static final String NAME = "getVisibleMsgMetas";
  public static final d.a afwS;
  
  static
  {
    AppMethodBeat.i(249832);
    afwS = new d.a((byte)0);
    AppMethodBeat.o(249832);
  }
  
  public final String a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249844);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    boolean bool = paramJSONObject.optBoolean("needFrame", false);
    com.tencent.mm.ui.chatting.d.a locala = paramb.adCQ;
    paramJSONObject = com.tencent.mm.ui.n.c.a.a(locala, false);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramJSONObject == null) || (paramJSONObject.size() <= 0))
    {
      Log.i("MicroMsg.MEGetVisibleMsgMetas", "stevecai: get visible msg metas, no visible holders found");
      paramb = a.e.rVt;
      paramJSONObject = new HashMap();
      paramJSONObject.put("msgMetas", localArrayList);
      localObject = ah.aiuX;
      paramb = a(paramb, (Map)paramJSONObject);
      AppMethodBeat.o(249844);
      return paramb;
    }
    Iterator localIterator = ((Iterable)paramJSONObject).iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      paramJSONObject = ((u)locala.cm(u.class)).jrZ();
      localObject = localPair.first;
      s.s(localObject, "pair.first");
      localObject = paramJSONObject.q((cc)localObject);
      paramJSONObject = (JSONObject)localObject;
      if (((List)localObject).isEmpty()) {
        paramJSONObject = kotlin.a.p.listOf("");
      }
      paramJSONObject = ((Iterable)paramJSONObject).iterator();
      while (paramJSONObject.hasNext())
      {
        localObject = (String)paramJSONObject.next();
        localObject = i.a((cc)localPair.first, (String)localObject, "", bool, locala, (View)paramb.afwG);
        if (localObject != null) {
          localArrayList.add(((i)localObject).jBH());
        }
      }
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249852);
    s.u(this, "this");
    AppMethodBeat.o(249852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.d
 * JD-Core Version:    0.7.0.1
 */