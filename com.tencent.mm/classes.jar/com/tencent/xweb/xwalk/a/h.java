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

public final class h
{
  private static Map<String, g> aajN;
  
  static
  {
    AppMethodBeat.i(157195);
    aajN = new HashMap();
    AppMethodBeat.o(157195);
  }
  
  private static a ag(File paramFile)
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
  
  public static g bEW(String paramString)
  {
    AppMethodBeat.i(157189);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(157189);
      return null;
    }
    paramString = (g)aajN.get(paramString);
    AppMethodBeat.o(157189);
    return paramString;
  }
  
  public static void izc()
  {
    AppMethodBeat.i(157192);
    if (aajN.size() == 0)
    {
      Log.e("XWalkPluginMgr", "checkFiles error, sPluginMap size is 0");
      AppMethodBeat.o(157192);
      return;
    }
    Iterator localIterator = aajN.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).izc();
    }
    AppMethodBeat.o(157192);
  }
  
  public static boolean izg()
  {
    AppMethodBeat.i(157187);
    if (aajN.size() == 0)
    {
      Log.i("XWalkPluginMgr", "initPlugins");
      Object localObject = new c();
      aajN.put("FullScreenVideo", localObject);
      localObject = new e();
      aajN.put("XFilesPDFReader", localObject);
      localObject = new f();
      aajN.put("XFilesPPTReader", localObject);
      localObject = new n();
      aajN.put("XFilesWordReader", localObject);
      localObject = new b();
      aajN.put("XFilesExcelReader", localObject);
      localObject = new d();
      aajN.put(((m)localObject).getPluginName(), localObject);
    }
    AppMethodBeat.o(157187);
    return true;
  }
  
  public static List<g> izh()
  {
    AppMethodBeat.i(157190);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = aajN.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(157190);
    return localArrayList;
  }
  
  public static String izi()
  {
    AppMethodBeat.i(157191);
    Object localObject = new StringBuilder();
    Iterator localIterator = aajN.entrySet().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)((Map.Entry)localIterator.next()).getValue();
      if (localg != null) {
        ((StringBuilder)localObject).append(localg.getPluginName()).append(" = ").append(localg.aajM).append(", ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(157191);
    return localObject;
  }
  
  public static void izj()
  {
    AppMethodBeat.i(157194);
    if (aajN.size() == 0)
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
    int k = localObject.length;
    int i = 0;
    File localFile;
    a locala;
    label164:
    label225:
    int j;
    if (i < k)
    {
      localFile = localObject[i];
      if (localFile != null)
      {
        locala = ag(localFile);
        if (locala != null) {
          break label164;
        }
        Log.e("XWalkPluginMgr", "clearOldVersions can not get plugin info, delete " + localFile.getAbsolutePath());
        com.tencent.xweb.util.c.bFA(localFile.getAbsolutePath());
      }
      g localg;
      for (;;)
      {
        i += 1;
        break;
        localg = (g)aajN.get(locala.GRF);
        if (localg != null) {
          break label225;
        }
        Log.e("XWalkPluginMgr", "clearOldVersions invalid plugin info, delete " + localFile.getAbsolutePath());
        com.tencent.xweb.util.c.bFA(localFile.getAbsolutePath());
      }
      j = localg.aajM;
      if (j >= 0) {
        break label327;
      }
      j = localg.izd();
    }
    label327:
    for (;;)
    {
      if (j < 0)
      {
        Log.e("XWalkPluginMgr", "clearOldVersions can not get availableVersion, skip " + localFile.getAbsolutePath());
        break;
      }
      if (locala.aajO >= j) {
        break;
      }
      Log.i("XWalkPluginMgr", "clearOldVersions is old version, delete " + localFile.getAbsolutePath());
      com.tencent.xweb.util.c.bFA(localFile.getAbsolutePath());
      break;
      AppMethodBeat.o(157194);
      return;
    }
  }
  
  public static Map<String, Integer> mF(Context paramContext)
  {
    AppMethodBeat.i(157188);
    HashMap localHashMap = new HashMap();
    localHashMap.put("FullScreenVideo", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "FullScreenVideo")));
    localHashMap.put("XFilesPDFReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesPDFReader")));
    localHashMap.put("XFilesPPTReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesPPTReader")));
    localHashMap.put("XFilesWordReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesWordReader")));
    localHashMap.put("XFilesExcelReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesExcelReader")));
    localHashMap.put("XFilesOfficeReader", Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(paramContext, "XFilesOfficeReader")));
    AppMethodBeat.o(157188);
    return localHashMap;
  }
  
  static final class a
  {
    String GRF;
    int aajO;
    
    a(String paramString, int paramInt)
    {
      this.GRF = paramString;
      this.aajO = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.h
 * JD-Core Version:    0.7.0.1
 */