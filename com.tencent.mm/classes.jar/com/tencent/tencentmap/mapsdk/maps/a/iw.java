package com.tencent.tencentmap.mapsdk.maps.a;

import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class iw
  extends Thread
{
  private ik a;
  private boolean b = false;
  private boolean c = false;
  private byte[] d = null;
  
  public iw(ik paramik)
  {
    this.a = paramik;
  }
  
  private boolean d()
  {
    AppMethodBeat.i(148659);
    if (this.a != null)
    {
      boolean bool = this.a.j();
      AppMethodBeat.o(148659);
      return bool;
    }
    AppMethodBeat.o(148659);
    return false;
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148658);
    this.d = paramArrayOfByte;
    this.b = true;
    interrupt();
    AppMethodBeat.o(148658);
  }
  
  public void b()
  {
    AppMethodBeat.i(99890);
    this.c = false;
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(99890);
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(99891);
    AppMethodBeat.o(99891);
  }
  
  public void run()
  {
    AppMethodBeat.i(148657);
    while (!this.b)
    {
      try
      {
        for (;;)
        {
          boolean bool = this.c;
          if (!bool) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException1)
          {
            d.b(Log.getStackTraceString(localInterruptedException1));
          }
        }
      }
      finally
      {
        AppMethodBeat.o(148657);
      }
      if (!d()) {
        try
        {
          sleep(160L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          d.b(Log.getStackTraceString(localInterruptedException2));
        }
      }
    }
    c();
    if (this.d != null) {
      synchronized (this.d)
      {
        this.d.notify();
        AppMethodBeat.o(148657);
        return;
      }
    }
    AppMethodBeat.o(148657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.iw
 * JD-Core Version:    0.7.0.1
 */