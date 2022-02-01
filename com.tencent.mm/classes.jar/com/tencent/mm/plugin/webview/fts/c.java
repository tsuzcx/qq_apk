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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.rv;
import com.tencent.mm.aw.i;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.webview.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.evu;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.gew;
import com.tencent.mm.protocal.protobuf.ghg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.am.h
{
  private HashMap<String, b> HAb;
  public ad HAc;
  public Set<Integer> WAD;
  public com.tencent.mm.plugin.fts.a.l WAE;
  private Map<Integer, g> WAF;
  public e WAG;
  public List<com.tencent.mm.aw.f> WAH;
  private com.tencent.mm.plugin.websearch.c.a.c WAI;
  private com.tencent.mm.plugin.websearch.c.a.d WAJ;
  private d WAK;
  h.a WAw;
  public IListener rDF;
  private long teM;
  
  public c()
  {
    AppMethodBeat.i(77898);
    this.WAE = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(77886);
        final c.f localf = (c.f)paramAnonymousm.HpM;
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[] { Integer.valueOf(paramAnonymousm.resultCode), Integer.valueOf(localf.WBb) });
        final JSONObject localJSONObject1;
        JSONArray localJSONArray1;
        JSONArray localJSONArray2;
        if (paramAnonymousm.resultCode == 0)
        {
          localJSONObject1 = new JSONObject();
          try
          {
            localJSONObject1.put("ret", 0);
            localJSONArray1 = new JSONArray();
            localJSONArray2 = new JSONArray();
            paramAnonymousm = paramAnonymousm.HtF.iterator();
            while (paramAnonymousm.hasNext())
            {
              o localo = (o)paramAnonymousm.next();
              if (localo.content != null)
              {
                JSONObject localJSONObject2 = new JSONObject(localo.content);
                localJSONObject2.put("timeStamp", localo.timestamp);
                localJSONArray2.put(localJSONObject2);
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(77885);
                    if (localf.WBb != 0)
                    {
                      Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[] { Integer.valueOf(localf.WBb) });
                      com.tencent.mm.plugin.webview.ui.tools.jsapi.j localj = k.auP(localf.WBb);
                      String str = localJSONObject1.toString();
                      Bundle localBundle = new Bundle();
                      localBundle.putString("data", str);
                      try
                      {
                        if (localj.WFb != null)
                        {
                          localj.WFb.i(143, localBundle);
                          AppMethodBeat.o(77885);
                          return;
                        }
                        Log.i("MicroMsg.MsgHandler", "callbacker is null");
                        AppMethodBeat.o(77885);
                        return;
                      }
                      catch (RemoteException localRemoteException)
                      {
                        Log.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + localRemoteException.getMessage());
                      }
                    }
                    AppMethodBeat.o(77885);
                  }
                });
              }
            }
          }
          catch (Exception paramAnonymousm) {}
        }
        for (;;)
        {
          AppMethodBeat.o(77886);
          return;
          paramAnonymousm = new JSONObject();
          paramAnonymousm.put("items", localJSONArray2);
          localJSONArray1.put(paramAnonymousm);
          localJSONObject1.put("data", localJSONArray1);
        }
      }
    };
    this.WAw = new h.a()
    {
      public final void handleCallback(h.b paramAnonymousb)
      {
        AppMethodBeat.i(295544);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "handleCallback %s", new Object[] { paramAnonymousb });
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(295544);
          return;
        }
        int i = ((Integer)paramAnonymousb.WBq).intValue();
        paramAnonymousb = (c.h)paramAnonymousb.WBr;
        if ((paramAnonymousb == null) || (paramAnonymousb.WBc == null))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd netResult invalid");
          AppMethodBeat.o(295544);
          return;
        }
        if ((paramAnonymousb.errType != 0) || (paramAnonymousb.errCode != 0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramAnonymousb.errType), Integer.valueOf(paramAnonymousb.errCode) });
          AppMethodBeat.o(295544);
          return;
        }
        paramAnonymousb = paramAnonymousb.WBc;
        c.b localb = new c.b();
        localb.scene = paramAnonymousb.scene;
        localb.HAd = paramAnonymousb.WoF.aaSd;
        localb.hMi = paramAnonymousb.WoF.aayd;
        localb.HAe = (System.currentTimeMillis() / 1000L);
        localb.xVe = paramAnonymousb.WoF.aayf;
        localb.type = paramAnonymousb.businessType;
        Object localObject = c.D(localb.scene, localb.type, true);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { localb.hMi });
        if (!Util.isNullOrNil(localb.hMi))
        {
          k.auP(i).f(0, localb.hMi, 0, paramAnonymousb.hOG);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { localb.hMi });
        }
        c.b(c.this).put(localObject, localb);
        if (localb.HAd == 0L)
        {
          i = localb.scene;
          int j = localb.type;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramAnonymousb = com.tencent.mm.plugin.record.c.bzO();
          localObject = new u(paramAnonymousb, c.D(i, j, true));
          if (((u)localObject).jKS()) {
            ((u)localObject).diJ();
          }
          paramAnonymousb = new u(paramAnonymousb, c.D(i, j, false));
          if (paramAnonymousb.jKS()) {
            paramAnonymousb.diJ();
          }
        }
        while ((localb.scene == 20) && (localb.type == 0))
        {
          as.a(localb.scene, 1, localb.xVe, localb.type, 2, localb.fyV(), 1);
          AppMethodBeat.o(295544);
          return;
          localObject = new dlw();
          ((dlw)localObject).scene = localb.scene;
          ((dlw)localObject).aayd = localb.hMi;
          ((dlw)localObject).aaRX = localb.HAd;
          ((dlw)localObject).aaRY = localb.HAe;
          ((dlw)localObject).YYr = localb.xVe;
          ((dlw)localObject).vhJ = localb.type;
          paramAnonymousb = null;
          try
          {
            localObject = ((dlw)localObject).toByteArray();
            paramAnonymousb = (h.b)localObject;
          }
          catch (IOException localIOException)
          {
            label542:
            break label542;
          }
          if (paramAnonymousb != null)
          {
            localObject = new u(com.tencent.mm.plugin.record.c.bzO(), c.D(localb.scene, localb.type, true));
            if (!((u)localObject).jKP().jKS()) {
              ((u)localObject).jKP().jKY();
            }
            if (((u)localObject).jKS()) {
              ((u)localObject).diJ();
            }
            y.f(com.tencent.mm.vfs.ah.v(((u)localObject).jKT()), paramAnonymousb, paramAnonymousb.length);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.ah.v(((u)localObject).jKT()), Integer.valueOf(paramAnonymousb.length) });
          }
          else
          {
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
          }
        }
        as.a(localb.scene, 1, localb.xVe, localb.type, 1, "", 0);
        AppMethodBeat.o(295544);
      }
    };
    this.WAF = new HashMap();
    this.WAG = new e();
    this.rDF = new FTSWebViewLogic.4(this, com.tencent.mm.app.f.hfK);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.HAb = new HashMap();
    this.WAD = Collections.synchronizedSet(new HashSet());
    this.rDF.alive();
    com.tencent.mm.kernel.h.aZW().a(2975, this);
    AppMethodBeat.o(77898);
  }
  
  static String D(int paramInt1, int paramInt2, boolean paramBoolean)
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
    if (new u(com.tencent.mm.plugin.record.c.bzO(), str2).jKS())
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    AppMethodBeat.o(77916);
    return str1;
  }
  
  private static void J(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.c.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.p.class)).Pm(paramString1);
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
  
  private static void a(com.tencent.mm.plugin.websearch.c.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77919);
    paramd = paramd.nd(paramInt1, paramInt2);
    k.auP(paramInt3).cJ(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.WAZ != 0) {
      i = paramc.WAZ;
    }
    for (;;)
    {
      an.biA(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.MVy);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.WAW);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.MWY != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.MWY.toByteArray());
        label124:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.mpa);
        localBundle.putString("Contact_Ext_Args_Search_Click_Id", paramc.Ndp);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.WAY);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        localIntent.putExtra("biz_profile_tab_type", paramc.hJx);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.hVr == 2)
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
          if (paramc.WAX)
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
    localIntent.putExtra("Contact_Alias", paramd.kDc);
    localIntent.putExtra("Contact_Sex", paramd.sex);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramd.country, paramd.province, paramd.city));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.WBa);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5)
  {
    AppMethodBeat.i(295681);
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
      if (paramInt5 == 3) {
        localIntent.putExtra("show_native_web_view", true);
      }
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", localIntent);
      AppMethodBeat.o(295681);
      return;
      if ((paramBundle != null) && (!Util.isNullOrNil(paramString1)))
      {
        paramString1 = paramBundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
        localIntent.putExtra("prePublishId", paramString1);
        localIntent.putExtra("KPublisherId", paramString1);
      }
    }
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5)
  {
    AppMethodBeat.i(295677);
    a(paramString1, paramBundle, paramInt1, paramString2, paramString3, 0, paramString4, paramInt2, paramInt3, paramString5, -1);
    AppMethodBeat.o(295677);
  }
  
  private static String afS(String paramString)
  {
    AppMethodBeat.i(295658);
    try
    {
      String str = r.as(paramString, "utf-8");
      paramString = str;
    }
    finally
    {
      label16:
      break label16;
    }
    AppMethodBeat.o(295658);
    return paramString;
  }
  
  public static boolean bD(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295651);
    int i = aj.c(paramMap, "showType", 0);
    String str = aj.au(paramMap, "query");
    if (aj.c(paramMap, "isDeleteAll", 0) == 1) {
      ((n)com.tencent.mm.kernel.h.az(n.class)).deleteSOSHistory();
    }
    for (;;)
    {
      AppMethodBeat.o(295651);
      return false;
      ((n)com.tencent.mm.kernel.h.az(n.class)).deleteSOSHistory(str + "​" + i);
    }
  }
  
  public static boolean bH(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295662);
    String str1 = aj.au(paramMap, "query");
    int i = aj.c(paramMap, "scene", 3);
    int j = aj.c(paramMap, "type", 0);
    if (paramMap.get("thirdExtParam") == null) {}
    for (paramMap = "";; paramMap = paramMap.get("thirdExtParam").toString())
    {
      String str2 = aj.asV(i);
      Map localMap = aj.r(i, true, 0);
      localMap.put("query", str1);
      localMap.put("sessionId", str2);
      localMap.put("thirdExtParam", r.cg(paramMap));
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(MMApplicationContext.getContext(), i, str1, str2, true, localMap, j);
      AppMethodBeat.o(295662);
      return true;
    }
  }
  
  public static boolean bI(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295669);
    int i = aj.c(paramMap, "scene", 3);
    long l = com.tencent.mm.model.cn.getSyncServerTimeSecond();
    paramMap = aj.au(paramMap, "query");
    String str = com.tencent.mm.plugin.fts.a.d.We(i);
    Object localObject = new com.tencent.mm.plugin.websearch.api.ah();
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).context = MMApplicationContext.getContext();
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).scene = i;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).query = paramMap;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).title = paramMap;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).sessionId = str;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoH = true;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoI = true;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoJ = true;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoK = 1;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoL = com.tencent.mm.cd.a.w(MMApplicationContext.getContext(), com.tencent.mm.plugin.webview.c.c.white);
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoM = true;
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).hVt.put("msgSvrId", "0");
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).hVt.put("parentSearchID", "");
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).hVt.put("fromTagSearch", "1");
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoT.put("ShareSceneId", "");
    ((com.tencent.mm.plugin.websearch.api.ah)localObject).WoT.put("SnsContentType", "0");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((com.tencent.mm.plugin.websearch.api.ah)localObject);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.startsWith("#"))) {
      paramMap = paramMap.substring(1);
    }
    for (;;)
    {
      localObject = new rv();
      ((rv)localObject).ioV = 1L;
      ((rv)localObject).izR = l;
      ((rv)localObject).jwF = 1L;
      paramMap = ((rv)localObject).yA(paramMap);
      paramMap.jwH = 6L;
      paramMap = paramMap.yB("");
      paramMap.jwJ = l;
      paramMap.jwK = 0L;
      paramMap.yC(str).bMH();
      as.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(295669);
      return true;
    }
  }
  
  public static boolean bJ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295673);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[] { paramMap.toString() });
    int i = aj.c(paramMap, "logId", 0);
    paramMap = aj.au(paramMap, "logString");
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", new Object[] { Integer.valueOf(i), paramMap });
    as.dC(i, paramMap);
    AppMethodBeat.o(295673);
    return false;
  }
  
  private c bL(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = aj.au(paramMap, "userName");
    localc.nickname = aj.au(paramMap, "nickName");
    localc.MVy = aj.au(paramMap, "headHDImgUrl");
    localc.WAW = aj.c(paramMap, "verifyFlag", 0);
    localc.signature = aj.au(paramMap, "signature");
    localc.scene = aj.c(paramMap, "scene", 0);
    localc.hVr = aj.c(paramMap, "sceneActionType", 1);
    localc.MWY = new ahl();
    localc.MWY.pSt = aj.c(paramMap, "brandFlag", 0);
    localc.MWY.pSw = aj.au(paramMap, "iconUrl");
    localc.MWY.pSv = aj.au(paramMap, "brandInfo");
    localc.MWY.pSu = aj.au(paramMap, "externalInfo");
    localc.mpa = aj.au(paramMap, "searchId");
    localc.Ndp = aj.au(paramMap, "searchClickId");
    localc.query = aj.au(paramMap, "query");
    localc.position = aj.c(paramMap, "position", 0);
    localc.WAX = aj.av(paramMap, "isCurrentDetailPage");
    localc.WAY = aj.au(paramMap, "extraParams");
    localc.WAZ = aj.c(paramMap, "friendScene", 0);
    if (aj.c(paramMap, "bizTabType", 0) == 2) {}
    for (localc.hJx = 1;; localc.hJx = 0)
    {
      AppMethodBeat.o(77914);
      return localc;
    }
  }
  
  private d bM(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = aj.au(paramMap, "userName");
    locald.nickname = aj.au(paramMap, "nickName");
    locald.kDc = aj.au(paramMap, "alias");
    locald.signature = aj.au(paramMap, "signature");
    locald.sex = aj.c(paramMap, "sex", 0);
    locald.country = aj.au(paramMap, "country");
    locald.city = aj.au(paramMap, "city");
    locald.province = aj.au(paramMap, "province");
    locald.WBa = aj.c(paramMap, "snsFlag", 0);
    String str = aj.au(paramMap, "query");
    if (!Util.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(aj.au(paramMap, "matchType"))) {
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
  
  public static boolean bN(Map<String, Object> paramMap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(295732);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openEmotionPage %s", new Object[] { paramMap });
    int i = aj.c(paramMap, "type", 0);
    int j = aj.c(paramMap, "scene", 0);
    String str2 = aj.au(paramMap, "searchId");
    String str3 = aj.au(paramMap, "activityId");
    int k = aj.c(paramMap, "isGenSticker", 0);
    int m = aj.c(paramMap, "fromSearchType", 0);
    String str1 = "";
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("extra_scence", j);
    localIntent.putExtra("extra_type", i);
    localIntent.putExtra("searchID", str2);
    localIntent.putExtra("docID", aj.au(paramMap, "docID"));
    localIntent.putExtra("activityId", str3);
    localIntent.putExtra("search_type", m);
    localIntent.putExtra("extra_gen_sticker", k);
    switch (i)
    {
    default: 
      paramMap = str1;
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        if (!Util.isNullOrNil(paramMap)) {
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "emoji", paramMap, localIntent);
        }
        AppMethodBeat.o(295732);
        return false;
        localIntent.putExtra("extra_id", aj.au(paramMap, "productID"));
        localIntent.putExtra("preceding_scence", 18);
        localIntent.putExtra("download_entrance_scene", 27);
        localIntent.putExtra("searchID", str2);
        paramMap = ".ui.EmojiStoreDetailUI";
        continue;
        localIntent.putExtra("extra_emoji_name", aj.au(paramMap, "express"));
        localIntent.putExtra("extra_md5", aj.au(paramMap, "md5"));
        localIntent.putExtra("extra_aeskey", aj.au(paramMap, "aesKey"));
        localIntent.putExtra("extra_encrypt_url", aj.au(paramMap, "encryptUrl"));
        localIntent.putExtra("extra_thumb_url", aj.au(paramMap, "thumb"));
        localIntent.putExtra("id", aj.au(paramMap, "designerId"));
        localIntent.putExtra("extra_product_id", aj.au(paramMap, "productID"));
        localIntent.putExtra("productUrl", aj.au(paramMap, "productUrl"));
        localIntent.putExtra("extra_product_name", aj.au(paramMap, "productName"));
        localIntent.putExtra("weapp_user_name", aj.au(paramMap, "weappUserName"));
        localIntent.putExtra("biz_user_name", aj.au(paramMap, "bizUin"));
        localIntent.putExtra("weapp_version", aj.c(paramMap, "weappVersion", 0));
        localIntent.putExtra("source_type", aj.c(paramMap, "sourceType", 0));
        paramMap = ".ui.fts.FTSEmojiDetailPageUI";
        continue;
        localIntent.putExtra("extra_emoji_name", aj.au(paramMap, "express"));
        localIntent.putExtra("extra_md5", aj.au(paramMap, "md5"));
        localIntent.putExtra("extra_aeskey", aj.au(paramMap, "aesKey"));
        localIntent.putExtra("extra_encrypt_url", aj.au(paramMap, "encryptUrl"));
        localIntent.putExtra("extra_thumb_url", aj.au(paramMap, "thumb"));
        localIntent.putExtra("id", aj.au(paramMap, "designerId"));
        localIntent.putExtra("name", aj.au(paramMap, "designerName"));
        localIntent.putExtra("headurl", aj.au(paramMap, "designerThumb"));
        localIntent.putExtra("weapp_user_name", aj.au(paramMap, "weappUserName"));
        localIntent.putExtra("weapp_version", aj.c(paramMap, "weappVersion", 0));
        localIntent.putExtra("source_type", aj.c(paramMap, "sourceType", 0));
        localIntent.putExtra("biz_user_name", aj.au(paramMap, "bizUin"));
        paramMap = ".ui.fts.FTSEmojiDetailPageUI";
      }
    }
    localIntent.putExtra("extra_emoji_name", aj.au(paramMap, "express"));
    localIntent.putExtra("extra_encrypt_url", aj.au(paramMap, "encryptUrl"));
    localIntent.putExtra("extra_thumb_url", aj.au(paramMap, "thumb"));
    localIntent.putExtra("extra_article_name", aj.au(paramMap, "sourceTitle"));
    localIntent.putExtra("extra_article_url", aj.au(paramMap, "articleSource"));
    if (aj.c(paramMap, "disableAddSticker", 0) > 0)
    {
      bool1 = true;
      label810:
      localIntent.putExtra("disableAddSticker", bool1);
      if (aj.c(paramMap, "needSavePhotosAlbum", 0) <= 0) {
        break label926;
      }
    }
    label926:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("needSavePhotosAlbum", bool1);
      localIntent.putExtra("weapp_user_name", aj.au(paramMap, "weappUserName"));
      localIntent.putExtra("weapp_version", aj.c(paramMap, "weappVersion", 0));
      localIntent.putExtra("source_type", aj.c(paramMap, "sourceType", 0));
      localIntent.putExtra("biz_user_name", aj.au(paramMap, "bizUin"));
      paramMap = ".ui.fts.FTSEmojiDetailPageUI";
      break;
      bool1 = false;
      break label810;
    }
  }
  
  public static boolean bO(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = aj.au(paramMap, "word");
    boolean bool1 = aj.av(paramMap, "isInputChange");
    String str2 = aj.au(paramMap, "custom");
    String str3 = aj.au(paramMap, "tagList");
    boolean bool2 = aj.av(paramMap, "cache");
    paramMap = k.auP(Util.nullAsInt(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool1);
    localBundle.putString("fts_key_tag_list", str3);
    localBundle.putBoolean("fts_key_cache", bool2);
    try
    {
      if (paramMap.WFb != null) {
        paramMap.WFb.i(122, localBundle);
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
  
  public static boolean bR(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77921);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doSearchWebQuery %s", new Object[] { paramMap.toString() });
    String str1 = aj.au(paramMap, "requestId");
    String str2 = aj.au(paramMap, "commReq");
    int i = aj.c(paramMap, "webview_instance_id", -1);
    com.tencent.mm.kernel.h.aZW().a(new x(str1, str2, i), 0);
    AppMethodBeat.o(77921);
    return false;
  }
  
  public static String bS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(369831);
    paramMap = aj.bo(paramMap);
    AppMethodBeat.o(369831);
    return paramMap;
  }
  
  public static boolean bT(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295755);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderProfile %s", new Object[] { paramMap });
    String str = aj.au(paramMap, "userName");
    paramMap = aj.au(paramMap, "reportExtraInfo");
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", str);
    localIntent.putExtra("key_from_profile_share_scene", 14);
    localIntent.putExtra("key_enter_profile_type", 1);
    localIntent.putExtra("key_extra_info", paramMap);
    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(6, 2, 32, localIntent);
    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
    AppMethodBeat.o(295755);
    return false;
  }
  
  public static boolean bU(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295762);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", aj.au(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(aj.au(paramMap, "extInfo")));
      localJSONObject.put("extraInfo", aj.au(paramMap, "extraInfo"));
      paramMap = new Intent();
      paramMap.putExtra("tab_type", 8);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(6, 2, 25, paramMap);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), localJSONObject.toString(), paramMap);
      label143:
      AppMethodBeat.o(295762);
      return false;
    }
    catch (Exception paramMap)
    {
      break label143;
    }
  }
  
  public static boolean bV(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295766);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getCurrentLocation %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        i = aj.c(paramMap, "webview_instance_id", -1);
        paramMap = aj.dch();
        if (paramMap == null) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("latitude", paramMap.ZaH);
        localJSONObject.put("longitude", paramMap.ZaG);
        localJSONObject.put("precision", paramMap.Zyl);
        localJSONObject.put("macAddr", paramMap.ZaH);
        localJSONObject.put("cellId", paramMap.ZaH);
        localJSONObject.put("gpsSource", paramMap.ZaH);
        localJSONObject.put("address", paramMap.ZaH);
        k.auP(i).bmz(localJSONObject.toString());
      }
      catch (Exception paramMap)
      {
        int i;
        continue;
      }
      AppMethodBeat.o(295766);
      return false;
      k.auP(i).bmz("");
    }
  }
  
  /* Error */
  public static boolean bW(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 1119
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 112
    //   8: ldc_w 1121
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 733	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ldc_w 963
    //   26: iconst_m1
    //   27: invokestatic 533	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   30: invokestatic 286	com/tencent/mm/plugin/webview/ui/tools/jsapi/k:auP	(I)Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/j;
    //   33: astore 4
    //   35: aload_0
    //   36: ldc_w 1123
    //   39: invokestatic 538	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: new 344	android/os/Bundle
    //   46: dup
    //   47: invokespecial 345	android/os/Bundle:<init>	()V
    //   50: astore 5
    //   52: aload 5
    //   54: ldc_w 1125
    //   57: aload_3
    //   58: invokevirtual 353	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc_w 1127
    //   64: aload_3
    //   65: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   68: ifeq +30 -> 98
    //   71: aload_0
    //   72: ldc_w 1132
    //   75: invokeinterface 1135 2 0
    //   80: ifeq +18 -> 98
    //   83: aload 5
    //   85: ldc_w 1137
    //   88: aload_0
    //   89: ldc_w 1132
    //   92: invokestatic 538	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 353	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: ldc_w 1139
    //   101: aload_3
    //   102: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   105: ifeq +311 -> 416
    //   108: aload_0
    //   109: ldc_w 1141
    //   112: invokeinterface 1135 2 0
    //   117: ifeq +175 -> 292
    //   120: aload_0
    //   121: ldc_w 1141
    //   124: invokestatic 538	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 6
    //   129: aload 6
    //   131: invokestatic 468	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   134: istore_2
    //   135: iload_2
    //   136: ifne +38 -> 174
    //   139: new 1054	org/json/JSONObject
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 1063	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload_3
    //   150: ldc_w 1142
    //   153: invokevirtual 1145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   156: ifeq +18 -> 174
    //   159: aload 5
    //   161: ldc_w 1142
    //   164: aload_3
    //   165: ldc_w 1142
    //   168: invokevirtual 1148	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokevirtual 353	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aconst_null
    //   175: astore_3
    //   176: aload 6
    //   178: invokestatic 468	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   181: istore_2
    //   182: iload_2
    //   183: ifne +412 -> 595
    //   186: new 1054	org/json/JSONObject
    //   189: dup
    //   190: aload 6
    //   192: invokespecial 1063	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   195: astore 7
    //   197: aload 7
    //   199: ldc_w 1150
    //   202: invokevirtual 1145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   205: ifeq +12 -> 217
    //   208: aload 7
    //   210: ldc_w 1150
    //   213: invokevirtual 1148	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_3
    //   217: aload 5
    //   219: ldc_w 1152
    //   222: aload_3
    //   223: invokevirtual 353	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 6
    //   228: invokestatic 468	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   231: istore_2
    //   232: iload_2
    //   233: ifne +268 -> 501
    //   236: new 1054	org/json/JSONObject
    //   239: dup
    //   240: aload 6
    //   242: invokespecial 1063	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: astore 6
    //   247: aload 6
    //   249: ldc_w 1154
    //   252: invokevirtual 1145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   255: ifeq +246 -> 501
    //   258: aload 6
    //   260: ldc_w 1154
    //   263: invokevirtual 1157	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   266: istore_2
    //   267: aload 5
    //   269: ldc_w 1159
    //   272: iload_2
    //   273: invokevirtual 977	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   276: ldc_w 992
    //   279: ldc_w 1161
    //   282: aload_3
    //   283: invokestatic 1164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 1167	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_0
    //   293: ldc_w 1169
    //   296: invokeinterface 1135 2 0
    //   301: ifeq +19 -> 320
    //   304: aload 5
    //   306: ldc_w 1171
    //   309: aload_0
    //   310: ldc_w 1169
    //   313: iconst_0
    //   314: invokestatic 533	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   317: invokevirtual 367	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   320: aload_0
    //   321: ldc_w 1173
    //   324: invokeinterface 1135 2 0
    //   329: ifeq +24 -> 353
    //   332: aload_0
    //   333: ldc_w 1173
    //   336: invokestatic 798	com/tencent/mm/plugin/websearch/api/aj:av	(Ljava/util/Map;Ljava/lang/String;)Z
    //   339: ifeq +167 -> 506
    //   342: iconst_1
    //   343: istore_1
    //   344: aload 5
    //   346: ldc_w 1175
    //   349: iload_1
    //   350: invokevirtual 367	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   353: aload_0
    //   354: ldc_w 1177
    //   357: invokeinterface 568 2 0
    //   362: checkcast 496	java/lang/String
    //   365: astore_0
    //   366: aload_0
    //   367: invokestatic 468	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   370: istore_2
    //   371: iload_2
    //   372: ifne +44 -> 416
    //   375: new 1054	org/json/JSONObject
    //   378: dup
    //   379: aload_0
    //   380: invokespecial 1063	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: ldc_w 1132
    //   386: ldc_w 1179
    //   389: invokevirtual 1181	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_0
    //   393: aload_0
    //   394: ldc_w 1183
    //   397: invokevirtual 835	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   400: istore_2
    //   401: iload_2
    //   402: ifeq +109 -> 511
    //   405: iconst_1
    //   406: istore_1
    //   407: aload 5
    //   409: ldc_w 1185
    //   412: iload_1
    //   413: invokevirtual 367	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   416: aload 4
    //   418: getfield 985	com/tencent/mm/plugin/webview/ui/tools/jsapi/j:WFb	Lcom/tencent/mm/plugin/webview/stub/f;
    //   421: ifnull +19 -> 440
    //   424: aload 4
    //   426: getfield 985	com/tencent/mm/plugin/webview/ui/tools/jsapi/j:WFb	Lcom/tencent/mm/plugin/webview/stub/f;
    //   429: sipush 154
    //   432: aload 5
    //   434: invokeinterface 990 3 0
    //   439: pop
    //   440: ldc_w 1119
    //   443: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: iconst_0
    //   447: ireturn
    //   448: astore_3
    //   449: ldc_w 992
    //   452: aload_3
    //   453: ldc_w 570
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 1189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: goto -289 -> 174
    //   466: astore_3
    //   467: ldc_w 992
    //   470: aload_3
    //   471: ldc_w 570
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 1189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: goto +114 -> 595
    //   484: astore 6
    //   486: ldc_w 992
    //   489: aload 6
    //   491: ldc_w 570
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 1189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: iconst_0
    //   502: istore_2
    //   503: goto -236 -> 267
    //   506: iconst_2
    //   507: istore_1
    //   508: goto -164 -> 344
    //   511: aload_0
    //   512: ldc_w 1191
    //   515: invokevirtual 835	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifeq +8 -> 526
    //   521: iconst_2
    //   522: istore_1
    //   523: goto -116 -> 407
    //   526: aload_0
    //   527: ldc_w 1179
    //   530: invokevirtual 835	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   533: istore_2
    //   534: iload_2
    //   535: ifeq +65 -> 600
    //   538: iconst_3
    //   539: istore_1
    //   540: goto -133 -> 407
    //   543: astore_0
    //   544: ldc_w 992
    //   547: aload_0
    //   548: ldc_w 570
    //   551: iconst_0
    //   552: anewarray 4	java/lang/Object
    //   555: invokestatic 1189	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   558: goto +42 -> 600
    //   561: astore_0
    //   562: ldc_w 992
    //   565: new 157	java/lang/StringBuilder
    //   568: dup
    //   569: ldc_w 1193
    //   572: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   575: aload_0
    //   576: invokevirtual 997	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   579: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 999	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: goto -148 -> 440
    //   591: astore_0
    //   592: goto -152 -> 440
    //   595: aconst_null
    //   596: astore_3
    //   597: goto -380 -> 217
    //   600: iconst_0
    //   601: istore_1
    //   602: goto -195 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	paramMap	Map<String, Object>
    //   343	259	1	i	int
    //   134	401	2	bool	boolean
    //   42	241	3	localObject1	Object
    //   448	5	3	localJSONException1	JSONException
    //   466	5	3	localJSONException2	JSONException
    //   596	1	3	localObject2	Object
    //   33	392	4	localj	com.tencent.mm.plugin.webview.ui.tools.jsapi.j
    //   50	383	5	localBundle	Bundle
    //   127	132	6	localObject3	Object
    //   484	6	6	localJSONException3	JSONException
    //   195	14	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   139	174	448	org/json/JSONException
    //   186	197	466	org/json/JSONException
    //   197	217	466	org/json/JSONException
    //   236	267	484	org/json/JSONException
    //   375	401	543	org/json/JSONException
    //   511	521	543	org/json/JSONException
    //   526	534	543	org/json/JSONException
    //   416	440	561	android/os/RemoteException
    //   22	98	591	java/lang/Exception
    //   98	135	591	java/lang/Exception
    //   139	174	591	java/lang/Exception
    //   176	182	591	java/lang/Exception
    //   186	197	591	java/lang/Exception
    //   197	217	591	java/lang/Exception
    //   217	232	591	java/lang/Exception
    //   236	267	591	java/lang/Exception
    //   267	292	591	java/lang/Exception
    //   292	320	591	java/lang/Exception
    //   320	342	591	java/lang/Exception
    //   344	353	591	java/lang/Exception
    //   353	371	591	java/lang/Exception
    //   375	401	591	java/lang/Exception
    //   407	416	591	java/lang/Exception
    //   416	440	591	java/lang/Exception
    //   449	463	591	java/lang/Exception
    //   467	481	591	java/lang/Exception
    //   486	501	591	java/lang/Exception
    //   511	521	591	java/lang/Exception
    //   526	534	591	java/lang/Exception
    //   544	558	591	java/lang/Exception
    //   562	588	591	java/lang/Exception
  }
  
  public static boolean bX(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295795);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "showNavBarShadow %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        int i = aj.c(paramMap, "webview_instance_id", -1);
        localObject = aj.au(paramMap, "color");
        double d = Double.valueOf(paramMap.get("alpha").toString()).doubleValue();
        paramMap = ((String)localObject).substring(1, ((String)localObject).length());
        int j = (int)(d * 255.0D);
        int k = Integer.parseInt(paramMap, 16);
        paramMap = k.auP(i);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fts_key_data", k);
        ((Bundle)localObject).putInt("fts_key_cache", j);
      }
      finally
      {
        Object localObject;
        continue;
      }
      try
      {
        if (paramMap.WFb != null) {
          paramMap.WFb.i(155, (Bundle)localObject);
        }
        AppMethodBeat.o(295795);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "showNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bY(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295801);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hideNavBarShadow");
    for (;;)
    {
      try
      {
        paramMap = k.auP(aj.c(paramMap, "webview_instance_id", -1));
      }
      finally
      {
        continue;
      }
      try
      {
        if (paramMap.WFb != null) {
          paramMap.WFb.i(156, new Bundle());
        }
        AppMethodBeat.o(295801);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "hideNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  public static int e(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(77912);
    paramMap1 = aj.au(paramMap1, "data");
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject);
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
  
  private static void v(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle z(int paramInt, Bundle paramBundle)
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
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.g.ivW().itd());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", al.bix(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = al.bix("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = aj.r(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", al.biy(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.j paramj)
  {
    AppMethodBeat.i(77904);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openSearchWebView %s", new Object[] { paramMap.toString() });
    int k = Util.safeParseInt((String)paramMap.get("actionType"));
    int m = aj.c(paramMap, "type", 0);
    Object localObject4 = (String)paramMap.get("extParams");
    String str4 = (String)paramMap.get("jumpTo");
    String str2 = (String)paramMap.get("navBarColor");
    Object localObject5 = aj.au(paramMap, "publishId");
    boolean bool2 = "true".equals((String)paramMap.get("hideSearchBar"));
    int n = Util.safeParseInt((String)paramMap.get("isHomePage"));
    String str3 = String.valueOf(paramMap.get("isSug"));
    Object localObject1 = (String)paramMap.get("nativeConfig");
    String str1 = null;
    if (!Util.isNullOrNil((String)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).has("title")) {
          str1 = ((JSONObject)localObject1).optString("title");
        }
        String str5;
        boolean bool1;
        int i;
        int i1;
        int j;
        String str7;
        String str6;
        int i2;
        int i3;
        Object localObject2;
        String str8;
        Object localObject3 = null;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (((JSONObject)localObject1).has("searchBarTextColor"))
          {
            localObject1 = ((JSONObject)localObject1).optString("searchBarTextColor");
            str5 = (String)paramMap.get("navButtonConfig");
            if (!Util.isNullOrNil(str5)) {
              try
              {
                str5 = new JSONObject(str5).optString("leftBarButtonType", "back");
                bool1 = str5.equals("exit");
                if (bool1)
                {
                  i = 1;
                  i1 = aj.c(paramMap, "ftsNeedHideKeyBoard", 0);
                  j = 0;
                  if (Util.isNullOrNil(str2)) {}
                }
              }
              catch (JSONException localJSONException3)
              {
                Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localJSONException3, "", new Object[0]);
              }
            }
            try
            {
              j = Color.parseColor(str2);
              str5 = (String)paramMap.get("statusBarStyle");
              str7 = (String)paramMap.get("tagId");
              str2 = (String)paramMap.get("sessionId");
              str6 = (String)paramMap.get("srcUserName");
              i2 = aj.c(paramMap, "scene", 0);
              i3 = aj.c(paramMap, "subType", 0);
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
              Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
              AppMethodBeat.o(77904);
              return true;
            }
            localJSONException1 = localJSONException1;
            str1 = null;
            Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localJSONException1, "", new Object[0]);
            localObject2 = null;
            continue;
            bool1 = str5.equals("none");
            if (bool1)
            {
              i = 2;
              continue;
              i = 0;
              continue;
              switch (m)
              {
              default: 
                paramMap = aj.au(paramMap, "jumpUrl");
                Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
                paramj = paramj.iBn();
                if (Util.isNullOrNil(paramMap)) {
                  continue;
                }
                com.tencent.mm.plugin.webview.modeltools.g.ivW();
                a(paramMap, paramj, j, localJSONException3, (String)localObject5, str6, i2, i3, "");
                break;
              case 8: 
                aj.au(paramMap, "snsid");
                paramj = aj.au(paramMap, "objectXmlDesc");
                str1 = aj.au(paramMap, "userName");
                bool1 = aj.av(paramMap, "fromMusicItem");
                com.tencent.mm.plugin.webview.modeltools.g.ivW();
                J(paramj, str1, bool1);
                break;
              case 1: 
                a(bL(paramMap), false);
                break;
              case 32: 
                a(bM(paramMap));
                continue;
                str1 = aj.au(paramMap, "query");
                localObject2 = new JSONObject();
                try
                {
                  ((JSONObject)localObject2).put("word", str1);
                  ((JSONObject)localObject2).put("id", String.valueOf(System.currentTimeMillis()));
                  ((JSONObject)localObject2).put("timestamp", String.valueOf(System.currentTimeMillis()));
                  ((JSONObject)localObject2).put("showType", 1);
                  ((JSONObject)localObject2).put("jumpUrl", aj.au(paramMap, "jumpUrl"));
                  ((n)com.tencent.mm.kernel.h.az(n.class)).addSOSHistory(str1 + "​1", ((JSONObject)localObject2).toString());
                  paramMap = aj.au(paramMap, "jumpUrl");
                  Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s", new Object[] { paramMap });
                  paramj = paramj.iBn();
                  if (Util.isNullOrNil(paramMap)) {
                    continue;
                  }
                  com.tencent.mm.plugin.webview.modeltools.g.ivW();
                  a(paramMap, paramj, j, localJSONException3, (String)localObject5, str6, i2, i3, "");
                  continue;
                  str6 = aj.au(paramMap, "query");
                  str8 = aj.au(paramMap, "searchId");
                  paramj = new Intent();
                  paramj.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
                  paramj.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
                  paramj.putExtra("neverGetA8Key", true);
                  paramj.putExtra("key_load_js_without_delay", true);
                  paramj.putExtra("ftsQuery", str6);
                  paramj.putExtra("ftsType", m);
                  paramj.putExtra("customize_status_bar_color", j);
                  paramj.putExtra("status_bar_style", localJSONException3);
                  paramj.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str4));
                  paramj.putExtra("KPublisherId", (String)localObject5);
                  paramj.putExtra("ftsbizscene", i2);
                  if (str1 != null) {
                    paramj.putExtra("title", str1);
                  }
                  i3 = aj.c(paramMap, "tabPageType", 0);
                  if ((i1 == 1) || (i1 == 2))
                  {
                    if (i1 == 1)
                    {
                      bool1 = true;
                      paramj.putExtra("ftsneedkeyboard", bool1);
                    }
                  }
                  else
                  {
                    paramMap = aj.a(i2, false, m, (String)localObject4);
                    paramMap.put("query", afS(str6));
                    paramMap.put("searchId", str8);
                    paramMap.put("isHomePage", String.valueOf(n));
                    paramMap.put("isSug", str3);
                    if (!TextUtils.isEmpty(str2))
                    {
                      paramMap.put("sessionId", str2);
                      paramj.putExtra("sessionId", str2);
                    }
                    localObject5 = aj.asV(i2);
                    paramMap.put("subSessionId", localObject5);
                    paramj.putExtra("subSessionId", (String)localObject5);
                    paramj.putExtra("rawUrl", aj.bo(paramMap));
                    paramj.putExtra("ftsQuery", str6);
                    paramj.putExtra("customize_status_bar_color", j);
                    paramj.putExtra("status_bar_style", localJSONException3);
                    paramj.putExtra("tabId", str7);
                    paramj.putExtra("key_load_js_without_delay", true);
                    paramj.putExtra("key_back_btn_type", i);
                    paramj.putExtra("key_search_bar_text_color", (String)localObject2);
                    if ((i1 <= 0) && (k == 7)) {
                      paramj.putExtra("ftsneedkeyboard", true);
                    }
                    if (i3 != 1) {
                      continue;
                    }
                    paramj.putExtra("ftscaneditable", false);
                    aj.a(MMApplicationContext.getContext(), str6, paramj, str1, (String)localObject4, str8, str2, (String)localObject5);
                    AppMethodBeat.o(77904);
                    return false;
                  }
                  bool1 = false;
                  continue;
                  if ((i2 == 20) || (i2 == 22) || (i2 == 33) || (i2 == 3) || (i2 == 34) || (i2 == 65) || (i2 == 36) || (i2 == 100) || (i2 == 67))
                  {
                    paramj.putExtra("key_search_icon_and_hint_fix_default", true);
                    paramj.putExtra("ftsInitToSearch", true);
                    paramj.putExtra("hideSearchInput", bool2);
                    paramMap = ".ui.tools.fts.FTSSOSHomeWebViewUI";
                    if (TextUtils.isEmpty(paramMap)) {
                      continue;
                    }
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", paramMap, paramj);
                    continue;
                  }
                  paramj.putExtra("key_change_search_icon", true);
                  paramj.putExtra("key_search_icon_and_hint_fix_default", true);
                  paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI";
                  continue;
                  paramj = aj.au(paramMap, "query");
                  i = aj.c(paramMap, "topStoryScene", 0);
                  j = aj.c(paramMap, "tagId", 0);
                  localObject2 = aj.au(paramMap, "navigationId");
                  paramMap = str2;
                  if (Util.isNullOrNil(str2)) {
                    paramMap = aj.asV(i);
                  }
                  str2 = String.valueOf(System.currentTimeMillis());
                  localObject5 = new HashMap();
                  ((HashMap)localObject5).put("scene", "21");
                  ((HashMap)localObject5).put("query", paramj);
                  ((HashMap)localObject5).put("extParams", localObject4);
                  ((HashMap)localObject5).put("sessionId", paramMap);
                  ((HashMap)localObject5).put("subSessionId", paramMap);
                  ((HashMap)localObject5).put("requestId", str2);
                  ((HashMap)localObject5).put("pRequestId", str2);
                  ((HashMap)localObject5).put("seq", str2);
                  ((HashMap)localObject5).put("navigationId", localObject2);
                  ((HashMap)localObject5).put("channelId", String.valueOf(j));
                  localObject4 = new fnt();
                  ((fnt)localObject4).zIO = com.tencent.mm.plugin.topstory.ui.d.hNb();
                  ((fnt)localObject4).scene = i;
                  ((fnt)localObject4).mpa = "";
                  ((fnt)localObject4).hAB = paramj;
                  ((fnt)localObject4).sessionId = paramMap;
                  ((fnt)localObject4).hVn = paramMap;
                  ((fnt)localObject4).tBy = 2;
                  ((fnt)localObject4).url = com.tencent.mm.plugin.topstory.a.g.t((HashMap)localObject5);
                  ((fnt)localObject4).tgw = str1;
                  ((fnt)localObject4).channelId = j;
                  ((fnt)localObject4).hOG = str2;
                  ((fnt)localObject4).Wot = ((String)localObject2);
                  ((fnt)localObject4).GtP = aj.gtA();
                  paramMap = new aem();
                  paramMap.key = "rec_category";
                  paramMap.Zmx = j;
                  paramMap.Zmy = String.valueOf(j);
                  ((fnt)localObject4).Wol.add(paramMap);
                  com.tencent.mm.plugin.topstory.ui.d.a(MMApplicationContext.getContext(), (fnt)localObject4, str2);
                }
                catch (Exception localException)
                {
                  continue;
                }
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          continue;
          i = 0;
          continue;
          localObject3 = null;
          continue;
        }
      }
      str1 = null;
    }
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.j paramj, String paramString)
  {
    AppMethodBeat.i(77905);
    this.WAG.TIX = true;
    boolean bool1 = aj.av(paramMap, "isTeachPage");
    boolean bool2 = aj.av(paramMap, "isMoreButton");
    int j;
    String str1;
    String str2;
    String str3;
    int m;
    String str4;
    int k;
    int i;
    if (aj.c(paramMap, "isFeedBack", 0) == 1)
    {
      j = 1;
      str1 = aj.au(paramMap, "srcUserName");
      str2 = aj.au(paramMap, "sessionId");
      str3 = (String)paramMap.get("navBarColor");
      m = aj.c(paramMap, "subType", 0);
      aj.au(paramMap, "searchPlaceHolder");
      str4 = aj.au(paramMap, "jumpUrl");
      k = -1;
      i = k;
      if (!Util.isNullOrNil(str4)) {
        if (!str4.contains("http://mp.weixin.qq.com/imgretrieval"))
        {
          i = k;
          if (!str4.contains("https://mp.weixin.qq.com/imgretrieval")) {}
        }
        else
        {
          i = 3;
        }
      }
      k = 0;
      if (Util.isNullOrNil(str3)) {}
    }
    for (;;)
    {
      try
      {
        k = Color.parseColor(str3);
        str3 = (String)paramMap.get("statusBarStyle");
        if (j == 0) {
          break label263;
        }
        paramString = aj.au(paramMap, "jumpUrl");
        paramMap = null;
        if (paramj != null) {
          paramMap = paramj.iBn();
        }
        com.tencent.mm.plugin.webview.modeltools.g.ivW();
        v(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      j = 0;
      break;
      label263:
      j = aj.c(paramMap, "type", 0);
      int n = aj.c(paramMap, "opType", 0);
      if (n > 0)
      {
        switch (n)
        {
        default: 
          break;
        case 2: 
          a(bL(paramMap), bool1);
          break;
        case 3: 
          paramMap = bL(paramMap);
          if (!ab.IR(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          an.biA(paramMap.username);
          paramj = new Intent();
          paramj.putExtra("Chat_User", paramMap.username);
          paramj.putExtra("finish_direct", true);
          paramj.putExtra("key_temp_session_show_type", 0);
          paramj.putExtra("preChatTYPE", 9);
          com.tencent.mm.br.c.g(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", paramj);
          break;
        case 4: 
          paramString = aj.au(paramMap, "jumpUrl");
          paramMap = null;
          if (paramj != null) {
            paramMap = paramj.iBn();
          }
          com.tencent.mm.plugin.webview.modeltools.g.ivW();
          v(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str1 = aj.au(paramMap, "query");
        i = aj.c(paramMap, "scene", 0);
        paramMap = aj.au(paramMap, "searchId");
        paramj = new Intent();
        paramj.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
        paramj.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
        paramj.putExtra("neverGetA8Key", true);
        paramj.putExtra("key_load_js_without_delay", true);
        paramj.putExtra("ftsQuery", str1);
        paramj.putExtra("ftsType", j);
        paramj.putExtra("sessionId", str2);
        paramString = aj.a(i, false, j, paramString);
        try
        {
          paramString.put("query", r.as(str1, "UTF-8"));
          paramString.put("searchId", paramMap);
          paramString.put("sessionId", str2);
          str1 = aj.asV(Util.safeParseInt((String)paramString.get("scene")));
          paramString.put("subSessionId", str1);
          paramj.putExtra("subSessionId", str1);
          paramj.putExtra("rawUrl", aj.bo(paramString));
          paramj.putExtra("key_session_id", str2);
          paramj.putExtra("searchId", paramMap);
          if ((i == 20) || (i == 22) || (i == 24) || (i == 33))
          {
            paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", paramMap, paramj);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramString.put("query", str1);
            continue;
            paramMap = ".ui.tools.fts.FTSSearchTabWebViewUI";
          }
        }
      }
      else
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(j), (String)paramMap.get("url") });
        switch (j)
        {
        default: 
          paramString = aj.au(paramMap, "jumpUrl");
          str2 = aj.au(paramMap, "publishId");
          j = aj.c(paramMap, "payScene", 0);
          n = aj.c(paramMap, "scene", 0);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str2, Integer.valueOf(j) });
          str4 = aj.au(paramMap, "cookie");
          paramMap = null;
          if (paramj != null) {
            paramMap = paramj.iBn();
          }
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.g.ivW();
            a(paramString, paramMap, k, localException, str2, j, str1, n, m, str4, i);
          }
          break;
        case 8: 
          aj.au(paramMap, "snsid");
          paramj = aj.au(paramMap, "objectXmlDesc");
          paramString = aj.au(paramMap, "userName");
          bool1 = aj.av(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.g.ivW();
          J(paramj, paramString, bool1);
          break;
        case 1: 
          a(bL(paramMap), false);
          break;
        case 32: 
          a(bM(paramMap));
        }
      }
    }
  }
  
  public final g atu(int paramInt)
  {
    AppMethodBeat.i(295868);
    if (this.WAF.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.atv(paramInt);
      if (localg != null) {
        this.WAF.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.WAF.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(295868);
    return localg;
  }
  
  public final boolean bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (aj.c(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (am.Wpw == null) {
        am.iqd();
      }
      am.Wpw.vgO.clear();
      paramMap = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = am.cwe();
        localObject2 = Base64.encodeToString(am.Wpw.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        Log.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = aj.c(paramMap, "type", 0);
      int j = aj.c(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.teM > 1000L)
      {
        this.teM = System.currentTimeMillis();
        if (!aj.asX(0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          as.V(i, j, al.biy("searchID"));
          paramMap = aj.ipS();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", aj.bo(aj.r(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          paramMap.putExtra("key_change_search_icon", true);
          paramMap.putExtra("key_search_icon_and_hint_fix_default", true);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = k.auP(aj.c(paramMap, "webview_instance_id", -1));
          i = aj.c(paramMap, "scene", 0);
          paramMap = aj.au(paramMap, "query");
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
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb.i(136, (Bundle)localObject2);
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
  
  public final boolean bF(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    final int i = aj.c(paramMap, "scene", 0);
    final int k = aj.c(paramMap, "type", 0);
    int m = aj.c(paramMap, "requestType", 0);
    final int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    final String str = (String)paramMap.get("requestId");
    Object localObject1 = (String)paramMap.get("guideInfo");
    Object localObject2 = (String)paramMap.get("sessionId");
    boolean bool = aj.av(paramMap, "ignoreCache");
    if (m == 0)
    {
      paramMap = ne(i, k);
      if ((paramMap.isAvailable()) && (!bool))
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.HAd), Long.valueOf(paramMap.HAe), Integer.valueOf(paramMap.type), paramMap.hMi });
        k.auP(j).f(m, paramMap.hMi, 1, str);
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          as.a(paramMap.scene, 0, paramMap.xVe, paramMap.type, 2, paramMap.fyV(), 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77902);
        return false;
        as.a(paramMap.scene, 0, paramMap.xVe, paramMap.type, 1, "", 0);
        continue;
        com.tencent.mm.plugin.webview.modeltools.g.ivX().WBQ.a(2, str, Integer.valueOf(j), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(295523);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData realTime, webviewID = %d", new Object[] { Integer.valueOf(j) });
            com.tencent.mm.kernel.h.aZW().a(1048, c.this);
            String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            long l = al.bix("discoverSearchEntry").optLong("guideParam");
            c.a(c.this, new ad(i, k, aj.asY(0), j, str, l, str, this.rma, this.WAR));
            com.tencent.mm.kernel.h.aZW().a(c.a(c.this), 0);
            AppMethodBeat.o(295523);
          }
        }, this.WAw);
      }
    }
    paramMap = an.iqf();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        i = paramMap.vgO.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject3 = (dre)paramMap.vgO.get(i);
          if (!ab.IR(((dre)localObject3).Username)) {
            break label610;
          }
          localObject3 = com.tencent.mm.an.g.hU(((dre)localObject3).Username);
          if (localObject3 == null) {
            break label610;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.api.c)localObject3).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.api.c)localObject3).field_username);
          localJSONObject2.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(((com.tencent.mm.api.c)localObject3).field_username));
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
        k.auP(j).f(1, paramMap, 1, str);
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
  
  public final boolean bG(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = aj.c(paramMap, "scene", 201);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    Object localObject = atu(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.j localj;
    String str;
    if (localObject != null)
    {
      localj = k.auP(i);
      str = ((g)localObject).hMi;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localj.v(str, 1, i, ((g)localObject).qzs);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.h.aZW().a(1866, this);
        localObject = new e(paramMap, j, 0);
        if (paramMap != null) {
          ((e)localObject).hVk = aj.c(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean bK(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    eqy localeqy = new eqy();
    localeqy.abuE = aj.au(paramMap, "logString");
    com.tencent.mm.kernel.h.aZW().a(1134, this);
    paramMap = new ae(localeqy);
    com.tencent.mm.kernel.h.aZW().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bP(Map<String, Object> paramMap)
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
      if (this.WAJ.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.WAI == null) {
        this.WAI = new com.tencent.mm.plugin.websearch.c.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.c.a.d(str, (List)localObject);
      if (this.WAJ == null) {}
    }
    this.WAJ = paramMap;
    this.WAI.a(paramMap, new com.tencent.mm.plugin.websearch.c.a.c.a()
    {
      public final void iqH()
      {
        AppMethodBeat.i(295543);
        c.b(c.e(c.this), j, k, m);
        AppMethodBeat.o(295543);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.WAJ.hAE) {
        a(this.WAJ, j, k, m);
      }
    }
  }
  
  public final boolean bQ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = aj.au(paramMap, "md5");
    int i = aj.c(paramMap, "offset", 0);
    String str2 = aj.au(paramMap, "searchId");
    String str3 = aj.au(paramMap, "sessionId");
    int j = aj.c(paramMap, "tab", 0);
    String str4 = aj.au(paramMap, "requestId");
    int k = aj.c(paramMap, "scene", 0);
    int m = aj.c(paramMap, "webview_instance_id", -1);
    String str5 = aj.au(paramMap, "emojiUrl");
    paramMap = aj.au(paramMap, "aesKey");
    if (this.WAK != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.WAK);
      com.tencent.mm.kernel.h.aZW().b(2999, this);
    }
    com.tencent.mm.kernel.h.aZW().a(2999, this);
    this.WAK = new d(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.WAK.hVk = m;
    com.tencent.mm.kernel.h.aZW().a(this.WAK, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final boolean bZ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295876);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    this.WAD.add(Integer.valueOf(i));
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException) {}
    }
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "playMusic webviewID:%s", new Object[] { Integer.valueOf(i) });
    q.d(localJSONObject, false);
    AppMethodBeat.o(295876);
    return false;
  }
  
  public final boolean ca(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295878);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    this.WAD.add(Integer.valueOf(i));
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException) {}
    }
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openMusicPage webviewID:%s", new Object[] { Integer.valueOf(i) });
    q.d(localJSONObject, true);
    AppMethodBeat.o(295878);
    return false;
  }
  
  public final String itd()
  {
    AppMethodBeat.i(77901);
    Object localObject = D(20, 0, true);
    if (this.HAb.get(localObject) == null)
    {
      b localb = new b();
      localb.nf(20, 0);
      this.HAb.put(localObject, localb);
    }
    localObject = (b)this.HAb.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).hMi; Util.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(77901);
      return "";
    }
    AppMethodBeat.o(77901);
    return localObject;
  }
  
  public final b ne(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295825);
    Object localObject = D(paramInt1, paramInt2, true);
    if (this.HAb.get(localObject) == null)
    {
      b localb = new b();
      localb.nf(paramInt1, paramInt2);
      this.HAb.put(localObject, localb);
    }
    localObject = (b)this.HAb.get(localObject);
    AppMethodBeat.o(295825);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(77913);
    if ((paramp instanceof ad))
    {
      com.tencent.mm.kernel.h.aZW().b(1048, this);
      paramString = new h(paramInt1, paramInt2, (ad)paramp);
      com.tencent.mm.plugin.webview.modeltools.g.ivX().WBQ.a(2, ((ad)paramp).hOG, paramString, this.WAw);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramp instanceof ae))
    {
      com.tencent.mm.kernel.h.aZW().b(1134, this);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramp instanceof e))
    {
      com.tencent.mm.kernel.h.aZW().b(1866, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (e)paramp;
      if (paramString.hVk != -1) {
        k.auP(paramString.hVk).v(((gew)com.tencent.mm.am.c.c.b(paramString.rr.otC)).hMi, 0, 0, 0);
      }
      if (paramString.WBe != null) {
        this.WAF.put(Integer.valueOf(paramString.WBe.scene), paramString.WBe);
      }
      AppMethodBeat.o(77913);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof d))
    {
      com.tencent.mm.kernel.h.aZW().b(2999, this);
      localObject1 = (d)paramp;
      paramp = Util.nullAs(((d)localObject1).WBd.aayd, "");
      if (((d)localObject1).hVk != -1)
      {
        localObject1 = k.auP(((d)localObject1).hVk);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("fts_key_json_data", paramp);
        ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
        ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb.i(152, (Bundle)localObject2);
          }
          AppMethodBeat.o(77913);
          return;
        }
        catch (Exception paramString) {}
      }
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramp instanceof x))
    {
      localObject2 = (x)paramp;
      paramp = Util.nullAs(((x)localObject2).hMP().acds, "");
      if (((x)localObject2).hVk != -1)
      {
        localObject1 = k.auP(((x)localObject2).hVk);
        localObject2 = ((x)localObject2).hOG;
        Bundle localBundle = new Bundle();
        localBundle.putString("fts_key_id", (String)localObject2);
        localBundle.putString("fts_key_json_data", paramp);
        localBundle.putString("fts_key_err_msg", paramString);
        localBundle.putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb.i(153, localBundle);
          }
          AppMethodBeat.o(77913);
          return;
        }
        catch (Exception paramString) {}
      }
    }
    AppMethodBeat.o(77913);
  }
  
  public final class a
    implements Runnable
  {
    public boolean WAT;
    public String data;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(77890);
      ArrayList localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(this.data);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = ((com.tencent.mm.plugin.sns.c.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.p.class)).Pm(localJSONArray.getString(i));
          com.tencent.mm.kernel.h.baF();
          localObject = i.a(com.tencent.mm.kernel.h.baE().mCJ, (TimeLineObject)localObject, 9, null);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
        if (!this.WAT) {
          break label132;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
        AppMethodBeat.o(77890);
        return;
      }
      if (c.c(c.this) == null)
      {
        label132:
        c.a(c.this, localException);
        AppMethodBeat.o(77890);
        return;
      }
      c.c(c.this).addAll(localException);
      AppMethodBeat.o(77890);
    }
  }
  
  public static final class b
  {
    long HAd;
    long HAe;
    boolean WAU = false;
    String hMi;
    int scene;
    private String sgs = null;
    int type;
    String xVe;
    
    final String fyV()
    {
      AppMethodBeat.i(77892);
      if (this.sgs == null) {
        this.sgs = "";
      }
      try
      {
        localObject = new JSONObject(this.hMi).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.sgs = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.sgs;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final boolean isAvailable()
    {
      AppMethodBeat.i(77891);
      if (this.WAU)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((Util.isNullOrNil(this.hMi)) || (System.currentTimeMillis() / 1000L - this.HAe > this.HAd))
      {
        AppMethodBeat.o(77891);
        return false;
      }
      AppMethodBeat.o(77891);
      return true;
    }
    
    final void nf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      dlw localdlw = new dlw();
      Object localObject1 = com.tencent.mm.plugin.record.c.bzO();
      Object localObject2 = c.D(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(c.D(paramInt1, paramInt2, true))) {
        this.WAU = true;
      }
      localObject1 = new u((String)localObject1, (String)localObject2);
      localObject2 = y.bi(com.tencent.mm.vfs.ah.v(((u)localObject1).jKT()), 0, (int)((u)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localdlw.parseFrom((byte[])localObject2);
          this.scene = localdlw.scene;
          this.hMi = localdlw.aayd;
          this.HAd = localdlw.aaRX;
          this.HAe = localdlw.aaRY;
          this.xVe = localdlw.YYr;
          this.type = localdlw.vhJ;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.ah.v(((u)localObject1).jKT()), Integer.valueOf(localObject2.length) });
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
    public String MVy;
    public ahl MWY;
    public String Ndp;
    public int WAW;
    public boolean WAX;
    public String WAY;
    public int WAZ;
    public int hJx;
    public int hVr;
    public String mpa;
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
    public int WBa;
    public String city;
    public String country;
    public String kDc;
    public String nickname;
    public String province;
    public String query;
    public int scene;
    public int sex;
    public String signature;
    public String username;
    
    private d() {}
  }
  
  public final class e
  {
    public boolean TIX;
    public boolean hAE;
    public boolean lwK = true;
    public String query;
    public int scene;
    public int xVf;
    
    public e() {}
    
    public final void C(int paramInt1, String paramString, int paramInt2)
    {
      this.query = paramString;
      this.scene = paramInt1;
      this.hAE = false;
      this.xVf = paramInt2;
      this.TIX = false;
      this.lwK = false;
    }
  }
  
  public final class f
    extends com.tencent.mm.plugin.fts.a.a.l
  {
    public int WBb;
    
    private f() {}
  }
  
  static final class g
  {
    public long HAe;
    public String hMi;
    public long interval;
    public int qzs;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.hMi = "";
      this.interval = 0L;
      this.HAe = 0L;
      this.qzs = 0;
    }
    
    public g(int paramInt1, gew paramgew, int paramInt2)
    {
      AppMethodBeat.i(295657);
      this.scene = 0;
      this.hMi = "";
      this.interval = 0L;
      this.HAe = 0L;
      this.qzs = 0;
      this.scene = paramInt1;
      this.hMi = paramgew.hMi;
      this.interval = paramgew.interval;
      this.HAe = (System.currentTimeMillis() / 1000L);
      this.qzs = paramInt2;
      AppMethodBeat.o(295657);
    }
    
    /* Error */
    public static g atv(int paramInt)
    {
      // Byte code:
      //   0: ldc 61
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 63	com/tencent/mm/vfs/u
      //   8: dup
      //   9: invokestatic 69	com/tencent/mm/plugin/record/c:bzO	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 73	com/tencent/mm/plugin/webview/fts/c$g:atw	(I)Ljava/lang/String;
      //   16: invokespecial 76	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 80	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   24: invokestatic 86	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual 89	com/tencent/mm/vfs/u:length	()J
      //   32: l2i
      //   33: invokestatic 95	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
      //   36: astore_1
      //   37: new 97	com/tencent/mm/protocal/protobuf/dlx
      //   40: dup
      //   41: invokespecial 98	com/tencent/mm/protocal/protobuf/dlx:<init>	()V
      //   44: astore_2
      //   45: aload_2
      //   46: aload_1
      //   47: invokevirtual 102	com/tencent/mm/protocal/protobuf/dlx:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   50: pop
      //   51: new 2	com/tencent/mm/plugin/webview/fts/c$g
      //   54: dup
      //   55: invokespecial 103	com/tencent/mm/plugin/webview/fts/c$g:<init>	()V
      //   58: astore_1
      //   59: aload_1
      //   60: aload_2
      //   61: getfield 106	com/tencent/mm/protocal/protobuf/dlx:IJG	I
      //   64: putfield 21	com/tencent/mm/plugin/webview/fts/c$g:scene	I
      //   67: aload_1
      //   68: aload_2
      //   69: getfield 109	com/tencent/mm/protocal/protobuf/dlx:aayd	Ljava/lang/String;
      //   72: putfield 25	com/tencent/mm/plugin/webview/fts/c$g:hMi	Ljava/lang/String;
      //   75: aload_1
      //   76: aload_2
      //   77: getfield 112	com/tencent/mm/protocal/protobuf/dlx:aaRZ	J
      //   80: putfield 27	com/tencent/mm/plugin/webview/fts/c$g:interval	J
      //   83: aload_1
      //   84: aload_2
      //   85: getfield 115	com/tencent/mm/protocal/protobuf/dlx:aaRY	J
      //   88: putfield 29	com/tencent/mm/plugin/webview/fts/c$g:HAe	J
      //   91: aload_1
      //   92: aload_2
      //   93: getfield 118	com/tencent/mm/protocal/protobuf/dlx:aaSa	I
      //   96: putfield 31	com/tencent/mm/plugin/webview/fts/c$g:qzs	I
      //   99: ldc 61
      //   101: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   44	49	2	localdlx	com.tencent.mm.protocal.protobuf.dlx
      //   112	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   37	59	106	java/lang/Exception
      //   59	99	112	java/lang/Exception
    }
    
    static String atw(int paramInt)
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
      if (this.HAe + this.interval <= System.currentTimeMillis() / 1000L)
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
    ad WBc;
    int errCode;
    int errType;
    
    public h(int paramInt1, int paramInt2, ad paramad)
    {
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.WBc = paramad;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */