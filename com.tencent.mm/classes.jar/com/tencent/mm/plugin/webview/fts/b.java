package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
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
  implements com.tencent.mm.al.g
{
  private c AOA;
  private r AOB;
  public Set<Integer> AOr;
  public l AOs;
  private HashMap<String, b> AOt;
  public v AOu;
  private Map<Integer, g> AOv;
  public b.e AOw;
  public List<com.tencent.mm.az.f> AOx;
  private com.tencent.mm.plugin.websearch.a.a.c AOy;
  com.tencent.mm.plugin.websearch.a.a.d AOz;
  public com.tencent.mm.sdk.b.c jBI;
  private long kOJ;
  
  public b()
  {
    AppMethodBeat.i(77898);
    this.AOs = new b.1(this);
    this.AOv = new HashMap();
    this.AOw = new b.e(this);
    this.jBI = new b.2(this);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.AOt = new HashMap();
    this.AOr = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
    AppMethodBeat.o(77898);
  }
  
  static String C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(77916);
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean)
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    if (new e(com.tencent.mm.plugin.record.b.apZ(), str2).exists())
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    AppMethodBeat.o(77916);
    return str1;
  }
  
  static void a(com.tencent.mm.plugin.websearch.a.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77919);
    paramd = paramd.ir(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramInt3).bq(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.AOO != 0) {
      i = paramc.AOO;
    }
    for (;;)
    {
      af.avh(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.uAe);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.AOL);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.uBr != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.uBr.toByteArray());
        label116:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.jko);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.AON);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.dtA == 2)
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
          if (paramc.AOM)
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
        break label116;
      }
    }
  }
  
  private static void a(d paramd)
  {
    AppMethodBeat.i(77910);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramd.username);
    localIntent.putExtra("Contact_Nick", paramd.nickname);
    localIntent.putExtra("Contact_Alias", paramd.eKn);
    localIntent.putExtra("Contact_Sex", paramd.evp);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramd.country, paramd.evz, paramd.evA));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.AOP);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5)
  {
    AppMethodBeat.i(187852);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("convertActivityFromTranslucent", false);
    localIntent.putExtra("customize_status_bar_color", paramInt1);
    localIntent.putExtra("status_bar_style", paramString2);
    localIntent.putExtra("from_scence", paramInt3);
    localIntent.putExtra("subtype", paramInt4);
    localIntent.putExtra("key_h5pay_cookie", paramString5);
    if (!bt.isNullOrNil(paramString3))
    {
      localIntent.putExtra("prePublishId", paramString3);
      localIntent.putExtra("KPublisherId", paramString3);
    }
    for (;;)
    {
      if (paramInt2 > 0) {
        localIntent.putExtra("pay_channel", paramInt2);
      }
      localIntent.putExtra("geta8key_scene", 65);
      localIntent.putExtra("preChatTYPE", 10);
      if (!bt.isNullOrNil(paramString4)) {
        localIntent.putExtra("srcUsername", paramString4);
      }
      com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", localIntent);
      AppMethodBeat.o(187852);
      return;
      if ((paramBundle != null) && (!bt.isNullOrNil(paramString1)))
      {
        paramString1 = paramBundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
        localIntent.putExtra("prePublishId", paramString1);
        localIntent.putExtra("KPublisherId", paramString1);
      }
    }
  }
  
  public static int b(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(77912);
    paramMap1 = aa.w(paramMap1, "data");
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
        ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap1, "", new Object[0]);
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh((String)localObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", paramMap1);
      localJSONObject.put("userName", localObject);
      localJSONObject.put("displayName", str);
      localJSONArray2.put(localJSONObject);
      i += 1;
    }
    paramMap2.put("ret", Integer.valueOf(0));
    paramMap2.put("data", localJSONArray2.toString());
    AppMethodBeat.o(77912);
    return 0;
  }
  
  private c be(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = aa.w(paramMap, "userName");
    localc.nickname = aa.w(paramMap, "nickName");
    localc.uAe = aa.w(paramMap, "headHDImgUrl");
    localc.AOL = aa.d(paramMap, "verifyFlag", 0);
    localc.signature = aa.w(paramMap, "signature");
    localc.scene = aa.d(paramMap, "scene", 0);
    localc.dtA = aa.d(paramMap, "sceneActionType", 1);
    localc.uBr = new zh();
    localc.uBr.ika = aa.d(paramMap, "brandFlag", 0);
    localc.uBr.ikd = aa.w(paramMap, "iconUrl");
    localc.uBr.ikc = aa.w(paramMap, "brandInfo");
    localc.uBr.ikb = aa.w(paramMap, "externalInfo");
    localc.jko = aa.w(paramMap, "searchId");
    localc.query = aa.w(paramMap, "query");
    localc.position = aa.d(paramMap, "position", 0);
    localc.AOM = aa.x(paramMap, "isCurrentDetailPage");
    localc.AON = aa.w(paramMap, "extraParams");
    localc.AOO = aa.d(paramMap, "friendScene", 0);
    AppMethodBeat.o(77914);
    return localc;
  }
  
  private d bf(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = aa.w(paramMap, "userName");
    locald.nickname = aa.w(paramMap, "nickName");
    locald.eKn = aa.w(paramMap, "alias");
    locald.signature = aa.w(paramMap, "signature");
    locald.evp = aa.d(paramMap, "sex", 0);
    locald.country = aa.w(paramMap, "country");
    locald.evA = aa.w(paramMap, "city");
    locald.evz = aa.w(paramMap, "province");
    locald.AOP = aa.d(paramMap, "snsFlag", 0);
    String str = aa.w(paramMap, "query");
    if (!bt.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(aa.w(paramMap, "matchType"))) {
          break label195;
        }
        locald.query = str;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77915);
      return locald;
      label195:
      locald.scene = 1;
      continue;
      locald.scene = 3;
    }
  }
  
  public static boolean bg(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = aa.w(paramMap, "word");
    boolean bool = aa.x(paramMap, "isInputChange");
    String str2 = aa.w(paramMap, "custom");
    String str3 = aa.w(paramMap, "tagList");
    paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(bt.i(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool);
    localBundle.putString("fts_key_tag_list", str3);
    try
    {
      if (paramMap.ASw != null) {
        paramMap.ASw.f(122, localBundle);
      }
      AppMethodBeat.o(77917);
      return false;
    }
    catch (RemoteException paramMap)
    {
      for (;;)
      {
        ad.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean ca(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197140);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", aa.w(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(aa.w(paramMap, "extInfo")));
      ((j)com.tencent.mm.kernel.g.ad(j.class)).enterFinderShareFeedUI(aj.getContext(), localJSONObject.toString());
      label88:
      AppMethodBeat.o(197140);
      return false;
    }
    catch (Exception paramMap)
    {
      break label88;
    }
  }
  
  private static String f(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(77922);
    switch (paramInt)
    {
    default: 
      paramMap = aa.aR(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    case 201: 
      paramMap = com.tencent.mm.plugin.websearch.b.a.aR(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    }
    paramMap = aa.f(paramMap, 1);
    AppMethodBeat.o(77922);
    return paramMap;
  }
  
  private static void o(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", 0, "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(77899);
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77899);
      return localBundle;
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.emC().ejR());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ac.ave(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = com.tencent.mm.plugin.websearch.api.ac.ave("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = aa.f(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ac.avf(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  private static void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.c.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.n.class)).zn(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localTimeLineObject.Id).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localTimeLineObject.toByteArray());
      label82:
      com.tencent.mm.bs.d.b(aj.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      AppMethodBeat.o(77909);
      return;
    }
    catch (IOException paramString2)
    {
      break label82;
    }
  }
  
  public final g Sw(int paramInt)
  {
    AppMethodBeat.i(187853);
    if (this.AOv.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.Sx(paramInt);
      if (localg != null) {
        this.AOv.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.AOv.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(187853);
    return localg;
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf)
  {
    AppMethodBeat.i(77904);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int k = bt.aGh((String)paramMap.get("actionType"));
    int m = aa.d(paramMap, "type", 0);
    Object localObject4 = (String)paramMap.get("extParams");
    String str3 = (String)paramMap.get("jumpTo");
    Object localObject3 = (String)paramMap.get("navBarColor");
    String str1 = aa.w(paramMap, "publishId");
    boolean bool = "true".equals((String)paramMap.get("hideSearchBar"));
    int n = bt.aGh((String)paramMap.get("isHomePage"));
    Object localObject5 = String.valueOf(paramMap.get("isSug"));
    Object localObject1 = (String)paramMap.get("nativeConfig");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      String str2;
      String str5;
      String str4;
      int i1;
      int i2;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("title")) {
          break label1845;
        }
        localObject1 = ((JSONObject)localObject1).optString("title");
        i = 0;
        if (!bt.isNullOrNil((String)localObject3)) {}
        localObject2 = null;
      }
      catch (JSONException localJSONException)
      {
        try
        {
          i = Color.parseColor((String)localObject3);
          str2 = (String)paramMap.get("statusBarStyle");
          str5 = (String)paramMap.get("tagId");
          localObject3 = (String)paramMap.get("sessionId");
          str4 = (String)paramMap.get("srcUserName");
          i1 = aa.d(paramMap, "scene", 0);
          i2 = aa.d(paramMap, "subType", 0);
          switch (k)
          {
          case 4: 
          case 6: 
          default: 
            AppMethodBeat.o(77904);
            return false;
          }
        }
        catch (IllegalArgumentException paramMap)
        {
          ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
          AppMethodBeat.o(77904);
          return true;
        }
        localJSONException = localJSONException;
        ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localJSONException, "", new Object[0]);
      }
      Object localObject2;
      continue;
      switch (m)
      {
      default: 
        paramMap = aa.w(paramMap, "jumpUrl");
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
        paramf = paramf.eqt();
        if (!bt.isNullOrNil(paramMap))
        {
          com.tencent.mm.plugin.webview.modeltools.g.emC();
          a(paramMap, paramf, i, str2, str1, 0, str4, i1, i2, "");
        }
        break;
      case 8: 
        aa.w(paramMap, "snsid");
        paramf = aa.w(paramMap, "objectXmlDesc");
        localObject2 = aa.w(paramMap, "userName");
        bool = aa.x(paramMap, "fromMusicItem");
        com.tencent.mm.plugin.webview.modeltools.g.emC();
        z(paramf, (String)localObject2, bool);
        break;
      case 1: 
        a(be(paramMap), false);
        break;
      case 32: 
        a(bf(paramMap));
        continue;
        localObject2 = aa.w(paramMap, "query");
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("word", localObject2);
          ((JSONObject)localObject3).put("id", String.valueOf(System.currentTimeMillis()));
          ((JSONObject)localObject3).put("timestamp", String.valueOf(System.currentTimeMillis()));
          ((JSONObject)localObject3).put("showType", 1);
          ((JSONObject)localObject3).put("jumpUrl", aa.w(paramMap, "jumpUrl"));
          label668:
          ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory((String)localObject2 + "​1", ((JSONObject)localObject3).toString());
          paramMap = aa.w(paramMap, "jumpUrl");
          ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
          paramf = paramf.eqt();
          if (bt.isNullOrNil(paramMap)) {
            continue;
          }
          com.tencent.mm.plugin.webview.modeltools.g.emC();
          a(paramMap, paramf, i, str2, str1, 0, str4, i1, i2, "");
          continue;
          str4 = aa.w(paramMap, "query");
          String str6 = aa.w(paramMap, "searchId");
          paramf = new Intent();
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
          paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
          paramf.putExtra("neverGetA8Key", true);
          paramf.putExtra("key_load_js_without_delay", true);
          paramf.putExtra("ftsQuery", str4);
          paramf.putExtra("ftsType", m);
          paramf.putExtra("customize_status_bar_color", i);
          paramf.putExtra("status_bar_style", str2);
          paramf.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str3));
          paramf.putExtra("KPublisherId", str1);
          paramf.putExtra("ftsbizscene", i1);
          if (localObject2 != null) {
            paramf.putExtra("title", (String)localObject2);
          }
          label942:
          int i3;
          if (aa.d(paramMap, "isWeAppMore", 0) == 1)
          {
            j = 1;
            i3 = aa.d(paramMap, "tabPageType", 0);
            if (j == 0) {
              break label1179;
            }
            localObject2 = com.tencent.mm.plugin.websearch.b.a.a(i1, false, m, (String)localObject4);
            ((Map)localObject2).put("query", str4);
            ((Map)localObject2).put("searchId", str6);
            ((Map)localObject2).put("subType", String.valueOf(i2));
            ((Map)localObject2).put("isWeAppMore", String.valueOf(aa.d(paramMap, "isWeAppMore", 0)));
            paramMap = com.tencent.mm.modelappbrand.b.atH();
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("subSessionId", paramMap);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aR((Map)localObject2));
            paramf.putExtra("ftsbizscene", i1);
            paramf.putExtra("customize_status_bar_color", i);
            paramf.putExtra("status_bar_style", str2);
            paramf.putExtra("sessionId", paramMap);
            if (bool) {
              break label1173;
            }
          }
          label1173:
          for (bool = true;; bool = false)
          {
            paramf.putExtra("ftscaneditable", bool);
            com.tencent.mm.bs.d.b(aj.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramf);
            break;
            j = 0;
            break label942;
          }
          label1179:
          paramMap = aa.a(i1, false, m, (String)localObject4);
          paramMap.put("query", str4);
          paramMap.put("searchId", str6);
          paramMap.put("isHomePage", String.valueOf(n));
          paramMap.put("isSug", localObject5);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramMap.put("sessionId", localObject3);
            paramf.putExtra("sessionId", (String)localObject3);
          }
          str1 = aa.RY(i1);
          paramMap.put("subSessionId", str1);
          paramf.putExtra("subSessionId", str1);
          paramf.putExtra("rawUrl", f(i1, paramMap));
          paramf.putExtra("ftsQuery", str4);
          paramf.putExtra("customize_status_bar_color", i);
          paramf.putExtra("status_bar_style", str2);
          paramf.putExtra("tabId", str5);
          paramf.putExtra("key_load_js_without_delay", true);
          if (k == 7) {
            paramf.putExtra("ftsneedkeyboard", true);
          }
          if (i3 == 1)
          {
            paramf.putExtra("ftscaneditable", false);
            aa.a(aj.getContext(), str4, paramf, (String)localObject2, (String)localObject4, str6, (String)localObject3, str1);
            AppMethodBeat.o(77904);
            return false;
          }
          if ((i1 == 20) || (i1 == 22) || (i1 == 33) || (i1 == 3) || (i1 == 36))
          {
            paramf.putExtra("ftsInitToSearch", true);
            paramf.putExtra("hideSearchInput", bool);
          }
          for (paramMap = ".ui.tools.fts.FTSSOSHomeWebViewUI"; !TextUtils.isEmpty(paramMap); paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI")
          {
            com.tencent.mm.bs.d.b(aj.getContext(), "webview", paramMap, paramf);
            break;
          }
          paramf = aa.w(paramMap, "query");
          i = aa.d(paramMap, "topStoryScene", 0);
          int j = aa.d(paramMap, "tagId", 0);
          str1 = aa.w(paramMap, "navigationId");
          paramMap = (Map<String, Object>)localObject3;
          if (bt.isNullOrNil((String)localObject3)) {
            paramMap = aa.RY(i);
          }
          localObject3 = String.valueOf(System.currentTimeMillis());
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("scene", "21");
          ((HashMap)localObject5).put("query", paramf);
          ((HashMap)localObject5).put("extParams", localObject4);
          ((HashMap)localObject5).put("sessionId", paramMap);
          ((HashMap)localObject5).put("subSessionId", paramMap);
          ((HashMap)localObject5).put("requestId", localObject3);
          ((HashMap)localObject5).put("pRequestId", localObject3);
          ((HashMap)localObject5).put("seq", localObject3);
          ((HashMap)localObject5).put("navigationId", str1);
          ((HashMap)localObject5).put("channelId", String.valueOf(j));
          localObject4 = new dcn();
          ((dcn)localObject4).qwV = com.tencent.mm.plugin.topstory.ui.d.dOl();
          ((dcn)localObject4).scene = i;
          ((dcn)localObject4).jko = "";
          ((dcn)localObject4).dcm = paramf;
          ((dcn)localObject4).sessionId = paramMap;
          ((dcn)localObject4).dtw = paramMap;
          ((dcn)localObject4).EtU = 2;
          ((dcn)localObject4).url = h.k((HashMap)localObject5);
          ((dcn)localObject4).EtV = ((String)localObject2);
          ((dcn)localObject4).cJR = j;
          ((dcn)localObject4).dnB = ((String)localObject3);
          ((dcn)localObject4).AGg = str1;
          ((dcn)localObject4).qGK = aa.cWN();
          paramMap = new xp();
          paramMap.key = "rec_category";
          paramMap.CZi = j;
          paramMap.CZj = String.valueOf(j);
          ((dcn)localObject4).AFX.add(paramMap);
          com.tencent.mm.plugin.topstory.ui.d.a(aj.getContext(), (dcn)localObject4, (String)localObject3);
        }
        catch (Exception localException)
        {
          break label668;
        }
        label1845:
        localObject2 = null;
      }
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(77905);
    this.AOw.yLV = true;
    boolean bool1 = aa.x(paramMap, "isTeachPage");
    boolean bool2 = aa.x(paramMap, "isMoreButton");
    int j;
    int i;
    label62:
    String str3;
    String str1;
    String str4;
    int m;
    String str2;
    int k;
    if (aa.d(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (aa.d(paramMap, "isWeAppMore", 0) != 1) {
        break label192;
      }
      i = 1;
      str3 = aa.w(paramMap, "srcUserName");
      str1 = aa.w(paramMap, "sessionId");
      str4 = (String)paramMap.get("navBarColor");
      m = aa.d(paramMap, "subType", 0);
      str2 = aa.w(paramMap, "searchPlaceHolder");
      k = 0;
      if (bt.isNullOrNil(str4)) {}
    }
    for (;;)
    {
      try
      {
        k = Color.parseColor(str4);
        str4 = (String)paramMap.get("statusBarStyle");
        if (j == 0) {
          break label232;
        }
        paramString = aa.w(paramMap, "jumpUrl");
        paramMap = null;
        if (paramf != null) {
          paramMap = paramf.eqt();
        }
        com.tencent.mm.plugin.webview.modeltools.g.emC();
        o(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label192:
        ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label62;
      label232:
      j = aa.d(paramMap, "type", 0);
      int n = aa.d(paramMap, "opType", 0);
      if (n > 0)
      {
        switch (n)
        {
        default: 
          break;
        case 2: 
          a(be(paramMap), bool1);
          break;
        case 3: 
          paramMap = be(paramMap);
          if (!com.tencent.mm.model.w.sD(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          af.avh(paramMap.username);
          paramf = new Intent();
          paramf.putExtra("Chat_User", paramMap.username);
          paramf.putExtra("finish_direct", true);
          paramf.putExtra("key_temp_session_show_type", 0);
          paramf.putExtra("preChatTYPE", 9);
          com.tencent.mm.bs.d.e(aj.getContext(), ".ui.chatting.ChattingUI", paramf);
          break;
        case 4: 
          paramString = aa.w(paramMap, "jumpUrl");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eqt();
          }
          com.tencent.mm.plugin.webview.modeltools.g.emC();
          o(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str4 = aa.w(paramMap, "query");
        k = aa.d(paramMap, "scene", 0);
        str3 = aa.w(paramMap, "searchId");
        paramf = new Intent();
        paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
        paramf.putExtra("neverGetA8Key", true);
        paramf.putExtra("key_load_js_without_delay", true);
        paramf.putExtra("ftsQuery", str4);
        paramf.putExtra("ftsType", j);
        paramf.putExtra("sessionId", str1);
        if (i != 0)
        {
          paramString = com.tencent.mm.plugin.websearch.b.a.a(k, false, j, paramString);
          try
          {
            paramString.put("query", p.encode(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(m));
            paramString.put("isWeAppMore", String.valueOf(aa.d(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.atH();
            paramString.put("sessionId", paramMap);
            str1 = aa.RY(bt.aGh((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramf.putExtra("subSessionId", str1);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aR(paramString));
            paramf.putExtra("ftsbizscene", k);
            paramf.putExtra("key_search_place_holder", str2);
            com.tencent.mm.bs.d.b(aj.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramf);
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
            paramMap.put("query", p.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = aa.RY(bt.aGh((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramf.putExtra("subSessionId", paramString);
            paramf.putExtra("rawUrl", f(k, paramMap));
            paramf.putExtra("key_session_id", str1);
            paramf.putExtra("searchId", str3);
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", paramMap, paramf);
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
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = aa.w(paramMap, "jumpUrl");
          str1 = aa.w(paramMap, "publishId");
          i = aa.d(paramMap, "payScene", 0);
          j = aa.d(paramMap, "scene", 0);
          ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          str2 = aa.w(paramMap, "cookie");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eqt();
          }
          if (!bt.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.emC();
            a(paramString, paramMap, k, str4, str1, i, str3, j, m, str2);
          }
          break;
        case 8: 
          aa.w(paramMap, "snsid");
          paramf = aa.w(paramMap, "objectXmlDesc");
          paramString = aa.w(paramMap, "userName");
          bool1 = aa.x(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.emC();
          z(paramf, paramString, bool1);
          break;
        case 1: 
          a(be(paramMap), false);
          break;
        case 32: 
          a(bf(paramMap));
        }
      }
    }
  }
  
  public final boolean ba(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (aa.d(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (ae.AGP == null) {
        ae.ehZ();
      }
      ae.AGP.mAL.clear();
      paramMap = aj.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = ae.bdo();
        localObject2 = Base64.encodeToString(ae.AGP.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        ad.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = aa.d(paramMap, "type", 0);
      int j = aa.d(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.kOJ > 1000L)
      {
        this.kOJ = System.currentTimeMillis();
        if (!aa.Sa(0))
        {
          ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          ak.K(i, j, com.tencent.mm.plugin.websearch.api.ac.avf("searchID"));
          paramMap = aa.ehS();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", aa.aR(aa.f(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(aa.d(paramMap, "webview_instance_id", -1));
          i = aa.d(paramMap, "scene", 0);
          paramMap = aa.w(paramMap, "query");
          if ((i != 20) || (bt.isNullOrNil(paramMap)))
          {
            ad.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw.f(136, (Bundle)localObject2);
              }
            }
            catch (Exception paramMap)
            {
              ad.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final boolean bb(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = aa.d(paramMap, "scene", 0);
    int k = aa.d(paramMap, "type", 0);
    int m = aa.d(paramMap, "requestType", 0);
    int j = bt.i(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    boolean bool = aa.x(paramMap, "ignoreCache");
    Object localObject1;
    if (m == 0)
    {
      paramMap = C(i, k, true);
      if (this.AOt.get(paramMap) == null)
      {
        localObject1 = new b((byte)0);
        ((b)localObject1).is(i, k);
        this.AOt.put(paramMap, localObject1);
      }
      paramMap = (b)this.AOt.get(paramMap);
      if ((!bt.isNullOrNil(paramMap.dlu)) && (!bool))
      {
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", new Object[] { Integer.valueOf(j), paramMap.dlu });
        if ((paramMap.scene != 20) || (paramMap.type != 0) || ((!paramMap.AOK) && (paramMap.isAvailable()))) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).e(m, paramMap.dlu, 1, str);
        }
      }
      if ((paramMap.isAvailable()) && (!bool))
      {
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", new Object[] { Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.AOI), Long.valueOf(paramMap.AOJ), Integer.valueOf(paramMap.type), paramMap.dlu });
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          ak.a(paramMap.scene, 0, paramMap.oEK, paramMap.type, 2, paramMap.ejS(), 1);
        }
        for (;;)
        {
          AppMethodBeat.o(77902);
          return false;
          ak.a(paramMap.scene, 0, paramMap.oEK, paramMap.type, 1, "", 0);
        }
      }
      com.tencent.mm.kernel.g.aeS().a(1048, this);
      ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[] { Integer.valueOf(j) });
      paramMap = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
      long l = com.tencent.mm.plugin.websearch.api.ac.ave("discoverSearchEntry").optLong("guideParam");
      this.AOu = new v(i, k, aa.Sb(0), j, paramMap, l, str);
      com.tencent.mm.kernel.g.aeS().a(this.AOu, 0);
      AppMethodBeat.o(77902);
      return false;
    }
    paramMap = af.eib();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        i = paramMap.mAL.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject2 = (bsd)paramMap.mAL.get(i);
          if (!com.tencent.mm.model.w.sD(((bsd)localObject2).Username)) {
            break label751;
          }
          localObject2 = com.tencent.mm.am.f.ei(((bsd)localObject2).Username);
          if (localObject2 == null) {
            break label751;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.api.c)localObject2).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.api.c)localObject2).field_username);
          localJSONObject2.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(((com.tencent.mm.api.c)localObject2).field_username));
          localJSONArray2.put(localJSONObject2);
          break label751;
        }
        localJSONObject1.put("items", localJSONArray2);
        localJSONObject1.put("type", 5);
        localJSONObject1.put("title", "");
        localJSONArray1.put(localJSONObject1);
        ((JSONObject)localObject1).put("data", localJSONArray1);
        paramMap = ((JSONObject)localObject1).toString();
        ad.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(j).e(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label751:
      i -= 1;
    }
  }
  
  public final boolean bc(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = aa.d(paramMap, "scene", 201);
    int i = bt.i(paramMap.get("webview_instance_id"), -1);
    Object localObject = Sw(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf;
    String str;
    if (localObject != null)
    {
      localf = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i);
      str = ((g)localObject).dlu;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localf.q(str, 1, i, ((g)localObject).AOR);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.g.aeS().a(1866, this);
        localObject = new d(paramMap, j, 0);
        if (paramMap != null) {
          ((d)localObject).dtt = aa.d(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean bd(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    ckd localckd = new ckd();
    localckd.Eff = aa.w(paramMap, "logString");
    com.tencent.mm.kernel.g.aeS().a(1134, this);
    paramMap = new com.tencent.mm.plugin.websearch.api.w(localckd);
    com.tencent.mm.kernel.g.aeS().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bh(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77918);
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    final int j = bt.aGh((String)paramMap.get("offset"));
    final int k = bt.aGh((String)paramMap.get("count"));
    final int m = bt.i(paramMap.get("webview_instance_id"), -1);
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
      if (this.AOz.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.AOy == null) {
        this.AOy = new com.tencent.mm.plugin.websearch.a.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.a.a.d(str, (List)localObject);
      if (this.AOz == null) {}
    }
    this.AOz = paramMap;
    this.AOy.a(paramMap, new c.a()
    {
      public final void eis()
      {
        AppMethodBeat.i(77889);
        b.a(b.this.AOz, j, k, m);
        AppMethodBeat.o(77889);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.AOz.dcq) {
        a(this.AOz, j, k, m);
      }
    }
  }
  
  public final boolean bi(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = aa.w(paramMap, "md5");
    int i = aa.d(paramMap, "offset", 0);
    String str2 = aa.w(paramMap, "searchId");
    String str3 = aa.w(paramMap, "sessionId");
    int j = aa.d(paramMap, "tab", 0);
    String str4 = aa.w(paramMap, "requestId");
    int k = aa.d(paramMap, "scene", 0);
    int m = aa.d(paramMap, "webview_instance_id", -1);
    String str5 = aa.w(paramMap, "emojiUrl");
    paramMap = aa.w(paramMap, "aesKey");
    if (this.AOA != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.AOA);
      com.tencent.mm.kernel.g.aeS().b(2999, this);
    }
    com.tencent.mm.kernel.g.aeS().a(2999, this);
    this.AOA = new c(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.AOA.dtt = m;
    com.tencent.mm.kernel.g.aeS().a(this.AOA, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final boolean bj(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77921);
    String str1 = aa.w(paramMap, "requestId");
    String str2 = aa.w(paramMap, "commReq");
    int i = aa.d(paramMap, "webview_instance_id", -1);
    if (this.AOB != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.AOB);
      com.tencent.mm.kernel.g.aeS().b(2975, this);
    }
    com.tencent.mm.kernel.g.aeS().a(2975, this);
    this.AOB = new r(str1, str2, i);
    com.tencent.mm.kernel.g.aeS().a(this.AOB, 0);
    AppMethodBeat.o(77921);
    return false;
  }
  
  public final String ejR()
  {
    AppMethodBeat.i(77901);
    Object localObject = C(20, 0, true);
    if (this.AOt.get(localObject) == null)
    {
      b localb = new b((byte)0);
      localb.is(20, 0);
      this.AOt.put(localObject, localb);
    }
    localObject = (b)this.AOt.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).dlu; bt.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(77901);
      return "";
    }
    AppMethodBeat.o(77901);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(77913);
    Object localObject1;
    if ((paramn instanceof v))
    {
      com.tencent.mm.kernel.g.aeS().b(1048, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (v)paramn;
      localObject1 = new b((byte)0);
      ((b)localObject1).scene = paramString.scene;
      ((b)localObject1).AOI = paramString.AGm.DLG;
      ((b)localObject1).dlu = paramString.AGm.DLy;
      ((b)localObject1).AOJ = (System.currentTimeMillis() / 1000L);
      ((b)localObject1).oEK = paramString.AGm.DLH;
      ((b)localObject1).type = paramString.businessType;
      paramn = C(((b)localObject1).scene, ((b)localObject1).type, true);
      ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { ((b)localObject1).dlu });
      if (!bt.isNullOrNil(((b)localObject1).dlu))
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.dtt).e(0, ((b)localObject1).dlu, 0, paramString.dnB);
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { ((b)localObject1).dlu });
      }
      this.AOt.put(paramn, localObject1);
      if (((b)localObject1).AOI == 0L)
      {
        paramInt1 = ((b)localObject1).scene;
        paramInt2 = ((b)localObject1).type;
        ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = com.tencent.mm.plugin.record.b.apZ();
        paramn = new e(paramString, C(paramInt1, paramInt2, true));
        if (paramn.exists()) {
          paramn.delete();
        }
        paramString = new e(paramString, C(paramInt1, paramInt2, false));
        if (paramString.exists()) {
          paramString.delete();
        }
      }
      while ((((b)localObject1).scene == 20) && (((b)localObject1).type == 0))
      {
        ak.a(((b)localObject1).scene, 1, ((b)localObject1).oEK, ((b)localObject1).type, 2, ((b)localObject1).ejS(), 1);
        AppMethodBeat.o(77913);
        return;
        paramn = new boe();
        paramn.scene = ((b)localObject1).scene;
        paramn.DLy = ((b)localObject1).dlu;
        paramn.DLz = ((b)localObject1).AOI;
        paramn.DLA = ((b)localObject1).AOJ;
        paramn.CNs = ((b)localObject1).oEK;
        paramn.mBH = ((b)localObject1).type;
        paramString = null;
        try
        {
          paramn = paramn.toByteArray();
          paramString = paramn;
        }
        catch (IOException paramn)
        {
          label490:
          Object localObject2;
          Bundle localBundle;
          break label490;
        }
        if (paramString != null)
        {
          paramn = new e(com.tencent.mm.plugin.record.b.apZ(), C(((b)localObject1).scene, ((b)localObject1).type, true));
          if (!paramn.fhT().exists()) {
            paramn.fhT().mkdirs();
          }
          if (paramn.exists()) {
            paramn.delete();
          }
          i.f(com.tencent.mm.vfs.q.B(paramn.fhU()), paramString, paramString.length);
          ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(paramn.fhU()), Integer.valueOf(paramString.length) });
        }
        else
        {
          ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
        }
      }
      ak.a(((b)localObject1).scene, 1, ((b)localObject1).oEK, ((b)localObject1).type, 1, "", 0);
      AppMethodBeat.o(77913);
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.w))
      {
        com.tencent.mm.kernel.g.aeS().b(1134, this);
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof d))
      {
        com.tencent.mm.kernel.g.aeS().b(1866, this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(77913);
          return;
        }
        paramString = (d)paramn;
        if (paramString.dtt != -1) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.dtt).q(((dqd)paramString.rr.gUT.gUX).dlu, 0, 0, 0);
        }
        if (paramString.AOT != null) {
          this.AOv.put(Integer.valueOf(paramString.AOT.scene), paramString.AOT);
        }
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof c))
      {
        com.tencent.mm.kernel.g.aeS().b(2999, this);
        localObject1 = (c)paramn;
        paramn = bt.by(((c)localObject1).AOS.DLy, "");
        if (((c)localObject1).dtt != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(((c)localObject1).dtt);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("fts_key_json_data", paramn);
          ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
          ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw.f(152, (Bundle)localObject2);
            }
            AppMethodBeat.o(77913);
            return;
          }
          catch (Exception paramString) {}
        }
        AppMethodBeat.o(77913);
        return;
      }
      if (paramn.equals(this.AOB))
      {
        com.tencent.mm.kernel.g.aeS().b(2975, this);
        paramn = bt.by(((dsj)this.AOB.rr.gUT.gUX).EGU, "");
        if (this.AOB.dtt != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.AOB.dtt);
          localObject2 = this.AOB.dnB;
          localBundle = new Bundle();
          localBundle.putString("fts_key_id", (String)localObject2);
          localBundle.putString("fts_key_json_data", paramn);
          localBundle.putString("fts_key_err_msg", paramString);
          localBundle.putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ASw.f(153, localBundle);
            }
            AppMethodBeat.o(77913);
            return;
          }
          catch (Exception paramString) {}
        }
      }
      AppMethodBeat.o(77913);
      return;
    }
  }
  
  final class b
  {
    long AOI;
    long AOJ;
    boolean AOK = false;
    String dlu;
    private String jXt = null;
    String oEK;
    int scene;
    int type;
    
    private b() {}
    
    final String ejS()
    {
      AppMethodBeat.i(77892);
      if (this.jXt == null) {
        this.jXt = "";
      }
      try
      {
        localObject = new JSONObject(this.dlu).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.jXt = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.jXt;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final void is(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      boe localboe = new boe();
      Object localObject1 = com.tencent.mm.plugin.record.b.apZ();
      Object localObject2 = b.C(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(b.C(paramInt1, paramInt2, true))) {
        this.AOK = true;
      }
      localObject1 = new e((String)localObject1, (String)localObject2);
      localObject2 = i.aR(com.tencent.mm.vfs.q.B(((e)localObject1).fhU()), 0, (int)((e)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localboe.parseFrom((byte[])localObject2);
          this.scene = localboe.scene;
          this.dlu = localboe.DLy;
          this.AOI = localboe.DLz;
          this.AOJ = localboe.DLA;
          this.oEK = localboe.CNs;
          this.type = localboe.mBH;
          ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(((e)localObject1).fhU()), Integer.valueOf(localObject2.length) });
          AppMethodBeat.o(77893);
          return;
        }
        catch (IOException localIOException) {}
      }
      AppMethodBeat.o(77893);
    }
    
    final boolean isAvailable()
    {
      AppMethodBeat.i(77891);
      if (this.AOK)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((bt.isNullOrNil(this.dlu)) || (System.currentTimeMillis() / 1000L - this.AOJ > this.AOI))
      {
        AppMethodBeat.o(77891);
        return false;
      }
      AppMethodBeat.o(77891);
      return true;
    }
  }
  
  final class c
  {
    public int AOL;
    public boolean AOM;
    public String AON;
    public int AOO;
    public int dtA;
    public String jko;
    public String nickname;
    public int position;
    public String query;
    public int scene;
    public String signature;
    public String uAe;
    public zh uBr;
    public String username;
    
    private c() {}
  }
  
  final class d
  {
    public int AOP;
    public String country;
    public String eKn;
    public String evA;
    public int evp;
    public String evz;
    public String nickname;
    public String query;
    public int scene;
    public String signature;
    public String username;
    
    private d() {}
  }
  
  static final class g
  {
    public long AOJ;
    public int AOR;
    public String dlu;
    public long interval;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.dlu = "";
      this.interval = 0L;
      this.AOJ = 0L;
      this.AOR = 0;
    }
    
    public g(int paramInt1, dqd paramdqd, int paramInt2)
    {
      AppMethodBeat.i(187850);
      this.scene = 0;
      this.dlu = "";
      this.interval = 0L;
      this.AOJ = 0L;
      this.AOR = 0;
      this.scene = paramInt1;
      this.dlu = paramdqd.dlu;
      this.interval = paramdqd.fWw;
      this.AOJ = (System.currentTimeMillis() / 1000L);
      this.AOR = paramInt2;
      AppMethodBeat.o(187850);
    }
    
    /* Error */
    public static g Sx(int paramInt)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 64	com/tencent/mm/vfs/e
      //   8: dup
      //   9: invokestatic 70	com/tencent/mm/plugin/record/b:apZ	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 74	com/tencent/mm/plugin/webview/fts/b$g:Sy	(I)Ljava/lang/String;
      //   16: invokespecial 77	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 81	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
      //   24: invokestatic 87	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual 90	com/tencent/mm/vfs/e:length	()J
      //   32: l2i
      //   33: invokestatic 96	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
      //   36: astore_1
      //   37: new 98	com/tencent/mm/protocal/protobuf/bof
      //   40: dup
      //   41: invokespecial 99	com/tencent/mm/protocal/protobuf/bof:<init>	()V
      //   44: astore_2
      //   45: aload_2
      //   46: aload_1
      //   47: invokevirtual 103	com/tencent/mm/protocal/protobuf/bof:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   50: pop
      //   51: new 2	com/tencent/mm/plugin/webview/fts/b$g
      //   54: dup
      //   55: invokespecial 104	com/tencent/mm/plugin/webview/fts/b$g:<init>	()V
      //   58: astore_1
      //   59: aload_1
      //   60: aload_2
      //   61: getfield 107	com/tencent/mm/protocal/protobuf/bof:Scene	I
      //   64: putfield 21	com/tencent/mm/plugin/webview/fts/b$g:scene	I
      //   67: aload_1
      //   68: aload_2
      //   69: getfield 110	com/tencent/mm/protocal/protobuf/bof:DLy	Ljava/lang/String;
      //   72: putfield 25	com/tencent/mm/plugin/webview/fts/b$g:dlu	Ljava/lang/String;
      //   75: aload_1
      //   76: aload_2
      //   77: getfield 113	com/tencent/mm/protocal/protobuf/bof:DLB	J
      //   80: putfield 27	com/tencent/mm/plugin/webview/fts/b$g:interval	J
      //   83: aload_1
      //   84: aload_2
      //   85: getfield 116	com/tencent/mm/protocal/protobuf/bof:DLA	J
      //   88: putfield 29	com/tencent/mm/plugin/webview/fts/b$g:AOJ	J
      //   91: aload_1
      //   92: aload_2
      //   93: getfield 119	com/tencent/mm/protocal/protobuf/bof:DLC	I
      //   96: putfield 31	com/tencent/mm/plugin/webview/fts/b$g:AOR	I
      //   99: ldc 62
      //   101: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: aload_1
      //   105: areturn
      //   106: astore_1
      //   107: aconst_null
      //   108: astore_1
      //   109: goto -10 -> 99
      //   112: astore_2
      //   113: goto -14 -> 99
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	116	0	paramInt	int
      //   19	86	1	localObject1	Object
      //   106	1	1	localException1	Exception
      //   108	1	1	localObject2	Object
      //   44	49	2	localbof	com.tencent.mm.protocal.protobuf.bof
      //   112	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   37	59	106	java/lang/Exception
      //   59	99	112	java/lang/Exception
    }
    
    static String Sy(int paramInt)
    {
      AppMethodBeat.i(77896);
      String str = com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext());
      str = "SearchGuide_" + paramInt + "-" + str;
      AppMethodBeat.o(77896);
      return str;
    }
    
    public final boolean isExpired()
    {
      AppMethodBeat.i(77897);
      if (this.AOJ + this.interval <= System.currentTimeMillis() / 1000L)
      {
        AppMethodBeat.o(77897);
        return true;
      }
      AppMethodBeat.o(77897);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b
 * JD-Core Version:    0.7.0.1
 */