package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.om;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements h
{
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(201771);
    a(paramContext, paramInt, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, paramString3);
    AppMethodBeat.o(201771);
  }
  
  private void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(116534);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean1, paramMap, paramBoolean2, paramInt2, paramString3, 0, false);
    AppMethodBeat.o(116534);
  }
  
  private void a(final Context paramContext, final int paramInt1, final String paramString1, final String paramString2, final boolean paramBoolean1, final Map<String, String> paramMap, final boolean paramBoolean2, final int paramInt2, final String paramString3, final int paramInt3, final boolean paramBoolean3)
  {
    AppMethodBeat.i(201774);
    ((i)g.af(i.class)).a(paramContext, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201768);
        if (!ai.afs(0))
        {
          Log.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(201768);
          return;
        }
        if (!WeChatBrands.Business.Entries.DiscoverySearch.checkAvailable(paramContext))
        {
          AppMethodBeat.o(201768);
          return;
        }
        Object localObject1 = "";
        int i = -1;
        JSONObject localJSONObject = new JSONObject();
        Object localObject2 = "";
        int j = 0;
        if (paramMap != null)
        {
          localObject2 = (String)paramMap.get("sugId");
          if (!paramMap.containsKey("parentSearchID")) {
            break label720;
          }
          localObject1 = (String)paramMap.get("parentSearchID");
        }
        try
        {
          localJSONObject.put("parentSearchID", localObject1);
          localObject3 = (String)paramMap.get("sugId");
          i = Util.safeParseInt((String)paramMap.get("sceneActionType"));
          j = Util.safeParseInt((String)paramMap.get("chatSearch"));
          localObject2 = localObject1;
          localObject1 = localObject3;
          Log.i("StartWebSearchService", "startWebSearch parentSearchID=%s,scene=%s", new Object[] { localObject2, Integer.valueOf(paramInt1) });
          String str = String.valueOf(System.currentTimeMillis());
          localObject3 = ai.afq(paramInt1);
          if ((paramBoolean1) && (paramInt3 == 0) && (j == 0))
          {
            Log.i("StartWebSearchService", "preload web search data");
            ai.a(str, paramString2, (String)localObject3, paramString1, paramInt1, (String)localObject1, i, (String)localObject2, j, null, null);
          }
          localObject1 = new om();
          ((om)localObject1).dUz.scene = 0;
          EventCenter.instance.publish((IEvent)localObject1);
          localObject1 = ai.a(paramInt1, paramBoolean1, paramInt3, Uri.encode(localJSONObject.toString()), "", paramString2, paramString1, "", (String)localObject3, "", str);
          if (paramMap != null) {
            ((Map)localObject1).putAll(paramMap);
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            Object localObject3;
            ((Map)localObject1).put("query", q.encode(paramString1, "UTF-8"));
            ((Map)localObject1).put("sessionId", paramString2);
            localObject1 = ai.bd((Map)localObject1);
            ah.a(paramInt1, paramString2, (String)localObject3, paramBoolean1, paramString1, paramInt3, "", "");
            localObject2 = ai.fXX();
            ((Intent)localObject2).putExtra("ftsType", paramInt3);
            ((Intent)localObject2).putExtra("title", paramString3);
            ((Intent)localObject2).putExtra("ftsbizscene", paramInt1);
            ((Intent)localObject2).putExtra("ftsQuery", paramString1);
            if ((!TextUtils.isEmpty(paramString1)) || (paramBoolean3))
            {
              bool = true;
              ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
              ((Intent)localObject2).putExtra("sessionId", paramString2);
              ((Intent)localObject2).putExtra("subSessionId", (String)localObject3);
              ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
              ((Intent)localObject2).putExtra("key_preload_biz", a.fXq());
              ((Intent)localObject2).putExtra("key_weapp_url", a.aWV(paramString2));
              ((Intent)localObject2).putExtra("hideSearchInput", this.IDc);
              ((Intent)localObject2).putExtra("key_back_btn_type", this.IDd);
              ((Intent)localObject2).putExtra("key_hide_shadow_view", this.IDe);
              if (paramBoolean2) {
                ((Intent)localObject2).putExtra("status_bar_style", "black");
              }
              if (paramInt2 != 2147483647) {
                ((Intent)localObject2).putExtra("customize_status_bar_color", paramInt2);
              }
              ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
              if (paramInt1 == 56) {
                ((Intent)localObject2).putExtra("ftsneedkeyboard", true);
              }
              c.b(paramContext, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
              a.fXr();
              AppMethodBeat.o(201768);
              return;
              label720:
              localObject3 = new StringBuilder();
              if (paramMap.containsKey("clickType")) {}
              for (localObject1 = (String)paramMap.get("clickType") + ":";; localObject1 = "0:")
              {
                localObject1 = (String)localObject1 + (String)localObject2 + ":" + paramString1 + ":";
                break;
              }
              localJSONException = localJSONException;
              Log.printDebugStack("StartWebSearchService", "", new Object[] { localJSONException });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ((Map)localObject1).put("query", paramString1);
              continue;
              boolean bool = false;
            }
          }
        }
      }
    });
    AppMethodBeat.o(201774);
  }
  
  public final void M(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116527);
    a(paramContext, 16, paramString1, paramString2, null);
    AppMethodBeat.o(116527);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116528);
    b(paramContext, paramInt, paramString1, paramString2, true, paramMap, "");
    AppMethodBeat.o(116528);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(116529);
    a(paramContext, paramInt1, paramString1, paramString2, true, paramMap, false, paramInt2, paramString3, 0, true);
    AppMethodBeat.o(116529);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, int paramInt2)
  {
    AppMethodBeat.i(201770);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, "", paramInt2, true);
    AppMethodBeat.o(201770);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116533);
    a(paramContext, 3, paramString1, paramString2, true, paramMap, true, -1, "");
    AppMethodBeat.o(116533);
  }
  
  public final void a(final ag paramag)
  {
    AppMethodBeat.i(201769);
    ((i)g.af(i.class)).a(paramag.context, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116526);
        if (!ai.afs(0))
        {
          Log.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(116526);
          return;
        }
        Log.i("StartWebSearchService", "startWebSearch");
        a.b(paramag);
        String str3 = String.valueOf(System.currentTimeMillis());
        String str2 = ai.afq(paramag.scene);
        int i = 0;
        Object localObject1 = null;
        if (paramag.dVU != null)
        {
          i = Util.safeParseInt((String)paramag.dVU.get("chatSearch"));
          localObject1 = (String)paramag.dVU.get("reqKey");
        }
        if (!Util.isNullOrNil(paramag.IEr)) {}
        label149:
        String str1;
        for (Object localObject2 = new JSONObject();; str1 = "") {
          try
          {
            ((JSONObject)localObject2).put("parentSearchID", paramag.IEr);
            localObject2 = Uri.encode(((JSONObject)localObject2).toString());
            Log.i("StartWebSearchService", "preload web search data");
            ai.a(str3, paramag.sessionId, str2, paramag.query, paramag.scene, "", -1, paramag.IEr, i, (String)localObject1, paramag.dVU);
            localObject1 = ai.a(paramag.scene, paramag.IEk, paramag.type, (String)localObject2, "", paramag.sessionId, paramag.query, "", str2, "", str3);
            if (paramag.dVU != null) {
              ((Map)localObject1).putAll(paramag.dVU);
            }
            try
            {
              ((Map)localObject1).put("query", q.encode(paramag.query, "UTF-8"));
              ((Map)localObject1).put("sessionId", paramag.sessionId);
              ((Map)localObject1).put("parentSearchID", paramag.IEr);
              localObject1 = ai.bd((Map)localObject1);
              localObject2 = ai.fXX();
              ((Intent)localObject2).putExtra("ftsType", paramag.type);
              ((Intent)localObject2).putExtra("title", paramag.title);
              ((Intent)localObject2).putExtra("ftsbizscene", paramag.scene);
              ((Intent)localObject2).putExtra("ftsQuery", paramag.query);
              if ((!TextUtils.isEmpty(paramag.query)) || (paramag.IEl))
              {
                bool = true;
                ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
                ((Intent)localObject2).putExtra("sessionId", paramag.sessionId);
                ((Intent)localObject2).putExtra("subSessionId", str2);
                ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
                ((Intent)localObject2).putExtra("key_preload_biz", a.fXq());
                ((Intent)localObject2).putExtra("key_weapp_url", a.aWV(paramag.sessionId));
                ((Intent)localObject2).putExtra("hideSearchInput", paramag.IEm);
                ((Intent)localObject2).putExtra("key_back_btn_type", paramag.IEn);
                ((Intent)localObject2).putExtra("key_hide_shadow_view", paramag.IEo);
                ((Intent)localObject2).putExtra("first_page_result", paramag.IEq);
                if (paramag.IEp) {
                  ((Intent)localObject2).putExtra("status_bar_style", "black");
                }
                if (paramag.statusBarColor != 2147483647) {
                  ((Intent)localObject2).putExtra("customize_status_bar_color", paramag.statusBarColor);
                }
                ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
                if (paramag.scene == 56) {
                  ((Intent)localObject2).putExtra("ftsneedkeyboard", true);
                }
                c.b(paramag.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
                a.fXr();
                AppMethodBeat.o(116526);
                return;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ((Map)localObject1).put("query", paramag.query);
                continue;
                boolean bool = false;
              }
            }
          }
          catch (Exception localException2)
          {
            break label149;
          }
        }
      }
    });
    AppMethodBeat.o(201769);
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(201773);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = com.tencent.mm.plugin.websearch.c.a.br(paramInt, false);
    String str = b.aXE();
    localMap.put("WASessionId", str);
    if (!Util.isNullOrNil(paramString2)) {
      localMap.put("query", paramString2);
    }
    localMap.put("sessionId", str);
    localMap.put("subSessionId", str);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.bd(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localIntent.putExtra("ftsQuery", paramString2);
    localIntent.putExtra("key_preload_biz", 5);
    if (!Util.isNullOrNil(paramString1)) {
      localIntent.putExtra("key_search_place_holder", paramString1);
    }
    for (;;)
    {
      c.b(paramContext, "appbrand", ".ui.AppBrandSearchUI", localIntent);
      AppMethodBeat.o(201773);
      return;
      paramString1 = g.aAh().azQ().get(ar.a.Oaj, null);
      if ((paramString1 != null) && ((paramString1 instanceof String))) {
        localIntent.putExtra("key_search_input_hint", (String)paramString1);
      }
    }
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(201772);
    a(paramContext, paramInt, paramString1, paramString2, true, paramMap, paramString3);
    AppMethodBeat.o(201772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a
 * JD-Core Version:    0.7.0.1
 */