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
  static final e abNM;
  final b<T> abNK;
  private boolean abNL;
  
  static
  {
    AppMethodBeat.i(90244);
    abNM = new e()
    {
      public final void c(Throwable paramAnonymousThrowable) {}
      
      public final void fUB() {}
      
      public final void he(Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(90244);
  }
  
  private a(b<T> paramb)
  {
    super(new a(paramb));
    AppMethodBeat.i(90239);
    this.abNK = paramb;
    AppMethodBeat.o(90239);
  }
  
  private void hg(Object paramObject)
  {
    AppMethodBeat.i(90240);
    synchronized (this.abNK.abNO)
    {
      this.abNK.abNQ.add(paramObject);
      if ((this.abNK.get() != null) && (!this.abNK.abNP))
      {
        this.abNL = true;
        this.abNK.abNP = true;
      }
      if (this.abNL)
      {
        paramObject = this.abNK.abNQ.poll();
        if (paramObject != null) {
          c.a((e)this.abNK.get(), paramObject);
        }
      }
    }
    AppMethodBeat.o(90240);
  }
  
  public static <T> a<T> iVN()
  {
    AppMethodBeat.i(90238);
    a locala = new a(new b());
    AppMethodBeat.o(90238);
    return locala;
  }
  
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90242);
    if (this.abNL)
    {
      ((e)this.abNK.get()).c(paramThrowable);
      AppMethodBeat.o(90242);
      return;
    }
    hg(c.T(paramThrowable));
    AppMethodBeat.o(90242);
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(90241);
    if (this.abNL)
    {
      ((e)this.abNK.get()).fUB();
      AppMethodBeat.o(90241);
      return;
    }
    hg(c.iVQ());
    AppMethodBeat.o(90241);
  }
  
  public final void he(T paramT)
  {
    AppMethodBeat.i(90243);
    if (this.abNL)
    {
      ((e)this.abNK.get()).he(paramT);
      AppMethodBeat.o(90243);
      return;
    }
    hg(c.hh(paramT));
    AppMethodBeat.o(90243);
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final a.b<T> abNK;
    
    public a(a.b<T> paramb)
    {
      this.abNK = paramb;
    }
  }
  
  static final class b<T>
    extends AtomicReference<e<? super T>>
  {
    final Object abNO;
    boolean abNP;
    final ConcurrentLinkedQueue<Object> abNQ;
    final c<T> abNR;
    
    b()
    {
      AppMethodBeat.i(90235);
      this.abNO = new Object();
      this.abNQ = new ConcurrentLinkedQueue();
      this.abNR = c.iVP();
      AppMethodBeat.o(90235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.a
 * JD-Core Version:    0.7.0.1
 */