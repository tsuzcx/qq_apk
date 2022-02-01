package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class k
{
  private static LinkedList<s> WGP;
  private static HashMap<String, s> WGQ;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    WGP = new LinkedList();
    WGQ = new HashMap();
    AppMethodBeat.o(78357);
  }
  
  public static void b(s params)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      if (!WGP.contains(params))
      {
        WGP.add(params);
        WGQ.put(d(params), params);
      }
      AppMethodBeat.o(78355);
      return;
    }
  }
  
  public static s bjX(String paramString)
  {
    AppMethodBeat.i(295950);
    paramString = (s)WGQ.get(paramString);
    AppMethodBeat.o(295950);
    return paramString;
  }
  
  public static void c(s params)
  {
    AppMethodBeat.i(78356);
    synchronized (lock)
    {
      WGP.remove(params);
      WGQ.remove(d(params));
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static String d(s params)
  {
    AppMethodBeat.i(295957);
    params = "luggage_page_" + params.hashCode();
    AppMethodBeat.o(295957);
    return params;
  }
  
  public static LinkedList<s> iuB()
  {
    AppMethodBeat.i(295954);
    synchronized (lock)
    {
      LinkedList localLinkedList = new LinkedList(WGP);
      AppMethodBeat.o(295954);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */