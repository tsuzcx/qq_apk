package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface q
  extends o, p
{
  public static final class a
  {
    public static int a(q paramq, k paramk)
    {
      AppMethodBeat.i(61243);
      d.g.b.k.h(paramk, "$this$size");
      int i = p.a.a((p)paramq, paramk);
      AppMethodBeat.o(61243);
      return i;
    }
    
    public static l a(q paramq, k paramk, int paramInt)
    {
      AppMethodBeat.i(61242);
      d.g.b.k.h(paramk, "$this$get");
      paramq = p.a.a((p)paramq, paramk, paramInt);
      AppMethodBeat.o(61242);
      return paramq;
    }
    
    public static m a(q paramq, g paramg)
    {
      AppMethodBeat.i(61239);
      d.g.b.k.h(paramg, "$this$typeConstructor");
      paramq = p.a.f((p)paramq, paramg);
      AppMethodBeat.o(61239);
      return paramq;
    }
    
    public static i b(q paramq, g paramg)
    {
      AppMethodBeat.i(61240);
      d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
      paramq = p.a.a((p)paramq, paramg);
      AppMethodBeat.o(61240);
      return paramq;
    }
    
    public static i c(q paramq, g paramg)
    {
      AppMethodBeat.i(61241);
      d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
      paramq = p.a.b((p)paramq, paramg);
      AppMethodBeat.o(61241);
      return paramq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.c.q
 * JD-Core Version:    0.7.0.1
 */