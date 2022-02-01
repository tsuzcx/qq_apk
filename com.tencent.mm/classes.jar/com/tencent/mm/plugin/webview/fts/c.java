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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.b.a.c.a;
import com.tencent.mm.plugin.websearch.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  implements i
{
  h.a INN;
  public Set<Integer> INY;
  public l INZ;
  HashMap<String, b> IOa;
  public ac IOb;
  private Map<Integer, g> IOc;
  public c.e IOd;
  public List<com.tencent.mm.ay.f> IOe;
  private com.tencent.mm.plugin.websearch.b.a.c IOf;
  com.tencent.mm.plugin.websearch.b.a.d IOg;
  private d IOh;
  public IListener lEl;
  private long mZq;
  
  public c()
  {
    AppMethodBeat.i(77898);
    this.INZ = new c.1(this);
    this.INN = new h.a()
    {
      public final void a(h.b paramAnonymousb)
      {
        AppMethodBeat.i(210819);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "handleCallback %s", new Object[] { paramAnonymousb });
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(210819);
          return;
        }
        int i = ((Integer)paramAnonymousb.IOM).intValue();
        paramAnonymousb = (c.h)paramAnonymousb.ION;
        if ((paramAnonymousb == null) || (paramAnonymousb.IOz == null))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd netResult invalid");
          AppMethodBeat.o(210819);
          return;
        }
        if ((paramAnonymousb.errType != 0) || (paramAnonymousb.errCode != 0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramAnonymousb.errType), Integer.valueOf(paramAnonymousb.errCode) });
          paramAnonymousb = paramAnonymousb.IOz;
          if (paramAnonymousb != null) {
            ah.a(paramAnonymousb.scene, paramAnonymousb.sessionId, "", "", paramAnonymousb.dPI, false, "", paramAnonymousb.getType());
          }
          AppMethodBeat.o(210819);
          return;
        }
        paramAnonymousb = paramAnonymousb.IOz;
        ah.a(paramAnonymousb.scene, paramAnonymousb.sessionId, "", "", paramAnonymousb.dPI, true, "", paramAnonymousb.getType());
        c.b localb = new c.b();
        localb.scene = paramAnonymousb.scene;
        localb.IOq = paramAnonymousb.IEi.Mrk;
        localb.dNA = paramAnonymousb.IEi.MaZ;
        localb.IOr = (System.currentTimeMillis() / 1000L);
        localb.rjq = paramAnonymousb.IEi.Mbb;
        localb.type = paramAnonymousb.businessType;
        Object localObject = c.G(localb.scene, localb.type, true);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { localb.dNA });
        if (!Util.isNullOrNil(localb.dNA))
        {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).e(0, localb.dNA, 0, paramAnonymousb.dPI);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { localb.dNA });
        }
        c.this.IOa.put(localObject, localb);
        if (localb.IOq == 0L)
        {
          i = localb.scene;
          int j = localb.type;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramAnonymousb = com.tencent.mm.plugin.record.b.aTb();
          localObject = new o(paramAnonymousb, c.G(i, j, true));
          if (((o)localObject).exists()) {
            ((o)localObject).delete();
          }
          paramAnonymousb = new o(paramAnonymousb, c.G(i, j, false));
          if (paramAnonymousb.exists()) {
            paramAnonymousb.delete();
          }
        }
        while ((localb.scene == 20) && (localb.type == 0))
        {
          ar.a(localb.scene, 1, localb.rjq, localb.type, 2, localb.gax(), 1);
          AppMethodBeat.o(210819);
          return;
          localObject = new clt();
          ((clt)localObject).scene = localb.scene;
          ((clt)localObject).MaZ = localb.dNA;
          ((clt)localObject).Mre = localb.IOq;
          ((clt)localObject).Mrf = localb.IOr;
          ((clt)localObject).KZj = localb.rjq;
          ((clt)localObject).oUv = localb.type;
          paramAnonymousb = null;
          try
          {
            localObject = ((clt)localObject).toByteArray();
            paramAnonymousb = (h.b)localObject;
          }
          catch (IOException localIOException)
          {
            label603:
            break label603;
          }
          if (paramAnonymousb != null)
          {
            localObject = new o(com.tencent.mm.plugin.record.b.aTb(), c.G(localb.scene, localb.type, true));
            if (!((o)localObject).heq().exists()) {
              ((o)localObject).heq().mkdirs();
            }
            if (((o)localObject).exists()) {
              ((o)localObject).delete();
            }
            s.f(aa.z(((o)localObject).her()), paramAnonymousb, paramAnonymousb.length);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { aa.z(((o)localObject).her()), Integer.valueOf(paramAnonymousb.length) });
          }
          else
          {
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
          }
        }
        ar.a(localb.scene, 1, localb.rjq, localb.type, 1, "", 0);
        AppMethodBeat.o(210819);
      }
    };
    this.IOc = new HashMap();
    this.IOd = new c.e(this);
    this.lEl = new c.4(this);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.IOa = new HashMap();
    this.INY = Collections.synchronizedSet(new HashSet());
    EventCenter.instance.addListener(this.lEl);
    com.tencent.mm.kernel.g.azz().a(2975, this);
    AppMethodBeat.o(77898);
  }
  
  private static void B(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((n)com.tencent.mm.kernel.g.af(n.class)).PM(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localTimeLineObject.Id).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localTimeLineObject.toByteArray());
      label76:
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      AppMethodBeat.o(77909);
      return;
    }
    catch (IOException paramString2)
    {
      break label76;
    }
  }
  
  static String G(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(77916);
    String str1 = "FTS_BizCacheObj" + paramInt1 + "-" + paramInt2;
    String str2 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    str2 = str1 + "-" + str2;
    if (paramBoolean)
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    if (new o(com.tencent.mm.plugin.record.b.aTb(), str2).exists())
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    AppMethodBeat.o(77916);
    return str1;
  }
  
  static void a(com.tencent.mm.plugin.websearch.b.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77919);
    paramd = paramd.kd(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramInt3).cd(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.IOv != 0) {
      i = paramc.IOv;
    }
    for (;;)
    {
      am.aXh(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.BdC);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.IOs);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.BeX != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.BeX.toByteArray());
        label124:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.hes);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.IOu);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.dVS == 2)
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
          if (paramc.IOt)
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
        break label124;
      }
    }
  }
  
  private static void a(d paramd)
  {
    AppMethodBeat.i(77910);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramd.username);
    localIntent.putExtra("Contact_Nick", paramd.nickname);
    localIntent.putExtra("Contact_Alias", paramd.fMb);
    localIntent.putExtra("Contact_Sex", paramd.fuA);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramd.country, paramd.fuJ, paramd.fuK));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.IOw);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5)
  {
    AppMethodBeat.i(210828);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("convertActivityFromTranslucent", false);
    localIntent.putExtra("customize_status_bar_color", paramInt1);
    localIntent.putExtra("status_bar_style", paramString2);
    localIntent.putExtra("from_scence", paramInt3);
    localIntent.putExtra("subtype", paramInt4);
    localIntent.putExtra("key_h5pay_cookie", paramString5);
    if (!Util.isNullOrNil(paramString3))
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
      if (!Util.isNullOrNil(paramString4)) {
        localIntent.putExtra("srcUsername", paramString4);
      }
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", localIntent);
      AppMethodBeat.o(210828);
      return;
      if ((paramBundle != null) && (!Util.isNullOrNil(paramString1)))
      {
        paramString1 = paramBundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
        localIntent.putExtra("prePublishId", paramString1);
        localIntent.putExtra("KPublisherId", paramString1);
      }
    }
  }
  
  private static String aeL(String paramString)
  {
    AppMethodBeat.i(210827);
    try
    {
      String str = com.tencent.mm.compatible.util.q.encode(paramString, "utf-8");
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
    AppMethodBeat.o(210827);
    return paramString;
  }
  
  public static boolean bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210833);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "showNavBarShadow %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        int i = ai.b(paramMap, "webview_instance_id", -1);
        localObject = ai.N(paramMap, "color");
        double d = Double.valueOf(paramMap.get("alpha").toString()).doubleValue();
        paramMap = ((String)localObject).substring(1, ((String)localObject).length());
        int j = (int)(d * 255.0D);
        int k = Integer.parseInt(paramMap, 16);
        paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fts_key_data", k);
        ((Bundle)localObject).putInt("fts_key_cache", j);
      }
      catch (Throwable paramMap)
      {
        Object localObject;
        continue;
      }
      try
      {
        if (paramMap.ISw != null) {
          paramMap.ISw.f(155, (Bundle)localObject);
        }
        AppMethodBeat.o(210833);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "showNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210834);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hideNavBarShadow");
    for (;;)
    {
      try
      {
        paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(ai.b(paramMap, "webview_instance_id", -1));
      }
      catch (Throwable paramMap)
      {
        continue;
      }
      try
      {
        if (paramMap.ISw != null) {
          paramMap.ISw.f(156, new Bundle());
        }
        AppMethodBeat.o(210834);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "hideNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  private c bs(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = ai.N(paramMap, "userName");
    localc.nickname = ai.N(paramMap, "nickName");
    localc.BdC = ai.N(paramMap, "headHDImgUrl");
    localc.IOs = ai.b(paramMap, "verifyFlag", 0);
    localc.signature = ai.N(paramMap, "signature");
    localc.scene = ai.b(paramMap, "scene", 0);
    localc.dVS = ai.b(paramMap, "sceneActionType", 1);
    localc.BeX = new aeq();
    localc.BeX.kem = ai.b(paramMap, "brandFlag", 0);
    localc.BeX.kep = ai.N(paramMap, "iconUrl");
    localc.BeX.keo = ai.N(paramMap, "brandInfo");
    localc.BeX.ken = ai.N(paramMap, "externalInfo");
    localc.hes = ai.N(paramMap, "searchId");
    localc.query = ai.N(paramMap, "query");
    localc.position = ai.b(paramMap, "position", 0);
    localc.IOt = ai.O(paramMap, "isCurrentDetailPage");
    localc.IOu = ai.N(paramMap, "extraParams");
    localc.IOv = ai.b(paramMap, "friendScene", 0);
    AppMethodBeat.o(77914);
    return localc;
  }
  
  private d bt(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = ai.N(paramMap, "userName");
    locald.nickname = ai.N(paramMap, "nickName");
    locald.fMb = ai.N(paramMap, "alias");
    locald.signature = ai.N(paramMap, "signature");
    locald.fuA = ai.b(paramMap, "sex", 0);
    locald.country = ai.N(paramMap, "country");
    locald.fuK = ai.N(paramMap, "city");
    locald.fuJ = ai.N(paramMap, "province");
    locald.IOw = ai.b(paramMap, "snsFlag", 0);
    String str = ai.N(paramMap, "query");
    if (!Util.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(ai.N(paramMap, "matchType"))) {
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
  
  public static boolean bu(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = ai.N(paramMap, "word");
    boolean bool1 = ai.O(paramMap, "isInputChange");
    String str2 = ai.N(paramMap, "custom");
    String str3 = ai.N(paramMap, "tagList");
    boolean bool2 = ai.O(paramMap, "cache");
    paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(Util.nullAsInt(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool1);
    localBundle.putString("fts_key_tag_list", str3);
    localBundle.putBoolean("fts_key_cache", bool2);
    try
    {
      if (paramMap.ISw != null) {
        paramMap.ISw.f(122, localBundle);
      }
      AppMethodBeat.o(77917);
      return false;
    }
    catch (RemoteException paramMap)
    {
      for (;;)
      {
        Log.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bx(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210830);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", ai.N(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(ai.N(paramMap, "extInfo")));
      localJSONObject.put("extraInfo", ai.N(paramMap, "extraInfo"));
      paramMap = new Intent();
      paramMap.putExtra("tab_type", 8);
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(6, 2, 25, paramMap);
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), localJSONObject.toString(), paramMap);
      label143:
      AppMethodBeat.o(210830);
      return false;
    }
    catch (Exception paramMap)
    {
      break label143;
    }
  }
  
  public static boolean by(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210831);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getCurrentLocation %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        i = ai.b(paramMap, "webview_instance_id", -1);
        paramMap = ai.clJ();
        if (paramMap == null) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("latitude", paramMap.LbD);
        localJSONObject.put("longitude", paramMap.LbC);
        localJSONObject.put("precision", paramMap.LuT);
        localJSONObject.put("macAddr", paramMap.LbD);
        localJSONObject.put("cellId", paramMap.LbD);
        localJSONObject.put("gpsSource", paramMap.LbD);
        localJSONObject.put("address", paramMap.LbD);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).baW(localJSONObject.toString());
      }
      catch (Exception paramMap)
      {
        int i;
        continue;
      }
      AppMethodBeat.o(210831);
      return false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).baW("");
    }
  }
  
  public static boolean bz(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(210832);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "navControl %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        int i = ai.b(paramMap, "webview_instance_id", -1);
        paramMap = ai.N(paramMap, "action");
        localf = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i);
        localBundle = new Bundle();
        localBundle.putString("fts_key_data", paramMap);
      }
      catch (Exception paramMap)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf;
        Bundle localBundle;
        continue;
      }
      try
      {
        if (localf.ISw != null) {
          localf.ISw.f(154, localBundle);
        }
        AppMethodBeat.o(210832);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "onNavControl exception" + paramMap.getMessage());
      }
    }
  }
  
  public static int d(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(77912);
    paramMap1 = ai.N(paramMap1, "data");
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
        Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap1, "", new Object[0]);
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject);
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
  
  private static String i(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(77922);
    switch (paramInt)
    {
    default: 
      paramMap = ai.bd(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    case 201: 
      paramMap = a.bd(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    }
    paramMap = ai.g(paramMap, 1);
    AppMethodBeat.o(77922);
    return paramMap;
  }
  
  private static void p(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", 0, "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle u(int paramInt, Bundle paramBundle)
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
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.gds().gaw());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", ak.aXe(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = ak.aXe("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = ai.h(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", ak.aXf(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  /* Error */
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf)
  {
    // Byte code:
    //   0: ldc_w 916
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 97
    //   8: ldc_w 918
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: invokevirtual 522	java/lang/Object:toString	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_1
    //   26: ldc_w 920
    //   29: invokeinterface 521 2 0
    //   34: checkcast 469	java/lang/String
    //   37: invokestatic 923	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   40: istore 6
    //   42: aload_1
    //   43: ldc_w 900
    //   46: iconst_0
    //   47: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   50: istore 7
    //   52: aload_1
    //   53: ldc_w 925
    //   56: invokeinterface 521 2 0
    //   61: checkcast 469	java/lang/String
    //   64: astore 16
    //   66: aload_1
    //   67: ldc_w 927
    //   70: invokeinterface 521 2 0
    //   75: checkcast 469	java/lang/String
    //   78: astore 19
    //   80: aload_1
    //   81: ldc_w 929
    //   84: invokeinterface 521 2 0
    //   89: checkcast 469	java/lang/String
    //   92: astore 15
    //   94: aload_1
    //   95: ldc_w 931
    //   98: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 17
    //   103: ldc_w 933
    //   106: aload_1
    //   107: ldc_w 935
    //   110: invokeinterface 521 2 0
    //   115: checkcast 469	java/lang/String
    //   118: invokevirtual 667	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 12
    //   123: aload_1
    //   124: ldc_w 895
    //   127: invokeinterface 521 2 0
    //   132: checkcast 469	java/lang/String
    //   135: invokestatic 923	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   138: istore 8
    //   140: aload_1
    //   141: ldc_w 909
    //   144: invokeinterface 521 2 0
    //   149: invokestatic 938	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: astore 18
    //   154: aload_1
    //   155: ldc_w 940
    //   158: invokeinterface 521 2 0
    //   163: checkcast 469	java/lang/String
    //   166: astore 14
    //   168: aload 14
    //   170: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +259 -> 432
    //   176: new 708	org/json/JSONObject
    //   179: dup
    //   180: aload 14
    //   182: invokespecial 718	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 14
    //   187: aload 14
    //   189: ldc_w 942
    //   192: invokevirtual 810	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +1795 -> 1990
    //   198: aload 14
    //   200: ldc_w 942
    //   203: invokevirtual 945	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 14
    //   208: aload_1
    //   209: ldc_w 947
    //   212: invokeinterface 521 2 0
    //   217: checkcast 469	java/lang/String
    //   220: astore 20
    //   222: aload 20
    //   224: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   227: ifne +247 -> 474
    //   230: new 708	org/json/JSONObject
    //   233: dup
    //   234: aload 20
    //   236: invokespecial 718	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   239: ldc_w 949
    //   242: ldc_w 951
    //   245: invokevirtual 953	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 20
    //   250: aload 20
    //   252: ldc_w 955
    //   255: invokevirtual 667	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: istore 13
    //   260: iload 13
    //   262: ifeq +176 -> 438
    //   265: iconst_1
    //   266: istore_3
    //   267: iconst_0
    //   268: istore 4
    //   270: aload 15
    //   272: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   275: ifne +10 -> 285
    //   278: aload 15
    //   280: invokestatic 960	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   283: istore 4
    //   285: aload_1
    //   286: ldc_w 962
    //   289: invokeinterface 521 2 0
    //   294: checkcast 469	java/lang/String
    //   297: astore 20
    //   299: aload_1
    //   300: ldc_w 964
    //   303: invokeinterface 521 2 0
    //   308: checkcast 469	java/lang/String
    //   311: astore 22
    //   313: aload_1
    //   314: ldc_w 966
    //   317: invokeinterface 521 2 0
    //   322: checkcast 469	java/lang/String
    //   325: astore 15
    //   327: aload_1
    //   328: ldc_w 968
    //   331: invokeinterface 521 2 0
    //   336: checkcast 469	java/lang/String
    //   339: astore 21
    //   341: aload_1
    //   342: ldc_w 596
    //   345: iconst_0
    //   346: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   349: istore 9
    //   351: aload_1
    //   352: ldc_w 970
    //   355: iconst_0
    //   356: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   359: istore 10
    //   361: iload 6
    //   363: tableswitch	default:+45 -> 408, 1:+150->513, 2:+446->809, 3:+510->873, 4:+45->408, 5:+1282->1645, 6:+45->408, 7:+510->873, 8:+321->684
    //   409: iconst_0
    //   410: lcmp
    //   411: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 14
    //   418: ldc 97
    //   420: aload 14
    //   422: ldc_w 782
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 835	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aconst_null
    //   433: astore 14
    //   435: goto -227 -> 208
    //   438: aload 20
    //   440: ldc_w 972
    //   443: invokevirtual 667	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: istore 13
    //   448: iload 13
    //   450: ifeq +1535 -> 1985
    //   453: iconst_2
    //   454: istore_3
    //   455: goto -188 -> 267
    //   458: astore 20
    //   460: ldc 97
    //   462: aload 20
    //   464: ldc_w 782
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 835	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -209 -> 267
    //   479: astore_1
    //   480: ldc 97
    //   482: new 221	java/lang/StringBuilder
    //   485: dup
    //   486: ldc_w 974
    //   489: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   492: aload_1
    //   493: invokevirtual 975	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   496: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 978	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: ldc_w 916
    //   508: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iconst_1
    //   512: ireturn
    //   513: iload 7
    //   515: lookupswitch	default:+33->548, 1:+146->661, 8:+97->612, 32:+158->673
    //   549: ldc_w 980
    //   552: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   555: astore_1
    //   556: ldc 97
    //   558: ldc_w 982
    //   561: iconst_1
    //   562: anewarray 4	java/lang/Object
    //   565: dup
    //   566: iconst_0
    //   567: aload_1
    //   568: aastore
    //   569: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: aload_2
    //   573: invokevirtual 986	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:ghB	()Landroid/os/Bundle;
    //   576: astore_2
    //   577: aload_1
    //   578: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   581: ifne -173 -> 408
    //   584: invokestatic 863	com/tencent/mm/plugin/webview/modeltools/g:gds	()Lcom/tencent/mm/plugin/webview/fts/c;
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
    //   603: ldc_w 782
    //   606: invokestatic 854	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;)V
    //   609: goto -201 -> 408
    //   612: aload_1
    //   613: ldc_w 988
    //   616: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   619: pop
    //   620: aload_1
    //   621: ldc_w 990
    //   624: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   627: astore_2
    //   628: aload_1
    //   629: ldc_w 588
    //   632: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   635: astore 14
    //   637: aload_1
    //   638: ldc_w 992
    //   641: invokestatic 629	com/tencent/mm/plugin/websearch/api/ai:O	(Ljava/util/Map;Ljava/lang/String;)Z
    //   644: istore 12
    //   646: invokestatic 863	com/tencent/mm/plugin/webview/modeltools/g:gds	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   649: pop
    //   650: aload_2
    //   651: aload 14
    //   653: iload 12
    //   655: invokestatic 994	com/tencent/mm/plugin/webview/fts/c:B	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   658: goto -250 -> 408
    //   661: aload_0
    //   662: aload_1
    //   663: invokespecial 996	com/tencent/mm/plugin/webview/fts/c:bs	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$c;
    //   666: iconst_0
    //   667: invokestatic 998	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$c;Z)V
    //   670: goto -262 -> 408
    //   673: aload_0
    //   674: aload_1
    //   675: invokespecial 1000	com/tencent/mm/plugin/webview/fts/c:bt	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$d;
    //   678: invokestatic 1002	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$d;)V
    //   681: goto -273 -> 408
    //   684: aload_1
    //   685: ldc_w 622
    //   688: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   691: astore 14
    //   693: new 708	org/json/JSONObject
    //   696: dup
    //   697: invokespecial 709	org/json/JSONObject:<init>	()V
    //   700: astore 15
    //   702: aload 15
    //   704: ldc_w 674
    //   707: aload 14
    //   709: invokevirtual 715	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 15
    //   715: ldc_w 807
    //   718: invokestatic 1007	java/lang/System:currentTimeMillis	()J
    //   721: invokestatic 1010	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   724: invokevirtual 715	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 15
    //   730: ldc_w 1012
    //   733: invokestatic 1007	java/lang/System:currentTimeMillis	()J
    //   736: invokestatic 1010	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   739: invokevirtual 715	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload 15
    //   745: ldc_w 1014
    //   748: iconst_1
    //   749: invokevirtual 769	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   752: pop
    //   753: aload 15
    //   755: ldc_w 980
    //   758: aload_1
    //   759: ldc_w 980
    //   762: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   765: invokevirtual 715	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: ldc_w 1016
    //   772: invokestatic 728	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   775: checkcast 1016	com/tencent/mm/plugin/fts/a/n
    //   778: new 221	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   785: aload 14
    //   787: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 1018
    //   793: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: aload 15
    //   801: invokevirtual 733	org/json/JSONObject:toString	()Ljava/lang/String;
    //   804: invokeinterface 1021 3 0
    //   809: aload_1
    //   810: ldc_w 980
    //   813: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   816: astore_1
    //   817: ldc 97
    //   819: ldc_w 982
    //   822: iconst_1
    //   823: anewarray 4	java/lang/Object
    //   826: dup
    //   827: iconst_0
    //   828: aload_1
    //   829: aastore
    //   830: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   833: aload_2
    //   834: invokevirtual 986	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:ghB	()Landroid/os/Bundle;
    //   837: astore_2
    //   838: aload_1
    //   839: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   842: ifne -434 -> 408
    //   845: invokestatic 863	com/tencent/mm/plugin/webview/modeltools/g:gds	()Lcom/tencent/mm/plugin/webview/fts/c;
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
    //   864: ldc_w 782
    //   867: invokestatic 854	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;)V
    //   870: goto -462 -> 408
    //   873: aload_1
    //   874: ldc_w 622
    //   877: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   880: astore 21
    //   882: aload_1
    //   883: ldc_w 621
    //   886: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   889: astore 23
    //   891: new 160	android/content/Intent
    //   894: dup
    //   895: invokespecial 161	android/content/Intent:<init>	()V
    //   898: astore_2
    //   899: aload_2
    //   900: ldc_w 1023
    //   903: getstatic 1029	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzm	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   906: invokevirtual 1032	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   909: pop
    //   910: aload_2
    //   911: ldc_w 1034
    //   914: getstatic 1040	com/tencent/mm/protocal/GeneralControlWrapper:Kzg	Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   917: invokevirtual 1032	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   920: pop
    //   921: aload_2
    //   922: ldc_w 1042
    //   925: iconst_1
    //   926: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   929: pop
    //   930: aload_2
    //   931: ldc_w 1044
    //   934: iconst_1
    //   935: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   938: pop
    //   939: aload_2
    //   940: ldc_w 1046
    //   943: aload 21
    //   945: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   948: pop
    //   949: aload_2
    //   950: ldc_w 1048
    //   953: iload 7
    //   955: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   958: pop
    //   959: aload_2
    //   960: ldc_w 429
    //   963: iload 4
    //   965: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   968: pop
    //   969: aload_2
    //   970: ldc_w 431
    //   973: aload 20
    //   975: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   978: pop
    //   979: aload_2
    //   980: ldc_w 1050
    //   983: ldc_w 1052
    //   986: aload 19
    //   988: invokevirtual 1055	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   991: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   994: pop
    //   995: aload_2
    //   996: ldc_w 447
    //   999: aload 17
    //   1001: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1004: pop
    //   1005: aload_2
    //   1006: ldc_w 1057
    //   1009: iload 9
    //   1011: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1014: pop
    //   1015: aload 14
    //   1017: ifnull +13 -> 1030
    //   1020: aload_2
    //   1021: ldc_w 942
    //   1024: aload 14
    //   1026: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1029: pop
    //   1030: aload_1
    //   1031: ldc_w 1059
    //   1034: iconst_0
    //   1035: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1038: iconst_1
    //   1039: if_icmpne +241 -> 1280
    //   1042: iconst_1
    //   1043: istore 5
    //   1045: aload_1
    //   1046: ldc_w 1061
    //   1049: iconst_0
    //   1050: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1053: istore 11
    //   1055: iload 5
    //   1057: ifeq +235 -> 1292
    //   1060: iload 9
    //   1062: iconst_0
    //   1063: iload 7
    //   1065: aload 16
    //   1067: invokestatic 1064	com/tencent/mm/plugin/websearch/c/a:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1070: astore 14
    //   1072: aload 14
    //   1074: ldc_w 622
    //   1077: aload 21
    //   1079: invokeinterface 830 3 0
    //   1084: pop
    //   1085: aload 14
    //   1087: ldc_w 621
    //   1090: aload 23
    //   1092: invokeinterface 830 3 0
    //   1097: pop
    //   1098: aload 14
    //   1100: ldc_w 970
    //   1103: iload 10
    //   1105: invokestatic 1067	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1108: invokeinterface 830 3 0
    //   1113: pop
    //   1114: aload 14
    //   1116: ldc_w 1059
    //   1119: aload_1
    //   1120: ldc_w 1059
    //   1123: iconst_0
    //   1124: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1127: invokestatic 1067	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1130: invokeinterface 830 3 0
    //   1135: pop
    //   1136: invokestatic 1072	com/tencent/mm/modelappbrand/b:aXE	()Ljava/lang/String;
    //   1139: astore_1
    //   1140: aload 14
    //   1142: ldc_w 966
    //   1145: aload_1
    //   1146: invokeinterface 830 3 0
    //   1151: pop
    //   1152: aload 14
    //   1154: ldc_w 966
    //   1157: aload_1
    //   1158: invokeinterface 830 3 0
    //   1163: pop
    //   1164: aload 14
    //   1166: ldc_w 1074
    //   1169: aload_1
    //   1170: invokeinterface 830 3 0
    //   1175: pop
    //   1176: aload_2
    //   1177: ldc_w 1076
    //   1180: aload_1
    //   1181: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1184: pop
    //   1185: aload_2
    //   1186: ldc_w 425
    //   1189: aload 14
    //   1191: invokestatic 845	com/tencent/mm/plugin/websearch/c/a:bd	(Ljava/util/Map;)Ljava/lang/String;
    //   1194: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1197: pop
    //   1198: aload_2
    //   1199: ldc_w 1057
    //   1202: iload 9
    //   1204: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1207: pop
    //   1208: aload_2
    //   1209: ldc_w 429
    //   1212: iload 4
    //   1214: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1217: pop
    //   1218: aload_2
    //   1219: ldc_w 431
    //   1222: aload 20
    //   1224: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1227: pop
    //   1228: aload_2
    //   1229: ldc_w 966
    //   1232: aload_1
    //   1233: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1236: pop
    //   1237: iload 12
    //   1239: ifne +47 -> 1286
    //   1242: iconst_1
    //   1243: istore 12
    //   1245: aload_2
    //   1246: ldc_w 1078
    //   1249: iload 12
    //   1251: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1254: pop
    //   1255: aload_2
    //   1256: ldc_w 1080
    //   1259: iconst_1
    //   1260: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1263: pop
    //   1264: invokestatic 207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1267: ldc_w 1082
    //   1270: ldc_w 1084
    //   1273: aload_2
    //   1274: invokestatic 216	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
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
    //   1299: invokestatic 1085	com/tencent/mm/plugin/websearch/api/ai:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1302: astore_1
    //   1303: aload_1
    //   1304: ldc_w 622
    //   1307: aload 21
    //   1309: invokestatic 1087	com/tencent/mm/plugin/webview/fts/c:aeL	(Ljava/lang/String;)Ljava/lang/String;
    //   1312: invokeinterface 830 3 0
    //   1317: pop
    //   1318: aload_1
    //   1319: ldc_w 621
    //   1322: aload 23
    //   1324: invokeinterface 830 3 0
    //   1329: pop
    //   1330: aload_1
    //   1331: ldc_w 895
    //   1334: iload 8
    //   1336: invokestatic 1067	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1339: invokeinterface 830 3 0
    //   1344: pop
    //   1345: aload_1
    //   1346: ldc_w 909
    //   1349: aload 18
    //   1351: invokeinterface 830 3 0
    //   1356: pop
    //   1357: aload 15
    //   1359: invokestatic 1093	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1362: ifne +25 -> 1387
    //   1365: aload_1
    //   1366: ldc_w 966
    //   1369: aload 15
    //   1371: invokeinterface 830 3 0
    //   1376: pop
    //   1377: aload_2
    //   1378: ldc_w 966
    //   1381: aload 15
    //   1383: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1386: pop
    //   1387: iload 9
    //   1389: invokestatic 1096	com/tencent/mm/plugin/websearch/api/ai:afq	(I)Ljava/lang/String;
    //   1392: astore 17
    //   1394: aload_1
    //   1395: ldc_w 1074
    //   1398: aload 17
    //   1400: invokeinterface 830 3 0
    //   1405: pop
    //   1406: aload_2
    //   1407: ldc_w 1074
    //   1410: aload 17
    //   1412: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1415: pop
    //   1416: aload_2
    //   1417: ldc_w 425
    //   1420: iload 9
    //   1422: aload_1
    //   1423: invokestatic 1098	com/tencent/mm/plugin/webview/fts/c:i	(ILjava/util/Map;)Ljava/lang/String;
    //   1426: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1429: pop
    //   1430: aload_2
    //   1431: ldc_w 1046
    //   1434: aload 21
    //   1436: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1439: pop
    //   1440: aload_2
    //   1441: ldc_w 429
    //   1444: iload 4
    //   1446: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1449: pop
    //   1450: aload_2
    //   1451: ldc_w 431
    //   1454: aload 20
    //   1456: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1459: pop
    //   1460: aload_2
    //   1461: ldc_w 1100
    //   1464: aload 22
    //   1466: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1469: pop
    //   1470: aload_2
    //   1471: ldc_w 1044
    //   1474: iconst_1
    //   1475: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1478: pop
    //   1479: aload_2
    //   1480: ldc_w 1102
    //   1483: iload_3
    //   1484: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1487: pop
    //   1488: iload 6
    //   1490: bipush 7
    //   1492: if_icmpne +12 -> 1504
    //   1495: aload_2
    //   1496: ldc_w 1104
    //   1499: iconst_1
    //   1500: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1503: pop
    //   1504: iload 11
    //   1506: iconst_1
    //   1507: if_icmpne +39 -> 1546
    //   1510: aload_2
    //   1511: ldc_w 1078
    //   1514: iconst_0
    //   1515: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1518: pop
    //   1519: invokestatic 207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1522: aload 21
    //   1524: aload_2
    //   1525: aload 14
    //   1527: aload 16
    //   1529: aload 23
    //   1531: aload 15
    //   1533: aload 17
    //   1535: invokestatic 1107	com/tencent/mm/plugin/websearch/api/ai:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1538: ldc_w 916
    //   1541: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1544: iconst_0
    //   1545: ireturn
    //   1546: iload 9
    //   1548: bipush 20
    //   1550: if_icmpeq +44 -> 1594
    //   1553: iload 9
    //   1555: bipush 22
    //   1557: if_icmpeq +37 -> 1594
    //   1560: iload 9
    //   1562: bipush 33
    //   1564: if_icmpeq +30 -> 1594
    //   1567: iload 9
    //   1569: iconst_3
    //   1570: if_icmpeq +24 -> 1594
    //   1573: iload 9
    //   1575: bipush 34
    //   1577: if_icmpeq +17 -> 1594
    //   1580: iload 9
    //   1582: bipush 65
    //   1584: if_icmpeq +10 -> 1594
    //   1587: iload 9
    //   1589: bipush 36
    //   1591: if_icmpne +47 -> 1638
    //   1594: aload_2
    //   1595: ldc_w 1109
    //   1598: iconst_1
    //   1599: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1602: pop
    //   1603: aload_2
    //   1604: ldc_w 1111
    //   1607: iload 12
    //   1609: invokevirtual 192	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1612: pop
    //   1613: ldc_w 1113
    //   1616: astore_1
    //   1617: aload_1
    //   1618: invokestatic 1093	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1621: ifne -1213 -> 408
    //   1624: invokestatic 207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1627: ldc_w 455
    //   1630: aload_1
    //   1631: aload_2
    //   1632: invokestatic 216	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1635: goto -1227 -> 408
    //   1638: ldc_w 1115
    //   1641: astore_1
    //   1642: goto -25 -> 1617
    //   1645: aload_1
    //   1646: ldc_w 622
    //   1649: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1652: astore_2
    //   1653: aload_1
    //   1654: ldc_w 1117
    //   1657: iconst_0
    //   1658: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1661: istore_3
    //   1662: aload_1
    //   1663: ldc_w 964
    //   1666: iconst_0
    //   1667: invokestatic 507	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1670: istore 4
    //   1672: aload_1
    //   1673: ldc_w 1119
    //   1676: invokestatic 513	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1679: astore 17
    //   1681: aload 15
    //   1683: astore_1
    //   1684: aload 15
    //   1686: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1689: ifeq +8 -> 1697
    //   1692: iload_3
    //   1693: invokestatic 1096	com/tencent/mm/plugin/websearch/api/ai:afq	(I)Ljava/lang/String;
    //   1696: astore_1
    //   1697: invokestatic 1007	java/lang/System:currentTimeMillis	()J
    //   1700: invokestatic 1010	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1703: astore 15
    //   1705: new 84	java/util/HashMap
    //   1708: dup
    //   1709: invokespecial 85	java/util/HashMap:<init>	()V
    //   1712: astore 18
    //   1714: aload 18
    //   1716: ldc_w 596
    //   1719: ldc_w 1121
    //   1722: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1725: pop
    //   1726: aload 18
    //   1728: ldc_w 622
    //   1731: aload_2
    //   1732: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1735: pop
    //   1736: aload 18
    //   1738: ldc_w 925
    //   1741: aload 16
    //   1743: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1746: pop
    //   1747: aload 18
    //   1749: ldc_w 966
    //   1752: aload_1
    //   1753: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1756: pop
    //   1757: aload 18
    //   1759: ldc_w 1074
    //   1762: aload_1
    //   1763: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1766: pop
    //   1767: aload 18
    //   1769: ldc_w 1124
    //   1772: aload 15
    //   1774: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1777: pop
    //   1778: aload 18
    //   1780: ldc_w 1126
    //   1783: aload 15
    //   1785: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1788: pop
    //   1789: aload 18
    //   1791: ldc_w 1128
    //   1794: aload 15
    //   1796: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: aload 18
    //   1802: ldc_w 1119
    //   1805: aload 17
    //   1807: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1810: pop
    //   1811: aload 18
    //   1813: ldc_w 1130
    //   1816: iload 4
    //   1818: invokestatic 1067	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1821: invokevirtual 1122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1824: pop
    //   1825: new 1132	com/tencent/mm/protocal/protobuf/eii
    //   1828: dup
    //   1829: invokespecial 1133	com/tencent/mm/protocal/protobuf/eii:<init>	()V
    //   1832: astore 16
    //   1834: aload 16
    //   1836: invokestatic 1138	com/tencent/mm/plugin/topstory/ui/c:fyi	()Ljava/lang/String;
    //   1839: putfield 1141	com/tencent/mm/protocal/protobuf/eii:sGQ	Ljava/lang/String;
    //   1842: aload 16
    //   1844: iload_3
    //   1845: putfield 1142	com/tencent/mm/protocal/protobuf/eii:scene	I
    //   1848: aload 16
    //   1850: ldc_w 782
    //   1853: putfield 1143	com/tencent/mm/protocal/protobuf/eii:hes	Ljava/lang/String;
    //   1856: aload 16
    //   1858: aload_2
    //   1859: putfield 1146	com/tencent/mm/protocal/protobuf/eii:dDv	Ljava/lang/String;
    //   1862: aload 16
    //   1864: aload_1
    //   1865: putfield 1148	com/tencent/mm/protocal/protobuf/eii:sessionId	Ljava/lang/String;
    //   1868: aload 16
    //   1870: aload_1
    //   1871: putfield 1151	com/tencent/mm/protocal/protobuf/eii:dVO	Ljava/lang/String;
    //   1874: aload 16
    //   1876: iconst_2
    //   1877: putfield 1154	com/tencent/mm/protocal/protobuf/eii:Nhz	I
    //   1880: aload 16
    //   1882: aload 18
    //   1884: invokestatic 1160	com/tencent/mm/plugin/topstory/a/h:n	(Ljava/util/HashMap;)Ljava/lang/String;
    //   1887: putfield 1163	com/tencent/mm/protocal/protobuf/eii:url	Ljava/lang/String;
    //   1890: aload 16
    //   1892: aload 14
    //   1894: putfield 1166	com/tencent/mm/protocal/protobuf/eii:nbg	Ljava/lang/String;
    //   1897: aload 16
    //   1899: iload 4
    //   1901: putfield 1168	com/tencent/mm/protocal/protobuf/eii:channelId	I
    //   1904: aload 16
    //   1906: aload 15
    //   1908: putfield 1171	com/tencent/mm/protocal/protobuf/eii:dPI	Ljava/lang/String;
    //   1911: aload 16
    //   1913: aload 17
    //   1915: putfield 1174	com/tencent/mm/protocal/protobuf/eii:IDW	Ljava/lang/String;
    //   1918: aload 16
    //   1920: invokestatic 1177	com/tencent/mm/plugin/websearch/api/ai:ait	()Ljava/lang/String;
    //   1923: putfield 1180	com/tencent/mm/protocal/protobuf/eii:wib	Ljava/lang/String;
    //   1926: new 1182	com/tencent/mm/protocal/protobuf/aca
    //   1929: dup
    //   1930: invokespecial 1183	com/tencent/mm/protocal/protobuf/aca:<init>	()V
    //   1933: astore_1
    //   1934: aload_1
    //   1935: ldc_w 1185
    //   1938: putfield 1187	com/tencent/mm/protocal/protobuf/aca:key	Ljava/lang/String;
    //   1941: aload_1
    //   1942: iload 4
    //   1944: i2l
    //   1945: putfield 1190	com/tencent/mm/protocal/protobuf/aca:LmC	J
    //   1948: aload_1
    //   1949: iload 4
    //   1951: invokestatic 1067	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1954: putfield 1193	com/tencent/mm/protocal/protobuf/aca:LmD	Ljava/lang/String;
    //   1957: aload 16
    //   1959: getfield 1197	com/tencent/mm/protocal/protobuf/eii:IDO	Ljava/util/LinkedList;
    //   1962: aload_1
    //   1963: invokevirtual 1202	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1966: pop
    //   1967: invokestatic 207	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1970: aload 16
    //   1972: aload 15
    //   1974: invokestatic 1205	com/tencent/mm/plugin/topstory/ui/c:a	(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/eii;Ljava/lang/String;)V
    //   1977: goto -1569 -> 408
    //   1980: astore 16
    //   1982: goto -1213 -> 769
    //   1985: iconst_0
    //   1986: istore_3
    //   1987: goto -1532 -> 455
    //   1990: aconst_null
    //   1991: astore 14
    //   1993: goto -1785 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1996	0	this	c
    //   0	1996	1	paramMap	Map<String, Object>
    //   0	1996	2	paramf	com.tencent.mm.plugin.webview.ui.tools.jsapi.f
    //   266	1721	3	i	int
    //   268	1682	4	j	int
    //   1043	239	5	k	int
    //   40	1453	6	m	int
    //   50	1246	7	n	int
    //   138	1197	8	i1	int
    //   349	1243	9	i2	int
    //   359	745	10	i3	int
    //   1053	455	11	i4	int
    //   121	1487	12	bool1	boolean
    //   258	191	13	bool2	boolean
    //   166	41	14	localObject1	Object
    //   416	5	14	localJSONException1	JSONException
    //   433	1559	14	localObject2	Object
    //   92	1881	15	localObject3	Object
    //   64	1907	16	localObject4	Object
    //   1980	1	16	localException	Exception
    //   101	1813	17	str1	String
    //   152	1731	18	localObject5	Object
    //   78	909	19	str2	String
    //   220	219	20	str3	String
    //   458	997	20	localJSONException2	JSONException
    //   339	1184	21	str4	String
    //   311	1154	22	str5	String
    //   889	641	23	str6	String
    // Exception table:
    //   from	to	target	type
    //   176	208	416	org/json/JSONException
    //   230	260	458	org/json/JSONException
    //   438	448	458	org/json/JSONException
    //   278	285	479	java/lang/IllegalArgumentException
    //   702	769	1980	java/lang/Exception
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(77905);
    this.IOd.GjI = true;
    boolean bool1 = ai.O(paramMap, "isTeachPage");
    boolean bool2 = ai.O(paramMap, "isMoreButton");
    int j;
    int i;
    label62:
    String str3;
    String str1;
    String str4;
    int m;
    String str2;
    int k;
    if (ai.b(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      if (ai.b(paramMap, "isWeAppMore", 0) != 1) {
        break label192;
      }
      i = 1;
      str3 = ai.N(paramMap, "srcUserName");
      str1 = ai.N(paramMap, "sessionId");
      str4 = (String)paramMap.get("navBarColor");
      m = ai.b(paramMap, "subType", 0);
      str2 = ai.N(paramMap, "searchPlaceHolder");
      k = 0;
      if (Util.isNullOrNil(str4)) {}
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
        paramString = ai.N(paramMap, "jumpUrl");
        paramMap = null;
        if (paramf != null) {
          paramMap = paramf.ghB();
        }
        com.tencent.mm.plugin.webview.modeltools.g.gds();
        p(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label192:
        Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      j = 0;
      break;
      i = 0;
      break label62;
      label232:
      j = ai.b(paramMap, "type", 0);
      int n = ai.b(paramMap, "opType", 0);
      if (n > 0)
      {
        switch (n)
        {
        default: 
          break;
        case 2: 
          a(bs(paramMap), bool1);
          break;
        case 3: 
          paramMap = bs(paramMap);
          if (!ab.IS(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          am.aXh(paramMap.username);
          paramf = new Intent();
          paramf.putExtra("Chat_User", paramMap.username);
          paramf.putExtra("finish_direct", true);
          paramf.putExtra("key_temp_session_show_type", 0);
          paramf.putExtra("preChatTYPE", 9);
          com.tencent.mm.br.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", paramf);
          break;
        case 4: 
          paramString = ai.N(paramMap, "jumpUrl");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.ghB();
          }
          com.tencent.mm.plugin.webview.modeltools.g.gds();
          p(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str4 = ai.N(paramMap, "query");
        k = ai.b(paramMap, "scene", 0);
        str3 = ai.N(paramMap, "searchId");
        paramf = new Intent();
        paramf.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        paramf.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        paramf.putExtra("neverGetA8Key", true);
        paramf.putExtra("key_load_js_without_delay", true);
        paramf.putExtra("ftsQuery", str4);
        paramf.putExtra("ftsType", j);
        paramf.putExtra("sessionId", str1);
        if (i != 0)
        {
          paramString = a.a(k, false, j, paramString);
          try
          {
            paramString.put("query", com.tencent.mm.compatible.util.q.encode(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(m));
            paramString.put("isWeAppMore", String.valueOf(ai.b(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.aXE();
            paramString.put("sessionId", paramMap);
            str1 = ai.afq(Util.safeParseInt((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramf.putExtra("subSessionId", str1);
            paramf.putExtra("key_session_id", paramMap);
            paramf.putExtra("rawUrl", a.bd(paramString));
            paramf.putExtra("ftsbizscene", k);
            paramf.putExtra("key_search_place_holder", str2);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramf);
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
          paramMap = ai.a(k, false, j, paramString);
          try
          {
            paramMap.put("query", com.tencent.mm.compatible.util.q.encode(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = ai.afq(Util.safeParseInt((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramf.putExtra("subSessionId", paramString);
            paramf.putExtra("rawUrl", i(k, paramMap));
            paramf.putExtra("key_session_id", str1);
            paramf.putExtra("searchId", str3);
            if ((k == 20) || (k == 22) || (k == 24) || (k == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", paramMap, paramf);
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
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = ai.N(paramMap, "jumpUrl");
          str1 = ai.N(paramMap, "publishId");
          i = ai.b(paramMap, "payScene", 0);
          j = ai.b(paramMap, "scene", 0);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          str2 = ai.N(paramMap, "cookie");
          paramMap = null;
          if (paramf != null) {
            paramMap = paramf.ghB();
          }
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.gds();
            a(paramString, paramMap, k, str4, str1, i, str3, j, m, str2);
          }
          break;
        case 8: 
          ai.N(paramMap, "snsid");
          paramf = ai.N(paramMap, "objectXmlDesc");
          paramString = ai.N(paramMap, "userName");
          bool1 = ai.O(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.gds();
          B(paramf, paramString, bool1);
          break;
        case 1: 
          a(bs(paramMap), false);
          break;
        case 32: 
          a(bt(paramMap));
        }
      }
    }
  }
  
  public final g afM(int paramInt)
  {
    AppMethodBeat.i(210829);
    if (this.IOc.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.afN(paramInt);
      if (localg != null) {
        this.IOc.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.IOc.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(210829);
    return localg;
  }
  
  public final boolean bo(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (ai.b(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (al.IEV == null) {
        al.fYg();
      }
      al.IEV.oTA.clear();
      paramMap = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = al.bKh();
        localObject2 = Base64.encodeToString(al.IEV.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        Log.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = ai.b(paramMap, "type", 0);
      int j = ai.b(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.mZq > 1000L)
      {
        this.mZq = System.currentTimeMillis();
        if (!ai.afs(0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          ar.N(i, j, ak.aXf("searchID"));
          paramMap = ai.fXX();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", ai.bd(ai.h(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          paramMap.putExtra("key_change_search_icon", true);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(ai.b(paramMap, "webview_instance_id", -1));
          i = ai.b(paramMap, "scene", 0);
          paramMap = ai.N(paramMap, "query");
          if ((i != 20) || (Util.isNullOrNil(paramMap)))
          {
            Log.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[] { Integer.valueOf(i), paramMap });
          }
          else
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("fts_key_new_query", paramMap);
            try
            {
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw.f(136, (Bundle)localObject2);
              }
            }
            catch (Exception paramMap)
            {
              Log.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + paramMap.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final boolean bp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    int i = ai.b(paramMap, "scene", 0);
    int k = ai.b(paramMap, "type", 0);
    int m = ai.b(paramMap, "requestType", 0);
    int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    String str = (String)paramMap.get("requestId");
    Object localObject1 = (String)paramMap.get("guideInfo");
    Object localObject2 = (String)paramMap.get("sessionId");
    boolean bool = ai.O(paramMap, "ignoreCache");
    if (m == 0)
    {
      paramMap = ke(i, k);
      if ((paramMap.isAvailable()) && (!bool))
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.IOq), Long.valueOf(paramMap.IOr), Integer.valueOf(paramMap.type), paramMap.dNA });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).e(m, paramMap.dNA, 1, str);
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          ar.a(paramMap.scene, 0, paramMap.rjq, paramMap.type, 2, paramMap.gax(), 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77902);
        return false;
        ar.a(paramMap.scene, 0, paramMap.rjq, paramMap.type, 1, "", 0);
        continue;
        com.tencent.mm.plugin.webview.modeltools.g.gdt().IPn.a(2, str, Integer.valueOf(j), new c.2(this, j, i, k, str, (String)localObject2, (String)localObject1), this.INN);
      }
    }
    paramMap = am.fYi();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        i = paramMap.oTA.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject3 = (crg)paramMap.oTA.get(i);
          if (!ab.IS(((crg)localObject3).Username)) {
            break label610;
          }
          localObject3 = com.tencent.mm.al.g.fJ(((crg)localObject3).Username);
          if (localObject3 == null) {
            break label610;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.api.c)localObject3).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.api.c)localObject3).field_username);
          localJSONObject2.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(((com.tencent.mm.api.c)localObject3).field_username));
          localJSONArray.put(localJSONObject2);
          break label610;
        }
        localJSONObject1.put("items", localJSONArray);
        localJSONObject1.put("type", 5);
        localJSONObject1.put("title", "");
        ((JSONArray)localObject2).put(localJSONObject1);
        ((JSONObject)localObject1).put("data", localObject2);
        paramMap = ((JSONObject)localObject1).toString();
        Log.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[] { paramMap });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(j).e(1, paramMap, 1, str);
      }
      catch (Exception paramMap)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "gen mostSearchBizContactList error", new Object[0]);
      }
      break;
      label610:
      i -= 1;
    }
  }
  
  public final boolean bq(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = ai.b(paramMap, "scene", 201);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    Object localObject = afM(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf;
    String str;
    if (localObject != null)
    {
      localf = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i);
      str = ((g)localObject).dNA;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localf.r(str, 1, i, ((g)localObject).IOy);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.g.azz().a(1866, this);
        localObject = new e(paramMap, j, 0);
        if (paramMap != null) {
          ((e)localObject).dVL = ai.b(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean br(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    doc localdoc = new doc();
    localdoc.MRe = ai.N(paramMap, "logString");
    com.tencent.mm.kernel.g.azz().a(1134, this);
    paramMap = new ad(localdoc);
    com.tencent.mm.kernel.g.azz().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bv(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77918);
    String str = (String)paramMap.get("query");
    Object localObject = (String)paramMap.get("sortedContacts");
    final int j = Util.safeParseInt((String)paramMap.get("offset"));
    final int k = Util.safeParseInt((String)paramMap.get("count"));
    final int m = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
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
      if (this.IOg.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.IOf == null) {
        this.IOf = new com.tencent.mm.plugin.websearch.b.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.b.a.d(str, (List)localObject);
      if (this.IOg == null) {}
    }
    this.IOg = paramMap;
    this.IOf.a(paramMap, new c.a()
    {
      public final void fYI()
      {
        AppMethodBeat.i(210823);
        c.a(c.this.IOg, j, k, m);
        AppMethodBeat.o(210823);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.IOg.dDz) {
        a(this.IOg, j, k, m);
      }
    }
  }
  
  public final boolean bw(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = ai.N(paramMap, "md5");
    int i = ai.b(paramMap, "offset", 0);
    String str2 = ai.N(paramMap, "searchId");
    String str3 = ai.N(paramMap, "sessionId");
    int j = ai.b(paramMap, "tab", 0);
    String str4 = ai.N(paramMap, "requestId");
    int k = ai.b(paramMap, "scene", 0);
    int m = ai.b(paramMap, "webview_instance_id", -1);
    String str5 = ai.N(paramMap, "emojiUrl");
    paramMap = ai.N(paramMap, "aesKey");
    if (this.IOh != null)
    {
      com.tencent.mm.kernel.g.azz().a(this.IOh);
      com.tencent.mm.kernel.g.azz().b(2999, this);
    }
    com.tencent.mm.kernel.g.azz().a(2999, this);
    this.IOh = new d(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.IOh.dVL = m;
    com.tencent.mm.kernel.g.azz().a(this.IOh, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final String gaw()
  {
    AppMethodBeat.i(77901);
    Object localObject = G(20, 0, true);
    if (this.IOa.get(localObject) == null)
    {
      b localb = new b();
      localb.kf(20, 0);
      this.IOa.put(localObject, localb);
    }
    localObject = (b)this.IOa.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).dNA; Util.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(77901);
      return "";
    }
    AppMethodBeat.o(77901);
    return localObject;
  }
  
  public final b ke(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210826);
    Object localObject = G(paramInt1, paramInt2, true);
    if (this.IOa.get(localObject) == null)
    {
      b localb = new b();
      localb.kf(paramInt1, paramInt2);
      this.IOa.put(localObject, localb);
    }
    localObject = (b)this.IOa.get(localObject);
    AppMethodBeat.o(210826);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(77913);
    if ((paramq instanceof ac))
    {
      com.tencent.mm.kernel.g.azz().b(1048, this);
      paramString = new h(paramInt1, paramInt2, (ac)paramq);
      com.tencent.mm.plugin.webview.modeltools.g.gdt().IPn.a(2, ((ac)paramq).dPI, paramString, this.INN);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramq instanceof ad))
    {
      com.tencent.mm.kernel.g.azz().b(1134, this);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramq instanceof e))
    {
      com.tencent.mm.kernel.g.azz().b(1866, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (e)paramq;
      if (paramString.dVL != -1) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramString.dVL).r(((ext)paramString.rr.iLL.iLR).dNA, 0, 0, 0);
      }
      if (paramString.IOB != null) {
        this.IOc.put(Integer.valueOf(paramString.IOB.scene), paramString.IOB);
      }
      AppMethodBeat.o(77913);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof d))
    {
      com.tencent.mm.kernel.g.azz().b(2999, this);
      localObject1 = (d)paramq;
      paramq = Util.nullAs(((d)localObject1).IOA.MaZ, "");
      if (((d)localObject1).dVL != -1)
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(((d)localObject1).dVL);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("fts_key_json_data", paramq);
        ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
        ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw.f(152, (Bundle)localObject2);
          }
          AppMethodBeat.o(77913);
          return;
        }
        catch (Exception paramString) {}
      }
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramq instanceof w))
    {
      localObject2 = (w)paramq;
      paramq = Util.nullAs(((w)localObject2).fxY().NvZ, "");
      if (((w)localObject2).dVL != -1)
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(((w)localObject2).dVL);
        localObject2 = ((w)localObject2).dPI;
        Bundle localBundle = new Bundle();
        localBundle.putString("fts_key_id", (String)localObject2);
        localBundle.putString("fts_key_json_data", paramq);
        localBundle.putString("fts_key_err_msg", paramString);
        localBundle.putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.f)localObject1).ISw.f(153, localBundle);
          }
          AppMethodBeat.o(77913);
          return;
        }
        catch (Exception paramString) {}
      }
    }
    AppMethodBeat.o(77913);
  }
  
  public static final class b
  {
    long IOq;
    long IOr;
    String dNA;
    boolean hjq = false;
    private String mdi = null;
    String rjq;
    int scene;
    int type;
    
    final String gax()
    {
      AppMethodBeat.i(77892);
      if (this.mdi == null) {
        this.mdi = "";
      }
      try
      {
        localObject = new JSONObject(this.dNA).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.mdi = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.mdi;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final boolean isAvailable()
    {
      AppMethodBeat.i(77891);
      if (this.hjq)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((Util.isNullOrNil(this.dNA)) || (System.currentTimeMillis() / 1000L - this.IOr > this.IOq))
      {
        AppMethodBeat.o(77891);
        return false;
      }
      AppMethodBeat.o(77891);
      return true;
    }
    
    final void kf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      clt localclt = new clt();
      Object localObject1 = com.tencent.mm.plugin.record.b.aTb();
      Object localObject2 = c.G(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(c.G(paramInt1, paramInt2, true))) {
        this.hjq = true;
      }
      localObject1 = new o((String)localObject1, (String)localObject2);
      localObject2 = s.aW(aa.z(((o)localObject1).her()), 0, (int)((o)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localclt.parseFrom((byte[])localObject2);
          this.scene = localclt.scene;
          this.dNA = localclt.MaZ;
          this.IOq = localclt.Mre;
          this.IOr = localclt.Mrf;
          this.rjq = localclt.KZj;
          this.type = localclt.oUv;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { aa.z(((o)localObject1).her()), Integer.valueOf(localObject2.length) });
          AppMethodBeat.o(77893);
          return;
        }
        catch (IOException localIOException) {}
      }
      AppMethodBeat.o(77893);
    }
  }
  
  final class c
  {
    public String BdC;
    public aeq BeX;
    public int IOs;
    public boolean IOt;
    public String IOu;
    public int IOv;
    public int dVS;
    public String hes;
    public String nickname;
    public int position;
    public String query;
    public int scene;
    public String signature;
    public String username;
    
    private c() {}
  }
  
  final class d
  {
    public int IOw;
    public String country;
    public String fMb;
    public int fuA;
    public String fuJ;
    public String fuK;
    public String nickname;
    public String query;
    public int scene;
    public String signature;
    public String username;
    
    private d() {}
  }
  
  static final class g
  {
    public long IOr;
    public int IOy;
    public String dNA;
    public long interval;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.dNA = "";
      this.interval = 0L;
      this.IOr = 0L;
      this.IOy = 0;
    }
    
    public g(int paramInt1, ext paramext, int paramInt2)
    {
      AppMethodBeat.i(210824);
      this.scene = 0;
      this.dNA = "";
      this.interval = 0L;
      this.IOr = 0L;
      this.IOy = 0;
      this.scene = paramInt1;
      this.dNA = paramext.dNA;
      this.interval = paramext.gTn;
      this.IOr = (System.currentTimeMillis() / 1000L);
      this.IOy = paramInt2;
      AppMethodBeat.o(210824);
    }
    
    /* Error */
    public static g afN(int paramInt)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 64	com/tencent/mm/vfs/o
      //   8: dup
      //   9: invokestatic 70	com/tencent/mm/plugin/record/b:aTb	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 74	com/tencent/mm/plugin/webview/fts/c$g:afO	(I)Ljava/lang/String;
      //   16: invokespecial 77	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 81	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
      //   24: invokestatic 87	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual 90	com/tencent/mm/vfs/o:length	()J
      //   32: l2i
      //   33: invokestatic 96	com/tencent/mm/vfs/s:aW	(Ljava/lang/String;II)[B
      //   36: astore_1
      //   37: new 98	com/tencent/mm/protocal/protobuf/clu
      //   40: dup
      //   41: invokespecial 99	com/tencent/mm/protocal/protobuf/clu:<init>	()V
      //   44: astore_2
      //   45: aload_2
      //   46: aload_1
      //   47: invokevirtual 103	com/tencent/mm/protocal/protobuf/clu:parseFrom	([B)Lcom/tencent/mm/bw/a;
      //   50: pop
      //   51: new 2	com/tencent/mm/plugin/webview/fts/c$g
      //   54: dup
      //   55: invokespecial 104	com/tencent/mm/plugin/webview/fts/c$g:<init>	()V
      //   58: astore_1
      //   59: aload_1
      //   60: aload_2
      //   61: getfield 107	com/tencent/mm/protocal/protobuf/clu:Scene	I
      //   64: putfield 21	com/tencent/mm/plugin/webview/fts/c$g:scene	I
      //   67: aload_1
      //   68: aload_2
      //   69: getfield 110	com/tencent/mm/protocal/protobuf/clu:MaZ	Ljava/lang/String;
      //   72: putfield 25	com/tencent/mm/plugin/webview/fts/c$g:dNA	Ljava/lang/String;
      //   75: aload_1
      //   76: aload_2
      //   77: getfield 113	com/tencent/mm/protocal/protobuf/clu:Mrg	J
      //   80: putfield 27	com/tencent/mm/plugin/webview/fts/c$g:interval	J
      //   83: aload_1
      //   84: aload_2
      //   85: getfield 116	com/tencent/mm/protocal/protobuf/clu:Mrf	J
      //   88: putfield 29	com/tencent/mm/plugin/webview/fts/c$g:IOr	J
      //   91: aload_1
      //   92: aload_2
      //   93: getfield 119	com/tencent/mm/protocal/protobuf/clu:Mrh	I
      //   96: putfield 31	com/tencent/mm/plugin/webview/fts/c$g:IOy	I
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
      //   44	49	2	localclu	com.tencent.mm.protocal.protobuf.clu
      //   112	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   37	59	106	java/lang/Exception
      //   59	99	112	java/lang/Exception
    }
    
    static String afO(int paramInt)
    {
      AppMethodBeat.i(77896);
      String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      str = "SearchGuide_" + paramInt + "-" + str;
      AppMethodBeat.o(77896);
      return str;
    }
    
    public final boolean isExpired()
    {
      AppMethodBeat.i(77897);
      if (this.IOr + this.interval <= System.currentTimeMillis() / 1000L)
      {
        AppMethodBeat.o(77897);
        return true;
      }
      AppMethodBeat.o(77897);
      return false;
    }
  }
  
  static final class h
  {
    ac IOz;
    int errCode;
    int errType;
    
    public h(int paramInt1, int paramInt2, ac paramac)
    {
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.IOz = paramac;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */