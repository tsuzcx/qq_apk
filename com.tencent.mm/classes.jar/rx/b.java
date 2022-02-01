package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;

public final class b
{
  static final b abNh;
  static final b abNi;
  private final a abNg;
  
  static
  {
    AppMethodBeat.i(90077);
    abNh = new b(new a() {}, (byte)0);
    abNi = new b(new a() {}, (byte)0);
    AppMethodBeat.o(90077);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(90075);
    this.abNg = rx.d.c.b(parama);
    AppMethodBeat.o(90075);
  }
  
  private b(a parama, byte paramByte)
  {
    this.abNg = parama;
  }
  
  private static NullPointerException O(Throwable paramThrowable)
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
    hd(parama);
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
      rx.d.c.c(parama);
      parama = O(parama);
      AppMethodBeat.o(90072);
      throw parama;
    }
  }
  
  private static <T> T hd(T paramT)
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
  
  public final j iVF()
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
      
      public final void fUB()
      {
        AppMethodBeat.i(90070);
        localc.iVJ();
        AppMethodBeat.o(90070);
      }
    };
    hd(local3);
    try
    {
      rx.d.c.a(this, this.abNg).cA(local3);
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
      rx.a.b.R(localThrowable);
      Object localObject = rx.d.c.aa(localThrowable);
      rx.d.c.c((Throwable)localObject);
      localObject = O((Throwable)localObject);
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
    
    public abstract void fUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.b
 * JD-Core Version:    0.7.0.1
 */