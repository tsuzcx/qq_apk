package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avj;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.cik;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.ah.f
{
  private long gMG;
  public com.tencent.mm.sdk.b.c giK = new b.3(this);
  public com.tencent.mm.plugin.fts.a.a.a kxg;
  public l mVF = new b.4(this);
  public Set<Integer> qYR;
  public l qYS = new b.1(this);
  private HashMap<String, b.b> qYT;
  public e qYU;
  public v qYV;
  private Map<Integer, b.g> qYW = new HashMap();
  public b.e qYX = new b.e(this);
  public List<com.tencent.mm.av.e> qYY;
  private com.tencent.mm.plugin.websearch.c.a.c qYZ;
  com.tencent.mm.plugin.websearch.c.a.d qZa;
  
  public b()
  {
    y.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
    this.qYT = new HashMap();
    this.qYR = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.sdk.b.a.udP.c(this.giK);
  }
  
  static void a(com.tencent.mm.plugin.websearch.c.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramd = paramd.eC(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = h.Db(paramInt3);
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_json_data", paramd.toString());
    try
    {
      if (localg.rgh != null) {
        localg.rgh.b(137, localBundle);
      }
      return;
    }
    catch (RemoteException paramd)
    {
      y.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + paramd.getMessage());
    }
  }
  
  private static void a(b.c paramc, boolean paramBoolean)
  {
    int i;
    if (paramc.qZq != 0) {
      i = paramc.qZq;
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.api.ai.Rx(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.mVN);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.qZn);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.mWN != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.mWN.toByteArray());
        label111:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.fTF);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.bVk);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.qZp);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.br.d.b(ae.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        return;
        if (paramc.bVt == 2)
        {
          i = 89;
          continue;
        }
        if (paramBoolean)
        {
          i = 85;
          continue;
        }
        if ((paramc.scene == 3) || (paramc.scene == 16))
        {
          if (paramc.qZo)
          {
            i = 88;
            continue;
          }
          i = 87;
          continue;
        }
        i = 39;
      }
      catch (IOException localIOException)
      {
        break label111;
      }
    }
  }
  
  private static void a(b.d paramd)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramd.username);
    localIntent.putExtra("Contact_Nick", paramd.nickname);
    localIntent.putExtra("Contact_Alias", paramd.cMT);
    localIntent.putExtra("Contact_Sex", paramd.sex);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramd.country, paramd.cCA, paramd.cCB));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.qZr);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.bVk);
    com.tencent.mm.br.d.b(ae.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("convertActivityFromTranslucent", false);
    localIntent.putExtra("customize_status_bar_color", paramInt1);
    localIntent.putExtra("status_bar_style", paramString2);
    if (!bk.bl(paramString3))
    {
      localIntent.putExtra("prePublishId", paramString3);
      localIntent.putExtra("KPublisherId", paramString3);
    }
    for (;;)
    {
      if (paramInt2 > 0) {
        localIntent.putExtra("pay_channel", paramInt2);
      }
      com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      if ((paramBundle != null) && (!bk.bl(paramString1)))
      {
        paramString1 = paramBundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.o(paramString1.getBytes());
        localIntent.putExtra("prePublishId", paramString1);
        localIntent.putExtra("KPublisherId", paramString1);
      }
    }
  }
  
  private b.c ae(Map<String, Object> paramMap)
  {
    b.c localc = new b.c(this, (byte)0);
    localc.username = aa.s(paramMap, "userName");
    localc.nickname = aa.s(paramMap, "nickName");
    localc.mVN = aa.s(paramMap, "headHDImgUrl");
    localc.qZn = aa.c(paramMap, "verifyFlag", 0);
    localc.signature = aa.s(paramMap, "signature");
    localc.scene = aa.c(paramMap, "scene", 0);
    localc.bVt = aa.c(paramMap, "sceneActionType", 1);
    localc.mWN = new sg();
    localc.mWN.ffv = aa.c(paramMap, "brandFlag", 0);
    localc.mWN.ffy = aa.s(paramMap, "iconUrl");
    localc.mWN.ffx = aa.s(paramMap, "brandInfo");
    localc.mWN.ffw = aa.s(paramMap, "externalInfo");
    localc.fTF = aa.s(paramMap, "searchId");
    localc.bVk = aa.s(paramMap, "query");
    localc.position = aa.c(paramMap, "position", 0);
    localc.qZo = aa.t(paramMap, "isCurrentDetailPage");
    localc.qZp = aa.s(paramMap, "extraParams");
    localc.qZq = aa.c(paramMap, "friendScene", 0);
    return localc;
  }
  
  private b.d af(Map<String, Object> paramMap)
  {
    int i = 3;
    b.d locald = new b.d(this, (byte)0);
    locald.username = aa.s(paramMap, "userName");
    locald.nickname = aa.s(paramMap, "nickName");
    locald.cMT = aa.s(paramMap, "alias");
    locald.signature = aa.s(paramMap, "signature");
    locald.sex = aa.c(paramMap, "sex", 0);
    locald.country = aa.s(paramMap, "country");
    locald.cCB = aa.s(paramMap, "city");
    locald.cCA = aa.s(paramMap, "province");
    locald.qZr = aa.c(paramMap, "snsFlag", 0);
    String str = aa.s(paramMap, "query");
    if (!bk.bl(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if ("mobile".equals(aa.s(paramMap, "matchType"))) {
          locald.bVk = str;
        }
      }
      else {
        return locald;
      }
      locald.scene = 1;
      return locald;
    }
    locald.scene = 3;
    return locald;
  }
  
  public static boolean ag(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = aa.s(paramMap, "word");
    boolean bool = aa.t(paramMap, "isInputChange");
    String str2 = aa.s(paramMap, "custom");
    String str3 = aa.s(paramMap, "tagList");
    paramMap = h.Db(bk.e(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool);
    localBundle.putString("fts_key_tag_list", str3);
    try
    {
      if (paramMap.rgh != null) {
        paramMap.rgh.b(122, localBundle);
      }
      return false;
    }
    catch (RemoteException paramMap)
    {
      y.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
    }
    return false;
  }
  
  public static int c(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    paramMap1 = aa.s(paramMap1, "data");
    for (;;)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(paramMap1);
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        if (i < localJSONArray1.length())
        {
          localObject = localJSONArray1.getJSONObject(i);
          if (((JSONObject)localObject).has("id"))
          {
            paramMap1 = ((JSONObject)localObject).getString("id");
            if (!((JSONObject)localObject).has("userName")) {
              break label196;
            }
            localObject = ((JSONObject)localObject).getString("userName");
            String str = com.tencent.mm.model.r.gV((String)localObject);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", paramMap1);
            localJSONObject.put("userName", localObject);
            localJSONObject.put("displayName", str);
            localJSONArray2.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramMap2.put("ret", Integer.valueOf(0));
          paramMap2.put("data", localJSONArray2.toString());
          return 0;
        }
      }
      catch (JSONException paramMap1)
      {
        y.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", paramMap1, "", new Object[0]);
        return 0;
      }
      paramMap1 = "";
      continue;
      label196:
      Object localObject = "";
    }
  }
  
  private static void j(String paramString, Bundle paramBundle)
  {
    a(paramString, paramBundle, 0, "", "", 0);
  }
  
  public static Bundle o(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    case 3: 
    case 5: 
    default: 
    case 7: 
    case 2: 
      for (;;)
      {
        return localBundle;
        localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.ccI().cay());
        return localBundle;
        try
        {
          paramBundle = paramBundle.getString("key");
          localBundle.putString("result", ac.Ru(paramBundle).toString());
          if ("educationTab".equals(paramBundle))
          {
            paramBundle = ac.Ru("discoverSearchGuide");
            if (paramBundle.optJSONArray("items").length() > 0)
            {
              localBundle.putString("result_1", paramBundle.toString());
              return localBundle;
            }
          }
        }
        catch (Exception paramBundle)
        {
          return localBundle;
        }
      }
    case 4: 
      paramBundle = aa.b(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      return localBundle;
    }
    try
    {
      localBundle.putString("result", ac.Rv(paramBundle.getString("key")));
      return localBundle;
    }
    catch (Exception paramBundle) {}
    return localBundle;
  }
  
  static String p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = x.fB(ae.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean) {}
    do
    {
      return str2;
      au.Hx();
    } while (new File(com.tencent.mm.model.c.FJ(), str2).exists());
    return str1;
  }
  
  private static void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    bxk localbxk = ((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sns.b.m.class)).nn(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localbxk.lsK).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localbxk.toByteArray());
      label76:
      com.tencent.mm.br.d.b(ae.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      return;
    }
    catch (IOException paramString2)
    {
      break label76;
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg)
  {
    y.i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int j = bk.ZR((String)paramMap.get("actionType"));
    int k = aa.c(paramMap, "type", 0);
    Object localObject3 = (String)paramMap.get("extParams");
    String str3 = (String)paramMap.get("jumpTo");
    String str1 = (String)paramMap.get("navBarColor");
    String str2 = aa.s(paramMap, "publishId");
    boolean bool = "true".equals((String)paramMap.get("hideSearchBar"));
    Object localObject1 = (String)paramMap.get("nativeConfig");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      Object localObject4;
      String str6;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("title")) {
          break label1662;
        }
        localObject1 = ((JSONObject)localObject1).optString("title");
        i = 0;
        if (!bk.bl(str1)) {}
        localObject2 = null;
      }
      catch (JSONException localJSONException)
      {
        try
        {
          i = Color.parseColor(str1);
          localObject4 = (String)paramMap.get("statusBarStyle");
          str6 = (String)paramMap.get("tagId");
          str1 = (String)paramMap.get("sessionId");
          switch (j)
          {
          case 4: 
          default: 
            return false;
          }
        }
        catch (IllegalArgumentException paramMap)
        {
          y.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
          return true;
        }
        localJSONException = localJSONException;
        y.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", localJSONException, "", new Object[0]);
      }
      Object localObject2;
      continue;
      switch (k)
      {
      default: 
        localObject2 = aa.s(paramMap, "jumpUrl");
        y.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[] { localObject2 });
        paramMap = null;
        if (paramg != null) {
          paramMap = paramg.cgw();
        }
        if (!bk.bl((String)localObject2))
        {
          com.tencent.mm.plugin.webview.modeltools.g.ccI();
          a((String)localObject2, paramMap, i, (String)localObject4, str2, 0);
        }
        break;
      case 8: 
        aa.s(paramMap, "snsid");
        paramg = aa.s(paramMap, "objectXmlDesc");
        localObject2 = aa.s(paramMap, "userName");
        bool = aa.t(paramMap, "fromMusicItem");
        com.tencent.mm.plugin.webview.modeltools.g.ccI();
        s(paramg, (String)localObject2, bool);
        break;
      case 1: 
        a(ae(paramMap), false);
        break;
      case 32: 
        a(af(paramMap));
        continue;
        localObject2 = aa.s(paramMap, "jumpUrl");
        y.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[] { localObject2 });
        paramMap = null;
        if (paramg != null) {
          paramMap = paramg.cgw();
        }
        if (!bk.bl((String)localObject2))
        {
          com.tencent.mm.plugin.webview.modeltools.g.ccI();
          a((String)localObject2, paramMap, i, (String)localObject4, str2, 0);
          continue;
          String str4 = aa.s(paramMap, "query");
          int m = aa.c(paramMap, "scene", 0);
          String str5 = aa.s(paramMap, "searchId");
          paramg = new Intent();
          paramg.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
          paramg.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
          paramg.putExtra("neverGetA8Key", true);
          paramg.putExtra("key_load_js_without_delay", true);
          paramg.putExtra("ftsQuery", str4);
          paramg.putExtra("ftsType", k);
          paramg.putExtra("customize_status_bar_color", i);
          paramg.putExtra("status_bar_style", (String)localObject4);
          paramg.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str3));
          paramg.putExtra("KPublisherId", str2);
          paramg.putExtra("ftsbizscene", m);
          if (localObject2 != null) {
            paramg.putExtra("title", (String)localObject2);
          }
          if (!com.tencent.mm.plugin.appbrand.u.r.aqr())
          {
            paramMap = com.tencent.mm.bc.a.bu(m, k);
            paramMap.put("query", str4);
            paramMap.put("searchId", str5);
            paramg.putExtra("rawUrl", com.tencent.mm.bc.a.b(m, paramMap));
            if ((m == 20) || (m == 22) || (m == 33)) {}
            for (paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";; paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI")
            {
              com.tencent.mm.br.d.b(ae.getContext(), "webview", paramMap, paramg);
              break;
            }
          }
          if (aa.c(paramMap, "isWeAppMore", 0) == 1) {}
          int n;
          for (j = 1;; j = 0)
          {
            n = aa.c(paramMap, "tabPageType", 0);
            if (j == 0) {
              break label1050;
            }
            localObject2 = com.tencent.mm.plugin.appbrand.u.r.a(m, false, k, (String)localObject3);
            ((Map)localObject2).put("query", str4);
            ((Map)localObject2).put("searchId", str5);
            ((Map)localObject2).put("subType", String.valueOf(aa.c(paramMap, "subType", 0)));
            ((Map)localObject2).put("isWeAppMore", String.valueOf(aa.c(paramMap, "isWeAppMore", 0)));
            paramMap = com.tencent.mm.modelappbrand.b.Jk();
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("subSessionId", paramMap);
            paramg.putExtra("key_session_id", paramMap);
            paramg.putExtra("rawUrl", com.tencent.mm.plugin.appbrand.u.r.v((Map)localObject2));
            paramg.putExtra("ftsbizscene", m);
            paramg.putExtra("customize_status_bar_color", i);
            paramg.putExtra("status_bar_style", (String)localObject4);
            paramg.putExtra("sessionId", paramMap);
            com.tencent.mm.br.d.b(ae.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramg);
            break;
          }
          label1050:
          paramMap = aa.a(m, false, k, (String)localObject3);
          paramMap.put("query", str4);
          paramMap.put("searchId", str5);
          if (!TextUtils.isEmpty(str1))
          {
            paramMap.put("sessionId", str1);
            paramg.putExtra("sessionId", str1);
          }
          str2 = aa.Bm(m);
          paramMap.put("subSessionId", str2);
          paramg.putExtra("subSessionId", str2);
          paramg.putExtra("rawUrl", com.tencent.mm.bc.a.b(m, paramMap));
          paramg.putExtra("ftsQuery", str4);
          paramg.putExtra("customize_status_bar_color", i);
          paramg.putExtra("status_bar_style", (String)localObject4);
          paramg.putExtra("tabId", str6);
          paramg.putExtra("key_load_js_without_delay", true);
          if (n == 1)
          {
            paramg.putExtra("ftscaneditable", false);
            aa.a(ae.getContext(), str4, paramg, (String)localObject2, (String)localObject3, str5, str1, str2);
            return false;
          }
          if ((m == 20) || (m == 22) || (m == 33) || (m == 3) || (m == 36))
          {
            paramg.putExtra("ftsInitToSearch", true);
            paramg.putExtra("hideSearchInput", bool);
          }
          for (paramMap = ".ui.tools.fts.FTSSOSHomeWebViewUI";; paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI")
          {
            if (TextUtils.isEmpty(paramMap)) {
              break label1325;
            }
            com.tencent.mm.br.d.b(ae.getContext(), "webview", paramMap, paramg);
            break;
          }
          label1325:
          continue;
          paramg = aa.s(paramMap, "query");
          i = aa.c(paramMap, "topStoryScene", 0);
          j = aa.c(paramMap, "tagId", 0);
          str2 = aa.s(paramMap, "navigationId");
          paramMap = str1;
          if (bk.bl(str1)) {
            paramMap = aa.Bm(i);
          }
          str1 = String.valueOf(System.currentTimeMillis());
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("scene", "21");
          ((HashMap)localObject4).put("query", paramg);
          ((HashMap)localObject4).put("extParams", localObject3);
          ((HashMap)localObject4).put("sessionId", paramMap);
          ((HashMap)localObject4).put("subSessionId", paramMap);
          ((HashMap)localObject4).put("requestId", str1);
          ((HashMap)localObject4).put("pRequestId", str1);
          ((HashMap)localObject4).put("seq", str1);
          ((HashMap)localObject4).put("navigationId", str2);
          ((HashMap)localObject4).put("channelId", String.valueOf(j));
          localObject3 = new byb();
          ((byb)localObject3).tNY = com.tencent.mm.plugin.topstory.ui.d.bNj();
          ((byb)localObject3).scene = i;
          ((byb)localObject3).fTF = "";
          ((byb)localObject3).bGm = paramg;
          ((byb)localObject3).bIB = paramMap;
          ((byb)localObject3).bVp = paramMap;
          ((byb)localObject3).tOa = 2;
          ((byb)localObject3).url = com.tencent.mm.plugin.topstory.a.g.m((HashMap)localObject4);
          ((byb)localObject3).tOb = ((String)localObject2);
          ((byb)localObject3).bvj = j;
          ((byb)localObject3).lJQ = str1;
          ((byb)localObject3).qTP = str2;
          ((byb)localObject3).tOc = aa.boM();
          paramMap = new rb();
          paramMap.key = "rec_category";
          paramMap.sOI = j;
          paramMap.sOJ = String.valueOf(j);
          ((byb)localObject3).qTG.add(paramMap);
          com.tencent.mm.plugin.topstory.ui.d.a(ae.getContext(), (byb)localObject3, str1);
          continue;
          label1662:
          localObject2 = null;
        }
        break;
      }
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg, String paramString)
  {
    this.qYX.pDz = true;
    boolean bool1 = aa.t(paramMap, "isTeachPage");
    boolean bool2 = aa.t(paramMap, "isMoreButton");
    int j;
    int i;
    label56:
    String str1;
    String str3;
    String str2;
    int k;
    if (aa.c(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (aa.c(paramMap, "isWeAppMore", 0) != 1) {
        break label161;
      }
      i = 1;
      str1 = aa.s(paramMap, "sessionId");
      str3 = (String)paramMap.get("navBarColor");
      str2 = aa.s(paramMap, "searchPlaceHolder");
      k = 0;
      if (bk.bl(str3)) {}
    }
    for (;;)
    {
      try
      {
        k = Color.parseColor(str3);
        str3 = (String)paramMap.get("statusBarStyle");
        if (j == 0) {
          break label195;
        }
        paramString = aa.s(paramMap, "jumpUrl");
        paramMap = null;
        if (paramg != null) {
          paramMap = paramg.cgw();
        }
        com.tencent.mm.plugin.webview.modeltools.g.ccI();
        j(paramString, paramMap);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label161:
        y.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label56;
      label195:
      j = aa.c(paramMap, "type", 0);
      int m = aa.c(paramMap, "opType", 0);
      if (m > 0)
      {
        switch (m)
        {
        default: 
          break;
        case 2: 
          a(ae(paramMap), bool1);
          break;
        case 3: 
          paramMap = ae(paramMap);
          if (!s.hk(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          com.tencent.mm.plugin.websearch.api.ai.Rx(paramMap.username);
          paramg = new Intent();
          paramg.putExtra("Chat_User", paramMap.username);
          paramg.putExtra("finish_direct", true);
          paramg.putExtra("key_temp_session_show_type", 0);
          com.tencent.mm.br.d.e(ae.getContext(), ".ui.chatting.ChattingUI", paramg);
          break;
        case 4: 
          paramString = aa.s(paramMap, "jumpUrl");
          paramMap = null;
          if (paramg != null) {
            paramMap = paramg.cgw();
          }
          com.tencent.mm.plugin.webview.modeltools.g.ccI();
          j(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        String str4 = aa.s(paramMap, "query");
        k = aa.c(paramMap, "scene", 0);
        str3 = aa.s(paramMap, "searchId");
        paramg = new Intent();
        paramg.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
        paramg.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
        paramg.putExtra("neverGetA8Key", true);
        paramg.putExtra("key_load_js_without_delay", true);
        paramg.putExtra("ftsQuery", str4);
        paramg.putExtra("ftsType", j);
        paramg.putExtra("sessionId", str1);
        if (!com.tencent.mm.plugin.appbrand.u.r.aqr())
        {
          paramMap = com.tencent.mm.bc.a.bu(k, j);
          try
          {
            paramMap.put("query", q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = aa.Bm(bk.ZR((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramg.putExtra("subSessionId", paramString);
            paramg.putExtra("key_session_id", str1);
            paramg.putExtra("rawUrl", com.tencent.mm.bc.a.b(k, paramMap));
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.br.d.b(ae.getContext(), "webview", paramMap, paramg);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramMap.put("query", str4);
              continue;
              paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI";
            }
          }
        }
        else if (i != 0)
        {
          paramString = com.tencent.mm.plugin.appbrand.u.r.a(k, false, j, paramString);
          try
          {
            paramString.put("query", q.encode(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(aa.c(paramMap, "subType", 0)));
            paramString.put("isWeAppMore", String.valueOf(aa.c(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.Jk();
            paramString.put("sessionId", paramMap);
            str1 = aa.Bm(bk.ZR((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramg.putExtra("subSessionId", str1);
            paramg.putExtra("key_session_id", paramMap);
            paramg.putExtra("rawUrl", com.tencent.mm.plugin.appbrand.u.r.v(paramString));
            paramg.putExtra("ftsbizscene", k);
            paramg.putExtra("key_search_place_holder", str2);
            com.tencent.mm.br.d.b(ae.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramg);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramString.put("query", str4);
            }
          }
        }
        else
        {
          paramMap = aa.a(k, false, j, paramString);
          try
          {
            paramMap.put("query", q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = aa.Bm(bk.ZR((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramg.putExtra("subSessionId", paramString);
            paramg.putExtra("rawUrl", com.tencent.mm.bc.a.b(k, paramMap));
            paramg.putExtra("key_session_id", str1);
            paramg.putExtra("searchId", str3);
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.br.d.b(ae.getContext(), "webview", paramMap, paramg);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramMap.put("query", str4);
              continue;
              paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI";
            }
          }
        }
      }
      else
      {
        y.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = aa.s(paramMap, "jumpUrl");
          str1 = aa.s(paramMap, "publishId");
          i = aa.c(paramMap, "payScene", 0);
          y.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          paramMap = null;
          if (paramg != null) {
            paramMap = paramg.cgw();
          }
          if (!bk.bl(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.ccI();
            a(paramString, paramMap, k, str3, str1, i);
          }
          break;
        case 8: 
          aa.s(paramMap, "snsid");
          paramg = aa.s(paramMap, "objectXmlDesc");
          paramString = aa.s(paramMap, "userName");
          bool1 = aa.t(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.ccI();
          s(paramg, paramString, bool1);
          break;
        case 1: 
          a(ae(paramMap), false);
          break;
        case 32: 
          a(af(paramMap));
        }
      }
    }
  }
  
  public final boolean aa(Map<String, Object> paramMap)
  {
    switch (aa.c(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      return false;
      if (af.qUu == null) {
        af.bZA();
      }
      af.qUu.hPT.clear();
      paramMap = ae.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = af.bZB();
        localObject2 = Base64.encodeToString(af.qUu.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        y.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
        return false;
      }
      catch (IOException paramMap)
      {
        return false;
      }
      int i = aa.c(paramMap, "type", 0);
      int j = aa.c(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.gMG > 1000L)
      {
        this.gMG = System.currentTimeMillis();
        if (!aa.Br(0))
        {
          y.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
          return false;
        }
        ao.u(i, j, ac.Rv("searchID"));
        paramMap = aa.bZt();
        paramMap.putExtra("ftsneedkeyboard", true);
        paramMap.putExtra("ftsbizscene", j);
        paramMap.putExtra("ftsType", i);
        paramMap.putExtra("rawUrl", aa.v(aa.b(j, true, i)));
        paramMap.putExtra("key_load_js_without_delay", true);
        com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
        return false;
        localObject1 = h.Db(aa.c(paramMap, "webview_instance_id", -1));
        i = aa.c(paramMap, "scene", 0);
        paramMap = aa.s(paramMap, "query");
        if ((i != 20) || (bk.bl(paramMap)))
        {
          y.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          return false;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).rgh != null)
          {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).rgh.b(136, (Bundle)localObject2);
            return false;
          }
        }
        catch (Exception paramMap)
        {
          y.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
        }
      }
    }
    return false;
  }
  
  public final boolean ab(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = aa.c(paramMap, "scene", 0);
    int k = aa.c(paramMap, "type", 0);
    int m = aa.c(paramMap, "requestType", 0);
    int j = bk.e(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    boolean bool = aa.t(paramMap, "ignoreCache");
    Object localObject1;
    if (m == 0)
    {
      paramMap = p(i, k, true);
      if (this.qYT.get(paramMap) == null)
      {
        localObject1 = new b.b(this, (byte)0);
        ((b.b)localObject1).eD(i, k);
        this.qYT.put(paramMap, localObject1);
      }
      paramMap = (b.b)this.qYT.get(paramMap);
      if ((!bk.bl(paramMap.bOE)) && (!bool))
      {
        y.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", new Object[] { Integer.valueOf(j), paramMap.bOE });
        if ((paramMap.scene != 20) || (paramMap.type != 0) || ((!paramMap.eyC) && (paramMap.isAvailable()))) {
          h.Db(j).c(m, paramMap.bOE, 1, str);
        }
      }
      if ((paramMap.isAvailable()) && (!bool))
      {
        y.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", new Object[] { Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.qZk), Long.valueOf(paramMap.qZl), Integer.valueOf(paramMap.type), paramMap.bOE });
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          ao.a(paramMap.scene, 0, paramMap.jfE, paramMap.type, 2, paramMap.caz(), 1);
        }
        for (;;)
        {
          return false;
          ao.a(paramMap.scene, 0, paramMap.jfE, paramMap.type, 1, "", 0);
        }
      }
      au.Dk().a(1048, this);
      y.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[] { Integer.valueOf(j) });
      paramMap = x.fB(ae.getContext());
      long l = ac.Ru("discoverSearchEntry").optLong("guideParam");
      this.qYV = new v(i, k, aa.Bs(0), j, paramMap, l, str);
      au.Dk().a(this.qYV, 0);
      return false;
    }
    paramMap = com.tencent.mm.plugin.websearch.api.ai.bZE();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        i = paramMap.hPT.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject2 = (ayk)paramMap.hPT.get(i);
          if (!s.hk(((ayk)localObject2).sxM)) {
            break label722;
          }
          localObject2 = com.tencent.mm.ai.f.kX(((ayk)localObject2).sxM);
          if (localObject2 == null) {
            break label722;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.ai.d)localObject2).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.ai.d)localObject2).field_username);
          localJSONObject2.put("nickName", com.tencent.mm.model.r.gV(((com.tencent.mm.ai.d)localObject2).field_username));
          localJSONArray2.put(localJSONObject2);
          break label722;
        }
        localJSONObject1.put("items", localJSONArray2);
        localJSONObject1.put("type", 5);
        localJSONObject1.put("title", "");
        localJSONArray1.put(localJSONObject1);
        ((JSONObject)localObject1).put("data", localJSONArray1);
        paramMap = ((JSONObject)localObject1).toString();
        y.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        h.Db(j).c(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        y.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label722:
      i -= 1;
    }
  }
  
  public final boolean ac(Map<String, Object> paramMap)
  {
    boolean bool = true;
    int i = bk.e(paramMap.get("webview_instance_id"), -1);
    if (this.qYW.get(Integer.valueOf(201)) == null)
    {
      localObject = b.g.caA();
      if (localObject != null) {
        this.qYW.put(Integer.valueOf(201), localObject);
      }
    }
    Object localObject = (b.g)this.qYW.get(Integer.valueOf(201));
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg;
    String str;
    if (localObject != null)
    {
      localg = h.Db(i);
      str = ((b.g)localObject).bOE;
      if (!((b.g)localObject).caB()) {
        break label177;
      }
    }
    label177:
    for (i = 1;; i = 0)
    {
      localg.af(str, 1, i);
      bool = ((b.g)localObject).caB();
      if (bool)
      {
        au.Dk().a(1866, this);
        localObject = new c();
        if (paramMap != null) {
          ((c)localObject).bVm = aa.c(paramMap, "webview_instance_id", -1);
        }
        au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      }
      return false;
    }
  }
  
  public final boolean ad(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    blf localblf = new blf();
    localblf.tEQ = aa.s(paramMap, "logString");
    au.Dk().a(1134, this);
    paramMap = new w(localblf);
    au.Dk().a(paramMap, 0);
    return false;
  }
  
  public final boolean ah(Map<String, Object> paramMap)
  {
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    int j = bk.ZR((String)paramMap.get("offset"));
    int k = bk.ZR((String)paramMap.get("count"));
    int m = bk.e(paramMap.get("webview_instance_id"), -1);
    paramMap = (Map<String, Object>)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramMap = "";
    }
    localObject = new ArrayList();
    try
    {
      paramMap = new JSONArray(paramMap);
      int i = 0;
      while (i < paramMap.length())
      {
        ((List)localObject).add(paramMap.optString(i));
        i += 1;
      }
      return false;
    }
    catch (JSONException paramMap)
    {
      y.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.qYZ == null) {
        this.qYZ = new com.tencent.mm.plugin.websearch.c.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.c.a.d(str, (List)localObject);
      if ((this.qZa == null) || (!this.qZa.equals(paramMap)))
      {
        this.qZa = paramMap;
        this.qYZ.a(paramMap, new b.5(this, j, k, m));
      }
      while (!this.qZa.bGq) {
        return false;
      }
      a(this.qZa, j, k, m);
    }
  }
  
  public final String cay()
  {
    Object localObject1 = p(20, 0, true);
    Object localObject2;
    if (this.qYT.get(localObject1) == null)
    {
      localObject2 = new b.b(this, (byte)0);
      ((b.b)localObject2).eD(20, 0);
      this.qYT.put(localObject1, localObject2);
    }
    localObject1 = (b.b)this.qYT.get(localObject1);
    if (((b.b)localObject1).isAvailable()) {}
    for (localObject1 = ((b.b)localObject1).bOE;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject2 = "";
      }
      return localObject2;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof v))
    {
      au.Dk().b(1048, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        y.e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    label838:
    do
    {
      do
      {
        do
        {
          return;
          paramString = (v)paramm;
          localObject = new b.b(this, (byte)0);
          ((b.b)localObject).scene = paramString.scene;
          ((b.b)localObject).qZk = paramString.qTT.tqW;
          ((b.b)localObject).bOE = paramString.qTT.sEb;
          ((b.b)localObject).qZl = (System.currentTimeMillis() / 1000L);
          ((b.b)localObject).jfE = paramString.qTT.tqX;
          ((b.b)localObject).type = paramString.businessType;
          paramm = p(((b.b)localObject).scene, ((b.b)localObject).type, true);
          y.i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { ((b.b)localObject).bOE });
          if (!bk.bl(((b.b)localObject).bOE))
          {
            h.Db(paramString.bVm).c(0, ((b.b)localObject).bOE, 0, paramString.lJQ);
            y.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { ((b.b)localObject).bOE });
          }
          this.qYT.put(paramm, localObject);
          if (((b.b)localObject).qZk == 0L)
          {
            paramInt1 = ((b.b)localObject).scene;
            paramInt2 = ((b.b)localObject).type;
            y.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            au.Hx();
            paramString = com.tencent.mm.model.c.FJ();
            paramm = new File(paramString, p(paramInt1, paramInt2, true));
            if (paramm.exists()) {
              paramm.delete();
            }
            paramString = new File(paramString, p(paramInt1, paramInt2, false));
            if (paramString.exists()) {
              paramString.delete();
            }
          }
          while ((((b.b)localObject).scene == 20) && (((b.b)localObject).type == 0))
          {
            ao.a(((b.b)localObject).scene, 1, ((b.b)localObject).jfE, ((b.b)localObject).type, 2, ((b.b)localObject).caz(), 1);
            return;
            paramm = new avi();
            paramm.scene = ((b.b)localObject).scene;
            paramm.sEb = ((b.b)localObject).bOE;
            paramm.tqP = ((b.b)localObject).qZk;
            paramm.tqQ = ((b.b)localObject).qZl;
            paramm.sFF = ((b.b)localObject).jfE;
            paramm.hQR = ((b.b)localObject).type;
            paramString = null;
            try
            {
              paramm = paramm.toByteArray();
              paramString = paramm;
            }
            catch (IOException paramm)
            {
              for (;;)
              {
                ArrayList localArrayList;
                JSONArray localJSONArray;
                continue;
                paramInt1 += 1;
              }
            }
            if (paramString != null)
            {
              au.Hx();
              paramm = new File(com.tencent.mm.model.c.FJ(), p(((b.b)localObject).scene, ((b.b)localObject).type, true));
              if (!paramm.getParentFile().exists()) {
                paramm.getParentFile().mkdirs();
              }
              if (paramm.exists()) {
                paramm.delete();
              }
              com.tencent.mm.a.e.b(paramm.getAbsolutePath(), paramString, paramString.length);
              y.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { paramm.getAbsolutePath(), Integer.valueOf(paramString.length) });
            }
            else
            {
              y.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
            }
          }
          ao.a(((b.b)localObject).scene, 1, ((b.b)localObject).jfE, ((b.b)localObject).type, 1, "", 0);
          return;
          if ((paramm instanceof w))
          {
            au.Dk().b(1134, this);
            return;
          }
          if (!(paramm instanceof e)) {
            break label838;
          }
          au.Dk().b(1161, this);
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        paramString = this.qYU.Jv();
        localArrayList = new ArrayList();
        try
        {
          paramString = new JSONObject(paramString);
          localJSONArray = paramString.optJSONArray("data");
          paramm = paramString.optString("suggestionID", "");
          paramString = null;
          paramInt1 = 0;
          if (paramInt1 < localJSONArray.length())
          {
            localObject = localJSONArray.optJSONObject(paramInt1);
            if (((JSONObject)localObject).optInt("type") != 1) {
              break;
            }
            paramString = (String)localObject;
            break;
          }
          if (paramString != null)
          {
            paramString = paramString.optJSONArray("items");
            paramInt1 = 0;
            while (paramInt1 < paramString.length())
            {
              localObject = paramString.optJSONObject(paramInt1).optString("word");
              if (!bk.bl((String)localObject)) {
                localArrayList.add(localObject);
              }
              paramInt1 += 1;
            }
          }
          paramString = paramm;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString = "";
          }
        }
        com.tencent.mm.sdk.platformtools.ai.d(new b.2(this, paramString, localArrayList));
        return;
      } while (!(paramm instanceof c));
      au.Dk().b(1866, this);
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = (c)paramm;
    if (paramString.bVm != -1) {
      h.Db(paramString.bVm).af(((cik)paramString.dmK.ecF.ecN).bOE, 0, 0);
    }
    Object localObject = new b.g((cik)paramString.dmK.ecF.ecN);
    paramm = new avj();
    paramm.pyo = ((b.g)localObject).scene;
    paramm.sEb = ((b.g)localObject).bOE;
    paramm.tqR = ((b.g)localObject).dFf;
    paramm.tqQ = ((b.g)localObject).qZl;
    paramString = null;
    try
    {
      paramm = paramm.toByteArray();
      paramString = paramm;
    }
    catch (IOException paramm)
    {
      label989:
      break label989;
    }
    if (paramString != null)
    {
      au.Hx();
      paramm = new File(com.tencent.mm.model.c.FJ(), b.g.BO(((b.g)localObject).scene));
      if (!paramm.getParentFile().exists()) {
        paramm.getParentFile().mkdirs();
      }
      if (paramm.exists()) {
        paramm.delete();
      }
      com.tencent.mm.a.e.b(paramm.getAbsolutePath(), paramString, paramString.length);
      y.i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[] { Integer.valueOf(((b.g)localObject).scene) });
    }
    for (;;)
    {
      this.qYW.put(Integer.valueOf(((b.g)localObject).scene), localObject);
      return;
      y.w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[] { Integer.valueOf(((b.g)localObject).scene) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */