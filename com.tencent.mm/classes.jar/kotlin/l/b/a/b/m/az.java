package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.m;

public final class az
{
  public static final ab a(ab paramab, List<? extends av> paramList, g paramg)
  {
    AppMethodBeat.i(60843);
    p.k(paramab, "$this$replace");
    p.k(paramList, "newArguments");
    p.k(paramg, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramab.iOR())) && (paramg == paramab.iDY()))
    {
      AppMethodBeat.o(60843);
      return paramab;
    }
    paramab = paramab.iPX();
    if ((paramab instanceof v))
    {
      paramab = (ab)ac.a(a(((v)paramab).abqv, paramList, paramg), a(((v)paramab).abqw, paramList, paramg));
      AppMethodBeat.o(60843);
      return paramab;
    }
    if ((paramab instanceof aj))
    {
      paramab = (ab)a((aj)paramab, paramList, paramg);
      AppMethodBeat.o(60843);
      return paramab;
    }
    paramab = new m();
    AppMethodBeat.o(60843);
    throw paramab;
  }
  
  private static aj a(aj paramaj, List<? extends av> paramList, g paramg)
  {
    AppMethodBeat.i(60844);
    p.k(paramaj, "$this$replace");
    p.k(paramList, "newArguments");
    p.k(paramg, "newAnnotations");
    if ((paramList.isEmpty()) && (paramg == paramaj.iDY()))
    {
      AppMethodBeat.o(60844);
      return paramaj;
    }
    if (paramList.isEmpty())
    {
      paramaj = paramaj.d(paramg);
      AppMethodBeat.o(60844);
      return paramaj;
    }
    paramaj = ac.c(paramg, paramaj.iOU(), paramList, paramaj.iIu());
    AppMethodBeat.o(60844);
    return paramaj;
  }
  
  public static final aj ay(ab paramab)
  {
    AppMethodBeat.i(60846);
    p.k(paramab, "$this$asSimpleType");
    bg localbg = paramab.iPX();
    Object localObject = localbg;
    if (!(localbg instanceof aj)) {
      localObject = null;
    }
    localObject = (aj)localObject;
    if (localObject == null)
    {
      paramab = (Throwable)new IllegalStateException("This is should be simple type: ".concat(String.valueOf(paramab)).toString());
      AppMethodBeat.o(60846);
      throw paramab;
    }
    AppMethodBeat.o(60846);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.az
 * JD-Core Version:    0.7.0.1
 */