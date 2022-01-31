package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.IOException;

public abstract class eb<T>
{
  public final dq a(T paramT)
  {
    try
    {
      ew localew = new ew();
      a(localew, paramT);
      paramT = localew.a();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new dr(paramT);
    }
  }
  
  public abstract void a(fh paramfh, T paramT);
  
  public abstract T b(ff paramff);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.eb
 * JD-Core Version:    0.7.0.1
 */