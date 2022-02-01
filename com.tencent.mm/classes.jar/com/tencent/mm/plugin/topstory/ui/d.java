package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.ze;
import com.tencent.mm.f.a.ze.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
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
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static com.tencent.mm.ay.a.a.c MWF;
  public static com.tencent.mm.ay.a.a.c MWG;
  
  static
  {
    AppMethodBeat.i(125890);
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRD = true;
    locala.lRC = true;
    locala.kPz = true;
    locala.lRP = c.c.default_avatar;
    MWF = locala.bmL();
    locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRD = true;
    locala.lRC = true;
    locala.lRP = c.c.default_avatar;
    MWG = locala.bmL();
    AppMethodBeat.o(125890);
  }
  
  public static final String a(esk paramesk)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramesk.Uue, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramesk.Uue.size())
    {
      localStringBuffer.append(((esu)paramesk.Uue.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((esu)paramesk.Uue.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((esu)paramesk.Uue.get(i)).timestamp - ((esu)paramesk.Uue.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramesk.Uue.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((esu)paramesk.Uue.get(paramesk.Uue.size() - 1)).timestamp - ((esu)paramesk.Uue.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramesk.Uue.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.gpM()) {
      ThreadPool.post(new a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    paramesk = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramesk;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString, n paramn)
  {
    AppMethodBeat.i(205188);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.anh(1)) });
    Object localObject1;
    String str1;
    int k;
    int n;
    int i;
    int j;
    if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpg())
    {
      localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj();
      str1 = ((ess)localObject1).msgId;
      ar.a((ess)localObject1, 102, 1, 0, 0L, "");
      k = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpp();
      if (n > 0) {
        ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpw()) {
        ar.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpm(), 102, 3, 0, 0L, "");
      }
      if (gqd())
      {
        gqe();
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      i = -1;
      if (paramn != null)
      {
        try
        {
          j = Integer.parseInt((String)paramn.params.get("category"));
          i = j;
        }
        catch (Exception localException)
        {
          label247:
          String str3;
          String str4;
          label635:
          break label247;
          final boolean bool1 = true;
        }
        str3 = String.valueOf(System.currentTimeMillis());
        str4 = paramContext.getString(c.g.fts_recommend_search_keyword);
        localObject1 = new esk();
        ((esk)localObject1).wmL = gqf();
        ((esk)localObject1).scene = paramInt;
        ((esk)localObject1).jQi = "";
        ((esk)localObject1).fwe = str4;
        if (i <= 0) {
          j = 100;
        }
        for (;;)
        {
          ((esk)localObject1).channelId = j;
          ((esk)localObject1).MWz = ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getFirstLoadWebView();
          String str5 = ai.ane(paramInt);
          ((esk)localObject1).sessionId = str5;
          ((esk)localObject1).fPs = str5;
          ((esk)localObject1).qbv = str4;
          ((esk)localObject1).Uuf = 1;
          ((esk)localObject1).ARR = ai.anV();
          ((esk)localObject1).Uug = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
          a(((esk)localObject1).Pye, str1, str3, true);
          b((esk)localObject1, "clickTopStory", System.currentTimeMillis());
          boolean bool3 = true;
          bool1 = true;
          Intent localIntent = new Intent();
          final String str2 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpx();
          final LinkedList localLinkedList = new LinkedList();
          if (paramn != null) {}
          try
          {
            paramn = paramn.params.get("extReqParam").toString();
            try
            {
              paramn = new JSONArray(paramn);
              j = 0;
              while (j < paramn.length())
              {
                localObject2 = paramn.optJSONObject(j);
                if (localObject2 != null)
                {
                  localObject3 = new aci();
                  ((aci)localObject3).key = ((JSONObject)localObject2).getString("key");
                  ((aci)localObject3).SnW = ((JSONObject)localObject2).getString("text_value");
                  Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI addreq, kvItem: %s, %s.", new Object[] { ((aci)localObject3).key, ((aci)localObject3).SnW });
                  localLinkedList.add(localObject3);
                  ((esk)localObject1).Pye.add(localObject3);
                }
                j += 1;
                continue;
                j = i;
              }
            }
            catch (JSONException paramn)
            {
              Log.e("MicroMsg.TopStory.TopStoryUILogic", Util.stackTraceToString(paramn));
            }
          }
          catch (Exception paramn)
          {
            Object localObject2;
            Object localObject3;
            boolean bool2;
            break label635;
          }
        }
        bool2 = bool3;
      }
    }
    for (;;)
    {
      int m;
      try
      {
        localObject2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyi, "{\"tabs\":[{\"wording\":\"朋友在看\",\"wording_cn\":\"朋友在看\",\"wording_en\":\"Wow\",\"wording_hk\":\"朋友在看\",\"wording_tw\":\"朋友在看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"热点广场\",\"wording_cn\":\"热点广场\",\"wording_en\":\"Top\",\"wording_hk\":\"熱點廣場\",\"wording_tw\":\"熱點廣場\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        localObject3 = beW((String)localObject2);
        bool2 = bool3;
        if (((List)localObject3).isEmpty()) {
          continue;
        }
        j = i;
        if (i <= 0)
        {
          bool2 = bool3;
          j = gqb();
        }
        bool2 = bool3;
        m = ((b)((List)localObject3).get(0)).MWN;
        bool2 = bool3;
        paramn = ((b)((List)localObject3).get(0)).MWP;
        i = 0;
        bool2 = bool3;
        if (i >= ((List)localObject3).size()) {
          break label1104;
        }
        bool2 = bool3;
        if (((b)((List)localObject3).get(i)).MWN != j) {
          continue;
        }
        bool2 = bool3;
        paramn = ((b)((List)localObject3).get(i)).MWP;
        bool2 = bool3;
        ((esk)localObject1).url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, paramn, k, n, str2, paramString);
        bool2 = bool3;
        localIntent.putExtra("key_tabconfig", (String)localObject2);
        bool2 = bool3;
        localIntent.putExtra("key_chosetab", j);
        bool2 = bool3;
        if (!com.tencent.mm.plugin.topstory.a.h.aju(j)) {
          break label1098;
        }
        bool1 = false;
      }
      catch (IOException paramString)
      {
        bool1 = bool2;
        continue;
      }
      bool2 = bool1;
      localIntent.putExtra("key_context", ((esk)localObject1).toByteArray());
      if (paramBundle != null) {
        localIntent.putExtra("key_extra_data", paramBundle);
      }
      localIntent.addFlags(67108864);
      ai.e(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125865);
          ((b)com.tencent.mm.kernel.h.ag(b.class)).getWebViewMgr().a(this.MWH, bool1, str2, localLinkedList);
          AppMethodBeat.o(125865);
        }
      });
      ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).setFirstLoadWebView(1);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvg, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).fA(com.tencent.mm.plugin.boots.a.b.smA, 884);
      AppMethodBeat.o(205188);
      return;
      i += 1;
      continue;
      bool2 = bool3;
      ((esk)localObject1).url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str2, paramString);
      bool2 = bool3;
      localIntent.putExtra("key_tabconfig", "");
      bool2 = bool3;
      localIntent.putExtra("key_chosetab", 0);
      continue;
      label1098:
      label1104:
      j = m;
      continue;
      i = -1;
      break label247;
      k = 0;
      str1 = "";
      break;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(205185);
    a(paramContext, 54, paramBundle, paramString, null);
    AppMethodBeat.o(205185);
  }
  
  public static void a(Context paramContext, esk paramesk)
  {
    AppMethodBeat.i(205191);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.h.aHG().aHp().b(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", paramesk.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpC());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.RAB, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.RAy);
        localObject2 = new esk();
        ((esk)localObject2).wmL = gqf();
        ((esk)localObject2).scene = 21;
        ((esk)localObject2).jQi = "";
        ((esk)localObject2).fwe = "";
        ((esk)localObject2).sessionId = paramesk.sessionId;
        ((esk)localObject2).fPs = paramesk.fPs;
        ((esk)localObject2).Uuf = 2;
        ((esk)localObject2).url = com.tencent.mm.plugin.topstory.a.h.q((HashMap)localObject1);
        ((esk)localObject2).qbv = "";
        ((esk)localObject2).channelId = 10802;
        ((esk)localObject2).ARR = ai.anV();
        ((esk)localObject2).BkW = paramContext.getResources().getColor(c.a.white);
        Object localObject1 = new aci();
        ((aci)localObject1).key = "rec_category";
        ((aci)localObject1).SnV = paramesk.channelId;
        ((aci)localObject1).SnW = String.valueOf(paramesk.channelId);
        ((esk)localObject2).Pye.add(localObject1);
        a(paramContext, (esk)localObject2, "", false);
        AppMethodBeat.o(205191);
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
  
  public static void a(Context paramContext, esk paramesk, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramesk, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, esk paramesk, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramesk.Pye, "", paramString, false);
    b(paramesk, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramesk.toByteArray());
      label47:
      ai.e(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)com.tencent.mm.kernel.h.ag(b.class)).getWebViewMgr().a(this.MWH, paramBoolean, "");
          AppMethodBeat.o(125866);
        }
      });
      AppMethodBeat.o(125878);
      return;
    }
    catch (IOException localIOException)
    {
      break label47;
    }
  }
  
  private static void a(List<aci> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    aci localaci = new aci();
    localaci.key = "redPointMsgId";
    localaci.SnW = String.valueOf(paramString1);
    paramList.add(localaci);
    paramString1 = new aci();
    paramString1.key = "currentPage";
    paramString1.SnV = 1L;
    paramList.add(paramString1);
    paramString1 = new aci();
    paramString1.key = "is_prefetch";
    paramString1.SnV = 0L;
    paramList.add(paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = new aci();
      paramString1.key = "seq";
      paramString1.SnW = paramString2;
      paramList.add(paramString1);
      paramString1 = new aci();
      paramString1.key = "requestId";
      paramString1.SnW = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new aci();
    paramString1.key = "recType";
    paramString1.SnV = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new aci();
      paramString1.key = "direction";
      paramString1.SnV = 1L;
      paramList.add(paramString1);
      paramString1 = new aci();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.SnW = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static void aK(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "", null);
    AppMethodBeat.o(125873);
  }
  
  public static void aQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.o(paramString2, true, false) == null)
    {
      o.d(paramString1, "", paramString2, -1, "appinfo error: not found.");
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
      o.d(paramString1, "", paramString2, -1, "extInfo error: parse failed.");
      AppMethodBeat.o(125872);
    }
  }
  
  public static final String ajw(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = MMApplicationContext.getContext().getString(c.g.top_story_home_tab_haokan);
    if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.kb(MMApplicationContext.getContext())) >= a.ke(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) == "zh_CN")) {
      if (paramInt > 9999) {
        str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 10000.0F), MMApplicationContext.getContext().getString(c.g.top_story_colike_count_unit_w) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125889);
      return str1;
      if (paramInt > 99999)
      {
        str1 = str2 + String.format(" 10%s+", new Object[] { MMApplicationContext.getContext().getString(c.g.top_story_colike_count_unit_w) });
      }
      else
      {
        str1 = str2 + " " + paramInt;
        continue;
        if (paramInt > 99999)
        {
          str1 = str2 + String.format(" 100%s+", new Object[] { MMApplicationContext.getContext().getString(c.g.top_story_colike_count_unit_k) });
        }
        else if (paramInt > 999)
        {
          str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 1000.0F), MMApplicationContext.getContext().getString(c.g.top_story_colike_count_unit_k) });
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
  
  private static void b(esk paramesk, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    com.tencent.mm.plugin.topstory.a.i.a(paramesk, paramString, paramLong);
    if (paramesk.Uue.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    esu localesu = new esu();
    localesu.name = paramString;
    localesu.timestamp = paramLong;
    paramesk.Uue.add(localesu);
    AppMethodBeat.o(125884);
  }
  
  public static List<b> beW(String paramString)
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
          localb.MWN = ((JSONObject)localObject).getInt("category");
          str = LocaleUtil.getApplicationLanguage();
          if (str.equals("zh_TW"))
          {
            localb.wording = ((JSONObject)localObject).getString("wording_tw");
            if (!Util.isNullOrNil(localb.wording)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label187;
          }
          localb.wording = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label214;
        }
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label187:
      localb.wording = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label214:
      localb.wording = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label244:
      localb.MWO = bool;
      localb.MWP = ((JSONObject)localObject).getString("tabInfo");
      if (com.tencent.mm.plugin.topstory.a.h.aju(localb.MWN)) {
        if (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpg()) {
          break label512;
        }
      }
    }
    label512:
    for (int j = 1;; j = 0)
    {
      localb.MWQ = j;
      localb.MWR = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpp();
      if (localb.MWR > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr();
        if (localObject != null) {
          localb.MWT = ((ess)localObject).msgId;
        }
      }
      if (localb.MWQ > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj();
        if (localObject != null) {
          localb.MWS = ((ess)localObject).msgId;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.MWN != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpw()) {}
      for (j = 1;; j = 0)
      {
        localb.MWQ = j;
        if (localb.MWQ <= 0) {
          break;
        }
        localb.MWS = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpx();
        break;
      }
      bool = false;
      break label244;
    }
  }
  
  public static void beX(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    com.tencent.mm.kernel.h.aGY().a(paramString.getType(), new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(125868);
        com.tencent.mm.kernel.h.aGY().b(this.Egj.getType(), this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(125868);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.d)paramAnonymousq).gpW().username;
        paramAnonymousq = new Intent();
        paramAnonymousq.putExtra("Contact_User", paramAnonymousString);
        paramAnonymousq.putExtra("Contact_Scene", 3);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousq);
        }
        AppMethodBeat.o(125868);
      }
    });
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  public static final String bz(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(esk paramesk, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    com.tencent.mm.plugin.topstory.a.i.a(paramesk, paramString, paramLong);
    if (paramesk.Uue.size() > 0)
    {
      esu localesu = new esu();
      localesu.name = paramString;
      localesu.timestamp = paramLong;
      paramesk.Uue.add(localesu);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int gqb()
  {
    AppMethodBeat.i(205190);
    boolean bool;
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyj, 0) == 0)
    {
      bool = true;
      Log.i("MicroMsg.TopStory.TopStoryUILogic", "getEnterTabCategory, haokanfirst:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label96;
      }
      i = gqc();
      if (i != 0) {
        break label133;
      }
      i = 110;
    }
    label133:
    for (;;)
    {
      i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ajt(i);
      AppMethodBeat.o(205190);
      return i;
      bool = false;
      break;
      label96:
      i = gqc();
      if (i == 0) {
        i = 100;
      }
      for (;;)
      {
        i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ajt(i);
        break;
      }
    }
  }
  
  public static int gqc()
  {
    AppMethodBeat.i(125875);
    if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VvL, 1) == 1)
    {
      int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VvK, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean gqd()
  {
    AppMethodBeat.i(125881);
    ze localze = new ze();
    localze.fYx.actionType = 1;
    EventCenter.instance.publish(localze);
    boolean bool = localze.fYy.fYz;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void gqe()
  {
    AppMethodBeat.i(125882);
    ze localze = new ze();
    localze.fYx.actionType = 2;
    EventCenter.instance.publish(localze);
    AppMethodBeat.o(125882);
  }
  
  public static final String gqf()
  {
    AppMethodBeat.i(125883);
    ze localze = new ze();
    localze.fYx.actionType = 3;
    EventCenter.instance.publish(localze);
    String str = "";
    if (localze.fYy.fYA != null) {
      str = localze.fYy.fYA.wmL;
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
  
  public static void iC(Context paramContext)
  {
    AppMethodBeat.i(125888);
    ar.u("", 0, 0, 100);
    ai.e(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  static final class a
    implements Runnable
  {
    String MWM;
    
    public a(String paramString)
    {
      this.MWM = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(125869);
      com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSL() + "topstory/trace.info");
      if ((localq.ifE()) && (localq.length() > 2048L)) {
        localq.cFq();
      }
      if (!localq.ifB().ifE()) {
        localq.ifB().ifL();
      }
      this.MWM = ("Trace:\n" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L) + "\n" + this.MWM);
      u.F(localq.bOF(), this.MWM.getBytes());
      AppMethodBeat.o(125869);
    }
  }
  
  public static final class b
  {
    public View Dds;
    public int MWN = 0;
    public boolean MWO;
    public String MWP = "";
    public int MWQ = 0;
    public int MWR = 0;
    public String MWS = "";
    public String MWT = "";
    public TextView MWU;
    public View MWV;
    public TabLayout.e bFQ;
    public TextView titleTv;
    public String wording = "";
    
    public final void cB(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.MWR = paramInt;
      this.MWT = paramString;
      if (this.MWR <= 0)
      {
        this.MWU.setText("");
        this.MWU.setVisibility(4);
        if (this.MWQ > 0)
        {
          cC(this.MWQ, this.MWS);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.MWR;
        if (this.MWR > 99) {
          paramString = "99+";
        }
        this.MWU.setText(paramString);
        this.MWU.setVisibility(0);
        this.MWV.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void cC(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.MWQ = paramInt;
      this.MWS = paramString;
      if (paramInt > 0)
      {
        if (this.MWR <= 0)
        {
          this.MWU.setVisibility(4);
          this.MWV.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.MWV.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */