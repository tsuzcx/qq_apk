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
  final d<T> NXL;
  final rx.b.e<? super T, ? extends R> NXM;
  
  public e(d<T> paramd, rx.b.e<? super T, ? extends R> parame)
  {
    this.NXL = paramd;
    this.NXM = parame;
  }
  
  static final class a<T, R>
    extends rx.i<T>
  {
    final rx.i<? super R> NXN;
    final rx.b.e<? super T, ? extends R> NXO;
    boolean done;
    
    public a(rx.i<? super R> parami, rx.b.e<? super T, ? extends R> parame)
    {
      this.NXN = parami;
      this.NXO = parame;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(90253);
      this.NXN.a(paramf);
      AppMethodBeat.o(90253);
    }
    
    public final void gyM()
    {
      AppMethodBeat.i(90252);
      if (this.done)
      {
        AppMethodBeat.o(90252);
        return;
      }
      this.NXN.gyM();
      AppMethodBeat.o(90252);
    }
    
    public final void gz(T paramT)
    {
      AppMethodBeat.i(90250);
      try
      {
        Object localObject = this.NXO.call(paramT);
        this.NXN.gz(localObject);
        AppMethodBeat.o(90250);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.K(localThrowable);
        this.NXn.gyQ();
        onError(g.a(localThrowable, paramT));
        AppMethodBeat.o(90250);
      }
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
      this.NXN.onError(paramThrowable);
      AppMethodBeat.o(90251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.e
 * JD-Core Version:    0.7.0.1
 */