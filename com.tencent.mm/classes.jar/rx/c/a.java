package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import rx.a.b;
import rx.a.d;
import rx.a.e;
import rx.a.f;
import rx.a.h;
import rx.d.c;
import rx.i;

public final class a<T>
  extends i<T>
{
  private final i<? super T> abOc;
  boolean done;
  
  public a(i<? super T> parami)
  {
    super(parami);
    this.abOc = parami;
  }
  
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90433);
    b.R(paramThrowable);
    if (!this.done)
    {
      this.done = true;
      c.c(paramThrowable);
      try
      {
        this.abOc.c(paramThrowable);
        AppMethodBeat.o(90433);
      }
      catch (f localf)
      {
        try
        {
          iVJ();
          AppMethodBeat.o(90433);
          return;
        }
        catch (Throwable paramThrowable)
        {
          c.c(paramThrowable);
          paramThrowable = new e(paramThrowable);
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
        localf = localf;
        try
        {
          iVJ();
          AppMethodBeat.o(90433);
          throw localf;
        }
        catch (Throwable localThrowable1)
        {
          c.c(localThrowable1);
          paramThrowable = new f("Observer.onError not implemented and error while unsubscribing.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable1 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
      }
      catch (Throwable localThrowable2)
      {
        c.c(localThrowable2);
        try
        {
          iVJ();
          paramThrowable = new e("Error occurred when trying to propagate error to Observer.onError", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
        catch (Throwable localThrowable3)
        {
          c.c(localThrowable3);
          paramThrowable = new e("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2, localThrowable3 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
      }
    }
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(90432);
    if (!this.done)
    {
      this.done = true;
      try
      {
        this.abOc.fUB();
        try
        {
          iVJ();
          AppMethodBeat.o(90432);
          return;
        }
        catch (Throwable localThrowable1)
        {
          c.c(localThrowable1);
          h localh1 = new h(localThrowable1.getMessage(), localThrowable1);
          AppMethodBeat.o(90432);
          throw localh1;
        }
        d locald;
        h localh2;
        AppMethodBeat.o(90432);
      }
      catch (Throwable localThrowable2)
      {
        b.R(localThrowable2);
        c.c(localThrowable2);
        locald = new d(localThrowable2.getMessage(), localThrowable2);
        AppMethodBeat.o(90432);
        throw locald;
      }
      finally
      {
        try
        {
          iVJ();
          AppMethodBeat.o(90432);
          throw localObject;
        }
        catch (Throwable localThrowable3)
        {
          c.c(localThrowable3);
          localh2 = new h(localThrowable3.getMessage(), localThrowable3);
          AppMethodBeat.o(90432);
          throw localh2;
        }
      }
    }
  }
  
  public final void he(T paramT)
  {
    AppMethodBeat.i(90434);
    try
    {
      if (!this.done) {
        this.abOc.he(paramT);
      }
      AppMethodBeat.o(90434);
      return;
    }
    catch (Throwable paramT)
    {
      b.a(paramT, this);
      AppMethodBeat.o(90434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.c.a
 * JD-Core Version:    0.7.0.1
 */