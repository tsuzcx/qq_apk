package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.f.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class l$b$d
  extends q
  implements m<List<? extends b>, T, T>
{
  l$b$d(g paramg)
  {
    super(2);
  }
  
  public final <T> T b(List<b> paramList, T paramT)
  {
    AppMethodBeat.i(58084);
    p.h(paramList, "$this$ifPresent");
    p.h(paramT, "qualifier");
    paramList = (Iterable)paramList;
    if ((!(paramList instanceof Collection)) || (!((Collection)paramList).isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        b localb = (b)paramList.next();
        if (this.NhR.g(localb) != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.l.b.d
 * JD-Core Version:    0.7.0.1
 */