package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class kw
{
  private ExecutorService a;
  private ExecutorService b;
  private kt c;
  private ku d;
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.d == null) {}
    do
    {
      return;
      if (this.b == null) {
        this.b = Executors.newSingleThreadExecutor();
      }
    } while (this.b.isShutdown());
    this.b.execute(new kw.2(this, paramArrayOfByte, paramString));
  }
  
  private void b(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = this.c.a(paramString);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 != null)
      {
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2.length == 0) {
          arrayOfByte1 = null;
        }
      }
      a(paramString, arrayOfByte1);
      return;
    }
    catch (Exception localException)
    {
      a(paramString, null);
    }
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(kt paramkt)
  {
    this.c = paramkt;
  }
  
  public void a(ku paramku)
  {
    this.d = paramku;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.c = null;
    if (this.a != null)
    {
      this.a.shutdown();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.shutdown();
      this.b = null;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      if (this.a == null) {
        this.a = Executors.newFixedThreadPool(5);
      }
      try
      {
        if (!this.a.isShutdown())
        {
          this.a.execute(new kw.1(this, paramString));
          return;
        }
      }
      catch (IllegalMonitorStateException paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kw
 * JD-Core Version:    0.7.0.1
 */