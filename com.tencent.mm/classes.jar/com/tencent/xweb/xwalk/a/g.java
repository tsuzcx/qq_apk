package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.updater.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public abstract class g
{
  public int aipK = -1;
  
  public g()
  {
    kjz();
  }
  
  private String aJP(int paramInt)
  {
    Object localObject = getVersionDir(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(kjs(), "getPatchDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "patch_temp";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  private String ez(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(kjs(), "getPatchFile, fileName is empty");
      return "";
    }
    String str = aJP(paramInt);
    if (str.isEmpty())
    {
      Log.e(kjs(), "getPatchFile, patchDir is null");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  private void kjz()
  {
    if (XWalkEnvironment.getApplicationContext() == null) {
      Log.e(kjs(), "loadVer, context is null");
    }
    int i;
    do
    {
      return;
      SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
      if (localSharedPreferences == null)
      {
        Log.e(kjs(), "loadVer, sp is null");
        return;
      }
      i = this.aipK;
      this.aipK = localSharedPreferences.getInt("availableVersion", -1);
    } while (this.aipK == i);
    if (i == -1)
    {
      Log.i(kjs(), "loadVer, version = " + this.aipK);
      return;
    }
    Log.i(kjs(), "loadVer, old version = " + i + ", new version = " + this.aipK);
  }
  
  public abstract int a(d paramd);
  
  public final boolean aJM(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(kjs(), "setVer, context is null");
      return false;
    }
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
    if (localObject == null)
    {
      Log.e(kjs(), "setVer, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if (bool) {
      this.aipK = paramInt;
    }
    Log.i(kjs(), "setVer, version = " + paramInt + ", isNow = true, ret = " + bool);
    return bool;
  }
  
  public final String aJN(int paramInt)
  {
    Object localObject = getVersionDir(paramInt);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e(kjs(), "getPrivateCacheDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "cache";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String aJO(int paramInt)
  {
    Object localObject = getVersionDir(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(kjs(), "getExtractDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "extracted";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  protected final boolean b(d paramd)
  {
    Log.i(kjs(), "unZipAndCheck version " + paramd.version);
    localFile = new File(paramd.path);
    try
    {
      if (!h.rb(paramd.path, paramd.aiiJ))
      {
        Log.i(kjs(), "unZipAndCheck failed, zip md5 not match");
        com.tencent.xweb.util.g.d(null);
        if (localFile.exists()) {
          localFile.delete();
        }
        return false;
      }
      localZipFile = new ZipFile(paramd.path);
      try
      {
        Enumeration localEnumeration = localZipFile.entries();
        while (localEnumeration.hasMoreElements())
        {
          Object localObject5 = (ZipEntry)localEnumeration.nextElement();
          Object localObject1 = URLEncoder.encode(((ZipEntry)localObject5).getName(), "UTF-8");
          if ((!((String)localObject1).contains("../")) && (!((String)localObject1).contains("..\\")) && (!((ZipEntry)localObject5).isDirectory()))
          {
            localObject5 = localZipFile.getInputStream((ZipEntry)localObject5);
            if (paramd.aiqx) {}
            for (localObject1 = new File(ez(paramd.version, (String)localObject1)); !com.tencent.xweb.util.g.b((InputStream)localObject5, (File)localObject1); localObject1 = new File(ey(paramd.version, (String)localObject1)))
            {
              Log.e(kjs(), "unZipAndCheck error, return");
              com.tencent.xweb.util.g.d(localZipFile);
              if (localFile.exists()) {
                localFile.delete();
              }
              return false;
            }
          }
        }
        try
        {
          Log.e(kjs(), "unZipAndCheck error: ".concat(String.valueOf(localObject2)));
          return false;
        }
        finally
        {
          boolean bool;
          com.tencent.xweb.util.g.d(paramd);
          if (!localFile.exists()) {
            break label413;
          }
          localFile.delete();
        }
      }
      finally
      {
        paramd = localZipFile;
      }
    }
    finally
    {
      for (;;)
      {
        ZipFile localZipFile;
        paramd = null;
      }
    }
    if (!paramd.aiqH)
    {
      bool = paramd.aiqx;
      if (!bool) {}
    }
    else
    {
      com.tencent.xweb.util.g.d(localZipFile);
      if (localFile.exists()) {
        localFile.delete();
      }
      return true;
    }
    if (!dh(paramd.version, false))
    {
      Log.e(kjs(), "unZipAndCheck md5 check failed");
      com.tencent.xweb.util.g.d(localZipFile);
      if (localFile.exists()) {
        localFile.delete();
      }
      return false;
    }
    com.tencent.xweb.util.g.d(localZipFile);
    if (localFile.exists()) {
      localFile.delete();
    }
    return true;
  }
  
  protected final boolean c(d paramd)
  {
    int i = this.aipK;
    Log.i(kjs(), "doPatch current version = " + i + ", new version = " + paramd.version);
    if (i < 0)
    {
      Log.e(kjs(), "doPatch, current version invalid");
      return false;
    }
    if (!paramd.aiqx)
    {
      Log.e(kjs(), "doPatch, current download config is not patch");
      return false;
    }
    Object localObject = new File(ez(paramd.version, "patch.config"));
    if (!((File)localObject).exists())
    {
      Log.e(kjs(), "doPatch, can not find patch config file");
      return false;
    }
    localObject = j.ak((File)localObject);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      Log.e(kjs(), "doPatch, patchConfigList = null");
      return false;
    }
    if (!com.tencent.xweb.util.g.ra(aJO(i), aJO(paramd.version)))
    {
      Log.e(kjs(), "doPatch, copy files failed");
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j.a locala = (j.a)((Iterator)localObject).next();
      if (locala.type == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (!com.tencent.xweb.util.g.copyFile(ez(paramd.version, locala.aipT), ey(paramd.version, locala.aipT)))
          {
            Log.e(kjs(), "doPatch, add file error: ".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(kjs(), "doPatch, add file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      if (locala.type == 3) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (!com.tencent.xweb.util.g.deleteFile(ey(paramd.version, locala.aipT)))
          {
            Log.e(kjs(), "doPatch, delete file error:".concat(String.valueOf(locala)));
            break;
            i = 0;
            continue;
          }
          Log.i(kjs(), "doPatch, delete file:".concat(String.valueOf(locala)));
          break;
        }
      }
      if (locala.type == 2) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (BSpatch.bQ(ey(paramd.version, locala.aipT), ez(paramd.version, locala.aipS), ey(paramd.version, locala.aipT)) < 0)
          {
            Log.e(kjs(), "doPatch, patch file error:".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(kjs(), "doPatch, patch file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      Log.e(kjs(), "doPatch, unknown op".concat(String.valueOf(locala)));
      return false;
    }
    com.tencent.xweb.util.g.deleteFile(ey(paramd.version, "filelist.config"));
    if (!com.tencent.xweb.util.g.copyFile(ez(paramd.version, "filelist.config"), ey(paramd.version, "filelist.config")))
    {
      Log.e(kjs(), "doPatch, copy filelist.config error");
      return false;
    }
    if (!dh(paramd.version, false))
    {
      Log.e(kjs(), "doPatch, check md5 failed");
      return false;
    }
    paramd = aJP(paramd.version);
    if (!paramd.isEmpty()) {
      com.tencent.xweb.util.g.bHZ(paramd);
    }
    return true;
  }
  
  public abstract String dg(int paramInt, boolean paramBoolean);
  
  public final boolean dh(int paramInt, boolean paramBoolean)
  {
    Log.i(kjs(), "checkFileListConfig, version = ".concat(String.valueOf(paramInt)));
    if (paramInt < 0)
    {
      Log.i(kjs(), "checkFileListConfig, version invalid");
      return false;
    }
    Object localObject1 = new File(ey(paramInt, "filelist.config"));
    if (!((File)localObject1).exists())
    {
      if (paramBoolean)
      {
        Log.i(kjs(), "checkFileListConfig, no filelist.config, skip");
        return true;
      }
      Log.e(kjs(), "checkFileListConfig, no filelist.config, return");
      return false;
    }
    try
    {
      localObject1 = new BufferedReader(new FileReader((File)localObject1));
    }
    finally
    {
      try
      {
        String str;
        Object localObject5;
        do
        {
          do
          {
            do
            {
              str = ((BufferedReader)localObject1).readLine();
              if (str == null) {
                break;
              }
            } while (str.isEmpty());
            localObject5 = str.split(":");
          } while ((localObject5.length != 2) || (localObject5[0] == null) || (localObject5[0].isEmpty()) || (localObject5[1] == null) || (localObject5[1].isEmpty()));
          str = localObject5[0];
          localObject5 = localObject5[1];
        } while (h.rb(ey(paramInt, str), (String)localObject5));
        Log.e(kjs(), "checkFileListConfig, md5 not match: ".concat(String.valueOf(str)));
        com.tencent.xweb.util.g.d((Closeable)localObject1);
        return false;
        Log.i(kjs(), "checkFileListConfig success");
        com.tencent.xweb.util.g.d((Closeable)localObject1);
        return true;
      }
      finally
      {
        break label241;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    try
    {
      label241:
      Log.e(kjs(), "checkFileListConfig error: ".concat(String.valueOf(localObject2)));
      return false;
    }
    finally
    {
      com.tencent.xweb.util.g.d((Closeable)localObject1);
    }
  }
  
  public final String ey(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(kjs(), "getExtractFile, fileName is empty");
      return "";
    }
    String str = aJO(paramInt);
    if (str.isEmpty())
    {
      Log.e(kjs(), "getExtractFile, extractDir is empty");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public final String getVersionDir(int paramInt)
  {
    Object localObject;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(kjs(), "getVersionDir, context is null");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      localObject = XWalkFileUtil.getPluginBaseDir();
      if (((String)localObject).isEmpty())
      {
        Log.e(kjs(), "getVersionDir, pluginBaseDir is null");
        return "";
      }
      str = (String)localObject + File.separator + kjs() + "_" + paramInt;
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final boolean kjA()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(kjs(), "clearPatchDownloadInfo, context is null");
      return false;
    }
    Object localObject1 = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
    if (localObject1 == null)
    {
      Log.e(kjs(), "clearPatchDownloadInfo, sp is null");
      return false;
    }
    Object localObject2 = ((SharedPreferences)localObject1).getAll();
    if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
      return true;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = ((Map)localObject2).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((str != null) && (str.startsWith("patchDownloadCount_")))
      {
        Log.i(kjs(), "clearPatchDownloadInfo, remove key ".concat(String.valueOf(str)));
        ((SharedPreferences.Editor)localObject1).remove(str);
      }
    }
    return ((SharedPreferences.Editor)localObject1).commit();
  }
  
  public abstract String kjs();
  
  public abstract boolean kjt();
  
  public abstract boolean kjw();
  
  public abstract void kjx();
  
  public final int kjy()
  {
    kjz();
    return this.aipK;
  }
  
  public final void qi(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      Log.e(kjs(), "reportUsingVersion, reportVersion invalid");
    }
    for (;;)
    {
      return;
      Object localObject2 = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(kjs());
      if (localObject2 == null)
      {
        Log.e(kjs(), "reportUsingVersion, sp is null");
        return;
      }
      int i = ((SharedPreferences)localObject2).getInt("lastReportVersion", -1);
      String str2 = ((SharedPreferences)localObject2).getString("lastReportDate", "");
      try
      {
        String str1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if ((i != paramInt1) || (!str2.equals(str1)))
        {
          i = paramInt1 % 50 + 100;
          Log.d(kjs(), "reportUsingVersion, id:" + paramInt2 + ", key:" + i);
          l.y(paramInt2, i, 1L);
          localObject2 = ((SharedPreferences)localObject2).edit();
          if (localObject2 != null)
          {
            ((SharedPreferences.Editor)localObject2).putInt("lastReportVersion", paramInt1);
            ((SharedPreferences.Editor)localObject2).putString("lastReportDate", str1);
            ((SharedPreferences.Editor)localObject2).commit();
            return;
          }
        }
      }
      finally
      {
        Log.e(kjs(), "reportUsingVersion, get cur date error: ".concat(String.valueOf(localObject1)));
        return;
      }
    }
    Log.e(kjs(), "reportUsingVersion, editor is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.g
 * JD-Core Version:    0.7.0.1
 */