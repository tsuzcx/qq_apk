package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<s> PQt;
  private static HashMap<String, s> PQu;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(78357);
    lock = new Object();
    PQt = new LinkedList();
    PQu = new HashMap();
    AppMethodBeat.o(78357);
  }
  
  public static void b(s params)
  {
    AppMethodBeat.i(78355);
    synchronized (lock)
    {
      if (!PQt.contains(params))
      {
        PQt.add(params);
        PQu.put(d(params), params);
      }
      AppMethodBeat.o(78355);
      return;
    }
  }
  
  public static s bkn(String paramString)
  {
    AppMethodBeat.i(224979);
    paramString = (s)PQu.get(paramString);
    AppMethodBeat.o(224979);
    return paramString;
  }
  
  public static void c(s params)
  {
    AppMethodBeat.i(78356);
    synchronized (lock)
    {
      PQt.remove(params);
      PQu.remove(d(params));
      AppMethodBeat.o(78356);
      return;
    }
  }
  
  public static String d(s params)
  {
    AppMethodBeat.i(224982);
    params = "luggage_page_" + params.hashCode();
    AppMethodBeat.o(224982);
    return params;
  }
  
  public static LinkedList<s> gUQ()
  {
    AppMethodBeat.i(224981);
    synchronized (lock)
    {
      LinkedList localLinkedList = new LinkedList(PQt);
      AppMethodBeat.o(224981);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */