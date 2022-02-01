package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout.f;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static com.tencent.mm.av.a.a.c BJp;
  public static com.tencent.mm.av.a.a.c BJq;
  
  static
  {
    AppMethodBeat.i(125890);
    c.a locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    locala.hhW = true;
    locala.igv = 2131231875;
    BJp = locala.aJu();
    locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    locala.igv = 2131231875;
    BJq = locala.aJu();
    AppMethodBeat.o(125890);
  }
  
  public static final String TB(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = ak.getContext().getString(2131764473);
    if (ak.getContext().getSharedPreferences(ak.fow(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.ie(ak.getContext())) >= com.tencent.mm.cb.a.ih(ak.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext()) == "zh_CN")) {
      if (paramInt > 9999) {
        str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 10000.0F), ak.getContext().getString(2131764458) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125889);
      return str1;
      if (paramInt > 99999)
      {
        str1 = str2 + String.format(" 10%s+", new Object[] { ak.getContext().getString(2131764458) });
      }
      else
      {
        str1 = str2 + " " + paramInt;
        continue;
        if (paramInt > 99999)
        {
          str1 = str2 + String.format(" 100%s+", new Object[] { ak.getContext().getString(2131764457) });
        }
        else if (paramInt > 999)
        {
          str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 1000.0F), ak.getContext().getString(2131764457) });
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
  
  public static final String a(dom paramdom)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramdom.HVo, new d.3());
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramdom.HVo.size())
    {
      localStringBuffer.append(((dow)paramdom.HVo.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((dow)paramdom.HVo.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((dow)paramdom.HVo.get(i)).timestamp - ((dow)paramdom.HVo.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramdom.HVo.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((dow)paramdom.HVo.get(paramdom.HVo.size() - 1)).timestamp - ((dow)paramdom.HVo.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramdom.HVo.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.esr()) {
      com.tencent.mm.sdk.g.b.c(new d.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    paramdom = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramdom;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(125874);
    ae.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.websearch.api.ad.WL(1)) });
    Object localObject;
    String str1;
    int j;
    int n;
    String str3;
    String str4;
    dom localdom;
    String str5;
    boolean bool3;
    final boolean bool1;
    Intent localIntent;
    boolean bool2;
    label448:
    int i;
    label529:
    label611:
    int m;
    int k;
    if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erP())
    {
      localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erR();
      str1 = ((dou)localObject).msgId;
      am.a((dou)localObject, 102, 1, 0, 0L, "");
      j = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erY();
      if (n > 0) {
        am.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esa(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esf()) {
        am.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erV(), 102, 3, 0, 0L, "");
      }
      if (esI())
      {
        esJ();
        ae.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      str3 = String.valueOf(System.currentTimeMillis());
      str4 = paramContext.getString(2131759717);
      localdom = new dom();
      localdom.rfA = esK();
      localdom.scene = paramInt;
      localdom.kid = "";
      localdom.dmf = str4;
      localdom.cSM = 100;
      localdom.BJf = ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getFirstLoadWebView();
      str5 = com.tencent.mm.plugin.websearch.api.ad.WI(paramInt);
      localdom.sessionId = str5;
      localdom.dEb = str5;
      localdom.GEi = str4;
      localdom.HVp = 1;
      localdom.sBn = com.tencent.mm.plugin.websearch.api.ad.UD();
      localdom.HVq = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(localdom.DTg, str1, str3, true);
      b(localdom, "clickTopStory", System.currentTimeMillis());
      bool3 = true;
      bool1 = true;
      localIntent = new Intent();
      bool2 = bool3;
      try
      {
        if (com.tencent.mm.protocal.d.FFH < 654311424)
        {
          bool2 = bool3;
          if (!com.tencent.mm.protocal.d.FFL) {
            break label1160;
          }
        }
        bool2 = bool3;
        localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzA, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        str6 = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esg();
        bool2 = bool3;
        localList = aEi((String)localObject);
        bool2 = bool3;
        if (localList.isEmpty()) {
          break label1070;
        }
        i = 110;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzB, 0) != 0) {
          break label909;
        }
        bool1 = true;
        bool2 = bool3;
        ae.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label964;
        }
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erY() > 0) {
          break label1179;
        }
        bool2 = bool3;
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erP()) {
          break label915;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          String str6;
          List localList;
          String str2;
          bool1 = bool2;
        }
        bool1 = true;
        break label1186;
      }
      bool2 = bool3;
      m = ((b)localList.get(0)).category;
      bool2 = bool3;
      str2 = ((b)localList.get(0)).BJw;
      k = 0;
    }
    for (;;)
    {
      bool2 = bool3;
      if (k < localList.size())
      {
        bool2 = bool3;
        if (((b)localList.get(k)).category != i) {
          break label1199;
        }
        bool2 = bool3;
        str2 = ((b)localList.get(k)).BJw;
        label715:
        bool2 = bool3;
        localdom.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, str2, j, n, str6, paramString);
        bool2 = bool3;
        localIntent.putExtra("key_tabconfig", (String)localObject);
        bool2 = bool3;
        localIntent.putExtra("key_chosetab", i);
        if (i == 110)
        {
          bool1 = false;
          break label1186;
        }
      }
      label909:
      label915:
      label1179:
      label1186:
      for (;;)
      {
        bool2 = bool1;
        localIntent.putExtra("key_context", localdom.toByteArray());
        if (paramBundle != null) {
          localIntent.putExtra("key_extra_data", paramBundle);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125865);
            ((b)g.ad(b.class)).getWebViewMgr().a(this.BJr, bool1);
            AppMethodBeat.o(125865);
          }
        });
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.ajR().ajA().set(am.a.IYt, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eO(com.tencent.mm.plugin.boots.a.b.nZt, 884);
        AppMethodBeat.o(125874);
        return;
        bool1 = false;
        break label529;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esf())
        {
          i = 100;
          break label611;
        }
        bool2 = bool3;
        i = esH();
        if (i != 0)
        {
          break label1189;
          label964:
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esf())
          {
            i = 100;
            break label611;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erY() > 0) {
            break label1192;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erP()) {
            break label1192;
          }
          bool2 = bool3;
          k = esH();
          if (k == 0) {
            break label611;
          }
          i = k;
          break label611;
          label1070:
          bool2 = bool3;
          localdom.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str6, paramString);
          bool2 = bool3;
          localIntent.putExtra("key_tabconfig", "");
          bool2 = bool3;
          localIntent.putExtra("key_chosetab", 0);
          continue;
          i = m;
          break label715;
        }
        i = 110;
        break label1189;
        localObject = "";
        break label448;
        j = 0;
        str1 = "";
        break;
        i = 110;
        break label611;
      }
      label1160:
      label1189:
      break label611;
      label1192:
      i = 110;
      break label611;
      label1199:
      k += 1;
    }
  }
  
  public static void a(Context paramContext, dom paramdom, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramdom, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, dom paramdom, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramdom.DTg, "", paramString, false);
    b(paramdom, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramdom.toByteArray());
      label48:
      com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)g.ad(b.class)).getWebViewMgr().a(this.BJr, paramBoolean);
          AppMethodBeat.o(125866);
        }
      });
      AppMethodBeat.o(125878);
      return;
    }
    catch (IOException localIOException)
    {
      break label48;
    }
  }
  
  private static void a(List<aaj> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    aaj localaaj = new aaj();
    localaaj.key = "redPointMsgId";
    localaaj.GrF = String.valueOf(paramString1);
    paramList.add(localaaj);
    paramString1 = new aaj();
    paramString1.key = "currentPage";
    paramString1.GrE = 1L;
    paramList.add(paramString1);
    paramString1 = new aaj();
    paramString1.key = "is_prefetch";
    paramString1.GrE = 0L;
    paramList.add(paramString1);
    if (!bu.isNullOrNil(paramString2))
    {
      paramString1 = new aaj();
      paramString1.key = "seq";
      paramString1.GrF = paramString2;
      paramList.add(paramString1);
      paramString1 = new aaj();
      paramString1.key = "requestId";
      paramString1.GrF = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new aaj();
    paramString1.key = "recType";
    paramString1.GrE = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new aaj();
      paramString1.key = "direction";
      paramString1.GrE = 1L;
      paramList.add(paramString1);
      paramString1 = new aaj();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.GrF = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static List<b> aEi(String paramString)
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
          str = com.tencent.mm.sdk.platformtools.ad.fom();
          if (str.equals("zh_TW"))
          {
            localb.dyI = ((JSONObject)localObject).getString("wording_tw");
            if (!bu.isNullOrNil(localb.dyI)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label188;
          }
          localb.dyI = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label214;
        }
      }
      catch (Exception paramString)
      {
        ae.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label188:
      localb.dyI = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label214:
      localb.dyI = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label244:
      localb.BJv = bool;
      localb.BJw = ((JSONObject)localObject).getString("tabInfo");
      if (localb.category == 110) {
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erP()) {
          break label511;
        }
      }
    }
    label511:
    for (int j = 1;; j = 0)
    {
      localb.BJx = j;
      localb.BJy = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erY();
      if (localb.BJy > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esa();
        if (localObject != null) {
          localb.BJA = ((dou)localObject).msgId;
        }
      }
      if (localb.BJx > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erR();
        if (localObject != null) {
          localb.BJz = ((dou)localObject).msgId;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.category != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esf()) {}
      for (j = 1;; j = 0)
      {
        localb.BJx = j;
        if (localb.BJx <= 0) {
          break;
        }
        localb.BJz = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().esg();
        break;
      }
      bool = false;
      break label244;
    }
  }
  
  public static void aEj(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    g.ajj().a(paramString.getType(), new d.4(paramString));
    g.ajj().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  public static void aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    ae.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.m(paramString2, true, false) == null)
    {
      l.d(paramString1, "", paramString2, -1, "appinfo error: not found.");
      ae.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
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
      com.tencent.mm.plugin.websearch.api.ad.e(ak.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
      AppMethodBeat.o(125872);
      return;
    }
    catch (JSONException paramString3)
    {
      ae.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", paramString3, "startTopStoryUploadUI", new Object[0]);
      l.d(paramString1, "", paramString2, -1, "extInfo error: parse failed.");
      AppMethodBeat.o(125872);
    }
  }
  
  public static void aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "");
    AppMethodBeat.o(125873);
  }
  
  private static void b(dom paramdom, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    i.a(paramdom, paramString, paramLong);
    if (paramdom.HVo.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    dow localdow = new dow();
    localdow.name = paramString;
    localdow.timestamp = paramLong;
    paramdom.HVo.add(localdow);
    AppMethodBeat.o(125884);
  }
  
  public static final String bt(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(dom paramdom, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    i.a(paramdom, paramString, paramLong);
    if (paramdom.HVo.size() > 0)
    {
      dow localdow = new dow();
      localdow.name = paramString;
      localdow.timestamp = paramLong;
      paramdom.HVo.add(localdow);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int esH()
  {
    AppMethodBeat.i(125875);
    if (g.ajR().ajA().getInt(am.a.IYY, 1) == 1)
    {
      int i = g.ajR().ajA().getInt(am.a.IYX, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean esI()
  {
    AppMethodBeat.i(125881);
    ww localww = new ww();
    localww.dMq.actionType = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localww);
    boolean bool = localww.dMr.dMs;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void esJ()
  {
    AppMethodBeat.i(125882);
    ww localww = new ww();
    localww.dMq.actionType = 2;
    com.tencent.mm.sdk.b.a.IvT.l(localww);
    AppMethodBeat.o(125882);
  }
  
  public static final String esK()
  {
    AppMethodBeat.i(125883);
    ww localww = new ww();
    localww.dMq.actionType = 3;
    com.tencent.mm.sdk.b.a.IvT.l(localww);
    String str = "";
    if (localww.dMr.dMt != null) {
      str = localww.dMr.dMt.rfA;
    }
    if (bu.isNullOrNil(str))
    {
      str = UUID.randomUUID().toString();
      AppMethodBeat.o(125883);
      return str;
    }
    AppMethodBeat.o(125883);
    return str;
  }
  
  public static void gD(Context paramContext)
  {
    AppMethodBeat.i(125888);
    am.p("", 0, 0, 100);
    com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class b
  {
    public String BJA = "";
    public TextView BJB;
    public View BJC;
    public boolean BJv;
    public String BJw = "";
    public int BJx = 0;
    public int BJy = 0;
    public String BJz = "";
    public int category = 0;
    public String dyI = "";
    public TextView titleTv;
    public View uGB;
    public TabLayout.f vj;
    
    public final void cj(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.BJy = paramInt;
      this.BJA = paramString;
      if (this.BJy <= 0)
      {
        this.BJB.setText("");
        this.BJB.setVisibility(4);
        if (this.BJx > 0)
        {
          ck(this.BJx, this.BJz);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.BJy;
        if (this.BJy > 99) {
          paramString = "99+";
        }
        this.BJB.setText(paramString);
        this.BJB.setVisibility(0);
        this.BJC.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void ck(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.BJx = paramInt;
      this.BJz = paramString;
      if (paramInt > 0)
      {
        if (this.BJy <= 0)
        {
          this.BJB.setVisibility(4);
          this.BJC.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.BJC.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */