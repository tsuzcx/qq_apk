package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.c;
import com.tencent.xweb.h.b;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class m
  extends g
{
  protected Class SIp = null;
  protected Class SIq = null;
  protected int SIr = -1;
  ValueCallback<Pair<Integer, String>> SIs = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> SIt = new ValueCallback() {};
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(hvh());
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
      hvv();
      paramClassLoader = this.SIq;
    }
    return "";
  }
  
  private String ath(int paramInt)
  {
    String str = atd(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  private boolean bsR(String paramString)
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
  
  private void hvv()
  {
    try
    {
      int i = hvk();
      if ((this.SIp == null) || (this.SIq == null) || (this.SIr != i))
      {
        Log.i(getPluginName(), "load class of version ".concat(String.valueOf(i)));
        ClassLoader localClassLoader = i.bx(ata(i), ath(i), null);
        this.SIp = localClassLoader.loadClass(hvg());
        this.SIq = localClassLoader.loadClass(hvh());
        this.SIr = i;
      }
      return;
    }
    finally {}
  }
  
  public final void D(HashMap<String, String> paramHashMap)
  {
    if (this.SIp == null)
    {
      Log.e(getPluginName(), "finishReadFile error, loadedReaderClass is null");
      return;
    }
    try
    {
      Method localMethod = this.SIp.getMethod("finishReadFile", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramHashMap });
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "finishReadFile error: " + paramHashMap.getMessage());
    }
  }
  
  public final h.b E(HashMap<String, Object> paramHashMap)
  {
    if (this.SIp == null)
    {
      Log.e(getPluginName(), "getViewStatus error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Object localObject1 = this.SIp.getMethod("getViewStatus", new Class[] { HashMap.class });
      ((Method)localObject1).setAccessible(true);
      paramHashMap = ((Method)localObject1).invoke(null, new Object[] { paramHashMap });
      if ((paramHashMap instanceof HashMap))
      {
        Object localObject3 = (HashMap)paramHashMap;
        paramHashMap = ((HashMap)localObject3).get("get_index");
        localObject1 = ((HashMap)localObject3).get("get_zoom");
        Object localObject2 = ((HashMap)localObject3).get("get_x");
        localObject3 = ((HashMap)localObject3).get("get_y");
        if ((!(paramHashMap instanceof Integer)) || (!(localObject1 instanceof Float)) || (!(localObject2 instanceof Integer)) || (!(localObject3 instanceof Integer)))
        {
          Log.e(getPluginName(), "getViewStatus error, value invalid");
          return null;
        }
        paramHashMap = new h.b(((Integer)paramHashMap).intValue(), ((Float)localObject1).floatValue(), ((Integer)localObject2).intValue(), ((Integer)localObject3).intValue());
        return paramHashMap;
      }
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "getViewStatus error: " + paramHashMap.getMessage());
    }
    return null;
  }
  
  public final boolean F(HashMap<String, Object> paramHashMap)
  {
    if (this.SIp == null)
    {
      Log.e(getPluginName(), "setViewToStatus error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.SIp.getMethod("setViewToStatus", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      if ((paramHashMap instanceof Boolean))
      {
        boolean bool = ((Boolean)paramHashMap).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "setViewToStatus error: " + paramHashMap.getMessage());
    }
    return false;
  }
  
  public final boolean G(HashMap<String, Object> paramHashMap)
  {
    if (this.SIp == null)
    {
      Log.e(getPluginName(), "requestThumbnail error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.SIp.getMethod("requestThumbnail", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      if ((paramHashMap instanceof Boolean))
      {
        boolean bool = ((Boolean)paramHashMap).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "requestThumbnail error: " + paramHashMap.getMessage());
    }
    return false;
  }
  
  public final Object H(HashMap<String, Object> paramHashMap)
  {
    if (this.SIp == null)
    {
      Log.e(getPluginName(), "generalInvoke error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Method localMethod = this.SIp.getMethod("generalInvoke", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      return paramHashMap;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "generalInvoke error: " + paramHashMap.getMessage());
    }
    return null;
  }
  
  public final int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    Log.i(getPluginName(), "performInstall version " + paramc.version);
    boolean bool1 = b(paramc);
    if (!bool1)
    {
      Log.e(getPluginName(), "performInstall unZipAndCheck failed");
      h.dM(getPluginName(), paramc.SJc);
    }
    do
    {
      return -1;
      if (!paramc.SJc) {
        break label142;
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
        break label142;
      }
      Log.e(getPluginName(), "performInstall doPatch failed, delete all");
      h.bsJ(getPluginName());
      paramc = atd(paramc.version);
    } while (paramc.isEmpty());
    com.tencent.xweb.util.c.bsB(paramc);
    return -1;
    label142:
    Object localObject1 = ata(paramc.version);
    String str = ath(paramc.version);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject1 = a(i.bx((String)localObject1, str, null));
        bsR((String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        y.hsF().a((String[])localObject1, f.a.SyT);
        y.hsF().a((String[])localObject1, f.c.SyY);
        e.ah((String[])localObject1);
        hvm();
        localObject1 = ate(paramc.version);
        if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
          com.tencent.xweb.util.c.bsB((String)localObject1);
        }
        atc(paramc.version);
        Log.i(getPluginName(), "performInstall version " + this.SHU + " success");
        return 0;
      }
      catch (Exception localException2)
      {
        int j;
        int i;
        Object localObject3;
        h.dN(getPluginName(), paramc.SJc);
        Log.e(getPluginName(), "performInstall error: " + localException2.getMessage());
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if ((localObject3 != null) && (localObject3.exists())) {
            localObject3.delete();
          }
          i += 1;
        }
      }
    }
    return -1;
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
    int j = this.SHU;
    if (j <= 0)
    {
      Log.e(getPluginName(), "readFile plugin not installed");
      c(str, paramValueCallback1, -2);
      return false;
    }
    if (paramValueCallback != null) {}
    for (int i = 1;; i = 0)
    {
      i = atb(i);
      if (j >= i) {
        break;
      }
      Log.e(getPluginName(), "readFile plugin version is too old, require: ".concat(String.valueOf(i)));
      c(str, paramValueCallback1, -11);
      return false;
    }
    Log.i(getPluginName(), "readFile by xweb, plugin version ".concat(String.valueOf(j)));
    if ("XFilesPPTReader".equalsIgnoreCase(getPluginName())) {
      mQ(j, 1068);
    }
    try
    {
      paramHashMap.put("cache_dir", ate(j));
      paramHashMap.put("res_dir", atf(j));
      hvv();
      if (paramValueCallback != null)
      {
        Method localMethod = this.SIp.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        localMethod.setAccessible(true);
        e.onStart(str);
        localMethod.invoke(null, new Object[] { paramActivity, paramViewGroup, this.SIp.getClassLoader(), paramHashMap, paramValueCallback, this.SIs, this.SIt, new ValueCallback() {} });
      }
      for (;;)
      {
        return true;
        if ("XFilesPDFReader".equalsIgnoreCase(getPluginName()))
        {
          mQ(j, 1071);
          break;
        }
        if ("XFilesWordReader".equalsIgnoreCase(getPluginName()))
        {
          mQ(j, 1069);
          break;
        }
        if ("XFilesExcelReader".equalsIgnoreCase(getPluginName()))
        {
          mQ(j, 1070);
          break;
        }
        if ("XFilesOfficeReader".equalsIgnoreCase(getPluginName()))
        {
          mQ(j, 1544);
          break;
        }
        Log.e(getPluginName(), "unknown report id");
        break;
        paramValueCallback = this.SIp.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        paramValueCallback.setAccessible(true);
        e.onStart(str);
        paramValueCallback.invoke(null, new Object[] { paramActivity, paramViewGroup, this.SIp.getClassLoader(), paramHashMap, this.SIs, this.SIt, new ValueCallback() {} });
      }
      return false;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "readFile error: " + paramHashMap.getMessage());
      f.a(getPluginName(), j, "invoke error ", paramHashMap);
      c(str, paramValueCallback1, -3);
    }
  }
  
  public abstract String ata(int paramInt);
  
  public abstract int atb(int paramInt);
  
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
      int i = this.SHU;
      if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
      label144:
      try
      {
        this.SIp = null;
        this.SIq = null;
        this.SIr = -1;
        Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
        paramString = atd(i);
        atc(-1);
        if ((paramString != null) && (!paramString.isEmpty())) {
          com.tencent.xweb.util.c.bsB(paramString);
        }
        f.aZ(str, i, paramInt);
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
  
  public final String ca(int paramInt, boolean paramBoolean)
  {
    String str = atd(paramInt);
    if ((str == null) || (str.isEmpty())) {
      return "";
    }
    if (!paramBoolean) {
      return str + File.separator + getPluginName() + ".zip";
    }
    return str + File.separator + getPluginName() + ".patch";
  }
  
  public final boolean dS(String paramString, boolean paramBoolean)
  {
    if (this.SHU < 0)
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
        bsR((String)localObject2);
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
  
  public abstract String hvg();
  
  public abstract String hvh();
  
  public final boolean hvi()
  {
    return false;
  }
  
  public final void hvj()
  {
    int i = this.SHU;
    if (i < 0) {
      Log.i(getPluginName(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (cb(i, true));
      Log.e(getPluginName(), "checkFiles failed, abandon version ".concat(String.valueOf(i)));
      h.bsK(getPluginName());
      str = atd(i);
      atc(-1);
    } while ((str == null) || (str.isEmpty()));
    com.tencent.xweb.util.c.bsB(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.m
 * JD-Core Version:    0.7.0.1
 */