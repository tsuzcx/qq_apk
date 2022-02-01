package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T>
{
  public a a;
  public T b;
  public Object c;
  
  public static <T> e<T> a(a parama, T paramT)
  {
    AppMethodBeat.i(174071);
    e locale = new e();
    locale.a = parama;
    locale.b = paramT;
    AppMethodBeat.o(174071);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(174131);
      a = new a("EXISTING", 0);
      b = new a("BUILTIN", 1);
      c = new a("LOCAL", 2);
      d = new a("SHARING", 3);
      e = new a("ONLINE", 4);
      f = new a("EXTENSION", 5);
      g = new a("SDCARD_FILE", 6);
      h = new a[] { a, b, c, d, e, f, g };
      AppMethodBeat.o(174131);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.e
 * JD-Core Version:    0.7.0.1
 */