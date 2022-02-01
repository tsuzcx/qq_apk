package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.List;

@l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"checkCountOverflow", "", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "listOf", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"})
public class k
{
  public static final <T> List<T> listOf(T paramT)
  {
    AppMethodBeat.i(129006);
    paramT = Collections.singletonList(paramT);
    p.g(paramT, "java.util.Collections.singletonList(element)");
    AppMethodBeat.o(129006);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.k
 * JD-Core Version:    0.7.0.1
 */