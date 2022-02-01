package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.b.a.b;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.n;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "netSceneGetSearchShare", "Lcom/tencent/mm/plugin/websearch/api/NetSceneGetSearchShare;", "cancelSearchShare", "", "destroy", "getSearchData", "paramsStr", "getSearchShare", "getTagSearchUIComponent", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<flp>
{
  private final String TAG;
  r WqB;
  
  public d(b paramb)
  {
    super((e)paramb);
    AppMethodBeat.i(315388);
    this.TAG = "MicroMsg.WebSearch.TagSearchWebData";
    com.tencent.mm.kernel.h.aZW().a(4614, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4858, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(315388);
  }
  
  public final void aEN(String paramString)
  {
    AppMethodBeat.i(315397);
    kotlin.g.b.s.u(paramString, "paramsStr");
    try
    {
      paramString = new JSONObject(paramString);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramString.keys();
      kotlin.g.b.s.s(localIterator, "requestObj.keys()");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Map localMap = (Map)localHashMap;
        kotlin.g.b.s.s(str, "it");
        localMap.put(str, paramString.opt(str));
      }
      paramString = new y(bt((Map)localHashMap));
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(315397);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
    AppMethodBeat.o(315397);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(315410);
    super.destroy();
    com.tencent.mm.kernel.h.aZW().b(4614, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(4858, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(315410);
  }
  
  public final void iqA()
  {
    AppMethodBeat.i(315400);
    r localr = this.WqB;
    if (localr != null)
    {
      com.tencent.mm.kernel.h.aZW().a((p)localr);
      this.WqB = null;
    }
    AppMethodBeat.o(315400);
  }
  
  public final b iqE()
  {
    f localf = this.WrK;
    if ((localf instanceof b)) {
      return (b)localf;
    }
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(315404);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    Log.i(this.TAG, "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramp instanceof y))
    {
      if (((y)paramp).WnS.hVk == ipD())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((y)paramp).WnR;
          if (localObject == null)
          {
            paramString = null;
            if (paramString != null) {
              break label293;
            }
            paramString = ((d)this).iqE();
            if (paramString != null)
            {
              paramString = paramString.iqG();
              if (paramString != null) {
                if (((y)paramp).WnS.offset != 0) {
                  break label287;
                }
              }
            }
          }
          label287:
          for (bool1 = bool2;; bool1 = false)
          {
            paramp = ((y)paramp).WnS.hOG;
            kotlin.g.b.s.s(paramp, "scene.model.requestId");
            paramString.h(bool1, "{\"ret\":-1}", paramp);
            AppMethodBeat.o(315404);
            return;
            paramString = iqE();
            if (paramString == null)
            {
              paramString = null;
              break;
            }
            paramString = paramString.iqG();
            if (paramString == null)
            {
              paramString = null;
              break;
            }
            if (((y)paramp).WnS.offset == 0) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject = ((gid)localObject).aayd;
              kotlin.g.b.s.s(localObject, "it.Json");
              String str = ((y)paramp).WnS.hOG;
              kotlin.g.b.s.s(str, "scene.model.requestId");
              paramString.h(bool1, (String)localObject, str);
              paramString = ah.aiuX;
              break;
            }
          }
          label293:
          AppMethodBeat.o(315404);
          return;
        }
        paramString = iqE();
        if (paramString != null)
        {
          paramString = paramString.iqG();
          if (paramString != null)
          {
            if (((y)paramp).WnS.offset == 0) {}
            for (;;)
            {
              paramp = ((y)paramp).WnS.hOG;
              kotlin.g.b.s.s(paramp, "scene.model.requestId");
              paramString.h(bool1, "{\"ret\":-1}", paramp);
              AppMethodBeat.o(315404);
              return;
              bool1 = false;
            }
          }
        }
      }
    }
    else if (((paramp instanceof r)) && (((r)paramp).WnW == ipD()) && (kotlin.g.b.s.p(paramp, this.WqB)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((r)paramp).WnV;
        if (paramString != null)
        {
          localObject = iqE();
          if (localObject != null) {
            ((b)localObject).a(paramString, ((r)paramp).WnX, ((r)paramp).WnU.YWK);
          }
        }
      }
      this.WqB = null;
    }
    AppMethodBeat.o(315404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.d
 * JD-Core Version:    0.7.0.1
 */