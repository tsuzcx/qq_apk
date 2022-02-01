package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.p;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class cn
  extends n
  implements bw
{
  public final String getString(String paramString)
  {
    AppMethodBeat.i(118248);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    int i = 1;
    n localn = (n)this;
    paramString = (p)localn.kDZ();
    if (!s.p(paramString, localn))
    {
      int j = i;
      ch localch;
      if ((paramString instanceof ch))
      {
        localch = (ch)paramString;
        if (i == 0) {
          break label104;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localch);
        j = i;
        paramString = paramString.kEa();
        i = j;
        break;
        label104:
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    s.s(paramString, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118248);
    return paramString;
  }
  
  public final boolean isActive()
  {
    return true;
  }
  
  public final cn kCj()
  {
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118249);
    if (au.DEBUG)
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
 * Qualified Name:     kotlinx.coroutines.cn
 * JD-Core Version:    0.7.0.1
 */