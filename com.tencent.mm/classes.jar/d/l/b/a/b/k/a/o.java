package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.b;
import java.util.Iterator;
import java.util.List;

public final class o
  implements i
{
  private final ac JUv;
  
  public o(ac paramac)
  {
    AppMethodBeat.i(60311);
    this.JUv = paramac;
    AppMethodBeat.o(60311);
  }
  
  public final h d(a parama)
  {
    AppMethodBeat.i(60310);
    k.h(parama, "classId");
    Object localObject1 = this.JUv;
    Object localObject2 = parama.fGW();
    k.g(localObject2, "classId.packageFqName");
    localObject1 = ((ac)localObject1).f((b)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ab)((Iterator)localObject1).next();
      if ((localObject2 instanceof p))
      {
        localObject2 = ((p)localObject2).fJx().d(parama);
        if (localObject2 != null)
        {
          AppMethodBeat.o(60310);
          return localObject2;
        }
      }
    }
    AppMethodBeat.o(60310);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.o
 * JD-Core Version:    0.7.0.1
 */