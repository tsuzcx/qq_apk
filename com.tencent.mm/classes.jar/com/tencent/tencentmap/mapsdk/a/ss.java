package com.tencent.tencentmap.mapsdk.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ss
{
  private int a;
  private int b;
  private List<sr> c;
  
  public ss(int paramInt1, int paramInt2, List<sr> paramList)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramList;
    Collections.sort(paramList, new ss.1(this));
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final String[] a(st paramst)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      sr localsr = (sr)localIterator.next();
      if (localsr.a(paramst)) {
        return new String[] { localsr.b(), localsr.c() };
      }
    }
    return null;
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ss
 * JD-Core Version:    0.7.0.1
 */