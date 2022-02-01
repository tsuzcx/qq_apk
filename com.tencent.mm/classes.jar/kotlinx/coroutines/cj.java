package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.t;
import kotlinx.coroutines.internal.j;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
public final class cj
  extends j
  implements bt
{
  public final String getString(String paramString)
  {
    AppMethodBeat.i(118248);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    int i = 1;
    j localj = (j)this;
    paramString = localj.iSL();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118248);
      throw paramString;
    }
    paramString = (kotlinx.coroutines.internal.l)paramString;
    if ((p.h(paramString, localj) ^ true))
    {
      int j = i;
      cd localcd;
      if ((paramString instanceof cd))
      {
        localcd = (cd)paramString;
        if (i == 0) {
          break label129;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localcd);
        j = i;
        paramString = paramString.iSM();
        i = j;
        break;
        label129:
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    p.j(paramString, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118248);
    return paramString;
  }
  
  public final cj iRt()
  {
    return this;
  }
  
  public final boolean isActive()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118249);
    if (ap.getDEBUG())
    {
      str = getString("Active");
      AppMethodBeat.o(118249);
      return str;
    }
    String str = super.toString();
    AppMethodBeat.o(118249);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cj
 * JD-Core Version:    0.7.0.1
 */