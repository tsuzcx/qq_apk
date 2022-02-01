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
  static final e OuC;
  final b<T> OuA;
  private boolean OuB;
  
  static
  {
    AppMethodBeat.i(90244);
    OuC = new e()
    {
      public final void gC(Object paramAnonymousObject) {}
      
      public final void gDo() {}
      
      public final void onError(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.OuA = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void gD(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.OuA.OuE)
    {
      this.OuA.OuG.add(paramObject);
      if ((this.OuA.get() != null) && (!this.OuA.OuF))
      {
        this.OuB = true;
        this.OuA.OuF = true;
      }
      if (this.OuB)
      {
        paramObject = this.OuA.OuG.poll();
        if (paramObject != null) {
          c.a((e)this.OuA.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> gDw()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void gC(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.OuB)
    {
      ((e)this.OuA.get()).gC(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    gD(c.gE(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void gDo()
  {
    AppMethodBeat.i(90241);
    if (this.OuB)
    {
      ((e)this.OuA.get()).gDo();
      AppMethodBeat.o(90241);
      return;
    }
    gD(c.gDz());
    AppMethodBeat.o(90241);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.OuB)
    {
      ((e)this.OuA.get()).onError(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    gD(c.N(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> OuA;
    
    public a(a.b<T> paramb)
    {
      this.OuA = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final Object OuE;
    boolean OuF;
    final ConcurrentLinkedQueue<Object> OuG;
    final c<T> OuH;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.OuE = new Object();
      this.OuG = new ConcurrentLinkedQueue();
      this.OuH = c.gDy();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */