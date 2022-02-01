package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
public final class cf
  extends i
  implements bp
{
  public final String getString(String paramString)
  {
    AppMethodBeat.i(118248);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    int i = 1;
    i locali = (i)this;
    paramString = locali.hNI();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118248);
      throw paramString;
    }
    paramString = (k)paramString;
    if ((p.j(paramString, locali) ^ true))
    {
      int j = i;
      bz localbz;
      if ((paramString instanceof bz))
      {
        localbz = (bz)paramString;
        if (i == 0) {
          break label129;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localbz);
        j = i;
        paramString = paramString.hNJ();
        i = j;
        break;
        label129:
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    p.g(paramString, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118248);
    return paramString;
  }
  
  public final cf hMX()
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
    if (an.getDEBUG())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */