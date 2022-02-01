package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.aa;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.c;
import com.tencent.xweb.j.b;
import com.tencent.xweb.util.l;
import com.tencent.xweb.util.m;
import com.tencent.xweb.xwalk.updater.d;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public abstract class n
  extends g
{
  protected Class aiqj = null;
  protected Class aiqk = null;
  protected int aiql = -1;
  ValueCallback<Pair<Integer, String>> aiqm = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> aiqn = new ValueCallback() {};
  
  private String aJQ(int paramInt)
  {
    String str = getVersionDir(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(kjs(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  private boolean bIq(String paramString)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(kjs(), "saveSupportFormats, context is null");
      return false;
    }
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
    if (localObject == null)
    {
      Log.e(kjs(), "saveSupportFormats, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("supportFormats", paramString);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    Log.i(kjs(), "loadSupportFormat, ret = " + bool + ", formats: " + paramString);
    return bool;
  }
  
  private String c(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(kjv());
        paramClassLoader = paramClassLoader.getMethod("getSupportFormats", new Class[0]);
        paramClassLoader.setAccessible(true);
        String str = (String)paramClassLoader.invoke(null, new Object[0]);
        paramClassLoader = str;
        if (str == null) {
          paramClassLoader = "";
        }
        return paramClassLoader;
      }
      finally
      {
        Log.e(kjs(), "loadSupportFormatsFromPlugin error: ".concat(String.valueOf(paramClassLoader)));
      }
      kjM();
      paramClassLoader = this.aiqk;
    }
    return "";
  }
  
  private void kjM()
  {
    try
    {
      int i = kjy();
      if ((this.aiqj == null) || (this.aiqk == null) || (this.aiql != i))
      {
        Log.i(kjs(), "load class of version ".concat(String.valueOf(i)));
        ClassLoader localClassLoader = m.bS(aJK(i), aJQ(i), null);
        this.aiqj = localClassLoader.loadClass(kju());
        this.aiqk = localClassLoader.loadClass(kjv());
        this.aiql = i;
      }
      return;
    }
    finally {}
  }
  
  private static String kjN()
  {
    return "display_" + Build.DISPLAY + ",sdk_" + Build.VERSION.SDK_INT + ",release_" + Build.VERSION.RELEASE + ",client_" + XWalkEnvironment.getAppClientVersion();
  }
  
  public final void C(HashMap<String, String> paramHashMap)
  {
    if (this.aiqj == null)
    {
      Log.e(kjs(), "finishReadFile error, loadedReaderClass is null");
      return;
    }
    try
    {
      Method localMethod = this.aiqj.getMethod("finishReadFile", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramHashMap });
      return;
    }
    finally
    {
      Log.e(kjs(), "finishReadFile error: ".concat(String.valueOf(paramHashMap)));
    }
  }
  
  public final j.b D(HashMap<String, Object> paramHashMap)
  {
    if (this.aiqj == null)
    {
      Log.e(kjs(), "getViewStatus error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Object localObject1 = this.aiqj.getMethod("getViewStatus", new Class[] { HashMap.class });
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
          Log.e(kjs(), "getViewStatus error, value invalid");
          return null;
        }
        paramHashMap = new j.b(((Integer)paramHashMap).intValue(), ((Float)localObject1).floatValue(), ((Integer)localObject2).intValue(), ((Integer)localObject3).intValue());
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      Log.e(kjs(), "getViewStatus error: ".concat(String.valueOf(paramHashMap)));
    }
    return null;
  }
  
  public final boolean E(HashMap<String, Object> paramHashMap)
  {
    if (this.aiqj == null)
    {
      Log.e(kjs(), "setViewToStatus error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.aiqj.getMethod("setViewToStatus", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      if ((paramHashMap instanceof Boolean))
      {
        boolean bool = ((Boolean)paramHashMap).booleanValue();
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e(kjs(), "setViewToStatus error: ".concat(String.valueOf(paramHashMap)));
    }
    return false;
  }
  
  public final boolean F(HashMap<String, Object> paramHashMap)
  {
    if (this.aiqj == null)
    {
      Log.e(kjs(), "requestThumbnail error, loadedReaderClass is null");
      return false;
    }
    try
    {
      Method localMethod = this.aiqj.getMethod("requestThumbnail", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      if ((paramHashMap instanceof Boolean))
      {
        boolean bool = ((Boolean)paramHashMap).booleanValue();
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e(kjs(), "requestThumbnail error: ".concat(String.valueOf(paramHashMap)));
    }
    return false;
  }
  
  public final Object G(HashMap<String, Object> paramHashMap)
  {
    if (this.aiqj == null)
    {
      Log.e(kjs(), "generalInvoke error, loadedReaderClass is null");
      return null;
    }
    try
    {
      Method localMethod = this.aiqj.getMethod("generalInvoke", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      paramHashMap = localMethod.invoke(null, new Object[] { paramHashMap });
      return paramHashMap;
    }
    finally
    {
      Log.e(kjs(), "generalInvoke error: ".concat(String.valueOf(paramHashMap)));
    }
    return null;
  }
  
  public final int a(d paramd)
  {
    Log.i(kjs(), "performInstall version " + paramd.version);
    boolean bool1 = b(paramd);
    if (!bool1)
    {
      Log.e(kjs(), "performInstall unZipAndCheck failed");
      l.eN(kjs(), paramd.aiqx);
    }
    do
    {
      return -1;
      if (!paramd.aiqx) {
        break label148;
      }
      try
      {
        boolean bool2 = c(paramd);
        bool1 = bool2;
      }
      finally
      {
        for (;;)
        {
          Log.e(kjs(), "performInstall doPatch error:".concat(String.valueOf(localObject1)));
        }
      }
      if (bool1) {
        break label148;
      }
      Log.e(kjs(), "performInstall doPatch failed, delete all");
      l.bIh(kjs());
      paramd = getVersionDir(paramd.version);
    } while (paramd.isEmpty());
    com.tencent.xweb.util.g.bHZ(paramd);
    return -1;
    label148:
    Object localObject2 = aJK(paramd.version);
    String str = aJQ(paramd.version);
    Object localObject4 = new File(str);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject2 = c(m.bS((String)localObject2, str, null));
        bIq((String)localObject2);
        localObject2 = ((String)localObject2).split(",");
        aa.kfE();
        aa.a((String[])localObject2, h.a.aiet);
        aa.kfE();
        aa.a((String[])localObject2, h.c.aiey);
        com.tencent.xweb.g.aj((String[])localObject2);
        kjA();
        localObject2 = aJN(paramd.version);
        if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
          com.tencent.xweb.util.g.bHZ((String)localObject2);
        }
        aJM(paramd.version);
        Log.i(kjs(), "performInstall version " + this.aipK + " success");
        return 0;
      }
      finally
      {
        int j;
        int i;
        Object localObject5;
        l.eO(kjs(), paramd.aiqx);
        Log.e(kjs(), "performInstall error: ".concat(String.valueOf(localObject3)));
      }
      localObject4 = ((File)localObject4).listFiles();
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        j = localObject4.length;
        i = 0;
        if (i < j)
        {
          localObject5 = localObject4[i];
          if ((localObject5 != null) && (localObject5.exists())) {
            localObject5.delete();
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
      Log.e(kjs(), "readFile params is null");
      c("", paramValueCallback1, -5);
      return false;
    }
    final String str = (String)paramHashMap.get("file_ext");
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(kjs(), "readFile fileExt is null");
      c("", paramValueCallback1, -5);
      return false;
    }
    int j = this.aipK;
    if (j <= 0)
    {
      Log.e(kjs(), "readFile plugin not installed");
      c(str, paramValueCallback1, -2);
      return false;
    }
    if (paramValueCallback != null) {}
    for (int i = 1;; i = 0)
    {
      i = aJL(i);
      if (j >= i) {
        break;
      }
      Log.e(kjs(), "readFile plugin version is too old, require: ".concat(String.valueOf(i)));
      c(str, paramValueCallback1, -11);
      return false;
    }
    Log.i(kjs(), "readFile by xweb, plugin version ".concat(String.valueOf(j)));
    if ("XFilesPPTReader".equalsIgnoreCase(kjs())) {
      qi(j, 1068);
    }
    label766:
    for (;;)
    {
      try
      {
        Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
        if (localObject == null)
        {
          Log.e(kjs(), "recordEnv sp is null");
          bool = true;
          if (bool) {
            Log.i(kjs(), "readFile, env changed");
          }
          paramHashMap.put("env_changed", String.valueOf(bool));
          paramHashMap.put("cache_dir", aJN(j));
          paramHashMap.put("res_dir", aJO(j));
          kjM();
          if (paramValueCallback != null)
          {
            localObject = this.aiqj.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
            ((Method)localObject).setAccessible(true);
            com.tencent.xweb.g.aNZ(str);
            ((Method)localObject).invoke(null, new Object[] { paramActivity, paramViewGroup, this.aiqj.getClassLoader(), paramHashMap, paramValueCallback, this.aiqm, this.aiqn, new ValueCallback() {} });
            return true;
            if ("XFilesPDFReader".equalsIgnoreCase(kjs()))
            {
              qi(j, 1071);
              continue;
            }
            if ("XFilesWordReader".equalsIgnoreCase(kjs()))
            {
              qi(j, 1069);
              continue;
            }
            if ("XFilesExcelReader".equalsIgnoreCase(kjs()))
            {
              qi(j, 1070);
              continue;
            }
            if ("XFilesOfficeReader".equalsIgnoreCase(kjs()))
            {
              qi(j, 1544);
              continue;
            }
            Log.e(kjs(), "unknown report id");
          }
        }
        else
        {
          if (kjN().equals(((SharedPreferences)localObject).getString("lastEnvInfo", ""))) {
            break label766;
          }
          bool = true;
          continue;
        }
        paramValueCallback = this.aiqj.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
        paramValueCallback.setAccessible(true);
        com.tencent.xweb.g.aNZ(str);
        paramValueCallback.invoke(null, new Object[] { paramActivity, paramViewGroup, this.aiqj.getClassLoader(), paramHashMap, this.aiqm, this.aiqn, new ValueCallback() {} });
        continue;
        boolean bool = false;
      }
      finally
      {
        Log.e(kjs(), "readFile error: ".concat(String.valueOf(paramHashMap)));
        h.a(kjs(), j, "invoke error ", paramHashMap);
        c(str, paramValueCallback1, -3);
        return false;
      }
    }
  }
  
  public abstract String aJK(int paramInt);
  
  public abstract int aJL(int paramInt);
  
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
      if (!"XFilesPPTReader".equalsIgnoreCase(kjs())) {
        break label144;
      }
      str = "ppt";
    }
    for (;;)
    {
      int i = this.aipK;
      if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
      label144:
      try
      {
        this.aiqj = null;
        this.aiqk = null;
        this.aiql = -1;
        Log.e(kjs(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
        paramString = getVersionDir(i);
        aJM(-1);
        if ((paramString != null) && (!paramString.isEmpty())) {
          com.tencent.xweb.util.g.bHZ(paramString);
        }
        h.bl(str, i, paramInt);
        if (paramValueCallback != null) {}
        return;
      }
      finally {}
      if ("XFilesPDFReader".equalsIgnoreCase(kjs()))
      {
        str = "pdf";
      }
      else if ("XFilesWordReader".equalsIgnoreCase(kjs()))
      {
        str = "doc";
      }
      else if ("XFilesExcelReader".equalsIgnoreCase(kjs()))
      {
        str = "xls";
      }
      else
      {
        Log.e(kjs(), "onReceiveValueProcess unknown fileExt");
        str = paramString;
      }
    }
  }
  
  public final String dg(int paramInt, boolean paramBoolean)
  {
    String str = getVersionDir(paramInt);
    if ((str == null) || (str.isEmpty())) {
      return "";
    }
    if (!paramBoolean) {
      return str + File.separator + kjs() + ".zip";
    }
    return str + File.separator + kjs() + ".patch";
  }
  
  /* Error */
  public final boolean eU(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 411	com/tencent/xweb/xwalk/a/g:aipK	I
    //   4: ifge +15 -> 19
    //   7: aload_0
    //   8: invokevirtual 45	com/tencent/xweb/xwalk/a/n:kjs	()Ljava/lang/String;
    //   11: ldc_w 553
    //   14: invokestatic 139	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: iconst_0
    //   18: ireturn
    //   19: invokestatic 120	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   22: ifnonnull +60 -> 82
    //   25: aload_0
    //   26: invokevirtual 45	com/tencent/xweb/xwalk/a/n:kjs	()Ljava/lang/String;
    //   29: ldc_w 555
    //   32: invokestatic 59	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 94
    //   37: astore_3
    //   38: aload_3
    //   39: astore 4
    //   41: aload_3
    //   42: invokevirtual 90	java/lang/String:isEmpty	()Z
    //   45: ifeq +24 -> 69
    //   48: aload_3
    //   49: astore 4
    //   51: iload_2
    //   52: ifeq +17 -> 69
    //   55: aload_0
    //   56: aconst_null
    //   57: invokespecial 360	com/tencent/xweb/xwalk/a/n:c	(Ljava/lang/ClassLoader;)Ljava/lang/String;
    //   60: astore 4
    //   62: aload_0
    //   63: aload 4
    //   65: invokespecial 362	com/tencent/xweb/xwalk/a/n:bIq	(Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 4
    //   71: invokevirtual 558	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   74: aload_1
    //   75: invokevirtual 558	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   78: invokevirtual 562	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ireturn
    //   82: aload_0
    //   83: invokevirtual 45	com/tencent/xweb/xwalk/a/n:kjs	()Ljava/lang/String;
    //   86: invokestatic 51	org/xwalk/core/XWalkSharedPreferenceUtil:getSharedPreferencesForPluginVersionInfo	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   89: astore_3
    //   90: aload_3
    //   91: ifnonnull +19 -> 110
    //   94: aload_0
    //   95: invokevirtual 45	com/tencent/xweb/xwalk/a/n:kjs	()Ljava/lang/String;
    //   98: ldc_w 564
    //   101: invokestatic 59	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc 94
    //   106: astore_3
    //   107: goto -69 -> 38
    //   110: aload_3
    //   111: ldc 126
    //   113: ldc 94
    //   115: invokeinterface 504 3 0
    //   120: astore_3
    //   121: goto -83 -> 38
    //   124: astore_1
    //   125: aload_0
    //   126: invokevirtual 45	com/tencent/xweb/xwalk/a/n:kjs	()Ljava/lang/String;
    //   129: ldc_w 566
    //   132: aload_1
    //   133: invokestatic 179	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 183	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 59	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: iconst_0
    //   143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	n
    //   0	144	1	paramString	String
    //   0	144	2	paramBoolean	boolean
    //   37	84	3	localObject1	Object
    //   39	31	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	69	124	finally
  }
  
  public abstract String kju();
  
  public abstract String kjv();
  
  public final boolean kjw()
  {
    return false;
  }
  
  public final void kjx()
  {
    int i = this.aipK;
    if (i < 0) {
      Log.i(kjs(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (dh(i, true));
      Log.e(kjs(), "checkFiles failed, abandon version ".concat(String.valueOf(i)));
      l.bIi(kjs());
      str = getVersionDir(i);
      aJM(-1);
    } while ((str == null) || (str.isEmpty()));
    com.tencent.xweb.util.g.bHZ(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.n
 * JD-Core Version:    0.7.0.1
 */