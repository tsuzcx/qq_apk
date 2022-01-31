package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Arrays;

public class og<T>
  extends nx<T>
{
  boolean a = false;
  private final nx<? super T> b;
  
  public og(nx<? super T> paramnx)
  {
    super(paramnx);
    this.b = paramnx;
  }
  
  private void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(149604);
    System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + paramThrowable.getMessage());
    AppMethodBeat.o(149604);
  }
  
  public void a()
  {
    AppMethodBeat.i(149600);
    if (!this.a)
    {
      this.a = true;
      try
      {
        this.b.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        oa.a(localThrowable);
        b(localThrowable);
        return;
      }
      finally
      {
        b();
        AppMethodBeat.o(149600);
      }
    }
    AppMethodBeat.o(149600);
  }
  
  public void a(T paramT)
  {
    AppMethodBeat.i(149602);
    try
    {
      if (!this.a) {
        this.b.a(paramT);
      }
      AppMethodBeat.o(149602);
      return;
    }
    catch (Throwable paramT)
    {
      oa.a(paramT);
      a(paramT);
      AppMethodBeat.o(149602);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    AppMethodBeat.i(149601);
    oa.a(paramThrowable);
    if (!this.a)
    {
      this.a = true;
      b(paramThrowable);
    }
    AppMethodBeat.o(149601);
  }
  
  protected void b(Throwable paramThrowable)
  {
    AppMethodBeat.i(149603);
    try
    {
      ok.a().b().a(paramThrowable);
    }
    catch (Throwable localThrowable6)
    {
      for (;;)
      {
        try
        {
          this.b.a(paramThrowable);
        }
        catch (Throwable localThrowable2)
        {
          if ((localThrowable2 instanceof oc))
          {
            try
            {
              b();
              paramThrowable = (oc)localThrowable2;
              AppMethodBeat.o(149603);
              throw paramThrowable;
            }
            catch (Throwable localThrowable3) {}
            try
            {
              ok.a().b().a(localThrowable3);
              paramThrowable = new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new nz(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3 })));
              AppMethodBeat.o(149603);
              throw paramThrowable;
            }
            catch (Throwable localThrowable5)
            {
              c(localThrowable5);
              continue;
            }
          }
          try
          {
            ok.a().b().a(localThrowable3);
          }
          catch (Throwable localThrowable6)
          {
            try
            {
              b();
              paramThrowable = new ob("Error occurred when trying to propagate error to Observer.onError", new nz(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3 })));
              AppMethodBeat.o(149603);
              throw paramThrowable;
            }
            catch (Throwable localThrowable7)
            {
              try
              {
                ok.a().b().a(localThrowable7);
                paramThrowable = new ob("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new nz(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3, localThrowable7 })));
                AppMethodBeat.o(149603);
                throw paramThrowable;
              }
              catch (Throwable localThrowable8)
              {
                for (;;)
                {
                  c(localThrowable8);
                }
              }
            }
            localThrowable6 = localThrowable6;
            c(localThrowable6);
            continue;
          }
        }
        try
        {
          b();
          AppMethodBeat.o(149603);
          return;
        }
        catch (RuntimeException paramThrowable) {}
        localThrowable1 = localThrowable1;
        c(localThrowable1);
      }
    }
    try
    {
      ok.a().b().a(paramThrowable);
      paramThrowable = new ob(paramThrowable);
      AppMethodBeat.o(149603);
      throw paramThrowable;
    }
    catch (Throwable localThrowable4)
    {
      for (;;)
      {
        c(localThrowable4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.og
 * JD-Core Version:    0.7.0.1
 */