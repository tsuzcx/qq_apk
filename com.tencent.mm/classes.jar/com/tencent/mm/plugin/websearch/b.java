package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.h.a.lc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements j
{
  private void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean, int paramInt2, String paramString3)
  {
    a(paramContext, paramInt1, paramString1, paramString2, paramMap, paramBoolean, paramInt2, paramString3, 0, false);
  }
  
  private void a(final Context paramContext, final int paramInt1, final String paramString1, final String paramString2, final Map<String, String> paramMap, final boolean paramBoolean1, final int paramInt2, final String paramString3, final int paramInt3, final boolean paramBoolean2)
  {
    ((m)g.r(m.class)).a(paramContext, new Runnable()
    {
      public final void run()
      {
        if (!aa.Br(0))
        {
          y.e("StartWebSearchService", "fts h5 template not avail");
          return;
        }
        Object localObject1 = "";
        int i = -1;
        Object localObject2 = new JSONObject();
        if (paramMap != null)
        {
          localObject1 = (String)paramMap.get("sugId");
          localObject1 = "0:" + (String)localObject1 + ":" + paramString1 + ":";
        }
        try
        {
          ((JSONObject)localObject2).put("parentSearchID", localObject1);
          localObject1 = (String)paramMap.get("sugId");
          i = bk.ZR((String)paramMap.get("sceneActionType"));
          String str2 = String.valueOf(System.currentTimeMillis());
          str1 = aa.Bm(paramInt1);
          aa.a(str2, paramString2, str1, paramString1, paramInt1, (String)localObject1, i);
          localObject1 = new lc();
          ((lc)localObject1).bUc.scene = 0;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = aa.a(paramInt1, this.qTg, 0, Uri.encode(((JSONObject)localObject2).toString()), "", paramString2, paramString1, "", str1, "", str2);
          if (paramMap != null) {
            ((Map)localObject1).putAll(paramMap);
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            String str1;
            ((Map)localObject1).put("query", q.encode(paramString1, "UTF-8"));
            ((Map)localObject1).put("sessionId", paramString2);
            localObject1 = aa.v((Map)localObject1);
            localObject2 = aa.bZt();
            ((Intent)localObject2).putExtra("ftsType", paramInt3);
            ((Intent)localObject2).putExtra("title", paramString3);
            ((Intent)localObject2).putExtra("ftsbizscene", paramInt1);
            ((Intent)localObject2).putExtra("ftsQuery", paramString1);
            if ((!TextUtils.isEmpty(paramString1)) || (paramBoolean2))
            {
              bool = true;
              ((Intent)localObject2).putExtra("ftsInitToSearch", bool);
              ((Intent)localObject2).putExtra("sessionId", paramString2);
              ((Intent)localObject2).putExtra("subSessionId", str1);
              ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
              ((Intent)localObject2).putExtra("key_preload_biz", 4);
              if (paramBoolean1) {
                ((Intent)localObject2).putExtra("status_bar_style", "black");
              }
              if (paramInt2 != 2147483647) {
                ((Intent)localObject2).putExtra("customize_status_bar_color", paramInt2);
              }
              ((Intent)localObject2).putExtra("key_load_js_without_delay", true);
              com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", (Intent)localObject2);
              b.bZd();
              return;
              localJSONException = localJSONException;
              y.b("StartWebSearchService", "", new Object[] { localJSONException });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localJSONException.put("query", paramString1);
              continue;
              boolean bool = false;
            }
          }
        }
      }
    });
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    a(paramContext, paramInt, paramString1, paramString2, null, "");
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, int paramInt2)
  {
    a(paramContext, paramInt1, paramString1, paramString2, paramMap, false, 2147483647, "", paramInt2, true);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    a(paramContext, paramInt, paramString1, paramString2, paramMap, false, 2147483647, paramString3);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    a(paramContext, 36, paramString1, paramString2, paramMap, false, 2147483647, "", 0, true);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    a(paramContext, 3, paramString1, paramString2, paramMap, true, -1, "");
  }
  
  public final void ev(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", 14);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("scene", "14");
    ((Map)localObject1).put("type", "64");
    ((Map)localObject1).put("lang", x.fB(ae.getContext()));
    ((Map)localObject1).put("platform", "android");
    ((Map)localObject1).put("version", String.valueOf(Integer.valueOf(com.tencent.mm.plugin.websearch.a.a.A(new File(com.tencent.mm.plugin.websearch.a.a.aoA(), "config.conf")).getProperty("version", "0")).intValue()));
    ((Map)localObject1).put("isHomePage", "0");
    if (!TextUtils.isEmpty("")) {
      ((Map)localObject1).put("extParams", "");
    }
    Object localObject2 = com.tencent.mm.model.c.c.IX().fJ("100192");
    if ((((com.tencent.mm.storage.c)localObject2).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject2).ctr().get("openSearchSuggestion")))) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", new Object[] { Integer.valueOf(14), Boolean.valueOf(false), Integer.valueOf(64), Boolean.valueOf(bool) });
      if (bool) {
        ((Map)localObject1).put("isSug", "1");
      }
      localObject2 = com.tencent.mm.modelappbrand.b.Jk();
      ((Map)localObject1).put("WASessionId", localObject2);
      ((Map)localObject1).put("sessionId", localObject2);
      ((Map)localObject1).put("subSessionId", localObject2);
      localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.a.a.v((Map)localObject1));
      localIntent.putExtra("key_load_js_without_delay", true);
      localIntent.addFlags(67108864);
      localIntent.putExtra("key_session_id", (String)localObject2);
      localIntent.putExtra("sessionId", (String)localObject2);
      localIntent.putExtra("subSessionId", (String)localObject2);
      localObject1 = g.DP().Dz().get(ac.a.uuO, null);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {
        localIntent.putExtra("key_search_input_hint", (String)localObject1);
      }
      com.tencent.mm.br.d.b(paramContext, "appbrand", ".ui.AppBrandSearchUI", localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */