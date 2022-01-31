package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.h.a.mf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  private static Map<Integer, ap> qTW = new HashMap();
  private static Map<Integer, k> qTX = new HashMap();
  
  static
  {
    qTW.put(Integer.valueOf(1), new ap("fts_browse/res", "wrd_template.zip", "browse"));
    qTW.put(Integer.valueOf(0), new ap("fts/res", "fts_template.zip", ""));
    Map localMap = qTX;
    Bo(0);
    localMap.put(Integer.valueOf(0), ag.bZD());
    localMap = qTX;
    Bo(1);
    localMap.put(Integer.valueOf(1), ag.bZD());
  }
  
  private static int BA(int paramInt)
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
  
  public static String BB(int paramInt)
  {
    return j(new com.tencent.mm.vfs.b(((ap)qTW.get(Integer.valueOf(paramInt))).aoA(), "config_data.conf")).getProperty("kv_set", "");
  }
  
  public static final String Bm(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append("_");
    g.DN();
    return o.getString(com.tencent.mm.kernel.a.CK()) + "_" + System.currentTimeMillis();
  }
  
  public static ap Bn(int paramInt)
  {
    return (ap)qTW.get(Integer.valueOf(paramInt));
  }
  
  private static String Bo(int paramInt)
  {
    ap localap = (ap)qTW.get(Integer.valueOf(paramInt));
    return localap.aoA() + "/app.html";
  }
  
  public static boolean Bp(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(paramInt))).bZU();
  }
  
  public static int Bq(int paramInt)
  {
    localObject1 = (ap)qTW.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(((ap)localObject1).qVe)) {}
    for (Object localObject4 = "config.conf";; localObject4 = ((ap)localObject1).qVe + "/config.conf")
    {
      AssetManager localAssetManager = ae.getContext().getAssets();
      Properties localProperties = new Properties();
      localObject3 = null;
      localObject1 = null;
      try
      {
        localObject4 = localAssetManager.open((String)localObject4);
        localObject1 = localObject4;
        localObject3 = localObject4;
        localProperties.load((InputStream)localObject4);
        bk.b((Closeable)localObject4);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject1;
          y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localException, localException.getMessage(), new Object[0]);
          bk.b((Closeable)localObject1);
        }
      }
      finally
      {
        bk.b(localObject3);
      }
      return Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    }
  }
  
  public static boolean Br(int paramInt)
  {
    y.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[] { Integer.valueOf(paramInt) });
    return ((ap)qTW.get(Integer.valueOf(paramInt))).NA() > 1;
  }
  
  public static int Bs(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(paramInt))).NA();
  }
  
  private static boolean Bt(int paramInt)
  {
    Object localObject2 = null;
    AssetManager localAssetManager = ae.getContext().getAssets();
    Object localObject3 = ((ap)qTW.get(Integer.valueOf(paramInt))).bZT();
    Object localObject1 = (ap)qTW.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(((ap)localObject1).qVe)) {}
    for (localObject1 = ((ap)localObject1).qVd; (bk.bl((String)localObject3)) || (bk.bl((String)localObject1)); localObject1 = ((ap)localObject1).qVe + "/" + ((ap)localObject1).qVd)
    {
      y.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
      return false;
    }
    try
    {
      localObject1 = localAssetManager.open((String)localObject1);
      if (localObject1 == null)
      {
        y.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
        return false;
      }
    }
    catch (IOException localIOException1)
    {
      InputStream localInputStream;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException1, "", new Object[0]);
        localInputStream = null;
      }
      localObject3 = new com.tencent.mm.vfs.b((String)localObject3);
      if (((com.tencent.mm.vfs.b)localObject3).exists()) {
        ((com.tencent.mm.vfs.b)localObject3).delete();
      }
      ((com.tencent.mm.vfs.b)localObject3).cLq().mkdirs();
      try
      {
        localObject3 = com.tencent.mm.vfs.e.p((com.tencent.mm.vfs.b)localObject3);
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
            y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException2, "", new Object[0]);
            return false;
          }
          finally
          {
            bk.b(localInputStream);
            bk.b(localObject2);
          }
          localFileNotFoundException = localFileNotFoundException;
          y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localFileNotFoundException, "", new Object[0]);
        }
      }
      if (localObject2 != null) {}
      bk.b(localInputStream);
    }
    return false;
  }
  
  public static String Bu(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(paramInt))).bZT();
  }
  
  public static void Bv(int paramInt)
  {
    ((ap)qTW.get(Integer.valueOf(paramInt))).bZR();
  }
  
  public static String Bw(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(paramInt))).aoA();
  }
  
  public static String Bx(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(BA(paramInt)))).aoA();
  }
  
  public static String By(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(BA(paramInt)))).qVd;
  }
  
  public static int Bz(int paramInt)
  {
    return ((ap)qTW.get(Integer.valueOf(BA(paramInt)))).NA();
  }
  
  public static atp Jx()
  {
    try
    {
      Object localObject = (String)g.DP().Dz().get(67591, null);
      if (localObject != null)
      {
        atp localatp = new atp();
        localObject = ((String)localObject).split(",");
        localatp.sUn = Integer.valueOf(localObject[0]).intValue();
        localatp.sUq = Integer.valueOf(localObject[1]).intValue();
        localatp.sGK = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localatp.sGJ = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        y.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localatp.sGK), Float.valueOf(localatp.sGJ) });
        return localatp;
      }
      y.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
      return null;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
  
  public static long Ng(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    y.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l) });
    return l;
  }
  
  public static String T(Map<String, ? extends Object> paramMap)
  {
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
    return localStringBuffer.substring(0, localStringBuffer.length() - 1).toString();
  }
  
  public static long a(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    paramMap = s(paramMap, paramString);
    if (bk.bl(paramMap)) {
      return paramLong;
    }
    try
    {
      long l = Long.valueOf(paramMap).longValue();
      return l;
    }
    catch (Exception paramMap) {}
    return paramLong;
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    return a(paramInt1, paramBoolean, paramInt2, paramString, "", "", "", "", "", "", "");
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
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
    localHashMap.put("lang", x.fB(ae.getContext()));
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
      paramString1 = String.valueOf(Bs(0));
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
        label396:
        y.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool5) });
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
      float f2 = com.tencent.mm.cb.a.cJ(ae.getContext());
      float f1 = f2;
      if (f2 != 1.0F)
      {
        f1 = f2;
        if (f2 != 0.875F)
        {
          f1 = f2;
          if (f2 != 1.125F)
          {
            f1 = f2;
            if (f2 != 1.25F)
            {
              f1 = f2;
              if (f2 != 1.375F)
              {
                f1 = f2;
                if (f2 != 1.625F)
                {
                  f1 = f2;
                  if (f2 != 1.875F)
                  {
                    f1 = f2;
                    if (f2 != 2.025F) {
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
      localHashMap.put("netType", boM());
      if (com.tencent.mm.av.a.Pu())
      {
        paramString1 = com.tencent.mm.av.a.Pw();
        if (paramString1 != null) {
          localHashMap.put("musicSnsId", paramString1.eux);
        }
      }
      return localHashMap;
      paramString1 = String.valueOf(Bs(1));
      break;
      paramString1 = ac.Ru("mixGlobal");
      if (paramBoolean)
      {
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (paramString1.optInt("mixSugSwitch", 0) != 1) {
          break label396;
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
          if (ac.Ru("bizTab").optInt("bizSugSwitch", 0) == 1) {
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (paramInt2 == 2)
        {
          bool1 = bool2;
          if (ac.Ru("articleTab").optInt("sugSwitch", 0) == 1) {
            bool1 = true;
          }
        }
        bool3 = bool1;
        bool2 = bool5;
        if (paramInt2 == 8)
        {
          paramString1 = ac.Ru("snsTab");
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
            if (ac.Ru("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
              bool1 = true;
            }
          }
        }
        bool3 = bool4;
        if (paramInt2 == 1)
        {
          bool3 = bool4;
          if (ac.Ru("bizTab").optInt("mfsBizSwitch", 0) == 1) {
            bool3 = true;
          }
        }
        bool4 = bool1;
        if (paramInt2 == 1024)
        {
          bool4 = bool1;
          if (ac.Ru("novelTab").optInt("sugSwitch", 0) == 1) {
            bool4 = true;
          }
        }
        bool1 = bool4;
        if (paramInt2 == 512)
        {
          bool1 = bool4;
          if (ac.Ru("musicTab").optInt("sugSwitch", 0) == 1) {
            bool1 = true;
          }
        }
        bool4 = bool1;
        if (paramInt2 == 384)
        {
          bool4 = bool1;
          if (ac.Ru("emotionTab").optInt("sugSwitch", 0) == 1) {
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
        if (ac.Ru("mixGlobal").optInt("mixSugSwitch", 0) != 1) {
          break;
        }
        bool1 = true;
        bool5 = bool3;
        bool6 = bool2;
        break;
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (ac.Ru("bizEntry").optInt("sugSwitch") != 1) {
          break;
        }
        continue;
        bool1 = bool7;
        bool5 = bool3;
        bool6 = bool2;
        if (ac.Ru("bizUnionTopEntry").optInt("sugSwitch") != 1) {
          break;
        }
      }
      bool1 = bool7;
      bool5 = bool3;
      bool6 = bool2;
      if (paramInt2 != 384) {
        break label396;
      }
      bool1 = bool7;
      bool5 = bool3;
      bool6 = bool2;
      if (ac.Ru("emoticonMall").optInt("sugSwitch", 0) != 1) {
        break label396;
      }
      bool1 = true;
      bool5 = bool3;
      bool6 = bool2;
      break label396;
      localHashMap.put("isHomePage", "1");
    }
  }
  
  public static void a(Activity paramActivity, byf parambyf)
  {
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parambyf.toByteArray());
      label20:
      if (gP(parambyf.tOo))
      {
        d(paramActivity, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        return;
      }
      d(paramActivity, ".ui.video.list.TopStoryListVideoUI", localIntent);
      return;
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public static void a(Context paramContext, byf parambyf)
  {
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("key_context", parambyf.toByteArray());
      label20:
      if (gP(parambyf.tOo))
      {
        c(paramContext, ".ui.video.fs.TopStoryFSVideoUI", localIntent);
        return;
      }
      c(paramContext, ".ui.video.list.TopStoryListVideoUI", localIntent);
      return;
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public static void a(Context paramContext, String paramString1, Intent paramIntent, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
      return;
    }
    Intent localIntent = ab(paramIntent);
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("title", paramString2);
    }
    localIntent.putExtra("isWebwx", paramString1);
    localIntent.putExtra("ftscaneditable", false);
    localIntent.putExtra("key_load_js_without_delay", true);
    if (TextUtils.isEmpty(paramString5)) {}
    for (paramIntent = Bm(21);; paramIntent = paramString5)
    {
      if (TextUtils.isEmpty(paramString6)) {}
      for (paramString2 = Bm(21);; paramString2 = paramString6)
      {
        paramString1 = a(21, false, 2, paramString3, paramString4, paramIntent, paramString1, "2", paramString2, "", "");
        if (!bk.bl("")) {
          paramString1.put("redPointMsgId", "");
        }
        localIntent.putExtra("rawUrl", c(paramString1, 1));
        localIntent.putExtra("sessionId", paramIntent);
        localIntent.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        localIntent.putExtra("status_bar_style", "black");
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
        return;
      }
    }
  }
  
  public static void a(com.tencent.mm.vfs.b paramb, int paramInt)
  {
    a(paramb, paramInt, false);
  }
  
  public static void a(com.tencent.mm.vfs.b paramb, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject = Bu(paramInt);
      if (bk.bl((String)localObject))
      {
        y.w("MicroMsg.WebSearch.WebSearchApiLogic", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", new Object[] { Integer.valueOf(paramInt), j.n(paramb.cLr()) });
        label43:
        return;
      }
      if (!paramb.exists()) {
        paramb.mkdirs();
      }
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramb, ".nomedia");
      if (!localb.exists()) {}
      try
      {
        localb.createNewFile();
        localObject = new com.tencent.mm.vfs.b((String)localObject);
        if (Bt(paramInt))
        {
          i = bk.gh(j.n(((com.tencent.mm.vfs.b)localObject).cLr()), ((com.tencent.mm.vfs.b)localObject).getParent());
          if (i < 0)
          {
            y.e("MicroMsg.WebSearch.WebSearchApiLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.n(((com.tencent.mm.vfs.b)localObject).cLr()) + ", unzipPath = " + ((com.tencent.mm.vfs.b)localObject).getParent());
            if ((paramBoolean) || (paramInt != 0) || (Bp(paramInt))) {
              break label43;
            }
            y.i("MicroMsg.WebSearch.WebSearchApiLogic", "init template fail, try again , ftsTemplateFolder %s, type %d", new Object[] { paramb, Integer.valueOf(paramInt) });
            paramBoolean = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", localIOException, "create nomedia file error", new Object[0]);
          continue;
          Bv(paramInt);
          int i = Bs(paramInt);
          y.i("MicroMsg.WebSearch.WebSearchApiLogic", "Unzip Path%s version=%d", new Object[] { ((com.tencent.mm.vfs.b)localObject).getParent(), Integer.valueOf(i) });
          continue;
          y.i("MicroMsg.WebSearch.WebSearchApiLogic", "copy template file from asset fail %s", new Object[] { j.n(((com.tencent.mm.vfs.b)localObject).cLr()) });
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2)
  {
    mf localmf = new mf();
    localmf.bVo.bVk = paramString4;
    localmf.bVo.bIB = paramString2;
    localmf.bVo.bVp = paramString3;
    localmf.bVo.scene = paramInt1;
    localmf.bVo.bVq = paramString1;
    localmf.bVo.bVs = paramString5;
    localmf.bVo.bVt = paramInt2;
    com.tencent.mm.sdk.b.a.udP.m(localmf);
  }
  
  private static Intent ab(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    paramIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    paramIntent.putExtra("neverGetA8Key", true);
    return paramIntent;
  }
  
  public static void ac(Intent paramIntent)
  {
    paramIntent.putExtra("ftsbizscene", 24);
    Map localMap = b(24, false, 384);
    String str = Bm(bk.ZR((String)localMap.get("scene")));
    localMap.put("sessionId", str);
    paramIntent.putExtra("sessionId", str);
    paramIntent.putExtra("rawUrl", c(localMap, 0));
    paramIntent.putExtra("ftsType", 384);
  }
  
  public static Map<String, String> b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramBoolean, paramInt2, "");
  }
  
  public static String bZq()
  {
    qTW.get(Integer.valueOf(1));
    return "app.html";
  }
  
  public static String bZr()
  {
    qTW.get(Integer.valueOf(1));
    return "config.conf";
  }
  
  public static void bZs()
  {
    Iterator localIterator = qTX.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public static Intent bZt()
  {
    return ab(new Intent());
  }
  
  public static void bZu()
  {
    gN(0L);
  }
  
  public static String bZv()
  {
    String str = Bm(-1);
    Map localMap = b(-1, true, 0);
    localMap.put("sessionId", str);
    localMap.put("inputMarginTop", "32");
    localMap.put("inputMarginLeftRight", "24");
    localMap.put("inputHeight", "48");
    localMap.put("isPreload", "1");
    return c(localMap, 0);
  }
  
  public static boolean bZw()
  {
    JSONObject localJSONObject = ac.Ru("snsContactMatch");
    if (localJSONObject != null) {
      return localJSONObject.optInt("matchSwitch") == 1;
    }
    return false;
  }
  
  public static int bZx()
  {
    JSONObject localJSONObject = ac.Ru("snsContactMatch");
    if (localJSONObject != null) {
      return localJSONObject.optInt("queryUtfLenLimit");
    }
    return 0;
  }
  
  public static boolean bZy()
  {
    return com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION.endsWith("0F");
  }
  
  public static String boM()
  {
    if (aq.isWifi(ae.getContext())) {
      return "wifi";
    }
    if (aq.is4G(ae.getContext())) {
      return "4g";
    }
    if (aq.is3G(ae.getContext())) {
      return "3g";
    }
    if (aq.is2G(ae.getContext())) {
      return "2g";
    }
    if (!aq.isConnected(ae.getContext())) {
      return "fail";
    }
    return "";
  }
  
  public static int c(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    paramMap = s(paramMap, paramString);
    if (bk.bl(paramMap)) {
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramMap).intValue();
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  public static String c(Map<String, String> paramMap, int paramInt)
  {
    int j = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    Object localObject1 = Bn(paramInt).aoA();
    Object localObject2 = new StringBuilder();
    ak localak = ak.bZF();
    if (paramInt == 1) {}
    for (int i = 2; !ae.cqV(); i = 1) {
      throw new IllegalStateException("please call from main process");
    }
    boolean bool;
    switch (i)
    {
    default: 
      bool = localak.bZH();
      if (!bool) {
        break;
      }
    }
    for (i = j;; i = 0)
    {
      paramMap.put("isOpenPreload", i);
      localStringBuffer.append((String)localObject1);
      if (paramMap.size() <= 0) {
        break label446;
      }
      localObject1 = localStringBuffer.append("/");
      Bn(paramInt);
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
      bool = localak.bZG();
      break;
    }
    localObject1 = (String)paramMap.get("sessionId");
    if (!paramMap.containsKey("sessionId"))
    {
      localObject1 = Bm(bk.ZR((String)paramMap.get("scene")));
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
    localStringBuffer.append(com.tencent.mm.protocal.d.spa);
    localStringBuffer.append("&");
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
    label446:
    paramMap = localStringBuffer.append("/");
    Bn(paramInt);
    paramMap.append("app.html");
    return localStringBuffer.toString();
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    try
    {
      String str2 = ae.cqQ() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ae.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(paramIntent);
        return;
      }
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
    }
  }
  
  private static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void d(Context paramContext, String paramString, Intent paramIntent)
  {
    try
    {
      String str2 = ae.cqQ() + ".plugin.topstory";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ae.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, 10001);
      }
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
    }
  }
  
  public static void gN(long paramLong)
  {
    ak localak = ak.bZF();
    if (localak.eAg == null)
    {
      localak.eAg = new ai();
      localak.eAg.O(new ak.2(localak));
    }
    g.DS().k(new aa.1(), paramLong);
  }
  
  public static boolean gO(long paramLong)
  {
    y.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.DP().Dz().c(ac.a.uzh, Long.valueOf(paramLong));
    return false;
  }
  
  private static boolean gP(long paramLong)
  {
    return paramLong == 100203L;
  }
  
  public static boolean i(Activity paramActivity, int paramInt)
  {
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramActivity, "android.permission.ACCESS_COARSE_LOCATION");
      if (i == 0)
      {
        h.nFQ.f(15104, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2) });
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", paramActivity, "", new Object[0]);
      return true;
    }
    h.nFQ.f(15104, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    if (android.support.v4.app.a.a(paramActivity, "android.permission.ACCESS_COARSE_LOCATION"))
    {
      y.w("MicroMsg.WebSearch.WebSearchApiLogic", "has shown request permission and user denied, do not show agagin");
      return true;
    }
    y.w("MicroMsg.WebSearch.WebSearchApiLogic", "showing request permission dialog");
    android.support.v4.app.a.a(paramActivity, new String[] { "android.permission.ACCESS_COARSE_LOCATION" }, 73);
    return false;
  }
  
  public static Properties j(com.tencent.mm.vfs.b paramb)
  {
    Properties localProperties = new Properties();
    Object localObject;
    com.tencent.mm.vfs.b localb;
    if ((paramb != null) && (paramb.isFile()))
    {
      localObject = null;
      localb = null;
    }
    try
    {
      paramb = com.tencent.mm.vfs.e.o(paramb);
      localb = paramb;
      localObject = paramb;
      localProperties.load(paramb);
      bk.b(paramb);
      return localProperties;
    }
    catch (Exception paramb)
    {
      localObject = localb;
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", paramb, "", new Object[0]);
      bk.b(localb);
      return localProperties;
    }
    finally
    {
      bk.b((Closeable)localObject);
    }
  }
  
  public static String s(Map<String, Object> paramMap, String paramString)
  {
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null) {
        return paramMap.get(paramString).toString();
      }
      return "";
    }
    return "";
  }
  
  public static boolean t(Map<String, Object> paramMap, String paramString)
  {
    paramMap = s(paramMap, paramString);
    if (bk.bl(paramMap)) {}
    for (;;)
    {
      return false;
      try
      {
        if ("1".equals(paramMap)) {
          return true;
        }
        if (!"0".equals(paramMap))
        {
          boolean bool = Boolean.valueOf(paramMap).booleanValue();
          return bool;
        }
      }
      catch (Exception paramMap) {}
    }
    return false;
  }
  
  public static String v(Map<String, String> paramMap)
  {
    return c(paramMap, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */