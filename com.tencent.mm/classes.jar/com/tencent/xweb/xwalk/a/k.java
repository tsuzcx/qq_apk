package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.xweb.f.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.x;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class k
  extends e
{
  protected Class IVf = null;
  protected Class IVg = null;
  protected int IVh = -1;
  ValueCallback<Pair<Integer, String>> IVi = new ValueCallback() {};
  ValueCallback<Pair<Integer, String>> IVj = new ValueCallback() {};
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass(fte());
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
      ftr();
      paramClassLoader = this.IVg;
    }
    return "";
  }
  
  private boolean aPE(String paramString)
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
  
  private String adt(int paramInt)
  {
    String str = ado(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e(getPluginName(), "getDexDir, versionDir is empty");
      return "";
    }
    return str + File.separator + "dex";
  }
  
  public final int a(f paramf)
  {
    Log.i(getPluginName(), "performInstall version " + paramf.version);
    boolean bool1 = b(paramf);
    if (!bool1)
    {
      Log.e(getPluginName(), "performInstall unZipAndCheck failed");
      g.de(getPluginName(), paramf.isPatch);
    }
    do
    {
      return -1;
      if (!paramf.isPatch) {
        break label138;
      }
      try
      {
        boolean bool2 = c(paramf);
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
      g.aPy(getPluginName());
      paramf = ado(paramf.version);
    } while (paramf.isEmpty());
    c.aPq(paramf);
    return -1;
    label138:
    Object localObject1 = adm(paramf.version);
    String str = adt(paramf.version);
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    for (;;)
    {
      try
      {
        localObject1 = a(h.ba((String)localObject1, str, null));
        aPE((String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        x.fqR().a((String[])localObject1, f.a.IMt);
        com.tencent.xweb.e.ae((String[])localObject1);
        if (XWalkEnvironment.getApplicationContext() == null)
        {
          Log.e(getPluginName(), "clearPatchDownloadInfo, context is null");
          localObject1 = adp(paramf.version);
          if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
            c.aPq((String)localObject1);
          }
          adn(paramf.version);
          Log.i(getPluginName(), "performInstall version " + this.IUH + " success");
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
        g.df(getPluginName(), paramf.isPatch);
        Log.e(getPluginName(), "performInstall error: " + localException2.getMessage());
        return -1;
      }
      SharedPreferences.Editor localEditor;
      localEditor.putInt("patchDownloadCount", 0);
      localEditor.commit();
    }
  }
  
  public abstract boolean a(HashMap<String, String> paramHashMap, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback);
  
  public abstract String adm(int paramInt);
  
  protected final void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt)
  {
    int i = this.IUH;
    if ((i > 0) && ((paramInt == -3) || (paramInt == -13))) {}
    try
    {
      this.IVf = null;
      this.IVg = null;
      this.IVh = -1;
      Log.e(getPluginName(), "invoke error or abi not match, abandon current version ".concat(String.valueOf(i)));
      String str = ado(i);
      adn(-1);
      if ((str != null) && (!str.isEmpty())) {
        c.aPq(str);
      }
      com.tencent.xweb.f.aW(paramString, i, paramInt);
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue(Integer.valueOf(paramInt));
      }
      return;
    }
    finally {}
  }
  
  public final String bd(int paramInt, boolean paramBoolean)
  {
    String str = ado(paramInt);
    if ((str == null) || (str.isEmpty())) {
      return "";
    }
    if (!paramBoolean) {
      return str + File.separator + getPluginName() + ".zip";
    }
    return str + File.separator + getPluginName() + ".patch";
  }
  
  public final boolean dj(String paramString, boolean paramBoolean)
  {
    if (this.IUH < 0)
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
        aPE((String)localObject2);
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
  
  public abstract String ftd();
  
  public abstract String fte();
  
  public abstract int ftf();
  
  public final boolean ftg()
  {
    return false;
  }
  
  public final void fth()
  {
    if (this.IUH < 0) {
      Log.i(getPluginName(), "checkFiles, not installed");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (be(this.IUH, true));
      Log.e(getPluginName(), "checkFiles failed, abandon version " + this.IUH);
      g.aPz(getPluginName());
      str = ado(this.IUH);
      adn(-1);
    } while ((str == null) || (str.isEmpty()));
    c.aPq(str);
  }
  
  protected final void ftr()
  {
    try
    {
      if ((this.IVf == null) || (this.IVg == null) || (this.IVh != this.IUH))
      {
        Log.i(getPluginName(), "load class of version " + this.IUH);
        ClassLoader localClassLoader = h.ba(adm(this.IUH), adt(this.IUH), null);
        this.IVf = localClassLoader.loadClass(ftd());
        this.IVg = localClassLoader.loadClass(fte());
        this.IVh = this.IUH;
      }
      return;
    }
    finally {}
  }
  
  public abstract void p(HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */