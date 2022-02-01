package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout.f;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vo.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
  public static com.tencent.mm.aw.a.a.c yMm;
  public static com.tencent.mm.aw.a.a.c yMn;
  
  static
  {
    AppMethodBeat.i(125890);
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    locala.gkG = true;
    locala.hkf = 2131231875;
    yMm = locala.azc();
    locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    locala.hkf = 2131231875;
    yMn = locala.azc();
    AppMethodBeat.o(125890);
  }
  
  public static final String Pe(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = aj.getContext().getString(2131764473);
    if (aj.getContext().getSharedPreferences(aj.eFD(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cd.a.hF(aj.getContext())) >= com.tencent.mm.cd.a.hI(aj.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (ac.ir(aj.getContext()) == "zh_CN")) {
      if (paramInt > 9999) {
        str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 10000.0F), aj.getContext().getString(2131764458) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125889);
      return str1;
      if (paramInt > 99999)
      {
        str1 = str2 + String.format(" 10%s+", new Object[] { aj.getContext().getString(2131764458) });
      }
      else
      {
        str1 = str2 + " " + paramInt;
        continue;
        if (paramInt > 99999)
        {
          str1 = str2 + String.format(" 100%s+", new Object[] { aj.getContext().getString(2131764457) });
        }
        else if (paramInt > 999)
        {
          str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 1000.0F), aj.getContext().getString(2131764457) });
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
  
  public static final String a(dcn paramdcn)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramdcn.EtT, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramdcn.EtT.size())
    {
      localStringBuffer.append(((dcx)paramdcn.EtT.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((dcx)paramdcn.EtT.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((dcx)paramdcn.EtT.get(i)).timestamp - ((dcx)paramdcn.EtT.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramdcn.EtT.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((dcx)paramdcn.EtT.get(paramdcn.EtT.size() - 1)).timestamp - ((dcx)paramdcn.EtT.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramdcn.EtT.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.dNT()) {
      com.tencent.mm.sdk.g.b.c(new d.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    paramdcn = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramdcn;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(125874);
    ad.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Sb(1)) });
    Object localObject;
    String str1;
    int j;
    int n;
    String str3;
    String str4;
    dcn localdcn;
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
    if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNr())
    {
      localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNt();
      str1 = ((dcv)localObject).dvT;
      ak.a((dcv)localObject, 102, 1, 0, 0L, "");
      j = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNA();
      if (n > 0) {
        ak.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNC(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNH()) {
        ak.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNx(), 102, 3, 0, 0L, "");
      }
      if (dOj())
      {
        dOk();
        ad.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      str3 = String.valueOf(System.currentTimeMillis());
      str4 = paramContext.getString(2131759717);
      localdcn = new dcn();
      localdcn.qwV = dOl();
      localdcn.scene = paramInt;
      localdcn.jko = "";
      localdcn.dcm = str4;
      localdcn.cJR = 100;
      localdcn.yMc = ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getFirstLoadWebView();
      str5 = aa.RY(paramInt);
      localdcn.sessionId = str5;
      localdcn.dtw = str5;
      localdcn.EtV = str4;
      localdcn.EtU = 1;
      localdcn.qGK = aa.cWN();
      localdcn.EtW = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(localdcn.AFX, str1, str3, true);
      b(localdcn, "clickTopStory", System.currentTimeMillis());
      bool3 = true;
      bool1 = true;
      localIntent = new Intent();
      bool2 = bool3;
      try
      {
        if (com.tencent.mm.protocal.d.CpK < 654311424)
        {
          bool2 = bool3;
          if (!com.tencent.mm.protocal.d.CpO) {
            break label1160;
          }
        }
        bool2 = bool3;
        localObject = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plq, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        str6 = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNI();
        bool2 = bool3;
        localList = asB((String)localObject);
        bool2 = bool3;
        if (localList.isEmpty()) {
          break label1070;
        }
        i = 110;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plr, 0) != 0) {
          break label909;
        }
        bool1 = true;
        bool2 = bool3;
        ad.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label964;
        }
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNA() > 0) {
          break label1179;
        }
        bool2 = bool3;
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNr()) {
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
      str2 = ((b)localList.get(0)).yMu;
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
        str2 = ((b)localList.get(k)).yMu;
        label715:
        bool2 = bool3;
        localdcn.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, str2, j, n, str6, paramString);
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
        localIntent.putExtra("key_context", localdcn.toByteArray());
        if (paramBundle != null) {
          localIntent.putExtra("key_extra_data", paramBundle);
        }
        localIntent.addFlags(67108864);
        aa.d(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125865);
            ((b)g.ad(b.class)).getWebViewMgr().a(this.yMo, bool1);
            AppMethodBeat.o(125865);
          }
        });
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.afB().afk().set(ae.a.Ftv, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eG(com.tencent.mm.plugin.boots.a.b.mQG, 884);
        AppMethodBeat.o(125874);
        return;
        bool1 = false;
        break label529;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNH())
        {
          i = 100;
          break label611;
        }
        bool2 = bool3;
        i = dOi();
        if (i != 0)
        {
          break label1189;
          label964:
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNH())
          {
            i = 100;
            break label611;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNA() > 0) {
            break label1192;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNr()) {
            break label1192;
          }
          bool2 = bool3;
          k = dOi();
          if (k == 0) {
            break label611;
          }
          i = k;
          break label611;
          label1070:
          bool2 = bool3;
          localdcn.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str6, paramString);
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
  
  public static void a(Context paramContext, dcn paramdcn, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramdcn, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, dcn paramdcn, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramdcn.AFX, "", paramString, false);
    b(paramdcn, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramdcn.toByteArray());
      label48:
      aa.d(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)g.ad(b.class)).getWebViewMgr().a(this.yMo, paramBoolean);
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
  
  private static void a(List<xp> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    xp localxp = new xp();
    localxp.key = "redPointMsgId";
    localxp.CZj = String.valueOf(paramString1);
    paramList.add(localxp);
    paramString1 = new xp();
    paramString1.key = "currentPage";
    paramString1.CZi = 1L;
    paramList.add(paramString1);
    paramString1 = new xp();
    paramString1.key = "is_prefetch";
    paramString1.CZi = 0L;
    paramList.add(paramString1);
    if (!bt.isNullOrNil(paramString2))
    {
      paramString1 = new xp();
      paramString1.key = "seq";
      paramString1.CZj = paramString2;
      paramList.add(paramString1);
      paramString1 = new xp();
      paramString1.key = "requestId";
      paramString1.CZj = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new xp();
    paramString1.key = "recType";
    paramString1.CZi = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new xp();
      paramString1.key = "direction";
      paramString1.CZi = 1L;
      paramList.add(paramString1);
      paramString1 = new xp();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.CZj = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static void aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    ad.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.j(paramString2, true, false) == null)
    {
      l.c(paramString1, "", paramString2, -1, "appinfo error: not found.");
      ad.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
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
      aa.d(aj.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
      AppMethodBeat.o(125872);
      return;
    }
    catch (JSONException paramString3)
    {
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", paramString3, "startTopStoryUploadUI", new Object[0]);
      l.c(paramString1, "", paramString2, -1, "extInfo error: parse failed.");
      AppMethodBeat.o(125872);
    }
  }
  
  public static void aa(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "");
    AppMethodBeat.o(125873);
  }
  
  public static List<b> asB(String paramString)
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
          str = ac.eFu();
          if (str.equals("zh_TW"))
          {
            localb.doh = ((JSONObject)localObject).getString("wording_tw");
            if (!bt.isNullOrNil(localb.doh)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label188;
          }
          localb.doh = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label214;
        }
      }
      catch (Exception paramString)
      {
        ad.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label188:
      localb.doh = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label214:
      localb.doh = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label244:
      localb.yMt = bool;
      localb.yMu = ((JSONObject)localObject).getString("tabInfo");
      if (localb.category == 110) {
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNr()) {
          break label511;
        }
      }
    }
    label511:
    for (int j = 1;; j = 0)
    {
      localb.yMv = j;
      localb.yMw = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNA();
      if (localb.yMw > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNC();
        if (localObject != null) {
          localb.yMy = ((dcv)localObject).dvT;
        }
      }
      if (localb.yMv > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNt();
        if (localObject != null) {
          localb.yMx = ((dcv)localObject).dvT;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.category != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNH()) {}
      for (j = 1;; j = 0)
      {
        localb.yMv = j;
        if (localb.yMv <= 0) {
          break;
        }
        localb.yMx = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNI();
        break;
      }
      bool = false;
      break label244;
    }
  }
  
  public static void asC(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    g.aeS().a(paramString.getType(), new d.4(paramString));
    g.aeS().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  private static void b(dcn paramdcn, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    i.a(paramdcn, paramString, paramLong);
    if (paramdcn.EtT.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    dcx localdcx = new dcx();
    localdcx.name = paramString;
    localdcx.timestamp = paramLong;
    paramdcn.EtT.add(localdcx);
    AppMethodBeat.o(125884);
  }
  
  public static final String bn(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(dcn paramdcn, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    i.a(paramdcn, paramString, paramLong);
    if (paramdcn.EtT.size() > 0)
    {
      dcx localdcx = new dcx();
      localdcx.name = paramString;
      localdcx.timestamp = paramLong;
      paramdcn.EtT.add(localdcx);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int dOi()
  {
    AppMethodBeat.i(125875);
    if (g.afB().afk().getInt(ae.a.Fua, 1) == 1)
    {
      int i = g.afB().afk().getInt(ae.a.FtZ, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean dOj()
  {
    AppMethodBeat.i(125881);
    vo localvo = new vo();
    localvo.dBb.actionType = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localvo);
    boolean bool = localvo.dBc.dBd;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void dOk()
  {
    AppMethodBeat.i(125882);
    vo localvo = new vo();
    localvo.dBb.actionType = 2;
    com.tencent.mm.sdk.b.a.ESL.l(localvo);
    AppMethodBeat.o(125882);
  }
  
  public static final String dOl()
  {
    AppMethodBeat.i(125883);
    vo localvo = new vo();
    localvo.dBb.actionType = 3;
    com.tencent.mm.sdk.b.a.ESL.l(localvo);
    String str = "";
    if (localvo.dBc.dBe != null) {
      str = localvo.dBc.dBe.qwV;
    }
    if (bt.isNullOrNil(str))
    {
      str = UUID.randomUUID().toString();
      AppMethodBeat.o(125883);
      return str;
    }
    AppMethodBeat.o(125883);
    return str;
  }
  
  public static void gj(Context paramContext)
  {
    AppMethodBeat.i(125888);
    ak.p("", 0, 0, 100);
    aa.d(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class b
  {
    public int category = 0;
    public String doh = "";
    public View snU;
    public TabLayout.f sr;
    public TextView titleTv;
    public View yMA;
    public boolean yMt;
    public String yMu = "";
    public int yMv = 0;
    public int yMw = 0;
    public String yMx = "";
    public String yMy = "";
    public TextView yMz;
    
    public final void bY(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.yMw = paramInt;
      this.yMy = paramString;
      if (this.yMw <= 0)
      {
        this.yMz.setText("");
        this.yMz.setVisibility(4);
        if (this.yMv > 0)
        {
          bZ(this.yMv, this.yMx);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.yMw;
        if (this.yMw > 99) {
          paramString = "99+";
        }
        this.yMz.setText(paramString);
        this.yMz.setVisibility(0);
        this.yMA.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void bZ(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.yMv = paramInt;
      this.yMx = paramString;
      if (paramInt > 0)
      {
        if (this.yMw <= 0)
        {
          this.yMz.setVisibility(4);
          this.yMA.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.yMA.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */