package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.d.a;
import com.tencent.xweb.q;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.z;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class b
  extends c
{
  private static String a(DexClassLoader paramDexClassLoader)
  {
    AppMethodBeat.i(151457);
    label157:
    for (;;)
    {
      try
      {
        paramDexClassLoader = paramDexClassLoader.loadClass("com.tencent.xweb.xfiles.ppt.PPTReaderEnvironment").getMethod("getSupportFormats", new Class[0]);
        paramDexClassLoader.setAccessible(true);
        Object localObject = (String)paramDexClassLoader.invoke(null, new Object[0]);
        paramDexClassLoader = (DexClassLoader)localObject;
        if (localObject == null) {
          paramDexClassLoader = "";
        }
        boolean bool;
        Log.e("XWalkPPTReaderPlugin", "loadSupportFormat error: " + localException1.getMessage());
      }
      catch (Exception localException1)
      {
        try
        {
          if (XWalkEnvironment.getApplicationContext() == null)
          {
            Log.e("XWalkPPTReaderPlugin", "loadSupportFormat context is null");
            AppMethodBeat.o(151457);
            return paramDexClassLoader;
          }
          localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo("XFilesPPTReader");
          if (localObject == null)
          {
            Log.e("XWalkPPTReaderPlugin", "loadSupportFormat sp is null");
            AppMethodBeat.o(151457);
            return paramDexClassLoader;
          }
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("supportFormats", paramDexClassLoader);
          bool = ((SharedPreferences.Editor)localObject).commit();
          Log.i("XWalkPPTReaderPlugin", "loadSupportFormat, ret = " + bool + " formats: " + paramDexClassLoader);
          AppMethodBeat.o(151457);
          return paramDexClassLoader;
        }
        catch (Exception localException2)
        {
          break label157;
        }
        localException1 = localException1;
        paramDexClassLoader = "";
      }
    }
  }
  
  public final String TH(int paramInt)
  {
    AppMethodBeat.i(151454);
    String str = TJ(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      Log.e("XWalkPPTReaderPlugin", "getDexDir versionDir is empty");
      AppMethodBeat.o(151454);
      return "";
    }
    str = str + File.separator + "dex";
    AppMethodBeat.o(151454);
    return str;
  }
  
  public final int a(d paramd)
  {
    AppMethodBeat.i(151456);
    Log.i("XWalkPPTReaderPlugin", "performInstall");
    boolean bool = b(paramd);
    if (!bool)
    {
      Log.e("XWalkPPTReaderPlugin", "performInstall unZipAndCheck failed, return");
      com.tencent.xweb.util.f.dZP();
      AppMethodBeat.o(151456);
      return -1;
    }
    label285:
    Object localObject3;
    if (paramd.isPatch)
    {
      for (;;)
      {
        try
        {
          Log.i("XWalkPlugin", "do patch " + eak());
          if (this.BKm >= 0) {
            continue;
          }
          Log.e("XWalkPlugin", "doPatch, current version invalid");
          bool = false;
        }
        catch (Exception localException)
        {
          Object localObject1;
          Log.e("XWalkPPTReaderPlugin", "performInstall doPatch error:", localException);
          continue;
        }
        if (bool) {
          break label726;
        }
        Log.e("XWalkPPTReaderPlugin", "performInstall doPatch failed, delete all");
        com.tencent.xweb.util.f.dZQ();
        paramd = TJ(paramd.version);
        if (!paramd.isEmpty()) {
          com.tencent.xweb.util.b.ayf(paramd);
        }
        AppMethodBeat.o(151456);
        return -1;
        if (!paramd.isPatch)
        {
          Log.e("XWalkPlugin", "doPatch, current download config is not patch");
          bool = false;
        }
        else
        {
          localObject1 = new File(bY(paramd.version, "patch.config"));
          if (!((File)localObject1).exists())
          {
            Log.e("XWalkPlugin", "doPatch, can not find patch config file");
            bool = false;
          }
          else
          {
            localObject1 = f.ax((File)localObject1);
            if ((localObject1 == null) || (((List)localObject1).size() == 0))
            {
              Log.e("XWalkPlugin", "doPatch, patchConfigList = null");
              bool = false;
            }
            else
            {
              Log.i("XWalkPlugin", "doPatch, parse patch.config finished");
              if (!com.tencent.xweb.util.b.jd(TL(this.BKm), TL(paramd.version)))
              {
                Log.e("XWalkPlugin", "doPatch, copy files failed");
                bool = false;
              }
              else
              {
                Log.i("XWalkPlugin", "doPatch, copy all extract file finished");
                localObject1 = ((List)localObject1).iterator();
              }
            }
          }
        }
      }
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (f.a)((Iterator)localObject1).next();
          if (((f.a)localObject3).type != 1) {
            break label1083;
          }
          i = 1;
          label318:
          if (i != 0)
          {
            if (!com.tencent.xweb.util.b.copyFile(bY(paramd.version, ((f.a)localObject3).originalFileName), bX(paramd.version, ((f.a)localObject3).originalFileName)))
            {
              Log.e("XWalkPlugin", "doPatch, add file error: ".concat(String.valueOf(localObject3)));
              bool = false;
              break;
            }
            Log.i("XWalkPlugin", "doPatch, add file:".concat(String.valueOf(localObject3)));
            continue;
          }
          if (((f.a)localObject3).type != 3) {
            break label1088;
          }
          i = 1;
          label421:
          if (i != 0)
          {
            if (!com.tencent.xweb.util.b.deleteFile(bX(paramd.version, ((f.a)localObject3).originalFileName))) {
              Log.e("XWalkPlugin", "doPatch, delete file error:".concat(String.valueOf(localObject3)));
            } else {
              Log.i("XWalkPlugin", "doPatch, delete file:".concat(String.valueOf(localObject3)));
            }
          }
          else {
            if (((f.a)localObject3).type != 2) {
              break label1093;
            }
          }
        }
      }
    }
    label1083:
    label1088:
    label1093:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (BSpatch.aK(bX(paramd.version, ((f.a)localObject3).originalFileName), bY(paramd.version, ((f.a)localObject3).patchFileName), bX(paramd.version, ((f.a)localObject3).originalFileName)) < 0)
        {
          Log.e("XWalkPlugin", "doPatch, patch file error:".concat(String.valueOf(localObject3)));
          bool = false;
          break;
        }
        Log.i("XWalkPlugin", "doPatch, patch file:".concat(String.valueOf(localObject3)));
        break label285;
      }
      Log.e("XWalkPlugin", "doPatch, unknown op".concat(String.valueOf(localObject3)));
      bool = false;
      break;
      Log.i("XWalkPlugin", "doPatch, finished");
      com.tencent.xweb.util.b.deleteFile(bX(paramd.version, "filelist.config"));
      if (!com.tencent.xweb.util.b.copyFile(bY(paramd.version, "filelist.config"), bX(paramd.version, "filelist.config")))
      {
        Log.e("XWalkPlugin", "doPatch, copy filelist.config error");
        bool = false;
        break;
      }
      if (!aQ(paramd.version, false))
      {
        Log.e("XWalkPlugin", "doPatch, check md5 failed");
        bool = false;
        break;
      }
      Object localObject2 = TM(paramd.version);
      if (!((String)localObject2).isEmpty()) {
        com.tencent.xweb.util.b.ayf((String)localObject2);
      }
      bool = true;
      break;
      label726:
      localObject2 = bX(paramd.version, "pptreader.apk");
      localObject3 = TH(paramd.version);
      Object localObject4 = new File((String)localObject3);
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdirs();
      }
      for (;;)
      {
        try
        {
          localObject2 = a(new DexClassLoader((String)localObject2, (String)localObject3, null, ClassLoader.getSystemClassLoader())).split(",");
          q.dYn().a((String[])localObject2, d.a.BDa);
          z.ab((String[])localObject2);
          if (XWalkEnvironment.getApplicationContext() == null)
          {
            Log.e("XWalkPlugin", "clearPatchDownloadInfo of " + eak() + " context is null");
            localObject2 = TK(paramd.version);
            if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
              com.tencent.xweb.util.b.ayf((String)localObject2);
            }
            TI(paramd.version);
            Log.i("XWalkPPTReaderPlugin", "performInstall success");
            AppMethodBeat.o(151456);
            return 0;
            localObject4 = ((File)localObject4).listFiles();
            if ((localObject4 == null) || (localObject4.length <= 0)) {
              continue;
            }
            int j = localObject4.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject5 = localObject4[i];
            if ((localObject5 != null) && (localObject5.exists())) {
              localObject5.delete();
            }
            i += 1;
            continue;
          }
          localObject2 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(eak());
          if (localObject2 == null)
          {
            Log.e("XWalkPlugin", "clearPatchDownloadInfo of " + eak() + " sp is null");
            continue;
          }
          localObject2 = ((SharedPreferences)localObject2).edit();
        }
        catch (Exception paramd)
        {
          com.tencent.xweb.util.f.dZR();
          Log.e("XWalkPPTReaderPlugin", "performInstall error: " + paramd.getMessage());
          AppMethodBeat.o(151456);
          return -1;
        }
        ((SharedPreferences.Editor)localObject2).putInt("patchDownloadCount", 0);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      i = 0;
      break label318;
      i = 0;
      break label421;
    }
  }
  
  public final String aP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(151453);
    String str = TJ(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(151453);
      return "";
    }
    if (!paramBoolean)
    {
      str = str + File.separator + "XFilesPPTReader.zip";
      AppMethodBeat.o(151453);
      return str;
    }
    str = str + File.separator + "XFilesPPTReader.patch";
    AppMethodBeat.o(151453);
    return str;
  }
  
  public final boolean cB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151458);
    int i = this.BKm;
    if (i < 0)
    {
      Log.i("XWalkPPTReaderPlugin", "isSupport not installed");
      AppMethodBeat.o(151458);
      return false;
    }
    Object localObject1;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPPTReaderPlugin", "getSupportFormat context is null");
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
        localObject2 = a(new DexClassLoader(bX(i, "pptreader.apk"), TH(i), null, ClassLoader.getSystemClassLoader()));
        paramBoolean = ((String)localObject2).toLowerCase().contains(paramString.toLowerCase());
        AppMethodBeat.o(151458);
        return paramBoolean;
      }
      catch (Exception paramString)
      {
        Log.e("XWalkPPTReaderPlugin", "isSupport error: " + paramString.getMessage());
        AppMethodBeat.o(151458);
      }
      localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo("XFilesPPTReader");
      if (localObject1 == null)
      {
        Log.e("XWalkPPTReaderPlugin", "getSupportFormat sp is null");
        localObject1 = "";
      }
      else
      {
        localObject1 = ((SharedPreferences)localObject1).getString("supportFormats", "");
      }
    }
    return false;
  }
  
  public final String eak()
  {
    return "XFilesPPTReader";
  }
  
  public final boolean eal()
  {
    return false;
  }
  
  public final void eam()
  {
    AppMethodBeat.i(151455);
    if (this.BKm < 0)
    {
      Log.i("XWalkPPTReaderPlugin", "checkFiles plugin not installed, skip");
      AppMethodBeat.o(151455);
      return;
    }
    if (!aQ(this.BKm, true))
    {
      Log.e("XWalkPPTReaderPlugin", "checkFiles failed, abandon current version " + this.BKm);
      com.tencent.xweb.util.f.dZS();
      String str = TJ(this.BKm);
      TI(-1);
      if ((str != null) && (!str.isEmpty())) {
        com.tencent.xweb.util.b.ayf(str);
      }
      AppMethodBeat.o(151455);
      return;
    }
    Log.i("XWalkPPTReaderPlugin", "checkFiles success");
    AppMethodBeat.o(151455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.b
 * JD-Core Version:    0.7.0.1
 */