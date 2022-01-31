package com.tencent.util.i;

import android.os.Bundle;

public class a
{
  public static void a(a parama)
  {
    b.a(b.a(), parama);
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    b.a(b.a(), paramString, paramBundle);
  }
  
  public static abstract interface a
  {
    public abstract void openWebView(String paramString, Bundle paramBundle);
  }
  
  private static class b
  {
    private static b a = new b();
    private a.a b;
    
    private void a(a.a parama)
    {
      this.b = parama;
    }
    
    private void a(String paramString, Bundle paramBundle)
    {
      if (this.b != null) {
        this.b.openWebView(paramString, paramBundle);
      }
    }
    
    private static b b()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.i.a
 * JD-Core Version:    0.7.0.1
 */