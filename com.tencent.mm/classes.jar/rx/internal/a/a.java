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
  static final e Mcv;
  final b<T> Mct;
  private boolean Mcu;
  
  static
  {
    AppMethodBeat.i(90244);
    Mcv = new e()
    {
      public final void gd(Object paramAnonymousObject) {}
      
      public final void ggi() {}
      
      public final void onError(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.Mct = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void ge(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.Mct.Mcx)
    {
      this.Mct.Mcz.add(paramObject);
      if ((this.Mct.get() != null) && (!this.Mct.Mcy))
      {
        this.Mcu = true;
        this.Mct.Mcy = true;
      }
      if (this.Mcu)
      {
        paramObject = this.Mct.Mcz.poll();
        if (paramObject != null) {
          c.a((e)this.Mct.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> ggq()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void gd(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.Mcu)
    {
      ((e)this.Mct.get()).gd(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    ge(c.gf(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void ggi()
  {
    AppMethodBeat.i(90241);
    if (this.Mcu)
    {
      ((e)this.Mct.get()).ggi();
      AppMethodBeat.o(90241);
      return;
    }
    ge(c.ggt());
    AppMethodBeat.o(90241);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.Mcu)
    {
      ((e)this.Mct.get()).onError(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    ge(c.L(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> Mct;
    
    public a(a.b<T> paramb)
    {
      this.Mct = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final c<T> McA;
    final Object Mcx;
    boolean Mcy;
    final ConcurrentLinkedQueue<Object> Mcz;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.Mcx = new Object();
      this.Mcz = new ConcurrentLinkedQueue();
      this.McA = c.ggs();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */