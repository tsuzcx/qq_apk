package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.m;

public final class be
{
  public static final bg a(bg parambg, ab paramab)
  {
    AppMethodBeat.i(60904);
    p.h(parambg, "$this$inheritEnhancement");
    p.h(paramab, "origin");
    parambg = b(parambg, aK(paramab));
    AppMethodBeat.o(60904);
    return parambg;
  }
  
  public static final ab aK(ab paramab)
  {
    AppMethodBeat.i(60903);
    p.h(paramab, "$this$getEnhancement");
    if ((paramab instanceof bd))
    {
      paramab = ((bd)paramab).gtY();
      AppMethodBeat.o(60903);
      return paramab;
    }
    AppMethodBeat.o(60903);
    return null;
  }
  
  public static final bg b(bg parambg, ab paramab)
  {
    AppMethodBeat.i(60905);
    p.h(parambg, "$this$wrapEnhancement");
    if (paramab == null)
    {
      AppMethodBeat.o(60905);
      return parambg;
    }
    if ((parambg instanceof aj))
    {
      parambg = (bg)new al((aj)parambg, paramab);
      AppMethodBeat.o(60905);
      return parambg;
    }
    if ((parambg instanceof v))
    {
      parambg = (bg)new x((v)parambg, paramab);
      AppMethodBeat.o(60905);
      return parambg;
    }
    parambg = new m();
    AppMethodBeat.o(60905);
    throw parambg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.be
 * JD-Core Version:    0.7.0.1
 */