package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.a.g;
import rx.d;
import rx.d.a;
import rx.d.c;
import rx.f;
import rx.i;

public final class e<T, R>
  implements d.a<R>
{
  final d<T> abOa;
  final rx.b.e<? super T, ? extends R> abOb;
  
  public e(d<T> paramd, rx.b.e<? super T, ? extends R> parame)
  {
    this.abOa = paramd;
    this.abOb = parame;
  }
  
  static final class a<T, R>
    extends i<T>
  {
    final i<? super R> abOc;
    final rx.b.e<? super T, ? extends R> abOd;
    boolean done;
    
    public a(i<? super R> parami, rx.b.e<? super T, ? extends R> parame)
    {
      this.abOc = parami;
      this.abOd = parame;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(90253);
      this.abOc.a(paramf);
      AppMethodBeat.o(90253);
    }
    
    public final void c(Throwable paramThrowable)
    {
      AppMethodBeat.i(90251);
      if (this.done)
      {
        c.c(paramThrowable);
        AppMethodBeat.o(90251);
        return;
      }
      this.done = true;
      this.abOc.c(paramThrowable);
      AppMethodBeat.o(90251);
    }
    
    public final void fUB()
    {
      AppMethodBeat.i(90252);
      if (this.done)
      {
        AppMethodBeat.o(90252);
        return;
      }
      this.abOc.fUB();
      AppMethodBeat.o(90252);
    }
    
    public final void he(T paramT)
    {
      AppMethodBeat.i(90250);
      try
      {
        Object localObject = this.abOd.call(paramT);
        this.abOc.he(localObject);
        AppMethodBeat.o(90250);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.R(localThrowable);
        iVJ();
        c(g.a(localThrowable, paramT));
        AppMethodBeat.o(90250);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.e
 * JD-Core Version:    0.7.0.1
 */