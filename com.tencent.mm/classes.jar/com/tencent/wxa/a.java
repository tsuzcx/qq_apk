package com.tencent.wxa;

import io.flutter.plugin.a.j;

public abstract class a
{
  public static a eI(Object paramObject)
  {
    return new a(true, paramObject);
  }
  
  public static a hrG()
  {
    return new a(false, null);
  }
  
  public abstract a a(j paramj);
  
  public static final class a
  {
    Object SxC;
    boolean result;
    
    public a(boolean paramBoolean, Object paramObject)
    {
      this.result = paramBoolean;
      this.SxC = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.a
 * JD-Core Version:    0.7.0.1
 */