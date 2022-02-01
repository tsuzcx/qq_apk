package com.tencent.wxa;

import io.flutter.plugin.common.MethodCall;

public abstract class b
{
  public static a hl(Object paramObject)
  {
    return new a(true, paramObject);
  }
  
  public static a keP()
  {
    return new a(false, null);
  }
  
  public abstract a a(MethodCall paramMethodCall);
  
  public static final class a
  {
    Object aidk;
    boolean result;
    
    public a(boolean paramBoolean, Object paramObject)
    {
      this.result = paramBoolean;
      this.aidk = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.b
 * JD-Core Version:    0.7.0.1
 */