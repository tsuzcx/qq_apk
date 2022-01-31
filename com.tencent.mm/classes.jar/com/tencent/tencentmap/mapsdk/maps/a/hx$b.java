package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class hx$b
  extends Thread
{
  private boolean b;
  private boolean c;
  
  private hx$b(hx paramhx) {}
  
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
      AppMethodBeat.i(148121);
      this.b = false;
      interrupt();
      AppMethodBeat.o(148121);
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
    AppMethodBeat.i(148122);
    while (this.b)
    {
      if (!this.c)
      {
        if (hx.a(this.a) != null) {
          hx.a(this.a).a(hv.h);
        }
        if ((hx.b(this.a)) && (System.currentTimeMillis() - hx.c(this.a) > 500L))
        {
          hx.a(this.a, false);
          if (hx.d(this.a) != null) {
            hx.d(this.a).a();
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
        finally
        {
          AppMethodBeat.o(148122);
        }
        AppMethodBeat.o(148122);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void start()
  {
    try
    {
      AppMethodBeat.i(148120);
      this.b = true;
      super.start();
      AppMethodBeat.o(148120);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hx.b
 * JD-Core Version:    0.7.0.1
 */