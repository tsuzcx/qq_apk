package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface r
  extends p, q
{
  public static final class a
  {
    public static int a(r paramr, l paraml)
    {
      AppMethodBeat.i(61243);
      d.g.b.p.h(paraml, "$this$size");
      int i = q.a.a((q)paramr, paraml);
      AppMethodBeat.o(61243);
      return i;
    }
    
    public static m a(r paramr, l paraml, int paramInt)
    {
      AppMethodBeat.i(61242);
      d.g.b.p.h(paraml, "$this$get");
      paramr = q.a.a((q)paramr, paraml, paramInt);
      AppMethodBeat.o(61242);
      return paramr;
    }
    
    public static n a(r paramr, h paramh)
    {
      AppMethodBeat.i(61239);
      d.g.b.p.h(paramh, "$this$typeConstructor");
      paramr = q.a.f((q)paramr, paramh);
      AppMethodBeat.o(61239);
      return paramr;
    }
    
    public static j b(r paramr, h paramh)
    {
      AppMethodBeat.i(61240);
      d.g.b.p.h(paramh, "$this$lowerBoundIfFlexible");
      paramr = q.a.a((q)paramr, paramh);
      AppMethodBeat.o(61240);
      return paramr;
    }
    
    public static j c(r paramr, h paramh)
    {
      AppMethodBeat.i(61241);
      d.g.b.p.h(paramh, "$this$upperBoundIfFlexible");
      paramr = q.a.b((q)paramr, paramh);
      AppMethodBeat.o(61241);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.c.r
 * JD-Core Version:    0.7.0.1
 */