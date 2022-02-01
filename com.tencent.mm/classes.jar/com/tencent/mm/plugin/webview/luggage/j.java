package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<s> Ehp;
  private static HashMap<String, s> Ehq;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    Ehp = new LinkedList();
    Ehq = new HashMap();
    AppMethodBeat.o(78357);
  }
  
  public static s aIq(String paramString)
  {
    AppMethodBeat.i(198062);
    paramString = (s)Ehq.get(paramString);
    AppMethodBeat.o(198062);
    return paramString;
  }
  
  public static void b(s params)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      if (!Ehp.contains(params))
      {
        Ehp.add(params);
        Ehq.put(d(params), params);
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
      Ehp.remove(params);
      Ehq.remove(d(params));
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static String d(s params)
  {
    AppMethodBeat.i(198064);
    params = "luggage_page_" + params.hashCode();
    AppMethodBeat.o(198064);
    return params;
  }
  
  public static LinkedList<s> eTi()
  {
    AppMethodBeat.i(198063);
    synchronized (lock)
    {
      LinkedList localLinkedList = new LinkedList(Ehp);
      AppMethodBeat.o(198063);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */