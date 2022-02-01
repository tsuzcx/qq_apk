package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.f.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class l$b$d
  extends l
  implements m<List<? extends b>, T, T>
{
  l$b$d(g paramg)
  {
    super(2);
  }
  
  public final <T> T a(List<b> paramList, T paramT)
  {
    AppMethodBeat.i(58084);
    k.h(paramList, "$this$ifPresent");
    k.h(paramT, "qualifier");
    paramList = (Iterable)paramList;
    if ((!(paramList instanceof Collection)) || (!((Collection)paramList).isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        b localb = (b)paramList.next();
        if (this.JDB.g(localb) != null)
        {
          i = 1;
          label84:
          if (i == 0) {
            break label104;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label111;
      }
      AppMethodBeat.o(58084);
      return paramT;
      i = 0;
      break label84;
      label104:
      break;
    }
    label111:
    AppMethodBeat.o(58084);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.l.b.d
 * JD-Core Version:    0.7.0.1
 */