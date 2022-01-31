package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;

public abstract class kz
  implements Comparable<kz>
{
  public int a(kz paramkz)
  {
    Rect localRect = a();
    paramkz = paramkz.a();
    if (localRect.top != paramkz.top) {
      return localRect.top - paramkz.top;
    }
    return localRect.left - paramkz.left;
  }
  
  public abstract Rect a();
  
  public abstract String b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kz
 * JD-Core Version:    0.7.0.1
 */