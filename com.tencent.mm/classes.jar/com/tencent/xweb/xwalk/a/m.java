package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.c;
import com.tencent.xweb.h.b;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.b.d;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class m
  extends g
{
  protected Class aakh = null;
  protected Class aaki = null;
  protected int aakj = -1;
  ValueCallback<Pair<Integer, String>> aakk = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> aakl = new ValueCallback() {};
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(iza());
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
      izr();
      paramClassLoader = this.aaki;
    }
    return "";
  }
  
  private String aDd(int paramInt)
  {
    String str = aCZ(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  private boolean bFS(String paramString)
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
  
  private void izr()
  {
    try
    {
      int i = izd();
      if ((this.aakh == null) || (this.aaki == null) || (this.aakj != i))
      {
        Log.i(getPluginName(), "load class of version ".concat(String.valueOf(i)));
        ClassLoader localClassLoader = i.bv(aCW(i), aDd(i), null);
        this.aakh = localClassLoader.loadClass(iyZ());
        this.aaki = localClassLoader.loadClass(iza());
        this.aakj = i;
      }
      return;
    }
    finally {}
  }
  
  private static String izs()
  {
    return "display_" + Build.DISPLAY + ",sdk_" + Build.VERSION.SDK_INT + ",release_" + Build.VERSION.RELEASE + ",client_" + XWalkEnvironment.getAppClientVersion();
  }
  
  public final void A(HashMap<String, String> paramHashMap)
  {
    if (this.aakh == null)
    {
      Log.e(getPluginName(), "finishReadFile error, loadedReaderClass is null");
      return;
    }
    try
    {
      Method localMethod = this.aakh.getMethod("finishReadFile", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramHashMap });
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.e(getPluginName(), "finishReadFile error: " + paramHashMap.getMessage());
    }
  }
  
  public final h.b B(HashMap<String, Object> paramHashMap)
  {
    if (this.aakh == null)
    {
      Log.e(getPluginName(), "getViewStatus error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Object localObject1 = this.aakh.getMethod("getViewStatus", new Class[] { HashMap.class });
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
  
  public final boolean C(HashMap<String, Object> paramHashMap)
  {
    if (this.aakh == null)
    {
      Log.e(getPluginName(), "setViewToStatus error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.aakh.getMethod("setViewToStatus", new Class[] { HashMap.class });
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
  
  public final boolean D(HashMap<String, Object> paramHashMap)
  {
    if (this.aakh == null)
    {
      Log.e(getPluginName(), "requestThumbnail error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.aakh.getMethod("requestThumbnail", new Class[] { HashMap.class });
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
  
  public final Object E(HashMap<String, Object> paramHashMap)
  {
    if (this.aakh == null)
    {
      Log.e(getPluginName(), "generalInvoke error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Method localMethod = this.aakh.getMethod("generalInvoke", new Class[] { HashMap.class });
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
  
  public final int a(d paramd)
  {
    Log.i(getPluginName(), "performInstall version " + paramd.version);
    boolean bool1 = b(paramd);
    if (!bool1)
    {
      Log.e(getPluginName(), "performInstall unZipAndCheck failed");
      h.dY(getPluginName(), paramd.aakU);
    }
    do
    {
      return -1;
      if (!paramd.aakU) {
        break label142;
      }
      try
      {
        boolean bool2 = c(paramd);
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
      h.bFI(getPluginName());
      paramd = aCZ(paramd.version);
    } while (paramd.isEmpty());
    c.bFA(paramd);
    return -1;
    label142:
    Object localObject1 = aCW(paramd.version);
    String str = aDd(paramd.version);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject1 = a(i.bv((String)localObject1, str, null));
        bFS((String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        y.iwp().a((String[])localObject1, f.a.ZZK);
        y.iwp().a((String[])localObject1, f.c.ZZP);
        e.ah((String[])localObject1);
        izf();
        localObject1 = aDa(paramd.version);
        if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
          c.bFA((String)localObject1);
        }
        aCY(paramd.version);
        Log.i(getPluginName(), "performInstall version " + this.aajM + " success");
        return 0;
      }
      catch (Exception localException2)
      {
        int j;
        int i;
        Object localObject3;
        h.dZ(getPluginName(), paramd.aakU);
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
    int j = this.aajM;
    if (j <= 0)
    {
      Log.e(getPluginName(), "readFile plugin not installed");
      c(str, paramValueCallback1, -2);
      return false;
    }
    if (paramValueCallback != null) {}
    for (int i = 1;; i = 0)
    {
      i = aCX(i);
      if (j >= i) {
        break;
      }
      Log.e(getPluginName(), "readFile plugin version is too old, require: ".concat(String.valueOf(i)));
      c(str, paramValueCallback1, -11);
      return false;
    }
    Log.i(getPluginName(), "readFile by xweb, plugin version ".concat(String.valueOf(j)));
    if ("XFilesPPTReader".equalsIgnoreCase(getPluginName())) {
      oi(j, 1068);
    }
    label776:
    for (;;)
    {
      try
      {
        Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (localObject == null)
        {
          Log.e(getPluginName(), "recordEnv sp is null");
          bool = true;
          if (bool) {
            Log.i(getPluginName(), "readFile, env changed");
          }
          paramHashMap.put("env_changed", String.valueOf(bool));
          paramHashMap.put("cache_dir", aDa(j));
          paramHashMap.put("res_dir", aDb(j));
          izr();
          if (paramValueCallback != null)
          {
            localObject = this.aakh.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
            ((Method)localObject).setAccessible(true);
            e.aRh(str);
            ((Method)localObject).invoke(null, new Object[] { paramActivity, paramViewGroup, this.aakh.getClassLoader(), paramHashMap, paramValueCallback, this.aakk, this.aakl, new ValueCallback() {} });
            return true;
            if ("XFilesPDFReader".equalsIgnoreCase(getPluginName()))
            {
              oi(j, 1071);
              continue;
            }
            if ("XFilesWordReader".equalsIgnoreCase(getPluginName()))
            {
              oi(j, 1069);
              continue;
            }
            if ("XFilesExcelReader".equalsIgnoreCase(getPluginName()))
            {
              oi(j, 1070);
              continue;
            }
            if ("XFilesOfficeReader".equalsIgnoreCase(getPluginName()))
            {
              oi(j, 1544);
              continue;
            }
            Log.e(getPluginName(), "unknown report id");
          }
        }
        else
        {
          if (izs().equals(((SharedPreferences)localObject).getString("lastEnvInfo", ""))) {
            break label776;
          }
          bool = true;
          continue;
        }
        paramValueCallback = this.aakh.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        paramValueCallback.setAccessible(true);
        e.aRh(str);
        paramValueCallback.invoke(null, new Object[] { paramActivity, paramViewGroup, this.aakh.getClassLoader(), paramHashMap, this.aakk, this.aakl, new ValueCallback() {} });
        continue;
        boolean bool = false;
      }
      catch (Exception paramHashMap)
      {
        Log.e(getPluginName(), "readFile error: " + paramHashMap.getMessage());
        f.a(getPluginName(), j, "invoke error ", paramHashMap);
        c(str, paramValueCallback1, -3);
        return false;
      }
    }
  }
  
  public abstract String aCW(int paramInt);
  
  public abstract int aCX(int paramInt);
  
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
      int i = this.aajM;
      if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
      label144:
      try
      {
        this.aakh = null;
        this.aaki = null;
        this.aakj = -1;
        Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
        paramString = aCZ(i);
        aCY(-1);
        if ((paramString != null) && (!paramString.isEmpty())) {
          c.bFA(paramString);
        }
        f.bb(str, i, paramInt);
        if (paramValueCallback != null) {}
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
  
  public final String cm(int paramInt, boolean paramBoolean)
  {
    String str = aCZ(paramInt);
    if ((str == null) || (str.isEmpty())) {
      return "";
    }
    if (!paramBoolean) {
      return str + File.separator + getPluginName() + ".zip";
    }
    return str + File.separator + getPluginName() + ".patch";
  }
  
  public final boolean ef(String paramString, boolean paramBoolean)
  {
    if (this.aajM < 0)
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
        bFS((String)localObject2);
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
  
  public abstract String iyZ();
  
  public abstract String iza();
  
  public final boolean izb()
  {
    return false;
  }
  
  public final void izc()
  {
    int i = this.aajM;
    if (i < 0) {
      Log.i(getPluginName(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (cn(i, true));
      Log.e(getPluginName(), "checkFiles failed, abandon version ".concat(String.valueOf(i)));
      h.bFJ(getPluginName());
      str = aCZ(i);
      aCY(-1);
    } while ((str == null) || (str.isEmpty()));
    c.bFA(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.m
 * JD-Core Version:    0.7.0.1
 */