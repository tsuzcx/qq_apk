package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.m;
import java.util.List;

public final class az
{
  public static final ab a(ab paramab, List<? extends av> paramList, g paramg)
  {
    AppMethodBeat.i(60843);
    p.h(paramab, "$this$replace");
    p.h(paramList, "newArguments");
    p.h(paramg, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramab.gxy())) && (paramg == paramab.gmj()))
    {
      AppMethodBeat.o(60843);
      return paramab;
    }
    paramab = paramab.gyC();
    if ((paramab instanceof v))
    {
      paramab = (ab)ac.a(a(((v)paramab).NZc, paramList, paramg), a(((v)paramab).NZd, paramList, paramg));
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
    p.h(paramaj, "$this$replace");
    p.h(paramList, "newArguments");
    p.h(paramg, "newAnnotations");
    if ((paramList.isEmpty()) && (paramg == paramaj.gmj()))
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
    paramaj = ac.c(paramg, paramaj.gxB(), paramList, paramaj.gqy());
    AppMethodBeat.o(60844);
    return paramaj;
  }
  
  public static final aj az(ab paramab)
  {
    AppMethodBeat.i(60846);
    p.h(paramab, "$this$asSimpleType");
    bg localbg = paramab.gyC();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.az
 * JD-Core Version:    0.7.0.1
 */