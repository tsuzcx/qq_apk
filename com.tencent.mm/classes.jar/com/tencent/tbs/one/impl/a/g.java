package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g<T>
  extends a<T>
{
  private List<a<T>> b;
  private a<T> c;
  
  public g(a<T>[] paramArrayOfa)
  {
    AppMethodBeat.i(173888);
    this.b = new ArrayList(Arrays.asList(paramArrayOfa));
    AppMethodBeat.o(173888);
  }
  
  protected final void a()
  {
    AppMethodBeat.i(173889);
    c();
    AppMethodBeat.o(173889);
  }
  
  public final void b()
  {
    AppMethodBeat.i(173891);
    super.b();
    if (this.c != null) {
      this.c.b();
    }
    AppMethodBeat.o(173891);
  }
  
  final void c()
  {
    AppMethodBeat.i(173890);
    this.c = ((a)this.b.remove(0));
    if (this.b.size() == 0) {}
    for (final boolean bool = true;; bool = false)
    {
      this.c.a(new l()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(173956);
          g.this.a(paramAnonymousInt2);
          AppMethodBeat.o(173956);
        }
        
        public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(173958);
          f.a(paramAnonymousString, new Object[] { paramAnonymousThrowable });
          if ((bool) || (bool))
          {
            g.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
            AppMethodBeat.o(173958);
            return;
          }
          g.this.c();
          AppMethodBeat.o(173958);
        }
        
        public final void a(T paramAnonymousT)
        {
          AppMethodBeat.i(173957);
          g.this.a(paramAnonymousT);
          AppMethodBeat.o(173957);
        }
      });
      AppMethodBeat.o(173890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.g
 * JD-Core Version:    0.7.0.1
 */