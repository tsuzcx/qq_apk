package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public enum h
{
  public static final Set<h> NtQ;
  public static final Set<h> NtR;
  public static final a NtS;
  private final boolean NtP;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59800);
    Object localObject1 = new h("VISIBILITY", 0, true);
    NtC = (h)localObject1;
    Object localObject2 = new h("MODALITY", 1, true);
    NtD = (h)localObject2;
    h localh1 = new h("OVERRIDE", 2, true);
    NtE = localh1;
    h localh2 = new h("ANNOTATIONS", 3, false);
    NtF = localh2;
    h localh3 = new h("INNER", 4, true);
    NtG = localh3;
    h localh4 = new h("MEMBER_KIND", 5, true);
    NtH = localh4;
    h localh5 = new h("DATA", 6, true);
    NtI = localh5;
    h localh6 = new h("INLINE", 7, true);
    NtJ = localh6;
    h localh7 = new h("EXPECT", 8, true);
    NtK = localh7;
    h localh8 = new h("ACTUAL", 9, true);
    NtL = localh8;
    h localh9 = new h("CONST", 10, true);
    NtM = localh9;
    h localh10 = new h("LATEINIT", 11, true);
    NtN = localh10;
    NtO = new h[] { localObject1, localObject2, localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8, localh9, localh10 };
    NtS = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localh1 = localObject1[i];
      if (localh1.NtP) {
        ((Collection)localObject2).add(localh1);
      }
      i += 1;
    }
    NtQ = j.n((Iterable)localObject2);
    NtR = e.Y(values());
    AppMethodBeat.o(59800);
  }
  
  private h(boolean paramBoolean)
  {
    this.NtP = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.h
 * JD-Core Version:    0.7.0.1
 */