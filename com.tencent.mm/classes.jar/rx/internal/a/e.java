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
  final d<T> akaT;
  final rx.b.e<? super T, ? extends R> akaU;
  
  public e(d<T> paramd, rx.b.e<? super T, ? extends R> parame)
  {
    this.akaT = paramd;
    this.akaU = parame;
  }
  
  static final class a<T, R>
    extends i<T>
  {
    final i<? super R> akaV;
    final rx.b.e<? super T, ? extends R> akaW;
    boolean done;
    
    public a(i<? super R> parami, rx.b.e<? super T, ? extends R> parame)
    {
      this.akaV = parami;
      this.akaW = parame;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(90253);
      this.akaV.a(paramf);
      AppMethodBeat.o(90253);
    }
    
    public final void fvq()
    {
      AppMethodBeat.i(90252);
      if (this.done)
      {
        AppMethodBeat.o(90252);
        return;
      }
      this.akaV.fvq();
      AppMethodBeat.o(90252);
    }
    
    public final void jV(T paramT)
    {
      AppMethodBeat.i(90250);
      try
      {
        Object localObject = this.akaW.call(paramT);
        this.akaV.jV(localObject);
        AppMethodBeat.o(90250);
        return;
      }
      finally
      {
        b.ai(localThrowable);
        kKh();
        l(g.a(localThrowable, paramT));
        AppMethodBeat.o(90250);
      }
    }
    
    public final void l(Throwable paramThrowable)
    {
      AppMethodBeat.i(90251);
      if (this.done)
      {
        c.l(paramThrowable);
        AppMethodBeat.o(90251);
        return;
      }
      this.done = true;
      this.akaV.l(paramThrowable);
      AppMethodBeat.o(90251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.e
 * JD-Core Version:    0.7.0.1
 */