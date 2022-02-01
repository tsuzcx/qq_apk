package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import rx.d.b;
import rx.f;

public final class m<T>
  implements d.b<T, T>
{
  final int limit = 10;
  
  private rx.i<? super T> b(final rx.i<? super T> parami)
  {
    AppMethodBeat.i(90305);
    rx.i local1 = new rx.i()
    {
      boolean TGl;
      int count;
      
      public final void a(final f paramAnonymousf)
      {
        AppMethodBeat.i(90304);
        parami.a(new f()
        {
          final AtomicLong akbp;
          
          public final void Cp(long paramAnonymous2Long)
          {
            AppMethodBeat.i(90300);
            if ((paramAnonymous2Long > 0L) && (!m.1.this.TGl))
            {
              long l1;
              long l2;
              do
              {
                l1 = this.akbp.get();
                l2 = Math.min(paramAnonymous2Long, m.this.limit - l1);
                if (l2 == 0L) {
                  break;
                }
              } while (!this.akbp.compareAndSet(l1, l1 + l2));
              paramAnonymousf.Cp(l2);
              AppMethodBeat.o(90300);
              return;
            }
            AppMethodBeat.o(90300);
          }
        });
        AppMethodBeat.o(90304);
      }
      
      public final void fvq()
      {
        AppMethodBeat.i(90301);
        if (!this.TGl)
        {
          this.TGl = true;
          parami.fvq();
        }
        AppMethodBeat.o(90301);
      }
      
      public final void jV(T paramAnonymousT)
      {
        AppMethodBeat.i(90303);
        if (!kKi())
        {
          int i = this.count;
          this.count = (i + 1);
          if (i < m.this.limit)
          {
            if (this.count == m.this.limit) {}
            for (i = 1;; i = 0)
            {
              parami.jV(paramAnonymousT);
              if ((i == 0) || (this.TGl)) {
                break;
              }
              this.TGl = true;
              try
              {
                parami.fvq();
                return;
              }
              finally
              {
                kKh();
                AppMethodBeat.o(90303);
              }
            }
          }
        }
      }
      
      public final void l(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(90302);
        if (!this.TGl)
        {
          this.TGl = true;
          try
          {
            parami.l(paramAnonymousThrowable);
            return;
          }
          finally
          {
            kKh();
            AppMethodBeat.o(90302);
          }
        }
        AppMethodBeat.o(90302);
      }
    };
    if (this.limit == 0)
    {
      parami.fvq();
      local1.akau.kKh();
    }
    parami.b(local1);
    AppMethodBeat.o(90305);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.m
 * JD-Core Version:    0.7.0.1
 */