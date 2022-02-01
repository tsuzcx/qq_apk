package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.m;
import java.util.List;

public final class az
{
  public static final ab a(ab paramab, List<? extends av> paramList, g paramg)
  {
    AppMethodBeat.i(60843);
    k.h(paramab, "$this$replace");
    k.h(paramList, "newArguments");
    k.h(paramg, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramab.fIT())) && (paramg == paramab.fxF()))
    {
      AppMethodBeat.o(60843);
      return paramab;
    }
    paramab = paramab.fJW();
    if ((paramab instanceof v))
    {
      paramab = (ab)ac.a(a(((v)paramab).JXH, paramList, paramg), a(((v)paramab).JXI, paramList, paramg));
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
    k.h(paramaj, "$this$replace");
    k.h(paramList, "newArguments");
    k.h(paramg, "newAnnotations");
    if ((paramList.isEmpty()) && (paramg == paramaj.fxF()))
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
    paramaj = ac.c(paramg, paramaj.fIW(), paramList, paramaj.fBT());
    AppMethodBeat.o(60844);
    return paramaj;
  }
  
  public static final aj az(ab paramab)
  {
    AppMethodBeat.i(60846);
    k.h(paramab, "$this$asSimpleType");
    bg localbg = paramab.fJW();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.az
 * JD-Core Version:    0.7.0.1
 */