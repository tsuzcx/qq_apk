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
  static final e Ukq;
  final b<T> Uko;
  private boolean Ukp;
  
  static
  {
    AppMethodBeat.i(90244);
    Ukq = new e()
    {
      public final void gL(Object paramAnonymousObject) {}
      
      public final void hQw() {}
      
      public final void onError(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.Uko = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void gM(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.Uko.Uks)
    {
      this.Uko.Uku.add(paramObject);
      if ((this.Uko.get() != null) && (!this.Uko.Ukt))
      {
        this.Ukp = true;
        this.Uko.Ukt = true;
      }
      if (this.Ukp)
      {
        paramObject = this.Uko.Uku.poll();
        if (paramObject != null) {
          c.a((e)this.Uko.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> hQE()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void gL(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.Ukp)
    {
      ((e)this.Uko.get()).gL(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    gM(c.gN(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void hQw()
  {
    AppMethodBeat.i(90241);
    if (this.Ukp)
    {
      ((e)this.Uko.get()).hQw();
      AppMethodBeat.o(90241);
      return;
    }
    gM(c.hQH());
    AppMethodBeat.o(90241);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.Ukp)
    {
      ((e)this.Uko.get()).onError(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    gM(c.P(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> Uko;
    
    public a(a.b<T> paramb)
    {
      this.Uko = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final Object Uks;
    boolean Ukt;
    final ConcurrentLinkedQueue<Object> Uku;
    final c<T> Ukv;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.Uks = new Object();
      this.Uku = new ConcurrentLinkedQueue();
      this.Ukv = c.hQG();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */