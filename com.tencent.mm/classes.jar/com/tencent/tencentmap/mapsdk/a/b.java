package com.tencent.tencentmap.mapsdk.a;

public abstract class b
{
  public static boolean a = true;
  private static b b;
  
  public static b a()
  {
    try
    {
      if (b == null) {
        b = new b.a();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.b
 * JD-Core Version:    0.7.0.1
 */