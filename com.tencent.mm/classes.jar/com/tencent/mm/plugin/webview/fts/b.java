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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  public Set<Integer> CgJ;
  public com.tencent.mm.plugin.fts.a.l CgK;
  private HashMap<String, b> CgL;
  public u CgM;
  private Map<Integer, g> CgN;
  public b.e CgO;
  public List<com.tencent.mm.ay.f> CgP;
  private com.tencent.mm.plugin.websearch.a.a.c CgQ;
  com.tencent.mm.plugin.websearch.a.a.d CgR;
  private c CgS;
  public com.tencent.mm.sdk.b.c kce;
  private long lqi;
  
  public b()
  {
    AppMethodBeat.i(77898);
    this.CgK = new b.1(this);
    this.CgN = new HashMap();
    this.CgO = new b.e(this);
    this.kce = new b.2(this);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.CgL = new HashMap();
    this.CgJ = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.sdk.b.a.GpY.c(this.kce);
    AppMethodBeat.o(77898);
  }
  
  static String B(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(77916);
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = com.tencent.mm.sdk.platformtools.ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean)
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    if (new e(com.tencent.mm.plugin.record.b.awO(), str2).exists())
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
    paramd = paramd.iG(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramInt3).bv(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.Che != 0) {
      i = paramc.Che;
    }
    for (;;)
    {
      ad.aAy(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.vIX);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.Chb);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.vKk != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.vKk.toByteArray());
        label116:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.jKB);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.Chd);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.drj == 2)
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
          if (paramc.Chc)
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
    localIntent.putExtra("Contact_Alias", paramd.eNf);
    localIntent.putExtra("Contact_Sex", paramd.exL);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramd.country, paramd.exV, paramd.exW));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.Chf);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5)
  {
    AppMethodBeat.i(188277);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("convertActivityFromTranslucent", false);
    localIntent.putExtra("customize_status_bar_color", paramInt1);
    localIntent.putExtra("status_bar_style", paramString2);
    localIntent.putExtra("from_scence", paramInt3);
    localIntent.putExtra("subtype", paramInt4);
    localIntent.putExtra("key_h5pay_cookie", paramString5);
    if (!bs.isNullOrNil(paramString3))
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
      if (!bs.isNullOrNil(paramString4)) {
        localIntent.putExtra("srcUsername", paramString4);
      }
      com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", localIntent);
      AppMethodBeat.o(188277);
      return;
      if ((paramBundle != null) && (!bs.isNullOrNil(paramString1)))
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
    paramMap1 = z.x(paramMap1, "data");
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap1, "", new Object[0]);
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk((String)localObject);
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
  
  private c bi(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = z.x(paramMap, "userName");
    localc.nickname = z.x(paramMap, "nickName");
    localc.vIX = z.x(paramMap, "headHDImgUrl");
    localc.Chb = z.d(paramMap, "verifyFlag", 0);
    localc.signature = z.x(paramMap, "signature");
    localc.scene = z.d(paramMap, "scene", 0);
    localc.drj = z.d(paramMap, "sceneActionType", 1);
    localc.vKk = new aaf();
    localc.vKk.iKh = z.d(paramMap, "brandFlag", 0);
    localc.vKk.iKk = z.x(paramMap, "iconUrl");
    localc.vKk.iKj = z.x(paramMap, "brandInfo");
    localc.vKk.iKi = z.x(paramMap, "externalInfo");
    localc.jKB = z.x(paramMap, "searchId");
    localc.query = z.x(paramMap, "query");
    localc.position = z.d(paramMap, "position", 0);
    localc.Chc = z.y(paramMap, "isCurrentDetailPage");
    localc.Chd = z.x(paramMap, "extraParams");
    localc.Che = z.d(paramMap, "friendScene", 0);
    AppMethodBeat.o(77914);
    return localc;
  }
  
  private d bj(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = z.x(paramMap, "userName");
    locald.nickname = z.x(paramMap, "nickName");
    locald.eNf = z.x(paramMap, "alias");
    locald.signature = z.x(paramMap, "signature");
    locald.exL = z.d(paramMap, "sex", 0);
    locald.country = z.x(paramMap, "country");
    locald.exW = z.x(paramMap, "city");
    locald.exV = z.x(paramMap, "province");
    locald.Chf = z.d(paramMap, "snsFlag", 0);
    String str = z.x(paramMap, "query");
    if (!bs.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(z.x(paramMap, "matchType"))) {
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
  
  public static boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = z.x(paramMap, "word");
    boolean bool1 = z.y(paramMap, "isInputChange");
    String str2 = z.x(paramMap, "custom");
    String str3 = z.x(paramMap, "tagList");
    boolean bool2 = z.y(paramMap, "cache");
    paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(bs.l(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool1);
    localBundle.putString("fts_key_tag_list", str3);
    localBundle.putBoolean("fts_key_cache", bool2);
    try
    {
      if (paramMap.CkJ != null) {
        paramMap.CkJ.g(122, localBundle);
      }
      AppMethodBeat.o(77917);
      return false;
    }
    catch (RemoteException paramMap)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bo(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(188279);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", z.x(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(z.x(paramMap, "extInfo")));
      ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderShareFeedUI(com.tencent.mm.sdk.platformtools.ai.getContext(), localJSONObject.toString());
      label88:
      AppMethodBeat.o(188279);
      return false;
    }
    catch (Exception paramMap)
    {
      break label88;
    }
  }
  
  private static String g(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(77922);
    switch (paramInt)
    {
    default: 
      paramMap = z.aV(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    case 201: 
      paramMap = com.tencent.mm.plugin.websearch.b.a.aV(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    }
    paramMap = z.f(paramMap, 1);
    AppMethodBeat.o(77922);
    return paramMap;
  }
  
  private static void o(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", 0, "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle t(int paramInt, Bundle paramBundle)
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
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.eBX().ezm());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ab.aAv(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = com.tencent.mm.plugin.websearch.api.ab.aAv("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = z.f(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ab.aAw(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  private static void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).Ds(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localTimeLineObject.Id).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localTimeLineObject.toByteArray());
      label82:
      com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      AppMethodBeat.o(77909);
      return;
    }
    catch (IOException paramString2)
    {
      break label82;
    }
  }
  
  public final g UE(int paramInt)
  {
    AppMethodBeat.i(188278);
    if (this.CgN.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.UF(paramInt);
      if (localg != null) {
        this.CgN.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.CgN.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(188278);
    return localg;
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf)
  {
    AppMethodBeat.i(77904);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int k = bs.aLy((String)paramMap.get("actionType"));
    int m = z.d(paramMap, "type", 0);
    Object localObject4 = (String)paramMap.get("extParams");
    String str3 = (String)paramMap.get("jumpTo");
    Object localObject3 = (String)paramMap.get("navBarColor");
    String str1 = z.x(paramMap, "publishId");
    boolean bool = "true".equals((String)paramMap.get("hideSearchBar"));
    int n = bs.aLy((String)paramMap.get("isHomePage"));
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
          break label1854;
        }
        localObject1 = ((JSONObject)localObject1).optString("title");
        i = 0;
        if (!bs.isNullOrNil((String)localObject3)) {}
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
          i1 = z.d(paramMap, "scene", 0);
          i2 = z.d(paramMap, "subType", 0);
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
          AppMethodBeat.o(77904);
          return true;
        }
        localJSONException = localJSONException;
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localJSONException, "", new Object[0]);
      }
      Object localObject2;
      continue;
      switch (m)
      {
      default: 
        paramMap = z.x(paramMap, "jumpUrl");
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
        paramf = paramf.eFN();
        if (!bs.isNullOrNil(paramMap))
        {
          com.tencent.mm.plugin.webview.modeltools.g.eBX();
          a(paramMap, paramf, i, str2, str1, 0, str4, i1, i2, "");
        }
        break;
      case 8: 
        z.x(paramMap, "snsid");
        paramf = z.x(paramMap, "objectXmlDesc");
        localObject2 = z.x(paramMap, "userName");
        bool = z.y(paramMap, "fromMusicItem");
        com.tencent.mm.plugin.webview.modeltools.g.eBX();
        z(paramf, (String)localObject2, bool);
        break;
      case 1: 
        a(bi(paramMap), false);
        break;
      case 32: 
        a(bj(paramMap));
        continue;
        localObject2 = z.x(paramMap, "query");
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("word", localObject2);
          ((JSONObject)localObject3).put("id", String.valueOf(System.currentTimeMillis()));
          ((JSONObject)localObject3).put("timestamp", String.valueOf(System.currentTimeMillis()));
          ((JSONObject)localObject3).put("showType", 1);
          ((JSONObject)localObject3).put("jumpUrl", z.x(paramMap, "jumpUrl"));
          label668:
          ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory((String)localObject2 + "​1", ((JSONObject)localObject3).toString());
          paramMap = z.x(paramMap, "jumpUrl");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
          paramf = paramf.eFN();
          if (bs.isNullOrNil(paramMap)) {
            continue;
          }
          com.tencent.mm.plugin.webview.modeltools.g.eBX();
          a(paramMap, paramf, i, str2, str1, 0, str4, i1, i2, "");
          continue;
          str4 = z.x(paramMap, "query");
          String str6 = z.x(paramMap, "searchId");
          paramf = new Intent();
          paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
          paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
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
          if (z.d(paramMap, "isWeAppMore", 0) == 1)
          {
            j = 1;
            i3 = z.d(paramMap, "tabPageType", 0);
            if (j == 0) {
              break label1188;
            }
            localObject2 = com.tencent.mm.plugin.websearch.b.a.a(i1, false, m, (String)localObject4);
            ((Map)localObject2).put("query", str4);
            ((Map)localObject2).put("searchId", str6);
            ((Map)localObject2).put("subType", String.valueOf(i2));
            ((Map)localObject2).put("isWeAppMore", String.valueOf(z.d(paramMap, "isWeAppMore", 0)));
            paramMap = com.tencent.mm.modelappbrand.b.aAy();
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("sessionId", paramMap);
            ((Map)localObject2).put("subSessionId", paramMap);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aV((Map)localObject2));
            paramf.putExtra("ftsbizscene", i1);
            paramf.putExtra("customize_status_bar_color", i);
            paramf.putExtra("status_bar_style", str2);
            paramf.putExtra("sessionId", paramMap);
            if (bool) {
              break label1182;
            }
          }
          label1182:
          for (bool = true;; bool = false)
          {
            paramf.putExtra("ftscaneditable", bool);
            paramf.putExtra("key_hide_cancel_btn", true);
            com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramf);
            break;
            j = 0;
            break label942;
          }
          label1188:
          paramMap = z.a(i1, false, m, (String)localObject4);
          paramMap.put("query", str4);
          paramMap.put("searchId", str6);
          paramMap.put("isHomePage", String.valueOf(n));
          paramMap.put("isSug", localObject5);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramMap.put("sessionId", localObject3);
            paramf.putExtra("sessionId", (String)localObject3);
          }
          str1 = z.Ui(i1);
          paramMap.put("subSessionId", str1);
          paramf.putExtra("subSessionId", str1);
          paramf.putExtra("rawUrl", g(i1, paramMap));
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
            z.a(com.tencent.mm.sdk.platformtools.ai.getContext(), str4, paramf, (String)localObject2, (String)localObject4, str6, (String)localObject3, str1);
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
            com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", paramMap, paramf);
            break;
          }
          paramf = z.x(paramMap, "query");
          i = z.d(paramMap, "topStoryScene", 0);
          int j = z.d(paramMap, "tagId", 0);
          str1 = z.x(paramMap, "navigationId");
          paramMap = (Map<String, Object>)localObject3;
          if (bs.isNullOrNil((String)localObject3)) {
            paramMap = z.Ui(i);
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
          localObject4 = new dia();
          ((dia)localObject4).qox = com.tencent.mm.plugin.topstory.ui.d.ecM();
          ((dia)localObject4).scene = i;
          ((dia)localObject4).jKB = "";
          ((dia)localObject4).cZL = paramf;
          ((dia)localObject4).sessionId = paramMap;
          ((dia)localObject4).drf = paramMap;
          ((dia)localObject4).FQW = 2;
          ((dia)localObject4).url = h.l((HashMap)localObject5);
          ((dia)localObject4).EDw = ((String)localObject2);
          ((dia)localObject4).cGY = j;
          ((dia)localObject4).dlj = ((String)localObject3);
          ((dia)localObject4).BYy = str1;
          ((dia)localObject4).rzt = z.dkv();
          paramMap = new yh();
          paramMap.key = "rec_category";
          paramMap.ErV = j;
          paramMap.ErW = String.valueOf(j);
          ((dia)localObject4).BYq.add(paramMap);
          com.tencent.mm.plugin.topstory.ui.d.a(com.tencent.mm.sdk.platformtools.ai.getContext(), (dia)localObject4, (String)localObject3);
        }
        catch (Exception localException)
        {
          break label668;
        }
        label1854:
        localObject2 = null;
      }
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(77905);
    this.CgO.zZO = true;
    boolean bool1 = z.y(paramMap, "isTeachPage");
    boolean bool2 = z.y(paramMap, "isMoreButton");
    int j;
    int i;
    label62:
    String str3;
    String str1;
    String str4;
    int m;
    String str2;
    int k;
    if (z.d(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (z.d(paramMap, "isWeAppMore", 0) != 1) {
        break label192;
      }
      i = 1;
      str3 = z.x(paramMap, "srcUserName");
      str1 = z.x(paramMap, "sessionId");
      str4 = (String)paramMap.get("navBarColor");
      m = z.d(paramMap, "subType", 0);
      str2 = z.x(paramMap, "searchPlaceHolder");
      k = 0;
      if (bs.isNullOrNil(str4)) {}
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
        paramString = z.x(paramMap, "jumpUrl");
        paramMap = null;
        if (paramf != null) {
          paramMap = paramf.eFN();
        }
        com.tencent.mm.plugin.webview.modeltools.g.eBX();
        o(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label192:
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label62;
      label232:
      j = z.d(paramMap, "type", 0);
      int n = z.d(paramMap, "opType", 0);
      if (n > 0)
      {
        switch (n)
        {
        default: 
          break;
        case 2: 
          a(bi(paramMap), bool1);
          break;
        case 3: 
          paramMap = bi(paramMap);
          if (!w.wG(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          ad.aAy(paramMap.username);
          paramf = new Intent();
          paramf.putExtra("Chat_User", paramMap.username);
          paramf.putExtra("finish_direct", true);
          paramf.putExtra("key_temp_session_show_type", 0);
          paramf.putExtra("preChatTYPE", 9);
          com.tencent.mm.br.d.e(com.tencent.mm.sdk.platformtools.ai.getContext(), ".ui.chatting.ChattingUI", paramf);
          break;
        case 4: 
          paramString = z.x(paramMap, "jumpUrl");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eFN();
          }
          com.tencent.mm.plugin.webview.modeltools.g.eBX();
          o(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str4 = z.x(paramMap, "query");
        k = z.d(paramMap, "scene", 0);
        str3 = z.x(paramMap, "searchId");
        paramf = new Intent();
        paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
        paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
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
            paramString.put("isWeAppMore", String.valueOf(z.d(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.aAy();
            paramString.put("sessionId", paramMap);
            str1 = z.Ui(bs.aLy((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramf.putExtra("subSessionId", str1);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aV(paramString));
            paramf.putExtra("ftsbizscene", k);
            paramf.putExtra("key_search_place_holder", str2);
            com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramf);
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
          paramMap = z.a(k, false, j, paramString);
          try
          {
            paramMap.put("query", p.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = z.Ui(bs.aLy((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramf.putExtra("subSessionId", paramString);
            paramf.putExtra("rawUrl", g(k, paramMap));
            paramf.putExtra("key_session_id", str1);
            paramf.putExtra("searchId", str3);
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", paramMap, paramf);
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = z.x(paramMap, "jumpUrl");
          str1 = z.x(paramMap, "publishId");
          i = z.d(paramMap, "payScene", 0);
          j = z.d(paramMap, "scene", 0);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          str2 = z.x(paramMap, "cookie");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eFN();
          }
          if (!bs.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.eBX();
            a(paramString, paramMap, k, str4, str1, i, str3, j, m, str2);
          }
          break;
        case 8: 
          z.x(paramMap, "snsid");
          paramf = z.x(paramMap, "objectXmlDesc");
          paramString = z.x(paramMap, "userName");
          bool1 = z.y(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.eBX();
          z(paramf, paramString, bool1);
          break;
        case 1: 
          a(bi(paramMap), false);
          break;
        case 32: 
          a(bj(paramMap));
        }
      }
    }
  }
  
  public final boolean be(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (z.d(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (com.tencent.mm.plugin.websearch.api.ac.BZh == null) {
        com.tencent.mm.plugin.websearch.api.ac.ext();
      }
      com.tencent.mm.plugin.websearch.api.ac.BZh.ncM.clear();
      paramMap = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = com.tencent.mm.plugin.websearch.api.ac.bkj();
        localObject2 = Base64.encodeToString(com.tencent.mm.plugin.websearch.api.ac.BZh.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = z.d(paramMap, "type", 0);
      int j = z.d(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.lqi > 1000L)
      {
        this.lqi = System.currentTimeMillis();
        if (!z.Uk(0))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          com.tencent.mm.plugin.websearch.api.ai.J(i, j, com.tencent.mm.plugin.websearch.api.ab.aAw("searchID"));
          paramMap = z.exm();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", z.aV(z.f(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(z.d(paramMap, "webview_instance_id", -1));
          i = z.d(paramMap, "scene", 0);
          paramMap = z.x(paramMap, "query");
          if ((i != 20) || (bs.isNullOrNil(paramMap)))
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ.g(136, (Bundle)localObject2);
              }
            }
            catch (Exception paramMap)
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final boolean bf(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = z.d(paramMap, "scene", 0);
    int k = z.d(paramMap, "type", 0);
    int m = z.d(paramMap, "requestType", 0);
    int j = bs.l(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    boolean bool = z.y(paramMap, "ignoreCache");
    Object localObject1;
    if (m == 0)
    {
      paramMap = B(i, k, true);
      if (this.CgL.get(paramMap) == null)
      {
        localObject1 = new b((byte)0);
        ((b)localObject1).iH(i, k);
        this.CgL.put(paramMap, localObject1);
      }
      paramMap = (b)this.CgL.get(paramMap);
      if ((paramMap.isAvailable()) && (!bool))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.CgZ), Long.valueOf(paramMap.Cha), Integer.valueOf(paramMap.type), paramMap.djc });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).e(m, paramMap.djc, 1, str);
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          com.tencent.mm.plugin.websearch.api.ai.a(paramMap.scene, 0, paramMap.pik, paramMap.type, 2, paramMap.ezn(), 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77902);
        return false;
        com.tencent.mm.plugin.websearch.api.ai.a(paramMap.scene, 0, paramMap.pik, paramMap.type, 1, "", 0);
        continue;
        com.tencent.mm.kernel.g.agi().a(1048, this);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[] { Integer.valueOf(j) });
        paramMap = com.tencent.mm.sdk.platformtools.ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
        long l = com.tencent.mm.plugin.websearch.api.ab.aAv("discoverSearchEntry").optLong("guideParam");
        this.CgM = new u(i, k, z.Ul(0), j, paramMap, l, str);
        com.tencent.mm.kernel.g.agi().a(this.CgM, 0);
      }
    }
    paramMap = ad.exv();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        i = paramMap.ncM.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject2 = (bwu)paramMap.ncM.get(i);
          if (!w.wG(((bwu)localObject2).Username)) {
            break label683;
          }
          localObject2 = com.tencent.mm.al.f.dX(((bwu)localObject2).Username);
          if (localObject2 == null) {
            break label683;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.api.c)localObject2).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.api.c)localObject2).field_username);
          localJSONObject2.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(((com.tencent.mm.api.c)localObject2).field_username));
          localJSONArray2.put(localJSONObject2);
          break label683;
        }
        localJSONObject1.put("items", localJSONArray2);
        localJSONObject1.put("type", 5);
        localJSONObject1.put("title", "");
        localJSONArray1.put(localJSONObject1);
        ((JSONObject)localObject1).put("data", localJSONArray1);
        paramMap = ((JSONObject)localObject1).toString();
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(j).e(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label683:
      i -= 1;
    }
  }
  
  public final boolean bg(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = z.d(paramMap, "scene", 201);
    int i = bs.l(paramMap.get("webview_instance_id"), -1);
    Object localObject = UE(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf;
    String str;
    if (localObject != null)
    {
      localf = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i);
      str = ((g)localObject).djc;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localf.q(str, 1, i, ((g)localObject).Chh);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.g.agi().a(1866, this);
        localObject = new d(paramMap, j, 0);
        if (paramMap != null) {
          ((d)localObject).drc = z.d(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean bh(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    cpk localcpk = new cpk();
    localcpk.FCf = z.x(paramMap, "logString");
    com.tencent.mm.kernel.g.agi().a(1134, this);
    paramMap = new v(localcpk);
    com.tencent.mm.kernel.g.agi().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77918);
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    final int j = bs.aLy((String)paramMap.get("offset"));
    final int k = bs.aLy((String)paramMap.get("count"));
    final int m = bs.l(paramMap.get("webview_instance_id"), -1);
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
      if (this.CgR.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.CgQ == null) {
        this.CgQ = new com.tencent.mm.plugin.websearch.a.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.a.a.d(str, (List)localObject);
      if (this.CgR == null) {}
    }
    this.CgR = paramMap;
    this.CgQ.a(paramMap, new c.a()
    {
      public final void exM()
      {
        AppMethodBeat.i(77889);
        b.a(b.this.CgR, j, k, m);
        AppMethodBeat.o(77889);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.CgR.cZP) {
        a(this.CgR, j, k, m);
      }
    }
  }
  
  public final boolean bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = z.x(paramMap, "md5");
    int i = z.d(paramMap, "offset", 0);
    String str2 = z.x(paramMap, "searchId");
    String str3 = z.x(paramMap, "sessionId");
    int j = z.d(paramMap, "tab", 0);
    String str4 = z.x(paramMap, "requestId");
    int k = z.d(paramMap, "scene", 0);
    int m = z.d(paramMap, "webview_instance_id", -1);
    String str5 = z.x(paramMap, "emojiUrl");
    paramMap = z.x(paramMap, "aesKey");
    if (this.CgS != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.CgS);
      com.tencent.mm.kernel.g.agi().b(2999, this);
    }
    com.tencent.mm.kernel.g.agi().a(2999, this);
    this.CgS = new c(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.CgS.drc = m;
    com.tencent.mm.kernel.g.agi().a(this.CgS, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final boolean bn(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77921);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "doSearchWebQuery %s", new Object[] { paramMap.toString() });
    String str1 = z.x(paramMap, "requestId");
    String str2 = z.x(paramMap, "commReq");
    int i = z.d(paramMap, "webview_instance_id", -1);
    com.tencent.mm.kernel.g.agi().a(2975, this);
    com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.plugin.websearch.api.q(str1, str2, i), 0);
    AppMethodBeat.o(77921);
    return false;
  }
  
  public final String ezm()
  {
    AppMethodBeat.i(77901);
    Object localObject = B(20, 0, true);
    if (this.CgL.get(localObject) == null)
    {
      b localb = new b((byte)0);
      localb.iH(20, 0);
      this.CgL.put(localObject, localb);
    }
    localObject = (b)this.CgL.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).djc; bs.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(77901);
      return "";
    }
    AppMethodBeat.o(77901);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(77913);
    Object localObject1;
    if ((paramn instanceof u))
    {
      com.tencent.mm.kernel.g.agi().b(1048, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (u)paramn;
      localObject1 = new b((byte)0);
      ((b)localObject1).scene = paramString.scene;
      ((b)localObject1).CgZ = paramString.BYE.FhV;
      ((b)localObject1).djc = paramString.BYE.FhN;
      ((b)localObject1).Cha = (System.currentTimeMillis() / 1000L);
      ((b)localObject1).pik = paramString.BYE.FhW;
      ((b)localObject1).type = paramString.businessType;
      paramn = B(((b)localObject1).scene, ((b)localObject1).type, true);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { ((b)localObject1).djc });
      if (!bs.isNullOrNil(((b)localObject1).djc))
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.drc).e(0, ((b)localObject1).djc, 0, paramString.dlj);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { ((b)localObject1).djc });
      }
      this.CgL.put(paramn, localObject1);
      if (((b)localObject1).CgZ == 0L)
      {
        paramInt1 = ((b)localObject1).scene;
        paramInt2 = ((b)localObject1).type;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = com.tencent.mm.plugin.record.b.awO();
        paramn = new e(paramString, B(paramInt1, paramInt2, true));
        if (paramn.exists()) {
          paramn.delete();
        }
        paramString = new e(paramString, B(paramInt1, paramInt2, false));
        if (paramString.exists()) {
          paramString.delete();
        }
      }
      while ((((b)localObject1).scene == 20) && (((b)localObject1).type == 0))
      {
        com.tencent.mm.plugin.websearch.api.ai.a(((b)localObject1).scene, 1, ((b)localObject1).pik, ((b)localObject1).type, 2, ((b)localObject1).ezn(), 1);
        AppMethodBeat.o(77913);
        return;
        paramn = new bsu();
        paramn.scene = ((b)localObject1).scene;
        paramn.FhN = ((b)localObject1).djc;
        paramn.FhO = ((b)localObject1).CgZ;
        paramn.FhP = ((b)localObject1).Cha;
        paramn.EfU = ((b)localObject1).pik;
        paramn.ndI = ((b)localObject1).type;
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
          paramn = new e(com.tencent.mm.plugin.record.b.awO(), B(((b)localObject1).scene, ((b)localObject1).type, true));
          if (!paramn.fxU().exists()) {
            paramn.fxU().mkdirs();
          }
          if (paramn.exists()) {
            paramn.delete();
          }
          i.f(com.tencent.mm.vfs.q.B(paramn.fxV()), paramString, paramString.length);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(paramn.fxV()), Integer.valueOf(paramString.length) });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
        }
      }
      com.tencent.mm.plugin.websearch.api.ai.a(((b)localObject1).scene, 1, ((b)localObject1).pik, ((b)localObject1).type, 1, "", 0);
      AppMethodBeat.o(77913);
    }
    else
    {
      if ((paramn instanceof v))
      {
        com.tencent.mm.kernel.g.agi().b(1134, this);
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof d))
      {
        com.tencent.mm.kernel.g.agi().b(1866, this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(77913);
          return;
        }
        paramString = (d)paramn;
        if (paramString.drc != -1) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.drc).q(((dvu)paramString.rr.hvs.hvw).djc, 0, 0, 0);
        }
        if (paramString.Chj != null) {
          this.CgN.put(Integer.valueOf(paramString.Chj.scene), paramString.Chj);
        }
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof c))
      {
        com.tencent.mm.kernel.g.agi().b(2999, this);
        localObject1 = (c)paramn;
        paramn = bs.bG(((c)localObject1).Chi.FhN, "");
        if (((c)localObject1).drc != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(((c)localObject1).drc);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("fts_key_json_data", paramn);
          ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
          ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ.g(152, (Bundle)localObject2);
            }
            AppMethodBeat.o(77913);
            return;
          }
          catch (Exception paramString) {}
        }
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.q))
      {
        localObject2 = (com.tencent.mm.plugin.websearch.api.q)paramn;
        com.tencent.mm.kernel.g.agi().b(2975, this);
        paramn = bs.bG(((dya)((com.tencent.mm.plugin.websearch.api.q)localObject2).rr.hvs.hvw).Geg, "");
        if (((com.tencent.mm.plugin.websearch.api.q)localObject2).drc != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(((com.tencent.mm.plugin.websearch.api.q)localObject2).drc);
          localObject2 = ((com.tencent.mm.plugin.websearch.api.q)localObject2).dlj;
          localBundle = new Bundle();
          localBundle.putString("fts_key_id", (String)localObject2);
          localBundle.putString("fts_key_json_data", paramn);
          localBundle.putString("fts_key_err_msg", paramString);
          localBundle.putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).CkJ.g(153, localBundle);
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
    long CgZ;
    long Cha;
    String djc;
    boolean gaw = false;
    private String kyf = null;
    String pik;
    int scene;
    int type;
    
    private b() {}
    
    final String ezn()
    {
      AppMethodBeat.i(77892);
      if (this.kyf == null) {
        this.kyf = "";
      }
      try
      {
        localObject = new JSONObject(this.djc).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.kyf = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.kyf;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final void iH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      bsu localbsu = new bsu();
      Object localObject1 = com.tencent.mm.plugin.record.b.awO();
      Object localObject2 = b.B(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(b.B(paramInt1, paramInt2, true))) {
        this.gaw = true;
      }
      localObject1 = new e((String)localObject1, (String)localObject2);
      localObject2 = i.aU(com.tencent.mm.vfs.q.B(((e)localObject1).fxV()), 0, (int)((e)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localbsu.parseFrom((byte[])localObject2);
          this.scene = localbsu.scene;
          this.djc = localbsu.FhN;
          this.CgZ = localbsu.FhO;
          this.Cha = localbsu.FhP;
          this.pik = localbsu.EfU;
          this.type = localbsu.ndI;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(((e)localObject1).fxV()), Integer.valueOf(localObject2.length) });
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
      if (this.gaw)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((bs.isNullOrNil(this.djc)) || (System.currentTimeMillis() / 1000L - this.Cha > this.CgZ))
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
    public int Chb;
    public boolean Chc;
    public String Chd;
    public int Che;
    public int drj;
    public String jKB;
    public String nickname;
    public int position;
    public String query;
    public int scene;
    public String signature;
    public String username;
    public String vIX;
    public aaf vKk;
    
    private c() {}
  }
  
  final class d
  {
    public int Chf;
    public String country;
    public String eNf;
    public int exL;
    public String exV;
    public String exW;
    public String nickname;
    public String query;
    public int scene;
    public String signature;
    public String username;
    
    private d() {}
  }
  
  static final class g
  {
    public long Cha;
    public int Chh;
    public String djc;
    public long interval;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.djc = "";
      this.interval = 0L;
      this.Cha = 0L;
      this.Chh = 0;
    }
    
    public g(int paramInt1, dvu paramdvu, int paramInt2)
    {
      AppMethodBeat.i(188275);
      this.scene = 0;
      this.djc = "";
      this.interval = 0L;
      this.Cha = 0L;
      this.Chh = 0;
      this.scene = paramInt1;
      this.djc = paramdvu.djc;
      this.interval = paramdvu.gbd;
      this.Cha = (System.currentTimeMillis() / 1000L);
      this.Chh = paramInt2;
      AppMethodBeat.o(188275);
    }
    
    /* Error */
    public static g UF(int paramInt)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 64	com/tencent/mm/vfs/e
      //   8: dup
      //   9: invokestatic 70	com/tencent/mm/plugin/record/b:awO	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 74	com/tencent/mm/plugin/webview/fts/b$g:UG	(I)Ljava/lang/String;
      //   16: invokespecial 77	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 81	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
      //   24: invokestatic 87	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual 90	com/tencent/mm/vfs/e:length	()J
      //   32: l2i
      //   33: invokestatic 96	com/tencent/mm/vfs/i:aU	(Ljava/lang/String;II)[B
      //   36: astore_1
      //   37: new 98	com/tencent/mm/protocal/protobuf/bsv
      //   40: dup
      //   41: invokespecial 99	com/tencent/mm/protocal/protobuf/bsv:<init>	()V
      //   44: astore_2
      //   45: aload_2
      //   46: aload_1
      //   47: invokevirtual 103	com/tencent/mm/protocal/protobuf/bsv:parseFrom	([B)Lcom/tencent/mm/bw/a;
      //   50: pop
      //   51: new 2	com/tencent/mm/plugin/webview/fts/b$g
      //   54: dup
      //   55: invokespecial 104	com/tencent/mm/plugin/webview/fts/b$g:<init>	()V
      //   58: astore_1
      //   59: aload_1
      //   60: aload_2
      //   61: getfield 107	com/tencent/mm/protocal/protobuf/bsv:Scene	I
      //   64: putfield 21	com/tencent/mm/plugin/webview/fts/b$g:scene	I
      //   67: aload_1
      //   68: aload_2
      //   69: getfield 110	com/tencent/mm/protocal/protobuf/bsv:FhN	Ljava/lang/String;
      //   72: putfield 25	com/tencent/mm/plugin/webview/fts/b$g:djc	Ljava/lang/String;
      //   75: aload_1
      //   76: aload_2
      //   77: getfield 113	com/tencent/mm/protocal/protobuf/bsv:FhQ	J
      //   80: putfield 27	com/tencent/mm/plugin/webview/fts/b$g:interval	J
      //   83: aload_1
      //   84: aload_2
      //   85: getfield 116	com/tencent/mm/protocal/protobuf/bsv:FhP	J
      //   88: putfield 29	com/tencent/mm/plugin/webview/fts/b$g:Cha	J
      //   91: aload_1
      //   92: aload_2
      //   93: getfield 119	com/tencent/mm/protocal/protobuf/bsv:FhR	I
      //   96: putfield 31	com/tencent/mm/plugin/webview/fts/b$g:Chh	I
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
      //   44	49	2	localbsv	com.tencent.mm.protocal.protobuf.bsv
      //   112	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   37	59	106	java/lang/Exception
      //   59	99	112	java/lang/Exception
    }
    
    static String UG(int paramInt)
    {
      AppMethodBeat.i(77896);
      String str = com.tencent.mm.sdk.platformtools.ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
      str = "SearchGuide_" + paramInt + "-" + str;
      AppMethodBeat.o(77896);
      return str;
    }
    
    public final boolean isExpired()
    {
      AppMethodBeat.i(77897);
      if (this.Cha + this.interval <= System.currentTimeMillis() / 1000L)
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