package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout.f;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.g.a.xx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static com.tencent.mm.av.a.a.c GjU;
  public static com.tencent.mm.av.a.a.c GjV;
  
  static
  {
    AppMethodBeat.i(125890);
    com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
    locala.jbf = true;
    locala.jbe = true;
    locala.iaT = true;
    locala.jbq = 2131231957;
    GjU = locala.bdv();
    locala = new com.tencent.mm.av.a.a.c.a();
    locala.jbf = true;
    locala.jbe = true;
    locala.jbq = 2131231957;
    GjV = locala.bdv();
    AppMethodBeat.o(125890);
  }
  
  public static final String a(eii parameii)
  {
    AppMethodBeat.i(125886);
    Collections.sort(parameii.Nhy, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < parameii.Nhy.size())
    {
      localStringBuffer.append(((eis)parameii.Nhy.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((eis)parameii.Nhy.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((eis)parameii.Nhy.get(i)).timestamp - ((eis)parameii.Nhy.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (parameii.Nhy.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((eis)parameii.Nhy.get(parameii.Nhy.size() - 1)).timestamp - ((eis)parameii.Nhy.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    parameii.Nhy.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.fxR()) {
      ThreadPool.post(new c.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    parameii = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return parameii;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(125874);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.aft(1)) });
    Object localObject;
    String str1;
    int j;
    int n;
    String str3;
    String str4;
    eii localeii;
    String str5;
    boolean bool3;
    boolean bool1;
    Intent localIntent;
    boolean bool2;
    if (((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxl())
    {
      localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
      str1 = ((eiq)localObject).msgId;
      ar.a((eiq)localObject, 102, 1, 0, 0L, "");
      j = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
      if (n > 0) {
        ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxB()) {
        ar.a(((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxr(), 102, 3, 0, 0L, "");
      }
      if (fyg())
      {
        fyh();
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      str3 = String.valueOf(System.currentTimeMillis());
      str4 = paramContext.getString(2131761038);
      localeii = new eii();
      localeii.sGQ = fyi();
      localeii.scene = paramInt;
      localeii.hes = "";
      localeii.dDv = str4;
      localeii.channelId = 100;
      localeii.GjO = ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).getFirstLoadWebView();
      str5 = ai.afq(paramInt);
      localeii.sessionId = str5;
      localeii.dVO = str5;
      localeii.nbg = str4;
      localeii.Nhz = 1;
      localeii.wib = ai.ait();
      localeii.NhA = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(localeii.IDO, str1, str3, true);
      b(localeii, "clickTopStory", System.currentTimeMillis());
      bool3 = true;
      bool1 = true;
      localIntent = new Intent();
      bool2 = bool3;
    }
    for (;;)
    {
      int m;
      int k;
      try
      {
        if (com.tencent.mm.protocal.d.KyO < 654311424)
        {
          bool2 = bool3;
          if (!com.tencent.mm.protocal.d.KyS) {
            break label1028;
          }
        }
        bool2 = bool3;
        localObject = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRL, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        str6 = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
        bool2 = bool3;
        List localList = aTy((String)localObject);
        bool2 = bool3;
        if (localList.isEmpty()) {
          continue;
        }
        bool2 = bool3;
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRM, 0) != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool3;
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          continue;
        }
        bool2 = bool3;
        i = fyf();
        if (i != 0) {
          break label1025;
        }
        i = 110;
        bool2 = bool3;
        i = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().abP(i);
        bool2 = bool3;
        m = ((b)localList.get(0)).category;
        bool2 = bool3;
        String str2 = ((b)localList.get(0)).Gkb;
        k = 0;
        bool2 = bool3;
        if (k >= localList.size()) {
          break label1015;
        }
        bool2 = bool3;
        if (((b)localList.get(k)).category != i) {
          break label1048;
        }
        bool2 = bool3;
        str2 = ((b)localList.get(k)).Gkb;
        bool2 = bool3;
        localeii.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, str2, j, n, str6, paramString);
        bool2 = bool3;
        localIntent.putExtra("key_tabconfig", (String)localObject);
        bool2 = bool3;
        localIntent.putExtra("key_chosetab", i);
        if (i != 110) {
          continue;
        }
        bool1 = false;
      }
      catch (IOException paramString)
      {
        String str6;
        bool1 = bool2;
        continue;
        bool1 = true;
      }
      bool2 = bool1;
      localIntent.putExtra("key_context", localeii.toByteArray());
      if (paramBundle != null) {
        localIntent.putExtra("key_extra_data", paramBundle);
      }
      localIntent.addFlags(67108864);
      ai.e(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
      MMHandlerThread.postToMainThread(new c.1(localeii, bool1));
      ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).setFirstLoadWebView(1);
      g.aAh().azQ().set(ar.a.OgQ, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkr, 884);
      AppMethodBeat.o(125874);
      return;
      bool1 = false;
      continue;
      bool2 = bool3;
      int i = fyf();
      if (i == 0)
      {
        i = 100;
        bool2 = bool3;
        i = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().abP(i);
        continue;
        bool2 = bool3;
        localeii.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str6, paramString);
        bool2 = bool3;
        localIntent.putExtra("key_tabconfig", "");
        bool2 = bool3;
        localIntent.putExtra("key_chosetab", 0);
        continue;
        label1015:
        i = m;
      }
      else
      {
        continue;
        label1025:
        continue;
        label1028:
        localObject = "";
        continue;
        j = 0;
        str1 = "";
        break;
        continue;
        label1048:
        k += 1;
      }
    }
  }
  
  public static void a(Context paramContext, eii parameii)
  {
    AppMethodBeat.i(236380);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)g.aAh().azQ().get(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", parameii.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxG());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.KyK);
        localObject2 = new eii();
        ((eii)localObject2).sGQ = fyi();
        ((eii)localObject2).scene = 21;
        ((eii)localObject2).hes = "";
        ((eii)localObject2).dDv = "";
        ((eii)localObject2).sessionId = parameii.sessionId;
        ((eii)localObject2).dVO = parameii.dVO;
        ((eii)localObject2).Nhz = 2;
        ((eii)localObject2).url = com.tencent.mm.plugin.topstory.a.h.n((HashMap)localObject1);
        ((eii)localObject2).nbg = "";
        ((eii)localObject2).channelId = 10802;
        ((eii)localObject2).wib = ai.ait();
        ((eii)localObject2).wwG = paramContext.getResources().getColor(2131101424);
        Object localObject1 = new aca();
        ((aca)localObject1).key = "rec_category";
        ((aca)localObject1).LmC = parameii.channelId;
        ((aca)localObject1).LmD = String.valueOf(parameii.channelId);
        ((eii)localObject2).IDO.add(localObject1);
        a(paramContext, (eii)localObject2, "", false);
        AppMethodBeat.o(236380);
        return;
        localException = localException;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", localException, "goUserProfiler", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void a(Context paramContext, eii parameii, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, parameii, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, eii parameii, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(parameii.IDO, "", paramString, false);
    b(parameii, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", parameii.toByteArray());
      label47:
      ai.e(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      MMHandlerThread.postToMainThread(new c.2(parameii, paramBoolean));
      AppMethodBeat.o(125878);
      return;
    }
    catch (IOException localIOException)
    {
      break label47;
    }
  }
  
  private static void a(List<aca> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    aca localaca = new aca();
    localaca.key = "redPointMsgId";
    localaca.LmD = String.valueOf(paramString1);
    paramList.add(localaca);
    paramString1 = new aca();
    paramString1.key = "currentPage";
    paramString1.LmC = 1L;
    paramList.add(paramString1);
    paramString1 = new aca();
    paramString1.key = "is_prefetch";
    paramString1.LmC = 0L;
    paramList.add(paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = new aca();
      paramString1.key = "seq";
      paramString1.LmD = paramString2;
      paramList.add(paramString1);
      paramString1 = new aca();
      paramString1.key = "requestId";
      paramString1.LmD = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new aca();
    paramString1.key = "recType";
    paramString1.LmC = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new aca();
      paramString1.key = "direction";
      paramString1.LmC = 1L;
      paramList.add(paramString1);
      paramString1 = new aca();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.LmD = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static List<b> aTy(String paramString)
  {
    AppMethodBeat.i(125876);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject;
    b localb;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("tabs");
        i = 0;
        String str;
        if (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          localb = new b();
          localb.category = ((JSONObject)localObject).getInt("category");
          str = LocaleUtil.getApplicationLanguage();
          if (str.equals("zh_TW"))
          {
            localb.dQx = ((JSONObject)localObject).getString("wording_tw");
            if (!Util.isNullOrNil(localb.dQx)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label188;
          }
          localb.dQx = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label215;
        }
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label188:
      localb.dQx = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label215:
      localb.dQx = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label245:
      localb.Gka = bool;
      localb.Gkb = ((JSONObject)localObject).getString("tabInfo");
      if (localb.category == 110) {
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxl()) {
          break label512;
        }
      }
    }
    label512:
    for (int j = 1;; j = 0)
    {
      localb.Gkc = j;
      localb.Gkd = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
      if (localb.Gkd > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw();
        if (localObject != null) {
          localb.Gkf = ((eiq)localObject).msgId;
        }
      }
      if (localb.Gkc > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
        if (localObject != null) {
          localb.Gke = ((eiq)localObject).msgId;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.category != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxB()) {}
      for (j = 1;; j = 0)
      {
        localb.Gkc = j;
        if (localb.Gkc <= 0) {
          break;
        }
        localb.Gke = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
        break;
      }
      bool = false;
      break label245;
    }
  }
  
  public static void aTz(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    g.azz().a(paramString.getType(), new c.4(paramString));
    g.azz().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  public static void aW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.o(paramString2, true, false) == null)
    {
      n.d(paramString1, "", paramString2, -1, "appinfo error: not found.");
      Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
      AppMethodBeat.o(125872);
      return;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString3);
      Object localObject2 = ((JSONObject)localObject1).getJSONObject("source");
      int i = ((JSONObject)localObject2).optInt("type");
      String str1 = ((JSONObject)localObject2).getString("title");
      String str2 = ((JSONObject)localObject2).optString("description", "");
      String str3 = ((JSONObject)localObject2).getString("thumbUrl");
      localObject1 = ((JSONObject)localObject1).getString("appVersion");
      String str4 = ((JSONObject)localObject2).optString("mediaName", "");
      localObject2 = ((JSONObject)localObject2).optString("mediaHeadUrl", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_TYPE", i);
      localIntent.putExtra("KEY_BIZTYPE", paramString1);
      localIntent.putExtra("KEY_APPID", paramString2);
      localIntent.putExtra("KEY_EXTINFO", paramString3);
      localIntent.putExtra("KEY_TITLE", str1);
      localIntent.putExtra("KEY_DESC", str2);
      localIntent.putExtra("KEY_THUMBURL", str3);
      localIntent.putExtra("KEY_APPVERSION", (String)localObject1);
      localIntent.putExtra("KEY_MEDIANAME", str4);
      localIntent.putExtra("KEY_MEDIAHEADURL", (String)localObject2);
      localIntent.addFlags(268435456).addFlags(32768);
      ai.e(MMApplicationContext.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
      AppMethodBeat.o(125872);
      return;
    }
    catch (JSONException paramString3)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", paramString3, "startTopStoryUploadUI", new Object[0]);
      n.d(paramString1, "", paramString2, -1, "extInfo error: parse failed.");
      AppMethodBeat.o(125872);
    }
  }
  
  public static final String abR(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = MMApplicationContext.getContext().getString(2131766817);
    if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.iX(MMApplicationContext.getContext())) >= a.ja(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) == "zh_CN")) {
      if (paramInt > 9999) {
        str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 10000.0F), MMApplicationContext.getContext().getString(2131766802) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125889);
      return str1;
      if (paramInt > 99999)
      {
        str1 = str2 + String.format(" 10%s+", new Object[] { MMApplicationContext.getContext().getString(2131766802) });
      }
      else
      {
        str1 = str2 + " " + paramInt;
        continue;
        if (paramInt > 99999)
        {
          str1 = str2 + String.format(" 100%s+", new Object[] { MMApplicationContext.getContext().getString(2131766801) });
        }
        else if (paramInt > 999)
        {
          str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 1000.0F), MMApplicationContext.getContext().getString(2131766801) });
        }
        else
        {
          str1 = str2;
          if (paramInt > 0) {
            str1 = str2 + " " + paramInt;
          }
        }
      }
    }
  }
  
  public static void as(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "");
    AppMethodBeat.o(125873);
  }
  
  private static void b(eii parameii, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    i.a(parameii, paramString, paramLong);
    if (parameii.Nhy.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    eis localeis = new eis();
    localeis.name = paramString;
    localeis.timestamp = paramLong;
    parameii.Nhy.add(localeis);
    AppMethodBeat.o(125884);
  }
  
  public static final String bu(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(eii parameii, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    i.a(parameii, paramString, paramLong);
    if (parameii.Nhy.size() > 0)
    {
      eis localeis = new eis();
      localeis.name = paramString;
      localeis.timestamp = paramLong;
      parameii.Nhy.add(localeis);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int fyf()
  {
    AppMethodBeat.i(125875);
    if (g.aAh().azQ().getInt(ar.a.Ohv, 1) == 1)
    {
      int i = g.aAh().azQ().getInt(ar.a.Ohu, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean fyg()
  {
    AppMethodBeat.i(125881);
    xx localxx = new xx();
    localxx.eei.actionType = 1;
    EventCenter.instance.publish(localxx);
    boolean bool = localxx.eej.eek;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void fyh()
  {
    AppMethodBeat.i(125882);
    xx localxx = new xx();
    localxx.eei.actionType = 2;
    EventCenter.instance.publish(localxx);
    AppMethodBeat.o(125882);
  }
  
  public static final String fyi()
  {
    AppMethodBeat.i(125883);
    xx localxx = new xx();
    localxx.eei.actionType = 3;
    EventCenter.instance.publish(localxx);
    String str = "";
    if (localxx.eej.eel != null) {
      str = localxx.eej.eel.sGQ;
    }
    if (Util.isNullOrNil(str))
    {
      str = UUID.randomUUID().toString();
      AppMethodBeat.o(125883);
      return str;
    }
    AppMethodBeat.o(125883);
    return str;
  }
  
  public static void hw(Context paramContext)
  {
    AppMethodBeat.i(125888);
    ar.q("", 0, 0, 100);
    ai.e(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class b
  {
    public boolean Gka;
    public String Gkb = "";
    public int Gkc = 0;
    public int Gkd = 0;
    public String Gke = "";
    public String Gkf = "";
    public TextView Gkg;
    public View Gkh;
    public int category = 0;
    public String dQx = "";
    public TextView titleTv;
    public TabLayout.f vq;
    public View xYN;
    
    public final void cA(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.Gkd = paramInt;
      this.Gkf = paramString;
      if (this.Gkd <= 0)
      {
        this.Gkg.setText("");
        this.Gkg.setVisibility(4);
        if (this.Gkc > 0)
        {
          cB(this.Gkc, this.Gke);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.Gkd;
        if (this.Gkd > 99) {
          paramString = "99+";
        }
        this.Gkg.setText(paramString);
        this.Gkg.setVisibility(0);
        this.Gkh.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void cB(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.Gkc = paramInt;
      this.Gke = paramString;
      if (paramInt > 0)
      {
        if (this.Gkd <= 0)
        {
          this.Gkg.setVisibility(4);
          this.Gkh.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.Gkh.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */