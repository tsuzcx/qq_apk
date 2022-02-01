package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.c;

public final class aj
{
  public static final List<ah> a(ai paramai, c paramc)
  {
    AppMethodBeat.i(191806);
    s.u(paramai, "<this>");
    s.u(paramc, "fqName");
    List localList = (List)new ArrayList();
    a(paramai, paramc, (Collection)localList);
    AppMethodBeat.o(191806);
    return localList;
  }
  
  public static final void a(ai paramai, c paramc, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(191815);
    s.u(paramai, "<this>");
    s.u(paramc, "fqName");
    s.u(paramCollection, "packageFragments");
    if ((paramai instanceof ak))
    {
      ((ak)paramai).a(paramc, paramCollection);
      AppMethodBeat.o(191815);
      return;
    }
    paramCollection.addAll((Collection)paramai.f(paramc));
    AppMethodBeat.o(191815);
  }
  
  public static final boolean b(ai paramai, c paramc)
  {
    AppMethodBeat.i(191809);
    s.u(paramai, "<this>");
    s.u(paramc, "fqName");
    if ((paramai instanceof ak))
    {
      bool = ((ak)paramai).g(paramc);
      AppMethodBeat.o(191809);
      return bool;
    }
    boolean bool = a(paramai, paramc).isEmpty();
    AppMethodBeat.o(191809);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aj
 * JD-Core Version:    0.7.0.1
 */