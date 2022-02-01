package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
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

public final class aa
{
  private static Map<Integer, am> AGp;
  private static int AGq;
  
  static
  {
    AppMethodBeat.i(117705);
    HashMap localHashMap = new HashMap();
    AGp = localHashMap;
    localHashMap.put(Integer.valueOf(3), new am("wxa/template", "wxa_template.zip", "wxa"));
    AGp.put(Integer.valueOf(1), new am("topstory/template", "wrd_template.zip", "topstory"));
    AGp.put(Integer.valueOf(0), new am("websearch/template", "fts_template.zip", "websearch"));
    AGp.put(Integer.valueOf(2), new am("box/template", "box_template.zip", "box"));
    AGp.put(Integer.valueOf(4), new am("scan_goods/template", "scan_goods_template.zip", "scan_goods"));
    AGp.put(Integer.valueOf(5), new am("pardus/template", "pardus_template.zip", "pardus"));
    AppMethodBeat.o(117705);
  }
  
  public static final String RY(int paramInt)
  {
    AppMethodBeat.i(117661);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    g.afz();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(117661);
    return localObject;
  }
  
  public static am RZ(int paramInt)
  {
    AppMethodBeat.i(117662);
    am localam = (am)AGp.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(117662);
    return localam;
  }
  
  public static Properties S(com.tencent.mm.vfs.e parame)
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
      parame = i.ah(parame);
      locale = parame;
      localObject = parame;
      localProperties.load(parame);
      bt.d(parame);
    }
    catch (Exception parame)
    {
      for (;;)
      {
        localObject = locale;
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", parame, "", new Object[0]);
        bt.d(locale);
      }
    }
    finally
    {
      bt.d((Closeable)localObject);
      AppMethodBeat.o(117660);
    }
    AppMethodBeat.o(117660);
    return localProperties;
  }
  
  public static boolean Sa(int paramInt)
  {
    AppMethodBeat.i(117664);
    ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((am)AGp.get(Integer.valueOf(paramInt))).axp() > 1)
    {
      AppMethodBeat.o(117664);
      return true;
    }
    AppMethodBeat.o(117664);
    return false;
  }
  
  public static int Sb(int paramInt)
  {
    AppMethodBeat.i(117665);
    paramInt = ((am)AGp.get(Integer.valueOf(paramInt))).axp();
    AppMethodBeat.o(117665);
    return paramInt;
  }
  
  public static void Sc(int paramInt)
  {
    AGq = paramInt;
  }
  
  public static String Sd(int paramInt)
  {
    AppMethodBeat.i(117667);
    String str = ((am)AGp.get(Integer.valueOf(paramInt))).eil();
    AppMethodBeat.o(117667);
    return str;
  }
  
  public static String Se(int paramInt)
  {
    AppMethodBeat.i(117668);
    String str = S(new com.tencent.mm.vfs.e(((am)AGp.get(Integer.valueOf(paramInt))).eil(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(117668);
    return str;
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(117700);
    paramMap = w(paramMap, paramString);
    if (bt.isNullOrNil(paramMap))
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
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext()));
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
      paramString1 = String.valueOf(Sb(0));
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
      ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
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
      float f2 = com.tencent.mm.cd.a.dT(aj.getContext());
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
      localHashMap.put("netType", cWN());
      if (com.tencent.mm.az.a.azF())
      {
        paramString1 = com.tencent.mm.az.a.azI();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.hnp);
        }
      }
      AppMethodBeat.o(117673);
      return localHashMap;
      paramString1 = String.valueOf(Sb(1));
      break;
      paramString1 = ac.ave("mixGlobal");
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
            if (ac.ave("bizTab").optInt("bizSugSwitch", 0) == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (paramInt2 == 2)
          {
            bool1 = bool2;
            if (ac.ave("articleTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool3 = bool1;
          bool2 = bool5;
          if (paramInt2 == 8)
          {
            paramString1 = ac.ave("snsTab");
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
              if (ac.ave("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                bool1 = true;
              }
            }
          }
          bool3 = bool4;
          if (paramInt2 == 1)
          {
            bool3 = bool4;
            if (ac.ave("bizTab").optInt("mfsBizSwitch", 0) == 1) {
              bool3 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 1024)
          {
            bool4 = bool1;
            if (ac.ave("novelTab").optInt("sugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
          bool1 = bool4;
          if (paramInt2 == 512)
          {
            bool1 = bool4;
            if (ac.ave("musicTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 384)
          {
            bool4 = bool1;
            if (ac.ave("emotionTab").optInt("sugSwitch", 0) == 1) {
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
          if (ac.ave("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
            break;
          }
          bool1 = true;
          bool5 = bool3;
          bool6 = bool2;
          break;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ac.ave("bizEntry").optInt("sugSwitch") != 1) {
            break;
          }
          continue;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ac.ave("bizUnionTopEntry").optInt("sugSwitch") != 1) {
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
          if (ac.ave("emoticonMall").optInt("sugSwitch", 0) == 1)
          {
            bool1 = true;
            bool5 = bool3;
            bool6 = bool2;
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, dcy paramdcy, int paramInt)
  {
    AppMethodBeat.i(117703);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdcy.toByteArray());
      label26:
      if (uW(paramdcy.Euy))
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
  
  public static void a(Context paramContext, dcy paramdcy)
  {
    AppMethodBeat.i(117704);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdcy.toByteArray());
      label26:
      if (uW(paramdcy.Euy))
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
      ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      AppMethodBeat.o(117679);
      return;
    }
    Intent localIntent = aP(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = RY(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = RY(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!bt.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", f(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        AppMethodBeat.o(117679);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(117693);
    oj localoj = new oj();
    localoj.dtv.query = paramString4;
    localoj.dtv.sessionId = paramString2;
    localoj.dtv.dtw = paramString3;
    localoj.dtv.scene = paramInt1;
    localoj.dtv.dtx = paramString1;
    localoj.dtv.dtz = paramString5;
    localoj.dtv.dtA = paramInt2;
    localoj.dtv.dty = paramString6;
    com.tencent.mm.sdk.b.a.ESL.l(localoj);
    AppMethodBeat.o(117693);
  }
  
  private static Intent aP(Intent paramIntent)
  {
    AppMethodBeat.i(117671);
    if (paramIntent == null)
    {
      AppMethodBeat.o(117671);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(117671);
    return paramIntent;
  }
  
  public static String aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(204989);
    paramMap = f(paramMap, 0);
    AppMethodBeat.o(204989);
    return paramMap;
  }
  
  public static String aS(Map<String, ? extends Object> paramMap)
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
  
  public static long avb(String paramString)
  {
    AppMethodBeat.i(117690);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(117690);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(117690);
    return l;
  }
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117702);
    try
    {
      String str2 = aj.eFC() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(aj.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      }
      AppMethodBeat.o(117702);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117702);
    }
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117689);
    paramIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = f(paramInt, false, 384);
    String str = RY(bt.aGh((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", f(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(117689);
  }
  
  public static ble bCk()
  {
    AppMethodBeat.i(117670);
    try
    {
      Object localObject = (String)g.afB().afk().get(67591, null);
      if (localObject != null)
      {
        ble localble = new ble();
        localObject = ((String)localObject).split(",");
        localble.DfE = Integer.valueOf(localObject[0]).intValue();
        localble.DfH = Integer.valueOf(localObject[1]).intValue();
        localble.COJ = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localble.COI = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localble.COJ), Float.valueOf(localble.COI) });
        AppMethodBeat.o(117670);
        return localble;
      }
      ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(117670);
      return null;
    }
    catch (Exception localException)
    {
      ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(117670);
    }
    return null;
  }
  
  public static String cWN()
  {
    AppMethodBeat.i(117669);
    if (ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(117669);
      return "wifi";
    }
    if (ay.is4G(aj.getContext()))
    {
      AppMethodBeat.o(117669);
      return "4g";
    }
    if (ay.is3G(aj.getContext()))
    {
      AppMethodBeat.o(117669);
      return "3g";
    }
    if (ay.is2G(aj.getContext()))
    {
      AppMethodBeat.o(117669);
      return "2g";
    }
    if (!ay.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(117669);
      return "fail";
    }
    AppMethodBeat.o(117669);
    return "";
  }
  
  public static void cj(int paramInt, final String paramString)
  {
    AppMethodBeat.i(190952);
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117659);
        String str = aa.ck(this.fpl, paramString);
        if (!TextUtils.isEmpty(str)) {
          ag.eic().t(str, 5, false);
        }
        AppMethodBeat.o(117659);
      }
    });
    AppMethodBeat.o(190952);
  }
  
  public static String ck(int paramInt, String paramString)
  {
    AppMethodBeat.i(117686);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    localHashMap.put("type", "64");
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.ac.ir(aj.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(((am)AGp.get(Integer.valueOf(3))).axp()));
    localHashMap.put("isHomePage", "0");
    localHashMap.put("isSug", "1");
    localHashMap.put("netType", cWN());
    localHashMap.put("WASessionId", paramString);
    localHashMap.put("sessionId", paramString);
    localHashMap.put("subSessionId", paramString);
    localHashMap.put("isPreload", "1");
    paramString = f(localHashMap, 3);
    AppMethodBeat.o(117686);
    return paramString;
  }
  
  public static void cl(int paramInt, String paramString)
  {
    AppMethodBeat.i(190954);
    ok localok = new ok();
    localok.dtB.scene = paramInt;
    localok.dtB.sessionId = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localok);
    AppMethodBeat.o(190954);
  }
  
  public static int d(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(117699);
    paramMap = w(paramMap, paramString);
    if (bt.isNullOrNil(paramMap))
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
      String str2 = aj.eFC() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(aj.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117701);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(117701);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117701);
    }
  }
  
  public static int ehP()
  {
    AppMethodBeat.i(117663);
    Object localObject4 = ((am)AGp.get(Integer.valueOf(1))).eim();
    AssetManager localAssetManager = aj.getContext().getAssets();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = localAssetManager.open((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      bt.d((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
        bt.d(localObject1);
      }
    }
    finally
    {
      bt.d(localObject3);
      AppMethodBeat.o(117663);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117663);
    return i;
  }
  
  public static int ehQ()
  {
    return AGq;
  }
  
  public static String ehR()
  {
    AppMethodBeat.i(117666);
    Object localObject = (am)AGp.get(Integer.valueOf(0));
    localObject = q.B(new com.tencent.mm.vfs.e(((am)localObject).eil(), ((am)localObject).AHs).fhU());
    AppMethodBeat.o(117666);
    return localObject;
  }
  
  public static Intent ehS()
  {
    AppMethodBeat.i(117672);
    Intent localIntent = aP(new Intent());
    AppMethodBeat.o(117672);
    return localIntent;
  }
  
  public static void ehT()
  {
    AppMethodBeat.i(117680);
    f(0L, false, true);
    AppMethodBeat.o(117680);
  }
  
  public static void ehU()
  {
    AppMethodBeat.i(117682);
    f(0L, false, false);
    AppMethodBeat.o(117682);
  }
  
  public static void ehV()
  {
    AppMethodBeat.i(184552);
    f(0L, true, true);
    AppMethodBeat.o(184552);
  }
  
  public static boolean ehW()
  {
    AppMethodBeat.i(117692);
    JSONObject localJSONObject = ac.ave("snsContactMatch");
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
  
  public static int ehX()
  {
    AppMethodBeat.i(117695);
    JSONObject localJSONObject = ac.ave("snsContactMatch");
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
    Object localObject = RZ(paramInt).eil();
    paramMap.put("isOpenPreload", "1");
    localStringBuffer.append((String)localObject);
    if (paramMap.size() > 0)
    {
      localObject = localStringBuffer.append("/");
      RZ(paramInt);
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
        localObject = RY(bt.aGh((String)paramMap.get("scene")));
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
      localStringBuffer.append(com.tencent.mm.protocal.d.CpK);
      localStringBuffer.append("&");
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(117688);
      return paramMap;
    }
    paramMap = localStringBuffer.append("/");
    RZ(paramInt);
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
  
  private static void f(long paramLong, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184553);
    g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117658);
        String str = aa.tc(this.AFu);
        if (!TextUtils.isEmpty(str)) {
          ag.eic().t(str, 4, paramBoolean1);
        }
        AppMethodBeat.o(117658);
      }
    }, paramLong);
    AppMethodBeat.o(184553);
  }
  
  /* Error */
  public static boolean n(Activity paramActivity, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 980
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 982
    //   10: invokestatic 988	android/support/v4/content/b:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +59 -> 74
    //   18: getstatic 994	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
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
    //   42: invokevirtual 997	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   45: ldc_w 980
    //   48: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 170
    //   56: aload_0
    //   57: ldc 172
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 178	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 980
    //   69: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_1
    //   73: ireturn
    //   74: getstatic 994	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
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
    //   98: invokevirtual 997	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ldc_w 982
    //   105: invokestatic 1002	android/support/v4/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 170
    //   113: ldc_w 1004
    //   116: invokestatic 1006	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 980
    //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 170
    //   129: ldc_w 1008
    //   132: invokestatic 1006	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 275	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 982
    //   145: aastore
    //   146: bipush 73
    //   148: invokestatic 1011	android/support/v4/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   151: ldc_w 980
    //   154: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 170
    //   162: aload_0
    //   163: ldc 172
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 178	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static String tc(boolean paramBoolean)
  {
    AppMethodBeat.i(117684);
    String str = RY(-1);
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
  
  public static void uU(long paramLong)
  {
    AppMethodBeat.i(117681);
    f(paramLong, false, true);
    AppMethodBeat.o(117681);
  }
  
  public static boolean uV(long paramLong)
  {
    AppMethodBeat.i(117691);
    ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.afB().afk().set(ae.a.Ftg, Long.valueOf(paramLong));
    AppMethodBeat.o(117691);
    return false;
  }
  
  private static boolean uW(long paramLong)
  {
    return paramLong == 100203L;
  }
  
  public static String w(Map<String, Object> paramMap, String paramString)
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
  
  public static boolean x(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117698);
    paramMap = w(paramMap, paramString);
    if (bt.isNullOrNil(paramMap))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */