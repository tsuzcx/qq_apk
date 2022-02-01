package com.tencent.tencentmap.mapsdk.maps.interfaces;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import java.util.List;

public abstract interface Boundable<T extends Projection>
{
  public abstract Rect getBound(T paramT);
  
  public abstract List<Boundable<T>> getGroupBounds();
  
  public abstract Rect getScreenBound(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
 * JD-Core Version:    0.7.0.1
 */