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
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.vz.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public static com.tencent.mm.av.a.a.c Aae;
  public static com.tencent.mm.av.a.a.c Aaf;
  
  static
  {
    AppMethodBeat.i(125890);
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    locala.gLt = true;
    locala.hKI = 2131231875;
    Aae = locala.aFT();
    locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    locala.hKI = 2131231875;
    Aaf = locala.aFT();
    AppMethodBeat.o(125890);
  }
  
  public static final String Rk(int paramInt)
  {
    AppMethodBeat.i(125889);
    String str2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764473);
    if (com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cc.a.hQ(com.tencent.mm.sdk.platformtools.ai.getContext())) >= com.tencent.mm.cc.a.hT(com.tencent.mm.sdk.platformtools.ai.getContext()))
    {
      AppMethodBeat.o(125889);
      return str2;
    }
    String str1;
    if ((paramInt > 0) && (ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()) == "zh_CN")) {
      if (paramInt > 9999) {
        str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 10000.0F), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764458) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(125889);
      return str1;
      if (paramInt > 99999)
      {
        str1 = str2 + String.format(" 10%s+", new Object[] { com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764458) });
      }
      else
      {
        str1 = str2 + " " + paramInt;
        continue;
        if (paramInt > 99999)
        {
          str1 = str2 + String.format(" 100%s+", new Object[] { com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764457) });
        }
        else if (paramInt > 999)
        {
          str1 = str2 + String.format(" %.1f%s", new Object[] { Float.valueOf(paramInt / 1000.0F), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764457) });
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
  
  public static final String a(dia paramdia)
  {
    AppMethodBeat.i(125886);
    Collections.sort(paramdia.FQV, new Comparator() {});
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < paramdia.FQV.size())
    {
      localStringBuffer.append(((dik)paramdia.FQV.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((dik)paramdia.FQV.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((dik)paramdia.FQV.get(i)).timestamp - ((dik)paramdia.FQV.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (paramdia.FQV.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((dik)paramdia.FQV.get(paramdia.FQV.size() - 1)).timestamp - ((dik)paramdia.FQV.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    paramdia.FQV.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.h.ect()) {
      com.tencent.mm.sdk.g.b.c(new d.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    paramdia = localStringBuffer.toString();
    AppMethodBeat.o(125886);
    return paramdia;
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(125874);
    ac.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(z.Ul(1)) });
    Object localObject;
    String str1;
    int j;
    int n;
    String str3;
    String str4;
    dia localdia;
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
    if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebR())
    {
      localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT();
      str1 = ((dii)localObject).dtG;
      com.tencent.mm.plugin.websearch.api.ai.a((dii)localObject, 102, 1, 0, 0L, "");
      j = 1;
      n = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eca();
      if (n > 0) {
        com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc(), 102, 2, n, 0L, "");
      }
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ech()) {
        com.tencent.mm.plugin.websearch.api.ai.a(((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebX(), 102, 3, 0, 0L, "");
      }
      if (ecK())
      {
        ecL();
        ac.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
      }
      str3 = String.valueOf(System.currentTimeMillis());
      str4 = paramContext.getString(2131759717);
      localdia = new dia();
      localdia.qox = ecM();
      localdia.scene = paramInt;
      localdia.jKB = "";
      localdia.cZL = str4;
      localdia.cGY = 100;
      localdia.zZU = ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getFirstLoadWebView();
      str5 = z.Ui(paramInt);
      localdia.sessionId = str5;
      localdia.drf = str5;
      localdia.EDw = str4;
      localdia.FQW = 1;
      localdia.rzt = z.dkv();
      localdia.FQX = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(localdia.BYq, str1, str3, true);
      b(localdia, "clickTopStory", System.currentTimeMillis());
      bool3 = true;
      bool1 = true;
      localIntent = new Intent();
      bool2 = bool3;
      try
      {
        if (com.tencent.mm.protocal.d.DIc < 654311424)
        {
          bool2 = bool3;
          if (!com.tencent.mm.protocal.d.DIg) {
            break label1160;
          }
        }
        bool2 = bool3;
        localObject = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOM, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        bool2 = bool3;
        str6 = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eci();
        bool2 = bool3;
        localList = axK((String)localObject);
        bool2 = bool3;
        if (localList.isEmpty()) {
          break label1070;
        }
        i = 110;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pON, 0) != 0) {
          break label909;
        }
        bool1 = true;
        bool2 = bool3;
        ac.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label964;
        }
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eca() > 0) {
          break label1179;
        }
        bool2 = bool3;
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebR()) {
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
      str2 = ((b)localList.get(0)).Aal;
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
        str2 = ((b)localList.get(k)).Aal;
        label715:
        bool2 = bool3;
        localdia.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, str2, j, n, str6, paramString);
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
        localIntent.putExtra("key_context", localdia.toByteArray());
        if (paramBundle != null) {
          localIntent.putExtra("key_extra_data", paramBundle);
        }
        localIntent.addFlags(67108864);
        z.d(paramContext, ".ui.home.TopStoryHomeUI", localIntent);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125865);
            ((b)g.ad(b.class)).getWebViewMgr().a(this.Aag, bool1);
            AppMethodBeat.o(125865);
          }
        });
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.agR().agA().set(ah.a.GRp, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eJ(com.tencent.mm.plugin.boots.a.b.nsR, 884);
        AppMethodBeat.o(125874);
        return;
        bool1 = false;
        break label529;
        bool2 = bool3;
        if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ech())
        {
          i = 100;
          break label611;
        }
        bool2 = bool3;
        i = ecJ();
        if (i != 0)
        {
          break label1189;
          label964:
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ech())
          {
            i = 100;
            break label611;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eca() > 0) {
            break label1192;
          }
          bool2 = bool3;
          if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebR()) {
            break label1192;
          }
          bool2 = bool3;
          k = ecJ();
          if (k == 0) {
            break label611;
          }
          i = k;
          break label611;
          label1070:
          bool2 = bool3;
          localdia.url = com.tencent.mm.plugin.topstory.a.h.a(paramInt, str5, str4, str3, str1, "", 0, 0, str6, paramString);
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
  
  public static void a(Context paramContext, dia paramdia, String paramString)
  {
    AppMethodBeat.i(125877);
    a(paramContext, paramdia, paramString, true);
    AppMethodBeat.o(125877);
  }
  
  public static void a(Context paramContext, dia paramdia, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(125878);
    a(paramdia.BYq, "", paramString, false);
    b(paramdia, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", paramdia.toByteArray());
      label48:
      z.d(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125866);
          ((b)g.ad(b.class)).getWebViewMgr().a(this.Aag, paramBoolean);
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
  
  private static void a(List<yh> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(125880);
    yh localyh = new yh();
    localyh.key = "redPointMsgId";
    localyh.ErW = String.valueOf(paramString1);
    paramList.add(localyh);
    paramString1 = new yh();
    paramString1.key = "currentPage";
    paramString1.ErV = 1L;
    paramList.add(paramString1);
    paramString1 = new yh();
    paramString1.key = "is_prefetch";
    paramString1.ErV = 0L;
    paramList.add(paramString1);
    if (!bs.isNullOrNil(paramString2))
    {
      paramString1 = new yh();
      paramString1.key = "seq";
      paramString1.ErW = paramString2;
      paramList.add(paramString1);
      paramString1 = new yh();
      paramString1.key = "requestId";
      paramString1.ErW = paramString2;
      paramList.add(paramString1);
    }
    paramString1 = new yh();
    paramString1.key = "recType";
    paramString1.ErV = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new yh();
      paramString1.key = "direction";
      paramString1.ErV = 1L;
      paramList.add(paramString1);
      paramString1 = new yh();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.ErW = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
    AppMethodBeat.o(125880);
  }
  
  public static void aE(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125872);
    ac.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", new Object[] { paramString2 });
    if (com.tencent.mm.pluginsdk.model.app.h.k(paramString2, true, false) == null)
    {
      l.d(paramString1, "", paramString2, -1, "appinfo error: not found.");
      ac.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
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
      z.d(com.tencent.mm.sdk.platformtools.ai.getContext(), ".ui.home.TopStoryUploadUI", localIntent);
      AppMethodBeat.o(125872);
      return;
    }
    catch (JSONException paramString3)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", paramString3, "startTopStoryUploadUI", new Object[0]);
      l.d(paramString1, "", paramString2, -1, "extInfo error: parse failed.");
      AppMethodBeat.o(125872);
    }
  }
  
  public static void ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125873);
    a(paramContext, paramInt, null, "");
    AppMethodBeat.o(125873);
  }
  
  public static List<b> axK(String paramString)
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
          str = ab.eUO();
          if (str.equals("zh_TW"))
          {
            localb.dlQ = ((JSONObject)localObject).getString("wording_tw");
            if (!bs.isNullOrNil(localb.dlQ)) {
              break;
            }
            localArrayList.clear();
            AppMethodBeat.o(125876);
            return localArrayList;
          }
          if (!str.equals("zh_HK")) {
            break label188;
          }
          localb.dlQ = ((JSONObject)localObject).getString("wording_hk");
          continue;
        }
        if (!str.equals("zh_CN")) {
          break label214;
        }
      }
      catch (Exception paramString)
      {
        ac.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", new Object[] { paramString.getMessage() });
        localArrayList.clear();
        AppMethodBeat.o(125876);
        return localArrayList;
      }
      label188:
      localb.dlQ = ((JSONObject)localObject).getString("wording_cn");
      continue;
      label214:
      localb.dlQ = ((JSONObject)localObject).getString("wording_en");
    }
    boolean bool;
    if (((JSONObject)localObject).getInt("showWhenRedDot") == 1)
    {
      bool = true;
      label244:
      localb.Aak = bool;
      localb.Aal = ((JSONObject)localObject).getString("tabInfo");
      if (localb.category == 110) {
        if (!((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebR()) {
          break label511;
        }
      }
    }
    label511:
    for (int j = 1;; j = 0)
    {
      localb.Aam = j;
      localb.Aan = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eca();
      if (localb.Aan > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc();
        if (localObject != null) {
          localb.Aap = ((dii)localObject).dtG;
        }
      }
      if (localb.Aam > 0)
      {
        localObject = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT();
        if (localObject != null) {
          localb.Aao = ((dii)localObject).dtG;
        }
      }
      do
      {
        localArrayList.add(localb);
        i += 1;
        break;
      } while (localb.category != 100);
      if (((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ech()) {}
      for (j = 1;; j = 0)
      {
        localb.Aam = j;
        if (localb.Aam <= 0) {
          break;
        }
        localb.Aao = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eci();
        break;
      }
      bool = false;
      break label244;
    }
  }
  
  public static void axL(String paramString)
  {
    AppMethodBeat.i(125887);
    paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
    g.agi().a(paramString.getType(), new d.4(paramString));
    g.agi().a(paramString, 0);
    AppMethodBeat.o(125887);
  }
  
  private static void b(dia paramdia, String paramString, long paramLong)
  {
    AppMethodBeat.i(125884);
    i.a(paramdia, paramString, paramLong);
    if (paramdia.FQV.size() != 0)
    {
      AppMethodBeat.o(125884);
      return;
    }
    dik localdik = new dik();
    localdik.name = paramString;
    localdik.timestamp = paramLong;
    paramdia.FQV.add(localdik);
    AppMethodBeat.o(125884);
  }
  
  public static final String bp(String paramString, long paramLong)
  {
    AppMethodBeat.i(125879);
    paramString = paramString + "_" + paramLong;
    AppMethodBeat.o(125879);
    return paramString;
  }
  
  public static final void c(dia paramdia, String paramString, long paramLong)
  {
    AppMethodBeat.i(125885);
    i.a(paramdia, paramString, paramLong);
    if (paramdia.FQV.size() > 0)
    {
      dik localdik = new dik();
      localdik.name = paramString;
      localdik.timestamp = paramLong;
      paramdia.FQV.add(localdik);
    }
    AppMethodBeat.o(125885);
  }
  
  public static int ecJ()
  {
    AppMethodBeat.i(125875);
    if (g.agR().agA().getInt(ah.a.GRU, 1) == 1)
    {
      int i = g.agR().agA().getInt(ah.a.GRT, 0);
      AppMethodBeat.o(125875);
      return i;
    }
    AppMethodBeat.o(125875);
    return 100;
  }
  
  private static boolean ecK()
  {
    AppMethodBeat.i(125881);
    vz localvz = new vz();
    localvz.dyP.actionType = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localvz);
    boolean bool = localvz.dyQ.dyR;
    AppMethodBeat.o(125881);
    return bool;
  }
  
  private static void ecL()
  {
    AppMethodBeat.i(125882);
    vz localvz = new vz();
    localvz.dyP.actionType = 2;
    com.tencent.mm.sdk.b.a.GpY.l(localvz);
    AppMethodBeat.o(125882);
  }
  
  public static final String ecM()
  {
    AppMethodBeat.i(125883);
    vz localvz = new vz();
    localvz.dyP.actionType = 3;
    com.tencent.mm.sdk.b.a.GpY.l(localvz);
    String str = "";
    if (localvz.dyQ.dyS != null) {
      str = localvz.dyQ.dyS.qox;
    }
    if (bs.isNullOrNil(str))
    {
      str = UUID.randomUUID().toString();
      AppMethodBeat.o(125883);
      return str;
    }
    AppMethodBeat.o(125883);
    return str;
  }
  
  public static void gv(Context paramContext)
  {
    AppMethodBeat.i(125888);
    com.tencent.mm.plugin.websearch.api.ai.p("", 0, 0, 100);
    z.d(paramContext, ".ui.home.TopStorySettingUI", new Intent());
    AppMethodBeat.o(125888);
  }
  
  public static final class b
  {
    public boolean Aak;
    public String Aal = "";
    public int Aam = 0;
    public int Aan = 0;
    public String Aao = "";
    public String Aap = "";
    public TextView Aaq;
    public View Aar;
    public int category = 0;
    public String dlQ = "";
    public TextView titleTv;
    public TabLayout.f tq;
    public View tvN;
    
    public final void cc(int paramInt, String paramString)
    {
      AppMethodBeat.i(125870);
      this.Aan = paramInt;
      this.Aap = paramString;
      if (this.Aan <= 0)
      {
        this.Aaq.setText("");
        this.Aaq.setVisibility(4);
        if (this.Aam > 0)
        {
          cd(this.Aam, this.Aao);
          AppMethodBeat.o(125870);
        }
      }
      else
      {
        paramString = this.Aan;
        if (this.Aan > 99) {
          paramString = "99+";
        }
        this.Aaq.setText(paramString);
        this.Aaq.setVisibility(0);
        this.Aar.setVisibility(8);
      }
      AppMethodBeat.o(125870);
    }
    
    public final void cd(int paramInt, String paramString)
    {
      AppMethodBeat.i(125871);
      this.Aam = paramInt;
      this.Aao = paramString;
      if (paramInt > 0)
      {
        if (this.Aan <= 0)
        {
          this.Aaq.setVisibility(4);
          this.Aar.setVisibility(0);
          AppMethodBeat.o(125871);
        }
      }
      else {
        this.Aar.setVisibility(8);
      }
      AppMethodBeat.o(125871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */