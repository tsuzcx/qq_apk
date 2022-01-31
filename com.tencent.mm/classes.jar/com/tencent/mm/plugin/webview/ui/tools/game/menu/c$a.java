package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public enum c$a
{
  private static EnumMap<a, Integer> rwT;
  int code;
  
  static
  {
    rwT = new EnumMap(a.class);
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      rwT.put(locala, Integer.valueOf(locala.code));
    }
  }
  
  private c$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static boolean CT(int paramInt)
  {
    return rwT.containsValue(Integer.valueOf(paramInt));
  }
  
  public static a CU(int paramInt)
  {
    Iterator localIterator = rwT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (a)localEntry.getKey();
      }
    }
    return rwK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a
 * JD-Core Version:    0.7.0.1
 */