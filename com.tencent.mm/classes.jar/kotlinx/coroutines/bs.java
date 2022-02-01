package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;
import kotlinx.coroutines.a.e;
import kotlinx.coroutines.a.g;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
public final class bs
  extends e
  implements be
{
  public final bs fLh()
  {
    return this;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(118248);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    int i = 1;
    e locale = (e)this;
    paramString = locale.fLN();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118248);
      throw paramString;
    }
    paramString = (g)paramString;
    if ((k.g(paramString, locale) ^ true))
    {
      int j = i;
      bm localbm;
      if ((paramString instanceof bm))
      {
        localbm = (bm)paramString;
        if (i == 0) {
          break label129;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localbm);
        j = i;
        paramString = paramString.fLO();
        i = j;
        break;
        label129:
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    k.g(paramString, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118248);
    return paramString;
  }
  
  public final boolean isActive()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118249);
    if (ah.getDEBUG())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bs
 * JD-Core Version:    0.7.0.1
 */