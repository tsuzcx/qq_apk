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
  private final i<? super T> NXN;
  boolean done;
  
  public a(i<? super T> parami)
  {
    super(parami);
    this.NXN = parami;
  }
  
  public final void gyM()
  {
    AppMethodBeat.i(90432);
    if (!this.done)
    {
      this.done = true;
      try
      {
        this.NXN.gyM();
        try
        {
          gyQ();
          AppMethodBeat.o(90432);
          return;
        }
        catch (Throwable localThrowable1)
        {
          c.onError(localThrowable1);
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
        b.K(localThrowable2);
        c.onError(localThrowable2);
        locald = new d(localThrowable2.getMessage(), localThrowable2);
        AppMethodBeat.o(90432);
        throw locald;
      }
      finally
      {
        try
        {
          gyQ();
          AppMethodBeat.o(90432);
          throw localObject;
        }
        catch (Throwable localThrowable3)
        {
          c.onError(localThrowable3);
          localh2 = new h(localThrowable3.getMessage(), localThrowable3);
          AppMethodBeat.o(90432);
          throw localh2;
        }
      }
    }
  }
  
  public final void gz(T paramT)
  {
    AppMethodBeat.i(90434);
    try
    {
      if (!this.done) {
        this.NXN.gz(paramT);
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
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90433);
    b.K(paramThrowable);
    if (!this.done)
    {
      this.done = true;
      c.onError(paramThrowable);
      try
      {
        this.NXN.onError(paramThrowable);
        AppMethodBeat.o(90433);
      }
      catch (f localf)
      {
        try
        {
          gyQ();
          AppMethodBeat.o(90433);
          return;
        }
        catch (Throwable paramThrowable)
        {
          c.onError(paramThrowable);
          paramThrowable = new e(paramThrowable);
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
        localf = localf;
        try
        {
          gyQ();
          AppMethodBeat.o(90433);
          throw localf;
        }
        catch (Throwable localThrowable1)
        {
          c.onError(localThrowable1);
          paramThrowable = new f("Observer.onError not implemented and error while unsubscribing.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable1 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
      }
      catch (Throwable localThrowable2)
      {
        c.onError(localThrowable2);
        try
        {
          gyQ();
          paramThrowable = new e("Error occurred when trying to propagate error to Observer.onError", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
        catch (Throwable localThrowable3)
        {
          c.onError(localThrowable3);
          paramThrowable = new e("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2, localThrowable3 }), (byte)0));
          AppMethodBeat.o(90433);
          throw paramThrowable;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.c.a
 * JD-Core Version:    0.7.0.1
 */