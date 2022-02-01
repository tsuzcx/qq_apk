package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sg;
import com.tencent.mm.b.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.b;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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

public final class aj
{
  private static Map<Integer, au> WoV;
  private static int WoW;
  
  static
  {
    AppMethodBeat.i(117705);
    HashMap localHashMap = new HashMap();
    WoV = localHashMap;
    localHashMap.put(Integer.valueOf(3), new au("wxa/template", "wxa_template.zip", "wxa", -1L));
    WoV.put(Integer.valueOf(1), new au("topstory/template", "wrd_template.zip", "topstory", 1851L));
    WoV.put(Integer.valueOf(0), new au("websearch/template", "fts_template.zip", "websearch", 1850L));
    WoV.put(Integer.valueOf(2), new au("box/template", "box_template.zip", "box", -1L));
    WoV.put(Integer.valueOf(4), new au("scan_goods/template", "scan_goods_template.zip", "scan_goods", -1L));
    WoV.put(Integer.valueOf(5), new au("pardus/template", "pardus_template.zip", "pardus", 1852L));
    WoV.put(Integer.valueOf(6), new au("tagsearch/template", "tsc_template.zip", "tagsearch", 1853L));
    WoV.put(Integer.valueOf(7), new au("material_forward/template", "material_forward_template.zip", "material_forward", -1L));
    WoV.put(Integer.valueOf(8), new au("ocr/template", "ocr_template.zip", "ocr", -1L));
    WoV.put(Integer.valueOf(9), new au("ftshotsearch/template", "ftshotsearch_template.zip", "ftshotsearch", 1854L));
    WoV.put(Integer.valueOf(10), new au("emojisearch/template", "esc_template.zip", "emojisearch", 1855L));
    AppMethodBeat.o(117705);
  }
  
  public static String Io(boolean paramBoolean)
  {
    AppMethodBeat.i(117684);
    String str = asV(-1);
    Map localMap = r(-1, paramBoolean, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    str = h(localMap, 0);
    AppMethodBeat.o(117684);
    return str;
  }
  
  public static Properties Z(u paramu)
  {
    AppMethodBeat.i(117660);
    Properties localProperties = new Properties();
    if ((paramu != null) && (paramu.jKV()))
    {
      localObject = null;
      localu = null;
    }
    try
    {
      paramu = y.ao(paramu);
      localu = paramu;
      localObject = paramu;
      localProperties.load(paramu);
      Util.qualityClose(paramu);
    }
    catch (Exception paramu)
    {
      for (;;)
      {
        localObject = localu;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", paramu, "", new Object[0]);
        Util.qualityClose(localu);
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
    paramMap = au(paramMap, paramString);
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
    boolean bool6;
    boolean bool9;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    boolean bool7;
    boolean bool2;
    boolean bool5;
    boolean bool8;
    switch (paramInt1)
    {
    default: 
      paramString1 = String.valueOf(asY(0));
      localHashMap.put("version", paramString1);
      bool6 = false;
      bool9 = false;
      bool1 = false;
      bool3 = false;
      bool4 = false;
      bool7 = false;
      bool2 = false;
      bool5 = false;
      bool8 = false;
      switch (paramInt1)
      {
      default: 
        bool5 = bool7;
        bool4 = bool8;
        bool6 = bool1;
        label472:
        bool1 = bool6;
        bool2 = bool5;
      }
      break;
    }
    for (;;)
    {
      label480:
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      if (bool1) {
        localHashMap.put("isSug", "1");
      }
      if (bool2) {
        localHashMap.put("isLocalSug", "1");
      }
      if (bool4) {
        localHashMap.put("isMostSearchBiz", "1");
      }
      if (paramBoolean) {
        localHashMap.put("isHomePage", "1");
      }
      float f2 = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
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
      localHashMap.put("netType", gtA());
      if (com.tencent.mm.aw.a.bLk())
      {
        paramString1 = com.tencent.mm.aw.a.bLn();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.oOv);
        }
      }
      AppMethodBeat.o(117673);
      return localHashMap;
      paramString1 = String.valueOf(asY(1));
      break;
      paramString1 = al.bix("mixGlobal");
      if (paramBoolean)
      {
        bool6 = bool1;
        bool4 = bool8;
        bool5 = bool7;
        if (paramString1.optInt("mixSugSwitch", 0) != 1) {
          break label472;
        }
      }
      for (;;)
      {
        bool1 = true;
        bool4 = bool2;
        bool2 = bool3;
        break label480;
        if (paramInt2 == 1)
        {
          bool6 = bool1;
          bool4 = bool8;
          bool5 = bool7;
          if (paramString1.optInt("bizSugSwitch", 0) != 1) {
            break;
          }
          continue;
        }
        if (paramInt2 == 8)
        {
          bool6 = bool1;
          bool4 = bool8;
          bool5 = bool7;
          if (paramString1.optInt("snsSugSwitch", 0) != 1) {
            break;
          }
          continue;
        }
        if (paramInt2 == 1024)
        {
          bool6 = bool1;
          bool4 = bool8;
          bool5 = bool7;
          if (paramString1.optInt("novelSugSwitch", 0) != 1) {
            break;
          }
          continue;
        }
        if (paramInt2 == 512)
        {
          bool6 = bool1;
          bool4 = bool8;
          bool5 = bool7;
          if (paramString1.optInt("musicSugSwitch", 0) != 1) {
            break;
          }
          continue;
        }
        if ((paramInt2 != 384) && (paramInt2 != 256))
        {
          bool6 = bool1;
          bool4 = bool8;
          bool5 = bool7;
          if (paramInt2 != 128) {
            break;
          }
        }
        bool6 = bool1;
        bool4 = bool8;
        bool5 = bool7;
        if (paramString1.optInt("emotionSugSwitch", 0) != 1) {
          break;
        }
        continue;
        bool1 = bool6;
        if (paramInt2 == 1)
        {
          bool1 = bool6;
          if (al.bix("bizTab").optInt("bizSugSwitch", 0) == 1) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramInt2 == 2)
        {
          bool2 = bool1;
          if (al.bix("articleTab").optInt("sugSwitch", 0) == 1) {
            bool2 = true;
          }
        }
        bool3 = bool2;
        bool1 = bool4;
        if (paramInt2 == 8)
        {
          paramString1 = al.bix("snsTab");
          if (paramString1.optInt("sugSwitch", 0) == 1) {
            bool2 = true;
          }
          bool3 = bool2;
          bool1 = bool4;
          if (paramString1.optInt("localSugSwitch", 0) == 1)
          {
            bool1 = true;
            bool3 = bool2;
          }
        }
        bool4 = bool3;
        if (!paramBoolean)
        {
          bool4 = bool3;
          if (paramInt2 == 4)
          {
            bool4 = bool3;
            if (al.bix("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
              bool4 = true;
            }
          }
        }
        bool2 = bool5;
        if (paramInt2 == 1)
        {
          bool2 = bool5;
          if (al.bix("bizTab").optInt("mfsBizSwitch", 0) == 1) {
            bool2 = true;
          }
        }
        bool3 = bool4;
        if (paramInt2 == 1024)
        {
          bool3 = bool4;
          if (al.bix("novelTab").optInt("sugSwitch", 0) == 1) {
            bool3 = true;
          }
        }
        bool4 = bool3;
        if (paramInt2 == 512)
        {
          bool4 = bool3;
          if (al.bix("musicTab").optInt("sugSwitch", 0) == 1) {
            bool4 = true;
          }
        }
        bool3 = bool4;
        if (paramInt2 == 384)
        {
          bool3 = bool4;
          if (al.bix("emotionTab").optInt("sugSwitch", 0) == 1) {
            bool3 = true;
          }
        }
        bool6 = bool3;
        bool4 = bool2;
        bool5 = bool1;
        if (paramInt2 != 0) {
          break;
        }
        bool6 = bool3;
        bool4 = bool2;
        bool5 = bool1;
        if (!paramBoolean) {
          break;
        }
        if (al.bix("mixGlobal").optInt("mixSugSwitch", 0) == 1) {
          bool3 = true;
        }
        bool4 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        break label480;
        bool6 = bool1;
        bool4 = bool8;
        bool5 = bool7;
        if (al.bix("bizEntry").optInt("sugSwitch") != 1) {
          break;
        }
        continue;
        bool6 = bool1;
        bool4 = bool8;
        bool5 = bool7;
        if (al.bix("bizUnionTopEntry").optInt("sugSwitch") != 1) {
          break;
        }
      }
      bool6 = bool1;
      bool4 = bool8;
      bool5 = bool7;
      if (paramInt2 != 384) {
        break label472;
      }
      bool1 = bool9;
      if (al.bix("emoticonMall").optInt("sugSwitch", 0) == 1) {
        bool1 = true;
      }
      bool4 = bool2;
      bool2 = bool3;
      continue;
      bool1 = true;
      bool4 = bool2;
      bool2 = bool3;
      continue;
      bool1 = true;
      bool3 = true;
      bool4 = bool2;
      bool2 = bool3;
    }
  }
  
  public static void a(Activity paramActivity, foe paramfoe, int paramInt)
  {
    AppMethodBeat.i(117703);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramActivity);
      AppMethodBeat.o(117703);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramfoe.toByteArray());
      label65:
      if (xH(paramfoe.abOj))
      {
        c(paramActivity, ".ui.video.fs.TopStoryFSVideoUI", localIntent, paramInt);
        AppMethodBeat.o(117703);
        return;
      }
      c(paramActivity, ".ui.video.list.TopStoryListVideoUI", localIntent, paramInt);
      AppMethodBeat.o(117703);
      return;
    }
    catch (IOException localIOException)
    {
      break label65;
    }
  }
  
  public static void a(Context paramContext, foe paramfoe)
  {
    AppMethodBeat.i(117704);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(117704);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramfoe.toByteArray());
      label65:
      if (xH(paramfoe.abOj))
      {
        f(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        AppMethodBeat.o(117704);
        return;
      }
      f(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent);
      AppMethodBeat.o(117704);
      return;
    }
    catch (IOException localIOException)
    {
      break label65;
    }
  }
  
  public static void a(Context paramContext, foe paramfoe, drt paramdrt)
  {
    AppMethodBeat.i(315527);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(315527);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramfoe.toByteArray());
      aet localaet = new aet();
      localaet.ZmM = paramdrt;
      localIntent.putExtra("key_multi_task_common_info", localaet.toByteArray());
      label93:
      if (xH(paramfoe.abOj))
      {
        f(paramContext, ".ui.video.fs.TopStoryMultiTaskFSVideoUI", localIntent);
        AppMethodBeat.o(315527);
        return;
      }
      f(paramContext, ".ui.video.list.TopStoryMultiTaskListVideoUI", localIntent);
      AppMethodBeat.o(315527);
      return;
    }
    catch (IOException paramdrt)
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
    Intent localIntent = bI(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = asV(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = asV(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!Util.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", h(paramString1, 1));
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
    AppMethodBeat.i(315509);
    sg localsg = new sg();
    localsg.hVm.query = paramString4;
    localsg.hVm.sessionId = paramString2;
    localsg.hVm.hVn = paramString3;
    localsg.hVm.scene = paramInt1;
    localsg.hVm.hVo = paramString1;
    localsg.hVm.hVq = paramString5;
    localsg.hVm.hVr = paramInt2;
    localsg.hVm.hVp = paramString6;
    localsg.hVm.hVs = paramInt3;
    localsg.hVm.hAT = paramString7;
    localsg.hVm.hVt = paramMap;
    localsg.publish();
    AppMethodBeat.o(315509);
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc_w 592
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc_w 594
    //   13: invokestatic 600	androidx/core/content/a:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   16: istore 5
    //   18: iload 5
    //   20: ifne +59 -> 79
    //   23: getstatic 606	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   26: sipush 15104
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_1
    //   36: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iconst_2
    //   43: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokevirtual 609	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   50: ldc_w 592
    //   53: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_0
    //   59: ldc 197
    //   61: aload_0
    //   62: ldc 199
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: ldc_w 592
    //   74: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_1
    //   78: ireturn
    //   79: getstatic 606	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   82: sipush 15104
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: iload_1
    //   92: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: iconst_1
    //   99: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokevirtual 609	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ldc_w 594
    //   110: invokestatic 614	androidx/core/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   113: ifeq +19 -> 132
    //   116: ldc 197
    //   118: ldc_w 616
    //   121: invokestatic 619	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: ldc_w 592
    //   127: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iconst_1
    //   131: ireturn
    //   132: ldc 197
    //   134: ldc_w 621
    //   137: invokestatic 619	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: invokestatic 216	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   144: ifne +105 -> 249
    //   147: ldc_w 623
    //   150: invokestatic 423	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   153: checkcast 623	com/tencent/mm/plugin/expt/b/c
    //   156: getstatic 629	com/tencent/mm/plugin/expt/b/c$a:yJM	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   159: getstatic 635	com/tencent/mm/util/b$a:agqQ	Lcom/tencent/mm/util/b$a;
    //   162: iconst_0
    //   163: invokeinterface 638 4 0
    //   168: ifne +76 -> 244
    //   171: iload 4
    //   173: istore_1
    //   174: iload_1
    //   175: ifeq +74 -> 249
    //   178: new 640	com/tencent/mm/ui/widget/a/g$a
    //   181: dup
    //   182: aload_0
    //   183: invokespecial 642	com/tencent/mm/ui/widget/a/g$a:<init>	(Landroid/content/Context;)V
    //   186: astore 6
    //   188: aload 6
    //   190: aload_2
    //   191: invokevirtual 646	com/tencent/mm/ui/widget/a/g$a:bDE	(Ljava/lang/String;)Lcom/tencent/mm/ui/widget/a/g$a;
    //   194: pop
    //   195: aload 6
    //   197: iconst_0
    //   198: invokevirtual 650	com/tencent/mm/ui/widget/a/g$a:NF	(Z)Lcom/tencent/mm/ui/widget/a/g$a;
    //   201: pop
    //   202: aload 6
    //   204: aload_3
    //   205: invokevirtual 653	com/tencent/mm/ui/widget/a/g$a:bDI	(Ljava/lang/String;)Lcom/tencent/mm/ui/widget/a/g$a;
    //   208: pop
    //   209: aload 6
    //   211: new 6	com/tencent/mm/plugin/websearch/api/aj$1
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 656	com/tencent/mm/plugin/websearch/api/aj$1:<init>	(Landroid/app/Activity;)V
    //   219: invokevirtual 659	com/tencent/mm/ui/widget/a/g$a:a	(Lcom/tencent/mm/ui/widget/a/g$b;)Lcom/tencent/mm/ui/widget/a/g$a;
    //   222: pop
    //   223: ldc_w 594
    //   226: bipush 73
    //   228: invokestatic 665	com/tencent/mm/pluginsdk/permission/b:iv	(Ljava/lang/String;I)V
    //   231: aload 6
    //   233: invokevirtual 668	com/tencent/mm/ui/widget/a/g$a:show	()V
    //   236: ldc_w 592
    //   239: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: iconst_0
    //   243: ireturn
    //   244: iconst_0
    //   245: istore_1
    //   246: goto -72 -> 174
    //   249: ldc_w 594
    //   252: bipush 73
    //   254: invokestatic 671	com/tencent/mm/pluginsdk/permission/b:iw	(Ljava/lang/String;I)V
    //   257: aload_0
    //   258: iconst_1
    //   259: anewarray 264	java/lang/String
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 594
    //   267: aastore
    //   268: bipush 73
    //   270: invokestatic 674	androidx/core/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   273: goto -37 -> 236
    //   276: astore_0
    //   277: ldc 197
    //   279: aload_0
    //   280: ldc 199
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: goto -53 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramActivity	Activity
    //   0	292	1	paramInt	int
    //   0	292	2	paramString1	String
    //   0	292	3	paramString2	String
    //   1	171	4	i	int
    //   16	3	5	j	int
    //   186	46	6	locala	com.tencent.mm.ui.widget.a.g.a
    // Exception table:
    //   from	to	target	type
    //   9	18	58	java/lang/Exception
    //   23	50	276	java/lang/Exception
    //   59	71	276	java/lang/Exception
    //   79	124	276	java/lang/Exception
    //   132	171	276	java/lang/Exception
    //   178	236	276	java/lang/Exception
    //   249	273	276	java/lang/Exception
  }
  
  public static final boolean aBu()
  {
    AppMethodBeat.i(315535);
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    AppMethodBeat.o(315535);
    return bool;
  }
  
  private static void aa(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(315484);
    com.tencent.threadpool.h.ahAA.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117659);
        Object localObject = com.tencent.mm.util.i.agtt;
        if (com.tencent.mm.util.i.a(b.a.agqM, 1) != 1)
        {
          AppMethodBeat.o(117659);
          return;
        }
        if (com.tencent.mm.compatible.util.d.rc(29))
        {
          AppMethodBeat.o(117659);
          return;
        }
        localObject = aj.Io(this.Wnw);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ao.iqg().C((String)localObject, 4, paramBoolean);
        }
        AppMethodBeat.o(117659);
      }
    }, paramLong, "WebSearchThread");
    AppMethodBeat.o(315484);
  }
  
  public static final String asV(int paramInt)
  {
    AppMethodBeat.i(117661);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    com.tencent.mm.kernel.h.baC();
    localObject = p.getString(com.tencent.mm.kernel.b.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(117661);
    return localObject;
  }
  
  public static au asW(int paramInt)
  {
    AppMethodBeat.i(117662);
    au localau = (au)WoV.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(117662);
    return localau;
  }
  
  public static boolean asX(int paramInt)
  {
    AppMethodBeat.i(117664);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((au)WoV.get(Integer.valueOf(paramInt))).bIG() > 1)
    {
      AppMethodBeat.o(117664);
      return true;
    }
    AppMethodBeat.o(117664);
    return false;
  }
  
  public static int asY(int paramInt)
  {
    AppMethodBeat.i(117665);
    paramInt = ((au)WoV.get(Integer.valueOf(paramInt))).bIG();
    AppMethodBeat.o(117665);
    return paramInt;
  }
  
  public static void asZ(int paramInt)
  {
    WoW = paramInt;
  }
  
  public static String ata(int paramInt)
  {
    AppMethodBeat.i(315368);
    Object localObject = (au)WoV.get(Integer.valueOf(paramInt));
    localObject = ah.v(new u(((au)localObject).iqp(), ((au)localObject).Wqd).jKT());
    AppMethodBeat.o(315368);
    return localObject;
  }
  
  public static String atb(int paramInt)
  {
    AppMethodBeat.i(117667);
    String str = ((au)WoV.get(Integer.valueOf(paramInt))).iqp();
    AppMethodBeat.o(117667);
    return str;
  }
  
  private static int atc(int paramInt)
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
  
  public static String au(Map<String, Object> paramMap, String paramString)
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
  
  public static boolean av(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(117698);
    paramMap = au(paramMap, paramString);
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
  
  public static void b(Context paramContext, foe paramfoe)
  {
    AppMethodBeat.i(315529);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(315529);
      return;
    }
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramfoe.toByteArray());
      label65:
      if (xH(paramfoe.abOj))
      {
        c(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent, 1);
        AppMethodBeat.o(315529);
        return;
      }
      c(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent, 1);
      AppMethodBeat.o(315529);
      return;
    }
    catch (IOException localIOException)
    {
      break label65;
    }
  }
  
  private static Intent bI(Intent paramIntent)
  {
    AppMethodBeat.i(117671);
    if (paramIntent == null)
    {
      AppMethodBeat.o(117671);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(117671);
    return paramIntent;
  }
  
  public static long biu(String paramString)
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
  
  public static String bo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(369998);
    paramMap = h(paramMap, 0);
    AppMethodBeat.o(369998);
    return paramMap;
  }
  
  public static int c(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(117699);
    paramMap = au(paramMap, paramString);
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
  
  private static void c(Context paramContext, String paramString, Intent paramIntent, int paramInt)
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
        com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivityForResult", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
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
  
  public static dhb dch()
  {
    AppMethodBeat.i(117670);
    try
    {
      Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(67591, null);
      if (localObject != null)
      {
        dhb localdhb = new dhb();
        localObject = ((String)localObject).split(",");
        localdhb.Zyl = Integer.valueOf(localObject[0]).intValue();
        localdhb.Zyo = Integer.valueOf(localObject[1]).intValue();
        localdhb.ZaH = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localdhb.ZaG = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localdhb.ZaH), Float.valueOf(localdhb.ZaG) });
        AppMethodBeat.o(117670);
        return localdhb;
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
  
  public static void f(Context paramContext, String paramString, Intent paramIntent)
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117701);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    Map localMap = r(paramInt, false, 384);
    String str = asV(Util.safeParseInt((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", h(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(117689);
  }
  
  public static String gtA()
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
  
  public static String h(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(117688);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject = asW(paramInt).iqp();
    paramMap.put("isOpenPreload", "1");
    localStringBuffer.append((String)localObject);
    if (paramMap.size() > 0)
    {
      localObject = localStringBuffer.append("/");
      asW(paramInt);
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
        localObject = asV(Util.safeParseInt((String)paramMap.get("scene")));
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
      localStringBuffer.append(com.tencent.mm.protocal.d.Yxh);
      localStringBuffer.append("&");
      paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(117688);
      return paramMap;
    }
    paramMap = localStringBuffer.append("/");
    asW(paramInt);
    paramMap.append("app.html");
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(117688);
    return paramMap;
  }
  
  public static int ipO()
  {
    AppMethodBeat.i(117663);
    Object localObject4 = ((au)WoV.get(Integer.valueOf(1))).iqq();
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
  
  public static boolean ipP()
  {
    AppMethodBeat.i(315350);
    if ("1".equals(Z(((au)WoV.get(Integer.valueOf(1))).iqo()).getProperty("support_long_video")))
    {
      AppMethodBeat.o(315350);
      return true;
    }
    AppMethodBeat.o(315350);
    return false;
  }
  
  public static int ipQ()
  {
    return WoW;
  }
  
  public static String ipR()
  {
    AppMethodBeat.i(315382);
    String str = Z(new u(((au)WoV.get(Integer.valueOf(1))).iqp(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(315382);
    return str;
  }
  
  public static Intent ipS()
  {
    AppMethodBeat.i(117672);
    Intent localIntent = bI(new Intent());
    AppMethodBeat.o(117672);
    return localIntent;
  }
  
  public static void ipT()
  {
    AppMethodBeat.i(117680);
    aa(0L, false);
    AppMethodBeat.o(117680);
  }
  
  public static void ipU()
  {
    AppMethodBeat.i(315469);
    aa(1000L, false);
    AppMethodBeat.o(315469);
  }
  
  public static void ipV()
  {
    AppMethodBeat.i(184552);
    aa(0L, true);
    AppMethodBeat.o(184552);
  }
  
  public static void ipW()
  {
    AppMethodBeat.i(315492);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "preloadWxaSearch %s", new Object[] { Long.valueOf(0L) });
    com.tencent.threadpool.h.ahAA.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315348);
        Object localObject = com.tencent.mm.util.i.agtt;
        if (com.tencent.mm.util.i.a(b.a.agqM, 1) != 1)
        {
          AppMethodBeat.o(315348);
          return;
        }
        if (com.tencent.mm.compatible.util.d.rc(29))
        {
          AppMethodBeat.o(315348);
          return;
        }
        localObject = aj.ipX();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ao.iqg().C((String)localObject, 5, false);
        }
        AppMethodBeat.o(315348);
      }
    }, 0L, "WebSearchThread");
    AppMethodBeat.o(315492);
  }
  
  public static String ipX()
  {
    AppMethodBeat.i(315495);
    Object localObject = new HashMap();
    ((Map)localObject).put("scene", "-1");
    ((Map)localObject).put("type", "64");
    ((Map)localObject).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((Map)localObject).put("platform", "android");
    ((Map)localObject).put("version", String.valueOf(((au)WoV.get(Integer.valueOf(3))).bIG()));
    ((Map)localObject).put("isHomePage", "0");
    ((Map)localObject).put("isSug", "1");
    ((Map)localObject).put("netType", gtA());
    ((Map)localObject).put("WASessionId", "");
    ((Map)localObject).put("sessionId", "");
    ((Map)localObject).put("subSessionId", "");
    ((Map)localObject).put("isPreload", "1");
    localObject = h((Map)localObject, 3);
    AppMethodBeat.o(315495);
    return localObject;
  }
  
  public static boolean ipY()
  {
    AppMethodBeat.i(117692);
    JSONObject localJSONObject = al.bix("snsContactMatch");
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
  
  public static int ipZ()
  {
    AppMethodBeat.i(117695);
    JSONObject localJSONObject = al.bix("snsContactMatch");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("queryUtfLenLimit");
      AppMethodBeat.o(117695);
      return i;
    }
    AppMethodBeat.o(117695);
    return 0;
  }
  
  public static acm iqa()
  {
    AppMethodBeat.i(315530);
    acm localacm = new acm();
    localacm.ZkR = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    if (localacm.ZkR)
    {
      localacm.ZkO = atc(((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq());
      localacm.ZkP = atc(((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr());
      localacm.ZkQ = atc(((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD());
    }
    AppMethodBeat.o(315530);
    return localacm;
  }
  
  public static String iqb()
  {
    AppMethodBeat.i(315531);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(315531);
      return "wifi";
    }
    if (isFreeSimCard())
    {
      AppMethodBeat.o(315531);
      return "wangka";
    }
    if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(315531);
      return "4g";
    }
    if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(315531);
      return "3g";
    }
    if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(315531);
      return "2g";
    }
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(315531);
      return "fail";
    }
    AppMethodBeat.o(315531);
    return "";
  }
  
  public static boolean isFreeSimCard()
  {
    AppMethodBeat.i(315533);
    int i = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class)).gbv();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(315533);
      return bool;
    }
  }
  
  public static Map<String, String> r(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(117674);
    Map localMap = a(paramInt1, paramBoolean, paramInt2, "");
    AppMethodBeat.o(117674);
    return localMap;
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
  
  public static boolean xG(long paramLong)
  {
    AppMethodBeat.i(117691);
    Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWt, Long.valueOf(paramLong));
    AppMethodBeat.o(117691);
    return false;
  }
  
  private static boolean xH(long paramLong)
  {
    return paramLong == 100203L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */