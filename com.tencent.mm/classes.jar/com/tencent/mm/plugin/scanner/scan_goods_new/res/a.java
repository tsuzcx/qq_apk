package com.tencent.mm.plugin.scanner.scan_goods_new.res;

import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.d.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/res/ScanProductModelResLogic;", "", "()V", "CONFIG_JSON_KEY_FILE", "", "CONFIG_JSON_KEY_FILE_MD5", "CONFIG_JSON_KEY_FILE_NAME", "CONFIG_JSON_KEY_FILE_PARAM", "CONFIG_JSON_KEY_VERSION", "CONFIG_JSON_PARAM_VALUE_DETECTOR_MODEL_PATH", "CONFIG_JSON_PARAM_VALUE_DETECTOR_PARAM_PATH", "CONFIG_JSON_PARAM_VALUE_MODEL_CONFIG_PATH", "CONFIG_JSON_PARAM_VALUE_SCANCLS_MODEL_PATH", "CONFIG_JSON_PARAM_VALUE_SCANCLS_PARAM_PATH", "RES_CONFIG", "RES_SUB_TYPE", "", "RES_TMP_PATH", "TAG", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "configResReady", "readyResFilePathMap", "Ljava/util/concurrent/ConcurrentHashMap;", "readyResVersion", "reporter", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/res/ScanProductResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/res/ScanProductResIDKeyReport;", "sMainHandler", "Landroid/os/Handler;", "checkFile", "", "checkIfDownloadModelResReady", "copyPendingDirToReadyDirIfNeed", "getConfigJsonVersion", "filePath", "getMainHandler", "getPendingConfigFilePath", "getPendingResDir", "getReadyModelConfigString", "getReadyModelConfigVersion", "getReadyParamPath", "param", "getReadyResConfigFilePath", "getReadyResDir", "getResParentPath", "getResType", "getSubType", "getTmpConfigFilePath", "getTmpModelFileDir", "getTmpResDir", "init", "", "moveTmpFileToPendingFilePath", "fileName", "md5", "resetData", "showToast", "text", "unInit", "unzipRes", "type", "subType", "version", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OWG;
  private static final b OWH;
  private static final ConcurrentHashMap<String, String> OWI;
  public static int OWJ;
  private static int OWK;
  static final IListener<cd> oDs;
  
  static
  {
    AppMethodBeat.i(314067);
    OWG = new a();
    OWH = new b();
    oDs = (IListener)new ScanProductModelResLogic.checkResUpdateCacheFileEventListener.1(f.hfK);
    OWI = new ConcurrentHashMap();
    OWK = -1;
    AppMethodBeat.o(314067);
  }
  
  static void aNm()
  {
    AppMethodBeat.i(314025);
    try
    {
      OWJ = 0;
      OWK = -1;
      OWI.clear();
      AppMethodBeat.o(314025);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)localException, "resetData", new Object[0]);
      AppMethodBeat.o(314025);
    }
  }
  
  private static int aUT(String paramString)
  {
    AppMethodBeat.i(314046);
    try
    {
      if (!y.ZC(paramString))
      {
        Log.w("MicroMsg.ScanProductModelResLogic", s.X("getConfigJsonVersion file is not exist. filePath:", paramString));
        AppMethodBeat.o(314046);
        return 0;
      }
      int i = new JSONObject(y.bEn(paramString)).optInt("version", 0);
      Log.i("MicroMsg.ScanProductModelResLogic", "getConfigJsonVersion version:" + i + " , filePath:" + paramString);
      AppMethodBeat.o(314046);
      return i;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)paramString, "getConfigJsonVersion", new Object[0]);
      AppMethodBeat.o(314046);
    }
    return 0;
  }
  
  private static final void aUU(String paramString)
  {
    AppMethodBeat.i(314064);
    a locala = OWG;
    s.s(paramString, "cacheFile");
    locala.r(paramString, 97, 1, 1);
    AppMethodBeat.o(314064);
  }
  
  private final boolean bIK()
  {
    AppMethodBeat.i(314035);
    Object localObject1 = gRW();
    Log.i("MicroMsg.ScanProductModelResLogic", s.X("checkFile pendingConfigFilePath : ", localObject1));
    if (y.ZC((String)localObject1))
    {
      Object localObject2;
      do
      {
        for (;;)
        {
          try
          {
            String str = y.bEn((String)localObject1);
            localObject1 = new JSONObject(str);
            localObject2 = ((JSONObject)localObject1).optJSONArray("file");
            int i = ((JSONObject)localObject1).optInt("version");
            StringBuilder localStringBuilder = new StringBuilder("unzipRes  jsonFile:");
            if (localObject2 == null)
            {
              localObject1 = null;
              Log.i("MicroMsg.ScanProductModelResLogic", localObject1 + "  version:" + i + "  meta json: " + str);
              if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
                break label283;
              }
              localObject1 = c.evK;
              localObject1 = c.f((JSONArray)localObject2);
              if (!((Iterator)localObject1).hasNext()) {
                break label263;
              }
              localObject2 = ((Iterator)localObject1).next();
              if (localObject2 != null) {
                break;
              }
              localObject1 = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
              AppMethodBeat.o(314035);
              throw ((Throwable)localObject1);
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)localException, "checkFile", new Object[0]);
            AppMethodBeat.o(314035);
            return false;
          }
          Integer localInteger = Integer.valueOf(((JSONArray)localObject2).length());
        }
        localObject2 = ((JSONObject)localObject2).optString("name");
        localObject2 = gRT() + '/' + localObject2;
      } while (y.ZC((String)localObject2));
      Log.e("MicroMsg.ScanProductModelResLogic", s.X("checkFile file not exist. filePath:", localObject2));
      AppMethodBeat.o(314035);
      return false;
      label263:
      gRY();
      Log.i("MicroMsg.ScanProductModelResLogic", "checkFile true");
      AppMethodBeat.o(314035);
      return true;
      label283:
      Log.e("MicroMsg.ScanProductModelResLogic", "checkFile jsonFile is empty");
      AppMethodBeat.o(314035);
      return false;
    }
    s.u("无下发识物模型", "text");
    Log.w("MicroMsg.ScanProductModelResLogic", "checkFile config not exist.");
    AppMethodBeat.o(314035);
    return false;
  }
  
  private static String gJs()
  {
    AppMethodBeat.i(313980);
    String str = s.X(com.tencent.mm.loader.i.b.bms(), "scan_res/");
    AppMethodBeat.o(313980);
    return str;
  }
  
  public static b gRR()
  {
    return OWH;
  }
  
  private static String gRS()
  {
    AppMethodBeat.i(313990);
    String str = s.X(gJs(), "temp");
    AppMethodBeat.o(313990);
    return str;
  }
  
  private static String gRT()
  {
    AppMethodBeat.i(313998);
    String str = s.X(gJs(), "pending");
    AppMethodBeat.o(313998);
    return str;
  }
  
  private static String gRU()
  {
    AppMethodBeat.i(314005);
    String str = s.X(gJs(), "ready");
    AppMethodBeat.o(314005);
    return str;
  }
  
  private static String gRV()
  {
    AppMethodBeat.i(314009);
    String str = s.X(gRS(), "/cscmodel");
    AppMethodBeat.o(314009);
    return str;
  }
  
  private static String gRW()
  {
    AppMethodBeat.i(314013);
    String str = s.X(gRT(), "/config.json");
    AppMethodBeat.o(314013);
    return str;
  }
  
  private static String gRX()
  {
    AppMethodBeat.i(314017);
    String str = s.X(gRU(), "/config.json");
    AppMethodBeat.o(314017);
    return str;
  }
  
  private final boolean gRY()
  {
    AppMethodBeat.i(314041);
    int i;
    int j;
    try
    {
      i = aUT(gRW());
      j = aUT(gRX());
      if (i > j)
      {
        String str1 = gRU();
        String str2 = gRT();
        y.ew(str1, true);
        y.bDX(str1);
        boolean bool = y.qo(str2, str1);
        if (bool) {
          b.rG(OWH.NRN + 9);
        }
        for (;;)
        {
          Log.i("MicroMsg.ScanProductModelResLogic", "copyPendingDirToReadyDirIfNeed copy, pendingVersion:" + i + ", readyVersion:" + j + ", result:" + bool);
          s.u("拷贝模型到ready目录：" + j + ", " + i + ", " + bool, "text");
          AppMethodBeat.o(314041);
          return bool;
          b.rG(OWH.NRN + 10);
        }
      }
      Log.w("MicroMsg.ScanProductModelResLogic", "copyPendingDirToReadyDirIfNeed not copy, pendingVersion:" + i + ", readyVersion:" + j);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)localException, "copyPendingDirToReadyDirIfNeed", new Object[0]);
      AppMethodBeat.o(314041);
      return false;
    }
    s.u("下发模型已ready，无需拷贝：" + j + ", " + i, "text");
    AppMethodBeat.o(314041);
    return true;
  }
  
  private final void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str1;
    int i;
    Object localObject1;
    try
    {
      AppMethodBeat.i(314055);
      Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes: " + paramString + "  type:" + paramInt1 + "  version:" + paramInt3);
      if (!y.ZC(paramString)) {
        break label1206;
      }
      str1 = gRS();
      y.bDX(str1);
      i = y.aA(paramString, str1);
      Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip file ret:" + i + "  getResTmpPath:" + str1 + "   version:" + paramInt3);
      paramString = y.eB(gRV(), false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (j)paramString.next();
          Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip file path:" + ((j)localObject1).acpB + " name:" + ((j)localObject1).name + " size:" + ((j)localObject1).size);
        }
      }
      m = 0;
    }
    finally {}
    int m;
    boolean bool2 = false;
    if (i == 0)
    {
      bool1 = bool2;
      k = m;
    }
    for (;;)
    {
      try
      {
        b.rG(OWH.NRN + 5);
        bool1 = bool2;
        k = m;
        localObject1 = s.X(gRV(), "/config.json");
        bool1 = bool2;
        k = m;
        if (!y.ZC((String)localObject1)) {
          continue;
        }
        bool1 = bool2;
        k = m;
        Log.i("MicroMsg.ScanProductModelResLogic", s.X("unzipRes file exist, tmpConfigPath:", localObject1));
        bool1 = bool2;
        k = m;
        paramString = y.bEn((String)localObject1);
        m = 1;
        bool2 = true;
        bool1 = bool2;
        k = m;
        localObject3 = new JSONObject(paramString);
        bool1 = bool2;
        k = m;
        localObject2 = ((JSONObject)localObject3).optJSONArray("file");
        bool1 = bool2;
        k = m;
        i = ((JSONObject)localObject3).optInt("version");
        bool1 = bool2;
        k = m;
        localObject3 = new StringBuilder("unzipRes meta json: ").append(paramString).append("  jsonFile:");
        if (localObject2 != null) {
          continue;
        }
        paramString = null;
        bool1 = bool2;
        k = m;
        Log.i("MicroMsg.ScanProductModelResLogic", paramString + "  version:" + i);
        if (localObject2 == null) {
          continue;
        }
        bool1 = bool2;
        k = m;
        if (((JSONArray)localObject2).length() <= 0) {
          continue;
        }
        bool1 = bool2;
        k = m;
        y.ew(gRT(), true);
        bool1 = bool2;
        k = m;
        y.bDX(gRT());
        bool1 = bool2;
        k = m;
        paramString = c.evK;
        bool1 = bool2;
        k = m;
        paramString = c.f((JSONArray)localObject2);
        bool1 = true;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        Object localObject2;
        label1206:
        continue;
        if ((k == 0) || (!bool1)) {
          continue;
        }
        bool1 = true;
        continue;
        bool1 = false;
      }
      finally
      {
        continue;
      }
      k = bool1;
      try
      {
        if (paramString.hasNext())
        {
          k = bool1;
          localObject2 = paramString.next();
          if (localObject2 == null)
          {
            k = bool1;
            paramString = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            k = bool1;
            AppMethodBeat.o(314055);
            k = bool1;
            throw paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        k = bool1;
        Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        OWH.gSf();
        Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip failed");
        y.ew(str1, true);
        AppMethodBeat.o(314055);
        return;
        bool1 = bool2;
        k = m;
        int j = ((JSONArray)localObject2).length();
        paramString = Integer.valueOf(j);
        continue;
        k = bool1;
        localObject3 = (JSONObject)localObject2;
        k = bool1;
        localObject2 = ((JSONObject)localObject3).optString("name");
        k = bool1;
        localObject3 = ((JSONObject)localObject3).optString("md5");
        k = bool1;
        s.s(localObject2, "fileName");
        k = bool1;
        s.s(localObject3, "md5");
        k = bool1;
        String str2 = gRV() + '/' + (String)localObject2;
        k = bool1;
        localObject2 = gRT() + '/' + (String)localObject2;
        k = bool1;
        Log.i("MicroMsg.ScanProductModelResLogic", "moveFileToPendingFilePath file tmp:" + str2 + "  pending:" + (String)localObject2);
        k = bool1;
        if (y.ZC(str2))
        {
          k = bool1;
          y.qn(str2, (String)localObject2);
          k = bool1;
          bool2 = s.p(g.getMD5((String)localObject2), localObject3);
          k = bool1;
          Log.i("MicroMsg.ScanProductModelResLogic", "moveFileToPendingFilePath move, result:" + bool2 + "  file: " + (String)localObject2);
          k = bool2;
        }
        else
        {
          k = bool1;
          Log.e("MicroMsg.ScanProductModelResLogic", s.X("moveFileToPendingFilePath file is not exist. tmpFilePath:", str2));
          k = 0;
          continue;
          k = bool1;
          Log.i("MicroMsg.ScanProductModelResLogic", s.X("unzipRes file, unzipSuccess:", Boolean.valueOf(bool1)));
          k = bool1;
          if (bool1)
          {
            k = bool1;
            y.deleteFile(gRW());
            k = bool1;
            y.qn((String)localObject1, gRW());
            k = bool1;
            s.u(s.X("识物模型解压成功：", Integer.valueOf(i)), "text");
            k = bool1;
          }
          if (k == 0)
          {
            OWH.gSf();
            Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip failed");
            y.ew(str1, true);
            AppMethodBeat.o(314055);
            continue;
            bool1 = bool2;
            k = m;
            Log.e("MicroMsg.ScanProductModelResLogic", "unzipRes json file is null or empty");
            k = 0;
            continue;
            k = 0;
            bool1 = false;
            Log.e("MicroMsg.ScanProductModelResLogic", s.X("unzipRes file not exist, configPath:", localObject1));
            k = 0;
            continue;
          }
          OWH.gSe();
          Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip success");
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().bu(paramInt1, paramInt2, paramInt3);
          continue;
          if (k == 0)
          {
            OWH.gSf();
            Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip failed");
            y.ew(str1, true);
            AppMethodBeat.o(314055);
            throw paramString;
          }
          OWH.gSe();
          Log.i("MicroMsg.ScanProductModelResLogic", "unzipRes unzip success");
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().bu(paramInt1, paramInt2, paramInt3);
          continue;
          b.rG(OWH.NRN + 6);
          AppMethodBeat.o(314055);
        }
      }
      finally {}
    }
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(369995);
    s.u(paramString, "text");
    AppMethodBeat.o(369995);
  }
  
  public final String aUS(String paramString)
  {
    AppMethodBeat.i(314078);
    if (!gRZ())
    {
      Log.e("MicroMsg.ScanProductModelResLogic", "getReadyParamPath res is not ready");
      AppMethodBeat.o(314078);
      return null;
    }
    if (n.bp((CharSequence)paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanProductModelResLogic", "getReadyParamPath param is empty");
      AppMethodBeat.o(314078);
      return null;
    }
    String str = (String)OWI.get(paramString);
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanProductModelResLogic", s.X("getReadyParamPath fileName is empty, param:", paramString));
      AppMethodBeat.o(314078);
      return null;
    }
    Log.i("MicroMsg.ScanProductModelResLogic", "getReadyParamPath  param:" + paramString + "  filePath:" + str);
    AppMethodBeat.o(314078);
    return str;
  }
  
  public final boolean gRZ()
  {
    AppMethodBeat.i(314074);
    try
    {
      if (OWK != -1)
      {
        if (OWK == 1)
        {
          AppMethodBeat.o(314074);
          return true;
        }
        AppMethodBeat.o(314074);
        return false;
      }
      Object localObject1 = gRX();
      if (!y.ZC((String)localObject1))
      {
        OWK = 0;
        OWI.clear();
        OWJ = 0;
        OWH.gSd();
        s.u("下发模型未ready", "text");
        AppMethodBeat.o(314074);
        return false;
      }
      localObject1 = new JSONObject(y.bEn((String)localObject1));
      OWJ = ((JSONObject)localObject1).optInt("version", 0);
      localObject1 = ((JSONObject)localObject1).optJSONArray("file");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label469;
      }
      localObject2 = c.evK;
      localObject1 = c.f((JSONArray)localObject1);
      if (!((Iterator)localObject1).hasNext()) {
        break label411;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(314074);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      OWK = 0;
      OWI.clear();
      OWJ = 0;
      OWH.gSd();
      Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)localException, "checkIfDownloadModelResReady.", new Object[0]);
      s.u("下发模型未ready", "text");
      AppMethodBeat.o(314074);
      return false;
    }
    Object localObject2 = (JSONObject)localObject2;
    String str = ((JSONObject)localObject2).optString("name");
    localObject2 = ((JSONObject)localObject2).optString("param");
    str = gRU() + '/' + str;
    Object localObject3 = (CharSequence)localObject2;
    if (localObject3 != null) {
      if (!n.bp((CharSequence)localObject3)) {
        break label528;
      }
    }
    for (;;)
    {
      if ((i != 0) || (!y.ZC(str)))
      {
        Log.e("MicroMsg.ScanProductModelResLogic", "checkIfDownloadModelResReady file not exist. version:" + OWJ + ", filePath:" + str);
        OWI.clear();
        OWJ = 0;
        OWK = 0;
        OWH.gSd();
        s.u("下发模型未ready", "text");
        AppMethodBeat.o(314074);
        return false;
      }
      localObject3 = (Map)OWI;
      s.s(localObject2, "param");
      ((Map)localObject3).put(localObject2, str);
      break;
      label411:
      OWK = 1;
      Log.i("MicroMsg.ScanProductModelResLogic", s.X("checkIfDownloadModelResReady true. version:", Integer.valueOf(OWJ)));
      s.u(s.X("下发模型已ready：", Integer.valueOf(OWJ)), "text");
      b.rG(OWH.NRN + 2);
      AppMethodBeat.o(314074);
      return true;
      label469:
      OWK = 0;
      OWI.clear();
      OWJ = 0;
      OWH.gSd();
      Log.e("MicroMsg.ScanProductModelResLogic", s.X("checkIfDownloadModelResReady fileJsonArray is empty. version:", Integer.valueOf(OWJ)));
      s.u("下发模型未ready", "text");
      AppMethodBeat.o(314074);
      return false;
      int i = 1;
      continue;
      label528:
      i = 0;
    }
  }
  
  public final String gSa()
  {
    AppMethodBeat.i(314084);
    for (;;)
    {
      int i;
      try
      {
        if (!gRZ())
        {
          Log.e("MicroMsg.ScanProductModelResLogic", "getReadyModelConfigString res is not ready");
          AppMethodBeat.o(314084);
          return "";
        }
        String str1 = (String)OWI.get("model_config");
        CharSequence localCharSequence = (CharSequence)str1;
        if (localCharSequence == null) {
          break label178;
        }
        if (!n.bp(localCharSequence)) {
          break label112;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanProductModelResLogic", (Throwable)localException, "getReadyModelConfigString", new Object[0]);
        AppMethodBeat.o(314084);
        return "";
      }
      if (i != 0)
      {
        Log.e("MicroMsg.ScanProductModelResLogic", "getReadyModelConfigString fileName is empty");
        AppMethodBeat.o(314084);
        return "";
        label112:
        i = 0;
      }
      else
      {
        if (!y.ZC(localException))
        {
          Log.e("MicroMsg.ScanProductModelResLogic", s.X("getReadyModelConfigString file is not exist. filePath:", localException));
          AppMethodBeat.o(314084);
          return "";
        }
        String str2 = y.bEn(localException);
        Log.i("MicroMsg.ScanProductModelResLogic", s.X("getReadyModelConfigString  config:", str2));
        s.s(str2, "config");
        AppMethodBeat.o(314084);
        return str2;
        label178:
        i = 1;
      }
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(314070);
    Log.i("MicroMsg.ScanProductModelResLogic", "init");
    aNm();
    oDs.alive();
    if (bIK())
    {
      b.rG(OWH.NRN);
      AppMethodBeat.o(314070);
      return;
    }
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(97, 1);
    if (y.ZC(str))
    {
      Log.i("MicroMsg.ScanProductModelResLogic", s.X("cache file exist ", str));
      h.baH().postToWorker(new a..ExternalSyntheticLambda0(str));
    }
    b.rG(OWH.NRN + 1);
    AppMethodBeat.o(314070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.res.a
 * JD-Core Version:    0.7.0.1
 */