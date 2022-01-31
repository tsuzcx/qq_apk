package com.tencent.util.a;

import android.os.Bundle;

public class a
{
  public static Bundle a()
  {
    return b.a().b();
  }
  
  public static void a(a parama)
  {
    b.a().a(parama);
  }
  
  public static abstract interface a
  {
    public abstract Bundle getTickets();
  }
  
  private static class b
  {
    private static b a = new b();
    private a.a b = null;
    
    public static b a()
    {
      return a;
    }
    
    public void a(a.a parama)
    {
      this.b = parama;
    }
    
    public Bundle b()
    {
      if (this.b != null) {
        return this.b.getTickets();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.a.a
 * JD-Core Version:    0.7.0.1
 */