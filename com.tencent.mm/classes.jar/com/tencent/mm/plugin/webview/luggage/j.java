package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<s> DPp;
  private static HashMap<String, s> DPq;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    DPp = new LinkedList();
    DPq = new HashMap();
    AppMethodBeat.o(78357);
  }
  
  public static s aGW(String paramString)
  {
    AppMethodBeat.i(207882);
    paramString = (s)DPq.get(paramString);
    AppMethodBeat.o(207882);
    return paramString;
  }
  
  public static void b(s params)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      if (!DPp.contains(params))
      {
        DPp.add(params);
        DPq.put(d(params), params);
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
      DPp.remove(params);
      DPq.remove(d(params));
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static String d(s params)
  {
    AppMethodBeat.i(207884);
    params = "luggage_page_" + params.hashCode();
    AppMethodBeat.o(207884);
    return params;
  }
  
  public static LinkedList<s> ePw()
  {
    AppMethodBeat.i(207883);
    synchronized (lock)
    {
      LinkedList localLinkedList = new LinkedList(DPp);
      AppMethodBeat.o(207883);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */