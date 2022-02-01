package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.f.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class l
  extends f
{
  protected Class Mye = null;
  protected Class Myf = null;
  protected int Myg = -1;
  ValueCallback<Pair<Integer, String>> Myh = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> Myi = new ValueCallback() {};
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(gdg());
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
      gdt();
      paramClassLoader = this.Myf;
    }
    return "";
  }
  
  private String aiP(int paramInt)
  {
    String str = aiK(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  private boolean bbB(String paramString)
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
  
  private void gdt()
  {
    try
    {
      if ((this.Mye == null) || (this.Myf == null) || (this.Myg != this.MxJ))
      {
        Log.i(getPluginName(), "load class of version " + this.MxJ);
        ClassLoader localClassLoader = h.bo(aiI(this.MxJ), aiP(this.MxJ), null);
        this.Mye = localClassLoader.loadClass(gdf());
        this.Myf = localClassLoader.loadClass(gdg());
        this.Myg = this.MxJ;
      }
      return;
    }
    finally {}
  }
  
  public final int a(SchedulerConfig paramSchedulerConfig)
  {
    Log.i(getPluginName(), "performInstall version " + paramSchedulerConfig.version);
    boolean bool1 = b(paramSchedulerConfig);
    if (!bool1)
    {
      Log.e(getPluginName(), "performInstall unZipAndCheck failed");
      g.jdMethod_do(getPluginName(), paramSchedulerConfig.MyT);
    }
    do
    {
      return -1;
      if (!paramSchedulerConfig.MyT) {
        break label138;
      }
      try
      {
        boolean bool2 = c(paramSchedulerConfig);
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
      g.bbu(getPluginName());
      paramSchedulerConfig = aiK(paramSchedulerConfig.version);
    } while (paramSchedulerConfig.isEmpty());
    c.bbn(paramSchedulerConfig);
    return -1;
    label138:
    Object localObject1 = aiI(paramSchedulerConfig.version);
    String str = aiP(paramSchedulerConfig.version);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject1 = a(h.bo((String)localObject1, str, null));
        bbB((String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        y.gaM().a((String[])localObject1, f.a.Mpi);
        e.al((String[])localObject1);
        if (XWalkEnvironment.getApplicationContext() == null)
        {
          Log.e(getPluginName(), "clearPatchDownloadInfo, context is null");
          localObject1 = aiL(paramSchedulerConfig.version);
          if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
            c.bbn((String)localObject1);
          }
          aiJ(paramSchedulerConfig.version);
          Log.i(getPluginName(), "performInstall version " + this.MxJ + " success");
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
        g.dp(getPluginName(), paramSchedulerConfig.MyT);
        Log.e(getPluginName(), "performInstall error: " + localException2.getMessage());
        return -1;
      }
      SharedPreferences.Editor localEditor;
      localEditor.putInt("patchDownloadCount", 0);
      localEditor.commit();
    }
  }
  
  public final boolean a(HashMap<String, String> paramHashMap, Activity paramActivity, ViewGroup paramViewGroup, final ValueCallback<Integer> paramValueCallback)
  {
    if ((paramActivity == null) || (paramViewGroup == null))
    {
      Log.e(getPluginName(), "readFile params is null");
      c("", paramValueCallback, -5);
      return false;
    }
    final String str = (String)paramHashMap.get("file_ext");
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "readFile fileExt is null");
      c("", paramValueCallback, -5);
      return false;
    }
    int i = this.MxJ;
    if (i <= 0)
    {
      Log.e(getPluginName(), "readFile plugin not installed");
      c(str, paramValueCallback, -2);
      return false;
    }
    if (i < gdh())
    {
      Log.e(getPluginName(), "readFile plugin version is too old, require: " + gdh());
      c(str, paramValueCallback, -11);
      return false;
    }
    Log.i(getPluginName(), "readFile by xweb, plugin version ".concat(String.valueOf(i)));
    if ("XFilesPPTReader".equalsIgnoreCase(getPluginName())) {
      aiO(1068);
    }
    for (;;)
    {
      try
      {
        paramHashMap.put("cache_dir", aiL(i));
        paramHashMap.put("res_dir", aiM(i));
        gdt();
        Method localMethod = this.Mye.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        localMethod.setAccessible(true);
        e.onStart(str);
        localMethod.invoke(null, new Object[] { paramActivity, paramViewGroup, this.Mye.getClassLoader(), paramHashMap, this.Myh, this.Myi, new ValueCallback() {} });
        return true;
      }
      catch (Exception paramHashMap)
      {
        Log.e(getPluginName(), "readFile error: " + paramHashMap.getMessage());
        com.tencent.xweb.f.a(getPluginName(), i, "invoke error ", paramHashMap);
        c(str, paramValueCallback, -3);
      }
      if ("XFilesPDFReader".equalsIgnoreCase(getPluginName())) {
        aiO(1071);
      } else if ("XFilesWordReader".equalsIgnoreCase(getPluginName())) {
        aiO(1069);
      } else if ("XFilesExcelReader".equalsIgnoreCase(getPluginName())) {
        aiO(1070);
      } else {
        Log.e(getPluginName(), "unknown report id");
      }
    }
    return false;
  }
  
  public abstract String aiI(int paramInt);
  
  public final String bq(int paramInt, boolean paramBoolean)
  {
    String str = aiK(paramInt);
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
      int i = this.MxJ;
      if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
      label144:
      try
      {
        this.Mye = null;
        this.Myf = null;
        this.Myg = -1;
        Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
        paramString = aiK(i);
        aiJ(-1);
        if ((paramString != null) && (!paramString.isEmpty())) {
          c.bbn(paramString);
        }
        com.tencent.xweb.f.bb(str, i, paramInt);
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
  
  public final boolean dt(String paramString, boolean paramBoolean)
  {
    if (this.MxJ < 0)
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
        bbB((String)localObject2);
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
  
  public abstract String gdf();
  
  public abstract String gdg();
  
  public abstract int gdh();
  
  public final boolean gdi()
  {
    return false;
  }
  
  public final void gdj()
  {
    if (this.MxJ < 0) {
      Log.i(getPluginName(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (br(this.MxJ, true));
      Log.e(getPluginName(), "checkFiles failed, abandon version " + this.MxJ);
      g.bbv(getPluginName());
      str = aiK(this.MxJ);
      aiJ(-1);
    } while ((str == null) || (str.isEmpty()));
    c.bbn(str);
  }
  
  public final void q(HashMap<String, String> paramHashMap)
  {
    if (this.Mye == null) {
      return;
    }
    try
    {
      Method localMethod = this.Mye.getMethod("finishReadFile", new Class[] { HashMap.class });
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