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
import org.xwalk.core.XWalkFileUtil;

public final class i
{
  private static Map<String, g> aipQ;
  
  static
  {
    AppMethodBeat.i(157195);
    aipQ = new HashMap();
    AppMethodBeat.o(157195);
  }
  
  public static a aj(File paramFile)
  {
    AppMethodBeat.i(157193);
    if (paramFile == null)
    {
      Log.e("XWalkPluginManager", "getPluginInfoFromDir, dirFile is null");
      AppMethodBeat.o(157193);
      return null;
    }
    if ((!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      Log.e("XWalkPluginManager", "getPluginInfoFromDir, dirFile is invalid");
      AppMethodBeat.o(157193);
      return null;
    }
    String str = paramFile.getName();
    int i = str.lastIndexOf('_');
    if ((i < 0) || (i >= str.length() - 1))
    {
      Log.e("XWalkPluginManager", "getPluginInfoFromDir, can not find _");
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
    finally
    {
      Log.e("XWalkPluginManager", "getPluginInfoFromDir, error: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(157193);
    }
    return null;
  }
  
  public static g bHs(String paramString)
  {
    AppMethodBeat.i(157189);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(157189);
      return null;
    }
    paramString = (g)aipQ.get(paramString);
    AppMethodBeat.o(157189);
    return paramString;
  }
  
  public static boolean kjB()
  {
    AppMethodBeat.i(157187);
    if (aipQ.size() == 0)
    {
      Log.i("XWalkPluginManager", "initPlugins");
      Object localObject = new c();
      aipQ.put("FullScreenVideo", localObject);
      localObject = new e();
      aipQ.put("XFilesPDFReader", localObject);
      localObject = new f();
      aipQ.put("XFilesPPTReader", localObject);
      localObject = new o();
      aipQ.put("XFilesWordReader", localObject);
      localObject = new b();
      aipQ.put("XFilesExcelReader", localObject);
      localObject = new d();
      aipQ.put(((n)localObject).kjs(), localObject);
    }
    AppMethodBeat.o(157187);
    return true;
  }
  
  public static List<g> kjC()
  {
    AppMethodBeat.i(157190);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = aipQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((g)((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(157190);
    return localArrayList;
  }
  
  public static String kjD()
  {
    AppMethodBeat.i(157191);
    Object localObject = new StringBuilder();
    Iterator localIterator = aipQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)((Map.Entry)localIterator.next()).getValue();
      if (localg != null) {
        ((StringBuilder)localObject).append(localg.kjs()).append(" = ").append(localg.aipK).append(", ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(157191);
    return localObject;
  }
  
  public static void kjE()
  {
    AppMethodBeat.i(157194);
    if (aipQ.size() == 0)
    {
      Log.e("XWalkPluginManager", "clearOldVersions error, sPluginMap size is 0");
      AppMethodBeat.o(157194);
      return;
    }
    Object localObject = XWalkFileUtil.getPluginBaseDir();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e("XWalkPluginManager", "clearOldVersions clear other, pluginBaseDir is null, return");
      AppMethodBeat.o(157194);
      return;
    }
    localObject = new File((String)localObject).listFiles();
    if ((localObject == null) || (localObject.length <= 0))
    {
      Log.i("XWalkPluginManager", "clearOldVersions, dir is empty, return");
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
        locala = aj(localFile);
        if (locala != null) {
          break label164;
        }
        Log.e("XWalkPluginManager", "clearOldVersions can not get plugin info, delete " + localFile.getAbsolutePath());
        com.tencent.xweb.util.g.bHZ(localFile.getAbsolutePath());
      }
      g localg;
      for (;;)
      {
        i += 1;
        break;
        localg = (g)aipQ.get(locala.MPj);
        if (localg != null) {
          break label225;
        }
        Log.e("XWalkPluginManager", "clearOldVersions invalid plugin info, delete " + localFile.getAbsolutePath());
        com.tencent.xweb.util.g.bHZ(localFile.getAbsolutePath());
      }
      j = localg.aipK;
      if (j >= 0) {
        break label327;
      }
      j = localg.kjy();
    }
    label327:
    for (;;)
    {
      if (j < 0)
      {
        Log.e("XWalkPluginManager", "clearOldVersions can not get availableVersion, skip " + localFile.getAbsolutePath());
        break;
      }
      if (locala.aipR >= j) {
        break;
      }
      Log.i("XWalkPluginManager", "clearOldVersions is old version, delete " + localFile.getAbsolutePath());
      com.tencent.xweb.util.g.bHZ(localFile.getAbsolutePath());
      break;
      AppMethodBeat.o(157194);
      return;
    }
  }
  
  public static void kjx()
  {
    AppMethodBeat.i(157192);
    if (aipQ.size() == 0)
    {
      Log.e("XWalkPluginManager", "checkFiles error, sPluginMap size is 0");
      AppMethodBeat.o(157192);
      return;
    }
    Iterator localIterator = aipQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).kjx();
    }
    AppMethodBeat.o(157192);
  }
  
  public static Map<String, Integer> pd(Context paramContext)
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
  
  public static final class a
  {
    public String MPj;
    public int aipR;
    
    a(String paramString, int paramInt)
    {
      this.MPj = paramString;
      this.aipR = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.i
 * JD-Core Version:    0.7.0.1
 */