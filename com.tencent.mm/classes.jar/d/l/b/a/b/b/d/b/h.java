package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.e.e;
import d.l.b.a.b.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class h
  extends d
  implements e
{
  private final Object[] amI;
  
  public h(f paramf, Object[] paramArrayOfObject)
  {
    super(paramf);
    AppMethodBeat.i(57423);
    this.amI = paramArrayOfObject;
    AppMethodBeat.o(57423);
  }
  
  public final List<d> fAA()
  {
    AppMethodBeat.i(57422);
    Object localObject1 = this.amI;
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 == null) {
        k.fvU();
      }
      localCollection.add(d.a.a(localObject2, null));
      i += 1;
    }
    localObject1 = (List)localCollection;
    AppMethodBeat.o(57422);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.h
 * JD-Core Version:    0.7.0.1
 */