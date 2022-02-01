package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.f.a;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class l
  extends f
{
  protected Class MVi = null;
  protected Class MVj = null;
  protected int MVk = -1;
  ValueCallback<Pair<Integer, String>> MVl = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> MVm = new ValueCallback() {};
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(ghJ());
        paramClassLoader = paramClassLoader.getMethod("getSupportFormats", new Class[0]);
        paramClassLoader.setAccessible(true);
        String str = (String)paramClassLoader.invoke(null, new Object[0]);
        paramClassLoader = str;
        if (str == null) {
          paramClassLoader = "";
        }
        return paramClassLoader;
      }
      catch (Exception paramClassLoader)
      {
        Log.e(getPluginName(), "loadSupportFormatsFromPlugin error: " + paramClassLoader.getMessage());
      }
      ghV();
      paramClassLoader = this.MVj;
    }
    return "";
  }
  
  private String ajz(int paramInt)
  {
    String str = aju(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  private boolean bde(String paramString)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "saveSupportFormats, context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
    if (localObject == null)
    {
      Log.e(getPluginName(), "saveSupportFormats, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("supportFormats", paramString);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    Log.i(getPluginName(), "loadSupportFormat, ret = " + bool + ", formats: " + paramString);
    return bool;
  }
  
  private void ghV()
  {
    try
    {
      if ((this.MVi == null) || (this.MVj == null) || (this.MVk != this.MUN))
      {
        Log.i(getPluginName(), "load class of version " + this.MUN);
        ClassLoader localClassLoader = h.bp(ajr(this.MUN), ajz(this.MUN), null);
        this.MVi = localClassLoader.loadClass(ghI());
        this.MVj = localClassLoader.loadClass(ghJ());
        this.MVk = this.MUN;
      }
      return;
    }
    finally {}
  }
  
  public final int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    Log.i(getPluginName(), "performInstall version " + paramc.version);
    boolean bool1 = b(paramc);
    if (!bool1)
    {
      Log.e(getPluginName(), "performInstall unZipAndCheck failed");
      g.dr(getPluginName(), paramc.MVY);
    }
    do
    {
      return -1;
      if (!paramc.MVY) {
        break label138;
      }
      try
      {
        boolean bool2 = c(paramc);
        bool1 = bool2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.e(getPluginName(), "performInstall doPatch error: ", localException1);
        }
      }
      if (bool1) {
        break label138;
      }
      Log.e(getPluginName(), "performInstall doPatch failed, delete all");
      g.bcX(getPluginName());
      paramc = aju(paramc.version);
    } while (paramc.isEmpty());
    com.tencent.xweb.util.c.bcQ(paramc);
    return -1;
    label138:
    Object localObject1 = ajr(paramc.version);
    String str = ajz(paramc.version);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject1 = a(h.bp((String)localObject1, str, null));
        bde((String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        y.gfo().a((String[])localObject1, f.a.MMe);
        e.al((String[])localObject1);
        if (XWalkEnvironment.getApplicationContext() == null)
        {
          Log.e(getPluginName(), "clearPatchDownloadInfo, context is null");
          localObject1 = ajv(paramc.version);
          if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
            com.tencent.xweb.util.c.bcQ((String)localObject1);
          }
          ajt(paramc.version);
          Log.i(getPluginName(), "performInstall version " + this.MUN + " success");
          return 0;
          localObject2 = ((File)localObject2).listFiles();
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            continue;
          }
          int j = localObject2.length;
          int i = 0;
          if (i >= j) {
            continue;
          }
          Object localObject3 = localObject2[i];
          if ((localObject3 != null) && (localObject3.exists())) {
            localObject3.delete();
          }
          i += 1;
          continue;
        }
        localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (localObject1 == null)
        {
          Log.e(getPluginName(), "clearPatchDownloadInfo, sp is null");
          continue;
        }
        localEditor = localException2.edit();
      }
      catch (Exception localException2)
      {
        g.ds(getPluginName(), paramc.MVY);
        Log.e(getPluginName(), "performInstall error: " + localException2.getMessage());
        return -1;
      }
      SharedPreferences.Editor localEditor;
      localEditor.putInt("patchDownloadCount", 0);
      localEditor.commit();
    }
  }
  
  public final boolean a(HashMap<String, String> paramHashMap, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Pair<String, Object>> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    if ((paramActivity == null) || (paramViewGroup == null))
    {
      Log.e(getPluginName(), "readFile params is null");
      c("", paramValueCallback1, -5);
      return false;
    }
    final String str = (String)paramHashMap.get("file_ext");
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "readFile fileExt is null");
      c("", paramValueCallback1, -5);
      return false;
    }
    int j = this.MUN;
    if (j <= 0)
    {
      Log.e(getPluginName(), "readFile plugin not installed");
      c(str, paramValueCallback1, -2);
      return false;
    }
    if (paramValueCallback != null) {}
    for (int i = 1;; i = 0)
    {
      i = ajs(i);
      if (j >= i) {
        break;
      }
      Log.e(getPluginName(), "readFile plugin version is too old, require: ".concat(String.valueOf(i)));
      c(str, paramValueCallback1, -11);
      return false;
    }
    Log.i(getPluginName(), "readFile by xweb, plugin version ".concat(String.valueOf(j)));
    if ("XFilesPPTReader".equalsIgnoreCase(getPluginName())) {
      ajy(1068);
    }
    try
    {
      paramHashMap.put("cache_dir", ajv(j));
      paramHashMap.put("res_dir", ajw(j));
      ghV();
      if (paramValueCallback != null)
      {
        Method localMethod = this.MVi.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        localMethod.setAccessible(true);
        e.onStart(str);
        localMethod.invoke(null, new Object[] { paramActivity, paramViewGroup, this.MVi.getClassLoader(), paramHashMap, paramValueCallback, this.MVl, this.MVm, new ValueCallback() {} });
      }
      for (;;)
      {
        return true;
        if ("XFilesPDFReader".equalsIgnoreCase(getPluginName()))
        {
          ajy(1071);
          break;
        }
        if ("XFilesWordReader".equalsIgnoreCase(getPluginName()))
        {
          ajy(1069);
          break;
        }
        if ("XFilesExcelReader".equalsIgnoreCase(getPluginName()))
        {
          ajy(1070);
          break;
        }
        Log.e(getPluginName(), "unknown report id");
        break;
        paramValueCallback = this.MVi.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        paramValueCallback.setAccessible(true);
        e.onStart(str);
        paramValueCallback.invoke(null, new Object[] { paramActivity, paramViewGroup, this.MVi.getClassLoader(), paramHashMap, this.MVl, this.MVm, new ValueCallback() {} });
      }
      return false;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "readFile error: " + paramHashMap.getMessage());
      com.tencent.xweb.f.a(getPluginName(), j, "invoke error ", paramHashMap);
      c(str, paramValueCallback1, -3);
    }
  }
  
  public abstract String ajr(int paramInt);
  
  public abstract int ajs(int paramInt);
  
  public final String bz(int paramInt, boolean paramBoolean)
  {
    String str = aju(paramInt);
    if ((str == null) || (str.isEmpty())) {
      return "";
    }
    if (!paramBoolean) {
      return str + File.separator + getPluginName() + ".zip";
    }
    return str + File.separator + getPluginName() + ".patch";
  }
  
  protected final void c(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      if (!"XFilesPPTReader".equalsIgnoreCase(getPluginName())) {
        break label144;
      }
      str = "ppt";
    }
    for (;;)
    {
      int i = this.MUN;
      if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
      label144:
      try
      {
        this.MVi = null;
        this.MVj = null;
        this.MVk = -1;
        Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
        paramString = aju(i);
        ajt(-1);
        if ((paramString != null) && (!paramString.isEmpty())) {
          com.tencent.xweb.util.c.bcQ(paramString);
        }
        com.tencent.xweb.f.be(str, i, paramInt);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(Integer.valueOf(paramInt));
        }
        return;
      }
      finally {}
      if ("XFilesPDFReader".equalsIgnoreCase(getPluginName()))
      {
        str = "pdf";
      }
      else if ("XFilesWordReader".equalsIgnoreCase(getPluginName()))
      {
        str = "doc";
      }
      else if ("XFilesExcelReader".equalsIgnoreCase(getPluginName()))
      {
        str = "xls";
      }
      else
      {
        Log.e(getPluginName(), "onReceiveValueProcess unknown fileExt");
        str = paramString;
      }
    }
  }
  
  public final boolean dw(String paramString, boolean paramBoolean)
  {
    if (this.MUN < 0)
    {
      Log.i(getPluginName(), "isSupport, not installed");
      return false;
    }
    Object localObject1;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "getSupportFormat, context is null");
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (((String)localObject1).isEmpty())
      {
        localObject2 = localObject1;
        if (!paramBoolean) {}
      }
      try
      {
        localObject2 = a(null);
        bde((String)localObject2);
        return ((String)localObject2).toLowerCase().contains(paramString.toLowerCase());
      }
      catch (Exception paramString)
      {
        Log.e(getPluginName(), "isSupport error: " + paramString.getMessage());
      }
      localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
      if (localObject1 == null)
      {
        Log.e(getPluginName(), "getSupportFormat, sp is null");
        localObject1 = "";
      }
      else
      {
        localObject1 = ((SharedPreferences)localObject1).getString("supportFormats", "");
      }
    }
    return false;
  }
  
  public abstract String ghI();
  
  public abstract String ghJ();
  
  public final boolean ghK()
  {
    return false;
  }
  
  public final void ghL()
  {
    if (this.MUN < 0) {
      Log.i(getPluginName(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (bA(this.MUN, true));
      Log.e(getPluginName(), "checkFiles failed, abandon version " + this.MUN);
      g.bcY(getPluginName());
      str = aju(this.MUN);
      ajt(-1);
    } while ((str == null) || (str.isEmpty()));
    com.tencent.xweb.util.c.bcQ(str);
  }
  
  public final void r(HashMap<String, String> paramHashMap)
  {
    if (this.MVi == null)
    {
      Log.e(getPluginName(), "finishReadFile error, loadedReaderClass is null");
      return;
    }
    try
    {
      Method localMethod = this.MVi.getMethod("finishReadFile", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramHashMap });
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "finishReadFile error: " + paramHashMap.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.l
 * JD-Core Version:    0.7.0.1
 */