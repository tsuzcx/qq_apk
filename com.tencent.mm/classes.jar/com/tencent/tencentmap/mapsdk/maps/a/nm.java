package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class nm
{
  private final String a;
  private int b;
  private int c;
  private List<nj> d;
  
  public nm(int paramInt1, int paramInt2, List<nj> paramList)
  {
    AppMethodBeat.i(149504);
    this.a = "_night";
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramList;
    Collections.sort(paramList, new nm.1(this));
    AppMethodBeat.o(149504);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String[] a(a parama, int paramInt)
  {
    AppMethodBeat.i(149505);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (nj)localIterator.next();
      if (((nj)localObject).a(parama))
      {
        if (((paramInt == 13) || (paramInt == 10)) && (((nj)localObject).d() != null) && (((nj)localObject).d().length() > 0))
        {
          parama = ((nj)localObject).b() + "_night";
          localObject = ((nj)localObject).d();
          AppMethodBeat.o(149505);
          return new String[] { parama, localObject };
        }
        parama = ((nj)localObject).b();
        localObject = ((nj)localObject).c();
        AppMethodBeat.o(149505);
        return new String[] { parama, localObject };
      }
    }
    AppMethodBeat.o(149505);
    return null;
  }
  
  public int b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nm
 * JD-Core Version:    0.7.0.1
 */