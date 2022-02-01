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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aay;
import com.tencent.mm.autogen.a.aay.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.protocal.protobuf.fod;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.xweb.WebView.WebViewKind;
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
  public static com.tencent.mm.modelimage.loader.a.c TJj;
  public static com.tencent.mm.modelimage.loader.a.c TJk;
  
  static
  {
    AppMethodBeat.i(125890);
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    locala.oKo = true;
    locala.nrc = true;
    locala.oKB = c.c.default_avatar;
    TJj = locala.bKx();
    locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    locala.oKo = true;
    locala.oKB = c.c.default_avatar;
    TJk = locala.bKx();
    AppMethodBeat.o(125890);
  }
  
  public static final String a(fnt paramfnt)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramfnt.abNF, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramfnt.abNF.size())
    {
      localStringBuffer.append(((fod)paramfnt.abNF.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((fod)paramfnt.abNF.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((fod)paramfnt.abNF.get(i)).timestamp - ((fod)paramfnt.abNF.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramfnt.abNF.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((fod)paramfnt.abNF.get(paramfnt.abNF.size() - 1)).timestamp - ((fod)paramfnt.abNF.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramfnt.abNF.clear();
    localStringBuffer.append("============ TopStory Trace ============");
    paramfnt = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramfnt;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString, com.tencent.mm.plugin.webview.jsapi.p paramp)
  {
    AppMethodBeat.i(271694);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aj.asY(1)) });
    Object localObject2;
    Object localObject1;
    int j;
    if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLS())
    {
      localObject2 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV();
      localObject1 = ((fob)localObject2).msgId;
      as.a((fob)localObject2, 102, 1, 0, 0L, "");
      j = 1;
    }
    for (;;)
    {
      int n = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMf();
      if (n > 0) {
        as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMm()) {
        as.a(((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLZ(), 102, 3, 0, 0L, "");
      }
      if (hMZ())
      {
        hNa();
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      int i = -1;
      if (paramp != null) {}
      for (;;)
      {
        for (;;)
        {
          try
          {
            k = Integer.parseInt((String)paramp.params.get("category"));
            i = k;
          }
          catch (Exception localException)
          {
            String str1;
            String str2;
            String str3;
            Intent localIntent;
            int m;
            continue;
            int k = m;
            continue;
          }
          str1 = String.valueOf(cn.bDw());
          str2 = paramContext.getString(c.g.fts_recommend_search_keyword);
          localObject2 = new fnt();
          ((fnt)localObject2).zIO = hNb();
          ((fnt)localObject2).scene = paramInt;
          ((fnt)localObject2).mpa = "";
          ((fnt)localObject2).hAB = str2;
          if (i <= 0)
          {
            k = 100;
            ((fnt)localObject2).channelId = k;
            ((fnt)localObject2).TJd = ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getFirstLoadWebView();
            str3 = aj.asV(paramInt);
            ((fnt)localObject2).sessionId = str3;
            ((fnt)localObject2).hVn = str3;
            ((fnt)localObject2).tgw = str2;
            ((fnt)localObject2).tBy = 1;
            ((fnt)localObject2).hOG = str1;
            ((fnt)localObject2).GtP = aj.gtA();
            ((fnt)localObject2).abNG = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
            a(((fnt)localObject2).Wol, (String)localObject1, str1, true);
            b((fnt)localObject2, "clickTopStory", cn.bDw());
            localIntent = new Intent();
            ((fnt)localObject2).abNJ = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMo();
            ((fnt)localObject2).abNK = ((String)localObject1);
            localObject1 = new LinkedList();
            if (paramp == null) {
              continue;
            }
          }
          try
          {
            for (;;)
            {
              paramp = paramp.params.get("extReqParam").toString();
              try
              {
                paramp = new JSONArray(paramp);
                k = 0;
                while (k < paramp.length())
                {
                  localObject3 = paramp.optJSONObject(k);
                  if (localObject3 != null)
                  {
                    localObject4 = new aem();
                    ((aem)localObject4).key = ((JSONObject)localObject3).getString("key");
                    ((aem)localObject4).Zmy = ((JSONObject)localObject3).getString("text_value");
                    Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI addreq, kvItem: %s, %s.", new Object[] { ((aem)localObject4).key, ((aem)localObject4).Zmy });
                    ((LinkedList)localObject1).add(localObject4);
                    ((fnt)localObject2).Wol.add(localObject4);
                  }
                  k += 1;
                }
                if (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMn()) {
                  break label1117;
                }
                localObject2 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMc();
                localObject1 = ((fob)localObject2).msgId;
                as.a((fob)localObject2, 102, 1, 0, 0L, "");
                j = 1;
              }
              catch (JSONException paramp)
              {
                Log.e("MicroMsg.TopStory.TopStoryUILogic", Util.stackTraceToString(paramp));
              }
            }
            k = i;
          }
          catch (Exception paramp)
          {
            Object localObject3;
            Object localObject4;
          }
        }
        try
        {
          localObject3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLJ, "{\"tabs\":[{\"wording\":\"在看\",\"wording_cn\":\"在看\",\"wording_en\":\"Wow\",\"wording_hk\":\"在看\",\"wording_tw\":\"在看\",\"category\":700,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":700}\",\"bypass\":\"700\"},{\"wording\":\"热点\",\"wording_cn\":\"热点\",\"wording_en\":\"Top\",\"wording_hk\":\"熱點\",\"wording_tw\":\"熱點\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
          localObject4 = bet((String)localObject3);
          if (((List)localObject4).isEmpty()) {
            continue;
          }
          k = i;
          if (i <= 0) {
            k = hMX();
          }
          m = ((a)((List)localObject4).get(0)).TJo;
          paramp = ((a)((List)localObject4).get(0)).TJq;
          i = 0;
          if (i >= ((List)localObject4).size()) {
            continue;
          }
          if (((a)((List)localObject4).get(i)).TJo != k) {
            continue;
          }
          paramp = ((a)((List)localObject4).get(i)).TJq;
          ((fnt)localObject2).url = g.a(paramInt, str3, str2, str1, ((fnt)localObject2).abNK, paramp, j, n, ((fnt)localObject2).abNJ, paramString);
          localIntent.putExtra("key_tabconfig", (String)localObject3);
          localIntent.putExtra("key_chosetab", k);
          ((fnt)localObject2).channelId = k;
          localIntent.putExtra("key_context", ((fnt)localObject2).toByteArray());
        }
        catch (IOException paramString)
        {
          continue;
        }
        if (paramBundle != null) {
          localIntent.putExtra("key_extra_data", paramBundle);
        }
        localIntent.addFlags(67108864);
        aj.f(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125865);
            ((b)com.tencent.mm.kernel.h.az(b.class)).getWebViewMgr().a(d.this, true, this.TJm);
            AppMethodBeat.o(125865);
          }
        });
        ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWP, Long.valueOf(cn.bDw()));
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).gs(com.tencent.mm.plugin.boots.a.b.vyz, 884);
        AppMethodBeat.o(271694);
        return;
        i += 1;
        continue;
        ((fnt)localObject2).url = g.a(paramInt, str3, str2, str1, ((fnt)localObject2).abNK, "", 0, 0, ((fnt)localObject2).abNJ, paramString);
        localIntent.putExtra("key_tabconfig", "");
        localIntent.putExtra("key_chosetab", 0);
        continue;
        i = -1;
      }
      label1117:
      j = 0;
      localObject1 = "";
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(271688);
    a(paramContext, 54, paramBundle, paramString, null);
    AppMethodBeat.o(271688);
  }
  
  public static void a(Context paramContext, fnt paramfnt)
  {
    AppMethodBeat.i(271700);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("path", "good-look-history");
      ((JSONObject)localObject2).put("subscene", 6);
      ((JSONObject)localObject2).put("tagId", 10802);
      ((JSONObject)localObject2).put("nickname", URLEncoder.encode((String)com.tencent.mm.kernel.h.baE().ban().d(4, null), "UTF-8"));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("scene", "21");
      ((HashMap)localObject1).put("sessionId", paramfnt.sessionId);
      ((HashMap)localObject1).put("extParams", ((JSONObject)localObject2).toString());
      ((HashMap)localObject1).put("extInfo", ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMv());
      ((HashMap)localObject1).put("profile", "1");
    }
    catch (Exception localException)
    {
      try
      {
        ((HashMap)localObject1).put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.Yxf, "utf8"));
        ((HashMap)localObject1).put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
        ((HashMap)localObject1).put("deviceModel", URLEncoder.encode(q.aPo(), "utf8"));
        ((HashMap)localObject1).put("ostype", com.tencent.mm.protocal.d.Yxc);
        localObject2 = new fnt();
        ((fnt)localObject2).zIO = hNb();
        ((fnt)localObject2).scene = 21;
        ((fnt)localObject2).mpa = "";
        ((fnt)localObject2).hAB = "";
        ((fnt)localObject2).sessionId = paramfnt.sessionId;
        ((fnt)localObject2).hVn = paramfnt.hVn;
        ((fnt)localObject2).tBy = 2;
        ((fnt)localObject2).url = g.t((HashMap)localObject1);
        ((fnt)localObject2).tgw = "";
        ((fnt)localObject2).channelId = 10802;
        ((fnt)localObject2).GtP = aj.gtA();
        ((fnt)localObject2).GRg = paramContext.getResources().getColor(c.a.white);
        Object localObject1 = new aem();
        ((aem)localObject1).key = "rec_category";
        ((aem)localObject1).Zmx = paramfnt.channelId;
        ((aem)localObject1).Zmy = String.valueOf(paramfnt.channelId);
        ((fnt)localObject2).Wol.add(localObject1);
        a(paramContext, (fnt)localObject2, "", false);
        AppMethodBeat.o(271700);
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
  
  public static void a(Context paramContext, fnt paramfnt, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramfnt, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, fnt paramfnt, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramfnt.Wol, "", paramString, false);
    b(paramfnt, "clickTopStory", cn.bDw());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramfnt.toByteArray());
      label47:
      aj.f(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)com.tencent.mm.kernel.h.az(b.class)).getWebViewMgr().a(d.this, paramBoolean, null);
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
  
  private static void a(List<aem> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    aem localaem = new aem();
    localaem.key = "redPointMsgId";
    localaem.Zmy = String.valueOf(paramString1);
    paramList.add(localaem);
    paramString1 = new aem();
    paramString1.key = "currentPage";
    paramString1.Zmx = 1L;
    paramList.add(paramString1);
    paramString1 = new aem();
    paramString1.key = "is_prefetch";
    paramString1.Zmx = 0L;
    paramList.add(paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = new aem();
      paramString1.key = "seq";
      paramString1.Zmy = paramString2;
      paramList.add(paramString1);
      paramString1 = new aem();
      paramString1.key = "requestId";
      paramString1.Zmy = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new aem();
    paramString1.key = "recType";
    paramString1.Zmx = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new aem();
      paramString1.key = "direction";
      paramString1.Zmx = 1L;
      paramList.add(paramString1);
      paramString1 = new aem();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.Zmy = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static final String aoN(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = MMApplicationContext.getContext().getString(c.g.top_story_home_tab_haokan);
    if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.md(MMApplicationContext.getContext())) >= a.mg(MMApplicationContext.getContext()))
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
  
  private static void b(fnt paramfnt, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    com.tencent.mm.plugin.topstory.a.h.a(paramfnt, paramString, paramLong);
    if (paramfnt.abNF.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    fod localfod = new fod();
    localfod.name = paramString;
    localfod.timestamp = paramLong;
    paramfnt.abNF.add(localfod);
    AppMethodBeat.o(125884);
  }
  
  public static final String bL(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static void bc(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "", null);
    AppMethodBeat.o(125873);
  }
  
  public static List<a> bet(String paramString)
  {
    AppMethodBeat.i(125876);
    ArrayList localArrayList = new ArrayList();
    a locala;
    label187:
    label214:
    label230:
    boolean bool;
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("tabs");
        i = 0;
        String str;
        if (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          locala = new a();
          locala.TJo = ((JSONObject)localObject).getInt("category");
          str = LocaleUtil.getApplicationLanguage();
          if (str.equals("zh_TW"))
          {
            locala.wording = ((JSONObject)localObject).getString("wording_tw");
            if (!Util.isNullOrNil(locala.wording)) {
              break label230;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label187;
          }
          locala.wording = ((JSONObject)localObject).getString("wording_hk");
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
      locala.wording = ((JSONObject)localObject).getString("wording_cn");
      continue;
      locala.wording = ((JSONObject)localObject).getString("wording_en");
      continue;
      if (((JSONObject)localObject).getInt("showWhenRedDot") != 1) {
        break label582;
      }
      bool = true;
      locala.TJp = bool;
      locala.TJq = ((JSONObject)localObject).getString("tabInfo");
      if (!g.aoJ(locala.TJo)) {
        break;
      }
      if (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLS()) {
        break label587;
      }
      j = 1;
      label297:
      locala.TJr = j;
      locala.TJs = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMf();
      if (locala.TJs > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh();
        if (localObject != null) {
          locala.TJu = ((fob)localObject).msgId;
        }
      }
      if (locala.TJr > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV();
        if (localObject != null) {
          locala.TJt = ((fob)localObject).msgId;
        }
      }
      label412:
      localArrayList.add(locala);
      i += 1;
    }
    if (g.aoK(locala.TJo)) {
      if (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMm()) {
        break label592;
      }
    }
    label582:
    label587:
    label592:
    for (int j = 1;; j = 0)
    {
      locala.TJr = j;
      if (locala.TJr <= 0) {
        break label412;
      }
      locala.TJt = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMo();
      break label412;
      if (!g.aoL(locala.TJo)) {
        break label412;
      }
      if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMn()) {}
      for (j = 1;; j = 0)
      {
        locala.TJr = j;
        if (locala.TJr <= 0) {
          break;
        }
        locala.TJt = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMa();
        break;
      }
      bool = false;
      break;
      j = 0;
      break label297;
    }
  }
  
  public static void beu(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    com.tencent.mm.kernel.h.aZW().a(paramString.getType(), new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(125868);
        com.tencent.mm.kernel.h.aZW().b(d.this.getType(), this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(125868);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.d)paramAnonymousp).hMS().username;
        paramAnonymousp = new Intent();
        paramAnonymousp.putExtra("Contact_User", paramAnonymousString);
        paramAnonymousp.putExtra("Contact_Scene", 3);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousp);
        }
        AppMethodBeat.o(125868);
      }
    });
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  public static void bi(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, extInfo:%s", new Object[] { paramString3 });
    Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, businessType:%s", new Object[] { paramString1 });
    if (com.tencent.mm.pluginsdk.model.app.h.s(paramString2, true, false) == null)
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
      aj.f(MMApplicationContext.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
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
  
  public static final void c(fnt paramfnt, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    com.tencent.mm.plugin.topstory.a.h.a(paramfnt, paramString, paramLong);
    if (paramfnt.abNF.size() > 0)
    {
      fod localfod = new fod();
      localfod.name = paramString;
      localfod.timestamp = paramLong;
      paramfnt.abNF.add(localfod);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int hMX()
  {
    AppMethodBeat.i(271697);
    boolean bool;
    int i;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLK, 0) == 0)
    {
      bool = true;
      if (!bool) {
        break label103;
      }
      i = hMY();
      if (i != 0) {
        break label140;
      }
      i = 110;
    }
    label140:
    for (;;)
    {
      i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().aoH(i);
      Log.i("MicroMsg.TopStory.TopStoryUILogic", "getEnterTabCategory, haokanfirst:%s enterTabCategory:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(271697);
      return i;
      bool = false;
      break;
      label103:
      i = hMY();
      if (i == 0) {
        i = 100;
      }
      for (;;)
      {
        i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().aoH(i);
        break;
      }
    }
  }
  
  public static int hMY()
  {
    AppMethodBeat.i(125875);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acXu, 0);
    if (g.aoJ(i))
    {
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acXv, 1) == 1)
      {
        AppMethodBeat.o(125875);
        return i;
      }
      AppMethodBeat.o(125875);
      return 100;
    }
    AppMethodBeat.o(125875);
    return i;
  }
  
  private static boolean hMZ()
  {
    AppMethodBeat.i(125881);
    aay localaay = new aay();
    localaay.iez.actionType = 1;
    localaay.publish();
    boolean bool = localaay.ieA.ieB;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void hNa()
  {
    AppMethodBeat.i(125882);
    aay localaay = new aay();
    localaay.iez.actionType = 2;
    localaay.publish();
    AppMethodBeat.o(125882);
  }
  
  public static final String hNb()
  {
    AppMethodBeat.i(125883);
    aay localaay = new aay();
    localaay.iez.actionType = 3;
    localaay.publish();
    String str = "";
    if (localaay.ieA.ieC != null) {
      str = localaay.ieA.ieC.zIO;
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
  
  public static void ku(Context paramContext)
  {
    AppMethodBeat.i(125888);
    as.u("", 0, 0, 100);
    aj.f(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class a
  {
    public int TJo = 0;
    public boolean TJp;
    public String TJq = "";
    public int TJr = 0;
    public int TJs = 0;
    public String TJt = "";
    public String TJu = "";
    public TextView TJv;
    public View TJw;
    public View TJx;
    public TabLayout.e dyQ;
    public TextView titleTv;
    public String wording = "";
    public View yao;
    
    public static void a(a parama)
    {
      AppMethodBeat.i(271681);
      if ((parama.TJv != null) && (parama.TJv.getVisibility() == 0))
      {
        if (Util.isNullOrNil(parama.TJv.getText()))
        {
          parama.titleTv.setContentDescription(parama.wording + parama.titleTv.getContext().getResources().getString(c.g.top_story_tab_item_btn_dec));
          AppMethodBeat.o(271681);
          return;
        }
        parama.titleTv.setContentDescription(parama.wording + parama.titleTv.getContext().getString(c.g._accessibility_top_story_tab_item_unread_msg, new Object[] { parama.TJv.getText() }) + parama.titleTv.getContext().getResources().getString(c.g.top_story_tab_item_btn_dec));
        AppMethodBeat.o(271681);
        return;
      }
      if ((parama.TJx != null) && (parama.TJx.getVisibility() == 0))
      {
        TextView localTextView = parama.titleTv;
        StringBuilder localStringBuilder = new StringBuilder().append(parama.wording);
        if (parama.TJx.getVisibility() == 0) {}
        for (String str = parama.TJx.getContext().getString(c.g._accessibility_top_story_tab_item_btn_red_desc_unread);; str = "")
        {
          localTextView.setContentDescription(str + parama.titleTv.getContext().getResources().getString(c.g.top_story_tab_item_btn_dec));
          AppMethodBeat.o(271681);
          return;
        }
      }
      parama.titleTv.setContentDescription(parama.wording + parama.titleTv.getContext().getResources().getString(c.g.top_story_tab_item_btn_dec));
      AppMethodBeat.o(271681);
    }
    
    public final void dq(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.TJs = paramInt;
      this.TJu = paramString;
      if (this.TJs <= 0)
      {
        this.TJv.setText("");
        this.TJv.setVisibility(8);
        if (this.TJr > 0) {
          dr(this.TJr, this.TJt);
        }
      }
      for (;;)
      {
        a(this);
        AppMethodBeat.o(125870);
        return;
        paramString = this.TJs;
        if (this.TJs > 99) {
          paramString = "99+";
        }
        this.TJv.setText(paramString);
        this.TJv.setVisibility(0);
        this.TJx.setVisibility(8);
      }
    }
    
    public final void dr(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.TJr = paramInt;
      this.TJt = paramString;
      if (paramInt > 0) {
        if (this.TJs <= 0)
        {
          this.TJv.setVisibility(8);
          this.TJx.setVisibility(0);
        }
      }
      for (;;)
      {
        a(this);
        AppMethodBeat.o(125871);
        return;
        this.TJx.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */