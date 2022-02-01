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
  static final e KoM;
  final b<T> KoK;
  private boolean KoL;
  
  static
  {
    AppMethodBeat.i(90244);
    KoM = new e()
    {
      public final void fNs() {}
      
      public final void fV(Object paramAnonymousObject) {}
      
      public final void onError(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.KoK = paramb;
    AppMethodBeat.o(90239);
  }
  
  public static <T> a<T> fNA()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  private void fW(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.KoK.KoO)
    {
      this.KoK.KoQ.add(paramObject);
      if ((this.KoK.get() != null) && (!this.KoK.KoP))
      {
        this.KoL = true;
        this.KoK.KoP = true;
      }
      if (this.KoL)
      {
        paramObject = this.KoK.KoQ.poll();
        if (paramObject != null) {
          c.a((e)this.KoK.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public final void fNs()
  {
    AppMethodBeat.i(90241);
    if (this.KoL)
    {
      ((e)this.KoK.get()).fNs();
      AppMethodBeat.o(90241);
      return;
    }
    fW(c.fND());
    AppMethodBeat.o(90241);
  }
  
  public final void fV(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.KoL)
    {
      ((e)this.KoK.get()).fV(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    fW(c.fX(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.KoL)
    {
      ((e)this.KoK.get()).onError(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    fW(c.K(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> KoK;
    
    public a(a.b<T> paramb)
    {
      this.KoK = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final Object KoO;
    boolean KoP;
    final ConcurrentLinkedQueue<Object> KoQ;
    final c<T> KoR;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.KoO = new Object();
      this.KoQ = new ConcurrentLinkedQueue();
      this.KoR = c.fNC();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */