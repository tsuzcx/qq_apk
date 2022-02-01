package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
public final class b$a<T>
  implements Comparator<T>
{
  public b$a(b[] paramArrayOfb) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(183771);
    b[] arrayOfb = this.SXw;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      int k = a.a((Comparable)localb.invoke(paramT1), (Comparable)localb.invoke(paramT2));
      if (k != 0)
      {
        AppMethodBeat.o(183771);
        return k;
      }
      i += 1;
    }
    AppMethodBeat.o(183771);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.b.b.a
 * JD-Core Version:    0.7.0.1
 */