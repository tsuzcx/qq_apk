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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.f.b.a.od;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fks;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.an.i
{
  h.a PKf;
  public Set<Integer> PKp;
  public l PKq;
  private HashMap<String, b> PKr;
  public ac PKs;
  private Map<Integer, g> PKt;
  public e PKu;
  public List<com.tencent.mm.bb.f> PKv;
  private com.tencent.mm.plugin.websearch.b.a.c PKw;
  private com.tencent.mm.plugin.websearch.b.a.d PKx;
  private d PKy;
  public IListener ozM;
  private long pZO;
  
  public c()
  {
    AppMethodBeat.i(77898);
    this.PKq = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(77886);
        final c.f localf = (c.f)paramAnonymousk.BFk;
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[] { Integer.valueOf(paramAnonymousk.resultCode), Integer.valueOf(localf.PKO) });
        final JSONObject localJSONObject1;
        JSONArray localJSONArray1;
        JSONArray localJSONArray2;
        if (paramAnonymousk.resultCode == 0)
        {
          localJSONObject1 = new JSONObject();
          try
          {
            localJSONObject1.put("ret", 0);
            localJSONArray1 = new JSONArray();
            localJSONArray2 = new JSONArray();
            paramAnonymousk = paramAnonymousk.BIW.iterator();
            while (paramAnonymousk.hasNext())
            {
              m localm = (m)paramAnonymousk.next();
              if (localm.content != null)
              {
                JSONObject localJSONObject2 = new JSONObject(localm.content);
                localJSONObject2.put("timeStamp", localm.timestamp);
                localJSONArray2.put(localJSONObject2);
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(77885);
                    if (localf.PKO != 0)
                    {
                      Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[] { Integer.valueOf(localf.PKO) });
                      com.tencent.mm.plugin.webview.ui.tools.jsapi.h localh = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(localf.PKO);
                      String str = localJSONObject1.toString();
                      Bundle localBundle = new Bundle();
                      localBundle.putString("data", str);
                      try
                      {
                        if (localh.POP != null)
                        {
                          localh.POP.h(143, localBundle);
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
          catch (Exception paramAnonymousk) {}
        }
        for (;;)
        {
          AppMethodBeat.o(77886);
          return;
          paramAnonymousk = new JSONObject();
          paramAnonymousk.put("items", localJSONArray2);
          localJSONArray1.put(paramAnonymousk);
          localJSONObject1.put("data", localJSONArray1);
        }
      }
    };
    this.PKf = new h.a()
    {
      public final void a(h.b paramAnonymousb)
      {
        AppMethodBeat.i(267328);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "handleCallback %s", new Object[] { paramAnonymousb });
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(267328);
          return;
        }
        int i = ((Integer)paramAnonymousb.PLd).intValue();
        paramAnonymousb = (c.h)paramAnonymousb.PLe;
        if ((paramAnonymousb == null) || (paramAnonymousb.PKQ == null))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd netResult invalid");
          AppMethodBeat.o(267328);
          return;
        }
        if ((paramAnonymousb.errType != 0) || (paramAnonymousb.errCode != 0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramAnonymousb.errType), Integer.valueOf(paramAnonymousb.errCode) });
          paramAnonymousb = paramAnonymousb.PKQ;
          if (paramAnonymousb != null) {
            ah.a(paramAnonymousb.scene, paramAnonymousb.sessionId, "", "", paramAnonymousb.fIY, false, "", paramAnonymousb.getType());
          }
          AppMethodBeat.o(267328);
          return;
        }
        paramAnonymousb = paramAnonymousb.PKQ;
        ah.a(paramAnonymousb.scene, paramAnonymousb.sessionId, "", "", paramAnonymousb.fIY, true, "", paramAnonymousb.getType());
        c.b localb = new c.b();
        localb.scene = paramAnonymousb.scene;
        localb.PKH = paramAnonymousb.Pyy.TCx;
        localb.fGM = paramAnonymousb.Pyy.Tkw;
        localb.PKI = (System.currentTimeMillis() / 1000L);
        localb.uMC = paramAnonymousb.Pyy.Tky;
        localb.type = paramAnonymousb.businessType;
        Object localObject = c.N(localb.scene, localb.type, true);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[] { localb.fGM });
        if (!Util.isNullOrNil(localb.fGM))
        {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).e(0, localb.fGM, 0, paramAnonymousb.fIY);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[] { localb.fGM });
        }
        c.b(c.this).put(localObject, localb);
        if (localb.PKH == 0L)
        {
          i = localb.scene;
          int j = localb.type;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramAnonymousb = com.tencent.mm.plugin.record.c.bbZ();
          localObject = new com.tencent.mm.vfs.q(paramAnonymousb, c.N(i, j, true));
          if (((com.tencent.mm.vfs.q)localObject).ifE()) {
            ((com.tencent.mm.vfs.q)localObject).cFq();
          }
          paramAnonymousb = new com.tencent.mm.vfs.q(paramAnonymousb, c.N(i, j, false));
          if (paramAnonymousb.ifE()) {
            paramAnonymousb.cFq();
          }
        }
        while ((localb.scene == 20) && (localb.type == 0))
        {
          ar.a(localb.scene, 1, localb.uMC, localb.type, 2, localb.gTr(), 1);
          AppMethodBeat.o(267328);
          return;
          localObject = new cuq();
          ((cuq)localObject).scene = localb.scene;
          ((cuq)localObject).Tkw = localb.fGM;
          ((cuq)localObject).TCr = localb.PKH;
          ((cuq)localObject).TCs = localb.PKI;
          ((cuq)localObject).Sas = localb.uMC;
          ((cuq)localObject).rWu = localb.type;
          paramAnonymousb = null;
          try
          {
            localObject = ((cuq)localObject).toByteArray();
            paramAnonymousb = (h.b)localObject;
          }
          catch (IOException localIOException)
          {
            label603:
            break label603;
          }
          if (paramAnonymousb != null)
          {
            localObject = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.record.c.bbZ(), c.N(localb.scene, localb.type, true));
            if (!((com.tencent.mm.vfs.q)localObject).ifB().ifE()) {
              ((com.tencent.mm.vfs.q)localObject).ifB().ifL();
            }
            if (((com.tencent.mm.vfs.q)localObject).ifE()) {
              ((com.tencent.mm.vfs.q)localObject).cFq();
            }
            u.f(((com.tencent.mm.vfs.q)localObject).bOF(), paramAnonymousb, paramAnonymousb.length);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[] { ((com.tencent.mm.vfs.q)localObject).bOF(), Integer.valueOf(paramAnonymousb.length) });
          }
          else
          {
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
          }
        }
        ar.a(localb.scene, 1, localb.uMC, localb.type, 1, "", 0);
        AppMethodBeat.o(267328);
      }
    };
    this.PKt = new HashMap();
    this.PKu = new e();
    this.ozM = new IListener()
    {
      private boolean c(np paramAnonymousnp)
      {
        AppMethodBeat.i(215874);
        com.tencent.mm.bb.f localf = paramAnonymousnp.fMc.fLV;
        int i;
        if (localf == null)
        {
          i = 0;
          Log.d("MicroMsg.WebSearch.FTSWebViewLogic", "musicPlayerListener type:%s webviewId:%s", new Object[] { Integer.valueOf(i), c.d(c.this) });
          if ((localf != null) && (com.tencent.mm.bb.a.e(localf))) {
            switch (paramAnonymousnp.fMc.action)
            {
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(215874);
          return false;
          i = localf.lVr;
          break;
          paramAnonymousnp = c.d(c.this).iterator();
          while (paramAnonymousnp.hasNext()) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((Integer)paramAnonymousnp.next()).intValue()).gY(localf.lVt, 0);
          }
          paramAnonymousnp = c.d(c.this).iterator();
          while (paramAnonymousnp.hasNext()) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((Integer)paramAnonymousnp.next()).intValue()).gY(localf.lVt, 1);
          }
        }
      }
    };
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
    this.PKr = new HashMap();
    this.PKp = Collections.synchronizedSet(new HashSet());
    EventCenter.instance.addListener(this.ozM);
    com.tencent.mm.kernel.h.aGY().a(2975, this);
    AppMethodBeat.o(77898);
  }
  
  private static void D(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(77909);
    TimeLineObject localTimeLineObject = ((o)com.tencent.mm.kernel.h.ae(o.class)).Xk(paramString1);
    paramString1 = new Intent();
    paramString1.putExtra("INTENT_TALKER", paramString2);
    paramString1.putExtra("INTENT_SNSID", new BigInteger(localTimeLineObject.Id).longValue());
    paramString1.putExtra("SNS_FROM_MUSIC_ITEM", paramBoolean);
    try
    {
      paramString1.putExtra("INTENT_SNS_TIMELINEOBJECT", localTimeLineObject.toByteArray());
      label76:
      com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsCommentDetailUI", paramString1);
      AppMethodBeat.o(77909);
      return;
    }
    catch (IOException paramString2)
    {
      break label76;
    }
  }
  
  static String N(int paramInt1, int paramInt2, boolean paramBoolean)
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
    if (new com.tencent.mm.vfs.q(com.tencent.mm.plugin.record.c.bbZ(), str2).ifE())
    {
      AppMethodBeat.o(77916);
      return str2;
    }
    AppMethodBeat.o(77916);
    return str1;
  }
  
  private static void a(com.tencent.mm.plugin.websearch.b.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77919);
    paramd = paramd.lt(paramInt1, paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramInt3).co(paramd);
    AppMethodBeat.o(77919);
  }
  
  private static void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(77911);
    int i;
    if (paramc.PKM != 0) {
      i = paramc.PKM;
    }
    for (;;)
    {
      am.biS(paramc.username);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramc.username);
      localIntent.putExtra("Contact_Nick", paramc.nickname);
      localIntent.putExtra("Contact_BrandIconURL", paramc.GXB);
      localIntent.putExtra("Contact_Signature", paramc.signature);
      localIntent.putExtra("Contact_VUser_Info_Flag", paramc.PKJ);
      localIntent.putExtra("Contact_Scene", i);
      if (paramc.GYV != null) {}
      try
      {
        localIntent.putExtra("Contact_customInfo", paramc.GYV.toByteArray());
        label124:
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", paramc.jQi);
        localBundle.putString("Contact_Ext_Args_Query_String", paramc.query);
        localBundle.putInt("Contact_Scene", i);
        localBundle.putInt("Contact_Ext_Args_Index", paramc.position);
        localBundle.putString("Contact_Ext_Extra_Params", paramc.PKL);
        localIntent.putExtra("preChatTYPE", 10);
        localIntent.putExtra("Contact_Ext_Args", localBundle);
        com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(77911);
        return;
        if (paramc.fPw == 2)
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
          if (paramc.PKK)
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
    localIntent.putExtra("Contact_Alias", paramd.idS);
    localIntent.putExtra("Contact_Sex", paramd.sex);
    localIntent.putExtra("Contact_Scene", paramd.scene);
    localIntent.putExtra("Contact_KHideExpose", true);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramd.country, paramd.province, paramd.city));
    localIntent.putExtra("Contact_Signature", paramd.signature);
    localIntent.putExtra("Contact_KSnsIFlag", paramd.PKN);
    localIntent.putExtra("Contact_full_Mobile_MD5", paramd.query);
    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(77910);
  }
  
  private static void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5)
  {
    AppMethodBeat.i(256570);
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
      com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", localIntent);
      AppMethodBeat.o(256570);
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
    AppMethodBeat.i(256567);
    a(paramString1, paramBundle, paramInt1, paramString2, paramString3, 0, paramString4, paramInt2, paramInt3, paramString5, -1);
    AppMethodBeat.o(256567);
  }
  
  private static String amF(String paramString)
  {
    AppMethodBeat.i(256549);
    try
    {
      String str = com.tencent.mm.compatible.util.q.an(paramString, "utf-8");
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
    AppMethodBeat.o(256549);
    return paramString;
  }
  
  public static boolean bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256604);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", new Object[] { paramMap });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", ai.aa(paramMap, "feedId"));
      localJSONObject.put("extInfo", new JSONObject(ai.aa(paramMap, "extInfo")));
      localJSONObject.put("extraInfo", ai.aa(paramMap, "extraInfo"));
      paramMap = new Intent();
      paramMap.putExtra("tab_type", 8);
      ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(6, 2, 25, paramMap);
      ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), localJSONObject.toString(), paramMap);
      label143:
      AppMethodBeat.o(256604);
      return false;
    }
    catch (Exception paramMap)
    {
      break label143;
    }
  }
  
  public static boolean bB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256605);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getCurrentLocation %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        i = ai.b(paramMap, "webview_instance_id", -1);
        paramMap = ai.czn();
        if (paramMap == null) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("latitude", paramMap.ScP);
        localJSONObject.put("longitude", paramMap.ScO);
        localJSONObject.put("precision", paramMap.Sxt);
        localJSONObject.put("macAddr", paramMap.ScP);
        localJSONObject.put("cellId", paramMap.ScP);
        localJSONObject.put("gpsSource", paramMap.ScP);
        localJSONObject.put("address", paramMap.ScP);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).bmU(localJSONObject.toString());
      }
      catch (Exception paramMap)
      {
        int i;
        continue;
      }
      AppMethodBeat.o(256605);
      return false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).bmU("");
    }
  }
  
  public static boolean bC(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256606);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "navControl %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        int i = ai.b(paramMap, "webview_instance_id", -1);
        String str = ai.aa(paramMap, "action");
        paramMap = ai.aa(paramMap, "leftBarButtonType");
        localh = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i);
        localBundle = new Bundle();
        localBundle.putString("fts_key_data", str);
        localBundle.putString("fts_key_leftBar_button_type", paramMap);
      }
      catch (Exception paramMap)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h localh;
        Bundle localBundle;
        continue;
      }
      try
      {
        if (localh.POP != null) {
          localh.POP.h(154, localBundle);
        }
        AppMethodBeat.o(256606);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "onNavControl exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bD(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256609);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "showNavBarShadow %s", new Object[] { paramMap });
    for (;;)
    {
      try
      {
        int i = ai.b(paramMap, "webview_instance_id", -1);
        localObject = ai.aa(paramMap, "color");
        double d = Double.valueOf(paramMap.get("alpha").toString()).doubleValue();
        paramMap = ((String)localObject).substring(1, ((String)localObject).length());
        int j = (int)(d * 255.0D);
        int k = Integer.parseInt(paramMap, 16);
        paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i);
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
        if (paramMap.POP != null) {
          paramMap.POP.h(155, (Bundle)localObject);
        }
        AppMethodBeat.o(256609);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "showNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256612);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hideNavBarShadow");
    for (;;)
    {
      try
      {
        paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(ai.b(paramMap, "webview_instance_id", -1));
      }
      catch (Throwable paramMap)
      {
        continue;
      }
      try
      {
        if (paramMap.POP != null) {
          paramMap.POP.h(156, new Bundle());
        }
        AppMethodBeat.o(256612);
        return false;
      }
      catch (RemoteException paramMap)
      {
        Log.w("MicroMsg.MsgHandler", "hideNavBarShadow exception" + paramMap.getMessage());
      }
    }
  }
  
  public static boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256533);
    int i = ai.b(paramMap, "showType", 0);
    String str = ai.aa(paramMap, "query");
    if (ai.b(paramMap, "isDeleteAll", 0) == 1) {
      ((n)com.tencent.mm.kernel.h.ag(n.class)).deleteSOSHistory();
    }
    for (;;)
    {
      AppMethodBeat.o(256533);
      return false;
      ((n)com.tencent.mm.kernel.h.ag(n.class)).deleteSOSHistory(str + "​" + i);
    }
  }
  
  public static boolean bo(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256550);
    String str1 = ai.aa(paramMap, "query");
    int i = ai.b(paramMap, "scene", 3);
    int j = ai.b(paramMap, "type", 0);
    if (paramMap.get("thirdExtParam") == null) {}
    for (paramMap = "";; paramMap = paramMap.get("thirdExtParam").toString())
    {
      String str2 = ai.ane(i);
      Map localMap = ai.j(i, true, 0);
      localMap.put("query", str1);
      localMap.put("sessionId", str2);
      localMap.put("thirdExtParam", com.tencent.mm.compatible.util.q.aT(paramMap));
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(MMApplicationContext.getContext(), i, str1, str2, true, localMap, j);
      AppMethodBeat.o(256550);
      return true;
    }
  }
  
  public static boolean bp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256554);
    int i = ai.b(paramMap, "scene", 3);
    long l = cm.bfF();
    paramMap = ai.aa(paramMap, "query");
    String str = com.tencent.mm.plugin.fts.a.d.Sx(i);
    Object localObject = new ag();
    ((ag)localObject).context = MMApplicationContext.getContext();
    ((ag)localObject).scene = i;
    ((ag)localObject).query = paramMap;
    ((ag)localObject).title = paramMap;
    ((ag)localObject).sessionId = str;
    ((ag)localObject).PyA = true;
    ((ag)localObject).PyB = true;
    ((ag)localObject).PyC = true;
    ((ag)localObject).PyD = 1;
    ((ag)localObject).PyE = com.tencent.mm.ci.a.w(MMApplicationContext.getContext(), com.tencent.mm.plugin.webview.c.c.white);
    ((ag)localObject).PyF = true;
    ((ag)localObject).fPy.put("msgSvrId", "0");
    ((ag)localObject).fPy.put("parentSearchID", "");
    ((ag)localObject).fPy.put("fromTagSearch", "1");
    ((ag)localObject).PyL.put("ShareSceneId", "");
    ((ag)localObject).PyL.put("SnsContentType", "0");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.startsWith("#"))) {
      paramMap = paramMap.substring(1);
    }
    for (;;)
    {
      localObject = new od();
      ((od)localObject).giq = 1L;
      ((od)localObject).gqh = l;
      ((od)localObject).haV = 1L;
      paramMap = ((od)localObject).ES(paramMap);
      paramMap.haX = 6L;
      paramMap = paramMap.ET("");
      paramMap.haZ = l;
      paramMap.hba = 0L;
      paramMap.EU(str).bpa();
      ar.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(256554);
      return true;
    }
  }
  
  public static boolean bq(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256562);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[] { paramMap.toString() });
    int i = ai.b(paramMap, "logId", 0);
    paramMap = ai.aa(paramMap, "logString");
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", new Object[] { Integer.valueOf(i), paramMap });
    ar.cN(i, paramMap);
    AppMethodBeat.o(256562);
    return false;
  }
  
  private c bs(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77914);
    c localc = new c((byte)0);
    localc.username = ai.aa(paramMap, "userName");
    localc.nickname = ai.aa(paramMap, "nickName");
    localc.GXB = ai.aa(paramMap, "headHDImgUrl");
    localc.PKJ = ai.b(paramMap, "verifyFlag", 0);
    localc.signature = ai.aa(paramMap, "signature");
    localc.scene = ai.b(paramMap, "scene", 0);
    localc.fPw = ai.b(paramMap, "sceneActionType", 1);
    localc.GYV = new aez();
    localc.GYV.mVM = ai.b(paramMap, "brandFlag", 0);
    localc.GYV.mVP = ai.aa(paramMap, "iconUrl");
    localc.GYV.mVO = ai.aa(paramMap, "brandInfo");
    localc.GYV.mVN = ai.aa(paramMap, "externalInfo");
    localc.jQi = ai.aa(paramMap, "searchId");
    localc.query = ai.aa(paramMap, "query");
    localc.position = ai.b(paramMap, "position", 0);
    localc.PKK = ai.ab(paramMap, "isCurrentDetailPage");
    localc.PKL = ai.aa(paramMap, "extraParams");
    localc.PKM = ai.b(paramMap, "friendScene", 0);
    AppMethodBeat.o(77914);
    return localc;
  }
  
  private d bt(Map<String, Object> paramMap)
  {
    int i = 3;
    AppMethodBeat.i(77915);
    d locald = new d((byte)0);
    locald.username = ai.aa(paramMap, "userName");
    locald.nickname = ai.aa(paramMap, "nickName");
    locald.idS = ai.aa(paramMap, "alias");
    locald.signature = ai.aa(paramMap, "signature");
    locald.sex = ai.b(paramMap, "sex", 0);
    locald.country = ai.aa(paramMap, "country");
    locald.city = ai.aa(paramMap, "city");
    locald.province = ai.aa(paramMap, "province");
    locald.PKN = ai.b(paramMap, "snsFlag", 0);
    String str = ai.aa(paramMap, "query");
    if (!Util.isNullOrNil(str))
    {
      if (Character.isDigit(str.charAt(0))) {
        i = 15;
      }
      locald.scene = i;
      if (locald.scene == 15)
      {
        if (!"mobile".equals(ai.aa(paramMap, "matchType"))) {
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
    boolean bool2 = true;
    AppMethodBeat.i(256588);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openEmotionPage %s", new Object[] { paramMap });
    int i = ai.b(paramMap, "type", 0);
    int j = ai.b(paramMap, "scene", 0);
    String str2 = ai.aa(paramMap, "searchId");
    String str3 = ai.aa(paramMap, "activityId");
    int k = ai.b(paramMap, "fromSearchType", 0);
    String str1 = "";
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("extra_scence", j);
    localIntent.putExtra("extra_type", i);
    localIntent.putExtra("searchID", str2);
    localIntent.putExtra("docID", ai.aa(paramMap, "docID"));
    localIntent.putExtra("activityId", str3);
    localIntent.putExtra("search_type", k);
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
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "emoji", paramMap, localIntent);
        }
        AppMethodBeat.o(256588);
        return false;
        localIntent.putExtra("extra_id", ai.aa(paramMap, "productID"));
        localIntent.putExtra("preceding_scence", 18);
        localIntent.putExtra("download_entrance_scene", 27);
        localIntent.putExtra("searchID", Util.getLong(str2, 0L));
        paramMap = ".ui.EmojiStoreDetailUI";
        continue;
        localIntent.putExtra("extra_emoji_name", ai.aa(paramMap, "express"));
        localIntent.putExtra("extra_md5", ai.aa(paramMap, "md5"));
        localIntent.putExtra("extra_aeskey", ai.aa(paramMap, "aesKey"));
        localIntent.putExtra("extra_encrypt_url", ai.aa(paramMap, "encryptUrl"));
        localIntent.putExtra("extra_thumb_url", ai.aa(paramMap, "thumb"));
        localIntent.putExtra("id", ai.aa(paramMap, "designerId"));
        localIntent.putExtra("extra_product_id", ai.aa(paramMap, "productID"));
        localIntent.putExtra("productUrl", ai.aa(paramMap, "productUrl"));
        localIntent.putExtra("extra_product_name", ai.aa(paramMap, "productName"));
        localIntent.putExtra("weapp_user_name", ai.aa(paramMap, "weappUserName"));
        localIntent.putExtra("weapp_version", ai.b(paramMap, "weappVersion", 0));
        localIntent.putExtra("source_type", ai.b(paramMap, "sourceType", 0));
        paramMap = ".ui.fts.FTSEmojiDetailPageUI";
        continue;
        localIntent.putExtra("extra_emoji_name", ai.aa(paramMap, "express"));
        localIntent.putExtra("extra_md5", ai.aa(paramMap, "md5"));
        localIntent.putExtra("extra_aeskey", ai.aa(paramMap, "aesKey"));
        localIntent.putExtra("extra_encrypt_url", ai.aa(paramMap, "encryptUrl"));
        localIntent.putExtra("extra_thumb_url", ai.aa(paramMap, "thumb"));
        localIntent.putExtra("id", ai.aa(paramMap, "designerId"));
        localIntent.putExtra("name", ai.aa(paramMap, "designerName"));
        localIntent.putExtra("headurl", ai.aa(paramMap, "designerThumb"));
        localIntent.putExtra("weapp_user_name", ai.aa(paramMap, "weappUserName"));
        localIntent.putExtra("weapp_version", ai.b(paramMap, "weappVersion", 0));
        localIntent.putExtra("source_type", ai.b(paramMap, "sourceType", 0));
        paramMap = ".ui.fts.FTSEmojiDetailPageUI";
      }
    }
    localIntent.putExtra("extra_emoji_name", ai.aa(paramMap, "express"));
    localIntent.putExtra("extra_encrypt_url", ai.aa(paramMap, "encryptUrl"));
    localIntent.putExtra("extra_thumb_url", ai.aa(paramMap, "thumb"));
    localIntent.putExtra("extra_article_name", ai.aa(paramMap, "sourceTitle"));
    localIntent.putExtra("extra_article_url", ai.aa(paramMap, "articleSource"));
    if (ai.b(paramMap, "disableAddSticker", 0) > 0)
    {
      bool1 = true;
      label762:
      localIntent.putExtra("disableAddSticker", bool1);
      if (ai.b(paramMap, "needSavePhotosAlbum", 0) <= 0) {
        break label862;
      }
    }
    label862:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("needSavePhotosAlbum", bool1);
      localIntent.putExtra("weapp_user_name", ai.aa(paramMap, "weappUserName"));
      localIntent.putExtra("weapp_version", ai.b(paramMap, "weappVersion", 0));
      localIntent.putExtra("source_type", ai.b(paramMap, "sourceType", 0));
      paramMap = ".ui.fts.FTSEmojiDetailPageUI";
      break;
      bool1 = false;
      break label762;
    }
  }
  
  public static boolean bv(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77917);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", new Object[] { paramMap });
    String str1 = ai.aa(paramMap, "word");
    boolean bool1 = ai.ab(paramMap, "isInputChange");
    String str2 = ai.aa(paramMap, "custom");
    String str3 = ai.aa(paramMap, "tagList");
    boolean bool2 = ai.ab(paramMap, "cache");
    paramMap = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(Util.nullAsInt(paramMap.get("webview_instance_id"), -1));
    Bundle localBundle = new Bundle();
    localBundle.putString("fts_key_new_query", str1);
    localBundle.putString("fts_key_custom_query", str2);
    localBundle.putBoolean("fts_key_need_keyboard", bool1);
    localBundle.putString("fts_key_tag_list", str3);
    localBundle.putBoolean("fts_key_cache", bool2);
    try
    {
      if (paramMap.POP != null) {
        paramMap.POP.h(122, localBundle);
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
  
  public static boolean by(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77921);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doSearchWebQuery %s", new Object[] { paramMap.toString() });
    String str1 = ai.aa(paramMap, "requestId");
    String str2 = ai.aa(paramMap, "commReq");
    int i = ai.b(paramMap, "webview_instance_id", -1);
    com.tencent.mm.kernel.h.aGY().a(new w(str1, str2, i), 0);
    AppMethodBeat.o(77921);
    return false;
  }
  
  public static boolean bz(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256602);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderProfile %s", new Object[] { paramMap });
    String str = ai.aa(paramMap, "userName");
    paramMap = ai.aa(paramMap, "reportExtraInfo");
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", str);
    localIntent.putExtra("key_from_profile_share_scene", 14);
    localIntent.putExtra("key_enter_profile_type", 1);
    localIntent.putExtra("key_extra_info", paramMap);
    ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(6, 2, 32, localIntent);
    ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
    AppMethodBeat.o(256602);
    return false;
  }
  
  public static int d(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    AppMethodBeat.i(77912);
    paramMap1 = ai.aa(paramMap1, "data");
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
      str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)localObject);
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
  
  private static String h(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(77922);
    switch (paramInt)
    {
    default: 
      paramMap = ai.aX(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    case 201: 
      paramMap = com.tencent.mm.plugin.websearch.c.a.aX(paramMap);
      AppMethodBeat.o(77922);
      return paramMap;
    }
    paramMap = ai.g(paramMap, 1);
    AppMethodBeat.o(77922);
    return paramMap;
  }
  
  private static void u(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(77907);
    a(paramString, paramBundle, 0, "", "", "", 0, 0, "");
    AppMethodBeat.o(77907);
  }
  
  public static Bundle w(int paramInt, Bundle paramBundle)
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
      localBundle.putString("data", com.tencent.mm.plugin.webview.modeltools.f.gWq().gTq());
      continue;
      try
      {
        paramBundle = paramBundle.getString("key");
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ak.biP(paramBundle).toString());
        if (!"educationTab".equals(paramBundle)) {
          continue;
        }
        paramBundle = com.tencent.mm.plugin.websearch.api.ak.biP("discoverSearchGuide");
        if (paramBundle.optJSONArray("items").length() <= 0) {
          continue;
        }
        localBundle.putString("result_1", paramBundle.toString());
      }
      catch (Exception paramBundle) {}
      continue;
      paramBundle = ai.j(paramBundle.getInt("scene"), paramBundle.getBoolean("isHomePage"), paramBundle.getInt("type"));
      localBundle.putString("type", (String)paramBundle.get("type"));
      localBundle.putString("isMostSearchBiz", (String)paramBundle.get("isMostSearchBiz"));
      localBundle.putString("isLocalSug", (String)paramBundle.get("isLocalSug"));
      localBundle.putString("isSug", (String)paramBundle.get("isSug"));
      localBundle.putString("scene", (String)paramBundle.get("scene"));
      continue;
      try
      {
        localBundle.putString("result", com.tencent.mm.plugin.websearch.api.ak.biQ(paramBundle.getString("key")));
      }
      catch (Exception paramBundle) {}
    }
  }
  
  /* Error */
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.h paramh)
  {
    // Byte code:
    //   0: ldc_w 1259
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 104
    //   8: ldc_w 1261
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: invokevirtual 660	java/lang/Object:toString	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 523	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_1
    //   26: ldc_w 1263
    //   29: invokeinterface 659 2 0
    //   34: checkcast 484	java/lang/String
    //   37: invokestatic 1266	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   40: istore 6
    //   42: aload_1
    //   43: ldc_w 717
    //   46: iconst_0
    //   47: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   50: istore 7
    //   52: aload_1
    //   53: ldc_w 1268
    //   56: invokeinterface 659 2 0
    //   61: checkcast 484	java/lang/String
    //   64: astore 17
    //   66: aload_1
    //   67: ldc_w 1270
    //   70: invokeinterface 659 2 0
    //   75: checkcast 484	java/lang/String
    //   78: astore 20
    //   80: aload_1
    //   81: ldc_w 1272
    //   84: invokeinterface 659 2 0
    //   89: checkcast 484	java/lang/String
    //   92: astore 16
    //   94: aload_1
    //   95: ldc_w 1274
    //   98: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 18
    //   103: ldc_w 1276
    //   106: aload_1
    //   107: ldc_w 1278
    //   110: invokeinterface 659 2 0
    //   115: checkcast 484	java/lang/String
    //   118: invokevirtual 970	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 14
    //   123: aload_1
    //   124: ldc_w 1243
    //   127: invokeinterface 659 2 0
    //   132: checkcast 484	java/lang/String
    //   135: invokestatic 1266	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   138: istore 8
    //   140: aload_1
    //   141: ldc_w 1252
    //   144: invokeinterface 659 2 0
    //   149: invokestatic 1281	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: astore 19
    //   154: aload_1
    //   155: ldc_w 1283
    //   158: invokeinterface 659 2 0
    //   163: checkcast 484	java/lang/String
    //   166: astore 15
    //   168: aload 15
    //   170: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +271 -> 444
    //   176: new 525	org/json/JSONObject
    //   179: dup
    //   180: aload 15
    //   182: invokespecial 541	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 15
    //   187: aload 15
    //   189: ldc_w 1284
    //   192: invokevirtual 1161	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +1881 -> 2076
    //   198: aload 15
    //   200: ldc_w 1284
    //   203: invokevirtual 1287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 15
    //   208: aload_1
    //   209: ldc_w 1289
    //   212: invokeinterface 659 2 0
    //   217: checkcast 484	java/lang/String
    //   220: astore 21
    //   222: aload 21
    //   224: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   227: ifne +259 -> 486
    //   230: new 525	org/json/JSONObject
    //   233: dup
    //   234: aload 21
    //   236: invokespecial 541	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   239: ldc_w 622
    //   242: ldc_w 1291
    //   245: invokevirtual 1293	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore 21
    //   250: aload 21
    //   252: ldc_w 1295
    //   255: invokevirtual 970	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: istore 13
    //   260: iload 13
    //   262: ifeq +188 -> 450
    //   265: iconst_1
    //   266: istore_3
    //   267: aload_1
    //   268: ldc_w 1297
    //   271: iconst_0
    //   272: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   275: istore 9
    //   277: iconst_0
    //   278: istore 4
    //   280: aload 16
    //   282: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   285: ifne +10 -> 295
    //   288: aload 16
    //   290: invokestatic 1302	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   293: istore 4
    //   295: aload_1
    //   296: ldc_w 1304
    //   299: invokeinterface 659 2 0
    //   304: checkcast 484	java/lang/String
    //   307: astore 21
    //   309: aload_1
    //   310: ldc_w 1306
    //   313: invokeinterface 659 2 0
    //   318: checkcast 484	java/lang/String
    //   321: astore 23
    //   323: aload_1
    //   324: ldc_w 732
    //   327: invokeinterface 659 2 0
    //   332: checkcast 484	java/lang/String
    //   335: astore 16
    //   337: aload_1
    //   338: ldc_w 1308
    //   341: invokeinterface 659 2 0
    //   346: checkcast 484	java/lang/String
    //   349: astore 22
    //   351: aload_1
    //   352: ldc_w 715
    //   355: iconst_0
    //   356: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   359: istore 10
    //   361: aload_1
    //   362: ldc_w 1310
    //   365: iconst_0
    //   366: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   369: istore 11
    //   371: iload 6
    //   373: tableswitch	default:+47 -> 420, 1:+152->525, 2:+447->820, 3:+510->883, 4:+47->420, 5:+1358->1731, 6:+47->420, 7:+510->883, 8:+322->695
    //   421: iconst_1
    //   422: <illegal opcode>
    //   423: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore 15
    //   430: ldc 104
    //   432: aload 15
    //   434: ldc_w 612
    //   437: iconst_0
    //   438: anewarray 4	java/lang/Object
    //   441: invokestatic 1180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: aconst_null
    //   445: astore 15
    //   447: goto -239 -> 208
    //   450: aload 21
    //   452: ldc_w 1312
    //   455: invokevirtual 970	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   458: istore 13
    //   460: iload 13
    //   462: ifeq +1609 -> 2071
    //   465: iconst_2
    //   466: istore_3
    //   467: goto -200 -> 267
    //   470: astore 21
    //   472: ldc 104
    //   474: aload 21
    //   476: ldc_w 612
    //   479: iconst_0
    //   480: anewarray 4	java/lang/Object
    //   483: invokestatic 1180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: iconst_0
    //   487: istore_3
    //   488: goto -221 -> 267
    //   491: astore_1
    //   492: ldc 104
    //   494: new 227	java/lang/StringBuilder
    //   497: dup
    //   498: ldc_w 1314
    //   501: invokespecial 230	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: aload_1
    //   505: invokevirtual 1315	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   508: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 1317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: ldc_w 1259
    //   520: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: iconst_1
    //   524: ireturn
    //   525: iload 7
    //   527: lookupswitch	default:+33->560, 1:+145->672, 8:+96->623, 32:+157->684
    //   561: ldc_w 1319
    //   564: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   567: astore_1
    //   568: ldc 104
    //   570: ldc_w 1321
    //   573: iconst_1
    //   574: anewarray 4	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: aload_1
    //   580: aastore
    //   581: invokestatic 523	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   584: aload_2
    //   585: invokevirtual 1325	com/tencent/mm/plugin/webview/ui/tools/jsapi/h:haY	()Landroid/os/Bundle;
    //   588: astore_2
    //   589: aload_1
    //   590: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   593: ifne -173 -> 420
    //   596: invokestatic 1211	com/tencent/mm/plugin/webview/modeltools/f:gWq	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   599: pop
    //   600: aload_1
    //   601: aload_2
    //   602: iload 4
    //   604: aload 21
    //   606: aload 18
    //   608: aload 22
    //   610: iload 10
    //   612: iload 11
    //   614: ldc_w 612
    //   617: invokestatic 1203	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   620: goto -200 -> 420
    //   623: aload_1
    //   624: ldc_w 1327
    //   627: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   630: pop
    //   631: aload_1
    //   632: ldc_w 1329
    //   635: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   638: astore_2
    //   639: aload_1
    //   640: ldc_w 896
    //   643: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   646: astore 15
    //   648: aload_1
    //   649: ldc_w 1331
    //   652: invokestatic 935	com/tencent/mm/plugin/websearch/api/ai:ab	(Ljava/util/Map;Ljava/lang/String;)Z
    //   655: istore 13
    //   657: invokestatic 1211	com/tencent/mm/plugin/webview/modeltools/f:gWq	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   660: pop
    //   661: aload_2
    //   662: aload 15
    //   664: iload 13
    //   666: invokestatic 1333	com/tencent/mm/plugin/webview/fts/c:D	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   669: goto -249 -> 420
    //   672: aload_0
    //   673: aload_1
    //   674: invokespecial 1335	com/tencent/mm/plugin/webview/fts/c:bs	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$c;
    //   677: iconst_0
    //   678: invokestatic 1337	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$c;Z)V
    //   681: goto -261 -> 420
    //   684: aload_0
    //   685: aload_1
    //   686: invokespecial 1339	com/tencent/mm/plugin/webview/fts/c:bt	(Ljava/util/Map;)Lcom/tencent/mm/plugin/webview/fts/c$d;
    //   689: invokestatic 1341	com/tencent/mm/plugin/webview/fts/c:a	(Lcom/tencent/mm/plugin/webview/fts/c$d;)V
    //   692: goto -272 -> 420
    //   695: aload_1
    //   696: ldc_w 701
    //   699: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   702: astore 15
    //   704: new 525	org/json/JSONObject
    //   707: dup
    //   708: invokespecial 526	org/json/JSONObject:<init>	()V
    //   711: astore 16
    //   713: aload 16
    //   715: ldc_w 1082
    //   718: aload 15
    //   720: invokevirtual 538	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload 16
    //   726: ldc_w 1032
    //   729: invokestatic 1346	java/lang/System:currentTimeMillis	()J
    //   732: invokestatic 1349	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   735: invokevirtual 538	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload 16
    //   741: ldc_w 1351
    //   744: invokestatic 1346	java/lang/System:currentTimeMillis	()J
    //   747: invokestatic 1349	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   750: invokevirtual 538	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   753: pop
    //   754: aload 16
    //   756: ldc_w 700
    //   759: iconst_1
    //   760: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   763: pop
    //   764: aload 16
    //   766: ldc_w 1319
    //   769: aload_1
    //   770: ldc_w 1319
    //   773: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   776: invokevirtual 538	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   779: pop
    //   780: ldc_w 705
    //   783: invokestatic 551	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   786: checkcast 705	com/tencent/mm/plugin/fts/a/n
    //   789: new 227	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   796: aload 15
    //   798: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: ldc_w 1353
    //   804: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: aload 16
    //   812: invokevirtual 556	org/json/JSONObject:toString	()Ljava/lang/String;
    //   815: invokeinterface 1356 3 0
    //   820: aload_1
    //   821: ldc_w 1319
    //   824: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   827: astore_1
    //   828: ldc 104
    //   830: ldc_w 1321
    //   833: iconst_1
    //   834: anewarray 4	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: aload_1
    //   840: aastore
    //   841: invokestatic 523	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   844: aload_2
    //   845: invokevirtual 1325	com/tencent/mm/plugin/webview/ui/tools/jsapi/h:haY	()Landroid/os/Bundle;
    //   848: astore_2
    //   849: aload_1
    //   850: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   853: ifne -433 -> 420
    //   856: invokestatic 1211	com/tencent/mm/plugin/webview/modeltools/f:gWq	()Lcom/tencent/mm/plugin/webview/fts/c;
    //   859: pop
    //   860: aload_1
    //   861: aload_2
    //   862: iload 4
    //   864: aload 21
    //   866: aload 18
    //   868: aload 22
    //   870: iload 10
    //   872: iload 11
    //   874: ldc_w 612
    //   877: invokestatic 1203	com/tencent/mm/plugin/webview/fts/c:a	(Ljava/lang/String;Landroid/os/Bundle;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   880: goto -460 -> 420
    //   883: aload_1
    //   884: ldc_w 701
    //   887: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   890: astore 22
    //   892: aload_1
    //   893: ldc_w 928
    //   896: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   899: astore 24
    //   901: new 166	android/content/Intent
    //   904: dup
    //   905: invokespecial 167	android/content/Intent:<init>	()V
    //   908: astore_2
    //   909: aload_2
    //   910: ldc_w 1358
    //   913: getstatic 1364	com/tencent/mm/protocal/JsapiPermissionWrapper:RBc	Lcom/tencent/mm/protocal/JsapiPermissionWrapper;
    //   916: invokevirtual 1367	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   919: pop
    //   920: aload_2
    //   921: ldc_w 1369
    //   924: getstatic 1375	com/tencent/mm/protocal/GeneralControlWrapper:RAX	Lcom/tencent/mm/protocal/GeneralControlWrapper;
    //   927: invokevirtual 1367	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   930: pop
    //   931: aload_2
    //   932: ldc_w 1377
    //   935: iconst_1
    //   936: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   939: pop
    //   940: aload_2
    //   941: ldc_w 1379
    //   944: iconst_1
    //   945: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   948: pop
    //   949: aload_2
    //   950: ldc_w 1381
    //   953: aload 22
    //   955: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   958: pop
    //   959: aload_2
    //   960: ldc_w 1383
    //   963: iload 7
    //   965: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   968: pop
    //   969: aload_2
    //   970: ldc_w 442
    //   973: iload 4
    //   975: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   978: pop
    //   979: aload_2
    //   980: ldc_w 444
    //   983: aload 21
    //   985: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   988: pop
    //   989: aload_2
    //   990: ldc_w 1385
    //   993: ldc_w 1387
    //   996: aload 20
    //   998: invokevirtual 1390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1001: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1004: pop
    //   1005: aload_2
    //   1006: ldc_w 460
    //   1009: aload 18
    //   1011: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1014: pop
    //   1015: aload_2
    //   1016: ldc_w 1392
    //   1019: iload 10
    //   1021: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1024: pop
    //   1025: aload 15
    //   1027: ifnull +13 -> 1040
    //   1030: aload_2
    //   1031: ldc_w 1284
    //   1034: aload 15
    //   1036: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1039: pop
    //   1040: aload_1
    //   1041: ldc_w 1394
    //   1044: iconst_0
    //   1045: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1048: iconst_1
    //   1049: if_icmpne +272 -> 1321
    //   1052: iconst_1
    //   1053: istore 5
    //   1055: aload_1
    //   1056: ldc_w 1396
    //   1059: iconst_0
    //   1060: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1063: istore 12
    //   1065: iload 9
    //   1067: iconst_1
    //   1068: if_icmpeq +9 -> 1077
    //   1071: iload 9
    //   1073: iconst_2
    //   1074: if_icmpne +22 -> 1096
    //   1077: iload 9
    //   1079: iconst_1
    //   1080: if_icmpne +247 -> 1327
    //   1083: iconst_1
    //   1084: istore 13
    //   1086: aload_2
    //   1087: ldc_w 1398
    //   1090: iload 13
    //   1092: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1095: pop
    //   1096: iload 5
    //   1098: ifeq +241 -> 1339
    //   1101: iload 10
    //   1103: iconst_0
    //   1104: iload 7
    //   1106: aload 17
    //   1108: invokestatic 1401	com/tencent/mm/plugin/websearch/c/a:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1111: astore 15
    //   1113: aload 15
    //   1115: ldc_w 701
    //   1118: aload 22
    //   1120: invokeinterface 730 3 0
    //   1125: pop
    //   1126: aload 15
    //   1128: ldc_w 928
    //   1131: aload 24
    //   1133: invokeinterface 730 3 0
    //   1138: pop
    //   1139: aload 15
    //   1141: ldc_w 1310
    //   1144: iload 11
    //   1146: invokestatic 1403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1149: invokeinterface 730 3 0
    //   1154: pop
    //   1155: aload 15
    //   1157: ldc_w 1394
    //   1160: aload_1
    //   1161: ldc_w 1394
    //   1164: iconst_0
    //   1165: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1168: invokestatic 1403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1171: invokeinterface 730 3 0
    //   1176: pop
    //   1177: invokestatic 1408	com/tencent/mm/modelappbrand/b:bgL	()Ljava/lang/String;
    //   1180: astore_1
    //   1181: aload 15
    //   1183: ldc_w 732
    //   1186: aload_1
    //   1187: invokeinterface 730 3 0
    //   1192: pop
    //   1193: aload 15
    //   1195: ldc_w 732
    //   1198: aload_1
    //   1199: invokeinterface 730 3 0
    //   1204: pop
    //   1205: aload 15
    //   1207: ldc_w 1410
    //   1210: aload_1
    //   1211: invokeinterface 730 3 0
    //   1216: pop
    //   1217: aload_2
    //   1218: ldc_w 1412
    //   1221: aload_1
    //   1222: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1225: pop
    //   1226: aload_2
    //   1227: ldc_w 438
    //   1230: aload 15
    //   1232: invokestatic 1194	com/tencent/mm/plugin/websearch/c/a:aX	(Ljava/util/Map;)Ljava/lang/String;
    //   1235: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1238: pop
    //   1239: aload_2
    //   1240: ldc_w 1392
    //   1243: iload 10
    //   1245: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1248: pop
    //   1249: aload_2
    //   1250: ldc_w 442
    //   1253: iload 4
    //   1255: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1258: pop
    //   1259: aload_2
    //   1260: ldc_w 444
    //   1263: aload 21
    //   1265: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload_2
    //   1270: ldc_w 732
    //   1273: aload_1
    //   1274: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1277: pop
    //   1278: iload 14
    //   1280: ifne +53 -> 1333
    //   1283: iconst_1
    //   1284: istore 13
    //   1286: aload_2
    //   1287: ldc_w 1414
    //   1290: iload 13
    //   1292: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1295: pop
    //   1296: aload_2
    //   1297: ldc_w 1416
    //   1300: iconst_1
    //   1301: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1304: pop
    //   1305: invokestatic 213	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1308: ldc_w 1418
    //   1311: ldc_w 1420
    //   1314: aload_2
    //   1315: invokestatic 222	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1318: goto -898 -> 420
    //   1321: iconst_0
    //   1322: istore 5
    //   1324: goto -269 -> 1055
    //   1327: iconst_0
    //   1328: istore 13
    //   1330: goto -244 -> 1086
    //   1333: iconst_0
    //   1334: istore 13
    //   1336: goto -50 -> 1286
    //   1339: iload 10
    //   1341: iconst_0
    //   1342: iload 7
    //   1344: aload 17
    //   1346: invokestatic 1421	com/tencent/mm/plugin/websearch/api/ai:a	(IZILjava/lang/String;)Ljava/util/Map;
    //   1349: astore_1
    //   1350: aload_1
    //   1351: ldc_w 701
    //   1354: aload 22
    //   1356: invokestatic 1423	com/tencent/mm/plugin/webview/fts/c:amF	(Ljava/lang/String;)Ljava/lang/String;
    //   1359: invokeinterface 730 3 0
    //   1364: pop
    //   1365: aload_1
    //   1366: ldc_w 928
    //   1369: aload 24
    //   1371: invokeinterface 730 3 0
    //   1376: pop
    //   1377: aload_1
    //   1378: ldc_w 1243
    //   1381: iload 8
    //   1383: invokestatic 1403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1386: invokeinterface 730 3 0
    //   1391: pop
    //   1392: aload_1
    //   1393: ldc_w 1252
    //   1396: aload 19
    //   1398: invokeinterface 730 3 0
    //   1403: pop
    //   1404: aload 16
    //   1406: invokestatic 823	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1409: ifne +25 -> 1434
    //   1412: aload_1
    //   1413: ldc_w 732
    //   1416: aload 16
    //   1418: invokeinterface 730 3 0
    //   1423: pop
    //   1424: aload_2
    //   1425: ldc_w 732
    //   1428: aload 16
    //   1430: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1433: pop
    //   1434: iload 10
    //   1436: invokestatic 723	com/tencent/mm/plugin/websearch/api/ai:ane	(I)Ljava/lang/String;
    //   1439: astore 18
    //   1441: aload_1
    //   1442: ldc_w 1410
    //   1445: aload 18
    //   1447: invokeinterface 730 3 0
    //   1452: pop
    //   1453: aload_2
    //   1454: ldc_w 1410
    //   1457: aload 18
    //   1459: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1462: pop
    //   1463: aload_2
    //   1464: ldc_w 438
    //   1467: iload 10
    //   1469: aload_1
    //   1470: invokestatic 1425	com/tencent/mm/plugin/webview/fts/c:h	(ILjava/util/Map;)Ljava/lang/String;
    //   1473: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1476: pop
    //   1477: aload_2
    //   1478: ldc_w 1381
    //   1481: aload 22
    //   1483: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1486: pop
    //   1487: aload_2
    //   1488: ldc_w 442
    //   1491: iload 4
    //   1493: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1496: pop
    //   1497: aload_2
    //   1498: ldc_w 444
    //   1501: aload 21
    //   1503: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1506: pop
    //   1507: aload_2
    //   1508: ldc_w 1427
    //   1511: aload 23
    //   1513: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1516: pop
    //   1517: aload_2
    //   1518: ldc_w 1379
    //   1521: iconst_1
    //   1522: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1525: pop
    //   1526: aload_2
    //   1527: ldc_w 1429
    //   1530: iload_3
    //   1531: invokevirtual 329	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1534: pop
    //   1535: iload 9
    //   1537: ifgt +19 -> 1556
    //   1540: iload 6
    //   1542: bipush 7
    //   1544: if_icmpne +12 -> 1556
    //   1547: aload_2
    //   1548: ldc_w 1398
    //   1551: iconst_1
    //   1552: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1555: pop
    //   1556: iload 12
    //   1558: iconst_1
    //   1559: if_icmpne +39 -> 1598
    //   1562: aload_2
    //   1563: ldc_w 1414
    //   1566: iconst_0
    //   1567: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1570: pop
    //   1571: invokestatic 213	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1574: aload 22
    //   1576: aload_2
    //   1577: aload 15
    //   1579: aload 17
    //   1581: aload 24
    //   1583: aload 16
    //   1585: aload 18
    //   1587: invokestatic 1432	com/tencent/mm/plugin/websearch/api/ai:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1590: ldc_w 1259
    //   1593: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1596: iconst_0
    //   1597: ireturn
    //   1598: iload 10
    //   1600: bipush 20
    //   1602: if_icmpeq +51 -> 1653
    //   1605: iload 10
    //   1607: bipush 22
    //   1609: if_icmpeq +44 -> 1653
    //   1612: iload 10
    //   1614: bipush 33
    //   1616: if_icmpeq +37 -> 1653
    //   1619: iload 10
    //   1621: iconst_3
    //   1622: if_icmpeq +31 -> 1653
    //   1625: iload 10
    //   1627: bipush 34
    //   1629: if_icmpeq +24 -> 1653
    //   1632: iload 10
    //   1634: bipush 65
    //   1636: if_icmpeq +17 -> 1653
    //   1639: iload 10
    //   1641: bipush 36
    //   1643: if_icmpeq +10 -> 1653
    //   1646: iload 10
    //   1648: bipush 67
    //   1650: if_icmpne +56 -> 1706
    //   1653: aload_2
    //   1654: ldc_w 1434
    //   1657: iconst_1
    //   1658: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1661: pop
    //   1662: aload_2
    //   1663: ldc_w 1436
    //   1666: iconst_1
    //   1667: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1670: pop
    //   1671: aload_2
    //   1672: ldc_w 1438
    //   1675: iload 14
    //   1677: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1680: pop
    //   1681: ldc_w 1440
    //   1684: astore_1
    //   1685: aload_1
    //   1686: invokestatic 823	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1689: ifne -1269 -> 420
    //   1692: invokestatic 213	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1695: ldc_w 470
    //   1698: aload_1
    //   1699: aload_2
    //   1700: invokestatic 222	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1703: goto -1283 -> 420
    //   1706: aload_2
    //   1707: ldc_w 1442
    //   1710: iconst_1
    //   1711: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1714: pop
    //   1715: aload_2
    //   1716: ldc_w 1434
    //   1719: iconst_1
    //   1720: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1723: pop
    //   1724: ldc_w 1444
    //   1727: astore_1
    //   1728: goto -43 -> 1685
    //   1731: aload_1
    //   1732: ldc_w 701
    //   1735: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1738: astore_2
    //   1739: aload_1
    //   1740: ldc_w 1446
    //   1743: iconst_0
    //   1744: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1747: istore_3
    //   1748: aload_1
    //   1749: ldc_w 1306
    //   1752: iconst_0
    //   1753: invokestatic 571	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1756: istore 4
    //   1758: aload_1
    //   1759: ldc_w 1448
    //   1762: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1765: astore 18
    //   1767: aload 16
    //   1769: astore_1
    //   1770: aload 16
    //   1772: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1775: ifeq +8 -> 1783
    //   1778: iload_3
    //   1779: invokestatic 723	com/tencent/mm/plugin/websearch/api/ai:ane	(I)Ljava/lang/String;
    //   1782: astore_1
    //   1783: invokestatic 1346	java/lang/System:currentTimeMillis	()J
    //   1786: invokestatic 1349	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1789: astore 16
    //   1791: new 93	java/util/HashMap
    //   1794: dup
    //   1795: invokespecial 94	java/util/HashMap:<init>	()V
    //   1798: astore 19
    //   1800: aload 19
    //   1802: ldc_w 715
    //   1805: ldc_w 1450
    //   1808: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1811: pop
    //   1812: aload 19
    //   1814: ldc_w 701
    //   1817: aload_2
    //   1818: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1821: pop
    //   1822: aload 19
    //   1824: ldc_w 1268
    //   1827: aload 17
    //   1829: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1832: pop
    //   1833: aload 19
    //   1835: ldc_w 732
    //   1838: aload_1
    //   1839: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1842: pop
    //   1843: aload 19
    //   1845: ldc_w 1410
    //   1848: aload_1
    //   1849: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1852: pop
    //   1853: aload 19
    //   1855: ldc_w 1114
    //   1858: aload 16
    //   1860: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1863: pop
    //   1864: aload 19
    //   1866: ldc_w 1453
    //   1869: aload 16
    //   1871: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1874: pop
    //   1875: aload 19
    //   1877: ldc_w 1455
    //   1880: aload 16
    //   1882: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1885: pop
    //   1886: aload 19
    //   1888: ldc_w 1448
    //   1891: aload 18
    //   1893: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1896: pop
    //   1897: aload 19
    //   1899: ldc_w 1457
    //   1902: iload 4
    //   1904: invokestatic 1403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1907: invokevirtual 1451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1910: pop
    //   1911: new 1459	com/tencent/mm/protocal/protobuf/esk
    //   1914: dup
    //   1915: invokespecial 1460	com/tencent/mm/protocal/protobuf/esk:<init>	()V
    //   1918: astore 17
    //   1920: aload 17
    //   1922: invokestatic 1465	com/tencent/mm/plugin/topstory/ui/d:gqf	()Ljava/lang/String;
    //   1925: putfield 1468	com/tencent/mm/protocal/protobuf/esk:wmL	Ljava/lang/String;
    //   1928: aload 17
    //   1930: iload_3
    //   1931: putfield 1469	com/tencent/mm/protocal/protobuf/esk:scene	I
    //   1934: aload 17
    //   1936: ldc_w 612
    //   1939: putfield 1470	com/tencent/mm/protocal/protobuf/esk:jQi	Ljava/lang/String;
    //   1942: aload 17
    //   1944: aload_2
    //   1945: putfield 1473	com/tencent/mm/protocal/protobuf/esk:fwe	Ljava/lang/String;
    //   1948: aload 17
    //   1950: aload_1
    //   1951: putfield 1474	com/tencent/mm/protocal/protobuf/esk:sessionId	Ljava/lang/String;
    //   1954: aload 17
    //   1956: aload_1
    //   1957: putfield 1477	com/tencent/mm/protocal/protobuf/esk:fPs	Ljava/lang/String;
    //   1960: aload 17
    //   1962: iconst_2
    //   1963: putfield 1480	com/tencent/mm/protocal/protobuf/esk:Uuf	I
    //   1966: aload 17
    //   1968: aload 19
    //   1970: invokestatic 1486	com/tencent/mm/plugin/topstory/a/h:q	(Ljava/util/HashMap;)Ljava/lang/String;
    //   1973: putfield 1489	com/tencent/mm/protocal/protobuf/esk:url	Ljava/lang/String;
    //   1976: aload 17
    //   1978: aload 15
    //   1980: putfield 1492	com/tencent/mm/protocal/protobuf/esk:qbv	Ljava/lang/String;
    //   1983: aload 17
    //   1985: iload 4
    //   1987: putfield 1494	com/tencent/mm/protocal/protobuf/esk:channelId	I
    //   1990: aload 17
    //   1992: aload 16
    //   1994: putfield 1497	com/tencent/mm/protocal/protobuf/esk:fIY	Ljava/lang/String;
    //   1997: aload 17
    //   1999: aload 18
    //   2001: putfield 1500	com/tencent/mm/protocal/protobuf/esk:Pym	Ljava/lang/String;
    //   2004: aload 17
    //   2006: invokestatic 1503	com/tencent/mm/plugin/websearch/api/ai:anV	()Ljava/lang/String;
    //   2009: putfield 1506	com/tencent/mm/protocal/protobuf/esk:ARR	Ljava/lang/String;
    //   2012: new 1508	com/tencent/mm/protocal/protobuf/aci
    //   2015: dup
    //   2016: invokespecial 1509	com/tencent/mm/protocal/protobuf/aci:<init>	()V
    //   2019: astore_1
    //   2020: aload_1
    //   2021: ldc_w 1511
    //   2024: putfield 1513	com/tencent/mm/protocal/protobuf/aci:key	Ljava/lang/String;
    //   2027: aload_1
    //   2028: iload 4
    //   2030: i2l
    //   2031: putfield 1516	com/tencent/mm/protocal/protobuf/aci:SnV	J
    //   2034: aload_1
    //   2035: iload 4
    //   2037: invokestatic 1403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2040: putfield 1519	com/tencent/mm/protocal/protobuf/aci:SnW	Ljava/lang/String;
    //   2043: aload 17
    //   2045: getfield 1523	com/tencent/mm/protocal/protobuf/esk:Pye	Ljava/util/LinkedList;
    //   2048: aload_1
    //   2049: invokevirtual 1528	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   2052: pop
    //   2053: invokestatic 213	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2056: aload 17
    //   2058: aload 16
    //   2060: invokestatic 1531	com/tencent/mm/plugin/topstory/ui/d:a	(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/esk;Ljava/lang/String;)V
    //   2063: goto -1643 -> 420
    //   2066: astore 17
    //   2068: goto -1288 -> 780
    //   2071: iconst_0
    //   2072: istore_3
    //   2073: goto -1606 -> 467
    //   2076: aconst_null
    //   2077: astore 15
    //   2079: goto -1871 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2082	0	this	c
    //   0	2082	1	paramMap	Map<String, Object>
    //   0	2082	2	paramh	com.tencent.mm.plugin.webview.ui.tools.jsapi.h
    //   266	1807	3	i	int
    //   278	1758	4	j	int
    //   1053	270	5	k	int
    //   40	1505	6	m	int
    //   50	1293	7	n	int
    //   138	1244	8	i1	int
    //   275	1261	9	i2	int
    //   359	1292	10	i3	int
    //   369	776	11	i4	int
    //   1063	497	12	i5	int
    //   258	1077	13	bool1	boolean
    //   121	1555	14	bool2	boolean
    //   166	41	15	localObject1	Object
    //   428	5	15	localJSONException1	JSONException
    //   445	1633	15	localObject2	Object
    //   92	1967	16	localObject3	Object
    //   64	1993	17	localObject4	Object
    //   2066	1	17	localException	Exception
    //   101	1899	18	str1	String
    //   152	1817	19	localObject5	Object
    //   78	919	20	str2	String
    //   220	231	21	str3	String
    //   470	1032	21	localJSONException2	JSONException
    //   349	1226	22	str4	String
    //   321	1191	23	str5	String
    //   899	683	24	str6	String
    // Exception table:
    //   from	to	target	type
    //   176	208	428	org/json/JSONException
    //   230	260	470	org/json/JSONException
    //   450	460	470	org/json/JSONException
    //   288	295	491	java/lang/IllegalArgumentException
    //   713	780	2066	java/lang/Exception
  }
  
  public final boolean a(Map<String, Object> paramMap, com.tencent.mm.plugin.webview.ui.tools.jsapi.h paramh, String paramString)
  {
    AppMethodBeat.i(77905);
    this.PKu.MWt = true;
    boolean bool1 = ai.ab(paramMap, "isTeachPage");
    boolean bool2 = ai.ab(paramMap, "isMoreButton");
    int k;
    int i;
    label62:
    String str3;
    String str1;
    String str4;
    int n;
    String str2;
    int m;
    int j;
    if (ai.b(paramMap, "isFeedBack", 0) == 1)
    {
      k = 1;
      if (ai.b(paramMap, "isWeAppMore", 0) != 1) {
        break label245;
      }
      i = 1;
      str3 = ai.aa(paramMap, "srcUserName");
      str1 = ai.aa(paramMap, "sessionId");
      str4 = (String)paramMap.get("navBarColor");
      n = ai.b(paramMap, "subType", 0);
      str2 = ai.aa(paramMap, "searchPlaceHolder");
      String str5 = ai.aa(paramMap, "jumpUrl");
      m = -1;
      j = m;
      if (!Util.isNullOrNil(str5)) {
        if (!str5.contains("http://mp.weixin.qq.com/imgretrieval"))
        {
          j = m;
          if (!str5.contains("https://mp.weixin.qq.com/imgretrieval")) {}
        }
        else
        {
          j = 3;
        }
      }
      m = 0;
      if (Util.isNullOrNil(str4)) {}
    }
    for (;;)
    {
      try
      {
        m = Color.parseColor(str4);
        str4 = (String)paramMap.get("statusBarStyle");
        if (k == 0) {
          break label285;
        }
        paramString = ai.aa(paramMap, "jumpUrl");
        paramMap = null;
        if (paramh != null) {
          paramMap = paramh.haY();
        }
        com.tencent.mm.plugin.webview.modeltools.f.gWq();
        u(paramString, paramMap);
        AppMethodBeat.o(77905);
        return false;
      }
      catch (IllegalArgumentException paramMap)
      {
        label245:
        Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + paramMap.getMessage());
        AppMethodBeat.o(77905);
        return true;
      }
      k = 0;
      break;
      i = 0;
      break label62;
      label285:
      k = ai.b(paramMap, "type", 0);
      int i1 = ai.b(paramMap, "opType", 0);
      if (i1 > 0)
      {
        switch (i1)
        {
        default: 
          break;
        case 2: 
          a(bs(paramMap), bool1);
          break;
        case 3: 
          paramMap = bs(paramMap);
          if (!ab.Ql(paramMap.username))
          {
            a(paramMap, bool1);
            continue;
          }
          am.biS(paramMap.username);
          paramh = new Intent();
          paramh.putExtra("Chat_User", paramMap.username);
          paramh.putExtra("finish_direct", true);
          paramh.putExtra("key_temp_session_show_type", 0);
          paramh.putExtra("preChatTYPE", 9);
          com.tencent.mm.by.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", paramh);
          break;
        case 4: 
          paramString = ai.aa(paramMap, "jumpUrl");
          paramMap = null;
          if (paramh != null) {
            paramMap = paramh.haY();
          }
          com.tencent.mm.plugin.webview.modeltools.f.gWq();
          u(paramString, paramMap);
          break;
        }
      }
      else if (bool2)
      {
        str4 = ai.aa(paramMap, "query");
        j = ai.b(paramMap, "scene", 0);
        str3 = ai.aa(paramMap, "searchId");
        paramh = new Intent();
        paramh.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
        paramh.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
        paramh.putExtra("neverGetA8Key", true);
        paramh.putExtra("key_load_js_without_delay", true);
        paramh.putExtra("ftsQuery", str4);
        paramh.putExtra("ftsType", k);
        paramh.putExtra("sessionId", str1);
        if (i != 0)
        {
          paramString = com.tencent.mm.plugin.websearch.c.a.a(j, false, k, paramString);
          try
          {
            paramString.put("query", com.tencent.mm.compatible.util.q.an(str4, "UTF-8"));
            paramString.put("searchId", str3);
            paramString.put("subType", String.valueOf(n));
            paramString.put("isWeAppMore", String.valueOf(ai.b(paramMap, "isWeAppMore", 0)));
            paramString.put("sessionId", str1);
            paramMap = com.tencent.mm.modelappbrand.b.bgL();
            paramString.put("sessionId", paramMap);
            str1 = ai.ane(Util.safeParseInt((String)paramString.get("scene")));
            paramString.put("subSessionId", str1);
            paramh.putExtra("subSessionId", str1);
            paramh.putExtra("key_session_id", paramMap);
            paramh.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.aX(paramString));
            paramh.putExtra("ftsbizscene", j);
            paramh.putExtra("key_search_place_holder", str2);
            com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandSearchUI", paramh);
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
          paramMap = ai.a(j, false, k, paramString);
          try
          {
            paramMap.put("query", com.tencent.mm.compatible.util.q.an(str4, "UTF-8"));
            paramMap.put("searchId", str3);
            paramMap.put("sessionId", str1);
            paramString = ai.ane(Util.safeParseInt((String)paramMap.get("scene")));
            paramMap.put("subSessionId", paramString);
            paramh.putExtra("subSessionId", paramString);
            paramh.putExtra("rawUrl", h(j, paramMap));
            paramh.putExtra("key_session_id", str1);
            paramh.putExtra("searchId", str3);
            if ((j == 20) || (j == 22) || (j == 24) || (j == 33))
            {
              paramMap = ".ui.tools.fts.FTSSOSMoreWebViewUI";
              com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", paramMap, paramh);
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
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[] { Integer.valueOf(k), (String)paramMap.get("url") });
        switch (k)
        {
        default: 
          paramString = ai.aa(paramMap, "jumpUrl");
          str1 = ai.aa(paramMap, "publishId");
          i = ai.b(paramMap, "payScene", 0);
          k = ai.b(paramMap, "scene", 0);
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[] { paramString, str1, Integer.valueOf(i) });
          str2 = ai.aa(paramMap, "cookie");
          paramMap = null;
          if (paramh != null) {
            paramMap = paramh.haY();
          }
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.plugin.webview.modeltools.f.gWq();
            a(paramString, paramMap, m, str4, str1, i, str3, k, n, str2, j);
          }
          break;
        case 8: 
          ai.aa(paramMap, "snsid");
          paramh = ai.aa(paramMap, "objectXmlDesc");
          paramString = ai.aa(paramMap, "userName");
          bool1 = ai.ab(paramMap, "fromMusicItem");
          com.tencent.mm.plugin.webview.modeltools.f.gWq();
          D(paramh, paramString, bool1);
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
  
  public final g anA(int paramInt)
  {
    AppMethodBeat.i(256584);
    if (this.PKt.get(Integer.valueOf(paramInt)) == null)
    {
      localg = g.anB(paramInt);
      if (localg != null) {
        this.PKt.put(Integer.valueOf(paramInt), localg);
      }
    }
    g localg = (g)this.PKt.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(256584);
    return localg;
  }
  
  public final boolean bF(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256613);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    this.PKp.add(Integer.valueOf(i));
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
    com.tencent.mm.plugin.websearch.webview.j.d(localJSONObject, false);
    AppMethodBeat.o(256613);
    return false;
  }
  
  public final boolean bG(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(256614);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    this.PKp.add(Integer.valueOf(i));
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
    com.tencent.mm.plugin.websearch.webview.j.d(localJSONObject, true);
    AppMethodBeat.o(256614);
    return false;
  }
  
  public final boolean bl(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77900);
    switch (ai.b(paramMap, "action", 0))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77900);
      return false;
      if (al.Pzn == null) {
        al.gQR();
      }
      al.Pzn.rVy.clear();
      paramMap = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0);
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = al.bVR();
        localObject2 = Base64.encodeToString(al.Pzn.toByteArray(), 0);
        paramMap.edit().putString((String)localObject1, (String)localObject2).apply();
        Log.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[] { localObject2 });
      }
      catch (IOException paramMap) {}
      continue;
      int i = ai.b(paramMap, "type", 0);
      int j = ai.b(paramMap, "scene", 0);
      if (System.currentTimeMillis() - this.pZO > 1000L)
      {
        this.pZO = System.currentTimeMillis();
        if (!ai.ang(0))
        {
          Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
        }
        else
        {
          ar.M(i, j, com.tencent.mm.plugin.websearch.api.ak.biQ("searchID"));
          paramMap = ai.gQI();
          paramMap.putExtra("ftsneedkeyboard", true);
          paramMap.putExtra("ftsbizscene", j);
          paramMap.putExtra("ftsType", i);
          paramMap.putExtra("rawUrl", ai.aX(ai.j(j, true, i)));
          paramMap.putExtra("key_load_js_without_delay", true);
          paramMap.putExtra("key_change_search_icon", true);
          paramMap.putExtra("key_search_icon_and_hint_fix_default", true);
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramMap);
          continue;
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(ai.b(paramMap, "webview_instance_id", -1));
          i = ai.b(paramMap, "scene", 0);
          paramMap = ai.aa(paramMap, "query");
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
              if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP != null) {
                ((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP.h(136, (Bundle)localObject2);
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
  
  public final boolean bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77902);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", new Object[] { paramMap });
    final int i = ai.b(paramMap, "scene", 0);
    final int k = ai.b(paramMap, "type", 0);
    int m = ai.b(paramMap, "requestType", 0);
    final int j = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    final String str = (String)paramMap.get("requestId");
    Object localObject1 = (String)paramMap.get("guideInfo");
    Object localObject2 = (String)paramMap.get("sessionId");
    boolean bool = ai.ab(paramMap, "ignoreCache");
    if (m == 0)
    {
      paramMap = lu(i, k);
      if ((paramMap.isAvailable()) && (!bool))
      {
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramMap.scene), Long.valueOf(paramMap.PKH), Long.valueOf(paramMap.PKI), Integer.valueOf(paramMap.type), paramMap.fGM });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(j).e(m, paramMap.fGM, 1, str);
        if ((paramMap.scene == 20) && (paramMap.type == 0)) {
          ar.a(paramMap.scene, 0, paramMap.uMC, paramMap.type, 2, paramMap.gTr(), 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77902);
        return false;
        ar.a(paramMap.scene, 0, paramMap.uMC, paramMap.type, 1, "", 0);
        continue;
        com.tencent.mm.plugin.webview.modeltools.f.gWr().PLD.a(2, str, Integer.valueOf(j), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(265703);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData realTime, webviewID = %d", new Object[] { Integer.valueOf(j) });
            com.tencent.mm.kernel.h.aGY().a(1048, c.this);
            String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            long l = com.tencent.mm.plugin.websearch.api.ak.biP("discoverSearchEntry").optLong("guideParam");
            c.a(c.this, new ac(i, k, ai.anh(0), j, str, l, str, this.oiy, this.PKE));
            com.tencent.mm.kernel.h.aGY().a(c.a(c.this), 0);
            AppMethodBeat.o(265703);
          }
        }, this.PKf);
      }
    }
    paramMap = am.gQT();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        i = paramMap.rVy.size() - 1;
        if (i >= 0)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject3 = (czx)paramMap.rVy.get(i);
          if (!ab.Ql(((czx)localObject3).Username)) {
            break label610;
          }
          localObject3 = com.tencent.mm.ao.g.gu(((czx)localObject3).Username);
          if (localObject3 == null) {
            break label610;
          }
          localJSONObject2.put("avatarUrl", ((com.tencent.mm.api.c)localObject3).field_brandIconURL);
          localJSONObject2.put("userName", ((com.tencent.mm.api.c)localObject3).field_username);
          localJSONObject2.put("nickName", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(((com.tencent.mm.api.c)localObject3).field_username));
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(j).e(1, paramMap, 1, str);
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
  
  public final boolean bn(Map<String, Object> paramMap)
  {
    boolean bool = true;
    AppMethodBeat.i(77903);
    int j = ai.b(paramMap, "scene", 201);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    Object localObject = anA(j);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h localh;
    String str;
    if (localObject != null)
    {
      localh = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i);
      str = ((g)localObject).fGM;
      if (!((g)localObject).isExpired()) {
        break label152;
      }
    }
    label152:
    for (i = 1;; i = 0)
    {
      localh.v(str, 1, i, ((g)localObject).PKP);
      bool = ((g)localObject).isExpired();
      if (bool)
      {
        com.tencent.mm.kernel.h.aGY().a(1866, this);
        localObject = new e(paramMap, j, 0);
        if (paramMap != null) {
          ((e)localObject).fPp = ai.b(paramMap, "webview_instance_id", -1);
        }
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      }
      AppMethodBeat.o(77903);
      return false;
    }
  }
  
  public final boolean br(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77906);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[] { paramMap.toString() });
    dxu localdxu = new dxu();
    localdxu.Udk = ai.aa(paramMap, "logString");
    com.tencent.mm.kernel.h.aGY().a(1134, this);
    paramMap = new ad(localdxu);
    com.tencent.mm.kernel.h.aGY().a(paramMap, 0);
    AppMethodBeat.o(77906);
    return false;
  }
  
  public final boolean bw(Map<String, Object> paramMap)
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
      if (this.PKx.equals(paramMap)) {
        break label243;
      }
    }
    catch (JSONException paramMap)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", paramMap, "", new Object[0]);
      if (this.PKw == null) {
        this.PKw = new com.tencent.mm.plugin.websearch.b.a.b();
      }
      paramMap = new com.tencent.mm.plugin.websearch.b.a.d(str, (List)localObject);
      if (this.PKx == null) {}
    }
    this.PKx = paramMap;
    this.PKw.a(paramMap, new com.tencent.mm.plugin.websearch.b.a.c.a()
    {
      public final void gRt()
      {
        AppMethodBeat.i(249243);
        c.b(c.e(c.this), j, k, m);
        AppMethodBeat.o(249243);
      }
    });
    for (;;)
    {
      AppMethodBeat.o(77918);
      return false;
      label243:
      if (this.PKx.fwi) {
        a(this.PKx, j, k, m);
      }
    }
  }
  
  public final boolean bx(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77920);
    String str1 = ai.aa(paramMap, "md5");
    int i = ai.b(paramMap, "offset", 0);
    String str2 = ai.aa(paramMap, "searchId");
    String str3 = ai.aa(paramMap, "sessionId");
    int j = ai.b(paramMap, "tab", 0);
    String str4 = ai.aa(paramMap, "requestId");
    int k = ai.b(paramMap, "scene", 0);
    int m = ai.b(paramMap, "webview_instance_id", -1);
    String str5 = ai.aa(paramMap, "emojiUrl");
    paramMap = ai.aa(paramMap, "aesKey");
    if (this.PKy != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.PKy);
      com.tencent.mm.kernel.h.aGY().b(2999, this);
    }
    com.tencent.mm.kernel.h.aGY().a(2999, this);
    this.PKy = new d(str1, i, str2, str3, j, str4, k, str5, paramMap);
    this.PKy.fPp = m;
    com.tencent.mm.kernel.h.aGY().a(this.PKy, 0);
    AppMethodBeat.o(77920);
    return false;
  }
  
  public final String gTq()
  {
    AppMethodBeat.i(77901);
    Object localObject = N(20, 0, true);
    if (this.PKr.get(localObject) == null)
    {
      b localb = new b();
      localb.lv(20, 0);
      this.PKr.put(localObject, localb);
    }
    localObject = (b)this.PKr.get(localObject);
    if (((b)localObject).isAvailable()) {}
    for (localObject = ((b)localObject).fGM; Util.isNullOrNil((String)localObject); localObject = "")
    {
      AppMethodBeat.o(77901);
      return "";
    }
    AppMethodBeat.o(77901);
    return localObject;
  }
  
  public final b lu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256543);
    Object localObject = N(paramInt1, paramInt2, true);
    if (this.PKr.get(localObject) == null)
    {
      b localb = new b();
      localb.lv(paramInt1, paramInt2);
      this.PKr.put(localObject, localb);
    }
    localObject = (b)this.PKr.get(localObject);
    AppMethodBeat.o(256543);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(77913);
    if ((paramq instanceof ac))
    {
      com.tencent.mm.kernel.h.aGY().b(1048, this);
      paramString = new h(paramInt1, paramInt2, (ac)paramq);
      com.tencent.mm.plugin.webview.modeltools.f.gWr().PLD.a(2, ((ac)paramq).fIY, paramString, this.PKf);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramq instanceof ad))
    {
      com.tencent.mm.kernel.h.aGY().b(1134, this);
      AppMethodBeat.o(77913);
      return;
    }
    if ((paramq instanceof e))
    {
      com.tencent.mm.kernel.h.aGY().b(1866, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(77913);
        return;
      }
      paramString = (e)paramq;
      if (paramString.fPp != -1) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramString.fPp).v(((fij)d.c.b(paramString.rr.lBS)).fGM, 0, 0, 0);
      }
      if (paramString.PKS != null) {
        this.PKt.put(Integer.valueOf(paramString.PKS.scene), paramString.PKS);
      }
      AppMethodBeat.o(77913);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof d))
    {
      com.tencent.mm.kernel.h.aGY().b(2999, this);
      localObject1 = (d)paramq;
      paramq = Util.nullAs(((d)localObject1).PKR.Tkw, "");
      if (((d)localObject1).fPp != -1)
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((d)localObject1).fPp);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("fts_key_json_data", paramq);
        ((Bundle)localObject2).putString("fts_key_err_msg", paramString);
        ((Bundle)localObject2).putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP.h(152, (Bundle)localObject2);
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
      paramq = Util.nullAs(((w)localObject2).gpT().UJk, "");
      if (((w)localObject2).fPp != -1)
      {
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((w)localObject2).fPp);
        localObject2 = ((w)localObject2).fIY;
        Bundle localBundle = new Bundle();
        localBundle.putString("fts_key_id", (String)localObject2);
        localBundle.putString("fts_key_json_data", paramq);
        localBundle.putString("fts_key_err_msg", paramString);
        localBundle.putInt("fts_key_ret_code", paramInt2);
        try
        {
          if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.h)localObject1).POP.h(153, localBundle);
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
    public boolean PKG;
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
          Object localObject = ((o)com.tencent.mm.kernel.h.ae(o.class)).Xk(localJSONArray.getString(i));
          com.tencent.mm.kernel.h.aHH();
          localObject = com.tencent.mm.bb.i.a(com.tencent.mm.kernel.h.aHG().kcB, (TimeLineObject)localObject, 9, null);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
        if (!this.PKG) {
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
    long PKH;
    long PKI;
    String fGM;
    boolean jVk = false;
    private String paZ = null;
    int scene;
    int type;
    String uMC;
    
    final String gTr()
    {
      AppMethodBeat.i(77892);
      if (this.paZ == null) {
        this.paZ = "";
      }
      try
      {
        localObject = new JSONObject(this.fGM).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
          i += 1;
        }
        this.paZ = TextUtils.join("|", localArrayList);
      }
      catch (Exception localException)
      {
        Object localObject;
        label98:
        break label98;
      }
      localObject = this.paZ;
      AppMethodBeat.o(77892);
      return localObject;
    }
    
    final boolean isAvailable()
    {
      AppMethodBeat.i(77891);
      if (this.jVk)
      {
        AppMethodBeat.o(77891);
        return false;
      }
      if ((Util.isNullOrNil(this.fGM)) || (System.currentTimeMillis() / 1000L - this.PKI > this.PKH))
      {
        AppMethodBeat.o(77891);
        return false;
      }
      AppMethodBeat.o(77891);
      return true;
    }
    
    final void lv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77893);
      cuq localcuq = new cuq();
      Object localObject1 = com.tencent.mm.plugin.record.c.bbZ();
      Object localObject2 = c.N(paramInt1, paramInt2, false);
      if (!((String)localObject2).equals(c.N(paramInt1, paramInt2, true))) {
        this.jVk = true;
      }
      localObject1 = new com.tencent.mm.vfs.q((String)localObject1, (String)localObject2);
      localObject2 = u.aY(((com.tencent.mm.vfs.q)localObject1).bOF(), 0, (int)((com.tencent.mm.vfs.q)localObject1).length());
      if (localObject2 != null) {
        try
        {
          localcuq.parseFrom((byte[])localObject2);
          this.scene = localcuq.scene;
          this.fGM = localcuq.Tkw;
          this.PKH = localcuq.TCr;
          this.PKI = localcuq.TCs;
          this.uMC = localcuq.Sas;
          this.type = localcuq.rWu;
          Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { ((com.tencent.mm.vfs.q)localObject1).bOF(), Integer.valueOf(localObject2.length) });
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
    public String GXB;
    public aez GYV;
    public int PKJ;
    public boolean PKK;
    public String PKL;
    public int PKM;
    public int fPw;
    public String jQi;
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
    public int PKN;
    public String city;
    public String country;
    public String idS;
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
    public boolean MWt;
    public boolean fwi;
    public boolean iUF = true;
    public String query;
    public int scene;
    public int uMD;
    
    public e() {}
    
    public final void x(int paramInt1, String paramString, int paramInt2)
    {
      this.query = paramString;
      this.scene = paramInt1;
      this.fwi = false;
      this.uMD = paramInt2;
      this.MWt = false;
      this.iUF = false;
    }
  }
  
  public final class f
    extends com.tencent.mm.plugin.fts.a.a.j
  {
    public int PKO;
    
    private f() {}
  }
  
  static final class g
  {
    public long PKI;
    public int PKP;
    public String fGM;
    public long interval;
    public int scene;
    
    public g()
    {
      this.scene = 0;
      this.fGM = "";
      this.interval = 0L;
      this.PKI = 0L;
      this.PKP = 0;
    }
    
    public g(int paramInt1, fij paramfij, int paramInt2)
    {
      AppMethodBeat.i(247842);
      this.scene = 0;
      this.fGM = "";
      this.interval = 0L;
      this.PKI = 0L;
      this.PKP = 0;
      this.scene = paramInt1;
      this.fGM = paramfij.fGM;
      this.interval = paramfij.interval;
      this.PKI = (System.currentTimeMillis() / 1000L);
      this.PKP = paramInt2;
      AppMethodBeat.o(247842);
    }
    
    /* Error */
    public static g anB(int paramInt)
    {
      // Byte code:
      //   0: ldc 61
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 63	com/tencent/mm/vfs/q
      //   8: dup
      //   9: invokestatic 69	com/tencent/mm/plugin/record/c:bbZ	()Ljava/lang/String;
      //   12: iload_0
      //   13: invokestatic 73	com/tencent/mm/plugin/webview/fts/c$g:anC	(I)Ljava/lang/String;
      //   16: invokespecial 76	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: astore_1
      //   20: aload_1
      //   21: invokevirtual 79	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   24: iconst_0
      //   25: aload_1
      //   26: invokevirtual 82	com/tencent/mm/vfs/q:length	()J
      //   29: l2i
      //   30: invokestatic 88	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
      //   33: astore_1
      //   34: new 90	com/tencent/mm/protocal/protobuf/cur
      //   37: dup
      //   38: invokespecial 91	com/tencent/mm/protocal/protobuf/cur:<init>	()V
      //   41: astore_2
      //   42: aload_2
      //   43: aload_1
      //   44: invokevirtual 95	com/tencent/mm/protocal/protobuf/cur:parseFrom	([B)Lcom/tencent/mm/cd/a;
      //   47: pop
      //   48: new 2	com/tencent/mm/plugin/webview/fts/c$g
      //   51: dup
      //   52: invokespecial 96	com/tencent/mm/plugin/webview/fts/c$g:<init>	()V
      //   55: astore_1
      //   56: aload_1
      //   57: aload_2
      //   58: getfield 99	com/tencent/mm/protocal/protobuf/cur:CPw	I
      //   61: putfield 21	com/tencent/mm/plugin/webview/fts/c$g:scene	I
      //   64: aload_1
      //   65: aload_2
      //   66: getfield 102	com/tencent/mm/protocal/protobuf/cur:Tkw	Ljava/lang/String;
      //   69: putfield 25	com/tencent/mm/plugin/webview/fts/c$g:fGM	Ljava/lang/String;
      //   72: aload_1
      //   73: aload_2
      //   74: getfield 105	com/tencent/mm/protocal/protobuf/cur:TCt	J
      //   77: putfield 27	com/tencent/mm/plugin/webview/fts/c$g:interval	J
      //   80: aload_1
      //   81: aload_2
      //   82: getfield 108	com/tencent/mm/protocal/protobuf/cur:TCs	J
      //   85: putfield 29	com/tencent/mm/plugin/webview/fts/c$g:PKI	J
      //   88: aload_1
      //   89: aload_2
      //   90: getfield 111	com/tencent/mm/protocal/protobuf/cur:TCu	I
      //   93: putfield 31	com/tencent/mm/plugin/webview/fts/c$g:PKP	I
      //   96: ldc 61
      //   98: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   101: aload_1
      //   102: areturn
      //   103: astore_1
      //   104: aconst_null
      //   105: astore_1
      //   106: goto -10 -> 96
      //   109: astore_2
      //   110: goto -14 -> 96
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	paramInt	int
      //   19	83	1	localObject1	Object
      //   103	1	1	localException1	Exception
      //   105	1	1	localObject2	Object
      //   41	49	2	localcur	com.tencent.mm.protocal.protobuf.cur
      //   109	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   34	56	103	java/lang/Exception
      //   56	96	109	java/lang/Exception
    }
    
    static String anC(int paramInt)
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
      if (this.PKI + this.interval <= System.currentTimeMillis() / 1000L)
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
    ac PKQ;
    int errCode;
    int errType;
    
    public h(int paramInt1, int paramInt2, ac paramac)
    {
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.PKQ = paramac;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */