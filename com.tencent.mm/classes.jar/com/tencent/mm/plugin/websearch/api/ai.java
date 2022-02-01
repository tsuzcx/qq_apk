package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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

public final class ai
{
  private static Map<Integer, at> IEv;
  private static int IEw;
  
  static
  {
    AppMethodBeat.i(117705);
    HashMap localHashMap = new HashMap();
    IEv = localHashMap;
    localHashMap.put(Integer.valueOf(3), new at("wxa/template", "wxa_template.zip", "wxa"));
    IEv.put(Integer.valueOf(1), new at("topstory/template", "wrd_template.zip", "topstory"));
    IEv.put(Integer.valueOf(0), new at("websearch/template", "fts_template.zip", "websearch"));
    IEv.put(Integer.valueOf(2), new at("box/template", "box_template.zip", "box"));
    IEv.put(Integer.valueOf(4), new at("scan_goods/template", "scan_goods_template.zip", "scan_goods"));
    IEv.put(Integer.valueOf(5), new at("pardus/template", "pardus_template.zip", "pardus"));
    IEv.put(Integer.valueOf(6), new at("tagsearch/template", "tsc_template.zip", "tagsearch"));
    IEv.put(Integer.valueOf(7), new at("material_forward/template", "material_forward_template.zip", "material_forward"));
    IEv.put(Integer.valueOf(8), new at("ocr/template", "ocr_template.zip", "ocr"));
    AppMethodBeat.o(117705);
  }
  
  public static void LW(long paramLong)
  {
    AppMethodBeat.i(117681);
    P(paramLong, false);
    AppMethodBeat.o(117681);
  }
  
  public static void LX(long paramLong)
  {
    AppMethodBeat.i(187851);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "preloadWxaSearch %s", new Object[] { Long.valueOf(paramLong) });
    h.RTc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117659);
        Object localObject = com.tencent.mm.util.c.QYz;
        if (!com.tencent.mm.util.c.cnC())
        {
          AppMethodBeat.o(117659);
          return;
        }
        if (com.tencent.mm.compatible.util.d.oE(29))
        {
          AppMethodBeat.o(117659);
          return;
        }
        localObject = ai.fYa();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          an.fYj().w((String)localObject, 5, false);
        }
        AppMethodBeat.o(117659);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(187851);
  }
  
  public static boolean LY(long paramLong)
  {
    AppMethodBeat.i(117691);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.aAh().azQ().set(ar.a.Ogu, Long.valueOf(paramLong));
    AppMethodBeat.o(117691);
    return false;
  }
  
  private static boolean LZ(long paramLong)
  {
    return paramLong == 100203L;
  }
  
  public static String N(Map<String, Object> paramMap, String paramString)
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
  
  public static boolean O(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117698);
    paramMap = N(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
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
  
  private static void P(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(187850);
    h.RTc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117658);
        Object localObject = com.tencent.mm.util.c.QYz;
        if (!com.tencent.mm.util.c.cnC())
        {
          AppMethodBeat.o(117658);
          return;
        }
        if (com.tencent.mm.compatible.util.d.oE(29))
        {
          AppMethodBeat.o(117658);
          return;
        }
        localObject = ai.yO(this.IDa);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          an.fYj().w((String)localObject, 4, paramBoolean);
        }
        AppMethodBeat.o(117658);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(187850);
  }
  
  public static Properties X(o paramo)
  {
    AppMethodBeat.i(117660);
    Properties localProperties = new Properties();
    if ((paramo != null) && (paramo.isFile()))
    {
      localObject = null;
      localo = null;
    }
    try
    {
      paramo = s.ao(paramo);
      localo = paramo;
      localObject = paramo;
      localProperties.load(paramo);
      Util.qualityClose(paramo);
    }
    catch (Exception paramo)
    {
      for (;;)
      {
        localObject = localo;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", paramo, "", new Object[0]);
        Util.qualityClose(localo);
      }
    }
    finally
    {
      Util.qualityClose((Closeable)localObject);
      AppMethodBeat.o(117660);
    }
    AppMethodBeat.o(117660);
    return localProperties;
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(117700);
    paramMap = N(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
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
    localHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
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
      paramString1 = String.valueOf(aft(0));
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
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
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
      float f2 = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
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
      localHashMap.put("netType", ait());
      if (com.tencent.mm.ay.a.bec())
      {
        paramString1 = com.tencent.mm.ay.a.bef();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.jeV);
        }
      }
      AppMethodBeat.o(117673);
      return localHashMap;
      paramString1 = String.valueOf(aft(1));
      break;
      paramString1 = ak.aXe("mixGlobal");
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
            if (ak.aXe("bizTab").optInt("bizSugSwitch", 0) == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (paramInt2 == 2)
          {
            bool1 = bool2;
            if (ak.aXe("articleTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool3 = bool1;
          bool2 = bool5;
          if (paramInt2 == 8)
          {
            paramString1 = ak.aXe("snsTab");
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
              if (ak.aXe("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                bool1 = true;
              }
            }
          }
          bool3 = bool4;
          if (paramInt2 == 1)
          {
            bool3 = bool4;
            if (ak.aXe("bizTab").optInt("mfsBizSwitch", 0) == 1) {
              bool3 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 1024)
          {
            bool4 = bool1;
            if (ak.aXe("novelTab").optInt("sugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
          bool1 = bool4;
          if (paramInt2 == 512)
          {
            bool1 = bool4;
            if (ak.aXe("musicTab").optInt("sugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
          bool4 = bool1;
          if (paramInt2 == 384)
          {
            bool4 = bool1;
            if (ak.aXe("emotionTab").optInt("sugSwitch", 0) == 1) {
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
          if (ak.aXe("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
            break;
          }
          bool1 = true;
          bool5 = bool3;
          bool6 = bool2;
          break;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ak.aXe("bizEntry").optInt("sugSwitch") != 1) {
            break;
          }
          continue;
          bool1 = bool7;
          bool5 = bool3;
          bool6 = bool2;
          if (ak.aXe("bizUnionTopEntry").optInt("sugSwitch") != 1) {
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
          if (ak.aXe("emoticonMall").optInt("sugSwitch", 0) == 1)
          {
            bool1 = true;
            bool5 = bool3;
            bool6 = bool2;
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, eit parameit, int paramInt)
  {
    AppMethodBeat.i(117703);
    if (((b)g.af(b.class)).Vt())
    {
      ((b)g.af(b.class)).hr(paramActivity);
      AppMethodBeat.o(117703);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parameit.toByteArray());
      label65:
      if (LZ(parameit.Nib))
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
      break label65;
    }
  }
  
  public static void a(Context paramContext, eit parameit)
  {
    AppMethodBeat.i(117704);
    if (((b)g.af(b.class)).Vt())
    {
      ((b)g.af(b.class)).hr(paramContext);
      AppMethodBeat.o(117704);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parameit.toByteArray());
      label65:
      if (LZ(parameit.Nib))
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
      break label65;
    }
  }
  
  public static void a(Context paramContext, eit parameit, crq paramcrq)
  {
    AppMethodBeat.i(187856);
    if (((b)g.af(b.class)).Vt())
    {
      ((b)g.af(b.class)).hr(paramContext);
      AppMethodBeat.o(187856);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parameit.toByteArray());
      ach localach = new ach();
      localach.LmQ = paramcrq;
      localIntent.putExtra("key_multi_task_common_info", localach.toByteArray());
      label93:
      if (LZ(parameit.Nib))
      {
        e(paramContext, ".ui.video.fs.TopStoryMultiTaskFSVideoUI", localIntent);
        AppMethodBeat.o(187856);
        return;
      }
      e(paramContext, ".ui.video.list.TopStoryMultiTaskListVideoUI", localIntent);
      AppMethodBeat.o(187856);
      return;
    }
    catch (IOException paramcrq)
    {
      break label93;
    }
  }
  
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(117679);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      AppMethodBeat.o(117679);
      return;
    }
    Intent localIntent = bi(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = afq(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = afq(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!Util.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", g(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        AppMethodBeat.o(117679);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187854);
    pu localpu = new pu();
    localpu.dVN.query = paramString4;
    localpu.dVN.sessionId = paramString2;
    localpu.dVN.dVO = paramString3;
    localpu.dVN.scene = paramInt1;
    localpu.dVN.dVP = paramString1;
    localpu.dVN.dVR = paramString5;
    localpu.dVN.dVS = paramInt2;
    localpu.dVN.dVQ = paramString6;
    localpu.dVN.dVT = paramInt3;
    localpu.dVN.dDL = paramString7;
    localpu.dVN.dVU = paramMap;
    EventCenter.instance.publish(localpu);
    AppMethodBeat.o(187854);
  }
  
  public static long aXb(String paramString)
  {
    AppMethodBeat.i(117690);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(117690);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(117690);
    return l;
  }
  
  public static final String afq(int paramInt)
  {
    AppMethodBeat.i(117661);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    g.aAf();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(117661);
    return localObject;
  }
  
  public static at afr(int paramInt)
  {
    AppMethodBeat.i(117662);
    at localat = (at)IEv.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(117662);
    return localat;
  }
  
  public static boolean afs(int paramInt)
  {
    AppMethodBeat.i(117664);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((at)IEv.get(Integer.valueOf(paramInt))).bbw() > 1)
    {
      AppMethodBeat.o(117664);
      return true;
    }
    AppMethodBeat.o(117664);
    return false;
  }
  
  public static int aft(int paramInt)
  {
    AppMethodBeat.i(117665);
    paramInt = ((at)IEv.get(Integer.valueOf(paramInt))).bbw();
    AppMethodBeat.o(117665);
    return paramInt;
  }
  
  public static void afu(int paramInt)
  {
    IEw = paramInt;
  }
  
  public static String afv(int paramInt)
  {
    AppMethodBeat.i(187848);
    Object localObject = (at)IEv.get(Integer.valueOf(paramInt));
    localObject = aa.z(new o(((at)localObject).fYs(), ((at)localObject).IFx).her());
    AppMethodBeat.o(187848);
    return localObject;
  }
  
  public static String afw(int paramInt)
  {
    AppMethodBeat.i(117667);
    String str = ((at)IEv.get(Integer.valueOf(paramInt))).fYs();
    AppMethodBeat.o(117667);
    return str;
  }
  
  private static int afx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 3;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static String ait()
  {
    AppMethodBeat.i(117669);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(117669);
      return "wifi";
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(117669);
      return "4g";
    }
    if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(117669);
      return "3g";
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(117669);
      return "2g";
    }
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(117669);
      return "fail";
    }
    AppMethodBeat.o(117669);
    return "";
  }
  
  public static int b(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(117699);
    paramMap = N(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
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
  
  public static void b(Context paramContext, eit parameit)
  {
    AppMethodBeat.i(187857);
    if (((b)g.af(b.class)).Vt())
    {
      ((b)g.af(b.class)).hr(paramContext);
      AppMethodBeat.o(187857);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parameit.toByteArray());
      label65:
      if (LZ(parameit.Nib))
      {
        b(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent, 1);
        AppMethodBeat.o(187857);
        return;
      }
      b(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent, 1);
      AppMethodBeat.o(187857);
      return;
    }
    catch (IOException localIOException)
    {
      break label65;
    }
  }
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117702);
    try
    {
      String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      }
      AppMethodBeat.o(117702);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117702);
    }
  }
  
  public static String bd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(258523);
    paramMap = g(paramMap, 0);
    AppMethodBeat.o(258523);
    return paramMap;
  }
  
  private static Intent bi(Intent paramIntent)
  {
    AppMethodBeat.i(117671);
    if (paramIntent == null)
    {
      AppMethodBeat.o(117671);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(117671);
    return paramIntent;
  }
  
  public static void cM(int paramInt, String paramString)
  {
    AppMethodBeat.i(187855);
    pv localpv = new pv();
    localpv.dVV.scene = paramInt;
    localpv.dVV.sessionId = paramString;
    EventCenter.instance.publish(localpv);
    AppMethodBeat.o(187855);
  }
  
  public static chl clJ()
  {
    AppMethodBeat.i(117670);
    try
    {
      Object localObject = (String)g.aAh().azQ().get(67591, null);
      if (localObject != null)
      {
        chl localchl = new chl();
        localObject = ((String)localObject).split(",");
        localchl.LuT = Integer.valueOf(localObject[0]).intValue();
        localchl.LuW = Integer.valueOf(localObject[1]).intValue();
        localchl.LbD = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localchl.LbC = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localchl.LbD), Float.valueOf(localchl.LbC) });
        AppMethodBeat.o(117670);
        return localchl;
      }
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(117670);
      return null;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(117670);
    }
    return null;
  }
  
  public static void e(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(117701);
    try
    {
      String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117701);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(117701);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(117701);
    }
  }
  
  public static void f(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117689);
    paramIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = h(paramInt, false, 384);
    String str = afq(Util.safeParseInt((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", g(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(117689);
  }
  
  public static int fXU()
  {
    AppMethodBeat.i(117663);
    Object localObject4 = ((at)IEv.get(Integer.valueOf(1))).fYt();
    AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = localAssetManager.open((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      Util.qualityClose((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
        Util.qualityClose(localObject1);
      }
    }
    finally
    {
      Util.qualityClose(localObject3);
      AppMethodBeat.o(117663);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117663);
    return i;
  }
  
  public static int fXV()
  {
    return IEw;
  }
  
  public static String fXW()
  {
    AppMethodBeat.i(187849);
    String str = X(new o(((at)IEv.get(Integer.valueOf(1))).fYs(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(187849);
    return str;
  }
  
  public static Intent fXX()
  {
    AppMethodBeat.i(117672);
    Intent localIntent = bi(new Intent());
    AppMethodBeat.o(117672);
    return localIntent;
  }
  
  public static void fXY()
  {
    AppMethodBeat.i(117680);
    P(0L, false);
    AppMethodBeat.o(117680);
  }
  
  public static void fXZ()
  {
    AppMethodBeat.i(184552);
    P(0L, true);
    AppMethodBeat.o(184552);
  }
  
  public static String fYa()
  {
    AppMethodBeat.i(187852);
    Object localObject = new HashMap();
    ((Map)localObject).put("scene", "-1");
    ((Map)localObject).put("type", "64");
    ((Map)localObject).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((Map)localObject).put("platform", "android");
    ((Map)localObject).put("version", String.valueOf(((at)IEv.get(Integer.valueOf(3))).bbw()));
    ((Map)localObject).put("isHomePage", "0");
    ((Map)localObject).put("isSug", "1");
    ((Map)localObject).put("netType", ait());
    ((Map)localObject).put("WASessionId", "");
    ((Map)localObject).put("sessionId", "");
    ((Map)localObject).put("subSessionId", "");
    ((Map)localObject).put("isPreload", "1");
    localObject = g((Map)localObject, 3);
    AppMethodBeat.o(187852);
    return localObject;
  }
  
  public static boolean fYb()
  {
    AppMethodBeat.i(117692);
    JSONObject localJSONObject = ak.aXe("snsContactMatch");
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
  
  public static int fYc()
  {
    AppMethodBeat.i(117695);
    JSONObject localJSONObject = ak.aXe("snsContactMatch");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("queryUtfLenLimit");
      AppMethodBeat.o(117695);
      return i;
    }
    AppMethodBeat.o(117695);
    return 0;
  }
  
  public static aah fYd()
  {
    AppMethodBeat.i(187858);
    aah localaah = new aah();
    localaah.Llv = ((b)g.af(b.class)).Vt();
    if (localaah.Llv)
    {
      localaah.Lls = afx(((b)g.af(b.class)).fvo());
      localaah.Llt = afx(((b)g.af(b.class)).fvp());
      localaah.Llu = afx(((b)g.af(b.class)).dxW());
    }
    AppMethodBeat.o(187858);
    return localaah;
  }
  
  public static String fYe()
  {
    AppMethodBeat.i(187859);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187859);
      return "wifi";
    }
    if (isFreeSimCard())
    {
      AppMethodBeat.o(187859);
      return "wangka";
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187859);
      return "4g";
    }
    if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187859);
      return "3g";
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187859);
      return "2g";
    }
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187859);
      return "fail";
    }
    AppMethodBeat.o(187859);
    return "";
  }
  
  public static String g(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(117688);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject = afr(paramInt).fYs();
    paramMap.put("isOpenPreload", "1");
    localStringBuffer.append((String)localObject);
    if (paramMap.size() > 0)
    {
      localObject = localStringBuffer.append("/");
      afr(paramInt);
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
        localObject = afq(Util.safeParseInt((String)paramMap.get("scene")));
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
      localStringBuffer.append(com.tencent.mm.protocal.d.KyO);
      localStringBuffer.append("&");
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(117688);
      return paramMap;
    }
    paramMap = localStringBuffer.append("/");
    afr(paramInt);
    paramMap.append("app.html");
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(117688);
    return paramMap;
  }
  
  public static Map<String, String> h(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117674);
    Map localMap = a(paramInt1, paramBoolean, paramInt2, "");
    AppMethodBeat.o(117674);
    return localMap;
  }
  
  public static boolean isFreeSimCard()
  {
    AppMethodBeat.i(187860);
    int i = ((com.tencent.mm.plugin.misc.a.a)g.af(com.tencent.mm.plugin.misc.a.a.class)).eiV();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(187860);
      return bool;
    }
  }
  
  /* Error */
  public static boolean n(Activity paramActivity, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1116
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 1118
    //   10: invokestatic 1124	android/support/v4/content/b:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +59 -> 74
    //   18: getstatic 1130	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
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
    //   42: invokevirtual 1133	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   45: ldc_w 1116
    //   48: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 115
    //   56: aload_0
    //   57: ldc 191
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 1116
    //   69: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_1
    //   73: ireturn
    //   74: getstatic 1130	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
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
    //   98: invokevirtual 1133	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ldc_w 1118
    //   105: invokestatic 1138	android/support/v4/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 115
    //   113: ldc_w 1140
    //   116: invokestatic 1143	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 1116
    //   122: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 115
    //   129: ldc_w 1145
    //   132: invokestatic 1143	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 210	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 1118
    //   145: aastore
    //   146: bipush 73
    //   148: invokestatic 1148	android/support/v4/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   151: ldc_w 1116
    //   154: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 115
    //   162: aload_0
    //   163: ldc 191
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static String yO(boolean paramBoolean)
  {
    AppMethodBeat.i(117684);
    String str = afq(-1);
    Map localMap = h(-1, paramBoolean, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    str = g(localMap, 0);
    AppMethodBeat.o(117684);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ai
 * JD-Core Version:    0.7.0.1
 */