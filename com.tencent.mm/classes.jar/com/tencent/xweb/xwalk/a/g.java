package com.tencent.xweb.xwalk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g
{
  private static Map<String, f> MUO;
  
  static
  {
    AppMethodBeat.i(157195);
    MUO = new HashMap();
    AppMethodBeat.o(157195);
  }
  
  private static a aj(File paramFile)
  {
    AppMethodBeat.i(157193);
    if (paramFile == null)
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is null");
      AppMethodBeat.o(157193);
      return null;
    }
    if ((!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is invalid");
      AppMethodBeat.o(157193);
      return null;
    }
    String str = paramFile.getName();
    int i = str.lastIndexOf('_');
    if ((i < 0) || (i >= str.length() - 1))
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir can not find _");
      AppMethodBeat.o(157193);
      return null;
    }
    paramFile = str.substring(0, i);
    str = str.substring(i + 1);
    try
    {
      paramFile = new a(paramFile, Integer.parseInt(str));
      AppMethodBeat.o(157193);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir error: " + paramFile.getMessage());
      AppMethodBeat.o(157193);
    }
    return null;
  }
  
  public static f bcp(String paramString)
  {
    AppMethodBeat.i(157189);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(157189);
      return null;
    }
    paramString = (f)MUO.get(paramString);
    AppMethodBeat.o(157189);
    return paramString;
  }
  
  public static void ghL()
  {
    AppMethodBeat.i(157192);
    if (MUO.size() == 0)
    {
      Log.e("XWalkPluginMgr", "checkFiles error, sPluginMap size is 0");
      AppMethodBeat.o(157192);
      return;
    }
    Iterator localIterator = MUO.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((f)((Map.Entry)localIterator.next()).getValue()).ghL();
    }
    AppMethodBeat.o(157192);
  }
  
  public static boolean ghN()
  {
    AppMethodBeat.i(157187);
    if (MUO.size() == 0)
    {
      Log.i("XWalkPluginMgr", "initPlugins");
      Object localObject = new c();
      MUO.put("FullScreenVideo", localObject);
      localObject = new d();
      MUO.put("XFilesPDFReader", localObject);
      localObject = new e();
      MUO.put("XFilesPPTReader", localObject);
      localObject = new m();
      MUO.put("XFilesWordReader", localObject);
      localObject = new b();
      MUO.put("XFilesExcelReader", localObject);
    }
    AppMethodBeat.o(157187);
    return true;
  }
  
  public static List<f> ghO()
  {
    AppMethodBeat.i(157190);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = MUO.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(157190);
    return localArrayList;
  }
  
  public static String ghP()
  {
    AppMethodBeat.i(157191);
    Object localObject = new StringBuilder();
    Iterator localIterator = MUO.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)((Map.Entry)localIterator.next()).getValue();
      if (localf != null) {
        ((StringBuilder)localObject).append(localf.getPluginName()).append(" = ").append(localf.MUN).append(", ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(157191);
    return localObject;
  }
  
  public static void ghQ()
  {
    AppMethodBeat.i(157194);
    if (MUO.size() == 0)
    {
      Log.e("XWalkPluginMgr", "clearOldVersions error, sPluginMap size is 0");
      AppMethodBeat.o(157194);
      return;
    }
    Object localObject = XWalkEnvironment.getPluginBaseDir();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e("XWalkPluginMgr", "clearOldVersions clear other, pluginBaseDir is null, return");
      AppMethodBeat.o(157194);
      return;
    }
    localObject = new File((String)localObject).listFiles();
    if ((localObject == null) || (localObject.length <= 0))
    {
      Log.i("XWalkPluginMgr", "clearOldVersions, dir is empty, return");
      AppMethodBeat.o(157194);
      return;
    }
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      File localFile = localObject[i];
      a locala;
      if (localFile != null)
      {
        locala = aj(localFile);
        if (locala != null) {
          break label159;
        }
        Log.e("XWalkPluginMgr", "clearOldVersions can not get plugin info, delete " + localFile.getAbsolutePath());
        com.tencent.xweb.util.c.bcQ(localFile.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        label159:
        f localf = (f)MUO.get(locala.yUt);
        if (localf == null)
        {
          Log.e("XWalkPluginMgr", "clearOldVersions invalid plugin info, delete " + localFile.getAbsolutePath());
          com.tencent.xweb.util.c.bcQ(localFile.getAbsolutePath());
        }
        else
        {
          if (localf.MUN < 0) {
            localf.ghM();
          }
          if (localf.MUN < 0)
          {
            Log.e("XWalkPluginMgr", "clearOldVersions can not get availableVersion, skip " + localFile.getAbsolutePath());
          }
          else if (locala.MUP < localf.MUN)
          {
            Log.i("XWalkPluginMgr", "clearOldVersions is old version, delete " + localFile.getAbsolutePath());
            com.tencent.xweb.util.c.bcQ(localFile.getAbsolutePath());
          }
        }
      }
    }
    AppMethodBeat.o(157194);
  }
  
  public static Map<String, Integer> lK(Context paramContext)
  {
    AppMethodBeat.i(157188);
    HashMap localHashMap = new HashMap();
    localHashMap.put("FullScreenVideo", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "FullScreenVideo")));
    localHashMap.put("XFilesPDFReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesPDFReader")));
    localHashMap.put("XFilesPPTReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesPPTReader")));
    localHashMap.put("XFilesWordReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesWordReader")));
    localHashMap.put("XFilesExcelReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesExcelReader")));
    AppMethodBeat.o(157188);
    return localHashMap;
  }
  
  static final class a
  {
    int MUP;
    String yUt;
    
    a(String paramString, int paramInt)
    {
      this.yUt = paramString;
      this.MUP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.g
 * JD-Core Version:    0.7.0.1
 */