package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class na
{
  private final String a = "_night";
  private int b;
  private int c;
  private List<mx> d;
  
  public na(int paramInt1, int paramInt2, List<mx> paramList)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramList;
    Collections.sort(paramList, new Comparator()
    {
      public int a(mx paramAnonymousmx1, mx paramAnonymousmx2)
      {
        return paramAnonymousmx2.a() - paramAnonymousmx1.a();
      }
    });
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String[] a(a parama, int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      mx localmx = (mx)localIterator.next();
      if (localmx.a(parama))
      {
        if (((paramInt == 13) || (paramInt == 10)) && (localmx.d() != null) && (localmx.d().length() > 0)) {
          return new String[] { localmx.b() + "_night", localmx.d() };
        }
        return new String[] { localmx.b(), localmx.c() };
      }
    }
    return null;
  }
  
  public int b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.na
 * JD-Core Version:    0.7.0.1
 */