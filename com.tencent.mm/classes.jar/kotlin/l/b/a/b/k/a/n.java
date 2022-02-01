package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;

public final class n
  implements g
{
  private final ai ajma;
  
  public n(ai paramai)
  {
    AppMethodBeat.i(60311);
    this.ajma = paramai;
    AppMethodBeat.o(60311);
  }
  
  public final f f(b paramb)
  {
    AppMethodBeat.i(60310);
    s.u(paramb, "classId");
    Object localObject1 = this.ajma;
    Object localObject2 = paramb.kxL();
    s.s(localObject2, "classId.packageFqName");
    localObject1 = aj.a((ai)localObject1, (c)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ah)((Iterator)localObject1).next();
      if ((localObject2 instanceof o))
      {
        localObject2 = ((o)localObject2).kzX().f(paramb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */