package com.tencent.tencentmap.mapsdk.a;

class ix$b
  extends Thread
{
  private boolean b;
  private boolean c;
  
  private ix$b(ix paramix) {}
  
  public void a()
  {
    try
    {
      this.c = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void destroy()
  {
    try
    {
      this.b = false;
      interrupt();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    while (this.b)
    {
      if (!this.c)
      {
        if (ix.a(this.a) != null) {
          ix.a(this.a).a(iv.h);
        }
        if ((ix.b(this.a)) && (System.currentTimeMillis() - ix.c(this.a) > 500L))
        {
          ix.a(this.a, false);
          if (ix.d(this.a) != null) {
            ix.d(this.a).a();
          }
        }
      }
      try
      {
        try
        {
          wait(this.a.h());
          continue;
        }
        finally {}
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void start()
  {
    try
    {
      this.b = true;
      super.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ix.b
 * JD-Core Version:    0.7.0.1
 */