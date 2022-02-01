package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements h
{
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(116531);
    a(paramContext, paramInt, paramString1, paramString2, true, paramMap, false, 2147483647, paramString3);
    AppMethodBeat.o(116531);
  }
  
  private void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(116534);
    a(paramContext, paramInt1, paramString1, paramString2, true, paramMap, paramBoolean2, paramInt2, paramString3, 0, false, false, 0, false);
    AppMethodBeat.o(116534);
  }
  
  private void a(final Context paramContext, final int paramInt1, final String paramString1, final String paramString2, final boolean paramBoolean1, final Map<String, String> paramMap, final boolean paramBoolean2, final int paramInt2, final String paramString3, final int paramInt3, final boolean paramBoolean3, final boolean paramBoolean4, final int paramInt4, final boolean paramBoolean5)
  {
    AppMethodBeat.i(220002);
    ((i)g.ab(i.class)).a(paramContext, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116526);
        if (!com.tencent.mm.plugin.websearch.api.ad.Wd(0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("StartWebSearchService", "fts h5 template not avail");
          AppMethodBeat.o(116526);
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
            break label655;
          }
          localObject1 = (String)paramMap.get("parentSearchID");
        }
        try
        {
          localJSONObject.put("parentSearchID", localObject1);
          localObject3 = (String)paramMap.get("sugId");
          i = bt.aRe((String)paramMap.get("sceneActionType"));
          j = bt.aRe((String)paramMap.get("chatSearch"));
          localObject2 = localObject1;
          localObject1 = localObject3;
          com.tencent.mm.sdk.platformtools.ad.i("StartWebSearchService", "startWebSearch parentSearchID=%s", new Object[] { localObject2 });
          String str = String.valueOf(System.currentTimeMillis());
          localObject3 = com.tencent.mm.plugin.websearch.api.ad.Wb(paramInt1);
          if ((paramBoolean1) && (paramInt3 == 0) && (j != 2))
          {
            com.tencent.mm.sdk.platformtools.ad.i("StartWebSearchService", "preload web search data");
            com.tencent.mm.plugin.websearch.api.ad.a(str, paramString2, (String)localObject3, paramString1, paramInt1, (String)localObject1, i, (String)localObject2, j);
          }
          localObject1 = new nt();
          ((nt)localObject1).dBE.scene = 0;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = com.tencent.mm.plugin.websearch.api.ad.a(paramInt1, paramBoolean1, paramInt3, Uri.encode(localJSONObject.toString()), "", paramString2, paramString1, "", (String)localObject3, "", str);
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
            localObject1 = com.tencent.mm.plugin.websearch.api.ad.aY((Map)localObject1);
            localObject2 = com.tencent.mm.plugin.websearch.api.ad.eMd();
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
              ((Intent)localObject2).putExtra("key_preload_biz", a.eLB());
              ((Intent)localObject2).putExtra("key_weapp_url", a.aFH(paramString2));
              ((Intent)localObject2).putExtra("hideSearchInput", paramBoolean4);
              ((Intent)localObject2).putExtra("key_back_btn_type", paramInt4);
              ((Intent)localObject2).putExtra("key_hide_shadow_view", paramBoolean5);
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
              d.b(paramContext, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
              a.eLC();
              AppMethodBeat.o(116526);
              return;
              label655:
              localObject3 = new StringBuilder();
              if (paramMap.containsKey("clickType")) {}
              for (localObject1 = (String)paramMap.get("clickType") + ":";; localObject1 = "0:")
              {
                localObject1 = (String)localObject1 + (String)localObject2 + ":" + paramString1 + ":";
                break;
              }
              localJSONException = localJSONException;
              com.tencent.mm.sdk.platformtools.ad.l("StartWebSearchService", "", new Object[] { localJSONException });
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
    AppMethodBeat.o(220002);
  }
  
  public final void I(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116527);
    a(paramContext, 16, paramString1, paramString2, null);
    AppMethodBeat.o(116527);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220001);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = com.tencent.mm.plugin.websearch.b.a.aS(paramInt, false);
    String str = com.tencent.mm.modelappbrand.b.aDB();
    localMap.put("WASessionId", str);
    if (!bt.isNullOrNil(paramString2)) {
      localMap.put("query", paramString2);
    }
    localMap.put("sessionId", str);
    localMap.put("subSessionId", str);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aY(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localIntent.putExtra("ftsQuery", paramString2);
    localIntent.putExtra("key_preload_biz", 5);
    if (!bt.isNullOrNil(paramString1)) {
      localIntent.putExtra("key_search_place_holder", paramString1);
    }
    for (;;)
    {
      d.b(paramContext, "appbrand", ".ui.AppBrandSearchUI", localIntent);
      AppMethodBeat.o(220001);
      return;
      paramString1 = g.ajC().ajl().get(al.a.IxJ, null);
      if ((paramString1 != null) && ((paramString1 instanceof String))) {
        localIntent.putExtra("key_search_input_hint", (String)paramString1);
      }
    }
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116528);
    b(paramContext, paramInt, paramString1, paramString2, paramMap, "");
    AppMethodBeat.o(116528);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, int paramInt2)
  {
    AppMethodBeat.i(219999);
    a(paramContext, paramInt1, paramString1, paramString2, true, paramMap, false, paramInt2, "", 0, true, true, 1, true);
    AppMethodBeat.o(219999);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(116529);
    a(paramContext, paramInt1, paramString1, paramString2, true, paramMap, false, paramInt2, paramString3, 0, true, false, 0, false);
    AppMethodBeat.o(116529);
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, int paramInt2)
  {
    AppMethodBeat.i(220000);
    a(paramContext, paramInt1, paramString1, paramString2, paramBoolean, paramMap, false, 2147483647, "", paramInt2, true, false, 0, false);
    AppMethodBeat.o(220000);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116533);
    a(paramContext, 3, paramString1, paramString2, true, paramMap, true, -1, "");
    AppMethodBeat.o(116533);
  }
  
  public final void b(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    AppMethodBeat.i(116532);
    a(paramContext, paramInt, paramString1, paramString2, paramMap, paramString3);
    AppMethodBeat.o(116532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a
 * JD-Core Version:    0.7.0.1
 */