package com.tencent.tencentmap.mapsdk.maps.a;

import java.util.ArrayList;

public abstract class gw
  implements Cloneable
{
  ArrayList<Object> a = null;
  
  public gw a()
  {
    try
    {
      gw localgw = (gw)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localgw.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localgw.a.add(localArrayList.get(i));
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
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gw
 * JD-Core Version:    0.7.0.1
 */