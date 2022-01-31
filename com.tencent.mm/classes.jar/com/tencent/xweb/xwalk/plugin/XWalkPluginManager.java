package com.tencent.xweb.xwalk.plugin;

import android.support.annotation.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;

public class XWalkPluginManager
{
  private static Map<String, b> xms = new HashMap();
  
  public static b ahg(String paramString)
  {
    if (paramString.isEmpty()) {
      return null;
    }
    return (b)xms.get(paramString);
  }
  
  public static List<b> cTF()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = xms.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public static String cTG()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = xms.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if (localb != null) {
        localStringBuilder.append(localb.cTE()).append(" = ").append(localb.xmr).append(", ");
      }
    }
    return localStringBuilder.toString();
  }
  
  @Keep
  public static boolean initPlugins()
  {
    if (xms.size() == 0)
    {
      Log.i("XWalkPluginMgr", "initPlugins");
      a locala = new a();
      xms.put("FullScreenVideo", locala);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.XWalkPluginManager
 * JD-Core Version:    0.7.0.1
 */