package com.tencent.xweb.xwalk.a;

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

public final class e
{
  private static Map<String, c> BKq;
  
  static
  {
    AppMethodBeat.i(4182);
    BKq = new HashMap();
    AppMethodBeat.o(4182);
  }
  
  private static e.a aw(File paramFile)
  {
    AppMethodBeat.i(151460);
    if (paramFile == null)
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is null");
      AppMethodBeat.o(151460);
      return null;
    }
    if ((!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is invalid");
      AppMethodBeat.o(151460);
      return null;
    }
    String str = paramFile.getName();
    int i = str.lastIndexOf('_');
    if ((i < 0) || (i >= str.length() - 1))
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir can not find _");
      AppMethodBeat.o(151460);
      return null;
    }
    paramFile = str.substring(0, i);
    str = str.substring(i + 1);
    try
    {
      paramFile = new e.a(paramFile, Integer.parseInt(str));
      AppMethodBeat.o(151460);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir error: " + paramFile.getMessage());
      AppMethodBeat.o(151460);
    }
    return null;
  }
  
  public static c ayq(String paramString)
  {
    AppMethodBeat.i(4179);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(4179);
      return null;
    }
    paramString = (c)BKq.get(paramString);
    AppMethodBeat.o(4179);
    return paramString;
  }
  
  public static void eam()
  {
    AppMethodBeat.i(151459);
    if (BKq.size() == 0)
    {
      Log.e("XWalkPluginMgr", "checkFiles error, sPluginMap size is 0");
      AppMethodBeat.o(151459);
      return;
    }
    Iterator localIterator = BKq.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((c)((Map.Entry)localIterator.next()).getValue()).eam();
    }
    AppMethodBeat.o(151459);
  }
  
  public static boolean eao()
  {
    AppMethodBeat.i(4178);
    if (BKq.size() == 0)
    {
      Log.i("XWalkPluginMgr", "initPlugins");
      Object localObject = new a();
      BKq.put("FullScreenVideo", localObject);
      localObject = new b();
      BKq.put("XFilesPPTReader", localObject);
    }
    AppMethodBeat.o(4178);
    return true;
  }
  
  public static List<c> eap()
  {
    AppMethodBeat.i(4180);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = BKq.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(4180);
    return localArrayList;
  }
  
  public static String eaq()
  {
    AppMethodBeat.i(4181);
    Object localObject = new StringBuilder();
    Iterator localIterator = BKq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if (localc != null) {
        ((StringBuilder)localObject).append(localc.eak()).append(" = ").append(localc.BKm).append(", ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(4181);
    return localObject;
  }
  
  public static void ear()
  {
    AppMethodBeat.i(151461);
    if (BKq.size() == 0)
    {
      Log.e("XWalkPluginMgr", "clearOldVersions error, sPluginMap size is 0");
      AppMethodBeat.o(151461);
      return;
    }
    Object localObject = XWalkEnvironment.getPluginBaseDir();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e("XWalkPluginMgr", "clearOldVersions clear other, pluginBaseDir is null, return");
      AppMethodBeat.o(151461);
      return;
    }
    localObject = new File((String)localObject).listFiles();
    if ((localObject == null) || (localObject.length <= 0))
    {
      Log.i("XWalkPluginMgr", "clearOldVersions, dir is empty, return");
      AppMethodBeat.o(151461);
      return;
    }
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      File localFile = localObject[i];
      e.a locala;
      if (localFile != null)
      {
        Log.i("XWalkPluginMgr", "clearOldVersions process " + localFile.getAbsolutePath());
        locala = aw(localFile);
        if (locala != null) {
          break label166;
        }
        Log.e("XWalkPluginMgr", "clearOldVersions can not get plugin info, delete");
        com.tencent.xweb.util.b.ayf(localFile.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        label166:
        c localc = (c)BKq.get(locala.qGd);
        if (localc == null)
        {
          Log.e("XWalkPluginMgr", "clearOldVersions invalid plugin info, delete");
          com.tencent.xweb.util.b.ayf(localFile.getAbsolutePath());
        }
        else
        {
          if (localc.BKm < 0) {
            localc.ean();
          }
          if (localc.BKm < 0)
          {
            Log.e("XWalkPluginMgr", "clearOldVersions can not get availableVersion, skip");
          }
          else if (locala.BKr < localc.BKm)
          {
            Log.i("XWalkPluginMgr", "clearOldVersions is old version, delete");
            com.tencent.xweb.util.b.ayf(localFile.getAbsolutePath());
          }
        }
      }
    }
    AppMethodBeat.o(151461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.e
 * JD-Core Version:    0.7.0.1
 */