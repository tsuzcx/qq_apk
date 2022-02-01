package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.b.e;
import rx.d.b;
import rx.i;
import rx.internal.b.a;

public final class h<T>
  implements d.b<Boolean, T>
{
  final e<? super T, Boolean> akbd;
  final boolean akbe;
  
  public h(e<? super T, Boolean> parame)
  {
    this.akbd = parame;
    this.akbe = true;
  }
  
  private i<? super T> b(final i<? super Boolean> parami)
  {
    AppMethodBeat.i(90262);
    final a locala = new a(parami);
    i local1 = new i()
    {
      boolean akbf;
      boolean done;
      
      public final void fvq()
      {
        AppMethodBeat.i(90261);
        if (!this.done)
        {
          this.done = true;
          if (this.akbf)
          {
            locala.setValue(Boolean.FALSE);
            AppMethodBeat.o(90261);
            return;
          }
          locala.setValue(Boolean.valueOf(h.this.akbe));
        }
        AppMethodBeat.o(90261);
      }
      
      public final void jV(T paramAnonymousT)
      {
        AppMethodBeat.i(90259);
        this.akbf = true;
        for (;;)
        {
          try
          {
            bool = ((Boolean)h.this.akbd.call(paramAnonymousT)).booleanValue();
            if ((bool) && (!this.done))
            {
              this.done = true;
              paramAnonymousT = locala;
              if (!h.this.akbe)
              {
                bool = true;
                paramAnonymousT.setValue(Boolean.valueOf(bool));
                kKh();
              }
            }
            else
            {
              AppMethodBeat.o(90259);
              return;
            }
          }
          finally
          {
            b.a(localThrowable, this, paramAnonymousT);
            AppMethodBeat.o(90259);
            return;
          }
          boolean bool = false;
        }
      }
      
      public final void l(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(90260);
        parami.l(paramAnonymousThrowable);
        AppMethodBeat.o(90260);
      }
    };
    parami.b(local1);
    parami.a(locala);
    AppMethodBeat.o(90262);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.h
 * JD-Core Version:    0.7.0.1
 */