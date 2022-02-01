package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
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

public final class ad
{
  private static Map<Integer, ao> DBD;
  private static int DBE;
  
  static
  {
    AppMethodBeat.i(117705);
    HashMap localHashMap = new HashMap();
    DBD = localHashMap;
    localHashMap.put(Integer.valueOf(3), new ao("wxa/template", "wxa_template.zip", "wxa"));
    DBD.put(Integer.valueOf(1), new ao("topstory/template", "wrd_template.zip", "topstory"));
    DBD.put(Integer.valueOf(0), new ao("websearch/template", "fts_template.zip", "websearch"));
    DBD.put(Integer.valueOf(2), new ao("box/template", "box_template.zip", "box"));
    DBD.put(Integer.valueOf(4), new ao("scan_goods/template", "scan_goods_template.zip", "scan_goods"));
    DBD.put(Integer.valueOf(5), new ao("pardus/template", "pardus_template.zip", "pardus"));
    AppMethodBeat.o(117705);
  }
  
  public static boolean A(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117698);
    paramMap = z(paramMap, paramString);
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
  
  public static void Ck(long paramLong)
  {
    AppMethodBeat.i(117681);
    I(paramLong, false);
    AppMethodBeat.o(117681);
  }
  
  public static void Cl(long paramLong)
  {
    AppMethodBeat.i(217642);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "preloadWxaSearch %s", new Object[] { Long.valueOf(paramLong) });
    h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117659);
        Object localObject = c.LgD;
        if (!c.bPa())
        {
          AppMethodBeat.o(117659);
          return;
        }
        localObject = ad.eMg();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ai.eMn().t((String)localObject, 5, false);
        }
        AppMethodBeat.o(117659);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(217642);
  }
  
  public static boolean Cm(long paramLong)
  {
    AppMethodBeat.i(117691);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.ajC().ajl().set(al.a.IDx, Long.valueOf(paramLong));
    AppMethodBeat.o(117691);
    return false;
  }
  
  private static boolean Cn(long paramLong)
  {
    return paramLong == 100203L;
  }
  
  private static void I(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(217641);
    h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117658);
        Object localObject = c.LgD;
        if (!c.bPa())
        {
          AppMethodBeat.o(117658);
          return;
        }
        localObject = ad.uR(this.DAC);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ai.eMn().t((String)localObject, 4, this.DBF);
        }
        AppMethodBeat.o(117658);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(217641);
  }
  
  public static Properties T(com.tencent.mm.vfs.e parame)
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
      parame = com.tencent.mm.vfs.i.ai(parame);
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", parame, "", new Object[0]);
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
  
  public static String Ux()
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
  
  public static final String Wb(int paramInt)
  {
    AppMethodBeat.i(117661);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    g.ajA();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(117661);
    return localObject;
  }
  
  public static ao Wc(int paramInt)
  {
    AppMethodBeat.i(117662);
    ao localao = (ao)DBD.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(117662);
    return localao;
  }
  
  public static boolean Wd(int paramInt)
  {
    AppMethodBeat.i(117664);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((ao)DBD.get(Integer.valueOf(paramInt))).aHm() > 1)
    {
      AppMethodBeat.o(117664);
      return true;
    }
    AppMethodBeat.o(117664);
    return false;
  }
  
  public static int We(int paramInt)
  {
    AppMethodBeat.i(117665);
    paramInt = ((ao)DBD.get(Integer.valueOf(paramInt))).aHm();
    AppMethodBeat.o(117665);
    return paramInt;
  }
  
  public static void Wf(int paramInt)
  {
    DBE = paramInt;
  }
  
  public static String Wg(int paramInt)
  {
    AppMethodBeat.i(117667);
    String str = ((ao)DBD.get(Integer.valueOf(paramInt))).eMw();
    AppMethodBeat.o(117667);
    return str;
  }
  
  public static String Wh(int paramInt)
  {
    AppMethodBeat.i(117668);
    String str = T(new com.tencent.mm.vfs.e(((ao)DBD.get(Integer.valueOf(paramInt))).eMw(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(117668);
    return str;
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(117700);
    paramMap = z(paramMap, paramString);
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
    localHashMap.put("lang", ac.iM(aj.getContext()));
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
      paramString1 = String.valueOf(We(0));
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
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
      float f2 = com.tencent.mm.cc.a.eb(aj.getContext());
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
      localHashMap.put("netType", Ux());
      if (com.tencent.mm.az.a.aJG())
      {
        paramString1 = com.tencent.mm.az.a.aJJ();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.ihg);
        }
      }
      AppMethodBeat.o(117673);
      return localHashMap;
      paramString1 = String.valueOf(We(1));
      break;
      paramString1 = af.aFP("mixGlobal");
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
            if (af.aFP("bizTab").optInt("bizSugSwitch", 0) == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (paramInt2 == 2)
          {
            bool1 = bool2;
            if (af.aFP("articleTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool3 = bool1;
          bool2 = bool5;
          if (paramInt2 == 8)
          {
            paramString1 = af.aFP("snsTab");
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
              if (af.aFP("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                bool1 = true;
              }
            }
          }
          bool3 = bool4;
          if (paramInt2 == 1)
          {
            bool3 = bool4;
            if (af.aFP("bizTab").optInt("mfsBizSwitch", 0) == 1) {
              bool3 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 1024)
          {
            bool4 = bool1;
            if (af.aFP("novelTab").optInt("sugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
          bool1 = bool4;
          if (paramInt2 == 512)
          {
            bool1 = bool4;
            if (af.aFP("musicTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 384)
          {
            bool4 = bool1;
            if (af.aFP("emotionTab").optInt("sugSwitch", 0) == 1) {
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
          if (af.aFP("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
            break;
          }
          bool1 = true;
          bool5 = bool3;
          bool6 = bool2;
          break;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (af.aFP("bizEntry").optInt("sugSwitch") != 1) {
            break;
          }
          continue;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (af.aFP("bizUnionTopEntry").optInt("sugSwitch") != 1) {
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
          if (af.aFP("emoticonMall").optInt("sugSwitch", 0) == 1)
          {
            bool1 = true;
            bool5 = bool3;
            bool6 = bool2;
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, doa paramdoa, int paramInt)
  {
    AppMethodBeat.i(117703);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdoa.toByteArray());
      label26:
      if (Cn(paramdoa.HCf))
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
  
  public static void a(Context paramContext, doa paramdoa)
  {
    AppMethodBeat.i(117704);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdoa.toByteArray());
      label26:
      if (Cn(paramdoa.HCf))
      {
        e(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        AppMethodBeat.o(117704);
        return;
      }
      e(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent);
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      AppMethodBeat.o(117679);
      return;
    }
    Intent localIntent = aW(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = Wb(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = Wb(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!bt.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", e(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        AppMethodBeat.o(117679);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3)
  {
    AppMethodBeat.i(217645);
    pb localpb = new pb();
    localpb.dCV.query = paramString4;
    localpb.dCV.sessionId = paramString2;
    localpb.dCV.dCW = paramString3;
    localpb.dCV.scene = paramInt1;
    localpb.dCV.dCX = paramString1;
    localpb.dCV.dCZ = paramString5;
    localpb.dCV.dDa = paramInt2;
    localpb.dCV.dCY = paramString6;
    localpb.dCV.dDb = paramInt3;
    com.tencent.mm.sdk.b.a.IbL.l(localpb);
    AppMethodBeat.o(217645);
  }
  
  public static long aFM(String paramString)
  {
    AppMethodBeat.i(117690);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(117690);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(117690);
    return l;
  }
  
  private static Intent aW(Intent paramIntent)
  {
    AppMethodBeat.i(117671);
    if (paramIntent == null)
    {
      AppMethodBeat.o(117671);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(117671);
    return paramIntent;
  }
  
  public static String aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(221251);
    paramMap = e(paramMap, 0);
    AppMethodBeat.o(221251);
    return paramMap;
  }
  
  public static int b(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(117699);
    paramMap = z(paramMap, paramString);
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
  
  public static void b(Context paramContext, doa paramdoa)
  {
    AppMethodBeat.i(217647);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramdoa.toByteArray());
      label26:
      if (Cn(paramdoa.HCf))
      {
        b(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent, 1);
        AppMethodBeat.o(217647);
        return;
      }
      b(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent, 1);
      AppMethodBeat.o(217647);
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
      String str2 = aj.fkB() + ".plugin.topstory";
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117702);
    }
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117689);
    paramIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = f(paramInt, false, 384);
    String str = Wb(bt.aRe((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", e(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(117689);
  }
  
  public static btn bNG()
  {
    AppMethodBeat.i(117670);
    try
    {
      Object localObject = (String)g.ajC().ajl().get(67591, null);
      if (localObject != null)
      {
        btn localbtn = new btn();
        localObject = ((String)localObject).split(",");
        localbtn.Ggw = Integer.valueOf(localObject[0]).intValue();
        localbtn.Ggz = Integer.valueOf(localObject[1]).intValue();
        localbtn.FOB = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localbtn.FOA = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localbtn.FOB), Float.valueOf(localbtn.FOA) });
        AppMethodBeat.o(117670);
        return localbtn;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(117670);
      return null;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(117670);
    }
    return null;
  }
  
  public static void cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(217646);
    pc localpc = new pc();
    localpc.dDc.scene = paramInt;
    localpc.dDc.sessionId = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localpc);
    AppMethodBeat.o(217646);
  }
  
  public static String e(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(117688);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject = Wc(paramInt).eMw();
    paramMap.put("isOpenPreload", "1");
    localStringBuffer.append((String)localObject);
    if (paramMap.size() > 0)
    {
      localObject = localStringBuffer.append("/");
      Wc(paramInt);
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
        localObject = Wb(bt.aRe((String)paramMap.get("scene")));
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
      localStringBuffer.append(com.tencent.mm.protocal.d.Fnj);
      localStringBuffer.append("&");
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(117688);
      return paramMap;
    }
    paramMap = localStringBuffer.append("/");
    Wc(paramInt);
    paramMap.append("app.html");
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(117688);
    return paramMap;
  }
  
  public static void e(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(117701);
    try
    {
      String str2 = aj.fkB() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(aj.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117701);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(117701);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117701);
    }
  }
  
  public static int eMa()
  {
    AppMethodBeat.i(117663);
    Object localObject4 = ((ao)DBD.get(Integer.valueOf(1))).eMx();
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
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
  
  public static int eMb()
  {
    return DBE;
  }
  
  public static String eMc()
  {
    AppMethodBeat.i(117666);
    Object localObject = (ao)DBD.get(Integer.valueOf(0));
    localObject = q.B(new com.tencent.mm.vfs.e(((ao)localObject).eMw(), ((ao)localObject).DCF).fOK());
    AppMethodBeat.o(117666);
    return localObject;
  }
  
  public static Intent eMd()
  {
    AppMethodBeat.i(117672);
    Intent localIntent = aW(new Intent());
    AppMethodBeat.o(117672);
    return localIntent;
  }
  
  public static void eMe()
  {
    AppMethodBeat.i(117680);
    I(0L, false);
    AppMethodBeat.o(117680);
  }
  
  public static void eMf()
  {
    AppMethodBeat.i(184552);
    I(0L, true);
    AppMethodBeat.o(184552);
  }
  
  public static String eMg()
  {
    AppMethodBeat.i(217643);
    Object localObject = new HashMap();
    ((Map)localObject).put("scene", "-1");
    ((Map)localObject).put("type", "64");
    ((Map)localObject).put("lang", ac.iM(aj.getContext()));
    ((Map)localObject).put("platform", "android");
    ((Map)localObject).put("version", String.valueOf(((ao)DBD.get(Integer.valueOf(3))).aHm()));
    ((Map)localObject).put("isHomePage", "0");
    ((Map)localObject).put("isSug", "1");
    ((Map)localObject).put("netType", Ux());
    ((Map)localObject).put("WASessionId", "");
    ((Map)localObject).put("sessionId", "");
    ((Map)localObject).put("subSessionId", "");
    ((Map)localObject).put("isPreload", "1");
    localObject = e((Map)localObject, 3);
    AppMethodBeat.o(217643);
    return localObject;
  }
  
  public static boolean eMh()
  {
    AppMethodBeat.i(117692);
    JSONObject localJSONObject = af.aFP("snsContactMatch");
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
  
  public static int eMi()
  {
    AppMethodBeat.i(117695);
    JSONObject localJSONObject = af.aFP("snsContactMatch");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("queryUtfLenLimit");
      AppMethodBeat.o(117695);
      return i;
    }
    AppMethodBeat.o(117695);
    return 0;
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
    //   0: ldc_w 1010
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 1012
    //   10: invokestatic 1018	android/support/v4/content/b:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +59 -> 74
    //   18: getstatic 1024	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
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
    //   42: invokevirtual 1027	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   45: ldc_w 1010
    //   48: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 132
    //   56: aload_0
    //   57: ldc 222
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 1010
    //   69: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_1
    //   73: ireturn
    //   74: getstatic 1024	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
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
    //   98: invokevirtual 1027	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ldc_w 1012
    //   105: invokestatic 1032	android/support/v4/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 132
    //   113: ldc_w 1034
    //   116: invokestatic 1037	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 1010
    //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 132
    //   129: ldc_w 1039
    //   132: invokestatic 1037	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 105	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 1012
    //   145: aastore
    //   146: bipush 73
    //   148: invokestatic 1042	android/support/v4/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   151: ldc_w 1010
    //   154: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 132
    //   162: aload_0
    //   163: ldc 222
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static String toUrlParams(Map<String, ? extends Object> paramMap)
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
  
  public static String uR(boolean paramBoolean)
  {
    AppMethodBeat.i(117684);
    String str = Wb(-1);
    Map localMap = f(-1, paramBoolean, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    str = e(localMap, 0);
    AppMethodBeat.o(117684);
    return str;
  }
  
  public static String z(Map<String, Object> paramMap, String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ad
 * JD-Core Version:    0.7.0.1
 */