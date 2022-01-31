package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public abstract class hv
  implements Cloneable
{
  ArrayList<Object> a = null;
  
  public hv a()
  {
    try
    {
      hv localhv = (hv)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localhv.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localhv.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hv
 * JD-Core Version:    0.7.0.1
 */