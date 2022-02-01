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
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.a.ws.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public static com.tencent.mm.aw.a.a.c BrQ;
  public static com.tencent.mm.aw.a.a.c BrR;
  
  static
  {
    AppMethodBeat.i(125890);
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    locala.hfi = true;
    locala.idD = 2131231875;
    BrQ = locala.aJc();
    locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    locala.idD = 2131231875;
    BrR = locala.aJc();
    AppMethodBeat.o(125890);
  }
  
  public static final String SU(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = aj.getContext().getString(2131764473);
    if (aj.getContext().getSharedPreferences(aj.fkC(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cc.a.hZ(aj.getContext())) >= com.tencent.mm.cc.a.ic(aj.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (ac.iM(aj.getContext()) == "zh_CN")) {
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
  
  public static final String a(dnp paramdnp)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramdnp.HBB, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramdnp.HBB.size())
    {
      localStringBuffer.append(((dnz)paramdnp.HBB.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((dnz)paramdnp.HBB.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((dnz)paramdnp.HBB.get(i)).timestamp - ((dnz)paramdnp.HBB.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramdnp.HBB.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((dnz)paramdnp.HBB.get(paramdnp.HBB.size() - 1)).timestamp - ((dnz)paramdnp.HBB.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramdnp.HBB.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.eoK()) {
      com.tencent.mm.sdk.g.b.c(new d.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    paramdnp = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramdnp;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(125874);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.websearch.api.ad.We(1)) });
    Object localObject;
    String str1;
    int j;
    int n;
    String str3;
    String str4;
    dnp localdnp;
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
    if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoi())
    {
      localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok();
      str1 = ((dnx)localObject).msgId;
      am.a((dnx)localObject, 102, 1, 0, 0L, "");
      j = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eor();
      if (n > 0) {
        am.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoy()) {
        am.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoo(), 102, 3, 0, 0L, "");
      }
      if (epb())
      {
        epc();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      str3 = String.valueOf(System.currentTimeMillis());
      str4 = paramContext.getString(2131759717);
      localdnp = new dnp();
      localdnp.qXu = epd();
      localdnp.scene = paramInt;
      localdnp.keN = "";
      localdnp.dld = str4;
      localdnp.cSc = 100;
      localdnp.BrG = ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getFirstLoadWebView();
      str5 = com.tencent.mm.plugin.websearch.api.ad.Wb(paramInt);
      localdnp.sessionId = str5;
      localdnp.dCW = str5;
      localdnp.Glg = str4;
      localdnp.HBC = 1;
      localdnp.srd = com.tencent.mm.plugin.websearch.api.ad.Ux();
      localdnp.HBD = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(localdnp.DBj, str1, str3, true);
      b(localdnp, "clickTopStory", System.currentTimeMillis());
      bool3 = true;
      bool1 = true;
      localIntent = new Intent();
      bool2 = bool3;
      try
      {
        if (com.tencent.mm.protocal.d.Fnj < 654311424)
        {
          bool2 = bool3;
          if (!com.tencent.mm.protocal.d.Fnn) {
            break label1160;
          }
        }
        bool2 = bool3;
        localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsL, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        str6 = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoz();
        bool2 = bool3;
        localList = aCP((String)localObject);
        bool2 = bool3;
        if (localList.isEmpty()) {
          break label1070;
        }
        i = 110;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsM, 0) != 0) {
          break label909;
        }
        bool1 = true;
        bool2 = bool3;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label964;
        }
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eor() > 0) {
          break label1179;
        }
        bool2 = bool3;
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoi()) {
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
      str2 = ((b)localList.get(0)).BrX;
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
        str2 = ((b)localList.get(k)).BrX;
        label715:
        bool2 = bool3;
        localdnp.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, str2, j, n, str6, paramString);
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
        localIntent.putExtra("key_context", localdnp.toByteArray());
        if (paramBundle != null) {
          localIntent.putExtra("key_extra_data", paramBundle);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125865);
            ((b)g.ad(b.class)).getWebViewMgr().a(this.BrS, bool1);
            AppMethodBeat.o(125865);
          }
        });
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.ajC().ajl().set(al.a.IDT, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eN(com.tencent.mm.plugin.boots.a.b.nTN, 884);
        AppMethodBeat.o(125874);
        return;
        bool1 = false;
        break label529;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoy())
        {
          i = 100;
          break label611;
        }
        bool2 = bool3;
        i = epa();
        if (i != 0)
        {
          break label1189;
          label964:
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoy())
          {
            i = 100;
            break label611;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eor() > 0) {
            break label1192;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoi()) {
            break label1192;
          }
          bool2 = bool3;
          k = epa();
          if (k == 0) {
            break label611;
          }
          i = k;
          break label611;
          label1070:
          bool2 = bool3;
          localdnp.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str6, paramString);
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
  
  public static void a(Context paramContext, dnp paramdnp, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramdnp, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, dnp paramdnp, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramdnp.DBj, "", paramString, false);
    b(paramdnp, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramdnp.toByteArray());
      label48:
      com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)g.ad(b.class)).getWebViewMgr().a(this.BrS, paramBoolean);
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
  
  private static void a(List<aag> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    aag localaag = new aag();
    localaag.key = "redPointMsgId";
    localaag.FZf = String.valueOf(paramString1);
    paramList.add(localaag);
    paramString1 = new aag();
    paramString1.key = "currentPage";
    paramString1.FZe = 1L;
    paramList.add(paramString1);
    paramString1 = new aag();
    paramString1.key = "is_prefetch";
    paramString1.FZe = 0L;
    paramList.add(paramString1);
    if (!bt.isNullOrNil(paramString2))
    {
      paramString1 = new aag();
      paramString1.key = "seq";
      paramString1.FZf = paramString2;
      paramList.add(paramString1);
      paramString1 = new aag();
      paramString1.key = "requestId";
      paramString1.FZf = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new aag();
    paramString1.key = "recType";
    paramString1.FZe = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new aag();
      paramString1.key = "direction";
      paramString1.FZe = 1L;
      paramList.add(paramString1);
      paramString1 = new aag();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.FZf = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static List<b> aCP(String paramString)
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
          str = ac.fks();
          if (str.equals("zh_TW"))
          {
            localb.dxD = ((JSONObject)localObject).getString("wording_tw");
            if (!bt.isNullOrNil(localb.dxD)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label188;
          }
          localb.dxD = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label214;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label188:
      localb.dxD = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label214:
      localb.dxD = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label244:
      localb.BrW = bool;
      localb.BrX = ((JSONObject)localObject).getString("tabInfo");
      if (localb.category == 110) {
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoi()) {
          break label511;
        }
      }
    }
    label511:
    for (int j = 1;; j = 0)
    {
      localb.BrY = j;
      localb.BrZ = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eor();
      if (localb.BrZ > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot();
        if (localObject != null) {
          localb.Bsb = ((dnx)localObject).msgId;
        }
      }
      if (localb.BrY > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok();
        if (localObject != null) {
          localb.Bsa = ((dnx)localObject).msgId;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.category != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoy()) {}
      for (j = 1;; j = 0)
      {
        localb.BrY = j;
        if (localb.BrY <= 0) {
          break;
        }
        localb.Bsa = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoz();
        break;
      }
      bool = false;
      break label244;
    }
  }
  
  public static void aCQ(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    g.aiU().a(paramString.getType(), new d.4(paramString));
    g.aiU().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  public static void aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.m(paramString2, true, false) == null)
    {
      l.d(paramString1, "", paramString2, -1, "appinfo error: not found.");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
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
      com.tencent.mm.plugin.websearch.api.ad.e(aj.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
      AppMethodBeat.o(125872);
      return;
    }
    catch (JSONException paramString3)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", paramString3, "startTopStoryUploadUI", new Object[0]);
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
  
  private static void b(dnp paramdnp, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    i.a(paramdnp, paramString, paramLong);
    if (paramdnp.HBB.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    dnz localdnz = new dnz();
    localdnz.name = paramString;
    localdnz.timestamp = paramLong;
    paramdnp.HBB.add(localdnz);
    AppMethodBeat.o(125884);
  }
  
  public static final String bs(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(dnp paramdnp, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    i.a(paramdnp, paramString, paramLong);
    if (paramdnp.HBB.size() > 0)
    {
      dnz localdnz = new dnz();
      localdnz.name = paramString;
      localdnz.timestamp = paramLong;
      paramdnp.HBB.add(localdnz);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int epa()
  {
    AppMethodBeat.i(125875);
    if (g.ajC().ajl().getInt(al.a.IEy, 1) == 1)
    {
      int i = g.ajC().ajl().getInt(al.a.IEx, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean epb()
  {
    AppMethodBeat.i(125881);
    ws localws = new ws();
    localws.dLb.actionType = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localws);
    boolean bool = localws.dLc.dLd;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void epc()
  {
    AppMethodBeat.i(125882);
    ws localws = new ws();
    localws.dLb.actionType = 2;
    com.tencent.mm.sdk.b.a.IbL.l(localws);
    AppMethodBeat.o(125882);
  }
  
  public static final String epd()
  {
    AppMethodBeat.i(125883);
    ws localws = new ws();
    localws.dLb.actionType = 3;
    com.tencent.mm.sdk.b.a.IbL.l(localws);
    String str = "";
    if (localws.dLc.dLe != null) {
      str = localws.dLc.dLe.qXu;
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
  
  public static void gy(Context paramContext)
  {
    AppMethodBeat.i(125888);
    am.p("", 0, 0, 100);
    com.tencent.mm.plugin.websearch.api.ad.e(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class b
  {
    public boolean BrW;
    public String BrX = "";
    public int BrY = 0;
    public int BrZ = 0;
    public String Bsa = "";
    public String Bsb = "";
    public TextView Bsc;
    public View Bsd;
    public int category = 0;
    public String dxD = "";
    public TextView titleTv;
    public View uvc;
    public TabLayout.f vj;
    
    public final void cj(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.BrZ = paramInt;
      this.Bsb = paramString;
      if (this.BrZ <= 0)
      {
        this.Bsc.setText("");
        this.Bsc.setVisibility(4);
        if (this.BrY > 0)
        {
          ck(this.BrY, this.Bsa);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.BrZ;
        if (this.BrZ > 99) {
          paramString = "99+";
        }
        this.Bsc.setText(paramString);
        this.Bsc.setVisibility(0);
        this.Bsd.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void ck(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.BrY = paramInt;
      this.Bsa = paramString;
      if (paramInt > 0)
      {
        if (this.BrZ <= 0)
        {
          this.Bsc.setVisibility(4);
          this.Bsd.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.Bsd.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */