package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.my;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public final class aa
{
  private static Map<Integer, ao> uJf;
  private static Map<Integer, k> uJg;
  private static int uJh;
  
  static
  {
    AppMethodBeat.i(124148);
    uJf = new HashMap();
    uJg = new HashMap();
    uJf.put(Integer.valueOf(2), new ao("wxa_fts/res", "wxa_fts_template.zip", ""));
    uJf.put(Integer.valueOf(1), new ao("fts_browse/res", "wrd_template.zip", "browse"));
    uJf.put(Integer.valueOf(0), new ao("fts/res", "fts_template.zip", ""));
    Map localMap = uJg;
    Jb(0);
    localMap.put(Integer.valueOf(0), ag.cZz());
    localMap = uJg;
    Jb(1);
    localMap.put(Integer.valueOf(1), ag.cZz());
    localMap = uJg;
    Jb(2);
    localMap.put(Integer.valueOf(2), ag.cZz());
    AppMethodBeat.o(124148);
  }
  
  public static String F(Map<String, String> paramMap)
  {
    AppMethodBeat.i(156851);
    paramMap = d(paramMap, 0);
    AppMethodBeat.o(156851);
    return paramMap;
  }
  
  public static final String IZ(int paramInt)
  {
    AppMethodBeat.i(124092);
    Object localObject = new StringBuilder().append(paramInt).append("_");
    g.RJ();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(124092);
    return localObject;
  }
  
  public static ao Ja(int paramInt)
  {
    AppMethodBeat.i(124093);
    ao localao = (ao)uJf.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(124093);
    return localao;
  }
  
  private static String Jb(int paramInt)
  {
    AppMethodBeat.i(124094);
    Object localObject = (ao)uJf.get(Integer.valueOf(paramInt));
    localObject = ((ao)localObject).aLw() + "/app.html";
    AppMethodBeat.o(124094);
    return localObject;
  }
  
  public static boolean Jc(int paramInt)
  {
    AppMethodBeat.i(124098);
    if (paramInt == 2)
    {
      AppMethodBeat.o(124098);
      return true;
    }
    boolean bool = ((ao)uJf.get(Integer.valueOf(paramInt))).cZP();
    AppMethodBeat.o(124098);
    return bool;
  }
  
  public static int Jd(int paramInt)
  {
    AppMethodBeat.i(124099);
    localObject1 = (ao)uJf.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(((ao)localObject1).uKp)) {}
    for (Object localObject4 = "config.conf";; localObject4 = ((ao)localObject1).uKp + "/config.conf")
    {
      AssetManager localAssetManager = ah.getContext().getAssets();
      Properties localProperties = new Properties();
      localObject3 = null;
      localObject1 = null;
      try
      {
        localObject4 = localAssetManager.open((String)localObject4);
        localObject1 = localObject4;
        localObject3 = localObject4;
        localProperties.load((InputStream)localObject4);
        bo.b((Closeable)localObject4);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject1;
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
          bo.b((Closeable)localObject1);
        }
      }
      finally
      {
        bo.b(localObject3);
        AppMethodBeat.o(124099);
      }
      paramInt = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
      AppMethodBeat.o(124099);
      return paramInt;
    }
  }
  
  public static boolean Je(int paramInt)
  {
    AppMethodBeat.i(124100);
    ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    if (((ao)uJf.get(Integer.valueOf(paramInt))).agn() > 1)
    {
      AppMethodBeat.o(124100);
      return true;
    }
    AppMethodBeat.o(124100);
    return false;
  }
  
  public static int Jf(int paramInt)
  {
    AppMethodBeat.i(124101);
    paramInt = ((ao)uJf.get(Integer.valueOf(paramInt))).agn();
    AppMethodBeat.o(124101);
    return paramInt;
  }
  
  public static void Jg(int paramInt)
  {
    uJh = paramInt;
  }
  
  private static boolean Jh(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(124102);
    AssetManager localAssetManager = ah.getContext().getAssets();
    Object localObject3 = ((ao)uJf.get(Integer.valueOf(paramInt))).cZO();
    Object localObject1 = (ao)uJf.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(((ao)localObject1).uKp)) {}
    for (localObject1 = ((ao)localObject1).uKo; (bo.isNullOrNil((String)localObject3)) || (bo.isNullOrNil((String)localObject1)); localObject1 = ((ao)localObject1).uKp + "/" + ((ao)localObject1).uKo)
    {
      ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
      AppMethodBeat.o(124102);
      return false;
    }
    try
    {
      localObject1 = localAssetManager.open((String)localObject1);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
        AppMethodBeat.o(124102);
        return false;
      }
    }
    catch (IOException localIOException1)
    {
      InputStream localInputStream;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException1, "", new Object[0]);
        localInputStream = null;
      }
      localObject3 = new b((String)localObject3);
      if (((b)localObject3).exists()) {
        ((b)localObject3).delete();
      }
      ((b)localObject3).dQI().mkdirs();
      try
      {
        localObject3 = com.tencent.mm.vfs.e.r((b)localObject3);
        localObject2 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          try
          {
            copyFile(localInputStream, localObject2);
            return true;
          }
          catch (IOException localIOException2)
          {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException2, "", new Object[0]);
            return false;
          }
          finally
          {
            bo.b(localInputStream);
            bo.b(localObject2);
            AppMethodBeat.o(124102);
          }
          localFileNotFoundException = localFileNotFoundException;
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localFileNotFoundException, "", new Object[0]);
        }
      }
      if (localObject2 != null) {}
      bo.b(localInputStream);
      AppMethodBeat.o(124102);
    }
    return false;
  }
  
  public static String Ji(int paramInt)
  {
    AppMethodBeat.i(124104);
    String str = ((ao)uJf.get(Integer.valueOf(paramInt))).cZO();
    AppMethodBeat.o(124104);
    return str;
  }
  
  public static void Jj(int paramInt)
  {
    AppMethodBeat.i(124105);
    ((ao)uJf.get(Integer.valueOf(paramInt))).cZM();
    AppMethodBeat.o(124105);
  }
  
  public static String Jk(int paramInt)
  {
    AppMethodBeat.i(124106);
    String str = ((ao)uJf.get(Integer.valueOf(paramInt))).aLw();
    AppMethodBeat.o(124106);
    return str;
  }
  
  public static String Jl(int paramInt)
  {
    AppMethodBeat.i(124107);
    String str = ((ao)uJf.get(Integer.valueOf(Jo(paramInt)))).aLw();
    AppMethodBeat.o(124107);
    return str;
  }
  
  public static String Jm(int paramInt)
  {
    AppMethodBeat.i(124108);
    String str = ((ao)uJf.get(Integer.valueOf(Jo(paramInt)))).uKo;
    AppMethodBeat.o(124108);
    return str;
  }
  
  public static int Jn(int paramInt)
  {
    AppMethodBeat.i(124109);
    paramInt = ((ao)uJf.get(Integer.valueOf(Jo(paramInt)))).agn();
    AppMethodBeat.o(124109);
    return paramInt;
  }
  
  private static int Jo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  public static String Jp(int paramInt)
  {
    AppMethodBeat.i(124110);
    String str = l(new b(((ao)uJf.get(Integer.valueOf(paramInt))).aLw(), "config_data.conf")).getProperty("kv_set", "");
    AppMethodBeat.o(124110);
    return str;
  }
  
  public static long ZN(String paramString)
  {
    AppMethodBeat.i(124130);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(124130);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(124130);
    return l;
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    AppMethodBeat.i(124140);
    paramMap = t(paramMap, paramString);
    if (bo.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(124140);
      return paramLong;
    }
    try
    {
      long l = Long.valueOf(paramMap).longValue();
      AppMethodBeat.o(124140);
      return l;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(124140);
    }
    return paramLong;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    AppMethodBeat.i(124117);
    paramString = a(paramInt1, paramBoolean, paramInt2, paramString, "");
    AppMethodBeat.o(124117);
    return paramString;
  }
  
  private static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124118);
    paramString1 = a(paramInt1, paramBoolean, paramInt2, paramString1, "", "", "", "", "", paramString2);
    AppMethodBeat.o(124118);
    return paramString1;
  }
  
  private static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(124119);
    paramString1 = a(paramInt1, paramBoolean, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "");
    AppMethodBeat.o(124119);
    return paramString1;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(124115);
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
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()));
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
      paramString1 = String.valueOf(Jf(0));
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
        label400:
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
        if (bool1) {
          localHashMap.put("isSug", "1");
        }
        if (bool6) {
          localHashMap.put("isLocalSug", "1");
        }
        if (bool5) {
          localHashMap.put("isMostSearchBiz", "1");
        }
        if (!paramBoolean) {
          localHashMap.put("isHomePage", "0");
        }
        break;
      }
      break;
    }
    for (;;)
    {
      float f2 = com.tencent.mm.cb.a.dr(ah.getContext());
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
      localHashMap.put("netType", bXn());
      if (com.tencent.mm.aw.a.aiw())
      {
        paramString1 = com.tencent.mm.aw.a.aiz();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.fKj);
        }
      }
      AppMethodBeat.o(124115);
      return localHashMap;
      paramString1 = String.valueOf(Jf(1));
      break;
      paramString1 = ac.agv("mixGlobal");
      if (paramBoolean)
      {
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (paramString1.optInt("mixSugSwitch", 0) != 1) {
          break label400;
        }
      }
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
          if (ac.agv("bizTab").optInt("bizSugSwitch", 0) == 1) {
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (paramInt2 == 2)
        {
          bool1 = bool2;
          if (ac.agv("articleTab").optInt("sugSwitch", 0) == 1) {
            bool1 = true;
          }
        }
        bool3 = bool1;
        bool2 = bool5;
        if (paramInt2 == 8)
        {
          paramString1 = ac.agv("snsTab");
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
            if (ac.agv("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
        }
        bool3 = bool4;
        if (paramInt2 == 1)
        {
          bool3 = bool4;
          if (ac.agv("bizTab").optInt("mfsBizSwitch", 0) == 1) {
            bool3 = true;
          }
        }
        bool4 = bool1;
        if (paramInt2 == 1024)
        {
          bool4 = bool1;
          if (ac.agv("novelTab").optInt("sugSwitch", 0) == 1) {
            bool4 = true;
          }
        }
        bool1 = bool4;
        if (paramInt2 == 512)
        {
          bool1 = bool4;
          if (ac.agv("musicTab").optInt("sugSwitch", 0) == 1) {
            bool1 = true;
          }
        }
        bool4 = bool1;
        if (paramInt2 == 384)
        {
          bool4 = bool1;
          if (ac.agv("emotionTab").optInt("sugSwitch", 0) == 1) {
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
        if (ac.agv("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
          break;
        }
        bool1 = true;
        bool5 = bool3;
        bool6 = bool2;
        break;
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (ac.agv("bizEntry").optInt("sugSwitch") != 1) {
          break;
        }
        continue;
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (ac.agv("bizUnionTopEntry").optInt("sugSwitch") != 1) {
          break;
        }
      }
      bool1 = bool7;
      bool5 = bool3;
      bool6 = bool2;
      if (paramInt2 != 384) {
        break label400;
      }
      bool1 = bool7;
      bool5 = bool3;
      bool6 = bool2;
      if (ac.agv("emoticonMall").optInt("sugSwitch", 0) != 1) {
        break label400;
      }
      bool1 = true;
      bool5 = bool3;
      bool6 = bool2;
      break label400;
      localHashMap.put("isHomePage", "1");
    }
  }
  
  public static void a(Activity paramActivity, ckw paramckw)
  {
    AppMethodBeat.i(124146);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramckw.toByteArray());
      label26:
      if (nl(paramckw.xUO))
      {
        e(paramActivity, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        AppMethodBeat.o(124146);
        return;
      }
      e(paramActivity, ".ui.video.list.TopStoryListVideoUI", localIntent);
      AppMethodBeat.o(124146);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public static void a(Context paramContext, ckw paramckw)
  {
    AppMethodBeat.i(124147);
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", paramckw.toByteArray());
      label26:
      if (nl(paramckw.xUO))
      {
        d(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        AppMethodBeat.o(124147);
        return;
      }
      d(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent);
      AppMethodBeat.o(124147);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(124121);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      AppMethodBeat.o(124121);
      return;
    }
    Intent localIntent = ay(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = IZ(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = IZ(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!bo.isNullOrNil("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", d(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        AppMethodBeat.o(124121);
        return;
      }
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(124129);
    paramIntent.putExtra("ftsbizscene", paramInt);
    Map localMap = d(paramInt, false, 384);
    String str = IZ(bo.apV((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", d(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
    AppMethodBeat.o(124129);
  }
  
  public static void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(124144);
    a(paramb, paramInt, false);
    AppMethodBeat.o(124144);
  }
  
  public static void a(b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124145);
    for (;;)
    {
      Object localObject = Ji(paramInt);
      if (bo.isNullOrNil((String)localObject))
      {
        ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", new Object[] { Integer.valueOf(paramInt), j.p(paramb.dQJ()) });
        AppMethodBeat.o(124145);
        return;
      }
      if (!paramb.exists()) {
        paramb.mkdirs();
      }
      b localb = new b(paramb, ".nomedia");
      if (!localb.exists()) {}
      try
      {
        localb.createNewFile();
        localObject = new b((String)localObject);
        if (Jh(paramInt))
        {
          i = bo.ii(j.p(((b)localObject).dQJ()), ((b)localObject).getParent());
          if (i < 0)
          {
            ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.p(((b)localObject).dQJ()) + ", unzipPath = " + ((b)localObject).getParent());
            if ((paramBoolean) || (paramInt != 0) || (Jc(paramInt))) {
              break label314;
            }
            ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "init template fail, try again , ftsTemplateFolder %s, type %d", new Object[] { paramb, Integer.valueOf(paramInt) });
            paramBoolean = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException, "create nomedia file error", new Object[0]);
          continue;
          Jj(paramInt);
          int i = Jf(paramInt);
          ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "Unzip Path%s version=%d", new Object[] { ((b)localObject).getParent(), Integer.valueOf(i) });
          continue;
          ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "copy template file from asset fail %s", new Object[] { j.p(((b)localObject).dQJ()) });
        }
        label314:
        AppMethodBeat.o(124145);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(124133);
    mx localmx = new mx();
    localmx.cCV.query = paramString4;
    localmx.cCV.cpW = paramString2;
    localmx.cCV.cCW = paramString3;
    localmx.cCV.scene = paramInt1;
    localmx.cCV.cCX = paramString1;
    localmx.cCV.cCZ = paramString5;
    localmx.cCV.cDa = paramInt2;
    localmx.cCV.cCY = paramString6;
    com.tencent.mm.sdk.b.a.ymk.l(localmx);
    AppMethodBeat.o(124133);
  }
  
  public static azu acv()
  {
    AppMethodBeat.i(124112);
    try
    {
      Object localObject = (String)g.RL().Ru().get(67591, null);
      if (localObject != null)
      {
        azu localazu = new azu();
        localObject = ((String)localObject).split(",");
        localazu.wSk = Integer.valueOf(localObject[0]).intValue();
        localazu.wSn = Integer.valueOf(localObject[1]).intValue();
        localazu.wDi = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localazu.wDh = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localazu.wDi), Float.valueOf(localazu.wDh) });
        AppMethodBeat.o(124112);
        return localazu;
      }
      ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(124112);
      return null;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(124112);
    }
    return null;
  }
  
  public static void agr(String paramString)
  {
    AppMethodBeat.i(124125);
    g.RO().ac(new aa.2(paramString));
    AppMethodBeat.o(124125);
  }
  
  public static void ags(String paramString)
  {
    AppMethodBeat.i(124134);
    my localmy = new my();
    localmy.cDb.scene = 201;
    localmy.cDb.cpW = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localmy);
    AppMethodBeat.o(124134);
  }
  
  public static String an(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(124136);
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
    AppMethodBeat.o(124136);
    return paramMap;
  }
  
  private static Intent ay(Intent paramIntent)
  {
    AppMethodBeat.i(124113);
    if (paramIntent == null)
    {
      AppMethodBeat.o(124113);
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    paramIntent.putExtra("neverGetA8Key", true);
    AppMethodBeat.o(124113);
    return paramIntent;
  }
  
  public static String bXn()
  {
    AppMethodBeat.i(124111);
    if (at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(124111);
      return "wifi";
    }
    if (at.is4G(ah.getContext()))
    {
      AppMethodBeat.o(124111);
      return "4g";
    }
    if (at.is3G(ah.getContext()))
    {
      AppMethodBeat.o(124111);
      return "3g";
    }
    if (at.is2G(ah.getContext()))
    {
      AppMethodBeat.o(124111);
      return "2g";
    }
    if (!at.isConnected(ah.getContext()))
    {
      AppMethodBeat.o(124111);
      return "fail";
    }
    AppMethodBeat.o(124111);
    return "";
  }
  
  public static String bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(124126);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    localHashMap.put("type", "64");
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(((ao)uJf.get(Integer.valueOf(2))).agn()));
    localHashMap.put("isHomePage", "0");
    localHashMap.put("isSug", "1");
    localHashMap.put("netType", bXn());
    localHashMap.put("WASessionId", paramString);
    localHashMap.put("sessionId", paramString);
    localHashMap.put("subSessionId", paramString);
    localHashMap.put("isPreload", "1");
    paramString = d(localHashMap, 2);
    AppMethodBeat.o(124126);
    return paramString;
  }
  
  public static String cZl()
  {
    AppMethodBeat.i(124095);
    uJf.get(Integer.valueOf(1));
    AppMethodBeat.o(124095);
    return "app.html";
  }
  
  public static String cZm()
  {
    AppMethodBeat.i(124096);
    uJf.get(Integer.valueOf(1));
    AppMethodBeat.o(124096);
    return "config.conf";
  }
  
  public static void cZn()
  {
    AppMethodBeat.i(124097);
    Iterator localIterator = uJg.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(124097);
  }
  
  public static int cZo()
  {
    return uJh;
  }
  
  public static Intent cZp()
  {
    AppMethodBeat.i(124114);
    Intent localIntent = ay(new Intent());
    AppMethodBeat.o(124114);
    return localIntent;
  }
  
  public static void cZq()
  {
    AppMethodBeat.i(124122);
    nj(0L);
    AppMethodBeat.o(124122);
  }
  
  public static String cZr()
  {
    AppMethodBeat.i(124124);
    String str = IZ(-1);
    Map localMap = d(-1, true, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    str = d(localMap, 0);
    AppMethodBeat.o(124124);
    return str;
  }
  
  public static boolean cZs()
  {
    AppMethodBeat.i(124132);
    JSONObject localJSONObject = ac.agv("snsContactMatch");
    if (localJSONObject != null)
    {
      if (localJSONObject.optInt("matchSwitch") == 1)
      {
        AppMethodBeat.o(124132);
        return true;
      }
      AppMethodBeat.o(124132);
      return false;
    }
    AppMethodBeat.o(124132);
    return false;
  }
  
  public static int cZt()
  {
    AppMethodBeat.i(124135);
    JSONObject localJSONObject = ac.agv("snsContactMatch");
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("queryUtfLenLimit");
      AppMethodBeat.o(124135);
      return i;
    }
    AppMethodBeat.o(124135);
    return 0;
  }
  
  public static boolean cZu()
  {
    AppMethodBeat.i(124143);
    boolean bool = f.CLIENT_VERSION.endsWith("0F");
    AppMethodBeat.o(124143);
    return bool;
  }
  
  private static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(124103);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(124103);
  }
  
  public static int d(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(124139);
    paramMap = t(paramMap, paramString);
    if (bo.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(124139);
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramMap).intValue();
      AppMethodBeat.o(124139);
      return i;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(124139);
    }
    return paramInt;
  }
  
  public static String d(Map<String, String> paramMap, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(124128);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject1 = Ja(paramInt).aLw();
    Object localObject2 = new StringBuilder();
    aj localaj = aj.cZB();
    if (paramInt == 1)
    {
      i = 2;
      if (!localaj.Js(i)) {
        break label220;
      }
    }
    label220:
    for (int i = j;; i = 0)
    {
      paramMap.put("isOpenPreload", i);
      localStringBuffer.append((String)localObject1);
      if (paramMap.size() <= 0) {
        break label411;
      }
      localObject1 = localStringBuffer.append("/");
      Ja(paramInt);
      ((StringBuffer)localObject1).append("app.html?");
      localObject1 = paramMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localStringBuffer.append((String)((Map.Entry)localObject2).getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)((Map.Entry)localObject2).getValue());
        localStringBuffer.append("&");
      }
      i = 1;
      break;
    }
    localObject1 = (String)paramMap.get("sessionId");
    if (!paramMap.containsKey("sessionId"))
    {
      localObject1 = IZ(bo.apV((String)paramMap.get("scene")));
      localStringBuffer.append("sessionId");
      localStringBuffer.append("=");
      localStringBuffer.append((String)localObject1);
      localStringBuffer.append("&");
    }
    if (!paramMap.containsKey("subSessionId"))
    {
      localStringBuffer.append("subSessionId");
      localStringBuffer.append("=");
      localStringBuffer.append((String)localObject1);
      localStringBuffer.append("&");
    }
    localStringBuffer.append("wechatVersion");
    localStringBuffer.append("=");
    localStringBuffer.append(com.tencent.mm.protocal.d.whH);
    localStringBuffer.append("&");
    paramMap = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    AppMethodBeat.o(124128);
    return paramMap;
    label411:
    paramMap = localStringBuffer.append("/");
    Ja(paramInt);
    paramMap.append("app.html");
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(124128);
    return paramMap;
  }
  
  public static Map<String, String> d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(124116);
    Map localMap = a(paramInt1, paramBoolean, paramInt2, "");
    AppMethodBeat.o(124116);
    return localMap;
  }
  
  public static void d(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(124141);
    try
    {
      String str2 = ah.dsO() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ah.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(paramIntent);
        AppMethodBeat.o(124141);
        return;
      }
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
      AppMethodBeat.o(124141);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(124141);
    }
  }
  
  private static void e(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(124142);
    try
    {
      String str2 = ah.dsO() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ah.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, 10001);
      }
      AppMethodBeat.o(124142);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(124142);
    }
  }
  
  public static Properties l(b paramb)
  {
    AppMethodBeat.i(124091);
    Properties localProperties = new Properties();
    if ((paramb != null) && (paramb.isFile()))
    {
      localObject = null;
      localb = null;
    }
    try
    {
      paramb = com.tencent.mm.vfs.e.q(paramb);
      localb = paramb;
      localObject = paramb;
      localProperties.load(paramb);
      bo.b(paramb);
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        localObject = localb;
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", paramb, "", new Object[0]);
        bo.b(localb);
      }
    }
    finally
    {
      bo.b((Closeable)localObject);
      AppMethodBeat.o(124091);
    }
    AppMethodBeat.o(124091);
    return localProperties;
  }
  
  /* Error */
  public static boolean l(Activity paramActivity, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1091
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 1093
    //   10: invokestatic 1099	android/support/v4/content/b:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +59 -> 74
    //   18: getstatic 1105	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
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
    //   42: invokevirtual 1108	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   45: ldc_w 1091
    //   48: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 215
    //   56: aload_0
    //   57: ldc 43
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 1091
    //   69: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_1
    //   73: ireturn
    //   74: getstatic 1105	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
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
    //   98: invokevirtual 1108	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ldc_w 1093
    //   105: invokestatic 1113	android/support/v4/app/a:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 215
    //   113: ldc_w 1115
    //   116: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 1091
    //   122: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 215
    //   129: ldc_w 1117
    //   132: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: iconst_1
    //   137: anewarray 387	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc_w 1093
    //   145: aastore
    //   146: bipush 73
    //   148: invokestatic 1120	android/support/v4/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   151: ldc_w 1091
    //   154: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 215
    //   162: aload_0
    //   163: ldc 43
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static void nj(long paramLong)
  {
    AppMethodBeat.i(124123);
    aj.cZB().cZC();
    g.RO().o(new aa.1(), paramLong);
    AppMethodBeat.o(124123);
  }
  
  public static boolean nk(long paramLong)
  {
    AppMethodBeat.i(124131);
    ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.RL().Ru().set(ac.a.yJV, Long.valueOf(paramLong));
    AppMethodBeat.o(124131);
    return false;
  }
  
  private static boolean nl(long paramLong)
  {
    return paramLong == 100203L;
  }
  
  public static String t(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(124137);
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null)
      {
        paramMap = paramMap.get(paramString).toString();
        AppMethodBeat.o(124137);
        return paramMap;
      }
      AppMethodBeat.o(124137);
      return "";
    }
    AppMethodBeat.o(124137);
    return "";
  }
  
  public static boolean u(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(124138);
    paramMap = t(paramMap, paramString);
    if (bo.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(124138);
      return false;
    }
    try
    {
      boolean bool = "1".equals(paramMap);
      if (bool)
      {
        AppMethodBeat.o(124138);
        return true;
      }
      bool = "0".equals(paramMap);
      if (bool)
      {
        AppMethodBeat.o(124138);
        return false;
      }
      bool = Boolean.valueOf(paramMap).booleanValue();
      AppMethodBeat.o(124138);
      return bool;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(124138);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */