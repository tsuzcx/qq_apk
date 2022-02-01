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
      boolean completed;
      int count;
      
      public final void a(final f paramAnonymousf)
      {
        AppMethodBeat.i(90304);
        parami.a(new f()
        {
          final AtomicLong Mdf;
          
          public final void CI(long paramAnonymous2Long)
          {
            AppMethodBeat.i(90300);
            if ((paramAnonymous2Long > 0L) && (!m.1.this.completed))
            {
              long l1;
              long l2;
              do
              {
                l1 = this.Mdf.get();
                l2 = Math.min(paramAnonymous2Long, m.this.limit - l1);
                if (l2 == 0L) {
                  break;
                }
              } while (!this.Mdf.compareAndSet(l1, l1 + l2));
              paramAnonymousf.CI(l2);
              AppMethodBeat.o(90300);
              return;
            }
            AppMethodBeat.o(90300);
          }
        });
        AppMethodBeat.o(90304);
      }
      
      public final void gd(T paramAnonymousT)
      {
        AppMethodBeat.i(90303);
        if (!this.Mcl.MfG)
        {
          int i = this.count;
          this.count = (i + 1);
          if (i < m.this.limit)
          {
            if (this.count == m.this.limit) {}
            for (i = 1;; i = 0)
            {
              parami.gd(paramAnonymousT);
              if ((i == 0) || (this.completed)) {
                break;
              }
              this.completed = true;
              try
              {
                parami.ggi();
                return;
              }
              finally
              {
                this.Mcl.ggm();
                AppMethodBeat.o(90303);
              }
            }
          }
        }
      }
      
      public final void ggi()
      {
        AppMethodBeat.i(90301);
        if (!this.completed)
        {
          this.completed = true;
          parami.ggi();
        }
        AppMethodBeat.o(90301);
      }
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(90302);
        if (!this.completed)
        {
          this.completed = true;
          try
          {
            parami.onError(paramAnonymousThrowable);
            return;
          }
          finally
          {
            this.Mcl.ggm();
            AppMethodBeat.o(90302);
          }
        }
        AppMethodBeat.o(90302);
      }
    };
    if (this.limit == 0)
    {
      parami.ggi();
      local1.Mcl.ggm();
    }
    parami.b(local1);
    AppMethodBeat.o(90305);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.m
 * JD-Core Version:    0.7.0.1
 */