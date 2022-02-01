package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.b.e;
import rx.d.b;
import rx.internal.b.a;

public final class h<T>
  implements d.b<Boolean, T>
{
  final e<? super T, Boolean> Ova;
  final boolean Ovb;
  
  public h(e<? super T, Boolean> parame)
  {
    this.Ova = parame;
    this.Ovb = true;
  }
  
  private rx.i<? super T> b(final rx.i<? super Boolean> parami)
  {
    AppMethodBeat.i(90262);
    final a locala = new a(parami);
    rx.i local1 = new rx.i()
    {
      boolean Ovc;
      boolean done;
      
      public final void gC(T paramAnonymousT)
      {
        AppMethodBeat.i(90259);
        this.Ovc = true;
        for (;;)
        {
          try
          {
            bool = ((Boolean)h.this.Ova.call(paramAnonymousT)).booleanValue();
            if ((bool) && (!this.done))
            {
              this.done = true;
              paramAnonymousT = locala;
              if (!h.this.Ovb)
              {
                bool = true;
                paramAnonymousT.setValue(Boolean.valueOf(bool));
                this.Ous.gDs();
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
      
      public final void gDo()
      {
        AppMethodBeat.i(90261);
        if (!this.done)
        {
          this.done = true;
          if (this.Ovc)
          {
            locala.setValue(Boolean.FALSE);
            AppMethodBeat.o(90261);
            return;
          }
          locala.setValue(Boolean.valueOf(h.this.Ovb));
        }
        AppMethodBeat.o(90261);
      }
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(90260);
        parami.onError(paramAnonymousThrowable);
        AppMethodBeat.o(90260);
      }
    };
    parami.b(local1);
    parami.a(locala);
    AppMethodBeat.o(90262);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.h
 * JD-Core Version:    0.7.0.1
 */