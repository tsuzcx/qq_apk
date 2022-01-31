package com.tencent.tencentmap.mapsdk.a;

import java.util.Map;
import java.util.WeakHashMap;

public final class uk
{
  private static Map<ue.a, sj> a = new WeakHashMap();
  
  public static sj a(tn paramtn, ue.a parama)
  {
    if (paramtn.f().a() > 1) {}
    for (int i = 2;; i = 1)
    {
      paramtn = (sj)a.get(parama);
      if (paramtn == null) {
        break;
      }
      return paramtn;
    }
    switch (uk.1.a[parama.ordinal()])
    {
    default: 
      return null;
    case 1: 
      paramtn = new um(i);
    }
    for (;;)
    {
      a.put(parama, paramtn);
      return paramtn;
      paramtn = new uo(i);
      continue;
      paramtn = new ul(i);
      continue;
      paramtn = new un(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uk
 * JD-Core Version:    0.7.0.1
 */