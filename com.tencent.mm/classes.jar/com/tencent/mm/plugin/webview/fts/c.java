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
import com.tencent.mm.al.b.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.websearch.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
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

public final class c
  implements com.tencent.mm.al.f
{
  public Set<Integer> DJQ;
  public l DJR;
  private HashMap<String, b> DJS;
  public y DJT;
  private Map<Integer, g> DJU;
  public c.e DJV;
  public List<com.tencent.mm.az.f> DJW;
  private com.tencent.mm.plugin.websearch.a.a.c DJX;
  com.tencent.mm.plugin.websearch.a.a.d DJY;
  private d DJZ;
  public com.tencent.mm.sdk.b.c kwD;
  private long lND;
  
  public c()
  {
    AppMethodBeat.i(77898);
    this.DJR = new c.1(this);
    this.DJU = new HashMap();
    this.DJV = new c.e(this);
    this.kwD = new c.2(this);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.DJS = new HashMap();
    this.DJQ = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
    AppMethodBeat.o(77898);
  }
  
  static String B(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(77916);
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = ac.iM(aj.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean)
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    if (new com.tencent.mm.vfs.e(com.tencent.mm.plugin.record.b.azD(), str2).exists())
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
    paramd = paramd.iT(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramInt3).bE(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.DKl != 0) {
      i = paramc.DKl;
    }
    for (;;)
    {
      ah.aFS(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.wQe);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.DKi);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.wRt != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.wRt.toByteArray());
        label116:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.keN);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.DKk);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.dDa == 2)
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
          if (paramc.DKj)
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
    localIntent.putExtra("Contact_Alias", paramd.ffB);
    localIntent.putExtra("Contact_Sex", paramd.ePk);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramd.country, paramd.ePu, paramd.ePv));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.DKm);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5)
  {
    AppMethodBeat.i(207811);
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
      AppMethodBeat.o(207811);
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
    paramMap1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap1, "data");
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap1, "", new Object[0]);
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf((String)localObject);
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
  
  private c bl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "userName");
    localc.nickname = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "nickName");
    localc.wQe = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "headHDImgUrl");
    localc.DKi = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "verifyFlag", 0);
    localc.signature = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "signature");
    localc.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    localc.dDa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sceneActionType", 1);
    localc.wRt = new acf();
    localc.wRt.jdq = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "brandFlag", 0);
    localc.wRt.jdt = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "iconUrl");
    localc.wRt.jds = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "brandInfo");
    localc.wRt.jdr = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "externalInfo");
    localc.keN = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchId");
    localc.query = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    localc.position = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "position", 0);
    localc.DKj = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isCurrentDetailPage");
    localc.DKk = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "extraParams");
    localc.DKl = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "friendScene", 0);
    AppMethodBeat.o(77914);
    return localc;
  }
  
  private d bm(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "userName");
    locald.nickname = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "nickName");
    locald.ffB = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "alias");
    locald.signature = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "signature");
    locald.ePk = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sex", 0);
    locald.country = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "country");
    locald.ePv = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "city");
    locald.ePu = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "province");
    locald.DKm = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "snsFlag", 0);
    String str = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    if (!bt.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "matchType"))) {
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
  
  public static boolean bn(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "word");
    boolean bool1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isInputChange");
    String str2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "custom");
    String str3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "tagList");
    boolean bool2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "cache");
    paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(bt.m(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool1);
    localBundle.putString("fts_key_tag_list", str3);
    localBundle.putBoolean("fts_key_cache", bool2);
    try
    {
      if (paramMap.DNO != null) {
        paramMap.DNO.g(122, localBundle);
      }
      AppMethodBeat.o(77917);
      return false;
    }
    catch (RemoteException paramMap)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean br(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(207813);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "extInfo")));
      paramMap = new Intent();
      ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).fillContextIdToIntent(6, 2, 25, paramMap);
      ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).enterFinderShareFeedUI(aj.getContext(), localJSONObject.toString(), paramMap);
      label118:
      AppMethodBeat.o(207813);
      return false;
    }
    catch (Exception paramMap)
    {
      break label118;
    }
  }
  
  private static String g(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(77922);
    switch (paramInt)
    {
    default: 
      paramMap = com.tencent.mm.plugin.websearch.api.ad.aY(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    case 201: 
      paramMap = com.tencent.mm.plugin.websearch.b.a.aY(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    }
    paramMap = com.tencent.mm.plugin.websearch.api.ad.e(paramMap, 1);
    AppMethodBeat.o(77922);
    return paramMap;
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", 0, "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle v(int paramInt, Bundle paramBundle)
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
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.eQR().eOb());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", af.aFP(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = af.aFP("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = com.tencent.mm.plugin.websearch.api.ad.f(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", af.aFQ(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  private static void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).Gx(paramString1);
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
  
  public final g Ww(int paramInt)
  {
    AppMethodBeat.i(207812);
    if (this.DJU.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.Wx(paramInt);
      if (localg != null) {
        this.DJU.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.DJU.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(207812);
    return localg;
  }
  
  /* Error */
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf)
  {
    // Byte code:
    //   0: ldc_w 797
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 87
    //   8: ldc_w 799
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: invokevirtual 800	java/lang/Object:toString	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 593	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_1
    //   26: ldc_w 802
    //   29: invokeinterface 609 2 0
    //   34: checkcast 406	java/lang/String
    //   37: invokestatic 805	com/tencent/mm/sdk/platformtools/bt:aRe	(Ljava/lang/String;)I
    //   40: istore 6
    //   42: aload_1
    //   43: ldc_w 738
    //   46: iconst_0
    //   47: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   50: istore 7
    //   52: aload_1
    //   53: ldc_w 807
    //   56: invokeinterface 609 2 0
    //   61: checkcast 406	java/lang/String
    //   64: astore 16
    //   66: aload_1
    //   67: ldc_w 809
    //   70: invokeinterface 609 2 0
    //   75: checkcast 406	java/lang/String
    //   78: astore 19
    //   80: aload_1
    //   81: ldc_w 811
    //   84: invokeinterface 609 2 0
    //   89: checkcast 406	java/lang/String
    //   92: astore 15
    //   94: aload_1
    //   95: ldc_w 813
    //   98: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 17
    //   103: ldc_w 815
    //   106: aload_1
    //   107: ldc_w 817
    //   110: invokeinterface 609 2 0
    //   115: checkcast 406	java/lang/String
    //   118: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 12
    //   123: aload_1
    //   124: ldc_w 733
    //   127: invokeinterface 609 2 0
    //   132: checkcast 406	java/lang/String
    //   135: invokestatic 805	com/tencent/mm/sdk/platformtools/bt:aRe	(Ljava/lang/String;)I
    //   138: istore 8
    //   140: aload_1
    //   141: ldc_w 748
    //   144: invokeinterface 609 2 0
    //   149: invokestatic 820	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: astore 18
    //   154: aload_1
    //   155: ldc_w 822
    //   158: invokeinterface 609 2 0
    //   163: checkcast 406	java/lang/String
    //   166: astore 14
    //   168: aload 14
    //   170: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +259 -> 432
    //   176: new 443	org/json/JSONObject
    //   179: dup
    //   180: aload 14
    //   182: invokespecial 658	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 14
    //   187: aload 14
    //   189: ldc_w 824
    //   192: invokevirtual 446	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +1792 -> 1987
    //   198: aload 14
    //   200: ldc_w 824
    //   203: invokevirtual 827	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 14
    //   208: aload_1
    //   209: ldc_w 829
    //   212: invokeinterface 609 2 0
    //   217: checkcast 406	java/lang/String
    //   220: astore 20
    //   222: aload 20
    //   224: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   227: ifne +247 -> 474
    //   230: new 443	org/json/JSONObject
    //   233: dup
    //   234: aload 20
    //   236: invokespecial 658	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   239: ldc_w 831
    //   242: ldc_w 833
    //   245: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 20
    //   250: aload 20
    //   252: ldc_w 837
    //   255: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: istore 13
    //   260: iload 13
    //   262: ifeq +176 -> 438
    //   265: iconst_1
    //   266: istore_3
    //   267: iconst_0
    //   268: istore 4
    //   270: aload 15
    //   272: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   275: ifne +10 -> 285
    //   278: aload 15
    //   280: invokestatic 842	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   283: istore 4
    //   285: aload_1
    //   286: ldc_w 844
    //   289: invokeinterface 609 2 0
    //   294: checkcast 406	java/lang/String
    //   297: astore 20
    //   299: aload_1
    //   300: ldc_w 846
    //   303: invokeinterface 609 2 0
    //   308: checkcast 406	java/lang/String
    //   311: astore 22
    //   313: aload_1
    //   314: ldc_w 848
    //   317: invokeinterface 609 2 0
    //   322: checkcast 406	java/lang/String
    //   325: astore 15
    //   327: aload_1
    //   328: ldc_w 850
    //   331: invokeinterface 609 2 0
    //   336: checkcast 406	java/lang/String
    //   339: astore 21
    //   341: aload_1
    //   342: ldc_w 511
    //   345: iconst_0
    //   346: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   349: istore 9
    //   351: aload_1
    //   352: ldc_w 852
    //   355: iconst_0
    //   356: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   359: istore 10
    //   361: iload 6
    //   363: tableswitch	default:+45 -> 408, 1:+150->513, 2:+446->809, 3:+510->873, 4:+45->408, 5:+1279->1642, 6:+45->408, 7:+510->873, 8:+321->684
    //   409: iconst_0
    //   410: iload_3
    //   411: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 14
    //   418: ldc 87
    //   420: aload 14
    //   422: ldc_w 488
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aconst_null
    //   433: astore 14
    //   435: goto -227 -> 208
    //   438: aload 20
    //   440: ldc_w 854
    //   443: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: istore 13
    //   448: iload 13
    //   450: ifeq +1532 -> 1982
    //   453: iconst_2
    //   454: istore_3
    //   455: goto -188 -> 267
    //   458: astore 20
    //   460: ldc 87
    //   462: aload 20
    //   464: ldc_w 488
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -209 -> 267
    //   479: astore_1
    //   480: ldc 87
    //   482: new 125	java/lang/StringBuilder
    //   485: dup
    //   486: ldc_w 856
    //   489: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   492: aload_1
    //   493: invokevirtual 857	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   496: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 859	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: ldc_w 797
    //   508: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iconst_1
    //   512: ireturn
    //   513: iload 7
    //   515: lookupswitch	default:+33->548, 1:+146->661, 8:+97->612, 32:+158->673
    //   549: ldc_w 861
    //   552: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   555: astore_1
    //   556: ldc 87
    //   558: ldc_w 863
    //   561: iconst_1
    //   562: anewarray 4	java/lang/Object
    //   565: dup
    //   566: iconst_0
    //   567: aload_1
    //   568: aastore
    //   569: invokestatic 593	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: aload_2
    //   573: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:eUJ	()Landroid/os/Bundle;
    //   576: astore_2
    //   577: aload_1
    //   578: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   581: ifne -173 -> 408
    //   584: invokestatic 701	com/tencent/mm/plugin/webview/modeltools/g:eQR	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   587: pop
    //   588: aload_1
    //   589: aload_2
    //   590: iload 4
    //   592: aload 20
    //   594: aload 17
    //   596: iconst_0
    //   597: aload 21
    //   599: iload 9
    //   601: iload 10
    //   603: ldc_w 488
    //   606: invokestatic 692	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;)V
    //   609: goto -201 -> 408
    //   612: aload_1
    //   613: ldc_w 869
    //   616: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   619: pop
    //   620: aload_1
    //   621: ldc_w 871
    //   624: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   627: astore_2
    //   628: aload_1
    //   629: ldc_w 451
    //   632: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   635: astore 14
    //   637: aload_1
    //   638: ldc_w 873
    //   641: invokestatic 544	com/tencent/mm/plugin/websearch/api/ad:A	(Ljava/util/Map;Ljava/lang/String;)Z
    //   644: istore 12
    //   646: invokestatic 701	com/tencent/mm/plugin/webview/modeltools/g:eQR	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   649: pop
    //   650: aload_2
    //   651: aload 14
    //   653: iload 12
    //   655: invokestatic 875	com/tencent/mm/plugin/webview/fts/c:z	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   658: goto -250 -> 408
    //   661: aload_0
    //   662: aload_1
    //   663: invokespecial 877	com/tencent/mm/plugin/webview/fts/c:bl	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$c;
    //   666: iconst_0
    //   667: invokestatic 879	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$c;Z)V
    //   670: goto -262 -> 408
    //   673: aload_0
    //   674: aload_1
    //   675: invokespecial 881	com/tencent/mm/plugin/webview/fts/c:bm	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$d;
    //   678: invokestatic 883	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$d;)V
    //   681: goto -273 -> 408
    //   684: aload_1
    //   685: ldc_w 537
    //   688: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   691: astore 14
    //   693: new 443	org/json/JSONObject
    //   696: dup
    //   697: invokespecial 463	org/json/JSONObject:<init>	()V
    //   700: astore 15
    //   702: aload 15
    //   704: ldc_w 595
    //   707: aload 14
    //   709: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 15
    //   715: ldc_w 441
    //   718: invokestatic 888	java/lang/System:currentTimeMillis	()J
    //   721: invokestatic 891	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   724: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 15
    //   730: ldc_w 893
    //   733: invokestatic 888	java/lang/System:currentTimeMillis	()J
    //   736: invokestatic 891	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   739: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload 15
    //   745: ldc_w 895
    //   748: iconst_1
    //   749: invokevirtual 898	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   752: pop
    //   753: aload 15
    //   755: ldc_w 861
    //   758: aload_1
    //   759: ldc_w 861
    //   762: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   765: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: ldc_w 900
    //   772: invokestatic 664	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   775: checkcast 900	com/tencent/mm/plugin/fts/a/n
    //   778: new 125	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   785: aload 14
    //   787: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 902
    //   793: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: aload 15
    //   801: invokevirtual 669	org/json/JSONObject:toString	()Ljava/lang/String;
    //   804: invokeinterface 905 3 0
    //   809: aload_1
    //   810: ldc_w 861
    //   813: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   816: astore_1
    //   817: ldc 87
    //   819: ldc_w 863
    //   822: iconst_1
    //   823: anewarray 4	java/lang/Object
    //   826: dup
    //   827: iconst_0
    //   828: aload_1
    //   829: aastore
    //   830: invokestatic 593	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   833: aload_2
    //   834: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:eUJ	()Landroid/os/Bundle;
    //   837: astore_2
    //   838: aload_1
    //   839: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   842: ifne -434 -> 408
    //   845: invokestatic 701	com/tencent/mm/plugin/webview/modeltools/g:eQR	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   848: pop
    //   849: aload_1
    //   850: aload_2
    //   851: iload 4
    //   853: aload 20
    //   855: aload 17
    //   857: iconst_0
    //   858: aload 21
    //   860: iload 9
    //   862: iload 10
    //   864: ldc_w 488
    //   867: invokestatic 692	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;)V
    //   870: goto -462 -> 408
    //   873: aload_1
    //   874: ldc_w 537
    //   877: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   880: astore 21
    //   882: aload_1
    //   883: ldc_w 536
    //   886: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   889: astore 23
    //   891: new 209	android/content/Intent
    //   894: dup
    //   895: invokespecial 210	android/content/Intent:<init>	()V
    //   898: astore_2
    //   899: aload_2
    //   900: ldc_w 907
    //   903: getstatic 913	com/tencent/mm/protocal/JsapiPermissionWrapper:FnD	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   906: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   909: pop
    //   910: aload_2
    //   911: ldc_w 918
    //   914: getstatic 924	com/tencent/mm/protocal/GeneralControlWrapper:Fnz	Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   917: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   920: pop
    //   921: aload_2
    //   922: ldc_w 926
    //   925: iconst_1
    //   926: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   929: pop
    //   930: aload_2
    //   931: ldc_w 928
    //   934: iconst_1
    //   935: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   938: pop
    //   939: aload_2
    //   940: ldc_w 930
    //   943: aload 21
    //   945: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   948: pop
    //   949: aload_2
    //   950: ldc_w 932
    //   953: iload 7
    //   955: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   958: pop
    //   959: aload_2
    //   960: ldc_w 366
    //   963: iload 4
    //   965: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   968: pop
    //   969: aload_2
    //   970: ldc_w 368
    //   973: aload 20
    //   975: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   978: pop
    //   979: aload_2
    //   980: ldc_w 934
    //   983: ldc_w 936
    //   986: aload 19
    //   988: invokevirtual 939	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   991: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   994: pop
    //   995: aload_2
    //   996: ldc_w 384
    //   999: aload 17
    //   1001: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1004: pop
    //   1005: aload_2
    //   1006: ldc_w 941
    //   1009: iload 9
    //   1011: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1014: pop
    //   1015: aload 14
    //   1017: ifnull +13 -> 1030
    //   1020: aload_2
    //   1021: ldc_w 824
    //   1024: aload 14
    //   1026: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1029: pop
    //   1030: aload_1
    //   1031: ldc_w 943
    //   1034: iconst_0
    //   1035: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1038: iconst_1
    //   1039: if_icmpne +241 -> 1280
    //   1042: iconst_1
    //   1043: istore 5
    //   1045: aload_1
    //   1046: ldc_w 945
    //   1049: iconst_0
    //   1050: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1053: istore 11
    //   1055: iload 5
    //   1057: ifeq +235 -> 1292
    //   1060: iload 9
    //   1062: iconst_0
    //   1063: iload 7
    //   1065: aload 16
    //   1067: invokestatic 948	com/tencent/mm/plugin/websearch/b/a:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1070: astore 14
    //   1072: aload 14
    //   1074: ldc_w 537
    //   1077: aload 21
    //   1079: invokeinterface 485 3 0
    //   1084: pop
    //   1085: aload 14
    //   1087: ldc_w 536
    //   1090: aload 23
    //   1092: invokeinterface 485 3 0
    //   1097: pop
    //   1098: aload 14
    //   1100: ldc_w 852
    //   1103: iload 10
    //   1105: invokestatic 951	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1108: invokeinterface 485 3 0
    //   1113: pop
    //   1114: aload 14
    //   1116: ldc_w 943
    //   1119: aload_1
    //   1120: ldc_w 943
    //   1123: iconst_0
    //   1124: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1127: invokestatic 951	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1130: invokeinterface 485 3 0
    //   1135: pop
    //   1136: invokestatic 956	com/tencent/mm/modelappbrand/b:aDB	()Ljava/lang/String;
    //   1139: astore_1
    //   1140: aload 14
    //   1142: ldc_w 848
    //   1145: aload_1
    //   1146: invokeinterface 485 3 0
    //   1151: pop
    //   1152: aload 14
    //   1154: ldc_w 848
    //   1157: aload_1
    //   1158: invokeinterface 485 3 0
    //   1163: pop
    //   1164: aload 14
    //   1166: ldc_w 958
    //   1169: aload_1
    //   1170: invokeinterface 485 3 0
    //   1175: pop
    //   1176: aload_2
    //   1177: ldc_w 960
    //   1180: aload_1
    //   1181: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1184: pop
    //   1185: aload_2
    //   1186: ldc_w 362
    //   1189: aload 14
    //   1191: invokestatic 682	com/tencent/mm/plugin/websearch/b/a:aY	(Ljava/util/Map;)Ljava/lang/String;
    //   1194: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1197: pop
    //   1198: aload_2
    //   1199: ldc_w 941
    //   1202: iload 9
    //   1204: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1207: pop
    //   1208: aload_2
    //   1209: ldc_w 366
    //   1212: iload 4
    //   1214: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1217: pop
    //   1218: aload_2
    //   1219: ldc_w 368
    //   1222: aload 20
    //   1224: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1227: pop
    //   1228: aload_2
    //   1229: ldc_w 848
    //   1232: aload_1
    //   1233: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1236: pop
    //   1237: iload 12
    //   1239: ifne +47 -> 1286
    //   1242: iconst_1
    //   1243: istore 12
    //   1245: aload_2
    //   1246: ldc_w 962
    //   1249: iload 12
    //   1251: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1254: pop
    //   1255: aload_2
    //   1256: ldc_w 964
    //   1259: iconst_1
    //   1260: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1263: pop
    //   1264: invokestatic 149	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1267: ldc_w 966
    //   1270: ldc_w 968
    //   1273: aload_2
    //   1274: invokestatic 302	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1277: goto -869 -> 408
    //   1280: iconst_0
    //   1281: istore 5
    //   1283: goto -238 -> 1045
    //   1286: iconst_0
    //   1287: istore 12
    //   1289: goto -44 -> 1245
    //   1292: iload 9
    //   1294: iconst_0
    //   1295: iload 7
    //   1297: aload 16
    //   1299: invokestatic 969	com/tencent/mm/plugin/websearch/api/ad:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1302: astore_1
    //   1303: aload_1
    //   1304: ldc_w 537
    //   1307: aload 21
    //   1309: invokeinterface 485 3 0
    //   1314: pop
    //   1315: aload_1
    //   1316: ldc_w 536
    //   1319: aload 23
    //   1321: invokeinterface 485 3 0
    //   1326: pop
    //   1327: aload_1
    //   1328: ldc_w 733
    //   1331: iload 8
    //   1333: invokestatic 951	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1336: invokeinterface 485 3 0
    //   1341: pop
    //   1342: aload_1
    //   1343: ldc_w 748
    //   1346: aload 18
    //   1348: invokeinterface 485 3 0
    //   1353: pop
    //   1354: aload 15
    //   1356: invokestatic 975	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1359: ifne +25 -> 1384
    //   1362: aload_1
    //   1363: ldc_w 848
    //   1366: aload 15
    //   1368: invokeinterface 485 3 0
    //   1373: pop
    //   1374: aload_2
    //   1375: ldc_w 848
    //   1378: aload 15
    //   1380: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1383: pop
    //   1384: iload 9
    //   1386: invokestatic 978	com/tencent/mm/plugin/websearch/api/ad:Wb	(I)Ljava/lang/String;
    //   1389: astore 17
    //   1391: aload_1
    //   1392: ldc_w 958
    //   1395: aload 17
    //   1397: invokeinterface 485 3 0
    //   1402: pop
    //   1403: aload_2
    //   1404: ldc_w 958
    //   1407: aload 17
    //   1409: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1412: pop
    //   1413: aload_2
    //   1414: ldc_w 362
    //   1417: iload 9
    //   1419: aload_1
    //   1420: invokestatic 980	com/tencent/mm/plugin/webview/fts/c:g	(ILjava/util/Map;)Ljava/lang/String;
    //   1423: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1426: pop
    //   1427: aload_2
    //   1428: ldc_w 930
    //   1431: aload 21
    //   1433: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1436: pop
    //   1437: aload_2
    //   1438: ldc_w 366
    //   1441: iload 4
    //   1443: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1446: pop
    //   1447: aload_2
    //   1448: ldc_w 368
    //   1451: aload 20
    //   1453: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1456: pop
    //   1457: aload_2
    //   1458: ldc_w 982
    //   1461: aload 22
    //   1463: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1466: pop
    //   1467: aload_2
    //   1468: ldc_w 928
    //   1471: iconst_1
    //   1472: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1475: pop
    //   1476: aload_2
    //   1477: ldc_w 984
    //   1480: iload_3
    //   1481: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1484: pop
    //   1485: iload 6
    //   1487: bipush 7
    //   1489: if_icmpne +12 -> 1501
    //   1492: aload_2
    //   1493: ldc_w 986
    //   1496: iconst_1
    //   1497: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1500: pop
    //   1501: iload 11
    //   1503: iconst_1
    //   1504: if_icmpne +39 -> 1543
    //   1507: aload_2
    //   1508: ldc_w 962
    //   1511: iconst_0
    //   1512: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1515: pop
    //   1516: invokestatic 149	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1519: aload 21
    //   1521: aload_2
    //   1522: aload 14
    //   1524: aload 16
    //   1526: aload 23
    //   1528: aload 15
    //   1530: aload 17
    //   1532: invokestatic 989	com/tencent/mm/plugin/websearch/api/ad:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1535: ldc_w 797
    //   1538: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: iconst_0
    //   1542: ireturn
    //   1543: iload 9
    //   1545: bipush 20
    //   1547: if_icmpeq +44 -> 1591
    //   1550: iload 9
    //   1552: bipush 22
    //   1554: if_icmpeq +37 -> 1591
    //   1557: iload 9
    //   1559: bipush 33
    //   1561: if_icmpeq +30 -> 1591
    //   1564: iload 9
    //   1566: iconst_3
    //   1567: if_icmpeq +24 -> 1591
    //   1570: iload 9
    //   1572: bipush 34
    //   1574: if_icmpeq +17 -> 1591
    //   1577: iload 9
    //   1579: bipush 65
    //   1581: if_icmpeq +10 -> 1591
    //   1584: iload 9
    //   1586: bipush 36
    //   1588: if_icmpne +47 -> 1635
    //   1591: aload_2
    //   1592: ldc_w 991
    //   1595: iconst_1
    //   1596: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1599: pop
    //   1600: aload_2
    //   1601: ldc_w 993
    //   1604: iload 12
    //   1606: invokevirtual 332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1609: pop
    //   1610: ldc_w 995
    //   1613: astore_1
    //   1614: aload_1
    //   1615: invokestatic 975	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1618: ifne -1210 -> 408
    //   1621: invokestatic 149	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1624: ldc_w 392
    //   1627: aload_1
    //   1628: aload_2
    //   1629: invokestatic 302	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1632: goto -1224 -> 408
    //   1635: ldc_w 997
    //   1638: astore_1
    //   1639: goto -25 -> 1614
    //   1642: aload_1
    //   1643: ldc_w 537
    //   1646: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1649: astore_2
    //   1650: aload_1
    //   1651: ldc_w 999
    //   1654: iconst_0
    //   1655: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1658: istore_3
    //   1659: aload_1
    //   1660: ldc_w 846
    //   1663: iconst_0
    //   1664: invokestatic 509	com/tencent/mm/plugin/websearch/api/ad:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1667: istore 4
    //   1669: aload_1
    //   1670: ldc_w 1001
    //   1673: invokestatic 427	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1676: astore 17
    //   1678: aload 15
    //   1680: astore_1
    //   1681: aload 15
    //   1683: invokestatic 380	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1686: ifeq +8 -> 1694
    //   1689: iload_3
    //   1690: invokestatic 978	com/tencent/mm/plugin/websearch/api/ad:Wb	(I)Ljava/lang/String;
    //   1693: astore_1
    //   1694: invokestatic 888	java/lang/System:currentTimeMillis	()J
    //   1697: invokestatic 891	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1700: astore 15
    //   1702: new 74	java/util/HashMap
    //   1705: dup
    //   1706: invokespecial 75	java/util/HashMap:<init>	()V
    //   1709: astore 18
    //   1711: aload 18
    //   1713: ldc_w 511
    //   1716: ldc_w 1003
    //   1719: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1722: pop
    //   1723: aload 18
    //   1725: ldc_w 537
    //   1728: aload_2
    //   1729: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1732: pop
    //   1733: aload 18
    //   1735: ldc_w 807
    //   1738: aload 16
    //   1740: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1743: pop
    //   1744: aload 18
    //   1746: ldc_w 848
    //   1749: aload_1
    //   1750: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1753: pop
    //   1754: aload 18
    //   1756: ldc_w 958
    //   1759: aload_1
    //   1760: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1763: pop
    //   1764: aload 18
    //   1766: ldc_w 1006
    //   1769: aload 15
    //   1771: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1774: pop
    //   1775: aload 18
    //   1777: ldc_w 1008
    //   1780: aload 15
    //   1782: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1785: pop
    //   1786: aload 18
    //   1788: ldc_w 1010
    //   1791: aload 15
    //   1793: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1796: pop
    //   1797: aload 18
    //   1799: ldc_w 1001
    //   1802: aload 17
    //   1804: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1807: pop
    //   1808: aload 18
    //   1810: ldc_w 1012
    //   1813: iload 4
    //   1815: invokestatic 951	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1818: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1821: pop
    //   1822: new 1014	com/tencent/mm/protocal/protobuf/dnp
    //   1825: dup
    //   1826: invokespecial 1015	com/tencent/mm/protocal/protobuf/dnp:<init>	()V
    //   1829: astore 16
    //   1831: aload 16
    //   1833: invokestatic 1020	com/tencent/mm/plugin/topstory/ui/d:epd	()Ljava/lang/String;
    //   1836: putfield 1023	com/tencent/mm/protocal/protobuf/dnp:qXu	Ljava/lang/String;
    //   1839: aload 16
    //   1841: iload_3
    //   1842: putfield 1024	com/tencent/mm/protocal/protobuf/dnp:scene	I
    //   1845: aload 16
    //   1847: ldc_w 488
    //   1850: putfield 1025	com/tencent/mm/protocal/protobuf/dnp:keN	Ljava/lang/String;
    //   1853: aload 16
    //   1855: aload_2
    //   1856: putfield 1028	com/tencent/mm/protocal/protobuf/dnp:dld	Ljava/lang/String;
    //   1859: aload 16
    //   1861: aload_1
    //   1862: putfield 1030	com/tencent/mm/protocal/protobuf/dnp:sessionId	Ljava/lang/String;
    //   1865: aload 16
    //   1867: aload_1
    //   1868: putfield 1033	com/tencent/mm/protocal/protobuf/dnp:dCW	Ljava/lang/String;
    //   1871: aload 16
    //   1873: iconst_2
    //   1874: putfield 1036	com/tencent/mm/protocal/protobuf/dnp:HBC	I
    //   1877: aload 16
    //   1879: aload 18
    //   1881: invokestatic 1042	com/tencent/mm/plugin/topstory/a/h:l	(Ljava/util/HashMap;)Ljava/lang/String;
    //   1884: putfield 1045	com/tencent/mm/protocal/protobuf/dnp:url	Ljava/lang/String;
    //   1887: aload 16
    //   1889: aload 14
    //   1891: putfield 1048	com/tencent/mm/protocal/protobuf/dnp:Glg	Ljava/lang/String;
    //   1894: aload 16
    //   1896: iload 4
    //   1898: putfield 1051	com/tencent/mm/protocal/protobuf/dnp:cSc	I
    //   1901: aload 16
    //   1903: aload 15
    //   1905: putfield 1054	com/tencent/mm/protocal/protobuf/dnp:dwW	Ljava/lang/String;
    //   1908: aload 16
    //   1910: aload 17
    //   1912: putfield 1057	com/tencent/mm/protocal/protobuf/dnp:DBr	Ljava/lang/String;
    //   1915: aload 16
    //   1917: invokestatic 1060	com/tencent/mm/plugin/websearch/api/ad:Ux	()Ljava/lang/String;
    //   1920: putfield 1063	com/tencent/mm/protocal/protobuf/dnp:srd	Ljava/lang/String;
    //   1923: new 1065	com/tencent/mm/protocal/protobuf/aag
    //   1926: dup
    //   1927: invokespecial 1066	com/tencent/mm/protocal/protobuf/aag:<init>	()V
    //   1930: astore_1
    //   1931: aload_1
    //   1932: ldc_w 1068
    //   1935: putfield 1070	com/tencent/mm/protocal/protobuf/aag:key	Ljava/lang/String;
    //   1938: aload_1
    //   1939: iload 4
    //   1941: i2l
    //   1942: putfield 1073	com/tencent/mm/protocal/protobuf/aag:FZe	J
    //   1945: aload_1
    //   1946: iload 4
    //   1948: invokestatic 951	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1951: putfield 1076	com/tencent/mm/protocal/protobuf/aag:FZf	Ljava/lang/String;
    //   1954: aload 16
    //   1956: getfield 1080	com/tencent/mm/protocal/protobuf/dnp:DBj	Ljava/util/LinkedList;
    //   1959: aload_1
    //   1960: invokevirtual 1085	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1963: pop
    //   1964: invokestatic 149	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1967: aload 16
    //   1969: aload 15
    //   1971: invokestatic 1088	com/tencent/mm/plugin/topstory/ui/d:a	(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/dnp;Ljava/lang/String;)V
    //   1974: goto -1566 -> 408
    //   1977: astore 16
    //   1979: goto -1210 -> 769
    //   1982: iconst_0
    //   1983: istore_3
    //   1984: goto -1529 -> 455
    //   1987: aconst_null
    //   1988: astore 14
    //   1990: goto -1782 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1993	0	this	c
    //   0	1993	1	paramMap	Map<String, Object>
    //   0	1993	2	paramf	com.tencent.mm.plugin.webview.ui.tools.jsapi.f
    //   266	1718	3	i	int
    //   268	1679	4	j	int
    //   1043	239	5	k	int
    //   40	1450	6	m	int
    //   50	1246	7	n	int
    //   138	1194	8	i1	int
    //   349	1240	9	i2	int
    //   359	745	10	i3	int
    //   1053	452	11	i4	int
    //   121	1484	12	bool1	boolean
    //   258	191	13	bool2	boolean
    //   166	41	14	localObject1	Object
    //   416	5	14	localJSONException1	JSONException
    //   433	1556	14	localObject2	Object
    //   92	1878	15	localObject3	Object
    //   64	1904	16	localObject4	Object
    //   1977	1	16	localException	Exception
    //   101	1810	17	str1	String
    //   152	1728	18	localObject5	Object
    //   78	909	19	str2	String
    //   220	219	20	str3	String
    //   458	994	20	localJSONException2	JSONException
    //   339	1181	21	str4	String
    //   311	1151	22	str5	String
    //   889	638	23	str6	String
    // Exception table:
    //   from	to	target	type
    //   176	208	416	org/json/JSONException
    //   230	260	458	org/json/JSONException
    //   438	448	458	org/json/JSONException
    //   278	285	479	java/lang/IllegalArgumentException
    //   702	769	1977	java/lang/Exception
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(77905);
    this.DJV.BrA = true;
    boolean bool1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isTeachPage");
    boolean bool2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isMoreButton");
    int j;
    int i;
    label62:
    String str3;
    String str1;
    String str4;
    int m;
    String str2;
    int k;
    if (com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0) != 1) {
        break label192;
      }
      i = 1;
      str3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "srcUserName");
      str1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sessionId");
      str4 = (String)paramMap.get("navBarColor");
      m = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
      str2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchPlaceHolder");
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
        paramString = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "jumpUrl");
        paramMap = null;
        if (paramf != null) {
          paramMap = paramf.eUJ();
        }
        com.tencent.mm.plugin.webview.modeltools.g.eQR();
        q(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label192:
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label62;
      label232:
      j = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
      int n = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "opType", 0);
      if (n > 0)
      {
        switch (n)
        {
        default: 
          break;
        case 2: 
          a(bl(paramMap), bool1);
          break;
        case 3: 
          paramMap = bl(paramMap);
          if (!w.zD(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          ah.aFS(paramMap.username);
          paramf = new Intent();
          paramf.putExtra("Chat_User", paramMap.username);
          paramf.putExtra("finish_direct", true);
          paramf.putExtra("key_temp_session_show_type", 0);
          paramf.putExtra("preChatTYPE", 9);
          com.tencent.mm.bs.d.f(aj.getContext(), ".ui.chatting.ChattingUI", paramf);
          break;
        case 4: 
          paramString = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "jumpUrl");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eUJ();
          }
          com.tencent.mm.plugin.webview.modeltools.g.eQR();
          q(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str4 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
        k = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
        str3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchId");
        paramf = new Intent();
        paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
        paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
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
            paramString.put("query", com.tencent.mm.compatible.util.q.encode(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(m));
            paramString.put("isWeAppMore", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.aDB();
            paramString.put("sessionId", paramMap);
            str1 = com.tencent.mm.plugin.websearch.api.ad.Wb(bt.aRe((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramf.putExtra("subSessionId", str1);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.aY(paramString));
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
          paramMap = com.tencent.mm.plugin.websearch.api.ad.a(k, false, j, paramString);
          try
          {
            paramMap.put("query", com.tencent.mm.compatible.util.q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = com.tencent.mm.plugin.websearch.api.ad.Wb(bt.aRe((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramf.putExtra("subSessionId", paramString);
            paramf.putExtra("rawUrl", g(k, paramMap));
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "jumpUrl");
          str1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "publishId");
          i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "payScene", 0);
          j = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          str2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "cookie");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.eUJ();
          }
          if (!bt.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.eQR();
            a(paramString, paramMap, k, str4, str1, i, str3, j, m, str2);
          }
          break;
        case 8: 
          com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "snsid");
          paramf = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "objectXmlDesc");
          paramString = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "userName");
          bool1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.eQR();
          z(paramf, paramString, bool1);
          break;
        case 1: 
          a(bl(paramMap), false);
          break;
        case 32: 
          a(bm(paramMap));
        }
      }
    }
  }
  
  public final boolean bh(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (ag.DCd == null) {
        ag.eMk();
      }
      ag.DCd.nDj.clear();
      paramMap = aj.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = ag.bnU();
        localObject2 = Base64.encodeToString(ag.DCd.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
      int j = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.lND > 1000L)
      {
        this.lND = System.currentTimeMillis();
        if (!com.tencent.mm.plugin.websearch.api.ad.Wd(0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          am.L(i, j, af.aFQ("searchID"));
          paramMap = com.tencent.mm.plugin.websearch.api.ad.eMd();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.ad.aY(com.tencent.mm.plugin.websearch.api.ad.f(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "webview_instance_id", -1));
          i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
          paramMap = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
          if ((i != 20) || (bt.isNullOrNil(paramMap)))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO.g(136, (Bundle)localObject2);
              }
            }
            catch (Exception paramMap)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final boolean bi(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    int k = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    int m = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "requestType", 0);
    int j = bt.m(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    Object localObject1 = (String)paramMap.get("guideInfo");
    Object localObject2 = (String)paramMap.get("sessionId");
    boolean bool = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "ignoreCache");
    Object localObject3;
    if (m == 0)
    {
      paramMap = B(i, k, true);
      if (this.DJS.get(paramMap) == null)
      {
        localObject3 = new b((byte)0);
        ((b)localObject3).iU(i, k);
        this.DJS.put(paramMap, localObject3);
      }
      paramMap = (b)this.DJS.get(paramMap);
      if ((paramMap.isAvailable()) && (!bool))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.DKg), Long.valueOf(paramMap.DKh), Integer.valueOf(paramMap.type), paramMap.duO });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).e(m, paramMap.duO, 1, str);
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          am.a(paramMap.scene, 0, paramMap.pLL, paramMap.type, 2, paramMap.eOc(), 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77902);
        return false;
        am.a(paramMap.scene, 0, paramMap.pLL, paramMap.type, 1, "", 0);
        continue;
        com.tencent.mm.kernel.g.aiU().a(1048, this);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[] { Integer.valueOf(j) });
        paramMap = ac.iM(aj.getContext());
        long l = af.aFP("discoverSearchEntry").optLong("guideParam");
        this.DJT = new y(i, k, com.tencent.mm.plugin.websearch.api.ad.We(0), j, paramMap, l, str, (String)localObject2, (String)localObject1);
        com.tencent.mm.kernel.g.aiU().a(this.DJT, 0);
      }
    }
    paramMap = ah.eMm();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        localObject3 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        i = paramMap.nDj.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject = new JSONObject();
          Object localObject4 = (cbk)paramMap.nDj.get(i);
          if (!w.zD(((cbk)localObject4).Username)) {
            break label715;
          }
          localObject4 = com.tencent.mm.am.g.eS(((cbk)localObject4).Username);
          if (localObject4 == null) {
            break label715;
          }
          localJSONObject.put("avatarUrl", ((com.tencent.mm.api.c)localObject4).field_brandIconURL);
          localJSONObject.put("userName", ((com.tencent.mm.api.c)localObject4).field_username);
          localJSONObject.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(((com.tencent.mm.api.c)localObject4).field_username));
          localJSONArray.put(localJSONObject);
          break label715;
        }
        ((JSONObject)localObject3).put("items", localJSONArray);
        ((JSONObject)localObject3).put("type", 5);
        ((JSONObject)localObject3).put("title", "");
        ((JSONArray)localObject2).put(localObject3);
        ((JSONObject)localObject1).put("data", localObject2);
        paramMap = ((JSONObject)localObject1).toString();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(j).e(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label715:
      i -= 1;
    }
  }
  
  public final boolean bj(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 201);
    int i = bt.m(paramMap.get("webview_instance_id"), -1);
    Object localObject = Ww(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf;
    String str;
    if (localObject != null)
    {
      localf = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i);
      str = ((g)localObject).duO;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localf.q(str, 1, i, ((g)localObject).DKo);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.g.aiU().a(1866, this);
        localObject = new e(paramMap, j, 0);
        if (paramMap != null) {
          ((e)localObject).dCT = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    cup localcup = new cup();
    localcup.Hmu = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "logString");
    com.tencent.mm.kernel.g.aiU().a(1134, this);
    paramMap = new z(localcup);
    com.tencent.mm.kernel.g.aiU().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bo(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77918);
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    final int j = bt.aRe((String)paramMap.get("offset"));
    final int k = bt.aRe((String)paramMap.get("count"));
    final int m = bt.m(paramMap.get("webview_instance_id"), -1);
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
      if (this.DJY.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.DJX == null) {
        this.DJX = new com.tencent.mm.plugin.websearch.a.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.a.a.d(str, (List)localObject);
      if (this.DJY == null) {}
    }
    this.DJY = paramMap;
    this.DJX.a(paramMap, new c.a()
    {
      public final void eMD()
      {
        AppMethodBeat.i(77889);
        c.a(c.this.DJY, j, k, m);
        AppMethodBeat.o(77889);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.DJY.dlh) {
        a(this.DJY, j, k, m);
      }
    }
  }
  
  public final boolean bp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "md5");
    int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "offset", 0);
    String str2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchId");
    String str3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sessionId");
    int j = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "tab", 0);
    String str4 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "requestId");
    int k = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    int m = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "webview_instance_id", -1);
    String str5 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "emojiUrl");
    paramMap = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "aesKey");
    if (this.DJZ != null)
    {
      com.tencent.mm.kernel.g.aiU().a(this.DJZ);
      com.tencent.mm.kernel.g.aiU().b(2999, this);
    }
    com.tencent.mm.kernel.g.aiU().a(2999, this);
    this.DJZ = new d(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.DJZ.dCT = m;
    com.tencent.mm.kernel.g.aiU().a(this.DJZ, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final boolean bq(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77921);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "doSearchWebQuery %s", new Object[] { paramMap.toString() });
    String str1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "requestId");
    String str2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "commReq");
    int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "webview_instance_id", -1);
    com.tencent.mm.kernel.g.aiU().a(2975, this);
    com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.plugin.websearch.api.t(str1, str2, i), 0);
    AppMethodBeat.o(77921);
    return false;
  }
  
  public final String eOb()
  {
    AppMethodBeat.i(77901);
    Object localObject = B(20, 0, true);
    if (this.DJS.get(localObject) == null)
    {
      b localb = new b((byte)0);
      localb.iU(20, 0);
      this.DJS.put(localObject, localb);
    }
    localObject = (b)this.DJS.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).duO; bt.isNullOrNil((String)localObject); localObject = "")
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
    if ((paramn instanceof y))
    {
      com.tencent.mm.kernel.g.aiU().b(1048, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (y)paramn;
      localObject1 = new b((byte)0);
      ((b)localObject1).scene = paramString.scene;
      ((b)localObject1).DKg = paramString.DBA.GRw;
      ((b)localObject1).duO = paramString.DBA.GDb;
      ((b)localObject1).DKh = (System.currentTimeMillis() / 1000L);
      ((b)localObject1).pLL = paramString.DBA.GRx;
      ((b)localObject1).type = paramString.businessType;
      paramn = B(((b)localObject1).scene, ((b)localObject1).type, true);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { ((b)localObject1).duO });
      if (!bt.isNullOrNil(((b)localObject1).duO))
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.dCT).e(0, ((b)localObject1).duO, 0, paramString.dwW);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { ((b)localObject1).duO });
      }
      this.DJS.put(paramn, localObject1);
      if (((b)localObject1).DKg == 0L)
      {
        paramInt1 = ((b)localObject1).scene;
        paramInt2 = ((b)localObject1).type;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = com.tencent.mm.plugin.record.b.azD();
        paramn = new com.tencent.mm.vfs.e(paramString, B(paramInt1, paramInt2, true));
        if (paramn.exists()) {
          paramn.delete();
        }
        paramString = new com.tencent.mm.vfs.e(paramString, B(paramInt1, paramInt2, false));
        if (paramString.exists()) {
          paramString.delete();
        }
      }
      while ((((b)localObject1).scene == 20) && (((b)localObject1).type == 0))
      {
        am.a(((b)localObject1).scene, 1, ((b)localObject1).pLL, ((b)localObject1).type, 2, ((b)localObject1).eOc(), 1);
        AppMethodBeat.o(77913);
        return;
        paramn = new bxh();
        paramn.scene = ((b)localObject1).scene;
        paramn.GDb = ((b)localObject1).duO;
        paramn.GRp = ((b)localObject1).DKg;
        paramn.GRq = ((b)localObject1).DKh;
        paramn.FMt = ((b)localObject1).pLL;
        paramn.nEf = ((b)localObject1).type;
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
          paramn = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.record.b.azD(), B(((b)localObject1).scene, ((b)localObject1).type, true));
          if (!paramn.fOJ().exists()) {
            paramn.fOJ().mkdirs();
          }
          if (paramn.exists()) {
            paramn.delete();
          }
          i.f(com.tencent.mm.vfs.q.B(paramn.fOK()), paramString, paramString.length);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(paramn.fOK()), Integer.valueOf(paramString.length) });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
        }
      }
      am.a(((b)localObject1).scene, 1, ((b)localObject1).pLL, ((b)localObject1).type, 1, "", 0);
      AppMethodBeat.o(77913);
    }
    else
    {
      if ((paramn instanceof z))
      {
        com.tencent.mm.kernel.g.aiU().b(1134, this);
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof e))
      {
        com.tencent.mm.kernel.g.aiU().b(1866, this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(77913);
          return;
        }
        paramString = (e)paramn;
        if (paramString.dCT != -1) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.dCT).q(((ebu)paramString.rr.hNL.hNQ).duO, 0, 0, 0);
        }
        if (paramString.DKq != null) {
          this.DJU.put(Integer.valueOf(paramString.DKq.scene), paramString.DKq);
        }
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof d))
      {
        com.tencent.mm.kernel.g.aiU().b(2999, this);
        localObject1 = (d)paramn;
        paramn = bt.bI(((d)localObject1).DKp.GDb, "");
        if (((d)localObject1).dCT != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(((d)localObject1).dCT);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("fts_key_json_data", paramn);
          ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
          ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO.g(152, (Bundle)localObject2);
            }
            AppMethodBeat.o(77913);
            return;
          }
          catch (Exception paramString) {}
        }
        AppMethodBeat.o(77913);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.t))
      {
        localObject2 = (com.tencent.mm.plugin.websearch.api.t)paramn;
        com.tencent.mm.kernel.g.aiU().b(2975, this);
        paramn = bt.bI(((eea)((com.tencent.mm.plugin.websearch.api.t)localObject2).rr.hNL.hNQ).HPm, "");
        if (((com.tencent.mm.plugin.websearch.api.t)localObject2).dCT != -1)
        {
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(((com.tencent.mm.plugin.websearch.api.t)localObject2).dCT);
          localObject2 = ((com.tencent.mm.plugin.websearch.api.t)localObject2).dwW;
          localBundle = new Bundle();
          localBundle.putString("fts_key_id", (String)localObject2);
          localBundle.putString("fts_key_json_data", paramn);
          localBundle.putString("fts_key_err_msg", paramString);
          localBundle.putInt("fts_key_ret_code", paramInt2);
          try
          {
            if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO != null) {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).DNO.g(153, localBundle);
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
    long DKg;
    long DKh;
    String duO;
    boolean gtV = false;
    private String kUp = null;
    String pLL;
    int scene;
    int type;
    
    private b() {}
    
    final String eOc()
    {
      AppMethodBeat.i(77892);
      if (this.kUp == null) {
        this.kUp = "";
      }
      try
      {
        localObject = new JSONObject(this.duO).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.kUp = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.kUp;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final void iU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      bxh localbxh = new bxh();
      Object localObject1 = com.tencent.mm.plugin.record.b.azD();
      Object localObject2 = c.B(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(c.B(paramInt1, paramInt2, true))) {
        this.gtV = true;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1, (String)localObject2);
      localObject2 = i.aY(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK()), 0, (int)((com.tencent.mm.vfs.e)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localbxh.parseFrom((byte[])localObject2);
          this.scene = localbxh.scene;
          this.duO = localbxh.GDb;
          this.DKg = localbxh.GRp;
          this.DKh = localbxh.GRq;
          this.pLL = localbxh.FMt;
          this.type = localbxh.nEf;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK()), Integer.valueOf(localObject2.length) });
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
      if (this.gtV)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((bt.isNullOrNil(this.duO)) || (System.currentTimeMillis() / 1000L - this.DKh > this.DKg))
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
    public int DKi;
    public boolean DKj;
    public String DKk;
    public int DKl;
    public int dDa;
    public String keN;
    public String nickname;
    public int position;
    public String query;
    public int scene;
    public String signature;
    public String username;
    public String wQe;
    public acf wRt;
    
    private c() {}
  }
  
  final class d
  {
    public int DKm;
    public String country;
    public int ePk;
    public String ePu;
    public String ePv;
    public String ffB;
    public String nickname;
    public String query;
    public int scene;
    public String signature;
    public String username;
    
    private d() {}
  }
  
  static final class g
  {
    public long DKh;
    public int DKo;
    public String duO;
    public long interval;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.duO = "";
      this.interval = 0L;
      this.DKh = 0L;
      this.DKo = 0;
    }
    
    public g(int paramInt1, ebu paramebu, int paramInt2)
    {
      AppMethodBeat.i(207809);
      this.scene = 0;
      this.duO = "";
      this.interval = 0L;
      this.DKh = 0L;
      this.DKo = 0;
      this.scene = paramInt1;
      this.duO = paramebu.duO;
      this.interval = paramebu.guN;
      this.DKh = (System.currentTimeMillis() / 1000L);
      this.DKo = paramInt2;
      AppMethodBeat.o(207809);
    }
    
    /* Error */
    public static g Wx(int paramInt)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 64	com/tencent/mm/vfs/e
      //   8: dup
      //   9: invokestatic 70	com/tencent/mm/plugin/record/b:azD	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 74	com/tencent/mm/plugin/webview/fts/c$g:Wy	(I)Ljava/lang/String;
      //   16: invokespecial 77	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 81	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
      //   24: invokestatic 87	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual 90	com/tencent/mm/vfs/e:length	()J
      //   32: l2i
      //   33: invokestatic 96	com/tencent/mm/vfs/i:aY	(Ljava/lang/String;II)[B
      //   36: astore_1
      //   37: new 98	com/tencent/mm/protocal/protobuf/bxi
      //   40: dup
      //   41: invokespecial 99	com/tencent/mm/protocal/protobuf/bxi:<init>	()V
      //   44: astore_2
      //   45: aload_2
      //   46: aload_1
      //   47: invokevirtual 103	com/tencent/mm/protocal/protobuf/bxi:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   50: pop
      //   51: new 2	com/tencent/mm/plugin/webview/fts/c$g
      //   54: dup
      //   55: invokespecial 104	com/tencent/mm/plugin/webview/fts/c$g:<init>	()V
      //   58: astore_1
      //   59: aload_1
      //   60: aload_2
      //   61: getfield 107	com/tencent/mm/protocal/protobuf/bxi:Scene	I
      //   64: putfield 21	com/tencent/mm/plugin/webview/fts/c$g:scene	I
      //   67: aload_1
      //   68: aload_2
      //   69: getfield 110	com/tencent/mm/protocal/protobuf/bxi:GDb	Ljava/lang/String;
      //   72: putfield 25	com/tencent/mm/plugin/webview/fts/c$g:duO	Ljava/lang/String;
      //   75: aload_1
      //   76: aload_2
      //   77: getfield 113	com/tencent/mm/protocal/protobuf/bxi:GRr	J
      //   80: putfield 27	com/tencent/mm/plugin/webview/fts/c$g:interval	J
      //   83: aload_1
      //   84: aload_2
      //   85: getfield 116	com/tencent/mm/protocal/protobuf/bxi:GRq	J
      //   88: putfield 29	com/tencent/mm/plugin/webview/fts/c$g:DKh	J
      //   91: aload_1
      //   92: aload_2
      //   93: getfield 119	com/tencent/mm/protocal/protobuf/bxi:GRs	I
      //   96: putfield 31	com/tencent/mm/plugin/webview/fts/c$g:DKo	I
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
      //   44	49	2	localbxi	com.tencent.mm.protocal.protobuf.bxi
      //   112	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   37	59	106	java/lang/Exception
      //   59	99	112	java/lang/Exception
    }
    
    static String Wy(int paramInt)
    {
      AppMethodBeat.i(77896);
      String str = ac.iM(aj.getContext());
      str = "SearchGuide_" + paramInt + "-" + str;
      AppMethodBeat.o(77896);
      return str;
    }
    
    public final boolean isExpired()
    {
      AppMethodBeat.i(77897);
      if (this.DKh + this.interval <= System.currentTimeMillis() / 1000L)
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
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */