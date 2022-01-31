package com.tencent.util.g;

import android.os.Bundle;

public class a
{
  public static void a(Bundle paramBundle)
  {
    b.a(b.a(), paramBundle);
  }
  
  public static void a(a parama)
  {
    b.a(b.a(), parama);
  }
  
  public static abstract interface a
  {
    public abstract void report(Bundle paramBundle);
  }
  
  private static class b
  {
    private static b a = new b();
    private a.a b;
    
    private void a(Bundle paramBundle)
    {
      if (this.b != null)
      {
        if (paramBundle != null) {
          paramBundle.putString("opername", "now_jiehe");
        }
        this.b.report(paramBundle);
      }
    }
    
    private void a(a.a parama)
    {
      this.b = parama;
    }
    
    private static b b()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.g.a
 * JD-Core Version:    0.7.0.1
 */