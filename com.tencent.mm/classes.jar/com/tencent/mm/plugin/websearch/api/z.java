package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.q;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public final class z
{
  private static Map<Integer, ak> BYH;
  private static int BYI;
  
  static
  {
    AppMethodBeat.i(117705);
    HashMap localHashMap = new HashMap();
    BYH = localHashMap;
    localHashMap.put(Integer.valueOf(3), new ak("wxa/template", "wxa_template.zip", "wxa"));
    BYH.put(Integer.valueOf(1), new ak("topstory/template", "wrd_template.zip", "topstory"));
    BYH.put(Integer.valueOf(0), new ak("websearch/template", "fts_template.zip", "websearch"));
    BYH.put(Integer.valueOf(2), new ak("box/template", "box_template.zip", "box"));
    BYH.put(Integer.valueOf(4), new ak("scan_goods/template", "scan_goods_template.zip", "scan_goods"));
    BYH.put(Integer.valueOf(5), new ak("pardus/template", "pardus_template.zip", "pardus"));
    AppMethodBeat.o(117705);
  }
  
  private static void O(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(210473);
    h.JZN.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117658);
        if (c.ghj())
        {
          AppMethodBeat.o(117658);
          return;
        }
        String str = z.ud(this.BXN);
        if (!TextUtils.isEmpty(str)) {
          ae.exw().t(str, 4, this.BYJ);
        }
        AppMethodBeat.o(117658);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(210473);
  }
  
  public static Properties R(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(117660);
    Properties localProperties = new Properties();
    if ((parame != null) && (parame.isFile()))
    {
      localObject = null;
      locale = null;
    }
    try
    {
      parame = com.tencent.mm.vfs.i.ag(parame);
      locale = parame;
      localObject = parame;
      localProperties.load(parame);
      bs.d(parame);
    }
    catch (Exception parame)
    {
      for (;;)
      {
        localObject = locale;
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", parame, "", new Object[0]);
        bs.d(locale);
      }
    }
    finally
    {
      bs.d((Closeable)localObject);
      AppMethodBeat.o(117660);
    }
    AppMethodBeat.o(117660);
    return localProperties;
  }
  
  public static final String Ui(int paramInt)
  {
    AppMethodBeat.i(117661);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    g.agP();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(117661);
    return localObject;
  }
  
  public static ak Uj(int paramInt)
  {
    AppMethodBeat.i(117662);
    ak localak = (ak)BYH.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(117662);
    return localak;
  }
  
  public static boolean Uk(int paramInt)
  {
    AppMethodBeat.i(117664);
    ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((ak)BYH.get(Integer.valueOf(paramInt))).aEh() > 1)
    {
      AppMethodBeat.o(117664);
      return true;
    }
    AppMethodBeat.o(117664);
    return false;
  }
  
  public static int Ul(int paramInt)
  {
    AppMethodBeat.i(117665);
    paramInt = ((ak)BYH.get(Integer.valueOf(paramInt))).aEh();
    AppMethodBeat.o(117665);
    return paramInt;
  }
  
  public static void Um(int paramInt)
  {
    BYI = paramInt;
  }
  
  public static String Un(int paramInt)
  {
    AppMethodBeat.i(117667);
    String str = ((ak)BYH.get(Integer.valueOf(paramInt))).exF();
    AppMethodBeat.o(117667);
    return str;
  }
  
  public static String Uo(int paramInt)
  {
    AppMethodBeat.i(117668);
    String str = R(new com.tencent.mm.vfs.e(((ak)BYH.get(Integer.valueOf(paramInt))).exF(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(117668);
    return str;
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(117700);
    paramMap = x(paramMap, paramString);
    if (bs.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(117700);
      return paramLong;
    }
    try
    {
      long l = Long.valueOf(paramMap).longValue();
      AppMethodBeat.o(117700);
      return l;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(117700);
    }
    return paramLong;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117675);
    paramString = a(paramInt1, paramBoolean, paramInt2, paramString, "");
    AppMethodBeat.o(117675);
    return paramString;
  }
  
  private static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(117676);
    paramString1 = a(paramInt1, paramBoolean, paramInt2, paramString1, "", "", "", "", "", paramString2);
    AppMethodBeat.o(117676);
    return paramString1;
  }
  
  private static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(117677);
    paramString1 = a(paramInt1, paramBoolean, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "");
    AppMethodBeat.o(117677);
    return paramString1;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(117673);
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("searchId", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("sessionId", paramString3);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localHashMap.put("subSessionId", paramString6);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("query", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("sceneActionType", paramString5);
    }
    if (!TextUtils.isEmpty(paramString8)) {
      localHashMap.put("pRequestId", paramString8);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", String.valueOf(paramInt2));
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.ab.iC(ai.getContext()));
    localHashMap.put("platform", "android");
    if (!TextUtils.isEmpty(paramString7)) {
      localHashMap.put("poiInfo", paramString7);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("extParams", paramString1);
    }
    boolean bool1;
    boolean bool7;
    boolean bool5;
    boolean bool2;
    boolean bool4;
    boolean bool3;
    boolean bool6;
    switch (paramInt1)
    {
    default: 
      paramString1 = String.valueOf(Ul(0));
      localHashMap.put("version", paramString1);
      bool1 = false;
      bool7 = false;
      bool5 = false;
      bool2 = false;
      bool4 = false;
      bool3 = false;
      switch (paramInt1)
      {
      default: 
        bool6 = bool2;
        bool5 = bool3;
        bool1 = bool7;
      }
      break;
    }
    for (;;)
    {
      ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
      if (bool1) {
        localHashMap.put("isSug", "1");
      }
      if (bool6) {
        localHashMap.put("isLocalSug", "1");
      }
      if (bool5) {
        localHashMap.put("isMostSearchBiz", "1");
      }
      if (paramBoolean) {
        localHashMap.put("isHomePage", "1");
      }
      float f2 = com.tencent.mm.cc.a.eb(ai.getContext());
      float f1 = f2;
      if (f2 != 1.0F)
      {
        f1 = f2;
        if (f2 != 0.8F)
        {
          f1 = f2;
          if (f2 != 1.1F)
          {
            f1 = f2;
            if (f2 != 1.12F)
            {
              f1 = f2;
              if (f2 != 1.125F)
              {
                f1 = f2;
                if (f2 != 1.4F)
                {
                  f1 = f2;
                  if (f2 != 1.55F)
                  {
                    f1 = f2;
                    if (f2 != 1.65F) {
                      f1 = 1.0F;
                    }
                  }
                }
              }
            }
          }
        }
      }
      localHashMap.put("fontRatio", String.valueOf(f1));
      localHashMap.put("netType", dkv());
      if (com.tencent.mm.ay.a.aGv())
      {
        paramString1 = com.tencent.mm.ay.a.aGy();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.hNS);
        }
      }
      AppMethodBeat.o(117673);
      return localHashMap;
      paramString1 = String.valueOf(Ul(1));
      break;
      paramString1 = ab.aAv("mixGlobal");
      if (paramBoolean)
      {
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (paramString1.optInt("mixSugSwitch", 0) != 1) {}
      }
      else
      {
        for (;;)
        {
          bool1 = true;
          bool5 = bool3;
          bool6 = bool2;
          break;
          if (paramInt2 == 1)
          {
            bool1 = bool7;
            bool5 = bool3;
            bool6 = bool2;
            if (paramString1.optInt("bizSugSwitch", 0) != 1) {
              break;
            }
            continue;
          }
          if (paramInt2 == 8)
          {
            bool1 = bool7;
            bool5 = bool3;
            bool6 = bool2;
            if (paramString1.optInt("snsSugSwitch", 0) != 1) {
              break;
            }
            continue;
          }
          if (paramInt2 == 1024)
          {
            bool1 = bool7;
            bool5 = bool3;
            bool6 = bool2;
            if (paramString1.optInt("novelSugSwitch", 0) != 1) {
              break;
            }
            continue;
          }
          if (paramInt2 == 512)
          {
            bool1 = bool7;
            bool5 = bool3;
            bool6 = bool2;
            if (paramString1.optInt("musicSugSwitch", 0) != 1) {
              break;
            }
            continue;
          }
          if ((paramInt2 != 384) && (paramInt2 != 256))
          {
            bool1 = bool7;
            bool5 = bool3;
            bool6 = bool2;
            if (paramInt2 != 128) {
              break;
            }
          }
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (paramString1.optInt("emotionSugSwitch", 0) != 1) {
            break;
          }
          continue;
          bool2 = bool1;
          if (paramInt2 == 1)
          {
            bool2 = bool1;
            if (ab.aAv("bizTab").optInt("bizSugSwitch", 0) == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (paramInt2 == 2)
          {
            bool1 = bool2;
            if (ab.aAv("articleTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool3 = bool1;
          bool2 = bool5;
          if (paramInt2 == 8)
          {
            paramString1 = ab.aAv("snsTab");
            if (paramString1.optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
            bool3 = bool1;
            bool2 = bool5;
            if (paramString1.optInt("localSugSwitch", 0) == 1)
            {
              bool2 = true;
              bool3 = bool1;
            }
          }
          bool1 = bool3;
          if (!paramBoolean)
          {
            bool1 = bool3;
            if (paramInt2 == 4)
            {
              bool1 = bool3;
              if (ab.aAv("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                bool1 = true;
              }
            }
          }
          bool3 = bool4;
          if (paramInt2 == 1)
          {
            bool3 = bool4;
            if (ab.aAv("bizTab").optInt("mfsBizSwitch", 0) == 1) {
              bool3 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 1024)
          {
            bool4 = bool1;
            if (ab.aAv("novelTab").optInt("sugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
          bool1 = bool4;
          if (paramInt2 == 512)
          {
            bool1 = bool4;
            if (ab.aAv("musicTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 384)
          {
            bool4 = bool1;
            if (ab.aAv("emotionTab").optInt("sugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
          bool1 = bool4;
          bool5 = bool3;
          bool6 = bool2;
          if (paramInt2 != 0) {
            break;
          }
          bool1 = bool4;
          bool5 = bool3;
          bool6 = bool2;
          if (!paramBoolean) {
            break;
          }
          bool1 = bool4;
          bool5 = bool3;
          bool6 = bool2;
          if (ab.aAv("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
            break;
          }
          bool1 = true;
          bool5 = bool3;
          bool6 = bool2;
          break;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ab.aAv("bizEntry").optInt("sugSwitch") != 1) {
            break;
          }
          continue;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ab.aAv("bizUnionTopEntry").optInt("sugSwitch") != 1) {
            break;
          }
        }
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (paramInt2 == 384)
        {
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ab.aAv("emoticonMall").optInt("sugSwitch", 0) == 1)
          {
            bool1 = true;
            bool5 = bool3;
            bool6 = bool2;
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, dil paramdil, int paramInt)
  {
    AppMethodBeat.i(117703);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdil.toByteArray());
      label26:
      if (zz(paramdil.FRz))
      {
        b(paramActivity, ".ui.video.fs.TopStoryFSVideoUI", localIntent, paramInt);
        AppMethodBeat.o(117703);
        return;
      }
      b(paramActivity, ".ui.video.list.TopStoryListVideoUI", localIntent, paramInt);
      AppMethodBeat.o(117703);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public static void a(Context paramContext, dil paramdil)
  {
    AppMethodBeat.i(117704);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdil.toByteArray());
      label26:
      if (zz(paramdil.FRz))
      {
        d(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        AppMethodBeat.o(117704);
        return;
      }
      d(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent);
      AppMethodBeat.o(117704);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(117679);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      AppMethodBeat.o(117679);
      return;
    }
    Intent localIntent = aR(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = Ui(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = Ui(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!bs.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", f(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        AppMethodBeat.o(117679);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(117693);
    os localos = new os();
    localos.dre.query = paramString4;
    localos.dre.sessionId = paramString2;
    localos.dre.drf = paramString3;
    localos.dre.scene = paramInt1;
    localos.dre.drg = paramString1;
    localos.dre.dri = paramString5;
    localos.dre.drj = paramInt2;
    localos.dre.drh = paramString6;
    com.tencent.mm.sdk.b.a.GpY.l(localos);
    AppMethodBeat.o(117693);
  }
  
  public static long aAs(String paramString)
  {
    AppMethodBeat.i(117690);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(117690);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(117690);
    return l;
  }
  
  private static Intent aR(Intent paramIntent)
  {
    AppMethodBeat.i(117671);
    if (paramIntent == null)
    {
      AppMethodBeat.o(117671);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(117671);
    return paramIntent;
  }
  
  public static String aV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(210476);
    paramMap = f(paramMap, 0);
    AppMethodBeat.o(210476);
    return paramMap;
  }
  
  public static String aW(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(117696);
    StringBuffer localStringBuffer = new StringBuffer();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      if (localEntry.getValue() != null) {
        localStringBuffer.append(localEntry.getValue().toString());
      }
      localStringBuffer.append("&");
    }
    paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1).toString();
    AppMethodBeat.o(117696);
    return paramMap;
  }
  
  public static void b(Context paramContext, dil paramdil)
  {
    AppMethodBeat.i(207476);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdil.toByteArray());
      label26:
      if (zz(paramdil.FRz))
      {
        b(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent, 1);
        AppMethodBeat.o(207476);
        return;
      }
      b(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent, 1);
      AppMethodBeat.o(207476);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117702);
    try
    {
      String str2 = ai.eUW() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ai.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      }
      AppMethodBeat.o(117702);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117702);
    }
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117689);
    paramIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = f(paramInt, false, 384);
    String str = Ui(bs.aLy((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", f(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(117689);
  }
  
  public static bpa bJn()
  {
    AppMethodBeat.i(117670);
    try
    {
      Object localObject = (String)g.agR().agA().get(67591, null);
      if (localObject != null)
      {
        bpa localbpa = new bpa();
        localObject = ((String)localObject).split(",");
        localbpa.EyK = Integer.valueOf(localObject[0]).intValue();
        localbpa.EyN = Integer.valueOf(localObject[1]).intValue();
        localbpa.Ehu = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localbpa.Eht = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localbpa.Ehu), Float.valueOf(localbpa.Eht) });
        AppMethodBeat.o(117670);
        return localbpa;
      }
      ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(117670);
      return null;
    }
    catch (Exception localException)
    {
      ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(117670);
    }
    return null;
  }
  
  public static void co(int paramInt, String paramString)
  {
    AppMethodBeat.i(207475);
    ot localot = new ot();
    localot.drk.scene = paramInt;
    localot.drk.sessionId = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localot);
    AppMethodBeat.o(207475);
  }
  
  public static int d(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(117699);
    paramMap = x(paramMap, paramString);
    if (bs.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(117699);
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramMap).intValue();
      AppMethodBeat.o(117699);
      return i;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(117699);
    }
    return paramInt;
  }
  
  public static void d(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(117701);
    try
    {
      String str2 = ai.eUW() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ai.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117701);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(117701);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117701);
    }
  }
  
  public static String dkv()
  {
    AppMethodBeat.i(117669);
    if (ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(117669);
      return "wifi";
    }
    if (ax.is4G(ai.getContext()))
    {
      AppMethodBeat.o(117669);
      return "4g";
    }
    if (ax.is3G(ai.getContext()))
    {
      AppMethodBeat.o(117669);
      return "3g";
    }
    if (ax.is2G(ai.getContext()))
    {
      AppMethodBeat.o(117669);
      return "2g";
    }
    if (!ax.isConnected(ai.getContext()))
    {
      AppMethodBeat.o(117669);
      return "fail";
    }
    AppMethodBeat.o(117669);
    return "";
  }
  
  public static String eWH()
  {
    AppMethodBeat.i(210475);
    Object localObject = new HashMap();
    ((Map)localObject).put("scene", "-1");
    ((Map)localObject).put("type", "64");
    ((Map)localObject).put("lang", com.tencent.mm.sdk.platformtools.ab.iC(ai.getContext()));
    ((Map)localObject).put("platform", "android");
    ((Map)localObject).put("version", String.valueOf(((ak)BYH.get(Integer.valueOf(3))).aEh()));
    ((Map)localObject).put("isHomePage", "0");
    ((Map)localObject).put("isSug", "1");
    ((Map)localObject).put("netType", dkv());
    ((Map)localObject).put("WASessionId", "");
    ((Map)localObject).put("sessionId", "");
    ((Map)localObject).put("subSessionId", "");
    ((Map)localObject).put("isPreload", "1");
    localObject = f((Map)localObject, 3);
    AppMethodBeat.o(210475);
    return localObject;
  }
  
  public static int exj()
  {
    AppMethodBeat.i(117663);
    Object localObject4 = ((ak)BYH.get(Integer.valueOf(1))).exG();
    AssetManager localAssetManager = ai.getContext().getAssets();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = localAssetManager.open((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      bs.d((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
        bs.d(localObject1);
      }
    }
    finally
    {
      bs.d(localObject3);
      AppMethodBeat.o(117663);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117663);
    return i;
  }
  
  public static int exk()
  {
    return BYI;
  }
  
  public static String exl()
  {
    AppMethodBeat.i(117666);
    Object localObject = (ak)BYH.get(Integer.valueOf(0));
    localObject = q.B(new com.tencent.mm.vfs.e(((ak)localObject).exF(), ((ak)localObject).BZJ).fxV());
    AppMethodBeat.o(117666);
    return localObject;
  }
  
  public static Intent exm()
  {
    AppMethodBeat.i(117672);
    Intent localIntent = aR(new Intent());
    AppMethodBeat.o(117672);
    return localIntent;
  }
  
  public static void exn()
  {
    AppMethodBeat.i(117680);
    O(0L, false);
    AppMethodBeat.o(117680);
  }
  
  public static void exp()
  {
    AppMethodBeat.i(184552);
    O(0L, true);
    AppMethodBeat.o(184552);
  }
  
  public static boolean exq()
  {
    AppMethodBeat.i(117692);
    JSONObject localJSONObject = ab.aAv("snsContactMatch");
    if (localJSONObject != null)
    {
      if (localJSONObject.optInt("matchSwitch") == 1)
      {
        AppMethodBeat.o(117692);
        return true;
      }
      AppMethodBeat.o(117692);
      return false;
    }
    AppMethodBeat.o(117692);
    return false;
  }
  
  public static int exr()
  {
    AppMethodBeat.i(117695);
    JSONObject localJSONObject = ab.aAv("snsContactMatch");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("queryUtfLenLimit");
      AppMethodBeat.o(117695);
      return i;
    }
    AppMethodBeat.o(117695);
    return 0;
  }
  
  public static String f(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(117688);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject = Uj(paramInt).exF();
    paramMap.put("isOpenPreload", "1");
    localStringBuffer.append((String)localObject);
    if (paramMap.size() > 0)
    {
      localObject = localStringBuffer.append("/");
      Uj(paramInt);
      ((StringBuffer)localObject).append("app.html?");
      localObject = paramMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)localEntry.getValue());
        localStringBuffer.append("&");
      }
      localObject = (String)paramMap.get("sessionId");
      if (!paramMap.containsKey("sessionId"))
      {
        localObject = Ui(bs.aLy((String)paramMap.get("scene")));
        localStringBuffer.append("sessionId");
        localStringBuffer.append("=");
        localStringBuffer.append((String)localObject);
        localStringBuffer.append("&");
      }
      if (!paramMap.containsKey("subSessionId"))
      {
        localStringBuffer.append("subSessionId");
        localStringBuffer.append("=");
        localStringBuffer.append((String)localObject);
        localStringBuffer.append("&");
      }
      localStringBuffer.append("wechatVersion");
      localStringBuffer.append("=");
      localStringBuffer.append(com.tencent.mm.protocal.d.DIc);
      localStringBuffer.append("&");
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(117688);
      return paramMap;
    }
    paramMap = localStringBuffer.append("/");
    Uj(paramInt);
    paramMap.append("app.html");
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(117688);
    return paramMap;
  }
  
  public static Map<String, String> f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117674);
    Map localMap = a(paramInt1, paramBoolean, paramInt2, "");
    AppMethodBeat.o(117674);
    return localMap;
  }
  
  /* Error */
  public static boolean n(Activity paramActivity, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 976
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 978
    //   10: invokestatic 984	android/support/v4/content/b:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +59 -> 74
    //   18: getstatic 990	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   21: sipush 15104
    //   24: iconst_2
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: iload_1
    //   31: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: iconst_2
    //   38: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokevirtual 993	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   45: ldc_w 976
    //   48: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 138
    //   56: aload_0
    //   57: ldc 140
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 976
    //   69: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_1
    //   73: ireturn
    //   74: getstatic 990	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   77: sipush 15104
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: iload_1
    //   87: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iconst_1
    //   94: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokevirtual 993	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ldc_w 978
    //   105: invokestatic 998	android/support/v4/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 138
    //   113: ldc_w 1000
    //   116: invokestatic 1003	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 976
    //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 138
    //   129: ldc_w 1005
    //   132: invokestatic 1003	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 294	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 978
    //   145: aastore
    //   146: bipush 73
    //   148: invokestatic 1008	android/support/v4/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   151: ldc_w 976
    //   154: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 138
    //   162: aload_0
    //   163: ldc 140
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: goto -21 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramActivity	Activity
    //   0	175	1	paramInt	int
    //   13	2	2	i	int
    // Exception table:
    //   from	to	target	type
    //   6	14	53	java/lang/Exception
    //   18	45	159	java/lang/Exception
    //   54	66	159	java/lang/Exception
    //   74	119	159	java/lang/Exception
    //   127	151	159	java/lang/Exception
  }
  
  public static void uT(long paramLong)
  {
    AppMethodBeat.i(210474);
    ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "preloadWxaSearch %s", new Object[] { Long.valueOf(paramLong) });
    h.JZN.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117659);
        if (c.ghj())
        {
          AppMethodBeat.o(117659);
          return;
        }
        String str = z.eWH();
        if (!TextUtils.isEmpty(str)) {
          ae.exw().t(str, 5, false);
        }
        AppMethodBeat.o(117659);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(210474);
  }
  
  public static String ud(boolean paramBoolean)
  {
    AppMethodBeat.i(117684);
    String str = Ui(-1);
    Map localMap = f(-1, paramBoolean, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    str = f(localMap, 0);
    AppMethodBeat.o(117684);
    return str;
  }
  
  public static String x(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117697);
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null)
      {
        paramMap = paramMap.get(paramString).toString();
        AppMethodBeat.o(117697);
        return paramMap;
      }
      AppMethodBeat.o(117697);
      return "";
    }
    AppMethodBeat.o(117697);
    return "";
  }
  
  public static boolean y(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117698);
    paramMap = x(paramMap, paramString);
    if (bs.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(117698);
      return false;
    }
    try
    {
      boolean bool = "1".equals(paramMap);
      if (bool)
      {
        AppMethodBeat.o(117698);
        return true;
      }
      bool = "0".equals(paramMap);
      if (bool)
      {
        AppMethodBeat.o(117698);
        return false;
      }
      bool = Boolean.valueOf(paramMap).booleanValue();
      AppMethodBeat.o(117698);
      return bool;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(117698);
    }
    return false;
  }
  
  public static void zx(long paramLong)
  {
    AppMethodBeat.i(117681);
    O(paramLong, false);
    AppMethodBeat.o(117681);
  }
  
  public static boolean zy(long paramLong)
  {
    AppMethodBeat.i(117691);
    ac.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.agR().agA().set(ah.a.GRa, Long.valueOf(paramLong));
    AppMethodBeat.o(117691);
    return false;
  }
  
  private static boolean zz(long paramLong)
  {
    return paramLong == 100203L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */