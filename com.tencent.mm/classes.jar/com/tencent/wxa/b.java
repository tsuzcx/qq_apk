package com.tencent.wxa;

import io.flutter.plugin.a.j;

public abstract class b
{
  public static a eO(Object paramObject)
  {
    return new a(true, paramObject);
  }
  
  public static a ivs()
  {
    return new a(false, null);
  }
  
  public abstract a a(j paramj);
  
  public static final class a
  {
    Object ZYG;
    boolean result;
    
    public a(boolean paramBoolean, Object paramObject)
    {
      this.result = paramBoolean;
      this.ZYG = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.b
 * JD-Core Version:    0.7.0.1
 */