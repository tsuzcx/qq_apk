package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public enum h
{
  public static final Set<h> NQW;
  public static final Set<h> NQX;
  public static final a NQY;
  private final boolean NQV;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59800);
    Object localObject1 = new h("VISIBILITY", 0, true);
    NQI = (h)localObject1;
    Object localObject2 = new h("MODALITY", 1, true);
    NQJ = (h)localObject2;
    h localh1 = new h("OVERRIDE", 2, true);
    NQK = localh1;
    h localh2 = new h("ANNOTATIONS", 3, false);
    NQL = localh2;
    h localh3 = new h("INNER", 4, true);
    NQM = localh3;
    h localh4 = new h("MEMBER_KIND", 5, true);
    NQN = localh4;
    h localh5 = new h("DATA", 6, true);
    NQO = localh5;
    h localh6 = new h("INLINE", 7, true);
    NQP = localh6;
    h localh7 = new h("EXPECT", 8, true);
    NQQ = localh7;
    h localh8 = new h("ACTUAL", 9, true);
    NQR = localh8;
    h localh9 = new h("CONST", 10, true);
    NQS = localh9;
    h localh10 = new h("LATEINIT", 11, true);
    NQT = localh10;
    NQU = new h[] { localObject1, localObject2, localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8, localh9, localh10 };
    NQY = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localh1 = localObject1[i];
      if (localh1.NQV) {
        ((Collection)localObject2).add(localh1);
      }
      i += 1;
    }
    NQW = j.n((Iterable)localObject2);
    NQX = e.X(values());
    AppMethodBeat.o(59800);
  }
  
  private h(boolean paramBoolean)
  {
    this.NQV = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.i.h
 * JD-Core Version:    0.7.0.1
 */