package com.tencent.util.c;

import android.os.Bundle;

public class b
{
  public static void a(a parama)
  {
    b.a(b.a(), parama);
  }
  
  public static void a(String paramString1, String paramString2, Bundle paramBundle, a parama)
  {
    b.a(b.a(), paramString1, paramString2, paramBundle, parama);
  }
  
  public static abstract interface a
  {
    public abstract void download(String paramString1, String paramString2, Bundle paramBundle, a parama);
  }
  
  private static class b
  {
    private static b a = new b();
    private b.a b;
    
    private void a(b.a parama)
    {
      this.b = parama;
    }
    
    private void a(String paramString1, String paramString2, Bundle paramBundle, a parama)
    {
      if (this.b != null) {
        this.b.download(paramString1, paramString2, paramBundle, parama);
      }
    }
    
    private static b b()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.c.b
 * JD-Core Version:    0.7.0.1
 */