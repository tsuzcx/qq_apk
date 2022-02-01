package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.e;
import kotlin.l.b.a.b.f.f;

public final class h
  extends d
  implements e
{
  private final Object[] aqm;
  
  public h(f paramf, Object[] paramArrayOfObject)
  {
    super(paramf, (byte)0);
    AppMethodBeat.i(57423);
    this.aqm = paramArrayOfObject;
    AppMethodBeat.o(57423);
  }
  
  public final List<d> kqx()
  {
    AppMethodBeat.i(57422);
    Object localObject1 = this.aqm;
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      s.checkNotNull(localObject2);
      localCollection.add(d.a.a(localObject2, null));
      i += 1;
    }
    localObject1 = (List)localCollection;
    AppMethodBeat.o(57422);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */