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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gc.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements com.tencent.mm.ai.f
{
  public com.tencent.mm.sdk.b.c hCe;
  private long iod;
  com.tencent.mm.plugin.fts.a.a.a mSV;
  private l pym;
  f uOA;
  public v uOB;
  private Map<Integer, b.g> uOC;
  public b.e uOD;
  public List<com.tencent.mm.aw.e> uOE;
  private com.tencent.mm.plugin.websearch.c.a.c uOF;
  com.tencent.mm.plugin.websearch.c.a.d uOG;
  private c uOH;
  public Set<Integer> uOx;
  public l uOy;
  private HashMap<String, b.b> uOz;
  
  public b()
  {
    AppMethodBeat.i(5689);
    this.uOy = new b.1(this);
    this.uOC = new HashMap();
    this.uOD = new b.e(this);
    this.hCe = new b.3(this);
    this.pym = new b.4(this);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.uOz = new HashMap();
    this.uOx = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(5689);
  }
  
  static void a(com.tencent.mm.plugin.websearch.c.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5710);
    paramd = paramd.gG(paramInt1, paramInt2);
    h.KW(paramInt3).aU(paramd);
    AppMethodBeat.o(5710);
  }
  
  private static void a(b.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(5702);
    int i;
    if (paramc.uOW != 0) {
      i = paramc.uOW;
    }
    for (;;)
    {
      ai.agy(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.pyu);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.uOT);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.pzI != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.pzI.toByteArray());
        label117:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.hng);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.uOV);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.bq.d.b(ah.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(5702);
        return;
        if (paramc.cDa == 2)
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
          if (paramc.uOU)
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
        break label117;
      }
    }
  }
  
  private static void a(b.d paramd)
  {
    AppMethodBeat.i(5701);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramd.username);
    localIntent.putExtra("Contact_Nick", paramd.nickname);
    localIntent.putExtra("Contact_Alias", paramd.dCJ);
    localIntent.putExtra("Contact_Sex", paramd.dqC);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(paramd.country, paramd.province, paramd.city));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.uOX);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.bq.d.b(ah.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(5701);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(5699);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("convertActivityFromTranslucent", false);
    localIntent.putExtra("customize_status_bar_color", paramInt1);
    localIntent.putExtra("status_bar_style", paramString2);
    if (!bo.isNullOrNil(paramString3))
    {
      localIntent.putExtra("prePublishId", paramString3);
      localIntent.putExtra("KPublisherId", paramString3);
    }
    for (;;)
    {
      if (paramInt2 > 0) {
        localIntent.putExtra("pay_channel", paramInt2);
      }
      localIntent.putExtra("preChatTYPE", 10);
      com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(5699);
      return;
      if ((paramBundle != null) && (!bo.isNullOrNil(paramString1)))
      {
        paramString1 = paramBundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.w(paramString1.getBytes());
        localIntent.putExtra("prePublishId", paramString1);
        localIntent.putExtra("KPublisherId", paramString1);
      }
    }
  }
  
  private b.d aA(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(5706);
    b.d locald = new b.d(this, (byte)0);
    locald.username = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "userName");
    locald.nickname = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "nickName");
    locald.dCJ = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "alias");
    locald.signature = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "signature");
    locald.dqC = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sex", 0);
    locald.country = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "country");
    locald.city = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "city");
    locald.province = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "province");
    locald.uOX = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "snsFlag", 0);
    String str = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    if (!bo.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "matchType"))) {
          break label195;
        }
        locald.query = str;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5706);
      return locald;
      label195:
      locald.scene = 1;
      continue;
      locald.scene = 3;
    }
  }
  
  public static boolean aB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5708);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "word");
    boolean bool = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isInputChange");
    String str2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "custom");
    String str3 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "tagList");
    paramMap = h.KW(bo.f(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool);
    localBundle.putString("fts_key_tag_list", str3);
    try
    {
      if (paramMap.uWu != null) {
        paramMap.uWu.e(122, localBundle);
      }
      AppMethodBeat.o(5708);
      return false;
    }
    catch (RemoteException paramMap)
    {
      for (;;)
      {
        ab.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
      }
    }
  }
  
  private b.c az(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5705);
    b.c localc = new b.c(this, (byte)0);
    localc.username = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "userName");
    localc.nickname = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "nickName");
    localc.pyu = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "headHDImgUrl");
    localc.uOT = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "verifyFlag", 0);
    localc.signature = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "signature");
    localc.scene = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
    localc.cDa = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sceneActionType", 1);
    localc.pzI = new wc();
    localc.pzI.gxd = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "brandFlag", 0);
    localc.pzI.gxg = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "iconUrl");
    localc.pzI.gxf = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "brandInfo");
    localc.pzI.gxe = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "externalInfo");
    localc.hng = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
    localc.query = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    localc.position = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "position", 0);
    localc.uOU = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isCurrentDetailPage");
    localc.uOV = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "extraParams");
    localc.uOW = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "friendScene", 0);
    AppMethodBeat.o(5705);
    return localc;
  }
  
  public static int c(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(5703);
    paramMap1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap1, "data");
    for (;;)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(paramMap1);
        localJSONArray2 = new JSONArray();
        i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        localObject = localJSONArray1.getJSONObject(i);
        if (!((JSONObject)localObject).has("id")) {
          continue;
        }
        paramMap1 = ((JSONObject)localObject).getString("id");
      }
      catch (JSONException paramMap1)
      {
        JSONArray localJSONArray2;
        int i;
        String str;
        JSONObject localJSONObject;
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap1, "", new Object[0]);
        continue;
        paramMap1 = "";
        continue;
        Object localObject = "";
        continue;
      }
      if (!((JSONObject)localObject).has("userName")) {
        continue;
      }
      localObject = ((JSONObject)localObject).getString("userName");
      str = com.tencent.mm.model.s.nE((String)localObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", paramMap1);
      localJSONObject.put("userName", localObject);
      localJSONObject.put("displayName", str);
      localJSONArray2.put(localJSONObject);
      i += 1;
    }
    paramMap2.put("ret", Integer.valueOf(0));
    paramMap2.put("data", localJSONArray2.toString());
    AppMethodBeat.o(5703);
    return 0;
  }
  
  private static void o(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(5698);
    a(paramString, paramBundle, 0, "", "", 0);
    AppMethodBeat.o(5698);
  }
  
  public static Bundle s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(5690);
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5690);
      return localBundle;
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.dcB().day());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", ac.agv(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = ac.agv("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = com.tencent.mm.plugin.websearch.api.aa.d(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", ac.agw(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  static String s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(5707);
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean)
    {
      AppMethodBeat.o(5707);
      return str2;
    }
    if (new File(com.tencent.mm.plugin.record.b.YN(), str2).exists())
    {
      AppMethodBeat.o(5707);
      return str2;
    }
    AppMethodBeat.o(5707);
    return str1;
  }
  
  private static void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(5700);
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.m.class)).uA(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localTimeLineObject.Id).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localTimeLineObject.toByteArray());
      label82:
      com.tencent.mm.bq.d.b(ah.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      AppMethodBeat.o(5700);
      return;
    }
    catch (IOException paramString2)
    {
      break label82;
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg)
  {
    AppMethodBeat.i(5695);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int k = bo.apV((String)paramMap.get("actionType"));
    int m = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
    Object localObject3 = (String)paramMap.get("extParams");
    String str3 = (String)paramMap.get("jumpTo");
    String str1 = (String)paramMap.get("navBarColor");
    String str2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "publishId");
    boolean bool = "true".equals((String)paramMap.get("hideSearchBar"));
    int n = bo.apV((String)paramMap.get("isHomePage"));
    Object localObject4 = String.valueOf(paramMap.get("isSug"));
    Object localObject1 = (String)paramMap.get("nativeConfig");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      String str4;
      String str7;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("title")) {
          break label1751;
        }
        localObject1 = ((JSONObject)localObject1).optString("title");
        i = 0;
        if (!bo.isNullOrNil(str1)) {}
        localObject2 = null;
      }
      catch (JSONException localJSONException)
      {
        try
        {
          i = Color.parseColor(str1);
          str4 = (String)paramMap.get("statusBarStyle");
          str7 = (String)paramMap.get("tagId");
          str1 = (String)paramMap.get("sessionId");
          switch (k)
          {
          case 4: 
          case 6: 
          default: 
            AppMethodBeat.o(5695);
            return false;
          }
        }
        catch (IllegalArgumentException paramMap)
        {
          ab.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
          AppMethodBeat.o(5695);
          return true;
        }
        localJSONException = localJSONException;
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localJSONException, "", new Object[0]);
      }
      Object localObject2;
      continue;
      switch (m)
      {
      default: 
        paramMap = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "jumpUrl");
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
        paramg = paramg.dgL();
        if (!bo.isNullOrNil(paramMap))
        {
          com.tencent.mm.plugin.webview.modeltools.g.dcB();
          a(paramMap, paramg, i, str4, str2, 0);
        }
        break;
      case 8: 
        com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "snsid");
        paramg = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "objectXmlDesc");
        localObject2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "userName");
        bool = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "fromMusicItem");
        com.tencent.mm.plugin.webview.modeltools.g.dcB();
        z(paramg, (String)localObject2, bool);
        break;
      case 1: 
        a(az(paramMap), false);
        break;
      case 32: 
        a(aA(paramMap));
        continue;
        paramMap = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "jumpUrl");
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
        paramg = paramg.dgL();
        if (!bo.isNullOrNil(paramMap))
        {
          com.tencent.mm.plugin.webview.modeltools.g.dcB();
          a(paramMap, paramg, i, str4, str2, 0);
          continue;
          String str5 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
          int i1 = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
          String str6 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
          paramg = new Intent();
          paramg.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
          paramg.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
          paramg.putExtra("neverGetA8Key", true);
          paramg.putExtra("key_load_js_without_delay", true);
          paramg.putExtra("ftsQuery", str5);
          paramg.putExtra("ftsType", m);
          paramg.putExtra("customize_status_bar_color", i);
          paramg.putExtra("status_bar_style", str4);
          paramg.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str3));
          paramg.putExtra("KPublisherId", str2);
          paramg.putExtra("ftsbizscene", i1);
          if (localObject2 != null) {
            paramg.putExtra("title", (String)localObject2);
          }
          if (!r.aNU())
          {
            paramMap = com.tencent.mm.bd.a.cE(i1, m);
            paramMap.put("query", str5);
            paramMap.put("searchId", str6);
            paramg.putExtra("rawUrl", com.tencent.mm.bd.a.b(i1, paramMap));
            if ((i1 == 20) || (i1 == 22) || (i1 == 33)) {}
            for (paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";; paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI")
            {
              com.tencent.mm.bq.d.b(ah.getContext(), "webview", paramMap, paramg);
              break;
            }
          }
          if (com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0) == 1) {}
          int i2;
          for (int j = 1;; j = 0)
          {
            i2 = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "tabPageType", 0);
            if (j == 0) {
              break label1090;
            }
            localObject2 = r.a(i1, false, m, (String)localObject3);
            ((Map)localObject2).put("query", str5);
            ((Map)localObject2).put("searchId", str6);
            ((Map)localObject2).put("subType", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0)));
            ((Map)localObject2).put("isWeAppMore", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0)));
            paramMap = com.tencent.mm.modelappbrand.b.ach();
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("subSessionId", paramMap);
            paramg.putExtra("key_session_id", paramMap);
            paramg.putExtra("rawUrl", r.F((Map)localObject2));
            paramg.putExtra("ftsbizscene", i1);
            paramg.putExtra("customize_status_bar_color", i);
            paramg.putExtra("status_bar_style", str4);
            paramg.putExtra("sessionId", paramMap);
            com.tencent.mm.bq.d.b(ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramg);
            break;
          }
          label1090:
          paramMap = com.tencent.mm.plugin.websearch.api.aa.a(i1, false, m, (String)localObject3);
          paramMap.put("query", str5);
          paramMap.put("searchId", str6);
          paramMap.put("isHomePage", String.valueOf(n));
          paramMap.put("isSug", localObject4);
          if (!TextUtils.isEmpty(str1))
          {
            paramMap.put("sessionId", str1);
            paramg.putExtra("sessionId", str1);
          }
          str2 = com.tencent.mm.plugin.websearch.api.aa.IZ(i1);
          paramMap.put("subSessionId", str2);
          paramg.putExtra("subSessionId", str2);
          paramg.putExtra("rawUrl", com.tencent.mm.bd.a.b(i1, paramMap));
          paramg.putExtra("ftsQuery", str5);
          paramg.putExtra("customize_status_bar_color", i);
          paramg.putExtra("status_bar_style", str4);
          paramg.putExtra("tabId", str7);
          paramg.putExtra("key_load_js_without_delay", true);
          if (k == 7) {
            paramg.putExtra("ftsneedkeyboard", true);
          }
          if (i2 == 1)
          {
            paramg.putExtra("ftscaneditable", false);
            com.tencent.mm.plugin.websearch.api.aa.a(ah.getContext(), str5, paramg, (String)localObject2, (String)localObject3, str6, str1, str2);
            AppMethodBeat.o(5695);
            return false;
          }
          if ((i1 == 20) || (i1 == 22) || (i1 == 33) || (i1 == 3) || (i1 == 36))
          {
            paramg.putExtra("ftsInitToSearch", true);
            paramg.putExtra("hideSearchInput", bool);
          }
          for (paramMap = ".ui.tools.fts.FTSSOSHomeWebViewUI";; paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI")
          {
            if (TextUtils.isEmpty(paramMap)) {
              break label1414;
            }
            com.tencent.mm.bq.d.b(ah.getContext(), "webview", paramMap, paramg);
            break;
          }
          label1414:
          continue;
          paramg = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
          i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "topStoryScene", 0);
          j = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "tagId", 0);
          str2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "navigationId");
          paramMap = str1;
          if (bo.isNullOrNil(str1)) {
            paramMap = com.tencent.mm.plugin.websearch.api.aa.IZ(i);
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
          localObject3 = new cko();
          ((cko)localObject3).xUt = com.tencent.mm.plugin.topstory.ui.d.cII();
          ((cko)localObject3).scene = i;
          ((cko)localObject3).hng = "";
          ((cko)localObject3).cnv = paramg;
          ((cko)localObject3).cpW = paramMap;
          ((cko)localObject3).cCW = paramMap;
          ((cko)localObject3).xUv = 2;
          ((cko)localObject3).url = com.tencent.mm.plugin.topstory.a.g.o((HashMap)localObject4);
          ((cko)localObject3).xUw = ((String)localObject2);
          ((cko)localObject3).bWu = j;
          ((cko)localObject3).ohe = str1;
          ((cko)localObject3).uIX = str2;
          ((cko)localObject3).xUx = com.tencent.mm.plugin.websearch.api.aa.bXn();
          paramMap = new up();
          paramMap.key = "rec_category";
          paramMap.wMM = j;
          paramMap.wMN = String.valueOf(j);
          ((cko)localObject3).uIO.add(paramMap);
          com.tencent.mm.plugin.topstory.ui.d.a(ah.getContext(), (cko)localObject3, str1);
          continue;
          label1751:
          localObject2 = null;
        }
        break;
      }
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg, String paramString)
  {
    AppMethodBeat.i(5696);
    this.uOD.tfn = true;
    boolean bool1 = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isTeachPage");
    boolean bool2 = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isMoreButton");
    int j;
    int i;
    label62:
    String str1;
    String str3;
    String str2;
    int k;
    if (com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0) != 1) {
        break label173;
      }
      i = 1;
      str1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sessionId");
      str3 = (String)paramMap.get("navBarColor");
      str2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchPlaceHolder");
      k = 0;
      if (bo.isNullOrNil(str3)) {}
    }
    for (;;)
    {
      try
      {
        k = Color.parseColor(str3);
        str3 = (String)paramMap.get("statusBarStyle");
        if (j == 0) {
          break label213;
        }
        paramString = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "jumpUrl");
        paramMap = null;
        if (paramg != null) {
          paramMap = paramg.dgL();
        }
        com.tencent.mm.plugin.webview.modeltools.g.dcB();
        o(paramString, paramMap);
        AppMethodBeat.o(5696);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label173:
        ab.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(5696);
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label62;
      label213:
      j = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
      int m = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "opType", 0);
      if (m > 0)
      {
        switch (m)
        {
        default: 
          break;
        case 2: 
          a(az(paramMap), bool1);
          break;
        case 3: 
          paramMap = az(paramMap);
          if (!t.nT(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          ai.agy(paramMap.username);
          paramg = new Intent();
          paramg.putExtra("Chat_User", paramMap.username);
          paramg.putExtra("finish_direct", true);
          paramg.putExtra("key_temp_session_show_type", 0);
          paramg.putExtra("preChatTYPE", 9);
          com.tencent.mm.bq.d.f(ah.getContext(), ".ui.chatting.ChattingUI", paramg);
          break;
        case 4: 
          paramString = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "jumpUrl");
          paramMap = null;
          if (paramg != null) {
            paramMap = paramg.dgL();
          }
          com.tencent.mm.plugin.webview.modeltools.g.dcB();
          o(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        String str4 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
        k = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
        str3 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
        paramg = new Intent();
        paramg.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
        paramg.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
        paramg.putExtra("neverGetA8Key", true);
        paramg.putExtra("key_load_js_without_delay", true);
        paramg.putExtra("ftsQuery", str4);
        paramg.putExtra("ftsType", j);
        paramg.putExtra("sessionId", str1);
        if (!r.aNU())
        {
          paramMap = com.tencent.mm.bd.a.cE(k, j);
          try
          {
            paramMap.put("query", q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = com.tencent.mm.plugin.websearch.api.aa.IZ(bo.apV((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramg.putExtra("subSessionId", paramString);
            paramg.putExtra("key_session_id", str1);
            paramg.putExtra("rawUrl", com.tencent.mm.bd.a.b(k, paramMap));
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.bq.d.b(ah.getContext(), "webview", paramMap, paramg);
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
          paramString = r.a(k, false, j, paramString);
          try
          {
            paramString.put("query", q.encode(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0)));
            paramString.put("isWeAppMore", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.ach();
            paramString.put("sessionId", paramMap);
            str1 = com.tencent.mm.plugin.websearch.api.aa.IZ(bo.apV((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramg.putExtra("subSessionId", str1);
            paramg.putExtra("key_session_id", paramMap);
            paramg.putExtra("rawUrl", r.F(paramString));
            paramg.putExtra("ftsbizscene", k);
            paramg.putExtra("key_search_place_holder", str2);
            com.tencent.mm.bq.d.b(ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramg);
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
          paramMap = com.tencent.mm.plugin.websearch.api.aa.a(k, false, j, paramString);
          try
          {
            paramMap.put("query", q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = com.tencent.mm.plugin.websearch.api.aa.IZ(bo.apV((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramg.putExtra("subSessionId", paramString);
            paramg.putExtra("rawUrl", com.tencent.mm.bd.a.b(k, paramMap));
            paramg.putExtra("key_session_id", str1);
            paramg.putExtra("searchId", str3);
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.bq.d.b(ah.getContext(), "webview", paramMap, paramg);
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
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "jumpUrl");
          str1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "publishId");
          i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "payScene", 0);
          ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          paramMap = null;
          if (paramg != null) {
            paramMap = paramg.dgL();
          }
          if (!bo.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.dcB();
            a(paramString, paramMap, k, str3, str1, i);
          }
          break;
        case 8: 
          com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "snsid");
          paramg = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "objectXmlDesc");
          paramString = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "userName");
          bool1 = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.dcB();
          z(paramg, paramString, bool1);
          break;
        case 1: 
          a(az(paramMap), false);
          break;
        case 32: 
          a(aA(paramMap));
        }
      }
    }
  }
  
  public final boolean aC(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5709);
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    int j = bo.apV((String)paramMap.get("offset"));
    int k = bo.apV((String)paramMap.get("count"));
    int m = bo.f(paramMap.get("webview_instance_id"), -1);
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
      if (this.uOG.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.uOF == null) {
        this.uOF = new com.tencent.mm.plugin.websearch.c.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.c.a.d(str, (List)localObject);
      if (this.uOG == null) {}
    }
    this.uOG = paramMap;
    this.uOF.a(paramMap, new b.5(this, j, k, m));
    for (;;)
    {
      AppMethodBeat.o(5709);
      return false;
      label243:
      if (this.uOG.cnz) {
        a(this.uOG, j, k, m);
      }
    }
  }
  
  public final boolean aD(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(153072);
    String str1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "md5");
    int i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "offset", 0);
    String str2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
    String str3 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sessionId");
    int j = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "tab", 0);
    String str4 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "requestId");
    int k = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
    int m = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "webview_instance_id", -1);
    String str5 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "emojiUrl");
    paramMap = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "aesKey");
    if (this.uOH != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.uOH);
      com.tencent.mm.kernel.g.Rc().b(2999, this);
    }
    com.tencent.mm.kernel.g.Rc().a(2999, this);
    this.uOH = new c(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.uOH.cCT = m;
    com.tencent.mm.kernel.g.Rc().a(this.uOH, 0);
    AppMethodBeat.o(153072);
    return false;
  }
  
  public final boolean av(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5691);
    switch (com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5691);
      return false;
      if (af.uJF == null) {
        af.cZw();
      }
      af.uJF.jJv.clear();
      paramMap = ah.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = af.cZx();
        localObject2 = Base64.encodeToString(af.uJF.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        ab.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
      int j = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.iod > 1000L)
      {
        this.iod = System.currentTimeMillis();
        if (!com.tencent.mm.plugin.websearch.api.aa.Je(0))
        {
          ab.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          an.A(i, j, ac.agw("searchID"));
          paramMap = com.tencent.mm.plugin.websearch.api.aa.cZp();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.aa.F(com.tencent.mm.plugin.websearch.api.aa.d(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = h.KW(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "webview_instance_id", -1));
          i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
          paramMap = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
          if ((i != 20) || (bo.isNullOrNil(paramMap)))
          {
            ab.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu.e(136, (Bundle)localObject2);
              }
            }
            catch (Exception paramMap)
            {
              ab.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final boolean aw(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5693);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
    int k = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
    int m = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "requestType", 0);
    int j = bo.f(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    boolean bool = com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "ignoreCache");
    Object localObject1;
    if (m == 0)
    {
      paramMap = s(i, k, true);
      if (this.uOz.get(paramMap) == null)
      {
        localObject1 = new b.b(this, (byte)0);
        ((b.b)localObject1).gH(i, k);
        this.uOz.put(paramMap, localObject1);
      }
      paramMap = (b.b)this.uOz.get(paramMap);
      if ((!bo.isNullOrNil(paramMap.cvV)) && (!bool))
      {
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", new Object[] { Integer.valueOf(j), paramMap.cvV });
        if ((paramMap.scene != 20) || (paramMap.type != 0) || ((!paramMap.fOq) && (paramMap.isAvailable()))) {
          h.KW(j).d(m, paramMap.cvV, 1, str);
        }
      }
      if ((paramMap.isAvailable()) && (!bool))
      {
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", new Object[] { Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.uOR), Long.valueOf(paramMap.uOS), Integer.valueOf(paramMap.type), paramMap.cvV });
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          an.a(paramMap.scene, 0, paramMap.low, paramMap.type, 2, paramMap.daz(), 1);
        }
        for (;;)
        {
          AppMethodBeat.o(5693);
          return false;
          an.a(paramMap.scene, 0, paramMap.low, paramMap.type, 1, "", 0);
        }
      }
      com.tencent.mm.kernel.g.Rc().a(1048, this);
      ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[] { Integer.valueOf(j) });
      paramMap = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
      long l = ac.agv("discoverSearchEntry").optLong("guideParam");
      this.uOB = new v(i, k, com.tencent.mm.plugin.websearch.api.aa.Jf(0), j, paramMap, l, str);
      com.tencent.mm.kernel.g.Rc().a(this.uOB, 0);
      AppMethodBeat.o(5693);
      return false;
    }
    paramMap = ai.cZA();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        i = paramMap.jJv.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject2 = (bfh)paramMap.jJv.get(i);
          if (!t.nT(((bfh)localObject2).Username)) {
            break label740;
          }
          localObject2 = com.tencent.mm.aj.f.rS(((bfh)localObject2).Username);
          if (localObject2 == null) {
            break label740;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.aj.d)localObject2).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.aj.d)localObject2).field_username);
          localJSONObject2.put("nickName", com.tencent.mm.model.s.nE(((com.tencent.mm.aj.d)localObject2).field_username));
          localJSONArray2.put(localJSONObject2);
          break label740;
        }
        localJSONObject1.put("items", localJSONArray2);
        localJSONObject1.put("type", 5);
        localJSONObject1.put("title", "");
        localJSONArray1.put(localJSONObject1);
        ((JSONObject)localObject1).put("data", localJSONArray1);
        paramMap = ((JSONObject)localObject1).toString();
        ab.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        h.KW(j).d(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label740:
      i -= 1;
    }
  }
  
  public final boolean ax(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(5694);
    int i = bo.f(paramMap.get("webview_instance_id"), -1);
    if (this.uOC.get(Integer.valueOf(201)) == null)
    {
      localObject = b.g.daA();
      if (localObject != null) {
        this.uOC.put(Integer.valueOf(201), localObject);
      }
    }
    Object localObject = (b.g)this.uOC.get(Integer.valueOf(201));
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg;
    String str;
    if (localObject != null)
    {
      localg = h.KW(i);
      str = ((b.g)localObject).cvV;
      if (!((b.g)localObject).isExpired()) {
        break label196;
      }
    }
    label196:
    for (i = 1;; i = 0)
    {
      localg.n(str, 1, i, ((b.g)localObject).uOZ);
      bool = ((b.g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.g.Rc().a(1866, this);
        localObject = new d(paramMap, 0);
        if (paramMap != null) {
          ((d)localObject).cCT = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      }
      AppMethodBeat.o(5694);
      return false;
    }
  }
  
  public final boolean ay(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5697);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    buo localbuo = new buo();
    localbuo.xHP = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "logString");
    com.tencent.mm.kernel.g.Rc().a(1134, this);
    paramMap = new w(localbuo);
    com.tencent.mm.kernel.g.Rc().a(paramMap, 0);
    AppMethodBeat.o(5697);
    return false;
  }
  
  public final String day()
  {
    AppMethodBeat.i(5692);
    Object localObject = s(20, 0, true);
    if (this.uOz.get(localObject) == null)
    {
      b.b localb = new b.b(this, (byte)0);
      localb.gH(20, 0);
      this.uOz.put(localObject, localb);
    }
    localObject = (b.b)this.uOz.get(localObject);
    if (((b.b)localObject).isAvailable()) {}
    for (localObject = ((b.b)localObject).cvV; bo.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(5692);
      return "";
    }
    AppMethodBeat.o(5692);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(5704);
    Object localObject1;
    if ((paramm instanceof v))
    {
      com.tencent.mm.kernel.g.Rc().b(1048, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(5704);
        return;
      }
      paramString = (v)paramm;
      localObject1 = new b.b(this, (byte)0);
      ((b.b)localObject1).scene = paramString.scene;
      ((b.b)localObject1).uOR = paramString.uJb.xqW;
      ((b.b)localObject1).cvV = paramString.uJb.wAa;
      ((b.b)localObject1).uOS = (System.currentTimeMillis() / 1000L);
      ((b.b)localObject1).low = paramString.uJb.xqX;
      ((b.b)localObject1).type = paramString.businessType;
      paramm = s(((b.b)localObject1).scene, ((b.b)localObject1).type, true);
      ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { ((b.b)localObject1).cvV });
      if (!bo.isNullOrNil(((b.b)localObject1).cvV))
      {
        h.KW(paramString.cCT).d(0, ((b.b)localObject1).cvV, 0, paramString.ohe);
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { ((b.b)localObject1).cvV });
      }
      this.uOz.put(paramm, localObject1);
      if (((b.b)localObject1).uOR == 0L)
      {
        paramInt1 = ((b.b)localObject1).scene;
        paramInt2 = ((b.b)localObject1).type;
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = com.tencent.mm.plugin.record.b.YN();
        paramm = new File(paramString, s(paramInt1, paramInt2, true));
        if (paramm.exists()) {
          paramm.delete();
        }
        paramString = new File(paramString, s(paramInt1, paramInt2, false));
        if (paramString.exists()) {
          paramString.delete();
        }
      }
      while ((((b.b)localObject1).scene == 20) && (((b.b)localObject1).type == 0))
      {
        an.a(((b.b)localObject1).scene, 1, ((b.b)localObject1).low, ((b.b)localObject1).type, 2, ((b.b)localObject1).daz(), 1);
        AppMethodBeat.o(5704);
        return;
        paramm = new bbt();
        paramm.scene = ((b.b)localObject1).scene;
        paramm.wAa = ((b.b)localObject1).cvV;
        paramm.xqP = ((b.b)localObject1).uOR;
        paramm.xqQ = ((b.b)localObject1).uOS;
        paramm.wBZ = ((b.b)localObject1).low;
        paramm.jKs = ((b.b)localObject1).type;
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
            Object localObject2;
            JSONArray localJSONArray;
            continue;
            paramInt1 += 1;
          }
        }
        if (paramString != null)
        {
          paramm = new File(com.tencent.mm.plugin.record.b.YN(), s(((b.b)localObject1).scene, ((b.b)localObject1).type, true));
          if (!paramm.getParentFile().exists()) {
            paramm.getParentFile().mkdirs();
          }
          if (paramm.exists()) {
            paramm.delete();
          }
          com.tencent.mm.a.e.b(paramm.getAbsolutePath(), paramString, paramString.length);
          ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { paramm.getAbsolutePath(), Integer.valueOf(paramString.length) });
        }
        else
        {
          ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
        }
      }
      an.a(((b.b)localObject1).scene, 1, ((b.b)localObject1).low, ((b.b)localObject1).type, 1, "", 0);
      AppMethodBeat.o(5704);
    }
    else
    {
      if ((paramm instanceof w))
      {
        com.tencent.mm.kernel.g.Rc().b(1134, this);
        AppMethodBeat.o(5704);
        return;
      }
      if ((paramm instanceof f))
      {
        com.tencent.mm.kernel.g.Rc().b(1161, this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(5704);
          return;
        }
        paramString = this.uOA.act();
        localObject2 = new ArrayList();
        try
        {
          paramString = new JSONObject(paramString);
          localJSONArray = paramString.optJSONArray("data");
          paramm = paramString.optString("suggestionID", "");
          paramString = null;
          paramInt1 = 0;
          if (paramInt1 < localJSONArray.length())
          {
            localObject1 = localJSONArray.optJSONObject(paramInt1);
            if (((JSONObject)localObject1).optInt("type") != 1) {
              break label1148;
            }
            paramString = (String)localObject1;
            break label1148;
          }
          if (paramString != null)
          {
            paramString = paramString.optJSONArray("items");
            paramInt1 = i;
            while (paramInt1 < paramString.length())
            {
              localObject1 = paramString.optJSONObject(paramInt1).optString("word");
              if (!bo.isNullOrNil((String)localObject1)) {
                ((ArrayList)localObject2).add(localObject1);
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
        al.d(new b.2(this, paramString, (ArrayList)localObject2));
        AppMethodBeat.o(5704);
      }
      else
      {
        if ((paramm instanceof d))
        {
          com.tencent.mm.kernel.g.Rc().b(1866, this);
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(5704);
            return;
          }
          paramString = (d)paramm;
          if (paramString.cCT != -1) {
            h.KW(paramString.cCT).n(((cvw)paramString.rr.fsW.fta).cvV, 0, 0, 0);
          }
          if (paramString.uPb != null) {
            this.uOC.put(Integer.valueOf(paramString.uPb.scene), paramString.uPb);
          }
          AppMethodBeat.o(5704);
          return;
        }
        if ((paramm instanceof c))
        {
          com.tencent.mm.kernel.g.Rc().b(2999, this);
          localObject1 = (c)paramm;
          localObject2 = ((c)localObject1).uPa;
          paramm = bo.bf(((cct)localObject2).wAa, "");
          ((cct)localObject2).getBaseResponse();
          ((cct)localObject2).getBaseResponse();
          if (((c)localObject1).cCT != -1)
          {
            localObject1 = h.KW(((c)localObject1).cCT);
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_json_data", paramm);
            ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
            ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu.e(152, (Bundle)localObject2);
              }
              AppMethodBeat.o(5704);
              return;
            }
            catch (Exception paramString) {}
          }
        }
        AppMethodBeat.o(5704);
        return;
      }
    }
  }
  
  public final Bundle r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(153071);
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
    case 1: 
    case 3: 
    case 5: 
    case 6: 
      for (;;)
      {
        AppMethodBeat.o(153071);
        return null;
        int i = paramBundle.getInt("webview_id");
        this.uOx.remove(Integer.valueOf(i));
        paramBundle = this.uOD;
        if (!paramBundle.edo)
        {
          paramInt = 1;
          label92:
          if ((paramInt == 0) || (bo.isNullOrNil(paramBundle.query))) {
            break label220;
          }
          ab.v("MicroMsg.WebSearch.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", new Object[] { Boolean.valueOf(paramBundle.edo), paramBundle.query, Boolean.valueOf(paramBundle.cnz), Boolean.valueOf(paramBundle.tfn), Integer.valueOf(paramBundle.lox) });
          an.a(paramBundle.scene, paramBundle.query, paramBundle.tfn, paramBundle.cnz, paramBundle.lox);
          paramBundle.edo = true;
        }
        for (;;)
        {
          ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "activity destroy %d", new Object[] { Integer.valueOf(i) });
          break;
          paramInt = 0;
          break label92;
          label220:
          ab.v("MicroMsg.WebSearch.FTSWebViewLogic", "can not report %s", new Object[] { paramBundle.query });
        }
        if (this.mSV != null) {
          ((n)com.tencent.mm.kernel.g.G(n.class)).cancelSearchTask(this.mSV);
        }
        localObject = new i();
        ((i)localObject).query = paramBundle.getString("query");
        ((i)localObject).mSR = paramBundle.getInt("count");
        ((i)localObject).mSU = this.pym;
        ((i)localObject).mSS.add("notifymessage");
        this.mSV = ((n)com.tencent.mm.kernel.g.G(n.class)).search(8, (i)localObject);
        this.mSV.mRQ = Integer.valueOf(paramBundle.getInt("webview_id"));
        localObject = new com.tencent.mm.plugin.websearch.api.s();
        ((com.tencent.mm.plugin.websearch.api.s)localObject).scene = paramBundle.getInt("scene");
        ((com.tencent.mm.plugin.websearch.api.s)localObject).cnv = paramBundle.getString("query");
        ((com.tencent.mm.plugin.websearch.api.s)localObject).uIE = 1;
        ((com.tencent.mm.plugin.websearch.api.s)localObject).cCT = paramBundle.getInt("webview_id");
        if (this.uOA != null) {
          com.tencent.mm.kernel.g.Rc().a(this.uOA);
        }
        this.uOA = new f((com.tencent.mm.plugin.websearch.api.s)localObject);
        com.tencent.mm.kernel.g.Rc().a(1161, this);
        com.tencent.mm.kernel.g.Rc().a(this.uOA, 0);
        continue;
        paramBundle = paramBundle.getString("history");
        ((n)com.tencent.mm.kernel.g.G(n.class)).deleteSOSHistory(paramBundle);
        continue;
        paramBundle = paramBundle.getString("reportString");
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramBundle });
        localObject = new buo();
        ((buo)localObject).xHP = paramBundle;
        paramBundle = new w((buo)localObject);
        com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
      }
    }
    Object localObject = new gc();
    ((gc)localObject).cuC.coO = 3;
    ((gc)localObject).cuC.cqq = paramBundle.getString("md5");
    ((gc)localObject).cuC.cuE = paramBundle.getString("designerId");
    ((gc)localObject).cuC.aeskey = paramBundle.getString("aeskey");
    ((gc)localObject).cuC.cuF = paramBundle.getString("encryptUrl");
    ((gc)localObject).cuC.cqx = paramBundle.getString("productId");
    ((gc)localObject).cuC.name = paramBundle.getString("name");
    ((gc)localObject).cuC.thumbUrl = paramBundle.getString("thumbUrl");
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "GENERATE_EMOJI_PATH %s", new Object[] { ((gc)localObject).cuD.path });
    paramBundle = new Bundle();
    paramBundle.putString("emojiPath", ((gc)localObject).cuD.path);
    AppMethodBeat.o(153071);
    return paramBundle;
  }
  
  public final class a
    implements Runnable
  {
    public String data;
    public boolean uOQ;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(5681);
      ArrayList localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(this.data);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = ((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.m.class)).uA(localJSONArray.getString(i));
          com.tencent.mm.kernel.g.RM();
          localObject = com.tencent.mm.aw.g.a(com.tencent.mm.kernel.g.RL().eHR, (TimeLineObject)localObject, 9);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
        if (!this.uOQ) {
          break label133;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
        AppMethodBeat.o(5681);
        return;
      }
      if (b.this.uOE == null)
      {
        label133:
        b.this.uOE = localException;
        AppMethodBeat.o(5681);
        return;
      }
      b.this.uOE.addAll(localException);
      AppMethodBeat.o(5681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */