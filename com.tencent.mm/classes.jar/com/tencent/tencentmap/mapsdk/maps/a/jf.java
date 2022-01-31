package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class jf
{
  private ExecutorService a;
  private ExecutorService b;
  private jd c;
  private je d;
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148687);
    if (this.d == null)
    {
      AppMethodBeat.o(148687);
      return;
    }
    if (this.b == null) {
      this.b = Executors.newSingleThreadExecutor();
    }
    if (!this.b.isShutdown()) {
      this.b.execute(new jf.2(this, paramArrayOfByte, paramString));
    }
    AppMethodBeat.o(148687);
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(148686);
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
      AppMethodBeat.o(148686);
      return;
    }
    catch (Exception localException)
    {
      a(paramString, null);
      AppMethodBeat.o(148686);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(148683);
    a(null);
    AppMethodBeat.o(148683);
  }
  
  public void a(jd paramjd)
  {
    this.c = paramjd;
  }
  
  public void a(je paramje)
  {
    this.d = paramje;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(148684);
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
    AppMethodBeat.o(148684);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(148685);
    if (this.c == null)
    {
      AppMethodBeat.o(148685);
      return;
    }
    if (this.a == null) {
      this.a = Executors.newFixedThreadPool(5);
    }
    try
    {
      if (!this.a.isShutdown()) {
        this.a.execute(new jf.1(this, paramString));
      }
      AppMethodBeat.o(148685);
      return;
    }
    catch (IllegalMonitorStateException paramString)
    {
      AppMethodBeat.o(148685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jf
 * JD-Core Version:    0.7.0.1
 */