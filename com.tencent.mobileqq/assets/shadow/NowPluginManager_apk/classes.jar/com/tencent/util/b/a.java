package com.tencent.util.b;

import android.graphics.Bitmap;

public class a
{
  public static Bitmap a(String paramString)
  {
    return b.a().a(paramString);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(String paramString);
  }
  
  public static class b
  {
    private static b a = new b();
    private a.a b;
    
    public static b a()
    {
      return a;
    }
    
    public Bitmap a(String paramString)
    {
      if (this.b != null) {
        return this.b.a(paramString);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.b.a
 * JD-Core Version:    0.7.0.1
 */