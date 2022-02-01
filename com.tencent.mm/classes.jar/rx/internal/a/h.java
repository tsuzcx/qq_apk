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
  final e<? super T, Boolean> abOk;
  final boolean abOl;
  
  public h(e<? super T, Boolean> parame)
  {
    this.abOk = parame;
    this.abOl = true;
  }
  
  private i<? super T> b(final i<? super Boolean> parami)
  {
    AppMethodBeat.i(90262);
    final a locala = new a(parami);
    i local1 = new i()
    {
      boolean abOm;
      boolean done;
      
      public final void c(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(90260);
        parami.c(paramAnonymousThrowable);
        AppMethodBeat.o(90260);
      }
      
      public final void fUB()
      {
        AppMethodBeat.i(90261);
        if (!this.done)
        {
          this.done = true;
          if (this.abOm)
          {
            locala.setValue(Boolean.FALSE);
            AppMethodBeat.o(90261);
            return;
          }
          locala.setValue(Boolean.valueOf(h.this.abOl));
        }
        AppMethodBeat.o(90261);
      }
      
      public final void he(T paramAnonymousT)
      {
        AppMethodBeat.i(90259);
        this.abOm = true;
        for (;;)
        {
          try
          {
            bool = ((Boolean)h.this.abOk.call(paramAnonymousT)).booleanValue();
            if ((bool) && (!this.done))
            {
              this.done = true;
              paramAnonymousT = locala;
              if (!h.this.abOl)
              {
                bool = true;
                paramAnonymousT.setValue(Boolean.valueOf(bool));
                iVJ();
              }
            }
            else
            {
              AppMethodBeat.o(90259);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            b.a(localThrowable, this, paramAnonymousT);
            AppMethodBeat.o(90259);
            return;
          }
          boolean bool = false;
        }
      }
    };
    parami.b(local1);
    parami.a(locala);
    AppMethodBeat.o(90262);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.h
 * JD-Core Version:    0.7.0.1
 */