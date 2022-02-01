package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.a.g;
import rx.d;
import rx.d.a;
import rx.d.c;
import rx.f;

public final class e<T, R>
  implements d.a<R>
{
  final d<T> OuQ;
  final rx.b.e<? super T, ? extends R> OuR;
  
  public e(d<T> paramd, rx.b.e<? super T, ? extends R> parame)
  {
    this.OuQ = paramd;
    this.OuR = parame;
  }
  
  static final class a<T, R>
    extends rx.i<T>
  {
    final rx.i<? super R> OuS;
    final rx.b.e<? super T, ? extends R> OuT;
    boolean done;
    
    public a(rx.i<? super R> parami, rx.b.e<? super T, ? extends R> parame)
    {
      this.OuS = parami;
      this.OuT = parame;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(90253);
      this.OuS.a(paramf);
      AppMethodBeat.o(90253);
    }
    
    public final void gC(T paramT)
    {
      AppMethodBeat.i(90250);
      try
      {
        Object localObject = this.OuT.call(paramT);
        this.OuS.gC(localObject);
        AppMethodBeat.o(90250);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.L(localThrowable);
        this.Ous.gDs();
        onError(g.a(localThrowable, paramT));
        AppMethodBeat.o(90250);
      }
    }
    
    public final void gDo()
    {
      AppMethodBeat.i(90252);
      if (this.done)
      {
        AppMethodBeat.o(90252);
        return;
      }
      this.OuS.gDo();
      AppMethodBeat.o(90252);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90251);
      if (this.done)
      {
        c.onError(paramThrowable);
        AppMethodBeat.o(90251);
        return;
      }
      this.done = true;
      this.OuS.onError(paramThrowable);
      AppMethodBeat.o(90251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.e
 * JD-Core Version:    0.7.0.1
 */