package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;

public final class b
{
  static final b Koi;
  static final b Koj;
  private final a Koh;
  
  static
  {
    AppMethodBeat.i(90077);
    Koi = new b(new a() {}, (byte)0);
    Koj = new b(new a() {}, (byte)0);
    AppMethodBeat.o(90077);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(90075);
    this.Koh = rx.d.c.b(parama);
    AppMethodBeat.o(90075);
  }
  
  private b(a parama, byte paramByte)
  {
    this.Koh = parama;
  }
  
  private static NullPointerException F(Throwable paramThrowable)
  {
    AppMethodBeat.i(90074);
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    AppMethodBeat.o(90074);
    return localNullPointerException;
  }
  
  public static b a(a parama)
  {
    AppMethodBeat.i(90072);
    requireNonNull(parama);
    try
    {
      parama = new b(parama);
      AppMethodBeat.o(90072);
      return parama;
    }
    catch (NullPointerException parama)
    {
      AppMethodBeat.o(90072);
      throw parama;
    }
    catch (Throwable parama)
    {
      rx.d.c.onError(parama);
      parama = F(parama);
      AppMethodBeat.o(90072);
      throw parama;
    }
  }
  
  private static <T> T requireNonNull(T paramT)
  {
    AppMethodBeat.i(90073);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(90073);
      throw paramT;
    }
    AppMethodBeat.o(90073);
    return paramT;
  }
  
  public final j fNr()
  {
    AppMethodBeat.i(90076);
    final rx.f.c localc = new rx.f.c();
    c local3 = new c()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(90071);
        localc.f(paramAnonymousj);
        AppMethodBeat.o(90071);
      }
      
      public final void fNs()
      {
        AppMethodBeat.i(90070);
        localc.fNw();
        AppMethodBeat.o(90070);
      }
    };
    requireNonNull(local3);
    try
    {
      rx.d.c.a(this, this.Koh).cq(local3);
      AppMethodBeat.o(90076);
      return localc;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(90076);
      throw localNullPointerException;
    }
    catch (Throwable localThrowable)
    {
      rx.a.b.I(localThrowable);
      Object localObject = rx.d.c.R(localThrowable);
      rx.d.c.onError((Throwable)localObject);
      localObject = F((Throwable)localObject);
      AppMethodBeat.o(90076);
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface a
    extends rx.b.b<b.c>
  {}
  
  public static abstract interface b
    extends e<b.c, b.c>
  {}
  
  public static abstract interface c
  {
    public abstract void a(j paramj);
    
    public abstract void fNs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.b
 * JD-Core Version:    0.7.0.1
 */