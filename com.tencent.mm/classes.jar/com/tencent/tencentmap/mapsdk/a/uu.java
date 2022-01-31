package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;

public final class uu
{
  public static ut a()
  {
    return new ut(new td());
  }
  
  public static ut a(float paramFloat)
  {
    tf localtf = new tf();
    localtf.a(paramFloat);
    return new ut(localtf);
  }
  
  public static ut a(float paramFloat1, float paramFloat2)
  {
    tb localtb = new tb();
    localtb.a(paramFloat1);
    localtb.b(paramFloat2);
    return new ut(localtb);
  }
  
  public static ut a(float paramFloat, Point paramPoint)
  {
    return new ut(sx.a(paramFloat, paramPoint));
  }
  
  public static ut a(ru paramru)
  {
    return new ut(sx.a(paramru));
  }
  
  public static ut a(ry paramry)
  {
    return new ut(sx.a(ru.a().a(paramry).a()));
  }
  
  public static ut a(ry paramry, float paramFloat)
  {
    return new ut(sx.a(ru.a().a(paramry).a(paramFloat).a()));
  }
  
  public static ut a(rz paramrz, int paramInt)
  {
    return new ut(sx.a(paramrz, 0, 0, paramInt));
  }
  
  public static ut a(rz paramrz, int paramInt1, int paramInt2, int paramInt3)
  {
    return new ut(sx.a(paramrz, paramInt1, paramInt2, paramInt3));
  }
  
  public static ut b()
  {
    return new ut(new te());
  }
  
  public static ut b(float paramFloat)
  {
    return new ut(sx.a(paramFloat, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uu
 * JD-Core Version:    0.7.0.1
 */