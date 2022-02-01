package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<s> IUb;
  private static HashMap<String, s> IUc;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    IUb = new LinkedList();
    IUc = new HashMap();
    AppMethodBeat.o(78357);
  }
  
  public static s aYs(String paramString)
  {
    AppMethodBeat.i(210917);
    paramString = (s)IUc.get(paramString);
    AppMethodBeat.o(210917);
    return paramString;
  }
  
  public static void b(s params)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      if (!IUb.contains(params))
      {
        IUb.add(params);
        IUc.put(d(params), params);
      }
      AppMethodBeat.o(78355);
      return;
    }
  }
  
  public static void c(s params)
  {
    AppMethodBeat.i(78356);
    synchronized (lock)
    {
      IUb.remove(params);
      IUc.remove(d(params));
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static String d(s params)
  {
    AppMethodBeat.i(210919);
    params = "luggage_page_" + params.hashCode();
    AppMethodBeat.o(210919);
    return params;
  }
  
  public static LinkedList<s> gbV()
  {
    AppMethodBeat.i(210918);
    synchronized (lock)
    {
      LinkedList localLinkedList = new LinkedList(IUb);
      AppMethodBeat.o(210918);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */