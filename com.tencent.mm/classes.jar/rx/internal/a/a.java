package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d.a;
import rx.e;
import rx.e.b;

public final class a<T>
  extends b<T, T>
{
  static final e akaF;
  final b<T> akaD;
  private boolean akaE;
  
  static
  {
    AppMethodBeat.i(90244);
    akaF = new e()
    {
      public final void fvq() {}
      
      public final void jV(Object paramAnonymousObject) {}
      
      public final void l(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.akaD = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void jX(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.akaD.akaH)
    {
      this.akaD.akaJ.add(paramObject);
      if ((this.akaD.get() != null) && (!this.akaD.akaI))
      {
        this.akaE = true;
        this.akaD.akaI = true;
      }
      if (this.akaE)
      {
        paramObject = this.akaD.akaJ.poll();
        if (paramObject != null) {
          c.a((e)this.akaD.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> kKl()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(90241);
    if (this.akaE)
    {
      ((e)this.akaD.get()).fvq();
      AppMethodBeat.o(90241);
      return;
    }
    jX(c.kKo());
    AppMethodBeat.o(90241);
  }
  
  public final void jV(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.akaE)
    {
      ((e)this.akaD.get()).jV(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    jX(c.jY(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.akaE)
    {
      ((e)this.akaD.get()).l(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    jX(c.ak(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> akaD;
    
    public a(a.b<T> paramb)
    {
      this.akaD = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final Object akaH;
    boolean akaI;
    final ConcurrentLinkedQueue<Object> akaJ;
    final c<T> akaK;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.akaH = new Object();
      this.akaJ = new ConcurrentLinkedQueue();
      this.akaK = c.kKn();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */