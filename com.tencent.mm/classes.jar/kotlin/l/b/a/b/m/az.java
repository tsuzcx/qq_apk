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
    p.h(paramab, "$this$replace");
    p.h(paramList, "newArguments");
    p.h(paramg, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramab.hKB())) && (paramg == paramab.hzL()))
    {
      AppMethodBeat.o(60843);
      return paramab;
    }
    paramab = paramab.hLF();
    if ((paramab instanceof v))
    {
      paramab = (ab)ac.a(a(((v)paramab).TNV, paramList, paramg), a(((v)paramab).TNW, paramList, paramg));
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
    if ((paramList.isEmpty()) && (paramg == paramaj.hzL()))
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
    paramaj = ac.c(paramg, paramaj.hKE(), paramList, paramaj.hEa());
    AppMethodBeat.o(60844);
    return paramaj;
  }
  
  public static final aj ay(ab paramab)
  {
    AppMethodBeat.i(60846);
    p.h(paramab, "$this$asSimpleType");
    bg localbg = paramab.hLF();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.az
 * JD-Core Version:    0.7.0.1
 */