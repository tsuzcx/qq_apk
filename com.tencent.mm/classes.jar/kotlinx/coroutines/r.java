package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class r
{
  public static final <T> Object dY(Object paramObject)
  {
    AppMethodBeat.i(118471);
    if (p.dc(paramObject))
    {
      AppMethodBeat.o(118471);
      return paramObject;
    }
    paramObject = p.dd(paramObject);
    if (paramObject == null) {
      j.ebi();
    }
    paramObject = new q(paramObject);
    AppMethodBeat.o(118471);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */