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
  static final e NXx;
  final b<T> NXv;
  private boolean NXw;
  
  static
  {
    AppMethodBeat.i(90244);
    NXx = new e()
    {
      public final void gyM() {}
      
      public final void gz(Object paramAnonymousObject) {}
      
      public final void onError(Throwable paramAnonymousThrowable) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.NXv = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void gA(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.NXv.NXz)
    {
      this.NXv.NXB.add(paramObject);
      if ((this.NXv.get() != null) && (!this.NXv.NXA))
      {
        this.NXw = true;
        this.NXv.NXA = true;
      }
      if (this.NXw)
      {
        paramObject = this.NXv.NXB.poll();
        if (paramObject != null) {
          c.a((e)this.NXv.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> gyU()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void gyM()
  {
    AppMethodBeat.i(90241);
    if (this.NXw)
    {
      ((e)this.NXv.get()).gyM();
      AppMethodBeat.o(90241);
      return;
    }
    gA(c.gyX());
    AppMethodBeat.o(90241);
  }
  
  public final void gz(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.NXw)
    {
      ((e)this.NXv.get()).gz(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    gA(c.gB(paramT));
    AppMethodBeat.o(90243);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.NXw)
    {
      ((e)this.NXv.get()).onError(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    gA(c.M(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> NXv;
    
    public a(a.b<T> paramb)
    {
      this.NXv = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    boolean NXA;
    final ConcurrentLinkedQueue<Object> NXB;
    final c<T> NXC;
    final Object NXz;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.NXz = new Object();
      this.NXB = new ConcurrentLinkedQueue();
      this.NXC = c.gyW();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */